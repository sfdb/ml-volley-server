package agent;
import physics.PhysicsObjectInterface;
import server.GameStateInterface;

public class BallFollower extends AlwaysLeftInputProvider {
   public long offset;

   public BallFollower(long offset_) {
      offset = offset_;
   }

   @Override
   public PlayerInput getInput(GameStateInterface state) {
      PhysicsObjectInterface ball = state.getBall(), me = state.getMe();

      long x = me.getPosX(), y = me.getPosY();
      long bx = ball.getPosX(), by = ball.getPosY();
      long idealLocation = bx - offset;

      boolean left = x > idealLocation;
      boolean right = x < idealLocation;
      boolean up = by > y * 3;

      return new PlayerInput(left, right, up);
   }
}
