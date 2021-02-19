package com.epam.task.fourth.parser.handler;

import com.epam.task.fourth.entity.CallPrices;
import com.epam.task.fourth.entity.Tariff;
import com.epam.task.fourth.entity.TariffWithInternet;
import com.epam.task.fourth.parser.TariffTagEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TariffHandler extends DefaultHandler {

    private List<Tariff> tariffList;

    private Tariff currentTariff = new Tariff();

    private TariffTagEnum currentTag = null;


    public TariffHandler() {
        tariffList = new ArrayList<Tariff>();
    }

    public List<Tariff> getTariffList() {
        return tariffList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        TariffTagEnum currentEnum = TariffTagEnum.getEnumByValue(localName);
        if (currentEnum != null)
            switch (currentEnum) {
                case TARIFF: {
                    currentTariff = new Tariff();
                }
                break;
                case TARIFFWITHINTERNET: {
                    currentTariff = new TariffWithInternet();
                }
                break;
                default: {
                    currentTag = TariffTagEnum.getEnumByValue(localName);
                }
            }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String tagTariff = TariffTagEnum.TARIFF.getValue();
        String tagTariffWithInternet = TariffTagEnum.TARIFFWITHINTERNET.getValue();
        if (tagTariff.equals(localName) || tagTariffWithInternet.equals(localName)) {
            tariffList.add(currentTariff);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementString = new String(ch, start, length).trim();
        CallPrices currentCallPrices = currentTariff.getCallPrices();
        if (currentTag != null) {
            switch (currentTag) {
                case ID: {
                    currentTariff.setId(Integer.parseInt(elementString));
                }
                break;
                case NAME: {
                    currentTariff.setName(elementString);
                }
                break;
                case OPERATORNAME: {
                    currentTariff.setOperatorName(elementString);
                }
                break;
                case PAYROLL: {
                    currentTariff.setPayroll(Float.parseFloat(elementString));
                }
                break;
                case CALLPRICES: {
                    currentCallPrices = new CallPrices();
                    currentTariff.setCallPrices(currentCallPrices);
                }
                break;
                case SAMEOPERATOR: {
                    currentCallPrices.setSameOperator(Float.parseFloat(elementString));
                }
                break;
                case ANOTHEROPERATOR: {
                    currentCallPrices.setAnotherOperator(Float.parseFloat(elementString));
                }
                break;
                case LANDLINEPHONES: {
                    currentCallPrices.setLandlinePhones(Float.parseFloat(elementString));
                }
                break;
                case SMSPRICE: {
                    currentTariff.setSmsPrice(Float.parseFloat(elementString));
                }
                break;
                case TRAFFICINMEGABYTES: {
                    TariffWithInternet tariffWithInternet = (TariffWithInternet) currentTariff;
                    tariffWithInternet.setTrafficInMegabyte(Float.parseFloat(elementString));
                    currentTariff = tariffWithInternet;
                }
                break;
                case PRICEFORONEMEGABYTE: {
                    TariffWithInternet tariffWithInternet = (TariffWithInternet) currentTariff;
                    tariffWithInternet.setPriceForOneMegabyte(Float.parseFloat(elementString));
                    currentTariff = tariffWithInternet;
                }
                break;
                case ISMODEMMODEENABLED: {
                    TariffWithInternet tariffWithInternet = (TariffWithInternet) currentTariff;
                    tariffWithInternet.setIsModemModeEnabled(Boolean.parseBoolean(elementString));
                    currentTariff = tariffWithInternet;
                }
                break;
            }
        }
        currentTag = null;
    }
}
