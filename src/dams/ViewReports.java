package dams;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewReports extends JFrame implements ActionListener{
    String username;
    JButton b1,b2,b3,b4;
    ViewReports(String username){
        this.username=username;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/dc.jpg"));
        Image im = i.getImage();
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle("Dashboard");
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/dc.jpg"));
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
        
        JLabel l = new JLabel("View Reports :");
        l.setBounds(30,140,400,50);
        l.setForeground(Color.black);
        l.setFont(new Font("Rockwell",Font.BOLD,40));
        la.add(l);
        
        JPanel p1 = new JPanel();
        p1.setBounds(30,220,340,240);
        p1.setLayout(null);
        p1.setBackground(new Color(181,70,115));
        la.add(p1);
        
        b1 = new JButton("Student report");
        b1.setBounds(20,20,300,40);
        b1.setBackground(Color.white);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Rockwell",Font.BOLD,25));
        b1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("Dance Course Reports");
        b2.setBounds(20,100,300,40);
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Rockwell",Font.BOLD,25));
        b2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        b2.addActionListener(this);
        p1.add(b2);
        
        b3 = new JButton("Trainer Reports");
        b3.setBounds(20,180,300,40);
        b3.setBackground(Color.white);
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Rockwell",Font.BOLD,25));
        b3.setBorder(BorderFactory.createRaisedBevelBorder());
        b3.addActionListener(this);
        p1.add(b3);
        
        b4 = new JButton("Back");
        b4.setBounds(20,20,120,40);
        b4.setBackground(Color.white);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Rockwell",Font.BOLD,25));
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.addActionListener(this);
        la.add(b4);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b4){
            setVisible(false);
        }
        if(e.getSource()==b1){
            //new StudentReport("").setVisible(true);
        }
        if(e.getSource()==b2){
            //new DanceCourseReport("").setVisible(true);
        }
        if(e.getSource()==b3){
            //new TrainerReports("").setVisible(true);
        }
    }
    
    
    public static void main(String[] args){
        new ViewReports("");
    }
}
