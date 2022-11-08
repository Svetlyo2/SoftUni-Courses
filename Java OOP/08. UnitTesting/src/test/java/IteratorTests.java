import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class IteratorTests {
    String elements;
    ListIterator iterator;

    @Test
    public void cantCreateInstanceWithNullElements() throws OperationNotSupportedException{
        ListIterator listIterator = new ListIterator(elements);
    }
    @Before
    public void beforeEach() throws OperationNotSupportedException {
        iterator = new ListIterator("Stefcho", "Goshky");
    }

    @Test
    public void canCreateListIteratorInstance() {
        Assert.assertEquals(iterator.getClass().getSimpleName(), "ListIterator");
    }

    @Test
    public void canMoveIndexToNext() {
        Assert.assertTrue(iterator.move());
        Assert.assertEquals(iterator.print(), "Goshky");
    }
    @Test
    public void canMoveReturnsFalseWhenHasNotNextElement() {
        Assert.assertTrue(iterator.move());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void hasNextReturnsTrueWhenHasNextElement() {
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void printReturnsElementAtCurrentIndex() {
        Assert.assertEquals(iterator.print(), "Stefcho");
    }

    @Test
    public void printThrowsWithNoElements() throws IllegalStateException, OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("");
    }
}
