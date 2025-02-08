package dams;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EditAdminInfo extends JFrame implements ActionListener,DocumentListener{
    String username;
    JTextField f1,f2,f3;
    Choice c1;
    JButton b1,b2;
    EditAdminInfo(String username){
        this.username=username;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/editInfo.jpg"));
        Image im = i.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
        setIconImage(im);
        setResizable(false);
        setLayout(null);
        setBounds(80,50,1300,740);
        setUndecorated(true);
        
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1300,740);
        add(p);
       
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/dc.jpg"));
        Image b = bi.getImage().getScaledInstance(1300,740,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1300,740);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        //System.out.println(username);
        
        JLabel l1 = new JLabel("Username :");
        l1.setBounds(40,257,150,35);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Georgia",Font.BOLD,25));
        la.add(l1);
        
        f1 = new JTextField();
        f1.setBounds(200,260,200,30);
        f1.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        f1.setBorder(BorderFactory.createEmptyBorder());
        f1.getDocument().addDocumentListener(this);
        la.add(f1);
        
        JLabel l2 = new JLabel("Name :");
        l2.setForeground(Color.BLACK);
        l2.setBounds(40,320,150,35);
        l2.setFont(new Font("Georgia",Font.BOLD,25));
        la.add(l2);
        
        f2 = new JTextField();
        f2.setBounds(200,323,200,30);
        f2.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        f2.setBorder(BorderFactory.createEmptyBorder());
        f2.getDocument().addDocumentListener(this);
        la.add(f2);
        
        JLabel l3 = new JLabel("Security Question :");
        l3.setForeground(Color.BLACK);
        l3.setBounds(40,380,260,35);
        l3.setFont(new Font("Georgia",Font.BOLD,25));
        la.add(l3);
        
        c1 = new Choice();
        c1.add("who is your Idol?");
        c1.add("what is/was the name of your first pet");
        c1.add("Your favourite Singer?");
        c1.add("What city were you born in?");
        c1.setBounds(310,383,560,90);
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("Tahoma",Font.PLAIN,20));
        la.add(c1);
        
        JLabel l4 = new JLabel("Answer :");
        l4.setForeground(Color.BLACK);
        l4.setBounds(40,443,150,35);
        l4.setFont(new Font("Georgia",Font.BOLD,25));
        la.add(l4);
        
        f3 = new JTextField();
        f3.setBounds(200,447,200,30);
        f3.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        f3.setBorder(BorderFactory.createEmptyBorder());
        f3.getDocument().addDocumentListener(this);
        la.add(f3);
        
        b1 = new JButton("Update");
        b1.setBackground(Color.white);
        b1.setForeground(Color.BLACK);
        b1.setBounds(380,520,100,35);
        b1.setFont(new Font("Georgia",Font.BOLD,25));
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.addActionListener(this);
        la.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);
        b2.setBounds(20,20,100,30);
        b2.setFont(new Font("Georgia",Font.BOLD,25));
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.addActionListener(this);
        la.add(b2);
        
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from adminInfo where uName= '"+username+"'");
            while(rs.next()){
                f1.setText(rs.getString("uName"));     //get text from username column and put it in textField 
                f2.setText(rs.getString("name"));
                f3.setText(rs.getString("secAns"));
                c1.select(rs.getString("secQue"));
            }
        }catch(Exception e){}
        
        setVisible(true);
    }
    
    
    public void changedUpdate(DocumentEvent de){
        changed();
    }
    public void removeUpdate(DocumentEvent de){
        changed();
    }
    public void insertUpdate(DocumentEvent de){
        changed();
    }
    public void changed(){
        if(f1.getText().equals("") || f2.getText().equals("") || f3.getText().equals("")){
            b1.setEnabled(false);
        }
        else{
            b1.setEnabled(true);
        }
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String userName = f1.getText();
            String name = f2.getText();
            String question = c1.getSelectedItem();
            String answer = f3.getText();
            String sql = "update adminInfo set uName ='"+userName+"',name ='"+name+"',secQue ='"+question+"',secAns ='"+answer+"'";
            try{
                Conn c =new Conn();
                c.s.executeUpdate(sql);
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Admin details are updated successfully, Please login again");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,17));
                op.showMessageDialog(this,msg,"",JOptionPane.PLAIN_MESSAGE);
                dispose();
                new Login().setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            new Dashboard(username).setVisible(true);
            dispose();
        }
    }
    public static void main(String[] args){
        new EditAdminInfo("");
    }
}