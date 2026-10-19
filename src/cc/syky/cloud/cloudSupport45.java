package cc.syky.cloud;

public final class cloudSupport45 {
   private static final cloudSupport45.Part1[] v1 = cloudSupport45.Part1.values();
   private final String v2;
   private final float v3;
   private final cloudSupport45.Part1 v4;
   private final cloudSupport46[] v5;

   public cloudSupport45(String var1, float var2, cloudSupport45.Part1 var3, cloudSupport46[] var4) {
      if (var2 > 0.0F && var2 <= 3600.0F) {
         this.v2 = var1;
         this.v3 = var2;
         this.v4 = var3;
         this.v5 = var4;
      } else {
         throw new IllegalArgumentException("clip " + var1 + " is " + var2 + " s long");
      }
   }

   public static cloudSupport45.Part1 v1(int var0) {
      if (var0 >= 0 && var0 < v1.length) {
         return v1[var0];
      } else {
         throw new IllegalArgumentException("no loop mode " + var0);
      }
   }

   public String v1() {
      return this.v2;
   }

   public float v2() {
      return this.v3;
   }

   public cloudSupport45.Part1 v3() {
      return this.v4;
   }

   public int v4() {
      return this.v5.length;
   }

   public cloudSupport46 v2(int var1) {
      return this.v5[var1];
   }

   public void v1(float var1, float[] var2, float[] var3, float[] var4) {
      for (cloudSupport46 var8 : this.v5) {
         float[] var9 = switch (var8.v2()) {
            case ROTATION -> var2;
            case POSITION -> var3;
            case SCALE -> var4;
         };
         var8.v1(var1, var9, var8.v1() * 3, this.v4 == cloudSupport45.Part1.LOOP);
      }
   }

   public float v1(double var1) {
      if (var1 <= 0.0) {
         return 0.0F;
      } else {
         return switch (this.v4) {
            case LOOP -> (float)(var1 % this.v3);
            case ONCE -> var1 >= this.v3 ? -1.0F : (float)var1;
            case HOLD -> (float)Math.min(var1, (double)this.v3);
         };
      }
   }

   public static enum Part1 {
      LOOP,
      ONCE,
      HOLD;

      private Part1() {
      }
   }
}
