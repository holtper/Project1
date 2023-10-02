import mayflower.*;

public class Water extends AnimatedActor {
    
    private Animation animation;
    public Water() {
        
        //sets animation loop
        String[] files = new String[4];
        for (int i = 0; i < files.length; i++) 
            files[i] = new String("sprites/water/water(" + (i) + ").png");
        animation = new Animation(50, files);
        animation.scale(64, 800);
        
        setAnimation(animation);
    }
    
    public void act() {
        
        if (isTouching(Rat.class)) {
            
            Object obj = getOneIntersectingObject(Rat.class);
            Rat r = (Rat) obj;
            r.setLocation(200, 440);
            r.decreaseLives(1);
        }
    }
}