import mayflower.*;


public class MyWorld extends World {

	private Cat cat;
	private Jack jack;
	private Dog dog;
	private Block block1;
	private Block block2;
	
    public MyWorld() 
    {
    	setBackground("img/BG/BG.png");
    	//Mayflower.showBounds(true);
    	
    	cat = new Cat();
    	addObject(cat, 400, 100);
    	block1 = new Block();
    	addObject(block1, 400, 500);
    	block2 = new Block();
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