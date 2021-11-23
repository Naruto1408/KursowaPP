package com.nulp;

import com.nulp.command.Command;
import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        LifecycleController lc = new LifecycleController();

        ResponseEntity help = lc.getCommands().get("help").execute();
        System.out.println(help);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">> ");
            String command = scanner.nextLine();

            Map<String, Command> commands = lc.getCommands();
            Command executor = commands.get(command);
            if(executor == null) {
                System.out.println("No such command");
            }else {
                ResponseEntity response = executor.execute();
                System.out.println(response);
            }
        }
    }
}
