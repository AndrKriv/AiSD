package binary.tree;
//Формирование бинарного поискового дерево
public class BinTree {
    private Node root;
    static class Node {
        private   int key;
        private  Node left;
        private  Node right;
        Node(int key) {
            this.key = key;
            this.right =null;
            this.left =null;
        }
        public void print(String indent, String position, boolean last) {//вывод дерева
            System.out.print(indent);
            if (last){
                System.out.print("└─");
                indent += "  ";
            }
            else{
                System.out.print("├─");
                indent += "| ";
            }
            System.out.println(position);
            if( (left != null || right != null))
            {
                if (left != null)
                    left.print(indent, "L:"+left.key, false);
                else
                    System.out.println(indent+"├─"+"L:-");

                if (right != null)
                    right.print(indent, "R:"+right.key, true);
                else
                    System.out.println(indent+"└─"+"R:-");
            }
        }
        public int getKey(){
            return key;
        }
    }
    public void add(int value) {
        root = insert(root, value);
    } //функция добавления элемента
    private Node insert(Node current, int key) {
        if (current == null)
            return new Node(key);
        if (key < current.key)
            current.left = insert(current.left, key);
        else if (key > current.key)
            current.right = insert(current.right, key);
        else
            return current;

        return current;
    }
    private Node searchR(Node node, int key){
        if( node == null || key == node.key)
            return node;
        if (key < node.key)
            return searchR(node.left, key);
        else
            return searchR(node.right, key);
    }
    public Node search(int key){//Поиск по введенному ключу (ключ здесь и далее - элемент дерева)
        return searchR(root,key);

    }
    private Node rightDel(Node current, int key){//правое удаление
        if (current == null)
            return current;
        if (key < current.key)
            current.left = rightDel(current.left, key);
        else if (key > current.key)
            current.right = rightDel(current.right, key);
        else if (current.left != null && current.right != null) {
            current.key = minimum(current.right).key;
            current.right = rightDel(current.right, current.key);
        }
        else if (current.left != null)
            current = current.left;
        else if (current.right != null)
            current = current.right;
        else
            current = null;
        return current;
    }
    public void rightDeletion(int key){//Удаление(правое)
        root=rightDel(root,key);
    }
    private Node leftDel(Node current, int key){//левое удаление
        if (current == null)
            return current;
        if (key < current.key)
            current.left = leftDel(current.left, key);
        else if (key > current.key)
            current.right = leftDel(current.right, key);
        else if (current.left != null && current.right != null) {
            current.key = maximum(current.left).key;
            current.left = leftDel(current.left, current.key);
        }
        else if (current.left != null)
            current = current.left;
        else if (current.right != null)
            current = current.right;
        else
            current = null;
        return current;
    }
    public void leftDeletion(int key){//Удаление(левое)
        root=leftDel(root,key);
    }
    public Node maximum( Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }
    public Node minimum( Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }
    public String  symmetricalTraversal(Node node){ //Симметричный обход. Рекурсивно: левое поддерево, корень, правое поддерево.
        if (node != null)
            return symmetricalTraversal(node.left)+node.key+" "+symmetricalTraversal(node.right);
        return "";
    }
    public String  straightTraversal(Node node) { //Прямой обход. Рекурсивно: корень, левое поддерево, правое поддерево.
        if (node != null)
            return  node.key+" "+  straightTraversal(node.left)+straightTraversal(node.right);
        return "";
    }
    public String  reverseTraversal(Node node) {//Обратный обход. Рекурсивно: левое поддерево, правое поддерево, корень.
        if (node != null)
            return   reverseTraversal(node.left)+  reverseTraversal(node.right)+node.key+" ";
        return "";
    }
    public int depthR(Node node,int key){
        if (key != node.key) {

            if (key < node.key)
                return depthR(node.left, key) + 1;
            else
                return depthR(node.right, key) + 1;
        }
        return 0;
    }
    public int depth(int key){ //глубина(определение количества предков)
        if(search(key)!=null)
            return depthR(root,key);
        return -1;
    }
    private int heightR(Node node) {
        if (node != null)
            return Math.max(heightR(node.left), heightR(node.right)) + 1;
        else
            return -1;
    }
    public  int height(int key){//высота
        return heightR(search(key));
    }
    public int level(int key){ //уровень узла
        if(search(key)!=null)
            return heightR(root)-depth(key);
        return -1;
    }
    public void print()//вывод дерева
    {
        if(root!=null)
            root.print("", root.key+"", true);
        else System.out.println( "Дерево пустое!");
    }
    public Node getRoot(){
        return root;
    }
}