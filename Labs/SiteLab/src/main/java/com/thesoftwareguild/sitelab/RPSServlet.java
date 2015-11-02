/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.sitelab;

import com.thesoftwareguild.rps.Computer;
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
@WebServlet(name = "RPSServlet", urlPatterns = {"/RPSServlet"})
public class RPSServlet extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("rps.jsp");
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
        
        Computer comp = new Computer();
        String compChoice = comp.getChoice();
        String userChoice = "";
        String message = "";
        
        if (request.getParameter("rock") != null) {
            userChoice = "rock";
            switch (compChoice) {
                case "rock":
                    message = "It's a tie!";
                    break;
                case "paper":
                    message = "The computer wins!";
                    break;
                case "scissors":
                    message = "You win!";
                    break;
            }
        }
        if (request.getParameter("paper") != null) {
            userChoice = "paper";
            switch (compChoice) {
                case "rock":
                    message = "You win!";
                    break;
                case "paper":
                    message = "It's a tie!";
                    break;
                case "scissors":
                    message = "The computer wins!";
                    break;
            }
        }
        if (request.getParameter("scissors") != null) {
            userChoice = "scissors";
            switch (compChoice) {
                case "rock":
                    message = "The computer wins!";
                    break;
                case "paper":
                    message = "You win!";
                    break;
                case "scissors":
                    message = "It's a tie!";
                    break;
            }
        }
        
        request.setAttribute("compChoice", compChoice);
        request.setAttribute("userChoice", userChoice);
        request.setAttribute("message", message);
        
        RequestDispatcher rd = request.getRequestDispatcher("rpsresponse.jsp");
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
