package ru.aston.hometask;

public class MyHashSet<E> {
    private static final int INITIAL_CAPACITY = 16;
    private E[] elements;
    private int size;

    public MyHashSet() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean add(E value) {
        if (contains(value)) {
            return false;
        }
        if (size == elements.length) {
            resize();
        }
        int index = hash(value);
        while (elements[index] != null) {
            index = (index + 1) % elements.length;
        }
        elements[index] = value;
        size++;
        return true;
    }

    public boolean remove(E value) {
        int index = hash(value);
        int start = index;
        while (elements[index] != null) {
            if (elements[index].equals(value)) {
                elements[index] = null;
                size--;
                rehash(index);
                return true;
            }
            index = (index + 1) % elements.length;
            if (index == start) break;
        }
        return false;
    }

    public boolean contains(E value) {
        int index = hash(value);
        int start = index;
        while (elements[index] != null) {
            if (elements[index].equals(value)) {
                return true;
            }
            index = (index + 1) % elements.length;
            if (index == start) break;
        }
        return false;
    }

    private void resize() {
        Object[] oldElements = elements;
        elements = (E[]) new Object[oldElements.length * 2];
        size = 0;
        for (Object o : oldElements) {
            if (o != null) {
                add((E) o);
            }
        }
    }

    public int size() {
        return size;
    }

    private int hash(E o) {
        return (o == null) ? 0 : Math.abs(o.hashCode()) % elements.length;
    }

    private void rehash(int emptyIndex) {
        int index = (emptyIndex + 1) % elements.length;
        while (elements[index] != null) {
            E value = elements[index];
            elements[index] = null;
            size--;
            add(value);
            index = (index + 1) % elements.length;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (Object o : elements) {
            if (o != null) {
                if (!first) sb.append(", ");
                sb.append(o);
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}