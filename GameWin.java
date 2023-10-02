import mayflower.*;
public class GameWin extends World
{
    
    public GameWin() {
        setBackground("sprites/background/gamewin.png");
    }

    //checks for enter pressed, resets to main menu
    public void act() {
    
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            
            Mayflower.setWorld(new Title());
        }
    }
}
