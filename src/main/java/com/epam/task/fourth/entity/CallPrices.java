package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallPrices", propOrder = {
        "sameOperator",
        "anotherOperator",
        "landlinePhones"
})
public class CallPrices {

    @XmlElement(name = "same-operator")
    protected float sameOperator;
    @XmlElement(name = "another-operator")
    protected float anotherOperator;
    @XmlElement(name = "landline-phones")
    protected float landlinePhones;

    public CallPrices(float sameOperator, float anotherOperator, float landlinePhones) {
        this.sameOperator = sameOperator;
        this.anotherOperator = anotherOperator;
        this.landlinePhones = landlinePhones;
    }

    public CallPrices() {
    }

    public float getSameOperator() {
        return sameOperator;
    }

    public void setSameOperator(float value) {
        this.sameOperator = value;
    }

    public float getAnotherOperator() {
        return anotherOperator;
    }

    public void setAnotherOperator(float value) {
        this.anotherOperator = value;
    }

    public float getLandlinePhones() {
        return landlinePhones;
    }

    public void setLandlinePhones(float value) {
        this.landlinePhones = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CallPrices)) {
            return false;
        }
        CallPrices that = (CallPrices) o;
        return Float.compare(that.sameOperator, sameOperator) == 0 &&
                Float.compare(that.anotherOperator, anotherOperator) == 0 &&
                Float.compare(that.landlinePhones, landlinePhones) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameOperator, anotherOperator, landlinePhones);
    }

    @Override
    public String toString() {
        return "CallPrices{" +
                "sameOperator=" + sameOperator +
                ", anotherOperator=" + anotherOperator +
                ", landlinePhones=" + landlinePhones +
                '}';
    }
}
