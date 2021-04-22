public class BinarySearchTree {

    private TreeNode root;

    private class TreeNode {
        private int data; // Generic type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode search(int pointer) {
        return search(root, pointer);
    }

    public TreeNode search(TreeNode root, int pointer) {
        if (root == null || root.data == pointer) { // base case
            return root;
        }

        if (pointer < root.data) {
            return search(root.left, pointer);
        } else {
            return search(root.right, pointer);
        }

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(6);
        bst.insert(7);
        bst.insert(1);

        bst.inOrder();

        System.out.println();

        if (null != bst.search(10)) {
            System.out.println("pointer found !!!");
        } else {
            System.out.println("pointer not found !!!");
        }
    }
}