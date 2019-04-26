import greenfoot.*;

/**
 * A block that bounces back and forth across the screen.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Block extends Actor
{
    private int delta = 2;
    
    /**
     * Move across the screen, bounce off edges. Turn leaves, if we touch any.
     */
    public void act() 
    {
        move();
        checkEdge();
        checkMouseClick();
        checkForLeafCollision();
    }
    
    /**
     * Remove a Leaf if the block collides with it.
     */
    private void checkForLeafCollision()
    {
        // Get an object reference to a single Leaf from any Leaf object we
        // are currently intersecting
        
        // Note: By placing a type in brackets before the call for the
        //  GetOneIntersectingObject, we cast (or force_ the type to change
        // from Actor to Leaf
        // We can do this because Leaf is a subclass of Actor
        Leaf aLeaf = (Leaf) getOneIntersectingObject(Leaf.class);
        
        // Check that the aLeaf object actually has a reference to an object
        // If it is null, it means there was no Leaf intersecting the block.
        if (aLeaf != null)
        {
            // aLeaf is not null, so we can remove it
            World myWorld = getWorld();
            myWorld.removeObject(aLeaf);
        }
    }
    
    /**
     * Move sideways, either left or right.
     */
    private void move()
    {
        setLocation(getX()+delta, getY());
    }
    
    /**
     * Check whether we are at the edge of the screen. If we are, turn around.
     */
    private void checkEdge()
    {
        if (isAtEdge()) 
        {
            delta = -delta;  // reverse direction
            
            // Add a leaf object
            // Add a reference to the world
            World myWorld = getWorld();
            // Use the object reference to call a method on the world object
            myWorld.addObject(new Leaf(), getX(), getY());
            
        }
    }
    
    /**
     * Check whether the mouse button was clicked. If it was, change all leaves.
     */
    private void checkMouseClick()
    {
        if (Greenfoot.mouseClicked(null)) 
        {
            // do this when the mouse is clicked. currently: nothing.
        }
    }
    
    
}
