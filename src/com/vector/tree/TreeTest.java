package com.vector.tree;

/**
 * Created by 12345 on 2018-6-14.
 */
public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1,10f);
        tree.insert(2,10f);
        tree.insert(3,10f);
        tree.insert(4,10f);
        tree.insert(5,10f);

        Node node=tree.find(2);
        if(node==null)
        {
            System.out.println("we can not find it");
        }else
        {
            node.showNode();
        }

        //查找tree中的最值
        Node[] temp=tree.mVal();
        temp[0].showNode();
        temp[1].showNode();
    }



}
