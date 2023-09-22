import mayflower.*;

public class Rat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jump;
    
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
        jump = new Animation(50, jumpFiles);
        
        //String[] fallFiles = new String[7];
        //for (int i = 0; i < fallFiles.length; i++) 
          //  fallFiles[i] = new String("img/cat/Fall (" + (i + 1) + ").png");
        //fallRight = new Animation(50, fallFiles);
        
        walkLeft = new Animation(50, walkFiles);
        walkLeft.mirrorHorizontally();
        
        idleLeft = new Animation(50, idleFiles);
        idleLeft.mirrorHorizontally();
        
        //fallLeft = new Animation(50, fallFiles);
        //fallLeft.mirrorHorizontally();
        
        walkRight.scale(32, 32);
        walkLeft.scale(32, 32);
        idleRight.scale(32, 32);
        idleLeft.scale(32, 32);
        jump.scale(32,32);
        //fallRight.scale(100, 87);
        //fallLeft.scale(100, 87);
        
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setJumpAnimation(jump);
        //setFallRightAnimation(fallRight);
        //setFallLeftAnimation(fallLeft);
        
        setAnimation(idleRight);
    }
    public void act()
    {
        super.act();
    }
}
