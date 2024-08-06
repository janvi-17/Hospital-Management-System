package hospital.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
public class ViewDoctor extends JFrame implements ActionListener {
    JTable table;
	Choice cdname;
	JButton search,print,update,back;
	ViewDoctor(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel searchlbl=new JLabel("Search by Doctor Name");
		searchlbl.setBounds(20,20,150,20);
		add(searchlbl);
		
		 cdname=  new Choice();
		 cdname.setBounds(170, 20, 150,20);
		 add(cdname);
		 
		 table=new JTable();
		 try {
			 Conn c=new Conn();
			 ResultSet rs=c.s.executeQuery("select * from doctordata");
                         //table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 while(rs.next()) {
				 cdname.add(rs.getString("name"));
			 }
		 
                 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 try {
				 Conn con=new Conn();
				 ResultSet rs=con.s.executeQuery("select * from doctordata");
				 table.setModel(DbUtils.resultSetToTableModel(rs));
				 while(rs.next()) {
					 cdname.add(rs.getString("name"));
				 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 JScrollPane jsp= new JScrollPane(table);
		 jsp.setBounds(40,100,800,500);
		 add(jsp);
		 
		 search =new JButton("Search");
		 search.setBounds(60,70,80,20);
                 search.addActionListener(this);
		 add(search);
		 
		 print =new JButton("Print");
		 print.setBounds(160,70,80,20);
                 print.addActionListener(this);
		 add(print);
		 
		  update =new JButton("Update");
		 update.setBounds(260,70,80,20);
                 update.addActionListener(this);
		 add(update);
		 
		 back =new JButton("Back");
		 back.setBounds(360,70,80,20);
                 back.addActionListener(this);
		 add(back);
	    setSize(900,700);
	    setLocation(300,100);
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==search) {
			String query="select * from doctordata where name='"+cdname.getSelectedItem()+"'";
			try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==print) {
			try {
				table.print();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==update) {
                    setVisible(false);
			new UpdateDoctor(cdname.getSelectedItem());
		}
	    else {
		setVisible(false);
                new Home();
	
	}
}
	public static void main(String[] args) {
		new ViewDoctor();

	}

}
