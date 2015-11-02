package com.thesoftwareguild.flooringmvc.controllers;

import com.thesoftwareguild.flooringmvc.daos.OrderDao;
import com.thesoftwareguild.flooringmvc.daos.ProductDao;
import com.thesoftwareguild.flooringmvc.daos.StateDao;
import com.thesoftwareguild.flooringmvc.models.Order;
import com.thesoftwareguild.flooringmvc.models.OrderForm;
import com.thesoftwareguild.flooringmvc.models.Product;
import com.thesoftwareguild.flooringmvc.models.State;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private OrderDao odao;
    private ProductDao pdao;
    private StateDao sdao;

    @Inject
    public HomeController(OrderDao odao, ProductDao pdao, StateDao sdao) {
        this.odao = odao;
        this.pdao = pdao;
        this.sdao = sdao;
        
        pdao.load();
        sdao.load();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        
        Map<Date, List<Order>> orderMap = odao.orderMapByDate();
        Map<Date , List<Order>> treeOrderMap = new TreeMap<>(orderMap);
        model.addAttribute("orderMap", treeOrderMap);
        
        model.addAttribute("orderForm", new OrderForm());
        
        List<String> products = pdao.listAllProducts();
        List<String> states = sdao.listCurrentStates();

        model.addAttribute("products", products);
        model.addAttribute("states", states);
        
        return "index";
        
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Order addOrder(@Valid @RequestBody OrderForm orderForm) {
        
        State state = sdao.getStates().get(orderForm.getStateName());
        Product product = pdao.getProducts().get(orderForm.getProductName());

        Order order = new Order(orderForm.getCustomerName(), orderForm.getDate(), product, state, orderForm.getArea());

        Order addedOrder = odao.create(order);
        
        return addedOrder;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order getOrder(@PathVariable("id") Integer id) {
        
        Order order = odao.get(id);
        
        return order;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Order editOrder(@Valid @RequestBody OrderForm orderForm) {
        
        State state = sdao.getStates().get(orderForm.getStateName());
        Product product = pdao.getProducts().get(orderForm.getProductName());
        Order order = new Order(orderForm.getCustomerName(), orderForm.getDate(), product, state, orderForm.getArea());
        order.setOrderNumber(orderForm.getOrderNumber());
        
        odao.update(order);
        
        
        return order;
    }
}
