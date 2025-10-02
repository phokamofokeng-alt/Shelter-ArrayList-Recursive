public class Storage
{
    //create arrayList (called inventory) of type StorageItem
    // So T is StorageItem
    private MyArrayList<StorageItem> inventory;

    public Storage()
    {
        inventory = new MyArrayList<>();

    }

    // recursive method to find the item's index
    // takes target item
    public int findIndex(StorageItem item, int index)
    {
        //Base case: If index of item not found, return -1
        if (index >= inventory.size())
        {
            return -1;
        }

        // Otherwise retrieve item at index using get() method
        // Compare it to what's available in arrayList
        StorageItem foundItem = inventory.get(index);
        if(((Comparable)foundItem).compareTo(item) == 0)
        {
            return index;

        }
        
        return findIndex(item, index+1);

    }


    // Recursive donation method. Item being donated to Shelter
    // Donates one item at a time.
    // Takes item and quantity of how much is been donated
    public void donate(StorageItem item, int qty)
    {
        // If nothing being donated
        if(qty <=0)
        {
            return;
        }

        // if item type not in inventory
        // use findIndex method
        int index = findIndex(item, 0);
        if (index == -1)
        {
            // if item type is new to shelter
            StorageItem newItem = new StorageItem(item.getType(), 1);
            inventory.add(inventory.size(), newItem);

        }
        else // item just needs to be topped
        {
            // find item
            StorageItem oldItem = inventory.get(index);
            
            // Add to it
            oldItem.addQuantity(1);
            // If method was not recursive, we would write
            // inventory.oldItem.addQuantity(qty)

        }

        donate(item, qty -1);

    }

    // Method for shelter guests
    public boolean request(StorageItem item, int qty)
    {
        if (qty <= 0) // base case
        return true;

        int index = findIndex(item, 0);
        // item not available
        if(index == -1)
        {
            return false;

        }


        StorageItem found = inventory.get(index);
        if (found.getQuantity() >= 1)
        {
            found.removeQuantity(1);
            if(found.getQuantity() ==0)
            {
                inventory.remove(index);

            }
            return request(item, qty -1);

        }

        else
        {
            return false;
        }

        

    }



}