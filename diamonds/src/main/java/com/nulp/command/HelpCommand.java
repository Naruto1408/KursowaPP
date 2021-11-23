package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpCommand extends Command {

    private final String name = "help";
    private final String desc = "List all available commands";
    private LifecycleController lc;

    public HelpCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity re = new ResponseEntity();
        re.addPair("commands", lc.getCommands().values());
        return re;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
