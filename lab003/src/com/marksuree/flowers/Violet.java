package com.marksuree.flowers;

import com.marksuree.flowers.flowers_components.Bud;
import com.marksuree.flowers.flowers_components.Leaf;

/**
 * Violet class for Flower realization
 */
public class Violet extends Flower {

    /**
     * Abstract parent method implementation for Bud creation
     * @return Bud
     */
    @Override
    public Bud createBud()
    {
       return new Bud();
    }

    /**
     * Abstract parent method implementation for Leaf creation
     * @return Leaf
     */
    @Override
    public Leaf createLeaf()
    {
        return new Leaf();
    }
}
