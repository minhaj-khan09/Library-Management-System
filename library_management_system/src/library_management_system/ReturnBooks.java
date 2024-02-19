package library_management_system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ReturnBooks extends JFrame implements ActionListener {

    Conn con = new Conn();
    JTextField bidText, sidText, bnText, snText, courseText, branchText, issueDate;
    JDateChooser returndate;
    JButton search, rob, back;

    public ReturnBooks() {
        setSize(800, 600);
        setLocation(250, 20);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Return Book Page");
        heading.setBounds(280, 10, 350, 50);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);

        JLabel bookId = new JLabel("Book Id :");
        bookId.setBounds(20, 100, 100, 20);
        bookId.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bookId);

        bidText = new JTextField();
        bidText.setBounds(170, 100, 80, 30);
        bidText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(bidText);

        JLabel stuId = new JLabel("Student Id :");
        stuId.setBounds(20, 150, 110, 20);
        stuId.setFont(new Font("Ariel", Font.BOLD, 18));
        add(stuId);

        sidText = new JTextField();
        sidText.setBounds(170, 150, 80, 30);
        sidText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(sidText);

        JLabel bName = new JLabel("Book Name :");
        bName.setBounds(400, 150, 150, 25);
        bName.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bName);

        bnText = new JTextField();
        bnText.setBounds(550, 250, 180, 30);
        bnText.setFont(new Font("Ariel", Font.ITALIC, 16));
        bnText.setEditable(false);
        add(bnText);

        JLabel sName = new JLabel("Student Name :");
        sName.setBounds(400, 100, 140, 20);
        sName.setFont(new Font("Ariel", Font.BOLD, 18));
        add(sName);

        snText = new JTextField();
        snText.setBounds(550, 100, 180, 30);
        snText.setFont(new Font("Ariel", Font.ITALIC, 16));
        snText.setEditable(false);
        add(snText);

        search = new JButton("Search");
        search.setBounds(260, 150, 90, 30);
        search.setBackground(new Color(103, 120, 240));
        search.setForeground(new Color(255, 255, 255));
        search.setFont(new Font("Ariel", Font.BOLD, 16));
        search.addActionListener(this);
        search.setFocusable(false);
        add(search);

        JLabel course = new JLabel("Course :");
        course.setBounds(400, 200, 110, 20);
        course.setFont(new Font("Ariel", Font.BOLD, 18));
        add(course);

        courseText = new JTextField();
        courseText.setBounds(550, 150, 180, 30);
        courseText.setFont(new Font("Ariel", Font.ITALIC, 16));
        courseText.setEditable(false);
        add(courseText);

        JLabel branch = new JLabel("branch :");
        branch.setBounds(400, 250, 110, 20);
        branch.setFont(new Font("Ariel", Font.BOLD, 18));
        add(branch);

        branchText = new JTextField();
        branchText.setBounds(550, 200, 180, 30);
        branchText.setFont(new Font("Ariel", Font.ITALIC, 16));
        branchText.setEditable(false);
        add(branchText);

        JLabel doi = new JLabel("Date of Issue :");
        doi.setFont(new Font("Ariel", Font.BOLD, 18));
        doi.setBounds(20, 200, 150, 20);
        add(doi);

        issueDate = new JTextField();
        issueDate.setBounds(170, 200, 180, 30);
        issueDate.setFont(new Font("Ariel", Font.ITALIC, 16));
        issueDate.setEditable(false);
        add(issueDate);

        JLabel dor = new JLabel("Date of Return :");
        dor.setFont(new Font("Ariel", Font.BOLD, 18));
        dor.setBounds(20, 250, 150, 26);
        add(dor);

        returndate = new JDateChooser();
        returndate.setBounds(170, 250, 180, 30);
        returndate.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(returndate);

        rob = new JButton("Return Book");
        rob.setBounds(170, 320, 130, 35);
        rob.setBackground(new Color(103, 120, 240));
        rob.setForeground(new Color(255, 255, 255));
        rob.setFont(new Font("Ariel", Font.BOLD, 16));
        rob.addActionListener(this);
        rob.setFocusable(false);
        add(rob);

        back = new JButton("Back to Home");
        back.setBounds(550, 320, 180, 35);
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
            if (e.getSource() == search) {
                if (bidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Book Id is required");
                } else if (sidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Id is required");
                } else {
                    String sql = "SELECT * FROM issuebook WHERE BINARY student_id = ? AND BINARY book_id =?";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, sidText.getText());
                    st.setString(2, bidText.getText());
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        bnText.setText(rs.getString("bname"));
                        snText.setText(rs.getString("sname"));
                        courseText.setText(rs.getString("course"));
                        branchText.setText(rs.getString("branch"));
                        issueDate.setText(rs.getString("date_Of_issue"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter correct Book Id and Student Id");

                    }
                }

            } else if (e.getSource() == rob) {
                if (bidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Book Id is required");
                } else if (sidText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Id is required");
                } else if (snText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter correct details");
                } else if (returndate.getDateEditor().getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please enter return date");
                } else {
                    String s1 = "INSERT INTO returnbook(book_id,student_id,bname,sname,course,branch,date_of_issue,date_of_return) VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement st = con.c.prepareStatement(s1);
                    st.setString(1, bidText.getText());
                    st.setString(2, sidText.getText());
                    st.setString(3, bnText.getText());
                    st.setString(4, snText.getText());
                    st.setString(5, courseText.getText());
                    st.setString(6, branchText.getText());
                    st.setString(7, issueDate.getText());
                    st.setString(8, ((JTextField) returndate.getDateEditor().getUiComponent()).getText());
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Book has been returned");
                    JOptionPane.showMessageDialog(null, "Thank You");
                    
                    deleteQuery();
                    
                    bidText.setText("");
                    sidText.setText("");
                    bnText.setText("");
                    snText.setText("");
                    courseText.setText("");
                    branchText.setText("");
                    issueDate.setText("");
                    returndate.setDate(null);
                }

            } else if (e.getSource() == back) {
                this.setVisible(false);
                new HomePage().setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteQuery() {
        try {
            String query = "DELETE FROM issuebook WHERE BINARY book_id=?";
            PreparedStatement st = con.c.prepareStatement(query);

            st.setString(1, bidText.getText());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReturnBooks();

    }
}
