package com.src;

public class NodeAVL<T> {
    T data;
    NodeAVL<T> left;
    NodeAVL<T> right;
    int height;

    public NodeAVL(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

