package Laba1;

import java.util.Arrays;
import java.util.Scanner;

public class laba1 {

    public static int RtoA (String str) {
        int[] arab = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] rim = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "DM", "M"};
        int result = 0;
        for (int i = arab.length - 1; i >= 0; i--) {
            while (str.indexOf(rim[i]) == 0) {
                result += arab[i];
                str = str.substring(rim[i].length());
            }
        }
        return result;
    }

    public static int[] vvod() {
        Scanner in = new Scanner (System.in);
        System.out.print("Введите размер массива: ");
        int length = in.nextInt();

        int[] arr = new int[length];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < length; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static void vivod(int[] arr) {
        System.out.println("Элементы массива: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    public static int[] AddArr (int[] a, int[] b) {
        int maxlen = Math.max(a.length, b.length);
        int[] result = new int[maxlen + 1];

        int carry = 0;
        for (int i = 0; i < maxlen; i++) {
            int sum = carry;
            if (i < a.length) {
                sum += a[a.length - 1 - i];
            }
            if (i < b.length) {
                sum += b[b.length - 1 - i];
            }
            result[maxlen - i] = sum % 10;
            carry = sum / 10;
        }

        result[0] = carry;

        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Введите римское число: ");
        String str = in.next();
        System.out.println("Соответствующее арабское число:");
        System.out.println(RtoA(str));

        int[] a = vvod();
        int[] b = vvod();
        int[] result = AddArr(a, b);
        System.out.println("Два числа:");
        vivod(a);
        vivod(b);
        System.out.println("Результат сложения:");
        vivod(result);

    }
}