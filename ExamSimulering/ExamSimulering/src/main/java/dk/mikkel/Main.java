package dk.mikkel;

import dk.mikkel.Enums.ItemCategory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ItemShelf shelf1 = new ItemShelf("Food", 100);
        shelf1.addObserver(new ItemAddedObserver());
        shelf1.addObserver(new ItemRemovedObserver());

        ItemShelf shelf2 = new ItemShelf("Electronics", 200);
        shelf2.addObserver(new ItemAddedObserver());
        shelf2.addObserver(new ItemRemovedObserver());

        ItemShelf shelf3 = new ItemShelf("Misc", 250);
        shelf3.addObserver(new ItemAddedObserver());
        shelf3.addObserver(new ItemRemovedObserver());

        Warehouse warehouse = new Warehouse(shelf1, shelf2, shelf3);

        Item Burger = new Item(ItemCategory.Food, "Burger", 0.5);
        Item Pizza = new Item(ItemCategory.Food, "Pizza", 0.7);
        Item Cola = new Item(ItemCategory.Food, "Cola", 0.2);

        Item IPad = new Item(ItemCategory.Electronics, "IPad", 0.4);
        Item Fridge = new Item(ItemCategory.Electronics, "Fridge", 2);
        Item TV = new Item(ItemCategory.Electronics, "TV", 1);

        Item Jacket = new Item(ItemCategory.Misc, "Jacket", 0.5);
        Item Plane = new Item(ItemCategory.Misc, "Car", 100);

        warehouse.addItemToShelf("Food", Burger);
        warehouse.addItemToShelf("Food", Pizza);
        warehouse.addItemToShelf("Food", Cola);

        warehouse.addItemToShelf("Electronics", IPad);
        warehouse.addItemToShelf("Electronics", Fridge);
        warehouse.addItemToShelf("Electronics", TV);

        warehouse.addItemToShelf("Misc", Jacket);
        warehouse.removeItemFromShelf("Food", "Burger");


        warehouse.printShelf("Food");

        ItemShelf result = warehouse.findSpace(new FirstAvailableSpace(), Plane);
        if (result != null){
            System.out.println(result.toString());
        }else {
            System.out.println("No suitable shelf found");
        }

        result = warehouse.findSpace(new MostAvailableSpace(), Plane);
        if (result != null){
            System.out.println(result.toString());
        }else {
            System.out.println("No suitable shelf found");
        }
    }
}