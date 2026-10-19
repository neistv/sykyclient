package cc.syky.ui;

import cc.syky.LANRecord;
import cc.syky.sykyRecord4;
import cc.syky.hud.hudSupport57;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public final class uiSupport46 extends TypeASupport {
   private static final float v1 = 21.0F;
   private final uiSupport46.Part1 v8;
   private final String v13;
   private sykyRecord4 v14;
   private String v15;
   private String v16;
   private String v18;
   private final hudSupport57 v19;
   @Nullable
   private final LANRecord v17;

   public uiSupport46(uiSupport46.Part1 var1, @Nullable LANRecord var2, sykyRecord4 var3, String var4, float var5, boolean var6) {
      super(var5, var6);
      this.v8 = var1;
      this.v17 = var2;
      this.v14 = var3;
      this.v13 = var4;
      this.v15 = sykyRecord4.v2(var3.v6(), var3.v7(), var3.v8());
      this.v16 = uiSupport101.v1(var3.v5());
      this.v18 = v2(var3);
      this.v19 = new hudSupport57(var3.v10() ? 1.0F : 0.0F, 55.0F);
   }

   public sykyRecord4 v1() {
      return this.v14;
   }

   @Nullable
   public LANRecord v3() {
      return this.v17;
   }

   @Override
   public String v2() {
      return this.v14.v4();
   }

   public String v4() {
      return this.v13;
   }

   public String v5() {
      return this.v16;
   }

   public String v32() {
      return this.v18;
   }

   private static String v2(sykyRecord4 var0) {
      String var1 = var0.v16();
      return var1 == null ? "" : uiSupport101.v1(var1);
   }

   public void v1(sykyRecord4 var1) {
      if (var1.v6() != this.v14.v6() || var1.v7() != this.v14.v7() || var1.v8() != this.v14.v8()) {
         this.v15 = sykyRecord4.v2(var1.v6(), var1.v7(), var1.v8());
      }

      if (!var1.v5().equals(this.v14.v5())) {
         this.v16 = uiSupport101.v1(var1.v5());
      }

      if (!Objects.equals(var1.v16(), this.v14.v16())) {
         this.v18 = v2(var1);
      }

      this.v14 = var1;
      this.v19.v2(var1.v10() ? 1.0F : 0.0F);
   }

   @Override
   public String v6() {
      return this.v14.v5();
   }

   @Override
   public float v8() {
      return 53.0F;
   }

   @Override
   public String v9() {
      String var1 = this.v14.v16();
      if (var1 != null) {
         return var1;
      } else {
         return uiSupport223.v4 ? "Protected" : this.v15;
      }
   }

   @Override
   public boolean v11() {
      return this.v14.v15();
   }

   @Override
   public boolean v13() {
      return !this.v8.v26();
   }

   @Override
   public int v14() {
      return 32;
   }

   @Override
   public void v1(String var1) {
      this.v8.v1(this, var1);
   }

   @Override
   public void v2(String var1) {
      this.v8.v2(this, var1);
   }

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v14);
   }

   @Override
   public float v1(uiSupport35 var1, float var2) {
      float var3 = this.v19.v2();
      float var4 = SignInSupport.v4(21.0F, this.v4);
      float var5 = uiSupport126.v1(this.v10, this.v12, var4, SignInSupport.v4(54.0F, this.v4));
      float var6 = this.v9 + SignInSupport.v4(16.0F, this.v4);
      int var7 = uiSupport155.v1(SignInSupport.v12(), SignInSupport.v13(), var3);
      if (var3 < 1.0F) {
         uiSupport169.v1(uiSupport143.v19, var6, var5, var4, var4, uiSupport155.v1(var7, this.v5 * (1.0F - var3)), uiRecord7.ZERO);
      }

      if (var3 > 0.0F) {
         uiSupport169.v1(uiSupport143.v18, var6, var5, var4, var4, uiSupport155.v1(var7, this.v5 * var3), uiRecord7.ZERO);
      }

      return var3;
   }

   @Override
   public boolean v3(float var1, float var2, int var3) {
      if (var3 == 2) {
         this.v8.v2(this, var1, var2);
         return true;
      } else if (var3 == 1) {
         this.v8.v1(this, var1, var2);
         return true;
      } else if (var3 != 0) {
         return false;
      } else {
         this.v8.v1(this);
         return true;
      }
   }

   public interface Part1 {
      void v1(uiSupport46 var1);

      void v1(uiSupport46 var1, float var2, float var3);

      void v2(uiSupport46 var1, float var2, float var3);

      void v1(uiSupport46 var1, String var2);

      void v2(uiSupport46 var1, String var2);

      boolean v26();
   }
}
