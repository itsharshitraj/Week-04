package listmanagertest;
import junit.testinglistoperations.ListManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private List<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
    }

    // Test addElement method
    @Test
    public void testAddElement() {
        ListManager.addElement(list, 10);
        assertTrue(list.contains(10));
        assertEquals(1, ListManager.getSize(list));
    }

    // Test removeElement method
    @Test
    public void testRemoveElement() {
        ListManager.addElement(list, 20);
        assertTrue(ListManager.removeElement(list, 20));
        assertFalse(list.contains(20));
        assertEquals(0, ListManager.getSize(list));
    }

    // Test removeElement when element is not in the list
    @Test
    public void testRemoveElementNotInList() {
        assertFalse(ListManager.removeElement(list, 30));
        assertEquals(0, ListManager.getSize(list));
    }

    // Test getSize method
    @Test
    public void testGetSize() {
        assertEquals(0, ListManager.getSize(list)); // Empty list
        ListManager.addElement(list, 5);
        ListManager.addElement(list, 15);
        assertEquals(2, ListManager.getSize(list));
    }
}

