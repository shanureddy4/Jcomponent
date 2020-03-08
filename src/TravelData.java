import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;



public class TravelData extends JFrame {
    JTable tabl1;
    JButton b1;
    JButton b2;
    public static int fare=0;
    public static String fi1;
    public static String fi4;
    public static String fi5;
    public static String fi6;
    public static String fi3;
    public static String fi2;

  public  TravelData()

  { b1=new JButton("proceed");
  b1.setBounds(20,400,70,30);
  b2=new JButton("Back");
  b2.setBounds(50,400,70,30);
      this.setTitle("View");
  b2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          new Slct();
          dispose();
      }
  });

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "17MIS0008");
            String sql="select * from TRAVELDATA " +
            "where FROM1 = '" + Slct.fr.getText()+ "'" +
                    " and TO1 = '" + Slct.to.getText() + "'";
            //String sql3=("select From1  from TRAVELDATA");
            String sql2=("select count(*) as rowcount from TRAVELDATA");
            System.out.println(Slct.fr.getText()+Slct.fr.getText().length());
            PreparedStatement state1=conn.prepareStatement(sql2);
            PreparedStatement state=conn.prepareStatement(sql);
            //PreparedStatement state2=conn.prepareStatement(sql3);
            ResultSet rs=state.executeQuery();
            ResultSet rs2=state1.executeQuery();
           // ResultSet rs3=state2.executeQuery();
            //testing
           /* while(rs3.next())
            {

                //System.out.println();
            }*/
            rs2.next();
            int rowcount=rs2.getInt("rowcount");
            rs2.close();
            ResultSetMetaData rsmd=rs.getMetaData();
            String data[] []=new String[rowcount][6];
            int i=0;
            while(rs.next())
            {
               // System.out.println(rs.getString(1)+rs.getString(2));
                rs.getString(1);
                data [i] [2]=rs.getString(1);
                data [i] [3]=rs.getString(2);
                data [i] [4]=rs.getString(3);
                data [i] [5]=rs.getString(4);
                data [i] [0]=rs.getString("FROM1");
                data [i] [1]=rs.getString("TO1");
                i++;
            }

            setLayout(new FlowLayout());
            String coloumn[] = {"from", "to", "travel", "time","seats","price"};
            tabl1 = new JTable(data, coloumn);
            JScrollPane scroll = new JScrollPane(tabl1);

            ListSelectionModel model=tabl1.getSelectionModel();
            model.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {

                   try{
                       if(!model.isSelectionEmpty()) {
                       int selectedRow = model.getMaxSelectionIndex();//getMinSelectionIndex();
                       TableModel model = tabl1.getModel();
                       fi1 = (model.getValueAt(selectedRow, 2)).toString();
                       fi2 = (model.getValueAt(selectedRow, 1)).toString();
                       fi3 = (model.getValueAt(selectedRow, 0)).toString();
                       fi4 = (model.getValueAt(selectedRow, 5)).toString();
                       fi5 = (model.getValueAt(selectedRow, 4)).toString();
                       fi6 = (model.getValueAt(selectedRow, 3)).toString();
                       System.out.println(fi1 + " " + fi2 + " " + fi3 + " " + " " + fi4);
                       fare = Integer.parseInt(fi4);
                       JOptionPane.showMessageDialog(null, "continue with " + fi1 + " Travels?");

                       b1.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {

                               new Payment();
                               dispose();

                           }
                       });
                   }
                   }catch(NullPointerException ex) {
                       JOptionPane.showMessageDialog(null,"sorry for blank table it seems no data available");

                        // JOptionPane.showMessageDialog(null,fi1);
                    }

                }
            });



            add(scroll);add(b1);add(b2);
            setSize(500, 500);
            setVisible(true);
            System.out.println("fare "+fare);


        }catch (NullPointerException x){
            System.out.println("sorry");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


}
