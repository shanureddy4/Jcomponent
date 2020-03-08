import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SignUp extends JFrame {
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel dob;
    JButton b1;
    JButton b2;
    JComboBox cb1;
    JDateChooser dt;
    SignUp()
    {
        t1=new JTextField();
        t1.setBounds(120,120,175,30);
        t2=new JTextField();
        t2.setBounds(120,200,175,30);
        t3=new JTextField();
        t3.setBounds(120,280,175,30);
        t4=new JTextField();
        t4.setBounds(120,360,175,30);
        t5=new JTextField();
        t5.setBounds(120,440,175,30);
        l1=new JLabel("First Name");
        l1.setBounds(20,120,90,30);
        l2=new JLabel("Last Name");
        l2.setBounds(20,200,90,30);
        l3=new JLabel("username");
        l3.setBounds(20,280,90,30);
        l4=new JLabel("password");
        l4.setBounds(20,360,90,30);
        l5=new JLabel("ReTypePassword");
        l5.setBounds(5,440,105,30);
        l6=new JLabel("click here to LogIn");
        l6.setBounds(5,550,120,25);
        b1=new JButton("SignUp");
        b1.setBounds(140,490,80,30);
        b2=new JButton("LogIn");
        b2.setBounds(130,550,70,20);
        String [] gender={"Gender","Male","Female"};
        cb1=new JComboBox(gender);
        cb1.setBounds(400,220,100,20);
        dob=new JLabel("DOB");
        dob.setBounds(400,260,70,30);
        dt=new JDateChooser();
        dt.setBounds(400,300,120,26);
        dt.setDateFormatString("yyyy-MM-dd");
        add(t1);add(t2);add(t3);add(t4);add(t5);
        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
        add(b1);add(b2);
        add(cb1);
        add(dt);add(dob);this.setTitle("Sign up");
        setLayout(null);
        setSize(600,650);
        setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "17MIS0008");
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                String da=df.format(dt.getDate());
                String gend=cb1.getSelectedItem().toString();
                String fi = t1.getText();
                String la = t2.getText();
                String uid = t3.getText();
                String pwrd = t4.getText();
                String sql = "INSERT INTO SIGNUP"
                        + "(FIRSTNAME , LASTNAME, USERNAME, PASSWORD,GENDER,DOB) VALUES"
                        + "(?,?,?,?,?,?)";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, fi);
                st.setString(2, la);
                st.setString(3, uid);
                st.setString(4, pwrd);
                st.setString(5, gend);
                st.setString(6, da);
                st.executeUpdate();
                conn.close();
                JOptionPane.showMessageDialog(null,"success");
                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                t5.setText(null);

            }
            catch (Exception a){System.out.println(a);}

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Travel();
                dispose();
            }
        });
    }


}
