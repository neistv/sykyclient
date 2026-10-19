package cc.syky.account;

import cc.syky.cloud.cloudSupport53;
import cc.syky.ui.uiSupport164;
import java.util.Arrays;

public final class accountSupport11 implements AutoCloseable {
   public static final String v1 = "gpu.frame";
   public static final String v2 = "gpu.blur.capture";
   public static final String v3 = "gpu.blur.recapture";
   public static final String v4 = "gpu.blur.composite";
   public static final String v5 = "gpu.blur.nested";
   public static final String v6 = "gpu.gui.capture";
   public static final String v7 = "gpu.world.post";
   public static final String v8 = "gpu.world.fogblur";
   public static final String v9 = "gpu.world.motionblur";
   public static final String v10 = "gpu.hand.blur";
   public static final String v11 = "gpu.world.wetsurfaces";
   public static final String v12 = "gpu.world.colorgrade";
   public static final String v13 = "gpu.world.raindrops";
   public static final String v14 = "gpu.world.sky";
   public static final String v15 = "gpu.world.particles";
   public static final String v16 = "gpu.world.rings.march";
   public static final String v18 = "gpu.world.rings.glow";
   public static final String v19 = "gpu.world.rings.discs";
   public static final String v17 = "gpu.world.beams";
   public static final String v20 = "gpu.world.shapes";
   public static final String v21 = "gpu.world.overlay";
   public static final String v22 = "gpu.world.cover";
   public static final String v24 = "gpu.world.seam";
   public static final String v25 = "gpu.hud.tail";
   public static final String v26 = "gpu.batch2d";
   public static final String v27 = "gpu.clickgui";
   public static final String v28 = "gpu.clickgui.glass";
   public static final String v29 = "gpu.clickgui.veil";
   public static final int v30 = 4;
   public static final int v32 = 64;
   public static final int v23 = 16;
   private final uiSupport164 v33;
   private final cloudSupport53 v31;
   private final accountSupport11.Part1[] v34 = new accountSupport11.Part1[4];
   private final int[] v36 = new int[16];
   private int[] v38 = new int[64];
   private int v42;
   private int v43;
   private int v37;
   private boolean v48;
   private boolean v40;
   private int v44;
   private long v47;
   private long v49;

   public accountSupport11(uiSupport164 var1, cloudSupport53 var2) {
      this.v33 = var1;
      this.v31 = var2;

      for (int var3 = 0; var3 < 4; var3++) {
         this.v34[var3] = new accountSupport11.Part1();
      }
   }

   public boolean v1() {
      return this.v48;
   }

   public void v1(boolean var1) {
      if (this.v48 != var1) {
         this.v48 = var1;
         if (!var1) {
            this.v7();
         }
      }
   }

   public long v2() {
      return this.v47;
   }

   public long v3() {
      return this.v49;
   }

   public void v4() {
      if (this.v48 && !this.v40) {
         this.v6();
         accountSupport11.Part1 var1 = this.v34[this.v43];
         if (var1.v7) {
            this.v2(var1);
            this.v47++;
         }

         var1.v1();
         this.v40 = true;
         this.v37 = 0;
         this.v44 = this.v1("gpu.frame");
      }
   }

   public void v5() {
      if (this.v40) {
         while (this.v37 > 1) {
            this.v1(this.v36[this.v37 - 1] + 1);
         }

         this.v1(this.v44);
         this.v44 = 0;
         this.v40 = false;
         accountSupport11.Part1 var1 = this.v34[this.v43];
         var1.v7 = var1.v5 > 0;
         this.v43 = (this.v43 + 1) % 4;
      }
   }

   public int v1(String var1) {
      if (this.v48 && this.v40) {
         accountSupport11.Part1 var2 = this.v34[this.v43];
         if (var2.v5 < 64 && this.v37 < 16) {
            int var3 = var2.v5++;
            int var4 = this.v8();
            var2.v1[var3] = var1;
            var2.v2[var3] = var4;
            var2.v3[var3] = 0;
            this.v33.v1(var4);
            var2.v6 = var4;
            this.v36[this.v37++] = var3;
            return var3 + 1;
         } else {
            this.v49++;
            return 0;
         }
      } else {
         return 0;
      }
   }

   public void v1(int var1) {
      if (var1 != 0 && this.v40) {
         int var2 = var1 - 1;
         accountSupport11.Part1 var3 = this.v34[this.v43];
         if (var2 < var3.v5 && var3.v3[var2] == 0) {
            int var4 = this.v8();
            var3.v3[var2] = var4;
            this.v33.v1(var4);
            var3.v6 = var4;

            while (this.v37 > 0 && this.v36[this.v37 - 1] != var2) {
               this.v37--;
            }

            if (this.v37 > 0) {
               this.v37--;
            }
         }
      }
   }

   @Override
   public void close() {
      this.v48 = false;
      this.v7();
   }

   private void v6() {
      for (int var1 = 0; var1 < 4; var1++) {
         accountSupport11.Part1 var2 = this.v34[(this.v43 + var1) % 4];
         if (var2.v7 && this.v33.v2(var2.v6)) {
            for (int var3 = 0; var3 < var2.v5; var3++) {
               int var4 = var2.v3[var3];
               if (var4 == 0) {
                  var2.v4[var3] = -1L;
               } else {
                  var2.v4[var3] = this.v33.v3(var4) - this.v33.v3(var2.v2[var3]);
               }
            }

            this.v1(var2);
            this.v2(var2);
         }
      }
   }

   private void v1(accountSupport11.Part1 var1) {
      for (int var2 = 0; var2 < var1.v5; var2++) {
         if (var1.v4[var2] >= 0L) {
            String var3 = var1.v1[var2];
            boolean var4 = true;

            for (int var5 = 0; var5 < var2; var5++) {
               if (var1.v4[var5] >= 0L && var3.equals(var1.v1[var5])) {
                  var4 = false;
                  break;
               }
            }

            if (var4) {
               long var8 = var1.v4[var2];

               for (int var7 = var2 + 1; var7 < var1.v5; var7++) {
                  if (var1.v4[var7] >= 0L && var3.equals(var1.v1[var7])) {
                     var8 += var1.v4[var7];
                  }
               }

               this.v31.v1(var3, var8);
            }
         }
      }
   }

   private void v2(accountSupport11.Part1 var1) {
      for (int var2 = 0; var2 < var1.v5; var2++) {
         this.v2(var1.v2[var2]);
         if (var1.v3[var2] != 0) {
            this.v2(var1.v3[var2]);
         }
      }

      var1.v1();
   }

   private void v7() {
      for (accountSupport11.Part1 var4 : this.v34) {
         this.v2(var4);
      }

      for (int var5 = 0; var5 < this.v42; var5++) {
         this.v33.v4(this.v38[var5]);
      }

      this.v42 = 0;
      this.v40 = false;
      this.v44 = 0;
      this.v37 = 0;
      this.v43 = 0;
   }

   private int v8() {
      return this.v42 > 0 ? this.v38[--this.v42] : this.v33.v2();
   }

   private void v2(int var1) {
      if (var1 != 0) {
         if (this.v42 == this.v38.length) {
            this.v38 = Arrays.copyOf(this.v38, this.v38.length * 2);
         }

         this.v38[this.v42++] = var1;
      }
   }

   public static final class Part1 {
      public final String[] v1 = new String[64];
      public final int[] v2 = new int[64];
      public final int[] v3 = new int[64];
      public final long[] v4 = new long[64];
      public int v5;
      public int v6;
      public boolean v7;

      public Part1() {
      }

      public void v1() {
         for (int var1 = 0; var1 < this.v5; var1++) {
            this.v2[var1] = 0;
            this.v3[var1] = 0;
            this.v4[var1] = -1L;
         }

         this.v5 = 0;
         this.v6 = 0;
         this.v7 = false;
      }
   }
}
