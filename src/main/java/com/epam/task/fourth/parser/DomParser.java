package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.CallPrices;
import com.epam.task.fourth.entity.Tariff;
import com.epam.task.fourth.entity.TariffWithInternet;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser<Tariff> {

    private final static String PARSING_EXCEPTION_MESSAGE = "Parsing exception";

    @Override
    public List<Tariff> parse(String filename) throws ParserException {
        List<Tariff> resultTariffList = new ArrayList<Tariff>();
        Document document;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(filename);

            Element root = document.getDocumentElement();
            List<Tariff> tariffsList = process(root, TariffTagEnum.TARIFF);
            List<Tariff> tariffsWithInternetList = process(root, TariffTagEnum.TARIFFWITHINTERNET);

            resultTariffList.addAll(tariffsList);
            resultTariffList.addAll(tariffsWithInternetList);

        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new ParserException(PARSING_EXCEPTION_MESSAGE, e);
        }
        return resultTariffList;
    }

    private List<Tariff> process(Element root, TariffTagEnum elementTag) {
        List<Tariff> resultTariffList = new ArrayList<Tariff>();

        NodeList tariffsList = root.getElementsByTagName(elementTag.getValue());
        for (int i = 0; i < tariffsList.getLength(); i++) {
            Element tariffElement = (Element) tariffsList.item(i);
            Tariff tariff = buildTariff(tariffElement, elementTag);
            resultTariffList.add(tariff);
        }
        return resultTariffList;
    }

    private Tariff buildTariff(Element tariffAttributes, TariffTagEnum elementTag) {
        Tariff tariff;
        if (elementTag == TariffTagEnum.TARIFF) {
            tariff = new Tariff();
        } else {
            tariff = new TariffWithInternet();
        }

        int id = Integer.parseInt(getElementTextContent(tariffAttributes, TariffTagEnum.ID.getValue()));
        tariff.setId(id);

        String name = getElementTextContent(tariffAttributes, TariffTagEnum.NAME.getValue());
        tariff.setName(name);

        float smsPrice = Float.parseFloat(getElementTextContent(tariffAttributes, TariffTagEnum.SMSPRICE.getValue()));
        tariff.setSmsPrice(smsPrice);

        String operatorName = getElementTextContent(tariffAttributes, TariffTagEnum.OPERATORNAME.getValue());
        tariff.setOperatorName(operatorName);

        float payroll = Float.parseFloat(getElementTextContent(tariffAttributes, TariffTagEnum.PAYROLL.getValue()));
        tariff.setPayroll(payroll);

        Element callPricesElement = (Element) tariffAttributes.getElementsByTagName(TariffTagEnum.CALLPRICES.getValue()).item(0);
        CallPrices callPrices = buildCallPrices(callPricesElement);

        tariff.setCallPrices(callPrices);

        if (elementTag == TariffTagEnum.TARIFFWITHINTERNET) {

            float trafficInMegabyte = Float.parseFloat(getElementTextContent(tariffAttributes, TariffTagEnum.TRAFFICINMEGABYTES.getValue()));
            ((TariffWithInternet) tariff).setTrafficInMegabyte(trafficInMegabyte);

            float priceForOneMegabyte = Float.parseFloat(getElementTextContent(tariffAttributes, TariffTagEnum.PRICEFORONEMEGABYTE.getValue()));
            ((TariffWithInternet) tariff).setPriceForOneMegabyte(priceForOneMegabyte);

            boolean isModemModeEnabled = Boolean.parseBoolean(getElementTextContent(tariffAttributes, TariffTagEnum.ISMODEMMODEENABLED.getValue()));
            ((TariffWithInternet) tariff).setIsModemModeEnabled(isModemModeEnabled);
        }

        return tariff;
    }

    private CallPrices buildCallPrices(Element attributes) {
        CallPrices callPrices = new CallPrices();

        float sameOperator = Float.parseFloat(getElementTextContent(attributes, TariffTagEnum.SAMEOPERATOR.getValue()));
        callPrices.setSameOperator(sameOperator);

        float anotherOperator = Float.parseFloat(getElementTextContent(attributes, TariffTagEnum.ANOTHEROPERATOR.getValue()));
        callPrices.setAnotherOperator(anotherOperator);

        float landlinePhones = Float.parseFloat(getElementTextContent(attributes, TariffTagEnum.LANDLINEPHONES.getValue()));
        callPrices.setLandlinePhones(landlinePhones);

        return callPrices;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

}

