package action;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BitExpressionsReaderTest {
    @Test
    public void testBitTranslate() throws Exception {
        BitExpressionsReader reader=new BitExpressionsReader();
        assertEquals(reader.bitTranslate("((1&2)|3)<<2"),"12");
    }
}