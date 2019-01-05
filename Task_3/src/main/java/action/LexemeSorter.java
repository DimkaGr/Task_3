package action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexemeSorter {

    public List<String> sortLexemes(List<String> list,char ch){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int num1=0;
                int num2=0;
                for(int i=0; i<s1.length(); i++){
                    if(s1.charAt(i)==ch){
                        num1++;
                    }
                }
                for(int i=0; i<s2.length(); i++){
                    if(s2.charAt(i)==ch){
                        num2++;
                    }
                }
                if(num1>num2){
                    return-1;
                }
                else if(num1<num2){
                    return 1;
                }
                else{
                    return s1.compareTo(s2);
                }
            }
        });
        return list;
    }
}
