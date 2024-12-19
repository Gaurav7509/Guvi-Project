// Function to display property details in an alert
function showDetails(name, location, price, area) {
    alert(`Property Details:\n\nName: ${name}\nLocation: ${location}\nPrice: ${price}\nArea: ${area}`);
}

// Handle the Add Property form submission
document.getElementById("addPropertyForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form from refreshing the page

    // Get input values
    const name = document.getElementById("propertyName").value;
    const location = document.getElementById("propertyLocation").value;
    const price = document.getElementById("propertyPrice").value;
    const area = document.getElementById("propertyArea").value;

    // Create a new property card
    const propertyList = document.getElementById("propertyList");
    const newProperty = document.createElement("div");
    newProperty.classList.add("property");

    newProperty.innerHTML = `
        <img src="https://via.placeholder.com/150" alt="${name}" class="property-image">
        <div class="property-details">
            <h3>${name}</h3>
            <p><strong>Location:</strong> ${location}</p>
            <p><strong>Price:</strong> ${price}</p>
            <p><strong>Area:</strong> ${area}</p>
            <button class="details-button" onclick="showDetails('${name}', '${location}', '${price}', '${area}')">View Details</button>
        </div>
    `;

    // Append the new property to the property list
    propertyList.appendChild(newProperty);

    // Reset the form
    document.getElementById("addPropertyForm").reset();
});

// Handle the Contact Us form submission
document.getElementById("contactForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form from refreshing the page

    // Get input values
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const message = document.getElementById("message").value;

    // Display a thank you message
    alert(`Thank you, ${name}! Your message has been sent. We will contact you at ${email} soon.`);
    
    // Reset the form
    document.getElementById("contactForm").reset();
});
