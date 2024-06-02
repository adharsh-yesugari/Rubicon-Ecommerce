package main.com.tadigital.ecommerce.customer.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import main.com.tadigital.ecommerce.customer.dao.CustomerDatabase;
import main.com.tadigital.ecommerce.customer.dao.CustomerDatabaseImplementation;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.service.CustomerService;
import main.com.tadigital.ecommerce.customer.service.CustomerServiceImplementation;

import java.io.IOException;

@WebServlet("/password")

public class PasswordUpdation extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImplementation();

    /**
     * This method is overrided from HttpServlet class & used to handle get request
     *
     * @param request  is a HttpServletRequest object and passed it as an argument
     *                 to the doGet method,it represents a request.
     * @param response is a HttpServletResponse object and passed it as an argument
     *                 to the doGet method,it represents a response.
     * @return void.
     * @throws ServletException - if the HTTP request cannot be handled.
     * @throws IOException      - if an input or output error occurs while the
     *                          servlet is handling the HTTP request.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("passwordUpdation.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * This method is overrided from HttpServlet class & used to handle post request
     *
     * @param request  is a HttpServletRequest object and passed it as an argument
     *                 to the doGet method,it represents a request.
     * @param response is a HttpServletResponse object and passed it as an argument
     *                 to the doGet method,it represents a response.
     * @return void.
     * @throws ServletException - if the HTTP request cannot be handled.
     * @throws IOException      - if an input or output error occurs while the
     *                          servlet is handling the HTTP request.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String oldPassword = request.getParameter("existingPassword");
        String newPassword = request.getParameter("updatedPassword");
        String newPasswordRetyped = request.getParameter("upadatedPasswordRetyped");

        HttpSession session = request.getSession();
        Customer customer1 = (Customer) session.getAttribute("CUSTOMERINFORMATION");
        System.out.println(customer1);
        int id = customer1.getId();
        String originalPassword = customer1.getPassword();
        RequestDispatcher dispatcher = null;
        Customer customer = new Customer(id, newPassword);
        CustomerDatabase customerDao = new CustomerDatabaseImplementation();
        System.out.println(id + "----------" + originalPassword);
        System.out.println(oldPassword);
        System.out.println(newPassword);
        System.out.println(newPasswordRetyped);
        if (newPassword.equals(newPasswordRetyped) && originalPassword.equals(oldPassword)) {
            System.out.println("condition success");

            boolean status = customerService.passwordUpdation(customer);

            System.out.println("Method Called" + status);
            if (status) {

                session.invalidate();

                Cookie[] allCookies = request.getCookies();
                for (Cookie cookie : allCookies) {
                    String cookieName = cookie.getName();
                    if (cookieName.equals("taEcommerce")) {
                        cookie.setValue(" ");
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);

                    }
                }

                response.setStatus(201);
                dispatcher = request.getRequestDispatcher("passwordUpdation.jsp");

            } else {
                response.setStatus(400);
                dispatcher = request.getRequestDispatcher("passwordUpdation.jsp");

            }
        } else {
            response.setStatus(400);
            dispatcher = request.getRequestDispatcher("passwordUpdation.jsp");

        }
        dispatcher.forward(request, response);
    }
}

