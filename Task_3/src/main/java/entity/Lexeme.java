package entity;

import action.BitExpressionsReader;
import entity.chain.ChainClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexeme extends ChainClass {
    private String string="";
    private String result="";
    private Pattern lexemePattern=Pattern.compile(".+?\\s");
    private Pattern bitPattern=Pattern.compile("(\\d|\\().+?$");
    private BitExpressionsReader bitReader=new BitExpressionsReader();

    public Lexeme(String string){
        this.string=string;
    }
    public String getLexeme(){
        return string;
    }

    @Override
    public String parse(){
        Matcher matcher=lexemePattern.matcher(string);
        if(matcher.find()){
            string=string.substring(matcher.start(),matcher.end());
        }
            Matcher bitWord=bitPattern.matcher(string);
            if(bitWord.find()){
                String temp=bitReader.bitTranslate(string);
                if(temp.equals("")){
                    result=result+string;
                }else {
                    result = result + temp+" ";
                }
            }else{
                result=result+string;
            }

        return result;
    }
}
