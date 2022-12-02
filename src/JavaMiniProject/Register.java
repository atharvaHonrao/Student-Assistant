package JavaMiniProject;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Register implements ActionListener {

    JFrame f;
    JTextField tname,temail,tpass,tcompass,tuserid,tphone,tRollno,tdiv;
    JLabel lname,lemail,lpass,lcompass,luserid,lphone,lRollno,ldiv;
    JLabel logo,bk,Register,s,L_register;
    ImageIcon img1;
    ImageIcon img,img2;
    JPanel info,design;
    JLabel imglabel1,imglabel2;
    JButton bCreateAcc,L_create;

    public Register(){

    	
    	ImageIcon rectangle1 = new ImageIcon("src/rectangle2.png");
    	ImageIcon student1 = new ImageIcon("src/Login-rafiki-resized.png");

    	imglabel1 = new JLabel();
        imglabel1.setIcon(rectangle1);
        imglabel1.setBounds(75,20,546,572);
    	
        imglabel2 = new JLabel();
        imglabel2.setIcon(student1);
        imglabel2.setBounds(0,130,350,350);
        
        Register = new JLabel();
        Register.setText("REGISTER");
        Register.setFont(new Font("Elephant",Font.PLAIN,30));
        Register.setBackground(Color.white);
        Register.setOpaque(true);
        Register.setBounds(225,75,200,148-118);
        
        lRollno = new JLabel("Roll No");
        lemail = new JLabel("Email Id");
        lname = new JLabel("Name");
        ldiv = new JLabel("Division");
        lcompass = new JLabel("Confirm Password");
        lpass = new JLabel("Password");
        lphone = new JLabel("Phone Number");
        luserid = new JLabel("User-Id");

        tname = new JTextField();
        tRollno = new JTextField();
        temail = new JTextField();
        tuserid = new JTextField();
        tdiv = new JTextField();
        tcompass= new JTextField();
        tpass = new JTextField();
        tphone = new JTextField();

        lname.setBounds(100,100,200,50);
        luserid.setBounds(100,190,200,50);
        ldiv.setBounds(100,280,200,50);
        lpass.setBounds(100,370,200,50);

        lemail.setBounds(360,100,140,50);
        lphone.setBounds(360,190,140,50);
        lRollno.setBounds(360,280,140,50);
        lcompass.setBounds(360,370,140,50);
        
        tname.setBounds(100,140,200,39);
        tuserid.setBounds(100,230,200,39);
        tdiv.setBounds(100,320,200,39);
        tpass.setBounds(100,410,200,39);

        temail.setBounds(360,140,200,39);
        tphone.setBounds(360,230,200,39);
        tRollno.setBounds(360,320,200,39);
        tcompass.setBounds(360,410,200,39);
        
        lname.setFont(new Font("Sahitya", Font.PLAIN, 18));
        luserid.setFont(new Font("Sahitya", Font.PLAIN, 15));
        ldiv.setFont(new Font("Sahitya", Font.PLAIN, 18));
        lpass.setFont(new Font("Sahitya", Font.PLAIN, 18));
        lemail.setFont(new Font("Sahitya", Font.PLAIN, 18));
        lphone.setFont(new Font("Sahitya", Font.PLAIN, 18));
        lRollno.setFont(new Font("Sahitya", Font.PLAIN, 18));
        lcompass.setFont(new Font("Sahitya", Font.PLAIN, 18));
        tname.setFont(new Font("Sahitya", Font.PLAIN, 18));
        tuserid.setFont(new Font("Sahitya", Font.PLAIN, 18));
        tdiv.setFont(new Font("Sahitya", Font.PLAIN, 18));
        tpass.setFont(new Font("Sahitya", Font.PLAIN, 18));
        temail.setFont(new Font("Sahitya", Font.PLAIN, 18));
        tphone.setFont(new Font("Sahitya", Font.PLAIN, 18));
        tRollno.setFont(new Font("Sahitya", Font.PLAIN, 18));
        tcompass.setFont(new Font("Sahitya", Font.PLAIN, 18));
        
        bCreateAcc = new JButton("Create Account");
        bCreateAcc.setBorder(null);
        bCreateAcc.setFont(new Font("Sahitya", Font.PLAIN, 15));
        bCreateAcc.setBounds(280,470,100,35);
        bCreateAcc.setFocusable(false);
        bCreateAcc.addActionListener(this);
        
        L_register = new JLabel("Already have an account?");
        L_register.setBounds(245,500,250,30);
        L_register.setFont(new Font("Product Sans", Font.PLAIN, 15));
        
        L_create = new JButton("Sign-in");
        L_create.setBounds(285,525,100,30);
        L_create.setFont(new Font("Product Sans", Font.PLAIN, 14));
        L_create.setForeground(Color.BLUE.darker());
        L_create.setBackground(Color.white);
        L_create.setBorderPainted(false);
        L_create.setFocusable(false);
        L_create.addActionListener(this);
        
        f = new JFrame();
        f.setLayout(null);
        f.getContentPane().setBackground(new Color(0xFBC4AB));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        design = new JPanel();
        design.setLayout(null);
        design.setBounds(0,0,350,650);
        design.setBackground(new Color(0xf54848));

        info = new JPanel();
        info.setLayout(null);
        info.setBounds(350,0,650,650);
        info.setBackground(Color.white);
        
        design.add(imglabel2);
        
        info.add(bCreateAcc);
        info.add(Register);

        info.add(tname);
        info.add(tRollno);
        info.add(tdiv);
        info.add(tcompass);
        info.add(tpass);
        info.add(temail);
        info.add(tphone);
        info.add(tuserid);

        info.add(lname);
        info.add(lRollno);
        info.add(lcompass);
        info.add(ldiv);
        info.add(lemail);
        info.add(lpass);
        info.add(luserid);
        info.add(lphone);
        info.add(imglabel1);
       
        info.add(L_register);
        info.add(L_create);

        f.setBounds(200,50,1000,650);
        f.add(design);
        f.add(info);
        f.setVisible(true);
        

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==L_create){
			
			f.dispose();
			Login m = new Login();
			
			
		}
		
		if(e.getSource()==bCreateAcc)
    	{
    	    try {    	    	
    	        
    	        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
    	        Connection connection2=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
    	        PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
    	        
    	        Pstatement.setString(1,tuserid.getText());
    	        Pstatement.setString(2,tRollno.getText());
    	        Pstatement.setString(3,tphone.getText());
    	        Pstatement.setString(4,tname.getText());
    	        Pstatement.setString(5,tdiv.getText());
    	        Pstatement.setString(6,tpass.getText());
    	        Pstatement.setString(7,temail.getText());
    	        System.out.println("1");
    	        String querr = "Alter table attendance add column " +tuserid.getText() + " boolean default false";
    	        System.out.println("2");
    	       
    	        System.out.println("2");
    	        String iop = tRollno.getText();  
    	        System.out.println("2");
    			Boolean flag = true;
    			 System.out.println("2");
    			for(int a=0;a<iop.length();a++)
    			{
    				if(a==0 && iop.charAt(a) == '-')
    					continue;
    				if( !Character.isDigit(iop.charAt(a)))
    					flag=false;          	   
    			}
    			
    			String io = tphone.getText();           
    			Boolean po=true;
    			Boolean hi =false;
    			
    			if(!temail.getText().isEmpty()) {
    			if(temail.getText().contains("@")) {
    				hi = true;
    			}
    			else {
    				hi = false;
    			}
    			if(temail.getText().charAt(0)=='@') {
    				hi = false;
    			}
    			}
    			for(int a=0;a<io.length();a++)
    			{
    				if(a==0 && io.charAt(a) == '-')
    					continue;
    				if( !Character.isDigit(io.charAt(a)))
    					po=false;          	   
    			}
    			
    	        if(tuserid.getText().isEmpty() || tRollno.getText().isEmpty() || tphone.getText().isEmpty() || tname.getText().isEmpty() ||
    	        		tdiv.getText().isEmpty() ||tpass.getText().isEmpty() ||	temail.getText().isEmpty()) {
    	        	
    	        	JOptionPane.showMessageDialog(null,"Incomplete information");
    	        	
    	        }
    	        else if(hi == false) {
    	        	JOptionPane.showMessageDialog(null,"Wrong Email-id");
    	        }
    	        else if(tpass.getText().length() <8){
    	        	JOptionPane.showMessageDialog(null,"Password length should be greater than 7");
    	        	
    	        }
    	        else if(po==false || io.length()!=10) {
    	        	JOptionPane.showMessageDialog(null,"Wrong Phone Number");
    	        }
    	        else if(flag ==false){
    	        	JOptionPane.showMessageDialog(null,"Roll number is not integer");
    	        }
//    	        PreparedStatement p =connection.prepareStatement ("insert into student values(?,?,?,?,?,?,?)");
    	        else if(tpass.getText().equals(tcompass.getText()))
    	        {
    	            //Executing query
    	        	 PreparedStatement p=connection2.prepareStatement(querr);
    	            Pstatement.executeUpdate();
  	            p.executeUpdate();
    	            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
    	            f.dispose();
    	            Login l = new Login(); 
    	        }
    	        else
    	        {
    	            JOptionPane.showMessageDialog(null,"Password did not match");
    	        }

    	    } catch (SQLException e1) {
    	        e1.printStackTrace();
    	    }
    	    
try {
    	        
    	        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");       
    	        PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
    	       
    	        
    	        
    	       

    	    } catch (SQLException e1) {
    	        e1.printStackTrace();
    	    }
    	    
    	    

    	}
		
	}
    
}