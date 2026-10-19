package cc.syky.cloud;

import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.AbstractHudWidget;
import cc.syky.hud.CopiedSupport2;
import cc.syky.hud.hudRecord4;
import cc.syky.hud.hudSupport16;
import cc.syky.hud.hudSupport40;
import cc.syky.hud.hudSupport43;
import cc.syky.hud.hudSupport49;
import cc.syky.hud.hudSupport52;
import cc.syky.hud.hudSupport64;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport223;
import cc.syky.util.ClipboardUtil;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.class_1309;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_742;
import net.minecraft.class_8685;
import org.jetbrains.annotations.Nullable;

public final class HealthSupport extends AbstractHudWidget {
   public static final String v2 = "target_hud";
   private HealthSupport.Part1 v3 = new HealthSupport.Part1(HealthSupport.Part2.DEFAULT, false);
   private static final float v4 = 200.0F;
   private static final float v5 = 76.0F;
   private static final float v6 = 20.0F;
   private static final float v7 = 5.0F;
   private static final float v8 = 5.0F;
   private static final float v9 = 66.0F;
   private static final float v10 = 15.0F;
   private static final float v11 = 81.0F;
   private static final float v12 = 10.0F;
   private static final float v13 = 16.0F;
   private static final float v14 = 5.0F;
   private static final float v15 = 18.0F;
   private static final float v16 = 4.0F;
   private static final float v18 = 81.0F;
   private static final float v19 = 32.0F;
   private static final float v17 = 13.0F;
   private static final float v20 = 80.0F;
   private static final float v21 = 55.0F;
   private static final float v22 = 109.0F;
   private static final float v24 = 11.0F;
   private static final float v25 = 6.0F;
   private static final int v26 = 1728053247;
   private static final int v27 = -1;
   private static final int v28 = -14548;
   private static final float v29 = 12.0F;
   private static final float v30 = 120.0F;
   private static final long v32 = 250L;
   private static final float v23 = 14.0F;
   private static final int v33 = -10558582;
   private static final int v31 = -41892;
   private static final String v34 = "Health ";
   private static final String v36 = " HP";
   private static final String v38 = "Target";
   private static final String v42 = "Health —";
   private final Supplier<class_1309> v43;
   @Nullable
   private class_1309 v37;
   private final cloudSupport101 v48;
   private final cloudSupport9 v40 = new cloudSupport9(120.0F, 250L);
   private final cloudSupport9 v44 = new cloudSupport9(120.0F, 250L);
   private final EnumSetting<HealthSupport.Part2> v47;
   private final BooleanSetting v49;
   private final ColorSetting v46;
   private final BooleanSetting v51;
   private final BooleanSetting v50;
   private final ColorSetting v60;
   private final ColorSetting v59;
   @Nullable
   private CopiedSupport2 v53;
   private final cloudSupport12<class_1309> v63 = new cloudSupport12<>(var0 -> true);
   private boolean v64;
   private long v61;
   private final cloudSupport11 v66 = new cloudSupport11();
   private final cloudSupport11 v68 = new cloudSupport11();
   private final hudSupport16.Part1 v52 = new hudSupport16.Part1();
   private String v75 = "";
   private float v73 = Float.NaN;
   private final StringBuilder v74 = new StringBuilder(12);
   private final cloudSupport11 v72 = new cloudSupport11();
   @Nullable
   private String v80;
   private float v84 = -1.0F;
   private float v94;
   private float v82;
   private float v99 = -1.0F;

   public HealthSupport(Supplier<class_1309> var1, cloudSupport101 var2, hudSupport52 var3, float var4, float var5) {
      super("target_hud", 47, var3, var4, var5);
      this.v43 = var1;
      this.v48 = var2;
      this.v47 = this.v2().v1(new EnumSetting<>("design", HealthSupport.Part2.DEFAULT));
      this.v49 = this.v2().v1(new BooleanSetting("goldenHearts", true), SettingCondition.v1(this.v47, HealthSupport.Part2.DEFAULT));
      this.v46 = this.v2().v1(new ColorSetting("goldenHeartsColor", -14548).setCondition(this.v49));
      this.v51 = this.v2().v1(new BooleanSetting("winLose", true));
      this.v50 = this.v2().v1(new BooleanSetting("winLoseColors", false), SettingCondition.v1(this.v51));
      this.v60 = this.v2().v1(new ColorSetting("winColor", -10558582), SettingCondition.v1(this.v50));
      this.v59 = this.v2().v1(new ColorSetting("loseColor", -41892), SettingCondition.v1(this.v50));
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      this.v64 = true;
      return this.v44() == null;
   }

   @Override
   public Object v1(hudSupport40 var1) {
      HealthSupport.Part2 var2 = this.v47.getValue();
      boolean var3 = var2 == HealthSupport.Part2.COMPACT && this.v51.getValue();
      HealthSupport.Part1 var4 = this.v3;
      if (var4.v1() == var2 && var4.v2() == var3) {
         return var4;
      } else {
         this.v3 = new HealthSupport.Part1(var2, var3);
         return this.v3;
      }
   }

   private HealthSupport.Part1 v40() {
      return this.v22() instanceof HealthSupport.Part1 var1 ? var1 : this.v3;
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      this.v47();
      if (this.v40().v1() == HealthSupport.Part2.COMPACT) {
         class_1309 var3 = this.v46();
         float var4 = 16.0F * var2;
         float var5 = cloudSupport10.v1(this.v66.v1(v1(var3), var4), this.v1(this.v2(var3), var4), this.v40().v2() ? this.v10(var4) : 0.0F, var2);
         return this.v12(var5, this.v6(36.0F, var2));
      } else {
         return this.v12(this.v6(200.0F, var2), this.v6(76.0F, var2));
      }
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return (this.v40().v1() == HealthSupport.Part2.COMPACT ? 18.0F : 20.0F) * var3;
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v47();
      class_1309 var4 = this.v46();
      if (this.v40().v1() == HealthSupport.Part2.COMPACT) {
         this.v1(var2, var3, var4);
      } else {
         float var5 = 66.0F * var3;
         this.v1(var2.v2() + 5.0F * var3, var2.v3() + 5.0F * var3, var5, 15.0F * var3, var4);
         this.v1(var2.v2(), var2.v3(), var3, var4);
         this.v2(var2.v2(), var2.v3(), var3, var4);
      }
   }

   @Nullable
   private class_1309 v44() {
      class_1309 var1 = this.v43 == null ? null : this.v43.get();
      this.v37 = var1;
      return var1;
   }

   private void v47() {
      long var1 = this.v24();
      if (var1 != this.v61) {
         this.v61 = var1;
         if (!this.v64) {
            this.v44();
         }

         this.v64 = false;
      }
   }

   private void v1(hudRecord4 var1, float var2, @Nullable class_1309 var3) {
      float var4 = var1.v2();
      float var5 = var1.v3();
      float var6 = this.v6(5.0F, var2);
      float var7 = this.v6(31.0F, var2) - var6;
      this.v1(var4 + var6, var5 + var6, var7, 13.0F * var2, var3);
      float var8 = 16.0F * var2;
      float var9 = var5 + uiSupport169.v1(18.0F, 16.0F) * var2;
      String var10 = v1(var3);
      float var11 = var4 + 40.0F * var2;
      this.v1(var10, var11, var9, var2, cloudRecord5.NONE);
      String var12 = this.v2(var3);
      float var13 = cloudSupport10.v1(var11 + this.v66.v1(var10, var8), var2);
      this.v1("syky_sans_strong", var12, var13, var9, var8, -1);
      WinSupport var14 = this.v40().v2() ? this.v3(var3) : null;
      if (var14 != null) {
         float var15 = var13 + this.v1(var12, var8);
         this.v1(this.v8(cloudSupport10.v2(var15, var2)), var5, var2);
         this.v1(var14, var14.v2(), cloudSupport10.v3(var15, var2), var9, var8, cloudRecord5.NONE);
      }
   }

   private static String v1(@Nullable class_1309 var0) {
      return var0 != null ? v4(var0) : "Target";
   }

   private String v2(@Nullable class_1309 var1) {
      float var2 = var1 == null ? 0.0F : Math.max(0.0F, var1.method_6032());
      if (var2 != this.v73 || this.v75.isEmpty()) {
         this.v73 = var2;
         this.v75 = v11(var2) + " HP";
      }

      return this.v75;
   }

   private float v1(String var1, float var2) {
      if (var1 == this.v80 && var2 == this.v84 && this.v94 > 0.0F) {
         return this.v94;
      } else {
         String var3 = this.v52.v1(var2);
         this.v74.setLength(0);

         for (int var4 = 0; var4 < var1.length(); var4++) {
            char var5 = var1.charAt(var4);
            if (var5 >= '0' && var5 <= '9') {
               this.v74.append(var3);
            } else {
               this.v74.append(var5);
            }
         }

         this.v94 = this.v72.v1(this.v74.toString(), var2);
         this.v80 = var1;
         this.v84 = var2;
         return this.v94;
      }
   }

   private float v10(float var1) {
      if (var1 != this.v99 || !(this.v82 > 0.0F)) {
         float var2 = 0.0F;

         for (WinSupport var6 : WinSupport.values()) {
            var2 = Math.max(var2, uiSupport169.v2("syky_sans_strong", var6.v2(), var1));
         }

         this.v82 = var2;
         this.v99 = var1;
      }

      return this.v82;
   }

   @Override
   public void v10(float var1, float var2) {
      if (this.v13(var1, var2)) {
         if (ClipboardUtil.v1(this.v49())) {
            if (this.v53 == null) {
               this.v53 = new CopiedSupport2();
            }

            this.v53.v1(System.nanoTime());
         }
      }
   }

   @Nullable
   private String v49() {
      class_1309 var1 = this.v46();
      return var1 == null ? null : var1.method_5477().getString();
   }

   private boolean v13(float var1, float var2) {
      hudRecord4 var3 = this.v27();
      class_1309 var4 = this.v46();
      if (!var3.v1() && var4 != null) {
         float var5 = this.v60();
         float var6 = uiSupport169.v2("syky_sans_strong", v4(var4), 16.0F * var5);
         if (var6 <= 0.0F) {
            return false;
         } else {
            float var7 = 4.0F * var5;
            if (this.v3.v1() == HealthSupport.Part2.COMPACT) {
               float var12 = var3.v2() + 40.0F * var5 - var7;
               return var1 >= var12 && var1 <= var12 + var6 + var7 * 2.0F && var2 >= var3.v3() && var2 <= var3.v3() + var3.v5();
            } else {
               float var8 = var3.v2() + 81.0F * var5 - var7;
               float var9 = Math.min(var8 + var6 + var7 * 2.0F, var3.v2() + 195.0F * var5);
               float var10 = var3.v3() + 10.0F * var5 - var7;
               float var11 = var10 + 16.0F * var5 + var7 * 2.0F;
               return var1 >= var8 && var1 <= var9 && var2 >= var10 && var2 <= var11;
            }
         }
      } else {
         return false;
      }
   }

   @Nullable
   private class_1309 v46() {
      class_1309 var1 = this.v63.v1(this.v37, this.v19());
      return var1 != null ? var1 : this.v59();
   }

   @Override
   public void v17() {
      this.v63.v1();
      this.v37 = null;
   }

   @Nullable
   private class_1309 v59() {
      if (this.v48 == null) {
         return null;
      } else {
         class_310 var1 = this.v48.v1();
         return var1 == null ? null : var1.field_1724;
      }
   }

   private void v1(float var1, float var2, float var3, float var4, @Nullable class_1309 var5) {
      uiRecord7 var6 = uiRecord7.v1(var4);
      if (var5 instanceof class_742 var7) {
         class_2960 var8 = v1(var7);
         uiSupport169.v1(var8, var1, var2, var3, -1, var6);
      } else {
         this.v1(hudSupport49.v17, var1, var2, var3, var3, -1, var6);
      }
   }

   private static class_2960 v1(class_742 var0) {
      class_8685 var1 = var0.method_52814();
      return var1.comp_1626().comp_3627();
   }

   private void v1(float var1, float var2, float var3, @Nullable class_1309 var4) {
      String var5 = var4 != null ? v4(var4) : "Target";
      String var6 = var4 != null ? v5(var4) : "Health —";
      float var7 = var1 + 81.0F * var3;
      float var8 = var2 + 10.0F * var3;
      float var9 = var1 + 81.0F * var3;
      float var10 = var2 + 32.0F * var3;
      cloudRecord5 var11 = cloudRecord5.NONE.v1(var1 + 195.0F * var3, 18.0F * var3);
      this.v1(var5, var7, var8, var3, var11);
      float var12 = 13.0F * var3;
      WinSupport var13 = this.v3(var4);
      if (var13 == null) {
         this.v1("syky_sans_strong", var6, var9, var10, var12, -1, var11);
      } else {
         float var14 = var9 + uiSupport169.v2("syky_sans_strong", var6, var12);
         float var15 = var14 + 13.0F * var3;
         float var16 = var15 + uiSupport169.v2("syky_sans_strong", var13.v1(), var12);
         cloudRecord5 var17 = var16 <= var1 + 195.0F * var3 ? cloudRecord5.NONE : var11;
         this.v1("syky_sans_strong", var6, var9, var10, var12, -1, var17);
         float var18 = this.v6(14.0F, var3);
         float var19 = var10 - uiSupport169.v1(0.0F, var12);
         this.v3(this.v8(var14 + 6.0F * var3), this.v8(var19 - var18 * 0.5F), var18, var3);
         this.v1(var13, var15, var10, var12, var17);
      }
   }

   @Nullable
   private WinSupport v3(@Nullable class_1309 var1) {
      if (this.v51.getValue() && var1 != null) {
         class_1309 var2 = this.v59();
         return var2 == null
            ? null
            : WinSupport.v3(WinSupport.v2(var2.method_6032(), var2.method_6067()), WinSupport.v2(var1.method_6032(), var1.method_6067()));
      } else {
         return null;
      }
   }

   private void v1(WinSupport var1, float var2, float var3, float var4, cloudRecord5 var5) {
      this.v1(var1, var1.v1(), var2, var3, var4, var5);
   }

   private void v1(WinSupport var1, String var2, float var3, float var4, float var5, cloudRecord5 var6) {
      if (this.v50.getValue() && var1 != WinSupport.DRAW) {
         int var7 = var1 == WinSupport.WIN ? this.v60.getValue() : this.v59.getValue();
         uiSupport169.v1("syky_sans_strong", var2, var3, var4, var5, var7, var6);
      } else {
         this.v1("syky_sans_strong", var2, var3, var4, var5, -1, var6);
      }
   }

   private void v1(String var1, float var2, float var3, float var4, cloudRecord5 var5) {
      float var6 = 16.0F * var4;
      CopiedSupport2 var7 = this.v53;
      if (var7 != null) {
         long var8 = System.nanoTime();
         if (var7.v2(var8)) {
            var7.v3(var8);
            this.v1(var7.v1(), var1, var2, var3, var6, var4, var5);
            this.v1(var7.v2(), "Copied!", var2, var3, var6, var4, var5);
            return;
         }
      }

      this.v1("syky_sans_strong", var1, var2, var3, var6, -1, var5);
   }

   private void v1(CopiedSupport2.Part1 var1, String var2, float var3, float var4, float var5, float var6, cloudRecord5 var7) {
      if (!(var1.v1() <= 0.003921569F)) {
         float var8 = uiSupport169.v2("syky_sans_strong", var2, var5);
         this.v1(var1, "syky_sans_strong", var2, var3, var4 + var1.v2() * var6, var8, var5, -1, var7);
      }
   }

   private static String v4(class_1309 var0) {
      return uiSupport223.v1(var0.method_5667()) ? "Protected" : var0.method_5477().getString();
   }

   private void v2(float var1, float var2, float var3, @Nullable class_1309 var4) {
      float var5 = var1 + this.v6(80.0F, var3);
      float var6 = var2 + this.v6(55.0F, var3);
      float var7 = this.v6(189.0F, var3) - this.v6(80.0F, var3);
      float var8 = this.v6(66.0F, var3) - this.v6(55.0F, var3);
      uiRecord7 var9 = uiRecord7.v1(6.0F * var3);
      this.v2(hudSupport49.v21, var5, var6, var7, var8, this.v2(1728053247), var9);
      if (var4 != null) {
         UUID var10 = var4.method_5667();
         boolean var11 = this.v49.getValue();
         float var12 = var11 ? Math.max(0.0F, var4.method_6067()) : 0.0F;
         float var13 = cloudSupport9.v1(var4.method_6063(), var12);
         float var14 = this.v40.v1(var10, cloudSupport9.v2(var4.method_6032(), var13));
         if (var11) {
            float var15 = this.v44.v1(var10, cloudSupport9.v2(var4.method_6032() + var12, var13));
            if (var15 > var14) {
               this.v1(var5, var6, var7, var8, var3, var15, this.v46.getValue(), false, var9);
            }
         }

         this.v1(var5, var6, var7, var8, var3, var14, this.v2(-1), true, var9);
      }
   }

   private void v1(float var1, float var2, float var3, float var4, float var5, float var6, int var7, boolean var8, uiRecord7 var9) {
      if (!(var6 <= 0.0F)) {
         float var10 = var3 * var6;
         float var11 = 12.0F * var5;
         if (var10 < var11) {
            var10 = var11;
         }

         if (var10 > var3) {
            var10 = var3;
         }

         if (var8) {
            this.v2(hudSupport49.v21, var1, var2, var10, var4, var7, var9);
         } else {
            uiSupport169.v1(hudSupport49.v21, var1, var2, var10, var4, var7, var9);
         }
      }
   }

   private static String v5(class_1309 var0) {
      return "Health " + v11(Math.max(0.0F, var0.method_6032()));
   }

   private static String v11(float var0) {
      if (!(var0 >= 2.0F) && !(var0 <= 0.0F)) {
         long var1 = Math.round(var0 * 100.0);
         long var3 = var1 / 100L;
         long var5 = var1 - var3 * 100L;
         if (var5 == 0L) {
            return Long.toString(var3);
         } else {
            StringBuilder var7 = new StringBuilder(8);
            var7.append(var3).append('.');
            if (var5 < 10L) {
               var7.append('0').append(var5);
            } else if (var5 % 10L == 0L) {
               var7.append(var5 / 10L);
            } else {
               var7.append(var5);
            }

            return var7.toString();
         }
      } else {
         return hudSupport43.v1(var0);
      }
   }

   public record Part1(HealthSupport.Part2 design, boolean verdict) {
      public HealthSupport.Part2 v1() {
         return this.design;
      }

      public boolean v2() {
         return this.verdict;
      }
   }

   public static enum Part2 implements hudSupport64 {
      DEFAULT("Default"),
      COMPACT("Compact");

      private final String label;

      private Part2(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
