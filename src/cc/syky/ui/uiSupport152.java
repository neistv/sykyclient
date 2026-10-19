package cc.syky.ui;

import net.minecraft.class_4588;
import org.jetbrains.annotations.Nullable;

public final class uiSupport152 implements class_4588 {
   public static final int v1 = 1024;
   public static final int v2 = 64;
   public static final int v3 = 13;
   private static final int v6 = 8191;
   public static final int v4 = 512;
   public static final int v5 = 8192;
   private static final int v7 = 63;
   @Nullable
   private class_4588 v8;
   private float v9;
   private float v10;
   private float v11;
   private int v12;
   private int v13;
   private int v14;

   public uiSupport152() {
   }

   public void v1(float var1, float var2, float var3, int var4, float var5, float var6, float var7) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = var3;
      this.v12 = var4;
      int var8 = Math.clamp((long)Math.round(var5 * 512.0F), 0, 8191);
      int var9 = Math.round(var6 / (float) (Math.PI * 2) * 8192.0F) & 8191;
      int var10 = Math.clamp((long)Math.round(var7 * 63.0F), 0, 63);
      this.v13 = var8 | (var10 & 7) << 13;
      this.v14 = var9 | var10 >> 3 << 13;
   }

   public class_4588 v1(class_4588 var1) {
      this.v8 = var1;
      return this;
   }

   public void v1() {
      this.v8 = null;
   }

   private static int v1(float var0) {
      return Math.clamp((long)Math.round(var0 * 1024.0F), -32768, 32767) & 65535;
   }

   private static int v1(float var0, float var1) {
      int var2 = Math.clamp((long)Math.round(var0 * 64.0F), -128, 127) & 0xFF;
      int var3 = Math.clamp((long)Math.round(var1 * 64.0F), -128, 127) & 0xFF;
      return var2 << 8 | var3;
   }

   private class_4588 v2() {
      class_4588 var1 = this.v8;
      if (var1 == null) {
         throw new IllegalStateException("scan vertices written outside a scan");
      } else {
         return var1;
      }
   }

   public class_4588 method_22912(float var1, float var2, float var3) {
      this.v2()
         .method_22912(var1, var2, var3)
         .method_39415(this.v12)
         .method_60796(this.v13, this.v14)
         .method_22921(v1(var2 - this.v10), v1(var1 - this.v9, var3 - this.v11));
      return this;
   }

   public class_4588 method_1336(int var1, int var2, int var3, int var4) {
      return this;
   }

   public class_4588 method_39415(int var1) {
      return this;
   }

   public class_4588 method_22913(float var1, float var2) {
      this.v2().method_22913(var1, var2);
      return this;
   }

   public class_4588 method_60796(int var1, int var2) {
      return this;
   }

   public class_4588 method_22921(int var1, int var2) {
      return this;
   }

   public class_4588 method_22914(float var1, float var2, float var3) {
      this.v2().method_22914(var1, var2, var3);
      return this;
   }

   public class_4588 method_75298(float var1) {
      return this;
   }
}
