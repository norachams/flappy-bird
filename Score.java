import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Score extends Actor
{
   int score = 0;
   public Score() {
       GreenfootImage newImage = new GreenfootImage(200, 50);
       setImage(newImage);
       reDraw();
    }
   public void scoreUp()
   {
       score++;
       reDraw();
   }
   public void reDraw() {
       GreenfootImage newImage = getImage();
       newImage.clear();
       
       greenfoot.Font f = new Font("Comic Sans MS", 32);
       newImage.setFont(f);
       
       greenfoot.Color c = new Color(127, 127, 127, 127);
       newImage.setColor(c);
       newImage.fill();
       newImage.setColor(Color.BLACK);
       newImage.drawString("Score = " + score, 30, 30);
       setImage(newImage);
    }
}
   
