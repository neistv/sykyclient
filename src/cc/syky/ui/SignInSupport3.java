package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.internal.InternalSupport25;
import cc.syky.render.font.MsdfFont;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class SignInSupport3 extends UiScreen {
   private static final String[] v1 = new String[]{"Offline", "Microsoft"};
   private static final int v2 = 0;
   private static final int v3 = 1;
   private static final String v4 = "Type nickname...";
   private static final String v5 = "Add account";
   private static final String v6 = "Sign in";
   private static final String v7 = "Open page";
   private static final String v8 = "Try again";
   private static final String v13 = "Cancel";
   private static final String v14 = "Code";
   private static final String v15 = "Asking Microsoft for a code...";
   private static final String v16 = "Signing in...";
   private static final String v18 = "Your browser opens the Microsoft sign-in page with the code filled in.";
   private static final float v19 = 14.0F;
   private static final float v17 = 18.0F;
   private static final float v20 = 4.0F;
   private static final int v21 = 10;
   private static final int v22 = 0;
   private static final int v24 = 1;
   private static final int v25 = 2;
   private static final int v26 = 3;
   private static final int v27 = 4;
   private static final int v28 = 0;
   private static final int v29 = 1;
   private static final int v30 = 2;
   private static final int v32 = 3;
   private static final int v23 = 4;
   private final MicrosoftSignSupport v33;
   private SignInSupport3.Part2 v31;
   private final MsdfFont v34;
   private final uiSupport109[] v36 = new uiSupport109[]{new uiSupport109(true), new uiSupport109(false)};
   private int v38 = 0;
   @Nullable
   private TheSignSupport v42;
   @Nullable
   private uiSupport269 v43;
   private boolean v37;
   private SignInSupport3.Part1[] v48 = new SignInSupport3.Part1[0];
   private long v40 = -1L;
   private float[] v44 = new float[0];
   private float[] v47 = new float[0];
   private boolean[] v49 = new boolean[0];
   private float v46;
   private String v51 = "";
   private boolean v50;
   private List<String> v60 = List.of();
   @Nullable
   private String v59;
   private final hudSupport57[] v53 = new hudSupport57[10];
   private float v63;

   public SignInSupport3(MicrosoftSignSupport var1, SignInSupport3.Part2 var2, float var3) {
      this.v33 = var1;
      this.v31 = var2;
      this.v63 = var3;
      this.v34 = new MsdfFont("syky_sans_strong", 16, var1x -> this.v42 = null);
      this.v34.v1("Type nickname...");
      this.v34.v1(1060L);

      for (int var4 = 0; var4 < this.v53.length; var4++) {
         this.v53[var4] = new hudSupport57(0.0F, 90.0F);
      }

      uiSupport269 var5 = var1.v7();
      if (var5 != null && !var5.v2()) {
         this.v43 = var5;
         this.v37 = var5.v3() != null;
         this.v1(1, false);
      }

      this.v6();
   }

   public void v1(SignInSupport3.Part2 var1) {
      this.v31 = var1;
   }

   public void v1() {
      this.v1(1, false);
      this.v21();
   }

   @Nullable
   private uiSupport269.Part1 v5() {
      uiSupport269 var1 = this.v43;
      return var1 == null ? null : var1.v1();
   }

   private void v6() {
      long var1 = this.v7();
      if (var1 != this.v40 || this.v59 == null) {
         this.v40 = var1;
         ArrayList var3 = new ArrayList(10);
         var3.add(new SignInSupport3.Part1(0, 0, 0));
         var3.add(new SignInSupport3.Part1(0, 1, 0));
         String var4 = "";
         boolean var5 = false;
         if (this.v38 == 0) {
            var3.add(new SignInSupport3.Part1(1, 0, 1));
            TheSignSupport var6 = this.v42;
            if (var6 != null) {
               var4 = var6.v1();
               var5 = true;
               var3.add(new SignInSupport3.Part1(3, 0, 1));
            }

            var3.add(new SignInSupport3.Part1(2, 0, 2));
         } else {
            uiSupport269 var9 = this.v43;
            uiSupport269.Part1 var7 = this.v5();
            if (var7 == null || var7 == uiSupport269.Part1.CANCELLED || var7 == uiSupport269.Part1.DONE) {
               var4 = "Your browser opens the Microsoft sign-in page with the code filled in.";
               var3.add(new SignInSupport3.Part1(3, 0, 1));
               var3.add(new SignInSupport3.Part1(2, 1, 2));
            } else if (var7 == uiSupport269.Part1.FAILED) {
               TheSignSupport var8 = var9 == null ? null : var9.v7();
               var4 = var8 == null ? TheSignSupport.FAILED.v1() : var8.v1();
               var5 = true;
               var3.add(new SignInSupport3.Part1(3, 0, 1));
               var3.add(new SignInSupport3.Part1(2, 3, 2));
            } else if (var7 == uiSupport269.Part1.WAITING && var9 != null) {
               var3.add(new SignInSupport3.Part1(4, 0, 1));
               var3.add(new SignInSupport3.Part1(2, 2, 1));
               var4 = v2(var9);
               var3.add(new SignInSupport3.Part1(3, 0, 2));
               var3.add(new SignInSupport3.Part1(2, 4, 3));
            } else {
               var4 = var7 == uiSupport269.Part1.SIGNING_IN ? "Signing in..." : "Asking Microsoft for a code...";
               var3.add(new SignInSupport3.Part1(3, 0, 1));
               var3.add(new SignInSupport3.Part1(2, 4, 2));
            }
         }

         this.v51 = var4;
         this.v50 = var5;
         this.v48 = var3.toArray(new SignInSupport3.Part1[0]);
         this.v8();
      }
   }

   private long v7() {
      uiSupport269.Part1 var1 = this.v5();
      long var2 = 0L;
      uiSupport269 var4 = this.v43;
      if (var4 != null && var1 == uiSupport269.Part1.WAITING) {
         var2 = v1(var4);
      }

      TheSignSupport var5 = this.v38 == 0 ? this.v42 : (var4 == null ? null : var4.v7());
      return this.v38 | (var1 == null ? 0L : var1.ordinal() + 1L) << 2 | (var5 == null ? 0L : var5.ordinal() + 1L) << 6 | var2 << 12;
   }

   private static long v1(uiSupport269 var0) {
      long var1 = var0.v5() - System.currentTimeMillis();
      return Math.max(1L, (var1 + 59999L) / 60000L);
   }

   private static String v2(uiSupport269 var0) {
      long var1 = v1(var0);
      return "Allow the sign-in on the page that opened. The code works for " + var1 + " more min.";
   }

   private void v8() {
      if (!this.v51.equals(this.v59)) {
         float var1 = 169.0F;
         List var2 = InternalSupport25.v1(this.v51, var1, var0 -> uiSupport169.v2("syky_sans", var0, 14.0F));
         this.v60 = var2;
         this.v59 = uiSupport169.v2("syky_sans", "A", 14.0F) > 0.0F ? this.v51 : null;
      }

      if (this.v44.length != this.v48.length) {
         this.v44 = new float[this.v48.length];
         this.v47 = new float[this.v48.length];
         this.v49 = new boolean[this.v48.length];
      }

      for (int var3 = 0; var3 < this.v48.length; var3++) {
         this.v49[var3] = var3 > 0 && this.v48[var3].v3() != this.v48[var3 - 1].v3();
         this.v47[var3] = this.v48[var3].v1() == 3 ? Math.max(1, this.v60.size()) * 18.0F + 8.0F : 41.0F;
      }

      this.v46 = uiSupport96.v1(this.v48.length, this.v49, this.v47, this.v44);
   }

   @Override
   public float v2() {
      return AddNoteSupport.v1();
   }

   @Override
   public float a_(float var1) {
      this.v6();
      return this.v46;
   }

   @Override
   public void v2(float var1) {
      this.v63 = var1;
   }

   private float v18() {
      return uiSupport96.v1(this.v9, this.v63);
   }

   private float v19() {
      return uiSupport96.v1(this.v63);
   }

   private float v1(int var1) {
      return this.v10 + SignInSupport.v4(this.v44[var1], this.v63);
   }

   private float v2(int var1) {
      return SignInSupport.v4(this.v47[var1], this.v63);
   }

   private int v6(float var1, float var2) {
      if (this.v1(var1, var2) && !(var1 < this.v18()) && !(var1 >= this.v18() + this.v19())) {
         for (int var3 = 0; var3 < this.v48.length; var3++) {
            float var4 = this.v1(var3);
            if (this.v48[var3].v1() != 3 && var2 >= var4 && var2 < var4 + this.v2(var3)) {
               return var3;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private void v1(int var1, boolean var2) {
      this.v38 = var1;
      this.v36[0].v1(var1 == 0);
      this.v36[1].v1(var1 == 1);
      if (var1 != 0) {
         this.v34.v3(false);
      }

      if (var2) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v3(int var1) {
      switch (var1) {
         case 0:
            this.v20();
            break;
         case 1:
         case 3:
            this.v21();
            break;
         case 2:
            this.v22();
            break;
         default:
            this.v25();
      }
   }

   private void v17() {
      if (this.v38 == 0) {
         this.v20();
      } else {
         uiSupport269.Part1 var1 = this.v5();
         if (var1 == uiSupport269.Part1.WAITING) {
            this.v22();
         } else if (var1 == null || var1 == uiSupport269.Part1.FAILED || var1 == uiSupport269.Part1.CANCELLED || var1 == uiSupport269.Part1.DONE) {
            this.v21();
         }
      }
   }

   private void v20() {
      MicrosoftSignSupport.Part3 var1 = this.v33.v2(this.v34.v2());
      if (!var1.v1()) {
         this.v42 = var1.v3();
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      } else {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
         this.v34.v2("");
         this.v34.v3(false);
         this.v42 = null;
         this.v31.v12();
      }
   }

   private void v21() {
      this.v43 = this.v33.v12();
      this.v37 = false;
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   private void v22() {
      uiSupport269 var1 = this.v43;
      if (var1 != null) {
         var1.v8();
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v24() {
      uiSupport269 var1 = this.v43;
      String var2 = var1 == null ? null : var1.v3();
      class_310 var3 = class_310.method_1551();
      if (var2 != null && var3 != null && var3.field_1774 != null) {
         var3.field_1774.method_1455(var2);
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v25() {
      uiSupport269 var1 = this.v43;
      if (var1 != null) {
         var1.v9();
      }

      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   private void v26() {
      uiSupport269 var1 = this.v43;
      if (var1 != null) {
         if (!this.v37 && var1.v1() == uiSupport269.Part1.WAITING) {
            this.v37 = true;
            var1.v8();
         }

         if (var1.v1() == uiSupport269.Part1.DONE) {
            this.v43 = null;
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
            this.v31.v12();
         }
      }
   }

   @Override
   public boolean v3() {
      return this.v34.v3();
   }

   @Override
   public void e_() {
      this.v34.v3(false);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v26();
      this.v6();
      if (this.v5() != null && !this.v27().v2()) {
         uiSupport33.v1();
      }

      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, this.v63);
      int var2 = var1.v2() ? this.v6(var1.v1, var1.v2) : -1;

      for (int var3 = 0; var3 < this.v48.length && var3 < this.v53.length; var3++) {
         boolean var4 = this.v48[var3].v1() == 1 && this.v34.v3();
         this.v53[var3].v2(var4 ? 1.0F : (var3 == var2 ? 0.7F : 0.0F));
         float var5 = SignInSupport.v1(this.v53[var3].v2());
         if (var5 > 0.002F && this.v48[var3].v1() != 3) {
            boolean var6 = this.v48[var3].v1() == 2 && this.v48[var3].v2() == 4;
            uiSupport96.v1(this.v18(), this.v1(var3), this.v19(), this.v2(var3), var5, var6, this.v63);
         }
      }

      float var7 = 18.0F * this.v63;

      for (int var8 = 0; var8 < this.v48.length; var8++) {
         SignInSupport3.Part1 var10 = this.v48[var8];
         switch (var10.v1()) {
            case 0:
               uiSupport96.v1(this.v36[var10.v2()], v1[var10.v2()], this.v18(), this.v1(var8), this.v2(var8), var8 == var2, this.v63);
               break;
            case 1:
               this.v1(var8, var1);
               break;
            case 2:
            default:
               this.v5(var10.v2(), var8);
               break;
            case 3:
               this.v4(var8);
               break;
            case 4:
               this.v1(var8, var2, var7);
         }
      }

      for (int var9 = 1; var9 < this.v48.length; var9++) {
         if (this.v48[var9].v3() != this.v48[var9 - 1].v3()) {
            uiSupport96.v1(this.v18(), this.v10 + SignInSupport.v4(this.v44[var9 - 1] + this.v47[var9 - 1] + 10.0F, this.v63), this.v19(), this.v63);
         }
      }
   }

   private uiSupport269 v27() {
      uiSupport269 var1 = this.v43;
      if (var1 == null) {
         throw new IllegalStateException("no sign-in");
      } else {
         return var1;
      }
   }

   private void v1(int var1, uiSupport35 var2) {
      float var3 = this.v18() + SignInSupport.v4(10.0F, this.v63);
      float var4 = this.v18() + this.v19() - SignInSupport.v4(10.0F, this.v63);
      float var5 = this.v1(var1);
      float var6 = this.v2(var1);
      this.v34.v1(var3, var5, Math.max(0.0F, var4 - var3), var6);
      float var7 = 18.0F * this.v63;
      this.v34.v1(var7, uiSupport169.v1(var6 / 2.0F, var7), 1.0F * this.v63);
      int var8 = this.v34.v3() ? uiSupport95.v4() : uiSupport95.v3();
      this.v34.v1(var8, uiSupport49.v2(uiSupport47.NAV_INK, 143), SignInSupport.v31(), uiSupport95.v4());
      this.v34.v1(var2);
   }

   private void v4(int var1) {
      float var2 = 14.0F * this.v63;
      float var3 = this.v18() + SignInSupport.v4(10.0F, this.v63);
      int var4 = this.v50 ? -218123180 : uiSupport95.v3();
      float var5 = this.v1(var1) + SignInSupport.v4(4.0F, this.v63);

      for (int var6 = 0; var6 < this.v60.size(); var6++) {
         float var7 = var5 + (var6 + 0.5F) * 18.0F * this.v63;
         uiSupport169.v1("syky_sans", this.v60.get(var6), var3, uiSupport169.v1(var7, var2), var2, var4);
      }
   }

   private void v1(int var1, int var2, float var3) {
      float var4 = this.v1(var1);
      float var5 = var4 + this.v2(var1) / 2.0F;
      uiSupport169.v1(
         "syky_sans_strong",
         "Code",
         this.v18() + SignInSupport.v4(10.0F, this.v63),
         uiSupport169.v1(var5, var3),
         var3,
         var1 == var2 ? uiSupport95.v4() : uiSupport95.v3()
      );
      uiSupport269 var6 = this.v43;
      String var7 = var6 == null ? null : var6.v3();
      if (var7 != null) {
         uiSupport169.v2(
            "syky_sans_strong", var7, this.v18() + this.v19() - SignInSupport.v4(10.0F, this.v63), uiSupport169.v1(var5, var3), var3, SignInSupport.v33()
         );
      }
   }

   private void v5(int var1, int var2) {
      float var3 = this.v1(var2);
      float var4 = this.v2(var2);
      float var5 = SignInSupport.v1(this.v53[Math.min(var2, this.v53.length - 1)].v2());
      float var7 = 22.0F;
      float var8 = 22.0F;
      class_2960 var6;
      String var9;
      switch (var1) {
         case 0:
            var6 = uiSupport143.v9;
            var7 = 15.0F;
            var8 = 15.0F;
            var9 = "Add account";
            break;
         case 1:
            var6 = uiSupport143.v30;
            var9 = "Sign in";
            break;
         case 2:
            var6 = uiSupport143.v13;
            var9 = "Open page";
            break;
         case 3:
            var6 = uiSupport143.v30;
            var9 = "Try again";
            break;
         default:
            var6 = uiSupport143.v32;
            var9 = "Cancel";
      }

      boolean var10 = var1 == 4;
      int var11 = uiSupport96.v2(var5, var10);
      int var12 = uiSupport96.v1(var5, var10);
      uiSupport96.v1(var6, var7, var8, this.v18(), var3, var4, var11, this.v63);
      uiSupport96.v1(var9, this.v18(), var3, var4, var12, this.v63);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else {
         int var4 = this.v6(var1, var2);
         if (var4 < 0 || this.v48[var4].v1() != 1) {
            this.v34.v3(false);
         }

         if (var3 == 0 && var4 >= 0) {
            SignInSupport3.Part1 var5 = this.v48[var4];
            switch (var5.v1()) {
               case 0:
                  this.v1(var5.v2(), true);
                  break;
               case 1:
               case 3:
               default:
                  this.v34.v3(true);
                  this.v34.v2(var1, var2, var3);
                  break;
               case 2:
                  this.v3(var5.v2());
                  break;
               case 4:
                  this.v24();
            }

            return true;
         } else {
            return true;
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v34.v3() && this.v34.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return this.v34.v3() && this.v34.v4(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      if (var1 == 257 || var1 == 335) {
         this.v17();
         return true;
      } else if (var1 == 258) {
         if (this.v38 == 0) {
            this.v34.v3(true);
            this.v34.v4();
         }

         return true;
      } else {
         return this.v34.v3() && this.v34.v2(var1, var2);
      }
   }

   @Override
   public boolean v3(int var1, int var2) {
      if (!this.v34.v3()) {
         return false;
      } else {
         return var1 > 32 && var1 < 127 ? this.v34.v3(var1, var2) : true;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      int var3 = this.v6(var1, var2);
      if (var3 < 0) {
         return hudSupport54.ARROW;
      } else {
         return this.v48[var3].v1() == 1 ? hudSupport54.IBEAM : hudSupport54.POINTER;
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      return this.v34.v3() ? this.v34.v31() : null;
   }

   public record Part1(int type, int index, int group) {
      public int v1() {
         return this.type;
      }

      public int v2() {
         return this.index;
      }

      public int v3() {
         return this.group;
      }
   }

   public interface Part2 {
      void v12();
   }
}
