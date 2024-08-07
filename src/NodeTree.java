public class NodeTree {
    int data;
    NodeTree left;
    NodeTree right;
    public NodeTree(int data){
        this.data = data;
    }
}

TreeNode root;

public class TreeNode {
    //Data Section
    public int doneeID;



    public int value;
    public int height;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { value = x; }
}}

// Height process and record
//    public int height(TreeNode node) {
//        // Empty node height is -1, leaf node height is 0
//        return node == null ? -1 : node.height;
//    }
//
//    public void updateHeight(TreeNode node) {
//        // Node height equals the height of the tallest subtree + 1
//        node.height = Math.max(height(node.left), height(node.right)) + 1;
//    }
//
//    // Balance process
//    int balanceFactor(TreeNode node) {
//        if (node == null) { return 0; }
//        return height(node.left) - height(node.right);
//    }
//
//    // Rotation process
//    public TreeNode rightRotate(TreeNode node) {
//        TreeNode child = node.left;
//        TreeNode grandChild = child.right;
//        // Rotate node to the right around child
//        child.right = node;
//        node.left = grandChild;
//        // Update node height
//        updateHeight(node);
//        updateHeight(child);
//        // Return the root of the subtree after rotation
//        return child;
//    }
//
//    public TreeNode leftRotate(TreeNode node) {
//        TreeNode child = node.right;
//        TreeNode grandChild = child.left;
//        // Rotate node to the left around child
//        child.left = node;
//        node.right = grandChild;
//        // Update node height
//        updateHeight(node);
//        updateHeight(child);
//        // Return the root of the subtree after rotation
//        return child;
//    }
//
//    public TreeNode rotate(TreeNode node) {
//        // Get the balance factor of node
//        int balanceFactor = balanceFactor(node);
//        // Left-leaning tree
//        if (balanceFactor > 1) {
//            if (balanceFactor(node.left) >= 0) {
//                // Right rotation
//                return rightRotate(node);
//            } else {
//                // First left rotation then right rotation
//                node.left = leftRotate(node.left);
//                return rightRotate(node);
//            }
//        }
//        // Right-leaning tree
//        if (balanceFactor < -1) {
//            if (balanceFactor(node.right) <= 0) {
//                // Left rotation
//                return leftRotate(node);
//            } else {
//                // First right rotation then left rotation
//                node.right = rightRotate(node.right);
//                return leftRotate(node);
//            }
//        }
//        // Balanced tree, no rotation needed, return
//        return node;
//    }
//
//    // Insert
//    @Override
//    public void insert(int value) {
//        root = insertHelper(root, value);
//    }
//
//    // Recursively insert node (helper method)
//    TreeNode insertHelper(TreeNode node, int value) {
//        if (node == null)
//            return new TreeNode(value);
//        // Find insertion position and insert node
//        if (value < node.value)
//            node.left = insertHelper(node.left, value);
//        else if (value > node.value)
//            node.right = insertHelper(node.right, value);
//        else
//            return node; // Do not insert duplicate nodes, return
//        updateHeight(node); // Update node height
//        // Perform rotation operation to restore balance to the subtree
//        node = rotate(node);
//        // Return the root node of the subtree
//        return node;
//    }
//
//    // Node remove
//    @Override
//    public void remove(int value) {
//        root = removeHelper(root, value);
//    }
//
//    // Recursively remove node (helper method)
//    TreeNode removeHelper(TreeNode node, int value) {
//        if (node == null)
//            return null;
//        // Find and remove the node
//        if (value < node.value)
//            node.left = removeHelper(node.left, value);
//        else if (value > node.value)
//            node.right = removeHelper(node.right, value);
//        else {
//            if (node.left == null || node.right == null) {
//                TreeNode child = node.left != null ? node.left : node.right;
//                // Number of child nodes = 0, remove node and return
//                if (child == null)
//                    return null;
//                    // Number of child nodes = 1, remove node
//                else
//                    node = child;
//            } else {
//                // Number of child nodes = 2, remove the next node in in-order traversal and replace the current node with it
//                TreeNode temp = node.right;
//                while (temp.left != null) {
//                    temp = temp.left;
//                }
//                node.right = removeHelper(node.right, temp.value);
//                node.value = temp.value;
//            }
//        }
//        updateHeight(node); // Update node height
//        // Perform rotation operation to restore balance to the subtree
//        node = rotate(node);
//        // Return the root node of the subtree
//        return node;
//    }
//
//    // Display
//    @Override
//    public void display() {
//        displayHelper(root);
//    }
//
//    private void displayHelper(TreeNode root) {
//        if (root != null) {
//            displayHelper(root.left);
//            System.out.println(root.value);
//            displayHelper(root.right);
//        }
//    }
//
//    //Clear
//    @Override
//    public void clear(){
//
//    }
//
//
//    public void replace();
//    public int contains(int E);
//    public boolean isEmpty();
//}