package cc.syky.module.visual;

public final class visualSupport27 {
   public static final float v1 = 2.0F;
   public static volatile boolean v2;
   public static final String v3 = "float lightAccum = min(1.0,";
   public static final String v4 = "float lightAccum = dot(Light0_Direction, Light0_Direction) > 2.0 ? 1.0 : min(1.0,";

   private visualSupport27() {
   }

   public static String v1(String var0) {
      if (!var0.contains("float lightAccum = min(1.0,")) {
         return var0;
      } else {
         v2 = true;
         return var0.replace("float lightAccum = min(1.0,", "float lightAccum = dot(Light0_Direction, Light0_Direction) > 2.0 ? 1.0 : min(1.0,");
      }
   }
}
