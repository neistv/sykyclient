package cc.syky.hud;

import cc.syky.cloud.cloudSupport11;
import cc.syky.cloud.cloudSupport2;
import cc.syky.ui.uiRecord7;
import cc.syky.util.ClipboardUtil;
import java.util.Arrays;
import java.util.Objects;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public abstract class CopiedSupport extends hudSupport12 {
   private final class_2960 v2;
   private final hudRecord2 v3;
   private static final int v4 = 3;
   private final cloudSupport11 v5 = new cloudSupport11();
   private final cloudSupport11[] v6 = v49();
   private final cloudSupport11 v7 = new cloudSupport11();
   private final float[] v8 = new float[3];
   private final int[] v9 = new int[3];
   private final boolean[] v10 = new boolean[3];
   private final boolean[] v11 = new boolean[3];
   private final CopiedSupport2[] v12 = new CopiedSupport2[4];
   private static final float v13 = 6.0F;
   private final CopiedSupport.Part3 v14 = new CopiedSupport.Part3();
   private final CopiedSupport.Part3 v15 = new CopiedSupport.Part3();
   private CopiedSupport.Part2 v16 = new CopiedSupport.Part2(true, null);
   private boolean v18;
   private long v19;
   @Nullable
   private CopiedSupport.Part3 v17;
   private long v20;
   @Nullable
   private CopiedSupport.Part3 v21;

   private static cloudSupport11[] v49() {
      cloudSupport11[] var0 = new cloudSupport11[3];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = new cloudSupport11();
      }

      return var0;
   }

   @Override
   public class_2960 v38() {
      return this.v2;
   }

   public CopiedSupport(String var1, class_2960 var2, hudRecord2 var3, hudSupport52 var4, float var5, float var6) {
      this(var1, var2, var3, 0, var4, var5, var6);
   }

   public CopiedSupport(String var1, class_2960 var2, hudRecord2 var3, int var4, hudSupport52 var5, float var6, float var7) {
      super(var1, 31 | var4, var5, var6, var7);
      this.v2 = var2;
      this.v3 = var3;
   }

   @Nullable
   public abstract String v1(cloudSupport2 var1);

   @Nullable
   public String v2(cloudSupport2 var1) {
      return null;
   }

   public void v1(cloudSupport2 var1, CopiedSupport.Part1 var2) {
      String var3 = this.v2(var1);
      if (var3 != null) {
         var2.v1(var3);
      }
   }

   @Nullable
   public String v44() {
      return null;
   }

   @Override
   public final void v10(float var1, float var2) {
      int var3 = this.v10(var1);
      CopiedSupport.Part3 var4 = this.v21;
      String var5 = var3 > 0 && var4 != null ? var4.v11[var3 - 1] : null;
      if (var5 == null) {
         var3 = 0;
         var5 = this.v44();
      }

      if (ClipboardUtil.v1(var5)) {
         CopiedSupport2 var6 = this.v12[var3];
         if (var6 == null) {
            var6 = new CopiedSupport2();
            this.v12[var3] = var6;
         }

         var6.v1(System.nanoTime());
      }
   }

   private int v10(float var1) {
      CopiedSupport.Part3 var2 = this.v21;
      if (var2 == null) {
         return 0;
      } else {
         int var3 = 0;
         float var4 = 13.0F * var2.v6 * 0.5F;

         for (int var5 = 0; var5 < var2.v10; var5++) {
            if (var1 >= var2.v19 + var2.v12[var5] - var4) {
               var3 = var5 + 1;
            }
         }

         return var3;
      }
   }

   @Override
   public boolean v43() {
      return true;
   }

   @Nullable
   public Object v40() {
      return null;
   }

   @Nullable
   public final Object v47() {
      return this.v22() instanceof CopiedSupport.Part2 var1 ? var1.v2() : this.v40();
   }

   private boolean v46() {
      return this.v22() instanceof CopiedSupport.Part2 var1 ? var1.v1() : this.v2().v14();
   }

   @Override
   public final Object v1(hudSupport40 var1) {
      boolean var2 = this.v2().v14();
      Object var3 = this.v40();
      CopiedSupport.Part2 var4 = this.v16;
      if (var4.v1() != var2 || !Objects.equals(var4.v2(), var3)) {
         var4 = new CopiedSupport.Part2(var2, var3);
         this.v16 = var4;
      }

      return var4;
   }

   @Nullable
   private CopiedSupport.Part3 v15(hudSupport40 var1) {
      if (var1.v1() == this.v20) {
         return this.v21;
      } else {
         CopiedSupport.Part3 var2 = this.v16(var1);
         if (var2 != null) {
            this.v1(var1, var2, this.v18 ? this.v15 : null);
         }

         this.v20 = var1.v1();
         this.v21 = var2;
         return var2;
      }
   }

   @Nullable
   @Override
   public final hudSupport12.Part1 v14(hudSupport40 var1) {
      return this.v16(var1);
   }

   @Nullable
   private CopiedSupport.Part3 v16(hudSupport40 var1) {
      if (var1.v1() == this.v19) {
         return this.v17;
      } else {
         CopiedSupport.Part3 var2 = this.v18(var1);
         this.v19 = var1.v1();
         this.v17 = var2;
         return var2;
      }
   }

   @Nullable
   private CopiedSupport.Part3 v18(hudSupport40 var1) {
      hudSupport6 var2 = this.v21();
      this.v1(var2, this.v14);
      this.v18 = false;
      this.v1(var2.v1());
      CopiedSupport.Part3 var3 = this.v1(var1, this.v14);
      if (var3 != null && var2.v3()) {
         this.v1(var2.v2());
         CopiedSupport.Part3 var4 = this.v1(var1, this.v15);
         this.v1(var2.v1());
         if (var4 == null) {
            return var3;
         } else {
            this.v1(var3, var4, var2);
            this.v18 = true;
            return var3;
         }
      } else {
         this.v1(var2.v1());
         return var3;
      }
   }

   @Override
   public final void v8(hudSupport40 var1) {
      CopiedSupport.Part3 var2 = this.v15(var1);
      if (var2 == null) {
         this.v2(hudRecord4.EMPTY);
      } else {
         this.v1(var1, var2.v16 + this.v15(), var2.v17, var2.v22, var2.v21, var2.v2);
         this.v2(var2.v16, var2.v18, var2.v22, var2.v21);
      }
   }

   @Override
   public final boolean v33() {
      return true;
   }

   @Override
   public final void v10(hudSupport40 var1) {
      CopiedSupport.Part3 var2 = this.v15(var1);
      if (var2 == null) {
         this.v2(hudRecord4.EMPTY);
      } else {
         this.v2(var2.v16, var2.v18, var2.v22, var2.v21);
      }
   }

   @Override
   public final hudRecord4 v9(hudSupport40 var1) {
      CopiedSupport.Part3 var2 = this.v15(var1);
      if (var2 == null) {
         this.v2(hudRecord4.EMPTY);
         return hudRecord4.EMPTY;
      } else {
         hudSupport6 var3 = this.v21();
         if (this.v18) {
            this.v1(var1, var2, var3);
         } else {
            this.v1(var2);
            this.v3(var2);
         }

         return this.v2(var2.v16, var2.v18, var2.v22, var2.v21);
      }
   }

   @Override
   public void v1(hudSupport40 var1, HudElement.Part2 var2) {
      CopiedSupport.Part3 var3 = this.v15(var1);
      if (var3 == null) {
         this.v2(hudRecord4.EMPTY);
      } else if (this.v18) {
         if (var2 == HudElement.Part2.ICONS) {
            this.v1(var1, var3, this.v21());
            this.v2(var3.v16, var3.v18, var3.v22, var3.v21);
         }
      } else {
         if (var2 == HudElement.Part2.ICONS) {
            this.v1(var3);
            this.v2(var3.v16, var3.v18, var3.v22, var3.v21);
         } else {
            this.v3(var3);
         }
      }
   }

   private void v1(hudSupport40 var1, CopiedSupport.Part3 var2, hudSupport6 var3) {
      CopiedSupport.Part3 var4 = this.v15;
      float var5 = var1.v5();
      float var6 = var2.v16 + this.v15();
      uiRecord7 var7 = uiRecord7.v1(var2.v2);
      float var8 = 7.0F * var5;
      float var9 = 6.0F * var5;
      float var10 = var3.v7();
      boolean var11 = var2.v1 && var4.v1;
      boolean var12 = var2.v7[0] == null && var4.v7[0] == null && !var2.v5.isEmpty() && var2.v5.equals(var4.v5) && var2.v3 == var4.v3;
      this.v1(var4, var2);
      int var13 = Math.min(var2.v15, var4.v15);
      float var14 = var2.v17 + this.v3.v6() * var2.v6;
      if (var11) {
         this.v2(var2);
      }

      for (int var15 = 0; var15 < var13; var15++) {
         this.v1(var2.v19 + v2(var4.v14[var15], var2.v14[var15], var10), var2.v17, var2.v6);
      }

      if (var12) {
         this.v1("syky_sans_strong", var2.v5, var2.v19 + v2(var4.v4, var2.v4, var10), var14, var2.v3, -1);
      }

      for (int var17 = 0; var17 < var2.v10; var17++) {
         int var16 = this.v9[var17];
         if (var16 >= 0) {
            this.v1("syky_sans_strong", var2.v9[var17], var2.v19 + v2(var4.v12[var16], var2.v12[var17], var10), var14, var2.v3, -1);
         }
      }

      if (var3.v14()) {
         this.v1(var4, var6, var2, var7, var8, var9, var11, var12, this.v11, var13, var3.v8(), var3.v9(), var3.v10() * var5);
      }

      if (var3.v15()) {
         this.v1(var2, var6, var2, var7, var8, var9, var11, var12, this.v10, var13, var3.v11(), var3.v12(), var3.v13() * var5);
      }
   }

   private void v1(CopiedSupport.Part3 var1, CopiedSupport.Part3 var2) {
      Arrays.fill(this.v11, false);
      Arrays.fill(this.v10, false);
      boolean var3 = var2.v3 == var1.v3;

      for (int var4 = 0; var4 < var2.v10; var4++) {
         int var5 = -1;
         if (var3) {
            for (int var6 = 0; var6 < var1.v10; var6++) {
               if (!this.v11[var6] && var1.v9[var6].equals(var2.v9[var4])) {
                  var5 = var6;
                  break;
               }
            }
         }

         this.v9[var4] = var5;
         if (var5 >= 0) {
            this.v11[var5] = true;
            this.v10[var4] = true;
         }
      }
   }

   private static float v2(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   private void v1(
      CopiedSupport.Part3 var1,
      float var2,
      CopiedSupport.Part3 var3,
      uiRecord7 var4,
      float var5,
      float var6,
      boolean var7,
      boolean var8,
      boolean[] var9,
      int var10,
      float var11,
      float var12,
      float var13
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
            var11,
            var12,
            var12,
            var13,
            var5,
            var6x -> {
               if (!var7) {
                  this.v2(var1);
               }

               for (int var7x = var10; var7x < var1.v15; var7x++) {
                  this.v1(var1.v19 + var1.v14[var7x], var1.v17, var1.v6);
               }

               if (!var8) {
                  this.v4(var1);
               }

               float var9x = var1.v17 + this.v3.v6() * var1.v6;

               for (int var8x = 0; var8x < var1.v10; var8x++) {
                  if (!var9[var8x]) {
                     this.v1("syky_sans_strong", var1.v9[var8x], var1.v19 + var1.v12[var8x], var9x, var1.v3, -1);
                  }
               }
            }
         );
      }
   }

   private void v1(CopiedSupport.Part3 var1) {
      this.v2(var1);

      for (int var2 = 0; var2 < var1.v15; var2++) {
         this.v1(var1.v19 + var1.v14[var2], var1.v17, var1.v6);
      }
   }

   private void v2(CopiedSupport.Part3 var1) {
      if (var1.v1) {
         this.v1(this.v2, var1.v19 + this.v3.v3() * var1.v6, var1.v17 + this.v3.v4() * var1.v6, this.v3.v1() * var1.v6, this.v3.v2() * var1.v6);
      }
   }

   private void v3(CopiedSupport.Part3 var1) {
      this.v4(var1);
      this.v5(var1);
   }

   private void v4(CopiedSupport.Part3 var1) {
      float var2 = var1.v17 + this.v3.v6() * var1.v6;
      CopiedSupport2 var3 = var1.v7[0];
      if (var3 != null) {
         this.v1(var1, var3, var2, var1.v5, var1.v4, var1.v8, this.v5);
      } else if (!var1.v5.isEmpty()) {
         this.v1("syky_sans_strong", var1.v5, var1.v19 + var1.v4, var2, var1.v3, -1);
      }
   }

   private void v5(CopiedSupport.Part3 var1) {
      float var2 = var1.v17 + this.v3.v6() * var1.v6;

      for (int var3 = 0; var3 < var1.v10; var3++) {
         CopiedSupport2 var4 = var1.v7[var3 + 1];
         if (var4 != null) {
            this.v1(var1, var4, var2, var1.v9[var3], var1.v12[var3], var1.v13[var3], this.v6[var3]);
         } else {
            this.v1("syky_sans_strong", var1.v9[var3], var1.v19 + var1.v12[var3], var2, var1.v3, -1);
         }
      }
   }

   private void v1(CopiedSupport.Part3 var1, CopiedSupport2 var2, float var3, String var4, float var5, float var6, cloudSupport11 var7) {
      CopiedSupport2.Part1 var8 = var2.v1();
      if (!var4.isEmpty() && var8.v1() > 0.003921569F) {
         this.v1(var8, "syky_sans_strong", var4, var1.v19 + var5, var3 + var8.v2() * var1.v6, var7.v1(var4, var1.v3), var1.v3, -1);
      }

      CopiedSupport2.Part1 var9 = var2.v2();
      if (var9.v1() > 0.003921569F) {
         float var10 = this.v7.v1("Copied!", var1.v3);
         this.v1(var9, "syky_sans_strong", "Copied!", var1.v19 + var5 + (var6 - var10) * 0.5F, var3 + var9.v2() * var1.v6, var10, var1.v3, -1);
      }
   }

   @Nullable
   private CopiedSupport.Part3 v1(hudSupport40 var1, CopiedSupport.Part3 var2) {
      String var3 = this.v1(var1.v6());
      if (var3 == null) {
         return null;
      } else {
         float var4 = this.v5(var1);
         float var5 = this.v6(36.0F, var4);
         float var6 = 18.0F * var4;
         float var7 = 16.0F * var4;
         boolean var8 = this.v46();
         var2.v10 = 0;
         this.v1(var1.v6(), var2);
         long var9 = System.nanoTime();
         float var11 = this.v7.v1("Copied!", var7);

         for (int var12 = 0; var12 < var2.v7.length; var12++) {
            CopiedSupport2 var13 = this.v12[var12];
            CopiedSupport2 var14 = null;
            if (var13 != null && var12 <= var2.v10 && var13.v2(var9)) {
               var13.v3(var9);
               var14 = var13;
            }

            var2.v7[var12] = var14;
         }

         boolean var22 = !var3.isEmpty() || var2.v7[0] != null;
         float var23 = Math.max(var3.isEmpty() ? 0.0F : this.v5.v1(var3, var7), v1(var2.v7[0], var11));
         float var24 = 0.0F;

         for (int var15 = 0; var15 < var2.v10; var15++) {
            this.v8[var15] = Math.max(this.v6[var15].v1(var2.v9[var15], var7), v1(var2.v7[var15 + 1], var11));
            var24 += this.v8[var15];
         }

         int var25 = (var22 ? 1 : 0) + var2.v10;
         int var16 = Math.max(0, var25 - 1);
         float var17 = var23 + var24 + var16 * 13.0F * var4;
         float var18 = (var8 ? this.v3.v5() : 10.0F) * var4;
         float var19;
         if (var25 > 0) {
            var19 = var18 + var17 + 10.0F * var4;
         } else if (var8) {
            var19 = (2.0F * this.v3.v3() + this.v3.v1()) * var4;
         } else {
            var19 = 20.0F * var4;
         }

         var2.v1 = var8;
         var2.v20 = var19;
         var2.v22 = var19;
         var2.v21 = var5;
         var2.v2 = var6;
         var2.v3 = var7;
         var2.v4 = var18;
         var2.v5 = var3;
         var2.v6 = var4;
         var2.v8 = var23;
         float var20 = var18 + var23;
         var2.v15 = 0;

         for (int var21 = 0; var21 < var2.v10; var21++) {
            if (var22 || var21 > 0) {
               var2.v14[var2.v15++] = this.v8(var20 + 6.0F * var4);
               var20 += 13.0F * var4;
            }

            var2.v12[var21] = var20;
            var2.v13[var21] = this.v8[var21];
            var20 += this.v8[var21];
         }

         return var2;
      }
   }

   private static float v1(@Nullable CopiedSupport2 var0, float var1) {
      return var0 == null ? 0.0F : var1 * var0.v3();
   }

   @FunctionalInterface
   public interface Part1 {
      void v1(String var1);

      default void v1(String var1, @Nullable String var2) {
         this.v1(var1);
      }
   }

   public record Part2(boolean icon, @Nullable Object own) {
      public boolean v1() {
         return this.icon;
      }

      @Nullable
      public Object v2() {
         return this.own;
      }
   }

   public static final class Part3 extends hudSupport12.Part1 implements CopiedSupport.Part1 {
      public boolean v1;
      public float v2;
      public float v3;
      public float v4;
      public String v5 = "";
      public float v6;
      public final CopiedSupport2[] v7 = new CopiedSupport2[4];
      public float v8;
      public final String[] v9 = new String[3];
      public int v10;
      public final String[] v11 = new String[3];
      public final float[] v12 = new float[3];
      public final float[] v13 = new float[3];
      public final float[] v14 = new float[3];
      public int v15;

      public Part3() {
      }

      @Override
      public void v1(String var1) {
         this.v1(var1, null);
      }

      @Override
      public void v1(String var1, @Nullable String var2) {
         if (var1 != null && !var1.isEmpty() && this.v10 != 3) {
            this.v11[this.v10] = var2;
            this.v9[this.v10++] = var1;
         }
      }
   }
}
