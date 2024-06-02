package main.com.tadigital.ecommerce.customer.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import main.com.tadigital.ecommerce.customer.entity.AddressDetails;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.service.CustomerService;
import main.com.tadigital.ecommerce.customer.service.CustomerServiceImplementation;

import java.io.IOException;

@WebServlet("/address")
public class AddressDetailsUpdateServlet extends HttpServlet {

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

        String addressLine1 = request.getParameter("line1");
        String addressLine2 = request.getParameter("line2");
        String addressLine3 = request.getParameter("line3");
        String postalCode = request.getParameter("pin");
        String state = request.getParameter("state");
        String city = request.getParameter("city");

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("CUSTOMERINFORMATION");
        AddressDetails addressDetails = new AddressDetails(addressLine1, addressLine2, addressLine3, postalCode, state,
                city);

        addressDetails.setCustomerID(customer.getId());

        boolean status = customerService.addressDetailsInsert(addressDetails);

        if (status) {
            response.setStatus(203);
        } else {
            response.setStatus(403);
        }

        dispatcher = request.getRequestDispatcher("ProfileUpdation.jsp");
        dispatcher.forward(request, response);
    }
}
