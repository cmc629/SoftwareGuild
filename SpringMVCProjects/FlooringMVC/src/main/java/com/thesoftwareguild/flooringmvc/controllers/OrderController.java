/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmvc.controllers;

import com.thesoftwareguild.flooringmvc.daos.OrderDao;
import com.thesoftwareguild.flooringmvc.daos.ProductDao;
import com.thesoftwareguild.flooringmvc.daos.StateDao;
import com.thesoftwareguild.flooringmvc.models.Order;
import com.thesoftwareguild.flooringmvc.models.OrderForm;
import com.thesoftwareguild.flooringmvc.models.Product;
import com.thesoftwareguild.flooringmvc.models.State;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chris Myung
 */
@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    private OrderDao odao;
    private ProductDao pdao;
    private StateDao sdao;

    @Inject
    public OrderController(OrderDao odao, ProductDao pdao, StateDao sdao) {
        this.odao = odao;
        this.pdao = pdao;
        this.sdao = sdao;

        pdao.load();
        sdao.load();

    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String addOrder(Model model) {

        model.addAttribute("orderForm", new OrderForm());

        List<String> products = pdao.listAllProducts();
        List<String> states = sdao.listCurrentStates();

        model.addAttribute("products", products);
        model.addAttribute("states", states);

        return "addOrder";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute OrderForm orderForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<String> products = pdao.listAllProducts();
            List<String> states = sdao.listCurrentStates();

            model.addAttribute("products", products);
            model.addAttribute("states", states);

            return "addOrder";
        }

        State state = sdao.getStates().get(orderForm.getStateName());
        Product product = pdao.getProducts().get(orderForm.getProductName());

        Order order = new Order(orderForm.getCustomerName(), orderForm.getDate(), product, state, orderForm.getArea());

        odao.create(order);

        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{orderNumber}", method = RequestMethod.GET)
    public String delete(@PathVariable("orderNumber") Integer orderNumber) {

        odao.delete(orderNumber);

        return "redirect:/";

    }

    @RequestMapping(value = "/edit/{orderNumber}", method = RequestMethod.GET)
    public String editOrder(@PathVariable("orderNumber") Integer orderNumber, Model model) {

        Order order = odao.get(orderNumber);

        OrderForm orderForm = new OrderForm(order.getCustomerName(), order.getDate(),
                order.getProduct().getProductName(), order.getState().getStateName(),
                order.getArea(), order.getOrderNumber());

        List<String> products = pdao.listAllProducts();
        List<String> states = sdao.listCurrentStates();

        model.addAttribute("products", products);
        model.addAttribute("states", states);
        model.addAttribute("orderForm", orderForm);

        return "editOrder";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute OrderForm orderForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "editOrder";
        }

        State state = sdao.getStates().get(orderForm.getStateName());
        Product product = pdao.getProducts().get(orderForm.getProductName());
        Order order = new Order(orderForm.getCustomerName(), orderForm.getDate(), product, state, orderForm.getArea());
        order.setOrderNumber(orderForm.getOrderNumber());

        odao.update(order);

        return "redirect:/";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id, Model model) {

        Order order = odao.get(id);

        String materialCost = String.format("$ %.2f", order.getOrderMaterialCost());
        String laborCost = String.format("$ %.2f", order.getOrderLaborCost());
        double sub = order.getOrderLaborCost() + order.getOrderMaterialCost();
        String subtotal = String.format("$ %.2f", sub);
        String tax = String.format("%.2f", order.getOrderTax());
        String total = String.format("$ %.2f", order.getOrderTotal());

        model.addAttribute("order", order);
        model.addAttribute("materialCost", materialCost);
        model.addAttribute("laborCost", laborCost);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("tax", tax);
        model.addAttribute("total", total);

        return "view";

    }

}
