from collections import defaultdict

# Dictionary Operations in Python
# Function to create and display dictionaries
def create_and_display_dictionaries():
    empty_dict = {}
    student_info = {
        "name": "Piyush Tilokani",
        "age": 22,
        "department": "Information Technology",
        "is_graduated": True
    }

    mixed_keys_dict = {
        101: "Physics",
        "semester": 5,
        True: "Active"
    }

    print("Empty Dictionary:", empty_dict)
    print("Student Information:", student_info)
    print("Mixed Keys Dictionary:", mixed_keys_dict)


# Function to demonstrate accessing dictionary values
def access_dictionary_values():
    employee = {
        "id": "E101",
        "name": "Rohan",
        "designation": "Manager"
    }

    print("\nAccessing Dictionary Values:")
    print("Employee ID:", employee["id"])
    print("Employee Name (using get):", employee.get("name"))
    print("Non-existing key (get with default):", employee.get("salary", "Not available")) 
    print("Non-existing key (get without default):", employee.get("salary"))  # Returns None if key doesn't exist
    print("All Keys:", employee.keys())
    print("All Values:", employee.values())


# Function to demonstrate adding and updating dictionary entries
def modify_dictionary():
    product = {
        "product_id": "P501",
        "name": "Wireless Mouse",
        "price": 899
    }

    print("\nOriginal Product Dictionary:", product)

    # Adding new key-value pairs
    product["stock"] = 25
    product.update({"category": "Electronics"})  # Using update we can add multiple key-value pairs

    # Updating values
    product["price"] = 799

    print("After Adding and Updating:", product)


# Function to demonstrate deleting dictionary entries
def delete_dictionary_entries():
    course = {
        "course_code": "CS101",
        "title": "Intro to Python",
        "credits": 4
    }

    print("\nOriginal Course Dictionary:", course)

    del course["credits"]  # Removes specific key
    removed_value = course.pop("title")  # Removes key-value pair and returns the value
    print("After Deletion:", course)
    print("Removed Value:", removed_value)

    course.clear()  # Removes all entries
    print("After Clearing Dictionary:", course)


# Function to demonstrate dictionary iteration
def iterate_dictionary():
    book = {
        "title": "Atomic Habits",
        "author": "James Clear",
        "price": 450
    }

    print("\nIterating Through Dictionary:")
    for key in book:
        print("Key:", key, "| Value:", book[key])

    print("\nUsing items():")
    for key, value in book.items():
        print(f"{key}: {value}")


# Function to demonstrate dictionary methods
def dictionary_methods():
    config = {
        "timeout": 30,
        "retries": 3
    }

    print("\nOriginal Config:", config)

    # Copy dictionary
    backup_config = config.copy() #Creates a shallow copy of the dictionary
    print("Backup Config:", backup_config)
    print("Is Backup Config equal to Original?", backup_config == config)  # Checks if both have the same content
    print("Is Backup Config same object as Original?", backup_config is config) # Checks if both refer to the same object

    # Set default value if key doesn't exist
    retries_value = config.setdefault("retries", 5)
    print("Retries:", retries_value)

    # Keys and values
    print("Keys:", list(config.keys()))
    print("Values:", list(config.values()))
    print("Items:", list(config.items()))


# Function to demonstrate dictionary comprehension
def dictionary_comprehension():
    print("\nDictionary Comprehension Example:")
    squares = {x: x ** 2 for x in range(1, 6)}
    print("Squares Dictionary:", squares)


# Function to demonstrate use of defaultdict
def defaultdict_example():
    print("\nDefaultdict Example (grouping students by department):")

    students = [
        ("Alice", "CS"),
        ("Bob", "IT"),
        ("Charlie", "CS"),
        ("David", "ECE"),
        ("Eva", "IT")
    ]

    dept_students = defaultdict(list)

    for name, dept in students:
        dept_students[dept].append(name)

    for dept, names in dept_students.items():
        print(f"{dept}: {names}")


# Function to demonstrate real-world use cases of dictionaries
def dictionary_use_cases():
    print("\nReal-World Dictionary Use Cases:")

    # 1. Simulating API response (like JSON)
    api_response = {
        "status": "success",
        "data": {
            "user_id": 101,
            "username": "piyush_22",
            "email": "piyush@example.com"
        }
    }
    print("API Response:", api_response)

    # 2. Counting frequency of words
    sentence = "hello world hello python hello dictionary"
    word_freq = {}
    for word in sentence.split():
        word_freq[word] = word_freq.get(word, 0) + 1
    print("Word Frequency:", word_freq)

    # 3. Storing product inventory by category
    inventory = {
        "Laptops": 15,
        "Monitors": 30,
        "Keyboards": 25
    }
    print("Product Inventory:", inventory)


if __name__ == "__main__":
    create_and_display_dictionaries()
    access_dictionary_values()
    modify_dictionary()
    delete_dictionary_entries()
    iterate_dictionary()
    dictionary_methods()
    dictionary_comprehension()
    defaultdict_example()
    dictionary_use_cases()