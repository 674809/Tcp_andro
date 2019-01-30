package com.example.lib.data;


public class LinkedList<E> {

    Node<E> first;
    Node<E> last;
    public int size;

    public LinkedList(){

    }

    public void add(E e){
        linkLast(e);
    }

    public void add(int index ,E e){
        if (index < 0 || index > size){
            return;
        }
        if (index == size){
            linkLast(e);
        }else {
            Node<E> target = node(index);
            Node<E> pre = target.prev;
            Node<E> newNode = new Node<E>(pre ,e ,target);

            if (pre == null){
                first = newNode;
            }else {
                pre.next = newNode;
            }
            pre = newNode;
            size ++;
        }
    }

    private Node<E> node(int index){
        //index处于前半部分
        if (index < (size -1)){
            Node<E> node = first;
            for (int i = 0 ; i < index ; i ++){
                node = node.next;
            }
            return node;
        }else {
            //处于后半部分
            Node<E> node = last;
            for (int i = size -1; i > size ; i --){
                node = node.prev;
            }
            return node;
        }
    }

    public E get(int index){
        if (index <0 || index >size){
            return null;
        }
        return node(index).item;
    }

    private void linkLast(E e) {
        Node<E> newNode = new Node<E>(last ,e ,null);
        Node<E> l = last;
        last = newNode;

        if (l == null){
            first = newNode;
        } else {
            l.next = newNode;
        }
        size ++;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> var1, E var2, Node<E> var3) {
            this.item = var2;
            this.next = var3;
            this.prev = var1;
        }
    }


}
