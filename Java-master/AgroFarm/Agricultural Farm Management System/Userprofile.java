import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
  
class Userprofile extends JFrame implements WindowListener,ActionListener{
	private Register register;
	public    Button b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,submitButton,show,resetButton1; 
	   public Label l,l0,l1,l2,l3,l4,l5,l6,l7,l8;
       public TextField tf,tf1,tf2,tf3,tf4,tf5,tf6,tf7;	  
public JLabel messageBox;	   
	public Userprofile(Register r){
		super("Farm Management System/UserProfile");
		this.register=r;
l=new Label("Farm Management System");
		l.setFont(new Font("Farm Management System",Font.PLAIN, 40));
		l.setBounds(150,60,500,45);  
		    
        b=new Button("Home");  
        b.setBounds(20,130,100,50);  
		b1=new Button("Dashboard");  
        b1.setBounds(120,130,100,50);  
		b2=new Button("Profile");  
        b2.setBounds(220,130,100,50);  
		b3=new Button("Reports");  
        b3.setBounds(320,130,100,50); 
		b4=new Button("Change Password");  
        b4.setBounds(420,130,120,50);  
		b5=new Button("Logout");  
        b5.setBounds(540,130,100,50); 
 l0=new Label("User profile");
l0.setFont(new Font("User profile",Font.PLAIN,20));		 
		  l0.setBounds(20,180, 500,45); 
		  		
					  messageBox=new JLabel("Data to show");
		messageBox.setFont(new Font("Farm Management System",Font.PLAIN, 15));
		messageBox.setBounds(20,200,500,600);
		//messageBox.setText(null);
	
				show=new Button("Show User Profile");  
        show.setBounds(600,200,100,50); 
				add(l);add(l0);add(b);add(b1);add(b2);add(b3);add(b4);add(b5);add(show);add(messageBox);
				
	
				
				
				b.addActionListener(this);
		        b1.addActionListener(this);
                b2.addActionListener(this);
		        b3.addActionListener(this);
		        b4.addActionListener(this);
		        b5.addActionListener(this);
				show.addActionListener(this);
				addWindowListener(this);
		
        setSize(800,800);  
        setLayout(null);  
        setVisible(false); 
	}
		
	public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("logo.PNG");  
        g.drawImage(i, 10,30,this);  
          
    }  
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();

		if(s.equals("Home")){
			register.userprofile.setVisible(false);
			register.homePage.setVisible(true);
		}
		else if(s.equals("Dashboard")){
			register.userprofile.setVisible(false);
			register.Dashboard.setVisible(true);
		}
		else if(s.equals("Profile")){
			//register.fertilizerreports.setVisible(false);
			register.userprofile.setVisible(true);
		}
		else if(s.equals("Reports")){
			register.userprofile.setVisible(false);
			register.ReportDashboard.setVisible(true);
		}
		else if(s.equals("Change Password")){
			register.userprofile.setVisible(false);
			register.ChangePass.setVisible(true);
		}
		else if(s.equals("Logout")){
			register.userprofile.setVisible(false);
			register.login.setVisible(true);
		}
		else if(s.equals("Show User Profile")){
			try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData("SELECT * FROM user ");
			messageBox.setText(null);
			String st="<html>";
			
			
			while(rs.next()){
				String uname=rs.getString("Uname");
				if(uname.equals(register.login.tf.getText())){
				st=st+"  UserId: "+rs.getString("Uid")+"<br/>"+"    UserName:  "+rs.getString("Uname")+"<br/>";
				st=st+"    Phone:  "+rs.getString("Phone")+"<br/>"+"    Email: "+rs.getString("Email")+"<br/>";
				st=st+"  Address: "+rs.getString("Address")+"<br/>"+"    Position:  "+rs.getString("Position")+"<br/>";
				}
			}
			st+="</html>";
			messageBox.setText(st);
			}
			catch(Exception ex){
			ex.printStackTrace();
		}
			
		}
	}
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}


}