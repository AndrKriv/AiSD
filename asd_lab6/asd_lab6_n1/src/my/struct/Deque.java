package my.struct;
public class Deque {
    //суть дека (или же двухсторонней очереди):
    //Определить дек можно как очередь с двумя сторонами, так и стек, имеющий два конца, т.е.
    //есть некоторое пространство, в которое можем добавлять что-то. в это что-то можно добавлять с 2 сторон,
    //далее по мере заполнения формируется заполняющееся пространство и мы можем брать оттуда элементы, как и в стеке,
    //т.е. только с краев множества, но может брать с любого края (как и добавлять)
    private int[] dequeArr;
    private int maxSize; //maxSize - максимальный размер
    private int front;
    private int back;
    public Deque(int maxSize) {//создание дека определенного размера
        this.maxSize = maxSize;
        dequeArr = new int[maxSize];
        back = -1;
        front = 0;
    }
    public void addFirst(int value)//добавление в начало
    {
        if (isFull())//проверка на заполненность
            System.out.println("Нет места в деке!");
        else {
            for (int i = ++back; i > 0; i--)
                dequeArr[i] = dequeArr[i - 1];
            dequeArr[0] = value;
        }
    }
    public void addLast(int value)//добавление в конец
    {
        if (isFull())//проверка на заполненность
            System.out.println("Нет места в деке!");
        else
            dequeArr[++back] = value;
    }
    public int DequeueFirst() {//удаление первого элемента дека
        if(isEmpty()) {
            System.out.println("Дек пуст!");
            return -1;
        }
        int temp = dequeArr[front]; // получаем первый элемент из очереди
        for (int i=0; i<back; i++) //смещение элементов
            dequeArr[i]=dequeArr[i+1];
        back--;
        return temp;
    }
    public int DequeueLast()//удаление последнего элемента дека
    {
        if(isEmpty()) {
            System.out.println("Дек пуст!");
            return -1;
        }
        return dequeArr[back--];
    }
    public int  getFirst(){//вывод первого элемента дека
        if(isEmpty()) {
            System.out.println("Дек пуст!");
            return -1;
        }
        return dequeArr[front];
    }
    public int getLast(){//вывод последнего элемента дека
        if(isEmpty()) {
            System.out.println("Дек пуст!");
            return -1;
        }
        return dequeArr[back];
    }
    public boolean isFull() {
        return (back == maxSize - 1);
    }//заполненное состояние

    public boolean isEmpty() {
        return (back == -1);
    }//пустое состояние
    public int getSize() {
        return back+1;
    }//размерность
}
