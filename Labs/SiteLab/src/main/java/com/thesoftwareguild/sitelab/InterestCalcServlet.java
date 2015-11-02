/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.sitelab;

import com.thesoftwareguild.interestcalculator.InterestCalculator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian Choi
 */
@WebServlet(name = "InterestCalcServlet", urlPatterns = {"/InterestCalcServlet"})
public class InterestCalcServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("interestcalc.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String initialString = request.getParameter("initial");
        float initial = Float.parseFloat(initialString);
        
        String rateString = request.getParameter("rate");
        float rate = Float.parseFloat(rateString);
        
        String yearString = request.getParameter("years");
        int year = Integer.parseInt(yearString);
        
        String compoundString = request.getParameter("compound");
        int compound = 0;
        
        if (compoundString.equals("quarterly")) {
            compound = 4;
        }
        if (compoundString.equals("monthly")) {
            compound = 12;
        }
        if (compoundString.equals("daily")) {
            compound = 365;
        }
        
        InterestCalculator ic = new InterestCalculator(initial, rate, year, compound);
        //This will contains our results that we'll pass on
        Map<Integer, List<String>> result = new HashMap<>();
        
        float currentBalance = ic.getInitialPrincipal(); //set current balance to initial principal
        float totalInterest;
        int yrCount = 1;
        
        while (yrCount <= year) {
            int compoundCount = 1;
            
            currentBalance = ic.getCurrentBalance(compoundCount, ic.getCompound(), currentBalance, ic.getAnnualInterestRate());
            totalInterest = currentBalance - ic.getInitialPrincipal();
            
            List<String> yearInfo = new ArrayList<>();
            yearInfo.add(0, String.format("$%.2f", ic.getInitialPrincipal()));
            yearInfo.add(1, String.format("$%.2f",totalInterest));
            yearInfo.add(2, String.format("$%.2f",currentBalance));
            
            result.put(yrCount, yearInfo);

            ic.setInitialPrincipal(currentBalance); //Set the initial principal to the ending balance as you loop into the next year
            yrCount += 1;
        }
        
        request.setAttribute("result", result);
        
        RequestDispatcher rd = request.getRequestDispatcher("icresponse.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
