package dk.mikkel.Interfaces;

import dk.mikkel.Item;
import dk.mikkel.ItemShelf;

import java.util.ArrayList;

public interface IFindSpaceStategy {
    ItemShelf findSpace(ArrayList<ItemShelf> shelves, Item i);
}
