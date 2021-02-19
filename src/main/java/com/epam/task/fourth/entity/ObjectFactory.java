package com.epam.task.fourth.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Tariff_QNAME = new QName("http://www.example.com/tariffs", "tariff");
    private final static QName _TariffWithInternet_QNAME = new QName("http://www.example.com/tariffs", "tariff-with-internet");

    public ObjectFactory() {
    }

    public Tariff createTariff() {
        return new Tariff();
    }

    public TariffWithInternet createTariffWithInternet() {
        return new TariffWithInternet();
    }

    public Tariffs createTariffs() {
        return new Tariffs();
    }

    public CallPrices createCallPrices() {
        return new CallPrices();
    }

    @XmlElementDecl(namespace = "http://www.example.com/tariffs", name = "tariff")
    public JAXBElement<Tariff> createTariff(Tariff value) {
        return new JAXBElement<Tariff>(_Tariff_QNAME, Tariff.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/tariffs", name = "tariff-with-internet", substitutionHeadNamespace = "http://www.example.com/tariffs", substitutionHeadName = "tariff")
    public JAXBElement<TariffWithInternet> createTariffWithInternet(TariffWithInternet value) {
        return new JAXBElement<TariffWithInternet>(_TariffWithInternet_QNAME, TariffWithInternet.class, null, value);
    }

}
