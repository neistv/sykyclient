package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import java.util.List;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class AddNoteSupport extends UiNode {
   private static final float v1 = 20.0F;
   private static final float v2 = 4.0F;
   private static final float v3 = 8.0F;
   private static final float v4 = 16.0F;
   private static final float v5 = 0.35F;
   private static final float v6 = 26.0F;
   private static final float v7 = 17.0F;
   private static final float v8 = 14.0F;
   private static final float v13 = 21.0F;
   private static final float v14 = 40.0F;
   private final List<AddNoteSupport.Part2> v15;
   private final List<AddNoteSupport.Part1> v16;
   private final hudSupport57[] v18;
   private float v19;
   private float v17 = -1.0F;

   public AddNoteSupport(List<AddNoteSupport.Part2> var1, float var2) {
      this(var1, List.of(), var2);
   }

   public AddNoteSupport(List<AddNoteSupport.Part2> var1, List<AddNoteSupport.Part1> var2, float var3) {
      this.v15 = List.copyOf(var1);
      this.v16 = List.copyOf(var2);
      this.v19 = var3;
      this.v18 = new hudSupport57[this.v15.size()];

      for (int var4 = 0; var4 < this.v18.length; var4++) {
         this.v18[var4] = new hudSupport57(0.0F, 90.0F);
      }
   }

   public void v1(float var1) {
      this.v19 = var1;
   }

   public static float v1() {
      return 221.0F;
   }

   public float v2() {
      if (this.v17 < 0.0F) {
         float var1 = 0.0F;

         for (AddNoteSupport.Part2 var3 : this.v15) {
            float var4 = uiSupport169.v2("syky_sans_strong", var3.v5(), 18.0F);
            if (!var3.v12().isEmpty()) {
               var4 += 8.0F + uiSupport169.v2("syky_sans", var3.v12(), 18.0F);
            }

            var1 = Math.max(var1, 72.0F + var4 + 16.0F);
         }

         this.v17 = Math.max(221.0F, (float)Math.ceil(var1));
      }

      return this.v17;
   }

   private float v5() {
      return SignInSupport.v4(this.v2() - 32.0F, this.v19);
   }

   public float v3() {
      return this.v16.isEmpty() ? this.v6() + 16.0F : this.v6() + this.v16.size() * 26.0F + 17.0F;
   }

   private float v6() {
      float var1 = this.v1(this.v15.size() - 1) + 41.0F;
      return this.v16.isEmpty() ? var1 : var1 + 10.0F + 17.0F;
   }

   private float v1(int var1) {
      return 16.0F + var1 * 47.0F + this.v2(var1) * uiSupport96.v1();
   }

   private int v2(int var1) {
      int var2 = 0;

      for (int var3 = 1; var3 <= var1; var3++) {
         if (this.v15.get(var3).v9()) {
            var2++;
         }
      }

      return var2;
   }

   private float v3(int var1) {
      return this.v1(var1 - 1) + 41.0F + 10.0F;
   }

   private int v4(float var1, float var2) {
      int var3 = this.v5(var1, var2);
      return var3 >= 0 && this.v15.get(var3).v7() ? var3 : -1;
   }

   @Nullable
   public AddNoteSupport.Part2 v3(float var1, float var2) {
      int var3 = this.v5(var1, var2);
      if (var3 < 0) {
         return null;
      } else {
         AddNoteSupport.Part2 var4 = this.v15.get(var3);
         return !var4.v7() && var4.v8() != null ? var4 : null;
      }
   }

   public float v1(AddNoteSupport.Part2 var1) {
      return this.v10 + SignInSupport.v4(this.v1(this.v15.indexOf(var1)), this.v19);
   }

   public float v4() {
      return SignInSupport.v4(41.0F, this.v19);
   }

   private int v5(float var1, float var2) {
      if (!this.v1(var1, var2)) {
         return -1;
      } else {
         float var3 = uiSupport96.v1(this.v9, this.v19);
         float var4 = this.v5();
         if (!(var1 < var3) && !(var1 >= var3 + var4)) {
            for (int var5 = 0; var5 < this.v15.size(); var5++) {
               float var6 = this.v10 + SignInSupport.v4(this.v1(var5), this.v19);
               if (var2 >= var6 && var2 < var6 + SignInSupport.v4(41.0F, this.v19)) {
                  return var5;
               }
            }

            return -1;
         } else {
            return -1;
         }
      }
   }

   @Override
   public void v1(uiSupport35 var1) {
      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, this.v19);
      int var2 = this.v4(var1.v1, var1.v2);
      float var3 = uiSupport96.v1(this.v9, this.v19);
      float var4 = this.v5();
      float var5 = SignInSupport.v4(41.0F, this.v19);

      for (int var6 = 0; var6 < this.v15.size(); var6++) {
         AddNoteSupport.Part2 var7 = this.v15.get(var6);
         float var8 = this.v10 + SignInSupport.v4(this.v1(var6), this.v19);
         this.v18[var6].v2(var6 == var2 ? 1.0F : 0.0F);
         float var9 = SignInSupport.v1(this.v18[var6].v2());
         uiSupport96.v1(var3, var8, var4, var5, var9, var7.v6(), this.v19);
         float var10 = var7.v7() ? 1.0F : 0.35F;
         float var11 = SignInSupport.v4(var7.v2(), this.v19);
         float var12 = SignInSupport.v4(var7.v3(), this.v19);
         int var13 = uiSupport96.v2(var9, var7.v6());
         class_2960 var14 = var7.v11();
         if (var14 != null) {
            uiSupport169.v1(
               var14,
               var3 + SignInSupport.v4(10.0F, this.v19),
               var8 + uiSupport169.v1((var5 - var12) * 0.5F),
               var11,
               uiSupport155.v1(-1, var10),
               uiRecord7.v1(4.0F * this.v19)
            );
         } else {
            uiSupport169.v1(
               var7.v1(),
               var3 + SignInSupport.v4(10.0F, this.v19),
               var8 + uiSupport169.v1((var5 - var12) * 0.5F + var7.v4() * this.v19),
               var11,
               var12,
               uiSupport155.v1(var13, var10),
               uiRecord7.ZERO
            );
         }

         uiSupport96.v1(var7.v5(), var3, var8, var5, uiSupport155.v1(uiSupport96.v1(var9, var7.v6()), var10), this.v19);
         if (!var7.v12().isEmpty()) {
            float var15 = 18.0F * this.v19;
            uiSupport169.v1(
               "syky_sans",
               var7.v12(),
               uiSupport169.v1(var3 + SignInSupport.v4(40.0F, this.v19) + uiSupport169.v2("syky_sans_strong", var7.v5(), var15) + 8.0F * this.v19),
               uiSupport169.v1(var8 + var5 / 2.0F, var15),
               var15,
               uiSupport155.v1(uiSupport49.v2(uiSupport47.TEXT_DIM), var10)
            );
         }
      }

      for (int var16 = 1; var16 < this.v15.size(); var16++) {
         if (this.v15.get(var16).v9()) {
            uiSupport96.v1(var3, this.v10 + SignInSupport.v4(this.v3(var16), this.v19), var4, this.v19);
         }
      }

      if (!this.v16.isEmpty()) {
         uiSupport96.v1(var3, this.v10 + SignInSupport.v4(this.v3(this.v15.size()), this.v19), var4, this.v19);
         float var17 = 14.0F * this.v19;
         int var18 = uiSupport49.v2(uiSupport47.TEXT_DIM);

         for (int var19 = 0; var19 < this.v16.size(); var19++) {
            AddNoteSupport.Part1 var20 = this.v16.get(var19);
            float var21 = this.v10 + SignInSupport.v4(this.v6() + var19 * 26.0F, this.v19);
            float var22 = var21 + SignInSupport.v4(26.0F, this.v19) / 2.0F;
            float var23 = SignInSupport.v4(var20.v2(), this.v19);
            float var24 = SignInSupport.v4(var20.v3(), this.v19);
            uiSupport169.v1(
               var20.v1(), uiSupport169.v1(var3 + 21.0F * this.v19 - var23 / 2.0F), uiSupport169.v1(var22 - var24 / 2.0F), var23, var24, var18, uiRecord7.ZERO
            );
            uiSupport169.v1("syky_sans", var20.v4(), var3 + SignInSupport.v4(40.0F, this.v19), uiSupport169.v1(var22, var17), var17, var18);
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 == 0 && this.v1(var1, var2)) {
         int var4 = this.v4(var1, var2);
         if (var4 >= 0) {
            this.v15.get(var4).v10().run();
         }

         return true;
      } else {
         return this.v1(var1, var2);
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v4(var1, var2) >= 0 ? hudSupport54.POINTER : hudSupport54.ARROW;
   }

   public record Part1(class_2960 icon, float iconW, float iconH, String text) {
      public class_2960 v1() {
         return this.icon;
      }

      public float v2() {
         return this.iconW;
      }

      public float v3() {
         return this.iconH;
      }

      public String v4() {
         return this.text;
      }
   }

   public record Part2(
      class_2960 icon,
      float iconW,
      float iconH,
      float nudgeY,
      String label,
      boolean destructive,
      boolean enabled,
      @Nullable String why,
      boolean ruleAbove,
      Runnable action,
      @Nullable class_2960 skin,
      String detail
   ) {
      public Part2(
         class_2960 var1, float var2, float var3, float var4, String var5, boolean var6, boolean var7, @Nullable String var8, boolean var9, Runnable var10
      ) {
         this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, null, "");
      }

      public Part2(class_2960 var1, float var2, float var3, float var4, String var5, boolean var6, boolean var7, boolean var8, Runnable var9) {
         this(var1, var2, var3, var4, var5, var6, var7, null, var8, var9);
      }

      public static AddNoteSupport.Part2 v1(@Nullable class_2960 var0, String var1, String var2, Runnable var3) {
         return new AddNoteSupport.Part2(uiSupport143.v8, 20.0F, 20.0F, 0.0F, var1, false, true, null, false, var3, var0, var2);
      }

      public static AddNoteSupport.Part2 v1(boolean var0, @Nullable String var1, Runnable var2) {
         return var0
            ? new AddNoteSupport.Part2(uiSupport143.v21, 22.0F, 22.0F, 0.0F, "Unpin", false, var1 == null, var1, false, var2)
            : new AddNoteSupport.Part2(uiSupport143.v20, 22.0F, 22.0F, 0.0F, "Pin", false, var1 == null, var1, false, var2);
      }

      public static AddNoteSupport.Part2 v2(boolean var0, @Nullable String var1, Runnable var2) {
         return new AddNoteSupport.Part2(uiSupport143.v36, 22.0F, 22.0F, 0.0F, var0 ? "Edit note" : "Add note", false, var1 == null, var1, false, var2);
      }

      public static AddNoteSupport.Part2 v1(Runnable var0) {
         return new AddNoteSupport.Part2(uiSupport143.v38, 22.0F, 22.0F, 0.0F, "Remove note", false, true, false, var0);
      }

      public static AddNoteSupport.Part2 v3(boolean var0, @Nullable String var1, Runnable var2) {
         return new AddNoteSupport.Part2(
            var0 ? uiSupport143.v23 : uiSupport143.v33, 22.0F, 22.0F, 1.0F, var0 ? "Disable" : "Enable", false, var1 == null, var1, false, var2
         );
      }

      public static AddNoteSupport.Part2 v1(@Nullable String var0, Runnable var1) {
         return new AddNoteSupport.Part2(uiSupport143.v28, 22.0F, 22.0F, 0.0F, "Settings", false, var0 == null, var0, false, var1);
      }

      public static AddNoteSupport.Part2 v2(Runnable var0) {
         return new AddNoteSupport.Part2(uiSupport143.v31, 22.0F, 22.0F, 0.0F, "Suggest an idea", false, true, true, () -> {
            var0.run();
            DiscordPTBSupport.v1();
         });
      }

      public static AddNoteSupport.Part2 v1(@Nullable String var0, Runnable var1, Runnable var2) {
         return new AddNoteSupport.Part2(uiSupport143.v34, 22.0F, 22.0F, 0.0F, "Reset settings", true, var0 == null, var0, true, () -> {
            var1.run();
            var2.run();
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
         });
      }

      public class_2960 v1() {
         return this.icon;
      }

      public float v2() {
         return this.iconW;
      }

      public float v3() {
         return this.iconH;
      }

      public float v4() {
         return this.nudgeY;
      }

      public String v5() {
         return this.label;
      }

      public boolean v6() {
         return this.destructive;
      }

      public boolean v7() {
         return this.enabled;
      }

      @Nullable
      public String v8() {
         return this.why;
      }

      public boolean v9() {
         return this.ruleAbove;
      }

      public Runnable v10() {
         return this.action;
      }

      @Nullable
      public class_2960 v11() {
         return this.skin;
      }

      public String v12() {
         return this.detail;
      }
   }
}
