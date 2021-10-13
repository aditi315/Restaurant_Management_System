import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerOrder extends JFrame implements ActionListener
{
		JLabel cknBrgLbl,bfBrgLbl,chsPizzaLbl,pepPizzaLbl,swhLbl,smnLbl1,smnLbl2,cokeLbl,coffeeLbl,waterLbl,titleLbl,sLLbl,totalLbl,foodLbl,priceLblt,quantityLbl;
	 JTextField quantityLb1,quantityLb2,quantityLb3,quantityLb4,quantityLb5,quantityLb6,quantityLb7,quantityLb8,quantityLb9,quantityLbl0;
	 JTextField priceLb1,priceLb2,priceLb3,priceLb4,priceLb5,priceLb6,priceLb7,priceLb8,priceLb9,priceLbl0,priceLb;
	 JPanel panel;
	JButton backBtn,logoutBtn;
	 String userId;
	 double temp=0;

	public CustomerOrder(String userId)
	{
		
		super("Restaurant Management System - Customer Order");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.userId=userId;
		
		panel =new JPanel();
		panel.setLayout(null);
		
		titleLbl = new JLabel("Order Details");
		titleLbl.setBounds(250, 30, 150, 30);
		panel.add(titleLbl);
		
		sLLbl = new JLabel("Sl no.");
		sLLbl.setBounds(50, 70, 150, 30);
		panel.add(sLLbl);
		
		foodLbl = new JLabel("Food");
		foodLbl.setBounds(120, 70, 150, 30);
		panel.add(foodLbl);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(270, 70, 150, 30);
		panel.add(quantityLbl);
		
		
		priceLblt = new JLabel("Price");
		priceLblt.setBounds(450, 70, 150, 30);
		panel.add(priceLblt);
		
		sLLbl = new JLabel("1.");
		sLLbl.setBounds(57, 100, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("2.");
		sLLbl.setBounds(57, 140, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("3.");
		sLLbl.setBounds(57, 180, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("4.");
		sLLbl.setBounds(57, 220, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("5.");
		sLLbl.setBounds(57, 260, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("6.");
		sLLbl.setBounds(57, 300, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("7.");
		sLLbl.setBounds(57, 340, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("8.");
		sLLbl.setBounds(57, 380, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("9.");
		sLLbl.setBounds(57, 420, 150, 30);
		panel.add(sLLbl);
		
		sLLbl = new JLabel("10.");
		sLLbl.setBounds(57, 460, 150, 30);
		panel.add(sLLbl);
		
			logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(50, 30, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		cknBrgLbl = new JLabel("Chicken Burger");
		cknBrgLbl.setBounds(120, 100, 150, 30);
		panel.add(cknBrgLbl);
		
		bfBrgLbl = new JLabel("Beef Burger");
		bfBrgLbl.setBounds(120, 140, 150, 30);
		panel.add(bfBrgLbl);
		
		pepPizzaLbl = new JLabel("Peperoni Pizza");
		pepPizzaLbl.setBounds(120, 180, 150, 30);
		panel.add(pepPizzaLbl);
		
		chsPizzaLbl = new JLabel("Cheese Pizza");
		chsPizzaLbl.setBounds(120, 220, 150, 30);
		panel.add(chsPizzaLbl);
		
		swhLbl = new JLabel("Sandwich");
		swhLbl.setBounds(120, 260, 150, 30);
		panel.add(swhLbl);
		
		smnLbl1 = new JLabel("Set Menu 1");
		smnLbl1.setBounds(120, 300, 150, 30);
		panel.add(smnLbl1);
		
		smnLbl2 = new JLabel("Set Menu 2");
		smnLbl2.setBounds(120, 340, 150, 30);
		panel.add(smnLbl2);
		
		cokeLbl = new JLabel("Coke");
		cokeLbl.setBounds(120, 380, 150, 30);
		panel.add(cokeLbl);
		
		coffeeLbl = new JLabel("Coffee");
		coffeeLbl.setBounds(120, 420, 150, 30);
		panel.add(coffeeLbl);
		
		waterLbl = new JLabel("Water");
		waterLbl.setBounds(120, 460, 150, 30);
		panel.add(waterLbl);
		
		
		
		
		
		
		quantityLb1 = new JTextField("0");
		quantityLb1.setBounds(270, 100, 80, 30);
		quantityLb1.setEnabled(false);
		panel.add(quantityLb1);
		
		quantityLb2 = new JTextField("0");
		quantityLb2.setBounds(270, 140, 80, 30);
		quantityLb2.setEnabled(false);
		panel.add(quantityLb2);
		
		quantityLb3 = new JTextField("0");
		quantityLb3.setBounds(270, 180, 80, 30);
		quantityLb3.setEnabled(false);
		panel.add(quantityLb3);
		
		quantityLb4 = new JTextField("0");
		quantityLb4.setBounds(270, 220, 80, 30);
		quantityLb4.setEnabled(false);
		panel.add(quantityLb4);
		
		quantityLb5 = new JTextField("0");
		quantityLb5.setBounds(270, 260, 80, 30);
		quantityLb5.setEnabled(false);
		panel.add(quantityLb5);
		
		quantityLb6 = new JTextField("0");
		quantityLb6.setBounds(270, 300, 80, 30);
		quantityLb6.setEnabled(false);
		panel.add(quantityLb6);
		
		quantityLb7 = new JTextField("0");
		quantityLb7.setBounds(270, 340, 80, 30);
		quantityLb7.setEnabled(false);
		panel.add(quantityLb7);
		
		quantityLb8 = new JTextField("0");
		quantityLb8.setBounds(270, 380, 80, 30);
		quantityLb8.setEnabled(false);
		panel.add(quantityLb8);
		
		quantityLb9 = new JTextField("0");
		quantityLb9.setBounds(270, 420, 80, 30);
		quantityLb9.setEnabled(false);
		panel.add(quantityLb9);
		
		quantityLbl0 = new JTextField("0");
		quantityLbl0.setBounds(270, 460, 80, 30);
		quantityLbl0.setEnabled(false);
		panel.add(quantityLbl0);
		
		
		
		
		priceLb1 = new JTextField("0");
		priceLb1.setBounds(450, 100, 80, 30);
		priceLb1.setEnabled(false);
		panel.add(priceLb1);
		
		priceLb2 = new JTextField("0");
		priceLb2.setBounds(450, 140, 80, 30);
		priceLb2.setEnabled(false);
		panel.add(priceLb2);
		
		priceLb3 = new JTextField("0");
		priceLb3.setBounds(450, 180, 80, 30);
		priceLb3.setEnabled(false);
		panel.add(priceLb3);
		
		priceLb4 = new JTextField("0");
		priceLb4.setBounds(450, 220, 80, 30);
		priceLb4.setEnabled(false);
		panel.add(priceLb4);
		
		priceLb5 = new JTextField("0");
		priceLb5.setBounds(450, 260, 80, 30);
		priceLb5.setEnabled(false);
		panel.add(priceLb5);
		
		priceLb6 = new JTextField("0");
		priceLb6.setBounds(450, 300, 80, 30);
		priceLb6.setEnabled(false);
		panel.add(priceLb6);
		
		priceLb7 = new JTextField("0");
		priceLb7.setBounds(450, 340, 80, 30);
		priceLb7.setEnabled(false);
		panel.add(priceLb7);
		
		priceLb8 = new JTextField("0");
		priceLb8.setBounds(450, 380, 80, 30);
		priceLb8.setEnabled(false);
		panel.add(priceLb8);
		
		priceLb9 = new JTextField("0");
		priceLb9.setBounds(450, 420, 80, 30);
		priceLb9.setEnabled(false);
		panel.add(priceLb9);
		
		priceLbl0 = new JTextField("0");
		priceLbl0.setBounds(450, 460, 80, 30);
		priceLbl0.setEnabled(false);
		panel.add(priceLbl0);
		
		
		priceLb = new JTextField("Tk "+"0");
		priceLb.setBounds(450, 500, 80, 30);
		priceLb.setEnabled(false);
		panel.add(priceLb);
		
		
		
		totalLbl = new JLabel("Total Cost:");
		totalLbl.setBounds(350, 500, 150, 30);
		panel.add(totalLbl);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(450, 30, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
	
		
	
	this.add(panel);
	this.setVisible(true);
	
	viewOrder(userId);	
	
		priceLb = new JTextField("Tk "+temp);
		priceLb.setBounds(450, 500, 80, 30);
		priceLb.setEnabled(false);
		panel.add(priceLb);
		
	}
public void actionPerformed(ActionEvent ae)
{
	String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			new CustomerHome(userId).setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
}
	
	public void viewOrder(String userId)
	{
		int cb;
		double chb;
		String fname;
		
		
		String query = "SELECT `food`, `quantity`, `price`, `total price`, `customerId`, `status` FROM `order food`;";      
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;
			
			while(rs.next())
				{
					String u= rs.getString("customerId");
					String v=rs.getString("status");
				
					if(u.equals(this.userId)&& v.equals("not done"))
					{
						fname=rs.getString("food");
						cb=rs.getInt("quantity");
						chb=rs.getDouble("price");
						double total=rs.getDouble("total price");
						flag=true;
						
						if(fname.equals("Chicken Burger"))
						{
							quantityLb1.setText(""+cb);
						
							priceLb1.setText(""+chb);
							
						}
						
						if(fname.equals("Beef Burger"))
						{
							quantityLb2.setText(""+cb);
						
							priceLb2.setText(""+chb);
							
						}
						
						if(fname.equals("Peperoni Pizza"))
						{
							quantityLb3.setText(""+cb);
						
							priceLb3.setText(""+chb);
							
						}
						
						if(fname.equals("Cheese Pizza"))
						{
							quantityLb4.setText(""+cb);
						
							priceLb4.setText(""+chb);
							
						}
						
						if(fname.equals("Coke"))
						{
							quantityLb8.setText(""+cb);
						
							priceLb8.setText(""+chb);
						}
						
						if(fname.equals("Coffee"))
						{
							quantityLb9.setText(""+cb);
						
							priceLb9.setText(""+chb);
							
						}
						
						if(fname.equals("Water"))
						{
							quantityLbl0.setText(""+cb);
						
							priceLbl0.setText(""+chb);
							
						}
						
						if(fname.equals("Sandwich"))
						{
							quantityLb5.setText(""+cb);
						
							priceLb5.setText(""+chb);
							
						}
						
						if(fname.equals("Set Menu 1"))
						{
							quantityLb6.setText(""+cb);
						
							priceLb6.setText(""+chb);
							
						}
						
						if(fname.equals("Set Menu 2"))
						{
							quantityLb7.setText(""+cb);
						
							priceLb7.setText(""+chb);
							
						}
							temp=total;

					}
					
				}
				 
		}
				catch(Exception ex)
					{
						System.out.println("Exception : " +ex.getMessage());
					}
				finally
				{
					try
				{
					if(rs!=null)
						rs.close();

					if(st!=null)
						st.close();

					if(con!=null)
						con.close();
				}
				catch(Exception ex){}
				}
	}
}