package main.com.tadigital.ecommerce.customer.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import main.com.tadigital.ecommerce.customer.entity.ContactDetailsUpdate;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.service.CustomerService;
import main.com.tadigital.ecommerce.customer.service.CustomerServiceImplementation;

import java.io.IOException;

@WebServlet("/contact")
public class ContactDetailsUpdateServlet extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProfileUpdation.jsp");
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
        RequestDispatcher dispatcher = null;

        String customerEmail = request.getParameter("email");
        String mobileNumber = request.getParameter("mobile");

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("CUSTOMERINFORMATION");
        ContactDetailsUpdate contact = new ContactDetailsUpdate(customerEmail, mobileNumber);

        contact.setID(customer.getId());

        boolean status = customerService.contactDetailsUpdate(contact);

        if (status) {
            response.setStatus(202);
        } else {
            response.setStatus(402);
        }

        dispatcher = request.getRequestDispatcher("ProfileUpdation.jsp");
        dispatcher.forward(request, response);
    }
}

