import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class FlappyBird here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    double dy = 0;
    double g = 1.3;
    double BOOST_SPEED = -6.5;
    
    /*public FlappyBird(){
     GreenfootImage image = getImage();  
     image.scale(100, 100);
     setImage(image);
    }*/
   
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        
        setLocation( getX(), (int) (getY() + dy) );
       
        // If we are touching a pipe, then Game Over!
        if (getOneIntersectingObject(bottom_pipe.class)!= null) {
            displayGameOver();
        }
        
        if (getOneIntersectingObject (top_pipe.class)!= null) {
            displayGameOver();
        }
        
       
       // If used presses up arrows, launch Flappy Bird upward
        if (Greenfoot.isKeyDown("up") == true) {
           dy = BOOST_SPEED;
        }
    
       
        // If FlappyBird drops out of the world, Game over!
        if (getY() > getWorld().getHeight())  {  
          displayGameOver();  
        }
       
        dy = dy + g;
        
        Actor Bird = getOneIntersectingObject(FlappyBird.class);
        
       
    }  
    

    
 
    private void displayGameOver() {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }
    
}