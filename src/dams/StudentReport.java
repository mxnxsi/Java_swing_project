package dams;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Date;
import net.sf.jasperreports.view.JRViewer;

public class StudentReport extends JFrame implements ActionListener,MouseListener,DocumentListener{
    String username;
    JButton b1,b4,b2;
    JTextField t1;
    com.toedter.calendar.JDateChooser jdc;
    com.toedter.calendar.JDateChooser jdc1;
    JPanel p1;
    
    StudentReport(String username){
        this.username=username;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/d.jpg"));
        Image im = i.getImage();
        setIconImage(im);
        setBounds(80,50,1370,760);
        setTitle("Dashboard");
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/d.jpg"));
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
        
        p1 = new JPanel();
        p1.setBounds(30,150,500,400);
        p1.setLayout(null);
        p1.setBackground(new Color(102,51,0));
        la.add(p1);
        
        JLabel l2 = new JLabel("ID :");
        l2.setBounds(100,30,50,30);
        l2.setFont(new Font("Georgia",Font.BOLD,25));
        l2.setForeground(Color.WHITE);
        p1.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(200,30,200,30);
        t1.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        t1.setForeground(Color.BLACK);
        t1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                ((JTextField)jdc.getDateEditor().getUiComponent()).setText("");
                ((JTextField)jdc1.getDateEditor().getUiComponent()).setText("");
                jdc1.getComponent(0).setEnabled(false);

                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                   if(((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                        b1.setEnabled(true);
                    }
                    else
                        b1.setEnabled(false);
                }
                else if(ch==KeyEvent.VK_BACK_SPACE){
                    if(t1.getText().length()==1){
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
                    JLabel msg = new JLabel("Invalid input");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                    t1.setText("");
                }
            }
        });
        t1.getDocument().addDocumentListener(this);
        p1.add(t1);
        
        JLabel l3 = new JLabel("Admission Date :");
        l3.setBounds(60,85,230,30);
        l3.setFont(new Font("Georgia",Font.BOLD,25));
        l3.setForeground(Color.WHITE);
        p1.add(l3);
        
        JLabel l4 = new JLabel("From :");
        l4.setBounds(100,130,100,25);
        l4.setFont(new Font("Georgia",Font.BOLD,20));
        l4.setForeground(Color.WHITE);
        p1.add(l4);
        
        JLabel l5 = new JLabel("To :");
        l5.setBounds(100,170,100,30);
        l5.setFont(new Font("Georgia",Font.BOLD,20));
        l5.setForeground(Color.WHITE);
        p1.add(l5);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.setBounds(200,130,200,25);
        p2.setBackground(Color.white);
        p1.add(p2);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.getComponent(1).addMouseListener(this);
        jdc.getComponent(0).addMouseListener(this);
        ((JTextField)jdc.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        java.util.Date d = new java.util.Date();
       // jdc.setMinSelectableDate(d);
        p2.add(jdc);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBounds(200,170,200,25);
        p3.setBackground(Color.white);
        p1.add(p3);
        jdc1 = new com.toedter.calendar.JDateChooser();
        jdc1.setBackground(Color.WHITE);
        jdc1.getComponent(1).addMouseListener(this);
        jdc1.getComponent(0).addMouseListener(this);
        jdc1.getComponent(0).setEnabled(false);
        ((JTextField)jdc1.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        jdc1.setDateFormatString("dd-MM-yyyy");
        jdc1.setFont(new java.awt.Font("Georgia", 0, 19));
        p3.add(jdc1);
        
        b1 = new JButton("Generate Report");
        b1.setBounds(100,250,300,30);
        b1.setBackground(Color.white);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Rockwell",Font.BOLD,23));
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.addActionListener(this);
        b1.setEnabled(false);
        p1.add(b1);
        
        b2 = new JButton("All Student Details");
        b2.setBounds(90,340,320,30);
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Rockwell",Font.BOLD,23));
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.addActionListener(this);
        p1.add(b2);
        
        b4 = new JButton("Back");
        b4.setBounds(20,20,120,40);
        b4.setBackground(Color.white);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Rockwell",Font.BOLD,23));
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.addActionListener(this);
        la.add(b4);
        
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
        if(!((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
            jdc1.getComponent(0).setEnabled(true);
        }
        /*if(((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("") && t1.getText().equals("")){
            b1.setEnabled(false);
        }*/
    }
    
    public void mouseClicked(MouseEvent e){
        if(e.getSource()==jdc.getComponent(1)){
            jdc.getComponent(1).setEnabled(false);
            JOptionPane.showMessageDialog(p1, "Please select the date");
            ((JTextField)jdc.getDateEditor().getUiComponent()).setText("");
            jdc1.getComponent(0).setEnabled(false);
            ((JTextField)jdc1.getDateEditor().getUiComponent()).setText("");
        }
        if(e.getSource()==jdc.getComponent(0)){
            //System.out.println(jdc1.getDate());
            jdc.getComponent(1).setEnabled(true);
            ((JTextField)jdc1.getDateEditor().getUiComponent()).setText("");
            t1.setText("");
            b1.setEnabled(true);
        }
        if(e.getSource()==jdc1.getComponent(1)){
            jdc1.getComponent(1).setEnabled(false);
            JOptionPane.showMessageDialog(p1, "Please select the date");
            ((JTextField)jdc1.getDateEditor().getUiComponent()).setText("");
        }
        if(e.getSource()==jdc1.getComponent(0)){
            jdc1.getComponent(1).setEnabled(true);
            t1.setText("");
            b1.setEnabled(true);
            jdc1.setMinSelectableDate(jdc.getDate()); 
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
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b4){
            setVisible(false);
        }
        if(e.getSource()==b1){
           Conn c = new Conn();  
            try{
                if(!t1.getText().equals("")  && ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("") && ((JTextField)jdc1.getDateEditor().getUiComponent()).getText().equals("")){
                    int count = 0;
                    ResultSet rs3 = c.s.executeQuery("select count(sId) from Studinfo");
                    if(rs3.next()){
                        count = Integer.parseInt(rs3.getString("count(sId)"));
                    }    
                    if(Integer.parseInt(t1.getText()) > count){
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Invalid input");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                        
                    }else{
                        JFrame f = new JFrame("ID wise Report");
                        f.setExtendedState(MAXIMIZED_BOTH);
                        f.setLayout(null);
                        f.setResizable(false);
                        f.getContentPane().setBackground(Color.WHITE);
                        
                        JPanel p = new JPanel();
                        p.setLayout(new BorderLayout());
                        p.setBounds(0,110,1540,690);
                        p.setBackground(Color.GRAY);
                        f.add(p);
                        
                        JLabel l1 = new JLabel("Id :");
                        l1.setBounds(30,30,100,30);
                        l1.setFont(new Font("Georgia",Font.BOLD,25));
                        f.add(l1);
                        
                        String id = t1.getText();
                        JLabel l2 = new JLabel(id);
                        l2.setBounds(140,30,150,30);
                        l2.setFont(new Font("SAN_SERIF",Font.BOLD,25));
                        f.add(l2);
                        
                        f.setVisible(true);
                        JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\studentReport.jrxml");
                        String sql = "select * from Studinfo where sId='"+t1.getText()+"'";
                        JRDesignQuery updatequery = new JRDesignQuery();
                        updatequery.setText(sql);
                        jd.setQuery(updatequery);
                        JasperReport jreport = JasperCompileManager.compileReport(jd);
                        JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                        JRViewer v = new JRViewer(jprint);
                        p.add(v);
                    }
                }
                if(t1.getText().equals("")  && !((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("") && ((JTextField)jdc1.getDateEditor().getUiComponent()).getText().equals("")){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(jdc.getDate());
                    
                    int count = 0;
                    ResultSet rs3 = c.s.executeQuery("select count(sName) from studinfo where sjdate = '"+date1+"'");
                    if(rs3.next()){
                        count = Integer.parseInt(rs3.getString("count(sName)"));
                    }    
                    if(count==0){
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("No Data Available");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                    }else{
                        JFrame f = new JFrame("Date Wise Report");
                        f.setExtendedState(MAXIMIZED_BOTH);
                        f.setLayout(null);
                        f.setResizable(false);
                        f.getContentPane().setBackground(Color.WHITE);
                        
                        JPanel p = new JPanel();
                        p.setLayout(new BorderLayout());
                        p.setBounds(0,110,1540,690);
                        p.setBackground(Color.GRAY);
                        f.add(p);
                        
                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
                        String date3 = sdf2.format(jdc.getDate());
                        
                        JLabel l1 = new JLabel("From :");
                        l1.setBounds(30,30,100,30);
                        l1.setFont(new Font("Georgia",Font.BOLD,25));
                        f.add(l1);
                        
                        JLabel l2 = new JLabel(date3);
                        l2.setBounds(140,30,150,30);
                        l2.setFont(new Font("SAN_SERIF",Font.BOLD,25));
                        f.add(l2);
                        
                        
                        f.setVisible(true);
                        JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\studentReport.jrxml");
                        String sql = "select * from studinfo where sjdate = '"+date1+"'";
                        JRDesignQuery updatequery = new JRDesignQuery();
                        updatequery.setText(sql);
                        jd.setQuery(updatequery);
                        JasperReport jreport = JasperCompileManager.compileReport(jd);
                        JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                        JRViewer v = new JRViewer(jprint);
                        p.add(v);
                    }
                
                }
                if(t1.getText().equals("")  && !((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("") && !((JTextField)jdc1.getDateEditor().getUiComponent()).getText().equals("")){
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = sdf.format(jdc.getDate());
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    String date2 = sdf1.format(jdc1.getDate());
                    
                    int count = 0;
                    ResultSet rs3 = c.s.executeQuery("select count(sName) from studinfo where sjdate >= '"+date1+"' && sjdate <= '"+date2+"'");
                    if(rs3.next()){
                        count = Integer.parseInt(rs3.getString("count(sName)"));
                    }    
                    if(count==0){
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("No Data Available");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                    }else{
                        JFrame f = new JFrame("Date To Date Report");
                        f.setExtendedState(MAXIMIZED_BOTH);
                        f.setLayout(null);
                        f.setResizable(false);
                        f.getContentPane().setBackground(Color.WHITE);
                        
                        JPanel p = new JPanel();
                        p.setLayout(new BorderLayout());
                        p.setBounds(0,110,1540,690);
                        p.setBackground(Color.GRAY);
                        f.add(p);
                        
                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
                        String date3 = sdf2.format(jdc.getDate());
                        SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
                        String date4 = sdf3.format(jdc1.getDate());
                        
                        JLabel l1 = new JLabel("From :");
                        l1.setBounds(30,30,100,30);
                        l1.setFont(new Font("Georgia",Font.BOLD,25));
                        f.add(l1);
                        
                        JLabel l2 = new JLabel(date3);
                        l2.setBounds(140,30,150,30);
                        l2.setFont(new Font("SAN_SERIF",Font.BOLD,25));
                        f.add(l2);
                        
                        JLabel l3 = new JLabel("To :");
                        l3.setBounds(330,30,50,30);
                        l3.setFont(new Font("Georgia",Font.BOLD,25));
                        f.add(l3);
                        
                        JLabel l4 = new JLabel(date4);
                        l4.setBounds(400,30,150,30);
                        l4.setFont(new Font("SAN_SERIF",Font.BOLD,25));
                        f.add(l4);
                        
                        f.setVisible(true);
                        JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\studentReport.jrxml");
                        String sql = "select * from studinfo where sjdate >= '"+date1+"' && sjdate <= '"+date2+"'";
                        JRDesignQuery updatequery = new JRDesignQuery();
                        updatequery.setText(sql);
                        jd.setQuery(updatequery);
                        JasperReport jreport = JasperCompileManager.compileReport(jd);
                        JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                        JRViewer v = new JRViewer(jprint);
                        p.add(v);
                    }
                }
                if(((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("") && t1.getText().equals("")){
                    //System.out.println("Please enter either ID or Date");
                    UIManager ui = new UIManager();
                    ui.put("OptionPane.background",Color.WHITE);
                    ui.put("Panel.background",Color.WHITE);
                    //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                    JOptionPane op = new JOptionPane();
                    JLabel msg = new JLabel("Please enter either ID or Date");
                    msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                    op.showMessageDialog(p1,msg ,"",JOptionPane.ERROR_MESSAGE);
                    b1.setEnabled(false);
                }
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }
        if(e.getSource()==b2){
            Conn c = new Conn();
            try{
                JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\studentReport.jrxml");
                String sql = "select * from studinfo";
                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(sql);
                jd.setQuery(updateQuery);
                JasperReport jreport = JasperCompileManager.compileReport(jd);
                JasperPrint jprint = JasperFillManager.fillReport(jreport,null,c.c);
                JasperViewer.viewReport(jprint);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }
    }
    
    
    public static void main(String[] args){
        new StudentReport("");
    }
}
