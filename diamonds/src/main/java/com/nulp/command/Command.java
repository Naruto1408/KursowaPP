package com.nulp.command;

import com.nulp.response.ResponseEntity;

public abstract class Command {

    private final String name = "none";
    private final String desc = "base command";

    public abstract ResponseEntity execute();

    @Override
    public String toString() {
        return this.getName() + " - " + this.getDesc();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
