/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Christian Choi
 */
public class Lambdas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Server> servers = new ArrayList<>();
        
        Server one = new Server();
        one.setName("Server 1");
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setRam("8GB");
        one.setNumberOfProcessors(6);
        one.setPurchaseDate(new Date());
        
        Server two = new Server();
        two.setName("Server 2");
        two.setIp("192.168.1.2");
        two.setMake("Hp");
        two.setRam("4GB");
        two.setNumberOfProcessors(1);
        two.setPurchaseDate(new Date());
        
        Server three = new Server();
        three.setName("Server 3");
        three.setIp("192.168.1.3");
        three.setMake("IBM");
        three.setRam("16GB");
        three.setNumberOfProcessors(8);
        three.setPurchaseDate(new Date());
        
        Server four = new Server();
        four.setName("Server 4");
        four.setIp("192.168.1.4");
        four.setMake("Dell");
        four.setRam("2GB");
        four.setNumberOfProcessors(2);
        four.setPurchaseDate(new Date());
        
        servers.add(one);
        servers.add(two);
        servers.add(three);
        servers.add(four);
        
        
        List<Server> matches = new ArrayList<>();
        for (Server server: servers) {
            
            if("Dell".equals(server.getMake())) {
                matches.add(server);
            }
            
        }
        
        //if we have many conditions, this could become tedious. Use streams
        
        //stream understand what lambdas are. lists have no idea
        List<Server> matchesLambda = servers.stream()
                .filter(s -> s.getMake().equals("Dell")) 
                .collect(Collectors.toList());
        
        
        servers.stream()
                .filter(s -> s.getMake().equals("Dell")) //first filter out the one we want to match
                .forEach(s -> { //kind of works like an enhanced for loop
                    
                    System.out.println(s.getIp());
                    System.out.println(s.getNumberOfProcessors());
                    
                });
        
        
//        //print out all server names older than a day
//        Date lastWeek = new Date(); //pretend this is last week
        
        List<Server> matches3 = servers.stream()
                .filter(s -> s.getNumberOfProcessors() > 2)
                .collect(Collectors.toList());
        
        
        double averageProcessors = servers
                .stream()
                .mapToInt(Server::getNumberOfProcessors)
                .average()
                .getAsDouble();
    }
    
}
