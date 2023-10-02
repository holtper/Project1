import mayflower.*;

public class Title extends World {
    
    public Title() {
        setBackground("sprites/background/title.png");
        
    }
    
    //checks for enter pressed, sets world to level 1
    public void act() {
    
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            
            Mayflower.setWorld(new Level1());
        }
    };
}