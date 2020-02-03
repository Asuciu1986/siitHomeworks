package objectcontainers.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if(p1.score==p2.score){
            if(p1.name.compareTo(p2.name)>=0){
                return 1;
            } else {
                return -1;
            }
        } else{
            return p2.score-p1.score;
        }
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scanner.next(), scanner.nextInt());
        }
        scanner.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].getName(), player[i].getScore());
        }
    }
}