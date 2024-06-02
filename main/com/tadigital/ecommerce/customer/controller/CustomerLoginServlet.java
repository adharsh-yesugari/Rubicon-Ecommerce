package main.com.tadigital.ecommerce.customer.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import main.com.tadigital.ecommerce.customer.dao.CustomerDatabaseImplementation;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.service.CustomerService;
import main.com.tadigital.ecommerce.customer.service.CustomerServiceImplementation;

import java.io.IOException;

@WebServlet("/login")
public class CustomerLoginServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImplementation();
    private HttpServletRequest request;
    private HttpServletResponse response;

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
        this.request = request;
        this.response = response;
        RequestDispatcher dispatcher = null;

        HttpSession session = request.getSession();
        String cookieStatus = (String) session.getAttribute("COOKIESTATUS");

        if (!(cookieStatus == null)) {
            if (cookieStatus.equals("FOUND")) {
                String keepSignedIn = (String) session.getAttribute("COOKIVALUE");
                Customer customer = new Customer(keepSignedIn);
                CustomerDatabaseImplementation customerDaoImplementation = new CustomerDatabaseImplementation();
                Customer status = customerDaoImplementation.findCustomerByEmailId(customer);

                if (status != null) {
                    String name = status.getFirstName() + " " + status.getLastName();
                    session.setAttribute("CUSTOMERNAME", name);
                    session.setAttribute("CUSTOMEREMAILID", keepSignedIn);
                    session.setAttribute("CUSTOMERINFORMATION", status);
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                dispatcher = request.getRequestDispatcher("SignInSignUpForm.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            dispatcher = request.getRequestDispatcher("SignInSignUpForm.jsp");
            dispatcher.forward(request, response);
        }
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
        String customerEmail = request.getParameter("email");
        String customerPassword = request.getParameter("password");
        String status = request.getParameter("staySignedIn");

        HttpSession session = request.getSession();
        session.setAttribute("EMIAL", customerEmail);

        Customer customer = new Customer(customerEmail, customerPassword);

        // CustomerDao customerDao = new CustomerDao();
        // Customer result = customerDao.searchCustomerByEmailAndPassword(customer);
        Customer result = customerService.loginCustomer(customer);

        RequestDispatcher dispatcher = null;

        if (result != null) {
            String customerName = result.getFirstName() + " " + result.getLastName();
            session = request.getSession();
            session.setAttribute("USERNAME", customerName);
            session.setAttribute("CUSTOMERINFORMATION", result);
            response.setStatus(201);

            if (status != null) {
                Cookie cookie = new Cookie("taEcommerce", customerEmail);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);

            }

            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            response.setStatus(401);
            dispatcher = request.getRequestDispatcher("SignInSignUpForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}
