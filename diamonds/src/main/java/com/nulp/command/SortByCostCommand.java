package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.gemstone.Gemstone;
import com.nulp.response.ResponseEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByCostCommand extends Command {

    private final String name = "sort";
    private final String desc = "Sort gemstones by cost";

    private LifecycleController lc;

    public SortByCostCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity responseEntity = new ResponseEntity();
        List<Gemstone> gemstonesCopy = new ArrayList<>(lc.getNecklace().getGemstones());
        gemstonesCopy.sort(Comparator.comparing(Gemstone::getUahPerCarat).reversed());

        responseEntity.addPair("Sorted gemstones by cost", gemstonesCopy);
        return responseEntity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
