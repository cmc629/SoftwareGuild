/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.sitelab;

import com.thesoftwareguild.factorizer.Factorizer;
import java.io.IOException;
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
@WebServlet(name = "FactorizerServlet", urlPatterns = {"/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("factorizer.jsp");
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
        
        String num = request.getParameter("number");
        int factorize = Integer.parseInt(num);
        
        Factorizer result = new Factorizer(factorize);
        
        int[] factors = result.getFactorArray();
        
        int factorSum = result.getFactorSum();
        
        boolean isPrime = result.isPerfect(factorize, factorSum);
        boolean isPerfect = result.isPerfect(factorize, factorSum);
        
        String primeMessage;
        String perfectMessage;
        
        if (isPrime) {
            primeMessage = "prime";
        } else {
            primeMessage = "not prime";
        }
        
        if (isPerfect) {
            perfectMessage = "perfect";
        } else {
            perfectMessage = "not perfect";
        }
        
        request.setAttribute("number", factorize);
        request.setAttribute("factors", factors);
        request.setAttribute("primeMessage", primeMessage);
        request.setAttribute("perfectMessage", perfectMessage);
        
        RequestDispatcher rd = request.getRequestDispatcher("factresponse.jsp");
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
