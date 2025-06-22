document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("registrationForm");
  const dobInput = document.getElementById("dob");
  const ageInput = document.getElementById("age");
  const passwordInput = document.getElementById("password");
  const submitBtn = document.getElementById("submitBtn");

  const rules = {
    length: document.getElementById("ruleLength"),
    upper: document.getElementById("ruleUpper"),
    lower: document.getElementById("ruleLower"),
    number: document.getElementById("ruleNumber"),
    special: document.getElementById("ruleSpecial"),
  };

  // Enable Bootstrap tooltips
  $(function () {
    $('[data-toggle="tooltip"]').tooltip();
  });

  // Calculate age and validate minimum age
  dobInput.addEventListener("change", () => {
    const dob = new Date(dobInput.value);
    if (!isNaN(dob)) {
      const diffMs = Date.now() - dob.getTime();
      const ageDate = new Date(diffMs);
      const age = Math.abs(ageDate.getUTCFullYear() - 1970);
      ageInput.value = age;

      if (age < 18) {
        $(ageInput).tooltip("show");
        submitBtn.disabled = true;
      } else {
        $(ageInput).tooltip("hide");
        submitBtn.disabled = false;
      }
    }
  });

  // Password validation
  passwordInput.addEventListener("input", () => {
    const value = passwordInput.value;

    const checks = {
      length: value.length >= 8 && value.length <= 16,
      upper: /[A-Z]/.test(value),
      lower: /[a-z]/.test(value),
      number: /[0-9]/.test(value),
      special: /[!@#$%^&*(),.?":{}|<>]/.test(value),
    };

    for (const rule in checks) {
      rules[rule].classList.toggle("text-success", checks[rule]);
      rules[rule].classList.toggle("text-danger", !checks[rule]);
      rules[rule].textContent = `${checks[rule] ? "✓" : "✗"} ${rules[rule].textContent.slice(2)}`;
    }
  });

  // Form submission
  form.addEventListener("submit", (event) => {
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = passwordInput.value;
    const age = parseInt(ageInput.value);

    if (name.length < 3) {
      alert("Full name must be at least 3 characters long.");
      event.preventDefault();
      return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      alert("Please enter a valid email address.");
      event.preventDefault();
      return;
    }

    const isValidPassword =
      password.length >= 8 &&
      password.length <= 16 &&
      /[A-Z]/.test(password) &&
      /[a-z]/.test(password) &&
      /[0-9]/.test(password) &&
      /[!@#$%^&*(),.?":{}|<>]/.test(password);

    if (!isValidPassword) {
      alert("Password does not meet all the required conditions.");
      event.preventDefault();
      return;
    }

    if (isNaN(age) || age < 18) {
      alert("User must be at least 18 years old.");
      event.preventDefault();
      return;
    }

    alert("Form submitted successfully!");
  });
});