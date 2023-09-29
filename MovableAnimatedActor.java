import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor {

    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private String currentAction;
    private String direction;
    
    public MovableAnimatedActor() {

        currentAction = null;
        direction = "right";
    }
    
    public void setAnimation(Animation a) {
        
        super.setAnimation(a);
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
            
        if(Mayflower.isKeyPressed(Keyboard.KEY_UP) && !isFalling()) {
            
            setLocation(x, y + 1);
            if (isTouching(Pipe.class)) {
                setLocation(x, y - 35);
                newAction = direction.equals("right") ? "jumpRight" : "jumpLeft";
            }
        }
        
        else if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) {
            
            newAction = "walkRight";
            direction = "right";
            setLocation(x + 1, y);
            
            if (isTouching(Pipe.class))
                
                setLocation(x - 1, y);

        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            
            newAction = "walkLeft";
            direction = "left";
            setLocation(x - 1, y);
            
             if (isTouching(Pipe.class))
                
                setLocation(x + 1, y);
        }
        
        else {
            
            newAction = "idle";
            
            if (!direction.equals(null) && direction.equals("right"))
                newAction = "idleRight";
                
            if (!direction.equals(null) && direction.equals("left"))
                newAction = "idleLeft";
        }

        if (!(newAction == (null)) && !newAction.equals(currentAction)) {
            
            if (newAction.equals("jumpRight"))
                setAnimation(jumpRight);
                
            else if (newAction.equals("jumpLeft"))
                setAnimation(jumpLeft);
                
            else if (newAction.equals("idleRight"))
                setAnimation(idleRight);
                
            else if (newAction.equals("idleLeft"))
                setAnimation(idleLeft);
                
            else if (newAction.equals("walkRight"))
                setAnimation(walkRight);
                
            else if (newAction.equals("walkLeft"))
                setAnimation(walkLeft);
                
            currentAction = newAction;
        }
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
    
    public void setJumpRightAnimation(Animation ani){
        
        jumpRight = ani;
    }
    
    public void setJumpLeftAnimation(Animation ani){
        
        jumpLeft = ani;
    }
}
