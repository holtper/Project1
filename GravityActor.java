import mayflower.*;

public class GravityActor extends Actor{
    
    
    public Boolean isBlocked() {
        
        return (isTouching(Pipe.class));
    }
    
    public Boolean isFalling() {
        
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Pipe.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
    
    public void act() {
        
        setLocation(getX(), getY() + 1);
        
        if (isBlocked())
            setLocation(getX(), getY() - 1);
    }
}
