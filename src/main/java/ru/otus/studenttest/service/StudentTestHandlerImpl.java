package ru.otus.studenttest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.otus.studenttest.model.entity.StudentTest;

import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

/**
 * Основная логика обработки Тестирования.
 */
@Component
@PropertySource("classpath:application.yml")
public class StudentTestHandlerImpl implements StudentTestHandler {

    /**
     * Считыватель символов
     */
    private BufferedReader bufferedReader;

    /**
     * Парсер ресурса
     */
    private final StudentTestParser studentTestParser;

    /**
     * Сервис для MessageSource
     */
    private final MessageSourceService messageService;

    /**
     * Порог для прохождения теста
     */
    private final int correctAnswersNumberForPassExam;

    public StudentTestHandlerImpl(StudentTestParser studentTestParser,
                                  MessageSourceService messageService,
                                  @Value("${correct-answers-number-for-pass-exam}") int correctAnswersNumberForPassExam) {
        this.studentTestParser = studentTestParser;
        this.messageService = messageService;
        this.correctAnswersNumberForPassExam = correctAnswersNumberForPassExam;
    }

    /**
     * Приветствует студента.
     */
    @Override
    public void printGreetingWithStudent() {
        try {
            messageService.printMessage(messageService.getMessage("write.your.name", new Object[]{}));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String studentName = bufferedReader.readLine();
            messageService.printMessage(messageService.getMessage("greeting", new Object[]{}) + studentName
                    + " " + System.lineSeparator() + messageService.getMessage("answer.the.questions", new Object[]{}));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Задает вопросы студенту и проверяет на правильность его ответы.
     */
    @Override
    public void testHandle(Resource[] resources) {
        printGreetingWithStudent();
        Map<String, String> tests = studentTestParser.parseResourceContent(resources);
        Set<String> questions = tests.keySet();
        int testSize = tests.size();
        int counterGoodAnswers = 0;
        for (String question : questions) {
            messageService.printMessage(messageService.getMessage("introduction", new Object[]{}));
            String answer = getResponseFromStudent(question);
            if (tests.get(question).equals(answer)) {
                counterGoodAnswers++;
            }
        }
        StudentTest studentTest = new StudentTest();
        studentTest.setGoodAnswersNumber(counterGoodAnswers);
        getResult(counterGoodAnswers, testSize);
    }

    /**
     * Получает ответ от студента.
     *
     * @param question заданный вопрос
     * @return ответ студента
     */
    @Override
    public String getResponseFromStudent(String question) {
        String answer = "";
        if (bufferedReader == null) {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        try {
            System.out.println(question);
            answer = bufferedReader.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return answer;
    }

    /**
     * Выводит результат тестирования.
     *
     * @param counterGoodAnswers количество правильных ответов
     */
    @Override
    public void getResult(int counterGoodAnswers, int studentTestSize) {

        if (counterGoodAnswers == studentTestSize) {
            messageService.printMessage(messageService.getMessage("the.best.result", new Object[]{}));
        } else if (counterGoodAnswers >= correctAnswersNumberForPassExam) {
            messageService.printMessage(messageService.getMessage("good.result", new Object[]{}));
        } else {
            messageService.printMessage(messageService.getMessage("bad.result", new Object[]{}));
        }

        messageService.printMessage(messageService.getMessage("correct.answers.number", new Object[]{counterGoodAnswers}) +
                counterGoodAnswers + "/" + studentTestSize);
    }

    /**
     * Закрывает поток.
     */
    @PreDestroy
    @Override
    public void closeReader() {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}