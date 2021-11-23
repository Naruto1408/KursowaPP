package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

public class ShowNecklaceCommand extends Command {

    private final String name = "necklace";
    private final String desc = "Show necklace";

    private LifecycleController lc;

    public ShowNecklaceCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity response = new ResponseEntity();
        response.addPair("Necklace", lc.getNecklace());
        return response;
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
