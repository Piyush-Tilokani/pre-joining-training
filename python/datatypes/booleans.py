# Boolean Values and Operations in Python

# Function to demonstrate direct Boolean values
def display_boolean_values():
    # Boolean variables to represent system states
    is_user_logged_in = True
    is_payment_complete = False

    print("Boolean Values:")
    print(f"User Logged In: {is_user_logged_in}")
    print(f"Payment Complete: {is_payment_complete}")


# Function to demonstrate comparison operations which return Boolean results
def comparison_operations():
    x = 10
    y = 20

    print("\nComparison Operations:")
    print(f"Is x equal to y? {x == y}")
    print(f"Is x not equal to y? {x != y}")
    print(f"Is x greater than y? {x > y}")
    print(f"Is x less than or equal to y? {x <= y}")

    # Example of chained comparison
    val = 25
    print(f"Is val between 10 and 50 (inclusive start)? {10 <= val < 50}")


# Function to demonstrate logical operators: and, or, not
def logical_operations():
    age = 25
    has_id = True
    is_student = False

    print("\nLogical Operations:")

    # Logical AND: both conditions must be True
    print(f"Eligible to enter (age >= 18 and has ID)? {(age >= 18) and has_id}")

    # Logical OR: at least one condition must be True
    print(f"Underage or no ID (age < 18 or not has ID)? {(age < 18) or not has_id}")

    # Logical NOT: negates the result
    print(f"Is student? {is_student}")
    print(f"Is not student? {not is_student}")

    # Combining logical operators
    print(f"Eligible and not a student? {(age >= 18 and has_id) and not is_student}")


# Function to demonstrate identity (is) and membership (in, not in) operators
def identity_and_membership():
    a = [1, 2, 3]
    b = [1, 2, 3]
    c = a

    print("\nIdentity and Membership Operations:")
    print(f"a is b? {a is b}")      # False: different objects with same values
    print(f"a is c? {a is c}")      # True: same object
    print(f"2 in a? {2 in a}")      # True: 2 is an element of list a
    print(f"5 not in a? {5 not in a}")  # True: 5 is not in the list


# Function to demonstrate what is considered truthy or falsy in Python
def truthy_falsy_examples():
    print("\nTruthy and Falsy Values:")
    values = [0, "", [], {}, None, "Python", [1, 2], 42, -5, 0.0, 3.14]
    for val in values:
        print(f"Value: {val!r} -> Boolean: {bool(val)}")


# Function to demonstrate Boolean behavior with various data types
def boolean_with_data_types():
    print("\nBoolean Results on Different Data Types:")

    # String comparisons
    name = "Piyush"
    print(f"'Piyush' == 'piyush'? {name == 'piyush'}")  # False
    print(f"'Piyush'.lower() == 'piyush'? {name.lower() == 'piyush'}")  # True

    # Numeric evaluations
    a = 0
    b = 100
    print(f"a == 0? {a == 0}")
    print(f"b > 50? {b > 50}")
    print(f"a != b? {a != b}")

    # List comparisons
    list1 = [1, 2, 3]
    list2 = [1, 2, 3]
    print(f"list1 == list2? {list1 == list2}")  # True: Same values
    print(f"list1 is list2? {list1 is list2}")  # False: Different objects

    # Dictionary key presence check
    user_data = {"name": "Bob", "age": 30}
    print(f"'name' in user_data? {'name' in user_data}")
    print(f"'email' not in user_data? {'email' not in user_data}")


if __name__ == "__main__":
    display_boolean_values()
    comparison_operations()
    logical_operations()
    identity_and_membership()
    truthy_falsy_examples()
    boolean_with_data_types()
