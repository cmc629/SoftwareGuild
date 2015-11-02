/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package city;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Christian Choi
 */
public class Cities {
    
    private List<City> cities = new ArrayList<>();
    
    public void addCities() {
        
        City ny = new City();
        ny.setName("New York");
        ny.setPop2010(8175133);
        ny.setPop2014(8491079);
        
        City la = new City();
        la.setName("Los Angeles");
        la.setPop2010(3792621);
        la.setPop2014(3928864);
        
        City chi = new City();
        chi.setName("Chicago");
        chi.setPop2010(2695598);
        chi.setPop2014(2722389);
        
        City hou = new City();
        hou.setName("Houston");
        hou.setPop2010(2100263);
        hou.setPop2014(2239558);
        
        City phi = new City();
        phi.setName("Philadelphia");
        phi.setPop2010(1526006);
        phi.setPop2014(1560297);
        
        City phx = new City();
        phx.setName("Phoenix");
        phx.setPop2010(1445632);
        phx.setPop2014(1537058);
        
        City sa = new City();
        sa.setName("San Antonio");
        sa.setPop2010(1327407);
        sa.setPop2014(1435597);
        
        City sd = new City();
        sd.setName("San Diego");
        sd.setPop2010(1307402);
        sd.setPop2014(1381069);
        
        City dal = new City();
        dal.setName("Dallas");
        dal.setPop2010(1197816);
        dal.setPop2014(1281047);
        
        City sj = new City();
        sj.setName("San Jose");
        sj.setPop2010(945942);
        sj.setPop2014(1015785);
        
        City aus = new City();
        aus.setName("Austin");
        aus.setPop2010(790390);
        aus.setPop2014(912791);
        
        City jac = new City();
        jac.setName("Jacksonville");
        jac.setPop2010(821784);
        jac.setPop2014(853382);
        
        City sf = new City();
        sf.setName("San Francisco");
        sf.setPop2010(805235);
        sf.setPop2014(852469);
        
        City ind = new City();
        ind.setName("Indianapolis");
        ind.setPop2010(820445);
        ind.setPop2014(848788);
        
        City col = new City();
        col.setName("Columbus");
        col.setPop2010(787033);
        col.setPop2014(835957);
        
        cities.add(ny);
        cities.add(la);
        cities.add(chi);
        cities.add(hou);
        cities.add(phi);
        cities.add(phx);
        cities.add(sa);
        cities.add(sd);
        cities.add(dal);
        cities.add(sj);
        cities.add(aus);
        cities.add(jac);
        cities.add(sf);
        cities.add(ind);
        cities.add(col);
        
    }
    
    
    public void printOver2M() {
        System.out.println("\nPrinting out the cities with 2014 population greater than 2 million:");
        cities.stream()
                .filter(c -> c.getPop2014() > 2000000)
                .forEach(c -> {
                    System.out.println(c.getName());
                });
        
        
    }
    
    public void printUnder1M() {
        System.out.println("\nPrinting out the cities with 2014 population less than 1 million:");
        cities.stream()
                .filter(c -> c.getPop2014() < 1000000)
                .forEach(c -> {
                    System.out.println(c.getName());
                });
    }
    
    public void printLeastGrowth() {
        System.out.println("\nPrinting out the city 2010-2014 growths from least to greatest:");
        cities.stream()
                .sorted((c1, c2) -> Integer.compare(c1.getPop2014() - c1.getPop2010(), c2.getPop2014() - c2.getPop2010()))
                .forEach(c -> System.out.println(String.format("%s | %d", c.getName(), (c.getPop2014()-c.getPop2010()))));
    }
    
    public void printMostGrowth() {
        System.out.println("\nPrinting out the city 2010-2014 growths from greatest to least:");
        cities.stream()
                .sorted(Collections.reverseOrder((c1, c2) -> Integer.compare(c1.getPop2014() - c1.getPop2010(), c2.getPop2014() - c2.getPop2010())))
                .forEach(c -> System.out.println(String.format("%s | %d", c.getName(), (c.getPop2014()-c.getPop2010()))));
    }
    
}
