package servlet;

import example.dao.UserDAO;
import example.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        User user = new User(name, email, role);
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(user);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
