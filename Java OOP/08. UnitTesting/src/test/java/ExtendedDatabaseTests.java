import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Person;
import p02_ExtendedDatabase.Database;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTests {
    private static final Person P1 = new Person(1,"Pesho");
    private static final Person P2 = new Person(2,"Gosho");
    private static final Person P3 = new Person(1,"Duplicate");
    private static final Person P4 = new Person(-1,"Negative");

    Person[] elements;
    @Before
    public void beforeEach() {
        elements = new Person[]{P1, P2};
    }

//    2 tests requested in the assignment but not implemented in the provided class:

//    @Test(expected = OperationNotSupportedException.class)
//    public void cantAddDuplicatedId() throws OperationNotSupportedException {
//        Database database = new Database(elements);
//        database.add(P3);
//    }

//    @Test(expected = OperationNotSupportedException.class)
//    public void cantAddDuplicatedId() throws OperationNotSupportedException {
//        Database database = new Database(elements);
//        database.add(P3);
//    }

    @Test(expected = OperationNotSupportedException.class)
    public void throwsWhenUsernameNotFound() throws OperationNotSupportedException {
        Database database = new Database(elements);
        database.findByUsername("Stamat");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void throwsWhenSearchedUsernameIsNull() throws OperationNotSupportedException {
        Database database = new Database(elements);
        database.findByUsername(null);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void cantFindWhenSearchingLowercase() throws OperationNotSupportedException {
        Database database = new Database(elements);
        Person target = database.findByUsername("pesho");
        Assert.assertNotEquals(target, P1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void cantFindWhenSearchingUppercase() throws OperationNotSupportedException {
        Database database = new Database(elements);
        Person target = database.findByUsername("PESHO");
        Assert.assertNotEquals(target, P1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void throwsWheniDNotFound() throws OperationNotSupportedException {
        Database database = new Database(elements);
        database.findById(5);
    }

}
