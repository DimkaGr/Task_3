package entity;

import action.ReadFromFile;
import entity.chain.ChainClass;
import entity.composite.CompositeObject;
import entity.exception.FileReadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends ChainClass implements CompositeObject {
    private Logger LOG = LogManager.getLogger(Text.class);
    private List<ChainClass>list=new ArrayList<>();
    private List<ChainClass>paragraphList=new ArrayList<>();
    private Pattern pattern=Pattern.compile("[^\t]+");

    private ReadFromFile reader=new ReadFromFile();    //if read data from file will be occured here
    @Override
    public String parse(){
        String string="";
        for(ChainClass p:paragraphList){
            string=string+"\t"+((Paragraph)p).parse();
        }
        return string;
    }
    @Override
    public void addLeaf(ChainClass leaf){
        list.add(leaf);
    }
    public String parse(String filePath){
        String string=null;
        try {
            string = reader.readFile(filePath);
            Matcher matcher=pattern.matcher(string);
            while(matcher.find()){
                paragraphList.add(new Paragraph(string.substring(matcher.start(),matcher.end())));
            }
            string=parse();
        }catch(FileReadException e){
            LOG.error("Exception while reading file "+filePath);
        }
        return string;
    }
}
