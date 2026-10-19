package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.config.EnumSetting;
import cc.syky.config.SettingCondition;
import cc.syky.ui.RowSupport2;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public final class hudSupport23 extends AbstractHudWidget {
   public static final String v2 = "armor";
   private static final class_1304[] v3 = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};
   private static final int v4 = 4;
   private static final String v5 = " %";
   private static final int v6 = -2130706433;
   private static final String v7 = "100 %";
   private static final String v8 = "999";
   private static final int v9 = 872415231;
   private static final int v10 = -1;
   private static final int v11 = -2332;
   private static final int v12 = -30720;
   private static final int v13 = -65532;
   private static final float v14 = 0.6F;
   private static final float v15 = 0.35F;
   private static final float v16 = 0.15F;
   private static final int v18 = 452984831;
   private static final float v19 = 6.0F;
   private static final float v17 = 0.4F;
   private static final AtomicInteger v20 = new AtomicInteger();
   private final cloudSupport101 v21;
   private final EnumSetting<RowSupport2.Part2> v22;
   private final EnumSetting<PercentSupport> v24;
   private final EnumSetting<RowSupport2.Part1> v25;
   private final class_1799[] v26 = new class_1799[4];
   private final int[] v27 = new int[4];
   private final String[] v28 = new String[4];
   private final float[] v29 = new float[4];
   private final float[] v30 = new float[4];
   private final float[] v32 = new float[4];
   private final float[] v23 = new float[4];
   private final float[] v33 = new float[4];
   private final float[] v31 = new float[4];
   private final float[] v34 = new float[4];
   private final float[] v36 = new float[4];
   private final float[] v38 = new float[4];
   private final float[] v42 = new float[4];
   private int v43;
   private float v37;
   private float v48;
   private float v40;
   private final hudSupport17<Integer> v44 = new hudSupport17<>(var0 -> var0);
   private final List<Integer> v47 = new ArrayList<>(4);
   private final List<Integer> v49 = new ArrayList<>(4);
   private final class_1799[] v46 = new class_1799[4];
   private final boolean[] v51 = new boolean[4];
   private final int[] v50 = new int[4];
   private final String[] v60 = new String[4];
   private final String[] v59 = new String[5];
   private final float[] v53 = new float[5];
   private final float[] v63 = new float[5];
   private final hudSupport13 v64 = new hudSupport13("armor", 4);
   @Nullable
   private GpuTextureView v61;
   private hudSupport23.Part1 v66 = new hudSupport23.Part1(RowSupport2.Part2.SLOTS, PercentSupport.PERCENT, RowSupport2.Part1.RIGHT);

   public static void v40() {
      v20.incrementAndGet();
   }

   public hudSupport23(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("armor", 43, var2, var3, var4);
      this.v21 = var1;
      AutoSupport var5 = this.v2();
      this.v22 = var5.v1(new EnumSetting<>("layout", RowSupport2.Part2.LIST));
      this.v24 = var5.v1(new EnumSetting<>("readout", PercentSupport.PERCENT), SettingCondition.v2(this.v22, RowSupport2.Part2.SLOTS));
      this.v25 = var5.v1(new EnumSetting<>("numberSide", RowSupport2.Part1.RIGHT), SettingCondition.v1(this.v22, RowSupport2.Part2.LIST));
      Arrays.fill(this.v26, class_1799.field_8037);
      Arrays.fill(this.v46, class_1799.field_8037);
      Arrays.fill(this.v28, "");
      Arrays.fill(this.v50, Integer.MIN_VALUE);
      Arrays.fill(this.v60, "");
      Arrays.fill(this.v59, "");
      Arrays.fill(this.v53, -1.0F);
   }

   @Nullable
   @Override
   public Object v1(hudSupport40 var1) {
      hudSupport23.Part1 var2 = this.v66;
      if (var2.v1() != this.v22.getValue() || var2.v2() != this.v24.getValue() || var2.v3() != this.v25.getValue()) {
         var2 = new hudSupport23.Part1(this.v22.getValue(), this.v24.getValue(), this.v25.getValue());
         this.v66 = var2;
      }

      return var2.v1() == RowSupport2.Part2.SLOTS ? null : var2;
   }

   private hudSupport23.Part1 v44() {
      return this.v22() instanceof hudSupport23.Part1 var1 ? var1 : this.v66;
   }

   private RowSupport2.Part2 v47() {
      return this.v44().v1();
   }

   private PercentSupport v49() {
      return this.v44().v2();
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      class_746 var2 = this.v59();
      if (var2 == null) {
         return true;
      } else {
         for (class_1304 var6 : v3) {
            if (!var2.method_6118(var6).method_7960()) {
               return false;
            }
         }

         return true;
      }
   }

   @Override
   public void v17() {
      this.v44.v5();
      this.v49.clear();
      Arrays.fill(this.v46, class_1799.field_8037);
   }

   @Override
   public boolean v30() {
      return true;
   }

   @Override
   public float a_(hudSupport40 var1) {
      return this.v5(var1) * RowSupport2.v1(this.v47());
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      this.v5(var1, var2);
      return this.v12(this.v37, this.v48);
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return RowSupport2.v3(this.v47(), var2.v4(), var2.v5(), var3);
   }

   @Override
   public void v1(hudSupport40 var1, hudRecord4 var2, float var3) {
      if (this.v43 != 0) {
         if (this.v47() != RowSupport2.Part2.SLOTS) {
            super.v1(var1, var2, var3);
         } else {
            float var4 = this.v40;

            for (int var5 = 0; var5 < this.v43; var5++) {
               float var6 = this.v42[var5];
               if (!(var6 <= 0.0F)) {
                  float var7 = var2.v2() + this.v38[var5];
                  float var8 = var2.v3() + (var4 - var6) * 0.5F;
                  this.v1(var7, var8, var6, var6, 10.0F * var3 * (var6 / var4), var3);
               }
            }
         }
      }
   }

   @Override
   public void v4(hudSupport40 var1, float var2) {
      this.v5(var1, var2);
      this.v61 = this.v43 == 0 ? null : this.v6(var1, var2);
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v5(var1, var3);
      if (this.v43 != 0) {
         RowSupport2.Part2 var4 = this.v47();
         GpuTextureView var5 = this.v61;
         boolean var6 = RowSupport2.v5(var4);
         float var7 = RowSupport2.v2(var4, var3);
         float var8 = 5.2000003F * var3;
         List var9 = this.v44.v1();

         for (int var10 = 0; var10 < this.v43; var10++) {
            hudSupport17.Part1 var11 = (hudSupport17.Part1)var9.get(var10);
            int var12 = var10;
            if (!var11.v3()) {
               this.v1(var12, var2, var3, var5, 1.0F);
            } else {
               hudSupport18 var13 = var11.v5();
               float var14 = var7 + this.v36[var10];
               this.v1(
                  var6 ? var2.v2() : var2.v2() + var14,
                  var6 ? var2.v3() + var14 : var2.v3(),
                  var6 ? this.v37 : this.v40,
                  var6 ? this.v40 : this.v48,
                  var8,
                  var13.v2(),
                  var13.v4(),
                  var13.v5(),
                  var13.v6() * var1.v5(),
                  var5x -> this.v1(var12, var2, var3, var5, var5x)
               );
            }
         }
      }
   }

   @Override
   public void v4(hudSupport40 var1, hudRecord4 var2, float var3) {
      Object var4 = this.v21().v1();
      this.v1(this.v21().v2());
      float var5 = this.a_(var1);
      this.v5(var1, var5);
      int var6 = this.v43;
      System.arraycopy(this.v30, 0, this.v32, 0, 4);
      System.arraycopy(this.v33, 0, this.v23, 0, 4);
      float var7 = RowSupport2.v4(this.v47()) * var5;
      this.v1(var4);
      float var8 = this.a_(var1);
      this.v5(var1, var8);
      var6 = Math.min(var6, this.v43);
      float var9 = RowSupport2.v4(this.v47()) * var8;
      float var10 = var7 + (var9 - var7) * var3;

      for (int var11 = 0; var11 < var6; var11++) {
         if (!this.v26[var11].method_7960()) {
            float var12 = v2(this.v1(var2, this.v32[var11], true), this.v1(var2, this.v30[var11], false), var3);
            float var13 = v2(this.v2(var2, this.v23[var11], true), this.v2(var2, this.v33[var11], false), var3);
            this.v1(var11, var12, var13, var10);
         }
      }
   }

   private static float v2(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   private void v1(int var1, hudRecord4 var2, float var3, @Nullable GpuTextureView var4, float var5) {
      if (!this.v51()) {
         this.v1(var1, var2, var3, var4);
      }

      if (this.v47() == RowSupport2.Part2.SLOTS) {
         this.v1(var1, var2, var3, var5);
      } else {
         this.v2(var1, var2, var3, var5);
      }
   }

   private void v5(hudSupport40 var1, float var2) {
      boolean var3 = var1.v7();
      class_746 var4 = this.v59();

      for (int var5 = 0; var5 < 4; var5++) {
         class_1799 var6 = v1(var4, var5);
         this.v51[var5] = !var6.method_7960();
         if (this.v51[var5] && !class_1799.method_7973(this.v46[var5], var6)) {
            this.v46[var5] = var6.method_7972();
         }
      }

      this.v47.clear();

      for (int var15 = 0; var15 < 4; var15++) {
         if (var3 || this.v51[var15]) {
            this.v47.add(var15);
         }
      }

      List var16 = this.v47;
      if (this.v47.isEmpty() && this.v19() && !this.v49.isEmpty()) {
         var16 = this.v49;
      } else if (!this.v47.isEmpty()) {
         this.v49.clear();
         this.v49.addAll(this.v47);
      }

      this.v44.v1(var16, System.nanoTime(), this.v18().v5());

      for (int var17 = 0; var17 < 4; var17++) {
         if (!this.v51[var17] && (var3 || !this.v3(var17))) {
            this.v46[var17] = class_1799.field_8037;
         }
      }

      RowSupport2.Part2 var18 = this.v47();
      boolean var7 = RowSupport2.v2(var18);
      float var8 = 13.0F * var2;
      List var9 = this.v44.v1();
      this.v43 = Math.min(var9.size(), 4);
      float var10 = 0.0F;

      for (int var11 = 0; var11 < this.v43; var11++) {
         int var12 = (Integer)((hudSupport17.Part1)var9.get(var11)).v1();
         class_1799 var13 = this.v46[var12];
         this.v27[var11] = var12;
         this.v26[var11] = var13;
         String var14 = var7 ? this.v1(var12, var13) : "";
         this.v28[var11] = var14;
         this.v29[var11] = this.v1(var12, var14, var8);
         var10 = Math.max(var10, this.v29[var11]);
      }

      this.v40 = this.v8(RowSupport2.v1(var18, var10, var2));
      this.v44.v1(this.v40, this.v8(RowSupport2.v1(var18, var2)));

      for (int var19 = 0; var19 < this.v43; var19++) {
         hudSupport17.Part1 var21 = (hudSupport17.Part1)var9.get(var19);
         this.v38[var19] = var21.v6();
         this.v42[var19] = var21.v7();
         this.v36[var19] = var21.v6() + (var21.v7() - this.v40) * 0.5F;
      }

      float var20 = this.v44.v3();
      this.v37 = RowSupport2.v1(var18, var20, var10, var2);
      this.v48 = RowSupport2.v2(var18, var20, var10, var2);
      RowSupport2.v1(var18, this.v44().v3(), this.v43, var10, this.v29, this.v36, var2, this.v30, this.v33, this.v31, this.v34);
      this.v1(var18);
   }

   private void v1(RowSupport2.Part2 var1) {
      boolean var2 = RowSupport2.v5(var1);

      for (int var3 = 0; var3 < this.v43; var3++) {
         float var4 = this.v36[var3];
         if (var2) {
            this.v30[var3] = this.v8(this.v30[var3]);
            this.v33[var3] = var4 + this.v8(this.v33[var3] - var4);
         } else {
            this.v30[var3] = var4 + this.v8(this.v30[var3] - var4);
            this.v33[var3] = this.v8(this.v33[var3]);
         }
      }
   }

   private boolean v3(int var1) {
      List var2 = this.v44.v1();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         if ((Integer)((hudSupport17.Part1)var2.get(var3)).v1() == var1) {
            return true;
         }
      }

      return false;
   }

   private static class_1799 v1(@Nullable class_746 var0, int var1) {
      return var0 == null ? class_1799.field_8037 : var0.method_6118(v3[var1]);
   }

   private String v1(int var1, class_1799 var2) {
      if (v1(var2)) {
         return this.v2(var1, var2);
      } else if (!var2.method_7960()) {
         return "";
      } else {
         return this.v49() == PercentSupport.PERCENT ? "100 %" : "999";
      }
   }

   private String v2(int var1, class_1799 var2) {
      boolean var3 = this.v49() == PercentSupport.PERCENT;
      int var4 = PercentSupport.v1(var2.method_7919(), var2.method_7936());
      int var5 = var3 ? PercentSupport.v2(var4, var2.method_7936()) : var4;
      int var6 = var3 ? ~var5 : var5;
      if (this.v50[var1] != var6) {
         this.v50[var1] = var6;
         this.v60[var1] = Integer.toString(var5);
      }

      return this.v60[var1];
   }

   private float v1(int var1, String var2, float var3) {
      if (var2.isEmpty()) {
         return 0.0F;
      } else {
         float var4 = this.v2(var1, var2, var3);
         return this.v1(var2) ? var4 + this.v2(4, " %", var3) : var4;
      }
   }

   private boolean v1(String var1) {
      return this.v49() == PercentSupport.PERCENT && !"100 %".equals(var1);
   }

   private float v2(int var1, String var2, float var3) {
      if (var3 == this.v53[var1] && var2.equals(this.v59[var1])) {
         return this.v63[var1];
      } else {
         float var4 = uiSupport169.v2("syky_sans_strong", var2, var3);
         this.v59[var1] = var2;
         this.v53[var1] = var3;
         this.v63[var1] = var4;
         return var4;
      }
   }

   @Nullable
   private GpuTextureView v6(hudSupport40 var1, float var2) {
      if (!this.v46()) {
         return null;
      } else {
         float var3 = this.v9(hudSupport13.v1(var1, var2));
         this.v64.v1(this.v43, RowSupport2.v4(this.v47()), var3, v20.get());

         for (int var4 = 0; var4 < this.v43; var4++) {
            this.v64.v1(var4, this.v26[var4]);
         }

         return this.v64.v1();
      }
   }

   private void v1(int var1, hudRecord4 var2, float var3, @Nullable GpuTextureView var4) {
      float var5 = this.v6(RowSupport2.v4(this.v47()), var3);
      float var6 = var2.v2() + this.v30[var1];
      float var7 = var2.v3() + this.v33[var1];
      if (this.v26[var1].method_7960()) {
         if (this.v47() != RowSupport2.Part2.SLOTS) {
            this.v1(var6, var7, var5, var5, this.v2(452984831), uiRecord7.v1(6.0F * var3));
         }
      } else if (var4 != null) {
         this.v1(var1, var6, var7, var5);
      }
   }

   private void v1(int var1, float var2, float var3, float var4) {
      if (this.v61 != null && !this.v26[var1].method_7960()) {
         this.v64.v1(var1, var2, var3, var4);
         uiSupport169.v12();
      }
   }

   private void v1(int var1, hudRecord4 var2, float var3, float var4) {
      class_1799 var5 = this.v26[var1];
      if (var5.method_7960() || v1(var5)) {
         float var6 = 30.0F * var3;
         float var7 = this.v6(35.0F, var3);
         float var8 = this.v6(38.0F, var3) - var7;
         uiRecord7 var9 = uiRecord7.v1(var8 * 0.5F);
         float var10 = var2.v3() + var7;
         float var11 = var2.v2() + this.v36[var1] + 6.0F * var3;
         uiSupport169.v1(var11, var10, var6, var8, CopiedSupport2.v1(this.v2(872415231), var4), var9);
         if (!var5.method_7960()) {
            float var12 = Math.clamp((float)(var5.method_7936() - var5.method_7919()) / var5.method_7936(), 0.0F, 1.0F);
            float var13 = var6 * var12;
            int var14 = CopiedSupport2.v1(v10(var12), var4);
            uiSupport169.v1(var11 + (var6 - var13) * 0.5F, var10, var13, var8, var14, var9);
         }
      }
   }

   private void v2(int var1, hudRecord4 var2, float var3, float var4) {
      String var5 = this.v28[var1];
      if (!var5.isEmpty()) {
         float var6 = 13.0F * var3;
         float var7 = var2.v2() + this.v31[var1];
         float var8 = var2.v3() + v13(this.v34[var1], var6);
         boolean var9 = this.v26[var1].method_7960();
         int var10 = var9 ? 452984831 : -1;
         this.v1("syky_sans_strong", var5, var7, var8, var6, CopiedSupport2.v1(var10, var4));
         if (!var9 && this.v1(var5)) {
            float var11 = var7 + this.v2(this.v27[var1], var5, var6);
            this.v1("syky_sans_strong", " %", var11, var8, var6, CopiedSupport2.v1(-2130706433, var4));
         }
      }
   }

   private static float v13(float var0, float var1) {
      return var0 - 0.24124998F * var1;
   }

   private boolean v46() {
      for (int var1 = 0; var1 < this.v43; var1++) {
         if (!this.v26[var1].method_7960()) {
            return true;
         }
      }

      return false;
   }

   private static boolean v1(class_1799 var0) {
      return !var0.method_7960() && var0.method_7963() && var0.method_7936() > 0;
   }

   private static int v10(float var0) {
      if (var0 >= 0.6F) {
         return -1;
      } else if (var0 >= 0.35F) {
         return -2332;
      } else {
         return var0 >= 0.15F ? -30720 : -65532;
      }
   }

   @Nullable
   private class_746 v59() {
      class_310 var1 = this.v21.v1();
      return var1 == null ? null : var1.field_1724;
   }

   public record Part1(RowSupport2.Part2 shape, PercentSupport readout, RowSupport2.Part1 side) {
      public RowSupport2.Part2 v1() {
         return this.shape;
      }

      public PercentSupport v2() {
         return this.readout;
      }

      public RowSupport2.Part1 v3() {
         return this.side;
      }
   }
}
