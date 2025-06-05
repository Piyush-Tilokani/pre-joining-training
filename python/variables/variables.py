# Variables and their operations in Python

# Variable Declaration and Initialization 
# snake_casing for variables
customer_name = "Piyush Tilokani"
shipping_address = "59/32, Andheri (E)"

# Integer variable for quantity
item_quantity = 3

# Float variable for price
item_price = 499.99

# Boolean variable to indicate order status
is_order_confirmed = True

# Displaying Variable Values
print("Customer Name:", customer_name)
print("Shipping Address:", shipping_address)
print("Item Quantity:", item_quantity)
print("Item Price per Unit:", item_price)
print("Order Confirmed:", is_order_confirmed)

# Multiple Assignments
# Assigning the same value to multiple variables 
item1_delivered = item2_delivered = item3_delivered = False

# Assigning different values to multiple variables
item1_name, item2_name, item3_name = "Bluetooth Speaker", "Wireless Mouse", "Keyboard"

print("Ordered Items:", item1_name, ", ", item2_name, ", ", item3_name, sep="")

# Checking Variable Types
# Using __name__ to print clean type names
print("Type of customer_name:", type(customer_name).__name__)
print("Type of item_quantity:", type(item_quantity).__name__)
print("Type of item_price:", type(item_price).__name__)
print("Type of is_order_confirmed:", type(is_order_confirmed).__name__)

# Deriving variable value from other variables
# Descriptive variable names improve code readability and maintainability
total_order_value = item_quantity * item_price
print("Total Order Value:", total_order_value)

# Dynamic Variable
# Python allows reassignment of different types to the same variable
delivery_status = "Pending"
print("Initial delivery_status:", delivery_status, "| Type:", type(delivery_status).__name__)

delivery_status = False
print("Updated delivery_status:", delivery_status, "| Type:", type(delivery_status).__name__)

# Swapping values of variables
warehouse_1 = "Mumbai"
warehouse_2 = "Delhi"

print("Before Swap - Warehouse 1: ", warehouse_1, ", Warehouse 2: ", warehouse_2, sep="")

warehouse_1, warehouse_2 = warehouse_2, warehouse_1

print("After Swap - Warehouse 1: ", warehouse_1, ", Warehouse 2: ", warehouse_2, sep="")

# Global and Local Variable Example
# Global variable
discount_rate = 0.1

def calculate_discounted_price():
    # Local variable
    original_price = 1000
    discounted_price = original_price * (1 - discount_rate)
    print("Discounted Price (Local Calculation):", discounted_price)

calculate_discounted_price()
print("Global Discount Rate:", discount_rate)
