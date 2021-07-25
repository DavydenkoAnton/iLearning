import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private int choice;


    public Player() {
    }

    public void input(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean correctInput=true;
        while (correctInput) {
            System.out.print("Your move: ");
            try {
                choice = sc.nextInt();
                if (choice < 0 || choice > args.length) {
                    System.out.println("Advice:  input 0-" + args.length);
                    correctInput = true;
                }else{
                    correctInput = false;
                }
            } catch (InputMismatchException e) {
                correctInput = true;
                sc.nextLine();
                System.out.println("Advice:  input only numbers");
            }
        }
    }



    public int getChoice() {
        return choice;
    }

}
