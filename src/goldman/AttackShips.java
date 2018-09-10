package goldman;

import java.util.ArrayList;
import java.util.List;

public class AttackShips {
    public String solution(int N, String S, String T) {
        // write your code in Java SE 8

        // if no ships or no attacks, return 0
        if(S.length() == 0 || T.length() == 0) {
            return new String(0+","+0);
        }

        // to hold rectangle coordinates
        String[] rectangles = S.split(",");

        // to hold ship size
        int[] size = new int[rectangles.length];

        String[] attacks = T.split(" ");
        List<List<Integer>> ships = getShips(size, rectangles, N);
        attackShips(attacks, ships, N);

        int sunk = 0;
        int hit = 0;
        int s = 0;
        for(List<Integer> ship: ships) {
            //if size is zero: all cells attacked
            if (ship.size() == 0) {
                sunk++;
            }
            else if(ship.size() < size[s]) {
                hit++;
            }
            s++;
        }

        return new String(sunk + "," + hit);
    }

    private static void attackShips(String[] attacks, List<List<Integer>> ships, int N) {
        //iterate over attacks and remove attacked cells from ships
        for (String attack : attacks) {
            if(attack.isEmpty()) continue;
            int row = Integer.parseInt(attack.substring(0, attack.length() - 1)) - 1;
            int col = attack.charAt(attack.length() - 1) - 'A';
            int cell = row*N + col;
            outer: for(List<Integer> ship: ships) {
                for(int i=0; i<ship.size(); i++) {
                    if(ship.get(i) == cell) {
                        ship.remove(i);
                        break outer;
                    }
                }
            }
        }
    }

    private static List<List<Integer>> getShips(int[] size, String[] rectangles, int N) {
        List<List<Integer>> ships = new ArrayList<>();

        // counter for size array
        int s=0;

        for (String pos : rectangles) {
            String[] xy = pos.split(" ");
            int row1 = Integer.parseInt(xy[0].substring(0, xy[0].length() - 1)) - 1;
            int col1 = xy[0].charAt(xy[0].length() - 1) - 'A';
            int row2 = Integer.parseInt(xy[1].substring(0, xy[1].length() - 1)) - 1;
            int col2 = xy[1].charAt(xy[1].length() - 1) - 'A';

            List<Integer> ship = new ArrayList<>();
            //rectangle of size 1
            if (row1 == row2 && col1 == col2) {
                ship.add(row1 * N + col1);
                size[s++] = 1;
            }
            // rectangle spanning only 1 row
            else if (row1 == row2) {
                for (int i = col1; i <= col2; i++) {
                    ship.add(row1 * N + i);
                }
                size[s++] = col2-col1+1;
            }
            // rectangle spanning only 1 col
            else if (col1 == col2) {
                for (int i = row1; i <= row2; i++) {
                    ship.add(i * N + col1);
                }
                size[s++] = row2-row1+1;
            }
            // square
            else {
                ship.add(row1*N + col1);
                ship.add(row1*N + col2);
                ship.add(row2*N + col1);
                ship.add(row2*N + col2);
                size[s++] = 4;
            }
            ships.add(ship);
        }
        return ships;
    }

    public static void main(String[] args) {
        System.out.println(new AttackShips().solution(3, "1A 2B,1C 1C,2C 3C,3A 3A", "1A 2B 3A 1C 3C"));
    }
}
//3 1A 2B,1C 1C,2C 3C,3A 3A 1A 2B 3A 1C 3C