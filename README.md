# 🎓 Student Management System

A **JavaFX-based** Student Management System with **JDBC** integration for data persistence. This project allows users to perform basic operations like adding, viewing, updating, and deleting student records, with secure login authentication and a modern graphical user interface (GUI).

---

## 📋 Features

- 🔐 **Login authentication** (username: `admin`, password: `admin123`)
- ✅ Add new student records
- 📖 View all student records in a table
- 🔁 Update existing student details
- ❌ Delete a student record
- 💾 Data persistence using **JDBC** with **MySQL** (instead of file handling)
- 🚪 Exit the application

---

## 🛠️ Technologies Used

- ☕ **Java** (JDK 8+)
- 🌐 **MySQL** (for data storage)
- 🖥️ **JavaFX** (for GUI)
- 💡 **IntelliJ IDEA** (for development)
- 🌍 **Git & GitHub** (for version control)

---

## 📁 Project Structure
📂 StudentManagementSystem/
├── 📁 src/
│ ├── 📄 Main.java // Launches the JavaFX application
│ ├── 📄 Student.java // Student data model
│ ├── 📄 StudentManagement.java // Core logic (CRUD operations)
│ ├── 📄 LoginScreen.java // User login/authentication (JavaFX)
│ ├── 📄 Dashboard.java // Main dashboard view (JavaFX)
│ └── 📄 DatabaseConnection.java // Database connection logic (JDBC)



---

## 🚀 How to Run

1. 🌀 Clone the repository:
   ```bash
   git clone https://github.com/KetanRaghuwanshi/StudentManagementSystem.git
   
2. 🛠️ Open the project in IntelliJ IDEA or any Java IDE.

3. 💾 Make sure MySQL is installed and the Student_management_System database is created with the following table:

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100)
);

4. 📝 Modify the DatabaseConnection.java file with your MySQL credentials if necessary (default: root, password: Ketan@2002).

5. ▶️ Run Main.java to launch the application.

6. 🔑 Login Credentials:

Username: admin
Password: admin123

🌱 Future Enhancements
🖼️ Build a more advanced GUI version using JavaFX, adding more user-friendly features.
🧑‍💻 Add user registration (not just hardcoded login).
✅ Implement input validation (e.g., unique student IDs, valid age ranges).
📤 Export data to CSV or Excel for reporting.

🙋‍♂️ Author
👨‍💻 Ketan Raghuwanshi
📧 ketanraghuwanshi11@gmail.com
🔗 GitHub Profile


