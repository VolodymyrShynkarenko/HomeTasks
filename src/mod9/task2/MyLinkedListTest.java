package mod9.task2;

import mod9.task1.MyArrayList;

class MyLinkedListTest {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Назар");
        list.add("ni");
        list.add("niof");

        System.out.println(list);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(0) = " + list.get(0));
        list.remove(1);
        System.out.println("list after remove = " + list.size());
        list.clear();
        System.out.println("list clear " + list.size());;

    }
}