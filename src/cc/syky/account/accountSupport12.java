package cc.syky.account;

import cc.syky.mixin.accessor.ItemLayerRenderStateAccessor;
import cc.syky.mixin.accessor.ItemRenderStateAccessor;
import java.util.List;
import net.minecraft.class_10444;
import net.minecraft.class_4587;
import net.minecraft.class_777;
import net.minecraft.class_804;
import net.minecraft.class_10444.class_10446;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public final class accountSupport12 {
   private static final accountSupport12.Part1[] v1 = new accountSupport12.Part1[]{new accountSupport12.Part1(), new accountSupport12.Part1()};
   private static final long v2 = 250000000L;
   private static int v3 = -1;

   private accountSupport12() {
   }

   public static void v1(boolean var0, Matrix4fc var1) {
      v1[v3(var0)].v1.set(var1);
   }

   public static void v1(boolean var0, Matrix4fc var1, float var2, Quaternionfc var3) {
      accountSupport12.Part1 var4 = v1[v3(var0)];
      var4.v2.set(var1);
      var4.v4 = var2;
      var4.v3.set(var3);
      var4.v5 = null;
      v3 = v3(var0);
   }

   public static void v1(class_10444 var0) {
      if (v3 >= 0) {
         accountSupport12.Part1 var1 = v1[v3];
         var1.v5 = var0;
         var1.v6 = true;
         var1.v8 = System.nanoTime();
         v3 = -1;
      }
   }

   public static void v1() {
      for (accountSupport12.Part1 var3 : v1) {
         var3.v7 = var3.v6;
         var3.v6 = false;
      }

      v3 = -1;
   }

   @Nullable
   public static accountSupport12.Part1 v1(boolean var0) {
      accountSupport12.Part1 var1 = v1[v3(var0)];
      return var1.v7 && var1.v5 != null ? var1 : null;
   }

   @Nullable
   public static accountSupport12.Part1 v2(boolean var0) {
      accountSupport12.Part1 var1 = v1[v3(var0)];
      return var1.v5 != null && System.nanoTime() - var1.v8 < 250000000L ? var1 : null;
   }

   private static int v3(boolean var0) {
      return var0 ? 0 : 1;
   }

   public static Matrix4f v1(class_10446 var0, boolean var1, Matrix4f var2) {
      class_804 var3 = ((ItemLayerRenderStateAccessor)var0).syky$transform();
      class_4587 var4 = new class_4587();
      var3.method_23075(var1, var4.method_23760());
      return var2.set(var4.method_23760().method_23761());
   }

   public static final class Part1 {
      public final Matrix4f v1 = new Matrix4f();
      public final Matrix4f v2 = new Matrix4f();
      public final Quaternionf v3 = new Quaternionf();
      public float v4 = 1.0F;
      @Nullable
      public class_10444 v5;
      public boolean v6;
      public boolean v7;
      public long v8;
      private final Matrix4f v9 = new Matrix4f();
      private final Vector3f v10 = new Vector3f();
      private final Vector3f v11 = new Vector3f();
      private final Vector3f v12 = new Vector3f();

      public Part1() {
      }

      public Matrix4f v1(Matrix4f var1) {
         return var1.rotation(this.v3.conjugate(new Quaternionf())).mul(this.v2);
      }

      public Matrix4f v2(Matrix4f var1) {
         return this.v1.invert(var1).mul(this.v2);
      }

      public float v1() {
         return this.v4;
      }

      public Vector3f v1(boolean var1, Vector3f var2) {
         ItemRenderStateAccessor var3 = (ItemRenderStateAccessor)this.v2();
         class_10446[] var4 = var3.syky$layers();
         boolean var5 = var3.syky$displayContext().method_67675();
         this.v11.set(Float.MAX_VALUE);
         this.v12.set(-Float.MAX_VALUE);
         int var6 = Math.min(var3.syky$layerCount(), var4.length);

         for (int var7 = 0; var7 < var6; var7++) {
            class_10446 var8 = var4[var7];
            Matrix4f var9 = accountSupport12.v1(var8, var5, this.v9);
            List var10 = var8.method_67997();

            for (class_777 var12 : var10) {
               for (int var13 = 0; var13 < 4; var13++) {
                  this.v1(var9.transformPosition(var12.method_76648(var13), this.v10));
               }
            }

            if (var10.isEmpty()) {
               for (Vector3fc var14 : ((ItemLayerRenderStateAccessor)var8).syky$vertices().get()) {
                  this.v1(var9.transformPosition(var14, this.v10));
               }
            }
         }

         if (this.v11.x > this.v12.x) {
            this.v11.set(0.0F);
            this.v12.set(0.0F);
         }

         var2.set(this.v11).add(this.v12).mul(0.5F);
         return (var1 ? this.v2(this.v9) : this.v1(this.v9)).transformPosition(var2);
      }

      private void v1(Vector3f var1) {
         this.v11.min(var1);
         this.v12.max(var1);
      }

      public class_10444 v2() {
         class_10444 var1 = this.v5;
         if (var1 == null) {
            throw new IllegalStateException("no model captured");
         } else {
            return var1;
         }
      }
   }
}
