import mayflower.*;

public class Level3 extends World {

    private Rat rateo;
    
    public Level3() 
    {
        setBackground("sprites/background/level3back.png");
        Mayflower.showBounds(false);
        
        // declares/instantiates the tiles array
        String[][] tiles = {new String[12], new String[14], new String[16], new String[18]}; 
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles[i].length; j++)
                tiles[i][j] = new String();
        
        // adds all level objects and interactables
        addPipes(4);
        addObject(new WinPipe(), 200, 50);
        addObject(new Bug(), 350, 152);
        addObject(new Bug(), 300, 248);
        addObject(new Bug(), 275, 344);
        addObject(new Bug(), 400, 440);
        addRandomObjects(tiles);
        showText("Points needed: 15", 10, 60, Color.WHITE);
        rateo = new Rat();
        rateo.setLevel(3);
        addObject(rateo, 150, 440);
        addObject(new Water(), 0, 536);
    }
    
    //add layers of pipes in a pyramid shape based on a parameter
    public void addPipes(int layers) {
        
        for (int i = 0; i < layers; i++) {
            
            addObject(new PipeLeft(), 32 + (32 * i), ((layers - i) * 96) + 100);
            for (int j = 64 + (i * 32); j < 704 - (i * 32); j += 32) 
                
                addObject(new Pipe(), j, ((layers - i) * 96) + 100);
                
            addObject(new PipeRight(), 704 - (32 * i), ((layers - i) * 96) + 100);
        }
    }
    
    // add random cheeses and ladders, not overlapping and using a 2d string array
    public void addRandomObjects(String[][] arr) { 
        
        boolean ladderAdded = false;
        for (int i = arr.length - 1; i > 0; i--) {
            
            ladderAdded = false;
            
            while (!ladderAdded) {
            
                int j = (int) (Math.random() * arr[i].length);
                if (Math.random() * 10 > 8 && arr[i][j].equals("")) {
                    addObject(new Ladder(), (j * 32) + (64 * (arr.length - i)), (i * 96) + 100);
                    addObject(new Ladder(), (j * 32) + (64 * (arr.length - i)), (i * 96) + 132);
                    addObject(new Ladder(), (j * 32) + (64 * (arr.length - i)), (i * 96) + 164);
                    arr[i][j] = "ladder";
                    ladderAdded = true;
                }
            }
        }
        
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                
                if (Math.random() * 10 > 6 && arr[i][j].equals("")) {
                    addObject(new Cheese(), j * 32 + (64 * (arr.length - i)), (i * 96) + 140);
                    arr[i][j] = "cheese";
                }
            }
        }
    }
    
    public void act()
    {
    }
    
}