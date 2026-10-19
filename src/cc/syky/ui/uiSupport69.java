package cc.syky.ui;

import cc.syky.cloud.cloudSupport20;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.NotASupport;
import cc.syky.config.Setting;
import cc.syky.config.SettingOwner;
import cc.syky.config.SettingRegistry;
import cc.syky.config.configRecord;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport58;
import cc.syky.hud.hudSupport75;
import cc.syky.module.visual.visualSupport6;
import cc.syky.render.renderSupport47;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

public final class uiSupport69 extends UiScreen implements uiSupport127, uiSupport90, uiSupport86 {
   private final Consumer<uiSupport35> v1 = this::v2;
   private static final float v2 = 54.0F;
   private final String v3;
   private final String v4;
   private final AllSupport v5;
   private final SettingRegistry v6;
   private final configRecord v7;
   private final cloudSupport20 v8;
   @Nullable
   private final Setting<?> v13;
   private final int v14;
   private final boolean v15;
   private final uiSupport61[] v16;
   private final Setting<?>[] v18;
   private final hudSupport57[] v19;
   private final float[] v17;
   private float v20;
   private float v21;
   private final float[] v22;
   private final boolean[] v24;
   private final float v25;
   private final float v26;
   private final float v27;
   private final hudSupport58 v28 = new hudSupport58();
   private final uiSupport125 v29 = new uiSupport125();
   private final uiSupport88<UiNode> v30 = new uiSupport88<>();
   private boolean v32 = true;
   @Nullable
   private Setting<?> v23;
   private boolean v33;
   private float v31;
   private boolean v34;
   private boolean v36;
   private float v38;
   private float v42;
   private float v43;
   private float v37;
   private long v48;
   private static final List<uiSupport69.Part1> v40 = new ArrayList<>();

   public uiSupport69(String var1, SettingRegistry var2, configRecord var3, float var4) {
      this(var1, var1, var2, var3, null, 0, true, var4);
   }

   public static uiSupport69 v1(String var0, SettingRegistry var1, configRecord var2, float var3) {
      return new uiSupport69(var0, var0, var1, var2, null, 0, false, var3);
   }

   private uiSupport69(String var1, String var2, SettingRegistry var3, configRecord var4, @Nullable Setting<?> var5, int var6, boolean var7, float var8) {
      this.v3 = var1;
      this.v4 = var2;
      this.v15 = var7;
      this.v5 = new AllSupport(var2, var4.v11(), this::v1);
      this.v6 = var3;
      this.v7 = var4;
      this.v8 = new cloudSupport20(var4, var8);
      this.v13 = var5;
      this.v14 = var6;
      this.v37 = var8;
      Map var9 = var3.colorMap();
      Map var10 = var3.conditionMap();
      List var11 = this.v1(var5, var9, var10);
      this.v18 = var11.toArray(new Setting[0]);
      this.v16 = new uiSupport61[var11.size()];
      this.v19 = new hudSupport57[var11.size()];
      this.v17 = new float[var11.size()];
      this.v22 = new float[var11.size()];
      this.v24 = new boolean[var11.size()];

      for (int var12 = 0; var12 < this.v16.length; var12++) {
         this.v16[var12] = this.v3(this.v18[var12], var9, var10);
         this.v16[var12].v1(var8);
         this.v19[var12] = new hudSupport57(this.v3(var12) ? 1.0F : 0.0F, 80.0F);
      }

      this.v24();
      this.v25 = this.v21();
      this.v26 = this.v25 - 32.0F;
      this.v27 = this.v19();

      for (uiSupport61 var15 : this.v16) {
         var15.v4(this.v27);
      }
   }

   private uiSupport69 v1(Setting<?> var1) {
      return new uiSupport69(
         this.v3 + "/" + var1.getName(), this.v4, this.v6, this.v7.v1(uiSupport135.v3(this.v4, var1.getName()), var1), var1, this.v14 + 1, this.v15, this.v37
      );
   }

   private float v1(uiSupport61 var1) {
      float var2 = var1.v7();
      return !(var2 <= 0.0F) && !Float.isNaN(this.v27) ? Math.max(var2, this.v26 - 10.0F - var1.v14() - this.v27 - var1.v8()) : 136.0F;
   }

   private float v19() {
      float var1 = this.v26 / 2.0F;
      return Math.max(var1, this.v17());
   }

   private float v17() {
      float var1 = 0.0F;

      for (uiSupport61 var5 : this.v16) {
         var1 = Math.max(var1, var5.v15());
      }

      return 10.0F + var1 + 16.0F;
   }

   private float v20() {
      float var1 = 0.0F;

      for (uiSupport61 var5 : this.v16) {
         float var6 = var5.v7() > 0.0F ? var5.v8() + var5.v7() + var5.v14() : var5.v2();
         var1 = Math.max(var1, var6);
      }

      return var1 <= 0.0F ? 0.0F : 10.0F + var1;
   }

   private float v21() {
      float var1 = 0.0F;
      float var2 = 0.0F;

      for (uiSupport61 var6 : this.v16) {
         var1 = Math.max(var1, var6.v15());
         var2 = Math.max(var2, var6.v2());
      }

      float var7 = 10.0F + var1 + 16.0F + var2 + 10.0F + 32.0F;
      float var8 = Math.max(var7, this.v8.v1());
      return (float)Math.ceil(Math.max(240.0F, Math.min(420.0F, Math.max(var8, this.v22()))));
   }

   private float v22() {
      return 2.0F * Math.max(this.v17(), this.v20()) + 32.0F;
   }

   @Override
   public void v2(float var1) {
      this.v37 = var1;
      this.v28.v8(var1);
      this.v8.v1(var1);

      for (uiSupport61 var5 : this.v16) {
         var5.v1(var1);
      }

      if (this.v30.v1() instanceof uiSupport86 var6) {
         var6.v2(var1);
      }
   }

   @Override
   public void v1(boolean var1) {
      this.v32 = var1;
   }

   @Override
   public void v4(float var1) {
      this.v43 = var1;
   }

   @Override
   public boolean v3() {
      if (this.v8.v2()) {
         return true;
      } else {
         for (uiSupport61 var4 : this.v16) {
            if (var4.v5()) {
               return true;
            }
         }

         UiNode var5 = this.v25();
         if (var5 instanceof uiSupport84 var8) {
            return var8.v3();
         } else {
            return var5 instanceof KeySupport var7 ? var7.v3() : var5 instanceof uiSupport69 var6 && var6.v3();
         }
      }
   }

   @Override
   public void e_() {
      this.v8.v3();

      for (uiSupport61 var4 : this.v16) {
         var4.v6();
      }

      UiNode var5 = this.v30.v1();
      if (var5 instanceof uiSupport84 var6) {
         var6.v4();
      } else if (var5 instanceof KeySupport var7) {
         var7.e_();
      } else if (var5 instanceof uiSupport69 var8) {
         var8.e_();
      }
   }

   @Override
   public boolean v15() {
      UiNode var1 = this.v25();
      if (var1 instanceof uiSupport69 var2 && var2.v15()) {
         return true;
      } else if (var1 instanceof KeySupport var6 && var6.v3()) {
         var6.e_();
         return true;
      } else {
         for (uiSupport61 var5 : this.v16) {
            if (var5.v4()) {
               return true;
            }
         }

         return this.v8.v4();
      }
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      UiNode var4 = this.v25();
      if (var4 instanceof uiSupport69 var5 && var5.v2(var1, var2, var3)) {
         return true;
      } else {
         return var4 instanceof KeySupport var6 && var6.v2(var1, var2, var3) ? true : this.v4(var3) || this.v8.v1(var3);
      }
   }

   @Override
   public boolean v3(float var1, float var2) {
      UiNode var3 = this.v25();
      return var3 != null && var3.v1(var1, var2)
         ? var3 instanceof UiScreen var4 && var4.v3(var1, var2)
         : super.v1(var1, var2) && this.v8.v1(var1, var2, this.v9, this.v10, this.v11);
   }

   @Override
   public void v4(float var1, float var2) {
      if (this.v25() != null) {
         this.v8.v1(var1, var2);
      } else {
         this.v8.v1(var1, var2, this.v9, this.v10);
      }

      if (this.v25() instanceof UiScreen var3 && var3.v3(var1, var2)) {
         this.v8.v6();
         var3.v4(var1, var2);
         if (!var3.v5(0.0F, 0.0F)) {
            this.v30.v1(var3, var1, var2);
         }
      }
   }

   @Override
   public boolean v5(float var1, float var2) {
      this.v8.v2(var1, var2);
      if (this.v25() instanceof UiScreen var3 && var3.v5(var1, var2)) {
         return true;
      } else if (this.v30.v7() && !(this.v37 <= 0.0F) && this.v30.v2() != null) {
         if (this.v30.v1(var1, var2, this.v9, this.v10, this.v37)) {
            this.v33 = false;
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public void v16() {
      switch (this.v8.v7()) {
         case OPEN_BIND:
            this.v6(this.v8.v8(), this.v8.v9());
            break;
         case DISMISS_CHILD:
            this.v4();
         case NONE:
      }

      if (this.v30.v1() instanceof UiScreen var1) {
         var1.v16();
      }

      this.v30.v4(this.v37);
   }

   @Override
   public float v2() {
      return this.v25;
   }

   @Override
   public float v1() {
      return this.v28.v5();
   }

   @Override
   public void v1(float var1) {
      this.v28.v6(var1);
   }

   @Override
   public void v10() {
      this.v24();
      if (this.v30.v1() instanceof uiSupport69 var1) {
         var1.v10();
      }
   }

   private void v24() {
      float var1 = 0.0F;
      float var2 = 0.0F;

      for (int var3 = 0; var3 < this.v16.length; var3++) {
         boolean var4 = this.v3(var3);
         this.v19[var3].v2(var4 ? 1.0F : 0.0F);
         float var5 = this.v19[var3].v2();
         this.v17[var3] = var5;
         var1 += var5 * 47.0F;
         var2 += var4 ? 47.0F : 0.0F;
      }

      this.v20 = Math.max(0.0F, var1 + 26.0F);
      this.v21 = Math.max(0.0F, var2 + 26.0F);
   }

   public float v5() {
      return this.v20;
   }

   private static float v5(float var0) {
      float var1 = (var0 - 0.25F) / 0.6F;
      return var1 <= 0.0F ? 0.0F : (var1 >= 1.0F ? 1.0F : var1);
   }

   @Override
   public float a_(float var1) {
      return 52.0F + Math.min(this.v5(), v6(var1));
   }

   @Override
   public float v3(float var1) {
      return 52.0F + Math.min(this.v21, v6(var1));
   }

   private static float v6(float var0) {
      float var1 = var0 * 0.75F - 52.0F;
      int var2 = Math.max(1, Math.round(var1 / 47.0F));
      return var2 * 47.0F + 26.0F;
   }

   @Override
   public void v4() {
      if (this.v30.v1() != null) {
         this.e_();
         this.v30.v8();
         this.v29();
      }
   }

   @Override
   public boolean v12() {
      if (!this.v7()) {
         return false;
      } else {
         this.v6();
         return true;
      }
   }

   public void v6() {
      if (this.v25() instanceof uiSupport69 var1 && var1.v7()) {
         var1.v6();
      } else {
         this.v4();
      }
   }

   @Nullable
   private UiNode v25() {
      return this.v30.v2();
   }

   @Override
   public void v11() {
      this.v30();
      if (this.v30.v1() instanceof UiScreen var1) {
         var1.v11();
      }
   }

   @Nullable
   @Override
   public UiNode v13() {
      return this.v30.v5() ? null : this.v30.v1();
   }

   public boolean v7() {
      return this.v25() != null;
   }

   @Nullable
   private uiSupport69.Part2 v1(Setting<?> var1, float var2) {
      if (var1 instanceof EnumSetting var8) {
         return this.v1(var8, var2);
      } else if (var1 instanceof visualSupport6 var7) {
         return this.v1(var7, var2);
      } else if (var1 instanceof uiSupport149 var6) {
         return this.v1(new uiSupport73(var6, this.v37), var2);
      } else if (var1 instanceof uiSupport150 var5) {
         return this.v1(new uiSupport77(var5, this.v37), var2);
      } else if (var1 instanceof ColorSetting var3) {
         uiSupport84 var4 = new uiSupport84(var3, this.v37);
         return new uiSupport69.Part2(var4, var4.v1(), var4.v2(), true);
      } else {
         return null;
      }
   }

   private <E extends Enum<E>> uiSupport69.Part2 v1(EnumSetting<E> var1, float var2) {
      return this.v1(new uiSupport78<>((E[])var1.getValues(), var1::getValue, var1::setValue, this, this.v37), var2);
   }

   private <E extends Enum<E>> uiSupport69.Part2 v1(visualSupport6<E> var1, float var2) {
      return this.v1(new uiSupport76(var1, this.v37), var2);
   }

   private uiSupport69.Part2 v1(uiSupport80 var1, float var2) {
      return new uiSupport69.Part2(var1, var1.v3(var2), var1.v3(), false, var1.v4());
   }

   private boolean v2(Setting<?> var1) {
      return this.v25() instanceof uiSupport69 && this.v23 == var1;
   }

   public void v1(Setting<?> var1, float var2, float var3) {
      uiSupport69 var4 = this.v1(var1);
      uiSupport69.Part2 var5 = new uiSupport69.Part2(var4, var4.v2(), var4.a_(624.0F), true);
      uiSupport89.v1(var4, var2, var3, var5.v2(), var5.v3(), this.v37, this.v43);
      this.v1(var5, var2, var3);
      this.v23 = var1;
      this.v2(true);
      this.v4(var1);
   }

   private void v6(float var1, float var2) {
      hudSupport75 var3 = this.v7.v11();
      String var4 = this.v7.v1();
      if (var3 != null && var4 != null) {
         KeySupport var5 = new KeySupport(var4, var3, this.v37, this::v4);
         uiSupport69.Part2 var6 = new uiSupport69.Part2(var5, var5.v2(), var5.a_(624.0F), true);
         uiSupport89.v1(var5, var1, var2, var6.v2(), var6.v3(), this.v37, this.v43);
         this.v1(var6, var1, var2);
         this.v23 = null;
         this.v33 = false;
         this.v29();
      }
   }

   private void v1(Setting<?> var1, float var2, float var3, float var4, float var5, float var6) {
      uiSupport69.Part2 var7 = this.v1(var1, this.v37 > 0.0F ? var3 / this.v37 : 136.0F);
      if (var7 != null) {
         if (var7.v4()) {
            uiSupport89.v1(var7.v1(), var5, var6, var7.v2(), var7.v3(), this.v37, this.v43);
         } else {
            uiSupport89.v1(var7.v1(), this.v9, this.v11, var2 + var4 / 2.0F, var7.v5(), 14.0F, var7.v2(), var7.v3(), this.v37, this.v43);
         }

         this.v1(var7, var5, var7.v4() ? var6 : var2 + var4 / 2.0F);
         this.v23 = var1;
         this.v2(var7.v4());
         this.v4(var1);
      }
   }

   private void v2(boolean var1) {
      int var2 = var1 ? -1 : this.v3(this.v23);
      this.v33 = var2 >= 0;
      this.v31 = this.v33 ? this.v30.v4() - this.v1(var2) : 0.0F;
   }

   private float v1(int var1) {
      return (this.v16[var1].v10 + this.v16[var1].v12 * 0.5F - this.v10) / this.v37;
   }

   private void v26() {
      int var1 = this.v3(this.v23);
      if (var1 >= 0) {
         this.v30.v1(this.v1(var1) + this.v31);
      }
   }

   private void v27() {
      if (this.v15) {
         uiSupport69.Part1 var1 = this.v28();
         if (var1 != null && this.v30.v2() != null) {
            float var2 = this.v30.v1() instanceof uiSupport127 var3 ? var3.v1() : 0.0F;
            if (var1.v3() != this.v30.v3() || var1.v4() != this.v30.v4() || var1.v5() != this.v30.v5() || var1.v6() != var2) {
               v40.set(this.v14, new uiSupport69.Part1(var1.v1(), var1.v2(), this.v30.v3(), this.v30.v4(), this.v30.v5(), var2));
            }
         }
      }
   }

   private int v3(@Nullable Setting<?> var1) {
      for (int var2 = 0; var2 < this.v18.length; var2++) {
         if (this.v18[var2] == var1) {
            return var2;
         }
      }

      if (var1 instanceof SettingOwner var4 && var4.v1() != null) {
         for (int var3 = 0; var3 < this.v18.length; var3++) {
            if (this.v18[var3] == var4.v1()) {
               return var3;
            }
         }
      }

      return -1;
   }

   private void v1(uiSupport69.Part2 var1, float var2, float var3) {
      this.v38 = var1.v2();
      this.v42 = var1.v3();
      this.v30.v1(var1.v1(), this.v9, this.v10, this.v37, var2, var3);
   }

   public static void v8() {
      v40.clear();
   }

   @Nullable
   public static String v1(String var0) {
      if (v40.isEmpty()) {
         return null;
      } else {
         uiSupport69.Part1 var1 = v40.get(0);
         return var0.equals(var1.v1()) ? var1.v2() : null;
      }
   }

   @Nullable
   private uiSupport69.Part1 v28() {
      if (this.v14 >= v40.size()) {
         return null;
      } else {
         uiSupport69.Part1 var1 = v40.get(this.v14);
         return this.v3.equals(var1.v1()) ? var1 : null;
      }
   }

   private void v29() {
      if (this.v15) {
         while (v40.size() > this.v14) {
            v40.remove(v40.size() - 1);
         }
      }
   }

   private void v4(Setting<?> var1) {
      if (this.v15) {
         this.v29();
         v40.add(new uiSupport69.Part1(this.v3, var1.getName(), this.v30.v3(), this.v30.v4(), false, 0.0F));
      }
   }

   public void v18() {
      uiSupport69.Part1 var1 = this.v28();
      if (var1 == null) {
         this.v29();
      } else {
         Setting var2 = this.v6.byName(var1.v2());
         int var3 = this.v3(var2);
         uiSupport69.Part2 var4 = this.v1(var2, var3);
         if (var4 == null) {
            this.v29();
         } else {
            this.v38 = var4.v2();
            this.v42 = var4.v3();
            this.v30.v1(var4.v1(), var1.v3(), var1.v4(), var1.v5());
            this.v23 = var2;
            if (var4.v1() instanceof uiSupport127 var5) {
               var5.v1(var1.v6());
            }

            this.v36 = var4.v4();
            this.v34 = !this.v30.v5();
            if (var4.v1() instanceof uiSupport69 var7) {
               var7.v18();
            }
         }
      }
   }

   @Nullable
   private uiSupport69.Part2 v1(@Nullable Setting<?> var1, int var2) {
      if (var1 != null && this.v6.isVisibleFor(var1, this.v13)) {
         if (var2 >= 0 && this.v16[var2].v11() > 0.0F) {
            uiSupport69 var3 = this.v1(var1);
            return new uiSupport69.Part2(var3, var3.v2(), var3.a_(624.0F), true);
         } else {
            return this.v1(var1, var2 < 0 ? 136.0F : this.v1(this.v16[var2]));
         }
      } else {
         return null;
      }
   }

   private void v30() {
      float var1 = SignInSupport.v4(47.0F, this.v37);
      float var2 = this.v5() * this.v37;
      float var3 = var2 - this.v23();
      this.v28.v7(var3 > uiSupport169.v2() ? var3 : 0.0F);
      this.v28.v3(uiSupport169.v1(this.v28.v2()));
      float var4 = this.v9 + SignInSupport.v4(16.0F, this.v37);
      float var5 = this.v9 + this.v11 - SignInSupport.v4(16.0F, this.v37) - var4;
      float var6 = this.v32() + SignInSupport.v4(13.0F, this.v37) - this.v28.v1();

      for (int var7 = 0; var7 < this.v16.length; var7++) {
         float var8 = this.v17[var7];
         this.v16[var7].v1(var4, var6, var5, var8 * var1);
         this.v22[var7] = v5(var8);
         var6 += var8 * var1;
      }

      if (this.v30.v1() != null) {
         if (this.v34) {
            this.v2(this.v36);
            this.v34 = false;
         }

         if (this.v33) {
            this.v26();
         }

         this.v30.v1(this.v9, this.v10, this.v37);
         this.v33();
         this.v30.v1(this.v37, this.v32);
         this.v27();
      }
   }

   private float v32() {
      return this.v10 + SignInSupport.v4(52.0F, this.v37);
   }

   private float v23() {
      return Math.max(0.0F, this.v10 + this.v12 - this.v32());
   }

   private boolean v7(float var1) {
      return var1 >= this.v32() && var1 < this.v32() + this.v23();
   }

   private boolean v3(int var1) {
      return this.v6.isVisibleFor(this.v18[var1], this.v13);
   }

   private void v2(uiSupport35 var1) {
      float var2 = this.v10 + this.v12;
      float var3 = 47.0F * this.v37;
      Arrays.fill(this.v24, false);

      for (int var4 = 0; var4 < this.v16.length; var4++) {
         if (this.v1(var4, var2) && this.v22[var4] >= 1.0F) {
            this.v1(var4, var1, 1.0F, var3);
         }
      }

      for (int var11 = 0; var11 < this.v16.length; var11++) {
         if (!this.v24[var11] && this.v1(var11, var2) && !(this.v22[var11] <= 0.0F)) {
            float var5 = this.v22[var11];
            if (!uiSupport169.v5()) {
               this.v1(var11, var1, var5, var3);
            } else {
               try {
                  int var6 = uiSupport103.v5(var5);

                  for (int var7 = var11; var7 < this.v16.length; var7++) {
                     if (!this.v24[var7] && this.v1(var7, var2) && !(this.v22[var7] <= 0.0F) && uiSupport103.v5(this.v22[var7]) == var6) {
                        this.v1(var7, var1, 1.0F, var3);
                     }
                  }
               } finally {
                  uiSupport169.v2(var5);
               }
            }
         }
      }
   }

   private void v1(uiSupport35 var1, uiRecord7 var2) {
      float var3 = this.v32();
      float var4 = SignInSupport.v4(16.0F, this.v37);
      uiSupport85.v1(
         var1,
         this.v1,
         this.v28.v3() > 0.0F,
         this.v9,
         this.v10,
         this.v11,
         this.v12,
         var2,
         var3,
         var3 + var4,
         9.0F * this.v37,
         this.v10 + this.v12 - var4,
         var3,
         this.v23()
      );
   }

   private boolean v1(int var1, float var2) {
      uiSupport61 var3 = this.v16[var1];
      return var3.v12 > 0.01F && var3.v10 + var3.v12 >= this.v32() && var3.v10 < var2;
   }

   private void v1(int var1, uiSupport35 var2, float var3, float var4) {
      uiSupport61 var5 = this.v16[var1];
      var5.v3(var3);
      boolean var6 = var5.v12 < var4 - 0.5F;
      if (var6) {
         uiSupport169.v6(var5.v9, var5.v10, var5.v11, var5.v12);
      }

      try {
         var5.v1(var2);
      } finally {
         if (var6) {
            uiSupport169.v17();
         }
      }

      this.v24[var1] = true;
   }

   private void v33() {
      UiNode var1 = renderSupport47.v1(this.v30.v1());
      if (var1 instanceof uiSupport69 var2) {
         this.v38 = var2.v2();
         this.v42 = var2.a_(624.0F);
         var2.v4(this.v43);
      }

      float var4 = this.v38 * this.v37;
      float var3 = this.v42 * this.v37;
      this.v30.v1(var4, var3, true, this.v43, this.v9, this.v10, this.v37);
      var1.v1(this.v30.v2(this.v9) + this.v30.v5(this.v37), this.v30.v3(this.v10) + this.v30.v6(this.v37), var4, var3);
   }

   @Override
   public void v1(uiSupport35 var1) {
      long var2 = System.nanoTime();
      float var4 = this.v48 == 0L ? 0.0F : (float)(var2 - this.v48) / 1000000.0F;
      this.v48 = var2;
      if (var4 > 100.0F) {
         var4 = 100.0F;
      }

      this.v28.v9(var4);
      if (!this.v28.v7()) {
         this.v29.v1();
      }

      if (this.v23 != null && this.v30.v2() != null && !this.v6.isVisibleFor(this.v23, this.v13)) {
         this.v4();
      }

      this.v30();
      float var5 = 24.0F * this.v37;
      uiRecord7 var6 = uiRecord7.v1(var5);
      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, this.v37);
      UiNode var7 = this.v30.v1();
      uiSupport35 var8 = var7 != null && var7.v1(var1.v1, var1.v2) ? var1.v1() : var1;
      this.v8.v1(var8, this.v9, this.v10, this.v11);
      this.v1(this.v7(var8.v2) ? var8 : var8.v1(), var6);
      float var9 = 6.0F * this.v37;
      this.v29.v1(this.v28, this.v9, this.v32(), this.v11, Math.max(0.0F, this.v23() - var9), this.v5() * this.v37, this.v37, var8.v1, var8.v2);
      if (this.v30.v5()) {
         if (this.v30.v1() != null && this.v30.v9()) {
            this.v34();
         }
      } else if (!this.v30.v1(var1, this.v37)) {
         this.v34();
      }
   }

   private void v34() {
      this.v30.v10();
      this.v23 = null;
      this.v33 = false;
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4, float var5) {
      UiNode var6 = this.v30.v1();
      if (var6 != null) {
         if (this.v30.v5()) {
            this.v30.v11();
            if (!this.v30.v1(var1, this.v37, var2, var3, var4, var5)) {
               this.v34();
               return;
            }
         }

         if (var6 instanceof uiSupport69 var7) {
            var7.v1(var1, var2, var3, var4, var5);
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2) {
      UiNode var3 = this.v30.v1();
      return super.v1(var1, var2) || var3 != null && var3.v1(var1, var2);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      UiNode var4 = this.v25();
      if (var4 != null) {
         if (var4.v1(var1, var2)) {
            return var4.v1(var1, var2, var3);
         } else {
            int var8 = var3 == 1 ? this.v7(var1, var2) : -1;
            if (var8 >= 0) {
               this.v4();
               this.v2(this.v18[var8], var1, var2);
               return true;
            } else {
               if (uiSupport90.v2(var3)) {
                  this.v4();
               }

               return true;
            }
         }
      } else {
         UiNode var5 = this.v30.v1();
         if (var5 != null && var5.v1(var1, var2)) {
            return true;
         } else if (!super.v1(var1, var2)) {
            return false;
         } else if (this.v4(var3)) {
            return true;
         } else if (var3 == 0 && this.v29.v1(this.v28, var1, var2)) {
            this.v2(null);
            return true;
         } else {
            int var6 = var3 == 1 ? this.v7(var1, var2) : -1;
            if (var6 >= 0) {
               this.v2(null);
               this.v2(this.v18[var6], var1, var2);
               return true;
            } else {
               for (int var7 = 0; var7 < this.v16.length && this.v7(var2); var7++) {
                  if (this.v3(var7) && this.v16[var7].v1(var1, var2) && this.v16[var7].v1(var1, var2, var3)) {
                     this.v2(this.v16[var7]);
                     return true;
                  }
               }

               this.v2(null);
               return true;
            }
         }
      }
   }

   private int v7(float var1, float var2) {
      if (super.v1(var1, var2) && this.v7(var2)) {
         for (int var3 = 0; var3 < this.v16.length; var3++) {
            if (this.v3(var3) && this.v16[var3].v1(var1, var2)) {
               return var3;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private void v2(Setting<?> var1, float var2, float var3) {
      NotASupport.Part1 var4 = new NotASupport.Part1() {
         @Override
         public void v1(Setting<?> var1, float var2x, float var3x) {
            uiSupport69.this.v1(var1, var2x, var3x);
         }

         @Override
         public void v1() {
            uiSupport69.this.v4();
         }
      };
      uiSupport93 var5 = new uiSupport93(NotASupport.v1(var1, this.v6, var4, var2, var3, this.v37));
      var5.v2(this.v37);
      uiSupport69.Part2 var6 = new uiSupport69.Part2(var5, var5.v2(), var5.a_(624.0F), true);
      uiSupport89.v1(var5, var2, var3, var6.v2(), var6.v3(), this.v37, this.v43);
      this.v1(var6, var2, var3);
      this.v23 = null;
      this.v33 = false;
      this.v29();
   }

   private boolean v4(int var1) {
      for (uiSupport61 var5 : this.v16) {
         if (var5.v1(var1)) {
            return true;
         }
      }

      return false;
   }

   private void v2(@Nullable uiSupport61 var1) {
      for (uiSupport61 var5 : this.v16) {
         if (var5 != var1) {
            var5.v6();
         }
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      UiNode var3 = this.v25();
      if (var3 != null) {
         return var3.v1(var1, var2) ? var3.v2(var1, var2) : hudSupport54.ARROW;
      } else {
         UiNode var4 = this.v30.v1();
         if (var4 != null && var4.v1(var1, var2)) {
            return hudSupport54.ARROW;
         } else if (!super.v1(var1, var2)) {
            return hudSupport54.ARROW;
         } else {
            hudSupport54 var5 = this.v8.v2(var1, var2, this.v9, this.v10, this.v11);
            if (var5 != hudSupport54.ARROW) {
               return var5;
            } else if (this.v29.v1(var1, var2)) {
               return hudSupport54.POINTER;
            } else {
               for (int var6 = 0; var6 < this.v16.length && this.v7(var2); var6++) {
                  if (this.v3(var6) && this.v16[var6].v1(var1, var2)) {
                     hudSupport54 var7 = this.v16[var6].v2(var1, var2);
                     if (var7 != hudSupport54.ARROW) {
                        return var7;
                     }
                  }
               }

               return hudSupport54.ARROW;
            }
         }
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      if (this.v29.v4()) {
         return hudSupport54.POINTER;
      } else {
         UiNode var1 = this.v25();
         if (var1 != null) {
            return var1.v31();
         } else {
            for (uiSupport61 var5 : this.v16) {
               hudSupport54 var6 = var5.v31();
               if (var6 != null) {
                  return var6;
               }
            }

            return null;
         }
      }
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      if (this.v29.v3()) {
         return true;
      } else {
         UiNode var4 = this.v25();
         if (var4 != null) {
            return var4.v4(var1, var2, var3);
         } else {
            for (uiSupport61 var8 : this.v16) {
               if (var8.v4(var1, var2, var3)) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      if (this.v29.v1(this.v28, var2)) {
         return true;
      } else {
         UiNode var6 = this.v25();
         if (var6 != null) {
            return var6.v1(var1, var2, var3, var4, var5);
         } else {
            for (uiSupport61 var10 : this.v16) {
               if (var10.v1(var1, var2, var3, var4, var5)) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @Override
   public void v11(float var1, float var2) {
      UiNode var3 = this.v25();
      if (var3 != null) {
         var3.v11(var1, var2);
      }

      for (int var4 = 0; var4 < this.v16.length && this.v7(var2); var4++) {
         if (this.v3(var4)) {
            this.v16[var4].v11(var1, var2);
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, double var3, double var5) {
      UiNode var7 = this.v25();
      if (var7 != null) {
         if (var7.v1(var1, var2)) {
            var7.v1(var1, var2, var3, var5);
         }

         return true;
      } else if (!super.v1(var1, var2) || this.v28.v3() <= 0.0F) {
         return true;
      } else if (var2 < this.v32()) {
         return true;
      } else {
         this.v28.v2((float)(-var5) * 54.0F * this.v37);
         this.v29.v1();
         return true;
      }
   }

   @Override
   public boolean v2(int var1, int var2) {
      UiNode var3 = this.v25();
      if (var3 != null) {
         return var3.v2(var1, var2);
      } else if (this.v8.v1(var1, var2)) {
         return true;
      } else {
         for (uiSupport61 var7 : this.v16) {
            if (var7.v5() && var7.v2(var1, var2)) {
               return true;
            }
         }

         return false;
      }
   }

   @Override
   public boolean v3(int var1, int var2) {
      UiNode var3 = this.v25();
      if (var3 != null) {
         return var3.v3(var1, var2);
      } else if (this.v8.v5()) {
         return true;
      } else {
         for (uiSupport61 var7 : this.v16) {
            if (var7.v5() && var7.v3(var1, var2)) {
               return true;
            }
         }

         return false;
      }
   }

   private List<Setting<?>> v1(@Nullable Setting<?> var1, Map<Setting<?>, ColorSetting> var2, Map<BooleanSetting, Setting<?>> var3) {
      Collection var4 = this.v6.all();
      ArrayList var5 = new ArrayList(var4.size());
      Set var6 = this.v6.hiddenSet();

      for (Setting var8 : var4) {
         if (this.v6.getVisibleParent(var8) == var1
            && !var6.contains(var8)
            && !(var8 instanceof ColorSetting var9 && var2.get(var9.getCondition()) == var9)
            && !var3.containsValue(var8)) {
            var5.add(var8);
         }
      }

      return var5;
   }

   private boolean v2(Setting<?> var1, Map<Setting<?>, ColorSetting> var2, Map<BooleanSetting, Setting<?>> var3) {
      return !this.v1(var1, var2, var3).isEmpty();
   }

   private uiSupport61 v3(Setting<?> var1, Map<Setting<?>, ColorSetting> var2, Map<BooleanSetting, Setting<?>> var3) {
      uiSupport61 var4 = this.v5.v1(var1, var2, var3);
      uiSupport62 var5 = uiSupport62.v1(var1.getName());
      if (var5 != null) {
         var4.v1(var5);
      }

      if (this.v6.isHidden(var1) && this.v2(var1, var2, var3)) {
         var4.v1((var2x, var3x, var4x, var5x, var6, var7) -> this.v1(var1, var6, var7), () -> this.v2(var1));
      }

      return var4;
   }

   public record Part1(String owner, String setting, float anchorX, float anchorY, boolean detached, float scroll) {
      public String v1() {
         return this.owner;
      }

      public String v2() {
         return this.setting;
      }

      public float v3() {
         return this.anchorX;
      }

      public float v4() {
         return this.anchorY;
      }

      public boolean v5() {
         return this.detached;
      }

      public float v6() {
         return this.scroll;
      }
   }

   public record Part2(UiNode popup, float designW, float designH, boolean atCursor, float firstRowInset) {
      public Part2(UiNode var1, float var2, float var3, boolean var4) {
         this(var1, var2, var3, var4, 0.0F);
      }

      public UiNode v1() {
         return this.popup;
      }

      public float v2() {
         return this.designW;
      }

      public float v3() {
         return this.designH;
      }

      public boolean v4() {
         return this.atCursor;
      }

      public float v5() {
         return this.firstRowInset;
      }
   }
}
