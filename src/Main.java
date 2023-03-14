import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean rumNum1 = false,rumNum2 = false;
        int a = 0,b = 0,res = 0;
        int[] resArr = new int[3];
        String str,sign = null,ar = null,br = null;
        String[] Romnum1 = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] Romnum2 = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
        String [] str_arr = new String[0];
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        str_arr = str.split(" ");

        if ((str_arr.length != 3)){
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(1);
            return;
        }
        try {
            sign = str_arr[1];
            for (int i = 1; i <= 10; i++) {
                if (str_arr[0].equals(Romnum1[i])) {
                    a = i;
                    rumNum1 = true;
                    break;
                }
            }
            if (rumNum1 == false) {
                a = Integer.valueOf(str_arr[0]);
            }
            for (int i = 1; i <= 10; i++) {
                if (str_arr[2].equals(Romnum1[i])) {
                    b = i;
                    rumNum2 = true;
                    break;
                }
            }
            if (rumNum2 == false) {
                b = Integer.valueOf(str_arr[2]);
            }
        } catch (NumberFormatException e){
            System.out.println("Формат математической операции не удовлетворяет заданию - два целочисленных операнда и один оператор (+, -, /, *)");
            System.exit(1);
        }

        if((a > 10) || (b > 10) ){
            System.out.println("Число не может превышать 10");
            System.exit(1);
        }
        if((a < 1) || (b < 1) ){
            System.out.println("Число не может быть меньше 1");
            System.exit(1);
        }
        if (rumNum2 == false) {
            b = Integer.valueOf(str_arr[2]);
        }
        if (rumNum1 != rumNum2){
            System.out.println("Используются одновременно разные системы счисления");
            System.exit(1);
        }
        switch (sign){
            case "+" :
                res = a + b;
                break;
            case "-" :
                res = a - b;
                break;
            case "*" :
                res = a * b;
                break;
            case "/" :
                res = a / b;
                break;
            default:
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(1);
        }
        if((res <= 1)&&(rumNum1)){
            System.out.println("В римской системе нет отрицательных чисел и нуля");
            System.exit(1);
        }
        if(rumNum1 == false){
            System.out.println(res);
        } else {
            ar = Romnum1[res % 10]; //Еденицы
            br = Romnum2[res / 10]; //Десятки
            if (res / 10 == 10 ){
                System.out.println("C");
            } else System.out.println(br+ar);
        }
    }
}
