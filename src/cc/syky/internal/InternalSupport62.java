package cc.syky.internal;

public final class InternalSupport62 {
   public static final int v1 = 2048;
   private final int v2;
   private final int v3;
   private final byte[] v4;
   private final int v5;
   private final float v6;
   private final boolean v7;

   public InternalSupport62(int var1, int var2, byte[] var3, int var4, float var5, boolean var6) {
      if (var1 < 1 || var2 < 1 || var1 > 2048 || var2 > 2048) {
         throw new IllegalArgumentException("texture " + var1 + "x" + var2 + " is outside 1..2048");
      } else if (var4 >= 1 && var2 % var4 == 0) {
         if (var4 <= 1 || var5 >= 0.01F && var5 <= 60.0F) {
            if (var3.length == 0) {
               throw new IllegalArgumentException("empty texture");
            } else {
               this.v2 = var1;
               this.v3 = var2;
               this.v4 = var3;
               this.v5 = var4;
               this.v6 = var5;
               this.v7 = var6;
            }
         } else {
            throw new IllegalArgumentException("frame time " + var5 + " s is outside [0.01, 60]");
         }
      } else {
         throw new IllegalArgumentException(var4 + " frames do not divide a " + var2 + "-texel strip");
      }
   }

   public int v1() {
      return this.v2;
   }

   public int v2() {
      return this.v3;
   }

   public byte[] v3() {
      return this.v4;
   }

   public int v4() {
      return this.v5;
   }

   public float v5() {
      return this.v6;
   }

   public boolean v6() {
      return this.v7;
   }

   public int v7() {
      return this.v3 / this.v5;
   }

   public int v1(double var1) {
      if (this.v5 == 1) {
         return 0;
      } else {
         long var3 = (long)Math.floor(var1 / this.v6);
         return (int)Math.floorMod(var3, (long)this.v5);
      }
   }
}
