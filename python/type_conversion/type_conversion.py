import json

# Custom class with type conversion methods
class Temperature:
    def __init__(self, celsius): # Initialize with Celsius value
        self.celsius = celsius

    def __int__(self): # Convert Celsius to Integer
        return int(self.celsius)

    def __float__(self): # Convert Celsius to Float
        return float(self.celsius)

    def __str__(self): # Convert Celsius to String
        return f"{self.celsius}°C"


# Function to safely convert string to int
def safe_str_to_int(s):
    try: # Attempt to convert string to int
        return int(s)
    except ValueError: # Handle conversion error. If conversion fails, print an error message and return None
        print(f"Cannot convert '{s}' to int.")
        return None

# Function to demonstrate various type conversions in Python
def demonstrate_type_conversions():
    print("\n--- Python Type Conversion ---")

    # String to Integer and Float
    str_num = "42"
    print("\nString to Integer:", int(str_num))
    print("String to Float:", float(str_num))

    # Integer to String and Float
    num = 10
    print("\nInteger to String:", str(num))
    print("Integer to Float:", float(num))

    # Float to Integer (lossy conversion)
    fl = 5.89
    print("\nFloat to Integer:", int(fl))

    # Number to Boolean
    print("\nInteger 0 to Boolean:", bool(0))
    print("Integer 1 to Boolean:", bool(1))
    print("Float 0.0 to Boolean:", bool(0.0))
    print("Float 3.14 to Boolean:", bool(3.14))

    # Boolean to Integer and Float
    print("\nBoolean True to Integer:", int(True))
    print("Boolean False to Integer:", int(False))
    print("Boolean True to Float:", float(True))
    print("Boolean False to Float:", float(False))

    # List to Tuple, Set and vice versa
    lst = [1, 2, 3, 4, 4]
    print("\nList to Tuple:", tuple(lst))
    print("List to Set (removes duplicates):", set(lst))

    tup = (10, 20, 30)
    print("Tuple to List:", list(tup))
    print("Tuple to Set:", set(tup))

    # Set to List or Tuple
    st = {7, 8, 9}
    print("Set to List:", list(st))
    print("Set to Tuple:", tuple(st))

    # String to List
    name = "hello"
    print("\nString to List (by characters):", list(name))
    sentence = "Python is fun"
    print("String to List (by words):", sentence.split())

    # List of strings to single string
    words = ['Python', 'is', 'awesome']
    print("List to String (joined):", " ".join(words))

    # Dictionary to JSON and back
    user = {"name": "Piyush", "age": 22, "verified": True}
    json_str = json.dumps(user)
    print("\nType of json_str:", type(json_str).__name__)
    print("Dictionary to JSON String:", json_str)
    back_to_dict = json.loads(json_str)
    print("Type of back_to_dict:", type(back_to_dict).__name__)
    print("JSON String to Dictionary:", back_to_dict)

    # Character to ASCII and back
    ch = 'A'
    print("\nCharacter to ASCII (ord):", ord(ch))
    print("ASCII to Character (chr):", chr(65))

    # Binary/Hex string to int
    bin_str = "1010"
    print("\nBinary String to Integer:", int(bin_str, 2))
    hex_str = "1F"
    print("Hexadecimal String to Integer:", int(hex_str, 16))

    # --- Custom Type Conversion ---
    print("\n--- Custom Type Conversion using Class ---")
    temp = Temperature(36.6)
    print("As String:", str(temp))
    print("As Float:", float(temp))
    print("As Integer:", int(temp))

    # --- Safe Type Conversion ---
    print("\n--- Safe Type Conversion ---")
    values = ["123", "45.6", "abc", "78"]
    for val in values:
        result = safe_str_to_int(val)
        print(f"String '{val}' to int:", result)

    # --- Real-life API JSON Parsing ---
    print("\n--- Real-life Scenario: Parsing API Response ---")
    api_response = '''
    {
        "id": 101,
        "user": "piyush_t",
        "rating": "4.8",
        "is_premium": "True",
        "posts": ["Intro to Python", "OOP in Java", "TypeScript Basics"]
    }
    '''
    print("API Response JSON String:", api_response)
    data = json.loads(api_response) # Parse JSON string to dictionary
    user_id = int(data["id"]) # Convert ID to integer 
    username = str(data["user"]) # Convert username to string
    rating = float(data["rating"]) # Convert rating to float
    is_premium = data["is_premium"] == "True" # Convert string to boolean
    posts = list(data["posts"]) # Convert posts to list

    print("Parsed Data:")
    print("Parsed User ID:", user_id)
    print("Username:", username)
    print("Rating (float):", rating)
    print("Is Premium (bool):", is_premium)
    print("Posts (List):", posts)


if __name__ == "__main__":
    demonstrate_type_conversions()