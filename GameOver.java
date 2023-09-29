import mayflower.*;
public class GameOver extends World
{
    
    public GameOver() {
        setBackground("sprites/background/gameover.png");
    }
    
    public void act() {
    
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            
            Mayflower.setWorld(new Title());
        }
    }
}
