package com.marksuree;

/**
 * This class is parent for real flowers clases
 */
public class Flower {
    private int height;

    /**
     * Method for overriding in child classes
     * @return Bud object of Bud class
     */
    public Bud createBud()
    {
            return new Bud();
    }



}
