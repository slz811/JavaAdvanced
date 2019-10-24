package smartlist;


public class Sorter {

    public static <T extends Comparable<? super T>> CustomList<T> sort(CustomList<T> customList) {
        final int len = customList.size(); // <-- from a.length
        for (int index = 0; index < len; index++) {
            T key = customList.getElement(index); // <-- from a[index]
            int position = index;
            while (position > 0 && customList.getElement(position - 1).compareTo(key) > 0) {
                customList.set(position, customList.getElement(position - 1)); // from a[position] = a[position-1];
                position--;
            }
            customList.set(position, key); // <-- from a[position] = key;
        }
        return customList;
    }
}