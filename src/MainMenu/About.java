package MainMenu;
import javax.swing.*;
import java.awt.*;

class About extends JFrame
{
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,lb;
	JButton b1,b2,b3;

	About()
	{
		jf=new JFrame();

		jf.setLayout(null);

		l1 = new JLabel("STATIONARY STORE  MANAGEMENT  SYSTEM");
		l1.setFont(new Font("Algerian",Font.PLAIN,25));
		l1.setBounds(500,30,600,40);
		l1.setForeground(Color.orange);
		jf.add(l1);
		
        l2 = new JLabel("*  Stationary Store Management system is a general software for Stationary store.");
		l2.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l2.setBounds(30,80,1000,80);
		l2.setForeground(Color.white);
		jf.add(l2);

		l3 = new JLabel("*  This project is mainly designed for the Stationary Shopkepper.");
		l3.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l3.setBounds(30,120,1000,80);
		l3.setForeground(Color.white);
		jf.add(l3);

		l4 = new JLabel("*  In this system we can add details of Product, Suppliers.");
		l4.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l4.setBounds(30,160,1000,80);
		l4.setForeground(Color.white);
		jf.add(l4);

		l5 = new JLabel("*  We can also update, delete & search the existing details.");
		l5.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l5.setBounds(30,200,1000,80);
		l5.setForeground(Color.white);
		jf.add(l5);

		l6 = new JLabel("*  It is helpfull for stock of Product & where we placed the product in store.");
		l6.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l6.setBounds(30,240,1000,80);
		
		l6.setForeground(Color.white);
		jf.add(l6);

		l7 = new JLabel("*  Stationary Store Management Software is very needy for the Stationary Store");
		l7.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l7.setBounds(30,280,1000,80);
		l7.setForeground(Color.white);
		jf.add(l7);
		
		l8 = new JLabel("*  This software help them to maintain the day-to-day transactions in computer.");
		l8.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l8.setBounds(30,320,1000,80);
		l8.setForeground(Color.white);
		jf.add(l8);

		l9 = new JLabel("*  This is so designed as to ease the work load of shopkeeper.");
		l9.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l9.setBounds(30,360,1000,80);
		l9.setForeground(Color.white);
		jf.add(l9);
		
		l10 = new JLabel("*  It is suited for the stationary shops or stores of any size.");
		l10.setFont(new Font("Times New Roman",Font.PLAIN,30));
		l10.setBounds(30,400,1000,80);
		l10.setForeground(Color.white);
		jf.add(l10);
		
		
		l12 = new JLabel(new ImageIcon("image/image5.jpg"));
		l12.setBounds(0,0,1920,1020);
		jf.add(l12);
		
		l13 = new JLabel();
		l13.setBounds(450,120,600,150);
		jf.add(l13);
		
		l14 = new JLabel();
		l14.setBounds(30,400,379,300);
		jf.add(l14);
		
		lb=new JLabel();
		lb.setBounds(0,0,900,700);
		jf.add(lb);
		
        jf.setTitle("About System");
		jf.setSize(900,700);
		jf.setLocation(20,20);
		jf.setBounds(0,0,1920,1020);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);

	}

	public static void main(String args[])
	{
          new About();

	}
}


