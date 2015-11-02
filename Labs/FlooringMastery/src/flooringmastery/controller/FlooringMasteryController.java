/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.controller;

import flooringmastery.daos.OrderDao;
import flooringmastery.daos.OrderDaoImpl;
import flooringmastery.daos.OrderDaoLambdaImpl;
import flooringmastery.daos.ProductDao;
import flooringmastery.daos.ProductDaoImpl;
import flooringmastery.daos.StateDao;
import flooringmastery.daos.StateDaoImpl;
import flooringmastery.dtos.Order;
import flooringmastery.dtos.Product;
import flooringmastery.dtos.State;
import flooringmastery.ui.ConsoleIO;
import flooringmastery.utility.StateConverter;
import java.io.FileNotFoundException;
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
    private OrderDao daoOrder = new OrderDaoLambdaImpl();
    private ProductDao daoProduct = new ProductDaoImpl();
    private StateDao daoState = new StateDaoImpl();

    public void run() {

        if (daoProduct instanceof ProductDaoImpl) {
            ((ProductDaoImpl) daoProduct).load();
        }
        if (daoState instanceof StateDaoImpl) {
            ((StateDaoImpl) daoState).load();
        }

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
        }
    }

    private void printMenu() {
        io.println("********************************************"); //44 asterisks
        io.println(String.format("%14sFlooring Program", ""));
        io.println(String.format("CURRENT ORDERS: %d", daoOrder.getOrders().size()));
        io.println("\n1. Display Orders\n2. Add an Order\n3. Edit an Order"
                + "\n4. Remove an Order\n5. Administrator Mode\n6. Quit");
        io.println("********************************************");

    }

    private void displayOrders() {
        io.println("Display orders by the date...");

        if (daoOrder.getOrders().isEmpty()) {
            io.println("\nThere are no orders to display!");
        } else {
            printAvailableDates();

            Date date = askUserForDate();

            List<Order> orderList = daoOrder.displayOrderByDate(date);

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
                daoOrder.create(order);
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
        if (daoOrder.getOrders().isEmpty()) {
            io.println("\nThere are no orders to display!");
        } else {
            printAvailableDates();

            Date date = askUserForDate();

            List<Order> orderList = daoOrder.displayOrderByDate(date);

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

                Order order = daoOrder.get(orderSelection);
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
                    io.println("\nAvailable States: " + String.valueOf(daoState.listCurrentStates()));
                    stateEdit = io.promptString(String.format("Enter state (%s): ",
                            order.getState().getStateName())).toLowerCase();
                    if (stateEdit.isEmpty()) {
                        editedOrder.setState(order.getState());
                        break;
                    } else {
                        stateEdit = getStateAbbreviations(stateEdit);
                        if (daoState.isValidState(stateEdit)) {
                            editedOrder.setState(daoState.getStates().get(stateEdit));
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
                    io.println("\nAvailable Flooring Types: " + String.valueOf(daoProduct.listAllProducts()));
                    productEdit = io.promptString(String.format("Enter product (%s): ",
                            order.getProduct().getProductName())).toLowerCase();
                    if (productEdit.isEmpty()) {
                        editedOrder.setProduct(order.getProduct());
                        break;
                    } else {
                        productEdit = getProductName(productEdit);
                        if (!productEdit.equals("Invalid")) {
                            editedOrder.setProduct(daoProduct.getProducts().get(productEdit));;
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
                    daoOrder.update(editedOrder);
                    io.println("\nChanges have been made!");
                } else {
                    io.println("\nChanges were not made.");
                }
            }
        }
    }

    private void removeOrder() {
        io.println("Removing an order...");
        if (daoOrder.getOrders().isEmpty()) {
            io.println("\nThere are no orders to display!");
        } else {
            printAvailableDates();

            Date date = askUserForDate();

            List<Order> orderList = daoOrder.displayOrderByDate(date);

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
                            Order removedOrder = daoOrder.get(orderSelection);
                            daoOrder.delete(orderSelection);
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
            ((StateDaoImpl) daoState).write();
            ((ProductDaoImpl) daoProduct).write();
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
            if (daoProduct.listAllProducts().contains(productName)) {
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
            daoProduct.create(product);
            io.println(String.format("\nProduct %s was added.", product.getProductName()));
        } else {
            io.println("\nProduct was not added.");
        }

    }

    private void editProduct() { //this will break if there are no products...solve easily using isEmpty() condition
        io.println("\nEditing product option...");
        if (!daoProduct.listAllProducts().isEmpty()) {
            io.println("Available flooring options: " + daoProduct.listAllProducts());
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
            Product product = daoProduct.getProducts().get(productName);

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
                    nameEdit = product.getProductName();
                    shouldContinue = true;
                } else {
                    if (daoProduct.listAllProducts().contains(nameEdit)) {
                        if (!nameEdit.equals(product.getProductName())) {
                            io.println("That product name already exists! Choose a different name.");
                        } else {
                            io.println("Name unchanged.");
                            shouldContinue = true;
                        }
                    } else {
                        shouldContinue = true;
                    }
                }
            }
            //Edit costPer
            Double cpEdit = io.promptDouble(String.format("\nEnter cost/SqFt (%.2f): ",
                    product.getCostPer()), 0, Double.MAX_VALUE);
            if (cpEdit.equals(Double.NaN)) {
                cpEdit = product.getCostPer();
            }
            //Edit laborCostPer
            Double lcpEdit = io.promptDouble(String.format("\nEnter labor cost/SqFt (%.2f): ",
                    product.getLaborCostPer()), 0, Double.MAX_VALUE);
            if (lcpEdit.equals(Double.NaN)) {
                lcpEdit = product.getLaborCostPer();
            }
            io.println("\nHere are your changes:");
            io.println(String.format("Product Name:\t\t%s --> %s",
                    product.getProductName(), nameEdit));
            io.println(String.format("Material Cost/SqFt:\t$%.2f --> $%.2f",
                    product.getCostPer(), cpEdit));
            io.println(String.format("Labor Cost/SqFt:\t$%.2f --> $%.2f",
                    product.getLaborCostPer(), lcpEdit));
            String commit = io.promptString("\nEnter 'yes' to commit to these changes. Enter anything else to cancel: ").toLowerCase();
            if (commit.equals("yes")) {
                if (product.getProductName().equals(nameEdit)) {
                    product.setCostPer(cpEdit);
                    product.setLaborCostPer(lcpEdit);
                } else {
                    Product productAdd = new Product();
                    productAdd.setProductName(nameEdit);
                    productAdd.setCostPer(cpEdit);
                    productAdd.setLaborCostPer(lcpEdit);
                    daoProduct.delete(product);
                    daoProduct.create(productAdd);
                }

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
        if (!daoProduct.listAllProducts().isEmpty()) {
            io.println("Available flooring options: " + daoProduct.listAllProducts());
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
                        if (daoOrder.containsProduct(productName)) {
                            io.println("This product was found amongst the current orders! Please choose a different product.");
                        } else {
                            isValid = true;
                            finalizeProcess = true;
                        }
                    }
                }
            }
            if (finalizeProcess) {
                Product product = daoProduct.getProducts().get(productName);
                String choice = io.promptString(String.format("\nEnter 'yes' to remove the product option %s. Hit anything else to cancel: ",
                        product.getProductName())).toLowerCase();
                if (choice.equals("yes")) {
                    Product removedProduct = daoProduct.delete(product);
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
        io.println("Current state options: " + daoState.listCurrentStates());
        boolean shouldContinue = false;
        String stateName = "";
        while (!shouldContinue) {
            stateName = io.promptString("\nPlease enter a US state name or abbreviation: ").toLowerCase();
            stateName = getStateAbbreviations(stateName);
            if (stateName.equals("Invalid")) {
                io.println("That's not a state in the US!");
            } else {
                if (daoState.getStates().containsKey(stateName)) {
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
            daoState.create(state);
            io.println(String.format("\nState %s was added.", state.getStateName()));
        } else {
            io.println("\nState was not added.");
        }

    }

    private void editState() {
        io.println("\nEditing state option...");
        if (!daoState.listCurrentStates().isEmpty()) {
            io.println("Current state options: " + daoState.listCurrentStates());
            boolean isValid = false;
            String stateName = "";
            while (!isValid) {
                String option = io.promptString("\nPlease enter the state option you would like to edit: ").toLowerCase();
                stateName = getStateAbbreviations(option);
                if (!daoState.isValidState(stateName)) {
                    io.println("State not found!");
                } else {
                    isValid = true;
                }
            }
            State state = daoState.getStates().get(stateName);

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
                    nameEdit = state.getStateName();
                    shouldContinue = true;
                } else {
                    nameEdit = getStateAbbreviations(nameEdit);
                    if (daoState.isValidState(nameEdit)) {
                        if (!nameEdit.equals(state.getStateName())) {
                            io.println("That state option already exists! choose a different state.");
                        } else {
                            io.println("State unchanged.");
                            shouldContinue = true;
                        }
                    } else {
                        if (nameEdit.equals("Invalid")) {
                            io.println("That state does not exist!");
                        } else {
                            shouldContinue = true;
                        }
                    }
                }
            }
            //Edit TaxRate
            Double trEdit = io.promptDouble(String.format("\nEnter tax rate (%.2f): ",
                    state.getTaxRate()), 0, Double.MAX_VALUE);
            if (trEdit.equals(Double.NaN)) {
                trEdit = state.getTaxRate();
            }
            //Show changes
            io.println("\nHere are your changes:");
            io.println(String.format("State:\t\t%s --> %s",
                    state.getStateName(), nameEdit));
            io.println(String.format("Tax Rate:\t%.2f%% --> %.2f%%",
                    state.getTaxRate(), trEdit));
            //Commit to changes?
            String commit = io.promptString("\nEnter 'yes' to commit to these changes. Enter anything else to cancel: ").toLowerCase();
            if (commit.equals("yes")) {
                if (state.getStateName().equals(nameEdit)) {
                    state.setTaxRate(trEdit);
                } else {
                    State stateAdd = new State();
                    stateAdd.setStateName(nameEdit);
                    stateAdd.setTaxRate(trEdit);
                    daoState.delete(state);
                    daoState.create(stateAdd);
                }
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
        if (!daoState.listCurrentStates().isEmpty()) {
            io.println("Current state options: " + daoState.listCurrentStates());
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
                    if (!daoState.isValidState(stateName)) {
                        io.println("State not found!");
                    } else {
                        if (daoOrder.containsState(stateName)) {
                            io.println("This state was found amongst the current orders! Please choose a different state.");
                        } else {
                            isValid = true;
                            finalizeProcess = true;
                        }
                    }
                }
            }
            if (finalizeProcess) {
                State state = daoState.getStates().get(stateName);
                String choice = io.promptString(String.format("\nEnter 'yes' to remove the state option %s. Hit anything else to cancel: ",
                        state.getStateName())).toLowerCase();
                if (choice.equals("yes")) {
                    State removedState = daoState.delete(state);
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
        io.println("AVAILABLE FLOORINGS: " + daoProduct.listAllProducts());
        io.println("AVAILABLE STATES: " + daoState.listCurrentStates());
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

        io.println("\nAvailable States: " + String.valueOf(daoState.listCurrentStates()));
        String state = io.promptString("Please enter the state name or abbreviation: ").toLowerCase();
        state = getStateAbbreviations(state);
        if (daoState.isValidState(state)) {
            return daoState.getStates().get(state);
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
        io.println("\nAvailable Flooring Types: " + String.valueOf(daoProduct.listAllProducts()));
        String product = io.promptString("Please enter the type of flooring: ").toLowerCase();
        product = getProductName(product);
        if (daoProduct.isValidProduct(product)) {
            return daoProduct.getProducts().get(product);
        } else {
            return askUserForProduct();
        }
    }

    private String getProductName(String input) {

        List<String> productNames = daoProduct.listAllProducts();
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
        List<Date> dateList = daoOrder.listDates();
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
