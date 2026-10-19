package cc.syky.ui;

import cc.syky.EndSupport;
import cc.syky.LANRecord;
import cc.syky.sykyRecord4;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.internal.InternalSupport7;
import cc.syky.internal.InternalSupport9;
import cc.syky.render.font.MsdfFont;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class TheEndSupport extends UiScreen {
   private static final String v1 = "Type name...";
   private static final String v2 = "Create waypoint";
   private static final String v3 = "Change coords";
   private static final String v4 = "Start selecting";
   private static final String v5 = "Stop selecting";
   private static final String v6 = "Save selections";
   private static final String v7 = "Discard";
   private static final String[] v8 = new String[]{"Classic waypoint", "Block overlay"};
   private static final int v13 = 0;
   private static final int v14 = 1;
   private static final String[] v15 = new String[]{"X", "Y", "Z"};
   private static final String[] v16 = new String[]{"minecraft:overworld", "minecraft:the_nether", "minecraft:the_end"};
   private static final int v18 = 9;
   private static final int v19 = 16;
   private static final int v17 = 0;
   private static final int v20 = 1;
   private static final int v21 = 2;
   private static final int v22 = 3;
   private static final int v24 = 0;
   private static final int v25 = 1;
   private static final int v26 = 2;
   private static final int v27 = 3;
   private static final int v28 = 4;
   private final InternalSupport7 v29;
   private TheEndSupport.Part3 v30;
   private final TheEndSupport.Part2 v32;
   @Nullable
   private final LANRecord v23;
   @Nullable
   private final String v33;
   private final int[] v31;
   private final String v34;
   private final int[] v36;
   private final boolean v38;
   private final MsdfFont[] v42;
   private final int v43;
   private final String[] v37;
   private final uiSupport109[] v48;
   private int v40;
   private int v44;
   private final uiSupport109[] v47 = new uiSupport109[]{new uiSupport109(true), new uiSupport109(false)};
   private TheEndSupport.Part1[] v49 = new TheEndSupport.Part1[0];
   private int v46 = -1;
   private final hudSupport57[] v51 = new hudSupport57[16];
   private float v50;

   private TheEndSupport(
      InternalSupport7 var1, TheEndSupport.Part3 var2, TheEndSupport.Part2 var3, @Nullable sykyRecord4 var4, int var5, int var6, int var7, float var8
   ) {
      this.v29 = var1;
      this.v30 = var2;
      this.v32 = var3;
      this.v23 = var1.v7();
      this.v33 = var4 == null ? null : var4.v4();
      this.v31 = new int[]{var5, var6, var7};
      this.v36 = new int[]{var5, var6, var7};
      this.v34 = var1.v10();
      this.v38 = uiSupport223.v4;
      this.v50 = var8;
      boolean var9 = var3 == TheEndSupport.Part2.CREATE;
      this.v43 = var9 ? 1 : 0;
      this.v42 = new MsdfFont[this.v43 + 3];
      InternalSupport9 var10 = var1.v16();
      if (var9) {
         MsdfFont var11 = new MsdfFont("syky_sans_strong", 32, var1x -> {
            if (var10.v1()) {
               var10.v3(var1x);
            }
         });
         var11.v1("Type name...");
         if (var10.v1()) {
            var11.v2(var10.v4());
         }

         this.v42[0] = var11;
      }

      for (int var15 = 0; var15 < 3; var15++) {
         MsdfFont var12 = new MsdfFont("syky_sans_strong", 9, var0 -> {});
         if (this.v38) {
            var12.v1("Protected");
         } else {
            var12.v2(Integer.toString(this.v36[var15]));
         }

         this.v42[this.v43 + var15] = var12;
      }

      for (MsdfFont var14 : this.v42) {
         var14.v1(1060L);
      }

      this.v37 = var9 ? v2(this.v34) : new String[0];
      int var17 = 0;

      for (int var19 = 0; var19 < this.v37.length; var19++) {
         if (this.v37[var19].equals(this.v34)) {
            var17 = var19;
         }
      }

      this.v40 = var17;
      this.v48 = new uiSupport109[this.v37.length];

      for (int var20 = 0; var20 < this.v48.length; var20++) {
         this.v48[var20] = new uiSupport109(var20 == this.v40);
      }

      for (int var21 = 0; var21 < this.v51.length; var21++) {
         this.v51[var21] = new hudSupport57(0.0F, 90.0F);
      }

      if (var9 && var10.v1()) {
         this.v2(1, false);
      }

      this.v6();
   }

   public static TheEndSupport v1(InternalSupport7 var0, TheEndSupport.Part3 var1, int var2, int var3, int var4, float var5) {
      return new TheEndSupport(var0, var1, TheEndSupport.Part2.CREATE, null, var2, var3, var4, var5);
   }

   public static TheEndSupport v1(InternalSupport7 var0, TheEndSupport.Part3 var1, sykyRecord4 var2, float var3) {
      return new TheEndSupport(var0, var1, TheEndSupport.Part2.MOVE, var2, var2.v6(), var2.v7(), var2.v8(), var3);
   }

   private static String[] v2(String var0) {
      ArrayList var1 = new ArrayList<>(List.of(v16));
      if (!var0.isEmpty() && !var1.contains(var0)) {
         var1.add(var0);
      }

      return var1.toArray(new String[0]);
   }

   private static String v3(String var0) {
      return "minecraft:the_end".equals(var0) ? "The End" : EndSupport.v2(var0);
   }

   private int v5() {
      if (this.v32 == TheEndSupport.Part2.MOVE) {
         return 0;
      } else {
         InternalSupport9 var1 = this.v29.v16();
         if (!var1.v1()) {
            return this.v44 == 0 ? 1 : 2;
         } else {
            return var1.v5().v2() ? 3 : 4;
         }
      }
   }

   private void v6() {
      int var1 = this.v5();
      if (var1 != this.v46) {
         this.v46 = var1;
         ArrayList var2 = new ArrayList();
         int var3 = 0;
         switch (var1) {
            case 0:
               for (int var10 = 0; var10 < 3; var10++) {
                  var2.add(new TheEndSupport.Part1(1, var10, var3));
               }

               var2.add(new TheEndSupport.Part1(3, 1, var3 + 1));
               break;
            case 1:
               var2.add(new TheEndSupport.Part1(0, 0, var3));
               var2.add(new TheEndSupport.Part1(0, 1, var3));
               var2.add(new TheEndSupport.Part1(1, 0, ++var3));
               var3++;

               for (int var4 = 0; var4 < this.v37.length; var4++) {
                  var2.add(new TheEndSupport.Part1(2, var4, var3));
               }

               var3++;

               for (int var9 = this.v43; var9 < this.v42.length; var9++) {
                  var2.add(new TheEndSupport.Part1(1, var9, var3));
               }

               var2.add(new TheEndSupport.Part1(3, 0, var3 + 1));
               break;
            case 2:
               var2.add(new TheEndSupport.Part1(0, 0, var3));
               var2.add(new TheEndSupport.Part1(0, 1, var3));
               var2.add(new TheEndSupport.Part1(1, 0, ++var3));
               var2.add(new TheEndSupport.Part1(3, 2, var3 + 1));
               break;
            default:
               var2.add(new TheEndSupport.Part1(1, 0, var3));
               var2.add(new TheEndSupport.Part1(3, 2, var3 + 1));
               if (var1 == 4) {
                  var2.add(new TheEndSupport.Part1(3, 3, var3 + 1));
               }

               var2.add(new TheEndSupport.Part1(3, 4, var3 + 2));
         }

         this.v49 = var2.toArray(new TheEndSupport.Part1[0]);
         int var11 = this.v20();
         if (var11 >= 0 && this.v1(var11) < 0) {
            this.v1(this.v32 == TheEndSupport.Part2.CREATE ? 0 : -1, false);
         }
      }
   }

   private int v1(int var1) {
      for (int var2 = 0; var2 < this.v49.length; var2++) {
         if (this.v49[var2].v1() == 1 && this.v49[var2].v2() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private int v2(int var1) {
      int var2 = 0;

      for (int var3 = 1; var3 <= var1 && var3 < this.v49.length; var3++) {
         if (this.v49[var3].v3() != this.v49[var3 - 1].v3()) {
            var2++;
         }
      }

      return var2;
   }

   private float v3(int var1) {
      return 16.0F + var1 * 47.0F + this.v2(var1) * v7();
   }

   private static float v7() {
      return 15.0F;
   }

   @Override
   public float v2() {
      return AddNoteSupport.v1();
   }

   @Override
   public float a_(float var1) {
      this.v6();
      return this.v3(this.v49.length - 1) + 41.0F + 16.0F;
   }

   @Override
   public void v2(float var1) {
      this.v50 = var1;
   }

   private float v8() {
      return uiSupport96.v1(this.v9, this.v50);
   }

   private float v18() {
      return uiSupport96.v1(this.v50);
   }

   private float v4(int var1) {
      return this.v10 + SignInSupport.v4(this.v3(var1), this.v50);
   }

   private float v19() {
      return SignInSupport.v4(41.0F, this.v50);
   }

   private int v6(float var1, float var2) {
      if (this.v1(var1, var2) && !(var1 < this.v8()) && !(var1 >= this.v8() + this.v18())) {
         for (int var3 = 0; var3 < this.v49.length; var3++) {
            float var4 = this.v4(var3);
            if (var2 >= var4 && var2 < var4 + this.v19()) {
               return var3;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private void v5(int var1, int var2) {
      MsdfFont var3 = this.v42[var1];
      float var4 = this.v8() + SignInSupport.v4(var1 < this.v43 ? 10.0F : 40.0F, this.v50);
      float var5 = this.v8() + this.v18() - SignInSupport.v4(10.0F, this.v50);
      float var6 = this.v4(var2);
      float var7 = this.v19();
      var3.v1(var4, var6, Math.max(0.0F, var5 - var4), var7);
      float var8 = 18.0F * this.v50;
      var3.v1(var8, uiSupport169.v1(var7 / 2.0F, var8), 1.0F * this.v50);
      int var9 = !var3.v3() && var1 < this.v43 ? uiSupport95.v3() : uiSupport95.v4();
      var3.v1(var9, v17(), SignInSupport.v31(), uiSupport95.v4());
   }

   private static int v17() {
      return uiSupport49.v2(uiSupport47.NAV_INK, 143);
   }

   private int v20() {
      for (int var1 = 0; var1 < this.v42.length; var1++) {
         if (this.v42[var1].v3()) {
            return var1;
         }
      }

      return -1;
   }

   private void v1(int var1, boolean var2) {
      for (int var3 = 0; var3 < this.v42.length; var3++) {
         this.v42[var3].v3(var3 == var1);
      }

      if (var2 && var1 >= 0) {
         this.v42[var1].v4();
      }
   }

   @Override
   public boolean v3() {
      return this.v20() >= 0;
   }

   @Override
   public void e_() {
      this.v1(-1, false);
   }

   public void v1(TheEndSupport.Part3 var1) {
      this.v30 = var1;
   }

   public boolean v1() {
      return !Objects.equals(this.v23, this.v29.v7()) || !this.v34.equals(this.v29.v10());
   }

   private void v2(int var1, boolean var2) {
      this.v44 = var1;
      this.v47[0].v1(var1 == 0);
      this.v47[1].v1(var1 == 1);
      if (var2) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v5(int var1) {
      if (var1 == this.v40) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      } else {
         this.v40 = var1;

         for (int var2 = 0; var2 < this.v48.length; var2++) {
            this.v48[var2].v1(var2 == this.v40);
         }

         String var6 = this.v37[this.v40];
         int[] var3 = new int[]{EndSupport.v1(this.v31[0], this.v34, var6), this.v31[1], EndSupport.v1(this.v31[2], this.v34, var6)};

         for (int var4 = 0; var4 < 3; var4++) {
            MsdfFont var5 = this.v42[this.v43 + var4];
            if (!this.v38 && var5.v2().trim().equals(Integer.toString(this.v36[var4]))) {
               var5.v2(Integer.toString(var3[var4]));
            }

            this.v36[var4] = var3[var4];
         }

         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v6(int var1) {
      switch (var1) {
         case 0:
         case 1:
            this.v26();
            break;
         case 2:
            this.v22();
            break;
         case 3:
            this.v24();
            break;
         default:
            this.v25();
      }
   }

   private void v21() {
      switch (this.v5()) {
         case 0:
         case 1:
            this.v26();
            break;
         case 2:
         case 3:
         default:
            this.v22();
            break;
         case 4:
            this.v24();
      }
   }

   private void v22() {
      InternalSupport9 var1 = this.v29.v16();
      String var2 = this.v42[0].v2();
      if (var1.v2()) {
         var1.v2(false);
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      } else {
         if (var1.v1()) {
            var1.v3(var2);
            var1.v2(true);
         } else {
            var1.v1(var2);
         }

         if (var1.v2()) {
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
            this.v1(-1, false);
            this.v30.v13();
         }
      }
   }

   private void v24() {
      InternalSupport9 var1 = this.v29.v16();
      var1.v3(this.v42[0].v2());
      if (var1.v10() != null) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }

      this.v30.v12();
   }

   private void v25() {
      this.v29.v16().v11();
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
      this.v30.v12();
   }

   private void v26() {
      int var1 = this.v7(0);
      int var2 = this.v7(1);
      int var3 = this.v7(2);
      boolean var4 = false;
      String var5 = this.v33;
      if (this.v32 == TheEndSupport.Part2.CREATE) {
         String var6 = this.v37.length == 0 ? this.v34 : this.v37[this.v40];
         var4 = this.v29.v1(this.v42[0].v2(), var1, var2, var3, var6) != null;
      } else if (var5 != null && this.v29.v1(var5) != null) {
         this.v29.v2(var5, var1, var2, var3);
         var4 = true;
      }

      if (var4) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }

      this.v30.v12();
   }

   private int v7(int var1) {
      Integer var2 = v1(this.v42[this.v43 + var1].v2());
      return var2 == null ? this.v36[var1] : sykyRecord4.v1(var2);
   }

   @Nullable
   public static Integer v1(String var0) {
      String var1 = var0.trim();
      int var2 = var1.startsWith("-") ? 1 : 0;
      if (var1.length() != var2 && var1.length() - var2 <= 9) {
         for (int var3 = var2; var3 < var1.length(); var3++) {
            char var4 = var1.charAt(var3);
            if (var4 < '0' || var4 > '9') {
               return null;
            }
         }

         return Integer.parseInt(var1);
      } else {
         return null;
      }
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v6();
      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, this.v50);
      int var2 = var1.v2() ? this.v6(var1.v1, var1.v2) : -1;
      int var3 = this.v20();
      int var4 = var3 < 0 ? -1 : this.v1(var3);

      for (int var5 = 0; var5 < this.v49.length && var5 < this.v51.length; var5++) {
         float var6 = var5 == var4 ? 1.0F : (var5 == var2 ? 0.7F : 0.0F);
         this.v51[var5].v2(var6);
         float var7 = SignInSupport.v1(this.v51[var5].v2());
         if (var7 > 0.002F) {
            boolean var8 = this.v49[var5].v1() == 3 && this.v49[var5].v2() == 4;
            uiSupport96.v1(this.v8(), this.v4(var5), this.v18(), this.v19(), var7, var8, this.v50);
         }
      }

      float var9 = 18.0F * this.v50;

      for (int var10 = 0; var10 < this.v49.length; var10++) {
         TheEndSupport.Part1 var12 = this.v49[var10];
         switch (var12.v1()) {
            case 0:
               uiSupport96.v1(this.v47[var12.v2()], v8[var12.v2()], this.v8(), this.v4(var10), this.v19(), var10 == var2, this.v50);
               break;
            case 1:
               this.v1(var12.v2(), var10, var1, var9);
               break;
            case 2:
               uiSupport96.v1(this.v48[var12.v2()], v3(this.v37[var12.v2()]), this.v8(), this.v4(var10), this.v19(), var10 == var2, this.v50);
               break;
            default:
               this.v6(var12.v2(), var10);
         }
      }

      for (int var11 = 1; var11 < this.v49.length; var11++) {
         if (this.v49[var11].v3() != this.v49[var11 - 1].v3()) {
            uiSupport96.v1(this.v8(), this.v10 + SignInSupport.v4(this.v3(var11 - 1) + 41.0F + 10.0F, this.v50), this.v18(), this.v50);
         }
      }
   }

   private void v1(int var1, int var2, uiSupport35 var3, float var4) {
      if (var1 >= this.v43) {
         uiSupport169.v1(
            "syky_sans_strong",
            v15[var1 - this.v43],
            this.v8() + SignInSupport.v4(10.0F, this.v50),
            uiSupport169.v1(this.v4(var2) + this.v19() / 2.0F, var4),
            var4,
            SignInSupport.v13()
         );
      }

      this.v5(var1, var2);
      this.v42[var1].v1(var3);
   }

   private void v6(int var1, int var2) {
      float var3 = this.v4(var2);
      float var4 = this.v19();
      float var5 = SignInSupport.v1(this.v51[Math.min(var2, this.v51.length - 1)].v2());
      InternalSupport9 var6 = this.v29.v16();
      float var8 = 22.0F;
      float var9 = 22.0F;
      class_2960 var7;
      String var10;
      switch (var1) {
         case 0:
            var7 = uiSupport143.v16;
            var10 = "Create waypoint";
            break;
         case 1:
            var7 = uiSupport143.v27;
            var10 = "Change coords";
            break;
         case 2:
            var7 = uiSupport143.v26;
            var10 = var6.v2() ? "Stop selecting" : "Start selecting";
            break;
         case 3:
            var7 = uiSupport143.v4;
            var8 = 17.0F;
            var9 = 17.0F;
            var10 = "Save selections";
            break;
         default:
            var7 = uiSupport143.v15;
            var8 = 18.0F;
            var9 = 20.0F;
            var10 = "Discard";
      }

      boolean var11 = var1 == 4;
      boolean var12 = var1 == 2 && var6.v2();
      int var13 = uiSupport96.v2(var5, var11);
      int var14 = uiSupport96.v1(var5, var11);
      if (var12) {
         var13 = SignInSupport.v13();
         var14 = uiSupport155.v1(uiSupport95.v4(), SignInSupport.v33(), var5);
      }

      uiSupport96.v1(var7, var8, var9, this.v8(), var3, var4, var13, this.v50);
      uiSupport96.v1(var10, this.v8(), var3, var4, var14, this.v50);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else {
         int var4 = this.v6(var1, var2);
         if (var4 < 0 || this.v49[var4].v1() != 1) {
            this.v1(-1, false);
         }

         if (var3 == 0 && var4 >= 0) {
            TheEndSupport.Part1 var5 = this.v49[var4];
            switch (var5.v1()) {
               case 0:
                  this.v2(var5.v2(), true);
                  break;
               case 1:
               default:
                  int var6 = var5.v2();
                  boolean var7 = this.v42[var6].v3();
                  this.v1(var6, false);
                  this.v5(var6, var4);
                  this.v42[var6].v2(var1, var2, var3);
                  if (!var7 && var6 >= this.v43) {
                     this.v42[var6].v4();
                  }
                  break;
               case 2:
                  this.v5(var5.v2());
                  break;
               case 3:
                  this.v6(var5.v2());
            }

            return true;
         } else {
            return true;
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      int var6 = this.v20();
      return var6 >= 0 && this.v42[var6].v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      int var4 = this.v20();
      return var4 >= 0 && this.v42[var4].v4(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      if (var1 != 257 && var1 != 335) {
         int var3 = this.v20();
         if (var1 == 258) {
            ArrayList var4 = new ArrayList();

            for (TheEndSupport.Part1 var8 : this.v49) {
               if (var8.v1() == 1) {
                  var4.add(var8.v2());
               }
            }

            if (!var4.isEmpty()) {
               int var9 = Math.max(0, var4.indexOf(var3));
               int var10 = (var2 & 1) != 0 ? -1 : 1;
               this.v1((Integer)var4.get(Math.floorMod(var9 + (var3 < 0 ? 0 : var10), var4.size())), true);
            }

            return true;
         } else {
            return var3 >= 0 && this.v42[var3].v2(var1, var2);
         }
      } else {
         this.v21();
         return true;
      }
   }

   @Override
   public boolean v3(int var1, int var2) {
      int var3 = this.v20();
      if (var3 < 0) {
         return false;
      } else {
         return var3 >= this.v43 && (var1 < 48 || var1 > 57) && var1 != 45 ? true : this.v42[var3].v3(var1, var2);
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      int var3 = this.v6(var1, var2);
      if (var3 < 0) {
         return hudSupport54.ARROW;
      } else {
         return this.v49[var3].v1() == 1 ? hudSupport54.IBEAM : hudSupport54.POINTER;
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      int var1 = this.v20();
      return var1 >= 0 ? this.v42[var1].v31() : null;
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

   public static enum Part2 {
      CREATE,
      MOVE;

      private Part2() {
      }
   }

   public interface Part3 {
      void v12();

      void v13();
   }
}
