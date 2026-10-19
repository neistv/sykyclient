package cc.syky.render;

public enum renderSupport9 {
   OPAQUE,
   TRANSLUCENT,
   SPRITE;

   private renderSupport9() {
   }

   public boolean v1() {
      return this == SPRITE;
   }
}
