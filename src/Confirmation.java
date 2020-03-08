import javax.mail.Message;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.text.MessageFormat;
import java.util.Random;

public class Confirmation extends JFrame  {

JLabel from;
    JLabel to;
    JLabel tkt;
    JLabel doj;
    JLabel travels;
    JLabel amount;
    JLabel deplace;
    JLabel from2;
    JLabel to2;
    public static JLabel tkt2;
    JLabel doj2;
    JLabel travels2;
    JLabel amount2;
    JLabel deplace2;
    Random r;
    JButton Exit;
    JButton print;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    Confirmation()
    {
        r=new Random();
        int low = 3500;
        int high = 5200;
        int re = r.nextInt(high-low) + low;
        String result=re+"";
        tkt=new JLabel("Tkt number:");
        tkt.setFont(tkt.getFont().deriveFont(Font.BOLD, 25f));
        tkt.setBounds(10,20,500,30);
        tkt2=new JLabel(result);
        tkt2.setFont(tkt.getFont().deriveFont(Font.BOLD, 16f));
        tkt2.setBounds(180,20,500,30);
        from=new JLabel("From:");
        from.setFont(from.getFont().deriveFont(Font.BOLD, 16f));
        from.setBounds(10,100,200,30);
        from2=new JLabel(TravelData.fi3);
        from2.setBounds(100,100,200,30);
        to=new JLabel("To:");
        to.setFont(to.getFont().deriveFont(Font.BOLD, 16f));
        to.setBounds(250,100,200,30);
        to2=new JLabel(TravelData.fi2);
        to2.setBounds(340,100,200,30);
        doj=new JLabel("Date:");
        doj.setFont(doj.getFont().deriveFont(Font.BOLD, 16f));
        doj.setBounds(10,150,200,30);
        doj2=new JLabel(Slct.x);
        doj2.setBounds(100,150,200,30);
        travels=new JLabel("Travels:");
        travels.setFont(travels.getFont().deriveFont(Font.BOLD, 16f));
        travels.setBounds(250,150,200,30);
        travels2=new JLabel(TravelData.fi1);
        travels2.setBounds(340,150,200,30);
        amount=new JLabel("Amount:");
        amount.setFont(amount.getFont().deriveFont(Font.BOLD, 16f));
        amount.setBounds(10,200,200,30);
        amount2=new JLabel(Payment.l9.getText());
        amount2.setBounds(100,200,200,30);
        deplace=new JLabel("Departure Place:");
        deplace.setFont(deplace.getFont().deriveFont(Font.BOLD, 16f));
        deplace.setBounds(250,200,500,30);
        deplace2=new JLabel(TravelData.fi3+" Bustand");
        deplace2.setBounds(380,200,500,30);
        l1=new JLabel("*we sent the same information to your mail please check email");
        l1.setBounds(10,300,500,30);
        l1.setForeground(Color.GREEN);
        l2=new JLabel("*Please carry tkt either mail or by hand");
        l2.setBounds(10,335,500,30);
        l2.setForeground(Color.blue);
        l3=new JLabel("*3 rest stops ");
        l3.setBounds(10,370,400,30);
        l3.setForeground(Color.lightGray);
        l4=new JLabel("*Be aware of thieves");
        l4.setBounds(10,405,300,30);
        l4.setForeground(Color.red);
        Exit=new JButton("Exit");
        Exit.setBounds(100,500,70,30);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
       // print=new JButton("Print");
        //print.setBounds(200,500,70,30);
        this.setTitle("Confirmation");
       //add(print);
       add(from);add(to);add(tkt);add(doj);add(travels);add(amount);add(deplace);add(doj2);add(tkt2);add(travels2);add(amount2);add(from2);add(to2);add(deplace2);
       add(l1);add(l2);add(l3);add(l4);add(Exit);
       setSize(600,600);
        setLayout(null);
        setVisible(true);

    }





}
