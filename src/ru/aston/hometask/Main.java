package ru.aston.hometask;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== MyHashSet Demo ===");
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add("apple");
        myHashSet.add("banana");
        myHashSet.add("orange");
        System.out.println("HashSet after additions: " + myHashSet);
        System.out.println("Size: " + myHashSet.size());

        myHashSet.remove("banana");
        System.out.println("HashSet after removing 'banana': " + myHashSet);
        System.out.println("Size: " + myHashSet.size());

        System.out.println("=== MyArrayList Demo ===");
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("apple");
        myArrayList.add("banana");
        myArrayList.add("orange");
        System.out.println("ArrayList after additions: " + myArrayList);
        System.out.println("Size: " + myArrayList.size());

        myArrayList.remove("apple");
        System.out.println("ArrayList after removing: " + myArrayList);
        System.out.println("Size: " + myArrayList.size());

        System.out.println("First element:" + myArrayList.get(0));

        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        myArrayList1.add("cherry");
        myArrayList1.add("lime");
        myArrayList.addAll(myArrayList1);
        System.out.println("Elements myArrayList after addAll:" + myArrayList);
        System.out.println("Size: " + myArrayList.size());
    }
}
