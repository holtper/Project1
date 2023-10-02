import mayflower.*;

public class GravityActor extends Actor{
    
    
    public Boolean isBlocked() {
        
        return (isTouching(Pipe.class));
    }
    
    // checks to see if an Gravity actor is continuously getting lower on the screen
    public Boolean isFalling() {
        
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Pipe.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
    
    //prevents walking into walls from the side
    public void act() {
        
        setLocation(getX(), getY() + 1);
        
        if (isBlocked())
            setLocation(getX(), getY() - 1);
    }
}
