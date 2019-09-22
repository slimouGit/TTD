package VoidMethodenTesten;

import VoidMethoden.ListenManipulation;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListenManipulationTest {

    static  List<String> nameList = new ArrayList<String>();

    ListenManipulation listenManipulation = new ListenManipulation();

    @BeforeClass
    public static void addNamen(){
        nameList.add("Michaela");
        nameList.add("Tanja");
        nameList.add("Peter");
        nameList.add("Max");
        nameList.add("Steffi");
    }

    @Test
    public void removeFirstItemFromList(){
        int originListSize = nameList.size();
        listenManipulation.removeFirstItemFromList(nameList);
        int newListSizeAfterRemove = nameList.size();
        assertEquals(originListSize-1,newListSizeAfterRemove);
    }

    @Test
    public void removeObjectFromList(){
        String testName = "Peter";
        assertTrue(testName + " is an item in list", nameList.contains(testName));
        listenManipulation.removeObjectFromList(nameList, testName);
        assertFalse(testName + " deleted from list", nameList.contains(testName));
    }

    @Test
    public void noResultAfterTryingToRemoveNotAvailableItemInList(){
        String testName = "Miriam";
        int originListSize = nameList.size();
        listenManipulation.removeObjectFromList(nameList, testName);
        int listSizeAfterManipulation = nameList.size();
        assertEquals(originListSize, listSizeAfterManipulation);
    }
}
