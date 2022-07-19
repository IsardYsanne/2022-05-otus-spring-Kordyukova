package ru.otus.studenttest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.studenttest.service.MessageSourceService;
import ru.otus.studenttest.service.StudentTestService;

import java.util.Locale;

/**
 * Содержит набор команд, позволяющий проводить тест.
 */
@ShellComponent
public class StudentTestCLI {

    private static final Logger logger = LoggerFactory.getLogger(StudentTestCLI.class);

    private final MessageSourceService messageSourceService;

    private final StudentTestService studentTestService;

    public StudentTestCLI(MessageSourceService messageSourceService, StudentTestService studentTestService) {
        this.messageSourceService = messageSourceService;
        this.studentTestService = studentTestService;
    }

    /**
     * Проводит тестирование.
     */
    @ShellMethod(value = "Let's test the student", key = {"start", "hello"})
    public void testTheStudent() {
        studentTestService.findTest();
    }

    /**
     * Определеяет локаль, на каком языке проводить тестирование.
     *
     * @param locale команда
     */
    @ShellMethod(value = "Define locale - English or Russian", key = {"language", "lang", "locale"})
    public void defineLocale(@ShellOption(defaultValue = "en") String locale) {
        switch (locale) {
            case "en":
                messageSourceService.setLocale(Locale.ENGLISH);
                break;
            case "ru":
                messageSourceService.setLocale(new Locale("ru"));
                break;
            default:
                logger.info("You can choose only Russian or English languages");
        }
    }
}
