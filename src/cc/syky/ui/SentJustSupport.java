package cc.syky.ui;

import cc.syky.cloud.GETSupport2;
import cc.syky.hud.hudSupport54;
import java.time.Instant;
import org.jetbrains.annotations.Nullable;

public final class SentJustSupport extends uiSupport54 {
   private final SentJustSupport.Part1 v13;
   private final boolean v14;
   private GETSupport2.Part1 v15;
   private final uiSupport53 v16;
   private final uiSupport53 v18;
   private String v19 = "";
   private GETSupport2.Part1 v17;
   private long v20 = -1L;
   public static final String v1 = "in:";
   public static final String v7 = "out:";

   public SentJustSupport(SentJustSupport.Part1 var1, GETSupport2.Part1 var2, boolean var3, float var4, boolean var5) {
      super(var1, var2.v1(), var3 ? "in:" : "out:", var4, var5);
      this.v13 = var1;
      this.v14 = var3;
      this.v15 = var2;
      this.v17 = var2;
      this.v16 = new uiSupport53(uiSupport53.Part2.ACCEPT, "Accept", null, var4, () -> var1.v1(this));
      this.v18 = new uiSupport53(uiSupport53.Part2.QUIET, var3 ? "Decline" : "Cancel", null, var4, () -> var1.v2(this));
      this.v2(var2.v2(), var2.v3());
   }

   public void v1(GETSupport2.Part1 var1) {
      this.v15 = var1;
      this.v2(var1.v2(), var1.v3());
   }

   @Override
   public void v1(float var1) {
      super.v1(var1);
      this.v16.v1(var1);
      this.v18.v1(var1);
   }

   public void v1(long var1) {
      long var3 = var1 / 60000L;
      if (this.v15 != this.v17 || var3 != this.v20 || this.v19.isEmpty()) {
         this.v17 = this.v15;
         this.v20 = var3;
         this.v19 = v1(this.v15, Instant.ofEpochMilli(var1));
      }
   }

   public static String v1(GETSupport2.Part1 var0, Instant var1) {
      if (!var0.v5().isEmpty()) {
         return var0.v5();
      } else {
         String var2 = uiSupport56.v1(var0.v4(), var1);
         return var2.isEmpty() ? "Sent just now" : "Sent " + var2 + " ago";
      }
   }

   @Override
   public String v4() {
      return this.v19;
   }

   private void v1() {
      float var1 = SignInSupport.v4(38.0F, this.v4);
      float var2 = uiSupport126.v1(this.v10, this.v12, var1, this.v13());
      float var3 = this.v9 + this.v11 - SignInSupport.v4(16.0F, this.v4);
      if (this.v14) {
         float var4 = SignInSupport.v4(this.v16.v6(), this.v4);
         this.v16.v1(var3 - var4, var2, var4, var1);
         var3 -= var4 + SignInSupport.v4(14.0F, this.v4);
      }

      float var6 = SignInSupport.v4(this.v18.v6(), this.v4);
      this.v18.v1(var3 - var6, var2, var6, var1);
      boolean var5 = !this.v13.v3(this) && this.v17();
      this.v16.v2(var5);
      this.v18.v2(var5);
   }

   @Override
   public void v1(uiSupport35 var1, float var2) {
      this.v1();
      if (this.v14) {
         this.v16.v1(var1);
      }

      this.v18.v1(var1);
   }

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v13.v3(this));
      var1.v1(this.v16.v8());
      var1.v1(this.v18.v8());
   }

   @Nullable
   private uiSupport53 v3(float var1, float var2) {
      this.v1();
      if (this.v14 && this.v16.v1(var1, var2)) {
         return this.v16;
      } else {
         return this.v18.v1(var1, var2) ? this.v18 : null;
      }
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      return false;
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (this.v17() && this.v1(var1, var2) && var3 == 0) {
         uiSupport53 var4 = this.v3(var1, var2);
         if (var4 != null) {
            var4.v1(var1, var2, var3);
         } else {
            this.v13.v4(this);
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      uiSupport53 var3 = this.v17() && this.v1(var1, var2) ? this.v3(var1, var2) : null;
      if (var3 != null) {
         return var3.v2(var1, var2);
      } else {
         return this.v17() && this.v1(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
      }
   }

   public interface Part1 extends uiSupport54.Part1 {
      void v1(SentJustSupport var1);

      void v2(SentJustSupport var1);

      boolean v3(SentJustSupport var1);

      void v4(SentJustSupport var1);
   }
}
