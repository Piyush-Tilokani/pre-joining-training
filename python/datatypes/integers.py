# Integer Types and Operations in Python

# Ways to define integers in Python:
num1 = 87                           # Positive integer
num2 = -35                          # Negative integer
num3 = 9876543210123456789          # Large integer
num4 = 0b101010                     # Binary (42)
num5 = 0o144                        # Octal (100)
num6 = 0xFF                         # Hexadecimal (255)
num7 = 300                          # Decimal

# Displaying values and types
numbers = {
    "num1 (Positive)": num1,
    "num2 (Negative)": num2,
    "num3 (Large)": num3,
    "num4 (Binary 0b101010)": num4,
    "num5 (Octal 0o144)": num5,
    "num6 (Hexadecimal 0xFF)": num6,
    "num7 (Decimal)": num7
}

# For loop to display values and types 
for label, value in numbers.items():
    print(f"{label}: {value} | Type: {type(value).__name__}")

# Arithmetic Operations (with expressions as lambdas)
print("\nArithmetic Operations:")

arithmetic_operations = {
    "Addition (num1 + num6)": lambda: num1 + num6,
    "Subtraction (num1 - num4)": lambda: num1 - num4,
    "Multiplication (num5 * num6)": lambda: num5 * num6,
    "Division (num7 / num1)": lambda: num7 / num1,         # Decimal division
    "Floor Division (num7 // num1)": lambda: num7 // num1, # Integer division
    "Modulo (num7 % num1)": lambda: num7 % num1,
    "Exponentiation (num4 ** 2)": lambda: num4 ** 2,
    "Absolute Value of num2": lambda: abs(num2)
}

for label, operation in arithmetic_operations.items():
    print(f"{label}: {operation()}")

# Bitwise Operations
print("\nBitwise Operations on num1 and num6:")

bitwise_operations = {
    "Bitwise AND (num1 & num6)": lambda: num1 & num6,
    "Bitwise OR (num1 | num6)": lambda: num1 | num6,
    "Bitwise XOR (num1 ^ num6)": lambda: num1 ^ num6,
    "Bitwise NOT (~num1)": lambda: ~num1,
    "Left Shift (num1 << 2)": lambda: num1 << 2,
    "Right Shift (num1 >> 2)": lambda: num1 >> 2
}

for label, operation in bitwise_operations.items():
    print(f"{label}: {operation()}")

# Base Conversions
print("\nBase Conversions for num1:")
print("Binary:", bin(num1))
print("Octal:", oct(num1))
print("Hexadecimal:", hex(num1))
