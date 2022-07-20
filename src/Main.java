import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;
import java.lang.Math;



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
        int delta_0 = B*B - 3*A*C;
        int delta_1 = 2*B*B*B - 9*A*B*C + 27*A*A*D;
        double delta = (Math.pow(delta_1,2) - 4*Math.pow(delta_0,3))/27*A*A;
        double CC_a = Math.pow(delta_1,2) - 4*Math.pow(delta_0,3);
        double CC_b = Math.pow(CC_a,1/2) + delta_1;
        double CC = Math.pow(CC_b/2, 1/3);
        double u = (-1 + Math.pow(-3,1/2))/2;
        double otvet[] = new double[3];
        double buf;
        for (int i = 0; i < 3; i++){
            buf = Math.pow(u,i)*CC;
            otvet[i] = -(B + Math.pow(u,i)*CC + delta_0/buf)/3*A;
        }

        System.out.println(delta_0);
        System.out.println(delta_1);
        System.out.println(delta);
        System.out.println(CC);
        System.out.println(u);
        System.out.println(otvet[0]);
        System.out.println(otvet[1]);
        System.out.println(otvet[2]);

        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
