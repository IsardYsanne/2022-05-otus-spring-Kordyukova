package ru.otus.studenttest.model.entity;

/**
 * Сущность "Тестирования".
 */
public class StudentTest {

    /**
     * Название ресурса
     */
    private String resourceName;

    /**
     * Порог для прохождения теста
     */
    private int goodAnswersNumber;

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
}
