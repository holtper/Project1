import mayflower.*;
public class Animation extends Actor {
    
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    
    //sets animation loop to the argument
    Animation(int rate, String[] filenames) {
        
        framerate = rate;
        currentFrame = 0;
        
        frames = new MayflowerImage[filenames.length];
        for (int i = 0; i < frames.length; i++) {
            
            frames[i] = new MayflowerImage(filenames[i]);
        }
    }
    
    public int getFramerate() {
        
        return framerate;
    }
    
    //gets the next frame in an animation loop
    public MayflowerImage getNextFrame() {
        
        MayflowerImage currentImage = frames[currentFrame];
        currentFrame++;
        if (currentFrame >= frames.length) {
            
            currentFrame = 0;
        }
        return currentImage;        
    }
    
    public void scale(int w, int h) {
        
        for (int i = 0; i < frames.length; i++)
            frames[i].scale(w, h);
    }
    
    public void setTransparency(int percent) {
        
        for (int i = 0; i < frames.length; i++)
            frames[i].setTransparency(percent);
    }
    
    public void mirrorHorizontally() {
        
        for (int i = 0; i < frames.length; i++)
            frames[i].mirrorHorizontally();
    }
    
    public void setBounds(int x, int y, int w, int h) {
        
        for (int i = 0; i < frames.length; i++)
            frames[i].crop(x, y, w, h);
    }
    
    public void act() {}
}
