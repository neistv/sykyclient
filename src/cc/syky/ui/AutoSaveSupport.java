package cc.syky.ui;

import cc.syky.cloud.cloudSupport15;
import cc.syky.config.ConfigUi;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport58;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class AutoSaveSupport extends UiScreen implements uiSupport127, uiSupport90, uiSupport114.Part1, ShareSupport.Part1 {
   private final Consumer<uiSupport35> v1 = this::v6;
   private static final String v2 = "Nothing found";
   private static final float v3 = 41.0F;
   private static final float v4 = 90.0F;
   private static final float v5 = 468.0F;
   private static final int v6 = v5(75.0F);
   private final ConfigUi v7;
   private final BooleanSupplier v8;
   private final SearchSupport v13;
   private final uiSupport108 v14;
   private final uiSupport108 v15;
   private final uiSupport108 v16;
   private final uiSupport108[] v18;
   private final uiSupport98 v19 = new uiSupport98();
   private final hudSupport58 v17 = new hudSupport58();
   private final uiSupport125 v20 = new uiSupport125();
   private final List<uiSupport114> v21 = new ArrayList<>();
   private final Set<String> v22 = new LinkedHashSet<>();
   private float v24;
   private float v25;
   private final hudSupport57 v26;
   private final hudSupport57 v27;
   private final hudSupport57 v28;
   private final uiSupport91 v29 = new uiSupport91();
   @Nullable
   private AddNoteSupport v30;
   @Nullable
   private uiSupport114 v32;
   private float v23;
   private float v33;
   private String v31 = "";
   private long v34;
   private String v36 = "";
   private float v38;
   private float v42;
   private long v43;
   private long v37;
   private boolean v48;
   private float v40;
   @Nullable
   private uiSupport108 v44;
   private boolean v47;
   private float v49;
   private float v46;
   private float v51;
   private float v50;

   private static int v5(float var0) {
      float var1 = 468.0F - var0 - 16.0F;
      return Math.max(1, (int)((var1 + 6.0F) / 47.0F));
   }

   public AutoSaveSupport(ConfigUi var1, float var2, BooleanSupplier var3) {
      this.v7 = var1;
      this.v38 = var2;
      this.v8 = var3;
      this.v13 = new SearchSupport(var2, this::v3);
      this.v14 = new uiSupport108(uiSupport143.v9, 15.0F, 15.0F, "Create new", this::v42);
      this.v15 = new uiSupport108(uiSupport143.v10, 16.0F, 13.0F, "Open folder", var1::v8);
      this.v16 = new uiSupport108(uiSupport143.v11, 15.0F, 18.0F, "Auto save", this::v43);
      this.v18 = new uiSupport108[]{this.v14, this.v15, this.v16};
      this.v16.v2(var1.v4());
      this.v2(false);
      this.v24 = this.v20();
      this.v28 = new hudSupport57(this.v19() ? 1.0F : 0.0F, 90.0F);
      this.v27 = new hudSupport57(this.v20() <= 0.0F ? 1.0F : 0.0F, 90.0F);
      this.v26 = new hudSupport57(this.v21(), 90.0F);
   }

   private void v18() {
      this.v2(true);
   }

   private void v2(boolean var1) {
      this.v34 = this.v7.v2();
      this.v36 = this.v7.v3();
      List var2 = this.v7.v1();
      ArrayList var3 = new ArrayList(var2.size());
      this.v22.clear();

      for (uiRecord5 var5 : var2) {
         this.v22.add(var5.v1());
         uiSupport114 var6 = this.v2(var5.v1());
         if (var6 == null) {
            var6 = new uiSupport114(this, var5, this.v38, var1);
         }

         var6.v1(var5);
         var3.add(var6);
      }

      uiSupport104.v1(this.v21, var3, var1x -> !this.v22.contains(var1x.v1()), var0 -> {});
      this.v21.clear();
      this.v21.addAll(var3);
      if (!this.v19() && !this.v31.isEmpty()) {
         this.v31 = "";
         this.v13.v1("");
         this.v13.v3(false);
      }

      this.v17();
   }

   @Nullable
   private uiSupport114 v2(String var1) {
      for (uiSupport114 var3 : this.v21) {
         if (var3.v1().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   private boolean v19() {
      return this.v22.size() > v6;
   }

   private void v3(String var1) {
      this.v31 = uiSupport101.v1(var1);
      this.v17();
      this.v17.v3(0.0F);
      this.v20.v2();
   }

   private void v17() {
      for (uiSupport114 var2 : this.v21) {
         var2.v4().v1(this.v1(var2));
      }
   }

   private boolean v1(uiSupport114 var1) {
      return this.v22.contains(var1.v1()) && uiSupport101.v1(this.v31, var1.v2());
   }

   private float v20() {
      int var1 = 0;

      for (uiSupport114 var3 : this.v21) {
         if (this.v1(var3)) {
            var1++;
         }
      }

      return var1 * 47.0F;
   }

   private float v21() {
      float var1 = this.v20();
      float var2 = var1 <= 0.0F ? 41.0F : var1 - 6.0F;
      float var3 = 123.0F - 48.0F * (this.v19() ? 0.0F : 1.0F);
      float var4 = var3 + v5(var3) * 47.0F - 6.0F + 16.0F;
      return Math.min(var3 + var2 + 16.0F, var4);
   }

   private float v22() {
      return 48.0F * this.v28.v2();
   }

   private float v24() {
      return 42.0F + this.v22() + 16.0F;
   }

   private float v25() {
      return SignInSupport.v4(48.0F, this.v38) * this.v28.v2();
   }

   private float v26() {
      return this.v10 + SignInSupport.v4(42.0F, this.v38) + this.v25() + SignInSupport.v4(16.0F, this.v38);
   }

   @Override
   public float v2() {
      return 327.0F;
   }

   @Override
   public float v1() {
      return this.v17.v5();
   }

   @Override
   public void v1(float var1) {
      this.v17.v6(var1);
   }

   @Override
   public float v9() {
      return this.v24();
   }

   @Override
   public float a_(float var1) {
      return v6(this.v26.v2(), var1);
   }

   @Override
   public float v3(float var1) {
      return v6(this.v21(), var1);
   }

   private static float v6(float var0, float var1) {
      return Math.min(var0, var1 * 0.75F);
   }

   @Override
   public void v2(float var1) {
      this.v38 = var1;
      this.v13.v1(var1);

      for (uiSupport108 var5 : this.v18) {
         var5.v1(var1);
      }

      for (uiSupport114 var8 : this.v21) {
         var8.v1(var1);
      }

      AddNoteSupport var7 = this.v30;
      if (var7 != null) {
         var7.v1(var1);
      }
   }

   @Override
   public void v4(float var1) {
      this.v42 = var1;
   }

   @Override
   public void v10() {
      long var1 = System.nanoTime();
      float var3 = this.v43 == 0L ? 0.0F : (float)(var1 - this.v43) / 1000000.0F;
      this.v43 = var1;
      if (var3 > 100.0F) {
         var3 = 100.0F;
      }

      this.v17.v9(var3);
      if (!this.v17.v7()) {
         this.v20.v1();
      }

      long var4 = System.currentTimeMillis();
      if (this.v48) {
         this.v48 = false;
         this.v37 = var4;
         this.v18();
      } else if (var4 - this.v37 >= 1000L || var4 < this.v37) {
         this.v37 = var4;
         long var6 = this.v7.v2();
         if (var6 != this.v34 || var6 == 0L || !this.v7.v3().equals(this.v36)) {
            this.v18();
         }
      }

      this.v27();
      this.v27.v2(this.v20() <= 0.0F ? 1.0F : 0.0F);
      this.v25 = uiSupport103.v2(this.v27.v2());
      this.v28.v2(this.v19() ? 1.0F : 0.0F);
      this.v26.v2(this.v21());
      this.v40 = var3;
   }

   private void v27() {
      float var1 = 0.0F;

      for (int var2 = this.v21.size() - 1; var2 >= 0; var2--) {
         uiSupport114 var3 = this.v21.get(var2);
         float var4 = var3.v4().v3();
         if (var3.v4().v6() && !this.v22.contains(var3.v1())) {
            this.v21.remove(var2);
         } else {
            var1 += var4;
         }
      }

      this.v24 = var1 * 47.0F;
   }

   @Override
   public void v11() {
      this.v28();
      this.v23();
      this.v36();
      this.v34();
   }

   private void v28() {
      float var1 = this.v10 + SignInSupport.v4(10.0F, this.v38);
      float var2 = SignInSupport.v4(32.0F, this.v38);

      for (int var3 = 0; var3 < this.v18.length; var3++) {
         float var4 = this.v9 + SignInSupport.v4(uiSupport113.v1(this.v18.length - 1 - var3), this.v38);
         this.v18[var3].v1(var4, var1, var2, var2);
      }

      this.v16.v1(this.v7.v4());
      float var6 = this.v9 + SignInSupport.v4(16.0F, this.v38);
      float var7 = this.v10 + SignInSupport.v4(42.0F, this.v38) + this.v25();
      float var5 = SignInSupport.v4(38.0F, this.v38);
      this.v13.v1(var6, var7 - var5, this.v9 + SignInSupport.v4(311.0F, this.v38) - var6, var5);
   }

   private float v29() {
      return this.v26() + SignInSupport.v4(17.0F, this.v38);
   }

   private float v30() {
      return Math.max(0.0F, this.v10 + this.v12 - SignInSupport.v4(16.0F, this.v38) - this.v29());
   }

   private float v32() {
      return this.v24 <= 0.0F ? 41.0F : this.v24 - 6.0F;
   }

   private void v23() {
      this.v17.v8(this.v38);
      float var1 = this.v32() * this.v38 - this.v30();
      this.v17.v7(var1 > uiSupport169.v2() ? var1 : 0.0F);
      this.v17.v3(uiSupport169.v1(this.v17.v2()));
      float var2 = this.v9 + SignInSupport.v4(16.0F, this.v38);
      float var3 = this.v9 + SignInSupport.v4(311.0F, this.v38) - var2;
      float var4 = SignInSupport.v4(41.0F, this.v38);
      float var5 = SignInSupport.v4(47.0F, this.v38);
      float var6 = this.v29() - this.v17.v1();

      for (uiSupport114 var8 : this.v21) {
         float var9 = var8.v4().v4();
         var8.v1(var2, var6, var3, var9 * var4);
         var6 += var9 * var5;
      }
   }

   @Override
   public void v1(uiSupport35 var1) {
      float var2 = 24.0F * this.v38;
      uiRecord7 var3 = uiRecord7.v1(var2);
      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, this.v38);
      AddNoteSupport var5 = this.v30;
      uiSupport35 var6 = var5 != null && var5.v1(var1.v1, var1.v2) ? var1.v1() : var1;
      this.v1(var6, var3);
      float var7 = SignInSupport.v4(6.0F, this.v38);
      this.v20.v1(this.v17, this.v9, this.v29(), this.v11, Math.max(0.0F, this.v30() - var7), this.v32() * this.v38, this.v38, var6.v1, var6.v2);
      this.v33();

      for (uiSupport108 var11 : this.v18) {
         var11.v1(var6);
      }

      this.v2(var6);
      float var15 = SignInSupport.v2(this.v38);
      float var16 = this.v9 + SignInSupport.v4(16.0F, this.v38);
      uiSupport169.v1(
         var16, this.v26(), this.v9 + SignInSupport.v4(311.0F, this.v38) - var16, var15, SignInSupport.v1(SignInSupport.v94(), this.v38), uiRecord7.ZERO
      );
      if (this.v19.v2()) {
         uiSupport169.v3();

         try {
            this.v19.v3(var1, this.v19.v3());
         } finally {
            uiSupport169.v4();
         }
      }

      this.v3(var1);
   }

   private void v1(uiSupport35 var1, uiRecord7 var2) {
      float var3 = this.v26();
      uiSupport85.v1(
         var1,
         this.v1,
         this.v17.v3() > 0.0F,
         this.v9,
         this.v10,
         this.v11,
         this.v12,
         var2,
         var3,
         var3 + 17.0F * this.v38,
         9.0F * this.v38,
         this.v10 + this.v12 - 16.0F * this.v38,
         this.v29(),
         this.v30()
      );
   }

   private void v2(uiSupport35 var1) {
      float var2 = this.v22();
      if (!(var2 <= 0.01F)) {
         if (var2 >= 47.99F) {
            this.v13.v1(var1);
         } else {
            float var3 = this.v10 + SignInSupport.v4(42.0F, this.v38);
            float var4 = this.v25();
            if (!uiSupport169.v2(this.v9, var3, this.v11, var4)) {
               uiSupport169.v6(this.v9, var3, this.v11, var4);

               try {
                  this.v13.v1(var1);
               } finally {
                  uiSupport169.v17();
               }
            } else {
               try {
                  this.v13.v1(var1);
               } finally {
                  float var9 = Math.min(var4, 14.0F * this.v38);
                  float var10 = SignInSupport.v1(var2 / 48.0F);
                  float var11 = 1.0F - 0.55F * (1.0F - var10);
                  uiSupport169.v1(var11, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, var3 + var9, var3, 0.0F, this.v9, var3, this.v11, var4);
               }
            }
         }
      }
   }

   private void v3(uiSupport35 var1) {
      AddNoteSupport var2 = this.v30;
      if (var2 != null) {
         this.v29.v4();
         if (this.v29.v6()) {
            this.v30 = null;
            this.v32 = null;
         } else {
            uiSupport169.v3();

            try {
               boolean var3 = this.v29.v1(var2, this.v38);

               try {
                  var2.v1(var1);
               } finally {
                  if (var3) {
                     this.v29.v7();
                  }
               }
            } finally {
               uiSupport169.v4();
            }
         }
      }
   }

   private void v33() {
      float var1 = SignInSupport.v4(15.0F, this.v38);
      float var2 = SignInSupport.v4(18.0F, this.v38);
      float var3 = SignInSupport.v4(20.0F, this.v38);
      uiSupport169.v1(
         uiSupport143.v3,
         this.v9 + SignInSupport.v4(18.0F, this.v38) + uiSupport169.v1((var3 - var1) * 0.5F),
         this.v10 + SignInSupport.v4(16.0F, this.v38) + uiSupport169.v1((var3 - var2) * 0.5F),
         var1,
         var2,
         SignInSupport.v4(),
         uiRecord7.ZERO
      );
      float var4 = 18.0F * this.v38;
      uiSupport169.v1("syky_sans_strong", "Config", this.v9 + 50.0F * this.v38, uiSupport169.v1(this.v10 + 25.5F * this.v38, var4), var4, uiSupport113.v1());
   }

   private void v6(uiSupport35 var1) {
      if (this.v25 > 0.002F) {
         float var2 = 18.0F * this.v38;
         uiSupport169.v1(
            "syky_sans_strong",
            "Nothing found",
            this.v9 + 26.0F * this.v38,
            uiSupport169.v1(this.v29() + 41.0F * this.v38 / 2.0F, var2),
            var2,
            uiSupport155.v1(uiSupport113.v2(), this.v25)
         );
      }

      if (!this.v21.isEmpty()) {
         float var7 = this.v29();
         float var3 = var7 + this.v30();
         uiSupport35 var4 = var1.v2 >= var7 && var1.v2 < var3 ? var1 : var1.v1();

         for (uiSupport114 var6 : this.v21) {
            if (!(var6.v10 + var6.v12 < this.v10) && !(var6.v10 > this.v10 + this.v12)) {
               var6.v1(var4, var6.v4().v5());
            }
         }
      }
   }

   private void v34() {
      class_310 var1 = class_310.method_1551();
      float var2 = (float)uiSupport142.v1(var1);
      float var3 = (float)uiSupport142.v2(var1);
      this.v19.v3(this.v9, this.v10);
      uiSupport108 var4 = this.v30 == null && this.v8.getAsBoolean() ? uiSupport108.v1(this.v18, var2, var3) : null;
      if (var4 == null) {
         this.v19.v1();
      } else {
         class_1041 var5 = var1.method_22683();
         this.v19
            .v1(
               var4,
               var4.v1(),
               var4.v9,
               var4.v10,
               var4.v11,
               var4.v12,
               uiSupport98.Part1.ABOVE,
               200.0F,
               var2,
               var3,
               this.v40,
               this.v38,
               var5.method_4486(),
               var5.method_4502()
            );
      }
   }

   private void v36() {
      AddNoteSupport var1 = this.v30;
      if (var1 != null) {
         var1.v1(this.v38);
         var1.v1(
            this.v9 + SignInSupport.v4(this.v23, this.v38),
            this.v10 + SignInSupport.v4(this.v33, this.v38),
            SignInSupport.v4(var1.v2(), this.v38),
            SignInSupport.v4(var1.v3(), this.v38)
         );
      }
   }

   @Override
   public void v1(uiSupport114 var1, float var2, float var3) {
      this.v40();
      AddNoteSupport var4 = ShareSupport.v1(this, !var1.v3(), this.v38);
      uiSupport89.v1(var4, var2, var3, var4.v2(), var4.v3(), this.v38, this.v42);
      this.v23 = (var4.v9 - this.v9) / this.v38;
      this.v33 = (var4.v10 - this.v10) / this.v38;
      this.v30 = var4;
      this.v32 = var1;
      this.v29.v1(var4, var2, var3);
   }

   @Nullable
   private AddNoteSupport v38() {
      return this.v29.v5() ? null : this.v30;
   }

   @Override
   public void v4() {
      if (this.v30 != null) {
         this.v29.v2();
      }
   }

   @Override
   public boolean v12() {
      if (this.v38() == null) {
         return false;
      } else {
         this.v4();
         return true;
      }
   }

   @Nullable
   @Override
   public UiNode v13() {
      if (this.v30 != null) {
         return this.v30;
      } else {
         return this.v19.v2() ? this.v19 : null;
      }
   }

   @Override
   public void v5() {
      uiSupport114 var1 = this.v32;
      this.v4();
      if (var1 != null) {
         this.v13.v3(false);
         var1.v6();
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   @Override
   public void v6() {
      uiSupport114 var1 = this.v32;
      this.v4();
      if (var1 != null) {
         this.v7.v4(var1.v1());
      }
   }

   @Override
   public void v7() {
      uiSupport114 var1 = this.v32;
      this.v4();
      if (var1 != null) {
         if (this.v7.v2(var1.v1()) != null) {
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
         }

         this.v18();
      }
   }

   @Override
   public void v8() {
      uiSupport114 var1 = this.v32;
      this.v4();
      if (var1 != null) {
         this.v7.v3(var1.v1());
         this.v18();
      }
   }

   @Override
   public void v1(String var1) {
      this.v7.v1(var1);
      this.v18();
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   @Override
   public String v1(String var1, String var2) {
      boolean var3 = this.v7.v1(var1, var2);
      this.v48 = true;
      return var3 ? var2 : var1;
   }

   private void v42() {
      boolean var1 = this.v7.v7() != null;
      this.v18();
      if (var1) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v43() {
      this.v7.v1(!this.v7.v4());
      uiSupport148.v1(uiSupport146.v1(this.v7.v4()));
   }

   @Override
   public boolean v1(float var1, float var2) {
      return super.v1(var1, var2) || this.v30 != null && this.v30.v1(var1, var2);
   }

   private boolean v37() {
      return this.v22() >= 47.99F;
   }

   @Nullable
   private uiSupport114 v48() {
      for (uiSupport114 var2 : this.v21) {
         if (var2.v5()) {
            return var2;
         }
      }

      return null;
   }

   private void v40() {
      uiSupport114 var1 = this.v48();
      if (var1 != null) {
         var1.v7();
         this.v18();
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      AddNoteSupport var4 = this.v38();
      if (var4 != null) {
         if (var4.v1(var1, var2)) {
            return var4.v1(var1, var2, var3);
         } else {
            if (uiSupport90.v2(var3)) {
               this.v4();
            }

            return true;
         }
      } else if (this.v30 != null && this.v30.v1(var1, var2)) {
         return true;
      } else if (!super.v1(var1, var2)) {
         return false;
      } else {
         uiSupport114 var5 = this.v48();
         if (var5 != null && !var5.v1(var1, var2)) {
            this.v40();
            return true;
         } else if (var3 == 0 && this.v20.v1(this.v17, var1, var2)) {
            this.v13.v3(false);
            return true;
         } else if (this.v37() && this.v13.v1(var1, var2)) {
            return this.v13.v1(var1, var2, var3);
         } else {
            if (var2 >= this.v29() && var2 < this.v29() + this.v30()) {
               for (uiSupport114 var7 : this.v21) {
                  if (var7.v1(var1, var2)) {
                     this.v13.v3(false);
                     return var7.v1(var1, var2, var3);
                  }
               }
            }

            this.v13.v3(false);
            return true;
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, double var3, double var5) {
      if (this.v38() != null) {
         return true;
      } else if (super.v1(var1, var2) && !(this.v17.v3() <= 0.0F)) {
         this.v17.v2((float)(-var5) * 47.0F * this.v38);
         this.v20.v1();
         return true;
      } else {
         return true;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      if (this.v20.v1(this.v17, var2)) {
         return true;
      } else {
         uiSupport114 var6 = this.v48();
         return var6 != null ? var6.v1(var1, var2, var3, var4, var5) : this.v13.v1(var1, var2, var3, var4, var5);
      }
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      if (this.v20.v3()) {
         return true;
      } else {
         uiSupport114 var4 = this.v48();
         return var4 != null ? var4.v4(var1, var2, var3) : this.v13.v4(var1, var2, var3);
      }
   }

   @Override
   public boolean v2(int var1, int var2) {
      uiSupport114 var3 = this.v48();
      if (var3 != null) {
         if (var1 != 257 && var1 != 335) {
            return var3.v2(var1, var2);
         } else {
            var3.v7();
            this.v18();
            return true;
         }
      } else {
         return this.v13.v2(var1, var2);
      }
   }

   @Override
   public boolean v3(int var1, int var2) {
      uiSupport114 var3 = this.v48();
      return var3 != null ? var3.v3(var1, var2) : this.v13.v3(var1, var2);
   }

   @Override
   public boolean v3() {
      return this.v13.v1() || this.v48() != null;
   }

   @Override
   public void e_() {
      this.v13.v3(false);
      this.v40();
   }

   @Override
   public boolean v14() {
      if (!this.v19()) {
         return false;
      } else {
         this.v40();
         this.v13.v5();
         return true;
      }
   }

   @Override
   public boolean v15() {
      uiSupport114 var1 = this.v48();
      if (var1 != null) {
         var1.v8();
         return true;
      } else {
         return this.v12();
      }
   }

   @Override
   public boolean v3(float var1, float var2) {
      AddNoteSupport var3 = this.v38();
      if (var3 != null && var3.v1(var1, var2)) {
         return false;
      } else {
         return super.v1(var1, var2) && !(var2 >= this.v26()) ? !this.v37() || !this.v13.v1(var1, var2) || !this.v13.v1() : false;
      }
   }

   @Override
   public void v4(float var1, float var2) {
      this.v49 = var1;
      this.v46 = var2;
      this.v51 = 0.0F;
      this.v50 = 0.0F;
      boolean var3 = this.v37() && this.v13.v1(var1, var2);
      if (!var3) {
         this.v13.v3(false);
      }

      if (this.v48() != null) {
         this.v40();
         this.v44 = null;
         this.v47 = false;
      } else {
         this.v47 = var3;
         this.v44 = var3 ? null : uiSupport108.v1(this.v18, var1, var2);
      }
   }

   @Override
   public boolean v5(float var1, float var2) {
      if (this.v44 == null && !this.v47) {
         return false;
      } else {
         this.v51 += var1;
         this.v50 += var2;
         if (cloudSupport15.v1(this.v51, this.v50, this.v38)) {
            this.v44 = null;
            this.v47 = false;
         }

         return false;
      }
   }

   @Override
   public void v16() {
      uiSupport108 var1 = this.v44;
      this.v44 = null;
      if (var1 != null) {
         var1.v2();
      }

      if (this.v47) {
         this.v47 = false;
         this.v13.v3(this.v49 + this.v51, this.v46 + this.v50);
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      AddNoteSupport var3 = this.v38();
      if (var3 != null) {
         return var3.v1(var1, var2) ? var3.v2(var1, var2) : hudSupport54.ARROW;
      } else if (!super.v1(var1, var2)) {
         return hudSupport54.ARROW;
      } else {
         for (uiSupport108 var7 : this.v18) {
            if (var7.v1(var1, var2)) {
               return var7.v2(var1, var2);
            }
         }

         if (this.v20.v1(var1, var2)) {
            return hudSupport54.POINTER;
         } else if (this.v37() && this.v13.v1(var1, var2)) {
            return this.v13.v2(var1, var2);
         } else {
            if (var2 >= this.v29() && var2 < this.v29() + this.v30()) {
               for (uiSupport114 var9 : this.v21) {
                  if (var9.v1(var1, var2)) {
                     return var9.v2(var1, var2);
                  }
               }
            }

            return hudSupport54.ARROW;
         }
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      if (this.v20.v4()) {
         return hudSupport54.POINTER;
      } else {
         uiSupport114 var1 = this.v48();
         return var1 == null ? this.v13.v31() : var1.v31();
      }
   }
}
