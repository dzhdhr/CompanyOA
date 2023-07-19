package blackrock;

import java.util.ArrayDeque;
import java.util.HashMap;

public class ValidateP {
    public static boolean isValidate(String input){
        HashMap<Character,Character>map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c:input.toCharArray()){
            if(c=='{'||c=='}'||c=='['||c==']'||c=='('||c==')'){
                if(map.containsKey(c)){
                    stack.push(c);
                }
                else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    else{
                        if(map.get(stack.peek())==c){
                            stack.pop();
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "dwd{dwd{[dwdw]dsdad}}";
        System.out.println(isValidate(input));
    }
}
