import mayflower.*;


public class Level1 extends World {

    private Rat rateo;
    private Pipe block1;
    private Pipe block2;
    
    public Level1() 
    {
        setBackground("sprites/background.png");
        
        rateo = new Rat();
        addObject(rateo, 200, 460);
        
        for (int i = 64; i < 704; i += 32)
            addObject(new Pipe(), i, 500);
            
        for (int i = 96; i < 672; i += 32)
            addObject(new Pipe(), i, 400);
            
        for (int i = 128; i < 640; i += 32)
            addObject(new Pipe(), i, 300);  
            
        for (int i = 160; i < 608; i += 32)
            addObject(new Pipe(), i, 200);
            
        
    }
    
    public void act()
    {
    }
    
}