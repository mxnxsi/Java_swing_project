package dams;
import java.lang.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static dams.AddTrainer.isValidEmail;
import static dams.AddTrainer.isValidMobileNo;
import static dams.AddTrainer.readAllBytes;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;   
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.util.Date;

public class TrainerDetails extends JFrame implements DocumentListener, ActionListener, MouseListener{
    JPanel p,p1,p2;
    JLabel l1,l11,l2,l22,l3,l33,l4,l5,l6,l7,l8,l9,l99,l10,l19;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf8, tf9,tf10;
    JTextArea ta6, ta7;
    String username;
    JButton b1,b2,b3,b4,b5,b6,b7;
    com.toedter.calendar.JDateChooser jdc;
    
    public static void main(String[] args){
        new TrainerDetails("");
    }
    
    TrainerDetails(String username){
        this.username=username;
        setBounds(80,50,1370,760);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("Trainer Details");
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(0,0,1370,760);
        add(p);
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/db.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1370,760);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(15,15,1140,730);
        p1.setBackground(new Color(0,0,0,25));
        la.add(p1);
        
        b1 = new JButton("Update Trainer");   
        b1.setBackground(new Color(0,102,102));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createLineBorder(Color.white));
        b1.setFont(new Font("Georgia",Font.BOLD,19));
        b1.setBounds(1170,185,180,40);
        b1.addActionListener(this);
        b1.setEnabled(false);
        la.add(b1);
        
        b2 = new JButton("Back");       //back to login page
        b2.setBackground(new Color(0,102,102));
        b2.setForeground(Color.white);
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.setFont(new Font("SAN_SERIF",Font.BOLD,22));
        b2.addActionListener(this);
        b2.setBounds(1170,485,180,40);
        la.add(b2);
        
        b6 = new JButton("Delete Trainer");   
        b6.setBackground(new Color(0,102,102));
        b6.setForeground(Color.WHITE);
        b6.setBorder(BorderFactory.createLineBorder(Color.white));
        b6.setFont(new Font("Georgia",Font.BOLD,19));
        b6.setBounds(1170,285,180,40);
        b6.setEnabled(false);
        b6.addActionListener(this);
        la.add(b6);
        
        b7 = new JButton("View All"); 
        b7.setBackground(new Color(0,102,102));
        b7.setForeground(Color.WHITE);
        b7.setBorder(BorderFactory.createLineBorder(Color.white));
        b7.setFont(new Font("Georgia",Font.BOLD,19));
        b7.addActionListener(this);
        b7.setBounds(1170,385,180,40);
        la.add(b7);
        
        l3 = new JLabel("Search By ID :");
        l3.setBounds(220,25,250,30);
        l3.setFont(new Font("Georgia",Font.BOLD,25));
        l3.setForeground(Color.BLACK);
        p1.add(l3);
        
        tf3 = new JTextField("");
        tf3.setBounds(420,25,100,30);
        tf3.setFont(new Font("Georgia",Font.BOLD,25));
        tf3.setForeground(Color.BLACK);
        p1.add(tf3);
        
        b5 = new JButton("Search");       //back to login page
        b5.setBackground(new Color(0,102,102));
        b5.setForeground(Color.white);
        b5.setBorder(BorderFactory.createRaisedBevelBorder());
        b5.setFont(new Font("SAN_SERIF",Font.BOLD,22));
        b5.addActionListener(this);
        b5.setBounds(550,25,100,30);
        p1.add(b5);
        
        l1 = new JLabel("First  Name :");
        l1.setBounds(20,115,150,30);
        l1.setFont(new Font("Georgia",Font.BOLD,19));
        l1.setForeground(Color.BLACK);
        p1.add(l1);
        
        tf1 = new JTextField();
        tf1.setBounds(170,115,200,33);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,21));
        tf1.setForeground(Color.BLACK);
        tf1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT && !tf2.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() && !tf5.getText().isEmpty() && !ta6.getText().isEmpty() && !ta7.getText().isEmpty() && !tf8.getText().isEmpty() && !tf9.getText().isEmpty()){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf1.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                }
            }
        });
        tf1.getDocument().addDocumentListener(this);
        p1.add(tf1);
        
        
        l2 = new JLabel("Last Name :");
        l2.setBounds(20,205,150,30);
        l2.setFont(new Font("Georgia",Font.BOLD,19));
        l2.setForeground(Color.BLACK);
        p1.add(l2);
        
        tf2 = new JTextField();
        tf2.setBounds(170,205,200,33);
        tf2.setFont(new Font("Tahoma",Font.PLAIN,21));
        tf2.setForeground(Color.BLACK);
        tf2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT  && !tf1.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() && !tf5.getText().isEmpty() && !ta6.getText().isEmpty() && !ta7.getText().isEmpty() && !tf8.getText().isEmpty() && !tf9.getText().isEmpty()){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf1.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                }
            }
        });
        tf2.getDocument().addDocumentListener(this);
        p1.add(tf2);
         
        JLabel l4 = new JLabel("Mobile No. :");
        l4.setBounds(20,295,150,30);
        l4.setFont(new Font("Georgia",Font.BOLD,19));
        l4.setForeground(Color.BLACK);
        p1.add(l4);
       
         
        tf4 = new JTextField();
        tf4.setBounds(170,295,200,33);
        tf4.setFont(new Font("Tahoma",Font.PLAIN,21));
        tf4.setForeground(Color.BLACK);
        tf4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf4.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                  
                  if(tf4.getText().length()>=10){
                      UIManager ui = new UIManager();
                      ui.put("OptionPane.background",Color.WHITE);
                      ui.put("Panel.background",Color.WHITE);
                      //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                      JOptionPane op = new JOptionPane();
                      JLabel msg = new JLabel("Invalid Input");
                      msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                      op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                      b1.setEnabled(false);
                      tf4.setText("");
                  }          
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf4.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                    tf4.setText("");
                }
            }
        });
        tf4.getDocument().addDocumentListener(this);
        p1.add(tf4);
                
        JLabel l5 = new JLabel("Email :");
        l5.setBounds(20,385,150,30);
        l5.setFont(new Font("Georgia",Font.BOLD,19));
        l5.setForeground(Color.BLACK);
        p1.add(l5);
        
        tf5 = new JTextField();
        tf5.setBounds(170,385,300,33);
        tf5.setFont(new Font("Tahoma",Font.PLAIN,21));
        tf5.setForeground(Color.BLACK);
        tf5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf5.getDocument().addDocumentListener(this);
        tf5.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT  || e.getKeyCode()==KeyEvent.VK_AT && !tf1.getText().isEmpty() && !tf3.getText().isEmpty() && !tf2.getText().isEmpty() && !tf5.getText().isEmpty() && !ta6.getText().isEmpty() && !ta7.getText().isEmpty() && !tf8.getText().isEmpty() && !tf9.getText().isEmpty()){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf5.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
            }
        });
        p1.add(tf5);
        
        JLabel l7 = new JLabel("Qualification :");
        l7.setBounds(20,480,150,30);
        l7.setFont(new Font("Georgia",Font.BOLD,19));
        l7.setForeground(Color.BLACK);
        p1.add(l7);
        
        ta7 = new JTextArea();
//        ta7.setBounds(170,360,300,80);
        ta7.setFont(new Font("Tahoma",Font.PLAIN,21));
        ta7.setForeground(Color.BLACK);
        ta7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ta7.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT && !tf1.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() && !tf5.getText().isEmpty() && !tf2.getText().isEmpty() && !ta6.getText().isEmpty() && !tf8.getText().isEmpty() && !tf9.getText().isEmpty()){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(ta7.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
            }
        });
        ta7.getDocument().addDocumentListener(this);
        JScrollPane pane1 = new JScrollPane(ta7,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane1.setBounds(170,480,300,100);
        p1.add(pane1);
                
        JLabel l8 = new JLabel("Experience :");
        l8.setBounds(20,645,150,30);
        l8.setFont(new Font("Georgia",Font.BOLD,19));
        l8.setForeground(Color.BLACK);
        p1.add(l8);
        JLabel l88 = new JLabel("yr/yrs");
        l88.setBounds(280,645,150,30);
        l88.setFont(new Font("Georgia",Font.BOLD,19));
        l88.setForeground(Color.BLACK);
        p1.add(l88);
        tf8 = new JTextField();
        tf8.setBounds(170,645,100,33);
        tf8.setFont(new Font("Tahoma",Font.PLAIN,21));
        tf8.setForeground(Color.BLACK);
        tf8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf8.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                  
                  if(tf8.getText().length()<1){
                     b1.setEnabled(true);
                  }
                  if(tf8.getText().length()>=2){
                      UIManager ui = new UIManager();
                      ui.put("OptionPane.background",Color.WHITE);
                      ui.put("Panel.background",Color.WHITE);
                      //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                      JOptionPane op = new JOptionPane();
                      JLabel msg = new JLabel("Invalid Input");
                      msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                      op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                      
                  }          
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf8.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                    tf8.setText("");
                }
            }
        });
        tf8.getDocument().addDocumentListener(this);
        p1.add(tf8);
                        
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(650,115,370,180);
        p2.setBackground(Color.white);
        p1.add(p2);
        
        //image add
        l33 = new JLabel();
        l33.setBounds(15,5,200,170);
        l33.setLayout(null);
        p2.add(l33);
                    
        b3 = new JButton("Add Image");   
        b3.setLayout(null);
        b3.setBackground(new Color(0,102,102));
        b3.setForeground(Color.white);
        b3.setBorder(BorderFactory.createLineBorder(Color.white));
        b3.setFont(new Font("Georgia",Font.BOLD,16));
        b3.setBounds(210,35,150,30);
        b3.addActionListener(this);
        p2.add(b3);
      
        b4 = new JButton();   
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("dams/icons/undo.png"));
        Image i2 = ic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        b4.setIcon(i3);
        b4.setLayout(null);
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.RED);
        b4.setBorder(BorderFactory.createLineBorder(Color.white));
        b4.setFont(new Font("Georgia",Font.BOLD,10));
        b4.setBounds(210,100,40,40);
        b4.addActionListener(this);
        p2.add(b4);
        
        JLabel l6 = new JLabel("Address :");
        l6.setBounds(560,375,150,30);
        l6.setFont(new Font("Georgia",Font.BOLD,19));
        l6.setForeground(Color.BLACK);
        p1.add(l6);
        
        ta6 = new JTextArea();
        //ta6.setBounds(720,375,350,80);
        ta6.setFont(new Font("Tahoma",Font.PLAIN,21));
        ta6.setForeground(Color.BLACK);
        ta6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ta6.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(ta6.getText().length()==1){
                        b1.setEnabled(false);
                    }
                } 
            }
        });
        ta6.getDocument().addDocumentListener(this);
        JScrollPane pane = new JScrollPane(ta6,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setBounds(680,375,350,100);
        p1.add(pane);        
        
        JLabel l9 = new JLabel("Salary :");
        l9.setBounds(590,535,150,30);
        l9.setFont(new Font("Georgia",Font.BOLD,19));
        l9.setForeground(Color.BLACK);
        p1.add(l9);
       
        tf9 = new JTextField();
        tf9.setBounds(700,535,150,33);
        tf9.setFont(new Font("Tahoma",Font.PLAIN,21));
        tf9.setForeground(Color.BLACK);
        tf9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf9.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                  
                  if(tf9.getText().length()<4){
                     b1.setEnabled(true);
                  }
                  if(tf9.getText().length()>=8){
                      UIManager ui = new UIManager();
                      ui.put("OptionPane.background",Color.WHITE);
                      ui.put("Panel.background",Color.WHITE);
                      //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                      JOptionPane op = new JOptionPane();
                      JLabel msg = new JLabel("Invalid Input");
                      msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                      op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                      
                  }          
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf9.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                    tf9.setText("");
                }
            }
        });
        tf9.getDocument().addDocumentListener(this);
        p1.add(tf9);
        
        JLabel l10 = new JLabel("Joining date:");
        l10.setBounds(590,625,180,30);
        l10.setForeground(Color.black);
        l10.setFont(new Font("Georgia",Font.BOLD,19));
        p1.add(l10);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(745,625,180,30);
        p1.add(p);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.getComponent(1).addMouseListener(this);
        jdc.getComponent(0).addMouseListener(this);
        jdc.getComponent(0).setForeground(Color.BLACK);
        ((JTextField)jdc.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        java.util.Date d = new java.util.Date();
        jdc.setMinSelectableDate(d);        
        p.add(jdc);
        
        
        setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e){
        if(e.getSource()==jdc.getComponent(1)){
            jdc.getComponent(1).setEnabled(false);
            JOptionPane.showMessageDialog(this, "Please select the date");
        }
        if(e.getSource()==jdc.getComponent(0)){
            System.out.println(jdc.getDate());
            jdc.getComponent(1).setEnabled(true);
            
        }
    }
    
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    
    public void mouseMoved(MouseEvent e) {
        
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
        if(tf1.getText().equals("") || tf2.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || tf5.getText().equals("") || ta6.getText().equals("") || ta7.getText().equals("") || tf8.getText().equals("") || tf9.getText().equals("") ||((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
            b1.setEnabled(false);
            b6.setEnabled(false);
        }
        else{
            b1.setEnabled(true);
            b6.setEnabled(true);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        String filePath="";
        
        
        //search
        if(e.getSource()==b5){
            int tId = Integer.parseInt(tf3.getText());
            try{
                Conn c = new Conn();
                FileInputStream fis = null;
                ResultSet rs = c.s.executeQuery("select * from trainerinfo where tId='"+tId+"'");
                while(rs.next()){
                    
                    File file2 = new File(rs.getString("TImgPath"));
                    //fis is reference variable
                    fis = new FileInputStream(file2);
                    byte[] by = readAllBytes(fis);
                    ImageIcon i1 = new ImageIcon(by);
                    Image i2 = i1.getImage().getScaledInstance(100,140,Image.SCALE_DEFAULT);
                    ImageIcon i3 = new ImageIcon(i2);
                    
                    l33.setIcon(i3);
                    tf1.setText(rs.getString("TfName"));
                    tf2.setText(rs.getString("TlName"));
                    tf4.setText(rs.getString("TMob"));  
                    tf5.setText(rs.getString("TEml"));
                    ta6.setText(rs.getString("TAddress"));
                    ta7.setText(rs.getString("TQualification"));
                    tf8.setText(rs.getString("TExperience"));
                    tf9.setText(rs.getString("TSalary"));   
                    //p.add(date);
                    String datee = rs.getString("TJdate");
                    System.out.println(datee);
                    Date da = null;
                    try{
                        da = new SimpleDateFormat("dd/MM/yyyy").parse(datee);
                    }
                    catch(Exception de){
                
                    }
                    ((JTextField)jdc.getDateEditor().getUiComponent()).setText(datee);
                    ((JTextField)jdc.getDateEditor().getUiComponent()).setForeground(Color.BLACK);
                    System.out.println(jdc.getDate());
                }
            }catch(SQLException | FileNotFoundException ex){
                
                System.out.println(ex);
                      
            }catch (IOException ex) {
                Logger.getLogger(TrainerDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(true);
        }
        
        
        if(e.getSource()==b3){
            int tId = Integer.parseInt(tf3.getText());
                JFileChooser fc = new JFileChooser("D:\\DAMS\\src\\dams\\trainers");       //path given
                if(fc.showOpenDialog(this)==fc.APPROVE_OPTION){     //open files menu, if selected then
                    File f = fc.getSelectedFile();      //selected file
                    filePath = f.getPath();      //path in string type
                    System.out.println(filePath);
                    int i=0; 
                   
                    StringBuilder s = new StringBuilder(filePath);
                    while(i<s.length()){
                        if(s.charAt(i)=='\\'){
                            
                              s.setCharAt(i,'/');
                              i+=2;
                        }
                        i++;
                    }
                    filePath=s.toString();
                    
                    
                 String sql = "insert into filepath values('"+filePath+"')";
                 FileInputStream fis = null;
                 try{
                     Conn c = new Conn();
                     c.s.executeUpdate(sql);
                     setVisible(false);
                     setVisible(true);
                     String s2 = "select * from filepath";
                     ResultSet rs = c.s.executeQuery(s2);
                     String p="";
                     if(rs.next()){
                        p = rs.getString("loc");
                     }
                     File file2 = new File(p);
                     //fis is reference variable
                     //import java.io.*;
                     fis = new FileInputStream(file2);
                     byte[] b = readAllBytes(fis);
                     ImageIcon i4 = new ImageIcon(b);
                     Image i5 = i4.getImage().getScaledInstance(100,140,Image.SCALE_DEFAULT);
                     ImageIcon i6 = new ImageIcon(i5);
                     l33.setIcon(i6);
                     
                 }catch(IOException | SQLException | NumberFormatException | HeadlessException ex){} 
               }
            }
        
        System.out.println(filePath);
        if(e.getSource()==b4){
                int tId = Integer.parseInt(tf3.getText());
                l33.setIcon(null);
                Conn c = new Conn();
                String sql4 = "delete from filePath";

                try{
                    c.s.execute(sql4);
                }catch(SQLException | NumberFormatException | HeadlessException ex){
                    System.out.println(ex);
                }
        }
        
        //update
        if(e.getSource()==b1){
            int tId = Integer.parseInt(tf3.getText());
            if(!isValidMobileNo(tf4.getText())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Invalid Mobile Number");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                b1.setEnabled(false);
            } 
            if(!isValidEmail(tf5.getText())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Invalid Email");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                b1.setEnabled(false);
            }
            
            if(isValidMobileNo(tf4.getText()) && isValidEmail(tf5.getText())){
                                
                if(!tf3.getText().equals("")){
                    UIManager uii = new UIManager();
                    uii.put("OptionPane.background",Color.WHITE);
                    uii.put("Panel.background",Color.WHITE);
                    uii.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane opp = new JOptionPane();
                    JLabel msgg = new JLabel("Are you sure");
                    msgg.setFont(new Font("SAN_SERIF",Font.BOLD,22));
                    int a = opp.showConfirmDialog(this,msgg,"Please Confirm",0);
            
                    if(a==opp.YES_OPTION){
                        
                        System.out.println(filePath);
                        String loc ="";
                        String locc ="";
                        //String dateee = ((JTextField)jdc.getDateEditor().getUiComponent()).getText();
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dateee = sdf.format(jdc.getDate());
                        //System.out.println(dateee);
                        try{
                            Conn c =new Conn();
                            FileInputStream fis = null;
                            String sql2 = "select * from filepath";
                            String sql3 = "delete from filepath";
                            ResultSet rs = c.s.executeQuery(sql2);       //whole row
                            //c.s.executeQuery() returns ResultSet class object so must be stored in same class object
                            while(rs.next()){   //column to column jump
                                loc = rs.getString("loc");
                                //System.out.println(loc);
                            }
                            ResultSet rss = c.s.executeQuery("select * from trainerinfo where tId='"+tId+"'");
                            while(rss.next()){

                                locc = rss.getString("TImgPath");
                                
                            }
                            if(!loc.equals("")){
                                //String query = "update trainerinfo set(tfName,tlName,tMob,tEml,tAddress, tQualification, tExperience, tSalary, tJdate, tImgPath) values('"+tf3.getText()+"','"+tf1.getText()+"','"+tf2.getText()+"','"+Long.parseLong(tf4.getText())+"','"+tf5.getText()+"','"+ta6.getText()+"','"+ta7.getText()+"','"+tf8.getText()+"','"+Long.parseLong(tf9.getText())+"','"+dateee+"','"+loc+"') where tId = '"+tf3+"'";
                                String query = "update trainerinfo set tId='"+tId+"', tfName='"+tf1.getText()+"', tlName='"+tf2.getText()+"', tMob='"+Long.parseLong(tf4.getText())+"', tEml='"+tf5.getText()+"', tAddress='"+ta6.getText()+"', tQualification='"+ta7.getText()+"', tExperience='"+Integer.parseInt(tf8.getText())+"', tSalary='"+Double.parseDouble(tf9.getText())+"', TJdate='"+dateee+"', TImgPath='"+loc+"' where tId='"+tId+"'";
                                c.s.executeUpdate(query);
                                c.s.execute(sql3);
                                //booking capacity
                                UIManager ui = new UIManager();
                                ui.put("OptionPane.background",Color.WHITE);
                                ui.put("Panel.background",Color.WHITE);
                                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                                JOptionPane op = new JOptionPane();
                                JLabel msg = new JLabel("Trainer updated successfully");
                                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                                op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);
                                tf1.setText("");
                                tf2.setText("");
                                tf3.setText("");
                                tf4.setText("");
                                tf5.setText("");
                                ta6.setText("");
                                ta7.setText("");
                                tf8.setText("");
                                tf9.setText("");
                                ((JTextField)jdc.getDateEditor().getUiComponent()).setText("");
                                l33.setIcon(null);
                                //setVisible(false);
                            }
                            else if(!locc.equals("")){
                                
                                String query = "update trainerinfo set tId='"+tId+"', tfName='"+tf1.getText()+"', tlName='"+tf2.getText()+"', tMob='"+Long.parseLong(tf4.getText())+"', tEml='"+tf5.getText()+"', tAddress='"+ta6.getText()+"', tQualification='"+ta7.getText()+"', tExperience='"+Integer.parseInt(tf8.getText())+"', tSalary='"+Double.parseDouble(tf9.getText())+"', TJdate='"+dateee+"', TImgPath='"+locc+"' where tId='"+tId+"'";
                                c.s.executeUpdate(query);
                                c.s.execute(sql3);
                                //booking capacity
                                UIManager ui = new UIManager();
                                ui.put("OptionPane.background",Color.WHITE);
                                ui.put("Panel.background",Color.WHITE);
                                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                                JOptionPane op = new JOptionPane();
                                JLabel msg = new JLabel("Trainer updated successfully");
                                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                                op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);
                                tf1.setText("");
                                tf2.setText("");
                                tf3.setText("");
                                tf4.setText("");
                                tf5.setText("");
                                ta6.setText("");
                                ta7.setText("");
                                tf8.setText("");
                                tf9.setText("");
                                ((JTextField)jdc.getDateEditor().getUiComponent()).setText("");
                                l33.setIcon(null);
                            }
                            else{
                                UIManager ui = new UIManager();
                                ui.put("OptionPane.background",Color.WHITE);
                                ui.put("Panel.background",Color.WHITE);
                                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                                JOptionPane op = new JOptionPane();
                                JLabel msg = new JLabel("please add an image");
                                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                            }
                    
                        }catch(SQLException | NumberFormatException | HeadlessException ae){
                            System.out.println(ae);
                            UIManager ui = new UIManager();
                            ui.put("OptionPane.background",Color.WHITE);
                            ui.put("Panel.background",Color.WHITE);
                            //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                            JOptionPane op = new JOptionPane();
                            JLabel msg = new JLabel("You didn't fill in all the details");
                            msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                            op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                        }
                
                    }
                    else{
                        UIManager ui1 = new UIManager();
                        ui1.put("OptionPane.background",Color.WHITE);
                        ui1.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op1 = new JOptionPane();
                        JLabel msg1 = new JLabel("Updation Canceled");
                        msg1.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op1.showMessageDialog(this,msg1,"",JOptionPane.ERROR_MESSAGE);
                    }   
                }
                  
            }
            b1.setEnabled(false);
        }
        
        //delete
        if(e.getSource()==b6){
            int tId = Integer.parseInt(tf3.getText());
            Conn c = new Conn();
            int j=0,k=0;
            //System.out.println(j);
            String rem = "delete from trainerinfo where tId='"+tId+"'";
            String sr2 = "select tId from trainerinfo where tId='"+tId+"'";
            String sr3 = "select count(tfName) from trainerinfo";
            //reset auto increment
            
            try{
                ResultSet rs2 = c.s.executeQuery(sr3);
                while(rs2.next()){
                    k=Integer.parseInt(rs2.getString("count(tfName)"));
                }
                ResultSet rs = c.s.executeQuery(sr2);
                if(rs.next()){
                    j = Integer.parseInt(rs.getString("tId"));
                }
                c.s.execute(rem);
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Trainer removed");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                while(j<=k){
                    String sr = "update trainerinfo set tId='"+(j)+"' where tId='"+(j+1)+"'";
                    c.s.executeUpdate(sr);
                    j++;
                    //System.out.println(j);
                }
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                ta6.setText("");
                ta7.setText("");
                tf8.setText("");
                tf9.setText("");
                ((JTextField)jdc.getDateEditor().getUiComponent()).setText("");
                l33.setIcon(null);
                
                
            }catch(SQLException | NumberFormatException | HeadlessException ex){
                System.out.println(ex);
            }
            b6.setEnabled(false);
        }
        
        if(e.getSource()==b2){ //Back
            setVisible(false);
        }
        if(e.getSource()==b7){
            new ViewTrainers(username).setVisible(true);
        }
        
    }
}