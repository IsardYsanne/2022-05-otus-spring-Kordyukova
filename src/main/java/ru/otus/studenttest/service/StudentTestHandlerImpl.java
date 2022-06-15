package ru.otus.studenttest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.otus.studenttest.model.entity.StudentTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

/**
 * Основная логика обработки Тестирования.
 */
@Component
public class StudentTestHandlerImpl implements StudentTestHandler {

    /**
     * Ставится перед каждым вопросом
     */
    public static final String INTRODUCTION = "Enter the answer to the question: ";

    /**
     * Считыватель символов
     */
    private BufferedReader bufferedReader;

    /**
     * Парсер ресурса
     */
    private final StudentTestParser studentTestParser;

    /**
     * Порог для прохождения теста
     */
    @Value("${correctAnswersNumberForPassExam}")
    private int correctAnswersNumberForPassExam;

    public StudentTestHandlerImpl(StudentTestParser studentTestParser) {
        this.studentTestParser = studentTestParser;
    }

    /**
     * Приветствует студента.
     */
    @Override
    public void printGreetingWithStudent() {
        try {
            System.out.println("Hi! Please write your name: ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String studentName = bufferedReader.readLine();
            System.out.println("Hello there! " + studentName + " " + System.lineSeparator() + "Now answer the questions, or I'm not responsible for myself .. Let's go!");
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
            System.out.println(INTRODUCTION);
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
     * Выводит результат тестирования
     *
     * @param counterGoodAnswers количество правильных ответов
     */
    @Override
    public void getResult(int counterGoodAnswers, int studentTestSize) {
        if (counterGoodAnswers == studentTestSize) {
            System.out.println("What did you forget in IT? Go to historian! О_о ");
        } else if (counterGoodAnswers >= correctAnswersNumberForPassExam) {
            System.out.println("What a good guy(girl) you are! ^___^");
        } else {
            System.out.println("Ha-ha-ha, you are prostofilya! :Р ");
        }

        System.out.println("Correct answers " + counterGoodAnswers + "/" + studentTestSize);
    }
}
