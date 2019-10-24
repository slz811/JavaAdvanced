package smartlist;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;

public class CustomList<T extends Object & Comparable> {
    public static final int INITIAL_CAPACITY = 4;
    public T[] data;
    public int size;

    public CustomList() {
        this.data = (T[]) Array.newInstance(Object.class, INITIAL_CAPACITY);
        this.size = 0;
    }


    public T getElement(int index) {
        T element = null;
        for (int i = 0; i < this.size; i++) {
            if (index == i) {
                element = this.data[i];
            }
        }
        return element;
    }

    public void add(T element) {
        if (this.size == this.data.length) {
            resize();
        }
        this.data[this.size++] = element;
    }

    public void set(int index, T element) {
        for (int i = 0; i < this.size; i++) {
            if (index == i) {
                this.data[i] = element;
            }
        }
    }

    public int size() {
        return this.size;
    }

    private void resize() {
        T[] newData = (T[]) Array.newInstance(Object.class, this.data.length * 2);
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 || index < this.size;
    }

    public T remove(int index) {
        T element = this.data[index];
        if (isValidIndex(index)) {
            for (int i = index; i < this.size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.data[this.size - 1] = null;
        }
        return element;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    public void addOnIndex(T element, int index) {
        if (this.size == this.data.length) {
            resize();
        }
        shiftRight(index);
        this.data[index] = element;
    }

    private void shiftRight(int index) { // 1 2     .(+1)      4(+1)      5(+1)
        for (int i = index; i < this.size + 1; i++) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = null;
    }

    public boolean contains(T element) {
        boolean isPresent = false;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i].equals(element)) {
                isPresent = true;
                break;
            }
        }

        return isPresent;
    }

    public void swap(int first, int second) {
        if (isValidIndex(first) && isValidIndex(second)) {
            T temp = this.data[first];
            this.data[first] = this.data[second];
            this.data[second] = temp;
        }
    }

    public int countGreaterThan(T element) {
        return (int) Arrays.stream(this.data, 0, this.size)
                .filter(e -> 0 < e.compareTo(element)).count();

    }

    public T getMax() {
        return Arrays.stream(this.data, 0, this.size).max(T::compareTo).orElse(null);
    }

    public T getMin() {
        return Arrays.stream(this.data, 0, this.size).min(T::compareTo).orElse(null);
    }

    public void forEach(Consumer<T> listConsumer) {
        for (int i = 0; i < this.size; i++) {
            listConsumer.accept(this.data[i]);
        }
    }


}