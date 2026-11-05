package dk.mikkel;

import dk.mikkel.Interfaces.IObserver;

import java.util.ArrayList;

public class ItemShelf {

    private String name;
    private double totalCapacity;
    private double capacity;
    private Warehouse warehouse;
    private ArrayList<Item> items;

    private ArrayList<IObserver> observers;

    public ItemShelf(String name, double capacity){
        this.name = name;
        this.capacity = capacity;
        this.totalCapacity = capacity;
        this.items = new ArrayList<Item>();
        this.observers = new ArrayList<IObserver>();
    }

    public boolean addItem(Item item){
        if(capacity > item.getSize()){
            this.items.add(item);
            this.capacity -= item.getSize();
            for(IObserver o : this.observers){
                o.update("itemAdded");
            }
            return true;
        }
        System.out.println("Capacity Reached!");
        return false;
    }


    public boolean removeItem(String itemName){
        for(Item i : this.items){
            if(i.getName().equals(itemName)){
                this.items.remove(i);
                for(IObserver o : this.observers){
                    o.update("itemRemoved");
                }
                return true;
            }
        }
        System.out.println("Item not on shelf!");
        return false;
    }

    public void addObserver(IObserver observer){
        observers.add(observer);
    }

    @Override
    public String toString(){ //Undskyld til Danny hvis du skal læse det her. Det er virkelig spaghetti kode, men var bare en lille sjov feature
        String shelfString = "----------------------------------\n";
        int lineLen = 33;
        int spacesAtEnd = lineLen - ("| SHELF OVERVIEW FOR " + this.name.toUpperCase()).length();
        shelfString += "| SHELF OVERVIEW FOR " + this.name.toUpperCase()+ " ".repeat(spacesAtEnd) + "|\n";
        shelfString += "----------------------------------\n";
        shelfString += "| ITEM       CATEGORY       SIZE |\n";
        for(Item i : this.items){
            spacesAtEnd = lineLen - ("| " + i.toString()).length();
            shelfString += "| " + i.toString() + " ".repeat(spacesAtEnd) + "|\n";
        }
        shelfString += "----------------------------------\n";

        spacesAtEnd = lineLen - ("| TOTAL CAPACITY / CAPACITY").length();
        shelfString += "| TOTAL CAPACITY / CAPACITY" + " ".repeat(spacesAtEnd)+"|\n";

        spacesAtEnd = lineLen - ("| " + this.totalCapacity + " / " + this.capacity).length();
        shelfString += "| " + this.totalCapacity + " / " + this.capacity + " ".repeat(spacesAtEnd) + "|\n";
        shelfString += "----------------------------------\n";
        return shelfString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getTotalCapacity(){
        return totalCapacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
