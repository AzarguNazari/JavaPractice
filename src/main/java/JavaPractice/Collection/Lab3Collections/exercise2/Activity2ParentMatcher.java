package Lab3Collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Azargul Nazari (1414322)
 */
public class Activity2ParentMatcher {
 
    // Class Name is ParentMatcher
    private final Deque<Character> stack = new ArrayDeque<>();
    private char[] currLine;
    
    /**
     * This method processes the string to figure out whether the parenthesis is positioned right or not
     * @param line is the string to be processed
     * @return true if the stack is empty otherwise false
     */
    public boolean processLine(String line){
        stack.clear();
        currLine = line.toCharArray();
        for(char c : currLine){
            switch(c){
                case '(':
                    stack.push(c);
                break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    else{
                       stack.pop();
                    }
                break;
            }
        }
        return stack.isEmpty();
    }
    
    /**
     * This method is to check all the string and find its validity
     * @param line  accepts an array of strings to be processed
     */
    public void processArray(String[] line){
        int count = 0;
        for(String s: line){
            if(processLine(s)){
                System.out.println("Line " + count + " is valid");
            }
            else{
                System.out.println("Line " + count + " is invalid");
            }
            count++;
        }
    }
    
    public static void main(String[] args) {
        
        Activity2ParentMatcher pm = new Activity2ParentMatcher();
        String[] expressions = new String[4];

        // all the expressions
        expressions[0] = "if ((a == b) && (x != y));";
        expressions[1] = "if ((a == b) && (x != y)));";
        expressions[2] = "if ((firstName.equals(newFirstName) && (lastName.equals(newLastName));";
        expressions[3] = "if ((firstName.equals(newFirstName) && (lastName.equals(newLastName))));";
        
        // printing
        pm.processArray(expressions);
        
    }
    
}
