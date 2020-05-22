package my.dishes;

import java.util.Random;

public class DishWasher {
    private Queue firstQ;
    private Queue secondQ;
    DishWasher(int Size){//создание посудомойки с 2 очередями равного размера
        int n=Size/2;
        firstQ= new Queue(n);
        secondQ=new Queue(Size-n);
    }
    public void putDirty(int value)
    {   if(value!=-1) {
        Random rand = new Random();
        if (!firstQ.isFull() && !secondQ.isFull())//Если две очереди свободны, то тарелку поставим в рандомную
            if (rand.nextInt(2) == 0)
                firstQ.Enqueue(value);
            else
                secondQ.Enqueue(value);
        else if (!firstQ.isFull())//иначе в свободную
            firstQ.Enqueue(value);
        else if (!secondQ.isFull())
            secondQ.Enqueue(value);
    }
    }
    public int[] returnClean()
    {
        int[] result ={-1,-1};//-1 значит нет посуды в очереди
        if(!firstQ.isEmpty())
            result[0]=firstQ.Dequeue();
        if(!secondQ.isEmpty())
            result[1]=secondQ.Dequeue();
        return result;
    }
    public void  outPut(){
        if(!firstQ.isEmpty()||!secondQ.isEmpty()) {
            System.out.println("\t---Машина---");
            if (!firstQ.isEmpty()) {
                System.out.println("---Первая дорожка---");
                firstQ.outPut();
            }
            if (!secondQ.isEmpty()) {
                System.out.println("---Вторая дорожка---");
                secondQ.outPut();
            }
        }

    }
}