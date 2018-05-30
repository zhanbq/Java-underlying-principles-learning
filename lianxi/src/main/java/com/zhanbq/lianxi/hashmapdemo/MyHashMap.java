package com.zhanbq.lianxi.hashmapdemo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

  Node<K, V>[] array = null;

  private static int defaultLength = 1 << 4;

  // 集合中的元素个数
  private int size;

  // 测试打印
  public void print() {
    System.out.println("==============");
    if (array != null) {
      Node<K, V> node = null;
      for (int i = 0; i < array.length; i++) {
        node = array[i];
        System.out.print("下标[" + i + "]");
//        while (node != null) {
//          System.out.print("[" + node.getKey() + ":" + node.getValue() + "]");
//          if (node.next != null) {
//            node = node.next;
//          } else {
//            node = null;
//          }
//        }
//        System.out.println();
//      }
      
        while(node != null){
          System.out.print("[" + node.getKey() + ":" + node.getValue() + "]");
          if(node.next != null){
            node = node.next;
          }else{
            node = null;
          }
        }
        System.out.println();
      }
    }
  }


  @Override
  public V put(K key, V value) {

    // 1 懒加载机制,使用的时候分配内存.
    if (array == null) {
      array = new Node[defaultLength];
    }

    // 2 通过hash算法,计算出具体插入的位置
    int index = position(key);

    // 3 放入要插入的元素
    Node<K, V> node = array[index];
    if (node == null) {
      array[index] = new Node<K, V>(key, value, null);
      size++;
    } else {
      if (key.equals(node.getKey()) || key == node.getKey()) { // 存在相同的key,即为更新
        node.setValue(value);
      } else {
        array[index] = new Node<K, V>(key, value, node);
        size++;
      }
    }

    return null;
  }

  private int position(K key) {
    int code = key.hashCode();

    // 取模算法
    int index = code % (defaultLength - 1);

    // 求与算法
    // int index = code&(defaultLength-1);
    return index;
  }

  @Override
  public V get(Object key) {
    if (array != null) {
      int index = position((K) key);
      Node<K, V> node = null;
      node = array[index];
      //遍历链表
      while (node != null) {
        //如果key值相同,则返回value
        if (node.getKey() == key) {
          return node.getValue();
        } else {
          //如果key值不同,则调到下一个元素
          node = node.next;
        }
      }
    }
    return null;
  }

  @Override
  public int size() {
    return this.size;
  }

  static class Node<K, V> implements Entry<K, V> {

    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value, Node<K, V> next) {
      super();
      this.key = key;
      this.value = value;
      this.next = next;
    }

    @Override
    public K getKey() {
      return this.key;
    }

    @Override
    public V getValue() {
      return this.value;
    }

    @Override
    public V setValue(V newV) {
      V oldValue = this.value;
      this.value = newV;
      return oldValue;
    }

  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean containsKey(Object key) {
    return false;
  }

  @Override
  public boolean containsValue(Object value) {
    return false;
  }

  @Override
  public V remove(Object key) {
    return null;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    // TODO Auto-generated method stub

  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }

  @Override
  public Set<K> keySet() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<V> values() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<java.util.Map.Entry<K, V>> entrySet() {
    // TODO Auto-generated method stub
    return null;
  }

}
