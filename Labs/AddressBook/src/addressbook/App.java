/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import addressbook.controllers.AddressBookController;

/**
 *
 * @author Christian Choi & Damien Marble
 */
public class App {

    public static void main(String[] args) {
        new AddressBookController().run();
    }
}
