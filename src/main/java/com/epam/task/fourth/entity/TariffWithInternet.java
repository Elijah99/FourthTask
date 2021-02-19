package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TariffWithInternet", propOrder = {
        "trafficInMegabyte",
        "priceForOneMegabyte",
        "isModemModeEnabled"
})
public class TariffWithInternet
        extends Tariff {

    @XmlElement(name = "traffic-in-megabyte")
    protected float trafficInMegabyte;
    @XmlElement(name = "price-for-one-megabyte")
    protected float priceForOneMegabyte;
    @XmlElement(name = "is-modem-mode-enabled")
    protected boolean isModemModeEnabled;

    public TariffWithInternet(int id, String name, String operatorName, float payroll, float smsPrice, CallPrices callPrices, float trafficInMegabyte, float priceForOneMegabyte, boolean isModemModeEnabled) {
        super(id, name, operatorName, payroll, smsPrice, callPrices);
        this.trafficInMegabyte = trafficInMegabyte;
        this.priceForOneMegabyte = priceForOneMegabyte;
        this.isModemModeEnabled = isModemModeEnabled;
    }

    public TariffWithInternet(float trafficInMegabyte, float priceForOneMegabyte, boolean isModemModeEnabled) {
        this.trafficInMegabyte = trafficInMegabyte;
        this.priceForOneMegabyte = priceForOneMegabyte;
        this.isModemModeEnabled = isModemModeEnabled;
    }

    public TariffWithInternet() {
    }

    public float getTrafficInMegabyte() {
        return trafficInMegabyte;
    }

    public void setTrafficInMegabyte(float value) {
        this.trafficInMegabyte = value;
    }

    public float getPriceForOneMegabyte() {
        return priceForOneMegabyte;
    }

    public void setPriceForOneMegabyte(float value) {
        this.priceForOneMegabyte = value;
    }

    public boolean isIsModemModeEnabled() {
        return isModemModeEnabled;
    }

    public void setIsModemModeEnabled(boolean value) {
        this.isModemModeEnabled = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TariffWithInternet)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TariffWithInternet that = (TariffWithInternet) o;
        return Float.compare(that.trafficInMegabyte, trafficInMegabyte) == 0 &&
                Float.compare(that.priceForOneMegabyte, priceForOneMegabyte) == 0 &&
                isModemModeEnabled == that.isModemModeEnabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trafficInMegabyte, priceForOneMegabyte, isModemModeEnabled);
    }

    @Override
    public String toString() {
        return "TariffWithInternet{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", smsPrice=" + smsPrice +
                ", callPrices=" + callPrices +
                ", trafficInMegabyte=" + trafficInMegabyte +
                ", priceForOneMegabyte=" + priceForOneMegabyte +
                ", isModemModeEnabled=" + isModemModeEnabled +
                '}';
    }
}
