package dams;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener{
    JPasswordField t1,t2,t3;
    JButton b1,b2,b3,b4,b5;
    String username;
    ImageIcon i6,i3;
    
    ChangePassword(String username){
        this.username=username;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/changePass.jpg"));
        Image im = i.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
        setIconImage(im);
        setBounds(80,50,1300,740);
        setResizable(false);
        setLayout(null);
        setUndecorated(true);
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/dc.jpg"));
        Image b = bi.getImage().getScaledInstance(1300,740,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1300,740);
        add(p);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1300,740);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
      
        
        JLabel l1 = new JLabel("Current Password :");
        l1.setBounds(80,150,350,35);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Georgia",Font.BOLD,35));
        la.add(l1);
        
        t1 = new JPasswordField();
        t1.setBounds(80,200,350,40);
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setFont(new Font("Tahoma",Font.BOLD,40));
        t1.setEchoChar('*');
        t1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) && !t2.getText().isEmpty() && !t3.getText().isEmpty() ){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t1.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                }
            }
        });
        la.add(t1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("dams/icons/view2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        i3 = new ImageIcon(i2);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("dams/icons/nView.png"));
        Image i5 = i4.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        i6 = new ImageIcon(i5);
        
        b3 = new JButton(i3);
        b3.setBounds(430,200,25,40);
        b3.setBackground(Color.WHITE);
        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.addActionListener(this);
        la.add(b3);
        
        JLabel l2 = new JLabel("New Password :");
        l2.setBounds(80,320,300,35);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Georgia",Font.BOLD,35));
        la.add(l2);
        
        t2 = new JPasswordField();
        t2.setBounds(80,370,350,40);
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setFont(new Font("Tahoma",Font.BOLD,40));
        t2.setEchoChar('*');
        t2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) && !t1.getText().isEmpty() && !t3.getText().isEmpty() ){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t2.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                }
            }
        });
        la.add(t2);
        
        b4 = new JButton(i3);
        b4.setBounds(430,370,25,40);
        b4.setBackground(Color.WHITE);
        b4.setBorder(BorderFactory.createEmptyBorder());
        b4.addActionListener(this);
        la.add(b4);
        
        JLabel l3 = new JLabel("Confirm Password :");
        l3.setBounds(80,490,370,35);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Georgia",Font.BOLD,35));
        la.add(l3);
        
        t3 = new JPasswordField();
        t3.setBounds(80,540,350,40);
        t3.setBorder(BorderFactory.createEmptyBorder());
        t3.setFont(new Font("Tahoma",Font.BOLD,40));
        t3.setEchoChar('*');
        t3.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) && !t2.getText().isEmpty() && !t1.getText().isEmpty() ){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t3.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                }
            }
        });
        la.add(t3);
        
        b5 = new JButton(i3);
        b5.setBounds(430,540,25,40);
        b5.setBackground(Color.WHITE);
        //b3.setForeground(Color.black);
        b5.setBorder(BorderFactory.createEmptyBorder());
        b5.addActionListener(this);
        la.add(b5);
        
        b1 = new JButton("Save");
        b1.setBounds(190,620,130,45);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.setFont(new Font("Rockwell",Font.BOLD,45));
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.addActionListener(this);
        b1.setEnabled(false);
        la.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(20,20,130,35);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.black);
        b2.setFont(new Font("Rockwell",Font.BOLD,25));
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.addActionListener(this);
        la.add(b2);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        Conn c = new Conn();
        if(e.getSource()==b1){
             try{
                String sql = "select * from adminInfo where pWord = '"+t1.getText()+"'";
                ResultSet rs = c.s.executeQuery(sql);
                if(rs.next()){      //if true means values are returning
                    
                    if(t2.getText().equals(t3.getText())){
                        
                        String query =  "update adminInfo set pWord= '"+t3.getText()+"'";
                        c.s.executeUpdate(query);
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Password updated succesfully, Please Login again");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,17));
                        op.showMessageDialog(this, msg);
                        dispose();
                        new Login().setVisible(true);
                    }
                    else{
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Passwords don't match");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,17));
                        op.showMessageDialog(this,msg,"Recheck new password",JOptionPane.ERROR_MESSAGE);
                    }
                   
                   
                }
                else{
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Enter correct password");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,17));
                    JOptionPane.showMessageDialog(this,msg,"Recheck current password",JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception ae){}
        }
        else if(e.getSource()==b2){
           new Dashboard(username).setVisible(true);
           dispose();
        }
        else if(e.getSource()==b3){
           if(t1.getEchoChar()==(char)0){
               b3.setIcon(i3);
               t1.setEchoChar('*');
           }
           else{
               t1.setEchoChar((char)0);
               b3.setIcon(i6);
           }
        }
        else if(e.getSource()==b4){
           if(t2.getEchoChar()==(char)0){
               b4.setIcon(i3);
               t2.setEchoChar('*');
           }
           else{
               t2.setEchoChar((char)0);
               b4.setIcon(i6);
           }
        }
        else if(e.getSource()==b5){
           if(t3.getEchoChar()==(char)0){
               b5.setIcon(i3);
               t3.setEchoChar('*');
           }
           else{
               t3.setEchoChar((char)0);
               b5.setIcon(i6);
           }
        }
        
    }
    public static void main(String[] args){
        new ChangePassword("");
    }
}

