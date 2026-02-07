package state;

import model.BaseballNumber;
import model.Game;
import model.GameResult;
import view.Inputview;
import view.OutputView;

public class ProgressState implements GameState{
    private final BaseballNumber answer;
    private final Inputview inputview;
    private final OutputView outputView;

    public ProgressState(BaseballNumber baseballNumber){
        this.answer = baseballNumber;
        this.inputview = new Inputview();
        this.outputView = new OutputView();
    }

    @Override
    public void handle(Game game){
        outputView.printInputGuide();
        String input = inputview.readNumber();
        playOneTurn(input, game);
    }

    private void playOneTurn(String input, Game game){
        try {
            BaseballNumber userNumber = new BaseballNumber(input);
            GameResult gameResult = answer.compare(userNumber);
            outputView.printResult(gameResult.getMessage());
            if(!gameResult.isThreeStrike()) return;
            outputView.printGameEnd();
            game.changeState(new GameOverState());
        } catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
        }
    }
}
