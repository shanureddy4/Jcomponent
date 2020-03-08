import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class Travel extends JFrame  {

    JLabel we;
    JLabel LI;
    JLabel US;
    JLabel PW;
    JLabel click;
    JButton Login;
    JButton NEW;
    public static String s1;
   public static  JTextField UT;
    public static JPasswordField UP;

Travel()
{

    we=new JLabel("Welcome To Travel Plan");
    we.setBounds(130,10,200,35);
    LI=new JLabel("LogIn");
    LI.setBounds(150,60,50,50);
    US=new JLabel("User Name");
    US.setBounds(90,100,75,35);
    PW=new JLabel("Password");
    PW.setBounds(90,130,75,35);
    click=new JLabel("new user ?");
    click.setBounds(70,200,150,35);
    Login=new JButton("Login");
    Login.setBounds(180,170,75,26);
    NEW=new JButton("ClickHere");
    NEW.setBounds(140,208,100,20);
    UT=new JTextField();
    UT.setBounds(160,110,150,20);
    UP=new JPasswordField();
    UP.setBounds(160,140,150,20);
    this.setTitle("Log in");
add(we);add(LI);add(US);add(PW);add(click);add(Login);add(NEW);add(UT);add(UP);
setSize(500,400);
setLayout(null);
    setVisible(true);
    Login.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            s1=UT.getText();
            String s2=UP.getText();
            if((UT.getText().length())<30)
            {
            int b=30-(UT.getText().length());
            for(int i=0;i<b;i++)
            { s1=s1+" "; }
            }
            if((UP.getText().length())<15)
            {
                int c=15-(UP.getText().length());
                for(int k=0;k<c;k++)
                { s2=s2+" "; }
            }
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","17MIS0008");
                //String sql="SELECT USERNAME, PASSWORD FROM SIGNUP " +
                       // " WHERE USERNAME=(s1)";
                String sql= "select USERNAME,PASSWORD from SIGNUP " +
                        "where username = '" + Travel.UT.getText() + "'" +
                        " and password = '" + Travel.UP.getText() + "'";
                // ("select username,password from SIGNUP where username ='" + Travel.UT.getText() + "'");
                PreparedStatement state=conn.prepareStatement(sql);
                ResultSet rs=state.executeQuery();
                String user=null;
                String pass=null;
                while(rs.next())
                {
                    user=rs.getString("USERNAME");
                    pass=rs.getString("PASSWORD");
                }
                System.out.println(s1+s2+user+pass);
                rs.close();
                if((user.equalsIgnoreCase(s1)) && (pass.equalsIgnoreCase(s2)))
                {
                    new Slct();
                    dispose();
                    JOptionPane.showMessageDialog(null,"Success");
                    System.out.println("success");

                }


            }
            catch(NullPointerException a){JOptionPane.showMessageDialog(null,"Please check your credentials");}
            catch (Exception a){System.out.println(a);}



        }

    });
    NEW.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           new SignUp();
            dispose();
        }
    });

}

    public static void main(String[] args) {


        new Travel();
    }
}
