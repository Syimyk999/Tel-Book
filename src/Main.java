import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String NAME_REGAX = "[А-я]+";
    private static final String NUM_REGAX = ("\\d{12}|\\d{9}");
    private static Map<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) {
//        Map<String, Integer> nameAge = new HashMap<>();
//        nameAge.put("Vasya ", 24);
//        nameAge.put("Sasha ", 31);
//        nameAge.put("Petya ", 34);
//        System.out.println(nameAge.get("Sasha "));
//
//        for (Map.Entry<String, Integer> entry : nameAge.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        Map<String, Set<String>> nameTodos = new HashMap<>();
//        Set<String> todosPetya = new TreeSet<>();
//        todosPetya.add("Купит молока ");
//        todosPetya.add("Сходить гораж ");
//        nameTodos.put("Петя", todosPetya);
//
//        Set<String> todosSasha = new TreeSet<>();
//        todosSasha.add("Купить акции ");
//        todosSasha.add("Купить крипту ");
//        nameTodos.put("Саша", todosSasha);

//       for (Map.Entry<String, Set<String>> entry : nameTodos.entrySet()) {
//           String name = entry.getKey();;
//           System.out.println(name);
//           for (String todo : entry.getValue()) {
//               System.out.println("\t" + todo);
//           }
//        boolean isContains = false;
//        for (Map.Entry<String, Set<String>> entry : nameTodos.entrySet()) {
//            for (String val : entry.getValue()) {
//                if (val.equals("Купить акции1 ")) {
//                    System.out.println(val + "содержиться в делах " + entry.getKey());
//                    isContains = true;
//                }
//            }
//        }
//        if (!isContains) {
//            System.out.println("Такого значение нет в списке ");
//        }
        System.out.println("\t\t\t Добро пожаловать в программу подобной тел-книгу " +
                "\nПрограмма может добавлять номера или печпть сахранненые номера командой 'List'\n");
        while (true) {
            System.out.println("Введите имя или ваш номер или команду: 'exit', 'print'");
            String input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Всего доброго! ");
                return;
            } else if (input.equalsIgnoreCase("print")) {
                print();

            } else if (input.matches(NAME_REGAX)) {
                addByName(input);

            } else if (input.replaceAll("\\D+", "").matches(NUM_REGAX)) {
                addByNum(input.replaceAll("\\D+", ""));

            } else {
                System.out.println("Неверная команда: " + input + ".Попробуйту еще раз!");

            }
        }
    }
    public static void addByNum(String num) {
        if (num.length() >= 12) {
            num = num.substring(3);
        }
        if (phoneBook.containsValue(num)) {
            System.out.println("Номер " + num + " уже есть у другого абанента!");
            return;
        }
        System.out.println("Введите имя абанента для номера " + num);
        String name = new Scanner(System.in).nextLine();
        if (!name.matches(NAME_REGAX)) {
            System.out.println("Это не имя ");
            return;
        }
        if (phoneBook.containsKey(name)) {
            System.out.println("Абонент с именем " + name + " уже существует ");
            return;
        }
        phoneBook.put(name, num);
        System.out.println("Абанент " + name + " с номером " + num + " успешно добавлено!");

    }

    public static void addByName(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println("Абанент " + name + " уже есть в списке ");
            return;
        }
        System.out.println("Введите номер для абанента " + name);
        String num = new Scanner(System.in).nextLine();
        num = num.replaceAll("\\D+", "");
        if (!num.matches(NUM_REGAX)) {
            System.out.println("Это не номер");
            return;
        }
        if (num.length() == 12) {
            num = num.substring(3);
        }
        if (phoneBook.containsValue(num)) {
            System.out.println("Номер " + num + " уже есть другого абанента ");
            return;
        }
        phoneBook.put(name, num);
        System.out.println("Абанент " + name + " с номером " + num + " успешно добавлено!");
    }

    public static void print() {
        if (phoneBook.isEmpty()) {
            System.out.println("Нет абонента ");
            return;
        }
        for (Map.Entry<String, String> contact : phoneBook.entrySet()) {
            System.out.println("Абанент: " + contact.getKey() + " номер: " + contact.getValue());


            }
        }
    }






