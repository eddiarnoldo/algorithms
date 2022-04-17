package datastructures;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;
//    [2,3,4,5,6,7]
//          2
//       3     4
//    5    6  7

    int[] items = new int[capacity];

    public static void main(String[] args) {

    }

    //heapifyDown
    //Extract minimum element of array [1,2,3,4,20] extract 1 and put 20 on it's place and
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();

        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerIndexChildren = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerIndexChildren = getRightChildIndex(index);
            }

            if (items[0] < items[smallerIndexChildren]) {
                break;
            } else {
                swap(index, smallerIndexChildren);
            }

            index = smallerIndexChildren;

        }
    }

    public void add(int number) {
        ensureExtraCapacity();
        items[size] = number;
        size++;
        heapifyUp();


    }

    private void heapifyUp() {
        int index = size - 1;
        //Bring up as long as there is a parent and our parent is less than us
        while (hasParent(index) && parent(index) > items[index]) {
            //Swap
            swap(getParentIndex(index), index);
            //Set new parent to now be the parent of the one we swaped
            index = getParentIndex(index);
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index) {
        //as long as it does not exceed our minheap array limits
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        //as long as it does not exceed our minheap array limits
        return getRightChildIndex(index) < size;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }


}
