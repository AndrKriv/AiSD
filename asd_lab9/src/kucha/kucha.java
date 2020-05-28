package kucha;
import java.util.Scanner;
class kucha {
    private int[] array;
    private int child = 3;//по условию d=3
    private int size, currentSize;
    Scanner sc=new Scanner(System.in);
    kucha() {
        System.out.println("Введите размер кучи: ");
        size = sc.nextInt();
        size++;
        currentSize = 0;
        array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = -1;
        System.out.println("\t1) Заполнить кучу рандомно!");
        System.out.println("\t2) Заполнить кучу с клавиатуры!");
        if (sc.next().equals("1")) {
            for (int i = 0; i < size; i++) {//random-цикл заполнения
                int hole = currentSize;
                currentSize++;
                while (true) {
                    int val = (int) (Math.random() * size);
                    int j = 0; int k = 0;
                    while (j != i) {
                        if (val != array[j]) {
                            k++;
                        }
                        j++;
                    }
                    if (k == i) {
                        array[hole] = val;
                        giveElem(hole);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++)
                Paste();
        }
    }
    private int parent(int i) {//определение родителя (основы разветвлений)
        return (i - 1) / child;
    }
    private int Child(int i, int k) {//формирование child-ов, которые ответвляются от родителя
        return child * i + k;
    }
    void Paste() {//вставка элементов в кучу
        if (currentSize == size)
            System.out.println("Куча переполнена!");
        else {
            int hole = currentSize;
            currentSize++;
            System.out.println("Введите элемент: ");
            array[hole] = sc.nextInt();
            giveElem(hole);
        }
    }
    void Delete() {//Удаление последнего (крайнего) элемента
        if (currentSize == 0)
            System.out.println("Куча пустая, нет элементов для удаления!");
        else {
            array[0] = array[currentSize - 1];
            currentSize--;
            delElem(0);
        }
    }
    private void delElem(int hole) {//основное свойство кучи для удаления в ней элемента
        int child;
        int tmp = array[hole];
        for (; Child(hole, 1) < currentSize; hole = child) {
            child = minChild(hole);
            if (array[child] < tmp)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }
    private int minChild(int hole) {//поиск минимального значения
        int min = Child(hole, 1);
        int k = 2;
        int i = Child(hole, k);
        while ((k <= child) && (i < currentSize)) {
            if (array[i] < array[min])
                min = i;
            k++;
            i = Child(hole, k);
        }
        return min;
    }
    private void giveElem(int hole) {//основное свойство кучи для вставки в нее элементов
        int tmp = array[hole];
        for (; hole > 0 && tmp < array[parent(hole)]; hole = parent(hole))
            array[hole] = array[parent(hole)];
        array[hole] = tmp;
    }
    void printHeap(String space, int n, boolean lefts) {//функция вывода кучи
        if (n < currentSize) {
            System.out.print(space);

            if (array[n] != -1)
                System.out.println("├─:" + array[n]);
            else
                System.out.println("├─:-");
            for (int i = 1; i < this.child; i++) {
                if (lefts)
                    printHeap(space + "|   ", this.Child(n, i), true);
                else
                    printHeap(space + "    ", this.Child(n, i), true);
            }
            if (lefts)
                printHeap(space + "|   ", this.Child(n, child), false);
            else
                printHeap(space + "    ", this.Child(n, child), false);
        }
    }
}