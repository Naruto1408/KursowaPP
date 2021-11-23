package com.nulp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nulp.command.*;
import com.nulp.necklace.Necklace;

import java.util.HashMap;
import java.util.Map;

public class LifecycleController {

    private Necklace necklace = new Necklace();
    private final Map<String, Command> commands = new HashMap<>();

    {
        Command infoCommand = new HelpCommand(LifecycleController.this);
        Command exitCommand = new ExitCommand();
        Command loadFromFileCommand = new LoadFromFileCommand(LifecycleController.this);
        Command showTariffListCommand = new ShowNecklaceCommand(LifecycleController.this);
        Command sortByTariffCostCommand = new SortByCostCommand(LifecycleController.this);
        Command getClientsAmountCommand = new NecklacePriceAndWeightCommand(LifecycleController.this);
        Command diapasonSearchCommand = new TransparencyDiapasonCommand(LifecycleController.this);

        commands.put(infoCommand.getName(), infoCommand);
        commands.put(exitCommand.getName(), exitCommand);
        commands.put(loadFromFileCommand.getName(), loadFromFileCommand);
        commands.put(showTariffListCommand.getName(), showTariffListCommand);
        commands.put(sortByTariffCostCommand.getName(), sortByTariffCostCommand);
        commands.put(getClientsAmountCommand.getName(), getClientsAmountCommand);
        commands.put(diapasonSearchCommand.getName(), diapasonSearchCommand);
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void setNecklace(Necklace necklace) {
        this.necklace = necklace;
    }

    public Necklace getNecklace() {
        return necklace;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
