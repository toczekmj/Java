import java.math.BigDecimal;
import java.rmi.MarshalException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.jar.Attributes;

public class Main {
    public static void main(String[] args) {
        String temp = "";

        if(args.length > 0)
          temp = args[0];

        switch (temp) {
            case "-p":
                System.out.println(Program.pierwiastekNtegoStopnia(Double.parseDouble(args[1]), Integer.parseInt(args[2])));
                break;
            case "-s":
                System.out.println(Program.sredniaGeometryczna(args));
                break;
            case "-n":
                System.out.println(Program.NWD(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                break;
            default:
                System.out.println(" -p {value} {n-th root} - obliczanie n-tego pierwiastka z liczby\n -s {value1} {value2} ... {valueN} - obliczanie sredniej geometrycznej z podanych wartosci\n -n {value1} {value2} - obliczanie NWD dwoch liczb");
        }



    }

    private static class Program{
        public static double pierwiastekNtegoStopnia(double a, int n){

            double xPre = Math.random() % 10;
            double e = 0.000000001;
            double delX = 2147483647;
            double xK = 0.0;
            while (delX > e){
                xK = ((n-1.0)*xPre + (double)a / Math.pow(xPre, n-1))/(double)n;
                delX = Math.abs(xK - xPre);
                xPre = xK;
            }
            return xK;
        }

        public static double sredniaGeometryczna(String[] args){
            double sum = 1;

            for(int i = 1; i < args.length; i++){
                sum *= Double.parseDouble(args[i]);
            }
            return pierwiastekNtegoStopnia(sum, args.length-1);
        }

        public static int NWD(int a, int b){
            if(a != b)
                return NWD(a>b ? a-b : a, b > a ? b-a:b);
            return a;
        }
    }

}

