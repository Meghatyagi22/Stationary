package MainMenu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class SupplierWiseProductReport extends JFrame implements ActionListener
 {
    JFrame jf;
    JButton submit,clear;
    JLabel l1,ln;
    JTextField t1;
    Font f;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
 	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

  public SupplierWiseProductReport()
  {
   jf=new JFrame();
   f = new Font("Times New Roman",Font.PLAIN,20);
   jf.setLayout(null);

  	ln = new JLabel("SUPPLIER WISE Product REPORT");
    ln.setFont(new Font("Algerian",Font.PLAIN,25));
    ln.setForeground(new java.awt.Color(204,51,0));
    ln.setBounds(500,70,400,30);
    jf.add(ln);

    l1 = new JLabel("Enter Supplier name:");
    l1.setFont(f);
    l1.setBounds(500,130,250,25);
    jf.add(l1);

    t1=new JTextField(10);
    t1.setBounds(700,130,200,25);t1.setToolTipText("Enter supplier name");
    jf.add(t1);



    submit = new JButton("Submit",new ImageIcon("images//open.png"));
    submit.setBounds(500,190,110,35); submit.setToolTipText("click to open supplier wise medicine report");
    jf.add(submit);submit.addActionListener(this);

    clear = new JButton("Clear",new ImageIcon("images//clear.png"));
    clear.setBounds(700,190,110,35);clear.setToolTipText("click to clear textfield");
    jf.add(clear);clear.addActionListener(this);

    scrlPane.setBounds(500,260,900,600);
    jf.add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("P_BNO");
        model.addColumn("P_NAME");
        model.addColumn("P_COMPANY");
        model.addColumn("P_QUANTITY");
        model.addColumn("P_EXPDATE");
        model.addColumn("P_PURDATE");
        model.addColumn("P_TYPE");
        model.addColumn("P_PURPRICE");
        model.addColumn("P_SALEPRICE");
        model.addColumn("P_RACKNO");
        model.addColumn("P_SID");
        model.addColumn("P_SNAME");


    jf.setTitle("Supplier Wise Product Report");
    jf.setSize(900,700);
	jf.setLocation(20,20);
	jf.setBounds(0,0,1920,1020);
	jf.setResizable(false);
    jf.getContentPane().setBackground(new java.awt.Color(255,153,153));
    jf.setVisible(true);
  }

  	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==submit)
	 {//list
  	int r = 0;
     try
     {
     		if(((t1.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"Please supplier name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else
	        {
	         int foundrec = 0;
     	Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT p_no,p_name,p_company,p_quantity,p_expdate,p_purdate,p_type,p_purprice,p_saleprice,p_rackno,p_sid,p_sname from product where p_sname='"+t1.getText()+"' ");
          while(rs.next())
            {
  model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});
              foundrec = 1;
            }
              if (foundrec == 0)
                {
                    JOptionPane.showMessageDialog(null,"Not any product provide by given supplier","Dialog",JOptionPane.WARNING_MESSAGE);
                }
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

	 else if(ae.getSource()==clear)
	 {
	 	t1.setText("");
	 }
    }

  public static void main(String args[])
    {
    	new SupplierWiseProductReport();
    }
}


