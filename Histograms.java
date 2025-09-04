
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Histograms {
    public static void main(String[] args) throws IOException {


        Scanner s = new Scanner(System.in);

        System.out.print("Enter input file name: ");

        String filename = s.nextLine();

        FileReader fr = new FileReader(filename);
        Scanner fs = new Scanner(fr);

        System.out.println();
        System.out.println("===== Horizontal Histogram =====");

        int size = fs.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++){
            array[i] = fs.nextInt();
        }

        for (int i = 0; i < size; i++){
            System.out.print(array[i] + ": ");

            for (int k = 0; k < array[i]; k++){
                System.out.print("* ");
            }

            System.out.println();
        }

        System.out.println();
        verticalHistogram(array);

    }

    public static void verticalHistogram (int[] arr){

        System.out.println("===== Vertical Histogram =====");

        int max = arr[0];

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }

        for(int i = 0; i < max; i++){
            for(int k = 0; k < arr.length; k++){
                if (max - arr[k] > i){
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++){
            System.out.print("--");
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

}