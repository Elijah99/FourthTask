package com.epam.task.fourth.parser;

public class ParserFactory {
    public Parser getParser(ParserType type) {
        switch (type) {
            case DOM: {
                return new DomParser();
            }
            case SAX: {
                return new SaxParser();
            }
            case JAXB: {
                return new JaxbParser();
            }
            default: {
                return null;
            }
        }
    }
}
