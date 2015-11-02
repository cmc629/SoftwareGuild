/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controllers;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dto.Change;
import vendingmachine.dto.VendingMachine;
import vendingmachine.items.Item;
import vendingmachine.ui.ConsoleIO;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {

    VendingMachineDao dao = new VendingMachineDao();
    ConsoleIO io = new ConsoleIO();
    VendingMachine vend;

    public void run() {
        vend = new VendingMachine(dao.readItems());
        int userSelection = 0;
        while (userSelection != 3) {
            printMenu();
            double availableMoney = vend.getAvailableMoney();
            io.println(String.format("You have $%d.%02d", (int) availableMoney, (int) ((availableMoney % 1) * 100)));
            userSelection = io.promtForIntInRange("Choose action: ", 1, 3);
            switch (userSelection) {
                case 1:
                    putMoney();
                    break;
                case 2:
                    pickItem();
                    break;
                case 3:
                    break;
            }
        }
        getChange();
    }

    private void printMenu() {
        io.println("1- Add Money");
        io.println("2- Buy Item");
        io.println("3- Exit");
    }

    private void putMoney() {
        double amountIn = io.promptForDouble("How much will you enter?");
        if (amountIn >= 0) {
            vend.addMoney(amountIn);
        } else {
            io.println("Nice try.");
        }
    }

    private void pickItem() {
        List<Item> items = new ArrayList<>(vend.getItems().keySet());
        for (int i = 0; i < items.size(); i++) {
            io.println(String.format("%d- %s $%d.%02d %s", i + 1, items.get(i).getName(), items.get(i).getCostInPennies() / 100, items.get(i).getCostInPennies() % 100, vend.getItems().get(items.get(i)) > 0 ? "" : "*OUT OF STOCK*"));
        }
        int userSelection = io.promtForIntInRange("Make selection (or 0 to exit)", 0, items.size()) - 1;
        if (userSelection != -1) {
            if (vend.getAvailableMoney() * 100 < items.get(userSelection).getCostInPennies()) {
                io.println(String.format("Insufficient funds! Need %.2f but inserted %.2f", ((double) items.get(userSelection).getCostInPennies()) / 100, ((float) vend.getAvailableMoney()) / 100));
            } else if (vend.getItems().get(items.get(userSelection)) == 0) {
                io.println("That item is out of stock.");
            } else {
                if (vend.vendItem(items.get(userSelection))) {
                    io.println(items.get(userSelection).getName() + " vended.");
                    dao.writeItems(vend.getItems());
                }

            }
        }
    }

    private void getChange() {
        String message = "Your change was";
        Change change = vend.dispenseChange();
        if (!change.isEmpty()) {
            if (change.getQuarters() > 0) {
                message += String.format(" %d Quarters", change.getQuarters());
            }
            if (change.getDimes() > 0) {
                message += String.format(" %d Dimes", change.getDimes());
            }
            if (change.getNickels() > 0) {
                message += String.format(" %d Nickels", change.getNickels());
            }
            if (change.getPennies() > 0) {
                message += String.format(" %d Pennies", change.getPennies());
            }
        } else {
            message += " nothing";
        }
        message += ".";
        io.println(message);
    }
}
