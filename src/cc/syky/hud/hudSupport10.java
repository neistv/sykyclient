package cc.syky.hud;

import cc.syky.config.BooleanSetting;
import cc.syky.render.renderSupport47;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import java.util.Objects;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public abstract class hudSupport10 extends hudSupport12 {
   private static final float v2 = 8.0F;
   private static final float v3 = 1.5F;
   private static final float v4 = 0.42F;
   private static final float v5 = 0.12F;
   private static final float v6 = 6.0F;
   private static final int v7 = 0;
   private static final int v8 = 1;
   private static final int v9 = 2;
   private static final int v10 = 3;
   private final class_2960 v11;
   private final hudRecord2 v12;
   private final MicrosoftBasicSupport v13;
   private final BooleanSetting v14;
   private final BooleanSetting v15;
   private final BooleanSetting v16;
   private final String[] v18 = new String[]{"", "", ""};
   @Nullable
   private String v19;
   private int v17 = Integer.MIN_VALUE;
   private int v20 = Integer.MIN_VALUE;
   private final String[] v21 = new String[]{"", "", ""};
   private final float[] v22 = new float[]{-1.0F, -1.0F, -1.0F};
   private final float[] v24 = new float[3];
   private final hudSupport10.Part2 v25 = new hudSupport10.Part2();
   private final hudSupport10.Part2 v26 = new hudSupport10.Part2();
   private boolean v27;
   private final boolean[] v28 = new boolean[3];
   private hudSupport10.Part1 v29 = new hudSupport10.Part1(true, true, true, true);
   private long v30;
   @Nullable
   private hudSupport10.Part2 v32;
   private long v23;
   @Nullable
   private hudSupport10.Part2 v33;

   public hudSupport10(String var1, class_2960 var2, hudRecord2 var3, MicrosoftBasicSupport var4, hudSupport52 var5, float var6, float var7) {
      super(var1, 31, var5, var6, var7);
      this.v11 = var2;
      this.v12 = var3;
      this.v13 = var4;
      AutoSupport var8 = this.v2();
      this.v14 = var8.v1(new BooleanSetting("name", true));
      this.v15 = var8.v1(new BooleanSetting("load", true));
      this.v16 = var8.v1(new BooleanSetting("temperature", true));
   }

   @Override
   public class_2960 v38() {
      return this.v11;
   }

   public abstract String v1(hudRecord6 var1);

   public abstract int v2(hudRecord6 var1);

   public abstract int v3(hudRecord6 var1);

   @Override
   public boolean v43() {
      return true;
   }

   @Override
   public Object v1(hudSupport40 var1) {
      boolean var2 = this.v2().v14();
      boolean var3 = this.v14.getValue();
      boolean var4 = this.v15.getValue();
      boolean var5 = this.v16.getValue();
      hudSupport10.Part1 var6 = this.v29;
      if (var6.v1() != var2 || var6.v2() != var3 || var6.v3() != var4 || var6.v4() != var5) {
         var6 = new hudSupport10.Part1(var2, var3, var4, var5);
         this.v29 = var6;
      }

      return var6;
   }

   private hudSupport10.Part1 v2(@Nullable Object var1) {
      return var1 instanceof hudSupport10.Part1 var2 ? var2 : this.v29;
   }

   @Override
   public final void v8(hudSupport40 var1) {
      hudSupport10.Part2 var2 = this.v15(var1);
      this.v1(var1, var2.v16 + this.v15(), var2.v17, var2.v22, var2.v21, var2.v1);
      this.v2(var2.v16, var2.v18, var2.v22, var2.v21);
   }

   @Override
   public final boolean v33() {
      return true;
   }

   @Override
   public final void v10(hudSupport40 var1) {
      hudSupport10.Part2 var2 = this.v15(var1);
      this.v2(var2.v16, var2.v18, var2.v22, var2.v21);
   }

   @Override
   public final hudRecord4 v9(hudSupport40 var1) {
      hudSupport10.Part2 var2 = this.v15(var1);
      hudSupport6 var3 = this.v21();
      if (this.v27) {
         this.v1(var1, var2, var3);
      } else {
         this.v1(var2);

         for (int var4 = 0; var4 < 3; var4++) {
            if (var2.v5[var4]) {
               this.v1(var2, var4, var2.v7[var4]);
            }
         }
      }

      return this.v2(var2.v16, var2.v18, var2.v22, var2.v21);
   }

   @Override
   public void v1(hudSupport40 var1, HudElement.Part2 var2) {
      hudSupport10.Part2 var3 = this.v15(var1);
      if (this.v27) {
         if (var2 == HudElement.Part2.ICONS) {
            this.v1(var1, var3, this.v21());
            this.v2(var3.v16, var3.v18, var3.v22, var3.v21);
         }
      } else if (var2 == HudElement.Part2.ICONS) {
         this.v1(var3);
         this.v2(var3.v16, var3.v18, var3.v22, var3.v21);
      } else {
         for (int var4 = 0; var4 < 3; var4++) {
            if (var3.v5[var4]) {
               this.v1(var3, var4, var3.v7[var4]);
            }
         }
      }
   }

   private hudSupport10.Part2 v15(hudSupport40 var1) {
      hudSupport10.Part2 var2 = this.v33;
      if (var1.v1() == this.v23 && var2 != null) {
         return var2;
      } else {
         hudSupport10.Part2 var3 = this.v16(var1);
         this.v1(var1, var3, this.v27 ? this.v26 : null);
         this.v23 = var1.v1();
         this.v33 = var3;
         return var3;
      }
   }

   @Override
   public final hudSupport12.Part1 v14(hudSupport40 var1) {
      return this.v16(var1);
   }

   private hudSupport10.Part2 v16(hudSupport40 var1) {
      hudSupport10.Part2 var2 = this.v32;
      if (var1.v1() == this.v30 && var2 != null) {
         return var2;
      } else {
         hudSupport10.Part2 var3 = this.v18(var1);
         this.v30 = var1.v1();
         this.v32 = var3;
         return var3;
      }
   }

   private hudSupport10.Part2 v18(hudSupport40 var1) {
      this.v40();
      hudSupport6 var2 = this.v21();
      this.v1(var2, this.v25);
      this.v27 = false;
      hudSupport10.Part2 var3 = this.v25;
      this.v1(var1, var3, this.v2(var2.v1()));
      if (!var2.v3()) {
         return var3;
      } else {
         hudSupport10.Part2 var4 = this.v26;
         this.v1(var1, var4, this.v2(var2.v2()));
         this.v1(var3, var4, var2);
         this.v27 = true;
         return var3;
      }
   }

   private void v1(hudSupport40 var1, hudSupport10.Part2 var2, hudSupport6 var3) {
      hudSupport10.Part2 var4 = this.v26;
      float var5 = var1.v5();
      float var6 = var3.v7();
      float var7 = var2.v16 + this.v15();
      uiRecord7 var8 = uiRecord7.v1(var2.v1);
      float var9 = 7.0F * var5;
      float var10 = 6.0F * var5;
      boolean var11 = var2.v4 && var4.v4;

      for (int var12 = 0; var12 < 3; var12++) {
         this.v28[var12] = var2.v5[var12] && var4.v5[var12];
      }

      if (var11) {
         this.v1(var2);
      }

      for (int var13 = 0; var13 < 3; var13++) {
         if (this.v28[var13]) {
            this.v1(var2, var13, v2(var4.v7[var13], var2.v7[var13], var6));
         }
      }

      if (var3.v14()) {
         this.v1(var4, var7, var2, var8, var9, var10, var11, var3.v8(), var3.v9(), var3.v10() * var5);
      }

      if (var3.v15()) {
         this.v1(var2, var7, var2, var8, var9, var10, var11, var3.v11(), var3.v12(), var3.v13() * var5);
      }
   }

   private void v1(
      hudSupport10.Part2 var1, float var2, hudSupport10.Part2 var3, uiRecord7 var4, float var5, float var6, boolean var7, float var8, float var9, float var10
   ) {
      if (var1.v20 > 0.0F) {
         this.v1(
            var1.v19,
            var1.v17,
            var1.v20,
            var1.v21,
            var6,
            var1.v19 + var1.v20 * 0.5F,
            var1.v17 + var1.v21 * 0.5F,
            var2,
            var3.v17,
            var3.v22,
            var3.v21,
            var4,
            var8,
            var9,
            var9,
            var10,
            var5,
            var3x -> {
               if (!var7) {
                  this.v1(var1);
               }

               for (int var4x = 0; var4x < 3; var4x++) {
                  if (!this.v28[var4x] && var1.v5[var4x]) {
                     this.v1(var1, var4x, var1.v7[var4x]);
                  }
               }
            }
         );
      }
   }

   private void v1(hudSupport10.Part2 var1) {
      if (var1.v4) {
         this.v1(this.v11, var1.v19 + this.v12.v3() * var1.v3, var1.v17 + this.v12.v4() * var1.v3, this.v12.v1() * var1.v3, this.v12.v2() * var1.v3);
      }
   }

   private void v1(hudSupport10.Part2 var1, int var2, float var3) {
      float var4 = var1.v19 + var3;
      float var5 = var1.v17 + this.v12.v6() * var1.v3;
      this.v1("syky_sans_strong", var1.v6[var2], var4, var5, var1.v2, -1);
      if (var2 == 2) {
         float var6 = var1.v2 * 0.42F;
         float var7 = Math.max(uiSupport169.v2(), var1.v2 * 0.12F);
         this.v1(var4 + this.v1(var2, var1.v6[var2], var1.v2) + 1.5F * var1.v3, var5, var6, var6, this.v1(-1), var7, uiRecord7.v1(var6 * 0.5F));
      }
   }

   private void v1(hudSupport40 var1, hudSupport10.Part2 var2, hudSupport10.Part1 var3) {
      float var4 = this.v5(var1);
      var2.v3 = var4;
      var2.v21 = this.v6(36.0F, var4);
      var2.v1 = 18.0F * var4;
      var2.v2 = 16.0F * var4;
      var2.v4 = var3.v1();
      var2.v6[0] = var3.v2() ? this.v18[0] : "";
      var2.v6[1] = var3.v3() ? this.v18[1] : "";
      var2.v6[2] = var3.v4() ? this.v18[2] : "";
      float var5 = (var2.v4 ? this.v12.v5() : 10.0F) * var4;
      boolean var6 = false;

      for (int var7 = 0; var7 < 3; var7++) {
         var2.v5[var7] = !var2.v6[var7].isEmpty();
         if (var2.v5[var7]) {
            if (var6) {
               var5 += 8.0F * var4;
            }

            var2.v7[var7] = var5;
            var5 += this.v1(var7, var2.v6[var7], var2.v2);
            if (var7 == 2) {
               var5 += 1.5F * var4 + var2.v2 * 0.42F;
            }

            var6 = true;
         }
      }

      if (var6) {
         var2.v20 = var5 + 10.0F * var4;
      } else if (var2.v4) {
         var2.v20 = (2.0F * this.v12.v3() + this.v12.v1()) * var4;
      } else {
         var2.v20 = 20.0F * var4;
      }

      var2.v22 = var2.v20;
   }

   private void v40() {
      hudRecord6 var1 = renderSupport47.v1(this.v13.v2());
      String var2 = this.v1(var1);
      if (!Objects.equals(var2, this.v19)) {
         this.v19 = var2;
         this.v18[0] = var2 == null ? "" : var2;
      }

      int var3 = this.v2(var1);
      if (var3 != this.v17) {
         this.v17 = var3;
         this.v18[1] = var3 >= 0 ? var3 + "%" : "";
      }

      int var4 = this.v3(var1);
      if (var4 != this.v20) {
         this.v20 = var4;
         this.v18[2] = var4 >= 0 ? Integer.toString(var4) : "";
      }
   }

   private float v1(int var1, String var2, float var3) {
      if (var3 == this.v22[var1] && var2.equals(this.v21[var1])) {
         return this.v24[var1];
      } else {
         float var4 = uiSupport169.v2("syky_sans_strong", var2, var3);
         this.v21[var1] = var2;
         this.v22[var1] = var3;
         this.v24[var1] = var4;
         return var4;
      }
   }

   private static float v2(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public record Part1(boolean icon, boolean name, boolean load, boolean temp) {
      public boolean v1() {
         return this.icon;
      }

      public boolean v2() {
         return this.name;
      }

      public boolean v3() {
         return this.load;
      }

      public boolean v4() {
         return this.temp;
      }
   }

   public static final class Part2 extends hudSupport12.Part1 {
      public float v1;
      public float v2;
      public float v3;
      public boolean v4;
      public final boolean[] v5 = new boolean[3];
      public final String[] v6 = new String[]{"", "", ""};
      public final float[] v7 = new float[3];

      public Part2() {
      }
   }
}
