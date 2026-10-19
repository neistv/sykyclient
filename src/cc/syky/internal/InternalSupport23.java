package cc.syky.internal;

import cc.syky.DecompilationFailedSupport;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport23 implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.hud.image");
   private final class_2960 v2;
   private final int v3;
   private final int v4;
   private final int v5;
   private final int v6;
   private final int v7;
   private final int v8;
   @Nullable
   private final int[] v9;
   private final float v10;
   private final float v11;
   private final float v12;
   private final float v13;
   private boolean v14;

   public InternalSupport23(class_2960 var1, int var2, int var3, int var4, int var5, @Nullable int[] var6, int var7, int var8) {
      this.v7 = var7 > 0 ? var7 : var2;
      this.v8 = var8 > 0 ? var8 : var3;
      this.v2 = var1;
      this.v3 = var2;
      this.v4 = var3;
      this.v5 = Math.max(1, var4);
      this.v6 = Math.max(1, var5);
      this.v9 = this.v6 > 1 ? var6 : null;
      int var9 = InternalSupport22.v1(this.v6, this.v5);
      this.v10 = (float)this.v5 * var2;
      this.v11 = (float)var9 * var3;
      boolean var10 = this.v6 > 1;
      this.v12 = var10 ? 0.5F / this.v10 : 0.0F;
      this.v13 = var10 ? 0.5F / this.v11 : 0.0F;
   }

   @Nullable
   public static InternalSupport23 v1(class_2960 var0, DecompilationFailedSupport.Part2 var1) {
      class_1011 var2 = var1.v1();

      try {
         class_310.method_1551().method_1531().method_4616(var0, new InternalSupport23.Part1(var0, var2));
      } catch (Throwable var4) {
         var2.close();
         v1.warn("could not upload {}", var0, var4);
         return null;
      }

      return new InternalSupport23(var0, var1.v2(), var1.v3(), var1.v4(), var1.v5(), var1.v6(), var1.v7(), var1.v8());
   }

   public class_2960 v1() {
      return this.v2;
   }

   public int v2() {
      return this.v3;
   }

   public int v3() {
      return this.v4;
   }

   public int v4() {
      return this.v7;
   }

   public int v5() {
      return this.v8;
   }

   public boolean v6() {
      return this.v9 != null;
   }

   public long v7() {
      return (long)this.v10 * (long)this.v11;
   }

   public int v1(long var1) {
      return this.v9 == null ? 0 : InternalSupport22.v1(var1, this.v9);
   }

   public float v1(int var1) {
      return this.v5(var1) * this.v3 / this.v10 + this.v12;
   }

   public float v2(int var1) {
      return this.v6(var1) * this.v4 / this.v11 + this.v13;
   }

   public float v3(int var1) {
      return (this.v5(var1) + 1) * this.v3 / this.v10 - this.v12;
   }

   public float v4(int var1) {
      return (this.v6(var1) + 1) * this.v4 / this.v11 - this.v13;
   }

   private int v5(int var1) {
      return Math.floorMod(var1, this.v5);
   }

   private int v6(int var1) {
      return Math.floorDiv(Math.floorMod(var1, this.v6), this.v5);
   }

   @Override
   public void close() {
      if (!this.v14) {
         this.v14 = true;
         class_310 var1 = class_310.method_1551();
         if (var1 != null) {
            var1.method_1531().method_4615(this.v2);
         }
      }
   }

   public static final class Part1 extends class_1043 {
      public Part1(class_2960 var1, class_1011 var2) {
         super(var1::toString, var2);
         this.field_63613 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      }
   }
}
