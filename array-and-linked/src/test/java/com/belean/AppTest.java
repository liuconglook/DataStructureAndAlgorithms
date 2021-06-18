package com.belean;

import com.belean.array.ArrayList;
import com.belean.linked.LinkedList;
import com.belean.linked.LinkedList2;
import com.belean.linked.LinkedList3;

import org.junit.Test;

/**
 * AppTest
 */
public class AppTest {

    @Test
    public void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>(5);
        // 触发一次扩容
        list.add(1).add(2).add(3).add(4).add(5).add(6);
        System.out.println(list);
        list.remove(1); // 删除索引1位置的元素2
        System.out.println(list);
        list.remove(new Integer(3));// 删除元素3
        System.out.println(list);
        list.insert(0, 0);
        list.insert(2, 2);
        // list.insert(6, 7); -- 下标越界
        System.out.println(list);
    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1).add(2).add(3).add(4).add(5);
        System.out.println(list);
        list.remove(1); // 删除索引1位置的元素2
        //list.remove(new Integer(3)); // 删除元素3
        /* System.out.println(list);
        list.remove(1);
        list.remove(1);
        list.remove(new Integer(5));
        list.remove(0);
        System.out.println(list); */
        list.addFirst(0);
        list.insert(0, -1);
        list.insert(0, -3);
        list.insert(1, -2);
        System.out.println(list);
    }

    @Test
    public void testLinkedList2() {
        LinkedList2<Integer> list = new LinkedList2<>();
        list.add(1).add(2).add(3).add(4).add(5);
        System.out.println(list);
        // list.remove(1); // 删除索引1位置的元素2
        // System.out.println(list);
        // list.remove(new Integer(3)); // 删除元素3
        // System.out.println(list);
        // list.remove(0);
        // list.remove(new Integer(5));
        // System.out.println(list);
        // list.remove(0);
        list.addFirst(0);
        list.insert(0, -1);
        list.insert(0, -3);
        list.insert(1, -2);
        list.insert(8, 6);
        // list.insert(10, 7); -- 索引越界
        System.out.println(list);
    }

    @Test
    public void testLinkedList3() {
        LinkedList3<Integer> list = new LinkedList3<>();
        list.add(1).add(2).add(3).add(4).add(5);
        System.out.println(list);
        // list.remove(1); // 删除索引1位置的元素2
        // System.out.println(list);
        // list.remove(new Integer(3)); // 删除元素3
        // System.out.println(list);
        // list.remove(0);
        // System.out.println(list);
        // list.remove(0);
        // list.remove(new Integer(5));
        list.addFirst(0);
        list.insert(0, -2);
        list.insert(1, -1);
        // list.insert(8, 6); -- 下标越界
        System.out.println(list);
        System.out.println(list.reversePrint());
    }
}
