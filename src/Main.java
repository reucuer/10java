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
        //int t1 = w1 - p/w1;
        //int t2 = w2 - p/w2;
        //int t3 = w3 - p/w3;
        int Q = (A*A-3*B)/9;
        int R = (2*A*A*A-9*A*B+27*C)/54;
        String answer;
        if ((R*R) < (Q*Q*Q)) {
            double t = Math.acos(R / Math.sqrt(Q * Q * Q)) / 3;
            double x1 = -2*Math.sqrt(Q)*Math.cos(t)-A/3;
            double x2 = -2*Math.sqrt(Q)*Math.cos(t+(2*Math.PI/3))-A/3;
            double x3 = -2*Math.sqrt(Q)*Math.cos(t-(2*Math.PI/3))-A/3;
            answer = String.valueOf(x1) + String.valueOf(x2) + String.valueOf(x3);
        }
        else{
            double BB;
            double AA = -Math.signum(R)*Math.pow(Math.abs(R)+Math.sqrt(R*R-Q*Q*Q),1/3);
            if (AA != 0) BB = Q/AA;
            else BB = 0;
            double x1=(AA+BB)-A/3;
            if (AA == BB) {
                double x2= -AA-A/3;
                answer = String.valueOf(x1) + String.valueOf(x2);
            }
            else answer = String.valueOf(x1);

        }



        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
