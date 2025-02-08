package dams;
import java.lang.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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

public class AddTrainer extends JFrame implements DocumentListener, ActionListener, KeyListener, MouseListener{
    JPanel p,p1,p2;
    JLabel l1,l11,l2,l22,l3,l33,l4,l5,l6,l7,l8,l9,l99,l10, tf3;
    JTextField tf1, tf2, tf4, tf5, tf6, tf8, tf9,tf10;
    JTextArea ta6, ta7;
    String username;
    JButton b1,b2,b3,b4;
    com.toedter.calendar.JDateChooser jdc;
    public static void main(String[] args){
        new AddTrainer("");
    }
    
    AddTrainer(String username){
        this.username=username;
        setBounds(80,50,1370,760);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("Add Trainer");
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
        p1.setBounds(15,15,1340,730);
        p1.setOpaque(false);
        //p1.setBackground(new Color(0,0,0,25));
        la.add(p1);
        
        b1 = new JButton("Add Trainer");   
        b1.setBackground(new Color(0,102,102));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createLineBorder(Color.white));
        b1.setFont(new Font("Georgia",Font.BOLD,30));
        b1.setBounds(900,620,300,45);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        b1.setEnabled(false);
        p1.add(b1);
        
        b2 = new JButton("Back");       //back to login page
        b2.setBackground(new Color(0,102,102));
        b2.setForeground(Color.white);
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.setFont(new Font("SAN_SERIF",Font.BOLD,22));
        b2.addActionListener(this);
        b2.setBounds(20,15,120,35);
        p1.add(b2);
        
        l3 = new JLabel("ID :");
        l3.setBounds(140,80,80,30);
        l3.setFont(new Font("Georgia",Font.BOLD,25));
        l3.setForeground(Color.BLACK);
        p1.add(l3);
        
        tf3 = new JLabel("");
        tf3.setBounds(205,78,153,30);
        tf3.setFont(new Font("Georgia",Font.BOLD,25));
        tf3.setForeground(new Color(153,0,0));

        int ID=0;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select count(tfName) from trainerinfo");
            if(rs.next()){
               ID = Integer.parseInt(rs.getString("count(tfName)")) + 1;
            }

        }
        catch(Exception ae){
            System.out.println(ae);
        }
        tf3.setText(Integer.toString(ID)); 
        p1.add(tf3);
        
               
        l1 = new JLabel("First  Name :");
        l1.setBounds(140,150,200,30);
        l1.setFont(new Font("Georgia",Font.BOLD,25));
        l1.setForeground(Color.BLACK);
        p1.add(l1);
        
        tf1 = new JTextField();
        tf1.setBounds(330,150,200,33);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,25));
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
        l2.setBounds(140,220,200,30);
        l2.setFont(new Font("Georgia",Font.BOLD,25));
        l2.setForeground(Color.BLACK);
        p1.add(l2);
        
        tf2 = new JTextField();
        tf2.setBounds(330,220,200,33);
        tf2.setFont(new Font("Tahoma",Font.PLAIN,25));
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
        l4.setBounds(140,290,200,30);
        l4.setFont(new Font("Georgia",Font.BOLD,25));
        l4.setForeground(Color.BLACK);
        p1.add(l4);
       
         
        tf4 = new JTextField();
        tf4.setBounds(330,290,250,33);
        tf4.setFont(new Font("Tahoma",Font.PLAIN,25));
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
        l5.setBounds(140,360,160,30);
        l5.setFont(new Font("Georgia",Font.BOLD,25));
        l5.setForeground(Color.BLACK);
        p1.add(l5);
        
        tf5 = new JTextField();
        tf5.setBounds(330,360,310,33);
        tf5.setFont(new Font("Tahoma",Font.PLAIN,25));
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
        
        JLabel l6 = new JLabel("Address :");
        l6.setBounds(140,450,150,30);
        l6.setFont(new Font("Georgia",Font.BOLD,25));
        l6.setForeground(Color.BLACK);
        p1.add(l6);
        
        ta6 = new JTextArea();
        //ta6.setBounds(300,430,350,80);
        ta6.setFont(new Font("Tahoma",Font.PLAIN,25));
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
        pane.setBounds(330,450,310,100);
        p1.add(pane);
        
        JLabel l8 = new JLabel("Experience :");
        l8.setBounds(140,600,200,30);
        l8.setFont(new Font("Georgia",Font.BOLD,25));
        l8.setForeground(Color.BLACK);
        p1.add(l8);
        JLabel l88 = new JLabel("yr/yrs");
        l88.setBounds(450,600,150,30);
        l88.setFont(new Font("Georgia",Font.BOLD,19));
        l88.setForeground(Color.BLACK);
        p1.add(l88);
        
        tf8 = new JTextField();
        tf8.setBounds(330,600,100,33);
        tf8.setFont(new Font("Tahoma",Font.PLAIN,25));
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
        p2.setBounds(800,80,370,180);
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
        
        JLabel l10 = new JLabel("Joining date:");
        l10.setBounds(800,305,220,30);
        l10.setForeground(Color.black);
        l10.setFont(new Font("Georgia",Font.BOLD,25));
        p1.add(l10);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(1000,305,180,30);
        p1.add(p);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.getComponent(1).addMouseListener(this);
        jdc.getComponent(0).addMouseListener(this);
        jdc.getComponent(0).setForeground(Color.BLACK);
        ((JTextField)jdc.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 24));
        java.util.Date d = new java.util.Date();
        jdc.setMinSelectableDate(d);        
        p.add(jdc);
                
        JLabel l9 = new JLabel("Salary :");
        l9.setBounds(800,380,150,30);
        l9.setFont(new Font("Georgia",Font.BOLD,25));
        l9.setForeground(Color.BLACK);
        p1.add(l9);
       
        tf9 = new JTextField();
        tf9.setBounds(940,380,150,33);
        tf9.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf9.setForeground(Color.BLACK);
        tf9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tf9.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)|| Character.compare(ch, '.')==0){
                  
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
                
        JLabel l7 = new JLabel("Qualification :");
        l7.setBounds(800,450,200,30);
        l7.setFont(new Font("Georgia",Font.BOLD,25));
        l7.setForeground(Color.BLACK);
        p1.add(l7);
        
        ta7 = new JTextArea();
//        ta7.setBounds(170,360,300,80);
        ta7.setFont(new Font("Tahoma",Font.PLAIN,25));
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
        pane1.setBounds(990,450,270,100);
        p1.add(pane1);
        
        setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getSource()==jdc.getComponent(1)){
            jdc.getComponent(1).setEnabled(false);
            JOptionPane.showMessageDialog(this, "Please select the date");
        }
        if(e.getSource()==jdc.getComponent(0)){
            System.out.println(jdc.getDate());
            jdc.getComponent(1).setEnabled(true);
            if(tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || ta6.getText().equals("") || ta7.getText().equals("") ||  tf8.getText().equals("") || tf9.getText().equals("") || ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                b1.setEnabled(false);
            }
            else{
                b1.setEnabled(true);
            }
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
    
    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        final int bufLen = 1024;
        byte[] buf = new byte[bufLen];
        int readLen;
        IOException exception = null;

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
                outputStream.write(buf, 0, readLen);

            return outputStream.toByteArray();
        } catch (IOException e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) inputStream.close();
            else try {
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
        }
        else{
            b1.setEnabled(true);
        }
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String filePath="";
    
            if(e.getSource()==b3){
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
                     ImageIcon i1 = new ImageIcon(b);
                     Image i2 = i1.getImage().getScaledInstance(100,140,Image.SCALE_DEFAULT);
                     ImageIcon i3 = new ImageIcon(i2);
                     l33.setIcon(i3);
                     
                 }catch(IOException | SQLException | NumberFormatException | HeadlessException ex){} 
               }
            }
            
        if(e.getSource()==b4){
            l33.setIcon(null);
            Conn c = new Conn();
            String sql4 = "delete from filepath";
            try{
                c.s.execute(sql4);
            }catch(Exception ex){
                System.out.println(ex);
            }
            
        }
        if(e.getSource()==b1){
                
                System.out.println(filePath);
                String loc ="";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(jdc.getDate());
                //System.out.println(date);
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
                    
                            String count = "select count(tfName) from trainerinfo";
                            int tCount=0;
                            try{
                                rs = c.s.executeQuery(count);
                                while(rs.next()){
                                tCount=Integer.parseInt(rs.getString("count(tfName)"));
                                }
                                //resetting auto increment
                                String reset ="alter table trainerinfo auto_increment="+(tCount+1)+"";
                                c.s.execute(reset);

                            }catch(SQLException | NumberFormatException ex){
                                System.out.println(ex);
                            }
                            if(!loc.equals("")){
                                String query = "insert into trainerinfo (tId,tfName,tlName,tMob,tEml,tAddress, tQualification, tExperience, tSalary, tJdate, tImgPath) values('"+Integer.parseInt(tf3.getText())+"','"+tf1.getText()+"','"+tf2.getText()+"','"+Long.parseLong(tf4.getText())+"','"+tf5.getText()+"','"+ta6.getText()+"','"+ta7.getText()+"','"+Integer.parseInt(tf8.getText())+"','"+Double.parseDouble(tf9.getText())+"','"+date+"','"+loc+"')";
                                c.s.executeUpdate(query);
                                c.s.execute(sql3);
                                //booking capacity
                                UIManager ui = new UIManager();
                                ui.put("OptionPane.background",Color.WHITE);
                                ui.put("Panel.background",Color.WHITE);
                                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                                JOptionPane op = new JOptionPane();
                                JLabel msg = new JLabel("Trainer added successfully");
                                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                                op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);
                                tf1.setText("");
                                tf2.setText("");
                                int ID=0;
                                try{
                                    ResultSet rsi = c.s.executeQuery("select count(tfName) from trainerinfo");
                                    if(rsi.next()){
                                       //System.out.println(rs.getString("count(tfName)"));
                                       ID = Integer.parseInt(rsi.getString("count(tfName)")) + 1;
                                       //System.out.println(ID);
                                    }

                                }
                                catch(SQLException | NumberFormatException | HeadlessException ae){
                                    System.out.println(ae);
                                }
                                tf3.setText(Integer.toString(ID)); 
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
                  
            }
        }
        if(e.getSource()==b2){
            setVisible(false);
        }
        
            
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
