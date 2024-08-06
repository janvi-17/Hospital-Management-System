
package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateDoctor extends JFrame implements ActionListener{
    JTextField tfmedicine,tfemail,tfadd,tfphone,tfcity ;
        JLabel lblname;
	JButton update,back;
	String name;
	UpdateDoctor(String name){
		this.name =name;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Update Doctor Details");
		heading.setBounds(280,30,500,50);
		heading.setFont(new Font("San_Serif",Font.BOLD,30));
		add(heading);
		
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50,180,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelname);
		
		 lblname=new JLabel();
		lblname.setBounds(180, 180, 150, 30);
		add(lblname);
		
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
		
	        JLabel lbldob=new JLabel();
		lbldob.setBounds(180, 230, 150, 30);
		add(lbldob);
		
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
		
		 JLabel lblg=new JLabel();
		lblg.setBounds(180, 330, 150, 30);
		add(lblg);
		
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
		
	        JLabel lblbg=new JLabel();
		lblbg.setBounds(180, 380, 150, 30);
		add(lblbg);
		
		JLabel labelsp=new JLabel("Spealization");
		labelsp.setBounds(360,380,150,30);
		labelsp.setFont(new Font("serif",Font.PLAIN,20));
		add(labelsp);
		
		 JLabel lblsp =new JLabel();
		lblsp.setBounds(500, 380, 150, 30);
		add(lblsp);
		
                try{
                    Conn c = new Conn();
                    String query = "select * from doctordata where name = '"+name+"'";
                   ResultSet rs = c.s.executeQuery(query);
                   while(rs.next()){
                       lblname.setText(rs.getString("name"));
                       tfmedicine.setText(rs.getString("medicine"));
                       lbldob.setText(rs.getString("dob"));
                       tfemail.setText(rs.getString("email"));
                      tfadd.setText(rs.getString("address"));
                       tfphone.setText(rs.getString("phone"));
                     lblg.setText(rs.getString("gender"));
                       tfcity.setText(rs.getString("city"));
                      lblbg.setText(rs.getString("bloodg"));
                     lblsp.setText(rs.getString("spl"));
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
			String medicine=tfmedicine.getText();
			//String dob=tfdob.getText();
			String email=tfemail.getText();
                        String address=tfadd.getText();
			//String fname=tffname.getText();
			String phone= tfphone.getText();
			//String matstatus=tfms.getText();
			String city=tfcity.getText();
			
			
			//String pId=lblpId.getText();
			
			try {
				Conn c= new Conn();
				String query="update  doctordata set medicine = '"+medicine+"',email='"+email+"',address='"+address+"',phone ='"+phone+"',city ='"+city+"' where name ='"+name+"'";
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
		new UpdateDoctor("");

	}

}
