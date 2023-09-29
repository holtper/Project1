import mayflower.*;

public class Rat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private int score;
    private int lives;
    
    public Rat() 
    {
        String[] walkFiles = new String[3];
        for (int i = 0; i < walkFiles.length; i++) 
            walkFiles[i] = new String("sprites/rat/Run(" + (i) + ").png");
        walkRight = new Animation(50, walkFiles);
        
        String[] idleFiles = new String[10];
        for (int i = 0; i < idleFiles.length; i++) 
            idleFiles[i] = new String("sprites/rat/Idle(" + (i) + ").png");
        idleRight = new Animation(50, idleFiles);
        
        String[] jumpFiles = new String[7];
        for (int i = 0; i < jumpFiles.length; i++) 
            jumpFiles[i] = new String("sprites/rat/Jump(" + (i) + ").png");
        jumpRight = new Animation(50, jumpFiles);
        
        //String[] fallFiles = new String[7];
        //for (int i = 0; i < fallFiles.length; i++) 
          //  fallFiles[i] = new String("img/cat/Fall (" + (i + 1) + ").png");
        //fallRight = new Animation(50, fallFiles);
        
        walkLeft = new Animation(50, walkFiles);
        walkLeft.mirrorHorizontally();
        
        idleLeft = new Animation(50, idleFiles);
        idleLeft.mirrorHorizontally();
        
        jumpLeft = new Animation(50, jumpFiles);
        jumpLeft.mirrorHorizontally();
        
        walkRight.scale(32, 32);
        walkLeft.scale(32, 32);
        idleRight.scale(32, 32);
        idleLeft.scale(32, 32);
        jumpRight.scale(32,32);
        jumpLeft.scale(32,32);
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setJumpRightAnimation(jumpRight);
        setJumpLeftAnimation(jumpRight);
        //setFallRightAnimation(fallRight);
        //setFallLeftAnimation(fallLeft);
        
        setAnimation(idleRight);
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
    
    private void updateText() {
     
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    public void act()
    {
        super.act();
        updateText();
    }
}
