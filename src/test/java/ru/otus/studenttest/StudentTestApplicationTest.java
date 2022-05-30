package ru.otus.studenttest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.studenttest.service.StudentTestServiceImpl;

import static org.junit.Assert.assertNotNull;

public class StudentTestApplicationTest {

    @Test
    public void main() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        StudentTestServiceImpl testService = context.getBean("testServiceImpl", StudentTestServiceImpl.class);
        assertNotNull(testService);
    }
}