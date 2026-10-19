package cc.syky.ui;

import cc.syky.cloud.GETSupport2;
import cc.syky.cloud.cloudSupport16;
import cc.syky.cloud.cloudSupport88;
import cc.syky.hud.hudSupport54;
import cc.syky.render.font.MsdfFont;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

public final class YouAndSupport extends UiNode {
   private static final String v1 = "Type in-game name or syky username";
   private static final String v2 = "Write your message (optional)";
   private final GETSupport2 v3;
   private final cloudSupport88 v4;
   private final YouAndSupport.Part2 v5;
   private final YouAndSupport.Part5 v6;
   private final YouAndSupport.Part1 v7;
   private final YouAndSupport.Part4 v8;
   private final MsdfFont v13;
   private final MsdfFont v14;
   private final uiSupport53 v15;
   private float v16;
   private boolean v18;
   private String v19 = "";
   private boolean v17;

   public YouAndSupport(
      GETSupport2 var1, cloudSupport88 var2, YouAndSupport.Part2 var3, YouAndSupport.Part5 var4, YouAndSupport.Part1 var5, YouAndSupport.Part4 var6, float var7
   ) {
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = var3;
      this.v6 = var4;
      this.v7 = var5;
      this.v8 = var6;
      this.v16 = var7;
      this.v13 = v1(32, "Type in-game name or syky username");
      this.v14 = v1(200, "Write your message (optional)");
      this.v15 = new uiSupport53(uiSupport53.Part2.SEND, "Send friend request", uiSupport143.v37, var7, this::v5);
      this.v15.v4(false);
      this.v15.v2(false);
   }

   private static MsdfFont v1(int var0, String var1) {
      MsdfFont var2 = new MsdfFont("syky_sans_strong", var0, var0x -> {});
      var2.v1(var1);
      var2.v1(true);
      var2.v1(1060L);
      return var2;
   }

   public void v1(float var1) {
      this.v16 = var1;
      this.v15.v1(var1);
   }

   public String v1() {
      return this.v13.v2();
   }

   public static float v2() {
      return 161.0F;
   }

   private void v5() {
      if (!this.v18) {
         String var1 = this.v13.v2().strip();
         if (!var1.isEmpty()) {
            if (var1.startsWith("@")) {
               this.v1(0L, var1.substring(1).strip());
            } else {
               List var2 = this.v4.v1(var1, System.currentTimeMillis());
               if (var2.isEmpty()) {
                  this.v1(var1);
               } else {
                  this.v18 = true;
                  this.v3.v1(var1, (Consumer<GETSupport2.Part6>)(var2x -> {
                     this.v18 = false;
                     ArrayList var3 = new ArrayList(var2.size() + 1);

                     for (cloudSupport88.Part1 var5 : var2) {
                        var3.add(new YouAndSupport.Part3(var5.v1(), var5.v2(), var5));
                     }

                     if (var2x != null && var3.stream().noneMatch(var1xx -> var1xx.v1() == var2x.v1())) {
                        var3.add(new YouAndSupport.Part3(var2x.v1(), var2x.v2(), null));
                     }

                     if (var3.size() == 1) {
                        this.v1(((YouAndSupport.Part3)var3.getFirst()).v1(), ((YouAndSupport.Part3)var3.getFirst()).v2());
                     } else {
                        this.v5.among(var3, this.v15.v9, this.v15.v10 + this.v15.v12, var1xx -> this.v1(var1xx.v1(), var1xx.v2()));
                     }
                  }));
               }
            }
         }
      }
   }

   private void v1(String var1) {
      if (this.v8.withoutAccount(var1)) {
         this.v6
            .say(
               var1,
               var1
                  + " uses syky but can't take friend requests: they have no syky account yet, or don't take requests. To ask a syky account with this username instead, type @"
                  + var1
                  + "."
            );
      } else {
         this.v18 = true;
         this.v3.v1(var1, (Consumer<GETSupport2.Part6>)(var2 -> {
            this.v18 = false;
            if (var2 == null) {
               this.v1(0L, var1);
            } else {
               this.v7.unmet(var2.v2(), () -> this.v1(var2.v1(), var2.v2()));
            }
         }));
      }
   }

   private void v1(long var1, String var3) {
      if (!this.v18 && !var3.isEmpty()) {
         this.v18 = true;
         Consumer var4 = var1x -> {
            this.v18 = false;
            this.v13.v2("");
            this.v14.v2("");
            this.v1(var1x.v3() ? "You and " + var1x.v2() + " are friends now." : "Friend request sent to " + var1x.v2() + ".", false);
         };
         Consumer var5 = var2 -> {
            this.v18 = false;
            this.v1("", false);
            this.v6.say(var3, var2);
         };
         if (var1 > 0L) {
            this.v3.v1(var1, this.v14.v2(), var4, var5);
         } else {
            this.v3.v1(var3, this.v14.v2(), var4, var5);
         }
      }
   }

   private void v1(String var1, boolean var2) {
      this.v19 = var1;
      this.v17 = var2;
   }

   private float v2(float var1) {
      return SignInSupport.v4(var1, this.v16);
   }

   private void v6() {
      boolean var1 = !this.v13.v2().isBlank();
      this.v15.v3(var1);
      this.v15.v2(var1 && !this.v18);
      float var2 = this.v9 + this.v11;
      float var3 = this.v2(200.0F);
      float var4 = var2 - this.v2(16.0F) - var3;
      this.v15.v1(var4, this.v10 + this.v2(16.0F), var3, this.v2(38.0F));
      float var5 = this.v9 + this.v2(16.0F);
      float var6 = 18.0F * this.v16;
      float var7 = this.v2(70.0F);
      this.v13.v1(var5, this.v10, Math.max(0.0F, var4 - this.v2(16.0F) - var5), var7);
      this.v13.v1(var6, uiSupport169.v1(var7 / 2.0F, var6), 1.0F * this.v16);
      float var8 = this.v10 + var7 + SignInSupport.v2(this.v16);
      float var9 = this.v10 + this.v12 - var8;
      float var10 = 97.5F * this.v16 - (var8 - this.v10);
      this.v14.v1(var5, var8, Math.max(0.0F, var2 - this.v2(16.0F) - var5), var9);
      this.v14.v1(var6, uiSupport169.v1(var10, var6), 1.0F * this.v16);
      int var11 = cloudSupport16.v2();
      this.v13.v1(var11, cloudSupport16.v1(), SignInSupport.v31(), var11);
      this.v14.v1(var11, cloudSupport16.v1(), SignInSupport.v31(), var11);
   }

   public void v1(uiSupport102 var1) {
      var1.v1(this);
      var1.v1(this.v9);
      var1.v1(this.v10);
      var1.v1(this.v11);
      var1.v1(this.v12);
      var1.v1(this.v13.v2());
      var1.v1(this.v14.v2());
      var1.v1(this.v13.v3());
      var1.v1(this.v14.v3());
      var1.v1(this.v19);
      var1.v1(this.v18);
      var1.v1(this.v15.v8());
      var1.v1(this.v15.v5());
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v6();
      uiSupport115.v1(this.v9, this.v10, this.v11, this.v12, 1.0F, this.v16);
      float var2 = SignInSupport.v2(this.v16);
      float var3 = this.v2(16.0F);
      uiSupport169.v1(
         this.v9 + var3, this.v10 + this.v2(70.0F), this.v11 - 2.0F * var3, var2, SignInSupport.v1(SignInSupport.v46(), this.v16), SignInSupport.v3(var2)
      );
      if (this.v13.v3() || this.v14.v3()) {
         uiSupport33.v1();
      }

      this.v13.v1(var1);
      this.v14.v1(var1);
      this.v15.v1(var1);
      if (!this.v19.isEmpty()) {
         float var4 = 16.0F * this.v16;
         uiSupport169.v1("syky_sans", this.v19, this.v9 + var3, this.v10 + this.v12 - this.v2(35.0F), var4, this.v17 ? -218123180 : cloudSupport16.v3());
      }
   }

   public boolean v3() {
      return this.v13.v3() || this.v14.v3();
   }

   public void v4() {
      this.v13.v3(false);
      this.v14.v3(false);
   }

   @Nullable
   private MsdfFont v7() {
      return this.v13.v3() ? this.v13 : (this.v14.v3() ? this.v14 : null);
   }

   @Override
   public boolean v2(int var1, int var2) {
      MsdfFont var3 = this.v7();
      if (var3 == null) {
         return false;
      } else if (var1 == 257 || var1 == 335) {
         this.v5();
         return true;
      } else if (var1 == 258) {
         MsdfFont var4 = var3 == this.v13 ? this.v14 : this.v13;
         var3.v3(false);
         var4.v3(true);
         var4.v4();
         return true;
      } else {
         var3.v2(var1, var2);
         return true;
      }
   }

   @Override
   public boolean v3(int var1, int var2) {
      MsdfFont var3 = this.v7();
      if (var3 == null) {
         return false;
      } else {
         var3.v3(var1, var2);
         return true;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else {
         this.v6();
         if (this.v15.v1(var1, var2)) {
            return this.v15.v1(var1, var2, var3);
         } else {
            MsdfFont var4 = this.v13.v1(var1, var2) ? this.v13 : (this.v14.v1(var1, var2) ? this.v14 : null);
            if (var4 == null) {
               this.v4();
               return true;
            } else {
               (var4 == this.v13 ? this.v14 : this.v13).v3(false);
               var4.v2(var1, var2, var3);
               return true;
            }
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      MsdfFont var6 = this.v7();
      return var6 != null && var6.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      MsdfFont var4 = this.v7();
      return var4 != null && var4.v4(var1, var2, var3);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (!this.v1(var1, var2)) {
         return hudSupport54.ARROW;
      } else {
         this.v6();
         if (this.v15.v1(var1, var2)) {
            return this.v15.v2(var1, var2);
         } else {
            return !this.v13.v1(var1, var2) && !this.v14.v1(var1, var2) ? hudSupport54.ARROW : hudSupport54.IBEAM;
         }
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      MsdfFont var1 = this.v7();
      return var1 == null ? null : var1.v31();
   }

   @FunctionalInterface
   public interface Part1 {
      void unmet(String var1, Runnable var2);
   }

   @FunctionalInterface
   public interface Part2 {
      void among(List<YouAndSupport.Part3> var1, float var2, float var3, Consumer<YouAndSupport.Part3> var4);
   }

   public record Part3(long uid, String username, @Nullable cloudSupport88.Part1 met) {
      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }

      @Nullable
      public cloudSupport88.Part1 v3() {
         return this.met;
      }
   }

   @FunctionalInterface
   public interface Part4 {
      boolean withoutAccount(String var1);
   }

   @FunctionalInterface
   public interface Part5 {
      void say(String var1, String var2);
   }
}
