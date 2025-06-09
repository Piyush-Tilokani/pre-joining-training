// Form validation using JavaScript
document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("registrationForm");

  form.addEventListener("submit", (event) => {
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();

    // Check for valid name
    if (name.length < 3) {
      alert("Full name must be at least 3 characters long.");
      event.preventDefault();
      return;
    }

    // Basic email format validation
    if (!email.includes("@") || !email.includes(".")) {
      alert("Please enter a valid email address.");
      event.preventDefault();
      return;
    }

    // All validations passed
    alert("Form submitted successfully!");
  });
});
