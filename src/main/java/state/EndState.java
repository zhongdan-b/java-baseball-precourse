package state;

import model.Game;

public class EndState implements GameState{
    @Override
    public void handle(Game game){
        game.stop();
    }
}
