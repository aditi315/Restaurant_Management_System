import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class OrderFirst extends JFrame implements ActionListener
{
	 JLabel title,sLLbl,cknBrgLbl,bfBrgLbl,chsPizzaLbl,pepPizzaLbl,swhLbl,smnLbl1,smnLbl2,cokeLbl,foodLbl,coffeeLbl,waterLbl,quantityLbl;
	 JButton logoutBtn,backBtn,orderBtn1,orderBtn2,orderBtn3,doneBtn,cancelBtn;
	 JPanel panel;
	 String userId;
	int tempcount=0;
	int c=0;
	
	int ckBQ, bfBQ, pepoPQ, chsPQ, sQ, ckQ, cfQ, wQ, smnQ1, smnQ2;
	
	public OrderFirst(String userId)
	{
		super("First Order");
		this.setSize(600, 600);
		this.userId=userId;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		ckBQ=orderQuantity();
		bfBQ=orderQuantity();
		pepoPQ=orderQuantity();
		chsPQ=orderQuantity();
		sQ=orderQuantity();
		ckQ=orderQuantity();
		cfQ=orderQuantity();
		wQ=orderQuantity();
		smnQ1=orderQuantity();
		smnQ2=orderQuantity();
		System.out.println(""+ckBQ);
		System.out.println(""+c);
		
		if(ckBQ==0 && bfBQ==0 && pepoPQ==0 && chsPQ==0 && sQ==0 && ckQ==0 &&cfQ==0 && wQ==0 && smnQ1==0 && smnQ2==0)
		{
			JOptionPane.showMessageDialog(this,"No order");
			new ViewOrder(userId).setVisible(true);
			this.setVisible(false);
		}
		else
		{
		
		foodLbl = new JLabel("Food");
		foodLbl.setBounds(120, 70, 150, 30);
		panel.add(foodLbl);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(270, 70, 150, 30);
		panel.add(quantityLbl);
		
		title = new JLabel("First Order Details");
		title.setBounds(250, 30, 150, 30);
		panel.add(title);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(450, 500, 120, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(450, 30, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		sLLbl = new JLabel("Sl no.");
		sLLbl.setBounds(50, 70, 150, 30);
		panel.add(sLLbl);
		
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
		
		
		quantityLbl = new JLabel(""+ckBQ);
		quantityLbl.setBounds(270, 100, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+bfBQ);
		quantityLbl.setBounds(270, 140, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+pepoPQ);
		quantityLbl.setBounds(270, 180, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+chsPQ);
		quantityLbl.setBounds(270, 220, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+sQ);
		quantityLbl.setBounds(270, 260, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+smnQ1);
		quantityLbl.setBounds(270, 300, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+smnQ2);
		quantityLbl.setBounds(270, 340, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+ckQ);
		quantityLbl.setBounds(270, 380, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+cfQ);
		quantityLbl.setBounds(270, 420, 150, 30);
		panel.add(quantityLbl);
		
		quantityLbl = new JLabel(""+wQ);
		quantityLbl.setBounds(270, 460, 150, 30);
		panel.add(quantityLbl);
		
		
		doneBtn= new JButton("Order Done");
		doneBtn.setBounds(150, 500, 150, 30);
		doneBtn.addActionListener(this);
		panel.add(doneBtn);
		
		
		/*cancelBtn= new JButton("Cancel Order");
		cancelBtn.setBounds(350, 500, 150, 30);
		cancelBtn.addActionListener(this);
		panel.add(cancelBtn);*/
		
		
		
		this.add(panel);
		this.setVisible(true);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			new ViewOrder(userId).setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(doneBtn.getText()))
		{
			orderDone();
			new ViewOrder(userId).setVisible(true);
			this.setVisible(false);
		}
		
	}
	
	public int orderQuantity()
	{
		int q=0;
				
		String query = "SELECT  `id`,`food`,`quantity`, `status` FROM `order food`;";     
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
				String nm= rs.getString("food");
				String s=rs.getString("status");
				int quantity=rs.getInt("quantity");
				int id=rs.getInt("id");
				System.out.println("database status: "+s);
				System.out.println("database food: "+nm);
				System.out.println("database quantity: "+quantity);
				if(s.equals("not done")&&nm.equals("Chicken Burger")&&id==1&&tempcount==0)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Beef Burger")&&id==1&&tempcount==1)
				{
					q=quantity;
					
					break;
				}
				else if(s.equals("not done")&&nm.equals("Peperoni Pizza")&&id==1&&tempcount==2)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Cheese Pizza")&&id==1&&tempcount==3)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Sandwich")&&id==1&&tempcount==4)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Set Menu 01")&&id==1&&tempcount==8)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Set Menu 02")&&id==1&&tempcount==9)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Coke")&&id==1&&tempcount==5)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Coffee")&&id==1&&tempcount==6)
				{
					q=quantity;
					break;
				}
				else if(s.equals("not done")&&nm.equals("Water")&&id==1&&tempcount==7)
				{
					q=quantity;
					
					break;
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
		tempcount++;
		return q;
	
	}
	
	
	public void orderDone()
	{
		String query = "SELECT  `id`,`food`,`quantity`,`price`,`total price`, `status`,`customerId` FROM `order food`;";     
		String query2;
		
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
					
			while(rs.next())
			{
                String nm= rs.getString("food");
				String s=rs.getString("status");
				double p=rs.getDouble("price");
				double tp=rs.getDouble("total price");
				String cstId=rs.getString("customerId");
				int quantity=rs.getInt("quantity");
				int id=rs.getInt("id");
				String s2="done";
				
				if(s.equals("not done")&&nm.equals("Chicken Burger")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Beef Burger")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Peperoni Pizza")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Cheese Pizza")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Sandwich")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Set Menu 01")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Set Menu 02")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Coke")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Coffee")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
				}
				else if(s.equals("not done")&&nm.equals("Water")&&id==1)
				{
					query2= "UPDATE `order food` SET `status`='done' WHERE `id`=1;";
					st.executeUpdate(query2);
					
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