import mayflower.*;
public class GameWin extends World
{
    
    public GameWin() {
        setBackground("sprites/background/gameover.png");
    }
    
    public void act() {
    
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            
            Mayflower.setWorld(new Title());
        }
    }
}
