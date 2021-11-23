package com.nulp.gemstone;

public class Diamond extends Gemstone {

    private String diamondFormName;

    public Diamond() {};

    public String getDiamondFormName() {
        return diamondFormName;
    }

    public void setDiamondFormName(String diamondFormName) {
        this.diamondFormName = diamondFormName;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "\t\tdiamondFormName: " + diamondFormName;
    }
}
