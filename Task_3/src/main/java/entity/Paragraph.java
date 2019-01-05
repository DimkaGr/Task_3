package entity;

import entity.chain.ChainClass;
import entity.composite.CompositeObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph extends ChainClass implements CompositeObject {
    private List<ChainClass>list=new ArrayList<>();
    private List<ChainClass>sentenceList=new ArrayList<>();
    private Pattern pattern=Pattern.compile("[^.?!]+([.!?])");
    private String string="";
    private String result="";

    public Paragraph(String string) {
        this.string = string;
    }

    @Override

    public String parse(){
        Matcher matcher=pattern.matcher(string);
        while(matcher.find()){
            sentenceList.add(new Sentence(string.substring(matcher.start(),matcher.end())));
        }
        for(ChainClass p:sentenceList){
            result=result+((Sentence)p).parse();
        }
        return result;
    }
    @Override
    public void addLeaf(ChainClass leaf){
        list.add(leaf);
    }
}
