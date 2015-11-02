/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenaddressbook;

import com.thesoftwareguild.mavenaddressbook.controllers.AddressBookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Christian Choi
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AddressBookController abc = ctx.getBean("addressBookController", AddressBookController.class);
        abc.run();
    }

}
