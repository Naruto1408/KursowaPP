package com.nulp.necklace;

import com.nulp.gemstone.Gemstone;

import java.util.ArrayList;
import java.util.List;

public class Necklace {

    private String name;
    private List<Gemstone> gemstones = new ArrayList<>();

    public Necklace() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(List<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Gemstone gemstone : gemstones) {
            sb.append(gemstone).append("\n\t\t-------------\n");
        }
        return "\tname: " + name + "\n" +
                "\tgemstones: {\n" +
                sb + "\t}";
    }
}
