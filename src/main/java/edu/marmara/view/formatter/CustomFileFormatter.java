package edu.marmara.view.formatter;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class CustomFileFormatter extends SimpleFormatter {
    @Override
    public String format(LogRecord record) {
        // Customize the log message format
        return record.getLevel() + " " + record.getMessage();
    }
}