/*
 * R.H.S.S.Nandasiri
 * 110382F
 */
package rating_system;

/**
 *
 * @author Sameera
 */
public class User {
    private String name;
    private int ratingCount=1;
    private double weight=1;
    private int sumOfRating=0;
    public User(String user)
    {
        this.name=user;
    }
    public User(String user,int rating)
    {
        this.name=user;
        sumOfRating+=rating;
    }
    public void incrementCount()
    {
        ratingCount++;
        weight=2-(1.0/ratingCount);
    }
    public void newRating(int rating)
    {
        this.incrementCount();
        sumOfRating+=rating;
    }
    public int getRatingSum()
    {
        return sumOfRating;
    }
    public int getCount()
    {
        return ratingCount;
    }
    public double getWeight()
    {
        return weight;
    }
    public String getName()
    {
        return name;
    }
}
