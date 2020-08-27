package default_Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
   
   private int[] snakex = new int[750];
   private int[] snakey = new int[750];
   
   private boolean left= false;
   private boolean right= false;
   private boolean up= false;
   private boolean down= false;
   
   private ImageIcon rightmouth;
   private ImageIcon leftmouth;
   private ImageIcon downmouth;
   private ImageIcon upmouth;
   private ImageIcon  snakeimage;
   
   private Timer timer;
   private int delay=100;
   
   private ImageIcon titleImage;
   
   private int[] enemyxspace = {25,50,75,100,125,150,175,200,225,250,
		                         275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,
		                         775,800,825,850};
   
   private int[] enemyyspace = {75,100,125,150,175,200,225,250,
                                 275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
   
   private int[] enemyxspace2 = {25,50,75,100,125,150,650,675,700,725,750,775,800,825,850};
   private int[] enemyyspace2 = {75,100,125,150,175,200,225,250,325,350,425,450,475,500,525,550,575,600,625};
   
   private int[] enemyxspace3 = {25,50,75,100,125,725,750,775,800,825,850};
   private int[] enemyyspace3 = {75,100,125,150,175,250,275,300,325,400,425,450,475,550,575,600,625};
   
   private ImageIcon enemyImage;
   
   private Random random = new Random();
   
   private int xpos = random.nextInt(34);
   private int ypos = random.nextInt(23);
   
   private int snakelength=3;
   
   private int score=0;
   
   private int level = 1;
   private int flag=0;
   
   private int block=0;
   public  GamePanel()
   {
	   addKeyListener(this);// add keyl in this
	   setFocusable(true);
	   setFocusTraversalKeysEnabled(false);
	   timer = new Timer(delay, this);
	   timer.start();
   }
       private int moves=0;
   public void paint(Graphics g) 
   {
	   flag=0;
	   if(moves==0) {
		  snakex[2]=50;
		  snakex[1]=75;
		  snakex[0]=100;
		  
		  snakey[2]=100;
		  snakey[1]=100;
		  snakey[0]=100;
		  if(level==1)
		  {
			  xpos = random.nextInt(34);
			  ypos = random.nextInt(23);
		  }
		  else if(level==2) {
			  xpos = random.nextInt(15);
			  ypos = random.nextInt(19);
		  }
		  else if(level==3) {
			  xpos = random.nextInt(11);
			  ypos = random.nextInt(17);
		  }
	   }
	// draw title image border
	   if(level<=3)
	   {g.setColor(Color.white);
	   g.drawRect(24, 10, 851, 55);}
	   
	 //draw title image
	   titleImage = new ImageIcon("snaketitle.jpg");
	   titleImage.paintIcon(this,g,25,11);
	 
	  //draw border of gameplay
	   g.setColor(Color.white);
	   g.drawRect(24, 74, 851, 577);
	   
	   //draw background for the gameplay
	   g.setColor(Color.black);
	   g.fillRect(25, 75, 850, 575);
	   
	   //draw the scores 
	   
	   g.setColor(Color.WHITE);
	   g.setFont(new Font("arial",Font.PLAIN,14));
	   g.drawString("Score: "+score,780,30);
	   
	  //draw the length
	   g.setColor(Color.WHITE);
	   g.setFont(new Font("arial",Font.PLAIN,14));
	   g.drawString("Level: "+level,780,50);
	   
	   rightmouth = new ImageIcon("rightmouth.png");
	   if(block!=1)
	   rightmouth.paintIcon(this, g, snakex[0], snakey[0]);
       
	   for(int a=0;a<snakelength&&block!=1;a++) 
	   {
		
		   if(a==0 && right ) {
			   
			   rightmouth = new ImageIcon("rightmouth.png");
			   rightmouth.paintIcon(this, g, snakex[a], snakey[a]);
		   }
		   else if(a==0 && left ) {
			   
			   leftmouth = new ImageIcon("leftmouth.png");
			   leftmouth.paintIcon(this, g, snakex[a], snakey[a]);
		   }
		   else if(a==0 && up ) {
	   
	          upmouth = new ImageIcon("upmouth.png");
	          upmouth.paintIcon(this, g, snakex[a], snakey[a]);
           }
		   else if(a==0 && down ) {
	   
	          downmouth = new ImageIcon("downmouth.png");
	          downmouth.paintIcon(this, g, snakex[a], snakey[a]);
	          
           }
           
		   else if(a!=0) {
        	   snakeimage = new ImageIcon("snakeimage.png");
        	   snakeimage.paintIcon(this, g, snakex[a], snakey[a]);
        	  
           }
           
	   }
	   
	   if(level==2) {
		   g.setColor(Color.WHITE);
		   g.drawRect(175, 275, 450, 25);
		   g.setColor(Color.WHITE);
		   g.drawRect(175, 375, 450, 25);
		   
	   }
	   
	   if(level==3) {
		   g.setColor(Color.WHITE);
		   g.drawRect(300, 200, 250, 25);
		   g.drawRect(300, 500, 250, 25);
		   g.drawRect(150, 350, 550, 25);
		   
	   }
	   if(level>=4&&block==0) {
		   g.setColor(Color.WHITE);
		   g.drawRect(300, 200, 250, 25);
		   g.drawRect(300, 500, 250, 25);
		   g.drawRect(150, 350, 550, 25);
		   g.setColor(Color.RED);
		   g.drawRect(24, 74, 851, 577);
	   }
	   
	   if(level>=4&&block==1) {
   	    
   	       g.setColor(Color.RED);
		   g.setFont(new Font("arial",Font.BOLD,50));
		   g.drawString("Game over", 500, 500);
		   
		   g.setFont(new Font("arial",Font.BOLD,20));
		   g.drawString("Space To Re-start", 350, 340);
		   g.drawString(("Score: "+score), 350, 370);
		   
		   
		   
		   block=0;
        }
	   
	   enemyImage = new ImageIcon("enemy.png");
	   
	   if((level==1)&&(enemyxspace[xpos] == snakex[0])&&( enemyyspace[ypos] == snakey[0]))
	   {
		   snakelength++;
		  
		    xpos= random.nextInt(34);
		    ypos= random.nextInt(23);
		   
		   score++;
	   }
	    
	   if(level==1)
	   enemyImage.paintIcon(this,g,enemyxspace[xpos],enemyyspace[ypos]);
	   
	   
	   if((level==2)&&xpos<=14&&ypos<=18&&(enemyxspace2[xpos] == snakex[0])&&( enemyyspace2[ypos] == snakey[0]))
	   {
		   snakelength++;
		  
		    xpos= random.nextInt(15);
		    ypos= random.nextInt(19);
		   
		   score++;
	   }
	    
	   if(level==2&&xpos<=14&&ypos<=18)
	   enemyImage.paintIcon(this,g,enemyxspace2[xpos],enemyyspace2[ypos]);
	   
	   if((level==3)&&xpos<=10&&ypos<=16&&(enemyxspace3[xpos] == snakex[0])&&( enemyyspace3[ypos] == snakey[0]))
	   {
		   snakelength++;
		  
		    xpos= random.nextInt(11);
		    ypos= random.nextInt(17);
		  //  System.out.print("Got it");
		   
		   score++;
	   }
	    
	   if(level==3&&xpos<11&&ypos<17)
	   enemyImage.paintIcon(this,g,enemyxspace3[xpos],enemyyspace3[ypos]);
	   
	   if((level>=4)&&xpos<=10&&ypos<=16&&(enemyxspace3[xpos] == snakex[0])&&( enemyyspace3[ypos] == snakey[0]))
	   {
		   snakelength++;
		  
		    xpos= random.nextInt(11);
		    ypos= random.nextInt(17);
		   // System.out.print("Got it");
		   
		   score++;
	   }
	    
	   if(level>=4&&xpos<11&&ypos<17)
	   enemyImage.paintIcon(this,g,enemyxspace3[xpos],enemyyspace3[ypos]);
	   
	   
	   for(int b=1;b<snakelength&&block!=1;b++) {
		   if(snakex[0]==snakex[b]&&snakey[0]==snakey[b]) {
			   right=true;
			   up=false;
			   down=false;
			   right=false;
			   g.setColor(Color.RED);
			   g.setFont(new Font("arial",Font.BOLD,50));
			   g.drawString("Game Over", 500, 500);
			   
			   g.setFont(new Font("arial",Font.BOLD,20));
			   g.drawString("Space To Restart", 350, 340);
			   g.drawString(("Score: "+score), 350, 370);
			   snakelength=3;
			   
			   moves=0;
			   score=0;
			   flag=1;
			   level=1;
			 //Requirement of pressing space is there
		   }
	   }
	   
	   if(score>=20&&level==1) {
		   right=true;
		   up=false;
		   down=false;
		   right=false;
		   
		   g.setColor(Color.GREEN);
		   g.setFont(new Font("arial",Font.BOLD,50));
		   g.drawString("Welcome to Level 2", 400, 500);
		   
		   g.setFont(new Font("arial",Font.BOLD,20));
		   g.drawString("Space To start", 350, 340);
		   g.drawString(("Score: "+score), 350, 370);
		   
		   snakelength=3;
		   level=2;
		   flag=1;  //Requirement of pressing space is there
		   
	   }
	   
	   if(score>=40&&level==2) {
		   right=true;
		   up=false;
		   down=false;
		   right=false;
		   
		   g.setColor(Color.GREEN);
		   g.setFont(new Font("arial",Font.BOLD,50));
		   g.drawString("Welcome to Level 3", 400, 500);
		   
		   g.setFont(new Font("arial",Font.BOLD,20));
		   g.drawString("Space To start", 350, 340);
		   g.drawString(("Score: "+score), 350, 370);
		   
		   snakelength=3;
		   level=3;
		   flag=1;  //Requirement of pressing space is there
		   
	   }
	   if(score>=60&&level==3) {
		   right=true;
		   up=false;
		   down=false;
		   right=false;
		   
		   g.setColor(Color.GREEN);
		   g.setFont(new Font("arial",Font.BOLD,50));
		   g.drawString("Welcome to Level 4", 400, 500);
		   
		   
		   g.setFont(new Font("arial",Font.BOLD,20));
		   g.drawString("Space To start", 350, 340);
		   g.drawString(("Score: "+score), 350, 370);
		   
		   snakelength=3;
		   level=4;
		   flag=1;  //Requirement of pressing space is there
	   }
	   if(score>=80&&level==4&&block!=1) {
		   right=true;
		   up=false;
		   down=false;
		   right=false;
		   
		   g.setColor(Color.GREEN);
		   g.setFont(new Font("arial",Font.BOLD,50));
		   g.drawString("Welcome to Level 5", 400, 500);
		   
		   g.setFont(new Font("arial",Font.BOLD,20));
		   g.drawString("Space To start", 350, 340);
		   g.drawString(("Score: "+score), 350, 370);
		   
		   snakelength=3;
		  
		   level=5;
		   flag=1;  //Requirement of pressing space is there
	   }
	   if(score>=100&&level==5&&block!=1) {
		   right=true;
		   up=false;
		   down=false;
		   right=false;
		   
		   g.setColor(Color.YELLOW);
		   g.setFont(new Font("arial",Font.BOLD,50));
		   g.drawString("You Won", 500, 500);
		   
		   g.setFont(new Font("arial",Font.BOLD,20));
		   g.drawString("Space To Re-start", 350, 340);
		   g.drawString(("Score: "+score), 350, 370);
		   
		   snakelength=3;
		  
		   level=1;
		   flag=1;  //Requirement of pressing space is there
	   }
	   if(level==2) {
		   if((snakex[0]>=175&&snakex[0]<=625)&&(snakey[0]>=275&&snakey[0]<=300)){
			   right=true;
			   up=false;
			   down=false;
			   right=false;
			   
			   g.setColor(Color.RED);
			   g.setFont(new Font("arial",Font.BOLD,50));
			   g.drawString("Game over", 500, 500);
			   
			   g.setFont(new Font("arial",Font.BOLD,20));
			   g.drawString("Space To Re-start", 350, 340);
			   g.drawString(("Score: "+score), 350, 370);
			   score=0;
			   snakelength=3;
			   level=1;
			   flag=1;  //Requirement of pressing space is there
			   
		   }
		   else if((snakex[0]>=175&&snakex[0]<=625)&&(snakey[0]>=375&&snakey[0]<=400)) {
			   right=true;
			   up=false;
			   down=false;
			   right=false;
			   
			   g.setColor(Color.RED);
			   g.setFont(new Font("arial",Font.BOLD,50));
			   g.drawString("Game over", 500, 500);
			   
			   g.setFont(new Font("arial",Font.BOLD,20));
			   g.drawString("Space To re-start", 350, 340);
			   g.drawString(("Score: "+score), 350, 370);
			   score=0;
			   snakelength=3;
			   level=1;
			   flag=1; 
		   }
	   }
	   
	   if(level>=3) {
		   if((snakex[0]>=300&&snakex[0]<=550)&&(snakey[0]>=200&&snakey[0]<=225)) {
			   right=true;
			   up=false;
			   down=false;
			   right=false;
			   
			   g.setColor(Color.RED);
			   g.setFont(new Font("arial",Font.BOLD,50));
			   g.drawString("Game over", 500, 500);
			   
			   g.setFont(new Font("arial",Font.BOLD,20));
			   g.drawString("Space To re-start", 350, 340);
			   g.drawString(("Score: "+score), 350, 370);
			   score=0;
			   snakelength=3;
			   level=1;
			   flag=1; 
		   }
		   if((snakex[0]>=150&&snakex[0]<=700)&&(snakey[0]>=350&&snakey[0]<=375)) {
			   right=true;
			   up=false;
			   down=false;
			   right=false;
			   
			   g.setColor(Color.RED);
			   g.setFont(new Font("arial",Font.BOLD,50));
			   g.drawString("Game over", 500, 500);
			   
			   g.setFont(new Font("arial",Font.BOLD,20));
			   g.drawString("Space To re-start", 350, 340);
			   g.drawString(("Score: "+score), 350, 370);
			   score=0;
			   snakelength=3;
			   level=1;
			   flag=1; 
		   }
		   if((snakex[0]>=300&&snakex[0]<=550)&&(snakey[0]>=500&&snakey[0]<=525)) {
			   right=true;
			   up=false;
			   down=false;
			   right=false;
			   
			   g.setColor(Color.RED);
			   g.setFont(new Font("arial",Font.BOLD,50));
			   g.drawString("Game over", 500, 500);
			   
			   g.setFont(new Font("arial",Font.BOLD,20));
			   g.drawString("Space To re-start", 350, 340);
			   g.drawString(("Score: "+score), 350, 370);
			   score=0;
			   snakelength=3;
			   level=1;
			   flag=1; 
		   }
	   }
	     
	   
	   g.dispose();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	    timer.start();
	    if(right==true) {
	      for(int r = snakelength-1; r>=0; r--) {
	    	  snakey[r+1]=snakey[r];
	      } 
	      for(int r = snakelength-1; r>=0; r--) {
	    	  
	    	  if(r==0) {
	    		  snakex[r+1]=snakex[r];
	    		  snakex[r]=snakex[r]+25;  
	    	  }
	    	  else {
	    		  
	    		  snakex[r+1]=snakex[r];
	    	  }
	    	  if(snakex[r]>850) {
	    		  if(level<=3)
	    		  {snakex[r]=25;}
	    		  else {
	    			  //game ends
	    			  //System.out.print("Game ends");
	    			  block=1;
	    		
	    			  break;
	    		  }
	    	  }
	      }
	      
	      repaint();
	    }
	    else if(left==true) {
		      for(int r = snakelength-1; r>=0; r--) {
		    	  snakey[r+1]=snakey[r];
		      } 
		      for(int r = snakelength-1; r>=0; r--) {
		    	  
		    	  if(r==0) {
		    		  snakex[r+1]=snakex[r];
		    		  snakex[r]=snakex[r]-25;  
		    	  }
		    	  else {
		    		  
		    		  snakex[r+1]=snakex[r];
		    	  }
		    	  if(snakex[r]<25) {
		    		  if(level<=3)
		    		  snakex[r]=850;
		    		  else
		    		  {
		    			  //System.out.print("Game ends");
		    			  block=1;
		    		
		    			  break; 
		    		  }
		    	  }
		      }
		       
		      repaint();
		    }
        
	    else if(up==true) {
        	for(int r = snakelength-1; r>=0; r--) {
		    	  snakex[r+1]=snakex[r];
		      } 
		      for(int r = snakelength-1; r>=0; r--) {
		    	  
		    	  if(r==0) {
		    		  snakey[r+1]=snakey[r];
		    		  snakey[r]=snakey[r]-25;  
		    	  }
		    	  else {
		    		  
		    		  snakey[r+1]=snakey[r];
		    	  }
		    	  if(snakey[r]<75) {
		    		  if(level<=3)
		    		  snakey[r]=625;
		    		   else
			    		  {
			    			 // System.out.print("Game ends");
			    			  block=1;
			    		
			    			  break; 
			    		  }
		    		  
		    	  }
		      }
		       
		      repaint();
        }
        else if(down==true) {
	      
        	for(int r = snakelength-1; r>=0; r--) {
		    	  snakex[r+1]=snakex[r];
		      } 
		      for(int r = snakelength-1; r>=0; r--) {
		    	  
		    	  if(r==0) {
		    		  snakey[r+1]=snakey[r];
		    		  snakey[r]=snakey[r]+25;  
		    	  }
		    	  else {
		    		  
		    		  snakey[r+1]=snakey[r];
		    	  }
		    	  if(snakey[r]>625) {
		    		  if(level<=3)
		    		  snakey[r]=75;
		    		  else
		    		  {
		    			 // System.out.print("Game ends");
		    			  block=1;
		    		
		    			  break; 
		    		  }
		    	  }
		      }
		       
		      repaint();
        }
   }
   @Override
   public void keyPressed(KeyEvent e) {
	   if(e.getKeyCode() == KeyEvent.VK_SPACE&&flag==0) {
		   moves=0;
		   score=0;
		   snakelength=3;
		   left=false;
		   right=false;
		   up=false;
		   down=false;
		   level=1;
		   repaint();
	   }
	   if(e.getKeyCode() == KeyEvent.VK_SPACE&&flag==1) {
		   moves=0;
		   snakelength=3;
		   left=false;
		   right=false;
		   up=false;
		   down=false;
		   flag=0;
		   repaint();
		  
	   }
	// TODO Auto-generated method stub
	  if(e.getKeyCode() == KeyEvent.VK_RIGHT&&flag==0) {
		  
		  moves++;
		  if(left==false) {
			  right=true;
		  }
		  else
		  {
			right=false;
			left=true;
		  }
		  up=false;
		  down=false;
	  }
      if(e.getKeyCode() == KeyEvent.VK_LEFT&&flag==0) {
		  
		  moves++;
		  if(right==false) {
			  left=true;
		  }
		  else
		  {
			left=false;
			right=true;
		  }
		  up=false;
		  down=false;
	  }
      if(e.getKeyCode() == KeyEvent.VK_UP&&flag==0) {
		  
		  moves++;
		  if(down==false) {
			  up=true;
		  }
		  else
		  {
			up=false;
			down=true;
		  }
		  left=false;
		  right=false;
	  }
      if(e.getKeyCode() == KeyEvent.VK_DOWN && flag==0) {
		  
		  moves++;
		  if(up==false) {
			  down=true;
		  }
		  else
		  {
			down=false;
			up=true;
		  }
		  left=false;
		  right=false;
	  }
      
   }
   @Override
   public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
   }
   @Override
   public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
   }
}
