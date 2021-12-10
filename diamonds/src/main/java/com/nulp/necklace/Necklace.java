package com.nulp.necklace;

import com.nulp.gemstone.Gemstone;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document("necklaces")
public class Necklace {

    private List<Gemstone> gemstones = new ArrayList<>();

    public Necklace() {};

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
        return "\tgemstones: {\n" +
                sb + "\t\t}";
    }
}
