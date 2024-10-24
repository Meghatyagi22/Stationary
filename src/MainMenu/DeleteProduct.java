package MainMenu;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class DeleteProduct extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	JLabel label, l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ln,lb;
    JButton b0,b1,b2,b3;
	Font f;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	DeleteProduct()
	{
		 JLabel label=new JLabel();
			label.setIcon(new ImageIcon("image/image2.jpg"));
			//Dimension size=label.getPreferredSize();
			label.setBounds(0,0,1920,1020);
		jf=new JFrame();
		f = new Font("Times New Roman",Font.PLAIN,20);
		jf.setLayout(null);

	    ln=new JLabel(" Delete  Product ");
	    ln.setFont(new Font("Algerian",Font.PLAIN,25));
	   
	    ln.setBounds(500,30,300,40);
	    jf.add(ln);

		l1 = new JLabel("Product Batch no* :");
		l1.setFont(f);
		
        l1.setBounds(500,100,200,25);
		jf.add(l1);

		t1 = new JTextField(20);
		t1.setBounds(700,100,100,25);
		t1.setToolTipText("Enter product batch no to delete medicine");
		jf.add(t1);

		l2 = new JLabel("Product name* :");
		l2.setFont(f);
        l2.setBounds(500,140,200,25);
       
		jf.add(l2);

    	t2 = new JTextField(20);
		t2.setBounds(700,140,200,25);
		t2.setToolTipText("Enter Product name to delete product");
		jf.add(t2);

		l3 = new JLabel("Product company :");
		l3.setFont(f);
        l3.setBounds(500,180,200,25);
       
		jf.add(l3);

     	t3 = new JTextField(20);
		t3.setBounds(700,180,200,25);
		jf.add(t3);

		l4 = new JLabel("Product quantity :");
		l4.setFont(f);
        l4.setBounds(500,220,200,25);
      
    	jf.add(l4);

        t4= new JTextField(20);
		t4.setBounds(700,220,100,25);
		jf.add(t4);

		l5= new JLabel("Product expiry date :");
		l5.setFont(f);
        l5.setBounds(500,260,250,25);
       
		jf.add(l5);

	    t5= new JTextField(20);
		t5.setBounds(700,260,100,25);
		jf.add(t5);

		l6= new JLabel("Product purchase date :");
		l6.setFont(f);
        l6.setBounds(500,300,250,25);
      
    	jf.add(l6);

        t6= new JTextField(20);
		t6.setBounds(700,300,100,25);
		jf.add(t6);

		l7 = new JLabel("Product type :");
		l7.setFont(f);
        l7.setBounds(900,100,200,25);
       
    	jf.add(l7);

        t7 = new JTextField(20);
		t7.setBounds(1100,100,100,25);
		jf.add(t7);

		l8= new JLabel("Product purchase price :");
		l8.setFont(f);
        l8.setBounds(900,140,220,25);
      
    	jf.add(l8);

        t8 = new JTextField(20);
		t8.setBounds(1100,140,100,25);
		jf.add(t8);

		l9 = new JLabel("Product sale price :");
		l9.setFont(f);
        l9.setBounds(900,180,200,25);
      
    	jf.add(l9);

        t9 = new JTextField(20);
		t9.setBounds(1100,180,100,25);
		jf.add(t9);

		l10 = new JLabel("Product rack no :");
		l10.setFont(f);
  	    l10.setBounds(900,220,200,25);
  	   
    	jf.add(l10);

        t10 = new JTextField(20);
		t10.setBounds(1100,220,100,25);
		jf.add(t10);

		l11 = new JLabel("Supplier name :");
		l11.setFont(f);
        l11.setBounds(900,260,180,25);
   
    	jf.add(l11);

        t11 = new JTextField(20);
	   	t11.setBounds(1100,260,100,25);
	   	jf.add(t11);

	   	l12 = new JLabel("Supplier id :");
		l12.setFont(f);
        l12.setBounds(900,300,180,25);
     
    	jf.add(l12);

    	t12 = new JTextField(20);
	    t12.setBounds(1100,300,100,25);
	    jf.add(t12);
        
        b0 = new JButton("Open");
        b0.setBounds(500,330,110,35);b0.setToolTipText("click to open product details");
		jf.add(b0);b0.addActionListener(this);

		b1 = new JButton("Delete");
		b1.setBounds(700,330,110,35);b1.setToolTipText("click to delete product details");
	    jf.add(b1); b1.addActionListener(this);

        b2= new JButton("Clear");
		b2.setBounds(900,330,110,35);b2.setToolTipText("click to clear all textfields");
		jf.add(b2); b2.addActionListener(this);

    	b3 = new JButton("All");//if button is press then record display repeat
		b3.setBounds(1100,330,110,35);b3.setToolTipText("click to view all product details");
		jf.add(b3); b3.addActionListener(this);

	    scrlPane.setBounds(500,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("p_NO");
        model.addColumn("p_NAME");
        model.addColumn("p_COMPANY");
        model.addColumn("p_QUANTITY");
        model.addColumn("p_EXPDATE");
        model.addColumn("p_PURDATE");
        model.addColumn("p_TYPE");
        model.addColumn("p_SALEPRICE");
        model.addColumn("p_PURPRICE");
        model.addColumn("p_RACKNO");
        model.addColumn("p_SID");
        model.addColumn("p_SNAME");
         
        lb = new JLabel();
		lb.setBounds(0,0,900,700);
		jf.add(lb);
		jf.add(label);
	     jf.setTitle("Delete product ");
	     jf.setSize(900,700);
		 jf.setLocation(20,20);
		 jf.setBounds(0,0,1920,1020);
		 jf.setResizable(false);
		 jf.getContentPane().setBackground(Color.white);
	     jf.setVisible(true);
 }

public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b0)
	  {
	  	try
	  	{
	  	 if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Please enter product p_no or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {
	         int foundrec = 0;

	    Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");

		  ps=con.prepareStatement("select * from product where p_name='"+ t2.getText()+"' or p_no='"+t1.getText()+"'");
		  rs=ps.executeQuery();
		  while(rs.next())
	      {
		    t1.setText(rs.getString(1));
	        t2.setText(rs.getString(2));
	        t3.setText(rs.getString(3));
	        t4.setText(rs.getString(4));
		    t5.setText(rs.getString(5));
		    t6.setText(rs.getString(6));
	        t7.setText(rs.getString(7));
	        t8.setText(rs.getString(8));
	        t9.setText(rs.getString(9));
		    t10.setText(rs.getString(10));
		    t12.setText(rs.getString(11));
		    t11.setText(rs.getString(12));
		     foundrec = 1;
	       }
	        if (foundrec == 0)
                {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }
	         }
	         con.close();
        }
      catch(SQLException se)
		{
	      System.out.println(se);
	     JOptionPane.showMessageDialog(null,"SQL Error."+se);
        }
	    catch(Exception e)
	     {
	     System.out.println(e);
		 JOptionPane.showMessageDialog(null,"Error."+e);
	     }
    }
  else if(ae.getSource()==b1)
	 {//delete
	 	if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
	     {
		  JOptionPane.showMessageDialog(this,"Please enter product batchno or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	      }
	      else
	      {
	      try
	       {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");
	    ps=con.prepareStatement("delete from product where p_no='"+t1.getText()+"' or p_name='"+t2.getText()+"'");
	    ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Record is deleted.");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
         con.close();
       }
        catch(SQLException se)
		{
		System.out.println(se);
	     JOptionPane.showMessageDialog(null,"SQL Error:"+se);
        }
	    catch(Exception e)
	     {
	     System.out.println(e);
		 JOptionPane.showMessageDialog(null,"Error:"+e);
	     }
     }
  }

        else if(ae.getSource()==b2)
           {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
			    t7.setText("");
			    t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
            }
   else if(ae.getSource()==b3)
    {//list
  	int r = 0;
     try
     {
         Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * from product order by p_no asc" );
          while(rs.next())
            {
model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(10),rs.getString(3),rs.getString(5),rs.getString(4),rs.getString(6),rs.getString(12),rs.getString(7),rs.getString(11),rs.getString(8),rs.getString(9) });
            }
             con.close();
       }
      catch(SQLException se)
       {
        System.out.println(se);
         JOptionPane.showMessageDialog(null,"SQL Error:"+se);
       }
      catch(Exception e)
       {
       	  System.out.println(e);
          JOptionPane.showMessageDialog(null,"Error:"+e);
       }
  	}
  }

 public static void main(String args[])
	{
	  new DeleteProduct();
	}
}



