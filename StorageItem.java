public class StorageItem 
{
    private String type;
    private int quantity;

    public StorageItem(String type, int quantity)
    {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType()
    {
        return type;
    }

    public int getQuantity()
    {
        return quantity;

    }

    public void addQuantity(int n)
    {
        this.quantity += n;
    }
    public void removeQuantity(int n)
    {
        this.quantity -= n;
    }

    public String toString()
    {
        return "[ " +type+ ": " +quantity+ "]";
    }


}   