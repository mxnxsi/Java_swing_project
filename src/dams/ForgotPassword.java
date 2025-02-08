package dams;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

    public class ForgotPassword extends JFrame implements ActionListener{
    JTextField f1,f2,f3,f4,f5;
    JButton b1,b2,b3;
    
        ForgotPassword(){
            ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/fpwIcon.png"));
            Image im = i.getImage();
            setIconImage(im);
            setResizable(false);
            setLayout(null);
            setTitle("Forgot Password");
            getContentPane().setBackground(Color.white);
            setBounds(80,50,1370,760);
            setUndecorated(true);
            ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/da.jpg"));
            Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
            ImageIcon bii = new ImageIcon(b);
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            p.setBounds(0,0,1370,760);
            add(p);
            JLabel la = new JLabel(bii);
            la.setBounds(0,0,1370,760);
            la.setForeground(Color.white);
            la.setFont(new Font("Rockwell",Font.BOLD,12));
            p.add(la);
            
            
            JLabel l = new JLabel("Retrieve  Password");
            l.setBounds(650,50,400,40);
            l.setForeground(Color.red);
            l.setFont(new Font("Rockwell",Font.BOLD,38));
            la.add(l);
           
            JLabel l1 = new JLabel("Username :");
            l1.setBounds(580,190,150,35);
            l1.setFont(new Font("Georgia",Font.BOLD,22));
            la.add(l1);
            
            f1 = new JTextField();
            f1.setBounds(740,190,200,32);
            f1.setBorder(BorderFactory.createEmptyBorder());
            f1.setFont(new Font("Tahoma",Font.PLAIN,20));
            la.add(f1);
            
            b1 = new JButton("Search");   //database conn -> fill name and question
            b1.setBackground(Color.DARK_GRAY);
            b1.setForeground(Color.white);
            b1.setBorder(BorderFactory.createRaisedBevelBorder());
            b1.setFont(new Font("Georgia",Font.BOLD,22));
            b1.setBounds(950,190,120,35);
            b1.addActionListener(this);
            la.add(b1);
            
            JLabel l2 = new JLabel("Name :");
            l2.setBounds(580,250,150,35);
            l2.setFont(new Font("Georgia",Font.BOLD,22));
            la.add(l2);
            
            f2 = new JTextField();
            f2.setBounds(740,250,200,32);
            f2.setBorder(BorderFactory.createEmptyBorder());
            f2.setFont(new Font("Tahoma",Font.PLAIN,20));
            la.add(f2);
            
            JLabel l3 = new JLabel("Your Security Question :");
            l3.setBounds(580,310,350,35);
            l3.setFont(new Font("Georgia",Font.BOLD,22));
            la.add(l3);
            
            f3 = new JTextField();
            f3.setBounds(580,355,490,32);
            f3.setBorder(BorderFactory.createEmptyBorder());
            f3.setFont(new Font("Tahoma",Font.PLAIN,20));
            la.add(f3);
            
            JLabel l4 = new JLabel("Answer :");
            l4.setBounds(580,415,150,35);
            l4.setFont(new Font("Georgia",Font.BOLD,22));
            la.add(l4);
            
            f4 = new JTextField();
            f4.setBounds(740,415,200,32);
            f4.setBorder(BorderFactory.createEmptyBorder());
            f4.setFont(new Font("Tahoma",Font.PLAIN,20));
            la.add(f4);
            
            b2 = new JButton("Retrieve");       //retrieve password
            b2.setBackground(Color.DARK_GRAY);
            b2.setForeground(Color.white);
            b2.setBorder(BorderFactory.createRaisedBevelBorder());
            b2.setFont(new Font("Georgia",Font.BOLD,22));
            b2.setBounds(950,415,120,35);
            b2.addActionListener(this);
            la.add(b2);
            
            JLabel l5 = new JLabel("Password :");
            l5.setBounds(580,475,150,35);
            l5.setFont(new Font("Georgia",Font.BOLD,22));
            la.add(l5);
            
            f5 = new JTextField();
            f5.setBounds(740,475,200,32);
            f5.setBorder(BorderFactory.createEmptyBorder());
            f5.setFont(new Font("Tahoma",Font.PLAIN,20));
            la.add(f5);
            
            b3 = new JButton("Back");       //back to login page
            b3.setBackground(Color.DARK_GRAY);
            b3.setForeground(Color.white);
            b3.setBorder(BorderFactory.createRaisedBevelBorder());
            b3.setFont(new Font("SAN_SERIF",Font.BOLD,22));
            b3.addActionListener(this);
            b3.setBounds(780,530,120,35);
            la.add(b3);
            
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
            Conn c = new Conn();
            if(ae.getSource()==b1){
               try{
                   String uname = f1.getText();
                   String sql2 = "select * from adminInfo where uName = '"+uname+"'";
                   ResultSet rs2 = c.s.executeQuery(sql2);
                   
                   if(rs2.next()){
                        String sql = "select * from adminInfo where uName = '"+f1.getText()+"'";
                        ResultSet rs = c.s.executeQuery(sql);       //whole row
                        //c.s.executeQuery() returns ResultSet class object so must be stored in same class object
                        while(rs.next()){   //column to column jump
                            f2.setText(rs.getString("name"));         //get from database and set into TextField
                            f3.setText(rs.getString("secQue"));
                        }
                   }
                   else{
                       UIManager ui = new UIManager();
                       ui.put("OptionPane.background",Color.WHITE);
                       ui.put("Panel.background",Color.WHITE);
                       //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                       JOptionPane op = new JOptionPane();
                       JLabel msg = new JLabel("Incorrect username");
                       msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                       op.showMessageDialog(this,msg ,"Try Again",JOptionPane.OK_OPTION);
                       f1.setText("");
                       f2.setText("");
                       f3.setText("");
                   }
               }catch(Exception e){}
                
            }else if(ae.getSource()==b2){
                try{
                    String ans = f4.getText();
                    String sql2 = "select * from adminInfo where secAns = '"+ans+"'";
                    ResultSet rs2 = c.s.executeQuery(sql2);
                    
                    if(rs2.next()){
                        
                        String sql = "select * from adminInfo where secAns = '"+f4.getText()+"'";
                        ResultSet rs = c.s.executeQuery(sql);       //whole row
                        //c.s.executeQuery() returns ResultSet class object so must be stored in same class object
                        if(rs.next()){   //column to column jump
                            f5.setText(rs.getString("pWord"));         //get from database and set into TextField   
                        }
                    }
                    else{
                       UIManager ui = new UIManager();
                       ui.put("OptionPane.background",Color.WHITE);
                       ui.put("Panel.background",Color.WHITE);
                       //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                       JOptionPane op = new JOptionPane();
                       JLabel msg = new JLabel("Incorrect Answer");
                       msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                       op.showMessageDialog(this,msg ,"Try Again",JOptionPane.OK_OPTION);
                       f4.setText("");
                       f5.setText("");
                    }    
            }catch(Exception e){}
                
            }else if(ae.getSource()==b3){
                this.setVisible(false);
            }
        }
        public static void main(String[] args){
            new ForgotPassword();
        }
}
