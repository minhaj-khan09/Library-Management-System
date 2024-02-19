package library_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener {

    JButton search, back, retrieve;
    JTextField ansText, userText, nameText, queText, passText;

    public ForgotPassword() {
        setSize(625, 455);
        setLocation(350, 100);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel username = new JLabel("Username :");
        username.setBounds(30, 20, 200, 30);
        username.setFont(new Font("Ariel", Font.BOLD, 18));
        add(username);

        userText = new JTextField();
        userText.setBounds(280, 20, 200, 30);
        userText.setFont(new Font("Ariel", Font.ITALIC, 18));
        add(userText);

        JLabel name = new JLabel("Name :");
        name.setBounds(30, 70, 200, 30);
        name.setFont(new Font("Ariel", Font.BOLD, 18));
        add(name);

        nameText = new JTextField();
        nameText.setBounds(280, 70, 200, 30);
        nameText.setFont(new Font("Ariel", Font.ITALIC, 18));
        add(nameText);

        JLabel que = new JLabel("Your security question :");
        que.setBounds(30, 120, 250, 30);
        que.setFont(new Font("Ariel", Font.BOLD, 18));
        add(que);

        queText = new JTextField();
        queText.setBounds(280, 120, 200, 30);
        queText.setForeground(new Color(163, 16, 50));
        queText.setEditable(false);
        queText.setFont(new Font("Ariel", Font.ITALIC, 18));
        add(queText);

        JLabel ans = new JLabel("Answer :");
        ans.setBounds(30, 170, 200, 30);
        ans.setFont(new Font("Ariel", Font.BOLD, 18));
        add(ans);

        ansText = new JTextField();
        ansText.setBounds(280, 170, 200, 30);
        ansText.setFont(new Font("Ariel", Font.ITALIC, 18));
        add(ansText);

        JLabel pass = new JLabel("Password :");
        pass.setBounds(30, 220, 200, 30);
        pass.setFont(new Font("Ariel", Font.BOLD, 18));
        add(pass);

        passText = new JTextField();
        passText.setBounds(280, 220, 200, 30);
        passText.setEditable(false);
        passText.setForeground(new Color(209, 0, 49));
        passText.setFont(new Font("Ariel", Font.ITALIC, 18));
        add(passText);

        search = new JButton("Search");
        search.setBounds(490, 118, 115, 35);
        search.setFont(new Font("Ariel", Font.BOLD, 20));
        search.setForeground(new Color(255, 255, 255));
        search.setBackground(new Color(103, 120, 240));
        search.addActionListener(this);
        search.setFocusable(false);
        add(search);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(490, 218, 115, 35);
        retrieve.setFont(new Font("Ariel", Font.BOLD, 20));
        retrieve.setForeground(new Color(255, 255, 255));
        retrieve.setBackground(new Color(103, 120, 240));
        retrieve.addActionListener(this);
        retrieve.setFocusable(false);
        add(retrieve);

        back = new JButton("Back");
        back.setBounds(490, 300, 115, 35);
        back.setFont(new Font("Ariel", Font.BOLD, 20));
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(103, 120, 240));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        setVisible(true);

    }

    public static void main(String[] args) {
        new ForgotPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Conn con = new Conn();

        if (e.getSource() == back) {
            this.setVisible(false);
        }

        try {
            if (e.getSource() == search) {
                String query = "SELECT * FROM account WHERE BINARY username = ? and BINARY name = ?";
                PreparedStatement st = con.c.prepareStatement(query);
                st.setString(1, userText.getText());
                st.setString(2, nameText.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    queText.setText(rs.getString("sec_q"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct Username and Name");
                }

            } else if (e.getSource() == retrieve) {
                if (ansText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter answer");
                } else {
                    String query = "SELECT * FROM account WHERE BINARY sec_ans=?";
                    PreparedStatement st = con.c.prepareStatement(query);
                    st.setString(1, ansText.getText());
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        passText.setText(rs.getString("password"));
                    } else{
                        JOptionPane.showMessageDialog(null, "Please enter correct Answer");
                    }
                }

            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
