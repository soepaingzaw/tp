package seedu.duke.foodstore;

public class FoodStore {

    public final String storeName;
    public final String storeDescription;
    public boolean isHalal;

    public FoodStore(String storeName, String storeDescription) {
        this.storeName = storeName.trim();
        this.storeDescription = storeDescription.trim();
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

    public void setHalal() {
        isHalal = true;
    }

    public void clearHalal() {
        isHalal = false;
    }

    public String toString() {
        if (isHalal()) {
            return "[Halal] " + getStoreName() + ": " + getStoreDescription();
        } else {
            return "[Non-Halal] " + getStoreName() + ": " + getStoreDescription();
        }
    }
}
