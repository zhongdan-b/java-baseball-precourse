package state;

import model.Game;

public interface GameState {
    void handle(Game game);
}
