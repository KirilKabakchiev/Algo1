package algo.brackets;

import java.util.Stack;

import org.omg.CORBA.Current;

public class Brackets {
    public static boolean checkParentesis(String str) {
        if (str.isEmpty())
            return true;

       if(Character.isDigit(str.charAt(0)) || Character.isDigit(str.charAt(str.length()-1))){
           return false;
       }
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            
            if(current != '(' && current != '[' && current != '{' && current != ')' && current != ']' && current != '}'){
                continue;
            }

            if (current == '{') {
                if(!stack.isEmpty()){
                    return false;
                }
                stack.push(current);
            }
            
            if (current == '[') {
                if(!stack.isEmpty()){
                    char last = stack.peek();
                    if(last != '{'){
                        return false;
                    }  
                }
                stack.push(current);
            }
            
            if (current == '(') {
                if(!stack.isEmpty()){
                    char last = stack.peek();
                    if(last != '['){
                        return false;
                    }
                }
                stack.push(current);
            }

            if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty())
                    return false;

                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
    
    public static int evaluate(String s){
        
        int sum = 0, part = 0, i = 0, number = 0, result = 0;
        Stack<String> stack = new Stack<>();
        for(i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == '{' || current == '[' || current == '('){
               stack.push(String.valueOf(current));
            }
            else if(Character.isDigit(current)){
                number *= 10;                          
                number += Integer.valueOf(Character.toString(current));             
                char next = s.charAt(i+1);
                if(!Character.isDigit(next)){
                    stack.push(String.valueOf(number));              
                    number = 0;
                    continue;
                }          
            }
            else {
                sum = 0;
                String peakit = stack.peek();
                while(!(peakit.charAt(0) == '{' || peakit.charAt(0) == '[' || peakit.charAt(0) == '(')){
                    String c = stack.pop();
                    sum += Integer.valueOf(c);
                    peakit = stack.peek();
                }
                stack.pop();
               if(!stack.isEmpty()){
                   stack.push(String.valueOf(2*sum));
               }
               else{               //ako steka e stanal prazen ima dva varainta (..) {..[..(..)..]..} i empty
                   //ako e empty dobavqme v result i 6te izlezem ot cikula zastoto sme obxodili stringa (cikulut prosto si svru6va)
                   //ina4e dobavqme "nesvurzanata komponenta v result i produljavame napred
                    result += sum;
                }
            }
        }    
        return result;
    }
    
    public static void checkAndEvaluate(String s){
        if(!checkParentesis(s)){
            System.out.println("NO");
        }
        else {
            System.out.println(evaluate(s));
        }
    }

    public static void main(String[] args) {
       
        
        checkAndEvaluate("{125[2][(1)][3]125}");
        checkAndEvaluate("[123(145)38(37)812]");
        checkAndEvaluate("[125()125()125()125]");
        checkAndEvaluate("{125()125}");
        checkAndEvaluate("{125[12]{125}[12]125}");
        checkAndEvaluate("{125[12(123]125}");
    }
}
