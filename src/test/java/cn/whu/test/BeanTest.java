package cn.whu.test;

import org.springframework.beans.factory.InitializingBean;

public class BeanTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after");
    }

    public static void main(String[] args) {
        BeanTest b = new BeanTest();
        System.out.println(111);
    }
}
