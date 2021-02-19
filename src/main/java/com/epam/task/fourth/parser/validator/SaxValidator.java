package com.epam.task.fourth.parser.validator;


import com.epam.task.fourth.parser.handler.TariffHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class SaxValidator {

    private final static Logger LOGGER = Logger.getLogger(SaxValidator.class);
    private final static String VALIDATION_EXCEPTION_MESSAGE = "Failed to validate xml:";
    private final String filepathXsd;

    public SaxValidator(String filepathXsd) {
        this.filepathXsd = filepathXsd;
    }

    public boolean isValid(String filename) {


        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schema = factory.newSchema(new File(filepathXsd));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);

            return true;
        } catch (SAXException | IOException e) {
            LOGGER.error(VALIDATION_EXCEPTION_MESSAGE, e);
            return false;
        }
    }
}
