import mayflower.*;
public class Cheese extends Actor
{
    
    public Cheese() {
        
        setImage("sprites/cheese.png");
    }
    
    public void act() {
        if (isTouching(Rat.class)) {
            
            Object a = getOneIntersectingObject(Rat.class);
            Rat c = (Rat) a;
            World w = getWorld(); //get this Actor’s World
            w.removeObject(this);
            c.increaseScore(1);
        }
    }
}
