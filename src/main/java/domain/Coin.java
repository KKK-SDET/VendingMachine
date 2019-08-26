package domain;

public class Coin
{
    /// <summary>
    /// domain.Coin Denomination value
    /// </summary>
    public int denomination;
    /// <summary>
    /// Total number of coins
    /// </summary>
    public int count;

    public Coin(int denomination, int count)
    {
        this.denomination = denomination;
        this.count = count;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
