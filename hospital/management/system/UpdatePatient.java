package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdatePatient extends JFrame implements ActionListener  {
     JTextField tfuname,tfemail,tffname,tfphone,tfdis,tfcity ,tfadd;
	
	JLabel lblpId;
	JButton update,back;
	String pId;
	UpdatePatient(String pId){
		this.pId =pId;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Update Patient Details");
		heading.setBounds(280,30,500,50);
		heading.setFont(new Font("San_Serif",Font.BOLD,25));
		add(heading);
		
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50,150,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelname);
		
		 JLabel lblname=new JLabel();
		lblname.setBounds(180, 150, 150, 30);
		add(lblname);
		
		JLabel labeluname=new JLabel("Username");
		labeluname.setBounds(360,150,150,30);
		labeluname.setFont(new Font("serif",Font.PLAIN,20));
		add(labeluname);
		
		 tfuname=new JTextField();
		tfuname.setBounds(500, 150, 150, 30);
		add(tfuname);
		
		JLabel labeldob=new JLabel("DOB");
		labeldob.setBounds(50,200,150,30);
		labeldob.setFont(new Font("serif",Font.PLAIN,20));
		add(labeldob);
		
	        JLabel lbldob=new JLabel();
		lbldob.setBounds(180, 200, 150, 30);
		add(lbldob);
		
		JLabel labelemail=new JLabel("Email");
		labelemail.setBounds(360,200,150,30);
		labelemail.setFont(new Font("serif",Font.PLAIN,20));
		add(labelemail);
		
	        tfemail=new JTextField();
		tfemail.setBounds(500, 200, 150, 30);
		add(tfemail);
		
		JLabel labelfname=new JLabel("Father Name");
		labelfname.setBounds(50,250,150,30);
		labelfname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelfname);
		
		tffname=new JTextField();
		tffname.setBounds(180, 250, 150, 30);
		add(tffname);
		
		JLabel labelphone=new JLabel("Phone No.");
		labelphone.setBounds(360,250,150,30);
		labelphone.setFont(new Font("serif",Font.PLAIN,20));
		add(labelphone);
		
		 tfphone=new JTextField();
		tfphone.setBounds(500, 250, 150, 30);
		add(tfphone);
		
		JLabel labelbg=new JLabel("Blood Group");
		labelbg.setBounds(50,300,150,30);
		labelbg.setFont(new Font("serif",Font.PLAIN,20));
		add(labelbg);
		
		JLabel lblms=new JLabel();
		lblms.setBounds(180, 300, 150, 30);
		add(lblms);
		
		JLabel labelcity=new JLabel("City");
		labelcity.setBounds(360,300,150,30);
		labelcity.setFont(new Font("serif",Font.PLAIN,20));
		add(labelcity);
		
		
		 tfcity=new JTextField();
		tfcity.setBounds(500, 300, 150, 30);
		add(tfcity);
		
		JLabel labeldis=new JLabel("Disease");
		labeldis.setBounds(50,350,150,30);
		labeldis.setFont(new Font("serif",Font.PLAIN,20));
		add(labeldis);
		
	        tfdis=new JTextField();
		tfdis.setBounds(180, 350, 150, 30);
		add(tfdis);
		
		JLabel labeladd=new JLabel("Address");
		labeladd.setBounds(360,350,150,30);
		labeladd.setFont(new Font("serif",Font.PLAIN,20));
		add(labeladd);
		
		tfadd=new JTextField();
		tfadd.setBounds(500, 350, 150, 30);
		add(tfadd);
		
		JLabel labelpId=new JLabel("Patient Number");
		labelpId.setBounds(50,400,150,30);
		labelpId.setFont(new Font("serif",Font.PLAIN,20));
		add(labelpId);
		
		lblpId=new JLabel();
		lblpId.setBounds(200,400,150,30);
		lblpId.setFont(new Font("serif",Font.PLAIN,20));
		add(lblpId);
                
                try{
                    Conn c = new Conn();
                    String query = "select * from patientdata where pid = '"+pId+"'";
                   ResultSet rs = c.s.executeQuery(query);
                   while(rs.next()){
                       lblname.setText(rs.getString("name"));
                       tfuname.setText(rs.getString("uname"));
                       lbldob.setText(rs.getString("dob"));
                       tfemail.setText(rs.getString("email"));
                       tffname.setText(rs.getString("fname"));
                       tfphone.setText(rs.getString("phone"));
                       lblms.setText(rs.getString("bloodgroup"));
                       tfcity.setText(rs.getString("city"));
                       tfdis.setText(rs.getString("disease"));
                       tfadd.setText(rs.getString("address"));
                       lblpId.setText(rs.getString("pid"));
                   }
                }catch(Exception e){
                    e.printStackTrace();
                }
		
		 update=new JButton("Update Details");
		 update.setBounds(250,550,150,40);
		 update.addActionListener(this);
		 update.setBackground(Color.BLACK);
		 update.setForeground(Color.WHITE);
		  add(update);
		   
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
		if( ae.getSource()==update) {
			//String name=tfname.getText();
			String uname=tfuname.getText();
			//String dob=tfdob.getText();
			String email=tfemail.getText();
			String fname=tffname.getText();
			String phone= tfphone.getText();
			//String matstatus=tfms.getText();
			String city=tfcity.getText();
			String disease = tfdis.getText();
			String address=tfadd.getText();
			//String pId=lblpId.getText();
			
			try {
				Conn c= new Conn();
				String query="update  patient set uname = '"+uname+"',email='"+email+"',fname='"+fname+"',phone ='"+phone+"',city ='"+city+"',disease='"+disease+"',address='"+address+"'where pId ='"+pId+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Updated successfully");
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
		new UpdatePatient("");

	}

}
