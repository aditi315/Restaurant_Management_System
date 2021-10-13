import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton btnLogin, btnExit, btnReg;
	JPanel panel;
	
	public Login()
	{
		super("Restaurant Management System - Login Window");
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Restaurant Management System");
		title.setBounds(294, 50, 350, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID :");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password :");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		panel.add(passPF);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(300, 200, 80, 30);
		btnLogin.addActionListener(this);
		panel.add(btnLogin);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(390, 200, 80, 30);
		btnExit.addActionListener(this);
		panel.add(btnExit);
		
		btnReg = new JButton("Register");
		btnReg.setBounds(600, 50, 100, 30);
		btnReg.addActionListener(this);
		panel.add(btnReg);
		
		this.add(panel);
		
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String text = event.getActionCommand();
		
		if(text.equals(btnLogin.getText()))
		{
			checkLogin();
		}
		else if(text.equals(btnExit.getText()))
			{
			System.exit(0);
		}
		else if(text.equals(btnReg.getText())) {
			this.dispose();
			Register reg = new Register();
			reg.setVisible(true);
		}
		else {}
	}
	
	public void checkLogin() 
	{
		String query = "SELECT `userId`, `password`, `status` FROM `login`;";     
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
				
				if(userId.equals(userTF.getText()) && password.equals(passPF.getText()))
				{
					flag=true;
					if(status==0 )
					{
						ManagerHome mh = new ManagerHome(userId);
						mh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==3)
					{
						ChefHome ch = new ChefHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else if(status==2)
					{
						WaiterHome wh = new WaiterHome(userId);
						wh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==1)
					{
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

}
