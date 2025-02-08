package dams;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewDanceCourses extends JFrame implements ActionListener{
    String username;
    com.toedter.calendar.JDateChooser jdc;
    DefaultTableModel dm ;
    JPanel p,panel;
    JButton b2;
    String data[][]={};
    JScrollPane sp;
    JTable t;
    
    public static void main(String[] args){
        new ViewDanceCourses("");
    }

    ViewDanceCourses(String username){
        this.username=username;
        setBounds(80,50,1300,740);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dams/icons/add.png"));
        Image im = i.getImage();
        setIconImage(im);
        setTitle("View All Trainers");
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
 
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(80,50,1300,740);
        add(p);
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/db.jpg"));
        Image b = bi.getImage().getScaledInstance(1300,740,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JLabel la = new JLabel(bii);
        la.setBounds(80,50,1300,740);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        panel = new JPanel();
        panel.setBounds(9,85,1280,700);
        panel.setLayout(null);
        //panel.setBackground(Color.LIGHT_GRAY);
        panel.setOpaque(false);
        la.add(panel);
        
        
        
        int cCount=0;
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select count(dType) from dcinfo");
            if(rs.next()){
                cCount = Integer.parseInt(rs.getString("count(dType)"));
            }
            int j = 0;
            data = new String [cCount][16];
            ResultSet rs2;
            while(j<cCount){
                rs2 = c.s.executeQuery("select * from dcinfo where dSrNo='"+(j+1)+"'");
                while(rs2.next()){
                    data[j][0] = rs2.getString("dType");
                    data[j][1] = rs2.getString("dGenre");
                    data[j][2] = rs2.getString("dTrainer");
                    data[j][3] = rs2.getString("dWDays");
                    data[j][4] = rs2.getString("dTime");
                    data[j][5] = rs2.getString("dBCapacity");
                    data[j][6] = rs2.getString("Beginner");
                    data[j][7] = rs2.getString("Intermediate");
                    data[j][8] = rs2.getString("Advance");
                    data[j][9] = rs2.getString("Masters");
                    data[j][10] = rs2.getString("Exam");
                    data[j][11] = rs2.getString("fBeginner");
                    data[j][12] = rs2.getString("fIntermediate");
                    data[j][13] = rs2.getString("fAdvance");
                    data[j][14] = rs2.getString("fMasters");
                    data[j][15] = rs2.getString("fExam");
                }
                j++;
            }
        }
        catch(Exception ae){
            System.out.println(ae);
        }
        
        dm = new DefaultTableModel();
        t = new JTable(dm);
        
        dm.addColumn("dType");
        dm.addColumn("dGenre");
        dm.addColumn("dTrainer");
        dm.addColumn("dWDay");
        dm.addColumn("dTime");
        dm.addColumn("dBCapacity");
        dm.addColumn("Beginner");
        dm.addColumn("Intermediate");
        dm.addColumn("Advance");
        dm.addColumn("Masters");
        dm.addColumn("Exam");
        dm.addColumn("fBeginner");
        dm.addColumn("fIntermediate");
        dm.addColumn("fAdvance");
        dm.addColumn("fMasters");
        dm.addColumn("fExam");
        //t.setBounds(0,0,900,340);
        t.setFont(new Font("SAN_SERIF",Font.BOLD,23));
        //t.setIntercellSpacing();
        t.setShowHorizontalLines(true);
        t.setShowVerticalLines(true);
        t.setBackground(Color.WHITE);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t.setEnabled(false);
        t.getTableHeader().setFont(new Font("Georgia",Font.BOLD,25));
        t.getTableHeader().setBackground(Color.DARK_GRAY);
        t.getTableHeader().setForeground(Color.WHITE);
        t.setRowHeight(30);
        
        t.getColumnModel().getColumn(0).setPreferredWidth(200);
        t.getColumnModel().getColumn(1).setPreferredWidth(225);
        t.getColumnModel().getColumn(2).setPreferredWidth(300);
        t.getColumnModel().getColumn(3).setPreferredWidth(350);
        t.getColumnModel().getColumn(4).setPreferredWidth(300);
        t.getColumnModel().getColumn(5).setPreferredWidth(500);
        t.getColumnModel().getColumn(6).setPreferredWidth(200);
        t.getColumnModel().getColumn(7).setPreferredWidth(200);
        t.getColumnModel().getColumn(8).setPreferredWidth(200);
        t.getColumnModel().getColumn(9).setPreferredWidth(200);
        t.getColumnModel().getColumn(10).setPreferredWidth(200);
        t.getColumnModel().getColumn(11).setPreferredWidth(150);
        t.getColumnModel().getColumn(12).setPreferredWidth(200);
        t.getColumnModel().getColumn(13).setPreferredWidth(150);
        t.getColumnModel().getColumn(14).setPreferredWidth(150);
        t.getColumnModel().getColumn(15).setPreferredWidth(150);
        
        sp = new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.getHorizontalScrollBar().setBackground(Color.gray);
        sp.getVerticalScrollBar().setBackground(Color.gray);
        sp.setBounds(40,0,1200,620);
        panel.add(sp);
        la.add(panel);
        createTable(data);
        
        
        
        
        b2 = new JButton("Back");       
        b2.setBackground(new Color(0,102,102));
        b2.setForeground(Color.white);
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b2.setFont(new Font("SAN_SERIF",Font.BOLD,22));
        b2.addActionListener(this);
        b2.setBounds(10,10,100,30);
        la.add(b2);
        
        setVisible(true);
    }
    
    public void createTable(String data2[][]){
        int i = 0;
        while(i<data2.length){
            dm.addRow(data2[i]);
            i++;
        } 
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b2){ //Back
            setVisible(false);
        }
    }
}    
