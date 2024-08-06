
package hospital.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
//import java.awt.event.ActiveEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartUpScreen extends JFrame implements ActionListener {
    StartUpScreen(){
    	  getContentPane().setBackground(Color.WHITE);
    	  setLayout(null);
    	     	  
    	  JLabel heading=new JLabel("Patient Management System");
    	  heading.setBounds(170,40,1200,60);
    	  heading.setFont(new Font("serif",Font.BOLD,60));
    	  heading.setForeground(Color.WHITE);
    	  add(heading);
    	  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1100, 700);
        add(image);
        
        JButton clickhere=new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(380, 500, 260, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
    	  add(clickhere);
    	 setSize(1100,650);
    	 setLocation(200,50);
    	 setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
       
      }
    @Override
      public void actionPerformed(ActionEvent ae) {
    	  setVisible(false);
    	  new Login();
      }
	public static void main(String[] args) {
	 new StartUpScreen();
	

	}

}
