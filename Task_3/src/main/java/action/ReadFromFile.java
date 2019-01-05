package action;

import entity.exception.FileReadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFromFile {
    private Logger LOG = LogManager.getLogger(ReadFromFile.class);

    public String readFile(String filePath) throws FileReadException{
        List<String>list=new ArrayList();
        Path path=Paths.get(filePath);
        try(Stream<String> temp = Files.lines(path, StandardCharsets.UTF_8)) {
            list = temp.collect(Collectors.toList());
        }catch(FileNotFoundException e){
            LOG.error("Couldn't find file "+path);
        }catch(IOException e){
            LOG.error("Couldn't read file "+path);
            throw new FileReadException("Exception while reading file");
        }
        String str="";
        String temp="\t";
        int paragraphCounter=0;
        for(String s:list) {
            if(s.charAt(0)=='\t'&&paragraphCounter!=0){
                s=temp+s;
            }
            paragraphCounter++;
            str=str+s+"\n";
        }
//        str=str+temp;
        return str;
    }
}
