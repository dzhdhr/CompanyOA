package googlevo;

public class Level {
    static class Node{
        Node left;
        Node right;
        int netForce;
        public Node (Node left, Node right, int leftDistance, int rightDistance){
            this.left = left;
            this.right = right;
            this.netForce = leftDistance*left.netForce-rightDistance*right.netForce;
        }
        public Node(int netForce){
            this.netForce = netForce;
        }
    }
    public static void main(String[] args) {
       Node left1 = new Node(new Node(1),new Node(1),1,1);
       Node right1 = new Node(new Node(2),new Node(4),4,2);
       Node left =new Node(left1,right1,3,1);
       Node right = new Node(new Node(1),new Node(3),6,2);
       Node root = new Node(left,right,2,4);
        System.out.println(root.netForce);
    }
}
