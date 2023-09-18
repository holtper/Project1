import mayflower.*;


public class MyWorld extends World {

	private Rat rateo;
	private Block block1;
	private Block block2;
	
    public MyWorld() 
    {
    	setBackground("sprites/placeholder.png");
    	//Mayflower.showBounds(true);
    	
    	rateo = new Rat();
    	addObject(rateo, 400, 100);
    	//block1 = new Block();
    	//addObject(block1, 400, 500);
    	//block2 = new Block();
    	//addObject(block2, 528, 372);
    	//jack = new Jack();
    	//addObject(jack, 400, 100);
    	//dog = new Dog();
    	//addObject(dog, 400, 400);
    }
    
    public void act()
    {
    }
    
}