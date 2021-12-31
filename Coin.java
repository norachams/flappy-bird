import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    GifImage myGif = new GifImage ("coin-clipart-drawn-17.gif");
    
    
    /**
     * Act - do whatever the coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( myGif.getCurrentImage());
          getImage().scale(150,150);
         getWorld().removeObjects(getObjectsInRange(0, FlappyBird.class));
    if (getObjectsInRange(50, FlappyBird.class).size() > 0)
{
    getWorld().removeObject(this);
}
}
}
