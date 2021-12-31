import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Flappy_Bird_Background here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    
    int counter = 0;
    boolean hasPrinted = false;
    int pipeCounter = 0;
    int FIRST_PIPE = 240;
    int PIPE_SPACE = 60;
    int NextLevel = 0;
    int LevelUp = 10;
    int WhenToLevelUp = 9;
    int RN = 0;
    private int spawnTimer;
    Score scoreObj = null;
    Coin[] coins;
    
    ArrayList<top_pipe> topPipes = new ArrayList<>();
    /**
     * Constructor for objects of class FlappyWorld.
     *
     */
    public FlappyWorld()        
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
       
        // Create a Flappy bird object
        FlappyBird flappy = new FlappyBird();
       
        // Add flappy to our world
        addObject(flappy, 100, getHeight()/2);
       
        // set paint order
        setPaintOrder(Score.class, bottom_pipe. class, top_pipe.class);
       
        // Create a Score object
        scoreObj = new Score();
       
        // Add Score to Flappy_Bird_Background
        addObject(scoreObj, 100, 100);
        
    }
 
    public void act() {
        checkForSpawning();
        
        
        
        for (top_pipe pipe : topPipes)
        {
            if (pipe.addscore)
               {
                   scoreObj.scoreUp();
                   pipe.addscore = false;
               }
        }
        if (scoreObj.score == 0 && hasPrinted == false) {
            System.out.println("Can you be named the Flappy Bird LEGEND?");
            hasPrinted = true;
        }
        if (scoreObj.score == 10 && hasPrinted == true) {
            System.out.println("Good Job!");
            displayLevelCompleted();
            hasPrinted = false;
        }
        if (scoreObj.score >= WhenToLevelUp) {
            PIPE_SPACE = 70;
        }
           
        if (scoreObj.score == 20 && hasPrinted == false) {
            System.out.println("So Far So Good!");
            displayLevelCompleted();
            hasPrinted = true;
        }
        if (scoreObj.score >= WhenToLevelUp + 10) {
            PIPE_SPACE = 80;
        }
           
        if (scoreObj.score == 30 && hasPrinted == true) {
            System.out.println("Are you the Flappy Bird GOAT?");
            displayLevelCompleted();
            hasPrinted = false;
        }
        if (scoreObj.score >= WhenToLevelUp + 20) {
            PIPE_SPACE = 90;
        }
           
        if (scoreObj.score == 40 && hasPrinted == false){
            System.out.println("Warning: Difficulty HALL OF FAME!");
            displayLevelCompleted();
            hasPrinted = true;
        }
        if (scoreObj.score >= WhenToLevelUp + 30) {
             PIPE_SPACE = 100;
        }
           
        if (scoreObj.score == 50 && hasPrinted == true) {
             System.out.println("Flappy Bird LEGEND!");
             displayLevelCompleted();
             hasPrinted = false;
        }
        if (scoreObj.score >= WhenToLevelUp + 40) {
             PIPE_SPACE = 110;
        }
           
        if (scoreObj.score == 51 && hasPrinted == false) {
             System.out.println("Warning: Level Impossible!");
             displayLevelCompleted();
             hasPrinted = true;
        }
       
        RN = getRandomNumber(50,100);
        pipeCounter++;
       
        if (pipeCounter % RN == 0) {
           // Create a pipe object
           bottom_pipe bpipe = new bottom_pipe();
           
           top_pipe tpipe = new top_pipe();
           
           GreenfootImage bimage = bpipe.getImage();
           GreenfootImage timage = tpipe.getImage();
           
           topPipes.add(tpipe);
           
           
           addObject(bpipe, getWidth(), getHeight()/2 + bimage.getHeight()-PIPE_SPACE);
           addObject(tpipe, getWidth(), getHeight()/2 - timage.getHeight()+PIPE_SPACE);
        }
               
        if (NextLevel == LevelUp) {
            displayLevelCompleted();
            NextLevel = 0;
        }
    }
   
    private void displayLevelCompleted() {
        System.out.println("NEXT LEVEL");
    }
   
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    private void checkForSpawning() // call from act method
{
    spawnTimer = (spawnTimer+1)%50; // repeat every 10 seconds (about)
    if (spawnTimer == 0) // at each timer reset
    {
        addObject(new Coin(), 90, Greenfoot.getRandomNumber(500));
        
    }
}

}


  