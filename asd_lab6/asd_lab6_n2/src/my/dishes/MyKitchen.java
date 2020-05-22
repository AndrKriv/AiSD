package my.dishes;
import javax.swing.*;

import java.util.Random;
import java.util.Scanner;
public class MyKitchen extends JPanel {//создаем элементы кухни
    private static int n;
    private static Table table;
    private static DishWasher dishW;
    private static DishShelf shelf;
    static void working(String str) throws InterruptedException {//интервал для операций
        Random rand=new Random();
        System.out.println("\n"+str);
        Thread.sleep(rand.nextInt(2000)+1000);
    }
    MyKitchen() throws InterruptedException {//определим количество посуды на кухне и максимальное значение посуды на каждом участке кухни
        long start = System.currentTimeMillis();
        long finish;
        long timeConsumedMillis;
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите количество посуды: ");
        n = scan.nextInt();
        if (n<=0) {
            System.out.println("Некорректно введено количество посуды!");
            System.exit(0);
        }
        table=new Table(n);
        dishW=new DishWasher(n);
        shelf=new DishShelf(n);
        Random rand=new Random();//заполним рандомно каждую из трех составляющих кухни
        for (int i = 1; i <= n; i++) {
            int buff= rand.nextInt(3);
            if(buff==0)
                table.putDirty(i);
            else if(buff==1)
                dishW.putDirty(i);
            else
                shelf.putClean(new int[]{i, -1});
        }
        while (true){//вывод информации о посуде
            table.outPut();
            dishW.outPut();
            shelf.outPut();
            Thread.sleep(5000);//ожидаем, чтобы посмотреть расположение посуды
            int buff= rand.nextInt(3);//определим количество составляющих кухни
            if(buff==0) {
                working("Самое время помыть посуду!!!");
                dishW.putDirty(table.returnDirty());//поставить грязную посуду со стола в машинку
            }
            else if(buff==1) {
                working("Самое время вынуть из посудомойки посуду!");
                shelf.putClean(dishW.returnClean());//вынуть чистую посуду из посудомойки и поставить на полку
            }
            else{
                working("Самое время загрязнить посуду :)");
                table.putDirty(shelf.makeDirty());//взять посуду с полки и сделать ее грязной
            }
            finish = System.currentTimeMillis();
            timeConsumedMillis = finish - start;
            if(timeConsumedMillis>20000&&timeConsumedMillis<35000){
                System.out.println("----------------------------------");
                System.out.println("Я больше не могу столько есть!!!!!");
                System.out.println("----------------------------------");}
            if(timeConsumedMillis>35000&&timeConsumedMillis<45000){
                System.out.println("--------------------------------------------");
                System.out.println("Кто-нибудь остановите наконец этот ужас!!!!!");
                System.out.println("--------------------------------------------");}
            if(timeConsumedMillis>45000){
                System.out.println("---------------------------");
                System.out.println("АААААААААААААААААААААА!!!!!");
                System.out.println("---------------------------");}
        }
    }
}