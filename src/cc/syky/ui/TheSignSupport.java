package cc.syky.ui;

public enum TheSignSupport {
   INVALID_NAME("A name is 1 to 16 letters, digits or symbols, with no spaces."),
   DUPLICATE("This account is already in the list."),
   NOT_FOUND("That account is no longer in the list."),
   NETWORK("Couldn't reach Microsoft. Check your connection and try again."),
   RATE_LIMITED("Too many sign-ins in a row. Wait a minute and try again."),
   SIGN_IN_AGAIN("Microsoft signed this account out. Sign in to it again."),
   CODE_EXPIRED("The sign-in code expired. Start the sign-in again."),
   DECLINED("The sign-in was declined."),
   NO_MINECRAFT("This Microsoft account doesn't own Minecraft: Java Edition."),
   NO_PROFILE("This account has no Minecraft name yet. Open the official launcher once to pick one."),
   NO_XBOX("This Microsoft account has no Xbox profile yet. Sign in at xbox.com once, then try again."),
   CHILD_ACCOUNT("A child account has to be added to a Microsoft family by an adult first."),
   XBOX_BANNED("Xbox has banned this account."),
   XBOX_REGION("Xbox isn't available in this account's country."),
   XBOX_AGE("Xbox needs this account's age verified first."),
   SERVICE("Microsoft's sign-in service is having trouble. Try again later."),
   STORAGE("Couldn't save the account list."),
   FAILED("Couldn't switch the account.");

   private final String message;

   private TheSignSupport(String var3) {
      this.message = var3;
   }

   public String v1() {
      return this.message;
   }
}
