import mayflower.*;

public class Rat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    
    public Rat() 
    {
        String[] walkFiles = new String[10];
        for (int i = 0; i < walkFiles.length; i++) 
            walkFiles[i] = new String("sprites/rat/Run(" + (i) + ").png");
        walkRight = new Animation(50, walkFiles);
        
        String[] idleFiles = new String[10];
        for (int i = 0; i < idleFiles.length; i++) 
            idleFiles[i] = new String("sprites/rat/Idle(" + (i) + ").png");
        idleRight = new Animation(50, idleFiles);
        
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
        
        //walkRight.scale(100, 87);
        //walkLeft.scale(100, 87);
        //idleRight.scale(100, 87);
        //idleLeft.scale(100, 87);
        //fallRight.scale(100, 87);
        //fallLeft.scale(100, 87);
        
        //walkRight.setBounds(18, 5, 54, 80);
        //walkLeft.setBounds(28, 5, 54, 80);
        //idleRight.setBounds(18, 5, 54, 80);
        //idleLeft.setBounds(28, 5, 54, 80);
       // fallRight.setBounds(18, 5, 54, 80);
        //fallLeft.setBounds(28, 5, 54, 80);
        
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        //setFallRightAnimation(fallRight);
        //setFallLeftAnimation(fallLeft);
        
        setAnimation(idleRight);
    }
    public void act()
    {
        super.act();
    }
}
