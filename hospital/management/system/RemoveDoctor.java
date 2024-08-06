
package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveDoctor extends JFrame implements ActionListener {
    Choice cname;
	JButton delete,back;
	
	RemoveDoctor (){
		getContentPane().setBackground(Color.WHITE);
		  setLayout(null);
		  
		  JLabel labelname=new JLabel("Doctor Name");
		  labelname.setBounds(50,50,100,30);
		  add(labelname);
		  cname=new Choice();
		  cname.setBounds(200,52,150,30);
		  add(cname);
		  
		  try {
			  Conn c=new Conn();
			  String query="select*from doctor";
			  ResultSet rs=c.s.executeQuery(query);
			  while(rs.next()){
				  cname.add(rs.getString("name"));
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  JLabel labeluname=new JLabel("Username");
		  labeluname.setBounds(50,100,100,30);
		  add(labeluname);
		  
		  JLabel lbluname=new JLabel();
		  lbluname.setBounds(200,100,100,30);
		  add(lbluname);
		  
		  JLabel labelphone=new JLabel("Phone");
		  labelphone.setBounds(50,150,100,30);
		  add(labelphone);
		  
		  JLabel lblphone=new JLabel();
		  lblphone.setBounds(200,150,100,30);
		  add(lblphone);
		  
		  JLabel labelemail=new JLabel("Email");
		  labelemail.setBounds(50,200,100,30);
		  add(labelemail);
		  
		  JLabel lblemail=new JLabel();
		  lblemail.setBounds(200,200,100,30);
		  add(lblemail);
		  
		  try {
			  Conn c=new Conn();
			  String query="select * from doctor where name='"+cname.getSelectedItem()+"'";
			 ResultSet rs=c.s.executeQuery(query);
			  while(rs.next()){
				 lbluname.setText(rs.getString("uname"));
				 lblphone.setText(rs.getString("phone"));
				 lblemail.setText(rs.getString("email"));
				  
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  cname.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent ic) {
				  try {
					  Conn c=new Conn();
					  String query="select * from doctor where name='"+cname.getSelectedItem()+"'";
					 ResultSet rs=c.s.executeQuery(query);
					  while(rs.next()){
						 lbluname.setText(rs.getString("uname"));
						 lblphone.setText(rs.getString("phone"));
						 lblemail.setText(rs.getString("email"));
						  
					  }
				  }catch(Exception e) {
					  e.printStackTrace();
				  }
				  

			  }
		  });
		  
		  delete =new JButton("Delete");
		  delete.setBounds(80,300,100,30);
		  delete.setBackground(Color.BLACK);
		  delete.setForeground(Color.WHITE);
		  delete.addActionListener(this);
		  add(delete);
		  
		  back =new JButton("Back");
		  back.setBounds(220,300,100,30);
		  back.setBackground(Color.BLACK);
		  back.setForeground(Color.WHITE);
		  back.addActionListener(this);
		  add(back);
		  
		  ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/doctor1.jpg"));
			Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(380,0,600,400);
			add(image);
		  setSize(1000,400);
		  setLocation(300,150);
		  setVisible(true);
		  
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==delete) {
			try {
				Conn c=new Conn();
				String query="delete from doctor where name='"+cname.getSelectedItem()+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null," Doctor information deleted successfully");
				setVisible(false);
				new Home();
			}catch(Exception ae) {
				ae.printStackTrace();
		}
		}else {
			setVisible(false);
			new Home();
		}
		}
	
			
		
	
	
	
	public static void main(String[] args) {
		new RemoveDoctor();
	}

}
