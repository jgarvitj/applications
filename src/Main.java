import Logger.LogConstants;
import Logger.LogProcessor;
import SnakesAndLadders.service.impl.SnakeAndLadderGame;
import Vehicle.Vehicle;
import Vehicle.VehicleConstants.VehicleConstants;
import Vehicle.factory.VehicleFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        LogProcessor logProcessor = new LogProcessor();
        SnakeAndLadderGame snakeAndLadderGame = SnakeAndLadderGame.initWithDefaultPlayer();
        snakeAndLadderGame.addPlayer(123);
        snakeAndLadderGame.addLadder(3, 15);
        snakeAndLadderGame.addLadder(21, 4);
        snakeAndLadderGame.addLadder(46, 15);
        snakeAndLadderGame.addLadder(80, 17);
        snakeAndLadderGame.addSnake(32, 10);
        snakeAndLadderGame.addSnake(37, 10);
        snakeAndLadderGame.addSnake(63, 10);
        snakeAndLadderGame.addSnake(82, 10);
        snakeAndLadderGame.play();

        Vehicle car = VehicleFactory.getVehicleObject(VehicleConstants.CAR);
        logProcessor.log(LogConstants.DEBUG, car.getSeatCapacity().toString());

        Vehicle truck = VehicleFactory.getVehicleObject("truck");
        logProcessor.log(LogConstants.DEBUG, truck.getSeatCapacity().toString());


    }
}