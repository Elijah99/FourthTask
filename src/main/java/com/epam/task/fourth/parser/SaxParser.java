package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Tariff;
import com.epam.task.fourth.parser.handler.TariffHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements Parser<Tariff> {

    private final static String PARSING_EXCEPTION_MESSAGE = "Parsing exception";

    @Override
    public List<Tariff> parse(String filename) throws ParserException {
        List<Tariff> tariffList = new ArrayList<>();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            TariffHandler handler = new TariffHandler();
            reader.setContentHandler(handler);
            reader.parse(filename);
            tariffList = handler.getTariffList();

        } catch (SAXException | IOException e) {
            throw new ParserException(PARSING_EXCEPTION_MESSAGE, e);
        }

        return tariffList;
    }
}
