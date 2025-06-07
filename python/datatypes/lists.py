# List Operations in Python 

# Function to create and display a list
def create_and_display_list():
    shopping_list = ["Milk", "Eggs", "Bread", "Butter"]
    print("Initial Shopping List:", shopping_list)


# Function to access list elements using indexing and slicing
def access_list_elements():
    numbers = [10, 20, 30, 40, 50]
    print("\nList Elements:")
    print("First element:", numbers[0])
    print("Last element:", numbers[-1])
    print("Middle elements (index 1 to 3):", numbers[1:4])


# Function to modify list elements
def modify_list_elements():
    currency = ["USD", "JPY", "INR"]
    currency[1] = "EUR"
    print("\nModified currency list:", currency)


# Function to add elements to a list
def add_elements_to_list():
    cities = ["Mumbai", "Delhi"]
    cities.append("Bangalore")  # Add at the end
    cities.insert(1, "Pune")    # Insert at index 1
    print("\nCities after Adding Elements:", cities)


# Function to remove elements from a list
def remove_elements_from_list():
    items = ["Pen", "Pencil", "Eraser", "Sharpener"]
    items.remove("Eraser")     # Remove by value
    popped_item = items.pop()  # Remove last element
    del items[0]               # Delete by index
    print("\nItems after Removals:", items)
    print("Popped Item:", popped_item)


# Function to demonstrate list utility methods
def list_utility_methods():
    numbers = [5, 2, 9, 1, 5, 6]
    print("\nOriginal Numbers:", numbers)
    print("Count of 5:", numbers.count(5))
    print("Index of 9:", numbers.index(9))
    numbers.sort()
    print("Sorted Numbers:", numbers)
    numbers.reverse()
    print("Reversed Numbers:", numbers)


# Function to demonstrate list copying and clearing
def copy_and_clear_list():
    names = ["Piyush", "Shashwat", "Atharva"]
    names_copy = names.copy()  # Create a shallow copy
    print("\nnames == names_copy:", names == names_copy)  # Elements of names and names_copy are equal
    print("names is names_copy:", names is names_copy)    # But they are not the same object in memory
    names.clear()
    print("Original List After Clear:", names)
    print("Copied List:", names_copy)


# Function to demonstrate nested lists
def nested_list_operations():
    matrix = [[1, 2], [3, 4], [5, 6]]
    print("\nNested List (Matrix):", matrix)
    print("Matrix view: ")
    for row in matrix:
        print(row)
    print("Element at row 2, col 1:", matrix[1][0])


# Function to demonstrate list comprehension
def list_comprehension_example():
    squares = [x * x for x in range(1, 6)]
    print("\nSquares using List Comprehension:", squares)


# Function to demonstrate list with multiple datatypes
def mixed_datatypes_in_list():
    mixed_list = [123, 5.56, "Python", True, None, [1, 2], {"key": "value"}]
    print("\nList with Multiple Data Types:", mixed_list)
    print("Type of mixed_list:", type(mixed_list).__name__)
    for i, item in enumerate(mixed_list):
        print(f"Element {i}: {item} -> Type: {type(item).__name__}")


# Function to demonstrate list creation from string, set, range and usage of extend
def list_creation_and_extension():
    # From string: creates list of characters
    from_string = list("hello")
    print("\nList from string 'hello':", from_string)

    # From set: creates list of unique unordered elements
    from_set = list({10, 20, 30})
    print("List from set {10, 20, 30}:", from_set)

    # From range: creates list of numbers from 1 to 5
    from_range = list(range(1, 6))
    print("List from range(1, 6):", from_range)

    # Using extend to merge two lists
    list_a = ["a", "b", "c"]
    list_b = [1, 2, 3]
    list_a.extend(list_b)
    print("List after using extend():", list_a)


if __name__ == "__main__":
    create_and_display_list()
    access_list_elements()
    modify_list_elements()
    add_elements_to_list()
    remove_elements_from_list()
    list_utility_methods()
    copy_and_clear_list()
    nested_list_operations()
    list_comprehension_example()
    mixed_datatypes_in_list()
    list_creation_and_extension()
