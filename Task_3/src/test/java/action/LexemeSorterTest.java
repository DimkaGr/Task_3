package action;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class LexemeSorterTest {
    @Test
    public void testSortLexemes() throws Exception {
        LexemeSorter sort=new LexemeSorter();
        List<String>list=new ArrayList();
        list.add("aba");
        list.add("aaab");
        list.add("aaac");
        list.add("bc");
        list.add("aaabb");
        List<String>list2=new ArrayList();
        list2.add("aaab");
        list2.add("aaabb");
        list2.add("aaac");
        list2.add("aba");
        list2.add("bc");
        assertEquals(sort.sortLexemes(list,'a'),list2);
    }

}