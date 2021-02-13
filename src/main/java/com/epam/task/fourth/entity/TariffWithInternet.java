package com.epam.task.fourth.entity;

import java.util.Objects;

public class TariffWithInternet extends Tariff {
    private float trafficInMegabyte;
    private float priceForOneMegabyte;
    private boolean isModemModeEnabled;

    public float getTrafficInMegabyte() {
        return trafficInMegabyte;
    }

    public void setTrafficInMegabyte(float trafficInMegabyte) {
        this.trafficInMegabyte = trafficInMegabyte;
    }

    public float getPriceForOneMegabyte() {
        return priceForOneMegabyte;
    }

    public void setPriceForOneMegabyte(float priceForOneMegabyte) {
        this.priceForOneMegabyte = priceForOneMegabyte;
    }

    public boolean isModemModeEnabled() {
        return isModemModeEnabled;
    }

    public void setModemModeEnabled(boolean modemModeEnabled) {
        isModemModeEnabled = modemModeEnabled;
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
                "trafficInMegabyte=" + trafficInMegabyte +
                ", priceForOneMegabyte=" + priceForOneMegabyte +
                ", isModemModeEnabled=" + isModemModeEnabled +
                '}';
    }
}
