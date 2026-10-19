package cc.syky.internal;

import cc.syky.cloud.cloudSupport101;
import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiSupport146;
import cc.syky.ui.uiSupport148;
import java.util.Arrays;
import java.util.Locale;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3965;
import net.minecraft.class_638;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_239.class_240;

public final class InternalSupport6 {
   public static final int v1 = 32768;
   private static final int v3 = 1509949439;
   private static final int v4 = -218103809;
   private static final float v5 = 2.5F;
   private static final int v6 = -1493172225;
   private static final float v7 = 1.5F;
   private static final double v8 = 64.0;
   public static final double v2 = 4.0;
   private static final long v9 = 2500L;
   private static final long v10 = 45000000L;
   private long v11 = -4611686018427387904L;
   private final cloudSupport101 v12;
   private final InternalSupport7 v13;
   private final class_2339 v14 = new class_2339();
   private final class_2339 v15 = new class_2339();
   private boolean v16;
   private long v18;
   private boolean v19;
   private boolean v17;

   public InternalSupport6(cloudSupport101 var1, InternalSupport7 var2) {
      this.v12 = var1;
      this.v13 = var2;
   }

   public boolean v1() {
      return this.v13.v16().v2();
   }

   public boolean v2() {
      if (!this.v1()) {
         return false;
      } else {
         this.v1(true);
         return true;
      }
   }

   public boolean v3() {
      if (!this.v1()) {
         return false;
      } else {
         this.v1(false);
         return true;
      }
   }

   private void v1(boolean var1) {
      class_310 var2 = this.v12.v1();
      if (var2 != null && this.v16) {
         InternalSupport9 var3 = this.v13.v16();
         if (var2.method_74187() && var3.v8()) {
            this.v1(var2, var3, var1);
         } else {
            this.v1(var3, var1);
         }
      }
   }

   private void v1(InternalSupport9 var1, boolean var2) {
      if (var2) {
         boolean var3 = var1.v5().v1() >= 16384 && !var1.v5().v4(this.v18);
         if (var3) {
            this.v1(String.format(Locale.ROOT, "Full – one overlay holds up to %,d blocks", 16384));
         }

         if (var1.v2(this.v18)) {
            this.v2(true);
         }
      } else if (var1.v3(this.v18)) {
         this.v2(false);
      }
   }

   private void v2(boolean var1) {
      long var2 = System.nanoTime();
      if (var2 - this.v11 >= 45000000L) {
         this.v11 = var2;
         uiSupport148.v1(var1 ? uiSupport146.SELECT_ADD : uiSupport146.SELECT_REMOVE);
      }
   }

   private void v1(class_310 var1, InternalSupport9 var2, boolean var3) {
      class_638 var4 = var1.field_1687;
      if (var4 != null) {
         long var5 = var2.v9();
         int var7 = Math.min(InternalSupport10.v1(var5), InternalSupport10.v1(this.v18));
         int var8 = Math.max(InternalSupport10.v1(var5), InternalSupport10.v1(this.v18));
         int var9 = Math.min(InternalSupport10.v3(var5), InternalSupport10.v3(this.v18));
         int var10 = Math.max(InternalSupport10.v3(var5), InternalSupport10.v3(this.v18));
         int var11 = Math.min(InternalSupport10.v2(var5), InternalSupport10.v2(this.v18));
         int var12 = Math.max(InternalSupport10.v2(var5), InternalSupport10.v2(this.v18));
         long var13 = (long)(var8 - var7 + 1) * (var10 - var9 + 1) * (var12 - var11 + 1);
         if (var13 > 32768L) {
            this.v1(String.format(Locale.ROOT, "Too big to fill – up to %,d blocks at once", 32768));
         } else {
            long[] var15 = new long[(int)var13];
            int var16 = 0;
            InternalSupport10 var17 = var2.v5();

            for (int var18 = var9; var18 <= var10; var18++) {
               for (int var19 = var11; var19 <= var12; var19++) {
                  for (int var20 = var7; var20 <= var8; var20++) {
                     long var21 = InternalSupport10.v1(var20, var18, var19);
                     boolean var23 = var3 ? (this.v19 ? this.v2(var4, var20, var18, var19) : this.v1(var4, var20, var18, var19)) : var17.v4(var21);
                     if (var23) {
                        var15[var16++] = var21;
                     }
                  }
               }
            }

            long[] var24 = Arrays.copyOf(var15, var16);
            int var25 = var17.v1();
            if (var3) {
               var2.v1(var24, this.v18);
            } else {
               var2.v2(var24, this.v18);
            }

            int var26 = Math.abs(var2.v5().v1() - var25);
            if (var26 > 0) {
               this.v2(var3);
            }

            if (var3 && var25 + var16 > 16384) {
               this.v1(String.format(Locale.ROOT, "Full – one overlay holds up to %,d blocks", 16384));
            } else {
               this.v1(String.format(Locale.ROOT, var3 ? "+%,d blocks" : "–%,d blocks", var26));
            }
         }
      }
   }

   private boolean v1(class_638 var1, int var2, int var3, int var4) {
      this.v14.method_10103(var2, var3, var4);
      class_2680 var5 = var1.method_8320(this.v14);
      if (!var5.method_26215() && !var5.method_45474()) {
         for (class_2350 var9 : class_2350.values()) {
            this.v15.method_10103(var2 + var9.method_10148(), var3 + var9.method_10164(), var4 + var9.method_10165());
            if (!var1.method_8320(this.v15).method_26216()) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean v2(class_638 var1, int var2, int var3, int var4) {
      this.v14.method_10103(var2, var3, var4);
      class_2680 var5 = var1.method_8320(this.v14);
      return var5.method_26215() || var5.method_45474();
   }

   public void v4() {
      this.v16 = false;
      InternalSupport9 var1 = this.v13.v16();
      class_310 var2 = this.v12.v1();
      if (var1.v2() && var2 != null && var2.field_1687 != null && var2.field_1724 != null) {
         class_1297 var3 = var2.method_1560();
         if (var3 != null) {
            float var4 = var2.method_61966().method_60637(false);
            this.v19 = var2.field_1755 == null && class_3675.method_15987(var2.method_22683(), 342);
            var1.v1(this.v19);
            if (this.v19) {
               class_239 var5 = var3.method_5745(4.0, var4, false);
               if (var5 instanceof class_3965 var6 && var5.method_17783() == class_240.field_1332) {
                  class_2338 var19 = var6.method_17777().method_10093(var6.method_17780());
                  this.v18 = InternalSupport10.v1(var19.method_10263(), var19.method_10264(), var19.method_10260());
               } else {
                  class_243 var7 = var3.method_5836(var4).method_1019(var3.method_5828(var4).method_1021(4.0));
                  this.v18 = InternalSupport10.v1(
                     class_3532.method_15357(var7.field_1352), class_3532.method_15357(var7.field_1351), class_3532.method_15357(var7.field_1350)
                  );
               }

               this.v16 = true;
            } else {
               double var16 = Math.max(64.0, var2.field_1690.method_38521() * 16.0);
               class_239 var20 = var3.method_5745(var16, var4, false);
               if (var20 instanceof class_3965 var8 && var20.method_17783() == class_240.field_1332) {
                  class_2338 var9 = var8.method_17777();
                  this.v18 = InternalSupport10.v1(var9.method_10263(), var9.method_10264(), var9.method_10260());
                  this.v16 = true;
               }
            }

            boolean var17 = var2.field_1755 == null;
            boolean var18 = var17 && var2.field_1690.field_1886.method_1434();
            boolean var21 = var17 && var2.field_1690.field_1904.method_1434();
            boolean var22 = var2.method_74187();
            if (this.v16 && (var18 || var21) && !var22) {
               this.v1(var1, var18);
            }

            this.v17 = var18 || var21;
            if (this.v16) {
               int var23 = InternalSupport10.v1(this.v18);
               int var10 = InternalSupport10.v3(this.v18);
               int var11 = InternalSupport10.v2(this.v18);
               class_238 var12 = v1(var23, var10, var11, var23 + 1, var10 + 1, var11 + 1);
               if (visualSupport9.v1(var12.field_1323, var12.field_1322, var12.field_1321, var12.field_1320, var12.field_1325, var12.field_1324)) {
                  visualSupport9.v1(var12, 1509949439);
                  visualSupport9.v1(var12, -218103809, 2.5F);
               }

               if (var22 && var1.v8() && !this.v17) {
                  long var13 = var1.v9();
                  class_238 var15 = v1(
                     Math.min(var23, InternalSupport10.v1(var13)),
                     Math.min(var10, InternalSupport10.v3(var13)),
                     Math.min(var11, InternalSupport10.v2(var13)),
                     Math.max(var23, InternalSupport10.v1(var13)) + 1,
                     Math.max(var10, InternalSupport10.v3(var13)) + 1,
                     Math.max(var11, InternalSupport10.v2(var13)) + 1
                  );
                  visualSupport9.v1(var15, -1493172225, 1.5F);
               }
            }
         }
      } else {
         this.v17 = false;
      }
   }

   private static class_238 v1(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = visualSupport9.v7();
      double var14 = visualSupport9.v8();
      double var16 = visualSupport9.v9();
      double var18 = 0.999;
      return new class_238(
         InternalSupport5.v1(var0, var12, var18),
         InternalSupport5.v1(var2, var14, var18),
         InternalSupport5.v1(var4, var16, var18),
         InternalSupport5.v1(var6, var12, var18),
         InternalSupport5.v1(var8, var14, var18),
         InternalSupport5.v1(var10, var16, var18)
      );
   }

   private void v1(String var1) {
      this.v13.v16().v1(var1, System.currentTimeMillis() + 2500L);
   }
}
