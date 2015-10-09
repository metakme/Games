package games;

import java.util.Scanner;

public class Menu {
    Game[] gamelist;
    int choice = 1;
    public Menu(Game[] gamelist){
        this.gamelist = gamelist;
    }
    void run() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose from the list of games:");
        for (int i = 0; i<gamelist.length; i++) {
            System.out.println(i+": "+gamelist[i].name);
        }
        choice = sc.nextInt();
        
        
        gamelist[choice].run();
    }

}
