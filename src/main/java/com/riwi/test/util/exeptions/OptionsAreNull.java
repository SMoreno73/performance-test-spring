package com.riwi.test.util.exeptions;

public class OptionsAreNull extends RuntimeException{
    private static final String ERROR_MESSAGE = "Options are null, change the question type or write the options ";

    public OptionsAreNull() {
        super(String.format(ERROR_MESSAGE));
    }
}
