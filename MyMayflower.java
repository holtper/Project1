import mayflower.*;

public class MyMayflower extends Mayflower 
{
    //Constructor
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("Project1", 800, 600);
    }

    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        Mayflower.playSound("sounds/level1theme.wav");
        Mayflower.setWorld(new Title());
    }
}
