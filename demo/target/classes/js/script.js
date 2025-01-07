document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (email === '' || password === '') {
        alert('Please fill in all fields');
    } else {
        // Proceed with login logic
        alert('Login successful');
    }
});

document.getElementById('register-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (username === '' || email === '' || password === '') {
        alert('Please fill in all fields');
    } else {
        // Proceed with registration logic
        alert('Registration successful');
    }
});

function editProfile() {
    // Logic to enable editing of user profile
    document.getElementById('username').disabled = false;
    document.getElementById('email').disabled = false;
}