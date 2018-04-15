package com.marksuree.flowers;

import com.marksuree.flowers.flowers_components.Bud;
import com.marksuree.flowers.flowers_components.Leaf;

/**
 * This abstract class is parent for real flowers clases
 */
public abstract class Flower {
    protected int height;
    protected Leaf flowerLeaf;

    public abstract Leaf createLeaf();
    public abstract Bud createBud();

    /**
     * Method for setting private height
     * @param height
     */
    public void setHeight(int height) {
        if(height > this.height)
        this.height = height;
    }

    /**
     * Standard getter for Height
     * @return height
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Destructor for created roses
     * @param flower
     */
    public void destroyFlower(Flower flower)
    {
        Rose rose = (Rose) flower;
        rose.destroyBud();
        rose.destroyLeaf();
        rose = null;
    }
}
