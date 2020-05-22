package my.struct;
public class Queue {
    //суть очереди:
    //первый пришёл — первый вышел
    //обычная очередь. как пример можно взть магазин, где
    //первый пришел на кассу, первый и ушел из этого магазина, а кто был последним
    //то ушел последним
    private int[] queueArr;
    private int maxSize; //maxSize - максимальный размер
    private int front;
    private int back;
    public Queue(int maxSize) {//задание очереди определенной размерности
        this.maxSize = maxSize;
        queueArr = new int[maxSize];
        back = -1;
        front = 0;
    }
    public void Enqueue(int value)//отправка в конец очереди. а если заполнено, то не добавляет
    {
        if(isFull())
            System.out.println("Нет места в очереди!");
        else {
            queueArr[++back] = value;
        }
    }
    public int Dequeue()//определение начального значения
    {
        if(isEmpty()) {
            System.out.println("Очередь пустая!");
            return -1;
        }
        else {
            int temp = queueArr[front]; // получаем первый элемент из очереди
            for (int i=0; i<back; i++) //смещение элементов
                queueArr[i]=queueArr[i+1];
            back--;
            return temp;
        }
    }
    public int  getFront(){//вывод первого элемента
        if (isEmpty()) {
            System.out.println("Очередь пустая!");
            return -1;
        }
        return queueArr[front];
    }
    public int getBack(){//вывод последнего элемента
        if (isEmpty()) {
            System.out.println("Очередь пустая!");
            return -1;
        }
        return queueArr[back];
    }
    public boolean isFull() {
        return (back == maxSize - 1);
    }//определение полной заполненности очереди
    public boolean isEmpty() {
        return (back == -1);
    }//определение отсутствия элментов в очереди
    public int getSize() {
        return back+1;
    }//возврат размерности
}
