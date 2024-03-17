import SnakesAndLadders.service.impl.SnakeAndLadderGame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
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
    }
}