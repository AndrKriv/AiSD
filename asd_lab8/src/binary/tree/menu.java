package binary.tree;
import java.util.Scanner;
class main {
    public static void main(String[] args) throws InterruptedException {
        BinTree bTr = new BinTree();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("<------------------------------>");
            System.out.println("Выбрать пункт:");
            System.out.println("\t1. Вывод дерева");
            System.out.println("\t2. Добавление узла");
            System.out.println("\t3. Поиск узла");
            System.out.println("\t4. Удаление (левое) узла");
            System.out.println("\t5. Удаление (правое) узла");
            System.out.println("\t6. Прямой обход дерева");
            System.out.println("\t7. Обратный обход дерева");
            System.out.println("\t8. Симметричный обход дерева");
            System.out.println("\t9. Определение глубины");
            System.out.println("\t10. Определение высоты");
            System.out.println("\t11. Определение уровня узла");
            System.out.println("\t12. Выход из программы");
            System.out.println("<------------------------------>");
            switch (sc.nextInt()){
                case 1:
                    bTr.print();
                    break;
                case 2:
                    System.out.println("Введите ключ:");
                    bTr.add(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Введите ключ:");
                    BinTree.Node node= bTr.search(sc.nextInt());
                    if(node==null)
                        System.out.println("Узел не найден!");
                    else
                        node.print("",node.getKey()+"",true);
                    break;
                case 4:
                    System.out.println("Введите ключ:");
                    bTr.leftDeletion(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Введите ключ:");
                    bTr.rightDeletion(sc.nextInt());
                    break;
                case 6:
                    System.out.println( bTr.straightTraversal(bTr.getRoot()));
                    break;
                case 7:
                    System.out.println( bTr.reverseTraversal(bTr.getRoot()));
                    break;
                case 8:
                    System.out.println( bTr.symmetricalTraversal(bTr.getRoot()));
                    break;
                case 9:
                    System.out.println("Введите ключ:");
                    int depth=bTr.depth(sc.nextInt());
                    if(depth==-1)
                        System.out.println("Узел не найден!");
                    else System.out.println(depth);
                    break;
                case 10:
                    System.out.println("Введите ключ:");
                    int height= bTr.height(sc.nextInt());
                    if(height==-1)
                        System.out.println("Узел не найден!");
                    else System.out.println(height);
                    break;
                case 11:
                    System.out.println("Введите ключ:");
                    int level=bTr.level(sc.nextInt());
                    if(level==-1)
                        System.out.println("Узел не найден!");
                    else System.out.println(level);
                    break;
                case 12:
                    System.out.println("Выходим из программы...");
                    Thread.sleep(1000);
                    System.exit(1);
                    break;
            }
        }
    }
}