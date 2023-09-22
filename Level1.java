import mayflower.*;


public class Level1 extends World {

    private Rat rateo;
    private String tiles;
    
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
    
    public void buildWorld(String[][] arr) {
        
        for (int r = 0; r < arr.length; r++)
            
            for (int c = 0; c < arr[r].length; c++)
                
                arr[r][c] = new String();
                
        
        for (int i = 0; i < arr[5].length; i++)
            
            arr[5][i] = "floor";
            
            
        for (int r = 0; r < arr.length; r++)
            
            for (int c = 0; c < arr[r].length; c++)
                
                if (arr[r][c].equals("ground"))
                    
                    addObject(new Pipe(), c * 100, r * 100 - 28);
    }
    
    public void addRandomObjects(String[][] arr) { 
        
        Boolean added = false;
        
        for (int r = 0; r < arr.length - 1; r++)
        
            for (int c = 0; c < arr[r].length; c++)
            
                if (Math.random() * arr.length < 3 && arr[r][c].equals(new String())) {
                    
                    addObject(new Cheese(), c * 100, r * 100);
                    arr[r][c] = "cheese";
                }
    }
    
    public void act()
    {
    }
    
}