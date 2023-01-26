package mod9.task5;

import java.util.Map;

public class MyHashMap<K, V> {
        private final int DEFAULT_CAPACITY = 16;
        private Entry[] table;
        private int size;

        public MyHashMap() {
            table = new Entry[DEFAULT_CAPACITY];
        }

        public MyHashMap(int initialCapacity) {
            if (initialCapacity < 0)
                throw new IllegalArgumentException("Illegal initial capacity: " +
                        initialCapacity);

            int capacity = 1;
            while (capacity < initialCapacity)
                capacity <<= 1;

            table = new Entry[capacity];
        }

        private void resize(int newCapacity) {
            Entry[] newTable = new Entry[newCapacity];
            transfer(newTable);
            table = newTable;
        }

        private void transfer(Entry[] newTable) {
            Entry[] src = table;
            int newCapacity = newTable.length;
            for (int i = 0; i < src.length; i++) {
                Entry<K, V> e = src[i];
                if (e != null) {
                    src[i] = null;
                    do {
                        Entry<K, V> next = e.next;

                        int j = indexFor(e.hash, newCapacity);
                        e.next = newTable[j];
                        newTable[j] = e;
                        e = next;
                    } while (e != null);
                }
            }
        }

        private int indexFor(int h, int length) {
            return h % length;
        }

        private int hash(int h) {
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private double maxCapacity() {
            return table.length * 0.75;
        }

        public V put (K key, V value) {
            if (key == null)
                return insertForNullKey(value);
            int hash = hash(key.hashCode());
            int i = indexFor(hash, table.length);
            for (Entry<K, V> e = table[i]; e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    V oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            addEntry(hash, key, value, i);
            return null;
        }

        private V insertForNullKey(V value) {
            for (Entry<K, V> e = table[0]; e != null; e = e.next) {
                // Если уже есть null ключ, меняем значение
                if (e.key == null) {
                    V oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            addEntry(0, null, value, 0);
            return null;
        }

        private class Entry<K, V> implements Map.Entry<K, V> {
            final K key;
            final int hash;
            V value;
            Entry<K, V> next;

            public Entry(int hash, K key, V value, Entry<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
                this.hash = hash;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public V setValue(V newValue) {
                V oldValue = value;
                value = newValue;
                return oldValue;
            }

            public final boolean equals(Object o) {
                if (!(o instanceof Map.Entry))
                    return false;
                Map.Entry e = (Map.Entry) o;
                Object k1 = getKey();
                Object k2 = e.getKey();
                if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                    Object v1 = getValue();
                    Object v2 = e.getValue();
                    if (v1 == v2 || (v1 != null && v1.equals(v2)))
                        return true;
                }
                return false;
            }

            public final int hashCode() {
                return (key == null ? 0 : key.hashCode()) ^
                        (value == null ? 0 : value.hashCode());
            }
        }

        private void addEntry(int hash, K key, V value, int bucketIndex) {
            Entry<K, V> e = table[bucketIndex];
            table[bucketIndex] = new Entry<>(hash, key, value, e);
            if (size++ >= maxCapacity())
                resize(2 * table.length);
        }

        public V get(Object key) {
            if (key == null)
                return getForNullKey();
            int hash = hash(key.hashCode());
            for (Entry<K,V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                    return e.value;
            }
            return null;
        }

        private V getForNullKey() {
            for (Entry<K,V> e = table[0]; e != null; e = e.next) {
                if (e.key == null)
                    return e.value;
            }
            return null;
        }

        private Entry<K,V> getEntry(Object key) {
            int hash = (key == null) ? 0 : hash(key.hashCode());
            for (Entry<K,V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            }
            return null;
        }

        /**
         * Удаляет запись по ключу
         * Возвращает true, если удаление было выполнено
         *
         */
        public boolean remove(Object key) {
            Entry<K,V> e = deleteEntryForKey(key);
            return !(e == null);
        }

        /**
         * Удаляет и возвращает запись соответсвующую ключу
         *
         */
        private Entry<K,V> deleteEntryForKey(Object key) {
            int hash = (key == null) ? 0 : hash(key.hashCode());
            int i = indexFor(hash, table.length);
            Entry<K,V> prev = table[i];
            Entry<K,V> e = prev;

            while (e != null) {
                Entry<K,V> next = e.next;
                Object k;
                if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                    size--;
                    if (prev == e)
                        table[i] = next;
                    else
                        prev.next = next;
                    return e;
                }
                prev = e;
                e = next;
            }
            return e;
        }

        /**
         * Удаляет все элементы в таблице
         */
        public void clear() {
            Entry[] tab = table;
            for (int i = 0; i < tab.length; i++)
                tab[i] = null;
            size = 0;
        }
    }