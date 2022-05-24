package ru.otus.studenttest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.studenttest.service.StudentTestServiceImpl;

public class StudentTestApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        StudentTestServiceImpl testService = context.getBean("testServiceImpl", StudentTestServiceImpl.class);
        testService.getTest();
        context.close();
    }
}
