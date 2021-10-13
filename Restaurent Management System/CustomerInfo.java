import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
	JLabel title, nameLabel,userLabel, addressLabel;
	JTextField nameTF,userTF, addressTF;
	JButton logoutBtn,backBtn, updateBtn, delBtn;
	JPanel panel;
	String userId;
	
	public CustomerInfo(String userId)
	{
		super("Customer Information");
		this.setSize(800, 450);
		this.userId=userId;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("MY INFO");
		title.setBounds(380, 50, 350, 30);
		panel.add(title);
		
		nameLabel = new JLabel("Name :");
		nameLabel.setBounds(322, 110, 60, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(390, 110, 100, 30);
		panel.add(nameTF);
		
		userLabel = new JLabel("User ID :");
		userLabel.setBounds(322, 150, 70, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(390, 150, 100, 30);
		userTF.setEditable(false);
		panel.add(userTF);
		
		addressLabel = new JLabel("Address :");
		addressLabel.setBounds(322, 190, 70, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(390, 190, 100, 30);
		panel.add(addressTF);
		
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 120, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(200, 300, 120, 30);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		delBtn = new JButton("Delete");
		delBtn.setBounds(450, 300, 120, 30);
		delBtn.addActionListener(this);
		panel.add(delBtn);
		
		this.add(panel);
		this.setVisible(true);
		
		displayinfo(userId);
		
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
		else if(text.equals(updateBtn.getText()))
		{
			updateInDB();
		}
		else if(text.equals(delBtn.getText()))
		{
				
			deleteFromDB();
		}
	}
	
	public void displayinfo(String userId)
	{
		 String uid;
		String eName;
		String address;
		
				
		String query = "SELECT `userId`, `name`, `address` FROM `customer`;";      
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
				String u= rs.getString("userId");
				
				if(u.equals(this.userId))
				{
				  uid=rs.getString("userId");
				eName = rs.getString("name");
				 address=rs.getString("address");
				flag=true;
				
				userTF.setText(uid);
				nameTF.setText(eName);
				addressTF.setText(address);
				
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
	
	public void updateInDB()
	{
		 try
		{
		String newId = userTF.getText();
		String eName = nameTF.getText();
		String address=addressTF.getText();
		String query = "UPDATE customer SET name='"+eName+"',address= '"+address+"' WHERE userId='"+newId+"'";	
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
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	
	public void deleteFromDB()
	{
		String newId = userTF.getText();
		String query1 = "DELETE from customer WHERE userId='"+newId+"';";
		String query2 = "DELETE from login WHERE userId='"+newId+"';";
		System.out.println(query1);
		System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
			
		}
        catch(Exception ex)
		{
		
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
}
