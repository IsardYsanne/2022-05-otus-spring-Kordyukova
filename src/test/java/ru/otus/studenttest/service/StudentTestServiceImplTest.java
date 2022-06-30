package ru.otus.studenttest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@PropertySource("classpath:application.yml")
public class StudentTestServiceImplTest {

    @Value("${resource.path-en}")
    private String pathEn;

    @Value("${resource.path-ru}")
    private String pathRu;

    private MessageSource messageSource;

    @Test
    public void findTest() {
        assertNotNull(pathEn);
        assertNotNull(pathRu);
        MessageSourceService messageService = new MessageSourceServiceImpl(messageSource, pathEn, pathRu);
        assertNotNull(messageService.getResourceName());
    }
}