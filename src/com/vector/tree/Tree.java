package com.vector.tree;

/**
 * Created by 12345 on 2018-6-14.
 */
public class Tree {

    private Node root;

    public void insert(int iData, double dData){
        Node nowNode = new Node();
        nowNode.iData = iData;
        nowNode.dData = dData;

        if(root == null){
            root = nowNode;
        }else{
            Node current = root;
            Node parent;

            while(true){
                parent = current;
                if(iData < current.iData){
                    current = current.leftNode;
                    if(current == null){
                        parent.leftNode = nowNode;
                        return;
                    }
                }else{
                    current = current.rightNode;
                    if(current == null){
                        parent.rightNode = nowNode;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key){
        Node current = root;
        while (current.iData != key){
            if(current.iData > key){
                current = current.leftNode;
            }
            if(current.iData < key){
                current = current.rightNode;
            }

            if(current == null){
                return null;
            }
        }

        return current;
    }

    public Node[] mVal(){
        Node minNode = null;
        Node maxNode = null;

        Node[] maxminVal = new Node[2];
        Node current = root;

        while(current != null){
            minNode = current;
            current = current.leftNode;
        }
        maxminVal[0] = minNode;

        current = root;
        while(current != null){
            maxNode = current;
            current = current.rightNode;
        }
        maxminVal[1] = maxNode;

        return maxminVal;
    }
}
