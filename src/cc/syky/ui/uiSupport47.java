package cc.syky.ui;

public enum uiSupport47 {
   PANEL(855309),
   CARD(1315860),
   SURFACE(789516),
   EDGE(16777215),
   TEXT_BRIGHT(15395562),
   TEXT(13487565),
   TEXT_DIM(9079434),
   NAV_INK(10132122),
   ICON(8026746),
   ACCENT(10383298),
   ACCENT_SOFT(14595836),
   ACCENT_TEXT(14075356),
   ACCENT_FILL(8209304),
   ACCENT_FILL_INK(16045823),
   BUBBLE(1842206),
   BUBBLE_INK(14474460),
   BUBBLE_MINE(6179440),
   BUBBLE_MINE_INK(16051959),
   CONTROL_INK(7500402),
   CONTROL_INK_ON(14803425),
   SHADOW(0);

   private final int defaultRgb;

   private uiSupport47(int var3) {
      this.defaultRgb = var3;
   }

   public int v1() {
      return this.defaultRgb;
   }
}
