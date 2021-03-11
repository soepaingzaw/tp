package seedu.duke.foodstore;

public class FoodStore {

    public final String storeName;
    public final String storeDescription;
    public boolean isHalal;

    public FoodStore(String storeName, String storeDescription, boolean isHalal) {
        this.storeName = storeName.trim();
        this.storeDescription = storeDescription.trim();
        this.isHalal = isHalal;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public boolean isHalal() {
        return isHalal;
    }

    public String toString() {
        if (isHalal()) {
            return "[H] " + getStoreName() + ": " + getStoreDescription();
        } else {
            return "[X] " + getStoreName() + ": " + getStoreDescription();
        }
    }
}
