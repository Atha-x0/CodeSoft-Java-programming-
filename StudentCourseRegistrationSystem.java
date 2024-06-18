import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;
    int enrolled;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolled = 0;
    }

    public boolean isFull() {
        
        return enrolled >= capacity;
    }

    public void registerStudent() {
        if (!isFull()) {
            enrolled++;
        }
    }

    public void removeStudent() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    @Override
    public String toString() {
        return code + " - " + title + ": " + description + " (Capacity: " + capacity + ", Enrolled: " + enrolled + ", Schedule: " + schedule + ")";
    }
}

class Student {
    String studentID;
    String name;
    ArrayList<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (!course.isFull() && !registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.registerStudent();
        } else {
            System.out.println("Course is full or already registered.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.removeStudent();
        } else {
            System.out.println("Course not found in registered courses.");
        }
    }

    public void listCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println(name + " is not registered for any courses.");
        } else {
            System.out.println(name + " is registered for the following courses:");
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }
}

class CourseRegistrationSystem {
    HashMap<String, Course> courses;
    HashMap<String, Student> students;

    public CourseRegistrationSystem() {
        courses = new HashMap<>();
        students = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.code, course);
    }

    public void addStudent(Student student) {
        students.put(student.studentID, student);
    }

    public void listCourses() {
        System.out.println("Available courses:");
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    public void registerStudentForCourse(String studentID, String courseCode) {
        Student student = students.get(studentID);
        Course course = courses.get(courseCode);
        if (student != null && course != null) {
            student.registerCourse(course);
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void dropStudentFromCourse(String studentID, String courseCode) {
        Student student = students.get(studentID);
        Course course = courses.get(courseCode);
        if (student != null && course != null) {
            student.dropCourse(course);
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void listStudentCourses(String studentID) {
        Student student = students.get(studentID);
        if (student != null) {
            student.listCourses();
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Add some coursess
        system.addCourse(new Course("ADE", "ADE", "Anlog and Digital Elentronics", 27, "9-10 AM"));
        system.addCourse(new Course("DSA", "DSA", "Data Structure and Algorithm", 27, " 10-11:00AM"));
        system.addCourse(new Course("DV", "DV", "Data Visualization", 27, " 2-3:00PM"));
        
        // Add some students
        system.addStudent(new Student("DMET1323004", "Atharva Waghale"));
        system.addStudent(new Student("DMET1323010", "Nayan Potdukhe"));
        system.addStudent(new Student("DMET1323020", "Sujal Zade"));
        system.addStudent(new Student("DMET1323015", "Rishikesh Thakre"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            
            System.out.println("\n1. List Courses\n2. Register for Course\n3. Drop Course\n4. List Student Courses\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    system.listCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Here the course code: \nADE \nDSA \nDV");
                    System.out.print("\nEnter Course Code: ");
                    String courseCode = scanner.nextLine();
                    system.registerStudentForCourse(studentID, courseCode);
                    System.out.print("Congrats your successfully enrolled !! ");
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();
                    system.dropStudentFromCourse(studentID, courseCode);
                    System.out.print("Congrats your successfully Drop Course !! ");
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    system.listStudentCourses(studentID);
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
