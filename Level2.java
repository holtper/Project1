import mayflower.*;

public class Level2 extends World {

    private Rat rateo;
    
    public Level2() 
    {
        setBackground("sprites/background/level1back.png");
        Mayflower.showBounds(false);
        
        String[][] tiles = {new String[12], new String[14], new String[16], new String[18]}; 
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles[i].length; j++)
                tiles[i][j] = new String();
        
        addPipes(4);
        addObject(new WinPipe(), 200, 50);
        addObject(new Bug(), 300, 230);
        addObject(new Bug(), 400, 440);
        addRandomObjects(tiles);
        showText("Points needed: 10", 10, 60, Color.WHITE);
        rateo = new Rat();
        rateo.setLevel(2);
        addObject(rateo, 200, 440);
    }
    
    public void addPipes(int layers) {
        
        for (int i = 0; i < layers; i++) {
            
            addObject(new PipeLeft(), 32 + (32 * i), ((layers - i) * 96) + 100);
            for (int j = 64 + (i * 32); j < 704 - (i * 32); j += 32) 
                
                addObject(new Pipe(), j, ((layers - i) * 96) + 100);
                
            addObject(new PipeRight(), 704 - (32 * i), ((layers - i) * 96) + 100);
        }
    }
    
    public void addRandomObjects(String[][] arr) { 
        
        boolean ladderAdded = false;
        for (int i = arr.length - 1; i > 0; i--) {
            
            ladderAdded = false;
            
            while (!ladderAdded) {
            
                int j = (int) (Math.random() * arr[i].length);
                if (Math.random() * 10 > 8 && arr[i][j].equals("")) {
                    addObject(new Ladder(), (j * 32) + 96, (i * 96) + 100);
                    addObject(new Ladder(), (j * 32) + 96, (i * 96) + 132);
                    addObject(new Ladder(), (j * 32) + 96, (i * 96) + 164);
                    arr[i][j] = "ladder";
                    ladderAdded = true;
                }
            }
        }
        
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j ++) {
                
                if (Math.random() * 10 > 6 && arr[i][j].equals("")) {
                    addObject(new Cheese(), (j * 32) + 96, (i * 96) + 150);
                    arr[i][j] = "cheese";
                }
            }
        }
    }
    
    public void act()
    {
    }
    
}