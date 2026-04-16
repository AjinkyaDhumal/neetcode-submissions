class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>())
            .put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tree = 
            timeMap.getOrDefault(key, new TreeMap());
        Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
        return (entry == null) ? "" : entry.getValue();
    }
}
