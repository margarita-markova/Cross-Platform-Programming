package com.marksuree;

/**
 * This class contains smell and static variable for roses creation.
 */
public class Bud {

    private String smell;
    protected static boolean isBudCreated = false;

    protected Bud()
    {
        isBudCreated = true;
        smell = "Ммм... Пахнет, как (-)-цис-изомер розового оксида";
    }

    public String getSmell()
    {
        return smell;
    }
}
