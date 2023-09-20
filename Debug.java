import mayflower.*;


public class Debug extends World {

	private Rat rateo;
	private Pipe block1;
	private Pipe block2;
	
    public Debug() 
    {
    	setBackground("sprites/placeholder.png");
    	Mayflower.showBounds(true);
    	
    	rateo = new Rat();
    	addObject(rateo, 400, 100);
    	block1 = new Pipe();
    	addObject(block1, 400, 500);
    	block2 = new Pipe();
    	addObject(block2, 528, 372);
    	//jack = new Jack();
    	//addObject(jack, 400, 100);
    	//dog = new Dog();
    	//addObject(dog, 400, 400);
    }
    
    public void act()
    {
    }
    
}