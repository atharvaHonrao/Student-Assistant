package JavaMiniProject;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotesPage {

	String input_password;
	String input_user_id;
    JFrame f;
    JTextField t_date, t_code;
    JLabel l_date,l_code, subject_name, imglabel,imglable0;
    JPanel opt,note, attendance, inst_notice,header;
    JButton bnotes,batendance,binstantNotice,back,submit,refresh;
    JLabel percentage;
    Border bordertextarea = BorderFactory.createLineBorder(Color.black,1);
    JTextArea notice_area;
    JTextField fileinput;
    JButton downindi;
    JLabel l;
    ImageIcon wave = new ImageIcon("src/wave-red.png");
    
    ImageIcon student = new ImageIcon("src/Formula-amico_resized.png");
    JTextArea files;
    
    JButton uploadall;
    
    NotesPage(String input_user_id,String z){
    	
    	imglable0 = new JLabel();
        imglable0.setIcon(wave);
        imglable0.setBounds(0,0,1000,150);
        
        header = new JPanel();
        header= new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(0xec2525));//new Color(0xFFDAB9)
        header.setBounds(00,0,1000,150);
        header.setVisible(true);
    	
    	fileinput = new JTextField();
    	fileinput.setBounds(300,290,150,40);
    	fileinput.setFont(new Font("Product Sans",Font.BOLD,18));
    	
    	l = new JLabel("Enter File Number :");
    	l.setBounds(90,290,160,40);
    	l.setFont(new Font("Product Sans",Font.BOLD,18));
    	
    	downindi = new JButton("Download File");
    	downindi.setBounds(90,360,150,40);
    	downindi.setFont(new Font("Product Sans",Font.BOLD,18));
    	downindi.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				
  				String m = fileinput.getText();
  								
              String SQL="SELECT *FROM dsanotes where file_id = ?";
 				
 				
 					if(m.isEmpty()) {
 						
 						JOptionPane.showMessageDialog(null,"Incomplete Information");
 						
 					}
 					else {
 						
 					try{
 					String result =" ";
 					File za = null;
 	 				String path = null;
 	 				
 	 				JFileChooser choose = new JFileChooser();
 	 				choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
 					int res = choose.showOpenDialog(null);
 						
 					if (res == JFileChooser.APPROVE_OPTION){
 							
 						za = new File (choose.getSelectedFile().getAbsolutePath());
 						path = za.getPath();
 						
 						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
 						
 	 					PreparedStatement ps = connection.prepareStatement(SQL);
 	 					ps.setString(1, m);
 	 					
 						ResultSet rs = ps.executeQuery();
 	 					int i =0;
 	 					
 	 					while (rs.next()) {
 	 						
 	 						i++;
 	 						int fileId = rs.getInt("file_id");
 	 						result += " " +fileId;
 	 						String fileName = rs.getString("file_name");
 	 						result += " " +fileName;
 	 						String fileExtension = rs.getString("file_extension");
 	 						result += " " +fileExtension;
 	 						Blob blob = rs.getBlob("file_content");
 	 						result += "\n";
 	 						InputStream inputStream = blob.getBinaryStream();
 	 						Files.copy(inputStream, Paths.get(path+"/"+fileName),StandardCopyOption.REPLACE_EXISTING);
 	 					}
 	 					
 	 					files.setText(result);
 	 					
 	 					JOptionPane.showMessageDialog(null,"Download Successful!!!");
 							
 					}
 					else {
 						
 						JOptionPane.showMessageDialog(null,"Download Unsuccessful");
 					}
 							
 				} catch (IOException e1) {
 					e1.printStackTrace();
 				} catch (SQLException e2) {
 					
					e2.printStackTrace();
				}	
 				}
  				
  			}
            	 
           });     
    	
    	uploadall = new JButton("Download All");
        uploadall.setBounds(300,360,150,40);//(250,100,250,50)
    	
    	percentage = new JLabel();
    	percentage.setBounds(200,300,500,50);
    	percentage.setOpaque(true);
    	percentage.setBackground(Color.white);
    	

    	imglabel = new JLabel();
    	imglabel.setIcon(student);
    	imglabel.setBounds(50,180,350,350);

         f = new JFrame();
         f.setLayout(null);
         //f.getContentPane().setBackground(new Color(0xFFDAB9));
         //f.(new Color(0xFBC4AB));
         f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

         attendance = new JPanel();
         attendance.setLayout(null);
         attendance.setBackground(Color.white);//new Color(0xFFDAB9)
         attendance.setBounds(300,150,700,500);
         attendance.setBorder(new BorderUIResource.BevelBorderUIResource(4));
         attendance.setVisible(false);
         
         
         note = new JPanel();
         note.setLayout(null);
         note.setBackground(Color.white);
         note.setBounds(300,150,700,500);
         note.setBorder(new BorderUIResource.BevelBorderUIResource(4));
         note.setVisible(true);
         
         inst_notice = new JPanel();
         inst_notice.setLayout(null);
         inst_notice.setBackground(Color.white);
         inst_notice.setBounds(300,150,700,500);
         inst_notice.setBorder(new BorderUIResource.BevelBorderUIResource(4));
         inst_notice.setVisible(false);
         
         notice_area = new JTextArea();
    	 notice_area.setBounds(90,10,500,250);
    	 notice_area.setBorder(bordertextarea);
    	 notice_area.setLineWrap(true);
    	 notice_area.setEditable(false);
    	 notice_area.setFont(new Font("Product Sans", Font.PLAIN, 16));
    	 note.add(notice_area);
      
         subject_name = new JLabel(z);
         subject_name.setFont(new Font("Product Sans",Font.BOLD,50));
         subject_name.setBounds(130,30,200,100);
         subject_name.setForeground(Color.white);
         
         back = new JButton("BACK");
         back.setBounds(20,55,90,50);
         back.setBorder(null);
         back.setBackground(Color.white);
         back.setFocusable(false);
         back.addActionListener(new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				
  				f.dispose();
  				student_subject k = new student_subject(input_user_id);  				
  				
  			}
            	 
           });      

         opt = new JPanel();
         opt.setLayout(null);
         opt.setBounds(0,150,300,500);
         opt.setBackground(new Color(0xec2525));//new Color(0xFFDAB9)
         //opt.setBorder(opt_border);
         
//         =========================================================================
         
         
         files = new JTextArea();
         files.setText("Hi there");
         files.setBorder(bordertextarea);
         files.setEditable(false);
         files.setLineWrap(true);
         files.setBounds(90,10,500,250);
         
         
         uploadall.setFocusable(false);
         uploadall.setFont(new Font("Product Sans",Font.BOLD,18));
         uploadall.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				String SQL="SELECT *FROM dsanotes";
 				
 				try{
 					
 					String result =" ";
 					File za = null;
 	 				String path = null;
 	 				
 	 				JFileChooser choose = new JFileChooser();
 	 				choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
 					int res = choose.showOpenDialog(null);
 						
 					if (res == JFileChooser.APPROVE_OPTION){
 							
 						za = new File (choose.getSelectedFile().getAbsolutePath());
 						path = za.getPath();
 						
 						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
 						
 	 					PreparedStatement ps = connection.prepareStatement(SQL);
 	 					
 						ResultSet rs = ps.executeQuery();
 	 					int i =0;
 	 					
 	 					while (rs.next()) {
 	 						
 	 						i++;
 	 						int fileId = rs.getInt("file_id");
 	 						result += " " +fileId;
 	 						String fileName = rs.getString("file_name");
 	 						result += " " +fileName;
 	 						String fileExtension = rs.getString("file_extension");
 	 						result += " " +fileExtension;
 	 						Blob blob = rs.getBlob("file_content");
 	 						result += "\n";
 	 						InputStream inputStream = blob.getBinaryStream();
 	 						Files.copy(inputStream, Paths.get(path+"/"+fileName),StandardCopyOption.REPLACE_EXISTING);
 	 					}
 	 					
 	 					files.setText(result);
 	 					
 	 					JOptionPane.showMessageDialog(null,"Download Successful!!!");
 							
 					}
 					else {
 						
 						JOptionPane.showMessageDialog(null,"Download Unsuccessful");
 					}
 							
 				} catch (IOException e1) {
 					e1.printStackTrace();
 				} catch (SQLException e2) {
 					
					e2.printStackTrace();
				}	
 			}
         	 
          });
         
         refresh = new JButton("Refresh");
    	 refresh.setBounds(90,260,100,30);
    	 refresh.setFocusable(false);
    	 refresh.setFont(new Font("Product Sans", Font.PLAIN, 16));
    	 
    	 
    	 refresh.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				try {
    	  				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
    	  				
    	  				PreparedStatement Pstatement=connection.prepareStatement("select noticeText from instNotice where srno = 1");
    	  				    	  				
    	  				ResultSet m = Pstatement.executeQuery();
    	  				
    	  				if(m.next()) {
    	  					
    	  					String j = m.getString("noticeText");
    	  					notice_area.setText(j);	
    	  				}
    	  				}
    	  				catch (SQLException e1) {
    	  	    	        e1.printStackTrace();
    	  	    	    }    				
    			}
            	 
             });

         bnotes = new JButton("Notes");
         batendance = new JButton("Attendance");
         binstantNotice = new JButton("Instant Notice");

         bnotes.setBorderPainted(false);
         binstantNotice.setBorderPainted(false);
         batendance.setBorderPainted(false);

         bnotes.setBounds(0,30,300,50);
         batendance.setBounds(0,100,300,50);
         binstantNotice.setBounds(0,170,300,50);

         binstantNotice.setBackground(new Color(0xec2525));
         batendance.setBackground(new Color(0xec2525));
         bnotes.setBackground(Color.white);
         
         bnotes.setFont(new Font("Product Sans", Font.BOLD, 20));
         binstantNotice.setFont(new Font("Product Sans", Font.BOLD, 20));
         batendance.setFont(new Font("Product Sans", Font.BOLD, 20));
         
         bnotes.setHorizontalAlignment(SwingConstants.CENTER);
         binstantNotice.setHorizontalAlignment(SwingConstants.CENTER);
         batendance.setHorizontalAlignment(SwingConstants.CENTER);
         
         binstantNotice.setForeground(Color.white);
         bnotes.setForeground(new Color(0xec2525));
         batendance.setForeground(Color.white);
         
         batendance.setFocusable(false);
         binstantNotice.setFocusable(false);
         bnotes.setFocusable(false);
         
         
         batendance.addActionListener(new ActionListener() {

   			@Override
   			public void actionPerformed(ActionEvent e) {
   				// TODO Auto-generated method stub
   				
   				try {
   				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
   				
   				PreparedStatement Pstatement=connection.prepareStatement("select " +input_user_id +" from attendance");
   				
   				ResultSet result = Pstatement.executeQuery();
   				float total=0;
   				float sum = 0;
   				
   				while(result.next()) {
   					
   					total++;
   					String one = "1";
   					String m = result.getString(input_user_id);
//   					System.out.println(m);
   					
   					if(m.equals(one)){
   						sum++;
   					}   					
   				}
   				float perc;
   				perc = sum*100/total;
   				percentage.setText("Your attendance is "+perc+"%");
   				
   				}
   				catch (SQLException e1) {
   	    	        e1.printStackTrace();
   	    	    }			
   			}
           	 
            });
         
         l_date = new JLabel("Enter current date : ");
         l_date.setBounds(50,80,200,30);
         l_date.setFont(new Font("Product Sans", Font.PLAIN, 18));
         
         l_code = new JLabel("Enter code given by Teacher :");
         l_code.setBounds(50,130,250,30);
         l_code.setFont(new Font("Product Sans", Font.PLAIN, 18));
         
         t_date = new JTextField();
         t_date.setLayout(null);
         t_date.setBounds(300, 80, 100, 30);
         t_date.setFont(new Font("Product Sans", Font.PLAIN, 15));
         
         t_code = new JTextField();
         t_code.setLayout(null);
         t_code.setBounds(300, 130, 100, 30);
         t_code.setFont(new Font("Product Sans", Font.PLAIN, 15));
         
         submit = new JButton("Mark Present");
         submit.setBounds(200,200,200,30);
         submit.setBorderPainted(false);
         submit.setFont(new Font("Product Sans", Font.PLAIN, 16));
         
         submit.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e) {
      		   
      		   if(e.getSource()==submit){
      				
      				try {
      					
      					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
      					
      					String date = t_date.getText();
      					String code = t_code.getText();
      					       
      	    	        PreparedStatement P=connection.prepareStatement("select * from code where srno=1");
      	    	        
      	    	        ResultSet r = P.executeQuery();
      	    	        
      	    	        if(r.next()){
      	    	        	
      	    	        	String r_date = r.getString("currentDate");
      	    	        	String r_code = r.getString("otp");
      	    	        	
      	    	        	
      	    	        	System.out.println(input_user_id);
      	    	        	if(r_date.equals(date)){
      	    	        		
      	    	        		if(r_code.equals(code)){
      	    	        			
      	        	        		PreparedStatement s = connection.prepareStatement("Update attendance Set "+ input_user_id +"= true where Dates = ?");
      	        	        		s.setString(1,r_date);
      	        	        		s.executeUpdate();
      	    	        			
      	    	        			JOptionPane.showMessageDialog(null," Attendance marked Succesfully");
      	        	        		
      	        	        	}
      	    	        		else {
      	    	        			
      	    	        			JOptionPane.showMessageDialog(null," Wrong Code");
      	    	        		}
      	    	        		
      	    	        	}
      	    	        	else {
      	    	        		
      	    	        		JOptionPane.showMessageDialog(null," Wrong Date");
      	    	        		
      	    	        	}
      	    	        }	
      				}
      				catch (SQLException e1){
      	    	        e1.printStackTrace();
      	    	    }
      		   }
      		   }
      		});
         
         inst_notice.add(refresh);
         inst_notice.add(notice_area);
         
         note.add(uploadall);
         note.add(files);

         opt.add(bnotes);
         opt.add(batendance);
         opt.add(binstantNotice);
        // opt.add(att_cover);
        // opt.add(notes_cover);

         f.setBounds(200,50,1000,650);
         f.setResizable(true);

         f.add(opt);        
//         f.add(back);
//         f.add(subject_name);        
         f.add(note);
         f.add(attendance);
         f.add(inst_notice);
                 
         attendance.add(l_date);
         attendance.add(l_code);
         attendance.add(t_date);
         attendance.add(t_code);
         attendance.add(submit);
         attendance.add(percentage);
         opt.add(imglabel);
         
         batendance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(!attendance.isVisible()) {
					attendance.setVisible(true);
					note.setVisible(false);
					inst_notice.setVisible(false);
					
 					batendance.setBackground(Color.white);
 					batendance.setForeground(new Color(0xec2525));
 					
 					bnotes.setBackground(new Color(0xec2525));
 					bnotes.setForeground(Color.white);
 					
 					binstantNotice.setBackground(new Color(0xec2525));
  					binstantNotice.setForeground(Color.white);
				}
//				
			}
        	 
         });
         
         bnotes.addActionListener(new ActionListener() {

   			@Override
   			public void actionPerformed(ActionEvent e) {
   				// TODO Auto-generated method stub
   				if(!note.isVisible()) {
   					note.setVisible(true);
   					attendance.setVisible(false);
   					inst_notice.setVisible(false);
   					
   					bnotes.setBackground(Color.white);
   					bnotes.setForeground(new Color(0xec2525));
   					
   					batendance.setBackground(new Color(0xec2525));
   					batendance.setForeground(Color.white);
   					
   					binstantNotice.setBackground(new Color(0xec2525));
    					binstantNotice.setForeground(Color.white);
    					
   				}
   				
   				String newLine = System.getProperty("line.separator");
   				
   				String SQL="SELECT *FROM dsanotes";
   				
   				
   				
                try{
 					
 					String result =" ";
 						
 						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
 						
 	 					PreparedStatement ps = connection.prepareStatement(SQL);
 	 					
 						ResultSet rs = ps.executeQuery();
 	 					int i =0;
 	 					
 	 					while (rs.next()) {
 	 						
 	 						i++;
 	 						int fileId = rs.getInt("file_id");
 	 						result += "\t " +fileId;
 	 						String fileName = rs.getString("file_name");
 	 						result += "\t" +fileName;
 	 						String fileExtension = rs.getString("file_extension");
// 	 						result += " " +fileExtension;
 	 						Blob blob = rs.getBlob("file_content");
 	 						result += "\n";
 	 					}
 	 					
 	 					files.setText(result);
 	 					
// 	 					JOptionPane.showMessageDialog(null,"print Successful!!!");
 										
 							
 				} catch (SQLException e2) {
 					
					e2.printStackTrace();
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
  					binstantNotice.setForeground(new Color(0xec2525));
  					
  					bnotes.setBackground(new Color(0xec2525));
  					bnotes.setForeground(Color.white);
  					
  					batendance.setBackground(new Color(0xec2525));
  					batendance.setForeground(Color.white);
  				}
  			}
          	 
           });
         header.add(back);
         header.add(subject_name);
         header.add(imglable0);
         note.add(fileinput);
     	note.add(l);
     	note.add(downindi);
     	f.add(header);
         
         f.setVisible(true);
    }
    
}

