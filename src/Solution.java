import java.util.*;
public class Solution {
    public static void main(String[] args) {

        int[] game = new int[] {0, 0, 0, 0, 0};
        int leap = 3;
        int[] game1 = new int[] {0, 0, 0, 1, 1, 1};
        int leap1 = 5;
        int[] game2 = new int[] {0, 0, 1, 1, 1, 0};
        int leap2 = 3;
        int[] game3 = new int[] {0, 1, 0};
        int leap3 = 1;

        System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        System.out.println( (canWin(leap1, game1)) ? "YES" : "NO" );
        System.out.println( (canWin(leap2, game2)) ? "YES" : "NO" );
        System.out.println( (canWin(leap3, game3)) ? "YES" : "NO" );
    }
    public static boolean canWin(int leap, int[] game) {
        /*int currentPosition = 0;
        int currentPositionFlag = -1;
        while (true){
            if (currentPosition + leap >= game.length || currentPosition >= game.length - 1)
                return true;
            if (game[currentPosition + leap] == 0)
                currentPosition += leap;
            else{
                if(currentPosition == currentPositionFlag)
                    break;
                for(int k = currentPosition + leap - 1; k >= 0; k--)
                    if (game[k] == 0){
                        currentPosition = k;
                        currentPositionFlag = currentPosition;
                        break;
                    }
            }
        }
        return false;    // Return true if you can win the game; otherwise, return false. */
        return isSolvable(leap, game, 0);
    }
    private static boolean isSolvable(int leap, int[] game, int position) {
        if (position >= game.length) {
            return true; // Eğer pozisyon oyun tahtasını aşıyorsa, kazanırsın
        } else if (position < 0 || game[position] == 1) {
            return false; // Eğer pozisyon negatifse ya da engel varsa, hareket edemezsin
        }

        game[position] = 1; // Bu pozisyonu ziyaret ettik olarak işaretleyelim

        // İleri, geri ve sıçrama hamlelerini deneyelim
        return isSolvable(leap, game, position + leap) || // Leap yaparak ileri git
                isSolvable(leap, game, position + 1) ||   // Bir adım ileri git
                isSolvable(leap, game, position - 1);     // Bir adım geri git
    }

}