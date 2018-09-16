package cn.whu.test;

public class Singleton {

    private Singleton(){
        //do something
    }

    private static volatile Singleton singleton = null;

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
