package com.src;
public class TreeAVL<T extends Comparable<T>> implements TreeInterface<T> {
    private NodeAVL<T> root;

    // Create Operation
    @Override
    public void insert(T data) {
        root = insertHelper(root, data);
    }

    private NodeAVL<T> insertHelper(NodeAVL<T> node, T data) {
        // Create a new node if the current node is null
        if (node == null) {
            return new NodeAVL<>(data);
        }

        // Compare based on data
        if (data.compareTo(node.data) < 0) {
            node.left = insertHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertHelper(node.right, data);
        } else {
            // Do not insert duplicate nodes, return
            return node;
        }

        updateHeight(node); // Update node height
        // Perform rotation operation to restore balance to the subtree
        node = rotate(node);
        // Return the root node of the subtree
        return node;
    }

    // Remove Operation
    @Override
    public void remove(T data) {
        root = removeHelper(root, data);
    }

    // Recursively remove node (helper method)
    private NodeAVL<T> removeHelper(NodeAVL<T> node, T data) {
        if (node == null) {
            return null;
        }

        // Find and remove the node
        if (data.compareTo(node.data) < 0) {
            node.left = removeHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = removeHelper(node.right, data);
        } else {
            // Node to be deleted is found
            // Case 1: Node with only one child or no child
            if (node.left == null || node.right == null) {
                NodeAVL<T> child = node.left != null ? node.left : node.right;
                // Number of child nodes = 0, remove node and return
                if (child == null) {
                    return null;
                }
                // Number of child nodes = 1, remove node
                else {
                    node = child;
                }
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.right != null) {
                    root.data = successor(root);
                    root.right = removeHelper(root.right, root.data);
                } else {
                    // find a predecessor to replace this node
                    root.data = predecessor(root);
                    root.left = removeHelper(root.left, root.data);
                }
            }
        }
        updateHeight(node); // Update node height
        // Perform rotation operation to restore balance to the subtree
        node = rotate(node);
        // Return the root node of the subtree
        return node;
    }

    private T successor(NodeAVL<T> node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    private T predecessor(NodeAVL<T> node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public boolean search(T key) {
        NodeAVL<T> result = searchHelper(root, key);
        return result != null;
    }

    private NodeAVL<T> searchHelper(NodeAVL<T> root, T key) {
        if (root == null || root.data.equals(key)) {
            return root;
        }

        if (key.compareTo(root.data) < 0) {
            return searchHelper(root.left, key);
        }
        return searchHelper(root.right, key);
    }

    @Override
    public boolean update(T data) {
        return false;
    }

    // Read process
    @Override
    public void read() {
        readHelper(root);
    }

    private void readHelper(NodeAVL<T> root) {
        if (root != null) {
            readHelper(root.left);
            System.out.println(root.data);
            readHelper(root.right);
        }
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
        // Rotate node to the right around child
        child.right = node;
        node.left = grandChild;
        // Update node height
        updateHeight(node);
        updateHeight(child);
        // Return the root of the subtree after rotation
        return child;
    }

    public NodeAVL<T> leftRotate(NodeAVL<T> node) {
        NodeAVL<T> child = node.right;
        NodeAVL<T> grandChild = child.left;
        // Rotate node to the left around child
        child.left = node;
        node.right = grandChild;
        // Update node height
        updateHeight(node);
        updateHeight(child);
        // Return the root of the subtree after rotation
        return child;
    }

    public NodeAVL<T> rotate(NodeAVL<T> node) {
        int balanceFactor = balanceFactor(node);
        // Left-leaning tree
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                // Right rotation
                return rightRotate(node);
            } else {
                // First left rotation then right rotation
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // Right-leaning tree
        if (balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                // Left rotation
                return leftRotate(node);
            } else {
                // First right rotation then left rotation
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        // Balanced tree, no rotation needed, return
        return node;
    }

    private static class NodeAVL<T> {
        private T data;
        private NodeAVL<T> left;
        private NodeAVL<T> right;
        private int height;

        public NodeAVL(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }
}
