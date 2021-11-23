package com.nulp.command;

import com.nulp.response.ResponseEntity;

public class ExitCommand extends Command {

    private final String name = "exit";
    private final String desc = "exit application";

    @Override
    public ResponseEntity execute() {
        System.exit(0);
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
