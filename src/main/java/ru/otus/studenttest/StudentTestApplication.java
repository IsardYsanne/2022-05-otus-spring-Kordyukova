package ru.otus.studenttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.studenttest.service.StudentTestService;

@SpringBootApplication
public class StudentTestApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(StudentTestApplication.class, args);
        StudentTestService service =  applicationContext.getBean(StudentTestService.class);
        service.findTest();
    }
}