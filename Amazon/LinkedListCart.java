package Amazon;

public class LinkedListCart {
    class Node{
        Node next;
        String val;
        public Node(String val,Node next){
            this.next = next;
            this.val = val;
        }

    }
    Node dummyHead;
    Node tail;
    private void pushHead(String val){
        Node n = new Node(val,null);
        n.next = this.dummyHead.next;
        this.dummyHead.next = n;
        if (tail==null) tail = n;
    }
    public void printNode(){
        Node start = dummyHead;
        while (start!=null){
            System.out.print(start.val);
            System.out.print("->");
            start = start.next;
        }
    }
    private Node popHead(){
        Node ret = dummyHead.next;
        dummyHead.next = dummyHead.next.next;
        if (dummyHead.next==null)tail=null;
        return ret;
    }
    private void pushTail(String val){
        Node n = new Node(val,null);
        if (tail==null){
            tail = n;
            dummyHead.next = n;
            System.out.println("here");
        }else {
            tail.next = n;
            tail = n;
        }
    }
    public Node ShoppingCart(String[] s,String []instructionList){
        dummyHead = new Node("-1",null);
        for (int i = 0; i < instructionList.length; i++) {
            if (instructionList[i].equals("push_head")){
                pushHead(s[i]);
            }
            else if (instructionList[i].equals("push_tail")){
                pushTail(s[i]);
            } else if (instructionList[i].equals("pop_head")) {
                popHead();
            }
            printNode();
            System.out.println();
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        String[] instructionList = new String[]{"push_tail","push_tail","push_tail","push_tail","pop_head","pop_head","pop_head","pop_head","push_head","push_tail","pop_head","push_tail","push_head"};
        String[] val = new String[]{"1","2","3","4","","","","","10","5","","6","100"};
        LinkedListCart l = new LinkedListCart();
        l.ShoppingCart(val,instructionList);
        l.printNode();
    }
}
