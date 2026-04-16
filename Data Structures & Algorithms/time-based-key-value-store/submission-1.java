class TimeMap {

    private HashMap<String, List<Pair<Integer, String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> pairValues = 
            timeMap.getOrDefault(key, new ArrayList());
        int l = 0, r = pairValues.size() -1;
        String result = "";

        while (l <= r) {
            int mid = (l + r) / 2;
            if (pairValues.get(mid).getKey() <= timestamp) {
                result = pairValues.get(mid).getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair (K key, V val) {
            this.key = key;
            this.value = val;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}
