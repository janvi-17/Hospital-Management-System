

package hospital.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Home extends JFrame implements ActionListener {
    JButton view,add,update,remove,
            view1,add1,update1,remove1;
	Home(){
		
	   getContentPane().setBackground(Color.WHITE);
  	   setLayout(null);
  	 
  	 JLabel heading=new JLabel("Patient Management System");
  	 heading.setBounds(770,40,400,40);
  	 heading.setFont(new Font("Railway",Font.BOLD,25));
	 add(heading);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
	 Image i2=i1.getImage().getScaledInstance(1190, 630, Image.SCALE_DEFAULT);
	 ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
	 image.setBounds(0,0, 1190, 630);
	 add(image); 
	   
	 add=new JButton("Add Patient Details");
	 add.setBounds(770,100,150,40);
	 add.addActionListener(this);
	 add(add);
           
         add1=new JButton("Add Doctor Details");
	 add1.setBounds(950,100,150,40);
	 add1.addActionListener(this);
	 add(add1);
	   
	 view=new JButton("View Patient Details");
	 view.setBounds(770,150,150,40);
	 view.addActionListener(this);
	 add(view);
           
         view1=new JButton("View Doctor Details");
	 view1.setBounds(950,150,150,40);
	 view1.addActionListener(this);
	 add(view1);

	 update=new JButton("Update Patient Details ");
	 update.setBounds(770,200,150,40);
	 update.addActionListener(this);
	 add(update);
           
         update1=new JButton("Update Doctor Details");
	 update1.setBounds(950,200,150,40);
	 update1.addActionListener(this);
	 add(update1);

	/* remove=new JButton("Remove Patient Details");
	 remove.setBounds(770,250,150,40);
	 remove.addActionListener(this);
	 add(remove);

	 remove1=new JButton("Remove Doctor Details");
	 remove1.setBounds(950,250,150,40);
	 remove1.addActionListener(this);
	 add(remove1);
	   */
	 setSize(1190,650);
	 setLocation(250,100);
	 setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== add) {
			setVisible(false);
			new AddPatient();
		}if(e.getSource()== add1) {
			setVisible(false);
			new AddDoctor();
		}if(e.getSource()== view) {
                    setVisible(false);
                    new ViewPatient();
		}
                if(e.getSource()== view1) {
			setVisible(false);
			new ViewDoctor();
		}if(e.getSource()==update) {
			setVisible(false);
			new ViewPatient();
		}if(e.getSource()==update1) {
                    setVisible(false);
                    new ViewDoctor();
                }
                /*
                if(e.getSource() == remove){
                    setVisible(false);
                    new RemovePatient();
                }if(e.getSource() == remove1){
                     setVisible(false);  
                   new RemoveDoctor();
		}
                */
		}
	
	public static void main(String[] args) {
		new Home();
	}

	

}
