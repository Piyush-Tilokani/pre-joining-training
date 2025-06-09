def function_examples():

    # 1. Function with Parameters and Arguments (Non-greeting example)
    print("\n1. Function with Parameters and Arguments:")

    def area_of_rectangle(length, width):
        return length * width

    print("Area of 5x3 rectangle:", area_of_rectangle(5, 3))


    # 2. Function with Default Argument Values
    print("\n2. Function with Default Argument:")

    def power(base, exponent=1):
        return base ** exponent

    print("5 raised to power 1 (default):", power(5))
    print("5 raised to power 3:", power(5, 3))


    # 3. Function Returning Multiple Values
    print("\n3. Function Returning Multiple Values:")

    def basic_statistics(a, b):
        sum_val = a + b
        diff_val = a - b
        prod_val = a * b
        return sum_val, diff_val, prod_val

    res_sum, res_diff, res_prod = basic_statistics(10, 4)
    print(f"Sum: {res_sum}, Difference: {res_diff}, Product: {res_prod}")
    res = basic_statistics(10, 4)  # Returns a tuple (sum, difference, product)
    #  Proof that the function returns a tuple
    print("Returned tuple:", res, "Type:", type(res).__name__)
    

    # 4. Function with *args variable-length arguments
    print("\n4. Function with *args:")

    def average_score(*scores): # Args is a tuple of variable-length arguments
         # Proof that *args is a tuple of variable length arguments
        print("Scores:", scores, "length:", len(scores))
        print("Type of scores:", type(scores).__name__)
        if scores:
            return sum(scores) / len(scores)
        return 0

    print("Average of scores (80, 90, 85):", average_score(80, 90, 85))
    print("Average of scores (20, 40, 30, 10, 50):", average_score(20, 40, 30, 10, 50))


    # 5. Function with **kwargs
    print("\n5. Function with **kwargs:")

    def display_employee(**details): # **kwargs is a dictionary of keyword arguments of variable length
        # Proof that **kwargs is a dictionary of variable length keyword arguments
        print("Details: "+ details.__str__() + " length:", len(details))
        print("Type of details:", type(details).__name__)
        print("Employee Details:")
        for key, value in details.items():
            print(f"{key}: {value}")

    display_employee(name="Piyush", id="E102", dept="IT")


    # 6. Function with Normal Arguments + *args + **kwargs
    print("\n6. Function with Normal Args + *args + **kwargs:")

    def transaction_summary(customer_id, *amounts, **meta):
        print(f"Customer ID: {customer_id}")
        print("Transaction Amounts:", amounts)
        print("Metadata:")
        for k, v in meta.items():
            print(f"  {k}: {v}")
        print("Total Amount:", sum(amounts))

    transaction_summary("C1001", 200, 450, 300, date="2025-06-05", payment_method="UPI")


if __name__ == "__main__":
    function_examples()