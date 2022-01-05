import java.util.*;

public class newNumberGenerator {
    public static void main(String[] args) {
        String[] letter = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        Arrays.sort(letter);
        HashSet<String> arrNumber = new HashSet<>();

        for (int i = 111; i <= 999; i += 111) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            arrNumber.add(String.format("%s%03d%s%s%d", a1, i, a2, a3, reg));
                        }
                    }
                }
            }
        }
        ArrayList<String> arrNum = new ArrayList<>(arrNumber);
        Collections.sort(arrNum);

        for (int i = 3_000_000; i <3_001_000; i++)
        {
            System.out.println(arrNum.get(i));
        }

        Scanner ad = new Scanner(System.in);
        System.out.println();
        System.out.println("Введите номер");
        String number = ad.nextLine();
        enumeration(arrNum,number);
        binary(arrNum,number);
        tree(arrNum,number);
        has(arrNum,number);
    }
    public static void enumeration (ArrayList<String> arrNum,String number){
        System.out.println("Прямой поиск.");
        long start = System.currentTimeMillis();
        boolean result = arrNum.contains(number);
        long duration = System.currentTimeMillis() - start;
        if (result) {
            System.out.println("Номер есть в списке. " + "Время поиска: " + duration);
        } else
            System.out.println("Номера в списке нет. " + "Время поиска: " + duration);
    }

    public static void binary (ArrayList<String> arrNum,String number){
        System.out.println("Бинарный поиск");
        long start1 = System.currentTimeMillis();
        int index = Collections.binarySearch(arrNum, number);
        long duration1 = System.currentTimeMillis() - start1;
        if (index > 0) {
            System.out.println("Номер есть в списке. " + "Время поиска: " + duration1);
        } else
            System.out.println("Номера в списке нет. " + "Время поиска: " + duration1);
    }

    public static void tree (ArrayList<String> arrNum,String number) {
        System.out.println("TreeSet");
        TreeSet<String> arrN = new TreeSet<>(arrNum);
        long start3 = System.currentTimeMillis();
        boolean tree = arrN.contains(number);
        long duration3 = System.currentTimeMillis() - start3;
        if (tree) {
            System.out.println("Номер есть в списке. " + "Время поиска: " + duration3);
        } else
            System.out.println("Номера в списке нет. " + "Время поиска: " + duration3);
    }

    public static void has (ArrayList<String> arrNum,String number) {
        System.out.println("HashSet");
        HashSet<String> arrNumber = new HashSet<>(arrNum);
        long start2 = System.currentTimeMillis();
        boolean has = arrNumber.contains(number);
        long duration2 = System.currentTimeMillis() - start2;

        if (has) {
            System.out.println("Номер есть в списке. " + "Время поиска: " + duration2);
        } else
            System.out.println("Номера в списке нет. " + "Время поиска: " + duration2);
    }
}
