import mayflower.*;


public class Level1 extends World {

    private Rat rateo;
    private String tiles;
    
    public Level1() 
    {
        setBackground("sprites/background/level1back.png");
        Mayflower.showBounds(true);
        
        rateo = new Rat();
        addObject(rateo, 200, 460);
        
        addPipes(4);
        addObject(new WinPipe(), 200, 70);
    }
    
    public boolean canWin() {
        
        return (rateo.getScore() >= 5 && rateo.getLives() > 0);
    }
    
    public void addPipes(int layers) {
        
        for (int i = 0; i < layers; i++) {
            
            addObject(new PipeLeft(), 32 + (32 * i), ((layers - i) * 100) + 100);
            for (int j = 64 + (i * 32); j < 704 - (i * 32); j += 32) 
                
                addObject(new Pipe(), j, ((layers - i) * 100) + 100);
                
            addObject(new PipeRight(), 704 - (32 * i), ((layers - i) * 100) + 100);
        }
    }
    
    public void addTiles(String[][] arr) {
        
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
    {}
    
}