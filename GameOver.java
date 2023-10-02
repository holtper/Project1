import mayflower.*;
public class GameOver extends World
{
    
    public GameOver() {
        setBackground("sprites/background/gameover.png");
    }
    
    //checks for enter pressed, resets to main menu
    public void act() {
    
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            
            Mayflower.setWorld(new Title());
        }
    }
}
