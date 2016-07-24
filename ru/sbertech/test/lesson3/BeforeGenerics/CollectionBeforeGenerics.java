package JavaSchoolRND2016.ru.sbertech.test.lesson3.BeforeGenerics;

import java.util.ArrayList;


public class CollectionBeforeGenerics {

    @SuppressWarnings("unchecked")
    public  static  void main(String[] args){
        ArrayList<Apple> apples = new ArrayList();

        for (int i=0;i<3;i++){
            apples.add(new Apple());

        }

        //apples.add(new Orange());
        for (int i=0;i<3;i++){
            System.out.println(apples.get(i));
            //System.out.println(apples.get(i)).getId());
            //
        }
    }

}
