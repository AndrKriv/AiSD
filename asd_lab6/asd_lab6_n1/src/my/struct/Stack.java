package my.struct;
public class Stack {//определение работы стека и проверки на заполненность
    //суть стека:
    //последним пришёл — первым вышел, т.е. пусть у нас накапливается
    //стопка посуды, то если мы будем брать из этой стопки, то будем брать то, что сверху
    //а то что было сверху - пришло последним
    private int maxSize; //maxSize - максимальный размер
    private int[] stackArray;
    private int top;
    public Stack(int size) {
        this.maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void Push(int value)
    {
        if (isFull())
            System.out.println("Очередь заполнена, нельзя зайти! Попробуйте позже!");
        else
            stackArray[++top] = value;
    }
    public int delElem()
    {
        if (isEmpty()){
            System.out.println("Стек пуст!");
            return -1;
        }
        return stackArray[top--];
    }
    public int showLast()
    {
        if (isEmpty()) {
            System.out.println("Стек пуст!");
            return -1;
        }
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
