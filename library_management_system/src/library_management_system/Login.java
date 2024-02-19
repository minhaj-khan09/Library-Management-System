package library_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton signup, forgot, login;
    JTextField userText;
    JPasswordField passwordText;

    Login() {

        setSize(900, 700);
        setLocation(200, 10);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));

        setTitle("LIBRARY MANAGEMENT SYSTEM");

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/LibraryPic1.jpeg"));
        Image i1 = i.getImage().getScaledInstance(500, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label = new JLabel(i2);
        label.setBounds(0, 0, 500, 700);
        add(label);

        JLabel libary = new JLabel("LIBRARY");
        libary.setBounds(50, 100, 300, 65);
        libary.setFont(new Font("Ariel", Font.BOLD, 65));
        libary.setForeground(Color.white);
        label.add(libary);

        JLabel ms = new JLabel("MANAGEMENT SYSTEM");
        ms.setBounds(50, 170, 300, 30);
        ms.setFont(new Font("Ariel", Font.BOLD, 24));
        ms.setForeground(Color.white);
        label.add(ms);

        JLabel user = new JLabel("Username :");
        user.setFont(new Font("Ariel", Font.BOLD, 20));
        user.setBounds(550, 100, 110, 30);
        user.setForeground(Color.black);
        add(user);

        userText = new JTextField();
        userText.setFont(new Font("Ariel", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        userText.setBounds(665, 100, 200, 30);
        add(userText);

        JLabel password = new JLabel("Password :");
        password.setFont(new Font("Ariel", Font.BOLD, 20));
        password.setBounds(550, 150, 110, 30);
        password.setForeground(Color.black);
        add(password);

        passwordText = new JPasswordField();
        passwordText.setFont(new Font("Ariel", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        passwordText.setBounds(665, 150, 200, 30);
        add(passwordText);

        login = new JButton("Login");
        login.setFont(new Font("Ariel", Font.BOLD, 17));
        login.setBounds(610, 220, 200, 40);
        login.setForeground(new Color(255, 255, 255));
        login.setBackground(new Color(103, 120, 240));
        login.addActionListener(this);
        login.setFocusable(false);
        add(login);

        signup = new JButton("Create new account");
        signup.setBounds(590, 275, 250, 40);
        signup.setFont(new Font("Ariel", Font.BOLD, 17));
        signup.setForeground(new Color(255, 255, 255));
        signup.setBackground(new Color(7, 204, 27));
        signup.addActionListener(this);
        signup.setFocusable(false);
        add(signup);

        forgot = new JButton("Forgotten password?");
        forgot.setBounds(590, 330, 250, 40);
        forgot.setFont(new Font("Ariel", Font.BOLD, 17));
        forgot.setForeground(new Color(103, 120, 240));
        forgot.setBackground(new Color(255, 255, 255));
        forgot.addActionListener(this);
        forgot.setFocusable(false);
        add(forgot);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            if (userText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username is required");
            } else if (passwordText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password is required");
            } else {
                Conn con = new Conn();
                try {
                    String query = "SELECT * FROM account WHERE BINARY username=? AND BINARY password=?";
                    PreparedStatement st = con.c.prepareStatement(query);
                    st.setString(1, userText.getText());
                    st.setString(2, passwordText.getText());
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        this.setVisible(false);
                        new HomePage().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username and Password are invalid");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getSource() == signup) {
            new Signup().setVisible(true);
        } else if (e.getSource() == forgot) {
            new ForgotPassword().setVisible(true);
        }

    }

}
