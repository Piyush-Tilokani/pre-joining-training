import timeit, sys

# Function to create and display sets including from different data types
def create_and_display_sets():
    empty_set = set()
    numbers_set = {15, 20, 37, 49, 63}
    mixed_set = {"Python", 42, True}
    duplicate_set = {1, 2, 2, 3, 3, 3}

    # Additional set creations
    set_from_list = set(["apple", "banana", "apple"])
    set_from_range = set(range(5))
    set_from_tuple = set((10, 20, 10, 30))
    set_from_loop = {x * 2 for x in range(5)}

    print("Empty Set:", empty_set)
    print("Numbers Set:", numbers_set)
    print("Mixed Set:", mixed_set)
    print("Duplicate Set (Duplicates Removed Automatically):", duplicate_set)
    print("Set from List:", set_from_list)
    print("Set from Range:", set_from_range)
    print("Set from Tuple:", set_from_tuple)
    print("Set from For Loop (x*2):", set_from_loop)


# Function to demonstrate basic set operations
def basic_set_operations():
    fruits = {"Apple", "Banana", "Cherry"}
    print("\nOriginal Set:", fruits)

    fruits.add("Mango")             # Add single item
    fruits.update(["Orange", "Grape"])  # Add multiple items
    print("After Adding Elements:", fruits)

    fruits.remove("Banana")         # Removes 'Banana' (throws error if not present)
    fruits.discard("Pineapple")     # Does not throw error if item not present
    print("After Removing Elements:", fruits)

    popped = fruits.pop()           # Removes and returns an arbitrary/random element
    print("Popped Element:", popped)
    print("After Popping:", fruits)

    fruits.clear()                  # Remove all elements
    print("After Clearing:", fruits)


# Function to demonstrate set operations between two sets including alternative operators
def set_math_operations():
    set_a = {1, 2, 3, 4}
    set_b = {3, 4, 5, 6}

    print("\nSet A:", set_a)
    print("Set B:", set_b)

    # Union
    print("Union using union():", set_a.union(set_b))  # Combine elements from both sets 
    print("Union using |:", set_a | set_b)             # Equivalent operator

    # Intersection
    print("Intersection using intersection():", set_a.intersection(set_b))  # Common elements
    print("Intersection using &:", set_a & set_b)                           # Equivalent operator

    # Difference
    print("Difference using difference():", set_a.difference(set_b))  # Elements in A that are not in B
    print("Difference using -:", set_a - set_b)                        # Equivalent operator

    # Symmetric Difference
    print("Symmetric Difference using symmetric_difference():", set_a.symmetric_difference(set_b))  # Elements that are either in A or B, not both
    print("Symmetric Difference using ^:", set_a ^ set_b)                                          # Equivalent operator

    # Comparison operations
    print("Set A is a subset of Set B:", set_a.issubset(set_b))
    print("Set A is equal to Set B:", set_a == set_b)
    print("Set A is not equal to Set B:", set_a != set_b)
    print("Set A > Set B (Proper Superset):", set_a > set_b) # Proper superset
    print("Set A < Set B (Proper Subset):", set_a < set_b) # Proper subset
    print("Set A >= Set B:", set_a >= set_b) # Proper superset or equal
    print("Set A <= Set B:", set_a <= set_b) # Proper subset or equal
    print("Set A is disjoint with Set B:", set_a.isdisjoint(set_b))  # No common elements


# Function to demonstrate frozenset and immutability
def frozenset_demo():
    normal_set = {1, 2, 3}
    frozen = frozenset(normal_set)

    print("\nNormal Set:", normal_set)
    print("Frozen Set:", frozen)

    # Demonstrating immutability of frozenset
    try:
        frozen.add(4)
    except AttributeError as e:
        print("Error on adding to frozenset:", e)

    try:
        frozen.remove(1)
    except AttributeError as e:
        print("Error on removing from frozenset:", e)

    print("Frozen Set supports union:", frozen.union({3, 4})) # Union with another set creates a new frozenset
    print("Frozen Set supports intersection:", frozen.intersection({2, 3})) # Intersection with another set creates a new frozenset


# Function to demonstrate membership and looping
def membership_and_looping():
    tools = {"Hammer", "Wrench", "Screwdriver"}
    print("\nTool Set:", tools)

    print("Is 'Hammer' in the set?", "Hammer" in tools)
    print("Is 'Drill' not in the set?", "Drill" not in tools)

    print("Looping through the set:")
    for tool in tools:
        print(tool)


# Function to demonstrate set relations
def set_relations():
    set_x = {1, 2}
    set_y = {1, 2, 3, 4}
    set_z = {1, 2}

    print("\nSubset:", set_x.issubset(set_y))
    print("Superset:", set_y.issuperset(set_x))
    print("Disjoint Sets (no common elements):", set_x.isdisjoint({5, 6}))
    print("set_x == set_z:", set_x == set_z) # Check if sets have the same elements
    print("set_x is set_z:", set_x is set_z) # Check if they are the same object in memory


# Function to demonstrate real-world use cases of sets
def set_use_cases():
    print("\nReal-World Use Cases of Sets:")

    # 1. Removing Duplicate Product IDs in Inventory
    product_ids = [101, 102, 103, 101, 104, 102]
    unique_product_ids = set(product_ids)
    print("\nUnique Product IDs (Duplicates Removed):", unique_product_ids)

    # 2. Fast Membership Testing
    blacklisted_ips = {"192.168.0.2", "10.0.0.3", "172.16.5.4"}
    incoming_ip = "10.0.0.3"
    if incoming_ip in blacklisted_ips:
        print(f"{incoming_ip} is blocked (in blacklist).")
    else:
        print(f"{incoming_ip} is allowed.")

    # 3. Finding Common Elements (Intersection)
    applicants_python = {"Alice", "Bob", "Charlie", "David"}
    applicants_java = {"Eve", "Charlie", "Alice", "Frank"}
    skilled_in_both = applicants_python & applicants_java
    print("\nApplicants skilled in both Python and Java:", skilled_in_both)

    # 4. Finding Unique Skills in One Group (Difference)
    only_python = applicants_python - applicants_java
    print("Applicants skilled only in Python:", only_python)

    # 5. Tags on Articles (for recommendation systems)
    article1_tags = {"AI", "ML", "Python"}
    article2_tags = {"Blockchain", "AI", "Python"}
    common_tags = article1_tags.intersection(article2_tags)
    all_tags = article1_tags.union(article2_tags)
    print("\nCommon Tags:", common_tags)
    print("All Tags Combined:", all_tags)


# Function to analyze performance of set vs tuple vs list
def analyze_performance():
    setup_code = '''
data_list = list(range(100000))
data_tuple = tuple(data_list)
data_set = set(data_list)
target = 99999
'''

    # Membership Test
    list_membership_time = timeit.timeit("target in data_list", setup=setup_code, number=1000)
    tuple_membership_time = timeit.timeit("target in data_tuple", setup=setup_code, number=1000)
    set_membership_time = timeit.timeit("target in data_set", setup=setup_code, number=1000)

    # Iteration Test
    list_iteration_time = timeit.timeit("for x in data_list: pass", setup=setup_code, number=1000)
    tuple_iteration_time = timeit.timeit("for x in data_tuple: pass", setup=setup_code, number=1000)
    set_iteration_time = timeit.timeit("for x in data_set: pass", setup=setup_code, number=1000)

    # Creation Time
    creation_time_list = timeit.timeit("list(range(100000))", number=1000)
    creation_time_tuple = timeit.timeit("tuple(range(100000))", number=1000)
    creation_time_set = timeit.timeit("set(range(100000))", number=1000)

    # Conversion Time from list
    conversion_to_tuple = timeit.timeit("tuple(data_list)", setup=setup_code, number=1000)
    conversion_to_set = timeit.timeit("set(data_list)", setup=setup_code, number=1000)

    # Memory usage
    data_list = list(range(100000))
    data_tuple = tuple(data_list)
    data_set = set(data_list)
    memory_list = sys.getsizeof(data_list)
    memory_tuple = sys.getsizeof(data_tuple)
    memory_set = sys.getsizeof(data_set)

    # Print formatted results
    print("\nPerformance Analysis of List, Tuple, and Set:")
    print(f"{'Operation':<30} {'List':>15} {'Tuple':>15} {'Set':>15}")
    print("-" * 80)
    print(f"{'Membership Test Time':<30} {list_membership_time:>15.6f} {tuple_membership_time:>15.6f} {set_membership_time:>15.6f}")
    print(f"{'Iteration Time':<30} {list_iteration_time:>15.6f} {tuple_iteration_time:>15.6f} {set_iteration_time:>15.6f}")
    print(f"{'Creation Time':<30} {creation_time_list:>15.6f} {creation_time_tuple:>15.6f} {creation_time_set:>15.6f}")
    print(f"{'Conversion from List':<30} {'-':>15} {conversion_to_tuple:>15.6f} {conversion_to_set:>15.6f}")
    print(f"{'Memory Usage (bytes)':<30} {memory_list:>15} {memory_tuple:>15} {memory_set:>15}")


if __name__ == "__main__":
    create_and_display_sets()
    basic_set_operations()
    set_math_operations()
    frozenset_demo()
    membership_and_looping()
    set_relations()
    set_use_cases()
    analyze_performance()