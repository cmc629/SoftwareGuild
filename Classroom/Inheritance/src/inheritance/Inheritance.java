/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

import java.util.ArrayList;
import java.util.List;
import models.Auditable;
import models.DTO;
import models.Employee;
import models.HiringManager;
import models.Intern;
import models.Manager;

/**
 *
 * @author Christian Choi
 */
public class Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Employee employee = new Employee();
//        
//        employee.doWork();
//        employee.createObjectives();
        
//        Manager manager = new Manager();
//        manager.createObjectives();
//        manager.doWork();
        
//        Employee manager2 = new Manager();
//        Employee intern = new Intern();
//        Employee hiringManager = new HiringManager();
//        
//        manager2.setFirstName("The");
//        manager2.setLastName("Manager");
//        
//        intern.setFirstName("Interny");
//        intern.setLastName("Internison");
//        
//        hiringManager.setFirstName("Bill");
//        hiringManager.setLastName("Jones");
//        
//        List<Employee> employees = new ArrayList<>();
//        
//        employees.add(manager2);
//        employees.add(intern);
//        employees.add(hiringManager);
//        
//        for (Employee employee : employees) {
//            employee.doWork();
//            //employee.createObjectives();
//        }
        Employee manager = new Manager();
        manager.doWork();
        
        Auditable employee = new Manager();
        Auditable intern = new Intern();
        
//        FakeDAO dao = new FakeDAO();
//        dao.saveDTO(employee);
        
        Auditor auditor = new Auditor();
        auditor.auditChange(employee);
        auditor.auditChange(intern);
    }
    
}
