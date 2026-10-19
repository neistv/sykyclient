package cc.syky.ui;

import java.util.Objects;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class SignInSupport2 extends TypeASupport {
   private static final float v8 = 21.0F;
   private static final float v13 = 6.0F;
   private static final float v14 = 10.0F;
   public static final String v1 = "Sign in again";
   private final SignInSupport2.Part1 v15;
   private uiRecord16 v16;
   private final boolean v18;
   private String v19;
   private String v17;
   private final uiSupport109 v20;
   private String v21 = "";
   private boolean v22;
   private boolean v24;
   @Nullable
   private uiRecord16 v25;
   @Nullable
   private LastSeenDisplay v26;
   private long v27 = -1L;
   @Nullable
   private String v28;
   @Nullable
   private String v29;

   public SignInSupport2(SignInSupport2.Part1 var1, uiRecord16 var2, boolean var3, float var4, boolean var5) {
      super(var4, var5);
      this.v15 = var1;
      this.v16 = var2;
      this.v18 = var3;
      this.v19 = uiSupport101.v1(var2.v5());
      this.v17 = v2(var2);
      this.v20 = new uiSupport109(var2.v8());
   }

   public uiRecord16 v1() {
      return this.v16;
   }

   @Override
   public String v2() {
      return this.v16.v3();
   }

   public String v3() {
      return this.v19;
   }

   public String v4() {
      return this.v17;
   }

   private static String v2(uiRecord16 var0) {
      String var1 = var0.v18();
      return var1 == null ? "" : uiSupport101.v1(var1);
   }

   public void v1(uiRecord16 var1) {
      if (!var1.v5().equals(this.v16.v5())) {
         this.v19 = uiSupport101.v1(var1.v5());
      }

      if (!Objects.equals(var1.v18(), this.v16.v18())) {
         this.v17 = v2(var1);
      }

      this.v16 = var1;
      this.v20.v1(var1.v8());
   }

   public void v1(LastSeenDisplay var1, long var2, @Nullable String var4, boolean var5, boolean var6, @Nullable String var7) {
      this.v24 = var6;
      long var8 = var2 / 60000L;
      if (this.v16 != this.v25 || var1 != this.v26 || var8 != this.v27 || !Objects.equals(var4, this.v28) || !Objects.equals(var7, this.v29)) {
         this.v25 = this.v16;
         this.v26 = var1;
         this.v27 = var8;
         this.v28 = var4;
         this.v29 = var7;
         if (var4 != null) {
            this.v21 = var4;
            this.v22 = var5;
         } else if (this.v16.v10()) {
            this.v21 = "Sign in again";
            this.v22 = true;
         } else {
            this.v21 = NowSupport.v1(this.v16, var1, var2, var7);
            this.v22 = false;
         }
      }
   }

   public boolean v5() {
      return this.v16.v2() && this.v16.v4() == uiSupport272.OFFLINE;
   }

   @Override
   public String v6() {
      return uiSupport223.v2 ? "Protected" : this.v16.v5();
   }

   @Override
   public String v7() {
      return uiSupport223.v2 ? "" : this.v16.v5();
   }

   @Override
   public float v8() {
      return this.v18 ? 78.0F : 53.0F;
   }

   @Override
   public String v9() {
      return this.v21;
   }

   @Override
   public int v10() {
      return this.v22 ? -218123180 : SignInSupport.v49();
   }

   @Override
   public boolean v11() {
      return this.v16.v16();
   }

   @Override
   public boolean v12() {
      return this.v24;
   }

   @Override
   public boolean v13() {
      return !this.v15.v26();
   }

   @Override
   public int v14() {
      return 16;
   }

   @Override
   public void v1(String var1) {
      this.v15.v1(this, var1);
   }

   @Override
   public void v2(String var1) {
      this.v15.v2(this, var1);
   }

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v16);
      var1.v1(this.v20.v1());
      var1.v1(uiSupport223.v2);
      var1.v1(uiSupport223.v3);
   }

   @Override
   public float v1(uiSupport35 var1, float var2) {
      float var3 = SignInSupport.v4(21.0F, this.v4);
      float var4 = uiSupport126.v1(this.v10, this.v12, var3, SignInSupport.v4(54.0F, this.v4));
      float var5 = this.v20.v1(this.v9 + SignInSupport.v4(16.0F, this.v4), var4, this.v4, this.v5);
      if (this.v18) {
         uiSupport169.v1(
            this.v15.v1(this.v16),
            this.v9 + SignInSupport.v4(47.0F, this.v4),
            var4,
            SignInSupport.v4(21.0F, this.v4),
            uiSupport155.v1(-1, this.v5),
            uiRecord7.v1(6.0F * this.v4)
         );
      }

      return var5;
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      return this.v17() && this.v1(var1, var2) && var3 == 1;
   }

   @Override
   public boolean v3(float var1, float var2, int var3) {
      if (var3 == 1) {
         this.v15.v1(this, var1, var2);
         return true;
      } else if (var3 != 0) {
         return false;
      } else {
         this.v15.v1(this);
         return true;
      }
   }

   public interface Part1 {
      void v1(SignInSupport2 var1);

      void v1(SignInSupport2 var1, float var2, float var3);

      void v1(SignInSupport2 var1, String var2);

      void v2(SignInSupport2 var1, String var2);

      boolean v26();

      class_2960 v1(uiRecord16 var1);
   }
}
