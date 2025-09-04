
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Distinct {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String filename = s.nextLine();

        FileReader fr = new FileReader(filename);
        Scanner fs = new Scanner(fr);

        int size = fs.nextInt();
        int min = fs.nextInt();
        int num;

        int[] array = new int[size];
        array[0] = min;

        for (int i = 1; i < size; i++){
            num = fs.nextInt();
            if (num < min){
                min = num;
            }
            array[i] = num;
        }

        System.out.println();
        System.out.println("Min Number: " + min);
        System.out.println();

        int count = 0;
        int num_length;
        String spacing;
        boolean not_repeated = true;

        System.out.println("Number  Count");

        for (int i = 0; i < size; i++){
            num = array[i];
            for (int k = 0; k < size; k++){
                if (num == array[k]){
                    count++;
                }

                if (i >= k && count > 1){
                    not_repeated = false;
                }

            }

            num_length = String.valueOf(num).length();

            if (num_length == 1){
                spacing = "       ";
            } else if (num_length == 2){
                spacing = "      ";
            } else {
                spacing = "     ";
            }

            if (not_repeated){
                System.out.println(num + spacing + count);
            }

            count = 0;
            not_repeated = true;
        }

        fr.close();


    }
}
