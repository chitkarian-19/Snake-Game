package default_Package;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Main  {
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       
       //Rules
       JFrame jf_r = new JFrame();
		jf_r.setBounds(158,60,900,700);
	    jf_r.setVisible(true);
	    jf_r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    JButton jbtn = new JButton("Proceed");
	    jbtn.setBounds(350,600,200,25);
	    
	    jf_r.add(jbtn);
	    
	    Rule rule = new Rule();
	    jf_r.add(rule);
	    jbtn.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		// TODO Auto-generated method stub
	    		jf_r.setVisible(false);
	    		JFrame jf = new JFrame();
	    	       jf.setBounds(10,10,905,700);
	    	       jf.getContentPane().setBackground(Color.DARK_GRAY);
	    	      
	    	       jf.setResizable(false);
	    	       jf.setVisible(true);
	    	       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	       GamePanel gameplay = new GamePanel();
	    	       jf.add(gameplay);
	    	}
	    });
	   
       
	}
}