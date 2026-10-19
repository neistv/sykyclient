package cc.syky.cloud;

public final class cloudSupport6 {
   public static final int v1 = -1;
   public static final int v2 = 2;
   private static final long v3 = 1000000000L;
   private static final long v4 = 8000000000L;
   private final cloudSupport6.Part1 v5 = new cloudSupport6.Part1();
   private final cloudSupport6.Part1 v6 = new cloudSupport6.Part1();
   private int v7 = -1;
   private int v8 = -1;
   private long v9;
   private long v10 = 8000000000L;

   public cloudSupport6() {
   }

   public void v1(int var1) {
      this.v8 = var1;
   }

   public void v1(int var1, long var2) {
      if (var1 == this.v8) {
         this.v1(var2);
         if (this.v7 != var1) {
            this.v2(var1);
         }

         this.v1(this.v5, this.v6, var2);
      }
   }

   public void v2(int var1, long var2) {
      this.v1(var2);
      if (this.v7 == -1) {
         this.v2(var1);
      } else if (this.v7 != var1) {
         return;
      }

      this.v1(this.v6, this.v5, var2);
   }

   private void v1(cloudSupport6.Part1 var1, cloudSupport6.Part1 var2, long var3) {
      var1.v3++;
      var1.v1++;
      var1.v2++;
      if (var1.v3 >= 2) {
         var1.v4 = false;
      }

      var2.v3 = 0;
      var2.v1 = 0;
      if (var2.v2 > 0) {
         if (var2.v4) {
            var2.v2 = 0;
            var2.v4 = false;
         } else {
            var2.v4 = true;
         }
      }

      this.v9 = var3;
   }

   public void v1(long var1) {
      if (this.v7 != -1) {
         if (var1 - this.v9 > this.v10) {
            this.v1();
         }
      }
   }

   public void v2(long var1) {
      this.v10 = var1 > 0L ? var1 : 8000000000L;
   }

   public void v1() {
      this.v5.v1();
      this.v6.v1();
      this.v7 = -1;
      this.v8 = -1;
      this.v9 = 0L;
   }

   private void v2(int var1) {
      this.v5.v1();
      this.v6.v1();
      this.v7 = var1;
   }

   public int v1(boolean var1) {
      return var1 ? this.v5.v2 : this.v5.v1;
   }

   public int v2(boolean var1) {
      return var1 ? this.v6.v2 : this.v6.v1;
   }

   public int v2() {
      return this.v7;
   }

   public long v3() {
      return this.v9;
   }

   public static final class Part1 {
      public int v1;
      public int v2;
      public int v3;
      public boolean v4;

      public Part1() {
      }

      public void v1() {
         this.v1 = 0;
         this.v2 = 0;
         this.v3 = 0;
         this.v4 = false;
      }
   }
}
