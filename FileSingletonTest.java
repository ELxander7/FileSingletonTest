import ru.itis.inf304.lab8.FileSingleton;

import static org.junit.Assert.assertSame;
import org.junit.Test;
public class FileSingletonTest {

    @Test
    public void testSingletonInstance(){
        FileSingleton instance1 = FileSingleton.getInstance();
        FileSingleton instance2 = FileSingleton.getInstance();

        assertSame(instance1, instance2);
    }
}
