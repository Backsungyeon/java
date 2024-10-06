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
        return this.capacity;
    }

    public int size() {
        return this.size;
    }

    public void add(int value) {
        if (size >= capacity) {
            resize();
        }
        array[size] = value;
        size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size >= capacity) {
            resize();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}