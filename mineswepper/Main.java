import java.util.*;;

public class Main {
    public static void main(String[] args) {
        int row;
        int col;
        Scanner scan = new Scanner(System.in);

        System.out.println("Satır Sayısı Giriniz : ");
        row = scan.nextInt();

        System.out.println("Sütun Sayısı Giriniz : ");
        col = scan.nextInt();

        int array[][] = new int[row][col];

        Minesweeper mine = new Minesweeper(row, col);

        mine.run();

    }
}
