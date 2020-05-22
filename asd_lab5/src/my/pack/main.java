package my.pack;
import java.util.Scanner;
public class main {
    private static int[] Fibonachi(int length) {//функция фибоначи, которая в main будет определять значения от 1 до 55
        int stZn0 = 1;
        int stZn1 = 1;
        int stZn2 = 2;
        System.out.print("Элементы последовательности Фибоначи: ");
        System.out.print(stZn0 + " " + stZn1 + " ");
        for (int i = 3; i <= length; i++) {
            stZn2 = stZn0 + stZn1;
            System.out.print(stZn2 + " ");
            if (stZn2 - length < 0) {
                stZn0 = stZn1;
                stZn1 = stZn2;
            } else {
                break;
            }
        }
        System.out.println();
        return new int[]{stZn0, stZn1, stZn2};//возвращяем 3 выбранных числа последовательности фибоначи
    }
    private static void output(int[] arr) {//функция вывода полученных рандомных значений
        System.out.print("Элементы массива: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + i + "] = " + arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {//основная main функция
        System.out.println("Введите размерность массива: ");
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();//размерность массива
        if(length==0||length<0){
            return;
        }
        int[] arr = new int[length];   // исходный массив
        System.out.println("Какой будет массив(0- рандомно, 1- по возрастанию, 2- по убыванию): ");
        int h=sc.nextInt();
        if(h==0) {//массив составлен рандомно
            for (int i = 0; i < length; i++)
                arr[i] = (int) (Math.random() * length + 1); //заполняем массив рандомными целыми значениями
        }
        else
        if(h==1){//составление массива в порядке возрастания
            int min, t,i;
            for ( i = 0; i < length; i++) {
                arr[i] = (int) (Math.random() * length + 1);}
            for ( i = 0; i < length; i++) {
                min = i;
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                t = arr[i];
                arr[i] = arr[min];
                arr[min] = t;
            }
        }else if(h==2) {//составление массива в порядке убывания
            int min, t, i;
            for (i = 0; i < length; i++) {
                arr[i] = (int) (Math.random() * length + 1);
            }
            for (i = 0; i < length; i++) {
                min = i;
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] > arr[min]) {
                        min = j;
                    }
                }
                t = arr[i];
                arr[i] = arr[min];
                arr[min] = t;

            }
        }
        else{return;}
        output(arr);//выведем его
        int[] stZn = Fibonachi(arr.length);//воспользуемся функцией фибоначи, чтобы понять в каких рамках будут значения
        System.out.println("Максимально значение в последовательности Фибоначи: "+stZn[2] + " = " + stZn[1] + " + " + stZn[0]);//n[2] будем значением для проверки в таблице и в дальнейших расчетах
        int startZn = stZn[2] - arr.length;//определим значение, с которого начнем считать
        System.out.println("Начальное значение для Part 1 " + " = " + startZn);
        fibSort[] elem = new fibSort[3];//распределение массива на 3 части, которые в свою очередь будут сортировать входящие в них элементы
        elem[0] = new fibSort(stZn[1]);
        elem[1] = new fibSort(stZn[0]);
        elem[2] = new fibSort(stZn[0]);
        int j = 0;
        for (int i = startZn; i < elem[0].length(); i++, j++)//начальное распределение элементов массива по двум частям
            elem[0].add(i, arr[i]);//1 часть
        for (int i = 0; i < elem[1].length(); i++, j++)
            elem[1].add(i, arr[j]);//2 часть
        System.out.println("Начало многофазной (фибоначиевой) сортировки :");
        System.out.print("Part 1: ");
        elem[0].output();
        System.out.print("Part 2: ");
        elem[1].output();
        System.out.print("Part 3: ");
        elem[2].output();
        int finding = 3;
        int step = 1;
        int x = 2;
        int y = 1;
        int z = 0;
        while (finding != 1) {//суть каждого шага для последующей сортировки
            elem[x] = elem[x].change(elem[z], elem[y], elem[x]);
            x--;
            if (x == -1)
                x = 2;
            z--;
            if (z == -1)
                z = 2;
            y--;
            if (y == -1)
                y = 2;
            System.out.println(step + " разделение:");
            step++;
            System.out.print("Part 1: ");
            elem[0].output();
            System.out.print("Part 2: ");
            elem[1].output();
            System.out.print("Part 3: ");
            elem[2].output();
            finding = 0;
            for (int i = 0; i < 3; i++)
                if (!elem[i].Empty())
                    finding++;
        }
    }
}