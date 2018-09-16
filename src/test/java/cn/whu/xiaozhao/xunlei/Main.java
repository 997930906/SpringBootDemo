package cn.whu.xiaozhao.xunlei;

public class Main {
    public static final void getGouguNum(int maxnum){
        for(int i = 1; i < maxnum; i++){
            for(int j = i; j < maxnum; j++){
                for(int n = j + 1; n < maxnum; n++){
                    if((i*i+j*j)==n*n){
                        System.out.println(" "+i+" "+j+" "+n);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        getGouguNum(10);
    }
}
