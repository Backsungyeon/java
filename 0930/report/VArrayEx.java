package java2024;

class VArray {
    private int[] array; 
    private int size; 
    private int capacity;

    public VArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size == capacity) {
            resize();
        }
        array[size] = value; 
        size++; 
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i]; 
        }
        array = newArray; 
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            resize(); 
        }
       
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value; 
        size++; 
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class VArrayEx {
    public static void main(String[] args) {
        VArray v = new VArray(5); 
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        for (int i = 0; i < 7; i++) 
            v.add(i);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.insert(3, 100);
        v.insert(5, 200); 
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        for (int i = 50; i < 55; i++) 
            v.add(i);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}