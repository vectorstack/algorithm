package com.vector.set;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by 12345 on 2018-6-14.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet set1 = new TreeSet();
        set1.add(new Person(13,"nick"));
        set1.add(new Person(12,"vector"));

        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        TreeSet set2 = new TreeSet(new MyComparator());
        set2.add(new Book("java编程思想",3.05f));
        set2.add(new Book("核心技术",3.06f));
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }


    }

    static class MyComparator implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;
            if(b1.getPrice() > b2.getPrice()){
                return 1;
            }

            if(b1.getPrice() < b2.getPrice()){
                return -1;
            }
            return b1.getName().compareTo(b2.getName());
        }
    }
}
