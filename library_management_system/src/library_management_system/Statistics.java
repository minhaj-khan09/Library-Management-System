package library_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Statistics extends JFrame implements ActionListener {
    
    Conn con = new Conn();
    JTable table1, table2;
    JButton back, searchBySId1, searchBySId2;
    Choice sid1, sid2;
    
    public Statistics() {
        setSize(800, 700);
        setLayout(null);
        setLocation(250, 20);
        getContentPane().setBackground(Color.white);
        setTitle("Details of issuing & returning page");
        
        JLabel heading = new JLabel("Details of Issuing & Returning page");
        heading.setBounds(100, 0, 550, 50);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        heading.setForeground(new Color(135, 0, 0));
        add(heading);
        
        JLabel issue = new JLabel("Issued Books");
        issue.setBounds(50, 60, 250, 20);
        issue.setFont(new Font("Ariel", Font.BOLD, 20));
        issue.setForeground(new Color(135, 0, 0));
        add(issue);
        
        JLabel sBySId = new JLabel("Search by student Id: ");
        sBySId.setBounds(380, 70, 160, 20);
        sBySId.setFont(new Font("Ariel", Font.BOLD, 15));
        sBySId.setForeground(new Color(135, 0, 0));
        add(sBySId);
        
        sid1 = new Choice();
        sid1.setBounds(545, 70, 100, 30);
        sid1.setFont(new Font("Ariel", Font.ITALIC, 14));
        add(sid1);
        
        try {
            String sql = "SELECT DISTINCT student_id FROM issuebook";
            ResultSet rs = con.s.executeQuery(sql);
            while (rs.next()) {
                sid1.add(rs.getString("student_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        searchBySId1 = new JButton("Search");
        searchBySId1.setBounds(650, 67, 100, 30);
        searchBySId1.setFont(new Font("Ariel", Font.BOLD, 18));
        searchBySId1.setForeground(new Color(255, 255, 255));
        searchBySId1.setBackground(new Color(103, 120, 240));
        searchBySId1.addActionListener(this);
        searchBySId1.setFocusable(false);
        add(searchBySId1);
        
        table1 = new JTable();
        table1.setBackground(new Color(232, 232, 232));
        table1.setFont(new Font("Ariel", Font.PLAIN, 14));
        
        try {
            String sql1 = "SELECT * FROM issuebook";
            ResultSet rs = con.s.executeQuery(sql1);
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        JScrollPane scroll1 = new JScrollPane(table1);
        scroll1.setBounds(50, 100, 700, 200);
        add(scroll1);
        
        JLabel retrn = new JLabel("Returned Books");
        retrn.setBounds(50, 330, 250, 20);
        retrn.setFont(new Font("Ariel", Font.BOLD, 20));
        retrn.setForeground(new Color(135, 0, 0));
        add(retrn);
        
        JLabel sBySId2 = new JLabel("Search by student Id: ");
        sBySId2.setBounds(380, 345, 160, 20);
        sBySId2.setFont(new Font("Ariel", Font.BOLD, 15));
        sBySId2.setForeground(new Color(135, 0, 0));
        add(sBySId2);
        
        sid2 = new Choice();
        sid2.setBounds(545, 345, 100, 30);
        sid2.setFont(new Font("Ariel", Font.ITALIC, 14));
        add(sid2);
        
        try {
            String sql = "SELECT DISTINCT student_id FROM returnbook";
            ResultSet rs = con.s.executeQuery(sql);
            while (rs.next()) {
                sid2.add(rs.getString("student_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        searchBySId2 = new JButton("Search");
        searchBySId2.setBounds(650, 340, 100, 30);
        searchBySId2.setFont(new Font("Ariel", Font.BOLD, 18));
        searchBySId2.setForeground(new Color(255, 255, 255));
        searchBySId2.setBackground(new Color(103, 120, 240));
        searchBySId2.addActionListener(this);
        searchBySId2.setFocusable(false);
        add(searchBySId2);
        
        table2 = new JTable();
        table2.setBackground(new Color(232, 232, 232));
        table2.setFont(new Font("Ariel", Font.PLAIN, 14));
        
        try {
            String sql2 = "SELECT * FROM returnbook";
            ResultSet rs2 = con.s.executeQuery(sql2);
            table2.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (SQLException ex) {
            
        }
        
        JScrollPane scroll2 = new JScrollPane(table2);
        scroll2.setBounds(50, 375, 700, 200);
        add(scroll2);
        
        back = new JButton("Back to Home");
        back.setBounds(580, 600, 170, 35);
        back.setBackground(new Color(103, 120, 240));
        back.setForeground(new Color(255, 255, 255));
        back.setFont(new Font("Ariel", Font.BOLD, 20));
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Statistics();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new HomePage().setVisible(true);
        }else if(e.getSource()==searchBySId1){
            try{
                String sql1="SELECT * FROM issuebook WHERE student_id=?";
                PreparedStatement st=con.c.prepareStatement(sql1);
                st.setString(1, sid1.getSelectedItem());
                ResultSet rs=st.executeQuery();
                table1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else if(e.getSource()==searchBySId2){
            try{
                String sql1="SELECT * FROM returnbook WHERE student_id=?";
                PreparedStatement st=con.c.prepareStatement(sql1);
                st.setString(1, sid2.getSelectedItem());
                ResultSet rs=st.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
    }
}
