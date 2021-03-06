package ui;

import server.GameState;

public interface UI {
   public void init(GameState state);
   public void display(GameState state);
   public void finish(GameState state);
}
