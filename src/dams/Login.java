package dams;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Login extends JFrame implements ActionListener{
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3,b4;
    ImageIcon i3,i6;
    JFrame f1;
    Login(){
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/loginIcon2.png"));
        Image im = i.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle("Login");
        setBackground(Color.white);
        setResizable(false);
        setLayout(null);
        setUndecorated(true);
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/da.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1370,760);
        add(p);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,110,760);   
        la.setForeground(Color.black);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        JLabel l1 = new JLabel("Welcome  Back!");
        l1.setBounds(900,50,400,40);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Rockwell",Font.BOLD,35));
        la.add(l1);
        
        JLabel l5 = new JLabel("Login to continue");
        l5.setBounds(960,100,400,30);
        l5.setForeground(new Color(89,35,190));
        l5.setFont(new Font("Rockwell",Font.BOLD,18));
        la.add(l5);
        
        JLabel l2 = new JLabel("Username :");
        l2.setBounds(820,250,170,40);
        l2.setForeground(new Color(255,0,153));
        l2.setFont(new Font("Georgia",Font.BOLD,27));
        la.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(1000,253,250,35);
        t1.setBackground(Color.WHITE);
        t1.setForeground(Color.black);
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setFont(new Font("Georgia",Font.BOLD,22));
        la.add(t1);
        
        JLabel l3 = new JLabel("Password :");
        l3.setBounds(820,330,170,40);
        l3.setForeground(new Color(255,0,153));
        l3.setFont(new Font("Georgia",Font.BOLD,27));
        la.add(l3);
        
        t2 = new JPasswordField();
        t2.setBounds(1000,333,225,35);
        t2.setBackground(Color.WHITE);
        t2.setForeground(Color.black);
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setFont(new Font("Tahoma",Font.BOLD,22));
        la.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("dams/icons/view2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(30,35,Image.SCALE_SMOOTH);
        i3 = new ImageIcon(i2);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("dams/icons/nView.png"));
        Image i5 = i4.getImage().getScaledInstance(30,35,Image.SCALE_SMOOTH);
        i6 = new ImageIcon(i5);
        
        b4 = new JButton(i3);
        b4.setBounds(1225,333,25,35);
        b4.setBackground(Color.WHITE);
        b4.setBorder(BorderFactory.createEmptyBorder());
        b4.addActionListener(this);
        la.add(b4);
        
        b1 = new JButton("Login");
        b1.setBounds(980,410,140,35);
        b1.setBackground(Color.DARK_GRAY);
        //b1.setBackground(new Color(0,153,153));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Rockwell",Font.BOLD,22));
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.addActionListener(this);
        la.add(b1);
        
        JLabel l4 = new JLabel("Forgot password?");
        l4.setForeground(Color.red);
        l4.setBounds(900, 495, 180, 30);
        l4.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        la.add(l4);
        
        b2 = new JButton("Click Here");
        b2.setBounds(1080,495,120,30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.black);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setFont(new Font("Tahoma",Font.BOLD,18));
        b2.addActionListener(this);
        la.add(b2);
        
        b3 = new JButton("Exit");
        b3.setBounds(20,20,120,30);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.black);
        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.setFont(new Font("Tahoma",Font.BOLD,18));
        b3.addActionListener(this);
        la.add(b3);
        
        
        setVisible(true);
        f1 = new ForgotPassword();
        f1.setVisible(false);
    }
    public void actionPerformed(ActionEvent e){
        Conn c = new Conn();
        
        if(e.getSource()==b1){
            try{//check in database if user exists
                String username = t1.getText();
                String password = t2.getText();
                String sql = "select * from adminInfo where uName = '"+username+"'AND pWord = '"+password+"'";
                ResultSet rs = c.s.executeQuery(sql);
                if(rs.next()){      //if true means values are returning
                    new Loading(username).show();
                    dispose();
                }
                else{
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Enter correct credentials  ");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(this,msg ,"Invalid Login",JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception ae){}
        
        }
        else if(e.getSource()==b2){
            f1.setVisible(true);
        }
        else if(e.getSource()==b3){
            setVisible(false);   
            System.exit(0);
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
    }
    public static void main(String[] args){
        new Login();
    }
}
