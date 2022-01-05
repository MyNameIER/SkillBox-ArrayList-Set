import java.util.*;

public class numberGenerator {
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
        TreeSet<String>arrN = new TreeSet<>(arrNumber);
        ArrayList<String> arrNum = new ArrayList<>(arrNumber);
        Collections.sort(arrNum);
         for (int i = 1_000_000; i <1_001_000; i++)
        {
            System.out.println(arrNum.get(i));
        }

        Scanner ad = new Scanner(System.in);
        for(;;)
        {
            System.out.println("Введите номер");
            String number = ad.nextLine();
            ad.nextLine();
            System.out.println("Как будем искать:" +
                    "1. прямой перебор;" +
                    "2. бинарный поиск;" +
                    "3.HasSet;" +
                    "4.TreeSet.");
            int id = ad.nextInt();

            switch (id) {
                case 1:
                    long start = System.currentTimeMillis();
                    boolean result = arrNum.contains(number);
                    long duration = System.currentTimeMillis() - start;
                    if (result) {
                        System.out.println("Номер есть в списке. " + "Время поиска: " + duration);
                    } else
                        System.out.println("Номера в списке нет. " + "Время поиска: " + duration);
                    break;
                case 2:
                    long start1 = System.currentTimeMillis();
                    int index = Collections.binarySearch(arrNum, number);
                    long duration1 = System.currentTimeMillis() - start1;
                    if (index > 0) {
                        System.out.println("Номер есть в списке. " + "Время поиска: " + duration1);
                    } else
                        System.out.println("Номера в списке нет. " + "Время поиска: " + duration1);
                    break;
                case 3:
                    long start2 = System.currentTimeMillis();
                    boolean has = arrNumber.contains(number);
                    long duration2 = System.currentTimeMillis() - start2;

                    if (has) {
                        System.out.println("Номер есть в списке. " + "Время поиска: " + duration2);
                    } else
                        System.out.println("Номера в списке нет. " + "Время поиска: " + duration2);
                    break;
                case 4:
                    long start3 = System.currentTimeMillis();
                    boolean tree = arrN.contains(number);
                    long duration3 = System.currentTimeMillis() - start3;
                    if (tree) {
                        System.out.println("Номер есть в списке. " + "Время поиска: " + duration3);
                    } else
                        System.out.println("Номера в списке нет. " + "Время поиска: " + duration3);
                    break;
            }
        }

    }
}



