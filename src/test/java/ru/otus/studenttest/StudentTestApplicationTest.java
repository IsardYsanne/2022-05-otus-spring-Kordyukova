package ru.otus.studenttest;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.studenttest.service.StudentTestService;

import static org.junit.Assert.assertNotNull;

public class StudentTestApplicationTest {

    @Test
    public void main() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentTestApplication.class);
        StudentTestService service = context.getBean(StudentTestService.class);
        assertNotNull(service);
    }
}