package my.struct;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n;//ввод пунктов списка
        do {
            System.out.println("0: Выйти");
            System.out.println("1: Стек");
            System.out.println("2: Очередь");
            System.out.println("3: Дек");
            switch (scan.nextInt()) {
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    int i = 0;
                    System.out.println("Размер стека:");
                    n=scan.nextInt();
                    if (n<0) {
                        System.out.println("Вы ввели отрицательно значение!");
                        break;
                    }
                    Stack stack = new Stack(n);
                    do {
                        System.out.println("0: Выйти");
                        System.out.println("1: Добавить элемент");
                        System.out.println("2: Удалить элемент");
                        System.out.println("3: Вывести верхний элемент");

                        switch (scan.nextInt()) {
                            case 0:
                                i = 1;
                                break;
                            case 1:
                                stack.Push(scan.nextInt());
                                break;
                            case 2:
                                System.out.println(stack.delElem());
                                break;
                            case 3:
                                System.out.println(stack.showLast());
                                break;
                        }
                    }
                    while (i == 0);
                    break;
                case 2:
                    i = 0;
                    System.out.println("Размер очереди:");
                    n=scan.nextInt();//Размер очереди
                    if (n<0) {
                        System.out.println("Размер очереди не может быть отрицательным!");
                        break;
                    }
                    Queue queue = new Queue(n);//пункты для работы с очередью
                    do {
                        System.out.println("0: Выйти");
                        System.out.println("1: Добавить элемент");
                        System.out.println("2: Удалить элемент");
                        System.out.println("3: Вывести первый элемент");
                        System.out.println("4: Вывести последний элемент");
                        switch (scan.nextInt()) {
                            case 0:
                                i = 1;
                                break;
                            case 1:
                                queue.Enqueue(scan.nextInt());
                                break;
                            case 2:
                                System.out.println(queue.Dequeue());
                                break;
                            case 3:
                                System.out.println(queue.getFront());
                                break;
                            case 4:
                                System.out.println(queue.getBack());
                                break;
                        }
                    }
                    while (i == 0);
                case 3:
                    i = 0;
                    System.out.println("Размер дека:");//определение размерности дека
                    n=scan.nextInt();
                    if (n<0) {
                        System.out.println("Вы ввели отрицательно значение!");
                        break;
                    }
                    Deque deque = new Deque(n);//пункты для работы с деком
                    do {
                        System.out.println("0: Выйти");
                        System.out.println("1: Добавить элемент в начало");
                        System.out.println("2: Добавить элемент в конец");
                        System.out.println("3: Удалить первый элемент");
                        System.out.println("4: Удалить последний элемент");
                        System.out.println("5: Вывести первый элемент");
                        System.out.println("6: Вывести последний элемент");
                        switch (scan.nextInt()) {
                            case 0:
                                i = 1;
                                break;
                            case 1:
                                deque.addFirst(scan.nextInt());
                                break;
                            case 2:
                                deque.addLast(scan.nextInt());
                                break;
                            case 3:
                                deque.DequeueFirst();
                                break;
                            case 4:
                                deque.DequeueLast();
                                break;
                            case 5:
                                System.out.println(deque.getFirst());
                                break;
                            case 6:
                                System.out.println(deque.getLast());
                                break;
                        }
                    }
                    while (i == 0);
                    break;
            }
        }while (true);
    }
}
