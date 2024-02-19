package library_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddBook extends JFrame implements ActionListener {

    JTextField bidText, bnText, authorText, priceText;
    JButton add, back, vab, exit;
    JComboBox editionText, langText;

    public AddBook() {

        setLocation(400, 100);
        setSize(450, 450);
        setLayout(null);
        setUndecorated(true);
        setTitle("Add Books");

        JLabel heading = new JLabel("Adding Book Page");
        heading.setBounds(80, 10, 300, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);

        JLabel bookId = new JLabel("Book Id :");
        bookId.setBounds(50, 70, 100, 20);
        bookId.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bookId);

        bidText = new JTextField();
        bidText.setBounds(200, 70, 180, 30);
        bidText.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bidText);

        JLabel bName = new JLabel("Book Name :");
        bName.setBounds(50, 110, 120, 20);
        bName.setFont(new Font("Ariel", Font.BOLD, 18));
        add(bName);

        bnText = new JTextField();
        bnText.setBounds(200, 110, 180, 30);
        bnText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(bnText);

        JLabel author = new JLabel("Author :");
        author.setBounds(50, 150, 100, 20);
        author.setFont(new Font("Ariel", Font.BOLD, 18));
        add(author);

        authorText = new JTextField();
        authorText.setBounds(200, 150, 180, 30);
        authorText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(authorText);

        JLabel lang = new JLabel("Language :");
        lang.setBounds(50, 190, 100, 20);
        lang.setFont(new Font("Ariel", Font.BOLD, 18));
        add(lang);

        langText = new JComboBox();
        langText.setModel(new DefaultComboBoxModel(new String[]{"Select Language", "English", "Hindi", "Other",}));
        langText.setBounds(200, 190, 180, 30);
        langText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(langText);

        JLabel price = new JLabel("Price :");
        price.setBounds(50, 230, 100, 20);
        price.setFont(new Font("Ariel", Font.BOLD, 18));
        add(price);

        priceText = new JTextField();
        priceText.setBounds(200, 230, 180, 30);
        priceText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(priceText);

        JLabel edition = new JLabel("Edition :");
        edition.setBounds(50, 270, 100, 20);
        edition.setFont(new Font("Ariel", Font.BOLD, 18));
        add(edition);

        editionText = new JComboBox();
        editionText.setModel(new DefaultComboBoxModel(new String[]{"Select Edition", "1", "2", "3", "4", "5", "6", "7", "8"}));
        editionText.setBounds(200, 270, 180, 30);
        editionText.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(editionText);

        add = new JButton("Add Book");
        add.setBounds(50, 330, 140, 35);
        add.setBackground(new Color(103, 120, 240));
        add.setForeground(new Color(255, 255, 255));
        add.setFont(new Font("Ariel", Font.BOLD, 20));
        add.addActionListener(this);
        add.setFocusable(false);
        add(add);

        back = new JButton("Back to Home");
        back.setBounds(200, 330, 180, 35);
        back.setBackground(new Color(103, 120, 240));
        back.setForeground(new Color(255, 255, 255));
        back.setFont(new Font("Ariel", Font.BOLD, 20));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        vab = new JButton("View all books");
        vab.setBounds(200, 380, 180, 35);
        vab.setFont(new Font("Ariel", Font.BOLD, 20));
        vab.setForeground(new Color(255, 255, 255));
        vab.setBackground(new Color(103, 120, 240));
        vab.addActionListener(this);
        vab.setFocusable(false);
        add(vab);

        exit = new JButton("Exit");
        exit.setBounds(50, 380, 140, 35);
        exit.setBackground(new Color(103, 120, 240));
        exit.setForeground(new Color(255, 255, 255));
        exit.setFont(new Font("Ariel", Font.BOLD, 20));
        exit.addActionListener(this);
        exit.setFocusable(false);
        add(exit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Conn con = new Conn();

        if (e.getSource() == vab) {
            this.setVisible(false);
            new BookDetails().setVisible(true);
        } else if (e.getSource() == back) {
            this.setVisible(false);
            new HomePage().setVisible(true);
        } else if (e.getSource() == exit) {
            this.dispose();
        } else if (e.getSource() == add) {

            if (bidText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Book Id is required");
            } else if (bnText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Book name is required");
            } else if (authorText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Author is required");
            } else if (langText.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Select a Language");
            } else if (priceText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Price is required");
            } else if (editionText.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Select an Edition");
            } else {
                try {
                    String query = "INSERT INTO book(book_id,name,author,language,edition,price) VALUES (?,?,?,?,?,?)";
                    PreparedStatement st = con.c.prepareStatement(query);

                    st.setString(1, bidText.getText());
                    st.setString(2, bnText.getText());
                    st.setString(3, authorText.getText());
                    st.setString(4, (String) langText.getSelectedItem());
                    st.setString(5, (String) editionText.getSelectedItem());
                    st.setString(6, priceText.getText());

                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Book has been added");

                    bidText.setText("");
                    bnText.setText("");
                    authorText.setText("");
                    langText.setSelectedIndex(0);
                    editionText.setSelectedIndex(0);
                    priceText.setText("");

                } catch (SQLIntegrityConstraintViolationException de) {
                    // Handle duplicate entry exception
                    String errorMessage = de.getMessage(); 
                    if (errorMessage.contains("Duplicate entry")) {
                        JOptionPane.showMessageDialog(null, "Book ID already exists. Please choose a different Book ID.", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                    } else {
                        de.printStackTrace();
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }

            }

        }

    }

    public static void main(String[] args) {
        new AddBook();
    }
}
