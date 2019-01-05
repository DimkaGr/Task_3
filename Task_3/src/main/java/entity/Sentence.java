package entity;

import entity.chain.ChainClass;
import entity.composite.CompositeObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence extends ChainClass implements CompositeObject {
    private List<ChainClass>list=new ArrayList<>();
    private List<ChainClass>lexemeList=new ArrayList<>();
    private Pattern pattern=Pattern.compile(".+?([\\s.?!])");
    private String string="";
    private String result="";

    public Sentence(String string){
        this.string=string;
    }

    @Override
    public String parse(){
        Matcher matcher=pattern.matcher(string);
        while(matcher.find()){
            lexemeList.add(new Lexeme(string.substring(matcher.start(),matcher.end())));
        }
        for(ChainClass p:lexemeList){
            result=result+((Lexeme)p).parse();
        }
        if(result.charAt(result.length()-1)==' '){
            result=result.substring(0,result.length()-1);
        }
        return result;
    }
    @Override
    public void addLeaf(ChainClass leaf){
        list.add(leaf);
    }
}
