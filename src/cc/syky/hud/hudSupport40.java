package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import net.minecraft.class_332;
import org.jetbrains.annotations.Nullable;

public final class hudSupport40 {
   private static long v1;
   @Nullable
   private class_332 v2;
   private int v3;
   private int v4;
   private float v5;
   private cloudSupport2 v6;
   private boolean v7;
   private long v8;

   public hudSupport40(@Nullable class_332 var1, int var2, int var3, float var4, cloudSupport2 var5, boolean var6) {
      this.v6 = var5;
      this.v1(var1, var2, var3, var4, var5, var6);
   }

   public hudSupport40 v1(@Nullable class_332 var1, int var2, int var3, float var4, cloudSupport2 var5, boolean var6) {
      this.v2 = var1;
      this.v3 = var2;
      this.v4 = var3;
      this.v5 = var4;
      this.v6 = var5;
      this.v7 = var6;
      this.v8 = ++v1;
      return this;
   }

   public long v1() {
      return this.v8;
   }

   @Nullable
   public class_332 v2() {
      return this.v2;
   }

   public int v3() {
      return this.v3;
   }

   public int v4() {
      return this.v4;
   }

   public float v5() {
      return this.v5;
   }

   public cloudSupport2 v6() {
      return this.v6;
   }

   public boolean v7() {
      return this.v7;
   }
}
