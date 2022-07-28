import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;
import java.lang.Math;

//надо вычислить один действительный корень. он вроде всегда есть
//надо разделить програмно многочлен на многочлен и получится квадратное уравнение


public class Main {
    public static int[] mnoj_by_A(int A) {
        int Abc_A = Math.abs(A);
        boolean AA[] = new boolean[Abc_A+1];
        int AAA[] = new int[Abc_A];
        int count = 0;
        for (int i = 1; i <= Abc_A; i++){
            AA[i] = false;
            if (Abc_A % i == 0) {
                AA[i] = true;
                count++;
            }
        }
        int[] myArray = new int[count];
        int j = 0;
        for (int i = 1; i <= Abc_A; i++) {
            if (AA[i] == true) {
                myArray[j] = (int)Math.signum(A)*i;
                j++;
            }
        }
        return myArray;
    }
    public static void print(int A[]){
        int count = A.length;
         for(int i = 0; i < count; i++){
            System.out.println(A[i]);
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "INPUT.TXT";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        String answer = "";
        int dis, x = 0, cor_dis, x_1 = 0, x_2 = 0;
        dis = B*B - 4*A*C;
        cor_dis = (int)Math.sqrt(dis);
        if (D == 0) {
            if (dis == 0){
                x_1 = -B/2*A;
            }
            if (dis > 0){
                x_1 = (-B + cor_dis)/(2*A);
                x_2 = (-B - cor_dis)/(2*A);
            }

            if (x == x_1 || x == x_2) dis = 0;
            if (dis > 0) answer = String.valueOf(x) + ' ' + String.valueOf(x_1) + ' ' + String.valueOf(x_2);
            if (dis == 0) answer = String.valueOf(x) + ' ' + String.valueOf(x_1);

        } else{
            int A_mas[] = mnoj_by_A(A);
            print(A_mas);
            int B_mas[] = mnoj_by_A(B);
            print(B_mas);
            int int_count = A_mas.length*2+B_mas.length*2;
            int new_mas[] = new int[int_count];

            int ii = -1;
            int jj = -1;
            do{
                ii++;
                jj++;
                if (jj == A_mas.length) break;
                new_mas[ii] = A_mas[jj];

            }while(ii < A_mas.length);

            ii = A_mas.length-1;
            jj = -1;
            do{
                ii++;
                jj++;
                if (jj == A_mas.length) break;
                new_mas[ii] = -A_mas[jj];

            }while(ii < int_count-B_mas.length-B_mas.length);

            ii = A_mas.length*2-1;
            jj = -1;
            do{
                ii++;
                jj++;
                if (jj == B_mas.length) break;
                new_mas[ii] = B_mas[jj];

            }while(ii < int_count-B_mas.length);

            ii = A_mas.length*2+B_mas.length-1;
            jj = -1;
            do{
                ii++;
                jj++;
                if (jj == B_mas.length) break;
                new_mas[ii] = -B_mas[jj];

            }while(ii < int_count);

            System.out.println("------------");
            print(new_mas);
        }


        System.out.println(answer);

        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
