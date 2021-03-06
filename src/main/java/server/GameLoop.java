package server;
import java.util.concurrent.TimeUnit;

import ui.UI;

public class GameLoop {
   private final static long NS_PER_SEC = TimeUnit.SECONDS.toNanos(1);
   private final static long MS_PER_SEC = TimeUnit.SECONDS.toMillis(1);

   public int maxFps;
   public UI ui;
   public GameState state;

   public GameLoop(int maxFps_, UI ui_, GameState state_) {
      maxFps = maxFps_;
      ui = ui_;
      state = state_;
   }

   public void run() {
      final long framePeriod = NS_PER_SEC / maxFps;
      
      ui.init(state);
      
      while (!state.isFinished()) {
         long beginTime = System.nanoTime();
         
         state.step();
         ui.display(state);
         
         long timeDiff = System.nanoTime() - beginTime;
         long sleepTime = framePeriod - timeDiff;
         if (sleepTime > 0) {
            try {
               long tmp = sleepTime * MS_PER_SEC;
               long sleepTimeMs = tmp / NS_PER_SEC;
               int sleepTimeNs = (int) (sleepTime % (NS_PER_SEC/MS_PER_SEC));
               //System.err.printf("Sleeping for %dms + %dns\n",sleepTimeMs,sleepTimeNs);
               Thread.sleep(sleepTimeMs, sleepTimeNs);
            } catch (InterruptedException e) {
               System.err.println("Sleep interrupted? "+e);
            }
         }
         
         for ( ; sleepTime < 0; sleepTime += framePeriod) {
            System.err.println("Uh oh... catching up.");
            state.step();
         }
      }
      
      ui.finish(state);
   }
}
