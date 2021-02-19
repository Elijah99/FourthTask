package com.epam.task.fourth.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tariff",
        "tariffWithInternet"
})
@XmlRootElement(name = "tariffs")
public class Tariffs {

    @XmlElement(required = true)
    protected List<Tariff> tariff;
    @XmlElement(name = "tariff-with-internet")
    protected List<TariffWithInternet> tariffWithInternet;

    public List<Tariff> getTariff() {
        if (tariff == null) {
            tariff = new ArrayList<Tariff>();
        }
        return this.tariff;
    }

    public List<TariffWithInternet> getTariffWithInternet() {
        if (tariffWithInternet == null) {
            tariffWithInternet = new ArrayList<TariffWithInternet>();
        }
        return this.tariffWithInternet;
    }

    public List<Tariff> getAllTariff() {
        List<Tariff> tariffList = new ArrayList<Tariff>(tariff);
        if (tariffWithInternet != null && !tariffWithInternet.isEmpty()) {
            tariffList.addAll(tariffWithInternet);
        }
        return tariffList;
    }

}
