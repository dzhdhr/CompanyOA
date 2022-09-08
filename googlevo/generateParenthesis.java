package googlevo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

// 多个括号如何生成
public class generateParenthesis {
    // 多个括号如何生成
    public List<String> generate(int n, int m){
        List<String> ret = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character>stack = new ArrayDeque<>();
        backTracking(ret,sb, 0,0,n,m,stack);
        return ret;
    }
    private void backTracking(List<String> ret,StringBuilder sb, int small, int large, int smallTarget,int largeTarget,ArrayDeque<Character> prev){
        if(prev.isEmpty()&&small==smallTarget&&large==largeTarget){
            ret.add(sb.toString());
            return;
        }
        if(small<smallTarget){
            sb.append("(");
            prev.push('(');
            backTracking(ret,sb,small+1,large,smallTarget,largeTarget,prev);
            prev.pop();
            sb.deleteCharAt((sb.length()-1));
        }
        if(large<largeTarget){
            sb.append("[");
            prev.push('[');
            backTracking(ret,sb,small,large+1,smallTarget,largeTarget,prev);
            prev.pop();
            sb.deleteCharAt((sb.length()-1));
        }
        if(!prev.isEmpty()){
            if(prev.peek()=='('){
                sb.append(')');
                prev.pop();
                backTracking(ret,sb,small,large,smallTarget,largeTarget,prev);
                prev.push('(');
                sb.deleteCharAt((sb.length()-1));
            }
            else if(prev.peek()=='['){
                sb.append(']');
                prev.pop();
                backTracking(ret,sb,small,large,smallTarget,largeTarget,prev);
                prev.push('[');
                sb.deleteCharAt((sb.length()-1));
            }
        }
    }

    private final char[] elements = new char[]{'(',')','[',']'};
    // 优先级
    public List<String> generatePriority(int n, int m){
        List<String>ret = new LinkedList<>();
        ArrayDeque<Integer> prev = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int num[] = new int[]{0,0,0,0};
        int[] target = new int[]{n,n,m,m};

        backTrackingPriority(ret,prev,num,target,0,n*2+m*2,sb);
        return ret;

    }
    // i number ( in sb
    // i1 number [ in sb
    private void backTrackingPriority(List<String> ret, ArrayDeque<Integer> prev, int num[], int target[],int count, int total, StringBuilder sb) {
        if(prev.isEmpty()&&count==total){
            ret.add(sb.toString());
            return;
        }
        for(int i = 0;i<elements.length;i++){
            if(num[i]>=target[i]){
                continue;
            }
            if(i%2==0){
                if(prev.isEmpty()||prev.peek()>=i){
                    sb.append(elements[i]);
                    prev.push(i);
                    num[i]++;
                    count++;
                    backTrackingPriority(ret,prev,num,target,count,total,sb);
                    num[i]--;
                    count--;
                    prev.pop();
                    sb.deleteCharAt((sb.length()-1));
                }
            }
            if(i%2==1){
                if(!prev.isEmpty()&&prev.peek()==i-1){
                    sb.append(elements[i]);
                    prev.pop();
                    count++;
                    num[i]++;
                    backTrackingPriority(ret,prev,num,target,count,total,sb);
                    prev.push(i-1);
                    num[i]--;
                    count--;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new generateParenthesis().generatePriority(1, 2));
    }
}
