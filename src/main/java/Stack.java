import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Stack {
//    protected List<Integer> stack; // для наследников
//    List<Integer> stack; // внутри пакета
//    public List<Integer> stack; // везде
//  private List<Integer> stack; //внутри класса
    final private List<Integer> list; //
    final private String name;

    public Stack(List<Integer> list, String name) {
        this.list = new LinkedList<>(list);
        this.name = name;
    }

    public Stack(String name) { // перегрузка метода
        this.list = new LinkedList<>();
        this.name = name;
    }

    ////геттеры и сеттеры
//    public List<Integer> getStack() {
//        return stack;
//    }
//
//    public void setStack(List<Integer> stack) {
//        this.stack = stack;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    public void rot() {
        if (isEmpty())
            return;
        int value = list.get(0);
        list.remove(0);
        list.add(value);
    }

    public void rev_rot() {
        if (isEmpty())
            return;
        int value = list.get(list.size() - 1) ;
        list.remove(list.size() - 1);
        list.add(0, value);
    }

    public void swap() {
        if (list.size() < 2)
            return;
        int value = list.get(0) ;
        list.set(0, list.get(1));
        list.set(1, value);
    }

    public void push(Stack dest_stack){
        if (isEmpty())
            return;
        int value = list.get(0);
        list.remove(0);
        dest_stack.insert(value);
    }

    private void insert(int value){
        list.add(0, value);
    }

    public boolean isEmpty(){
        return (list.size() == 0);
    }

    public boolean isSorted(){
        if (isEmpty())
            return true;

        Iterator<Integer> iterator = list.iterator();

        int prev = iterator.next();
        int next;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next < prev)
                return false;
            prev = next;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Stack " + name + "\n" + list.toString();
    }
}
