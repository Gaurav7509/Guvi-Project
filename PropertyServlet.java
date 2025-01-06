package servlet;

import dao.PropertyDao;
import model.Property;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/properties")
public class PropertyServlet extends HttpServlet {
    private PropertyDao propertyDao = new PropertyDao();

    // Handling GET request to retrieve all properties
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get all properties from the database using the PropertyDao
        List<Property> properties = propertyDao.getAllProperties();

        // Set the properties attribute in the request to pass to the JSP
        request.setAttribute("properties", properties);

        // Forward the request to the JSP page to display the properties
        request.getRequestDispatcher("/properties.jsp").forward(request, response);
    }

    // Handling POST request to add a new property
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get data from the form submission
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        double price = Double.parseDouble(request.getParameter("price"));
        float area = Float.parseFloat(request.getParameter("area"));

        // Create a new Property object
        Property property = new Property();
        property.setName(name);
        property.setLocation(location);
        property.setPrice(price);
        property.setArea(area);

        // Use PropertyDao to insert the new property into the database
        propertyDao.addProperty(property);

        // After the property is added, redirect back to the /properties URL (GET request)
        response.sendRedirect("properties");
    }
}
