import mayflower.*;

public class Bug extends AnimatedActor {
    
    private Animation flyRight;
    private Animation flyLeft;
    private int counter;
    private Timer wait;
    
    public Bug() {
        
        String[] flyFiles = new String[2];
        for (int i = 0; i < flyFiles.length; i++) 
            flyFiles[i] = new String("sprites/bug/Fly(" + (i) + ").png");
        flyRight = new Animation(50, flyFiles);
        
        flyLeft = new Animation(50, flyFiles);
        flyLeft.mirrorHorizontally();
        
        flyRight.scale(24, 24);
        flyLeft.scale(24, 24);
        
        setAnimation(flyRight);
        counter = Math.random() < 0.5 ? 0 : -1;
        wait = new Timer((int) (Math.random() * 5000));
    }
    
    public void act() {
        
        super.act();
        
        //resets counter
        if (counter >= 100)
            counter = -1;
            
        if (counter < -100)
            counter = 0;
        
        //once wait timer is done, start moving Bug
        if (wait.isDone()) {
            wait.reset();
            if (counter >= 0) {
                setAnimation(flyRight);
                setLocation(getX() + 2, getY());
                counter++;
            }
            else {
                setAnimation(flyLeft);
                setLocation(getX() - 2, getY());
                counter--;
            }
        }
        
        //checks for collision with Rat
        if (isTouching(Rat.class)) {
            
            Object obj = getOneIntersectingObject(Rat.class);
            Rat r = (Rat) obj;
            
            //if Rat is above Bug, kill Bug
            if (r.getY() + 20 < getY())
                getWorld().removeObject(this);
                
            //decrease Rat lives if not
            else {
                r.setLocation(150, 440);
                r.decreaseLives(1);
            }
        }
    }
}