package cc.syky.ui;

import cc.syky.config.configSupport11;

public enum uiSupport146 {
   TOGGLE_ON(configSupport11.TOGGLES, uiSupport147.CLICK_ON),
   TOGGLE_OFF(configSupport11.TOGGLES, uiSupport147.CLICK_OFF),
   OPTION_PICKED(configSupport11.TOGGLES, uiSupport147.CLICK_ON),
   BIND_ON(configSupport11.BINDS, uiSupport147.CLICK_ON),
   BIND_OFF(configSupport11.BINDS, uiSupport147.CLICK_OFF),
   SELECT_ADD(configSupport11.SELECTION, uiSupport147.SELECT_ADD_1, uiSupport147.SELECT_ADD_2, uiSupport147.SELECT_ADD_3, uiSupport147.SELECT_ADD_4),
   SELECT_REMOVE(
      configSupport11.SELECTION, uiSupport147.SELECT_REMOVE_1, uiSupport147.SELECT_REMOVE_2, uiSupport147.SELECT_REMOVE_3, uiSupport147.SELECT_REMOVE_4
   );

   private final configSupport11 group;
   private final uiSupport147[] clips;

   private uiSupport146(configSupport11 var3, uiSupport147... var4) {
      this.group = var3;
      this.clips = var4;
   }

   public configSupport11 v1() {
      return this.group;
   }

   public uiSupport147 v1(int var1) {
      return this.clips[var1];
   }

   public int v2() {
      return this.clips.length;
   }

   public static uiSupport146 v1(boolean var0) {
      return var0 ? TOGGLE_ON : TOGGLE_OFF;
   }

   public static uiSupport146 v2(boolean var0) {
      return var0 ? BIND_ON : BIND_OFF;
   }
}
