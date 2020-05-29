package del;
import java.util.Scanner;
public class main {
        public static void main(String[] args) throws InterruptedException {
            tree bTr = new tree();
            //Найти высоту дерева h и удалить (правым удалением) среднюю по значению из вершин на уровне [h/2],
            // у которых высота левого поддерева равна высоте правого поддерева.
            // Выполнить прямой (левый) обход полученного дерева.
            //Сформируем начальное дерево (для более легкого восприятия построено под условие варианта)
            bTr.add(6);
            bTr.add(2);
            bTr.add(11);
            bTr.add(1);
            bTr.add(30);
            bTr.add(3);
            bTr.add(9);
            //---------
            Scanner sc=new Scanner(System.in);
            while (true){
                System.out.println("<------------------------------>");
                System.out.println("Выбрать пункт:");
                System.out.println("\t1. Добавление узла");
                System.out.println("\t2. Вывод дерева");
                System.out.println("\t3. Поиск узла");
                System.out.println("\t4. Определение глубины");
                System.out.println("\t5. Определение высоты");
                System.out.println("\t6. Определение уровня узла");
                System.out.println("\t7. Условие задания №2");
                System.out.println("\t8. Выход из программы");
                System.out.println("<------------------------------>");
                switch (sc.nextInt()){
                    case 1:
                        System.out.println("Введите ключ:");
                        bTr.add(sc.nextInt());

                        break;
                    case 2:
                        bTr.print();
                        break;
                    case 3:
                        System.out.println("Введите ключ:");
                        tree.Node node= bTr.search(sc.nextInt());
                        if(node==null)
                            System.out.println("Узел не найден!");
                        else
                            node.print("",node.getKey()+"",true);
                        break;
                    case 4:
                        System.out.println("Введите ключ:");
                        int depth=bTr.depth(sc.nextInt());
                        if(depth==-1)
                            System.out.println("Узел не найден!");
                        else System.out.println(depth);
                        break;
                    case 5:
                        System.out.println("Введите ключ:");
                        int height= bTr.height(sc.nextInt());
                        if(height==-1)
                            System.out.println("Узел не найден!");
                        else System.out.println(height);
                        break;
                    case 6:
                        System.out.println("Введите ключ:");
                        int level=bTr.level(sc.nextInt());
                        if(level==-1)
                            System.out.println("Узел не найден!");
                        else System.out.println(level);
                        break;
                    case 7:
                        int plus=1;
                        int hight = bTr.getNodeHeight(bTr.getRoot());
                        System.out.println("Высота: "+hight);//определим высоту дерева
                        int center=(int)hight/2;//найдем центр дерева
                        System.out.println("Центр найден: "+center);
                        try{
                        if(bTr.getNodeHeight(bTr.searchR(bTr.getRoot(), plus).getLeft()) == bTr.getNodeHeight(bTr.searchR(bTr.getRoot(), plus).getRight()))
                            {//проверка на то, равны ли правая и левая ветвь дерева
                            //если выполняется
                        bTr.rightDeletion(center);//то удаляем центральный (правый) элемент
                                System.out.println("Удаление прошло успешно!");
                        System.out.println( "Обход: "+bTr.straightTraversal(bTr.getRoot()));//прямой (левый) обход полученного дерева
                            }
                        }
                        catch (NullPointerException e){
                            System.out.println("Возникла ошибка: "+e.getMessage()+"-pointer Exception!!!");}//проверка на отсутствие правого эоемента (удален или не добавлен)
                        break;
                    case 8:
                        System.out.println("Выходим из программы...");
                        Thread.sleep(1000);
                        System.exit(1);
                        break;
                }
            }
        }
    }