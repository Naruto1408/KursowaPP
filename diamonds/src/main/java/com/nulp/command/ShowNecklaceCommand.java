package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

public class ShowNecklaceCommand extends Command {

    public static final String NAME = "necklace";
    public static final String DESC = "Show necklace";

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

}