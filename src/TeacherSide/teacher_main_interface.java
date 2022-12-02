package TeacherSide;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class teacher_main_interface {
    	
	JFrame f;
	int newCode;
    JTextField search,t_date, t_rollno, t_date2;
    JLabel logo,dsa,s,l_date,l_code, subject_name, roll_no, l_date2,t_code, imglabel,imglabel2;
    ImageIcon img1;
    JTextArea notice_area;
    ImageIcon img,img2;
    JPanel opt,note, attendance,inst_notice, attentitle,pgencode,pmanualatte,pviewatte;
    JButton bnotes,batendance,binstantNotice,back,searchicon, submit, gen_code, mark_present,post,reset_notice,upload,bgencode,bmanualatte,bviewatte;
    Border bordertextarea = BorderFactory.createLineBorder(Color.black,1);
    JButton seeatten;
    JTextField inp,tviewroll;
    JLabel p,k,l,instruction,viewatt,viewroll,attis;
    JLabel imglable0,imglabel3;
//    ImageIcon line = new ImageIcon("src/line1.png");
    ImageIcon wave = new ImageIcon("src/wave.png");
    ImageIcon linehori1 = new ImageIcon("src/line_hori_1.png");
    JPanel header;
    
    
    teacher_main_interface(String input_user_id){
    	
    	imglable0 = new JLabel();
        imglable0.setIcon(wave);
        imglable0.setBounds(0,0,1000,150);
        
        imglabel3 = new JLabel();
        imglabel3.setIcon(linehori1);
        imglabel3.setBounds(20,90,700,10);
        
        header = new JPanel();
        header= new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(0x002233));//new Color(0xFFDAB9)
        header.setBounds(00,0,1000,150);
        header.setVisible(true);
    	
    	 attendance = new JPanel();
         attendance.setLayout(null);
         attendance.setBackground(Color.white);//new Color(0xFFDAB9)
         attendance.setBounds(300,150,700,500);
         attendance.setBorder(new BorderUIResource.BevelBorderUIResource(4));
         attendance.setVisible(false);
    	
    	attentitle = new JPanel();
        attentitle.setBounds(0, 0, 700,100);
        attentitle.setBackground(Color.white);
        attentitle.setLayout(null);
        
        pgencode= new JPanel();
        pgencode.setLayout(null);
        pgencode.setBackground(Color.white);//new Color(0xFFDAB9)
        pgencode.setBounds(0,100,700,400);
        pgencode.setBorder(new BorderUIResource.BevelBorderUIResource(4));
        pgencode.setVisible(true);
        
        pmanualatte= new JPanel();
        pmanualatte.setLayout(null);
        pmanualatte.setBackground(Color.white);//new Color(0xFFDAB9)
        pmanualatte.setBounds(0,100,700,400);
        pmanualatte.setBorder(new BorderUIResource.BevelBorderUIResource(4));
        pmanualatte.setVisible(false);
        
        pviewatte = new JPanel();
        pviewatte.setLayout(null);
        pviewatte.setBackground(Color.white);//new Color(0xFFDAB9)
        pviewatte.setBounds(0,100,700,400);
        pviewatte.setBorder(new BorderUIResource.BevelBorderUIResource(4));
        pviewatte.setVisible(false);
        
        bgencode = new JButton("Generate Code");
        bgencode.setBounds(10,40,150,50);
        bgencode.setBorderPainted(false);
        bgencode.setFocusable(false);
        bgencode.setBackground(Color.white);
        bgencode.setForeground(Color.black);
        bgencode.setFont(new Font("Product Sans", Font.PLAIN, 16));
       
        bmanualatte = new JButton("Manual Attendance");
        bmanualatte.setBounds(145,40,180, 50);
        bmanualatte.setBorderPainted(false);
        bmanualatte.setFocusable(false);
        bmanualatte.setBackground(Color.white);
        bmanualatte.setForeground(new Color(0x646464));
        bmanualatte.setFont(new Font("Product Sans", Font.PLAIN, 16));
        
        bviewatte= new JButton("View Attendance");
        bviewatte.setBounds(310,40,160, 50);
        bviewatte.setBorderPainted(false);
        bviewatte.setFocusable(false);
        bviewatte.setBackground(Color.white);
        bviewatte.setForeground(new Color(0x646464));
        bviewatte.setFont(new Font("Product Sans", Font.PLAIN, 16));
        
        viewatt = new JLabel("Know Attendance of student:");
        viewatt.setBounds(50,00,300,30);
        viewatt.setFont(new Font("Product Sans", Font.PLAIN, 18));
        
        viewroll = new JLabel("Roll Number");
        viewroll.setBounds(50,50,200,30);
        viewroll.setFont(new Font("Product Sans", Font.PLAIN, 18));
        
        tviewroll = new JTextField();
        tviewroll.setBounds(300,50,200,30);
        tviewroll.setFont(new Font("Product Sans", Font.PLAIN, 18));
        
        attis = new JLabel();
        attis.setBounds(80,150,200,30);
        attis.setFont(new Font("Product Sans", Font.PLAIN, 18));
        
        //-------------------------------------===========================================================

    	Border opt_border = BorderFactory.createLineBorder(new Color(176,176,176),3);
    	
    	img1 = new ImageIcon("src/Seminar-rafiki-resized.png");
         
    	imglabel = new JLabel();
//    	imglabel.setIcon(line);
    	imglabel.setBounds(420,50,350,350);
    	
    	imglabel2 = new JLabel();
    	imglabel2.setIcon(img1);
    	imglabel2.setBounds(20,180,350,350);
    	
    	k = new JLabel("Find Attendance of Student");
    	k.setBounds(440,50,300,30);
    	k.setOpaque(true);
    	k.setBackground(Color.white);
    	k.setFont(new Font("Product Sans", Font.PLAIN, 15));
    	
    	p = new JLabel();
    	p.setBounds(440,220,300,30);
    	p.setOpaque(true);
    	p.setBackground(Color.white);
    	p.setFont(new Font("Product Sans", Font.PLAIN, 15));
    	
    	
    	l = new JLabel("Roll Number");
    	l.setBounds(440,120,300,30);
    	l.setOpaque(true);
    	l.setBackground(Color.white);
    	l.setFont(new Font("Product Sans", Font.PLAIN, 15));
    	
    	inp = new JTextField();
    	inp.setBounds(560,120,100,30);
    	inp.setFont(new Font("Product Sans", Font.PLAIN, 15));
    	    	
    	seeatten = new JButton("Show Attendance");
    	seeatten.setFocusable(false);
    	seeatten.setBounds(50,120,200,30);
    	seeatten.setFont(new Font("Product Sans", Font.PLAIN, 15));
    	seeatten.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
					
					PreparedStatement h=connection.prepareStatement("select User_ID from student where Rno = ?");
					h.setString(1,tviewroll.getText());
					String g = "yashop";
					ResultSet m = h.executeQuery();
					if(m.next()) {
						
						g = m.getString("User_ID");
					}
					
	   				PreparedStatement Pstatement=connection.prepareStatement("select " +g +" from attendance");
	   				
	   				ResultSet result = Pstatement.executeQuery();
	   				float total=0;
	   				float sum = 0;
	   				
	   				while(result.next()) {
	   					
	   					total++;
	   					String one = "1";
	   					String r = result.getString(g);
//	   					System.out.println(m);
	   					
	   					if(r.equals(one)){
	   						sum++;
	   					}
	   					
	   				}
	   				float perc;
	   				perc = sum*100/total;
	   				attis.setText("Attendance is "+perc+"%");
					
					
				}
				catch (SQLException e1) {
  	    	        e1.printStackTrace();
  	    	    }
			}
        	 
         });
    	
         inst_notice = new JPanel();
         inst_notice.setLayout(null);
         inst_notice.setBackground(Color.white);
         inst_notice.setBounds(300,150,700,500);
         inst_notice.setBorder(new BorderUIResource.BevelBorderUIResource(4));
         inst_notice.setVisible(false);
    	
         f = new JFrame();
         f.setLayout(null);
         //f.getContentPane().setBackground(new Color(0xFFDAB9));
         //f.(new Color(0xFBC4AB));
         f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         
         note = new JPanel();
         note.setLayout(null);
         note.setBackground(Color.white);
         note.setBounds(300,150,700,500);
         note.setBorder(new BorderUIResource.BevelBorderUIResource(4));
         note.setVisible(true);
         

         dsa = new JLabel("DSA");
         dsa.setFont(new Font("Product Sans",Font.BOLD,20));
         dsa.setOpaque(true);
         dsa.setBackground(Color.white);
         dsa.setSize(203,76);
         dsa.setLocation(200,30);
         
         subject_name = new JLabel("DSA");
         subject_name.setFont(new Font("Product Sans",Font.BOLD,50));
         subject_name.setForeground(Color.white);
         subject_name.setBounds(130,30,200,100);
                 
         back = new JButton("BACK");
         back.setBounds(20,55,90,50);
         back.setBorder(null);
         back.setBackground(Color.white);
         back.setFocusable(false);

         opt = new JPanel();
         opt.setLayout(null);
         opt.setBounds(0,150,300,500);
         opt.setBackground(new Color(0x002233));//new Color(0xFFDAB9)
         //opt.setBorder(opt_border);
         
         bnotes = new JButton("Notes");
         batendance = new JButton("Attendance");
         binstantNotice = new JButton("Instant Notice");

         bnotes.setBorderPainted(false);
         binstantNotice.setBorderPainted(false);
         batendance.setBorderPainted(false);

         bnotes.setBounds(0,30,300,50);
         batendance.setBounds(0,100,300,50);
         binstantNotice.setBounds(0,170,300,50);
         
         
         instruction = new JLabel("Select and upload Notes");
         instruction.setBounds(50,20,500,50);
         instruction.setFont(new Font("Product Sans",Font.BOLD,20));
         
         upload = new JButton("Upload");
         upload.setBounds(50,80,100,40);
         upload.setFont(new Font("Product Sans",Font.BOLD,15));
         upload.setFocusable(false);
         upload.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				File za = null;
 				String h = null;
 				
 				JFileChooser choose = new JFileChooser();
				int res = choose.showOpenDialog(null);
					
				if (res == JFileChooser.APPROVE_OPTION){
						
					za = new File (choose.getSelectedFile().getAbsolutePath());
					h = za.getPath();
					
					try{
	 					
	 					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
	 					String SQL="INSERT INTO dsanotes (file_name,file_extension,file_content)VALUES(?,?,?)";
	 					PreparedStatement ps = connection.prepareStatement(SQL);
						
						String name = za.getName();
						long fileLength = za.length();
						
						ps.setString(1, name);
						
						ps.setString(2, name.substring(name.lastIndexOf(".")+1));
						
						FileInputStream fis = new FileInputStream(za);
						ps.setBinaryStream(3, fis, fileLength);
						
						ps.executeUpdate();	
	 					
						JOptionPane.showMessageDialog(null,"File Uploaded Succsessfully!!!");
						
	 				} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
						
				} 
				else {
					
					JOptionPane.showMessageDialog(null,"File NOT Uploaded Succsessfully!!!");
				}
 				
 						
 			}
         	 
          });
         
         binstantNotice.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				if(!inst_notice.isVisible()) {
    					
    					inst_notice.setVisible(true);
    					note.setVisible(false);
    					attendance.setVisible(false);
    					
    					binstantNotice.setBackground(Color.white);
    					binstantNotice.setForeground(new Color(0x002233));
    					
    					bnotes.setBackground(new Color(0x002233));
    					bnotes.setForeground(Color.white);
    					
    					batendance.setBackground(new Color(0x002233));
    					batendance.setForeground(Color.white);
    				}	
    			}
            	 
             });
         
         binstantNotice.setBackground(new Color(0x002233));
         batendance.setBackground(new Color(0x002233));
         bnotes.setBackground(Color.white);
         
         bnotes.setFont(new Font("Product Sans", Font.BOLD, 20));
         binstantNotice.setFont(new Font("Product Sans", Font.BOLD, 20));
         batendance.setFont(new Font("Product Sans", Font.BOLD, 20));
         
         bnotes.setHorizontalAlignment(SwingConstants.CENTER);
         binstantNotice.setHorizontalAlignment(SwingConstants.CENTER);
         batendance.setHorizontalAlignment(SwingConstants.CENTER);        

         binstantNotice.setForeground(Color.white);
         bnotes.setForeground(new Color(0x002233));
         batendance.setForeground(Color.white);
         
         
         
         batendance.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				
    				if(!attendance.isVisible()) {
 					attendance.setVisible(true);
 					note.setVisible(false);
 					inst_notice.setVisible(false);
 					
  					batendance.setBackground(Color.white);
  					batendance.setForeground(new Color(0x002233));
  					
    					bnotes.setBackground(new Color(0x002233));
  					bnotes.setForeground(Color.white);
  					
  					binstantNotice.setBackground(new Color(0x002233));
   					binstantNotice.setForeground(Color.white);
 				}
  			}
          	 
           });
         
         bnotes.addActionListener(new ActionListener() {

   			@Override
   			public void actionPerformed(ActionEvent e) {

   				if(!note.isVisible()) {
   					note.setVisible(true);
   					attendance.setVisible(false);
   					inst_notice.setVisible(false);
   					
   					bnotes.setBackground(Color.white);
   					bnotes.setForeground(new Color(0x002233));
   					
   					batendance.setBackground(new Color(0x002233));
   					batendance.setForeground(Color.white);
   					
   					binstantNotice.setBackground(new Color(0x002233));
    				binstantNotice.setForeground(Color.white);
   				}
   			}
           	 
            });
                  
         notice_area = new JTextArea();
    	 notice_area.setBounds(90,10,500,250);
    	 notice_area.setBorder(bordertextarea);
    	 notice_area.setText("//Type the message you want to convey to students");
    	 notice_area.setFont(new Font("Product Sans", Font.PLAIN, 16));
    	 
    	 post = new JButton("POST");
    	 post.setBounds(90,260,100,30);
    	 post.setFocusable(false);
    	 post.setFont(new Font("Product Sans", Font.PLAIN, 16));
    	 
    	 post.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {

    				try {
    	  				
    	  				
    	  				if(notice_area.getText().isEmpty() || notice_area.getText().isBlank()) {
    	  					JOptionPane.showMessageDialog(null,"Incomplete Information");
    	  					
    	  				}
    	  				else {
    	  				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
        	  			PreparedStatement Pstatement=connection.prepareStatement("update instnotice set noticeText = ? where srno = 1");
        	  			Pstatement.setString(1, notice_area.getText());
    	  				Pstatement.executeUpdate();
    	  				JOptionPane.showMessageDialog(null,"Notice Posted!!!!");
    	  				}
    	  				
    	  				}
    	  				catch (SQLException e1) {
    	  	    	        e1.printStackTrace();
    	  	    	    }    				
    			}
            	 
             });
    	 
    	 reset_notice = new JButton("RESET");
    	 reset_notice.setBounds(210,260,100,30);
    	 reset_notice.setFocusable(false);
    	 reset_notice.setFont(new Font("Product Sans", Font.PLAIN, 16));
    	 
    	 reset_notice.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 	  				notice_area.setText(null);
 			}
         	 
          });
    	 
    	 inst_notice.add(notice_area); 
    	 inst_notice.add(post);
    	 inst_notice.add(reset_notice);
         
//         attendance.add(k);
//         attendance.add(l);
//         attendance.add(imglabel);
         
         batendance.setFocusable(false);
         binstantNotice.setFocusable(false);
         bnotes.setFocusable(false);
         
         l_date = new JLabel("Enter current date : ");
         l_date.setBounds(50,50,200,30);
         l_date.setFont(new Font("Product Sans", Font.PLAIN, 18));
       
         gen_code = new JButton("Generate Code");
         gen_code.setBounds(50,100,150,30);
         gen_code.setBorderPainted(false);
         gen_code.setFont(new Font("Product Sans", Font.PLAIN, 16));
         gen_code.setFocusable(false);
         gen_code.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				try {
 				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
 				
 				Random_Code_Generator m = new Random_Code_Generator();
 				newCode = m.code();
// 				PreparedStatement Pstatement=connection.prepareStatement("update code set otp = "  +newCode +" where srno = '1' ");
// 				Pstatement.executeUpdate();
 				
 				String s = Integer.toString(newCode);
 				t_code.setText(s);
 				
// 				JOptionPane.showMessageDialog(null," Code has been reset succesfully");
 				
 				}
 				catch (SQLException e1) {
 	    	        e1.printStackTrace();
 	    	    }
 				 				
 			}
         	 
          });
         
         t_date = new JTextField();
         t_date.setBounds(300, 50, 100, 30);
         t_date.setFont(new Font("Product Sans", Font.PLAIN, 15));
                
         t_code = new JLabel();
         t_code.setLayout(null);
         t_code.setBounds(300, 100, 100, 30);
         t_code.setFont(new Font("Product Sans", Font.PLAIN, 15));
         
         submit = new JButton("Save Code");
         submit.setBounds(180,170,150,30);
         submit.setBorderPainted(false);
         submit.setFont(new Font("Product Sans", Font.PLAIN, 16));
         submit.setFocusable(false);
                
         l_date2 = new JLabel("Enter date : ");
         l_date2.setBounds(50,50,200,30);
         l_date2.setFont(new Font("Product Sans", Font.PLAIN, 18));
         
         t_date2 = new JTextField();
         t_date2.setBounds(300, 50, 100, 30);
         t_date2.setFont(new Font("Product Sans", Font.PLAIN, 15));
         
         roll_no = new JLabel("Enter roll no of Student");
         roll_no.setBounds(50,100,200,30);
         roll_no.setFont(new Font("Product Sans", Font.PLAIN, 18));
         
         t_rollno = new JTextField();
         t_rollno.setBounds(300, 100, 100, 30);
         t_rollno.setFont(new Font("Product Sans", Font.PLAIN, 15));
         
         mark_present = new JButton("Mark Present");
         mark_present.setBounds(180,170,150,30);
         mark_present.setBorderPainted(false);
         mark_present.setFont(new Font("Product Sans", Font.PLAIN, 16));
         mark_present.setFocusable(false);
         mark_present.addActionListener(new ActionListener() {

   			@Override
   			public void actionPerformed(ActionEvent e) {
   				
   				try {
   				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
   				
   				String date = t_date2.getText();
   				String r = t_rollno.getText();
   				int m = Integer.parseInt(r);
   				String user = "2345";
   				
   				
   				if(date.isEmpty() || r.isEmpty()) {
   					JOptionPane.showMessageDialog(null,"Incomlete Information");
   					
   				}
   				else {
   				PreparedStatement Pstatement=connection.prepareStatement("select User_ID from student where Rno ="+m);
   				
   				ResultSet result = Pstatement.executeQuery();
   				
   				if(result.next()) {
   					user = result.getString("User_ID");
   				}
   				
   				String currentDate = t_date.getText();
   				
   				PreparedStatement Jstatement=connection.prepareStatement("Update attendance Set " +user +"= true where Dates = ?");
   				Jstatement.setString(1,date);
   				Jstatement.executeUpdate();
   				
   				String s = Integer.toString(newCode);
   				JOptionPane.showMessageDialog(null," Attendance of the student has been marked");
   				}
   				
   				}
   				catch (SQLException e1) {
   	    	        e1.printStackTrace();
   	    	    }
   				}
           	 
            });
         
         submit.addActionListener(new ActionListener() {

   			@Override
   			public void actionPerformed(ActionEvent e) {
   				
   				try {
   				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
   				
   				PreparedStatement Pstatement=connection.prepareStatement("update code set otp = "  +newCode +" where srno = '1' ");
   				Pstatement.executeUpdate();
   				
   				String currentDate = t_date.getText();
   				if(currentDate.isEmpty()) {
   					JOptionPane.showMessageDialog(null,"Incomplete Information");
   				}
   				else {
   				PreparedStatement Dstatement=connection.prepareStatement("insert into attendance (Dates) values (?)");
   				Dstatement.setString(1,currentDate);
   				Dstatement.executeUpdate();
   				
   				PreparedStatement Jstatement=connection.prepareStatement("update code set currentDate = ? where srno = '1' ");
   				Jstatement.setString(1,currentDate);
   				Jstatement.executeUpdate();
   				
   				String s = Integer.toString(newCode);
   				JOptionPane.showMessageDialog(null," Date and Code has been reset succesfully");
   						
   				}
   				}
   				catch (SQLException e1) {
   	    	        e1.printStackTrace();
   	    	    }
   				  				  				
   			}
           	 
            });
         
         attentitle.add(bgencode);
         attentitle.add(bmanualatte);
         attentitle.add(bviewatte);
         attentitle.add(imglabel3);
         
         attendance.add(attentitle);
         attendance.add(pgencode);
         attendance.add(pmanualatte);
         attendance.add(pviewatte);
         
         pgencode.add(l_date);
         pgencode.add(t_date);
         pgencode.add(t_code);
         pgencode.add(submit);
         pgencode.add(gen_code);
         
         pmanualatte.add(roll_no);
         pmanualatte.add(t_rollno);
         pmanualatte.add(t_date2);
         pmanualatte.add(l_date2);
         pmanualatte.add(mark_present);
         
         pviewatte.add(viewatt);
         //pviewatte.add(imglabel2);
         pviewatte.add(viewroll);
         pviewatte.add(tviewroll);
         pviewatte.add(attis);
         pviewatte.add(seeatten);
         
         opt.add(bnotes);
         opt.add(batendance);
         opt.add(binstantNotice);
         opt.add(imglabel2);

         f.setBounds(200,50,1000,650);
         f.setResizable(true);
         
         header.add(subject_name);
         header.add(imglable0);
         f.add(opt);
         f.add(header);
//         f.add(subject_name);
         f.add(note);
         f.add(inst_notice);
         f.add(attendance);
         note.add(upload);
         note.add(instruction);
        
//         attendance.add(l_date);
//         attendance.add(t_date);
//         attendance.add(t_code);
//         attendance.add(submit);
//         attendance.add(gen_code);
//         attendance.add(roll_no);
//         attendance.add(t_rollno);
//         attendance.add(t_date2);
//         attendance.add(l_date2);
//         attendance.add(mark_present);
//         attendance.add(p);
//         attendance.add(seeatten);
//         attendance.add(inp);
         
         bgencode.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				if(!pgencode.isVisible()) {
    					pgencode.setVisible(true);
    					pmanualatte.setVisible(false);
    					pviewatte.setVisible(false);
    					
     					
    					bgencode.setForeground(Color.black);
// 					
// 					bnotes.setBackground(new Color(0x002233));
    					bviewatte.setForeground(new Color(0x646464));
// 					
// 					binstantNotice.setBackground(new Color(0x002233));
  					bmanualatte.setForeground(new Color(0x646464));
    				}
//    				
    			}
            	 
             });
          
           bmanualatte.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				if(!pmanualatte.isVisible()) {
    					pmanualatte.setVisible(true);
    					pgencode.setVisible(false);
    					pviewatte.setVisible(false);
    					
//     					batendance.setBackground(Color.white);
     				bmanualatte.setForeground(Color.black);
// 					
// 					bnotes.setBackground(new Color(0x002233));
 					bgencode.setForeground(new Color(0x646464));
// 					
// 					binstantNotice.setBackground(new Color(0x002233));
  					bviewatte.setForeground(new Color(0x646464));
    				}
//    				
    			}
            	 
             });
           
           bviewatte.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				if(!pviewatte.isVisible()) {
    					pviewatte.setVisible(true);
    					pmanualatte.setVisible(false);
    					pgencode.setVisible(false);
    					
//     					batendance.setBackground(Color.white);
     					bviewatte.setForeground(Color.black);
//     					
//     					bnotes.setBackground(new Color(0x002233));
     					bgencode.setForeground(new Color(0x646464));
//     					
//     					binstantNotice.setBackground(new Color(0x002233));
      					bmanualatte.setForeground(new Color(0x646464));
    				}
//    				
    			}
            	 
             });
         
         f.setVisible(true); 
    }
   
}