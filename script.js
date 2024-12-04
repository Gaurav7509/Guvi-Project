document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Thank you for your message! We will get back to you soon.');
});

document.getElementById('addPropertyForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const name = document.getElementById('propertyName').value;
    const location = document.getElementById('propertyLocation').value;
    const price = document.getElementById('propertyPrice').value;
    const area = document.getElementById('propertyArea').value;

    addProperty(name, location, price, area);

    // Clear the form fields
    document.getElementById('addPropertyForm').reset();
});

function addProperty(name, location, price, area) {
    const propertyList = document.getElementById('propertyList');
    
    const propertyDiv = document.createElement('div');
    propertyDiv.className = 'property';
    
    propertyDiv.innerHTML = `
        <h3>${name}</h3>
        <p>Location: ${location}</p>
        <p>Price: ${price}</p>
        <p>Area: ${area}</
