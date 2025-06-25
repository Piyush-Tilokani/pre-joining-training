# Core Java Training

This module contains Java programs covering the foundational to advanced topics in Core Java. The structure is organized by concepts, allowing for topic-wise study and execution.

## Development Environment

| Tool/Technology     | Version     |
|---------------------|-------------|
| Java                | 18.0.2.1    |
| Eclipse             | 4.35.0        |
| MySQL               | 8.0.42      |

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Piyush-Tilokani/pre-joining-training.git
   ```

2. **Open Project in Eclipse:**
   - Launch Eclipse.
   - Choose `File > Open Projects from File System`.
   - Browse and select the `coreJava` directory.

3. **Set Up Configuration:**
   - In `src/`, rename the file:
     ```
     config.properties.example → config.properties
     ```
   - Open the newly renamed file and add your database configuration:
     ```properties
     db.url=jdbc:mysql://localhost:3306/company
     db.user=root
     db.password=
     ```

4. **Run Java Files:**
   - Browse to any topic folder under `src/` in Eclipse.
   - Right-click on any `.java` file with a `main()` method.
   - Select `Run As > Java Application`.

---

## Folder Structure

| Directory Name           | Topics Covered                             |
|--------------------------|---------------------------------------------|
| `basics`                 | Syntax, input/output, class structure       |
| `datatypeandmodifiers`   | Data types, type casting, access modifiers  |
| `loopanddecisionmaking`  | Loops (`for`, `while`, `do-while`), conditions (`if`, `switch`) |
| `collections`            | List, Set, Map, Queue interfaces and classes|
| `stringsandarrays`       | String manipulation, arrays, arraylists     |
| `pillarsOfOOPS`          | Inheritance, Polymorphism, Abstraction, Encapsulation |
| `exceptionhandling`      | try-catch, throw, throws, custom exceptions |
| `fileReadWrite`          | File reading and writing with streams       |
| `multithreading`         | Threads, synchronization, lifecycle         |
| `jdbc`                   | MySQL DB connections using JDBC             |
| `JSON`                   | Reading/writing JSON using Java libraries   |
| `xml`                    | Reading/writing XML using Java libraries    |

---
