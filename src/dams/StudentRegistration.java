package dams;
import java.lang.*;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class StudentRegistration extends JFrame implements ActionListener,ItemListener, DocumentListener{

    String username;
    JLabel l, ll, li, lii, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l100, l11, l111, l12, l122, l13, l133, l14, l144, l15, l155, l16, l166, l17, l177;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    Choice ch6;
    JRadioButton rb71,rb72,rb73,rb74;
    JCheckBox cb8; 
    com.toedter.calendar.JDateChooser jdc;
    JButton b1, b2, b3, b4, b5, b6, b7;
    JPanel p1, p2, p3, pi;

    public static void main(String[] args) {
        new StudentRegistration("");
    }

    StudentRegistration(String username) {
        this.username = username;
        setBounds(80, 50, 1370, 760);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("New Registration");
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/d6.jpg"));
        Image b = bi.getImage().getScaledInstance(1370, 760, Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 1370, 760);
        add(p);
        JLabel la = new JLabel(bii);
        la.setBounds(0, 0, 1370, 760);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell", Font.BOLD, 12));
        p.add(la);

        //personal Details
        JLabel pd = new JLabel("Personal Information : ");
        pd.setBounds(45, 43, 380, 30);
        pd.setFont(new Font("TAHOMA", Font.BOLD, 30));
        pd.setForeground(new Color(27,02,02));
        la.add(pd);

        p1 = new JPanel();
        p1.setBounds(45, 100, 350, 550);
        p1.setBackground(Color.WHITE);
        p1.setLayout(null);
        la.add(p1);

        //image 
        pi = new JPanel();
        pi.setLayout(null);
        pi.setBounds(10, 10, 330, 120);
        pi.setBackground(new Color(255, 204, 204));
        p1.add(pi);

        li = new JLabel();
        li.setBounds(15, 0, 135, 120);
        li.setLayout(null);
        pi.add(li);

        b3 = new JButton("Add photo");
        b3.setLayout(null);
        b3.setBackground(new Color(0, 102, 102));
        b3.setForeground(Color.white);
        b3.setBorder(BorderFactory.createLineBorder(Color.white));
        b3.setFont(new Font("Georgia", Font.BOLD, 16));
        b3.setBounds(170, 15, 140, 30);
        b3.addActionListener(this);
        pi.add(b3);

        b4 = new JButton();
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("dams/icons/undo.png"));
        Image i2 = ic.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        b4.setIcon(i3);
        b4.setLayout(null);
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.RED);
        b4.setBorder(BorderFactory.createLineBorder(Color.white));
        b4.setFont(new Font("Georgia", Font.BOLD, 10));
        b4.setBounds(170, 60, 25, 25);
        b4.addActionListener(this);
        pi.add(b4);

        l1 = new JLabel("Name :");
        l1.setBounds(20, 165, 63, 30);
        l1.setFont(new Font("Georgia", Font.BOLD, 17));
        l1.setForeground(Color.BLACK);
        p1.add(l1);

        tf1 = new JTextField("");
        tf1.setBounds(87, 165, 242, 30);
        tf1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tf1.setForeground(Color.BLACK);
        tf1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (Character.isLetterOrDigit(ch) || e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    b5.setEnabled(true);
                } else if (ch == KeyEvent.VK_BACK_SPACE) {
                    if (tf1.getText().length() == 1) {
                        b5.setEnabled(false);
                    }
                } else {
                    b5.setEnabled(false);
                }
            }
        });
        
        tf1.getDocument().addDocumentListener(this);
        p1.add(tf1);

        l2 = new JLabel("Address :");
        l2.setBounds(20, 240, 90, 30);
        l2.setFont(new Font("Georgia", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);
        p1.add(l2);

        tf2 = new JTextField();
        tf2.setBounds(110, 240, 220, 30);
        tf2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tf2.setForeground(Color.BLACK);
        tf2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (Character.isLetterOrDigit(ch) || e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    b5.setEnabled(true);
                } else if (ch == KeyEvent.VK_BACK_SPACE) {
                    if (tf2.getText().length() == 1) {
                        b5.setEnabled(false);
                    }
                } else {
                    b5.setEnabled(false);
                }
            }
        });
        tf2.getDocument().addDocumentListener(this);
        p1.add(tf2);

        l3 = new JLabel("Pincode :");
        l3.setBounds(20, 315, 110, 30);
        l3.setFont(new Font("Georgia", Font.BOLD, 17));
        l3.setForeground(Color.BLACK);
        p1.add(l3);

        tf3 = new JTextField();
        tf3.setBounds(135, 315, 190, 30);
        tf3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tf3.setForeground(Color.BLACK);
        tf3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (Character.isDigit(ch)) {
                    if (tf3.getText().length() < 5) {
                        b5.setEnabled(false);
                    }
                    if (tf3.getText().length() == 5) {
                        b5.setEnabled(true);
                    }
                    if (tf3.getText().length() >= 6) {
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background", Color.WHITE);
                        ui.put("Panel.background", Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Invalid Input");
                        msg.setFont(new Font("SAN_SERIF", Font.BOLD, 19));
                        op.showMessageDialog(p2, msg, "", JOptionPane.ERROR_MESSAGE);
                        tf3.setText("");
                    }
                } else if (ch == KeyEvent.VK_BACK_SPACE) {
                    if (tf3.getText().length() == 1) {
                        b5.setEnabled(false);
                    }
                } else {
                    tf3.setText("");
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background", Color.WHITE);
                    ui.put("Panel.background", Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF", Font.BOLD, 19));
                    op.showMessageDialog(p2, msg, "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tf3.getDocument().addDocumentListener(this);
        p1.add(tf3);

        l4 = new JLabel("Mobile No. :");
        l4.setBounds(20, 390, 110, 30);
        l4.setFont(new Font("Georgia", Font.BOLD, 17));
        l4.setForeground(Color.BLACK);
        p1.add(l4);

        tf4 = new JTextField();
        tf4.setBounds(135, 390, 190, 30);
        tf4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tf4.setForeground(Color.BLACK);
        tf4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf4.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if (Character.isDigit(ch)) {

                    if (tf4.getText().length() >= 10) {
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background", Color.WHITE);
                        ui.put("Panel.background", Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Invalid Input");
                        msg.setFont(new Font("SAN_SERIF", Font.BOLD, 19));
                        op.showMessageDialog(p1, msg, "", JOptionPane.ERROR_MESSAGE);
                        b5.setEnabled(false);
                        tf4.setText("");
                    }
                } else if (ch == KeyEvent.VK_BACK_SPACE) {
                    if (tf4.getText().length() == 1) {
                        b5.setEnabled(false);
                    }
                } else {

                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background", Color.WHITE);
                    ui.put("Panel.background", Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Invalid Input");
                    msg.setFont(new Font("SAN_SERIF", Font.BOLD, 19));
                    op.showMessageDialog(p1, msg, "", JOptionPane.ERROR_MESSAGE);
                    tf4.setText("");
                }
            }
        });
        tf4.getDocument().addDocumentListener(this);
        p1.add(tf4);

        l5 = new JLabel("Email :");
        l5.setBounds(20,465,65,30);
        l5.setFont(new Font("Georgia",Font.BOLD,17));
        l5.setForeground(Color.BLACK);
        p1.add(l5);
        
        tf5 = new JTextField();
        tf5.setBounds(90,465,235,30);
        tf5.setFont(new Font("Tahoma",Font.PLAIN,17));
        tf5.setForeground(Color.BLACK);
        tf5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf5.getDocument().addDocumentListener(this);
        tf5.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT  || e.getKeyCode()==KeyEvent.VK_AT ){
                    b5.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf5.getText().length()==1){
                        b5.setEnabled(false);
                    }
                }
            }
        });
        p1.add(tf5);
        
        //Course Details
        JLabel sdc = new JLabel("Course Selection : ");
        sdc.setBounds(535,43,350,30);
        sdc.setFont(new Font("TAHOMA",Font.BOLD,30));
        sdc.setForeground(new Color(27,02,02));
        la.add(sdc);
        
        p2 = new JPanel();
        p2.setBounds(452, 100, 465, 450);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);
        la.add(p2);
        
        l6 = new JLabel("Dance Course :");
        l6.setBounds(20,20,150,30);
        l6.setFont(new Font("Georgia",Font.BOLD,19));
        l6.setForeground(Color.BLACK);
        p2.add(l6);
        
        JLabel l66 = new JLabel("Please select the Dance Course");
        l66.setBounds(175,20,175,33);
        l66.setForeground(Color.RED);
        l66.setFont(new Font("Rockwell",Font.BOLD,19));
        
        Conn  c = new Conn();
        ch6 = new Choice();
        ch6.add("none");
         //date
        String sql4 = "select count(dType) from bCapacity where sRegistered < bCapacity ";
        String sql = "select dType from bCapacity where sRegistered < bCapacity ";
        try{
           ResultSet rs4 = c.s.executeQuery(sql4);
           int n = 0;
           if(rs4.next()){
               n = rs4.getInt("count(dType)");
           }
           
           String[] dType = new String[n];
           ResultSet rs2 = c.s.executeQuery(sql);
           int j=0;
           while(rs2.next()){
              dType[j]=rs2.getString("dType");
              
              j++;
           }
           int k=0;
           while(k<dType.length){
               
               String sql3 = "select dType from dcinfo where dType='"+dType[k]+"'";
               ResultSet rs3 = c.s.executeQuery(sql3);
               if(rs3.next()){
                   ch6.add(rs3.getString("dType"));
               }
               k++;
           }
        }
        catch(Exception e){
            System.out.println(e);
        }   
        ch6.setBackground(Color.WHITE);
        ch6.setBounds(175,20,175,25);
        ch6.setForeground(Color.BLACK);
        ch6.setFont(new Font("Tahoma",Font.PLAIN,19));
        ch6.addItemListener(this);
        p2.add(ch6);
        
        b7 = new JButton("View");   
        b7.setBackground(new Color(0,102,102));
        b7.setBorder(BorderFactory.createLineBorder(Color.white));
        b7.setFont(new Font("Georgia",Font.BOLD,19));
        b7.setBounds(360,20,80,28);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        p2.add(b7);
        
        l7 = new JLabel("Level :");
        l7.setBounds(20,95,80,30);
        l7.setFont(new Font("Georgia",Font.BOLD,19));
        l7.setForeground(Color.BLACK);
        p2.add(l7);
        
        rb71 = new JRadioButton("Beginner");
        rb71.setBounds(100,135,150,25);
        rb71.setFont(new Font("Georgia",Font.BOLD,19));
        rb71.setBackground(Color.WHITE);
        rb71.setForeground(Color.BLACK);
        rb71.setEnabled(false);
        rb71.addItemListener(this);
        p2.add(rb71);
        
        rb72 = new JRadioButton("Intermediate");
        rb72.setBounds(270,135,180,25);
        rb72.setFont(new Font("Georgia",Font.BOLD,19));
        rb72.setBackground(Color.WHITE);
        rb72.setForeground(Color.BLACK);
        rb72.setEnabled(false);
        rb72.addItemListener(this);
        p2.add(rb72);
        
        rb73 = new JRadioButton("Advance");
        rb73.setBounds(100,170,150,25);
        rb73.setFont(new Font("Georgia",Font.BOLD,19));
        rb73.setBackground(Color.WHITE);
        rb73.setForeground(Color.BLACK);
        rb73.setEnabled(false);
        rb73.addItemListener(this);
        p2.add(rb73);
        
        rb74 = new JRadioButton("Masters");
        rb74.setBounds(270,170,180,25);
        rb74.setFont(new Font("Georgia",Font.BOLD,19));
        rb74.setBackground(Color.WHITE);
        rb74.setForeground(Color.BLACK);
        rb74.setEnabled(false);
        rb74.addItemListener(this);
        p2.add(rb74);
        
        l8 = new JLabel("Exam :");
        l8.setBounds(20,245,80,30);
        l8.setForeground(Color.black);
        l8.setFont(new Font("Georgia",Font.BOLD,19));
        p2.add(l8);
        
        cb8 = new JCheckBox("");
        cb8.setBounds(120,245,30,30);
        cb8.setFont(new Font("Georgia",Font.PLAIN,21));
        cb8.setForeground(Color.black);
        cb8.setBackground(Color.white);
        cb8.setEnabled(false);
        cb8.addItemListener(this);
        p2.add(cb8);
               
        l = new JLabel("------------------------------------------------------------------");
        l.setBounds(0,290,465,20);
        l.setForeground(Color.black);
        l.setFont(new Font("Georgia",Font.BOLD,19));
        p2.add(l);
        
        b5 = new JButton("Generate  Receipt");
        b5.setBounds(60,330,190,35);
        b5.setBackground(new Color(0, 40, 0));
        b5.setForeground(Color.WHITE);
        b5.setBorder(BorderFactory.createLineBorder(Color.white));
        b5.setFont(new Font("Georgia", Font.BOLD, 19));
        b5.addActionListener(this);
        b5.setEnabled(false);
        p2.add(b5);   
        
        b6 = new JButton("Print");
        b6.setBounds(320,330,80,35);
        b6.setBackground(new Color(0, 40, 0));
        b6.setForeground(Color.WHITE);
        b6.setBorder(BorderFactory.createLineBorder(Color.white));
        b6.setFont(new Font("Georgia", Font.BOLD, 19));
        b6.addActionListener(this);
        //b6.setEnabled(false);
        p2.add(b6);
        
        b1 = new JButton("Save");
        b1.setBackground(new Color(0, 40, 0));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createLineBorder(Color.white));
        b1.setFont(new Font("Georgia", Font.BOLD, 19));
        b1.setBounds(320, 390, 80, 35);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setEnabled(false);
        p2.add(b1);

        b2 = new JButton("Back");       //back to login page
        b2.setBackground(new Color(0,40,0));
        b2.setForeground(Color.white);
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
        b2.addActionListener(this);
        b2.setBounds(60, 390, 80, 35);
        p2.add(b2);
        
        
        //Receipt
        
        JLabel r = new JLabel("Receipt : ");
        r.setBounds(975, 43, 250, 30);
        r.setFont(new Font("TAHOMA", Font.BOLD, 30));
        r.setForeground(new Color(27,02,02));
        la.add(r);
        
        p3 = new JPanel();
        p3.setBounds(975, 100, 350, 550);
        p3.setBackground(Color.WHITE);
        p3.setLayout(null);
        la.add(p3);

        l10 = new JLabel("ID :");
        l10.setBounds(20,10,50,20);
        l10.setForeground(Color.black);
        l10.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l10);
        
        l100 = new JLabel("");
        l100.setBounds(70,10,50,20);
        l100.setForeground(Color.black);
        l100.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l100);               
        
        //photo
        lii = new JLabel();
        lii.setBounds(20, 50, 135, 120);
        lii.setLayout(null);
        p3.add(lii);
        
        l11 = new JLabel("Name :");
        l11.setBounds(20,195,80,20);
        l11.setForeground(Color.black);
        l11.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l11);
        
        l111 = new JLabel(" ");
        l111.setBounds(100,195,465,20);
        l111.setForeground(Color.black);
        l111.setFont(new Font("Georgia",Font.BOLD,17));
        p3.add(l111);
        
        l12 = new JLabel("Dance Course :");
        l12.setBounds(20,245,150,20);
        l12.setForeground(Color.black);
        l12.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l12);
        
        l122 = new JLabel(" ");
        l122.setBounds(180,245,465,25);
        l122.setForeground(Color.black);
        l122.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l122);
        
        l13 = new JLabel("Dance Level :");
        l13.setBounds(20,295,150,20);
        l13.setForeground(Color.black);
        l13.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l13);
        
        l133 = new JLabel("");
        l133.setBounds(180,295,465,25);
        l133.setForeground(Color.black);
        l133.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l133);
        
        l14 = new JLabel("Course Fee :");
        l14.setBounds(20,345,150,20);
        l14.setForeground(Color.black);
        l14.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l14);
        
        l144 = new JLabel("");
        l144.setBounds(180,345,465,25);
        l144.setForeground(Color.black);
        l144.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l144);
        
        //auto generate when cb8 is on item listener
        l16 = new JLabel(" ");
        l16.setBounds(20,395,150,20);
        l16.setForeground(Color.black);
        l16.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l16);
        
        l166 = new JLabel("");
        l166.setBounds(180,395,465,25);
        l166.setForeground(Color.black);
        l166.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l166);
        
        ll = new JLabel("------------------------------------------------------------------");
        ll.setBounds(0,425,465,20);
        ll.setForeground(Color.black);
        ll.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(ll);
        
        l17 = new JLabel("Total :");
        l17.setBounds(20,455,100,20);
        l17.setForeground(Color.black);
        l17.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l17);
        
        l177 = new JLabel("");
        l177.setBounds(120,455,465,20);
        l177.setForeground(Color.black);
        l177.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l177);
        
        l15 = new JLabel("Admission Date :");
        l15.setBounds(20,505,170,20);
        l15.setForeground(Color.black);
        l15.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l15);
        
        l155 = new JLabel("");
        l155.setBounds(200,505,465,20);
        l155.setForeground(Color.black);
        l155.setFont(new Font("Georgia",Font.BOLD,19));
        p3.add(l155);
        
        JPanel sdate = new JPanel();
        sdate.setLayout(new BorderLayout());
        //sdate.setBounds(220,320,180,30);
        //p2.add(sdate);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.white);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        java.util.Date d = new java.util.Date();
        jdc.setMaxSelectableDate(d);
        jdc.setMinSelectableDate(d);
        jdc.setDate(d);
//        sdate.add(jdc);
        setVisible(true);
    }
    
    
    public boolean islevelSelected(){
        if(!ch6.getSelectedItem().equals("None") && (!rb71.isSelected() && !rb72.isSelected() && !rb73.isSelected() && !rb74.isSelected())){
            
            UIManager ui = new UIManager();
            ui.put("OptionPane.background",Color.WHITE);
            ui.put("Panel.background",Color.WHITE);
            //ui.put("OptionPane.minimunSize",new Dimension(300,200));
            JOptionPane op = new JOptionPane();
            JLabel msg = new JLabel("Please select one level ");
            msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
            op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        final int bufLen = 1024;
        byte[] buf = new byte[bufLen];
        int readLen;
        IOException exception = null;

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while ((readLen = inputStream.read(buf, 0, bufLen)) != -1) {
                outputStream.write(buf, 0, readLen);
            }

            return outputStream.toByteArray();
        } catch (IOException e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) {
                inputStream.close();
            } else try {
                inputStream.close();
            } catch (IOException e) {
                exception.addSuppressed(e);
            }
        }
    }

     public static boolean isValidMobileNo(String str){
        Pattern ptr = Pattern.compile("(0/91)?[6-9][0-9]{9}");
        Matcher match = ptr.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    
     public static boolean isValidEmail(String str){
        Pattern ptr = Pattern.compile("^[a-zA-Z0-9+_.-]+@+gmail.com+$");
        Matcher match = ptr.matcher(str);
        return (match.find() && match.group().equals(str));
    }
     
     public static boolean isValidPincode(String str){
        //must start with 1-9 , next 2 digits 0-9 ,then one space and t=next 3 digits 0-9
        Pattern ptr = Pattern.compile("^[1-9]{1}[0-9]{2}{0,1}[0-9]{3}$");
        Matcher match = ptr.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
        changed();
        
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
        changed();
        
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
        changed();
        
    }

    public void changed(){
        if(!tf1.getText().equals("") && !tf2.getText().equals("") && !tf4.getText().equals("") && !tf5.getText().equals("") && !tf5.getText().equals("") && !ch6.getSelectedItem().equals("None")){
            b5.setEnabled(true);
        }
        else{
            b5.setEnabled(false);
        }
    }
    
    

    public void resetReceipt(JLabel l100, JLabel lii, JLabel l111, JLabel l122, JLabel l133, JLabel l144, JLabel l155, JLabel l16, JLabel l166, JLabel l177) {
        l100.setText(""); //Id
        lii.setIcon(null);
        l111.setText("");
        l122.setText("");
        l133.setText("");
        l144.setText("");
        l155.setText(""); //date
        l16.setText("");
        l166.setText("");
        l177.setText("");
        //dp = null;
        b5.setEnabled(false);
    }
    
    
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        Conn c = new Conn();
        
        if(ie.getSource()==ch6){
            resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
            rb71.setSelected(false);
            rb72.setSelected(false);
            rb73.setSelected(false);
            rb74.setSelected(false);
            cb8.setSelected(false);
            rb71.setEnabled(false);   rb72.setEnabled(false);   rb73.setEnabled(false);   rb74.setEnabled(false);   cb8.setEnabled(false);
            String sql6 = "select Beginner,Intermediate,Advance,Masters,exam from dcinfo where dType='"+ch6.getSelectedItem()+"'";
            
            try{
                ResultSet rs6 = c.s.executeQuery(sql6);
                if(rs6.next()){
                    //System.out.println(rs6.getString("rStandard"));
                    if(rs6.getString("Beginner").equals("Available")){
                        rb71.setEnabled(true);
                    }
                    else
                        rb71.setEnabled(false);
                    if(rs6.getString("Intermediate").equals("Available")){
                        rb72.setEnabled(true);
                    }
                    else
                        rb72.setEnabled(false);
                    if(rs6.getString("Advance").equals("Available")){
                        rb73.setEnabled(true);
                    }
                    else
                        rb73.setEnabled(false);
                    if(rs6.getString("Masters").equals("Available")){
                        rb74.setEnabled(true);
                    }
                    else
                        rb74.setEnabled(false);
                    if(rs6.getString("Exam").equals("Available")){
                        cb8.setEnabled(true);
                    }
                    else
                        cb8.setEnabled(false);
                }
                
            }catch(SQLException | NumberFormatException | HeadlessException iex){
                System.out.println(iex);
            }
            
            changed(); 
        }
        
        if(ie.getSource()==rb71){
            resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
            if(rb71.isSelected()){
                rb72.setSelected(false);
                rb73.setSelected(false);
                rb74.setSelected(false);
            }
            cb8.setSelected(false);
            changed(); 
        }
        if(ie.getSource()==rb72){
            resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
            if(rb72.isSelected()){
                rb71.setSelected(false);
                rb73.setSelected(false);
                rb74.setSelected(false);
            }
            cb8.setSelected(false);
            changed(); 
        }
        if(ie.getSource()==rb73){
            resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
            if(rb73.isSelected()){
                rb72.setSelected(false);
                rb71.setSelected(false);
                rb74.setSelected(false);
            }
            cb8.setSelected(false);
            changed(); 
        }
        if(ie.getSource()==rb74){
            resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
            if(rb74.isSelected()){
                rb72.setSelected(false);
                rb73.setSelected(false);
                rb71.setSelected(false);
            }
            cb8.setSelected(false);
            changed(); 
        }
        
        if(ie.getSource()==cb8){
            resetReceipt(l100,lii,l111,l122,l133,l144,l155,l16,l166,l177);
            
            changed();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = "";
        
        //get receipt
        if(e.getSource()==b5){
                System.out.println(filePath);
                String loc ="";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(jdc.getDate());
                System.out.println(date);
            if(!isValidPincode(tf3.getText())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Invalid Pincode");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                b5.setEnabled(false);
            }
            if(!isValidMobileNo(tf4.getText())){
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Invalid Mobile Number");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                b5.setEnabled(false);
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
                b5.setEnabled(false);
            }
            if(isValidPincode(tf3.getText()) && isValidMobileNo(tf4.getText()) && isValidEmail(tf5.getText()) && islevelSelected()){
               //for ID no.
                int ID=0;
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select count(sName) from studinfo");
                    if(rs.next()){
                       
                       ID = Integer.parseInt(rs.getString("count(sName)")) + 1;
                       System.out.println(ID);
                    }
                    l100.setText(Integer.toString(ID));
                }
                catch(SQLException | NumberFormatException | HeadlessException ae){
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
                //tf8.setText(Integer.toString(ID)); id on receipt
                
                try{
                    Conn c =new Conn();
                    String sql2 = "select * from filepath";
                    //String sql3 = "delete from filepath";
                    ResultSet rs = c.s.executeQuery(sql2);       //whole row
                    //c.s.executeQuery() returns ResultSet class object so must be stored in same class object
                    while(rs.next()){   //column to column jump
                        loc = rs.getString("loc");
                        System.out.println(loc);
                    }
                    System.out.println(loc);
                          
                    if(!loc.equals("")){
                        FileInputStream fis = null;
                            try{
                                Conn ci = new Conn();
                                String s2 = "select * from filepath";
                                ResultSet rsi = ci.s.executeQuery(s2);
                                String p = "";
                                if (rsi.next()) {
                                    p = rsi.getString("loc");
                                }
                                File file2 = new File(p);
                                    //fis is reference variable
                                    //import java.io.*;
                                fis = new FileInputStream(file2);
                                byte[] b = readAllBytes(fis);
                                ImageIcon i1 = new ImageIcon(b);
                                Image i2 = i1.getImage().getScaledInstance(90, 120, Image.SCALE_DEFAULT);
                                ImageIcon i3 = new ImageIcon(i2);
                                lii.setIcon(i3);
                    
                            } catch (IOException |SQLException | NumberFormatException | HeadlessException ex) {
                            }
                            
                            l155.setText(date);
                            l111.setText(tf1.getText());
                            l122.setText(ch6.getSelectedItem());
                            float total = 0;
                            if(rb71.isSelected()){
                                l133.setText(rb71.getText());
                                String sql3 = "select fBeginner from dcinfo where dType='"+ch6.getSelectedItem()+"'";
                                try{
                                    ResultSet rs3 = c.s.executeQuery(sql3);
                                    if(rs3.next()){
                                        total = rs3.getFloat("fBeginner");
                                        l144.setText(rs3.getString("fBeginner"));
                                        l177.setText(Float.toString(total));
                                    }
                                }
                                catch(SQLException | NumberFormatException | HeadlessException r1e){
                                    System.out.println(r1e);
                                }
                            }
                            
                            else if(rb72.isSelected()){
                                l133.setText(rb72.getText());
                                String sql3 = "select fIntermediate from dcinfo where dType='"+ch6.getSelectedItem()+"'";
                                try{
                                    ResultSet rs3 = c.s.executeQuery(sql3);
                                    if(rs3.next()){
                                        total = rs3.getFloat("fIntermediate");
                                        l144.setText(rs3.getString("fIntermediate"));
                                        l177.setText(Float.toString(total));
                                    }
                                }
                                catch(SQLException | NumberFormatException | HeadlessException r1e){
                                    System.out.println(r1e);
                                }
                            }
                            else if(rb73.isSelected()){
                                l133.setText(rb73.getText());
                                String sql3 = "select fAdvance from dcinfo where dType='"+ch6.getSelectedItem()+"'";
                                try{
                                    ResultSet rs3 = c.s.executeQuery(sql3);
                                    if(rs3.next()){
                                        total = rs3.getFloat("fAdvance");
                                        l144.setText(rs3.getString("fAdvance"));
                                        l177.setText(Float.toString(total));
                                    }
                                }
                                catch(SQLException | NumberFormatException | HeadlessException r1e){
                                    System.out.println(r1e);
                                }
                            }
                            else if(rb74.isSelected()){
                                l133.setText(rb74.getText());
                                String sql3 = "select fMasters from dcinfo where dType='"+ch6.getSelectedItem()+"'";
                                try{
                                    ResultSet rs3 = c.s.executeQuery(sql3);
                                    if(rs3.next()){
                                        total = rs3.getFloat("fMasters");
                                        l144.setText(rs3.getString("fMasters"));
                                        l177.setText(Float.toString(total));
                                    }
                                }
                                catch(SQLException r1e){
                                    System.out.println(r1e);
                                }
                            }
                            
                            if(cb8.isSelected()){
                                l16.setText("Exam fee :");
                                String sql3 = "select FExam from dcinfo where dType='"+ch6.getSelectedItem()+"'";

                                try{
                                    ResultSet rs3 = c.s.executeQuery(sql3);
                                    if(rs3.next()){
                                        total = total +  rs3.getFloat("fExam"); //

                                        l166.setText(rs3.getString("fExam"));
                                        l177.setText(Float.toString(total));
                                    }
                                }
                                catch(SQLException | NumberFormatException | HeadlessException cbe){
                                    System.out.println(cbe);
                                }
                            }
                            b1.setEnabled(true); //save
                            
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
        }
        //print
        if(e.getSource()==b6){ 
            
            Conn c = new Conn();
  
            int id=0;
            try{
                ResultSet rs = c.s.executeQuery("select count(sname) from studinfo");
                if(rs.next()){
                    id = Integer.parseInt(rs.getString("count(sName)"));
                    //System.out.println(id);
                }
                JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\Receipt.jrxml");
                String sql = "select * from studinfo where Sid='"+id+"'";
                JRDesignQuery updatequery = new JRDesignQuery();
                updatequery.setText(sql);
                jd.setQuery(updatequery);
                JasperReport jreport = JasperCompileManager.compileReport(jd);
                JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                JasperViewer.viewReport(jprint);
            }
            catch(SQLException | NumberFormatException | HeadlessException ae){
                System.out.println(ae);
            } catch (JRException ex) {
                Logger.getLogger(StudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            setVisible(false);
        }
        
        //save
        if(e.getSource()==b1){
            String loc ="";
            String sExam = "Not Applying";
            UIManager uii = new UIManager();
            uii.put("OptionPane.background",Color.WHITE);
            uii.put("Panel.background",Color.WHITE);
            uii.put("OptionPane.minimunSize",new Dimension(300,200));
            JOptionPane opp = new JOptionPane();
            JLabel msgg = new JLabel("Are you sure");
            msgg.setFont(new Font("SAN_SERIF",Font.BOLD,22));
            int a = opp.showConfirmDialog(this,msgg,"Please Confirm",0);
            
            if(a==opp.YES_OPTION){
                
                try{
                    Conn c =new Conn();
                    String sql2 = "select * from filepath";
                    String sql3 = "delete from filepath";
                    ResultSet rs = c.s.executeQuery(sql2);       //whole row
                    //c.s.executeQuery() returns ResultSet class object so must be stored in same class object
                    while(rs.next()){   //column to column jump
                        loc = rs.getString("loc");
                        System.out.println(loc);
                    }
                    System.out.println(loc);


                    if(!loc.equals("")){
                        if(cb8.isSelected()){
                            sExam = "Applying"; 
                            String query = "insert into studinfo (sId,sName,sAddress,sPincode,sMob,sEml,sjDate, sdCourse, sdLevel, sdExam, sfdCourse, sfExam, sTotal, sImgPath) values('"+Integer.parseInt(l100.getText())+"','"+tf1.getText()+"','"+tf2.getText()+"','"+Integer.parseInt(tf3.getText())+"','"+Long.parseLong(tf4.getText())+"','"+tf5.getText()+"','"+l155.getText()+"','"+l122.getText()+"','"+l133.getText()+"','"+sExam+"','"+Double.parseDouble(l144.getText())+"','"+Double.parseDouble(l166.getText())+"','"+Double.parseDouble(l177.getText())+"','"+loc+"')";
                            c.s.executeUpdate(query);
                            c.s.executeUpdate("update bCapacity set sRegistered=sRegistered+1, sExam = sExam+1 where dType='"+ch6.getSelectedItem()+"'");
                        }
                        else{
                            String query = "insert into studinfo (sId,sName,sAddress,sPincode,sMob,sEml,sjDate, sdCourse, sdLevel, sdExam, sfdCourse, sfExam, sTotal, sImgPath) values('"+Integer.parseInt(l100.getText())+"','"+tf1.getText()+"','"+tf2.getText()+"','"+Integer.parseInt(tf3.getText())+"','"+Long.parseLong(tf4.getText())+"','"+tf5.getText()+"','"+l155.getText()+"','"+l122.getText()+"','"+l133.getText()+"','"+sExam+"','"+Double.parseDouble(l144.getText())+"','"+Double.parseDouble("0")+"','"+Double.parseDouble(l177.getText())+"','"+loc+"')";
                            c.s.executeUpdate(query);
                            c.s.executeUpdate("update bCapacity set sRegistered=sRegistered+1 where dType='"+ch6.getSelectedItem()+"'");
                        }
                        c.s.execute(sql3); //use in save button
                        //booking capacity
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Student added successfully");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);

                        c.s.executeUpdate("update bCapacity set sRegistered=sRegistered+1 where dType='"+ch6.getSelectedItem()+"'");
                        b6.setEnabled(true);
                        
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
                JLabel msg1 = new JLabel("Registration Canceled");
                msg1.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op1.showMessageDialog(this,msg1,"",JOptionPane.ERROR_MESSAGE);
            }
              
        }
        
        if(e.getSource()==b2){
            setVisible(false);
        }
        if (e.getSource() == b3) {
            JFileChooser fc = new JFileChooser("D:\\DAMS\\src\\dams\\students");       //path given
            if (fc.showOpenDialog(this) == fc.APPROVE_OPTION) {     //open files menu, if selected then
                File f = fc.getSelectedFile();      //selected file
                filePath = f.getPath();      //path in string type
                System.out.println(filePath);
                int i = 0;

                StringBuilder s = new StringBuilder(filePath);
                while (i < s.length()) {
                    if (s.charAt(i) == '\\') {

                        s.setCharAt(i, '/');
                        i += 2;
                    }
                    i++;
                }
                filePath = s.toString();

                String sql = "insert into filepath values('" + filePath + "')";
                FileInputStream fis = null;
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(sql);
                    setVisible(false);
                    setVisible(true);
                    String s2 = "select * from filepath";
                    ResultSet rs = c.s.executeQuery(s2);
                    String p = "";
                    if (rs.next()) {
                        p = rs.getString("loc");
                    }
                    File file2 = new File(p);
                    //fis is reference variable
                    //import java.io.*;
                    fis = new FileInputStream(file2);
                    byte[] b = readAllBytes(fis);
                    ImageIcon i1 = new ImageIcon(b);
                    Image i2 = i1.getImage().getScaledInstance(90, 120, Image.SCALE_DEFAULT);
                    ImageIcon i3 = new ImageIcon(i2);
                    li.setIcon(i3);
                    
                } catch (IOException | SQLException | NumberFormatException | HeadlessException ex) {
                }
            }
        }

        if (e.getSource() == b4) {
            li.setIcon(null);
            lii.setIcon(null);
            Conn c = new Conn();
            String sql4 = "delete from filepath";
            try {
                c.s.execute(sql4);
            } catch (SQLException | NumberFormatException | HeadlessException ex) {
                System.out.println(ex);
            }

        }
        
        if(e.getSource()==b7){
            new ViewDanceCourses(username).setVisible(true);
        }
    }
  
}
