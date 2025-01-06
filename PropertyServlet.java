import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

public class PropertyServlet extends HttpServlet {
    private PropertyDao propertyDao;

    @Override
    public void init() throws ServletException {
        super.init();
        propertyDao = new PropertyDao(); // Initialize PropertyDao
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String location = request.getParameter("location");
            double price = Double.parseDouble(request.getParameter("price"));
            float area = Float.parseFloat(request.getParameter("area"));

            Property property = new Property(name, location, price, area);
            propertyDao.addProperty(property);

            response.sendRedirect("properties");  // Redirect to the properties list page
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input for price or area.");
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding property to the database.");
        }
    }
}
