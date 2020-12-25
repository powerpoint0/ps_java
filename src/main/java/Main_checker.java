import java.util.*;

public class Main_checker {
    static final String RA = "ra";

    static List<Integer> integers = new ArrayList<>();
    static List<String> commands = new ArrayList<>();
    static Stack stack_a;
    static Stack stack_b;

    public static void main(String[] args) {

        try {
            pars_args(args);
            read_commands();

            stack_a = new Stack(integers, "a");
            stack_b = new Stack("b");
            System.out.println(stack_a);
            System.out.println(stack_b);


            applyCommand();

            System.out.println(stack_a);
            System.out.println(stack_b);

            if (!stack_a.isSorted())
                throw new RuntimeException("Stack_a is not sorted");

            if (!stack_b.isEmpty())
                throw new RuntimeException("Stack_b is not empty");

            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    private static void applyCommand() {
        for (String cmd : commands) {
            if (cmd.equals("ra"))
                stack_a.rot();
            else if (cmd.equals("rb"))
                stack_b.rot();
            else if (cmd.equals("rr")) {
                stack_a.rot();
                stack_b.rot();
            } else if (cmd.equals("pb"))
                stack_a.push(stack_b);
            else if (cmd.equals("pa"))
                stack_b.push(stack_a);
            else if (cmd.equals("sa"))
                stack_a.swap();
            else if (cmd.equals("sb"))
                stack_b.swap();
            else if (cmd.equals("ss")) {
                stack_a.swap();
                stack_b.swap();
            } else if (cmd.equals("rra"))
                stack_a.rev_rot();
            else if (cmd.equals("rrb")) {
                stack_b.rev_rot();
            } else if (cmd.equals("rrr")) {
                stack_a.rev_rot();
                stack_b.rev_rot();
            }
        }
    }


    private static void pars_args(String[] args) {

//        String[] tmp = {"1 1    2   3   4", "5", "6 7"};
        for (String s : args) {
            String str[] = s.split(" ");
            for (int i = 0; i < str.length; i++) {
                if (!"".equals(str[i])) {
                    integers.add(Integer.valueOf(str[i]));
                }
            }
        }

//        integers.add(7);
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        integers.add(5);
//        integers.add(6);

        Set<Integer> set = new HashSet<>(integers);
        if (integers.size() != set.size())
            throw new RuntimeException("Error in numbers");
    }


    private static void read_commands() {
//        commands.add("ra");
//        commands.add("ra");
//        commands.add("pb");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "ra" :
                case "rb" :
                case "rr" :
                case "rra" :
                case "rrb" :
                case "rrr" :
                case "pa" :
                case "pb" :
                case "sa" :
                case "sb" :
                case "ss" :
                    commands.add(cmd);
                    break;
                default:
                    throw new RuntimeException("Error in string " + cmd);
            }
        }

    }

}


//1.считыв данных и запись в массив интов
//2.считыв команд
//3.исполнение команд,написать команды
//4.проверка сортировки
