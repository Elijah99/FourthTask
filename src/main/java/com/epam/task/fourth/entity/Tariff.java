package com.epam.task.fourth.entity;

import java.util.Objects;

public class Tariff {
    private int id;
    private String name;
    private String operatorName;
    private float payroll;
    private CallPrices callPrices;
    private float smsPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public float getPayroll() {
        return payroll;
    }

    public void setPayroll(float payroll) {
        this.payroll = payroll;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    public float getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(float smsPrice) {
        this.smsPrice = smsPrice;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", callPrices=" + callPrices +
                ", smsPrice=" + smsPrice +
                '}';
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
        return Float.compare(tariff.payroll, payroll) == 0 &&
                Float.compare(tariff.smsPrice, smsPrice) == 0 &&
                name.equals(tariff.name) &&
                operatorName.equals(tariff.operatorName) &&
                callPrices.equals(tariff.callPrices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, operatorName, payroll, callPrices, smsPrice);
    }
}
