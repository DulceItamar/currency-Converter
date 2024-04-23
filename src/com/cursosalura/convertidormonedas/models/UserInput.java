package com.cursosalura.convertidormonedas.models;

public class UserInput {
    private float currencyValue;

    private float newValue;
    private String currentCurrency;
    private String newCurrency;


    public float getCurrencyValue() {
        return currencyValue;
    }

    public String getNewCurrency() {
        return newCurrency;
    }

    public String getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrencyValue(float currencyValue) {
        this.currencyValue = currencyValue;
    }

    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    public void setNewCurrency(String newCurrency) {
        this.newCurrency = newCurrency;
    }

    public float getNewValue() {
        return newValue;
    }

    public void setNewValue(float newValue) {


        this.newValue = newValue;
    }
}
