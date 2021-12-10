package com.nulp.controller;

import com.nulp.command.*;
import com.nulp.necklace.Necklace;
import com.nulp.repository.GemstoneRepository;
import com.nulp.response.ResponseEntity;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class LifecycleController {

    private final ApplicationContext context;
    private GemstoneRepository gemstoneRepository;
    private Necklace necklace = new Necklace();

    private final Map<String, Command> commands = new HashMap<>();
    private final Map<String, Object> commandParams = new HashMap<>();

    public LifecycleController(ApplicationContext context) {
        this.context = context;
        gemstoneRepository = context.getBean(GemstoneRepository.class);
    }

    {
        Command showNecklaceCommand = new ShowNecklaceCommand(LifecycleController.this);
        Command sortByGemstoneCostCommand = new SortByCostCommand(LifecycleController.this);
        Command priceAndWeightCommand = new NecklacePriceAndWeightCommand(LifecycleController.this);
        Command transparencyDiapasonSearchCommand = new TransparencyDiapasonCommand(LifecycleController.this);
        Command addGemstoneToNecklaceCommand = new AddGemstoneToNecklaceCommand(LifecycleController.this);
        Command showAvailableGemstonesCommand = new ShowAvailableGemstonesCommand(LifecycleController.this);

        commands.put(ShowNecklaceCommand.NAME, showNecklaceCommand);
        commands.put(SortByCostCommand.NAME, sortByGemstoneCostCommand);
        commands.put(NecklacePriceAndWeightCommand.NAME, priceAndWeightCommand);
        commands.put(TransparencyDiapasonCommand.NAME, transparencyDiapasonSearchCommand);
        commands.put(AddGemstoneToNecklaceCommand.NAME, addGemstoneToNecklaceCommand);
        commands.put(ShowAvailableGemstonesCommand.NAME, showAvailableGemstonesCommand);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void setNecklace(Necklace necklace) {
        this.necklace = necklace;
    }

    public Necklace getNecklace() {
        return necklace;
    }

    public GemstoneRepository getGemstoneRepository() {
        return gemstoneRepository;
    }
    public ResponseEntity executeCommand(String command) {
        Command cmd = commands.get(command);
        if(cmd != null)
            return cmd.execute();
        else {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.addPair("Message", "No such command");
            return responseEntity;
        }
    }

    public Map<String, Object> getCommandParams() {
        return commandParams;
    }
}
