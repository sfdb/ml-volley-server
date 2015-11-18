public class EmptyUI implements UI {
   public void printState(GameState state) {
      System.err.printf("{lScore:%d,rScore:%d,lHits:%d,rHits:%d,",state.lScore,state.rScore,state.lHits,state.rHits);
      PlayerState l = state.match.lPlayer, r = state.match.rPlayer;
      System.err.printf("lPlayer:{x:%d,y:%d,vx:%d,vy:%d},",l.pCircle.posX,l.pCircle.posY,l.pCircle.velX,l.pCircle.velY);
      System.err.printf("rPlayer:{x:%d,y:%d,vx:%d,vy:%d},",r.pCircle.posX,r.pCircle.posY,r.pCircle.velX,r.pCircle.velY);
      BallState b = state.match.ball;
      System.err.printf("ball:{x:%d,y:%d,vx:%d,vy:%d}}\n",b.pCircle.posX,b.pCircle.posY,b.pCircle.velX,b.pCircle.velY);
   }

   @Override
   public void init(GameState state) {
      System.err.println("ui.init:");
      printState(state);
   }

   @Override
   public void display(GameState state) {
      System.err.println("ui.display:");
      printState(state);
   }

   @Override
   public void finish(GameState state) {
      System.err.println("ui.finish:");
      printState(state);
   }
}
