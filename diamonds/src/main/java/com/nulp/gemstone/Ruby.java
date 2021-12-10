package com.nulp.gemstone;

public class Ruby extends Gemstone {

    private String manufacturerCountry;

    public Ruby() {};

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\t\tmanufacturer country: " + manufacturerCountry;
    }
}

