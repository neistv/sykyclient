package cc.syky.hud;

import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.utilities.EndCrystalSupport;
import cc.syky.ui.RowSupport;
import cc.syky.ui.uiSupport169;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_1799;
import org.jetbrains.annotations.Nullable;

public final class NoItemsSupport extends HudElement {
   public static final String v2 = "item_counter";
   private static final String v3 = "No items selected";
   private static final int v4 = -1275068417;
   private static final AtomicInteger v5 = new AtomicInteger();
   private final EnumSetting<RowSupport.Part2> v6;
   private final EnumSetting<RowSupport.Part1> v7;
   private final BooleanSetting[] v8 = new BooleanSetting[EndCrystalSupport.COUNT];
   private final int[] v9 = new int[EndCrystalSupport.COUNT];
   private final boolean[] v10 = new boolean[EndCrystalSupport.COUNT];
   private final int[] v11 = new int[EndCrystalSupport.COUNT];
   private final String[] v12 = new String[EndCrystalSupport.COUNT];
   private final float[] v13 = new float[EndCrystalSupport.COUNT];
   private final float[] v14 = new float[EndCrystalSupport.COUNT];
   private final float[] v15 = new float[EndCrystalSupport.COUNT];
   private final float[] v16 = new float[EndCrystalSupport.COUNT];
   private final float[] v18 = new float[EndCrystalSupport.COUNT];
   private int v19;
   private final int[] v17 = new int[EndCrystalSupport.COUNT];
   private final int[] v20 = new int[EndCrystalSupport.COUNT];
   private final String[] v21 = new String[EndCrystalSupport.COUNT];
   private final int[] v22 = new int[EndCrystalSupport.COUNT];
   private final String[] v24 = new String[EndCrystalSupport.COUNT];
   private final String[] v25 = new String[EndCrystalSupport.COUNT];
   private final float[] v26 = new float[EndCrystalSupport.COUNT];
   private final float[] v27 = new float[EndCrystalSupport.COUNT];
   private float v28 = -1.0F;
   private float v29;
   private final hudSupport13 v30 = new hudSupport13("item_counter", EndCrystalSupport.COUNT);
   private final class_1799[] v32 = new class_1799[EndCrystalSupport.COUNT];
   private final int[] v23 = new int[EndCrystalSupport.COUNT];
   private final NoItemsSupport.Part1 v33 = new NoItemsSupport.Part1();

   public static void v40() {
      v5.incrementAndGet();
   }

   public NoItemsSupport(hudSupport52 var1, float var2, float var3) {
      super("item_counter", 43, var1, var2, var3);
      AutoSupport var4 = this.v2();
      this.v6 = var4.v1(new EnumSetting<>("layout", RowSupport.Part2.ROW));
      this.v7 = var4.v1(new EnumSetting<>("numberSide", RowSupport.Part1.RIGHT), SettingCondition.v1(this.v6, RowSupport.Part2.LIST));

      for (EndCrystalSupport var6 : EndCrystalSupport.CONSUMABLES) {
         this.v8[var6.v3()] = var4.v1(new BooleanSetting(var6.v2(), true));
      }

      Arrays.fill(this.v22, -1);
      Arrays.fill(this.v24, "");
      Arrays.fill(this.v25, "");
      Arrays.fill(this.v26, -1.0F);
   }

   @Override
   public boolean v43() {
      return true;
   }

   @Override
   public boolean v37() {
      return true;
   }

   @Override
   public boolean v1(hudSupport40 var1, float[] var2) {
      NoItemsSupport.Part1 var3 = this.v15(var1);
      if (var3 == null) {
         return false;
      } else {
         var2[0] = var3.v7;
         var2[1] = var3.v8;
         return true;
      }
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      int[] var2 = var1.v6().v44();

      for (int var3 = 0; var3 < EndCrystalSupport.COUNT; var3++) {
         if (var2[var3] > 0 && this.v3(var3)) {
            return false;
         }
      }

      return true;
   }

   private boolean v3(int var1) {
      BooleanSetting var2 = this.v8[var1];
      return var2 != null && var2.getValue();
   }

   @Override
   public void v17() {
      this.v19 = 0;
   }

   @Override
   public void v8(hudSupport40 var1) {
      NoItemsSupport.Part1 var2 = this.v14(var1);
      if (var2 == null) {
         this.v2(hudRecord4.EMPTY);
      } else {
         this.v1(var1, var2.v5, var2.v6, var2.v7, var2.v8, var2.v9);
         this.v2(new hudRecord4(var2.v3, var2.v4, var2.v7, var2.v8));
      }
   }

   @Override
   public final boolean v33() {
      return true;
   }

   @Override
   public void v10(hudSupport40 var1) {
      NoItemsSupport.Part1 var2 = this.v14(var1);
      this.v2(var2 == null ? hudRecord4.EMPTY : new hudRecord4(var2.v3, var2.v4, var2.v7, var2.v8));
   }

   @Override
   public hudRecord4 v9(hudSupport40 var1) {
      NoItemsSupport.Part1 var2 = this.v14(var1);
      if (var2 == null) {
         this.v2(hudRecord4.EMPTY);
         return hudRecord4.EMPTY;
      } else {
         this.v1(var1, var2);
         this.v2(var2);
         hudRecord4 var3 = new hudRecord4(var2.v3, var2.v4, var2.v7, var2.v8);
         this.v2(var3);
         return var3;
      }
   }

   @Override
   public void v1(hudSupport40 var1, HudElement.Part2 var2) {
      NoItemsSupport.Part1 var3 = this.v14(var1);
      if (var3 == null) {
         this.v2(hudRecord4.EMPTY);
      } else {
         if (var2 == HudElement.Part2.ICONS) {
            this.v1(var1, var3);
            this.v2(new hudRecord4(var3.v3, var3.v4, var3.v7, var3.v8));
         } else {
            this.v2(var3);
         }
      }
   }

   private void v1(hudSupport40 var1, NoItemsSupport.Part1 var2) {
      this.v1(var2);
      this.v2(var1, var2);
   }

   private void v1(NoItemsSupport.Part1 var1) {
      if (!RowSupport.v1(var1.v1)) {
         for (int var5 = 1; var5 < var1.v2; var5++) {
            this.v1(var1.v5 + this.v8(RowSupport.v1(var5, this.v14, var1.v11)), var1.v6, var1.v11);
         }
      } else {
         float var2 = this.v6(4.0F, var1.v11);
         float var3 = var1.v7 - 2.0F * var2;

         for (int var4 = 1; var4 < var1.v2; var4++) {
            this.v4(var1.v5 + var2, var1.v6 + this.v8(RowSupport.v1(var4, this.v15, var1.v11)), var3, var1.v11);
         }
      }
   }

   private void v2(NoItemsSupport.Part1 var1) {
      float var2 = var1.v10;
      if (var1.v2 == 0) {
         this.v1("syky_sans_strong", "No items selected", var1.v5 + 10.0F * var1.v11, var1.v6 + 8.0F * var1.v11, var2, -1275068417);
      } else {
         for (int var3 = 0; var3 < var1.v2; var3++) {
            this.v1("syky_sans_strong", this.v12[var3], var1.v5 + this.v16[var3], var1.v6 + this.v18[var3], var2, -1);
         }
      }
   }

   private void v2(hudSupport40 var1, NoItemsSupport.Part1 var2) {
      int var3 = var2.v2;
      if (var3 != 0) {
         this.v30.v1(var3, 24.0F, this.v9(hudSupport13.v1(var1, var2.v11)), v5.get());

         for (int var4 = 0; var4 < var3; var4++) {
            this.v30.v1(var4, this.v1(this.v9[var4], this.v11[var4]));
         }

         if (this.v30.v1() != null) {
            float var6 = this.v6(24.0F, var2.v11);

            for (int var5 = 0; var5 < var3; var5++) {
               this.v30.v1(var5, var2.v5 + this.v8(this.v14[var5]), var2.v6 + this.v8(this.v15[var5]), var6);
            }

            uiSupport169.v12();
         }
      }
   }

   private class_1799 v1(int var1, int var2) {
      class_1799 var3 = this.v32[var1];
      if (var3 == null || this.v23[var1] != var2) {
         var3 = EndCrystalSupport.VALUES.get(var1).v1(var2);
         this.v32[var1] = var3;
         this.v23[var1] = var2;
      }

      return var3;
   }

   @Nullable
   private NoItemsSupport.Part1 v14(hudSupport40 var1) {
      NoItemsSupport.Part1 var2 = this.v15(var1);
      if (var2 == null) {
         return null;
      } else {
         var2.v3 = this.v8(this.v1(var1, var2.v7));
         var2.v4 = this.v8(this.v2(var1, var2.v8));
         var2.v5 = var2.v3 + this.v15();
         var2.v6 = var2.v4 + this.v16();
         return var2;
      }
   }

   @Nullable
   private NoItemsSupport.Part1 v15(hudSupport40 var1) {
      int[] var2 = var1.v6().v44();

      for (int var3 = 0; var3 < EndCrystalSupport.COUNT; var3++) {
         this.v10[var3] = this.v3(var3);
      }

      boolean var14 = var1.v7();
      int var4 = RowSupport.v1(var2, this.v10, var14, this.v9);
      boolean var5 = var4 == 0 && this.v19() && this.v19 > 0;
      if (var5) {
         var4 = this.v19;
         System.arraycopy(this.v17, 0, this.v9, 0, var4);
      } else if (var4 == 0 && !var14) {
         this.v19 = 0;
         return null;
      }

      float var6 = this.v5(var1);
      float var7 = 16.0F * var6;
      RowSupport.Part2 var8 = this.v6.getValue();
      float var9;
      if (var4 == 0) {
         var9 = RowSupport.v1(this.v10(var7), var6);
      } else {
         int[] var10 = var1.v6().v47();

         for (int var11 = 0; var11 < var4; var11++) {
            int var12 = this.v9[var11];
            String var13 = var5 ? this.v21[var11] : this.v2(var12, var2[var12]);
            this.v12[var11] = var13;
            this.v13[var11] = this.v1(var12, var13, var7);
            this.v11[var11] = var5 ? this.v20[var11] : EndCrystalSupport.v2(var10[var12]);
         }

         var9 = RowSupport.v1(var8, this.v7.getValue(), var4, this.v13, var6, this.v14, this.v15, this.v16, this.v18);
         if (!var5) {
            this.v19 = var4;
            System.arraycopy(this.v9, 0, this.v17, 0, var4);
            System.arraycopy(this.v12, 0, this.v21, 0, var4);
            System.arraycopy(this.v11, 0, this.v20, 0, var4);
         }
      }

      float var15 = this.v8(RowSupport.v1(var8, var4, var6));
      NoItemsSupport.Part1 var16 = this.v33;
      var16.v1 = var8;
      var16.v2 = var4;
      var16.v7 = var9;
      var16.v8 = var15;
      var16.v9 = RowSupport.v1(var9, var15, var6);
      var16.v10 = var7;
      var16.v11 = var6;
      return var16;
   }

   private String v2(int var1, int var2) {
      if (this.v22[var1] != var2) {
         this.v22[var1] = var2;
         this.v24[var1] = Integer.toString(var2);
      }

      return this.v24[var1];
   }

   private float v1(int var1, String var2, float var3) {
      if (var3 == this.v26[var1] && var2.equals(this.v25[var1])) {
         return this.v27[var1];
      } else {
         float var4 = uiSupport169.v2("syky_sans_strong", var2, var3);
         this.v25[var1] = var2;
         this.v26[var1] = var3;
         this.v27[var1] = var4;
         return var4;
      }
   }

   private float v10(float var1) {
      if (var1 != this.v28) {
         this.v28 = var1;
         this.v29 = uiSupport169.v2("syky_sans_strong", "No items selected", var1);
      }

      return this.v29;
   }

   public static final class Part1 {
      public RowSupport.Part2 v1 = RowSupport.Part2.ROW;
      public int v2;
      public float v3;
      public float v4;
      public float v5;
      public float v6;
      public float v7;
      public float v8;
      public float v9;
      public float v10;
      public float v11;

      public Part1() {
      }
   }
}
