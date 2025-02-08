package dams;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JPopupMenu popupmenu,popupmenu2,popupmenu3;
    JMenuItem m1,m2,m3,cm1,cm2,tm3,tm4;
    
    Dashboard(String username){
        this.username=username;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/dc.jpg"));
        Image im = i.getImage();
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle("Dashboard");
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
          
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1370,760);
        add(p);
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/dc.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1370,760);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        
        JLabel l = new JLabel("Account Settings");
        l.setBounds(10,85,150,20);
        l.setForeground(Color.black);
        l.setFont(new Font("Rockwell",Font.BOLD,16));
        la.add(l);
                    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("dams/icons/s2.png"));
        Image i2 = i1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        b1 = new JButton(i3);
        b1.setIcon(i3);
        b1.setBounds(10,10,70,70);
        b1.setBackground(Color.white);
        b1.setBorder(BorderFactory.createLineBorder(new Color(102,51,0), 5,true));
        b1.addActionListener(this);
        la.add(b1);
        
        b5 = new JButton("Exit");
        b5.setBounds(1260,20,80,30);
        b5.setBackground(Color.white);
        b5.setForeground(Color.BLACK);
        b5.setFont(new Font("Rockwell",Font.BOLD,22));
        b5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b5.addActionListener(this);
        la.add(b5);
        
        popupmenu = new JPopupMenu();  
        m1 = new JMenuItem("Change Password");
        m1.setBackground(Color.DARK_GRAY);
        m1.setForeground(Color.white);
        m1.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        m1.addActionListener(this);
        m2 = new JMenuItem("Edit Admin Information");
        m2.setBackground(Color.DARK_GRAY);
        m2.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        m2.setForeground(Color.white);
        m2.addActionListener(this);
        m3 = new JMenuItem("Logout");
        m3.setBackground(Color.DARK_GRAY);
        m3.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        m3.setForeground(Color.white);
        m3.addActionListener(this);
        popupmenu.add(m1);popupmenu.addSeparator(); popupmenu.add(m2);popupmenu.addSeparator(); popupmenu.add(m3);
        add(popupmenu);
                
        //manage panel
        JPanel p2 = new JPanel();
        p2.setBounds(600,200,280,250);
        p2.setLayout(null);
        p2.setBackground(new Color(153,66,148));
        la.add(p2);
        
        JPanel p3 = new JPanel();
        p3.setBounds(10,10,260,70);
        p3.setLayout(null);
        p3.setBackground(Color.white);
        p2.add(p3);
        
        JLabel l1 = new JLabel("Manage");
        l1.setBounds(40,5,250,55);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.BOLD,45));
        p3.add(l1);
        
        b2 = new JButton("Dance Courses");
        b2.setBounds(40,105,200,50);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Rockwell",Font.BOLD,25));
        b2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b2.addActionListener(this);
        p2.add(b2);
        
        popupmenu2 = new JPopupMenu();   
        cm1 = new JMenuItem("Add Dance Course");
        cm1.setBackground(Color.DARK_GRAY);
        cm1.setForeground(Color.white);
        cm1.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        cm1.addActionListener(this);
        cm2 = new JMenuItem("View Dance Course");
        cm2.setBackground(Color.DARK_GRAY);
        cm2.setForeground(Color.white);
        cm2.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        cm2.addActionListener(this);
        popupmenu2.add(cm1);popupmenu2.addSeparator(); popupmenu2.add(cm2);
        add(popupmenu2);
        
        b3 = new JButton("Trainer");
        b3.setBounds(40,175,200,50);
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Rockwell",Font.BOLD,25));
        b3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b3.addActionListener(this);
        p2.add(b3);
        
        popupmenu3 = new JPopupMenu();   
        tm3 = new JMenuItem("Add Trainer");
        tm3.setBackground(Color.DARK_GRAY);
        tm3.setForeground(Color.white);
        tm3.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        tm3.addActionListener(this);
        tm4 = new JMenuItem("Trainer Details");
        tm4.setBackground(Color.DARK_GRAY);
        tm4.setForeground(Color.white);
        tm4.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        tm4.addActionListener(this);
        popupmenu3.add(tm3);popupmenu3.addSeparator(); popupmenu3.add(tm4);
        add(popupmenu3);
        
        
        //dancer reg panel
        JPanel p1 = new JPanel();
        p1.setBounds(50,200,500,90); //x y height width
        p1.setLayout(null);
        p1.setBackground(new Color(153,66,148));
        la.add(p1);
        
        JLabel l2 = new JLabel("New Student enrollment ");
        l2.setBounds(10,25,340,35);
        l2.setForeground(Color.black);
        l2.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        p1.add(l2);
        
        b4 = new JButton("enroll");
        b4.setBounds(300,20,150,50);
        //b4.setBackground(Color.white);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Rockwell",Font.BOLD,25));
        b4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b4.addActionListener(this);
        p1.add(b4);
               
        JPanel p4 = new JPanel();
        p4.setBounds(50,350,500,80);
        p4.setLayout(null);
        p4.setBackground(new Color(153,66,148));
        la.add(p4);
        
        JLabel l3 = new JLabel("Admitted Students");
        l3.setBounds(50,14,270,50);
        l3.setForeground(Color.black);
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        p4.add(l3);
        
        b6 = new JButton("View");
        b6.setBounds(300,16,150,45);
        //b6.setBackground(Color.white);
        b6.setForeground(Color.BLACK);
        b6.setFont(new Font("Rockwell",Font.BOLD,25));
        b6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b6.addActionListener(this);
        p4.add(b6);
        
        JPanel p5 = new JPanel();
        p5.setBounds(400,500,250,80);
        p5.setLayout(null);
        p5.setBackground(new Color(181,70,115));
        la.add(p5);
        
        b7 = new JButton("Get Reports");
        b7.setBounds(50,15,150,50);
        //b7.setBackground(Color.white);
        b7.setForeground(Color.BLACK);
        b7.setFont(new Font("Rockwell",Font.BOLD,24));
        b7.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b7.addActionListener(this);
        p5.add(b7);
        
        setVisible(true);
         
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            popupmenu.show(b1,75,0);
            try{
                popupmenu.wait();
            }catch(Exception ae){}
        }
        else if(e.getSource()==m1){
            new ChangePassword(username).setVisible(true);
            dispose();
        }
        else if(e.getSource()==m2){
            new EditAdminInfo(username).setVisible(true);
            dispose();
        }
        else if(e.getSource()==m3){
            new Login().setVisible(true);
            dispose();
        }
        else if(e.getSource()==b2){
             popupmenu2.show(b2,155,0);
        }
        else if(e.getSource()==cm1){
            new AddDanceCourse(username).setVisible(true);
        }
        else if(e.getSource()==cm2){
            new DanceCourseDetails(username).setVisible(true);       
        }
        else if(e.getSource()==b3){
             popupmenu3.show(b3,155,0);
        }
        else if(e.getSource()==tm3){
            new AddTrainer(username).setVisible(true);
        }
        else if(e.getSource()==tm4){
            new TrainerDetails(username).setVisible(true);
        }
        else if(e.getSource()==b4){
            new StudentRegistration(username).setVisible(true);
        }
        else if(e.getSource()==b5){
           setVisible(false);
           System.exit(0);
        }
        else if(e.getSource()==b6){
           new ViewStudents(username).setVisible(true);
        }
        else if(e.getSource()==b7){
           new ViewReports(username).setVisible(true);
        }
    
    }
   
    public static void main(String[] args){
        new Dashboard("");
    }
}   
