package cc.syky.hud;

import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport11;
import cc.syky.ui.uiSupport14;
import cc.syky.ui.uiSupport169;
import java.util.Arrays;

public final class LastHitSupport extends AbstractHudWidget {
   public static final String v2 = "reach";
   private static final String v3 = "Reach display";
   private static final String v4 = "AVG Reach display";
   private static final String v5 = "Reach";
   private static final String v6 = "AVG Reach";
   private static final String v7 = " Blocks";
   private static final String v8 = " – ";
   private static final float v9 = 2.89F;
   private static final int v10 = 1308622847;
   private static final int v11 = -855638017;
   private static final int v12 = -1;
   private static final float v13 = 0.7F;
   private static final float v14 = 120.0F;
   private static final long v15 = 250L;
   private static final long v16 = 1000000000L;
   private static final int v18 = 0;
   private static final int v19 = 1;
   private static final int v17 = 2;
   private final EnumSetting<LastHitSupport.Part3> v20;
   private final EnumSetting<LastHitSupport.Part2> v21;
   private final IntSetting v22;
   private final BooleanSetting v24;
   private final BooleanSetting v25;
   private final BooleanSetting v26;
   private final IntSetting v27;
   private final hudSupport57 v28 = new hudSupport57(0.0F, 120.0F);
   private long v29;
   private float v30;
   private boolean v32;
   private long v23 = Long.MIN_VALUE;
   private String v33 = "";
   private long v31 = Long.MIN_VALUE;
   private String v34 = "";
   private final String[] v36 = new String[2];
   private final float[] v38 = new float[2];
   private final float[] v42 = new float[2];
   private LastHitSupport.Part1 v43 = new LastHitSupport.Part1(LastHitSupport.Part3.VISUAL, LastHitSupport.Part2.LAST, true, true);

   public LastHitSupport(hudSupport52 var1, float var2, float var3) {
      super("reach", 43, var1, var2, var3);
      AutoSupport var4 = this.v2();
      this.v20 = var4.v1(new EnumSetting<>("design", LastHitSupport.Part3.VISUAL));
      this.v21 = var4.v1(new EnumSetting<>("mode", LastHitSupport.Part2.LAST));
      this.v22 = var4.v1(new IntSetting("samples", 10, 2, 100), SettingCondition.v1(this.v21, LastHitSupport.Part2.AVERAGE));
      this.v24 = var4.v1(new BooleanSetting("label", true), SettingCondition.v1(this.v20, LastHitSupport.Part3.CLASSIC));
      this.v25 = var4.v1(new BooleanSetting("units", true), SettingCondition.v1(this.v20, LastHitSupport.Part3.CLASSIC));
      this.v26 = var4.v1(new BooleanSetting("autoHide", true));
      this.v27 = var4.v1(new IntSetting("hideAfter", 5, 1, 60), SettingCondition.v1(this.v26));
      Arrays.fill(this.v36, "");
      Arrays.fill(this.v38, -1.0F);
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      uiSupport11 var2 = var1.v6().v22();
      if (!var2.v2()) {
         return true;
      } else {
         return !this.v26.getValue() ? false : System.nanoTime() - var2.v5() > this.v27.getValue().intValue() * 1000000000L;
      }
   }

   @Override
   public void v17() {
      this.v32 = false;
   }

   @Override
   public Object v1(hudSupport40 var1) {
      LastHitSupport.Part1 var2 = this.v43;
      if (var2.v1() == this.v20.getValue() && var2.v2() == this.v21.getValue() && var2.v3() == this.v24.getValue() && var2.v4() == this.v25.getValue()) {
         return var2;
      } else {
         this.v43 = new LastHitSupport.Part1(this.v20.getValue(), this.v21.getValue(), this.v24.getValue(), this.v25.getValue());
         return this.v43;
      }
   }

   private LastHitSupport.Part1 v40() {
      return this.v22() instanceof LastHitSupport.Part1 var1 ? var1 : this.v43;
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      if (this.v40().v1() == LastHitSupport.Part3.VISUAL) {
         return this.v12(this.v6(261.0F, var2), this.v6(70.0F, var2));
      } else {
         float var3 = this.v1(0, this.v18(var1), 16.0F * var2);
         return this.v12(uiSupport14.v1(var3, var2), this.v6(36.0F, var2));
      }
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return (this.v40().v1() == LastHitSupport.Part3.VISUAL ? 20.0F : 18.0F) * var3;
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      if (this.v40().v1() == LastHitSupport.Part3.VISUAL) {
         this.v5(var1, var2, var3);
      } else {
         this.v1("syky_sans_strong", this.v18(var1), var2.v2() + 15.0F * var3, var2.v3() + 8.0F * var3, 16.0F * var3, -1);
      }
   }

   private void v5(hudSupport40 var1, hudRecord4 var2, float var3) {
      float var4 = var2.v2();
      float var5 = var2.v3();
      float var6 = this.v15(var1);
      this.v2(
         "syky_sans_strong",
         this.v40().v2() == LastHitSupport.Part2.AVERAGE ? "AVG Reach display" : "Reach display",
         var4 + var2.v4() * 0.5F,
         var5 + 6.0F * var3,
         16.0F * var3,
         CopiedSupport2.v1(-1, 0.7F)
      );
      float var7 = var4 + this.v6(15.0F, var3);
      float var8 = var4 + this.v6(18.0F, var3);
      float var9 = var4 + this.v6(243.0F, var3);
      float var10 = var4 + this.v6(246.0F, var3);
      float var11 = var5 + this.v6(31.0F, var3);
      float var12 = this.v6(50.0F, var3) - this.v6(31.0F, var3);
      float var13 = var5 + this.v6(39.0F, var3);
      float var14 = this.v6(42.0F, var3) - this.v6(39.0F, var3);
      uiRecord7 var15 = uiRecord7.v1(1.5F * var3);
      int var16 = this.v2(-855638017);
      this.v2(hudSupport49.v21, var7, var11, var8 - var7, var12, var16, var15);
      this.v2(hudSupport49.v21, var9, var11, var10 - var9, var12, var16, var15);
      this.v2(hudSupport49.v21, var8, var13, var9 - var8, var14, this.v2(1308622847), uiRecord7.ZERO);
      float var17 = uiSupport14.v2(var6, var1.v6().v33());
      float var18 = uiSupport14.v3(this.v10(var17), var3);
      float var19 = Math.min(var4 + var18, var9);
      if (var19 > var8) {
         this.v2(hudSupport49.v21, var8, var13, var19 - var8, var14, this.v2(-1), uiRecord7.ZERO);
      }

      float var20 = 13.0F * var3;
      this.v2(hudSupport49.v21, var4 + var18 - var20 * 0.5F, var5 + 40.5F * var3 - var20 * 0.5F, var20, var20, this.v2(-1), uiRecord7.v1(var20 * 0.5F));
      String var21 = this.v11(var6);
      float var22 = 13.0F * var3;
      float var23 = this.v1(1, var21, var22);
      this.v2("syky_sans_strong", var21, var4 + uiSupport14.v1(var18, var23, var3), var5 + 47.0F * var3, var22, -1);
   }

   private float v10(float var1) {
      long var2 = System.nanoTime() / 1000000L;
      boolean var4 = var2 - this.v29 > 250L;
      this.v29 = var2;
      if (var4) {
         this.v28.v3(var1);
      } else {
         this.v28.v2(var1);
      }

      return this.v28.v2();
   }

   private float v15(hudSupport40 var1) {
      uiSupport11 var2 = var1.v6().v22();
      if (var2.v2()) {
         float var3 = this.v21.getValue() == LastHitSupport.Part2.AVERAGE ? var2.v1(this.v22.getValue()) : var2.v3();
         this.v30 = var3;
         this.v32 = true;
         return var3;
      } else {
         return this.v32 && this.v19() ? this.v30 : 2.89F;
      }
   }

   private String v18(hudSupport40 var1) {
      String var2 = this.v11(this.v15(var1));
      LastHitSupport.Part1 var3 = this.v40();
      boolean var4 = var3.v2() == LastHitSupport.Part2.AVERAGE;
      boolean var5 = var3.v3();
      boolean var6 = var3.v4();
      long var7 = this.v23 << 3 | (var5 ? 4 : 0) | (var4 ? 2 : 0) | (var6 ? 1 : 0);
      if (var7 != this.v31) {
         this.v31 = var7;
         StringBuilder var9 = new StringBuilder(32);
         if (var5) {
            var9.append(var4 ? "AVG Reach" : "Reach").append(" – ");
         }

         var9.append(var2);
         if (var6) {
            var9.append(" Blocks");
         }

         this.v34 = var9.toString();
      }

      return this.v34;
   }

   private String v11(float var1) {
      long var2 = Math.round(Math.max(var1, 0.0F) * 100.0);
      if (var2 != this.v23) {
         this.v23 = var2;
         long var4 = var2 / 100L;
         long var6 = var2 - var4 * 100L;
         StringBuilder var8 = new StringBuilder(8);
         var8.append(var4).append('.');
         if (var6 < 10L) {
            var8.append('0');
         }

         var8.append(var6);
         this.v33 = var8.toString();
      }

      return this.v33;
   }

   private float v1(int var1, String var2, float var3) {
      if (var3 == this.v38[var1] && var2.equals(this.v36[var1])) {
         return this.v42[var1];
      } else {
         float var4 = uiSupport169.v2("syky_sans_strong", var2, var3);
         this.v36[var1] = var2;
         this.v38[var1] = var3;
         this.v42[var1] = var4;
         return var4;
      }
   }

   public record Part1(LastHitSupport.Part3 design, LastHitSupport.Part2 mode, boolean label, boolean units) {
      public LastHitSupport.Part3 v1() {
         return this.design;
      }

      public LastHitSupport.Part2 v2() {
         return this.mode;
      }

      public boolean v3() {
         return this.label;
      }

      public boolean v4() {
         return this.units;
      }
   }

   public static enum Part2 implements hudSupport64 {
      LAST("Last hit"),
      AVERAGE("Average");

      private final String label;

      private Part2(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }

   public static enum Part3 implements hudSupport64 {
      CLASSIC("Classic"),
      VISUAL("Visual");

      private final String label;

      private Part3(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
