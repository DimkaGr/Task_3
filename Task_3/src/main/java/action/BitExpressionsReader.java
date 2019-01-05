package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BitExpressionsReader {
    private String string=null;
    private Stack<Integer> stack=new Stack();
    private Stack<String> stackStr=new Stack();
    List<String> list=new ArrayList();
    private String tempNum="";
    private int num1;
    private int num2;

    public String bitTranslate(String str){

        if(str.charAt(str.length()-1)==' '){
            str=str.substring(0,str.length()-1);
        }

        /*parse bit expression with the help of reverse polish notation*/

        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))||str.charAt(i)=='-'){
                tempNum+=str.charAt(i);
            }else {
                if (!tempNum.equals("")) {
                    list.add(tempNum);
                    tempNum="";
                }
                if(str.charAt(i) >='A'&&str.charAt(i)<='z'&&str.charAt(i)!='^'){
                    return "";
                }
                if (str.charAt(i) == '(') {
                    stackStr.push("(");
                } else if (str.charAt(i) == ')') {
                    while (!stackStr.peek().equals("(")) {
                        list.add(stackStr.pop());
                    }
                    stackStr.pop();
                } else if (str.charAt(i) == '<') {
                    if (str.charAt(i + 1) == '<') {
                        stackStr.push("<<");
                        i++;
                    }
                } else if (str.charAt(i) == '>') {
                    if (str.charAt(i + 1) == '>'){
                        stackStr.push(">>");
                        i++;
                    }
                } else {
                    stackStr.push(str.charAt(i)+"");
                }
            }
        }if(!tempNum.equals("")) {
            list.add(tempNum);
        }
        while(!stackStr.isEmpty()){
            if(stackStr.peek().equals("(")){
                stackStr.pop();
            }
            list.add(stackStr.pop());
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i).charAt(0)=='-'||(list.get(i).charAt(0)>='0'&&list.get(i).charAt(0)<='9')){
                stack.push(Integer.valueOf(list.get(i)));
            }else{
                num2=stack.pop();
                if(!list.get(i).equals("~")) {
                    num1 = stack.pop();
                }
                if(list.get(i).equals("<<")) {
                    num1 = num1 << num2;
                    stack.push(num1);
                }else if(list.get(i).equals(">>")) {
                    num1 = num1 >> num2;
                    stack.push(num1);
                }else if(list.get(i).equals("&")) {
                    num1 = num1 & num2;
                    stack.push(num1);
                }else if(list.get(i).equals("|")) {
                    num1 = num1 | num2;
                    stack.push(num1);
                }else if(list.get(i).equals("^")) {
                    num1 = num1 ^ num2;
                    stack.push(num1);
                }else if(list.get(i).equals("~")) {
                    num2 = ~num2;
                    stack.push(num1);
                    stack.push(num2);
                }
            }
        }
        string=stack.pop().toString();
        return string;
    }
}
