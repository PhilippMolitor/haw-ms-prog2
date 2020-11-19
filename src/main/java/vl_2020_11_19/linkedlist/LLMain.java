package vl_2020_11_19.linkedlist;

public class LLMain {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("---");

        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("---");
    }
}
