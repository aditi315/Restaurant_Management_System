import java.awt.event.ActionEvent;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener
{
	JLabel currentPassLabel, newPassLabel,confirmPassLabel,title;
	JTextField currentPassTF, newPassTF,confirmPassTF;
	JButton changeBtn, backBtn, logoutBtn;
	JPanel panel;
	String userId1;
	
	public ChangePassword(String userId)
	{
		super("Restaurant Management System - Change Password Window");
		this.userId1 = userId;
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Change PassWord");
		title.setBounds(350, 120, 350, 30);
		panel.add(title);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		currentPassLabel = new JLabel("Current Password :");
		currentPassLabel.setBounds(280, 170, 350, 30);
		panel.add(currentPassLabel);
		
		currentPassTF = new JTextField();
		currentPassTF.setBounds(410, 170, 100, 30);
		panel.add(currentPassTF);
		
		newPassLabel = new JLabel("New Password :");
		newPassLabel.setBounds(280, 220, 350, 30);
		panel.add(newPassLabel);
		
		newPassTF = new JTextField();
		newPassTF.setBounds(410, 220, 100, 30);
		panel.add(newPassTF);
		
		confirmPassLabel = new JLabel("Confirm Password :");
		confirmPassLabel.setBounds(280, 270, 350, 30);
		panel.add(confirmPassLabel);
		
		confirmPassTF = new JTextField();
		confirmPassTF.setBounds(410, 270, 100, 30);
		panel.add(confirmPassTF);
		
		changeBtn = new JButton("Change");
		changeBtn.setBounds(280, 320, 100, 30);
		changeBtn.addActionListener(this);
		panel.add(changeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(410, 320, 100, 30);
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
			checkStatus();
			this.dispose();
			
		}
		else if(text.equals(logoutBtn.getText()))
		{
			new Login().setVisible(true);
			this.dispose();
		}
		else if(text.equals(changeBtn.getText()))
		{
			checkUser();
		}
	}
	
	public void checkUser()
	{
		String query = "SELECT `userId`, `password`, `status` FROM `login`;";     
		String query2;
		String pass=confirmPassTF.getText();
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
                String userId = rs.getString("userId");
				String password = rs.getString("password");
				int status = rs.getInt("status");
				
				if( password.equals(currentPassTF.getText())&& (newPassTF.getText()).equals(confirmPassTF.getText()))
				{
					flag=true;
					if(status==0 )
					{
						query2= "UPDATE login SET password='"+pass+"' WHERE userId='"+userId1+"'";
						st.executeUpdate(query2);
						JOptionPane.showMessageDialog(this, "Password Changed");
						ManagerHome mh = new ManagerHome(userId);
						mh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==3)
					{
						query2= "UPDATE login SET password='"+pass+"' WHERE userId='"+userId1+"'";
						st.executeUpdate(query2);
						JOptionPane.showMessageDialog(this, "Password Changed");
						ChefHome ch = new ChefHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else if(status==2)
					{
						query2= "UPDATE login SET password='"+pass+"' WHERE userId='"+userId1+"'";
						st.executeUpdate(query2);
						JOptionPane.showMessageDialog(this, "Password Changed");
						WaiterHome wh = new WaiterHome(userId);
						wh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==1)
					{
						query2= "UPDATE login SET password='"+pass+"' WHERE userId='"+userId1+"'";
						st.executeUpdate(query2);
						JOptionPane.showMessageDialog(this, "Password Changed");
						CustomerHome c = new CustomerHome(userId);
						c.setVisible(true);
						this.setVisible(false);
					}
					else{}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
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
	public void checkStatus()
	{
		String query = "SELECT `userId`, `password`, `status` FROM `login`;"; 
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		int temp=0;
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
					//System.out.println(userId);
					System.out.println(userId1);
					//System.out.println(userId3);			
			
			while(rs.next())
			{
				String u= rs.getString("userId");
				int status = rs.getInt("status");
				
                
				{
					//System.out.println(u);	
					if(status==0 &&u.equals(this.userId1))
					{
						
						ManagerHome mh = new ManagerHome(userId1);
						mh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==3&&u.equals(this.userId1))
					{
						
						ChefHome ch = new ChefHome(userId1);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else if(status==2&&u.equals(this.userId1))
					{
						
						WaiterHome wh = new WaiterHome(userId1);
						wh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==1&&u.equals(this.userId1))
					{
						
						CustomerHome c = new CustomerHome(userId1);
						c.setVisible(true);
						this.setVisible(false);
					}
					else{}
					
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



