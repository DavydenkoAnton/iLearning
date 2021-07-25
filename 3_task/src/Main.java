import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class Main {
    //    d:\Study\ilearning\3_task\out\production\3_task>jar cfe 3_task.jar Main Main.class
//
//    d:\Study\ilearning\3_task\out\production\3_task>java -jar 3_task.jar xf ds fsd
    public static void main(String[] args) {


        Controller controller = new Controller();

        if (controller.validArgs(args)) {
            while (controller.run()) {
                controller.machineMove(args);
                controller.showHMAC();
                controller.showMenu(args);
                controller.playerMove(args);
                if(controller.run()) {
                    controller.initWinner(args);
                    controller.showResult(args);
                }
                controller.line();
            }
        }
    }
}

