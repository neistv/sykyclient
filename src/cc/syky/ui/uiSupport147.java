package cc.syky.ui;

public enum uiSupport147 {
   CLICK_ON("click_on.wav"),
   CLICK_OFF("click_off.wav"),
   SELECT_ADD_1("select_add_1.wav"),
   SELECT_ADD_2("select_add_2.wav"),
   SELECT_ADD_3("select_add_3.wav"),
   SELECT_ADD_4("select_add_4.wav"),
   SELECT_REMOVE_1("select_remove_1.wav"),
   SELECT_REMOVE_2("select_remove_2.wav"),
   SELECT_REMOVE_3("select_remove_3.wav"),
   SELECT_REMOVE_4("select_remove_4.wav");

   private static final String DIR = "/cc/syky/sound/ui/builtin/";
   private final String file;

   private uiSupport147(String var3) {
      this.file = var3;
   }

   public String v1() {
      return "/cc/syky/sound/ui/builtin/" + this.file;
   }

   public String v2() {
      return this.file;
   }
}
