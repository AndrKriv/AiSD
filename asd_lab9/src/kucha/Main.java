package kucha;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numb;
        kucha MyHeap = new kucha();
        MyHeap.printHeap("", 0, false);//начальный вывод кучи
        while (true) {
            System.out.println("Выбрать пункт:");
            System.out.println("\t1) Вставить элемент");
            System.out.println("\t2) Удалить элемент");
            System.out.println("\t3) Выйти из программы");
            Scanner sc = new Scanner(System.in);
            numb = sc.nextInt();
            if (numb == 1)
                MyHeap.Paste();
            else if (numb == 2)
                MyHeap.Delete();
            else if (numb == 3){
                System.out.println("Выход из программы...");
                System.exit(1);
                break;
            }
            MyHeap.printHeap("", 0, false);//вывод кучи после каждого совершенного действия
        }
    }
}