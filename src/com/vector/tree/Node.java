package com.vector.tree;

/**
 * Created by 12345 on 2018-6-14.
 */
public class Node {
    public int iData;
    public double dData;

    public Node leftNode;
    public Node rightNode;

    public void showNode()
    {
        System.out.println("{ "+iData+","+dData+" }");
    }
}
