import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paymentResi extends JFrame{
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    public static JLabel l6;
    JLabel l7;
    JLabel l8;
    public static JLabel l9;
    JButton b1;
    JButton b2;
    paymentResi()
    {
        l1=new JLabel("This is just booking confirmation.");
        l1.setBounds(10,20,300,30);
        l2=new JLabel("Right now we do not accept Online payment please pay charge at selected vilas.");
        l2.setBounds(10,40,500,30);
        l3=new JLabel("sorry for inconvenience");
        l3.setBounds(10,60,250,30);
        l4=new JLabel("Room price=");
        l4.setBounds(50,100,80,30);
        l5=new JLabel("Handling fee=");
        l5.setBounds(50,150,80,30);
        l6=new JLabel("Total =");
        l6.setBounds(50,200,80,30);
        l7=new JLabel(String.valueOf(Residencydata.fare));
        l7.setBounds(200,100,80,30);
        l8=new JLabel("150");
        l8.setBounds(200,150,80,30);
        l9=new JLabel(String.valueOf((Residencydata.fare+150)));
        l9.setBounds(200,200,80,30);
        b1=new JButton("Book");
        b1.setBounds(100,300,80,30);
        b2=new JButton("Cancel");
        b2.setBounds(250,300,80,30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new resiconfirm();
                Report2 rep=new Report2();
                rep.sendMail();

                dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Residencydata();
                dispose();
            }
        });
        this.setTitle("Payment");
        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(b1);add(b2);
        setSize(500,500);
        setLayout(null);
        setVisible(true);

    }
}
