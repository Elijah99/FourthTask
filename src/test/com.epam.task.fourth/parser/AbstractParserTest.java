package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.CallPrices;
import com.epam.task.fourth.entity.Tariff;
import com.epam.task.fourth.entity.TariffWithInternet;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParserTest {

    private final Parser parser;

    public static final String FILENAME_TARIFF_ONLY_VALID = "src/test/resources/tariffs.xml";
    public static final String FILENAME_EMPTY = "src/test/resources/tariffs_empty.xml";
    public static final String FILENAME_INVALID_DATA = "src/test/resources/tariffs_invalid_data.xml";
    public static final String FILENAME_VALID_DATA = "src/test/resources/tariffs_valid_data.xml";

    public static final List<Tariff> LIST_TARIFFS_XML_FILE_EXPECTED = Arrays.asList(
            new Tariff(1, "name", "operator",
                    3.15f, 0.22f, new CallPrices(1.22f, 3.22f, 5.22f)));
    public static final List<Tariff> LIST_TARIFFS_VALID_DATA_FILE_EXPECTED = Arrays.asList(
            new Tariff(0, "name", "operator",
                    0f, 0f, new CallPrices(0f, 0f, 0f)),
            new Tariff(1, "name1", "operator1",
                    1.11f, 1.11f, new CallPrices(1.11f, 1f, 1f)),
            new Tariff(2, "name2", "operator2",
                    2.22f, 2.22f, new CallPrices(2.22f, 2.22f, 2.22f)),
            new TariffWithInternet(3, "name3", "operator3",
                    3.33f, 3.33f, new CallPrices(3.33f, 3.33f, 3.33f),
                    333f, 3f, true),
            new TariffWithInternet(4, "name4", "operator4",
                    4.44f, 4f, new CallPrices(4f, 4.44f, 4.44f),
                    444.4f, 44.4f, false)
    );


    public AbstractParserTest(ParserType parserType) {
        ParserFactory parserFactory = new ParserFactory();
        this.parser = parserFactory.getParser(parserType);
    }

    @Test
    public void testParseShouldReturnExpectedListWhenInputFileHasTariffOnly() throws ParserException {
        //given
        //when
        List<Tariff> actual = parser.parse(FILENAME_TARIFF_ONLY_VALID);

        //then
        Assert.assertEquals(LIST_TARIFFS_XML_FILE_EXPECTED, actual);
    }

    @Test(expected = ParserException.class)
    public void testParseShouldThrowParserExceptionWhenInputFileEmpty() throws ParserException {
        //given
        //when
        List<Tariff> actual = parser.parse(FILENAME_EMPTY);
        //then
    }

    @Test(expected = ParserException.class)
    public void testParseShouldThrowParserExceptionWhenDataInFileInvalid() throws ParserException {
        //given
        //when
        List<Tariff> actual = parser.parse(FILENAME_INVALID_DATA);
        //then
    }

    @Test
    public void testParseShouldReturnExpectedListWhenDataInFileValid() throws ParserException {
        List<Tariff> actual = parser.parse(FILENAME_VALID_DATA);

        Assert.assertEquals(LIST_TARIFFS_VALID_DATA_FILE_EXPECTED, actual);
    }

}
