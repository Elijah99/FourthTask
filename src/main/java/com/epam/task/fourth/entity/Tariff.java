package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tariff", propOrder = {
        "id",
        "name",
        "operatorName",
        "payroll",
        "smsPrice",
        "callPrices"
})
@XmlSeeAlso({
        TariffWithInternet.class
})
public class Tariff {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "operator-name", required = true)
    protected String operatorName;
    protected float payroll;
    @XmlElement(name = "sms-price")
    protected float smsPrice;
    @XmlElement(name = "call-prices", required = true)
    protected CallPrices callPrices;

    public Tariff(int id, String name, String operatorName, float payroll, float smsPrice, CallPrices callPrices) {
        this.id = id;
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.smsPrice = smsPrice;
        this.callPrices = callPrices;
    }

    public Tariff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    public float getPayroll() {
        return payroll;
    }

    public void setPayroll(float value) {
        this.payroll = value;
    }

    public float getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(float value) {
        this.smsPrice = value;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices value) {
        this.callPrices = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tariff)) {
            return false;
        }
        Tariff tariff = (Tariff) o;
        return id == tariff.id &&
                Float.compare(tariff.payroll, payroll) == 0 &&
                Float.compare(tariff.smsPrice, smsPrice) == 0 &&
                Objects.equals(name, tariff.name) &&
                Objects.equals(operatorName, tariff.operatorName) &&
                Objects.equals(callPrices, tariff.callPrices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, operatorName, payroll, smsPrice, callPrices);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", smsPrice=" + smsPrice +
                ", callPrices=" + callPrices +
                '}';
    }
}
