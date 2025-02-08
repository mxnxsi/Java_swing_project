package dams;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class ViewStudents extends JFrame implements ActionListener, MouseListener{
    String username;
    com.toedter.calendar.JDateChooser jdc;
    DefaultTableModel dm ;
    JPanel p,panel;
    JButton b1,b2,b3,b4;
    JTextField tf1;
    JLabel l1,l3;
    String data[][]={};
    JScrollPane sp;
    JTable t;
    
    public static void main(String[] args){
        new ViewStudents("");
    }
    private Object jTable_Display_User;

    ViewStudents(String username){
        this.username=username;
        setBounds(80,50,1370,760);
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
        p.setBounds(0,0,1370,760);
        add(p);
        ImageIcon bi = new ImageIcon(ClassLoader.getSystemResource("dams/icons/d6.jpg"));
        Image b = bi.getImage().getScaledInstance(1370,760,Image.SCALE_REPLICATE);
        ImageIcon bii = new ImageIcon(b);
        JLabel la = new JLabel(bii);
        la.setBounds(0,0,1370,760);
        la.setForeground(Color.white);
        la.setFont(new Font("Rockwell",Font.BOLD,12));
        p.add(la);
        
        panel = new JPanel();
        panel.setBounds(9,105,1400,720);
        panel.setLayout(null);
        panel.setOpaque(false);
        //panel.setBackground(Color.LIGHT_GRAY);
        la.add(panel);
        
        
        
        int cCount=0;
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select count(sName) from studinfo");
            if(rs.next()){
                cCount = Integer.parseInt(rs.getString("count(sName)"));
            }
            int j = 0;
            data = new String [cCount][14];
            ResultSet rs2;
            while(j<cCount){
                rs2 = c.s.executeQuery("select * from studinfo where sId='"+(j+1)+"'");
                while(rs2.next()){
                    data[j][0] = rs2.getString("sId");
                    data[j][1] = rs2.getString("sName");
                    data[j][2] = rs2.getString("sAddress");
                    data[j][3] = rs2.getString("sPincode");
                    data[j][4] = rs2.getString("sMob");
                    data[j][5] = rs2.getString("sEml");
                    data[j][6] = rs2.getString("sjDate");
                    data[j][7] = rs2.getString("sdCourse");
                    data[j][8] = rs2.getString("sdLevel");
                    data[j][9] = rs2.getString("sdExam");
                    data[j][10] = rs2.getString("sfdCourse");
                    data[j][11] = rs2.getString("sfExam");
                    data[j][12] = rs2.getString("sTotal");
                    data[j][13] = rs2.getString("sImgPath");
                }
                j++;
            }
        }
        catch(Exception ae){
            System.out.println(ae);
        }
        
        dm = new DefaultTableModel();
        t = new JTable(dm);
        dm.addColumn("sId");
        dm.addColumn("sName");
        dm.addColumn("sAddress");
        dm.addColumn("sPincode");
        dm.addColumn("sMob");
        dm.addColumn("sEml");
        dm.addColumn("sjDate");
        dm.addColumn("sdCourse");
        dm.addColumn("sdLevel");
        dm.addColumn("sdExam");
        dm.addColumn("sfdCourse");
        dm.addColumn("sfExam");
        dm.addColumn("sTotal");
        dm.addColumn("tImgPath");
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
        
        t.getColumnModel().getColumn(0).setPreferredWidth(60);
        t.getColumnModel().getColumn(1).setPreferredWidth(400);
        t.getColumnModel().getColumn(2).setPreferredWidth(400);
        t.getColumnModel().getColumn(3).setPreferredWidth(150);
        t.getColumnModel().getColumn(4).setPreferredWidth(160);
        t.getColumnModel().getColumn(5).setPreferredWidth(400);
        t.getColumnModel().getColumn(6).setPreferredWidth(200);
        t.getColumnModel().getColumn(7).setPreferredWidth(300);
        t.getColumnModel().getColumn(8).setPreferredWidth(300);
        t.getColumnModel().getColumn(9).setPreferredWidth(300);
        t.getColumnModel().getColumn(10).setPreferredWidth(150);
        t.getColumnModel().getColumn(11).setPreferredWidth(150);
        t.getColumnModel().getColumn(12).setPreferredWidth(150);
        t.getColumnModel().getColumn(13).setPreferredWidth(600);

        sp = new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.getHorizontalScrollBar().setBackground(Color.gray);
        sp.getVerticalScrollBar().setBackground(Color.gray);
        sp.setBounds(40,0,1250,620);
        panel.add(sp);
        la.add(panel);
        createTable(data);
        
        l1 = new JLabel("ID :");
        l1.setBounds(200,35,50,30);
        l1.setFont(new Font("Georgia",Font.BOLD,25));
        l1.setForeground(Color.BLACK);
        la.add(l1);
        
        tf1 = new JTextField("");
        tf1.setBounds(250,35,80,30);
        tf1.setFont(new Font("Georgia",Font.BOLD,25));
        tf1.setForeground(Color.BLACK);
        la.add(tf1);
        
        l3 = new JLabel("Date :");
        l3.setBounds(400,35,100,30);
        l3.setFont(new Font("Georgia",Font.BOLD,25));
        l3.setForeground(Color.black);
        la.add(l3);
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(490,35,180,30);
        la.add(p);
        jdc = new com.toedter.calendar.JDateChooser();
        jdc.setBackground(Color.WHITE);
        jdc.getComponent(1).addMouseListener(this);
        jdc.getComponent(0).addMouseListener(this);
        //((JTextField)jdc.getDateEditor().getUiComponent()).getDocument().addDocumentListener(this);
        jdc.setDateFormatString("dd-MM-yyyy");
        jdc.setFont(new java.awt.Font("Georgia", 0, 19));
        java.util.Date d = new java.util.Date();
       // jdc.setMinSelectableDate(d);
        
        p.add(jdc);
        
        b1 = new JButton("Cancel Admission");
        b1.setBounds(800,30,250,40);
        b1.setFont(new Font("Georgia",Font.BOLD,25));
        b1.setBackground(Color.white);
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        la.add(b1);

        b3 = new JButton("search");
        b3.setBounds(690,30,100,40);
        b3.setFont(new Font("Georgia",Font.BOLD,25));
        b3.setBackground(Color.white);
        b3.setBorder(BorderFactory.createRaisedBevelBorder());
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        la.add(b3);
        
        b4 = new JButton("Show All");
        b4.setBounds(1220,30,130,40);
        b4.setFont(new Font("Georgia",Font.BOLD,25));
        b4.setBackground(Color.white);
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        la.add(b4);
        
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
        
        Conn cn = new Conn();
        
        if(e.getSource()==b1){
            int j=0,k=0,l=0,m=0;
            String dCourse = null,dExam = null;
            //System.out.println(j);
            String sr2 = "select sId from studinfo where sId='"+tf1.getText()+"'";
            String sr3 = "select count(sName) from studinfo";
            String rem = "delete from studinfo where sId='"+tf1.getText()+"'";
            String rem4 = "select sdCourse,SdExam from studinfo where sId='"+tf1.getText()+"'";
            
            
            try{
                ResultSet rs2 = cn.s.executeQuery(sr3);
                while(rs2.next()){
                    k=Integer.parseInt(rs2.getString("count(sName)"));
                    System.out.println(k);
                }
                ResultSet rs = cn.s.executeQuery(sr2);
                if(rs.next()){
                    j = Integer.parseInt(rs.getString("sId"));
                    System.out.println(j);
                }
                ResultSet rs4 = cn.s.executeQuery(rem4);
                while(rs4.next()){
                    dCourse = rs4.getString("sdCourse");
                    dExam = rs4.getString("sdExam");
                    System.out.println(dCourse);
                    System.out.println(dExam);
                }
                if(dExam.equals("Applying")){
                    System.out.println("Working");
                    String rem2 = "update bCapacity set sRegistered=sRegistered-1, sExam = sExam-1 where dType='"+dCourse+"'";
                    cn.s.execute(rem2);
                }
                else{
                    String rem3 = "update bCapacity set sRegistered=sRegistered-1 where dType='"+dCourse+"'";
                    cn.s.execute(rem3);
                }
                cn.s.execute(rem);
                UIManager ui = new UIManager();
                ui.put("OptionPane.background",Color.WHITE);
                ui.put("Panel.background",Color.WHITE);
                JOptionPane op = new JOptionPane();
                JLabel msg = new JLabel("Admission Canceled");
                msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                op.showMessageDialog(this,msg ,"",JOptionPane.ERROR_MESSAGE);
                while(j<=k){
                    String sr = "update studinfo set sId='"+j+"' where sId='"+(j+1)+"'";
                    cn.s.executeUpdate(sr);
                    j++;
                }
                tf1.setText("");
                setVisible(true);
                
            }catch(SQLException | NumberFormatException | HeadlessException ex){
                System.out.println(ex);
            }
            setVisible(false);
        }
        
        if(e.getSource()==b2){ //Back
            setVisible(false);
        }
        
        if(e.getSource()==b3){
            Conn c = new Conn();  
            dm.setRowCount(0);
            setVisible(false);
            setVisible(true);
            try{
                if(!tf1.getText().equals("")  && ((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                    data = new String[1][14];
                    ResultSet rs2 = c.s.executeQuery("select * from studinfo where Sid='"+tf1.getText()+"'");  
                    while(rs2.next()){
                        data[0][0] = rs2.getString("sId");
                        data[0][1] = rs2.getString("sName");
                        data[0][2] = rs2.getString("sAddress");
                        data[0][3] = rs2.getString("sPincode");
                        data[0][4] = rs2.getString("sMob");
                        data[0][5] = rs2.getString("sEml");
                        data[0][6] = rs2.getString("sjDate");
                        data[0][7] = rs2.getString("sdCourse");
                        data[0][8] = rs2.getString("sdLevel");
                        data[0][9] = rs2.getString("sdExam");
                        data[0][10] = rs2.getString("sfdCourse");
                        data[0][11] = rs2.getString("sfExam");
                        data[0][12] = rs2.getString("sTotal");
                        data[0][13] = rs2.getString("sImgPath");
                    }
                    int count = 0;
                    ResultSet rs3 = c.s.executeQuery("select count(Sid) from studinfo");
                    if(rs3.next()){
                        count = Integer.parseInt(rs3.getString("count(Sid)"));
                    }    
                    if(Integer.parseInt(tf1.getText()) > count){
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("Invalid input");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(panel,msg ,"",JOptionPane.ERROR_MESSAGE);
                        tf1.setText("");
                        dm.setRowCount(0);
                    }else
                        createTable(data);
                }
                
                if(tf1.getText().equals("")  && !((JTextField)jdc.getDateEditor().getUiComponent()).getText().equals("")){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(jdc.getDate());
                    
                    int count = 0;
                    ResultSet rs3 = c.s.executeQuery("select count(Sid) from studinfo where sjdate='"+date+"'");
                    if(rs3.next()){
                        count = Integer.parseInt(rs3.getString("count(Sid)"));
                    }    
                    if(count==0){
                        UIManager ui = new UIManager();
                        ui.put("OptionPane.background",Color.WHITE);
                        ui.put("Panel.background",Color.WHITE);
                        //ui.put("OptionPane.minimunSize",new Dimension(300,200));
                        JOptionPane op = new JOptionPane();
                        JLabel msg = new JLabel("No Data Available");
                        msg.setFont(new Font("SAN_SERIF",Font.BOLD,19));
                        op.showMessageDialog(panel,msg ,"",JOptionPane.ERROR_MESSAGE);
                        tf1.setText("");
                        dm.setRowCount(0);
                    }else{
                        data = new String[count][14];
                        //System.out.println(count);
                        int j = 0;
                        ResultSet rs2 = c.s.executeQuery("select * from studinfo where sjdate='"+date+"'"); 
                        while(j < count){
                            while(rs2.next()){
                                data[j][0] = rs2.getString("sId");
                                data[j][1] = rs2.getString("sName");
                                data[j][2] = rs2.getString("sAddress");
                                data[j][3] = rs2.getString("sPincode");
                                data[j][4] = rs2.getString("sMob");
                                data[j][5] = rs2.getString("sEml");
                                data[j][6] = rs2.getString("sjDate");
                                data[j][7] = rs2.getString("sdCourse");
                                data[j][8] = rs2.getString("sdLevel");
                                data[j][9] = rs2.getString("sdExam");
                                data[j][10] = rs2.getString("sfdCourse");
                                data[j][11] = rs2.getString("sfExam");
                                data[j][12] = rs2.getString("sTotal");
                                data[j][13] = rs2.getString("sImgPath");
                                j++;
                            }
                            
                        }
                        
                        createTable(data);
                    }
                }
            }
            catch(Exception ae){
                System.out.println(ae);
            }
            
        }
        if(e.getSource()==b4){
            tf1.setText("");
            ((JTextField)jdc.getDateEditor().getUiComponent()).setText("");
            dm.setRowCount(0);
            setVisible(false);
            setVisible(true);
            int cCount=0;
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select count(sname) from studinfo");
                if(rs.next()){
                    cCount = Integer.parseInt(rs.getString("count(sName)"));
                }
                int j = 0;
                data = new String [cCount][14];
                ResultSet rs2;
                while(j<cCount){
                    rs2 = c.s.executeQuery("select * from studinfo where Sid='"+(j+1)+"'");
                    while(rs2.next()){
                        data[j][0] = rs2.getString("sId");
                        data[j][1] = rs2.getString("sName");
                        data[j][2] = rs2.getString("sAddress");
                        data[j][3] = rs2.getString("sPincode");
                        data[j][4] = rs2.getString("sMob");
                        data[j][5] = rs2.getString("sEml");
                        data[j][6] = rs2.getString("sjDate");
                        data[j][7] = rs2.getString("sdCourse");
                        data[j][8] = rs2.getString("sdLevel");
                        data[j][9] = rs2.getString("sdExam");
                        data[j][10] = rs2.getString("sfdCourse");
                        data[j][11] = rs2.getString("sfExam");
                        data[j][12] = rs2.getString("sTotal");
                        data[j][13] = rs2.getString("sImgPath");
                    }
                    j++;
                }
            }
            catch(Exception ae){
                System.out.println(ae);
            }
            createTable(data);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==jdc.getComponent(1)){
            jdc.getComponent(1).setEnabled(false);
            JOptionPane.showMessageDialog(this, "Please select the date");
        }
        if(e.getSource()==jdc.getComponent(0)){
            jdc.getComponent(1).setEnabled(true);
            tf1.setText("");
            b3.setEnabled(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
   