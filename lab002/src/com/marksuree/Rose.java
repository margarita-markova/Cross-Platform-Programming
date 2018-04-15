package com.marksuree;

import static com.marksuree.Bud.isBudCreated;
//
/**
 * Class with Rose implementation.
 */
public final class Rose extends Flower {
    private Bud roseBud;

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
            return roseBud;
        }
    }
}
