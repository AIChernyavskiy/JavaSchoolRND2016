package JavaSchoolRND2016.homework.July14;


import java.io.*;
import java.util.*;

/*
Исходные данные: текстовый файл со средней длиной строки равной 10 символам (файл или прошить текст в коде).
        В реализациях используйте наиболее подходящие имплементации коллекций!
        Задание 1: Подсчитайте количество различных слов в файле.
        Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
        Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        Задание 4: Выведите на экран все строки файла в обратном порядке.
*/
public class Collection {

   private static class Comp implements Comparable {
        //Класс со словом и количеством символов в слове
        String str;
        int number;

        Comp(String str, int number) {
            this.str = str;
            this.number = number;
        }

        @Override
        public int compareTo(Object obj) {
            Comp entry = (Comp) obj;

            int result = number - entry.number;
            if(result != 0) {
                return (int) result / Math.abs( result );
            }

            result = str.compareTo(entry.str);
            if(result != 0) {
                return result;
            }

            return 0;
        }

    }

    public static void main(String[] args) {

        File file = new File("src/JavaSchoolRND2016/homework/July14/input.txt");

        //Проверяем есть ли файл
        if (!file.exists()) {
            System.out.println("Не удалось найти файл");
            return;
        }

        //Инициализируем необходимые переменные
        String stroka;
        int i;

        try {
            Scanner potok = new Scanner(file);
            PrintWriter output = new PrintWriter("src/JavaSchoolRND2016/homework/July14/output.txt");
            PrintWriter output_2 = new PrintWriter("src/JavaSchoolRND2016/homework/July14/output_2.txt");
            PrintWriter output_3 = new PrintWriter("src/JavaSchoolRND2016/homework/July14/output_3.txt");
            PrintWriter output_4 = new PrintWriter("src/JavaSchoolRND2016/homework/July14/output_4.txt");
            /*С помощью контейнера Coll подсчитаем количество различных слов в файле и используем Comparable.
              С помощью контейнера Arr и Coll подсчитаем и выведем на экран сколько раз каждое слово встречается в файле.
              С помощью контейнера Rev выведим на экран все строки файла в обратном порядке.
             */
            Set<Comp> Coll = new TreeSet<Comp>();
            List<String> Arr = new ArrayList<String>();
            List<String> Rev = new ArrayList<String>();
            //Проходим по файлу
            while (potok.hasNext()){
                stroka = potok.nextLine();
                //В контейнер Rev добавляем строки для дальнейшего их вывода в обратном порядке.
                Rev.add(stroka);
                //Получаем массив слов, пробел явл-ся разделителем
                String [] slov  = stroka.split(" ");
                //Проходим по массиву из слов и добавляем их в коллекции
                for (i=0;i<=slov.length-1;i++){
                    Arr.add(slov[i]);
                    //Получаем слово и его длину и сортируем в требуемом порядке в задании 2.
                    Coll.add(new Comp(slov[i],slov[i].length()));
                }

            }
            //Записываем данные в первый файл для первого задания
            output.println("Количество различных  слов в файле: "+ Coll.size());
            output.close();
            //Выводим список отсортированных различных слов.
            for (Comp k : Coll){
                // number теперь будет выступать как счетчик для дублирующихся слов в файле, поэтому обнуляем его.
                k.number=0;
                //Записываем данные во второй файл для второго задания
                output_2.println(k.str);
                //Подсчитываем количество дублирующихся слов
                for (String ElArr : Arr) if (ElArr.equals(k.str)) k.number++;
            }
            for (Comp k : Coll)
            //Записываем данные в третий файл для третьего задания
            output_3.println("Слово "+k.str+" встречается в файле " +k.number);
            //Ну тут понятно
            Collections.reverse(Rev);
            //Записываем данные в четвёртый файл для четвёртого задания
            for (String ElArr : Rev)   output_4.println(ElArr);

            output_2.close();
            output_3.close();
            output_4.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
