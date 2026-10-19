package cc.syky.ui;

public final class uiSupport30 {
   public static final int v1 = 48;
   private final uiSupport30.Part2[] v2 = new uiSupport30.Part2[48];
   private int v3;

   public uiSupport30() {
      for (int var1 = 0; var1 < 48; var1++) {
         this.v2[var1] = new uiSupport30.Part2();
      }
   }

   public void v1() {
      this.v3 = 0;
   }

   public int v2() {
      return this.v3;
   }

   public uiSupport30.Part2 v1(int var1) {
      return this.v2[var1];
   }

   public void v1(uiSupport30.Part1 var1, float var2, float var3, float var4, float var5, int var6) {
      if (this.v3 < 48 && (var2 != var4 || var3 != var5)) {
         float var7 = Math.min(var2, var4);
         float var8 = Math.min(var3, var5);
         float var9 = Math.max(var2, var4);
         float var10 = Math.max(var3, var5);

         for (int var11 = 0; var11 < this.v3; var11++) {
            uiSupport30.Part2 var12 = this.v2[var11];
            if (var12.v1 == var1 && var12.v2 == var7 && var12.v3 == var8 && var12.v4 == var9 && var12.v5 == var10) {
               return;
            }
         }

         uiSupport30.Part2 var13 = this.v2[this.v3++];
         var13.v1 = var1;
         var13.v2 = var7;
         var13.v3 = var8;
         var13.v4 = var9;
         var13.v5 = var10;
         var13.v6 = var6;
      }
   }

   public static enum Part1 {
      ALIGN,
      SPACING,
      MEASURE,
      HELPER;

      private Part1() {
      }
   }

   public static final class Part2 {
      public uiSupport30.Part1 v1 = uiSupport30.Part1.ALIGN;
      public float v2;
      public float v3;
      public float v4;
      public float v5;
      public int v6;

      public Part2() {
      }

      public boolean v1() {
         return this.v2 == this.v4;
      }
   }
}
