package com.marksuree.flowers;

import com.marksuree.flowers.flowers_components.Bud;
import com.marksuree.flowers.flowers_components.Leaf;
import com.marksuree.flowers.flowers_components.Petal;

import static com.marksuree.flowers.flowers_components.Bud.isBudCreated;

/**
 * Class with Rose implementation.
 */
public class Rose extends Flower {
    private Bud roseBud;
    private Petal petals[];
    public static int numberOfRosePetals = 32;

    /**
     * overriding method for bud creation.
     * @return roseBud object of Bud class
     */
    @Override
    public Bud createBud()
    {
        if(isBudCreated)
        {
            return roseBud;
        }
        else
        {
            roseBud = new Bud();
            petals = new Petal[numberOfRosePetals];
            return roseBud;
        }
    }

    /**
     * overriding method for leaf creation.
     * @return roseBud object of Bud class
     */
    @Override
    public Leaf createLeaf()
    {
        flowerLeaf = new Leaf();
        return flowerLeaf;
    }

    /**
     * Destructor for petal objects
     */
    private void destroyPetals()
    {
        for(int i = 0; i < numberOfRosePetals; i++)
        {
            petals[i] = null;
        }
        petals = null;
    }

    /**
     * Destructor for bud objects
     */
    public void destroyBud()
    {
        isBudCreated = false;
        roseBud = null;
    }

    /**
     * Destructor for leaf objects
     */
    public void destroyLeaf()
    {
        flowerLeaf = null;
    }
}
