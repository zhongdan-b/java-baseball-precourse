package controller;

import model.BaseballNumber;
import model.Game;
import model.NumberGenerator;
import state.GameState;
import state.ProgressState;

public class GameController {
    public Game game;
    public NumberGenerator numberGenerator;

    public void run(){
        initialize();
        play();
    }

    public void initialize(){
        this.numberGenerator = new NumberGenerator();
        BaseballNumber baseballNumber = numberGenerator.generate();
        GameState initialGameState = new ProgressState(baseballNumber);

        this.game = new Game(initialGameState);
    }

    public void play(){
        while(game.isRunning()){
            game.update();
        }
    }
}
