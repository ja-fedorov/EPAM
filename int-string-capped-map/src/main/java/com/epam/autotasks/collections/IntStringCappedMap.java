package com.epam.autotasks.collections;

import java.util.*;

class IntStringCappedMap extends AbstractMap<Integer, String> {

    ArrayList <Integer> keyMap = new ArrayList <>();
    ArrayList <String> valueMap = new ArrayList <>();

    private final long capacity;

    public IntStringCappedMap(final long capacity) {
        this.capacity = capacity;
    }

    public long getCapacity() {
        return capacity;
    }

    @Override
    public Set<Entry<Integer, String>> entrySet() {
        return new AbstractSet<>() {

            @Override
            public Iterator<Entry<Integer, String>> iterator() {
                return new Iterator<>() {
                    // make a new int
                    int index =0;

                    @Override
                    public boolean hasNext() {
                       return index < IntStringCappedMap.this.size() ;
                    }

                    @Override
                    public Entry<Integer, String> next() {
                        //make iterator of keyMap
                        Iterator <Integer> it = keyMap.iterator();
                        // use hashNext to Iterator
                        if (it.hasNext()) {
                            Map.Entry<Integer, String> entry = new SimpleEntry <> (keyMap.get(index), valueMap.get(index));
                            index++;
                            return entry;
                        }
                        else return new SimpleEntry <> (0, "0");
                    }
                };
            }

            @Override
            public int size() {
                // return size;
                return IntStringCappedMap.this.size();
            }
        };
    }

    @Override
    public String get(final Object key) {
        // (1)
        // Т.к. <k> & <v> добавляется одновременно, находим value по месту нахождения key;
        return valueMap.get(keyMap.indexOf(key));
    }

    @Override
    public String put(final Integer key, final String value) {

        // By Descriptions, we should to make Exception if this.capacity < capacity of String
        if (value.length() > IntStringCappedMap.this.capacity) {
            throw new IllegalArgumentException ();
        }
        // Add key and value if we didn't find a similar exemplar by key
        if (!(keyMap.contains(key))) {
            keyMap.add(key);
            valueMap.add(value);

        //  By Descriptions, if capacity more than we make -
        //  List should be cut equals position that he was added;
            while (capacity() > this.capacity) {
                this.remove(keyMap.get(0));
            }
            return null;
        }
        String str = valueMap.get(keyMap.indexOf(key));
        IntStringCappedMap.this.remove(key);
        keyMap.add(key);
        valueMap.add(value);
        while (capacity()>IntStringCappedMap.this.capacity) {
            IntStringCappedMap.this.remove(keyMap.get(0));
        }
        return str;
    }

    @Override
    public String remove(final Object key) {
        // (2)
        // Chek a key for a available
        if (keyMap.contains(key)) {
            // Как и (1) удаляем value по индексу key;
            String remove = valueMap.get(keyMap.indexOf(key));
            valueMap.remove(keyMap.indexOf(key));
            // Так же удаляем key удаляем и его тоже (что бы было все параллельно);
            keyMap.remove(key);
            // return String by issue
            return remove;
        }
        return null;
    }

    @Override
    public int size() {
        // (3)
        // return a size (length) of ArrayList <Integer> keyMap
        return keyMap.size();
    }

    // (4)
    // add new method capacity all List of valueMap
    public int capacity() {
        int capacity = 0;
        for (String sss : valueMap) {
            capacity += sss.length();
        }
        return capacity;
    }

}
