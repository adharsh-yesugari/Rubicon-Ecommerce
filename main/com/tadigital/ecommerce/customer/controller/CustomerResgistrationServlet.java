package main.com.tadigital.ecommerce.customer.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.service.CustomerService;
import main.com.tadigital.ecommerce.customer.service.CustomerServiceImplementation;

import java.io.IOException;

@WebServlet("/registration")
public class CustomerResgistrationServlet extends HttpServlet {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("SignInSignUpForm.jsp");
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

        String customernName = request.getParameter("name");
        String customerEmail = request.getParameter("email");
        String customernPassword = request.getParameter("password");

        String[] customerNameArray = customernName.split(" ");
        String customerFirstName = customerNameArray[0];
        String customerLastName = "";
        for (int i = 1; i < customerNameArray.length; i++) {
            customerLastName += customerNameArray[i] + " ";
        }

        Customer customer = new Customer(customerFirstName, customerLastName, customerEmail, customernPassword);
        boolean status = customerService.registerCustomer(customer);
        RequestDispatcher dispatcher = null;

        if (status) {
            response.setStatus(201);
            dispatcher = request.getRequestDispatcher("SignInSignUpForm.jsp");
            dispatcher.forward(request, response);
        } else {
            response.setStatus(400);
            dispatcher = request.getRequestDispatcher("SignInSignUpForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}
