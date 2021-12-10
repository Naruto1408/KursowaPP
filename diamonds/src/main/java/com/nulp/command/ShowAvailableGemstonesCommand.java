package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.gemstone.Gemstone;
import com.nulp.response.ResponseEntity;

import java.util.List;

public class ShowAvailableGemstonesCommand extends Command {

    public static final String NAME = "gem";
    public static final String DESC = "List available gemstones";

    private LifecycleController lc;

    public ShowAvailableGemstonesCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity responseEntity = new ResponseEntity();
        List<Gemstone> gemstones = lc.getGemstoneRepository().findAll();

        responseEntity.addPair("Gemstones", gemstones);
        return responseEntity;
    }
}

