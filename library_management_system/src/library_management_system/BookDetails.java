package library_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class BookDetails extends JFrame implements ActionListener {

    Conn con = new Conn();

    JTable table;
    Choice bid;
    JButton search, add, delete, vab, back;

    public BookDetails() {

        setSize(800, 600);
        setLayout(null);
        setLocation(250, 20);
        getContentPane().setBackground(Color.white);
        setTitle("Book details");

        JLabel heading = new JLabel("Book details page");
        heading.setBounds(270, 10, 350, 50);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);

        JLabel sbbi = new JLabel("Search by book-Id :");
        sbbi.setBounds(50, 70, 140, 20);
        sbbi.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(sbbi);

        bid = new Choice();
        bid.setBounds(200, 70, 80, 30);
        bid.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(bid);

        try {
            String query = "SELECT * FROM book";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {
                bid.add(rs.getString("book_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table = new JTable();
        table.setBackground(new Color(232, 232, 232));
        table.setFont(new Font("Ariel", Font.PLAIN, 14));

        try {
            String query = "SELECT * FROM book";
            ResultSet rs = con.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 110, 700, 300);
        add(scroll);

        search = new JButton("Search");
        search.setBounds(320, 67, 110, 30);
        search.setFont(new Font("Ariel", Font.BOLD, 18));
        search.setForeground(new Color(255, 255, 255));
        search.setBackground(new Color(103, 120, 240));
        search.addActionListener(this);
        search.setFocusable(false);
        add(search);

        add = new JButton("Add Book");
        add.setBounds(450, 67, 130, 30);
        add.setFont(new Font("Ariel", Font.BOLD, 18));
        add.setForeground(new Color(255, 255, 255));
        add.setBackground(new Color(103, 120, 240));
        add.addActionListener(this);
        add.setFocusable(false);
        add(add);

        delete = new JButton("Delete");
        delete.setBounds(600, 67, 100, 30);
        delete.setFont(new Font("Ariel", Font.BOLD, 18));
        delete.setForeground(new Color(255, 255, 255));
        delete.setBackground(new Color(103, 120, 240));
        delete.addActionListener(this);
        delete.setFocusable(false);
        add(delete);

        vab = new JButton("View all books");
        vab.setBounds(500, 450, 200, 35);
        vab.setFont(new Font("Ariel", Font.BOLD, 18));
        vab.setForeground(new Color(255, 255, 255));
        vab.setBackground(new Color(103, 120, 240));
        vab.addActionListener(this);
        vab.setFocusable(false);
        add(vab);

        back = new JButton("Back to Home");
        back.setBounds(200, 450, 200, 35);
        back.setFont(new Font("Ariel", Font.BOLD, 18));
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(103, 120, 240));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == search) {

                String query = "SELECT * FROM book WHERE BINARY book_id=?";
                PreparedStatement st = con.c.prepareStatement(query);
                st.setString(1, bid.getSelectedItem());
                ResultSet rs = st.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } else if (e.getSource() == vab) {

                String query = "SELECT * FROM book";
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } else if (e.getSource() == add) {
                this.setVisible(false);
                new AddBook().setVisible(true);

            } else if (e.getSource() == back) {
                this.setVisible(false);
                new HomePage().setVisible(true);
            } else if (e.getSource() == delete) {
                this.setVisible(false);
                new Delete().setVisible(true);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
