package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.gemstone.Gemstone;
import com.nulp.response.ResponseEntity;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TransparencyDiapasonCommand extends Command {

    private final String name = "tdiap";
    private final String desc = "Find gemstones by transparency diapason";

    private LifecycleController lc;

    public TransparencyDiapasonCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity response = new ResponseEntity();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Left bound >> ");
        double leftBound = scanner.nextLong();
        System.out.print("Right bound >> ");
        double rightBound = scanner.nextLong();

        List<Gemstone> gemstoneList = lc.getNecklace().getGemstones()
                .stream()
                .filter(v -> v.getTransparency() >= leftBound && v.getTransparency() < rightBound)
                .collect(Collectors.toList());

        response.addPair("Gemstones", gemstoneList);
        return response;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
