import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class DatabaseTests {
    private static final Integer[] INITIAL_ELEMENTS = new Integer[]{1, 2, 3};

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithLessThanOneElement() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Database database = new Database(new Integer[17]);
    }

    @Test
    public void constructorShouldIncreaseElements() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database database = new Database(INITIAL_ELEMENTS);
        Field elementsCount = Database.class.getDeclaredField("elementsCount");
        elementsCount.setAccessible(true);
        int elements = elementsCount.getInt(database);
        Assert.assertEquals(elements, INITIAL_ELEMENTS.length);
        Assert.assertEquals(database.getElements().length, INITIAL_ELEMENTS.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementThrowsException() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);
        database.add(null);
    }

    @Test
    public void addingElementIncreasesElementsCount() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);
        database.add(12);
        Assert.assertEquals(INITIAL_ELEMENTS.length + 1, database.getElements().length);
    }

    @Test
    public void removeElementShouldRemoveTheLastElement() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);
        database.add(12);
        database.remove(INITIAL_ELEMENTS.length);
        Assert.assertArrayEquals(database.getElements(), INITIAL_ELEMENTS);
    }
}
