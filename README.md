🎓 Student Management System
A JavaFX-based Student Management System with JDBC integration for data persistence. This project allows users to perform basic operations like adding, viewing, updating, and deleting student records, with secure login authentication and a modern graphical user interface (GUI).

📋 Features
🔐 Login authentication (username: admin, password: admin123)

✅ Add new student records

📖 View all student records in a table

🔁 Update existing student details

❌ Delete a student record

💾 Data persistence using JDBC with MySQL (instead of file handling)

🚪 Exit the application

🛠️ Technologies Used
☕ Java (JDK 8+)

🌐 MySQL (for data storage)

🖥️ JavaFX (for GUI)

💡 IntelliJ IDEA (for development)

🌍 Git & GitHub (for version control)

📁 Project Structure
📂 StudentManagementSystem/
├── 📁 src/
│ ├── 📄 Main.java // Launches the JavaFX application
│ ├── 📄 Student.java // Student data model
│ ├── 📄 StudentManagement.java // Core logic (CRUD operations)
│ ├── 📄 LoginScreen.java // User login/authentication (JavaFX)
│ ├── 📄 Dashboard.java // Main dashboard view (JavaFX)
│ └── 📄 DatabaseConnection.java // Database connection logic (JDBC)

🚀 How to Run
🌀 Clone the repository:

bash
Copy code
git clone https://github.com/KetanRaghuwanshi/StudentManagementSystem.git
🛠️ Open the project in IntelliJ IDEA or any Java IDE.

💾 Make sure MySQL is installed and the Student_management_System database is created with the following table:

sql
Copy code
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100)
);
📝 Modify the DatabaseConnection.java file with your MySQL credentials if necessary (default: root, password: Ketan@2002).

▶️ Run Main.java to launch the application.

🔑 Login Credentials:

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

⭐️ Show Your Support
If you like this project, consider starring ⭐ it on GitHub!


