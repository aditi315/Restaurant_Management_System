import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class OrderDetails extends JFrame implements ActionListener
{
	private JLabel cknBrgLbl,bfBrgLbl,chsPizzaLbl,pepPizzaLbl,swhLbl,smnLbl1,smnLbl2,cokeLbl,coffeeLbl,waterLbl;
	private JLabel titleLbl,foodLbl,rateLbl,quantityLbl,priceLbl,totalPriceLbl,sLLbl,totalLbl;
	private JPanel panel;
	private JButton backBtn,logoutBtn;
	private String userId;
	
	public OrderDetails(String customerId,int odrId,String userId,double chikenBurgerCost,double beefBurgerCost,double sandwichCost,double cheesePizzaCost,double peperoniPizzaCost,double cokeCost,double coffeeCost,double waterCost,double totalCost,double setMenuCost1,double setMenuCost2,int ckBQ,int bfBQ,int pepoPQ,int chsPQ,int sQ,int ckQ,int cfQ,int wQ,int smnQ1,int smnQ2)
	{
		super("Restaurant Management System - Order Details Window");
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
		
		rateLbl = new JLabel("Rate");
		rateLbl.setBounds(350, 70, 150, 30);
		panel.add(rateLbl);
		
		priceLbl = new JLabel("Price");
		priceLbl.setBounds(450, 70, 150, 30);
		panel.add(priceLbl);
		
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
		
		
		
		if(chikenBurgerCost==0)
		{
			rateLbl = new JLabel("0");
			rateLbl.setBounds(350, 100, 150, 30);
			panel.add(rateLbl);
		}
		
		else
		{
			rateLbl = new JLabel(""+(chikenBurgerCost/ckBQ));
			rateLbl.setBounds(350, 100, 150, 30);
			panel.add(rateLbl);
			
		}
		
		if(beefBurgerCost==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 140, 150, 30);
		panel.add(rateLbl);
		}
		else
		{
		rateLbl = new JLabel(""+(beefBurgerCost/bfBQ));
		rateLbl.setBounds(350, 140, 150, 30);
		panel.add(rateLbl);
		
		}
		
		if(peperoniPizzaCost==0)
		{
			rateLbl = new JLabel("0");
			rateLbl.setBounds(350, 180, 150, 30);
			panel.add(rateLbl);
		}
		else{
		rateLbl = new JLabel(""+(peperoniPizzaCost/pepoPQ));
		rateLbl.setBounds(350, 180, 150, 30);
		panel.add(rateLbl);
	
		}
		
		
		if(cheesePizzaCost==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 220, 150, 30);
		panel.add(rateLbl);
		}
		else
		{
		rateLbl = new JLabel(""+(cheesePizzaCost/chsPQ));
		rateLbl.setBounds(350, 220, 150, 30);
		panel.add(rateLbl);
		
		}
		
		if(sandwichCost==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 260, 150, 30);
		panel.add(rateLbl);
		}
		else{
		rateLbl = new JLabel(""+(sandwichCost/sQ));
		rateLbl.setBounds(350, 260, 150, 30);
		panel.add(rateLbl);
		}
		
		if(setMenuCost1==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 300, 150, 30);
		panel.add(rateLbl);
		}
		else
		{
		rateLbl = new JLabel(""+(setMenuCost1/smnQ1));
		rateLbl.setBounds(350, 300, 150, 30);
		panel.add(rateLbl);
		
		}
		
		
		if(setMenuCost2==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 340, 150, 30);
		panel.add(rateLbl);
		}
		else{
		rateLbl = new JLabel(""+(setMenuCost2/smnQ2));
		rateLbl.setBounds(350, 340, 150, 30);
		panel.add(rateLbl);
		
		}
		
		if(cokeCost==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 380, 150, 30);
		panel.add(rateLbl);
		}
		else
		{
		rateLbl = new JLabel(""+(cokeCost/ckQ));
		rateLbl.setBounds(350, 380, 150, 30);
		panel.add(rateLbl);
		
		}
		
		
		if(coffeeCost==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 420, 150, 30);
		panel.add(rateLbl);
		}
		else
		{
		rateLbl = new JLabel(""+(coffeeCost/cfQ));
		rateLbl.setBounds(350, 420, 150, 30);
		panel.add(rateLbl);
		
		}
		
		
		if(waterCost==0)
		{
			rateLbl = new JLabel("0");
		rateLbl.setBounds(350, 460, 150, 30);
		panel.add(rateLbl);
		}
		else
		{
		rateLbl = new JLabel(""+(waterCost/wQ));
		rateLbl.setBounds(350, 460, 150, 30);
		panel.add(rateLbl);
		
		}
		
		
		priceLbl = new JLabel(""+chikenBurgerCost);
		priceLbl.setBounds(450, 100, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+beefBurgerCost);
		priceLbl.setBounds(450, 140, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+peperoniPizzaCost);
		priceLbl.setBounds(450, 180, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+cheesePizzaCost);
		priceLbl.setBounds(450, 220, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+sandwichCost);
		priceLbl.setBounds(450, 260, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+setMenuCost1);
		priceLbl.setBounds(450, 300, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+setMenuCost2);
		priceLbl.setBounds(450, 340, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+cokeCost);
		priceLbl.setBounds(450, 380, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+coffeeCost);
		priceLbl.setBounds(450, 420, 150, 30);
		panel.add(priceLbl);
		
		priceLbl = new JLabel(""+waterCost);
		priceLbl.setBounds(450, 460, 150, 30);
		panel.add(priceLbl);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(450, 30, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		totalLbl = new JLabel("Total Cost:");
		totalLbl.setBounds(350, 500, 150, 30);
		panel.add(totalLbl);
		
		
		priceLbl = new JLabel("Tk "+totalCost);
		priceLbl.setBounds(450, 500, 150, 30);
		panel.add(priceLbl);
		
		System.out.println(""+chikenBurgerCost);
		
		if(chikenBurgerCost!=0)
			insertOrder(customerId,odrId,"Chicken Burger",ckBQ,chikenBurgerCost,totalCost);
			
		
		if(beefBurgerCost!=0)
		{
			insertOrder(customerId,odrId,"Beef Burger",bfBQ,beefBurgerCost,totalCost);
		}
		if(peperoniPizzaCost!=0)
		{
				insertOrder(customerId,odrId,"Peperoni Pizza",pepoPQ,peperoniPizzaCost,totalCost);
		}
		if(cheesePizzaCost!=0)
		{
			insertOrder(customerId,odrId,"Cheese Pizza",chsPQ,cheesePizzaCost,totalCost);
		}
		if(sandwichCost!=0)
		{
			insertOrder(customerId,odrId,"Sandwich",sQ,sandwichCost,totalCost);

		}
		if(setMenuCost1!=0)
		{
				insertOrder(customerId,odrId,"Set Menu 01",smnQ1,setMenuCost1,totalCost);
		}
		if(setMenuCost2!=0)
		{
			insertOrder(customerId,odrId,"Set Menu 02",smnQ2,setMenuCost2,totalCost);
		}
		if(cokeCost!=0)
		{
			insertOrder(customerId,odrId,"Coke",ckQ,cokeCost,totalCost);
		}
		if(coffeeCost!=0)
		{
			insertOrder(customerId,odrId,"Coffee",cfQ,coffeeCost,totalCost);
		}
		if(waterCost!=0)
		{
			insertOrder(customerId,odrId,"Water",wQ,waterCost,totalCost);
		}
		
		
		this.add(panel);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String temp=ae.getActionCommand();
		if(temp.equals("Back"))
		{
			new TakeOrder(userId).setVisible(true);
			this.dispose();
		}
		
		if(temp.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void insertOrder(String cusId,int id,String name, int q,double price,double totalCost)
	{
		String status="not done";
		System.out.println("I am in Inser Order");
		
		//System.out.println("+id+","+name+","+q+","+price+","+totalCost+","+status+");
		
		String query1 = "INSERT INTO `order food` (`id`, `food`, `quantity`, `price`, `total price`, `status`,`customerId`) VALUES ('"+id+"','"+name+"','"+q+"','"+price+"','"+totalCost+"','"+status+"','"+cusId+"');";
		System.out.println(query1);
        
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.close();
			con.close();
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
}