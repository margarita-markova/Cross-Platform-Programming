package com.marksuree.flowers.flowers_components;

/**
 * This class contains smell and static variable for roses creation.
 */
public class Bud {

    private String smell;
    public static boolean isBudCreated = false;

    /**
     * Default constructor
     */
    public Bud()
    {
        isBudCreated = true;
        smell = "Ммм... Пахнет, как (-)-цис-изомер розового оксида";
    }

    /**
     * Standard getter
     * @return smell
     */
    public String getSmell()
    {
        return smell;
    }
}
