def divide_numbers(a, b):
    try:
        result = a / b
        print(f"Result = {result}")
    except ZeroDivisionError:  # Handle division by zero
        print("Error: Cannot divide by zero.")
    except TypeError:  # Handle type errors (e.g., if inputs are not numbers)
        print("Error: Type mismatch. Please ensure both inputs are numbers.")


def read_file():
    print("\n2. Try-Except-Else-Finally Example: File Handling")
    try:
        file = open("resume.pdf", "r")  # Ensure this file exists
    except FileNotFoundError:  # Handle file not found error
        print("Error: The file does not exist.")
    else:  # This block executes if no exceptions were raised
        print("File opened successfully. First line:", file.readline())
        file.close()
    finally:  # This block always executes
        print("File read attempt complete.")


def validate_age_with_raise():
    print("\n3. Raise Example: Age Validation")

    def check_age(age):
        if age < 18: # Raise an exception if age is less than 18
            raise ValueError("You must be at least 18 years old.")
        return "Access granted."

    try:
        age = 17
        message = check_age(age)
        print(message)
    except ValueError as e: # Catch the raised exception
        print("Validation Error:", e)


def handle_multiple_errors():
    print("\n4. Handling Multiple Exceptions in One Block (with hardcoded numbers)")
    test_values = [2, 5]  # Hardcoded inputs to test
    lst = [10, 20, 30]
    for num in test_values:
        try: 
            print(f"Trying index {num}:", lst[num])  # Will raise IndexError for 5
        except (ValueError, IndexError) as e: # Handle both ValueError and IndexError
            print(f"Caught Error with index {num}:", e)


def raise_custom_exception():
    print("\n5. Raise Custom Exception: Email Check (with hardcoded emails)")

    class InvalidEmailError(Exception):
        pass

    def validate_email(email):
        if "@" not in email or "." not in email:
            raise InvalidEmailError("Invalid email format.")
        return "Email is valid."

    test_emails = ["piyush@mail.com", "gmail.com"]
    for email in test_emails:
        try:
            print(f"Checking email '{email}':", validate_email(email))
        except InvalidEmailError as e: # Catch the custom exception
            print(f"Custom Error for '{email}':", e)


if __name__ == "__main__":
    print("\n--- Python Error Handling Examples ---")
    print("\n1. Try-Except Example:")
    divide_numbers(10, 3)      # Valid input
    divide_numbers(30, 0)      # Division by zero
    divide_numbers(10, 'a')    # Invalid input type
    read_file()                # File handling
    validate_age_with_raise()  # Raise example
    handle_multiple_errors()   # Indexing with hardcoded inputs
    raise_custom_exception()   # Email validation with hardcoded inputs
