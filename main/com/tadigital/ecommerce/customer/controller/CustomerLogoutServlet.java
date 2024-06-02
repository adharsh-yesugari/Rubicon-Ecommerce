package main.com.tadigital.ecommerce.customer.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class CustomerLogoutServlet extends HttpServlet {
    /**
     * This method is overrided from HttpServlet class & used to handle post request
     *
     * @param request  is a HttpServletRequest object and passed it as an argument
     *                 to the doGet method,it represents a request.
     * @param response is a HttpServletResponse object and passed it as an argument
     *                 to the doGet method,it represents a response.
     * @return void.
     * @throws ServletException - if the HTTP requestcannot be handled.
     * @throws IOException      - if an input or output error occurs while the
     *                          servlet is handling the HTTP request.
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        response.setStatus(201);
        dispatcher.forward(request, response);
    }
}

