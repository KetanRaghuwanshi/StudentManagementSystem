# 🎓 Student Management System

A fully functional **JavaFX-based Student Management System**. This GUI-based project allows users to perform core operations like adding, viewing, updating, deleting, and searching student records, with data persistence.

---

## 📋 Features

- 🔐 **Login authentication** (username: `admin`, password: `admin123`)
- ✅ Add new student
- 📖 View all students
- 🔁 Update existing student details
- ❌ Delete a student
- 🔍 Search student by ID
- 📎 Automatically save/load data to/from file (`students.txt`)
- 🚪 Logout to login screen

---

## 🖼️ User Interface
Built entirely using **JavaFX**, the GUI offers a clean and interactive interface:

- Consistent and responsive layout
- Back buttons for navigation between forms
- Search results shown inline

---

## 🛠️ Technologies Used

- ☕ Java (JDK 8+)
- 🎨 JavaFX
- 💡 IntelliJ IDEA (for development)
- 🌐 Git & GitHub (for version control)

---

## 📁 Project Structure

```
📂 StudentManagementSystem/
└── 📂 src/
    ├── 📄 Main.java                // Launches the app via LoginScreen
    ├── 📄 Student.java             // Student data model
    ├── 📄 StudentManagement.java   // Core logic (add/view/update/delete/search/load/save)
    ├── 📄 LoginScreen.java         // Login UI screen
    ├── 📄 Dashboard.java           // Main menu after login
    ├── 📄 AddStudentForm.java      // UI for adding students
    ├── 📄 ViewStudentsTable.java   // UI for viewing all students
    ├── 📄 UpdateStudentForm.java   // UI for updating student data
    ├── 📄 DeleteStudentForm.java   // UI for deleting a student
    └── 📄 SearchStudentForm.java   // UI for searching a student by ID
```

---

## 🚀 How to Run

1. 🌀 Clone the repository:
```bash
git clone https://github.com/KetanRaghuwanshi/StudentManagementSystem.git
```
2. 🛠️ Open the project in IntelliJ IDEA (or any Java IDE)
3. 💾 Make sure MySQL is installed and the Student_management_System database is created with the following table:
4. ▶️ Run `Main.java`
 ```bash
 CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100)
);
```
6. 🔑 Login Credentials:
```
Username: admin
Password: admin123
```

---

## 🌱 Future Enhancements

1. 🌗 Theme toggle (light/dark)
2. 🔍 Search by name or course
3. 📄 Export data to PDF/CSV/Excel
4. 🧑‍🏫 Profile picture support
5. 🧑‍💻 Multi-user system (admin & students)

---

## 👨‍⚕️ Author

- 👨‍💻 Ketan Raghuwanshi
- 📧 ketanraghuwanshi11@gmail.com
- 🔗 [GitHub Profile](https://github.com/KetanRaghuwanshi)

---

⭐️ **Show your support**  
If you like this project, please consider giving it a star ⭐ on GitHub!



