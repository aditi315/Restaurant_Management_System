import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TakeOrder extends JFrame implements ActionListener
{
	private JLabel odrLbl, foodLbl, drinkLbl,quantityLbl,setMenuLbl,orderIdLbl,ctmrLbl;
	private JButton  addOrderBtn,backBtn, logoutBtn, refreshBtn;
	private JCheckBox bfBrgBx,ckBgrBx,pepPizzaBx,chsPizzaBx,swhBx,cokeBx,coffeeBx,waterBx,smenuBx1,smenuBx2;
	private JComboBox ckBQ,bfBQ,pepoPQ,chsPQ,sQ,ckQ,cfQ,wQ,smnQ1,smnQ2,ordrTF,cusTF;
	private JPanel panel;
	private String userId;
	int coutvalue=0;
	int count=0;
	String customerId [];
	int amountOfCustomer=0;
	String number []=new String[]{"0","1","2","3"};
	
	
	public TakeOrder(String userId)
	{
		super("Restaurant Management System - Take Order Window");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel =new JPanel();
		panel.setLayout(null);
		
		this.userId=userId;
		
		foodLbl = new JLabel("Fast Food");
		foodLbl.setBounds(100, 70, 150, 30);
		panel.add(foodLbl);
		
		drinkLbl = new JLabel("Drinks");
		drinkLbl.setBounds(580, 70, 150, 30);
		panel.add(drinkLbl);
		
		setMenuLbl = new JLabel("Set Menu");
		setMenuLbl.setBounds(420, 70, 150, 30);
		panel.add(setMenuLbl);
		
		odrLbl = new JLabel("Take Order");
		odrLbl.setBounds(350, 10, 150, 30);
		panel.add(odrLbl);
		
		orderIdLbl = new JLabel("Order Id: ");
		orderIdLbl.setBounds(300, 50, 150, 30);
		panel.add(orderIdLbl);
		
		ordrTF = new JComboBox(number);
		ordrTF.setBounds(360, 50, 35, 30);
		panel.add(ordrTF);
		
		ctmrLbl= new JLabel("Customer Id: ");
		ctmrLbl.setBounds(430, 50, 150, 30);
		panel.add(ctmrLbl);
		
		amountOfCustomer=getCustomerIdNo();
		String customerId []=new String[amountOfCustomer];
		System.out.println("amount: "+amountOfCustomer);
		getCustomerId(amountOfCustomer);
		
		/*cusTF = new JComboBox(customerId);
		cusTF.setBounds(510, 50, 100, 30);
		panel.add(cusTF);*/
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(100, 20, 100, 30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(650, 20, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		addOrderBtn = new JButton("Add Order");
		addOrderBtn.setBounds(300, 350, 100, 30);
		addOrderBtn.addActionListener(this);
		panel.add(addOrderBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(450, 350, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		ckBgrBx = new JCheckBox("Chicken Burger");
        ckBgrBx.setBounds(100, 100, 150, 30);
		ckBgrBx.addActionListener(this);
        panel.add(ckBgrBx);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(100, 135, 50, 30);
		panel.add(quantityLbl);
		
		String quantity[] = new String[]{"0", "1", "2","3","4","5","6","7","8","9","10",};
		ckBQ=new JComboBox(quantity);
		ckBQ.setBounds(155, 135, 40, 25);
		ckBQ.addActionListener(this);
		panel.add(ckBQ);
		
		bfBrgBx = new JCheckBox("Beef Burger");
        bfBrgBx.setBounds(100, 170, 150, 30);
		bfBrgBx.addActionListener(this);
        panel.add(bfBrgBx);

        bfBQ=new JComboBox(quantity);
		bfBQ.setBounds(155, 200, 40, 25);
		bfBQ.addActionListener(this);
		panel.add(bfBQ);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(100, 200, 50, 30);
		panel.add(quantityLbl);
		
		chsPizzaBx = new JCheckBox("Cheese Pizza");
        chsPizzaBx.setBounds(250, 100, 150, 30 );
		chsPizzaBx.addActionListener(this);
        panel.add(chsPizzaBx);

        chsPQ=new JComboBox(quantity);
		chsPQ.setBounds(308, 135, 40, 25 );
		chsPQ.addActionListener(this);
		panel.add(chsPQ);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(100, 265, 50, 30);
		panel.add(quantityLbl);
		
		pepPizzaBx = new JCheckBox("Peperoni Pizza"); 
        pepPizzaBx.setBounds(250, 170, 150, 30);
		pepPizzaBx.addActionListener(this);
        panel.add(pepPizzaBx);

        pepoPQ=new JComboBox(quantity);
		pepoPQ.setBounds(308, 200, 40, 25 );
		pepoPQ.addActionListener(this);
		panel.add(pepoPQ);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(250, 135, 50, 30);
		panel.add(quantityLbl);
		
		swhBx = new JCheckBox("Sandwich");
        swhBx.setBounds( 100, 240, 150, 30);
		swhBx.addActionListener(this);
        panel.add(swhBx);

        sQ=new JComboBox(quantity);
		sQ.setBounds(155, 270, 40, 25);
		sQ.addActionListener(this);
		panel.add(sQ);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(250, 200, 50, 30);
		panel.add(quantityLbl);
		
		smenuBx1 = new JCheckBox("Set Menu 1"); 
        smenuBx1.setBounds(420, 100, 150, 30);
		smenuBx1.addActionListener(this);
        panel.add(smenuBx1);

        smnQ1=new JComboBox(quantity);
		smnQ1.setBounds(480, 135, 40, 25);
		smnQ1.addActionListener(this);
		panel.add(smnQ1);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(420, 135, 50, 30);
		panel.add(quantityLbl);
		
		smenuBx2 = new JCheckBox("Set Menu 2");
        smenuBx2.setBounds(420, 170, 150, 30);
		smenuBx2.addActionListener(this);
        panel.add(smenuBx2);

        smnQ2=new JComboBox(quantity);
		smnQ2.setBounds(480, 200, 40, 25);
		smnQ2.addActionListener(this);
		panel.add(smnQ2);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(420, 200, 50, 30);
		panel.add(quantityLbl);
		
		cokeBx = new JCheckBox("Coke");
        cokeBx.setBounds(580, 100, 150, 30);
		cokeBx.addActionListener(this);
        panel.add(cokeBx);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(580, 135, 50, 30);
		panel.add(quantityLbl);
		
		ckQ=new JComboBox(quantity);
		ckQ.setBounds(640, 135, 40, 25);
		ckQ.addActionListener(this);
		panel.add(ckQ);
		
		coffeeBx = new JCheckBox("Coffee");
        coffeeBx.setBounds(580, 170, 150, 30);
		coffeeBx.addActionListener(this);
        panel.add(coffeeBx);

        cfQ=new JComboBox(quantity);
		cfQ.setBounds(640, 200, 40, 25);
		cfQ.addActionListener(this);
		panel.add(cfQ);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(580, 200, 50, 30);
		panel.add(quantityLbl);
		
		waterBx = new JCheckBox("Water");
        waterBx.setBounds(580, 240, 150, 30);
		waterBx.addActionListener(this);
        panel.add(waterBx);

        wQ=new JComboBox(quantity);
		wQ.setBounds(640, 270, 40, 25);
		wQ.addActionListener(this);
		panel.add(wQ);
		
		quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(580, 265, 50, 30);
		panel.add(quantityLbl);
		
		this.add(panel);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		String cb=null;
		String bb=null;
		String swh=null;
		String cp=null;
		String pp=null;
		String smn1=null;
		String smn2=null;
		String ck=null;
		String cf=null;
		String w=null;
		
		
		String cbQ = ckBQ.getSelectedItem().toString();
		String bbQ = bfBQ.getSelectedItem().toString();
		String swhQ = sQ.getSelectedItem().toString();
		String cpQ = chsPQ.getSelectedItem().toString();
		String ppQ = pepoPQ.getSelectedItem().toString();
		String setmnQ1 = smnQ1.getSelectedItem().toString();
		String setmnQ2 = smnQ2.getSelectedItem().toString();
		String cokeQ = ckQ.getSelectedItem().toString();
		String coffeeQ = cfQ.getSelectedItem().toString();
		String waterQ = wQ.getSelectedItem().toString();
		String odrId=ordrTF.getSelectedItem().toString();
		String customerId=cusTF.getSelectedItem().toString();
		
		
		if(text.equals(logoutBtn.getText()))
		{
			new Login().setVisible(true);
			this.dispose();
		}
		else if(text.equals(backBtn.getText()))
		{
			new WaiterHome(userId).setVisible(true);
			this.dispose();
		}
		else if(text.equals(refreshBtn.getText()))
		{
			new TakeOrder(userId).setVisible(true);
			this.dispose();
		}
		else if(text.equals(addOrderBtn.getText()))
		{	double chikenBurgerCost=0;
			double beefBurgerCost=0;
			double sandwichCost=0;
			double cheesePizzaCost=0;
			double peperoniPizzaCost=0;
			double cokeCost=0;
			double coffeeCost=0;
			double waterCost=0;
			double totalCost=0;
			double setMenuCost1=0;
			double setMenuCost2=0;
			count=0;
			//coutvalue=0;
			orderCheck(Integer.parseInt(waterQ),"010");
			orderCheck(Integer.parseInt(coffeeQ),"009");
			orderCheck(Integer.parseInt(cokeQ),"008");
			orderCheck(Integer.parseInt(setmnQ2),"007");
			orderCheck(Integer.parseInt(setmnQ1),"006");
			orderCheck(Integer.parseInt(ppQ),"003");
			orderCheck(Integer.parseInt(cpQ),"004");
			orderCheck(Integer.parseInt(swhQ),"005");
			orderCheck(Integer.parseInt(bbQ),"002");
			orderCheck(Integer.parseInt(cbQ),"001");
			
			if(odrId.equals("0"))
			{
				JOptionPane.showMessageDialog(this, "Order Id is not selected");
				count++;
			}
			if(customerId.equals("0"))
			{
				JOptionPane.showMessageDialog(this, "Customer Id is not selected");
				count++;
			}
				
				if(ckBgrBx.isSelected())
				{
					cb=ckBgrBx.getText();
					if(cbQ.equals("0"))
					{
						count++;
						JOptionPane.showMessageDialog(this, "Chicken Burger quantity is not selected");
					}
					else
					{
						chikenBurgerCost=order(Integer.parseInt(cbQ),"001");
						totalCost+=chikenBurgerCost;
					}
				}
			 if(bfBrgBx.isSelected())
			{
				bb=bfBrgBx.getText();
				if(bbQ.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Beef Burger quantity is not selected");
				}
				else
				{
					beefBurgerCost=order(Integer.parseInt(bbQ),"002");
					totalCost+=beefBurgerCost;
				}
			}
			if(swhBx.isSelected())
			{
				swh=swhBx.getText();
				if(swhQ.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Sandwich quantity is not selected");
				}
				else
				{
					sandwichCost=order(Integer.parseInt(swhQ),"005");
					totalCost+=sandwichCost;
				}
			}
			if(chsPizzaBx.isSelected())
			{
				cp=chsPizzaBx.getText();
				if(cpQ.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Cheese Pizza quantity is not selected");
				}
				else
				{
					
					cheesePizzaCost=order(Integer.parseInt(cpQ),"004");
					totalCost+=cheesePizzaCost;
				}
			}
			if(pepPizzaBx.isSelected())
			{
				pp=pepPizzaBx.getText();
				if(ppQ.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Peperoni Pizza quantity is not selected");
				}
				else
				{
					peperoniPizzaCost=order(Integer.parseInt(ppQ),"003");
					totalCost+=peperoniPizzaCost;
				}
			}
			 if(smenuBx1.isSelected())
			{
				smn1=smenuBx1.getText();
				if(setmnQ1.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Set Menu 1 quantity is not selected");
				}
				else
				{
					setMenuCost1=order(Integer.parseInt(setmnQ1),"006");
					totalCost+=setMenuCost1;
				}
			}
			 if(smenuBx2.isSelected())
			{
				smn2=smenuBx2.getText();
				if(setmnQ2.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Set Menu 2 quantity is not selected");
				}
				else
				{
					setMenuCost2=order(Integer.parseInt(setmnQ2),"007");
					totalCost+=setMenuCost2;
				}
			}
			 if(cokeBx.isSelected())
			{
				ck=cokeBx.getText();
				if(cokeQ.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Coke quantity  is not selected");
				}
				else
				{
					cokeCost=order(Integer.parseInt(cokeQ),"008");
					totalCost+=cokeCost;
				}
			}
			 if(coffeeBx.isSelected())
			{
				cf=coffeeBx.getText();
				if(coffeeQ.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Coffee quantity  is not selected");
				}
				else
				{
					coffeeCost=order(Integer.parseInt(coffeeQ),"009");
					totalCost+=coffeeCost;
				}
			}
			 if(waterBx.isSelected())
			{
				w=waterBx.getText();
				if(waterQ.equals("0"))
				{
					count++;
					JOptionPane.showMessageDialog(this, "Water quantity is not selected");
				}
				else
				{
					waterCost=order(Integer.parseInt(waterQ),"010");
					totalCost+=waterCost;
				}
			}
			if(!ckBgrBx.isSelected()&&!waterBx.isSelected()&&!coffeeBx.isSelected()&& !cokeBx.isSelected()&& !smenuBx2.isSelected()&&!smenuBx1.isSelected()&&!pepPizzaBx.isSelected()&&!chsPizzaBx.isSelected()&&!swhBx.isSelected()&& !bfBrgBx.isSelected())	
			{
				JOptionPane.showMessageDialog(this, "No Food is Selected");
				
			}
			
			else if(count==0&&coutvalue==0)
			{
				new OrderDetails(customerId,Integer.parseInt(odrId),userId,chikenBurgerCost,beefBurgerCost,sandwichCost,cheesePizzaCost,peperoniPizzaCost,cokeCost,coffeeCost,waterCost,totalCost,setMenuCost1,setMenuCost2,Integer.parseInt(cbQ),Integer.parseInt(bbQ),(Integer.parseInt(ppQ)),Integer.parseInt(cpQ),Integer.parseInt(swhQ),Integer.parseInt(cokeQ),Integer.parseInt(coffeeQ),Integer.parseInt(waterQ),Integer.parseInt(setmnQ1),Integer.parseInt(setmnQ2)).setVisible(true);
				this.dispose();
			}
			coutvalue=0;
			count=0;
		}
	}
	public double order(int q, String i)
	{
        String query = "SELECT `name`, `amount`, `price`,`id` FROM `food`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		String query2;
		double prc=0;
		//coutvalue=0;
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
                String name = rs.getString("name");
                int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				String id=rs.getString("id");
				 prc=0;
				int remainingQuantity;
				if(name.equals("Chicken Burger") && id.equals(i))
				{
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Chicken Burger'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Beef Burger")&& id.equals(i))
				{
					
					if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Beef Burger'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Set Menu 01") && id.equals(i))
				{
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Set Menu 01'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Set Menu 02")&& id.equals(i))
				{
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Set Menu 02'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Coke")&& id.equals(i))
				{
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Coke'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Coffee")&& id.equals(i))
				{
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Coffee'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Water")&& id.equals(i))
				{
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Water'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Peperoni Pizza")&& id.equals(i))
				{
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Peperoni Pizza'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Cheese Pizza")&& id.equals(i))
				{
					
					
					 if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Cheese Pizza'";
						st.executeUpdate(query2);
						break;
					}
				}
				else if(name.equals("Sandwich")&& id.equals(i))
				{
					if(amount>=q && coutvalue==0&&count==0)
					{
						remainingQuantity=amount-q;
						prc=price*q;
						query2= "UPDATE food SET amount='"+remainingQuantity+"' WHERE name='Sandwich'";
						st.executeUpdate(query2);
						break;
					}
				
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
		
		return prc;
	}
	
	
	public int  getCustomerIdNo()
	{
		String query = "SELECT `userId` FROM `customer`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		int tempAmountOfCustomer=0;		
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
                String name = rs.getString("userId");
				tempAmountOfCustomer++;
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
		return tempAmountOfCustomer;
	}
	
	public void  getCustomerId(int givenAmount)
	{
		String query = "SELECT `userId` FROM `customer`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		int tempAmountOfCustomer=0;		
		String tempArray[]=new String[givenAmount+1];
		int i=0;
		tempArray[0]="0";
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
                String name = rs.getString("userId");
				for(i=1;i<tempArray.length;i++)
				{
					if(tempArray[i]==null)
					{
						tempArray[i]=name;
						System.out.println("Temp array: "+tempArray[i]);
						break;
					}
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
		cusTF = new JComboBox(tempArray);
		cusTF.setBounds(510, 50, 100, 30);
		panel.add(cusTF);
		
	}
	
	public void orderCheck(int q, String i)
	{
        String query = "SELECT `name`, `amount`, `price`,`id` FROM `food`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		String query2;
		//coutvalue=0;
	
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
                String name = rs.getString("name");
                int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				String id=rs.getString("id");
				
				int remainingQuantity;
				if(name.equals("Chicken Burger") && id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Chicken Burger quantity: "+amount);
						break;
					
					}
				}
				else if(name.equals("Beef Burger")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Beef Burger quantity: "+amount);
						break;
					
					}
				}
				else if(name.equals("Set Menu 01") && id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Set Menu 1 quantity: "+amount);
						break;
					
					}
					
				}
				else if(name.equals("Set Menu 02")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Set Menu 2 quantity: "+amount);
						break;
					
					}
					
				}
				else if(name.equals("Coke")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Coke quantity: "+amount);
						break;
					
					}
					
				}
				else if(name.equals("Coffee")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Coffee quantity: "+amount);
						break;
					
					}
					
				}
				else if(name.equals("Water")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Water quantity: "+amount);
						break;
					
					}
					
				}
				else if(name.equals("Peperoni Pizza")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Peperoni Pizza quantity: "+amount);
						break;
					
					}
					
				}
				else if(name.equals("Cheese Pizza")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Cheese Pizza quantity: "+amount);
						break;
					
					}
					
					
				}
				else if(name.equals("Sandwich")&& id.equals(i))
				{
					if(amount<q)
					{
						coutvalue++;
						JOptionPane.showMessageDialog(this, "Only available Sandwich quantity: "+amount);
						break;
					
					}
					
				
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

	