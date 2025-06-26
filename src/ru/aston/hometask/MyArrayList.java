package ru.aston.hometask;

public class MyArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private E[] elements;
    private int size;

    public MyArrayList() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(E value) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = value;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Введен некорректный номер индекса");
        }
        return (E) elements[index];
    }

    public boolean remove(E value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                int numMoved = size - i - 1;
                if (numMoved > 0) {
                    System.arraycopy(elements, i + 1, elements, i, numMoved);
                }
            }
            elements[--size] = null;
            return true;
        }

        return false;
    }

    public void addAll(MyArrayList<E> elements) {
        for (int i = 0; i < elements.size(); i++) {
            add(elements.get(i));
        }
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
