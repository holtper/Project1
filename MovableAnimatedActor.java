import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor {

    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private String currentAction;
    private String direction;
    
    public MovableAnimatedActor() {
        
        walkRight = null;
        idleRight = null;
        currentAction = null;
        direction = "right";
    }
    
    public void setAnimation(Animation a) {
        
        super.setAnimation(a);
    }
    
    public void setWalkRightAnimation(Animation ani) {
        
        walkRight = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani) {
        
        walkLeft = ani;
    }
    
    public void setIdleRightAnimation(Animation ani) {
        
        idleRight = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani) {
        
        idleLeft = ani;
    }
    
    public void setFallRightAnimation(Animation ani) {
        
        fallRight = ani;
    }
    
     public void setFallLeftAnimation(Animation ani) {
        
        fallLeft = ani;
    }
    
    public void act() {
       
        super.act();
        
        String newAction = null;
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        if (currentAction == (null))
            newAction = "idleRight";
        
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) {
            
            newAction = "walkRight";
            direction = "right";
            setLocation(x + 1, y);
            
            if (isTouching(Block.class))
                
                setLocation(x - 1, y);
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            
            newAction = "walkLeft";
            direction = "left";
            setLocation(x - 1, y);
            
             if (isTouching(Block.class))
                
                setLocation(x + 1, y);
        }
        
        else {
            
            newAction = "idle";
            
            if (!direction.equals(null) && direction.equals("right"))
                newAction = "idleRight";
                
            if (!direction.equals(null) && direction.equals("left"))
                newAction = "idleLeft";
        }
        
        if (isFalling()) {
            
            if (!direction.equals(null) && direction.equals("right"))
                newAction = "fallRight";
                
            if (!direction.equals(null) && direction.equals("left"))
                newAction = "fallLeft";
        }
        
        // sets animation and currentAction
        if (!(newAction == (null)) && !newAction.equals(currentAction)) {
            
            if (newAction.equals("idleRight"))
                setAnimation(idleRight);
                
            else if (newAction.equals("idleLeft"))
                setAnimation(idleLeft);
                
            else if (newAction.equals("walkRight"))
                setAnimation(walkRight);
                
            else if (newAction.equals("walkLeft"))
                setAnimation(walkLeft);
                
            else if (newAction.equals("fallRight"))
                setAnimation(fallRight);
                
            else if (newAction.equals("fallLeft"))
                setAnimation(fallLeft);
                
            currentAction = newAction;
        }
    } 
}
