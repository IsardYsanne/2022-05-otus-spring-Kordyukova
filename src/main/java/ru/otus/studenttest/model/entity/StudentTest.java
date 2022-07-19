package ru.otus.studenttest.model.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Сущность "Тестирования".
 */
public class StudentTest {

    /**
     * Порог для прохождения теста
     */
    private int goodAnswersNumber;

    /**
     * Название ресурса
     */
    private String resourceName;

    /**
     * Имя студента
     */
    private String nameOfStudent;

    /**
     * Дата тестирования
     */
    private LocalDate testDate;

    /**
     * Содержит вопросы и баллы за каждый из них
     */
    private Map<String, String> results = new HashMap<>();

    public StudentTest() {
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getGoodAnswersNumber() {
        return goodAnswersNumber;
    }

    public void setGoodAnswersNumber(int goodAnswersNumber) {
        this.goodAnswersNumber = goodAnswersNumber;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }
}
