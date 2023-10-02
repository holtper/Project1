import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor {

    //declaring all variables
    private Animation walkRight, walkLeft, idleRight, idleLeft;
    private Animation climbRight, climbLeft, jumpRight, jumpLeft;
    private String currentAction, direction;
    
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
            
        // move up if touching ladder and pressing up
        if(Mayflower.isKeyDown(Keyboard.KEY_UP) && isTouching(Ladder.class)) {
            
            setLocation(x, y - 2);
            newAction = direction.equals("right") ? "climbRight" : "climbLeft";
        }
        
        // move down if touching ladder and pressing down
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            
            setLocation(x, y + 1);
            
            if (isTouching(Ladder.class))
                setLocation(x, y + 1);
            else
                setLocation(x, y - 1);
            newAction = direction.equals("right") ? "climbRight" : "climbLeft";
        }
        
        //"jumps" is up is pressed and not currently falling
        else if(Mayflower.isKeyPressed(Keyboard.KEY_UP) && !isFalling()) {
            
            setLocation(x, y + 1);
            if (isTouching(Pipe.class)) {
                setLocation(x, y - 32);
                newAction = direction.equals("right") ? "jumpRight" : "jumpLeft";
            }
            else
            setLocation(x, y - 1);
        }
        
        //moves right if right is pressed
        else if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) {
            
            newAction = "walkRight";
            direction = "right";
            setLocation(x + 1, y);
            
            if (isTouching(Pipe.class))
                
                setLocation(x - 2, y);
        }
        
        // moves left if left is pressed
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            
            newAction = "walkLeft";
            direction = "left";
            setLocation(x - 1, y);

            if (isTouching(Pipe.class))
                
                setLocation(x + 1, y);
        }
        
        //sets action to "idle" if nothing else
        else {
            
            
            newAction = "idle";
            
            if (!direction.equals(null) && direction.equals("right"))
                newAction = "idleRight";
                
            if (!direction.equals(null) && direction.equals("left"))
                newAction = "idleLeft";
        }

        //updates current animation depending on movement
        if (!(newAction == (null)) && !newAction.equals(currentAction)) {
            
            if (newAction.equals("climbRight")) 
                setAnimation(climbRight);
                
            else if(newAction.equals("climbLeft"))
                setAnimation(climbLeft);
            
            else if (newAction.equals("jumpRight") || (isFalling() && direction.equals("right")))
                setAnimation(jumpRight);
                
            else if (newAction.equals("jumpLeft") || (isFalling() && direction.equals("left")))
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
    
    //various setter methods
    
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
    
    public void setClimbRightAnimation(Animation ani) {
        
        climbRight = ani;
    }
    
     public void setClimbLeftAnimation(Animation ani) {
        
        climbLeft = ani;
    }
    
    public void setJumpRightAnimation(Animation ani){
        
        jumpRight = ani;
    }
    
    public void setJumpLeftAnimation(Animation ani){
        
        jumpLeft = ani;
    }
}
