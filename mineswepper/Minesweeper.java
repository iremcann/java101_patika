import java.util.*;

/**
 * Minesweeper
 */
public class Minesweeper {
    int rowN;
    int colN;
    int mine_number;
    String [][] game_array;
    String [][] mine_array;
    boolean isTrue = true;
    int choice_r;
    int choice_c;
    int count;

    Minesweeper(int row, int col){
        this.rowN = row;
        this.colN = col;
        this.game_array = new String [row][col];
        this.mine_array = new String [row][col];
        this.mine_number = (row*col)/4;
    }

    void mine_array(){
        for(int i=0; i<rowN; i++){
            for(int j=0; j<colN; j++){
                game_array[i][j] = "-";
                mine_array[i][j] = "-";
            }
        }
    }

    void find_random(){
        Random r = new Random();
        for(int i=0; i<this.mine_number; i++){
            int n1 = r.nextInt(this.rowN);
            int n2 = r.nextInt(this.colN);
            if(!this.mine_array[n1][n2].equals("*")){
                this.mine_array[n1][n2] = "*";
            }
        }
    }

    void print_mine_array(){
        System.out.println("Mayınların Konumu : ");

        find_random();

        for(int i=0; i<this.rowN; i++){
            for(int j=0; j<this.colN; j++){
                if(this.mine_array[i][j] != "*"){
                    this.mine_array[i][j] = "-";
                }
                System.out.print(this.mine_array[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("==================================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeliniz !");
    }

    void print_game_array(){
        for(int i=0; i<this.rowN; i++){
            for(int j=0; j<this.colN; j++){
                this.game_array[i][j] = "-";
                System.out.print(game_array[i][j] + " ");
            }
            System.out.println();
        }
    }

    void game(){
        Scanner scan = new Scanner(System.in);
        isTrue = false;

        while(!isTrue){
            System.out.print("Satır numarası giriniz : ");
            choice_r = scan.nextInt();
            choice_r -= 1;
            System.out.print("Sütun numarası giriniz: ");
            choice_c = scan.nextInt();
            choice_c -= 1;

            if(choice_r > this.rowN || choice_c > this.colN){
                System.out.println("Geçersiz sayı girişi yapıldı");
                continue;
            }

            if(mine_array[choice_r][choice_c].equals("*")){
                System.out.println("Oyunu kaybettiniz!!");
                break;
            }

            control_mine();

            if(finish_game()){
                System.out.println("Tebrikler. Oyunu Kazandınız!!");
                break;
            }

        }
    }

    void control_mine(){
        count = 0;
        
        for(int i = (choice_r-1); i<=(choice_r+1); i++){
            for(int j = (choice_c-1); j<=(choice_c+1); j++){
                if(i<0 || j<0 || i>=this.rowN || j>=this.colN){
                    continue;
                }
                if(this.mine_array[i][j].equals("*")){
                    count++;
                }
            }
        }

        this.mine_array[choice_r][choice_c] = String.valueOf(count);
        this.game_array[choice_r][choice_c] = String.valueOf(count);

        for(int i=0; i<this.rowN;i++){
            for(int j=0; j<this.colN; j++){
                System.out.print(this.game_array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    boolean finish_game(){
        for(int i=0; i<this.rowN; i++){
            for(int j=0; j<this.colN; j++){
                if(mine_array[i][j].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }

    void run(){
        mine_array();
        print_mine_array();
        game();
    }
}