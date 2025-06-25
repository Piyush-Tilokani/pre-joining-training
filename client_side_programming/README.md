# Client Side Programming

This folder contains a complete example of a responsive client-side registration form using **HTML**, **CSS**, **JavaScript**, and **Bootstrap**.

## Development Environment

- **Editor**: VSCode 1.101.1
- **Languages Used**: HTML5, CSS3, JavaScript (ES6)
- **Frameworks/Libraries**:
  - Bootstrap 3.4.1 (via CDN)
  - jQuery (for Bootstrap tooltip support)

## How to Run

1. Clone the repository.
2. Navigate to the `client_side_programming/` directory.
3. Open the `src/index.html` file in any web browser.

## Folder Structure

```
client_side_programming/
└── src/
    ├── index.html
    ├── js/
    │   └── script.js
    └── css/
        └── style.css
```

## Topics Demonstrated

### 1. HTML

- Uses `<form>` with validation attributes like `required`, `minlength`, `readonly`, `type="email"`, `type="date"`, etc.
- Input elements include:
  - Text
  - Email
  - Date
  - Number (readonly age)
  - Password
  - Radio buttons (Gender)
  - Checkbox (Subscribe)
- `data-toggle="tooltip"` is used to enable tooltip for the age validation.

### 2. CSS

- Custom styling in `style.css` using:
  - Font settings, padding, background color
  - Form layout design (centering, border-radius, box-shadow)
- Bootstrap 3.4.1 classes used:
  - `form-control`, `form-group`
  - `btn`, `btn-primary`, `btn-block`
  - `text-danger`, `text-success`, `text-center`
  - `container`, `col-md-6`, `col-md-offset-3`

### 3. JavaScript

All validations and dynamic behavior are implemented in `script.js`:

- **Tooltip Activation**: Bootstrap tooltips for invalid age.
- **Age Calculation**: Based on Date of Birth input.
  - Shows tooltip and disables submission if age < 18.
- **Password Validation**:
  - At least 8–16 characters
  - At least one uppercase, one lowercase, one number, one special character
- **Live Feedback**: Rules display ✓ or ✗ based on input.
- **Form Submission**:
  - Checks for valid name, email format, password strength, and age.
  - Alerts user if any validation fails.
  - Prevents form submission on error.

---
## Demonstration Screenshots

![image](https://github.com/user-attachments/assets/290b49e0-d417-45ac-a4d3-e5b49eab8ac7)
Empty form

![image](https://github.com/user-attachments/assets/13664eec-8aca-4999-a9b4-c6864f4dfe91)

Form's "register" button is disabled if one or more fields are empty or if the age is below 18

![image](https://github.com/user-attachments/assets/30692dc7-78b6-4633-b2cf-1ccfa92eb102)

Real-time password validation using js

![image](https://github.com/user-attachments/assets/55b2fbed-267e-4d8b-9dde-9ee52cda0b0b)

All fields are correctly filled, now the "register" button is enabled for submission

![image](https://github.com/user-attachments/assets/c4108cb2-0c89-451b-80a3-28d0cf224e42)

Form submission message
