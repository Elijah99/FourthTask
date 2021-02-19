package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Tariff;
import com.epam.task.fourth.entity.Tariffs;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;

public class JaxbParser implements Parser<Tariff> {
    private final static String PARSING_EXCEPTION_MESSAGE = "Parsing exception";

    @Override
    public List<Tariff> parse(String filename) throws ParserException {
        Tariffs tariffs = new Tariffs();
        try {
            JAXBContext context = JAXBContext.newInstance(Tariffs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(filename);
            String schemaName = "src/test/resources/tariffs.xsd";
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(schemaName));
            unmarshaller.setSchema(schema);

            tariffs = (Tariffs) unmarshaller.unmarshal(file);

        } catch (SAXException | JAXBException e) {
            throw new ParserException(PARSING_EXCEPTION_MESSAGE, e);
        }
        return tariffs.getAllTariff();
    }
}
