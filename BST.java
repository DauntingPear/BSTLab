
public class BST implements BSTInterface<Node> {
    private Node rootNode = null;
    private int size = 0;

    public int getRoot() {
        if (rootNode != null) {
            return rootNode.getData();
        } else {
            return -1;
        }
    }

    public void insert(Node n) {
        if (rootNode == null) {
            rootNode = n;
        } 
        else {
            Node currNode = rootNode;
            while (currNode != null) {
                if (n.getData() < currNode.getData()) {
                    if (currNode.getLeftChild() == null) {
                        currNode.setLeftChild(n);
                        currNode = null;
                    }
                    else {
                        currNode = currNode.getLeftChild();
                    }
                }
                else {
                    if (currNode.getRightChild() == null) {
                        currNode.setRightChild(n);
                        currNode = null;
                    }
                    else {
                        currNode = currNode.getRightChild();
                    }
                }
            }
        }
        size++;
    }

    public void printBSTInOrder(Node n) {
        return;
    }

    public void remove(Node n) {
        Node parNode = null;
        Node currNode = rootNode;

        while (currNode != null) {
            if (currNode.getData() == n.getData()) {
                // Remove leaf node
                if (currNode.getLeftChild() == null && currNode.getRightChild() == null) {
                    if (parNode == null) { // Node is root
                        this.rootNode = null;
                    }
                    else if (parNode.getLeftChild() == currNode) {
                        parNode.setLeftChild(null);
                    }
                    else {
                        parNode.setRightChild(null);
                    }
                }
                // Remove node with only left child
                else if (currNode.getRightChild() == null) {
                    if (parNode == null) { // Node is root
                        this.rootNode = currNode.getLeftChild();
                    }
                    else if (parNode.getLeftChild() == currNode) {
                        parNode.setLeftChild(currNode.getLeftChild());
                    }
                    else {
                        parNode.setRightChild(currNode.getLeftChild());
                    }
                }
                // Remove node with only right child
                else if (currNode.getLeftChild() == null) {
                    if (parNode == null) { // Node is root
                        rootNode = currNode.getRightChild();
                    }
                    else if (parNode.getLeftChild() == currNode) {
                        parNode.setLeftChild(currNode.getRightChild());
                    }
                    else {
                        parNode.setRightChild(currNode.getLeftChild());
                    }
                }
                // Remove node with two children
                else {
                    // Find successor (leftmost child of subtree)
                    Node sucNode = currNode.getRightChild();
                    while (sucNode.getLeftChild() != null) {
                        sucNode = sucNode.getLeftChild();
                    }
                    int sucData = sucNode.getData();
                    remove(sucNode); // Remove successor
                    currNode.setData(sucData);
                }
                size--;
                return; // Node found and removed
            }
            else if (currNode.getData() < n.getData()) { // Search right
                parNode = currNode;
                currNode = currNode.getRightChild();
            }
            else { // Search left
                parNode = currNode;
                currNode = currNode.getLeftChild();
            }
        }
        return; // Node not found
    }

    public void find(Node n) {
        Node currNode = rootNode;
        while (currNode != null) {
            if (n.getData() == currNode.getData()) {
                return; //Currnode is found
            }
            else if (n.getData() < currNode.getData()) {
                currNode = currNode.getLeftChild();
            }
            else {
                currNode = currNode.getRightChild();
            }
        }
        return; // nothing found
    }
}
