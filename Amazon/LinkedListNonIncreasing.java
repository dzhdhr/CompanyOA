package Amazon;

public class LinkedListNonIncreasing {
    static class Node{
        int val;
        Node next;
    }
    public static Node nonIncreasing(Node  head){
        if(head==null)return null;
        Node ret =head;
        Node fast = head;
        Node slow = head;
        int maxSize = 0;
        int curlength = 1;
        while(fast.next!=null){
            //add fast
            int prev = fast.val;
            curlength +=1;
            fast = fast.next;
            //remove slow
            if(prev<fast.val){
                slow = fast;
                curlength = 1;
            }
            //get results
            if(curlength>maxSize){
                ret = slow;
                maxSize = curlength;
            }

        }
        Node r = new Node();
        Node c = r;
        for(int i = 0;i<maxSize;i++){
            c.next = new Node();
            c.next.val = ret.val;
            System.out.println(ret.val);
            ret = ret.next;
            c = c.next;
        }
        return r.next;
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node cur = head;
        cur.next = new Node();
        cur = cur.next;
        cur.val = 1;
        cur.next = new Node();
        cur = cur.next;
        cur.val = 2;
        cur.next = new Node();
        cur = cur.next;
        cur.val = 3;
        cur.next = new Node();
        cur = cur.next;
        cur.val = 4;
        cur.next = new Node();
        cur = cur.next;
        cur.val = 5; cur.next = new Node();
        cur = cur.next;
        cur.val = 6; cur.next = new Node();
        cur = cur.next;
        cur.val = 7;
        Node r = nonIncreasing(head.next);
        while (r!=null){
            System.out.println(r.val);
            r = r.next;
        }



    }
}
