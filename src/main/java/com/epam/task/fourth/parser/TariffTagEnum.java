package com.epam.task.fourth.parser;

public enum TariffTagEnum {

    TARIFFS("tariffs"),
    TARIFF("tariff"),
    TARIFFWITHINTERNET("tariff-with-internet"),
    ID("id"),
    NAME("name"),
    OPERATORNAME("operator-name"),
    PAYROLL("payroll"),
    CALLPRICES("call-prices"),
    SAMEOPERATOR("same-operator"),
    ANOTHEROPERATOR("another-operator"),
    LANDLINEPHONES("landline-phones"),
    SMSPRICE("sms-price"),
    TRAFFICINMEGABYTES("traffic-in-megabyte"),
    PRICEFORONEMEGABYTE("price-for-one-megabyte"),
    ISMODEMMODEENABLED("is-modem-mode-enabled");

    private String value;

    private TariffTagEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TariffTagEnum getEnumByValue(String value) {
        for (TariffTagEnum tariffTagEnum : values()) {
            if (tariffTagEnum.value.equals(value)) {
                return tariffTagEnum;
            }
        }
        return null;
    }
}
