import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bottom_pipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bottom_pipe extends Actor
{
    int PIPE_SPEED = -4;
    int FIRST_PIPE = 225;
    int pipeCounter = 0;
    int YPIPE_SPEED = -1;
    /**
     * Act - do whatever the bottom_pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        pipeCounter++;
        setLocation( getX() + PIPE_SPEED, getY() + -YPIPE_SPEED );
        if (pipeCounter == 225) {
            YPIPE_SPEED = -25;
            setLocation(getX(), getY() + -YPIPE_SPEED);
            pipeCounter = 0;
        }
        if (YPIPE_SPEED == -101) {
            YPIPE_SPEED = 50;
            setLocation(getX(), getY() + YPIPE_SPEED);
           
        }
        if (pipeCounter == 50) {
            YPIPE_SPEED = 1;
            setLocation(getX(), getY() + -YPIPE_SPEED);
        }
        removePipe();
    }
    public void removePipe()
    {
        if (this.getX() == 0) {
            getWorld().removeObject(this);
        }
    }
}