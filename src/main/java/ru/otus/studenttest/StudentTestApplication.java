package ru.otus.studenttest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.studenttest.service.StudentTestService;

/**
 * Основной класс приложения. Сканирует классы, создает их экземпляры и кладет в контекст.
 *
 * @author Kordyukova
 */
@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan
public class StudentTestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentTestApplication.class);
        StudentTestService service = context.getBean(StudentTestService.class);
        service.getTest();
    }
}
