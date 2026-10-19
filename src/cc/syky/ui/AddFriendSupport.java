package cc.syky.ui;

import cc.syky.cloud.GETSupport;
import cc.syky.cloud.GETSupport2;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import java.time.Instant;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class AddFriendSupport extends uiSupport54 {
   public static final String v1 = "home:";
   public static final long v7 = 0L;
   private static final float v13 = 16.0F;
   private final AddFriendSupport.Part1 v14;
   private boolean v15;
   private AddFriendSupport.Part2 v16;
   private String v18 = "";
   private AddFriendSupport.Part2 v19;
   @Nullable
   private GETSupport.Part10 v17;
   private float v20 = -1.0F;
   private long v21 = -1L;
   private int v22;
   private final hudSupport57 v24 = new hudSupport57(0.0F, 45.0F);
   private final hudSupport57 v25 = new hudSupport57(0.0F, 45.0F);
   private final uiSupport53 v26;

   public AddFriendSupport(AddFriendSupport.Part1 var1, AddFriendSupport.Part2 var2, boolean var3, float var4, boolean var5) {
      super(var1, var2.v4(), "home:", var4, var5);
      this.v14 = var1;
      this.v15 = var3;
      this.v16 = var2;
      this.v19 = var2;
      this.v26 = new uiSupport53(uiSupport53.Part2.ACCEPT, "Add friend", null, var4, () -> var1.v2(this));
      this.v2(var2.v5(), var2.v6());
   }

   @Override
   public void v1(float var1) {
      super.v1(var1);
      this.v26.v1(var1);
   }

   private boolean v27() {
      return !this.v16.v2() && this.v16.v7() == null && this.v14.v2(this.v16.v4());
   }

   private void v28() {
      float var1 = SignInSupport.v4(38.0F, this.v4);
      float var2 = SignInSupport.v4(this.v26.v6(), this.v4);
      this.v26.v1(this.v29() - SignInSupport.v4(14.0F, this.v4) - var2, uiSupport126.v1(this.v10, this.v12, var1, this.v13()), var2, var1);
      this.v26.v2(this.v17());
   }

   public void v1(AddFriendSupport.Part2 var1, boolean var2) {
      this.v16 = var1;
      if (this.v15 != var2) {
         this.v15 = var2;
         this.v18 = "";
      }

      this.v2(var1.v5(), var1.v6());
   }

   public boolean v1() {
      return this.v16.v2();
   }

   public void v1(long var1) {
      long var3 = var1 / 60000L;
      if (this.v16.v2()) {
         float var11 = this.v4 > 0.0F && this.v11 > 0.0F ? this.v11 / this.v4 - 61.0F - 65.0F : 0.0F;
         if (this.v16 != this.v19 || var11 != this.v20 || this.v18.isEmpty()) {
            this.v19 = this.v16;
            this.v20 = var11;
            this.v22 = this.v14.v26();
            String var12 = this.v14.v25();
            this.v18 = var11 > 0.0F && uiSupport169.v2("syky_sans", var12, 17.0F) > var11 ? uiSupport116.v1("syky_sans", var12, var11, 17.0F) : var12;
         }
      } else {
         GETSupport.Part10 var5 = this.v14.v1(this.v16.v4());
         float var6 = this.v4 > 0.0F && this.v11 > 0.0F
            ? this.v11 / this.v4 - 61.0F - 24.0F - 65.0F - 16.0F - (this.v27() ? this.v26.v6() + 14.0F : 0.0F)
            : 0.0F;
         if (this.v16 != this.v19 || var5 != this.v17 || var6 != this.v20 || var3 != this.v21 || this.v18.isEmpty()) {
            this.v19 = this.v16;
            this.v17 = var5;
            this.v20 = var6;
            this.v21 = var3;
            this.v22 = var5 == null ? 0 : var5.v5();
            GETSupport2.Part2 var8 = this.v16.v7();
            String var9;
            if (this.v15 && var5 != null) {
               String var10 = switch (var5.v6()) {
                  case WORDS -> v1(var5.v2());
                  case PLACE -> "Coordinates";
                  case INVITE -> "Server invite";
               };
               var9 = (var5.v3() ? "You: " : "") + var10;
            } else if (var8 != null) {
               var9 = v1(var8, Instant.ofEpochMilli(var1));
            } else {
               var9 = "Not friends";
            }

            this.v18 = var6 > 0.0F && uiSupport169.v2("syky_sans", var9, 17.0F) > var6 ? uiSupport116.v1("syky_sans", var9, var6, 17.0F) : var9;
         }
      }
   }

   private static String v1(String var0) {
      int var1 = var0.indexOf(10);
      return var1 < 0 ? var0 : var0.substring(0, var1) + " ...";
   }

   public static String v1(GETSupport2.Part2 var0, Instant var1) {
      if (var0.v5()) {
         return "Online";
      } else {
         Instant var2 = var0.v7();
         String var3 = var2 == null ? "" : uiSupport56.v1(var2, var1);
         return var3.isEmpty() ? "Offline" : "Offline " + var3;
      }
   }

   public boolean v3() {
      return this.v16.v7() != null;
   }

   @Override
   public String v4() {
      return this.v18;
   }

   @Override
   public boolean v5() {
      GETSupport2.Part2 var1 = this.v16.v7();
      return var1 != null && var1.v5();
   }

   @Nullable
   @Override
   public class_2960 v6() {
      return this.v16.v2() ? uiSupport143.v40 : null;
   }

   @Nullable
   @Override
   public class_2960 v7() {
      return this.v16.v3() ? uiSupport143.v22 : null;
   }

   @Override
   public int v6(float var1) {
      return this.v22 > 0 ? uiSupport49.v2(uiSupport47.TEXT_BRIGHT) : super.v6(var1);
   }

   @Override
   public int v8() {
      return this.v22 > 0 ? uiSupport49.v2(uiSupport47.TEXT) : super.v8();
   }

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v22);
      var1.v1(this.v16.v3());
      var1.v1(this.v27());
      var1.v1(this.v26.v8());
   }

   private float v29() {
      return this.v9 + this.v11 - SignInSupport.v4(85.0F, this.v4);
   }

   private float v30() {
      return uiSupport126.v1(this.v10, this.v12, SignInSupport.v4(24.0F, this.v4), this.v13());
   }

   private boolean v3(float var1, float var2) {
      float var3 = this.v29() + SignInSupport.v4(24.0F, this.v4) / 2.0F;
      float var4 = this.v30() + SignInSupport.v4(24.0F, this.v4) / 2.0F;
      float var5 = 34.0F * this.v4 / 2.0F;
      return var1 >= var3 - var5 && var1 <= var3 + var5 && var2 >= var4 - var5 && var2 <= var4 + var5;
   }

   private float v32() {
      return this.v9 + this.v11 - SignInSupport.v4(28.0F + uiSupport110.FRIEND.v1(), this.v4);
   }

   private float v23() {
      return uiSupport126.v1(this.v10, this.v12, uiSupport110.FRIEND.v2() * this.v4, this.v13());
   }

   private boolean v4(float var1, float var2) {
      return uiSupport111.v1(uiSupport110.FRIEND, var1, var2, this.v32(), this.v23(), this.v4);
   }

   @Override
   public void v1(uiSupport35 var1, float var2) {
      if (this.v16.v2()) {
         if (this.v22 > 0) {
            uiSupport51.v1(
               this.v9 + this.v11 - SignInSupport.v4(28.0F, this.v4),
               uiSupport126.v1(this.v10, this.v12, SignInSupport.v4(20.0F, this.v4), this.v13()),
               this.v22,
               this.v4,
               this.v5
            );
         }
      } else {
         if (this.v27()) {
            this.v28();
            this.v26.v1(var1);
         }

         boolean var3 = this.v19().v1() && !this.v8.v28() && var1.v2();
         this.v24.v2(var3 && this.v3(var1.v1, var1.v2) ? 1.0F : 0.0F);
         this.v25.v2(var3 && this.v4(var1.v1, var1.v2) ? 1.0F : 0.0F);
         float var4 = SignInSupport.v4(24.0F, this.v4);
         int var5 = this.v22 > 0
            ? uiSupport49.v2(uiSupport47.ACCENT_SOFT)
            : uiSupport155.v1(SignInSupport.v28(), SignInSupport.v30(), hudSupport60.v1(this.v24.v2()));
         uiSupport169.v1(uiSupport143.v43, this.v29(), this.v30(), var4, var4, uiSupport155.v1(var5, this.v5), uiRecord7.ZERO);
         if (this.v22 > 0) {
            uiSupport51.v1(this.v29() + var4 + SignInSupport.v4(9.0F, this.v4), this.v30() - SignInSupport.v4(7.0F, this.v4), this.v22, this.v4, this.v5);
         }

         uiSupport111.v1(
            uiSupport110.FRIEND,
            this.v32(),
            this.v23(),
            this.v4,
            uiSupport155.v1(uiSupport110.FRIEND.v7(), uiSupport110.FRIEND.v9(), hudSupport60.v1(this.v25.v2())),
            this.v5
         );
      }
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      return this.v17() && this.v1(var1, var2) && !this.v16.v2() && (var3 == 1 || var3 == 0 && this.v4(var1, var2));
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (this.v17() && this.v1(var1, var2)) {
         if (this.v16.v2() || var3 != 1 && (var3 != 0 || !this.v4(var1, var2))) {
            if (var3 != 0) {
               return false;
            } else {
               if (this.v27()) {
                  this.v28();
                  if (this.v26.v1(var1, var2)) {
                     return this.v26.v1(var1, var2, var3);
                  }
               }

               this.v14.v1(this);
               return true;
            }
         } else {
            this.v14.v1(this, var1, var2);
            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v17() && this.v1(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
   }

   public interface Part1 extends uiSupport54.Part1 {
      void v1(AddFriendSupport var1, float var2, float var3);

      void v1(AddFriendSupport var1);

      @Nullable
      GETSupport.Part10 v1(long var1);

      String v25();

      int v26();

      boolean v2(long var1);

      void v2(AddFriendSupport var1);
   }

   public record Part2(long uid, String name, long avatar, @Nullable GETSupport2.Part2 friend) {
      public static AddFriendSupport.Part2 v1(GETSupport2.Part2 var0) {
         return new AddFriendSupport.Part2(var0.v1(), var0.v2(), var0.v3(), var0);
      }

      public static AddFriendSupport.Part2 v1() {
         return new AddFriendSupport.Part2(0L, "Requests", 0L, null);
      }

      public boolean v2() {
         return this.uid == 0L;
      }

      public boolean v3() {
         GETSupport2.Part2 var1 = this.friend;
         return var1 != null && var1.v8() != null;
      }

      public long v4() {
         return this.uid;
      }

      public String v5() {
         return this.name;
      }

      public long v6() {
         return this.avatar;
      }

      @Nullable
      public GETSupport2.Part2 v7() {
         return this.friend;
      }
   }
}
