package cc.syky.hud;

public final class CopiedSupport2 {
   public static final String v1 = "Copied!";
   public static final float v2 = 260.0F;
   public static final float v3 = 700.0F;
   public static final float v4 = 1220.0F;
   public static final float v5 = 4.0F;
   public static final float v6 = 0.003921569F;
   private static final float v7 = 0.72F;
   private static final float v8 = 0.5F;
   private static final float v9 = 0.84F;
   private static final float v10 = 0.1F;
   private static final float v11 = 0.42F;
   private static final float v12 = 0.45F;
   private static final float v13 = 0.22F;
   private static final float v14 = 0.2F;
   public static final float v15 = v6();
   private static final float v16 = 1000000.0F;
   private boolean v18;
   private long v19;
   private final CopiedSupport2.Part1 v17 = new CopiedSupport2.Part1();
   private final CopiedSupport2.Part1 v20 = new CopiedSupport2.Part1();
   private float v21;

   public CopiedSupport2() {
      this.v5();
   }

   public void v1(long var1) {
      if (!this.v2(var1)) {
         this.v18 = true;
         this.v19 = var1;
      } else {
         if (this.v4(var1) >= 260.0F) {
            this.v19 = var1 - 260000000L;
         }
      }
   }

   public boolean v2(long var1) {
      if (!this.v18) {
         return false;
      } else if (this.v4(var1) < 1220.0F) {
         return true;
      } else {
         this.v18 = false;
         return false;
      }
   }

   public void v3(long var1) {
      if (!this.v2(var1)) {
         this.v5();
      } else {
         float var3 = this.v4(var1);
         if (var3 < 260.0F) {
            this.v1(var3 / 260.0F, true);
         } else if (var3 < 960.0F) {
            this.v4();
         } else {
            this.v1((var3 - 260.0F - 700.0F) / 260.0F, false);
         }
      }
   }

   public CopiedSupport2.Part1 v1() {
      return this.v17;
   }

   public CopiedSupport2.Part1 v2() {
      return this.v20;
   }

   public float v3() {
      return this.v21;
   }

   public static int v1(int var0, float var1) {
      int var2 = Math.round((var0 >>> 24 & 0xFF) * var1);
      if (var2 < 0) {
         var2 = 0;
      } else if (var2 > 255) {
         var2 = 255;
      }

      return var2 << 24 | var0 & 16777215;
   }

   private void v1(float var1, boolean var2) {
      float var3 = 1.0F - Math.clamp(var1 / 0.72F, 0.0F, 1.0F);
      float var4 = Math.clamp((var1 - 0.27999997F) / 0.72F, 0.0F, 1.0F);
      float var5 = var2 ? -1.0F : 1.0F;
      CopiedSupport2.Part1 var6 = var2 ? this.v17 : this.v20;
      CopiedSupport2.Part1 var7 = var2 ? this.v20 : this.v17;
      var6.v1(var3, var5);
      var7.v1(var4, -var5);
      this.v21 = var2 ? v1(0.0F, 0.5F, var1) : 1.0F - v1(0.72F, 1.0F, var1);
   }

   private void v4() {
      this.v17.v1(0.0F, 0.0F);
      this.v20.v1(1.0F, 0.0F);
      this.v21 = 1.0F;
   }

   private void v5() {
      this.v17.v1(1.0F, 0.0F);
      this.v20.v1(0.0F, 0.0F);
      this.v21 = 0.0F;
   }

   private float v4(long var1) {
      return (float)(var1 - this.v19) / 1000000.0F;
   }

   public static float v1(float var0) {
      float var1 = (var0 - 0.45F) / 0.55F;
      if (!(var1 <= 0.0F) && !(var1 >= 1.0F)) {
         float var2 = var1 * (1.0F - var1);
         return 16.0F * var2 * var2;
      } else {
         return 0.0F;
      }
   }

   public static float v2(float var0) {
      float var1 = 6.0F * var0 * (1.0F - var0);
      float var2 = (var0 - 0.45F) / 0.55F;
      if (var2 > 0.0F && var2 < 1.0F) {
         var1 += 13.44F * var2 * (1.0F - var2) * (1.0F - 2.0F * var2) / 0.55F;
      }

      return var1;
   }

   private static float v6() {
      float var0 = 0.0F;

      for (int var1 = 0; var1 <= 200; var1++) {
         var0 = Math.max(var0, Math.abs(v2(var1 / 200.0F)));
      }

      return var0;
   }

   public static float v3(float var0) {
      return hudSupport60.v1(Math.clamp(var0, 0.0F, 1.0F));
   }

   private static float v1(float var0, float var1, float var2) {
      return v3((var2 - var0) / (var1 - var0));
   }

   public static final class Part1 {
      private float v1;
      private float v2;
      private float v3 = 1.0F;
      private float v4 = 1.0F;
      private float v5;

      public Part1() {
      }

      public float v1() {
         return this.v1;
      }

      public float v2() {
         return this.v2;
      }

      public float v3() {
         return this.v3;
      }

      public float v4() {
         return this.v4;
      }

      public float v5() {
         return this.v5;
      }

      public void v1(float var1, float var2) {
         float var3 = var1 <= 0.0F ? 0.0F : (var1 >= 1.0F ? 1.0F : var1);
         this.v1 = CopiedSupport2.v3(var3);
         this.v2 = var2 * 4.0F * (1.0F - this.v1 - 0.42F * CopiedSupport2.v1(var3));
         float var4 = 1.0F - 0.16000003F * (1.0F - this.v1);
         float var5 = Math.max(0.2F, 1.0F + 0.1F * CopiedSupport2.v2(var3) / CopiedSupport2.v15);
         this.v3 = var4 / var5;
         this.v4 = var4 * var5;
         float var6 = 1.0F - var3;
         this.v5 = 0.22F * var6 * (float)Math.sqrt(var6);
      }
   }
}
