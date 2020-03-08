import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Slct extends JFrame {
    JLabel l1;
    JButton b1;
    JButton b2;
    JButton b3;
    public static JTextField fr;
    public static JTextField to;
   public static JTextField fr2;
    public static JTextField stars;
    JButton b4;
    JButton Exit;
    JDateChooser data;
public static String y;
    public static String z;
    public static  String x;

    Slct()
    {
        l1=new JLabel("Looking for?");
        l1.setBounds(20,50,550,35);
        l1.setFont(l1.getFont().deriveFont(Font.BOLD, 30f));
        b1=new JButton("TRAVEL");
        b1.setBounds(50,100,100,30);
        b2=new JButton("RESIDENCY");
        b2.setBounds(50,230,120,30);
        Exit=new JButton("Exit");
        Exit.setBounds(150,415,80,30);
        add(l1);add(b2);add(b1);add(Exit);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        this.setTitle("Choose");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr=new JTextField("from");
                fr.setBounds(20,150,120,26);
                to=new JTextField("to");
                to.setBounds(200,150,120,26);
                data=new JDateChooser();
                data.setBounds(350,150,120,26);
                data.setDateFormatString("yyyy-MM-dd");

                b3=new JButton("SEARCH");
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new TravelData();
                        dispose();
                        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                        x=df.format(data.getDate());

                    }
                });
                b3.setVisible(true);
                b3.setBounds(250,200,85,25);
                add(fr);add(to);
                add(b3);add(data);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr2=new JTextField("Visiting place");
                fr2.setBounds(20,290,120,26);

                JDateChooser rdate=new JDateChooser();
                rdate.setBounds(200,290,120,26);
                rdate.setDateFormatString("yyyy-MM-dd");
                stars=new JTextField("no.of people");
                stars.setBounds(350,290,80,26);
                JLabel dto=new JLabel("Date to");
                dto.setBounds(200,320,50,20);
                JDateChooser rdate2=new JDateChooser();
                rdate2.setBounds(200,340,120,26);
                rdate2.setDateFormatString("yyyy-MM-dd");
                b4=new JButton("SEARCH");
                b4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
                        y=df2.format(rdate.getDate());
                        z=df2.format(rdate2.getDate());
                        new Residencydata();
                        dispose();

                    }
                });
                b4.setBounds(250,380,85,25);

                add(fr2);add(stars);add(b4);add(rdate);add(rdate2);add(dto);

            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }



}
