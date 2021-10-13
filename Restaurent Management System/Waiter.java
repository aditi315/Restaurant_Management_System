import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Waiter extends JFrame implements ActionListener{
	JLabel userLabel, eNameLabel, addressLabel, roleLabel, salaryLabel;
	JTextField userTF, addressTF, eNameTF, salaryTF;
	JButton refreshBtn, loadBtn, updateBtn, delBtn, backBtn, logoutBtn;
	JPanel panel;
	String userId;
	
	public Waiter(String userId)
	{
		super("Restaurant Management System - View Employee-waiter");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(250, 100, 275, 30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 150, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 150, 120, 30);
		panel.add(userTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(550, 150, 150, 30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		eNameLabel = new JLabel("Employee Name : ");
		eNameLabel.setBounds(250, 200, 120, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(250, 250, 120, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(400, 250, 120, 30);
		panel.add(addressTF);
		
		
		salaryLabel = new JLabel("Salary : ");
		salaryLabel.setBounds(250, 300, 120, 30);
		panel.add(salaryLabel);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(400, 300, 120, 30);
		panel.add(salaryTF);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(200, 400, 120, 30);
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		delBtn = new JButton("Delete");
		delBtn.setBounds(350, 400, 120, 30);
		delBtn.setEnabled(false);
		delBtn.addActionListener(this);
		panel.add(delBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(500, 400, 120, 30);
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
			ViewEmployee ve = new ViewEmployee(userId);
			ve.setVisible(true);
			this.dispose();
		}
		if(text.equals(refreshBtn.getText()))
		{
			updateBtn.setEnabled(false);
			delBtn.setEnabled(false);
			userTF.setEnabled(true);
			userTF.setText("");
			eNameTF.setText("");
			addressTF.setText("");
			salaryTF.setText("");
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		}
		
		else if(text.equals(loadBtn.getText()))
		{
			loadFromDB();
		}
		else if(text.equals(updateBtn.getText()))
		{
			updateInDB();
		}
		else if(text.equals(delBtn.getText()))
		{
				
				deleteFromDB();
		}
		else{}
	}
	
	public void loadFromDB()
	{
		
		String loadId = userTF.getText();
		String query = "SELECT `name`, `address`, `salary` FROM `waiter` WHERE `userId`='"+loadId+"';";     
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
			String address=null;
			double salary = 0.0;			
			while(rs.next())
			{
                eName = rs.getString("name");
				address=rs.getString("address");
				salary = rs.getDouble("salary");
				flag=true;
				
				eNameTF.setText(eName);
				addressTF.setText(address);
				salaryTF.setText(""+salary);
				userTF.setEnabled(false);
				updateBtn.setEnabled(true);
				delBtn.setEnabled(true);
			}
			if(!flag)
			{
				eNameTF.setText("");
				addressTF.setText("");
				salaryTF.setText("");
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
		String newId = userTF.getText();
		String eName = eNameTF.getText();
		String address=addressTF.getText();
		double salary = Double.parseDouble(salaryTF.getText());
		String query = "UPDATE Waiter SET name='"+eName+"',address= '"+address+"', salary = "+salary+" WHERE userId='"+newId+"'";	
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
			
			updateBtn.setEnabled(false);
			delBtn.setEnabled(false);
			userTF.setEnabled(true);
			userTF.setText("");
			eNameTF.setText("");
			addressTF.setText("");
			salaryTF.setText("");
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
		String query1 = "DELETE from waiter WHERE userId='"+newId+"';";
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
			
			updateBtn.setEnabled(false);
			delBtn.setEnabled(false);
			userTF.setEnabled(true);
			userTF.setText("");
			eNameTF.setText("");
			addressTF.setText("");
			salaryTF.setText("");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
	

}
