package library_management_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {

    JButton bdetails, sdetails, logout, addBook, statistics, addStu, issueBook, returnBook, delete;

    public HomePage() {

        setSize(700, 500);
        setLocation(300, 100);
        setLayout(null);
        setTitle("Home Page");

        JLabel welcome = new JLabel("Welcome To");
        welcome.setBounds(250, 10, 200, 30);
        welcome.setFont(new Font("Ariel", Font.BOLD, 30));
        welcome.setForeground(new Color(145, 0, 0));
        add(welcome);

        JLabel lms = new JLabel("Library Management System");
        lms.setBounds(150, 40, 450, 40);
        lms.setFont(new Font("Ariel", Font.BOLD, 30));
        lms.setForeground(new Color(145, 0, 0));
        add(lms);

        bdetails = new JButton("Book Details");
        bdetails.setBounds(50, 120, 170, 40);
        bdetails.setFont(new Font("Ariel", Font.BOLD, 18));
        bdetails.setBackground(new Color(103, 120, 240));
        bdetails.setForeground(new Color(255, 255, 255));
        bdetails.addActionListener(this);
        bdetails.setFocusable(false);
        add(bdetails);

        sdetails = new JButton("Student Details");
        sdetails.setBounds(270, 120, 170, 40);
        sdetails.setFont(new Font("Ariel", Font.BOLD, 18));
        sdetails.setBackground(new Color(103, 120, 240));
        sdetails.setForeground(new Color(255, 255, 255));
        sdetails.addActionListener(this);
        sdetails.setFocusable(false);
        add(sdetails);

        statistics = new JButton("Statistics");
        statistics.setBounds(470, 120, 170, 40);
        statistics.setFont(new Font("Ariel", Font.BOLD, 18));
        statistics.setBackground(new Color(103, 120, 240));
        statistics.setForeground(new Color(255, 255, 255));
        statistics.addActionListener(this);
        statistics.setFocusable(false);
        add(statistics);

        addBook = new JButton("Add Book");
        addBook.setBounds(50, 200, 170, 40);
        addBook.setFont(new Font("Ariel", Font.BOLD, 18));
        addBook.setBackground(new Color(103, 120, 240));
        addBook.setForeground(new Color(255, 255, 255));
        addBook.addActionListener(this);
        addBook.setFocusable(false);
        add(addBook);

        addStu = new JButton("Add Student");
        addStu.setBounds(270, 200, 170, 40);
        addStu.setFont(new Font("Ariel", Font.BOLD, 18));
        addStu.setBackground(new Color(103, 120, 240));
        addStu.setForeground(new Color(255, 255, 255));
        addStu.addActionListener(this);
        addStu.setFocusable(false);
        add(addStu);

        issueBook = new JButton("Issue Book");
        issueBook.setBounds(470, 200, 170, 40);
        issueBook.setFont(new Font("Ariel", Font.BOLD, 18));
        issueBook.setBackground(new Color(103, 120, 240));
        issueBook.setForeground(new Color(255, 255, 255));
        issueBook.addActionListener(this);
        issueBook.setFocusable(false);
        add(issueBook);

        returnBook = new JButton("Return Book");
        returnBook.setBounds(50, 280, 170, 40);
        returnBook.setFont(new Font("Ariel", Font.BOLD, 18));
        returnBook.setBackground(new Color(103, 120, 240));
        returnBook.setForeground(new Color(255, 255, 255));
        returnBook.addActionListener(this);
        returnBook.setFocusable(false);
        add(returnBook);

        delete = new JButton("Delete");
        delete.setBounds(270, 280, 170, 40);
        delete.setFont(new Font("Ariel", Font.BOLD, 18));
        delete.setBackground(new Color(103, 120, 240));
        delete.setForeground(new Color(255, 255, 255));
        delete.addActionListener(this);
        delete.setFocusable(false);
        add(delete);

        logout = new JButton("Logout");
        logout.setBounds(470, 280, 170, 40);
        logout.setFont(new Font("Ariel", Font.BOLD, 18));
        logout.setBackground(new Color(103, 120, 240));
        logout.setForeground(new Color(255, 255, 255));
        logout.addActionListener(this);
        logout.setFocusable(false);
        add(logout);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bdetails) {
            this.setVisible(false);
            new BookDetails().setVisible(true);
        } else if (e.getSource() == sdetails) {
            this.setVisible(false);
            new StudentDetails().setVisible(true);
        } else if (e.getSource() == statistics) {
            this.setVisible(false);
            new Statistics().setVisible(true);

        } else if (e.getSource() == addBook) {
            this.setVisible(false);
            new AddBook().setVisible(true);

        } else if (e.getSource() == addStu) {
            this.setVisible(false);
            new AddStudent().setVisible(true);

        } else if (e.getSource() == issueBook) {
            this.setVisible(false);
            new IssueBooks().setVisible(true);

        } else if (e.getSource() == returnBook) {
            this.setVisible(false);
            new ReturnBooks().setVisible(true);

        } else if (e.getSource() == logout) {
            this.setVisible(false);
            new Login().setVisible(true);

        } else if (e.getSource() == delete) {
            this.setVisible(false);
            new Delete().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }

}
