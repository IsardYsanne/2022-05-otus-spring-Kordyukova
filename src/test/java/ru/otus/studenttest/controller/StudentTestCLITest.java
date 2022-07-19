package ru.otus.studenttest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.studenttest.service.MessageSourceServiceImpl;
import ru.otus.studenttest.service.StudentTestHandler;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(locations = "classpath:test.properties")
public class StudentTestCLITest {

    @MockBean
    private StudentTestHandler studentTestHandler;

    @Autowired
    private MessageSourceServiceImpl messageSourceService;

    @Autowired
    private Shell shell;

    @Test
    public void showNoResult() {
        shell.evaluate(() -> "show");
        studentTestHandler.closeReader();

        verify(studentTestHandler).closeReader();
    }

    @Test
    public void checkAnswersRus() {
        when(studentTestHandler.getResponseFromStudent(anyString()))
                .thenReturn("Вася")
                .thenReturn("1932")
                .thenReturn("1924")
                .thenReturn("Александр II")
                .thenReturn("1962")
                .thenReturn("Холодная война");

        messageSourceService.setLocale(new Locale("ru"));

        shell.evaluate(() -> "start");
        studentTestHandler.closeReader();

        verify(messageSourceService).printMessage("Вася");
        verify(messageSourceService).printMessage("Количество правильных ответов: ");
    }

    @Test
    public void showAnswersAndGradesRus() {
        when(studentTestHandler.getResponseFromStudent(anyString()))
                .thenReturn("Вася")
                .thenReturn("1932")
                .thenReturn("1924")
                .thenReturn("Александр II")
                .thenReturn("1962")
                .thenReturn("Холодная война");

        messageSourceService.setLocale(new Locale("ru"));

        shell.evaluate(() -> "hello");
        Object result = shell.evaluate(() -> "show");
        studentTestHandler.closeReader();

        String expected = "Имя студента:                                               Вася                                                                  \n" +
                "Вопрос                                                                Количество баллов за вопрос                                           \n" +
                "В каком году произошел Кубинский кризис?                              1                                                                     \n" +
                "В каком году была принята Конституция СССР?                           1                                                                     \n" +
                "Кто подписал реформу об отмене крепостного права в 1861 году?         1                                                                     \n" +
                "В каком году был принят \"Закон о трех колосках\"?                    1                                                                     \n" +
                "Как называлось противостояние СССР и Западных стран?                  1                                                                     \n" +
                "Количество правильных ответов:                                        5                                                                     \n" +
                "Дата тестирования:                                                    2022-07-10";

        assertThat(result.toString()).contains(expected);
    }
}
