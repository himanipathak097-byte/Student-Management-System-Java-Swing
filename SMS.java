import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String name;
    String roll;
    String course;

    Student(String name, String roll, String course) {
        this.name = name;
        this.roll = roll;
        this.course = course;
    }

    public String toString() {
        return "Name: " + name + ", Roll: " + roll + ", Course: " + course;
    }
}

public class SMS extends JFrame {

    ArrayList<Student> students = new ArrayList<>();
    JTextField nameField, rollField, courseField;
    JTextArea displayArea;

    SMS() {
        setTitle("Student Management System");
        setSize(500, 400);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(15);   add(nameField);
        add(new JLabel("Roll No:"));
        rollField = new JTextField(15);   add(rollField);
        add(new JLabel("Course:"));
        courseField = new JTextField(15); add(courseField);

        JButton addBtn    = new JButton("Add Student");
        JButton viewBtn   = new JButton("View Students");
        JButton deleteBtn = new JButton("Delete Student");
        add(addBtn); add(viewBtn); add(deleteBtn);

        displayArea = new JTextArea(10, 40);
        add(new JScrollPane(displayArea));

        addBtn.addActionListener(e -> {
            String name   = nameField.getText();
            String roll   = rollField.getText();
            String course = courseField.getText();
            if (name.isEmpty() || roll.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            } else {
                students.add(new Student(name, roll, course));
                JOptionPane.showMessageDialog(this, "Student Added!");
                nameField.setText("");
                rollField.setText("");
                courseField.setText("");
            }
        });

        viewBtn.addActionListener(e -> {
            displayArea.setText("");
            for (Student s : students) {
                displayArea.append(s.toString() + "\n");
            }
        });

        deleteBtn.addActionListener(e -> {
            String roll = rollField.getText();
            students.removeIf(s -> s.roll.equals(roll));
            JOptionPane.showMessageDialog(this,
"Student Deleted (if existed)");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SMS();
    }
}

