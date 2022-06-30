package ru.otus.studenttest.service;

public interface MessageSourceService {

    void printMessage(String message);

    String getResourceName();

    String getMessage(String messageKey, Object[] objects);
}
