package ru.otus.studenttest.repository;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import ru.otus.studenttest.model.entity.StudentTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StudentTestRepositoryImpl implements StudentTestRepository {

    private final StudentTest studentTest;

    public StudentTestRepositoryImpl(StudentTest studentTest) {
        this.studentTest = studentTest;
    }

    @Override
    public void findTest() throws Exception {
        String resourceName = studentTest.getResourceName();
        try {
            PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
            Resource[] resources = scanner.getResources(resourceName);

            if (resources.length == 0)
                System.out.println("Warning: could not find any resources in this scanned package: " + resourceName);
            else {
                for (Resource resource : resources) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            throw new Exception("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}
