package library_management_system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class IssueBooks extends JFrame implements ActionListener {

    JTextField bidText, bnText, authorText, langText, priceText, editionText, sidText, snText, courseText, branchText, yearText, semText;
    JButton bsearch, stSearch, iob, back;
    JDateChooser dioText;

    IssueBooks() {

        setSize(800, 600);
        setLocation(250, 20);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Issue-Books");

        JLabel heading = new JLabel("Book Issue Page");
        heading.setBounds(280, 10, 350, 50);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);

        JLabel bookId = new JLabel("Book Id :");
        bookId.setBounds(20, 120, 100, 20);
        bookId.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bookId);

        bidText = new JTextField();
        bidText.setBounds(170, 120, 90, 30);
        bidText.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bidText);

        JLabel bName = new JLabel("Book Name :");
        bName.setBounds(20, 155, 120, 20);
        bName.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bName);

        bnText = new JTextField();
        bnText.setBounds(170, 155, 180, 30);
        bnText.setFont(new Font("Ariel", Font.ITALIC, 16));
        bnText.setEditable(false);
        add(bnText);

        JLabel author = new JLabel("Author :");
        author.setBounds(20, 190, 100, 20);
        author.setFont(new Font("Ariel", Font.BOLD, 18));
        add(author);

        authorText = new JTextField();
        authorText.setBounds(170, 190, 180, 30);
        authorText.setFont(new Font("Ariel", Font.ITALIC, 16));
        authorText.setEditable(false);
        add(authorText);

        JLabel lang = new JLabel("Language :");
        lang.setBounds(20, 225, 100, 20);
        lang.setFont(new Font("Ariel", Font.BOLD, 18));
        add(lang);

        langText = new JTextField();
        langText.setBounds(170, 225, 180, 30);
        langText.setFont(new Font("Ariel", Font.ITALIC, 16));
        langText.setEditable(false);
        add(langText);

        JLabel price = new JLabel("Price :");
        price.setBounds(20, 260, 100, 20);
        price.setFont(new Font("Ariel", Font.BOLD, 18));
        add(price);

        priceText = new JTextField();
        priceText.setBounds(170, 260, 180, 30);
        priceText.setFont(new Font("Ariel", Font.ITALIC, 16));
        priceText.setEditable(false);
        add(priceText);

        JLabel edition = new JLabel("Edition :");
        edition.setBounds(20, 295, 100, 20);
        edition.setFont(new Font("Ariel", Font.BOLD, 18));
        add(edition);

        editionText = new JTextField();
        editionText.setBounds(170, 295, 180, 30);
        editionText.setFont(new Font("Ariel", Font.ITALIC, 16));
        editionText.setEditable(false);
        add(editionText);

        bsearch = new JButton("Search");
        bsearch.setBounds(265, 120, 86, 30);
        bsearch.setBackground(new Color(103, 120, 240));
        bsearch.setForeground(new Color(255, 255, 255));
        bsearch.setFont(new Font("Ariel", Font.BOLD, 15));
        bsearch.addActionListener(this);
        bsearch.setFocusable(false);
        add(bsearch);

        JLabel stuId = new JLabel("Student Id :");
        stuId.setBounds(400, 120, 110, 20);
        stuId.setFont(new Font("Ariel", Font.BOLD, 18));
        add(stuId);

        sidText = new JTextField();
        sidText.setBounds(550, 120, 90, 30);
        sidText.setFont(new Font("Ariel", Font.BOLD, 16));
        add(sidText);

        JLabel sName = new JLabel("Student Name :");
        sName.setBounds(400, 155, 140, 20);
        sName.setFont(new Font("Ariel", Font.BOLD, 18));
        add(sName);

        snText = new JTextField();
        snText.setBounds(550, 155, 180, 30);
        snText.setFont(new Font("Ariel", Font.ITALIC, 16));
        snText.setEditable(false);
        add(snText);

        JLabel course = new JLabel("Course :");
        course.setBounds(400, 190, 110, 20);
        course.setFont(new Font("Ariel", Font.BOLD, 18));
        add(course);

        courseText = new JTextField();
        courseText.setBounds(550, 190, 180, 30);
        courseText.setFont(new Font("Ariel", Font.ITALIC, 16));
        courseText.setEditable(false);
        add(courseText);

        JLabel branch = new JLabel("branch :");
        branch.setBounds(400, 225, 110, 20);
        branch.setFont(new Font("Ariel", Font.BOLD, 18));
        add(branch);

        branchText = new JTextField();
        branchText.setBounds(550, 225, 180, 30);
        branchText.setFont(new Font("Ariel", Font.ITALIC, 16));
        branchText.setEditable(false);
        add(branchText);

        JLabel year = new JLabel("Year :");
        year.setBounds(400, 260, 110, 20);
        year.setFont(new Font("Ariel", Font.BOLD, 18));
        add(year);

        yearText = new JTextField();
        yearText.setBounds(550, 260, 180, 30);
        yearText.setFont(new Font("Ariel", Font.ITALIC, 16));
        yearText.setEditable(false);
        add(yearText);

        JLabel sem = new JLabel("Semester :");
        sem.setBounds(400, 295, 110, 20);
        sem.setFont(new Font("Ariel", Font.BOLD, 18));
        add(sem);

        semText = new JTextField();
        semText.setBounds(550, 295, 180, 30);
        semText.setFont(new Font("Ariel", Font.ITALIC, 16));
        semText.setEditable(false);
        add(semText);

        stSearch = new JButton("Search");
        stSearch.setBounds(645, 120, 86, 30);
        stSearch.setBackground(new Color(103, 120, 240));
        stSearch.setForeground(new Color(255, 255, 255));
        stSearch.setFont(new Font("Ariel", Font.BOLD, 15));
        stSearch.addActionListener(this);
        stSearch.setFocusable(false);
        add(stSearch);

        JLabel doi = new JLabel("Date of Issue :");
        doi.setFont(new Font("Ariel", Font.BOLD, 18));
        doi.setBounds(20, 330, 130, 26);
        add(doi);

        dioText = new JDateChooser();
        dioText.setBounds(170, 330, 180, 30);
        dioText.setFont(new Font("Ariel", Font.BOLD, 15));
        add(dioText);

        iob = new JButton("Issue Book");
        iob.setBounds(210, 380, 140, 35);
        iob.setBackground(new Color(103, 120, 240));
        iob.setForeground(new Color(255, 255, 255));
        iob.setFont(new Font("Ariel", Font.BOLD, 18));
        iob.addActionListener(this);
        iob.setFocusable(false);
        add(iob);

        back = new JButton("Back to Home");
        back.setBounds(550, 380, 180, 35);
        back.setFont(new Font("Ariel", Font.BOLD, 18));
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(103, 120, 240));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Conn con = new Conn();
            if (e.getSource() == bsearch) {

                if (bidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Book Id is required");
                } else {
                    String query = "SELECT * FROM book WHERE BINARY book_id=?";
                    PreparedStatement st = con.c.prepareStatement(query);
                    st.setString(1, bidText.getText());
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        bnText.setText(rs.getString("name"));
                        authorText.setText(rs.getString("author"));
                        langText.setText(rs.getString("language"));
                        priceText.setText(rs.getString("price"));
                        editionText.setText(rs.getString("edition"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Pelese enter correct Book Id");
                    }
                }

            } else if (e.getSource() == stSearch) {

                if (sidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Id is required");
                } else {
                    String query = "SELECT * FROM student WHERE BINARY student_id=?";
                    PreparedStatement st = con.c.prepareStatement(query);
                    st.setString(1, sidText.getText());
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        snText.setText(rs.getString("name"));
                        courseText.setText(rs.getString("course"));
                        branchText.setText(rs.getString("branch"));
                        yearText.setText(rs.getString("year"));
                        semText.setText(rs.getString("semester"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter correct Student Id");
                    }
                }

            } else if (e.getSource() == iob) {
                if (bidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Book Id is required");
                } else if (sidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Id is required");
                } else if (dioText.getDateEditor().getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please enter date of issue");
                } else if (snText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter correct Book Id and Student Id");
                } else {
                    String query = "INSERT INTO issuebook (book_id,student_id,bname,sname,course,branch,date_of_issue) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement st = con.c.prepareStatement(query);
                    st.setString(1, bidText.getText());
                    st.setString(2, sidText.getText());
                    st.setString(3, bnText.getText());
                    st.setString(4, snText.getText());
                    st.setString(5, courseText.getText());
                    st.setString(6, branchText.getText());
                    st.setString(7, ((JTextField) dioText.getDateEditor().getUiComponent()).getText());
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");

                    bidText.setText("");
                    sidText.setText("");
                    bnText.setText("");
                    snText.setText("");
                    courseText.setText("");
                    branchText.setText("");
                    authorText.setText("");
                    langText.setText("");
                    priceText.setText("");
                    editionText.setText("");
                    yearText.setText("");
                    semText.setText("");
                    dioText.setDate(null);
                }

            } else if (e.getSource() == back) {
                this.setVisible(false);
                new HomePage().setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new IssueBooks();
    }
}
