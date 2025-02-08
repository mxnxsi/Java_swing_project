package dams;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class DCReport extends JFrame implements ActionListener{
     String username;
     JPanel p1;
     JButton b1,b4,b2,b3,b5;
     Choice c1;
     
     
     DCReport(String username){
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
        
        b4 = new JButton("Back");
        b4.setBounds(20,20,120,40);
        b4.setBackground(Color.white);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Rockwell",Font.BOLD,23));
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.addActionListener(this);
        la.add(b4);
  
        
        p1 = new JPanel();
        p1.setBounds(30,150,500,400);
        p1.setLayout(null);
        p1.setBackground(new Color(102,51,0));
        la.add(p1);
        
        JLabel l = new JLabel("Dance Course Name :");
        l.setBounds(40,30,400,30);
        l.setForeground(Color.WHITE);
        l.setFont(new Font("Georgia",Font.BOLD,25));
        p1.add(l);
        
        c1 = new Choice();
        String count = "select count(dType) from dcinfo";
        String sql = "select dType from dcinfo";
        int pCount=0;
        Conn  c = new Conn();
        try{
           ResultSet rs = c.s.executeQuery(count);
           while(rs.next()){
               pCount=Integer.parseInt(rs.getString("count(dType)"));
           }
           ResultSet rs2 = c.s.executeQuery(sql);
           if(pCount>0){
               while(rs2.next()){
                   c1.add(rs2.getString("dType"));
               }
           }
           else{
               la.add(l);
               b2.setVisible(false);
           }
        }
        catch(Exception e){
            System.out.println(e);
        }   
        c1.setBackground(Color.WHITE);
        c1.setBounds(40,80,370,60);
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("Tahoma",Font.PLAIN,23));
        p1.add(c1);
        
        b1 = new JButton("Check");
        b1.setBounds(360,78,100,35);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        b1.setFont(new Font("Georgia",Font.BOLD,25));
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("All Dance Course Details");
        b2.setBounds(80,240,320,40);
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Rockwell",Font.BOLD,23));
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.addActionListener(this);
        p1.add(b2);
        
        b3 = new JButton("Check Batch Availability");
        b3.setBounds(70,170,350,40);
        b3.setBackground(Color.white);
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Rockwell",Font.BOLD,23));
        b3.setBorder(BorderFactory.createRaisedBevelBorder());
        b3.addActionListener(this);
        p1.add(b3);
        
        b5 = new JButton("View Fully BookedCourses");
        b5.setBounds(70,310,350,40);
        b5.setBackground(Color.white);
        b5.setForeground(Color.BLACK);
        b5.setFont(new Font("Rockwell",Font.BOLD,23));
        b5.setBorder(BorderFactory.createRaisedBevelBorder());
        b5.addActionListener(this);
        p1.add(b5);
        
        setVisible(true);
     }
     
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==b4){
            setVisible(false);
        }
        if(e.getSource()==b2){
            Conn c = new Conn();
            try{
                JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\dcReport.jrxml");
                String sql = "select * from dcinfo";
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
        if(e.getSource()==b3){
            Conn c = new Conn();
            try{
                JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\batchReport.jrxml");
                String sql = "select * from bCapacity";
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
        if(e.getSource()==b1){
            Conn c = new Conn();
            try{
                JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\dcReport.jrxml");
                String sql = "select * from dcinfo where dType = '"+c1.getSelectedItem()+"'";
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
        if(e.getSource()==b5){
            Conn c = new Conn();
            try{
                JasperDesign jd = JRXmlLoader.load("D:\\DAMS\\src\\dams\\reports\\batchReport.jrxml");
                String sql = "select * from bCapacity where (bCapacity-sRegistered)=0";
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
         new DCReport("");
     }
}

