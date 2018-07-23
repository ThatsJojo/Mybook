package AllTests;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import util.HashSetTest;
import util.HashTableTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HashSetTest.class,
	HashTableTest.class,
})
public class AllTests { }
