/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.controller;

import com.thesoftwareguild.consoleio.ConsoleIO;
import com.thesoftwareguild.mavenflooringmastery.daos.OrderDao;
import com.thesoftwareguild.mavenflooringmastery.daos.ProductDao;
import com.thesoftwareguild.mavenflooringmastery.daos.ProductDaoImpl;
import com.thesoftwareguild.mavenflooringmastery.daos.StateDao;
import com.thesoftwareguild.mavenflooringmastery.daos.StateDaoImpl;
import com.thesoftwareguild.mavenflooringmastery.dtos.Order;
import com.thesoftwareguild.mavenflooringmastery.dtos.Product;
import com.thesoftwareguild.mavenflooringmastery.dtos.State;
import com.thesoftwareguild.mavenflooringmastery.utility.StateConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Choi
 */
public class FlooringMasteryController {

    private ConsoleIO io = new ConsoleIO();
    private OrderDao odao;
    private ProductDao pdao;
    private StateDao sdao;

    public FlooringMasteryController(OrderDao odao, ProductDao pdao, StateDao sdao) {
        this.odao = odao;
        this.pdao = pdao;
        this.sdao = sdao;
    }
    
    public void run() {
        
        odao.load();
        pdao.load();
        sdao.load();
        
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int selection = io.promptInt("> ", 1, 6);
            io.println("");

            switch (selection) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    runAdminMode();
                    break;
                case 6:
                    io.println("Thank you! Goodbye!");
                    isRunning = false;
                    break;
            }
            odao.save();
        }
    }

    private void printMenu() {
        io.println("********************************************"); //44 asterisks
        io.println(String.format("%14sFlooring Program", ""));
        io.println(String.format("CURRENT ORDERS: %d", odao.getOrders().size()));
        io.println("\n1. Display Orders\n2. Add an Order\n3. Edit an Order"
                + "\n4. Remove an Order\n5. Administrator Mode\n6. Quit");
        io.println("********************************************");

    }

    private void displayOrders() {
        io.println("Display orders by the date...");

        if (odao.getOrders().isEmpty()) {
            io.println("\nThere are no orders to display!");
        } else {
            printAvailableDates();

            Date date = askUserForDate();

            List<Order> orderList = odao.displayOrderByDate(date);

            if (orderList.isEmpty()) {
                io.println("\nThere are currently no orders for that date!");
            } else {
                for (Order order : orderList) {
                    io.println("\n============================================");
                    io.println(String.format("Name: %s\nOrder #: %s\n"
                            + "State: %s\tTax Rate: %.2f%%\nProduct Type: %s\t"
                            + "Material Cost/SqFt: $%.2f\tLabor Cost/SqFt: $%.2f\n"
                            + "Area: %.2f sq ft\nMaterial Cost: $%.2f\tLabor Cost: $%.2f\t"
                            + "Tax: $%.2f\tTotal: $%.2f", order.getCustomerName(),
                            order.getOrderNumber(), order.getState().getStateName(),
                            order.getState().getTaxRate(), order.getProduct().getProductName(),
                            order.getProduct().getCostPer(), order.getProduct().getLaborCostPer(),
                            order.getArea(), order.getOrderMaterialCost(), order.getOrderLaborCost(),
                            order.getOrderTax(), order.getOrderTotal()));
                }
            }
        }
    }

    private void addOrder() {
        io.println("Adding an order...");

        Order order = new Order();

        String name = io.promptString("\nPlease enter the last name: ");
        order.setCustomerName(name);

        Date date = askUserForDate();
        order.setDate(date);

        State state = askUserForState();
        order.setState(state);

        Product product = askUserForProduct();
        order.setProduct(product);

        double area = io.promptDouble("\nPlease enter the area (in sq. ft): ", 0, Double.MAX_VALUE);
        order.setArea(area);
        boolean validConfirm = false;
        while (!validConfirm) {
            String confirm = io.promptString("\nConfirm adding of the order? (yes/no): ").toLowerCase();
            if (confirm.equals("y") || confirm.equals("yes")) {
                odao.create(order);
                io.println(String.format("\nThe order has been added. Order # is %d.", order.getOrderNumber()));
                validConfirm = true;
            } else if (confirm.equals("n") || confirm.equals("no")) {
                io.println("\nThe order was not added.");
                validConfirm = true;
            } else {
                io.println("Invalid input!");
            }
        }

    }

    private void editOrder() {
        io.println("Editing an order...");
        if (odao.getOrders().isEmpty()) {
            io.println("\nThere are no orders to display!");
        } else {
            printAvailableDates();

            Date date = askUserForDate();

            List<Order> orderList = odao.displayOrderByDate(date);

            if (orderList.isEmpty()) {
                io.println("\nThere are currently no orders for that date!");
            } else {
                io.println("\nCurrent Order(s) for the date: " + date);
                for (Order order : orderList) {
                    io.println(String.format("Order #: %d | Customer Name: %s",
                            order.getOrderNumber(), order.getCustomerName()));
                }

                boolean isValidNumber = false;
                int orderSelection = 0;
                while (!isValidNumber) {
                    orderSelection = io.promptInt("\nPlease enter the order number: ");
                    if (checkOrderNumber(orderList, orderSelection)) {
                        isValidNumber = true;
                    } else {
                        io.println("Invalid input!");
                    }
                }

                Order order = odao.get(orderSelection);
                Order editedOrder = new Order();
                editedOrder.setOrderNumber(orderSelection);
                SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");

                io.println("\nEach property of the order will be shown one at a time.");
                io.println("The value in parenthesis is the current property. To replace");
                io.println("the property, enter your new values. Press enter to skip that");
                io.println("edit.");

                //Edit Name
                String nameEdit = io.promptString(String.format("\nEnter customer name (%s): ", order.getCustomerName()));
                if (nameEdit.isEmpty()) {
                    editedOrder.setCustomerName(order.getCustomerName());
                } else {
                    editedOrder.setCustomerName(nameEdit);
                }
                //Edit Date
                boolean isValidDate = false;
                String dateEdit = "";
                while (!isValidDate) {
                    dateEdit = io.promptString(String.format("\nEnter date (%s): ", order.getFormattedDate()));
                    if (!dateEdit.isEmpty()) {
                        Date newDate = getDateObj(dateEdit);
                        if (newDate != null) {
                            editedOrder.setDate(newDate);
                            isValidDate = true;
                        } else {
                            io.println("Invalid date input. You may hit enter to skip date edit.");
                        }
                    } else {
                        editedOrder.setDate(order.getDate());
                        isValidDate = true;
                    }
                }

                //Edit State
                String stateEdit = "";
                boolean isValidState = false;
                while (!isValidState) {
                    io.println("\nAvailable States: " + String.valueOf(sdao.listCurrentStates()));
                    stateEdit = io.promptString(String.format("Enter state (%s): ",
                            order.getState().getStateName())).toLowerCase();
                    if (stateEdit.isEmpty()) {
                        editedOrder.setState(order.getState());
                        break;
                    } else {
                        stateEdit = getStateAbbreviations(stateEdit);
                        if (sdao.isValidState(stateEdit)) {
                            editedOrder.setState(sdao.getStates().get(stateEdit));
                            isValidState = true;
                        } else {
                            io.println("Invalid state input. You may also hit enter to skip state edit.");
                        }
                    }
                }

                //Edit Product
                String productEdit = "";
                boolean isValidProduct = false;
                while (!isValidProduct) {
                    io.println("\nAvailable Flooring Types: " + String.valueOf(pdao.listAllProducts()));
                    productEdit = io.promptString(String.format("Enter product (%s): ",
                            order.getProduct().getProductName())).toLowerCase();
                    if (productEdit.isEmpty()) {
                        editedOrder.setProduct(order.getProduct());
                        break;
                    } else {
                        productEdit = getProductName(productEdit);
                        if (!productEdit.equals("Invalid")) {
                            editedOrder.setProduct(pdao.getProducts().get(productEdit));;
                            isValidProduct = true;
                        } else {
                            io.println("Invalid product input. You may also hit enter to skip product edit.");
                        }
                    }
                }
                //Edit Area
                Double areaEdit = io.promptDouble(String.format("\nEnter area (%.2f): ", order.getArea()), 0, Double.MAX_VALUE);
                if (areaEdit.equals(Double.NaN)) {
                    editedOrder.setArea(order.getArea());
                } else {
                    editedOrder.setArea(areaEdit);
                }

                io.println("\nHere are your changes: ");
                io.println(String.format("Name:\t %s --> %s", order.getCustomerName(), editedOrder.getCustomerName()));
                io.println(String.format("Date:\t %s --> %s", order.getFormattedDate(), editedOrder.getFormattedDate()));
                io.println(String.format("State:\t %s --> %s", order.getState().getStateName(), editedOrder.getState().getStateName()));
                io.println(String.format("Product: %s --> %s", order.getProduct().getProductName(), editedOrder.getProduct().getProductName()));
                io.println(String.format("Area:\t %.2f --> %.2f", order.getArea(), editedOrder.getArea()));
                String select = io.promptString("Enter 'yes' to commit to these changes. Enter anything else to cancel: ").toLowerCase();
                if (select.equals("yes")) {
                    odao.update(editedOrder);
                    io.println("\nChanges have been made!");
                } else {
                    io.println("\nChanges were not made.");
                }
            }
        }
    }

    private void removeOrder() {
        io.println("Removing an order...");
        if (odao.getOrders().isEmpty()) {
            io.println("\nThere are no orders to display!");
        } else {
            printAvailableDates();

            Date date = askUserForDate();

            List<Order> orderList = odao.displayOrderByDate(date);

            if (orderList.isEmpty()) {
                io.println("\nThere are currently no orders for that date!");
            } else {
                io.println("\nCurrent Order(s) for the date: " + date);
                for (Order order : orderList) {
                    io.println(String.format("Order #: %d | Customer Name: %s",
                            order.getOrderNumber(), order.getCustomerName()));
                }

                boolean isValidNumber = false;
                int orderSelection = 0;
                while (!isValidNumber) {
                    orderSelection = io.promptInt("\nPlease enter the order number. Enter '0' to Quit: ");
                    if (orderSelection == 0) {
                        isValidNumber = true;
                    } else if (checkOrderNumber(orderList, orderSelection)) {
                        isValidNumber = true;
                    } else {
                        io.println("Invalid input!");
                    }
                }
                if (orderSelection == 0) {
                    io.println("\nReturning to main menu.");
                } else {
                    boolean validConfirm = false;
                    while (!validConfirm) {
                        String confirm = io.promptString("\nConfirm removal of order? (yes/no): ").toLowerCase();
                        if (confirm.equals("y") || confirm.equals("yes")) {
                            Order removedOrder = odao.get(orderSelection);
                            odao.delete(orderSelection);
                            io.println(String.format("\nOrder #%d was removed.", removedOrder.getOrderNumber()));
                            validConfirm = true;
                        } else if (confirm.equals("n") || confirm.equals("no")) {
                            io.println("\nThe order was not removed.");
                            validConfirm = true;
                        } else {
                            io.println("Invalid input!");
                        }
                    }
                }
            }
        }
    }

    private void runAdminMode() {

        boolean shouldRun = true;
        while (shouldRun) {
            printAdminMenu();
            int adminSelection = io.promptInt("> ", 1, 7);

            switch (adminSelection) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    addState();
                    break;
                case 5:
                    editState();
                    break;
                case 6:
                    removeState();
                    break;
                case 7:
                    shouldRun = false;
                    break;
            }
            pdao.save();
            sdao.save();
        }
    }

    private void addProduct() {
        io.println("\nAdding a new flooring option...");
        boolean isValidName = false;
        boolean isValidCost = false;
        boolean isValidLaborCost = false;
        String productName = "";
        Double costPer = 0d;
        Double laborCostPer = 0d;
        while (!isValidName) {
            productName = io.promptString("\nPlease enter the product name: ");
            productName = capitalizeFirstLowerRest(productName);
            if (pdao.listAllProducts().contains(productName)) {
                io.println("That product already exists!");
            } else {
                isValidName = true;
            }
        }
        while (!isValidCost) {
            costPer = io.promptDouble("\nPlease enter the material cost per square ft: ", 0, Double.MAX_VALUE);
            if (costPer.equals(Double.NaN)) {
                io.println("Empty value is unacceptable!");
            } else {
                isValidCost = true;
            }
        }
        while (!isValidLaborCost) {
            laborCostPer = io.promptDouble("\nPlease enter the labor cost per square ft: ", 0, Double.MAX_VALUE);
            if (laborCostPer.equals(Double.NaN)) {
                io.println("Empty value is unacceptable!");
            } else {
                isValidLaborCost = true;
            }
        }
        io.println(String.format("\nProduct Information:\nProduct Name: %s\nCost/SqFt: $%.2f\nLabor Cost/SqFt: $%.2f",
                productName, costPer, laborCostPer));
        String choice = io.promptString("\nEnter 'yes' to add this product option. Enter anything else to cancel: ").toLowerCase();
        if (choice.equals("yes")) {
            Product product = new Product();
            product.setProductName(productName);
            product.setCostPer(costPer);
            product.setLaborCostPer(laborCostPer);
            pdao.create(product);
            io.println(String.format("\nProduct %s was added.", product.getProductName()));
        } else {
            io.println("\nProduct was not added.");
        }

    }

    private void editProduct() { //this will break if there are no products...solve easily using isEmpty() condition
        io.println("\nEditing product option...");
        if (!pdao.listAllProducts().isEmpty()) {
            io.println("Available flooring options: " + pdao.listAllProducts());
            boolean isValid = false;
            String productName = "";
            while (!isValid) {
                String option = io.promptString("Please enter the flooring option you would like to edit: ").toLowerCase();
                productName = getProductName(option);
                if (productName.equals("Invalid")) {
                    io.println("Product not found!");
                } else {
                    isValid = true;
                }
            }
            Product product = pdao.getProducts().get(productName);
            Product editedProduct = new Product();
            io.println("\nEach property of the product will be shown one at a time.");
            io.println("The value in parenthesis is the current property. To replace");
            io.println("the property, enter your new values. Press enter to skip that");
            io.println("edit.");
            //Edit name
            boolean shouldContinue = false;
            String nameEdit = "";
            while (!shouldContinue) {
                nameEdit = capitalizeFirstLowerRest(io.promptString(String.format("\nEnter product name (%s): ",
                        product.getProductName())));
                if (nameEdit.isEmpty()) {
                    editedProduct.setProductName(product.getProductName());
                    shouldContinue = true;
                } else {
                    if (pdao.listAllProducts().contains(nameEdit)) {
                        if (!nameEdit.equals(product.getProductName())) {
                            io.println("That product name already exists! Choose a different name.");
                        } else {
                            editedProduct.setProductName(product.getProductName());
                            io.println("Name unchanged.");
                            shouldContinue = true;
                        }
                    } else {
                        editedProduct.setProductName(nameEdit);
                        shouldContinue = true;
                    }
                }
            }
            //Edit costPer
            Double cpEdit = io.promptDouble(String.format("\nEnter cost/SqFt (%.2f): ",
                    product.getCostPer()), 0, Double.MAX_VALUE);
            if (cpEdit.equals(Double.NaN)) {
                editedProduct.setCostPer(product.getCostPer());
            } else {
                editedProduct.setCostPer(cpEdit);
            }
            //Edit laborCostPer
            Double lcpEdit = io.promptDouble(String.format("\nEnter labor cost/SqFt (%.2f): ",
                    product.getLaborCostPer()), 0, Double.MAX_VALUE);
            if (lcpEdit.equals(Double.NaN)) {
                editedProduct.setLaborCostPer(product.getLaborCostPer());
            } else {
                editedProduct.setLaborCostPer(lcpEdit);
            }
            io.println("\nHere are your changes:");
            io.println(String.format("Product Name:\t\t%s --> %s",
                    product.getProductName(), editedProduct.getProductName()));
            io.println(String.format("Material Cost/SqFt:\t$%.2f --> $%.2f",
                    product.getCostPer(), editedProduct.getCostPer()));
            io.println(String.format("Labor Cost/SqFt:\t$%.2f --> $%.2f",
                    product.getLaborCostPer(), editedProduct.getLaborCostPer()));
            String commit = io.promptString("\nEnter 'yes' to commit to these changes. Enter anything else to cancel: ").toLowerCase();
            if (commit.equals("yes")) {
                pdao.update(product, editedProduct);
                io.println("\nChanges have been made!");
            } else {
                io.println("\nChanges were not made.");
            }
        } else {
            io.println("No products to edit!");
        }
    }

    private void removeProduct() { //for now, make it so you can't remove a product if any order contains that product
        io.println("\nRemoving product option...");
        if (!pdao.listAllProducts().isEmpty()) {
            io.println("Available flooring options: " + pdao.listAllProducts());
            boolean isValid = false;
            boolean finalizeProcess = false;
            String productName = "";

            while (!isValid) {
                String option = io.promptString("\nPlease enter the flooring option you would like to remove. Enter nothing to quit this process: ").toLowerCase();
                if (option.equals("")) {
                    io.println("Back to admin menu...");
                    isValid = true;
                } else {
                    productName = getProductName(option);
                    if (productName.equals("Invalid")) {
                        io.println("Product not found!");
                    } else {
                        if (odao.containsProduct(productName)) {
                            io.println("This product was found amongst the current orders! Please choose a different product.");
                        } else {
                            isValid = true;
                            finalizeProcess = true;
                        }
                    }
                }
            }
            if (finalizeProcess) {
                Product product = pdao.getProducts().get(productName);
                String choice = io.promptString(String.format("\nEnter 'yes' to remove the product option %s. Hit anything else to cancel: ",
                        product.getProductName())).toLowerCase();
                if (choice.equals("yes")) {
                    Product removedProduct = pdao.delete(product);
                    io.println(String.format("\nProduct %s was removed!", removedProduct.getProductName()));
                } else {
                    io.println(String.format("\nProduct %s was not removed!", product.getProductName()));
                }
            }
        } else {
            io.println("No products to remove!");
        }
    }

    private void addState() {
        io.println("\nAdding state option...");
        io.println("Current state options: " + sdao.listCurrentStates());
        boolean shouldContinue = false;
        String stateName = "";
        while (!shouldContinue) {
            stateName = io.promptString("\nPlease enter a US state name or abbreviation: ").toLowerCase();
            stateName = getStateAbbreviations(stateName);
            if (stateName.equals("Invalid")) {
                io.println("That's not a state in the US!");
            } else {
                if (sdao.getStates().containsKey(stateName)) {
                    io.println("That state already exists!");
                } else {
                    shouldContinue = true;
                }
            }
        }
        boolean isValidTR = false;
        Double taxRate = 0d;
        while (!isValidTR) {
            taxRate = io.promptDouble("\nPlease enter the state tax rate: ", 0, Double.MAX_VALUE);
            if (taxRate.equals(Double.NaN)) {
                io.println("Empty value is unacceptable!");
            } else {
                isValidTR = true;
            }
        }
        io.println(String.format("\nState Information:\nState: %s\nTax Rate: %.2f%%",
                stateName, taxRate));
        String choice = io.promptString("\nEnter 'yes' to add this state option. Enter anything else to cancel: ").toLowerCase();
        if (choice.equals("yes")) {
            State state = new State();
            state.setStateName(stateName);
            state.setTaxRate(taxRate);
            sdao.create(state);
            io.println(String.format("\nState %s was added.", state.getStateName()));
        } else {
            io.println("\nState was not added.");
        }

    }

    private void editState() {
        io.println("\nEditing state option...");
        if (!sdao.listCurrentStates().isEmpty()) {
            io.println("Current state options: " + sdao.listCurrentStates());
            boolean isValid = false;
            String stateName = "";
            while (!isValid) {
                String option = io.promptString("\nPlease enter the state option you would like to edit: ").toLowerCase();
                stateName = getStateAbbreviations(option);
                if (!sdao.isValidState(stateName)) {
                    io.println("State not found!");
                } else {
                    isValid = true;
                }
            }
            State state = sdao.getStates().get(stateName);
            State editedState = new State();

            io.println("\nEach property of the state will be shown one at a time.");
            io.println("The value in parenthesis is the current property. To replace");
            io.println("the property, enter your new values. Press enter to skip that");
            io.println("edit.");
            //Edit name
            boolean shouldContinue = false;
            String nameEdit = "";
            while (!shouldContinue) {
                nameEdit = io.promptString(String.format("\nEnter state name (%s): ",
                        state.getStateName()));
                if (nameEdit.isEmpty()) {
                    editedState.setStateName(state.getStateName());
                    shouldContinue = true;
                } else {
                    nameEdit = getStateAbbreviations(nameEdit);
                    if (sdao.isValidState(nameEdit)) {
                        if (!nameEdit.equals(state.getStateName())) {
                            io.println("That state option already exists! choose a different state.");
                        } else {
                            editedState.setStateName(state.getStateName());
                            io.println("State unchanged.");
                            shouldContinue = true;
                        }
                    } else {
                        if (nameEdit.equals("Invalid")) {
                            io.println("That state does not exist!");
                        } else {
                            editedState.setStateName(nameEdit);
                            shouldContinue = true;
                        }
                    }
                }
            }
            //Edit TaxRate
            Double trEdit = io.promptDouble(String.format("\nEnter tax rate (%.2f): ",
                    state.getTaxRate()), 0, Double.MAX_VALUE);
            if (trEdit.equals(Double.NaN)) {
                editedState.setTaxRate(state.getTaxRate());
            } else {
                editedState.setTaxRate(trEdit);
            }
            //Show changes
            io.println("\nHere are your changes:");
            io.println(String.format("State:\t\t%s --> %s",
                    state.getStateName(), editedState.getStateName()));
            io.println(String.format("Tax Rate:\t%.2f%% --> %.2f%%",
                    state.getTaxRate(), editedState.getTaxRate()));
            //Commit to changes?
            String commit = io.promptString("\nEnter 'yes' to commit to these changes. Enter anything else to cancel: ").toLowerCase();
            if (commit.equals("yes")) {
                sdao.update(state, editedState);
                io.println("\nChanges have been made!");
            } else {
                io.println("\nChanges were not made.");
            }
        } else {
            io.println("No states to edit!");
        }
    }

    private void removeState() { //For now, make it so that you can't remove a state if any order contains that state
        io.println("\nRemoving state option...");
        if (!sdao.listCurrentStates().isEmpty()) {
            io.println("Current state options: " + sdao.listCurrentStates());
            boolean isValid = false;
            boolean finalizeProcess = false;
            String stateName = "";
            while (!isValid) {
                String option = io.promptString("\nPlease enter the state option you would like to remove. Enter nothing to quit this process: ").toLowerCase();
                if (option.equals("")) {
                    io.println("Back to admin menu...");
                    isValid = true;
                } else {
                    stateName = getStateAbbreviations(option);
                    if (!sdao.isValidState(stateName)) {
                        io.println("State not found!");
                    } else {
                        if (odao.containsState(stateName)) {
                            io.println("This state was found amongst the current orders! Please choose a different state.");
                        } else {
                            isValid = true;
                            finalizeProcess = true;
                        }
                    }
                }
            }
            if (finalizeProcess) {
                State state = sdao.getStates().get(stateName);
                String choice = io.promptString(String.format("\nEnter 'yes' to remove the state option %s. Hit anything else to cancel: ",
                        state.getStateName())).toLowerCase();
                if (choice.equals("yes")) {
                    State removedState = sdao.delete(state);
                    io.println(String.format("\nState %s was removed!", removedState.getStateName()));
                } else {
                    io.println(String.format("\nState %s was not removed!", state.getStateName()));
                }
            }
        } else {
            io.println("No states to remove!");
        }
    }

    //Helper Functions
    private void printAdminMenu() {
        io.println("++++++++++++++++++++++++++++++++++++++++++++");
        io.println(String.format("%14sAdministrator Mode", ""));
        io.println("AVAILABLE FLOORINGS: " + pdao.listAllProducts());
        io.println("AVAILABLE STATES: " + sdao.listCurrentStates());
        io.println("\n1. Add Product Option\n2. Edit Product Option"
                + "\n3. Remove Product Option\n4. Add State Option"
                + "\n5. Edit State Option\n6. Remove State Option"
                + "\n7. Return to main menu");
        io.println("++++++++++++++++++++++++++++++++++++++++++++");

    }

    private boolean checkOrderNumber(List<Order> orderList, int number) {
        for (Order order : orderList) {
            if (order.getOrderNumber() == number) {
                return true;
            }
        }
        return false;
    }

    private Date askUserForDate() {
        String dateString = io.promptString("\nPlease enter the date (mm-dd-yyyy): ");
        Date date = getDateObj(dateString);
        if (date == null) {
            io.println("Invalid input or date format!");
            return askUserForDate();
        } else {
            return date;
        }
    }

    private Date getDateObj(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        List<String> formatList = new ArrayList<>();
        formatList.add("MM dd yy");
        formatList.add("MMMM dd, yyyy");
        formatList.add("MMMM dd yyyy");
        formatList.add("MM-dd-yy");
        formatList.add("MM/dd/yy");
        formatList.add("MM dd yyyy");
        Date date = null;
        for (String pattern : formatList) {
            SimpleDateFormat sdf2 = new SimpleDateFormat(pattern);
            try {
                date = sdf2.parse(dateString);
                return date;
            } catch (ParseException ex) {
                //Nothing here
            }
        }
        return date; //At moment this can be null...  
    }

    private State askUserForState() {

        io.println("\nAvailable States: " + String.valueOf(sdao.listCurrentStates()));
        String state = io.promptString("Please enter the state name or abbreviation: ").toLowerCase();
        state = getStateAbbreviations(state);
        if (sdao.isValidState(state)) {
            return sdao.getStates().get(state);
        } else {
            return askUserForState();
        }
    }

    private String getStateAbbreviations(String input) {

        Map<String, String> scm = StateConverter.getStateConversionMap();
        List<String> stateNames = new ArrayList<>();
        stateNames.addAll(scm.keySet());
        List<String> stateAbrvs = new ArrayList<>();
        stateAbrvs.addAll(scm.values());
        String inputName = capitalizeFirstLowerRest(input);
        String inputAbrvs = input.toUpperCase();
        if (stateNames.contains(inputName)) {
            return scm.get(inputName);
        } else if (stateAbrvs.contains(inputAbrvs)) {
            return inputAbrvs;
        } else {
            return "Invalid";
        }
    }

    private Product askUserForProduct() {
        io.println("\nAvailable Flooring Types: " + String.valueOf(pdao.listAllProducts()));
        String product = io.promptString("Please enter the type of flooring: ").toLowerCase();
        product = getProductName(product);
        if (pdao.isValidProduct(product)) {
            return pdao.getProducts().get(product);
        } else {
            return askUserForProduct();
        }
    }

    private String getProductName(String input) {

        List<String> productNames = pdao.listAllProducts();
        String name = "";
        for (String productName : productNames) {
            if (productName.toLowerCase().equals(input)) {
                name = productName;
            }
        }
        if (name.equals("")) {
            name = "Invalid";
        }
        return name;
    }

    private void printAvailableDates() {
        List<Date> dateList = odao.listDates();
        Collections.sort(dateList);
        io.println("\nList of available dates: ");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        for (Date date : dateList) {
            io.println(sdf.format(date));
        }
    }

    private String capitalizeFirstLowerRest(String text) {
        String[] array = text.split(" ");
        String capitalized = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > 1) {
                array[i] = array[i].substring(0, 1).toUpperCase() + array[i].substring(1).toLowerCase();
            } else {
                array[i] = array[i].substring(0).toUpperCase();
            }
        }
        if (array.length > 1) {
            capitalized = String.join(" ", array);
        } else if (array.length == 1) {
            capitalized = array[0];
        }
        return capitalized;
    }

}
