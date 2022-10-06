package googlevo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenrateIf {
    public static List<String> generateIf(int n){
        List<String>ret = new LinkedList<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        backTracking(ret,stack,n*2,0,sb);
        return ret;
    }
    // size number of if or } needed
    public static void backTracking(List<String> ret, ArrayDeque<String> stack,int size,int indent,StringBuilder sb){
        if(size==0&&stack.isEmpty()){
            ret.add(sb.toString());
            return;
        }
        if(size==0)return;
        // add if{
        StringBuilder cur = new StringBuilder();
        int prevlen = sb.length();
        cur.append("\t".repeat(Math.max(0, indent)));
        cur.append("if{\n");

        sb.append(cur);
        stack.push("if{");
        backTracking(ret,stack,size-1,indent+1,sb);
        stack.pop();
        sb.delete(prevlen,sb.length());

        // add }
        if(!stack.isEmpty()){
            StringBuilder temp2 = new StringBuilder();
            temp2.append("\t".repeat(Math.max(0, indent-1)));
            temp2.append("}\n");

            sb.append(temp2);
            String front = stack.pop();
            backTracking(ret,stack,size-1,indent-1,sb);
            stack.push(front);
            sb.delete(prevlen,sb.length());
        }

    }

    public static void main(String[] args) {
        System.out.println(generateIf(4));
    }
}
