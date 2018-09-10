package data_structures;

public class MaxHeap {
    int[] heap;
    int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // return parent
    int parent(int i) {
        return (i-1)/2;
    }

    // return left child
    int left(int index) {
        return (2*index + 1);
    }

    // return right child
    int right(int index) {
        return (2*index + 2);
    }

    // Inserts a new key 'k'
    public void insertKey(int k){
        heap[size] = k;
        upHeapify(size);
        size++;
    }

    // to extract the root which is the maximum element
    public int extractMax(){
        int max = heap[0];
        //swap the last element with the maximum element
        heap[0] = heap[size-1];
        //delete the last element
        size--;
        //make the heap valid
        downHeapify(0);
        return max;
    }


    // A recursive method to heapify down a subtree from the root at given index
    // This method assumes that the subtrees are already heapified
    private void downHeapify(int index) {
        // compare the node with both its children
        int left = left(index);
        int right = right(index);

        //find largest of the two children
        int largest = index;

        //checking if the node has children
        if (left < size && heap[left] > heap[index]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        // swap with smaller
        if (largest != index)
        {
            swap(index, largest);
            // continue heapifying;
            downHeapify(largest);
        }
    }

    // A recursive method to heapify up a subtree with the root at given index
    // This method assumes that the subtrees are already heapified
    private void upHeapify(int index) {
        // compare the node with both its parent
        int parent = parent(index);

        //checking if the node is larger than parent children
        if (parent >=0 && heap[index] > heap[parent]) {
            swap(index, parent);
            // continue heapifying;
            upHeapify(parent);
        }
    }


    // Decreases key value of key at index i to new_val
    void decreaseKey(int i, int new_val){

    }

    // Returns the minimum key (key at root) from min heap
    int getMax() {
        return heap[0];
    }

    // Deletes a key stored at index i
    void deleteKey(int i){

    }

    private void swap(int i, int j) {
        heap[i] = heap[i]+heap[j];
        heap[j] = heap[i]-heap[j];
        heap[i] = heap[i]-heap[j];
    }
}

