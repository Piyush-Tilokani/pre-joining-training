function validateLoginForm() {
    const email = document.getElementById("loginEmail").value.trim();
    const password = document.getElementById("loginPassword").value;

    if (!email.includes("@") || !email.includes(".")) {
        alert("Please enter a valid email address.");
        return false;
    }

    if (password.length < 6) {
        alert("Password must be at least 6 characters.");
        return false;
    }

    return true;
}

function validateRegisterForm() {
    const name = document.getElementById("regName").value.trim();
    const email = document.getElementById("regEmail").value.trim();
    const password = document.getElementById("regPassword").value;

    const emailRegex = /^[^@\s]+@[^@\s]+\.[^@\s]+$/;
    const passRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[\W_]).{8,16}$/;

    if (name.length < 3) {
        alert("Name must be at least 3 characters.");
        return false;
    }

    if (!emailRegex.test(email)) {
        alert("Enter a valid email.");
        return false;
    }

    if (!passRegex.test(password)) {
        alert("Password must be 8-16 characters, include upper/lowercase, a number, and special character.");
        return false;
    }

    return true;
}