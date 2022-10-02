package algorithm.JzOffer.Jz41;

import java.util.Set;
import java.util.TreeSet;

class MedianFinder {
    /**
     * initialize your data structure here.
     */
    Set<Integer> a = new TreeSet<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        a.add(num);
    }
    //p66 4.6 p47 3.8

    public double findMedian() {
        int n = a.size();
        int n1 = n / 2;
        var p = a.iterator();
        for (int i = 1; i < n1; i++) {
            p.next();
        }
        double ans;
        if (a.size() % 2 == 0) {
            ans = (p.next() + p.next()) / 2.0;
        } else {
            p.next();
            ans = p.next();
        }
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */