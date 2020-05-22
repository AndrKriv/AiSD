package my.dishes;
public class Table {
    private Stack stack;
    Table(int n){//создание стола посредством стека
        stack=new Stack(n);
    }
    public void putDirty(int dishes)
    {   if(dishes!=-1)
        stack.Push(dishes);
    }
    public int returnDirty()
    {
        if(!stack.isEmpty())
            return stack.Pop();

        return -1;
    }
    public void outPut(){
        if(!stack.isEmpty()) {
            System.out.println("\t---Стол---");
            stack.outPut();
        }
    }
}