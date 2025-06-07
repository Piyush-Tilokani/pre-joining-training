import timeit, sys
from collections import namedtuple


# Function to create and display tuples
def create_and_display_tuples():
    empty_tuple = ()
    single_element_tuple = ("One",)
    mixed_tuple = ("Alice", 28, True, 5.6)
    print("Empty Tuple:", empty_tuple)
    print("Single Element Tuple:", single_element_tuple)
    print("Mixed Data Tuple:", mixed_tuple)


# Function to demonstrate accessing tuple elements
def access_tuple_elements():
    numbers = (10, 20, 30, 40, 50)
    print("\nAccessing Elements:")
    print("First Element:", numbers[0])
    print("Last Element:", numbers[-1])
    print("Slice from index 1 to 3:", numbers[1:4])


# Function to demonstrate immutability of tuples
def tuple_immutability():
    languages = ("Python", "Java", "C++")
    print("\nTuple Immutability:")
    print("Original Tuple:", languages)
    try:
        languages[0] = "Go"  # This will raise an error
    except TypeError as e:
        print("Error when trying to modify tuple:", e)


# Function to demonstrate nested tuples
def nested_tuple_example():
    nested = ((1, 2), (3, 4), (5, 6))
    print("\nNested Tuple:", nested)
    for row in nested:
        print(row)
    print("Element at row 2, col 1:", nested[1][0])


# Function to demonstrate tuple unpacking
def tuple_unpacking():
    employee = ("E123", "Logan Paul", "HR")
    emp_id, emp_name, department = employee
    print("\nTuple Unpacking:")
    print("Employee ID:", emp_id)
    print("Employee Name:", emp_name)
    print("Department:", department)


# Function to demonstrate useful tuple methods
def tuple_methods_demo():
    values = (1, 2, 3, 2, 4, 2)
    print("\nTuple Methods:")
    print("Original Tuple:", values)
    print("Count of 2:", values.count(2))
    print("Index of 3:", values.index(3))


# Function to demonstrate tuples with loops and membership
def tuple_loops_and_membership():
    cities = ("Mumbai", "Delhi", "Chennai", "Kolkata")
    print("\nLooping through Tuple:")
    for city in cities:
        print(city)

    print("Is 'Delhi' in the tuple?", "Delhi" in cities)
    print("Is 'Pune' not in the tuple?", "Pune" not in cities)


# Function to demonstrate tuple operations
def tuple_operations_demo():
    t1 = (1, 2, 3)
    t2 = (3, 4, 5)
    print("\nTuple Operations:")
    print("t1 + t2:", t1 + t2)
    print("t1 * 2:", t1 * 2)


# Function to demonstrate extended unpacking
def tuple_extended_unpacking():
    values = (1, 2, 3, 4, 5)
    a, *b, c = values
    print("\nExtended Tuple Unpacking:")
    print("a:", a)
    print("b (middle values):", b)
    print("c:", c)


# Function to show real-world use cases of tuples
def tuple_use_cases():
    print("\nReal-world Tuple Use Cases:")

    # Example 1: Returning multiple values from a function (e.g., employee salary breakdown)
    def salary_breakdown(gross_salary):
        tax = gross_salary * 0.2
        net_salary = gross_salary - tax
        return net_salary, tax

    net, tax = salary_breakdown(60000)
    print("\nSalary Breakdown (net, tax):", (net, tax))

    # Example 2: Using tuple as dictionary key in a warehouse inventory system
    # Key: (product_id, warehouse_location)
    inventory = {
        (101, "Mumbai"): 250,
        (102, "Delhi"): 180,
        (103, "Mumbai"): 95
    }
    print("Inventory at (101, 'Mumbai'):", inventory[(101, "Mumbai")])

    # Example 3: Using tuples to store fixed data points (sensor data reading)
    sensor_reading = ("Sensor-A1", "2025-06-05 10:30:00", 27.8)
    print("\nSensor Reading (ID, Timestamp, Temperature):", sensor_reading)

    # Example 4: Tuple used in logging (log level, message)
    logs = [
        ("INFO", "Application started"),
        ("WARNING", "Low memory"),
        ("ERROR", "Unhandled exception occurred")
    ]
    print("\nLog Entries:")
    for log in logs:
        print(f"Level: {log[0]}, Message: {log[1]}")



# Function to show best practices
def tuple_best_practices():
    print("\nTuple Best Practices Examples:")

    # 1. Use tuples for fixed-size, read-only collections (like a product item)
    product = ("Laptop", "Intel i7", 16, 512)  # name, processor, RAM, SSD (immutable config)
    print("Product Specification Tuple:", product)

    try:
        product[1] = "Intel i9"  # Trying to change processor
    except TypeError as e:
        print("Cannot modify product spec tuple:", e)

    # 2. Prefer tuples (or namedtuples) for returning structured values from functions
    Employee = namedtuple("Employee", ["id", "name", "department", "salary"])

    def get_employee_details():
        return Employee("E101", "Piyush", "Engineering", 85000)

    emp = get_employee_details()
    print("\nNamedTuple from function (Employee):")
    print("Employee ID:", emp.id)
    print("Name:", emp.name)
    print("Department:", emp.department)
    print("Salary:", emp.salary)

    # 3. Tuples as dictionary keys — useful for composite keys like (item, location)
    inventory = {
        ("Keyboard", "Warehouse A"): 120,
        ("Mouse", "Warehouse B"): 85
    }
    key = ("Keyboard", "Warehouse A")
    print("\nInventory count for", key, "is", inventory[key])

    # Demonstrating that lists cannot be used as dictionary keys
    try:
        bad_key_dict = {["Keyboard", "Warehouse A"]: 120}
    except TypeError as e:
        print("List cannot be used as dictionary key:", e)


# Function to compare time performance
def tuple_time_analysis():
    print("\nTime and Feature Analysis: Tuple vs List\n")

    setup_code = "lst = list(range(100000)); tpl = tuple(lst)"

    access_time_list = timeit.timeit("lst[50000]", setup=setup_code, number=10000)
    access_time_tuple = timeit.timeit("tpl[50000]", setup=setup_code, number=10000)

    creation_time_list = timeit.timeit("list(range(100000))", number=1000)
    creation_time_tuple = timeit.timeit("tuple(range(100000))", number=1000)

    membership_time_list = timeit.timeit("99999 in lst", setup=setup_code, number=1000)
    membership_time_tuple = timeit.timeit("99999 in tpl", setup=setup_code, number=1000)

    iteration_time_list = timeit.timeit("for i in lst: pass", setup=setup_code, number=100)
    iteration_time_tuple = timeit.timeit("for i in tpl: pass", setup=setup_code, number=100)

    lst = list(range(100000))
    tpl = tuple(lst)

    memory_list = sys.getsizeof(lst)
    memory_tuple = sys.getsizeof(tpl)

    print(f"{'Operation':<25} {'List':>15} {'Tuple':>15}")
    print("-" * 55)
    print(f"{'Access Time':<25} {access_time_list:>15.6f} {access_time_tuple:>15.6f}")
    print(f"{'Creation Time':<25} {creation_time_list:>15.6f} {creation_time_tuple:>15.6f}")
    print(f"{'Membership Test Time':<25} {membership_time_list:>15.6f} {membership_time_tuple:>15.6f}")
    print(f"{'Iteration Time':<25} {iteration_time_list:>15.6f} {iteration_time_tuple:>15.6f}")
    print(f"{'Memory Usage (bytes)':<25} {memory_list:>15} {memory_tuple:>15}")


if __name__ == "__main__":
    create_and_display_tuples()
    access_tuple_elements()
    tuple_immutability()
    nested_tuple_example()
    tuple_unpacking()
    tuple_methods_demo()
    tuple_loops_and_membership()
    tuple_operations_demo()
    tuple_extended_unpacking()
    tuple_use_cases()
    tuple_best_practices()
    tuple_time_analysis()
