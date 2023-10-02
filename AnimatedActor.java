import mayflower.*;

public class AnimatedActor extends GravityActor {
    
    private Animation animation;
    private Timer animationTimer;
    
    //sets "framerate" to a value that seemed good
    public AnimatedActor() {
        
        animationTimer = new Timer(100000000);
    }
    
    //updates the game's frames
    public void act() {
        
        super.act();
        
        if (animationTimer.isDone()) {
            
            animationTimer.reset();
            
            MayflowerImage nextFrame = animation.getNextFrame();
            setImage(nextFrame);
        }
    }
    
    public void setAnimation(Animation a) {
        
        animation = a;
    }
}