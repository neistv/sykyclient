package cc.syky.ui;

import cc.syky.cloud.GETSupport2;
import cc.syky.cloud.cloudSupport88;
import cc.syky.hud.hudSupport54;
import java.time.Instant;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class RequestSentSupport extends uiSupport54 {
   public static final String v1 = "met:";
   private final RequestSentSupport.Part1 v7;
   private cloudSupport88.Part1 v13;
   private String v14 = "";
   private String v15 = "";
   private String v16 = "";
   private long v18 = -1L;
   private long v19 = -1L;
   private boolean v17;
   private final uiSupport53 v20;
   private final uiSupport53 v21;

   public RequestSentSupport(RequestSentSupport.Part1 var1, cloudSupport88.Part1 var2, float var3, boolean var4) {
      super(var1, var2.v1(), "met:", var3, var4);
      this.v7 = var1;
      this.v20 = new uiSupport53(uiSupport53.Part2.ACCEPT, "Send friend request", uiSupport143.v37, var3, () -> var1.v1(this));
      this.v21 = new uiSupport53(uiSupport53.Part2.QUIET, "Request sent", null, var3, () -> {});
      this.v21.v2(false);
      this.v1(var2);
   }

   public void v1(cloudSupport88.Part1 var1) {
      this.v13 = var1;
      this.v2(var1.v3(), 0L);
      String var2 = "@" + var1.v2();
      if (!var2.equals(this.v14)) {
         this.v14 = var2;
         this.v15 = uiSupport101.v1(var1.v3() + " " + var1.v2());
      }
   }

   public cloudSupport88.Part1 v1() {
      return this.v13;
   }

   @Override
   public String f_() {
      return this.v15;
   }

   @Override
   public void v1(float var1) {
      super.v1(var1);
      this.v20.v1(var1);
      this.v21.v1(var1);
   }

   public void v1(long var1) {
      long var3 = var1 / 60000L;
      boolean var5 = uiSupport223.v5;
      if (this.v13.v8() != this.v18 || var3 != this.v19 || var5 != this.v17 || this.v16.isEmpty()) {
         this.v18 = this.v13.v8();
         this.v19 = var3;
         this.v17 = var5;
         this.v16 = v1(this.v13, var5, var1);
      }
   }

   public static String v1(cloudSupport88.Part1 var0, boolean var1, long var2) {
      String var4 = uiSupport56.v1(Instant.ofEpochMilli(var0.v8()), Instant.ofEpochMilli(var2));
      String var5 = var4.isEmpty() ? "Seen just now" : "Seen " + var4 + " ago";
      String var6 = v1(var0, var1);
      return var6.isEmpty() ? var5 : var6 + " · " + var5;
   }

   public static String v1(cloudSupport88.Part1 var0, boolean var1) {
      return var0.v5().isEmpty() ? "" : (var1 ? "Protected" : var0.v5());
   }

   @Override
   public String v4() {
      return this.v16;
   }

   @Override
   public String v9() {
      return this.v14;
   }

   @Nullable
   @Override
   public class_2960 v10() {
      return this.v7.v1(this.v13);
   }

   private uiSupport53 v27() {
      return this.v7.v3(this.v11()) == GETSupport2.Part5.REQUEST_SENT ? this.v21 : this.v20;
   }

   private void v28() {
      uiSupport53 var1 = this.v27();
      float var2 = SignInSupport.v4(38.0F, this.v4);
      float var3 = uiSupport126.v1(this.v10, this.v12, var2, this.v13());
      float var4 = this.v9 + this.v11 - SignInSupport.v4(16.0F, this.v4);
      float var5 = SignInSupport.v4(var1.v6(), this.v4);
      var1.v1(var4 - var5, var3, var5, var2);
      this.v20.v2(!this.v7.v4(this.v11()) && this.v17());
   }

   @Override
   public void v1(uiSupport35 var1, float var2) {
      this.v28();
      this.v27().v1(var1);
   }

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v27());
      var1.v1(this.v7.v4(this.v11()));
      var1.v1(this.v20.v8());
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      return false;
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (this.v17() && this.v1(var1, var2) && var3 == 0) {
         this.v28();
         uiSupport53 var4 = this.v27();
         if (var4.v1(var1, var2)) {
            var4.v1(var1, var2, var3);
         } else {
            this.v7.v2(this);
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (this.v17() && this.v1(var1, var2)) {
         this.v28();
         uiSupport53 var3 = this.v27();
         return var3.v1(var1, var2) ? var3.v2(var1, var2) : hudSupport54.POINTER;
      } else {
         return hudSupport54.ARROW;
      }
   }

   public interface Part1 extends uiSupport54.Part1 {
      GETSupport2.Part5 v3(long var1);

      boolean v4(long var1);

      void v1(RequestSentSupport var1);

      void v2(RequestSentSupport var1);

      class_2960 v1(cloudSupport88.Part1 var1);
   }
}
