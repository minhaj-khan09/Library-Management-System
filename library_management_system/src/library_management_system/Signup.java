package library_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JButton back, create;
    JTextField userText, nameText, ansText;
    JPasswordField pasText;
    JComboBox queList;

    public Signup() {

        setSize(600, 450);
        setLocation(350, 100);
        getContentPane().setBackground(Color.white);
        setTitle("Create new account");
        setLayout(null);

        JLabel username = new JLabel("Username: ");
        username.setBounds(50, 70, 200, 30);
        username.setFont(new Font("Ariel", Font.BOLD, 20));
        add(username);

        userText = new JTextField();
        userText.setBounds(300, 70, 200, 30);
        userText.setFont(new Font("Ariel", Font.PLAIN, 16));
        add(userText);

        JLabel name = new JLabel("Name : ");
        name.setBounds(50, 110, 200, 30);
        name.setFont(new Font("Ariel", Font.BOLD, 20));
        add(name);

        nameText = new JTextField();
        nameText.setBounds(300, 110, 200, 30);
        nameText.setFont(new Font("Ariel", Font.PLAIN, 16));
        add(nameText);

        JLabel pass = new JLabel("Password: ");
        pass.setBounds(50, 150, 200, 30);
        pass.setFont(new Font("Ariel", Font.BOLD, 20));
        add(pass);

        pasText = new JPasswordField();
        pasText.setBounds(300, 150, 200, 30);
        pasText.setFont(new Font("Ariel", Font.PLAIN, 16));
        add(pasText);

        JLabel que = new JLabel("Security question: ");
        que.setBounds(50, 190, 200, 30);
        que.setFont(new Font("Ariel", Font.BOLD, 20));
        add(que);

        queList = new JComboBox();
        queList.setModel(new DefaultComboBoxModel(new String[]{"Select any question", "Your Nickname?", "Your Hometown?", "Your favourite actor?", "Your Favourite subject?"}));
        queList.setBounds(300, 190, 200, 30);
        queList.setFont(new Font("Ariel", Font.PLAIN, 16));
        add(queList);

        JLabel ans = new JLabel("Answer: ");
        ans.setBounds(50, 230, 200, 30);
        ans.setFont(new Font("Ariel", Font.BOLD, 20));
        add(ans);

        ansText = new JTextField();
        ansText.setBounds(300, 230, 200, 30);
        ansText.setFont(new Font("Ariel", Font.PLAIN, 16));
        add(ansText);

        create = new JButton("Create");
        create.setBounds(150, 300, 100, 35);
        create.setFont(new Font("Ariel", Font.BOLD, 20));
        create.setForeground(new Color(255, 255, 255));
        create.setBackground(new Color(7, 204, 27));
        create.addActionListener(this);
        create.setFocusable(false);
        add(create);

        back = new JButton("Back");
        back.setBounds(300, 300, 100, 35);
        back.setFont(new Font("Ariel", Font.BOLD, 20));
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(103, 120, 240));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            Conn con = new Conn();

            if (ae.getSource() == back) {
                this.setVisible(false);
            } else if (userText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username is required");
            } else if (nameText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else if (pasText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password is required");
            } else if (queList.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Select any security question");
            } else if (ansText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Security answer is required");
            } else if (ae.getSource() == create) {
                String query = "INSERT INTO account(username,name,password,sec_q,sec_ans) VALUES(?,?,?,?,?)";
                PreparedStatement st = con.c.prepareStatement(query);
                st.setString(1, userText.getText());
                st.setString(2, nameText.getText());
                st.setString(3, pasText.getText());
                st.setString(4, (String) queList.getSelectedItem());
                st.setString(5, ansText.getText());
                st.executeUpdate();
                System.out.println(nameText);

                JOptionPane.showMessageDialog(null, "Account has been created successfully");
                this.setVisible(false);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
