package Optiver;

import java.util.LinkedList;
import java.util.List;

public class LogServer {
    class Node{
        String name;
        int timeStamp;
        public Node(String name,int timeStamp){
            this.name = name;
            this.timeStamp = timeStamp;
        }
    }
    List<Node> logs;
    int m;
    int totalLog;
    public LogServer(int m){
        logs = new LinkedList<>();
        this.m = m;
        this.totalLog = 0;
    }
    public void recoidLog(String id, int timeStamp){
        Node n = new Node(id,timeStamp);
        logs.add(n);
        int prevTime = timeStamp-3600;
        totalLog++;
        int prevIndex = bs(this.logs,prevTime);
        for(int i = 0;i<=prevIndex;i++){
            totalLog--;

            Node temp = logs.remove(0);

        }
    }
    public void getLog(){
        for(int i = 0;i<Math.min(m,logs.size());i++){
            System.out.print(this.logs.get(i).name);
            System.out.print("->");
        }
        System.out.println();
    }
    private int bs(List<Node>l,int prevTime){
        int left = 0;
        int right = l.size()-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(l.get(mid).timeStamp<=prevTime){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        if(l.get(right).timeStamp<=prevTime)return right;
        if(l.get(left).timeStamp<=prevTime)return left;
        return -1;
    }
    public int getLogCount(){
        return totalLog;
    }

    public static void main(String[] args) {
        LogServer l = new LogServer(100);
        l.recoidLog("1",0);
        l.recoidLog("2",300);
        l.getLog();
        l.recoidLog("3",1200);
        l.recoidLog("1",1800);
        l.getLog();
        System.out.println(l.getLogCount());
        l.recoidLog("4",3900);
        l.getLog();
//        l.recoidLog("1",0);
    }
}
