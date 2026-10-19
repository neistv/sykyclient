package cc.syky.ui;

import cc.syky.cloud.cloudSupport41;
import cc.syky.cloud.cloudSupport42;
import cc.syky.cloud.cloudSupport48;
import cc.syky.cloud.cloudSupport50;
import cc.syky.internal.InternalSupport38;
import cc.syky.internal.InternalSupport44;
import cc.syky.internal.InternalSupport60;
import java.util.UUID;
import net.minecraft.class_4588;
import net.minecraft.class_11659.class_11660;
import net.minecraft.class_4587.class_4665;
import org.jetbrains.annotations.Nullable;

public final class uiSupport167 {
   public final UUID v1;
   public final InternalSupport60.Part5 v2;
   public final uiSupport167.Part1[] v3;
   public long v4 = -1L;
   public long v5;
   public double v6 = Double.NaN;
   public double v7 = Double.NaN;
   public double v8 = Double.NaN;
   public double v9 = Double.NaN;
   public double v10 = Double.NaN;
   public int v11 = Integer.MIN_VALUE;
   public final InternalSupport44 v12 = new InternalSupport44();

   public uiSupport167(UUID var1, InternalSupport60.Part5 var2) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = new uiSupport167.Part1[var2.v1().size()];

      for (int var3 = 0; var3 < this.v3.length; var3++) {
         this.v3[var3] = new uiSupport167.Part1(var2.v1().get(var3), var1.hashCode() * 31 + var3);
      }
   }

   public boolean v1() {
      for (uiSupport167.Part1 var4 : this.v3) {
         if (var4.v1.v7() != null && var4.v8 != null) {
            return true;
         }
      }

      return false;
   }

   public static final class Part1 {
      public final cloudSupport50 v1;
      public final cloudSupport48 v2;
      @Nullable
      public final cloudSupport41 v3;
      public final float[] v4;
      public final float[] v5;
      public int v6;
      public int v7;
      @Nullable
      public uiSupport168 v8;
      public uiSupport167.Part2[] v9 = new uiSupport167.Part2[0];
      public uiSupport167.Part2[] v10 = new uiSupport167.Part2[0];
      public final uiSupport167.Part2 v11 = new uiSupport167.Part2(this, -1, false);
      public final uiSupport167.Part2 v12 = new uiSupport167.Part2(this, -1, true);

      public Part1(cloudSupport50 var1, int var2) {
         this.v1 = var1;
         this.v2 = new cloudSupport48(var1);
         cloudSupport50.Part1 var3 = var1.v7();
         if (var3 != null) {
            this.v3 = new cloudSupport41(var3.v2(), var2);
            this.v4 = new float[cloudSupport42.v1(var3.v2()) * 8];
            this.v5 = new float[var3.v2().v2() * var3.v2().v3() * 3];
            this.v6 = cloudSupport42.v1(this.v3, var3.v4(), this.v5, this.v4, false);
            this.v7 = cloudSupport42.v1(var3.v2(), false);
         } else {
            this.v3 = null;
            this.v4 = new float[0];
            this.v5 = new float[0];
         }
      }

      public void v1(uiSupport168 var1) {
         this.v8 = var1;
         this.v9 = new uiSupport167.Part2[var1.v8.length];
         this.v10 = new uiSupport167.Part2[var1.v8.length];

         for (int var2 = 0; var2 < this.v9.length; var2++) {
            this.v9[var2] = new uiSupport167.Part2(this, var2, false);
            this.v10[var2] = new uiSupport167.Part2(this, var2, true);
         }
      }
   }

   public static final class Part2 implements class_11660 {
      private final uiSupport167.Part1 v3;
      private final int v4;
      private final boolean v5;
      public int v1;
      public double v2;

      public Part2(uiSupport167.Part1 var1, int var2, boolean var3) {
         this.v3 = var1;
         this.v4 = var2;
         this.v5 = var3;
      }

      public void render(class_4665 var1, class_4588 var2) {
         InternalSupport38.v1(this.v3, this.v4, this.v5, var1.method_23761(), var1.method_23762(), var2, this.v1, this.v2);
      }
   }
}
