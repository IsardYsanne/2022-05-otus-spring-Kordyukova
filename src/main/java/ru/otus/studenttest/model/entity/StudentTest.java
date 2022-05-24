package ru.otus.studenttest.model.entity;

public class StudentTest {

    private String resourceName;

    public StudentTest(String resourceName) {
        this.resourceName = resourceName;
    }

    public StudentTest() {
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
