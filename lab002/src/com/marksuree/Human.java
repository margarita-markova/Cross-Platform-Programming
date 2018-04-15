package com.marksuree;

import static com.marksuree.Bud.isBudCreated;

/**
 * This class is human. It's singleton. It's just user.
 */
public class Human {

    private String name;
    private Bud myBud;
    private Flower myFlower;

    private static Human _instance = null;

    /**
     * Private constructor for class - is implementation of singleton pattern
     */
    private Human() {}

    /**
     * It's more like constructor, but it always return one created object
     * @return _instance static parameter, which handles our one object of human class.
     */
    public static synchronized Human getInstance() {
        if (_instance == null)
            _instance = new Human();
        return _instance;
    }

    /**
     * This method "waters Flowers". it create new Bud for new rose/ Rose must have only one bud, and water Rose again
     * we receive nothing.
     * @return result string for label changing.
     */
    public String waterTheFlowers()
    {
        String result;
       if(getFlower()!=null)
       {
           if(isBudCreated)
           {
               result = "Жаль, что у этой розы не может быть больше одного бутона";
               return result;
           }
           else
           {
               myBud = getFlower().createBud();
               result = "Ого, у розы расцветает бутон! Не зря я ее поливала";
               return result;
           }
       }
        else
       {
           result = "Сначала нужно посадить розу...";
           return result;
       }
    }

    /**
     * Method gey smell from the rose's bud. It needs a rose and a bud.
     * @return result string for label changing
     */
    public String smellTheFlowers()
    {
        String result;
        if((getFlower()!= null))
        {
            if(isBudCreated)
            {
                result = myBud.getSmell();
                return result;
            }
            else
            {
                result = "У меня как-то кактус завял от того, что я его не поливала";
                return  result;
            }
        }
        else
        {
            result = "Сначала нужно посадить розу...";
            return result;
        }
    }

    /**
     * This method create new rose.
     * @param flower this parameter for every flower, not only rose
     * @return result string for label changing
     */
    public String plantAFlower(Flower flower)
    {
        if((getFlower() != null))
        {
                if (isBudCreated)
                {
                    isBudCreated = false;
                }
        }
        else
            {
                setFlower(flower);
            }

        return new String("Поздравляю, новая роза посажена!");
    }

    private void setFlower(Flower flower)
    {
        myFlower = flower;
    }

    private Flower getFlower()
    {
       return myFlower;
    }
}