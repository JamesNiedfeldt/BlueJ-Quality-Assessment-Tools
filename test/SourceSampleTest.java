import org.junit.Test;

import static org.junit.Assert.*;

public class SourceSampleTest {

    @Test
    public void aMethodTest() {
        SourceSample basic = new SourceSample("one");
        String ret = basic.aMethod("_two");
        assertEquals(ret, "one_two");
    }
}