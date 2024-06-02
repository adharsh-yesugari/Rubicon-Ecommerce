package main.com.tadigital.ecommerce.customer.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import main.com.tadigital.ecommerce.customer.dao.CustomerDatabase;
import main.com.tadigital.ecommerce.customer.dao.CustomerDatabaseImplementation;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.entity.PersonalDetails;
import main.com.tadigital.ecommerce.customer.service.CustomerService;
import main.com.tadigital.ecommerce.customer.service.CustomerServiceImplementation;

import java.io.IOException;

@WebServlet("/personal")
@MultipartConfig
public class PersonalDetailsUpdationServlet extends HttpServlet {
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

        Part part = request.getPart("profilePicture");
        String uploadFileName = part.getSubmittedFileName();
        String serverPath = getServletContext().getRealPath("") + "\\images\\";
        part.write(serverPath + uploadFileName);

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("date");

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("CUSTOMERINFORMATION");
        int customerID = customer.getId();

        PersonalDetails personalDetails = new PersonalDetails(customerID, uploadFileName, firstName, lastName, gender,
                dateOfBirth);
        CustomerDatabase customerDao = new CustomerDatabaseImplementation();
        boolean status = customerService.updatePersonalDetails(personalDetails);

        if (status) {
            String pictureInformation = customerDao.searchCustomerById(customerID);
            System.out.println("===================" + pictureInformation + "--------------");
            session.setAttribute("CUSTOMERPROFILEDATA", pictureInformation);
            response.setStatus(201);
        } else {
            response.setStatus(401);
        }
        dispatcher = request.getRequestDispatcher("ProfileUpdation.jsp");
        dispatcher.forward(request, response);

    }
}
