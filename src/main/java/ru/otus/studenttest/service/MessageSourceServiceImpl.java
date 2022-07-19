package ru.otus.studenttest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Сервис для интернационализации.
 */
@Service
@PropertySource("classpath:application.yml")
public class MessageSourceServiceImpl implements MessageSourceService {

    private Locale locale;

    private final String pathEn;

    private final String pathRu;

    private final MessageSource messageSource;

    public MessageSourceServiceImpl(MessageSource messageSource,
                                    @Value("${resource.path-en}") String pathEn,
                                    @Value("${resource.path-ru}") String pathRu) {
        this.messageSource = messageSource;
        this.pathEn = pathEn;
        this.pathRu = pathRu;
    }

    /**
     * Печатает сообщение.
     *
     * @param message текст сообщения
     */
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Вернет имя ресурса, язык которого соответствует локали пользователя.
     *
     * @return имя ресурса
     */
    @Override
    public String getResourceName() {
        locale = LocaleContextHolder.getLocale();
        return locale == Locale.ENGLISH ? pathEn : pathRu;
    }

    /**
     * Получает сообщение на необходимом языке.
     *
     * @param code  код сообщения для поиска
     * @param objects массив аргументов, которые будут заполнены для параметров внутри сообщения
     * @return сообщение
     */
    @Override
    public String getMessage(String code, Object[] objects) {
        return messageSource.getMessage(code, objects, locale);
    }

    /**
     * Задать локаль.
     *
     * @param locale локаль пользователя
     */
    @Override
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
