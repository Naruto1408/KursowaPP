package com.nulp.gemstone;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Diamond.class, name = "diamond_gemstone"),
        @JsonSubTypes.Type(value = Ruby.class, name = "ruby_gemstone")
})

public abstract class Gemstone {

    protected String name;
    protected BigDecimal uahPerCarat;
    protected double hardness;
    protected double transparency;
    protected double weightInCarats;

    public Gemstone() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUahPerCarat() {
        return uahPerCarat;
    }

    public void setUahPerCarat(BigDecimal uahPerCarat) {
        this.uahPerCarat = uahPerCarat;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public double getWeightInCarats() {
        return weightInCarats;
    }

    public void setWeightInCarats(double weightInCarats) {
        this.weightInCarats = weightInCarats;
    }

    @Override
    public String toString() {
        return "\t\tname: " + name + "\n" +
                "\t\tuah per carat: " + uahPerCarat + "\n" +
                "\t\thardness: " + hardness + "\n" +
                "\t\ttransparency: " + transparency + "\n" +
                "\t\tweight in carats: " + weightInCarats;
    }
}
