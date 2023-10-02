import mayflower.*;

/*
 * this is a miscellaneous world
 * meant for testing various collisions, animations, and movement without
 * editing existing levels
 */

public class Debug extends World {

    private Rat rateo;
    private Pipe block1;
    private Pipe block2;
    
    public Debug() 
    {
        setBackground("sprites/placeholder.png");
        
        rateo = new Rat();
        addObject(rateo, 400, 100);
        block1 = new Pipe();
        addObject(block1, 400, 500);
        block2 = new Pipe();
        addObject(block2, 528, 372);
    }
    
    public void act()
    {
    }
    
}