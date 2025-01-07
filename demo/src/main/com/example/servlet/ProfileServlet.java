package example.servlet;

import example.dao.UserDAO;
import example.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser (email);

        req.setAttribute("user", user); // Set user data in request scope
        req.getRequestDispatcher("/WEB-INF/views/user-profile.jsp").forward(req, resp); // Forward to JSP
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String role = req.getParameter("role");

        UserDAO userDAO = new UserDAO();
        userDAO.updateUser (email, name, role);

        req.setAttribute("user", userDAO.getUser (email)); // Set updated user data
        req.getRequestDispatcher("/WEB-INF/views/user-profile.jsp").forward(req, resp); // Forward to JSP
    }
}