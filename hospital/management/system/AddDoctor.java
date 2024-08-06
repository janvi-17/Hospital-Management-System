package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class AddDoctor extends JFrame implements ActionListener{
    Random ran= new Random();
	int number=ran.nextInt(100);
	
	JTextField tfname,tfmedicine,tfdob,tfemail,tfadd,tfphone,tfg,tfcity,tfbg ,tfsp;

	JButton add,back;
	
	AddDoctor(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Add Doctor Details");
		heading.setBounds(280,30,500,50);
		heading.setFont(new Font("San_Serif",Font.BOLD,30));
		add(heading);
		
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50,180,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelname);
		
		 tfname=new JTextField();
		tfname.setBounds(180, 180, 150, 30);
		add(tfname);
		
		JLabel labelmedicine=new JLabel("Medicine");
		labelmedicine.setBounds(360,180,150,30);
		labelmedicine.setFont(new Font("serif",Font.PLAIN,20));
		add(labelmedicine);
		
		 tfmedicine=new JTextField();
		tfmedicine.setBounds(500, 180, 150, 30);
		add(tfmedicine);
		
		JLabel labeldob=new JLabel("DOB");
		labeldob.setBounds(50,230,150,30);
		labeldob.setFont(new Font("serif",Font.PLAIN,20));
		add(labeldob);
		
	        tfdob=new JTextField();
		tfdob.setBounds(180, 230, 150, 30);
		add(tfdob);
		
		JLabel labelemail=new JLabel("Email");
		labelemail.setBounds(360,230,150,30);
		labelemail.setFont(new Font("serif",Font.PLAIN,20));
		add(labelemail);
		
	        tfemail=new JTextField();
		tfemail.setBounds(500, 230, 150, 30);
		add(tfemail);
		
		JLabel labeladd=new JLabel("Address");
		labeladd.setBounds(50,280,150,30);
		labeladd.setFont(new Font("serif",Font.PLAIN,20));
		add(labeladd);
		
		tfadd=new JTextField();
		tfadd.setBounds(180, 280, 150, 30);
		add(tfadd);
		
		JLabel labelphone=new JLabel("Phone No.");
		labelphone.setBounds(360,280,150,30);
		labelphone.setFont(new Font("serif",Font.PLAIN,20));
		add(labelphone);
		
		 tfphone=new JTextField();
		tfphone.setBounds(500, 280, 150, 30);
		add(tfphone);
		
		JLabel labelg=new JLabel("Gender");
		labelg.setBounds(50,330,150,30);
		labelg.setFont(new Font("serif",Font.PLAIN,20));
		add(labelg);
		
		tfg=new JTextField();
		tfg.setBounds(180, 330, 150, 30);
		add(tfg);
		
		JLabel labelcity=new JLabel("City");
		labelcity.setBounds(360,330,150,30);
		labelcity.setFont(new Font("serif",Font.PLAIN,20));
		add(labelcity);
		
		
		 tfcity=new JTextField();
		tfcity.setBounds(500, 330, 150, 30);
		add(tfcity);
		
		JLabel labelbg=new JLabel("Blood Group");
		labelbg.setBounds(50,380,150,30);
		labelbg.setFont(new Font("serif",Font.PLAIN,20));
		add(labelbg);
		
	        tfbg=new JTextField();
		tfbg.setBounds(180, 380, 150, 30);
		add(tfbg);
		
		JLabel labelsp=new JLabel("Spealization");
		labelsp.setBounds(360,380,150,30);
		labelsp.setFont(new Font("serif",Font.PLAIN,20));
		add(labelsp);
		
		tfsp=new JTextField();
		tfsp.setBounds(500, 380, 150, 30);
		add(tfsp);
		
		 add=new JButton("Add Details");
		 add.setBounds(250,550,150,40);
		 add.addActionListener(this);
		 add.setBackground(Color.BLACK);
		 add.setForeground(Color.WHITE);
		  add(add);
		   
		 back=new JButton("Back");
	         back.setBounds(450,550,150,40);
		 back.addActionListener(this);
		 back.setBackground(Color.BLACK);
		 back.setForeground(Color.WHITE);
		   add(back);
		   
		setSize(800,700);
		setLocation(300,50);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if( ae.getSource()==add) {
			String name=tfname.getText();
			String medicine=tfmedicine.getText();
			String dob=tfdob.getText();
			String email=tfemail.getText();
			String address=tfadd.getText();
			String phone= tfphone.getText();
			String gender=tfg.getText();
			String city=tfcity.getText();
			String bloodg = tfbg.getText();
			String spl=tfsp.getText();
			
			try {
				Conn conn= new Conn();
				String query="insert into doctordata values('"+name+"','"+medicine+"','"+dob+"','"+email+"','"+address+"','"+phone+"','"+gender+"','"+city+"','"+bloodg+"','"+spl+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details added successfully");
				setVisible(false);
				new Home();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Home();
		}
	}

	public static void main(String[] args) {
		new AddDoctor();
        }
}

