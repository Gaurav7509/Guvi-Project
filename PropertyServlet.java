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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Property> properties = propertyDao.getAllProperties();
        request.setAttribute("properties", properties);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        double price = Double.parseDouble(request.getParameter("price"));
        float area = Float.parseFloat(request.getParameter("area"));

        Property property = new Property();
        property.setName(name);
        property.setLocation(location);
        property.setPrice(price);
        property.setArea(area);
        
        propertyDao.addProperty(property);
        response.sendRedirect("properties");
    }
}
