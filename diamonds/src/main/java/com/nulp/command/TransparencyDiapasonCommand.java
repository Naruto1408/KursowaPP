package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.gemstone.Gemstone;
import com.nulp.response.ResponseEntity;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TransparencyDiapasonCommand extends Command {

    public static final String NAME = "tdiap";
    public static final String DESC = "Find gemstones by transparency diapason";

    private LifecycleController lc;

    public TransparencyDiapasonCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity response = new ResponseEntity();

        Scanner scanner = new Scanner(System.in);

        double leftBound = (double)lc.getCommandParams().get("lb");
        double rightBound = (double)lc.getCommandParams().get("rb");

        List<Gemstone> gemstoneList = lc.getNecklace().getGemstones()
                .stream()
                .filter(v -> v.getTransparency() >= leftBound && v.getTransparency() < rightBound)
                .collect(Collectors.toList());

        response.addPair("Gemstones transparency [" + leftBound + ", " + rightBound + "]", gemstoneList);
        return response;
    }
}