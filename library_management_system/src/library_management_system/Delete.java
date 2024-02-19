package library_management_system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener {

    Conn con = new Conn();
    JTextField bidText, bnText, authorText, langText, priceText, editionText, sidText, snText, courseText, branchText, yearText, semText;
    JButton bsearch, stSearch, deletebk, deleteSt, back;

    Delete() {

        setSize(800, 600);
        setLocation(250, 20);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Issue-Books");

        JLabel heading = new JLabel(" Delete Book Or Student Page");
        heading.setBounds(180, 10, 450, 50);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);

        JLabel bookId = new JLabel("Book Id :");
        bookId.setBounds(20, 120, 100, 20);
        bookId.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bookId);

        bidText = new JTextField();
        bidText.setBounds(170, 120, 80, 30);
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
        sidText.setBounds(550, 120, 80, 30);
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

        deletebk = new JButton("Delete Book");
        deletebk.setBounds(210, 380, 140, 35);
        deletebk.setBackground(new Color(103, 120, 240));
        deletebk.setForeground(new Color(255, 255, 255));
        deletebk.setFont(new Font("Ariel", Font.BOLD, 18));
        deletebk.addActionListener(this);
        deletebk.setFocusable(false);
        add(deletebk);

        deleteSt = new JButton("Delete Student");
        deleteSt.setBounds(550, 380, 180, 35);
        deleteSt.setBackground(new Color(103, 120, 240));
        deleteSt.setForeground(new Color(255, 255, 255));
        deleteSt.setFont(new Font("Ariel", Font.BOLD, 18));
        deleteSt.addActionListener(this);
        deleteSt.setFocusable(false);
        add(deleteSt);

        back = new JButton("Back to Home");
        back.setBounds(550, 440, 180, 35);
        back.setFont(new Font("Ariel", Font.BOLD, 18));
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(103, 120, 240));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Delete();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
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
                        JOptionPane.showMessageDialog(null, "Please enter correct Book Id");
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
            } else if (e.getSource() == deletebk) {
                if (bidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Book Id is required");
                } else if (bnText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter correct Book Id");
                } else {
                    String query = "DELETE FROM book WHERE BINARY book_id=?";
                    PreparedStatement st = con.c.prepareStatement(query);
                    st.setString(1, bidText.getText());
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Book details has been deleted");

                    bidText.setText("");
                    bnText.setText("");
                    authorText.setText("");
                    langText.setText("");
                    priceText.setText("");
                    editionText.setText("");

                }

            } else if (e.getSource() == deleteSt) {
                if (sidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Id is required");
                } else if (snText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter correct Student Id");
                } else {
                    String query = "DELETE FROM student WHERE BINARY student_id=?";
                    PreparedStatement st = con.c.prepareStatement(query);
                    st.setString(1, sidText.getText());
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Student details has been deleted");

                    sidText.setText("");
                    snText.setText("");
                    courseText.setText("");
                    branchText.setText("");
                    yearText.setText("");
                    semText.setText("");
                }

            } else if (e.getSource() == back) {
                this.setVisible(false);
                new HomePage().setVisible(true);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
