# Constants in Python using typing.Final

from typing import Final, List

# By convention, constants are written in UPPERCASE with underscores
# Final indicates to type checkers that these variables should not be reassigned

PLATFORM_NAME: Final[str] = "QuickCom"
MAX_LOGIN_ATTEMPTS: Final[int] = 5
DELIVERY_CHARGE: Final[float] = 49.99
TAX_RATE: Final[float] = 0.18
WAREHOUSE_LOCATIONS: Final[List[str]] = ["Mumbai", "Delhi", "Bangalore"]

# Displaying constant values
print("E-commerce Platform:", PLATFORM_NAME)
print("Maximum Login Attempts Allowed:", MAX_LOGIN_ATTEMPTS)
print("Standard Delivery Charge:", DELIVERY_CHARGE)
print("Applicable Tax Rate:", TAX_RATE)
print("Warehouse Locations:", WAREHOUSE_LOCATIONS)

# Using constants in calculations
item_price = 1000
final_price = item_price + DELIVERY_CHARGE + (item_price * TAX_RATE)

print("Final Price after Tax and Delivery:", final_price)

# Attempting to reassign a constant will raise an error in type checkers
# Uncommenting the line below will raise a type checker warning
TAX_RATE = 0.2
# Executes fine, but mypy will report an error if you run mypy on this: