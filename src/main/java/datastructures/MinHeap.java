package datastructures;

public class MinHeap {
    private int _capacity = 10;
    private int size = 0;
//    [2,3,4,5,6,7]
//          2
//       3     4
//    5    6  7

    int[] items = new int[_capacity];

    public static void main(String[] args) {

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
