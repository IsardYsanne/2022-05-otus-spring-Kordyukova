package ru.otus.studenttest.service;

import java.util.Locale;

public interface MessageSourceService {

    void printMessage(String message);

    String getResourceName();

    String getMessage(String messageKey, Object[] objects);

    void setLocale(Locale locale);
}
