package cn.whu.test;

import org.springframework.web.util.HtmlUtils;

public class QuickSort {

    public void quickSort(int[] arr, int low ,int high){

        if (low < high){
            int index = partition(arr, low , high);
            quickSort(arr, low, index-1);
            quickSort(arr, index+1, high);
        }
    }

    public int partition(int[] arr, int low, int high){

        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] > key) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] < key) low++;
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }
}
