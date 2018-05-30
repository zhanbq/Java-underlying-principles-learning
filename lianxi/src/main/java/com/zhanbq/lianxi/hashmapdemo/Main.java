package com.zhanbq.lianxi.hashmapdemo;

import java.util.HashMap;

public class Main {
  
  public static void main(String[] args) {
    MyHashMap<Object,Object> hashMap = new MyHashMap<>();
    
    hashMap.put("A", "a");
    hashMap.put("B", "b");
    hashMap.put("C", "c");
    hashMap.put("D", "d");
    hashMap.put("E", "e");
    hashMap.put("F", "f");
    hashMap.put("G", "g");
    hashMap.put("H", "h");
    hashMap.put("I", "i");
    hashMap.put("J", "j");
    hashMap.put("K", "k");
    hashMap.put("L", "l");
    hashMap.put("M", "m");
    hashMap.put("N", "n");
    hashMap.put("O", "o");
    hashMap.put("P", "p");
    hashMap.put("Q", "q");
    hashMap.put("R", "r");
    hashMap.put("S", "s");
    hashMap.put("T", "t");
    hashMap.put("U", "u");
    hashMap.print();
    
    HashMap<String,String> hashMap2 = new java.util.HashMap<>();
    hashMap2.put("A", "a");
    String A = hashMap2.get("A");
    
  }
}
