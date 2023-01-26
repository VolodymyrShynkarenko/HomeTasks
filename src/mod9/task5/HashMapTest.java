package mod9.task5;

public class HashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("Nazar", 1000);
        myHashMap.put( "Daha", 200);
        System.out.println(myHashMap.get("Nazar"));
        System.out.println(myHashMap.get("Andrei"));

        myHashMap.remove("Nazar");
        System.out.println(myHashMap.size());
        myHashMap.clear();
        System.out.println(myHashMap.isEmpty());
        System.out.println(myHashMap.size());
  }
}
