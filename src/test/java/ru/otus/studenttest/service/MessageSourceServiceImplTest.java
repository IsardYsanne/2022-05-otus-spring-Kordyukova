package ru.otus.studenttest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false"})
@PropertySource("classpath:application.yml")
public class MessageSourceServiceImplTest {

    private String pathEn;

    private String pathRu;

    private MessageSource messageSource;

    public MessageSourceServiceImplTest(@Value("${resource.path-en}")String pathEn,
                                        @Value("${resource.path-ru}")String pathRu) {
        this.pathEn = pathEn;
        this.pathRu = pathRu;
    }

    @Test
    public void getResourceName() {
        assertNotNull(pathEn);
        assertNotNull(pathRu);
        MessageSourceService messageService = new MessageSourceServiceImpl(messageSource, pathEn, pathRu);
        assertNotNull(messageService.getResourceName());
    }
}