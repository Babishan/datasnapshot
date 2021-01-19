package com.codingtask.datasnapshot.exception;

import java.text.ParseException;

public class LineParseException extends ParseException {
    /**
     * Constructs a ParseException with the specified detail message and
     * offset.
     * A detail message is a String that describes this particular exception.
     *
     * @param s           the detail message
     * @param errorOffset the position where the error is found while parsing.
     */
    public LineParseException(String s) {
        super(s, 0); // errorOffset is 0 as line can not be parsed.
    }
}
