package ru.otus.studenttest.service;

import org.springframework.core.io.Resource;

import java.util.Map;

public interface StudentTestParser {

    Map<String,String> parseResourceContent(Resource[] resources);
}
