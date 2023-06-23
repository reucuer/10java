import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;
import static java.lang.System.out;




public class Main {
    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "INPUT.TXT";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        double A = sc.nextDouble();
        double B = sc.nextDouble();
        double C = sc.nextDouble();
        double D = sc.nextDouble();
        String answer = "";
        double p =(3*A*C-B*B)/(3*A*A);
        double q=(2*B*B*B-9*A*B*C+27*A*A*D)/(27*A*A*A);
        double discriminant = (((q*q)/4)+(p*p*p)/27);
        double phi = 0;
        //int[] Ar;
        ArrayList<Integer> integers = new ArrayList<Integer>();


        //System.out.println(cor_discr);
        System.out.println(discriminant);
        if (q < 0){
            phi = Math.atan(-1*Math.sqrt(-discriminant)/(q/2));
            System.out.println("M");
        }
        if (q > 0){

            phi = Math.atan(-1*Math.sqrt(-discriminant)/(q/2)) + Math.PI;
            System.out.println("D: = ");
        }
        if (q == 0){
            phi = Math.PI/2;
            System.out.println("L:");
        }
        if(discriminant == 0){


            int x1 = (int)Math.round(2*Math.pow(-q/2, 1/3) - B/(3*A));
            int x2 = (int)Math.round(-1*Math.pow(-q/2, 1/3) - B/(3*A));
                answer = x1 + " " + x2;
            int[] Ar = {x1,x2};
            integers.add(x1);
            integers.add(x2);


        }

        if(discriminant > 0){
            double y1 = Math.cbrt(-q/2 + Math.sqrt(discriminant)) + Math.cbrt(-q/2 - Math.sqrt(discriminant));
            int x1 = (int)Math.round(y1 - B/(3*A));
            int[] Ar = {x1};
            integers.add(x1);

        }
        if(discriminant < 0){

            double y1 = 2*Math.sqrt(-p/3)*Math.cos(phi/3);
            double y2 = 2*Math.sqrt(-p/3)*Math.cos(phi/3+ 2*Math.PI/3);
            double y3 = 2*Math.sqrt(-p/3)*Math.cos(phi/3+ 4*Math.PI/3);

            int x1 = (int)Math.round(y1 - B/(3*A));
            int x2 = (int)Math.round(y2 - B/(3*A));
            int x3 = (int)Math.round(y3 - B/(3*A));
            answer = x1 + " " + x2 + " " + x3;
            int[] Ar = {x1,x2,x3};
            integers.add(x1);
            integers.add(x2);
            integers.add(x3);

        }
        int []dsf = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            dsf[i] = integers.get(i);
        }

        bubbleSort(dsf);

        if(discriminant < 0) {
            answer = dsf[0] + " " + dsf[1] + " " + dsf[2];
        }
        if(discriminant == 0) {
            answer = dsf[0] + " " + dsf[1];
        }
        if(discriminant > 0) {
            answer = String.valueOf(dsf[0]);
        }
        System.out.println(answer);


        FileWriter writerS = new FileWriter("OUTPUT.TXT", false);
        writerS.write(String.valueOf(answer));
        writerS.flush();
    }
}
