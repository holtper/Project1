import mayflower.*;

public class Rat extends MovableAnimatedActor
{
    private Animation walkRight, walkLeft, idleRight, idleLeft; 
    private Animation jumpRight, jumpLeft, climbRight, climbLeft;
    private int score, lives, level;
    
    public Rat() 
    {
        //creates animaiton loops
        String[] walkFiles = new String[3];
        for (int i = 0; i < walkFiles.length; i++) 
            walkFiles[i] = new String("sprites/rat/Run(" + (i) + ").png");
        walkRight = new Animation(50, walkFiles);
        
        String[] idleFiles = new String[10];
        for (int i = 0; i < idleFiles.length; i++) 
            idleFiles[i] = new String("sprites/rat/Idle(" + (i) + ").png");
        idleRight = new Animation(50, idleFiles);
        
        String[] jumpFiles = new String[4];
        for (int i = 0; i < jumpFiles.length; i++) 
            jumpFiles[i] = new String("sprites/rat/Jump(" + (i) + ").png");
        jumpRight = new Animation(50, jumpFiles);
        
        String[] climbFiles = new String[2];
        for (int i = 0; i < climbFiles.length; i++) 
            climbFiles[i] = new String("sprites/rat/Climb(" + i + ").png");
        climbRight = new Animation(50, climbFiles);
        
        // mirrors existing loops to work both directions
        walkLeft = new Animation(50, walkFiles);
        walkLeft.mirrorHorizontally();
        
        idleLeft = new Animation(50, idleFiles);
        idleLeft.mirrorHorizontally();
        
        jumpLeft = new Animation(50, jumpFiles);
        jumpLeft.mirrorHorizontally();
        
        climbLeft = new Animation(50, climbFiles);
        climbLeft.mirrorHorizontally();
        
        //scales animation loops to better fit the screen
        walkRight.scale(32, 32);
        walkLeft.scale(32, 32);
        idleRight.scale(32, 32);
        idleLeft.scale(32, 32);
        jumpRight.scale(32,32);
        jumpLeft.scale(32,32);
        climbRight.scale(32, 32);
        climbLeft.scale(32, 32);
        
        //sets the various animation loops to actual variables
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setJumpRightAnimation(jumpRight);
        setJumpLeftAnimation(jumpLeft);
        setClimbRightAnimation(climbRight);
        setClimbLeftAnimation(climbLeft);
        
        setAnimation(idleRight);
        
        lives = 3;
    }
    
    public void increaseScore(int amt) {
    
        score += amt;
    }
    
    public void decreaseLives(int amt) {
        
        lives -= amt;
    }
    
    public int getScore() {
    
        return score;
    }
    
    public int getLives() {
    
        return lives;
    }
    
        public void setLevel(int l) {
    
        level = l;
    }
    
    private void updateText() {
     
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.WHITE);
    }
    
    public void act()
    {
        super.act();
        updateText();
        
        //shows game over screen if lives are 0 or less
        if (lives <= 0) {
         
            Mayflower.setWorld(new GameOver());
        }
        
        //checks win conditions for each level
        if (isTouching(WinPipe.class))
        {
            if (level == 1 && score >= 5) {
                
                Mayflower.setWorld(new Level2());
            }
            
            if (level == 2 && score >= 10) {
                
                Mayflower.setWorld(new Level3());
            }
            
            if (level == 3 && score >= 15) {
                
                Mayflower.setWorld(new GameWin());
            }
        }
    }
}
