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
        double B1 = B/A;
        double B2 = C/A;
        double B3 = D/A;
        double p = (-1*B1*B1)/3 + B2;
        double q = 2*B1*B1*B1/27 - B1*B2/3 + B3;
        double delta = -4*B*B*B*D+B*B*C*C -4*A*C*C*C+18*A*B*C*D-27*A*A*D*D;
        double S = q*q/4 + p*p*p/27;
        double m = -1*q/2;
        double n = S;
        double y = Math.cbrt(m+Math.sqrt(n))+Math.cbrt(m-Math.sqrt(n));
        double y1 = 2*Math.cbrt(-q/2);
        double y2 = Math.cbrt(-q/2);
        double x = y - B1/3;

        if (delta > 0) answer = "tri_kornya" + '\n' + x + '\n' + x1;
        else if (delta < 0) answer = "odin_koreny" + '\n' + x;
        else answer = "koreny_kratnosty_3" + '\n' + x;



        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
