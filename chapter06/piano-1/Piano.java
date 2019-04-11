import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A piano that can be played with the computer keyboard.
 * 
 * @author: M. Kölling
 * @version: 0.1
 */
public class Piano extends World
{
    /**
     * Instance variables
     * (can be used anywhere in the class)
     */
    int frames;
    /**
     * Make the piano.
     */
    public Piano() 
    {
        super(800, 340, 1);
        // initialize instance variable
        frames = 0;
    }
    /**
     * act (gets called repeatedly)
     */
    public void act()
    {
        // Track frames
        frames +=1;
        
        // Show frames
        showText("" + frames, 100, 100);
    }
}