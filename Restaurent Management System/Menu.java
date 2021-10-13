import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Menu extends JFrame implements ActionListener
{
	JLabel idLabel, foodNameLabel, amountLabel, priceLabel;
	JTextField idTF, foodNameTF, amountTF, priceTF;
	JButton loadBtn, logoutBtn, addFoodBtn, deleteFoodBtn, updateBtn, backBtn, refreshBtn;
	JPanel panel;
	String userId;
	
	public Menu(String userId) 
	{
		super("Restaurant Management System - Manage Menu Window");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.userId=userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 10, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(250, 50, 275, 30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		idLabel = new JLabel("Food Id : ");
		idLabel.setBounds(250, 100, 120, 30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(400, 100, 120, 30);
		panel.add(idTF);
		
		foodNameLabel = new JLabel("Food Name : ");
		foodNameLabel.setBounds(250, 150, 120, 30);
		panel.add(foodNameLabel);
		
		foodNameTF = new JTextField();
		foodNameTF.setBounds(400, 150, 120, 30);
		panel.add(foodNameTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(550, 150, 150, 30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		amountLabel = new JLabel("Amount : ");
		amountLabel.setBounds(250, 200, 120, 30);
		panel.add(amountLabel);
		
		amountTF = new JTextField();
		amountTF.setBounds(400, 200, 120, 30);
		panel.add(amountTF);
		
		priceLabel = new JLabel("Price : ");
		priceLabel.setBounds(250, 250, 120, 30);
		panel.add(priceLabel);
		
		priceTF = new JTextField();
		priceTF.setBounds(400, 250, 120, 30);
		panel.add(priceTF);
		
		addFoodBtn = new JButton("Add Food");
		addFoodBtn.setBounds(150, 320, 120, 30);
		addFoodBtn.addActionListener(this);
		panel.add(addFoodBtn);
		
		deleteFoodBtn = new JButton("Delete Food");
		deleteFoodBtn.setBounds(300, 320, 120, 30);
		deleteFoodBtn.setEnabled(false);
		deleteFoodBtn.addActionListener(this);
		panel.add(deleteFoodBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(450, 320, 120, 30);
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 320, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			ChefHome chh = new ChefHome(userId);
			chh.setVisible(true);
			this.setVisible(false);
		}
		if(text.equals(refreshBtn.getText()))
		{
			addFoodBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteFoodBtn.setEnabled(false);
			idTF.setEnabled(true);
			idTF.setText("");
			foodNameTF.setText("");
			amountTF.setText("");
			priceTF.setText("");
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(loadBtn.getText()))
		{
			loadFromDB();			
		}
		else if(text.equals(updateBtn.getText()))
		{
			updateInDB();
		}
		else if(text.equals(deleteFoodBtn.getText()))
		{
			deleteFromDB();
		}
		else if(text.equals(addFoodBtn.getText()))
		{
			addFood();
		}
		else{}
	}
	
	public void loadFromDB() 
	{
		String loadId = idTF.getText();
		String query = "SELECT `name`, `amount`, `price` FROM `food` WHERE `id`='"+loadId+"';";     
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
			String eName = null;
			int amount=0;
			double price = 0.0;			
			while(rs.next())
			{
                eName = rs.getString("name");
				amount=rs.getInt("amount");
				price = rs.getDouble("price");
				flag=true;
				
				foodNameTF.setText(eName);
				amountTF.setText(""+amount);
				priceTF.setText(""+price);
				idTF.setEnabled(false);
				updateBtn.setEnabled(true);
				deleteFoodBtn.setEnabled(true);
				addFoodBtn.setEnabled(false);
			}
			if(!flag)
			{
				foodNameTF.setText("");
				amountTF.setText("");
				priceTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
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
	
	public void updateInDB()
	{
		
		 try
		{
		String newId = idTF.getText();
		String eName = foodNameTF.getText();
		int amount= Integer.parseInt(amountTF.getText());
		double price = Double.parseDouble(priceTF.getText());
		String query = "UPDATE food SET name='"+eName+"',amount= '"+amount+"', price = '"+price+"' WHERE id='"+newId+"'";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
       
			
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02","root","");
			st = con.createStatement();//create statement
			st.executeUpdate(query);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			addFoodBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteFoodBtn.setEnabled(false);
			idTF.setEnabled(true);
			idTF.setText("");
			foodNameTF.setText("");
			amountTF.setText("");
			priceTF.setText("");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	
	public void deleteFromDB()
	{
			String newId = idTF.getText();
		String query = "DELETE from food WHERE id='"+newId+"';";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			addFoodBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteFoodBtn.setEnabled(false);
			idTF.setEnabled(true);
			idTF.setText("");
			foodNameTF.setText("");
			amountTF.setText("");
			priceTF.setText("");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
	public void addFood()
	{
		String newId = idTF.getText();
		String eName = foodNameTF.getText();
		int amount= Integer.parseInt(amountTF.getText());
		double price = Double.parseDouble(priceTF.getText());
		
		
		
		String query = "INSERT INTO food VALUES ('"+newId+"','"+eName+"','"+amount+"','"+price+"');";
		System.out.println(query);
		
        
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			updateBtn.setEnabled(false);
			deleteFoodBtn.setEnabled(false);
			idTF.setEnabled(true);
			idTF.setText("");
			foodNameTF.setText("");
			amountTF.setText("");
			priceTF.setText("");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}

}
