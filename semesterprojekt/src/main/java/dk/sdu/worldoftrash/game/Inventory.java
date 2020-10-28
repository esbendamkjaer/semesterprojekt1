package dk.sdu.worldoftrash.game;
import dk.sdu.worldoftrash.game.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final int max_size;
    private List<Item> items = new ArrayList<Item>();

    public Inventory(int max_size) {
        this.max_size = max_size;
    }

    /**
     * Stores a given item in inventory, if it is not full.
     * @param item Item to store in inventory.
     * @return Whether or not the item could fit in the inventory.
     */
    public boolean storeItem(Item item){
        if (isFull()) return false;

        items.add(item);

        return true;
    }

    /**
     * Removes given item object from inventory.
     * @param item Item to remove from inventory.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Searches inventory for item with given name and returns true if found.
     * @param name Name of item to search for.
     * @return True of inventory contains item with given name, otherwise false.
     */
    public boolean hasItemWithName(String name) {
        for (Item i : items) {
            if (i.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get an item from the inventory specified by given name.
     * @param name Name of item to retrieve.
     * @return Returns the Item object. If none found in the inventory, it returns null.
     */
    public Item getItemByName(String name) {
        for (Item i : items) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Returns whether or not the inventory is full.
     * @return whether or not the inventory is full.
     */
    public boolean isFull() {
        return items.size() >= max_size;
    }

    /**
     * Prints out the inventory
     */
    public void printInv() {

        System.out.print("Inventory: ");

        if (items.size() <= 0) {
            System.out.println("Empty");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.print((i == 0 ? "" : ", ") + items.get(i).getName());
        }
        System.out.print("\n");

    }
}