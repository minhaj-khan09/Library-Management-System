package library_management_system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener {

    JTextField sidText, snText, fText;
    JComboBox courseText, branchText, yearText, semText;
    JButton add, back, vas, exit;

    public AddStudent() {

        setSize(450, 450);
        setLayout(null);
        setLocation(400, 100);
        setUndecorated(true);
        setTitle("Add Student");
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Student Adding Page");
        heading.setBounds(80, 10, 300, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);

        JLabel sId = new JLabel("Student Id :");
        sId.setBounds(50, 70, 120, 20);
        sId.setFont(new Font("Ariel", Font.BOLD, 18));
        add(sId);

        sidText = new JTextField();
        sidText.setBounds(200, 70, 200, 30);
        sidText.setFont(new Font("Ariel", Font.BOLD, 18));
        add(sidText);

        JLabel SName = new JLabel("Student Name :");
        SName.setBounds(50, 105, 140, 20);
        SName.setFont(new Font("Ariel", Font.BOLD, 18));
        add(SName);

        snText = new JTextField();
        snText.setBounds(200, 105, 200, 30);
        snText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(snText);

        JLabel author = new JLabel("Father :");
        author.setBounds(50, 140, 100, 20);
        author.setFont(new Font("Ariel", Font.BOLD, 18));
        add(author);

        fText = new JTextField();
        fText.setBounds(200, 140, 200, 30);
        fText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(fText);

        JLabel lang = new JLabel("Course :");
        lang.setBounds(50, 175, 100, 20);
        lang.setFont(new Font("Ariel", Font.BOLD, 18));
        add(lang);

        courseText = new JComboBox();
        courseText.setModel(new DefaultComboBoxModel(new String[]{"Select Course", "B.Tech", "M.Tech", "M.C.A", "B.Sc", "B.C.A", "Other"}));
        courseText.setBounds(200, 175, 200, 30);
        courseText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(courseText);

        JLabel price = new JLabel("Branch :");
        price.setBounds(50, 210, 100, 20);
        price.setFont(new Font("Ariel", Font.BOLD, 18));
        add(price);

        branchText = new JComboBox();
        branchText.setModel(new DefaultComboBoxModel(new String[]{"Select Branch", "Computer Science", "Mechanical", "Electrical", "Civil", "Mathematics", "Physics", "Chemistry", "Other"}));
        branchText.setBounds(200, 210, 200, 30);
        branchText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(branchText);

        JLabel edition = new JLabel("Year :");
        edition.setBounds(50, 245, 100, 20);
        edition.setFont(new Font("Ariel", Font.BOLD, 18));
        add(edition);

        yearText = new JComboBox();
        yearText.setModel(new DefaultComboBoxModel(new String[]{"Select Year", "1", "2", "3", "4"}));
        yearText.setBounds(200, 245, 200, 30);
        yearText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(yearText);

        JLabel sem = new JLabel("Semester :");
        sem.setBounds(50, 280, 100, 20);
        sem.setFont(new Font("Ariel", Font.BOLD, 18));
        add(sem);

        semText = new JComboBox();
        semText.setModel(new DefaultComboBoxModel(new String[]{"Select Semester", "1", "2", "3", "4", "5", "6", "7", "8"}));
        semText.setBounds(200, 280, 200, 30);
        semText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(semText);

        add = new JButton("Add Student");
        add.setBounds(30, 350, 160, 35);
        add.setBackground(new Color(103, 120, 240));
        add.setForeground(new Color(255, 255, 255));
        add.setFont(new Font("Ariel", Font.BOLD, 20));
        add.addActionListener(this);
        add.setFocusable(false);
        add(add);

        exit = new JButton("Exit");
        exit.setBounds(30, 395, 160, 35);
        exit.setBackground(new Color(103, 120, 240));
        exit.setForeground(new Color(255, 255, 255));
        exit.setFont(new Font("Ariel", Font.BOLD, 20));
        exit.addActionListener(this);
        exit.setFocusable(false);
        add(exit);

        back = new JButton("Back to Home");
        back.setBounds(215, 350, 170, 35);
        back.setBackground(new Color(103, 120, 240));
        back.setForeground(new Color(255, 255, 255));
        back.setFont(new Font("Ariel", Font.BOLD, 20));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        vas = new JButton("View all Students");
        vas.setBounds(200, 395, 200, 35);
        vas.setFont(new Font("Ariel", Font.BOLD, 20));
        vas.setForeground(new Color(255, 255, 255));
        vas.setBackground(new Color(103, 120, 240));
        vas.addActionListener(this);
        vas.setFocusable(false);
        add(vas);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Conn con = new Conn();
        try {
            if (e.getSource() == vas) {
                this.setVisible(false);
                new StudentDetails().setVisible(true);
            } else if (e.getSource() == back) {
                this.setVisible(false);
                new HomePage().setVisible(true);

            } else if (e.getSource() == exit) {
                this.dispose();
            } else if (e.getSource() == add) {
                if (sidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Id is Required");
                } else if (snText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Name is Required");
                } else if (fText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Father Name is Required");
                } else if (courseText.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Course is Required");
                } else if (branchText.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Branch is Required");
                } else if (yearText.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Year is Required");
                } else if (semText.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Semester is Required");
                } else {
                    String query = "INSERT INTO student (student_id,name,father,course,branch,year,semester) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement st = con.c.prepareStatement(query);

                    st.setString(1, sidText.getText());
                    st.setString(2, snText.getText());
                    st.setString(3, fText.getText());
                    st.setString(4, (String) courseText.getSelectedItem());
                    st.setString(5, (String) branchText.getSelectedItem());
                    st.setString(6, (String) yearText.getSelectedItem());
                    st.setString(7, (String) semText.getSelectedItem());

                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Student has been added");

                    sidText.setText("");
                    snText.setText("");
                    fText.setText("");
                    courseText.setSelectedIndex(0);
                    branchText.setSelectedIndex(0);
                    yearText.setSelectedIndex(0);
                    semText.setSelectedIndex(0);
                }

            }

        } catch (SQLIntegrityConstraintViolationException de) {
            // Handle duplicate entry exception
            String errorMessage = de.getMessage();
            if (errorMessage.contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Student ID already exists. Please choose a different Student ID.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            } else {
                de.printStackTrace();
            }
        } catch(SQLException sq){
            sq.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddStudent();
    }

}
