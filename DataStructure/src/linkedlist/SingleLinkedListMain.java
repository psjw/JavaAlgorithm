package linkedlist;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
        MyLinkedList.addNode(1);
        System.out.println(MyLinkedList.head.next);
        MyLinkedList.addNode(2);
        System.out.println(MyLinkedList.head.next.data);
        MyLinkedList.addNode(3);
        System.out.println("----");
        MyLinkedList.printALl();
        System.out.println("----");
        MyLinkedList.addNodeInside(5, 1);
        MyLinkedList.printALl();

        //없는 데이터 삽입
        MyLinkedList.addNodeInside(7,20);
        System.out.println("----");
        MyLinkedList.printALl();
        System.out.println("----");
        System.out.println(MyLinkedList.delNode(3));
        System.out.println("----");
        MyLinkedList.printALl();
        System.out.println("----");
        System.out.println(MyLinkedList.delNode(1));
        MyLinkedList.printALl();
        System.out.println("----");
        System.out.println(MyLinkedList.delNode(7));
        MyLinkedList.printALl();
        System.out.println("----");
        System.out.println(MyLinkedList.delNode(20));
        MyLinkedList.printALl();
    }
}

