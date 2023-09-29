public class Bug extends AnimatedActor {
    
    private Animation flyRight;
    private Animation flyLeft;
    private int counter;
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
        counter = 0;
    }
    
    public void act() {
        
        super.act();
        if (counter >= 100)
            counter = -1;
            
        if (counter < -100)
            counter = 0;
        
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
        
        if (isTouching(Rat.class)) {
            
            Object obj = getOneIntersectingObject(Rat.class);
            Rat r = (Rat) obj;
            r.setLocation(200, 465);
            r.decreaseLives(1);
        }
    }
}