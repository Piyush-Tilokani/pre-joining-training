# String Operations in Python using f-strings and other techniques

def display_string_info(name, city):
    print(f"Name: {name}")
    print(f"City: {city}")
    print(f"Welcome message: Hello, {name} from {city}!")


def string_manipulations(sample_text):
    print(f"\nOriginal Text: {sample_text}")
    print(f"Length: {len(sample_text)}")
    print(f"Uppercase: {sample_text.upper()}")
    print(f"Lowercase: {sample_text.lower()}")
    print(f"Title Case: {sample_text.title()}")
    print(f"Capitalize: {sample_text.capitalize()}")
    print(f"Reversed: {sample_text[::-1]}")
    print(f"Is Alphabetic: {sample_text.isalpha()}")
    print(f"Is Alphanumeric: {sample_text.replace(' ', '').isalnum()}")
    print(f"Is Lowercase: {sample_text.islower()}")
    print(f"Is Uppercase: {sample_text.isupper()}")
    print(f"Starts with 'Hello': {sample_text.startswith('Hello')}")
    print(f"Ends with '!': {sample_text.endswith('!')}")
    print(f"Count of 'o': {sample_text.count('o')}")
    print(f"Index of 'Stoxx': {sample_text.find('Stoxx')}")
    print(f"Replace 'o' with '0': {sample_text.replace('o', '0')}") # Replacing 'o' with '0' creates a new string
    print(f"Split into words: {sample_text.split()}")
    print(f"Joined with '-': {'-'.join(sample_text.split())}") # Joining an array of words with '-'
    print(f"Strip whitespace: {sample_text.strip()}") # Stripping whitespace from both ends


def character_access_and_slicing(text):
    print(f"\nFirst character: {text[0]}")
    print(f"Last character using negative indexing: {text[-1]}") #gets the first character from the end
    print(f"Substring [0:5]: {text[0:5]}") # Slicing from index 0 (inclusive) to 5 (exclusive)
    print(f"Substring from index 6 to end: {text[6:]}") # Slicing from index 6 to the end
    print(f"Substring with step (every 2nd char): {text[::2]}") # Slicing with a step of 2


def demonstrate_multiline_and_immutability():
    # Triple quotes for multi-line string
    multiline_string = """This is a multi-line string.
It can span multiple lines.
Each new line is preserved."""
    print("\nMultiline String:\n" + multiline_string)

    # Strings are immutable
    immutable_example = "Immutable"
    print(f"\nOriginal string: {immutable_example}")
    try:
        # Attempting to modify a character (will raise an error)
        immutable_example[0] = 'i'
    except TypeError as e:
        print("Error when trying to modify string (immutability):", e)

    # Updating a string (by reassigning)
    updated_string = "New Value"
    print("Updated string by reassignment:", updated_string)

    # Deleting a string variable
    temp_string = "To be deleted"
    print("Before deletion:", temp_string)
    del temp_string
    try:
        print("After deletion:", temp_string)
    except NameError as e:
        print("Error after deletion:", e)


def other_common_operations():
    name = "Piyush"
    greeting = "Hello"

    # String concatenation
    combined = greeting + " " + name
    print(f"\nConcatenated String: {combined}")

    # String repetition
    repeated = name * 3
    print(f"Repeated Name: {repeated}")

    # Length, strip, replace again
    extra_space = "  Trim this text  "
    print(f"Original with spaces: '{extra_space}'")
    print(f"After strip: '{extra_space.strip()}'")
    print(f"Replacing 'text' with 'line': {extra_space.replace('text', 'line')}")


def string_formatting_examples(name, age):
    print(f"\nFormatted Introduction: My name is {name} and I am {age} years old.")
    balance = 1234.567
    print(f"Formatted Balance: ₹{balance:.2f}") # Formatting to 2 decimal places
    print(f"Binary of 10: {10:b}") # Binary representation of 10
    print(f"Hexadecimal of 255: {255:x}") # Hexadecimal representation of 255
    print(f"Padded name: {name:>20}")  # Right-aligned with padding


if __name__ == "__main__":
    person_name = "Piyush Tilokani"
    city_name = "Mumbai"
    message = "Hello everyone, welcome to ISS Stoxx!"

    display_string_info(person_name, city_name)
    string_manipulations(message)
    character_access_and_slicing(message)
    demonstrate_multiline_and_immutability()
    other_common_operations()
    string_formatting_examples(person_name, 22)
