package default_Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Rule extends JPanel{
     private ImageIcon title;
	 Rule(){
    	 
     }
     
     public void paint(Graphics g) {
    	 //SET Border color
    	 g.setColor(Color.WHITE);
    	 g.drawRect(24, 10, 800, 55);
    	 
    	 title = new ImageIcon("snaketitle.jpg");
    	 title.paintIcon(this,g,25,11);
    	 
    	 g.setColor(Color.BLACK);
    	 g.setFont(new Font("Arial",Font.BOLD,30));
    	 g.drawString("This is Rule Window",300,100);
    	 g.drawLine(290, 105, 592, 105);
    	 //Rule 1
    	 g.setColor(Color.BLACK);
    	 g.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
    	 g.drawString("Rule 1: Make sure to load all the components properly in the required application.",70,140);
    	 g.drawString("Rule 2: Game consists of 5 Levels, each having 20 points.",70,190);
    	 g.drawString("Rule 3: You can restart game by pressing SPACE Button.",70,240);
    	 g.drawString("Rule 4: Press SPACE when qualified for the present level to go next level.",70,290);
    	 g.setFont(new Font("Arial",Font.BOLD,30));
    	 g.drawString(" Description of the Levels ",260,350);
    	 g.setColor(Color.BLACK);
    	 g.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
    	 g.drawLine(260, 360, 640, 360);
    	 g.drawString("Level 1: Snake need to eat the enemy without colliding the snake body with itself.",40,390);
    	 g.drawString("Level 2: Snake need to eat the enemy without colliding with it's body and mines.",40,430);
    	 g.drawString("Level 3: Snake need to eat the enemy without colliding with it's body and mines.",40,470);
    	 g.drawString("Level 4: Snake need to eat the enemy without colliding with it's body, mines and walls .",40,510);
    	 g.drawString("Level 5: Ultra Hard Mode, the speed of snake is very fast here.",40,550);
     }
}
