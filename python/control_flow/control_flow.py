def if_else():
    print("\n--- Python Control Flow ---")

    # 1. If-Else
    print("\n1. If-Else Statement:")
    age = 22
    if age >= 18: # Execute if age is 18 (inclusive) or older
        print("You are eligible to vote.")
    else: # Execute if age is less than 18
        print("You are not eligible to vote.")

def loops():
    # 2. For Loop
    print("\n2. For Loop (Print even numbers from 1 to 10):")
    for i in range(1, 11):
        if i % 2 == 0: # check if the number is even
            print(i) # print even numbers 

    # 3. While Loop
    print("\n3. While Loop (Count from 1 to 5):")
    count = 1
    while count <= 5: # Execute the loop while value of count is less than or equal to 5
        print("Count:", count) 
        count += 1 # Increment count by 1 in each iteration

def loop_control():
    # 4. Break and Continue
    print("\n4. Break and Continue in Loops:")
    for i in range(5, 11):
        if i % 2 != 0: # check if the number is odd
            print("Skipped odd number")
            continue  # skip odd numbers
        print("First even number after 5:", i)
        break  # exit after finding first even number

    # 5. Pass Statement
    print("\n5. Pass Statement (used as placeholder):")
    for i in range(3):
        if i == 1:
            pass  # Handle this case later
        print(f"Index: {i}")


def loop_else():
    # 6. Loop-Else
    print("\n6. For Loop with Else (Searching for a prime number):")
    nums = [4, 6, 7, 8, 9, 11]
    for n in nums: 
        if n < 2: # Skip numbers less than 2
            continue
        for i in range(2, n): # Check divisibility from 2 to n-1
            if n % i == 0: 
                print(n, "is not prime")
                break
        else:
            print(n, "is prime")  # only runs if inner for loop completes execution without breaki

    print("\nWhile Loop with Else (Count till 3):")
    i = 1
    while i <= 3: # Execute the loop while value of i is less than or equal to 3
        print("i =", i)
        i += 1
    else: # This else block executes after the while loop completes without a break
        print("Loop completed without break")

def match_case():
    # 7. Match-Case (Switch Case Equivalent in Python 3.10+)
    print("\n7. Match-Case Statement (Switch Alternative):")
    day = "Monday"
    match day:
        case "Monday": #If a case is matched, the corresponding block is executed and the rest are skipped
            print("Start of work week")
        case "Friday":
            print("Last working day")
        case "Saturday" | "Sunday":
            print("Weekend!")
        case _:
            print("Midweek day")

def nested_conditions_and_loops():
    # 8. Nested Conditions

    # Nested Conditions Example
    def number_parity_and_sign_check(num):
        if num > 0: # Check if the number is positive
            if num % 2 == 0: # Check if the number is even
                print(f"{num} is a positive even number")
            else:
                print(f"{num} is a positive odd number")
        elif num < 0: # Check if the number is negative
            if(abs(num) % 2 == 0): # Check if the absolute value of the number is even
                print(f"{num} is an even number with negative sign")
            else:
                print(f"{num} is an odd number with negative sign")
        else: 
            print("Number is zero")
        
    nums = [10, -5, 0, 15]
    print("\n8. Nested Conditions Example (Number Classification):")
    for num in nums:
        number_parity_and_sign_check(num)

    # 9. Nested Loops
    print("\n9. Nested Loops (Multiplication Table 1 to 3):")
    for i in range(1, 4):
        for j in range(1, 4):
            print(f"{i} x {j} = {i * j}")
        print("-" * 15)

    # 10. Skill matching
    required_skills = {"Python", "Django", "Flask", "Springboot"}
    resume_skills = ["Python", "Django", "Flask"]
    matched_skills = 0
    print("\n10. Skill Matching:")
    for skill in resume_skills:
        if skill in required_skills: # Check if the skill from resume is in the required skills
            print(f"Matched Skill: {skill}") # If skill matches, print it
            matched_skills += 1 # Increment matched skills count
    print(f"{matched_skills} skills from resume matched out of {len(required_skills)} required skills.")


if __name__ == "__main__":
    if_else()
    loops()
    loop_control()
    loop_else()
    match_case()
    nested_conditions_and_loops()