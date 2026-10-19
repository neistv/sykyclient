package cc.syky.account;

import net.minecraft.class_4184;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public final class accountSupport22 {
   private static final Matrix4f v1 = new Matrix4f();
   private static final Quaternionf v2 = new Quaternionf();
   private static final Matrix4f v3 = new Matrix4f();
   private static final Matrix4f v4 = new Matrix4f();
   private static final Matrix4f v5 = new Matrix4f();
   private static boolean v6;

   private accountSupport22() {
   }

   public static void v1() {
      v6 = false;
   }

   public static void v1(Matrix4f var0) {
      v1.set(var0);
      v6 = true;
   }

   public static boolean v1(class_4184 var0) {
      if (v6 && var0 != null) {
         v2.set(var0.method_23767());
         v3.rotation(v2.conjugate());
         v4.set(v1).mul(v3);
         v5.set(v4).invert();
         return true;
      } else {
         return false;
      }
   }

   public static Matrix4f v2() {
      return v1;
   }

   @Nullable
   public static Matrix4f v3() {
      return v6 ? v1 : null;
   }

   public static Matrix4f v4() {
      return v3;
   }

   public static Matrix4f v5() {
      return v5;
   }

   public static Matrix4f v6() {
      return v4;
   }
}
