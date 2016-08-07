package ru.sbertech.test.lesson6.classwork;

/**
 * Created by Student on 28.07.2016.
 */
public class C extends B implements I {
    @ValidLength(5)
    private String str = "first";
    public B bC;


    public  C() {

    }

        //@Override
        public void someMethod (String param){
          System.out.println(str+" " +param);
        }
}
