//n is where we detect our imbalance

/* CASE 1 */
Node rotateRight(Node n){
    Node c = n.left;
    n.left = c.right;
    c.right = n;
    //returning our new root for the subtree where the imbalance was detected
    return c;
}

/* CASE 2 */
Node rotateLeft(Node n){
    Node c = n.right;
    n.right = c.left;
    c.left = n;
    //returning our new root for the subtree where the imbalance was detected
}

/* CASE 3 */
Node rotateRightLeft(Node n){
    Node c = n.right;
    //rotating about n's grandchild to give n its new child... 
    n.right = rotateRight(c);
    //now we have right-right formation as in the normal rotateLeft case
    //rotate about n's new child and return the new root of this subtree
    return rotateLeft(n);
}

/* CASE 4 */
Node rotateLeftRight(Node n){
    Node c = n.left;
    //rotating about n's grandchild to give n its new child... 
    n.left = rotateLeft(c);
    //now we have left-left formation as in the normal rotateRight case
    //rotate about n's new child and return the new root of this subtree
    return rotateRight;
}

private AVLNode rebalance(Node n){
    //get height difference between node n's left and right subtrees
    int heightDif = getHDif(AVLNode n);
    //if dif > 1, left is bigger so we'll be rotating at the left
    if (hdif > 1){
        //if n.left's left is bigger, then its a left-left formation, solve with one right rotation (case 2)
        if (getHDif(n.left) > 0)
            n = rotateRight(n);
        //else if n's right is bigger, then first gotta rotate left to get into left-left formation, then another right rotation (case 4)
        else
            n = rotateLeftRight(n);
    }
    else if (hdif < -1){
        if (getHDif(n.right) > 0)
            n = rotateLeft(n);
        else
            n = rotateRightLeft(n);
    }
    //if hdif is bwn -1 and 1, tree is balanced, root node/ structure stays same
    return n; 
}

public E insert(E newData){
    E result = null;
    if (root == null))
        root = new AVLNode<E>();
    else{
        result = insertEntry(root, newData)
        setRoot(rebalance(root));
    }
}

private E insertEntry(AVLNode<E> root, E newData){
    Preconditions.checkArguments(root != null);

    E result = null;
    int comp = newData.compareTo(root.getData);

    if (comp == 0)
        result = root.getData();

    else if (comp < 0){
        if (root.left != null){
            result = insertEntry(left, newData);
            root.left = rebalance(left);
        }
        else
            root.left = new AVLNode<>(newData);
    }

    else if (comp > 0){
        if (root.right != null){
            result = insertEntry(right, newData);
            root.right = rebalance(right);
        }
        else
            root.right = new AVLNode<>(newData);
    }
    return result;
}
