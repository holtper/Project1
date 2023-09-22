import mayflower.*;

public class Title extends World {
    
    public Title() {
        setBackground("sprites/title.png");
        
    }
    
    public void act() {
    
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            
            Mayflower.setWorld(new Level1());
        }
    };
}