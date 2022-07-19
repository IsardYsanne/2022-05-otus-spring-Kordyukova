package ru.otus.studenttest.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.AbsoluteWidthSizeConstraints;
import org.springframework.shell.table.SimpleHorizontalAligner;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModelBuilder;
import ru.otus.studenttest.model.entity.StudentTest;
import ru.otus.studenttest.service.MessageSourceService;
import ru.otus.studenttest.service.StudentTestHandler;

import java.util.List;

import static org.springframework.shell.table.CellMatchers.column;

/**
 * Содержит метод для обработки результата тестирования.
 */
@ShellComponent
public class ResultHandlerCLI {

    private final StudentTestHandler studentTestHandler;

    private final MessageSourceService messageService;

    public ResultHandlerCLI(StudentTestHandler studentTestHandler, MessageSourceService messageService) {
        this.studentTestHandler = studentTestHandler;
        this.messageService = messageService;
    }

    /**
     * Выводит вопросы и набранные баллы за каждый вопрос, а также дату тестирования.
     *
     * @return результаты в виде строки.
     */
    @ShellMethod(value = "Show test result", key = {"show", "results", "get-results"})
    public String showResult() {
        TableModelBuilder<String> modelBuilder = new TableModelBuilder<>();
        List<StudentTest> results = studentTestHandler.getResults();
        if (results.size() == 0) {
            messageService.printMessage(messageService.getMessage("no.result.to.show", new Object[]{}));
            return null;
        }
        buildResultsTable(modelBuilder, results);

        String table = new TableBuilder(modelBuilder.build())
                .on(column(0)).addSizer(new AbsoluteWidthSizeConstraints(70)).addAligner(SimpleHorizontalAligner.left)
                .on(column(1)).addSizer(new AbsoluteWidthSizeConstraints(70)).addAligner(SimpleHorizontalAligner.left)
                .build()
                .render(500);

        return table;
    }

    /**
     * Построить таблицу результатов.
     *
     * @param modelBuilder билдер
     * @param results результаты теста
     */
    public void buildResultsTable(TableModelBuilder<String> modelBuilder, List<StudentTest> results) {
        for (StudentTest result : results) {
            modelBuilder
                    .addRow()
                    .addValue(messageService.getMessage("name.student", new Object[]{}))
                    .addValue(result.getNameOfStudent())
                    .addRow()
                    .addValue(messageService.getMessage("question", new Object[]{}))
                    .addValue(messageService.getMessage("mark", new Object[]{}));

            result.getResults().forEach((question, mark) -> {
                modelBuilder
                        .addRow()
                        .addValue(question)
                        .addValue(mark);
            });

            modelBuilder
                    .addRow()
                    .addValue(messageService.getMessage("correct.answers.number", new Object[]{}))
                    .addValue(String.valueOf(result.getGoodAnswersNumber()));
            modelBuilder
                    .addRow()
                    .addValue(messageService.getMessage("test.date", new Object[]{}))
                    .addValue(result.getTestDate().toString());
        }
    }
}
