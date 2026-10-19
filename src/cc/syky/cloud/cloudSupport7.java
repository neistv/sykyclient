package cc.syky.cloud;

public final class cloudSupport7 {
   public static final int v1 = 8;
   private boolean v2;
   private float v3;
   private int v4 = 8;

   public cloudSupport7() {
   }

   public void v1(float var1) {
      this.v2 = true;
      this.v3 = var1;
      this.v4 = 0;
   }

   public void v1(boolean var1) {
      if (this.v2) {
         if (!var1 || ++this.v4 > 8) {
            this.v2 = false;
         }
      }
   }

   public void v1() {
      this.v2 = false;
      this.v3 = 0.0F;
      this.v4 = 8;
   }

   public boolean v2() {
      return this.v2;
   }

   public float v3() {
      return this.v3;
   }
}
