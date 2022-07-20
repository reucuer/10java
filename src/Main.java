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
    public static void bubbleSort(int[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
}
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "INPUT.TXT";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        double AA = sc.nextDouble();
        double A = sc.nextDouble()/AA;
        double B = sc.nextDouble()/AA;
        double C = sc.nextDouble()/AA;
        int[] x_mas = new int[3];
        int count = 0;
        String answer = "";
        double Q = (3*B - A*A)/9;
        double R = (9*A*B - 2*A*A*A - 27*C)/54;
        double S = Q*Q*Q + R*R;
        if (S < 0) {
            count = 3;
            double phi = Math.acos(R/Math.sqrt((-Q)*(-Q)*(-Q)))/3;
            x_mas[0] = (int)Math.round(2 * Math.sqrt(-1*Q)*Math.cos(phi) - A/3);
            x_mas[1] = (int)Math.round(2 * Math.sqrt(-1*Q)*Math.cos(phi+2*Math.PI/3) - A/3);
            x_mas[2] = (int)Math.round(2 * Math.sqrt(-1*Q)*Math.cos(phi-2*Math.PI/3) - A/3);
        }

        if (S > 0) {
            count = 1;
            double phi = (1/Math.cos(Math.abs(R)/Math.sqrt(Q*Q*Q)))/3;
            if (Q > 0){
                x_mas[0] = (int)Math.round(-2 * Math.signum(R)*Math.sqrt(Q)*Math.cosh(phi) - A/3);
            }
            if (Q < 0){
                x_mas[0] = (int)Math.round(-2 * Math.signum(R)*Math.sqrt(Q)*Math.sinh(phi) - A/3);
            }
            if (Q == 0){
                x_mas[0] = (int)Math.round(-1*Math.cbrt(C - A*A*A/27) - A/3);
            }
        }
        if (S == 0){
            count = 2;
            x_mas[0] = (int)(-2 * Math.pow(R, 1/3) - A/3);
            x_mas[0] = (int)(-2 * Math.signum(R)*Math.sqrt(Q) - A/3);
            //double d = -2 * Math.cbrt(R) - A/3;
            //System.out.println(R);
            //System.out.println(A);
            //System.out.println(A/3);
            //System.out.println(-2*Math.cbrt(R));
            //System.out.println(R);
            x_mas[1] = (int)Math.round(Math.cbrt(R) - A/3);
            x_mas[1] = (int)(Math.signum(R)*Math.sqrt(Q) - A/3);
            System.out.print(R+" ");
            System.out.println(Math.sqrt(Q));
            //System.out.println(Math.signum(R));

        }

        bubbleSort(x_mas);
        if (count == 3) answer = answer = x_mas[0] + " " + x_mas[1]+ " " + x_mas[2];
        if (count == 2) answer = x_mas[0] + " " + x_mas[1];
        if (count == 1) answer = Integer.toString(x_mas[0]);
        System.out.println(answer);




        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
