package com.nulp.command;

import com.nulp.controller.LifecycleController;
import com.nulp.gemstone.Gemstone;
import com.nulp.response.ResponseEntity;

import java.util.List;

public class AddGemstoneToNecklaceCommand extends Command {

    public static final String NAME = "add";
    public static final String DESC = "add selected gemstone to necklace";

    private LifecycleController lc;

    public AddGemstoneToNecklaceCommand(LifecycleController lc) {
        this.lc = lc;
    }

    @Override
    public ResponseEntity execute() {
        ResponseEntity responseEntity = new ResponseEntity();
        List<Gemstone> gemstones = lc.getGemstoneRepository().findAll();

        int selectedId = (int)lc.getCommandParams().get("gemId");

        Gemstone gemstone = null;
        try{
            gemstone = gemstones.get(selectedId);
            lc.getNecklace().getGemstones().add(gemstone);
            responseEntity.addPair("success", "Камінь додано");
        }catch (IndexOutOfBoundsException e) {
            responseEntity.addPair("error", "Невірний індекс");
        }
        return responseEntity;
    }
}
