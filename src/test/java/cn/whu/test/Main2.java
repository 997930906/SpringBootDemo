package cn.whu.test;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public List printR(int[] a, int[] b, int[] line, int key){
        int index = binarySearch(a, key);
        List list = new ArrayList();
        for (int i = index; i < b.length; i++) {
            if(key < b[i]) list.add(line[i]);
        }
        return list;
    }
    public static int binarySearch(int[] a,int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(a[mid] == key) return mid;
            if(a[mid] > key) high = mid - 1;
            if(a[mid] < key) low = mid + 1;
        }
        return -1;
    }
}
