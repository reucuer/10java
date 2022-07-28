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
        }
        if (x == x_1 || x == x_2) dis = 0;

        if (dis > 0) answer = String.valueOf(x) + ' ' + String.valueOf(x_1) + ' ' + String.valueOf(x_2);
        if (dis == 0) answer = String.valueOf(x) + ' ' + String.valueOf(x_1);
        System.out.println(answer);

        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
