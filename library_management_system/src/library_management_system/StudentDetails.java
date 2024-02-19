package library_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {

    Conn con = new Conn();
    JTable table;
    Choice sid;
    JButton search, add, delete, vas,back;

    public StudentDetails() {

        setSize(800, 600);
        setLayout(null);
        setLocation(250, 20);
        getContentPane().setBackground(Color.white);
        setTitle("Student details");

        JLabel heading = new JLabel("Student details page");
        heading.setBounds(250, 5, 350, 50);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);

        JLabel sbbi = new JLabel("Search by student-Id :");
        sbbi.setBounds(50, 70, 160, 20);
        sbbi.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(sbbi);

        sid = new Choice();
        sid.setBounds(215, 70, 105, 20);
        sid.setFont(new Font("Ariel", Font.ITALIC, 16));
        add(sid);

        try {
            String query = "SELECT * FROM student";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {
                sid.add(rs.getString("student_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table = new JTable();
        table.setBackground(new Color(232, 232, 232));
        table.setFont(new Font("Ariel", Font.PLAIN, 14));

        try {
            String query = "SELECT * FROM student";
            ResultSet rs = con.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 120, 700, 300);
        add(scroll);

        search = new JButton("Search");
        search.setBounds(350, 68, 130, 30);
        search.setFont(new Font("Ariel", Font.BOLD, 18));
        search.setForeground(new Color(255, 255, 255));
        search.setBackground(new Color(103, 120, 240));
        search.addActionListener(this);
        search.setFocusable(false);
        add(search);

        add = new JButton("Add Student");
        add.setBounds(550, 68, 150, 30);
        add.setFont(new Font("Ariel", Font.BOLD, 18));
        add.setForeground(new Color(255, 255, 255));
        add.setBackground(new Color(103, 120, 240));
        add.addActionListener(this);
        add.setFocusable(false);
        add(add);

        delete = new JButton("Delete");
        delete.setBounds(330, 450, 130, 35);
        delete.setFont(new Font("Ariel", Font.BOLD, 18));
        delete.setForeground(new Color(255, 255, 255));
        delete.setBackground(new Color(103, 120, 240));
        delete.addActionListener(this);
        delete.setFocusable(false);
        add(delete);

        vas = new JButton("View all Students");
        vas.setBounds(500, 450, 200, 35);
        vas.setFont(new Font("Ariel", Font.BOLD, 18));
        vas.setForeground(new Color(255, 255, 255));
        vas.setBackground(new Color(103, 120, 240));
        vas.addActionListener(this);
        vas.setFocusable(false);
        add(vas);
        
        back = new JButton("Back to Home");
        back.setBounds(100, 450, 200, 35);
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
        if (e.getSource() == search) {
            try {
                String query = "SELECT * FROM student WHERE BINARY student_id=?";
                PreparedStatement st=con.c.prepareStatement(query);
                st.setString(1, sid.getSelectedItem());
                ResultSet rs=st.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                

            } catch (SQLException xe) {
                xe.printStackTrace();
            }
        } else if(e.getSource()==vas){
            try{
                String query="SELECT * FROM student";
                ResultSet rs=con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }           
        } else if(e.getSource()==add){
            this.setVisible(false);
            new AddStudent().setVisible(true);
            
        } else if(e.getSource()==back){
            this.setVisible(false);
            new HomePage().setVisible(true);
        }else if (e.getSource() == delete) {
            this.setVisible(false);
            new Delete().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
