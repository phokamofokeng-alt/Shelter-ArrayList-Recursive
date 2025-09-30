# Shelter-ArrayList-Recursive


MyArrayList<StorageItem> inventory = new MyArrayList<>();
inventory.add(new StorageItem("Jacket", 5));
inventory.add(new StorageItem("Shirt", 10));

public static int findIndex(MyArrayList<StorageItem> list, StorageItem target, int index) {
    if (index >= list.size()) return -1; // not found
    StorageItem current = list.get(index);
    if (((Comparable)current).compareTo(target) == 0) return index;
    return findIndex(list, target, index + 1);


StorageItem needed = new StorageItem("Jacket", 0);
int idx = findIndex(inventory, needed, 0);
if (idx != -1) {
    System.out.println("Found " + inventory.get(idx));
} else {
    System.out.println("Item not available");
}

public static void donate(MyArrayList<StorageItem> list, StorageItem item, int qty) {
    if (qty <= 0) return;
    int idx = findIndex(list, item, 0);
    if (idx != -1) {
        list.get(idx).addQuantity(1);
    } else {
        list.add(new StorageItem(item.getType(), 1));
    }
    donate(list, item, qty - 1); // recursive call
}


?? For method with two classes ??
public class TestShelter {
    public static void main(String[] args) {
        Storage shelter = new Storage();

        // Donate some items recursively
        shelter.donate(new StorageItem("Jacket", 0), 5);
        shelter.donate(new StorageItem("Shirt", 0), 3);
        shelter.donate(new StorageItem("Socks", 0), 10);

        System.out.println("After donations:");
        shelter.printInventory();

        // Guest requests
        System.out.println("\nGuest requests 3 Jackets:");
        boolean result1 = shelter.request(new StorageItem("Jacket", 0), 3);
        System.out.println("Request successful? " + result1);
        shelter.printInventory();

        System.out.println("\nGuest requests 2 Socks:");
        boolean result2 = shelter.request(new StorageItem("Socks", 0), 2);
        System.out.println("Request successful? " + result2);
        shelter.printInventory();

        System.out.println("\nGuest requests 10 Shirts (more than available):");
        boolean result3 = shelter.request(new StorageItem("Shirt", 0), 10);
        System.out.println("Request successful? " + result3);
        shelter.printInventory();
    }
}