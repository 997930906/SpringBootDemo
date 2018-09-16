package cn.whu.test;

public class MergeSort {
    public void mergeSort(int[] A, int low, int high) {
        if (low < high){//或者low == high return;长度为1时停止递归
            int mid = (low+high)/2;
            mergeSort(A, low, mid);
            mergeSort(A, mid+1, high);
            merge(A, low, high, mid);
        }
    }

    public void merge(int[] A, int low, int high, int mid){
        int[] B = new int[A.length];
        int i = low;
        int j = mid+1;
        int index = 0;
        while (i <= mid && j <= high){
            B[index++] = A[i] < A[j] ? A[i] : A[j];
        }
        while (i <= mid){
            B[index++] = A[i++];
        }
        while (j <= mid){
            B[index++] = A[j++];
        }
        for (int k = 0; k < A.length; k++)
        {
            A[low++] = B[k];
        }
    }
}
