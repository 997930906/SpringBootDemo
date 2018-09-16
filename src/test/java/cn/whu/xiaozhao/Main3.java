package cn.whu.xiaozhao;

import java.util.*;

public class Main3 {

    public static int getMaxMan(int[] a){
        int result = 0;
        Map<Integer,Integer> map = new HashMap();
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])){
                temp = (int) map.get(a[i]);
                map.put(a[i],temp+1);
            } else {
                map.put(a[i],1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) max = entry.getKey();
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];//投给谁
        int[] b = new int[n];//所需糖果数

        int currentTick = 0;//当前票数
        int needTick = 0;
        int need = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (a[i] ==1) currentTick++;
        }
        int max = getMaxMan(a);

        if(currentTick > n/2) {
            System.out.println(0);
        } else {
            needTick = max+1-currentTick;
            List list = new ArrayList();
            for (int i = 0; i < n; i++) {
                if (a[i] != 1) list.add(b[i]);
            }
            Collections.sort(list);
            for (int i = 0; i < needTick; i++) {
                need += (int) list.get(i);
            }
            System.out.println(need);
        }

    }
}
