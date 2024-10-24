package MainMenu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;


public class ProductList extends JFrame
 {
    JFrame jf=new JFrame();
    JLabel label, ln;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
 	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

  public ProductList()
  {
	  JLabel label=new JLabel();
		label.setIcon(new ImageIcon("image/image5.jpg"));
		//Dimension size=label.getPreferredSize();
		label.setBounds(0,0,1920,1020);
		
	  jf.setBounds(0,0,1920,1020);
    jf.setLayout(null);
  	ln = new JLabel("Stock  Of  Products");
    ln.setFont(new Font("Algerian",Font.PLAIN,25));
    ln.setForeground(Color.green);
    ln.setForeground(new java.awt.Color(0,102,102));
    ln.setBounds(500,70,350,25);
    jf.add(ln);

    scrlPane.setBounds(500,150,900,600);
    jf.add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));

    model.addColumn("Batchno");
    model.addColumn("Name");
    model.addColumn("Company");
    model.addColumn("Quantity");
  	model.addColumn("Expirydate");
  	model.addColumn("Purcahasedate");
  	model.addColumn("Type");
  	model.addColumn("Purchaseprice");
  	model.addColumn("Saleprice");
  	model.addColumn("Rackno");
  	model.addColumn("Supplierid");
  	model.addColumn("suppliername");
  		int r = 0;
     try
     {

     	Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from product order by p_no asc");
          while(rs.next())
            {
            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(10),rs.getString(3),rs.getString(5),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(12),rs.getString(11),rs.getString(8),rs.getString(9)});

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

     jf.add(label);
    jf.setTitle("Product List");
    jf.setSize(900,700);
	jf.setLocation(20,20);
	 jf.setBounds(0,0,1920,1020);
	jf.setResizable(false);
    jf.getContentPane().setBackground(new java.awt.Color(204, 102, 255));
    jf.setVisible(true);
  }


  public static void main(String args[])
    {
    	new ProductList();
    }
}

