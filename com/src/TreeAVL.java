package com.src;

public class TreeAVL<T extends Comparable<T>> implements TreeInterface<T> {
    private NodeAVL<T> root;

    // Constructor
    public TreeAVL() {this.root = null;}

    // Getter
    public NodeAVL<T> getRoot() {return root;}

    // Create Operation
    @Override
    public void insert(T data) {root = insertHelper(root, data);}

    private NodeAVL<T> insertHelper(NodeAVL<T> node, T data) {
        if (node == null) {return new NodeAVL<>(data);}

        if (data.compareTo(node.data) < 0) {node.left = insertHelper(node.left, data);}
        else if (data.compareTo(node.data) > 0) {node.right = insertHelper(node.right, data);}
        else {return node;}

        updateHeight(node);
        return rotate(node);
    }

    // Remove Operation
    @Override
    public boolean remove(T data) {
        int initialSize = size();  // Save the initial size
        root = removeHelper(root, data);
        return size() < initialSize; }

    private NodeAVL<T> removeHelper(NodeAVL<T> node, T data) {
        if (node == null) {return null;}

        if (data.compareTo(node.data) < 0) {node.left = removeHelper(node.left, data);}
        else if (data.compareTo(node.data) > 0) {node.right = removeHelper(node.right, data);}
        else {
            if (node.left == null || node.right == null) {return node.left != null ? node.left : node.right;}
            else
            {
                T successorData = successor(node.right);
                node.data = successorData;
                node.right = removeHelper(node.right, successorData);
            }
        }

        updateHeight(node);
        return rotate(node);
    }

    private T successor(NodeAVL<T> node)
    {
        node = node.right;
        while (node.left != null) {node = node.left;}
        return node.data;
    }

    // Search Operation
    public T search(T data)
    {
        NodeAVL<T> result = searchHelper(root, data);
        return result != null ? result.data : null;
    }

    private NodeAVL<T> searchHelper(NodeAVL<T> root, T data) {
        if (root == null || root.data.equals(data)) {return root;}

        if (data.compareTo(root.data) < 0) {
            return searchHelper(root.left, data);
        }
        return searchHelper(root.right, data);
    }

    @Override
    public boolean update(T data) {
        NodeAVL<T> node = searchHelper(root, data);
        if (node != null) {
            node.data = data;
            return true;
        }
        return false;
    }

    // Read Process
    @Override
    public void read() {readHelper(root);}

    private void readHelper(NodeAVL<T> root) {
        if (root != null) {
            readHelper(root.left);
            System.out.println(root.data);
            readHelper(root.right);
        }
    }

    @Override
    public boolean contains(T data) {return search(data) != null;}

    @Override
    public boolean isEmpty() {return root == null;}

    @Override
    public int size() {return sizeHelper(root);}

    private int sizeHelper(NodeAVL<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeHelper(node.left) + sizeHelper(node.right);
        }
    }

    // Height Process
    public int height(NodeAVL<T> node) {
        return node == null ? -1 : node.height;
    }

    public void updateHeight(NodeAVL<T> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public int balanceFactor(NodeAVL<T> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Rotation Process
    public NodeAVL<T> rightRotate(NodeAVL<T> node) {
        NodeAVL<T> child = node.left;
        NodeAVL<T> grandChild = child.right;
        child.right = node;
        node.left = grandChild;

        updateHeight(node);
        updateHeight(child);
        return child;
    }

    public NodeAVL<T> leftRotate(NodeAVL<T> node) {
        NodeAVL<T> child = node.right;
        NodeAVL<T> grandChild = child.left;
        child.left = node;
        node.right = grandChild;

        updateHeight(node);
        updateHeight(child);
        return child;
    }

    public NodeAVL<T> rotate(NodeAVL<T> node) {
        int balanceFactor = balanceFactor(node);

        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }
}
