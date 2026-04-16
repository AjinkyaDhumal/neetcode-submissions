class MedianFinder {

    Queue<Integer> smallHeap;
    Queue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        
        if (!largeHeap.isEmpty()
            && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.add(smallHeap.poll());
            smallHeap.add(largeHeap.poll());
        }

        if (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.add(smallHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.isEmpty() && largeHeap.isEmpty()) return 0;

        if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else if (smallHeap.size() < largeHeap.size()) {
            return (double) largeHeap.peek();
        } else {
            return
                ((double) smallHeap.peek() + (double) largeHeap.peek()) / 2;
        }
    }
}
