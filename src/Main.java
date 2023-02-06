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
        double A = (double)sc.nextInt();
        double B = (double)sc.nextInt();
        double C = (double)sc.nextInt();
        double D = (double)sc.nextInt();
        String answer = "";
        double p=(3*A*C-B*B)/(3*A*A);
        double q=((2*B*B*B-9*A*B*C+27*A*A*D))/(27*A*A*A);
        double s=(((q*q)/4)+(p*p*p)/27);
        double f;


        double discrim = 4*B*B - 12*A*C;
        double toch_exstrem_X1;
        double toch_exstrem_X2;
        int vetka = -1;
        if (discrim > 0){
            toch_exstrem_X1 = (-2*B + Math.sqrt(discrim))/(6*A);
            toch_exstrem_X2 = (-2*B - Math.sqrt(discrim))/(6*A);
            //System.out.println(toch_exstrem_X1 + " toch_exstrem_X1");
            //System.out.println(toch_exstrem_X2 + " toch_exstrem_X2");
            double f_x1 = A*Math.pow(toch_exstrem_X1, 3) + B*Math.pow(toch_exstrem_X1, 2) + C*Math.pow(toch_exstrem_X1, 1) + D;
            double f_x2 = A*Math.pow(toch_exstrem_X2, 3) + B*Math.pow(toch_exstrem_X2, 2) + C*Math.pow(toch_exstrem_X2, 1) + D;
            if (f_x1 * f_x2 < 0) vetka = 3;
            if (f_x1 * f_x2 == 0) vetka = 2;
        }
        else vetka = 1;

        System.out.println(vetka + " kornya:");
        System.out.println(s + " s:");
        System.out.println(p + " p:");
        System.out.println(q + " q:");
        System.out.println(A + " A:");
        System.out.println(B + " B:");
        System.out.println(C + " C:");
        System.out.println(D + " D:");


        if (q < 0){
            f = (Math.atan(Math.pow(-s,0.5)/(-q/2)));
            System.out.println(f + ": 1f");
        }
        if (q > 0){
            f = Math.atan(Math.pow(-s,0.5)/(-q/2)) + Math.PI;
            System.out.println(f + ": 2f");
        }
        else {
            f = Math.PI/2;
            System.out.println(f + ": 3f");
        }

        int x1, x2, x3;
        double x2i, x3i;

        if (s<0)
        {
            x1=(int)Math.round(2*Math.sqrt(-p/3)*Math.cos(f/3)-B/3*A);
            x2=(int)Math.round(2*Math.sqrt(-p/3)*Math.cos(f/3+(2*Math.PI)/3)-B/3*A);
            x3=(int)Math.round(2*Math.sqrt(-p/3)*Math.cos(f/3+(4*Math.PI)/3)-B/3*A);
            answer = x1 + " " + x2 + " " + x3;
        }
        else if (s>0)
        {
            x1=(int)(Math.cbrt(-q/2+Math.pow(s,0.5))+Math.cbrt(-q/2-(Math.pow(s,0.5)))-B/(3*A));
            answer = String.valueOf(x1);

        }
        else
        {
            x1=(int)Math.round(2*Math.cbrt(-q/2)-B/(3*A));
            x2=(int)Math.round(-1*Math.cbrt(-q/2)-B/(3*A));
            answer = x1 + " " + x2;
        }



        System.out.println(answer);



        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
