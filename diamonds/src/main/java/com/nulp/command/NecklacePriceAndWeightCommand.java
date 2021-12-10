package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.gemstone.Gemstone;
import com.nulp.response.ResponseEntity;

import java.math.BigDecimal;

public class NecklacePriceAndWeightCommand extends Command {

    public static final String NAME = "pw";
    public static final String DESC = "Get necklace`s price and weight";

    private LifecycleController lc;

    public NecklacePriceAndWeightCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity response = new ResponseEntity();
        if (lc.getNecklace() == null)
            return response;

        response.addPair("weight (carats)",
                lc.getNecklace().getGemstones().stream().map(Gemstone::getWeightInCarats).reduce(Double::sum).orElse(0.));
        response.addPair("total price",
                lc.getNecklace().getGemstones().stream().map(v -> v.getUahPerCarat().multiply(BigDecimal.valueOf(v.getWeightInCarats()))).map(BigDecimal::doubleValue).reduce(Double::sum).orElse(0.));
        return response;
    }
}