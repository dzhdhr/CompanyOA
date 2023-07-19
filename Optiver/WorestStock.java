package Optiver;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class WorestStock {
    class Node{
        int price;
        String name;
        int id;
        int share;
        int tradeType;
        public Node(int price,String name,int id,int share,int tradeType){
            this.id = id;
            this.name = name;
            this.price = price;
            this.share = share;
            this.tradeType = tradeType;

        }
        public int totalCost(){
            return this.price*this.share;
        }
    }
    HashMap<String,PriorityQueue<Node>>sellPQ;

    HashMap<String,PriorityQueue<Node>> buyPQ;
    HashMap<String,Integer>price;
    public WorestStock(){
        this.buyPQ = new HashMap<>();
        this.sellPQ = new HashMap<>();
        this.price = new HashMap<>();
    }
    public void update(int price,String name,int id,int share,int tradeType){
        Node n = new Node(price,name,id,share,tradeType);
        if (n.tradeType==1){
            sellPQ.putIfAbsent(name,new PriorityQueue<>(Comparator.comparingInt(Node::totalCost)));
            sellPQ.get(name).add(n);
        }
        else {
            buyPQ.putIfAbsent(name,new PriorityQueue<>((x,y)->Integer.compare(y.totalCost(),x.totalCost())));
            buyPQ.get(name).add(n);
        }

    }
    public void update(int price, String name){
        this.price.put(name,price);
    }
    public int query(String name){
        if (!buyPQ.containsKey(name)&&!sellPQ.containsKey(name)){
            return -1;
        }
        if(!buyPQ.containsKey(name)){
            Node front = sellPQ.get(name).peek();
            //sell price
            if (front.price>price.get(name)){
                return front.id;
            }
            return -1;
        }
        if(!sellPQ.containsKey(name)){
            Node front = buyPQ.get(name).peek();
            if (front.price<price.get(name)){
                return front.id;
            }
            return -1;
        }
        Node buy = buyPQ.get(name).peek();
        Node sell = sellPQ.get(name).peek();
        if(buy.price<price.get(name)&&sell.price>price.get(name)){
            return -1;
        }
        if(buy.price<price.get(name)){
            return sell.id;
        }
        if(sell.price<price.get(name)){
            return buy.id;
        }
        int sellProfit = sell.totalCost()-sell.share*price.get(name);
        int buyProfit = buy.totalCost()-buy.share*price.get(name);
        if(buyProfit<sellProfit){
            return buy.id;
        }
        return sell.id;


    }
}
