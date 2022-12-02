package JavaMiniProject;

import java.awt.Color;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
 
public class Login implements ActionListener{
	
	String input_password;
	String input_user_id;
	
	JFrame LoginFrame;
	JPanel content , design;
	JLabel L_username, L_password, L_register, imglabel,imglabel2, title;
	JTextField T_username;
	JPasswordField  T_password;
	JButton submit,L_createhere;
	
	ImageIcon rectangle1 = new ImageIcon("src/rectangle1.png");
	ImageIcon teacher1 = new ImageIcon("src/Login-amico-resized.png");
	
	 Login() {
		 
		Border design_border = BorderFactory.createLineBorder(Color.BLACK,1);
		
		LoginFrame = new JFrame();
		LoginFrame.setLayout(null);
		
		LoginFrame.setBounds(200,50,1000,650);
		LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		LoginFrame.setTitle("Login Here");
		LoginFrame.setResizable(false);
		LoginFrame.getContentPane().setBackground(Color.white);
		
		
		design = new JPanel();
        design.setLayout(null);
        design.setBounds(0,0,400,650);
        design.setBackground(new Color(0xf54848));
        //design.setBackground(Color.WHITE);
        //design.setSize(400,750);
        //design.setBorder(design_border);
        
        content = new JPanel();
        content.setLayout(null);
        content.setBounds(400,0,600,650);
       // content.setSize(880,750);
        content.setBackground(Color.white);
        
        imglabel = new JLabel();
        imglabel.setIcon(teacher1);
        imglabel.setBounds(0,130,368,336);
        
        imglabel2 = new JLabel();
        imglabel2.setIcon(rectangle1);
        imglabel2.setBounds(50,20,546,572);
       
        L_username = new JLabel("ENTER User_ID");
        L_username.setBounds(100, 200, 200, 50);
        L_username.setBorder(design_border);
        L_username.setFont(new Font("Sahitya", Font.PLAIN, 15));
        L_username.setBorder(new EmptyBorder(10,0,0,0));
        
        L_password = new JLabel("PASSWORD");
        L_password.setBounds(100, 275, 200, 50);
        L_password.setFont(new Font("Sahitya", Font.PLAIN, 15));
        
        title = new JLabel("STUDENT LOGIN");
        //title.setText("TEACHER LOGIN");
        title.setFont(new Font("Elephant", Font.PLAIN, 30));
        title.setBounds(140,75,500,100);
        
        
        T_username = new JTextField();
        T_username.setLayout(null);
        T_username.setBounds(100, 240, 390, 30);
        
        T_password = new JPasswordField();
        T_password.setLayout(null);
        T_password.setEchoChar('*');
        T_password.setBounds(100, 310, 390, 30);
        
        L_register = new JLabel("Dont have an account?");
        L_register.setBounds(230,450,150,30);
        L_register.setFont(new Font("Sahitya", Font.PLAIN, 15));
        
        L_createhere = new JButton("CREATE HERE");
        L_createhere.setBounds(245,470,110,30);
        L_createhere.setFont(new Font("Sahitya", Font.PLAIN, 12));
        L_createhere.setForeground(Color.BLUE.darker());
        L_createhere.setBackground(Color.white);
        L_createhere.setBorderPainted(false);
        L_createhere.setFocusable(false);
        L_createhere.addActionListener(this);
        
        submit = new JButton("Submit");
        submit.setBounds(250,380,100,30);
        submit.setBorderPainted(false);
        submit.setFont(new Font("Sahitya", Font.PLAIN, 15));
        submit.addActionListener(this);
        
        LoginFrame.add(design);
        LoginFrame.add(content);
      
        design.add(imglabel);
         
        content.add(T_username);
       	content.add(T_password);
		content.add(L_username);
		content.add(L_password);
		content.add(imglabel2);
		content.add(title);
		content.add(submit);
		content.add(L_createhere);
		content.add(L_register);
		
		LoginFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==submit){
			
			try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");       
 	        
			input_user_id = T_username.getText();
			input_password = T_password.getText();
			
			
//			System.out.println("Input password"+input_password+"ii");
			
			
			
			PreparedStatement Pstatement=connection.prepareStatement("select password_s from student where User_ID = ? ");
	       
	        Pstatement.setString(1,T_username.getText());
			
	        ResultSet result = Pstatement.executeQuery(); 
	        
	        

			
			if(result.next()) {
				
			
				String pass = result.getString("password_s");
//				System.out.println(pass);
				
				if(pass.equals(input_password)){
					
//					System.out.println("Inside");
					
					LoginFrame.dispose();
//					NotesPage n = new NotesPage(input_user_id);
					student_subject po = new student_subject(input_user_id);
					
				}
				else {
					
					JOptionPane.showMessageDialog(null,"  Wrong Password");
				}
			}
			else {
				
				JOptionPane.showMessageDialog(null,"  Wrong Userid");
			}
			

			}
			catch (SQLException e1) {
    	        e1.printStackTrace();
    	    }
		}
		
		if(e.getSource()==L_createhere) {
			LoginFrame.dispose();
			Register m = new Register();
		}
		
	}
}
