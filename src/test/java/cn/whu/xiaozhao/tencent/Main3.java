package cn.whu.xiaozhao.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a= in.nextInt();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i=0;i<a;i++){
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(in.nextInt());
            list1.add(in.nextInt());
            list1.add(in.nextInt());
            list.add(list1);
        }
        list.forEach(l->{
            if((l.get(0)%l.get(1))/l.get(2) == 0){
                System.out.println("YES");
            }
            else{
                for (int c=2;c<100;c++){
                    if ((c*l.get(0))-l.get(2)/l.get(1)==0){
                        System.out.println("YES");
                    }
                }
                System.out.println("NO");
            }

        });
    }

}