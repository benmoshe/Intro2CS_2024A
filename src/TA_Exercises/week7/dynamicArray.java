package TA_Exercises.week7;

public class dynamicArray {
    private int size = 0;
    private int capacity = 10;
    int[] array = new int[10];
    public void growSize(){
        int[] temp = new int[capacity*2];

        for (int i=0; i<size; i++)
            temp[i]=array[i];

        array = temp;
        capacity *= 2;
    }
    public void addElement(int n){
        if (size == capacity)
            growSize();

        array[size]=n;
        size++;
    }
    public void addElementAt(int n, int index){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size==capacity)
            growSize();

        for (int i=size; i>index; i--)
            array[i+1]=array[i];

        array[index]=n;
        size++;
    }
    public void removeElement(){
        if (size > 0) {
            size--;
        }
    }
    public void removeElementAt(int index){
        // remove the element at index
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i=index; i<size-1; i++)
            array[i]=array[i+1];

        size--;
    }
    public void shrink(){
        int[] temp = new int[size];

        for (int i=0; i<size; i++)
              temp[i]=array[i];

        capacity = size;
        array = temp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getElementAt(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[i];
    }
}
