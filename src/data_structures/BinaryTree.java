package data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    BinaryTree left;
    BinaryTree right;
    int value;

    public static List<Integer> inOrderIterative(BinaryTree root) {
        //1) Create an empty stack S.
        Stack<BinaryTree> nodes = new Stack<>();
        List<Integer> numbers = new ArrayList<>();
        //2) Initialize current node as root
        BinaryTree currentNode = root;
        //3) Push the current node to S and set current = current->left until current is NULL
        nodes.push(currentNode);
        currentNode = currentNode.left;

        //4) If current is NULL and stack is not empty then
        while (currentNode != null && !numbers.isEmpty()) {
            //set current = current->left until current is NULL
            while(currentNode != null ) {
                nodes.push(currentNode);
                currentNode = currentNode.left;
            }

            //a) Pop the top item from stack.
            BinaryTree tempNode = nodes.pop();

            //b) Print the popped item, set current = popped_item->right
            numbers.add(tempNode.value);
            currentNode = tempNode.right;
            //c) Go to step 3.
        }

        return numbers;

    }
}
