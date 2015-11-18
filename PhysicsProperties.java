// These values should be roughly the same as those in Blobby Volley.
public class PhysicsProperties {
   // Default gravity that affects the player. This should be positive.
   public long playerGravity = 287;

   // Gravity that affects the player when the Up key is presed. This should be positive.
   public long playerReducedGravity = playerGravity/2;

   // Initial velocity when a player jumps.
   public long playerJumpVelocity = 15100;

   // Horizontal movement speed when a player presses the Left or Right key.
   public long playerHorizontalSpeed = 4500;

   // Fun parameter... should players "bounce" off the floor?
   public boolean playerBounce = false;

   // Gravity that affects the ball. This should be positive.
   public long ballGravity = 287;
}
