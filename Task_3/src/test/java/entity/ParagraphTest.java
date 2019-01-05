package entity;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphTest {
    @Test
    public void testParse() throws Exception {
        Paragraph par=new Paragraph("\tIt has survived - not only (five) centuries, but also the leap into 13<<2 electronic\n" +
                "typesetting, remaining 3>>5 essentially 6&9|(3&4) unchanged. It was popularised in the\n" +
                "5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem\n" +
                "Ipsum passages, and more recently with desktop publishing software like Aldus\n" +
                "PageMaker including versions of Lorem Ipsum.\n");
        assertEquals(par.parse(),"\tIt has survived - not only (five) centuries, but also the leap into 52 electronic\n" +
                "typesetting, remaining 0 essentially 0 unchanged. It was popularised in the\n" +
                "5 with the release of Letraset sheets containing Lorem\n" +
                "Ipsum passages, and more recently with desktop publishing software like Aldus\n" +
                "PageMaker including versions of Lorem Ipsum.\n");
    }

}