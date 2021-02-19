package com.epam.task.fourth.parser;

import java.util.List;

public interface Parser<T> {
    public List<T> parse(String filename) throws ParserException;
}