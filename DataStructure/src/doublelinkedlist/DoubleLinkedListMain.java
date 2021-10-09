package doublelinkedlist;

public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);

        MyLinkedList.printAll();

        System.out.println("=====");
        System.out.println(MyLinkedList.searchFromHead(3));;
        System.out.println(MyLinkedList.searchFromTail(1));;
        System.out.println(MyLinkedList.searchFromTail(6));;

        System.out.println("----------------");

        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();

    }
}
