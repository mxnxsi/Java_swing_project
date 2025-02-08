package dams;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddDanceCourse extends JFrame implements ActionListener, ItemListener, DocumentListener, ListSelectionListener{
    
    String username;
    Choice c3,c5;
    JPanel p,p1;
    JButton b1,b2,b7;
    JCheckBox cb1,cb2,cb3,cb4,cb9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField tf1, tf2,tf4, tf6, tf81, tf82, tf83, tf84,tf10;
    JList jl4;
    public static void main(String[] args) {
        new AddDanceCourse("");
    }
    
    AddDanceCourse(String username) {
        this.username = username;
        setBounds(80,50,1370,760);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("Add new Dance Course");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setUndecorated(true);
        
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
        p1.setBackground(new Color(0,0,0,25));
        la.add(p1);
        
        b1 = new JButton("Add Dance Course");   
        b1.setFont(new Font("Georgia",Font.BOLD,30));
        b1.setBounds(800,600,300,45);
        b1.setBackground(Color.black);
        b1.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        b1.setForeground(new Color(0,255,255));
        b1.addActionListener(this);
        b1.setEnabled(false);
        p1.add(b1);
        
        b2 = new JButton("Back");   
        b2.setBackground(new Color(0,102,102));
        b2.setBorder(BorderFactory.createLineBorder(Color.white));
        b2.setFont(new Font("Georgia",Font.BOLD,30));
        b2.setBounds(10,10,100,35);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        p1.add(b2);
                
        l1 = new JLabel("Dance Type :");
        l1.setBounds(120,80,180,30);
        l1.setFont(new Font("Georgia",Font.BOLD,25));
        l1.setForeground(Color.BLACK);
        p1.add(l1);
        
        tf1 = new JTextField();
        tf1.setBounds(290,80,250,33);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf1.setForeground(Color.BLACK);
        tf1.setBorder(BorderFactory.createEmptyBorder());
        tf1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetter(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT && iscbSelected() ){
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
        
        l2 = new JLabel("Genre :");
        l2.setBounds(120,170,150,30);
        l2.setFont(new Font("Georgia",Font.BOLD,25));
        l2.setForeground(Color.BLACK);
        p1.add(l2);
        
        tf2 = new JTextField();
        tf2.setBounds(290,170,250,33);
        tf2.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf2.setForeground(Color.BLACK);
        tf2.setBorder(BorderFactory.createEmptyBorder());
        tf2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isLetter(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT && iscbSelected() ){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf2.getText().length()==1){
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
        
        l3 = new JLabel("Trainer :");
        l3.setBounds(120,260,130,30);
        l3.setFont(new Font("Georgia",Font.BOLD,25));
        l3.setForeground(Color.BLACK);
        p1.add(l3);
        
        JLabel l33 = new JLabel("Please add the Trainer");
        l33.setBounds(270,260,250,33);
        l33.setForeground(Color.RED);
        l33.setFont(new Font("Rockwell",Font.BOLD,20));
        
        c3 = new Choice();
        c3.add("none");
        String count = "select count(tfName) from trainerinfo";
        String sql = "select tfName from trainerinfo";
        int tCount=0;
        Conn  c = new Conn();
        try{
           ResultSet rss = c.s.executeQuery(count);
           while(rss.next()){
               tCount=Integer.parseInt(rss.getString("count(tfName)"));
           }
           ResultSet rs2 = c.s.executeQuery(sql);
           if(tCount>0){
               while(rs2.next()){
                   c3.add(rs2.getString("tfName"));
               }
           }
           else{
               p1.add(l33);
               b1.setEnabled(false);
           }
        }
        catch(Exception e){
            System.out.println(e);
        } 
        c3.setBackground(Color.WHITE);
        c3.setBounds(250,260,200,33);
        c3.setForeground(Color.BLACK);
        c3.addItemListener(this);
        c3.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(c3);
                
        b7 = new JButton("View");   
        b7.setBackground(new Color(0,102,102));
        b7.setBorder(BorderFactory.createLineBorder(Color.white));
        b7.setFont(new Font("Georgia",Font.PLAIN,25));
        b7.setBounds(460,260,80,35);
        b7.setForeground(Color.black);
        b7.addActionListener(this);
        p1.add(b7);
        
        l4 = new JLabel("Weekdays :");
        l4.setBounds(120,350,150,30);
        l4.setFont(new Font("Georgia",Font.BOLD,25));
        l4.setForeground(Color.BLACK);
        p1.add(l4);
        
        tf4 = new JTextField();
        //tf4.setBounds(190,350,250,33);
        tf4.setFont(new Font("Tahoma",Font.PLAIN,25));
        //p1.add(tf4);
        
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        jl4 = new JList(days);
        jl4.setFont(new Font("Tahoma",Font.PLAIN,19));
        jl4.setForeground(Color.BLACK);
        jl4.setBorder(BorderFactory.createEmptyBorder());
        jl4.setVisibleRowCount(4);
        jl4.setFixedCellHeight(20);
        jl4.setFixedCellWidth(140);
        jl4.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jl4.addListSelectionListener(this);
        JScrollPane sp4;
        sp4 = new JScrollPane(jl4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp4.setBounds(290,355,200,85);
        p1.add(sp4);
        
        l5 = new JLabel("Batch Time :");
        l5.setBounds(120,500,180,30);
        l5.setFont(new Font("Georgia",Font.BOLD,25));
        l5.setForeground(Color.BLACK);
        p1.add(l5);
        
        c5 = new Choice();
        c5.add("None");
        c5.add("Morning");
        c5.add("Evening");
        c5.setBounds(300,500,200,33);
        c5.setForeground(Color.BLACK);
        c5.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(c5);
        
        l6 = new JLabel("Batch Capacity :");
        l6.setBounds(120,595,220,30);
        l6.setFont(new Font("Georgia",Font.BOLD,25));
        l6.setForeground(Color.BLACK);
        p1.add(l6);
         
        tf6 = new JTextField();
        tf6.setBounds(330,595,180,33);
        tf6.setBorder(BorderFactory.createEmptyBorder());
        tf6.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf6.getDocument().addDocumentListener(this);
        tf6.setForeground(Color.black);
        tf6.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || e.getKeyCode()==KeyEvent.VK_SHIFT && iscbSelected()){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf6.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    JOptionPane.showMessageDialog(p1, "Invalid input");
                    tf6.setText("");
                }
            }
        });
        tf6.getDocument().addDocumentListener(this);
        p1.add(tf6);
        
        l7 = new JLabel("Levels :");
        l7.setBounds(760,80,180,40);
        l7.setFont(new Font("Georgia",Font.BOLD,35));
        l7.setForeground(new Color(102,51,50));
        p1.add(l7);
        
        cb1 = new JCheckBox("Beginner");
        cb1.setBounds(740,165,200,33);
        cb1.setFont(new Font("Georgia",Font.PLAIN,25));
        cb1.setForeground(Color.black);
        cb1.isSelected();        
        cb1.addItemListener(this);
        p1.add(cb1);
        
        cb2 = new JCheckBox("Intermediate");
        cb2.setBounds(740,230,200,33);
        cb2.setFont(new Font("Georgia",Font.PLAIN,25));
        cb2.setForeground(Color.black);
        cb2.setSelected(false);
        cb2.setEnabled(false);
        cb2.addItemListener(this);
        p1.add(cb2);
        
        cb3 = new JCheckBox("Advanced");
        cb3.setBounds(740,295,200,33);
        cb3.setFont(new Font("Georgia",Font.PLAIN,25));
        cb3.setForeground(Color.black);
        cb3.setSelected(false);
        cb3.setEnabled(false);
        cb3.addItemListener(this);
        p1.add(cb3);
        
        cb4 = new JCheckBox("Masters");
        cb4.setBounds(740,360,200,33);
        cb4.setFont(new Font("Georgia",Font.PLAIN,25));
        cb4.setForeground(Color.black);
        cb4.setSelected(false);
        cb4.setEnabled(false);
        cb4.addItemListener(this);
        p1.add(cb4);
        
        l8 = new JLabel("Fees :");
        l8.setBounds(1025,80,180,40);
        l8.setFont(new Font("Georgia",Font.BOLD,35));
        l8.setForeground(new Color(102,51,50));
        p1.add(l8);
        
        
        tf81 = new JTextField("0");
        tf81.setBounds(1000,165,150,33);
        tf81.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf81.setForeground(Color.BLACK);
        tf81.setBorder(BorderFactory.createEmptyBorder());
        tf81.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf81.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    JOptionPane.showMessageDialog(p1, "Invalid input");
                    tf81.setText("");
                }
            }
        });
        tf81.setEnabled(false);
        tf81.getDocument().addDocumentListener(this);
        p1.add(tf81);
        
        tf82 = new JTextField("0");
        tf82.setBounds(1000,230,150,33);
        tf82.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf82.setForeground(Color.BLACK);
        tf82.setBorder(BorderFactory.createEmptyBorder());
        tf82.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf82.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    JOptionPane.showMessageDialog(p1, "Invalid input");
                    tf82.setText("");
                }
            }
        });
        tf82.setEnabled(false);
        tf82.getDocument().addDocumentListener(this);
        p1.add(tf82);
        
        tf83 = new JTextField("0");
        tf83.setBounds(1000,295,150,33);
        tf83.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf83.setForeground(Color.BLACK);
        tf83.setBorder(BorderFactory.createEmptyBorder());
        tf83.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf83.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    JOptionPane.showMessageDialog(p1, "Invalid input");
                    tf83.setText("");
                }
            }
        });
        tf83.setEnabled(false);
        tf83.getDocument().addDocumentListener(this);
        p1.add(tf83);
        
        tf84 = new JTextField("0");
        tf84.setBounds(1000,360,150,33);
        tf84.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf84.setForeground(Color.BLACK);
        tf84.setBorder(BorderFactory.createEmptyBorder());
        tf84.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf84.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    JOptionPane.showMessageDialog(p1, "Invalid input");
                    tf84.setText("");
                }
            }
        });
        tf84.setEnabled(false);
        tf84.getDocument().addDocumentListener(this);
        p1.add(tf84);
        
        l9 = new JLabel("Exam :");
        l9.setBounds(780,450,120,30);
        l9.setFont(new Font("Georgia",Font.BOLD,25));
        l9.setForeground(Color.BLACK);
        p1.add(l9);
        
        cb9 = new JCheckBox("");
        cb9.setBounds(900,450,30,30);
        cb9.setFont(new Font("Georgia",Font.PLAIN,25));
        cb9.setForeground(Color.black);
        cb9.setBackground(Color.white);
        cb9.addItemListener(this);
        p1.add(cb9);
       
        l10 = new JLabel("Exam fee :");
        l10.setBounds(780,515,150,30);
        l10.setFont(new Font("Georgia",Font.BOLD,25));
        l10.setForeground(Color.BLACK);
        p1.add(l10);
        
        tf10 = new JTextField("0");
        tf10.setBounds(930,515,180,33);
        tf10.setBorder(BorderFactory.createEmptyBorder());
        tf10.setFont(new Font("Tahoma",Font.PLAIN,25));
        tf10.getDocument().addDocumentListener(this);
        tf10.setForeground(Color.black);
        tf10.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char ch = e.getKeyChar();
                if(Character.isDigit(ch) || Character.compare(ch, '.')==0){
                    b1.setEnabled(true);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(tf10.getText().length()==1){
                        b1.setEnabled(false);
                    }
                }
                else{
                    b1.setEnabled(false);
                    JOptionPane.showMessageDialog(p1, "Invalid input");
                    tf10.setText("");
                }
            }
        });
        tf10.setEnabled(false);
        tf10.getDocument().addDocumentListener(this);
        p1.add(tf10);
        
        setVisible(true);

    }

    public void valueChanged(ListSelectionEvent e) {

        String s = "";
        Object o[] = jl4.getSelectedValues();
        for(int i=0;i<o.length;i++){
            s +=(String) o[i];
            s = s+" " ;
       }
        tf4.setText(s);
    }
    
    public boolean iscbSelected(){
        
        if(cb1.isSelected()&& (tf81.getText().equals(""))){
            b1.setEnabled(false);
            cb1.setSelected(true);
            return false;
        }
        else if(cb2.isSelected()&& (tf82.getText().equals(""))){
            b1.setEnabled(false);
            cb2.setSelected(true);
            return false;
        }
        else if(cb3.isSelected()&& (tf83.getText().equals(""))){
            b1.setEnabled(false);
            cb3.setSelected(true);
            return false;
        }
        else if(cb4.isSelected()&& (tf84.getText().equals(""))){
            b1.setEnabled(false);
            cb4.setSelected(true);
            return false;
        }
        
        else if(cb9.isSelected()&& (tf10.getText().equals(""))){
            b1.setEnabled(false);
            cb9.setSelected(true);
            return false;
        }  
    
        
        return true;
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        changed();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changed();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        changed();
    }
    
    public void changed(){
        if(!tf1.getText().equals("") && !tf2.getText().equals("") && !c3.getSelectedItem().equals("None") && !tf4.getText().equals("") && !c5.getSelectedItem().equals("None") && !tf6.getText().equals("") && cb1.isSelected() && iscbSelected() )
        {
            b1.setEnabled(true);
        } else {
            b1.setEnabled(false);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource()==cb1){
            if(cb1.isSelected()){
                tf81.setEnabled(true);
                tf81.setText("");
                cb2.setEnabled(true);
            }
            else{
                b1.setEnabled(false);
                tf81.setEnabled(false);
                tf81.setText("0");
                cb2.setEnabled(false);
                cb3.setEnabled(false);
                cb4.setEnabled(false);
                cb2.setSelected(false);
                cb3.setSelected(false);
                cb4.setSelected(false);
                
            }   
        }
        else if(ie.getSource()==cb2){
            if(cb2.isSelected()){
                tf82.setEnabled(true);
                tf82.setText("");
                cb3.setEnabled(true);

            }
            else{
                tf82.setEnabled(false);
                tf82.setText("0");
                cb3.setSelected(false);
                cb4.setSelected(false);
                cb3.setEnabled(false);
                cb4.setEnabled(false);
            }
        }
        else if(ie.getSource()==cb3){
            if(cb3.isSelected()){
                tf83.setEnabled(true);
                tf83.setText("");
                cb4.setEnabled(true);
            }
            else{
                tf83.setEnabled(false);
                tf83.setText("0");
                cb4.setSelected(false);
                cb4.setEnabled(false);
            }
        }  
        else if(ie.getSource()==cb4){
            if(cb4.isSelected()){
                tf84.setEnabled(true);
                tf84.setText("");
            }
            else{
                tf84.setEnabled(false);
                tf84.setText("0");
            }
        }
        else if(ie.getSource()==cb9){
            if(cb9.isSelected()){
                tf10.setEnabled(true);
                tf10.setText("");
            }
            else{
                tf10.setEnabled(false);
                tf10.setText("0");
            }
        }
        if(ie.getSource()==cb2 || ie.getSource()==cb3 || ie.getSource()==cb4 || ie.getSource()==cb1){
            if(!cb1.isSelected() && !cb2.isSelected() && !cb3.isSelected() && !cb4.isSelected()){
                b1.setEnabled(false);
            }
        }
    }
    

    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1){
            String dType = tf1.getText();
            String dGenre = tf2.getText();
            String tname = c3.getSelectedItem();
            String dWeekdays = tf4.getText();
            String dTime = c5.getSelectedItem();
            int bCapacity = Integer.parseInt(tf6.getText());
            String rBeginner = "Not available";
            String rIntermediate = "Not available";
            String rAdvanced = "Not available";
            String rMasters = "Not available";
            String rExam = "Not available";
            double fBeginner = Double.parseDouble(tf81.getText());
            double fIntermediate = Double.parseDouble(tf82.getText());
            double fAdvanced = Double.parseDouble(tf83.getText());
            double fMasters = Double.parseDouble(tf84.getText());
            double fExam = Double.parseDouble(tf10.getText());
            if(cb1.isSelected()){
                rBeginner = "Available";
            }
            if(cb2.isSelected()){
                rIntermediate = "Available";
            }
            if(cb3.isSelected()){
                rAdvanced = "Available";
            }
            if(cb4.isSelected()){
                rMasters = "Available";
            }
            if(cb9.isSelected()){
                rExam = "Available";
            }
            
            
            try{
                Conn c =new Conn();
                    String count = "select count(dType) from dcinfo";
                    ResultSet rs;
                    int dCount=0;
                    try{
                        rs = c.s.executeQuery(count);
                        while(rs.next()){
                        dCount=Integer.parseInt(rs.getString("count(dType)"));
                        }
                        //resetting auto increment
                        String reset ="alter table dcinfo auto_increment="+(dCount+1)+"";
                        c.s.execute(reset);

                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                    
                    String query = "insert into dcinfo(dType,dGenre,dtrainer,dWDays,dTime,dbCapacity,Beginner,Intermediate,Advance,Masters,Exam,fBeginner,fIntermediate,fAdvance,fMasters,fExam) values('"+dType+"', '"+dGenre+"', '"+tname+"', '"+dWeekdays+"', '"+dTime+"', '"+bCapacity+"', '"+rBeginner+"', '"+rIntermediate+"', '"+rAdvanced+"', '"+rMasters+"', '"+rExam+"', '"+fBeginner+"', '"+fIntermediate+"', '"+fAdvanced+"', '"+fMasters+"', '"+fExam+"')";
                    c.s.executeUpdate(query);
                    String sql5 = "insert into bCapacity(dType,bCapacity,sRegistered,sExam) values('"+dType+"','"+bCapacity+"','"+Integer.parseInt("0")+"','"+Integer.parseInt("0")+"')";
                    c.s.executeUpdate(sql5);
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Dance Course added successfully");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(this,msg ,"",JOptionPane.PLAIN_MESSAGE);
                    
                    tf1.setText("");
                    tf2.setText("");     
                    c3.select("none");
                    tf4.setText("");
                    c5.select("none");
                    tf6.setText("");
                    cb1.setSelected(false);
                    cb2.setSelected(false);
                    cb3.setSelected(false);
                    cb4.setSelected(false);
                    cb9.setSelected(false);
                
                    setVisible(false);
                   
               
            }catch(SQLException | NumberFormatException | HeadlessException ae){
                System.out.println(ae);
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("You didn't fill in all the details correctly");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
            }
            
        }    
        if(e.getSource()==b2){
            setVisible(false);
        }
        if(e.getSource()==b7){
            new ViewTrainers(username).setVisible(true);
        }
    }
    
}