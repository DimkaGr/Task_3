package action;

import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class ReadFromFileTest {
    @Test
    public void testReadFile() throws Exception {
        ReadFromFile reader=new ReadFromFile();
        String string="\tIt has survived - not only (five) centuries, but also the leap into 13<<2 electronic\n"
                +"typesetting, remaining 3>>5 essentially 6&9|(3&4) unchanged. It was popularised in the\n"
                +"5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem\n"
                +"Ipsum passages, and more recently with desktop publishing software like Aldus\n"
                +"PageMaker including versions of Lorem Ipsum.\n";
        assertEquals(reader.readFile("test.txt"),string);
    }
}