
public class BST implements BSTInterface<Node> {
    private Node rootNode = null;

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
    }

    public void printBSTInOrder(Node n) {
        if (n == null) {
            return;
        }

        printBSTInOrder(n.getLeftChild());
        System.out.println(n.getData());
        printBSTInOrder(n.getRightChild());
    }

    public void remove(Node n) {
        Node parNode = null;
        Node currNode = rootNode;

        while (currNode != null) {
            if (currNode.getData() == n.getData()) {
                if (currNode.getLeftChild() == null && currNode.getRightChild() == null) {
                    if (parNode == null) {
                        this.rootNode = null;
                    }
                    else if (parNode.getLeftChild() == currNode) {
                        parNode.setLeftChild(null);
                    }
                    else {
                        parNode.setRightChild(null);
                    }
                }
                else if (currNode.getRightChild() == null) {
                    if (parNode == null) {
                        this.rootNode = currNode.getLeftChild();
                    }
                    else if (parNode.getLeftChild() == currNode) {
                        parNode.setLeftChild(currNode.getLeftChild());
                    }
                    else {
                        parNode.setRightChild(currNode.getLeftChild());
                    }
                }
                else {
                    Node sucNode = currNode.getRightChild();
                    while (sucNode.getLeftChild() != null) {
                        sucNode = sucNode.getLeftChild();
                    }
                    int sucData = sucNode.getData();
                    remove(sucNode);
                    currNode.setData(sucData);
                }
                return;
            }
            else if (currNode.getData() < n.getData()) {
                parNode = currNode;
                currNode = currNode.getRightChild();
            }
            else {
                parNode = currNode;
                currNode = currNode.getLeftChild();
            }
        }
        return;
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
