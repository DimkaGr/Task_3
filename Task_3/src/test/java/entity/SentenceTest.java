package entity;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceTest {
    @Test
    public void testParse() throws Exception {
        Sentence sent=new Sentence("It has survived - not only (five) centuries, but also the leap into 13<<2 electronic.");
        assertEquals(sent.parse(),"It has survived - not only (five) centuries, but also the leap into 52 electronic.");
    }

}