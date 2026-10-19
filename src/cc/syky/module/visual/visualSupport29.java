package cc.syky.module.visual;

import cc.syky.hud.hudSupport60;
import org.jetbrains.annotations.Nullable;

public final class visualSupport29 {
   private static final long v1 = 200L;
   private static final float v2 = 18.0F;
   private static final float v3 = 0.1F;
   private static final float v4 = 0.001F;
   private static final visualSupport29.Part1 v5 = new visualSupport29.Part1();
   private static final visualSupport29.Part1 v6 = new visualSupport29.Part1();
   private static final visualSupport58 v7 = new visualSupport58(0.0F, 18.0F);
   private static long v8;

   private visualSupport29() {
   }

   public static void v1(float var0, boolean var1, boolean var2) {
      v7.v1(var0);
      v5.v1(var1 ? 1.0F : 0.0F);
      v6.v1(var2 ? 1.0F : 0.0F);
      v4();
   }

   public static void v1() {
      v5.v1(0.0F);
      v6.v1(0.0F);
      v4();
   }

   public static void v2() {
      v8 = 0L;
      v5.v3();
      v6.v3();
      v7.v3();
      visualSupport51.v3 = false;
      v6();
   }

   public static void v3() {
      long var0 = System.nanoTime();
      float var2 = v8 == 0L ? 0.0F : Math.min((float)(var0 - v8) / 1.0E9F, 0.1F);
      v8 = var0;
      if (visualSupport51.v3) {
         if (v5.v1() <= 0.001F) {
            v7.v3();
         } else {
            v7.v2(var2);
         }

         visualSupport51.v3 = v5();
         v6();
      }
   }

   private static void v4() {
      if (v5()) {
         visualSupport51.v3 = true;
      }
   }

   private static boolean v5() {
      return !v5.v2() || !v6.v2() || Math.abs(v7.v2() - v7.v1()) >= 0.001F;
   }

   private static void v6() {
      visualSupport51.v1 = v5.v1() * v7.v1();
      v2 = v6.v1();
   }

   public static final class Part1 {
      private float v1;
      private float v2;
      @Nullable
      private visualSupport2 v3;

      public Part1() {
      }

      public void v1(float var1) {
         if (!(Math.abs(var1 - this.v2) < 0.001F)) {
            this.v1 = this.v1();
            this.v2 = var1;
            long var2 = Math.max(1L, (long)(200.0F * Math.abs(this.v2 - this.v1)));
            this.v3 = new visualSupport2(var2, hudSupport60::v5);
         }
      }

      public float v1() {
         visualSupport2 var1 = this.v3;
         return var1 == null ? this.v2 : this.v1 + (this.v2 - this.v1) * var1.v1();
      }

      public boolean v2() {
         visualSupport2 var1 = this.v3;
         return var1 == null || var1.v2();
      }

      public void v3() {
         this.v1 = this.v2;
         this.v3 = null;
      }
   }
}
