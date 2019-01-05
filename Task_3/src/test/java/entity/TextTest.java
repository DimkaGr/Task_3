package entity;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextTest {
    @Test
    public void testParse() throws Exception {
        Text text=new Text();
        String string="\tIt has survived - not only (five) centuries, but also the leap into 52 electronic\n"
                +"typesetting, remaining 0 essentially 0 unchanged. It was popularised in the\n"
                +"5 with the release of Letraset sheets containing Lorem\n"
                +"Ipsum passages, and more recently with desktop publishing software like Aldus\n"
                +"PageMaker including versions of Lorem Ipsum.\n";
        assertEquals(text.parse("test.txt"),string);
    }
}