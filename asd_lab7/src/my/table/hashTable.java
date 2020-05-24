package my.table;
import java.io.*;
import java.util.Random;
public class hashTable {// Реализация хеш-таблицы с использованием метода цепочек
static class lab7 {
    public static void main(String[] args) throws IOException, InterruptedException {
        int key;
        long firstT1=0,firstT2=0 ;
        long lastT1, lastT2;
        table aDataItem;//далее это будет элемент таблицы, соответствующий ключу (номеру) в хеш-таблице
        int size, n;// Ввод размеров, где size- размер таблицы, а n - количество элементов в ней
        //количество элементов в ней мложет быть более размера таблицы, так как отркытом хешировании
        //в одной клетке таблицы может содержаться несколько значений
        System.out.print("Введите размер хеш-таблицы: ");
        size = getInt();
        System.out.print("Заполнить случайными чилами, введите количество: ");
        n = getInt();
        hTable theHashTable = new hTable(size); // Создание таблицы
        for (int i = 0; i < n; i++) // Вставка данных
        {
            if(i==0)firstT1 = System.nanoTime();
            if(i==99){lastT1 = System.nanoTime();
                System.out.println("add first 100: " + (lastT1 - firstT1) / Math.pow(10, 6));}
            Random r = new Random();
            key = r.nextInt(size*100);// рандом
            aDataItem = new table(key);
            theHashTable.past(aDataItem);
            if(i==n-101)firstT2 = System.nanoTime();
            if(i==n-1){lastT2 = System.nanoTime();
                System.out.println("add last 100: " + (lastT2 - firstT2) / Math.pow(10, 6));}
        }
        while (true) // Меню
        {
            System.out.println("\tМеню:\n1) Вывести таблицу значений\n2) Добавить элемент по ключу\n3) Найти элемент \n4) Выход из программы");
            int v = getInt();
            switch (v) {
                case 1:
                    theHashTable.showTable();//вывод таблицы
                    break;
                case 2://добавление элемента по ключу
                    System.out.print("Введите ключ для добавления: ");//одновременно будет являться и самим элементом добавления
                    key = getInt();
                    aDataItem = new table(key);
                    theHashTable.past(aDataItem);
                    break;
                case 3://поиск элемента по ключу
                    System.out.print("Введите ключ для поиска: ");
                    key = getInt();
                    aDataItem = theHashTable.search(key);
                    if (aDataItem != null)
                        System.out.println("(+) Заданный элемент найден: " + key);
                    else
                        System.out.println("(-) Заданный элемент не найден: " + key);
                    break;
                case 4:
                    long start;
                    long finish;
                    long sr,sr2,sr3;
                    start = System.currentTimeMillis();
                    Thread.sleep(1000);
                    finish = System.currentTimeMillis();
                    sr = finish - start;
                    if(sr<1500){
                        System.out.print("Wait.\n");}
                    Thread.sleep(1000);
                    finish = System.currentTimeMillis();
                    sr2 = finish - start;
                    if(sr2>1500&&sr2<2500){
                        System.out.print("Wait..\n");}
                    Thread.sleep(1000);
                    finish = System.currentTimeMillis();
                    sr3 = finish - start;
                    if(sr3>2500&&sr3<3500){
                        System.out.print("Wait...\n");}
                    System.out.print("Закрытие программы!");
                    System.exit(0);
                default:
                    System.out.print("Некорректно введены данные!\n");
            }
        }
    }
    static class table {
        private int data; // Данные
        public table next; // Следующий элемент списка
        public table(int x) // Конструктор
        {
            data = x;
        }
        public int getKey() {
            return data;
        }
        public void print() // Вывод содержимого элемента
        {
            System.out.print(data + " ");
        }
    }
    static class List {
        private table first; // Ссылка на первый элемент списка
        public void insert(table asd) // Вставка в порядке сортировки
        {
            int key = asd.getKey();
            table adr = null; // Начиная с первого элемента
            table elem = first;            // До конца списка
            while (elem != null && key > elem.getKey()) { // Или пока current <= key
                adr = elem;
                elem = elem.next; // Переход к следующему элементу
            }
            if (adr == null) // В начале списка
                first = asd; // first --> новый элемент
            else // Не в начале
                adr.next = asd; // prev --> новый элемент
            asd.next = elem; // новый элемент --> asd
        }
        public table find(int key) // Поиск элемента с заданным ключом
        {
            long start1,end1;
            table asd = first; // Начиная от начала списка            // До конца списка
            start1=System.nanoTime();
            while (asd != null && asd.getKey() <= key) { // или пока ключ не превысит current,
                if (asd.getKey() == key) { // Искомый элемент?
                    end1=System.nanoTime();
                    System.out.println("Search: " + (end1 - start1) / Math.pow(10, 6));
                    return asd; // Совпадение обнаружено
                }
                asd = asd.next; // Переход к следующему элементу
            }
            end1=System.nanoTime();
            System.out.println("Search: " + (end1 - start1) / Math.pow(10, 6));
            return null; // Элемент не найден

        }
        public void showList() {
            table asd = first; // От начала списка
            while (asd != null) // Перемещение до конца списка
            {
                asd.print(); // Вывод данных
                asd = asd.next; // Переход к следующему элементу
            }
            System.out.println(" ");
        }
    }
    static class hTable {
        private List[] hArr; // Массив списков
        private int arrSize;
        public hTable(int size) // Конструктор
        {
            arrSize = size;
            hArr = new List[arrSize]; // Создание массива
            for (int i = 0; i < arrSize; i++) // Заполнение массива
                hArr[i] = new List(); // списками
        }
        public void showTable() {//вывод таблицы
            System.out.println("\t###=Hash-Table=###");
            System.out.println("#------------------------#");
            for (int i = 0; i < arrSize; i++) // Для каждой ячейки
            {
                System.out.print(i + ") "); // Вывод номера ячейки
                hArr[i].showList(); // Вывод списка
            }
            System.out.println("#------------------------#");
        }
        public int hashFx(int key) // Хеш-функция
        {
            return key % arrSize;//возвращает остаток от деления
        }
        public void past(table asd) // Вставка элемента
        {
            int key = asd.getKey();
            int hashZn = hashFx(key); // Хеширование ключа
            hArr[hashZn].insert(asd); // Вставка в позиции hashVal
        }
        public table search(int key) // Поиск элемента
        {
            int hashZn = hashFx(key); // Хеширование ключа
            table asd = hArr[hashZn].find(key); // Поиск
            return asd; // Метод возвращает найденный элемент
        }
    }
    public static int getInt() throws IOException {//функция множественного ввода
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufR = new BufferedReader(isr);
        String str = bufR.readLine();
        return Integer.parseInt(str);
    }
    }
}
