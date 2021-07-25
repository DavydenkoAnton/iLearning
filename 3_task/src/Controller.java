public class Controller {


    private boolean inProgress;
    private Validator validator;
    private Machine machine;
    private Player player;
    private String winner;

    public Controller() {
        inProgress = true;
        validator = new Validator();
        machine = new Machine();
        player = new Player();
    }

    public void showMenu(String[] args) {
        for (int i = 1; i <= args.length; i++) {
            System.out.println(i + " - " + args[i - 1]);
        }
        System.out.println("0 - exit");
    }

    public boolean run() {
        return inProgress;
    }


    public boolean validArgs(String[] args) {
        if (!validator.argsCount(args)) {
            System.out.println("Error:  arguments less then three\nAdvice: rerun game and add arguments!");
            inProgress = false;
            return false;
        } else if (!validator.argsEven(args)) {
            System.out.println("Error:  arguments are not even\nAdvice: rerun game and add even count of arguments!");
            inProgress = false;
            return false;
        }
        return true;
    }

    public void machineMove(String[] args) {
        machine.generateKey128();
        machine.randomChoice(args);
        machine.generateHMAC(args);
    }

    public void playerMove(String[] args) {
        player.input(args);
        if (player.getChoice() == 0) {
            inProgress = false;
        }
    }

    public void showResult(String[] args) {
        System.out.println("Your move: " + args[player.getChoice() - 1]);
        System.out.println("Comp move: " + args[machine.getChoice()]);
        System.out.println("HMAC key:  " + machine.getKey());

    }


    public void initWinner(String[] args) {
        winner = "You win!";
        int count = player.getChoice()+1;
        if (player.getChoice() == machine.getChoice()+1) {
            winner = "Dead heat!";
        } else {
            for (int i = 0; i < args.length / 2; i++) {
                if (count == machine.getChoice()+1) {
                    winner = "Computer win!";
                    break;
                }
                if (count == args.length ) {
                    count = 0;
                }
                count++;
            }
        }
        System.out.println(winner);
    }

    public void showHMAC() {
        System.out.println("HMAC: " + machine.getHMAC());
    }

    public void line() {
        System.out.println("------------------------------------");
    }
}
