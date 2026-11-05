package dk.mikkel;

import dk.mikkel.Enums.ItemCategory;

public class Item {

    private ItemCategory category;
    private String name;
    private double size;

    //For printing
    private int gapLen = 7;
    private int ItemLen = "ITEM".length();
    private int CategoryLen = "CATEGORY".length();
    private int CapacityLen = "CAPACITY".length();

    public Item(ItemCategory category, String name, double size){
        this.category = category;
        this.name = name;
        this.size = size;
    }


    @Override
    public String toString(){
        return this.name + " ".repeat(ItemLen + gapLen - this.name.length())
                + this.category.toString() + " ".repeat(CategoryLen + gapLen - this.category.toString().length())
                + this.size + "\n";
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
