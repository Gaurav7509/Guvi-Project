<%@ page import="java.util.List" %>
<%@ page import="model.Property" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Real Estate Management</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Real Estate Management</h1>
    </header>

    <section id="properties">
        <h2>Available Properties</h2>
        <div class="property-list">
            <% 
                List<Property> properties = (List<Property>) request.getAttribute("properties");
                if (properties != null && !properties.isEmpty()) {
                    for (Property property : properties) {
            %>
                <div class="property">
                    <h3><%= property.getName() %></h3>
                    <p><strong>Location:</strong> <%= property.getLocation() %></p>
                    <p><strong>Price:</strong> Rs<%= property.getPrice() %></p>
                    <p><strong>Area:</strong> <%= property.getArea() %> sqft</p>
                </div>
            <% } else { %>
                <p>No properties available.</p>
            <% } %>
        </div>

        <h3>Add New Property</h3>
        <form action="properties" method="POST">
            <input type="text" name="name" placeholder="Property Name" required>
            <input type="text" name="location" placeholder="Location" required>
            <input type="number" step="0.01" name="price" placeholder="Price" required>
            <input type="number" step="0.01" name="area" placeholder="Area (sqft)" required>
            <button type="submit">Add Property</button>
        </form>
    </section>

    <footer>
        <p>&copy; 2023 Real Estate Management</p>
    </footer>
</body>
</html>
