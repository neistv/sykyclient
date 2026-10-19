package cc.syky.ui;

import cc.syky.cloud.CloudClient;
import cc.syky.cloud.OnlyMeSupport2;
import cc.syky.cloud.cloudSupport49;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class SignOutSupport extends UiNode {
   private static final String v2 = "Back";
   private static final String v3 = "Edit profile";
   private static final String v4 = "Add as a friend";
   private static final String v5 = "Request sent";
   private static final String v6 = "Cancel request";
   private static final String v7 = "Accept";
   private static final String v8 = "Decline";
   private static final String v13 = "Friends";
   private static final String v14 = "Remove friend";
   private static final String v15 = "About";
   private static final String v16 = "Details";
   private static final String v18 = "Body";
   private static final String v19 = "Head";
   private static final String v17 = "Cosmetics";
   private static final String v20 = "Profile visibility";
   private static final String v21 = "Privacy";
   private static final String v22 = "Server you play on";
   private static final String v24 = "Account";
   private static final String v25 = "Nothing about you yet — add a few words with Edit profile.";
   private static final String v26 = "Nothing here yet.";
   private static final String v27 = "Kept private.";
   private static final String v28 = "Loading…";
   private static final String v29 = "None";
   private static final String v30 = "—";
   private static final cloudSupport49[] v32 = new cloudSupport49[]{cloudSupport49.CAPE, cloudSupport49.BACK, cloudSupport49.AURA};
   private static final cloudSupport49[] v23 = new cloudSupport49[]{cloudSupport49.HAT, cloudSupport49.FACE};
   private static final DateTimeFormatter v33 = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH).withZone(ZoneId.systemDefault());
   public static final boolean v1 = false;
   private static final SignOutSupport.Part1[] v31 = new SignOutSupport.Part1[]{SignOutSupport.Part1.OVERVIEW, SignOutSupport.Part1.SETTINGS};
   private static final SignOutSupport.Part1[] v34 = new SignOutSupport.Part1[]{SignOutSupport.Part1.OVERVIEW};
   private static final OnlyMeSupport2.Part4[] v36 = new OnlyMeSupport2.Part4[]{OnlyMeSupport2.Part4.FRIENDS, OnlyMeSupport2.Part4.NOBODY};
   private static SignOutSupport.Part1 v38 = SignOutSupport.Part1.OVERVIEW;
   private final OnlyMeSupport2 v42;
   private final uiSupport119 v43;
   private final CloudClient v37;
   private final uiSupport120 v48;
   private float v40;
   private final uiSupport123 v44;
   private final uiSupport123 v47;
   private final uiSupport123 v49;
   private final hudSupport57[] v46 = new hudSupport57[SignOutSupport.Part1.values().length];
   private final uiSupport118[] v51;
   private int v50;
   private final uiSupport118[] v60;
   private final uiSupport118[] v59;
   private final uiSupport118[] v53;
   private final uiSupport118[] v63;
   private final uiSupport118[] v64;
   private final uiSupport118[] v61;
   private final uiSupport118 v66;
   private final uiSupport118[] v68;
   private final uiSupport118[] v52;
   private final Runnable v75;
   private final Runnable v73;
   private final Runnable v74;
   private final Runnable v72;
   private final Runnable v80;
   private final Runnable v84;
   private final Runnable v94;
   private final Runnable[] v82 = new Runnable[cloudSupport49.values().length];
   private final Runnable[] v99 = new Runnable[OnlyMeSupport2.Part1.values().length];
   private final Runnable v120;
   private float v88;
   private float v103;
   private float v101;
   private float v96;
   private float v105;
   private float v87;
   private float v85;
   private float v119;
   private float v98;
   private final float[] v124 = new float[SignOutSupport.Part1.values().length];
   private final float[] v117 = new float[SignOutSupport.Part1.values().length];
   private float v45;
   private boolean v104;
   private boolean v125;
   private float v141 = 406.0F;
   private final String[] v145 = new String[3];
   private final float[] v162 = new float[3];
   private final float[] v107 = new float[3];
   private int v118;
   private float v159;
   private float v176;
   private float v116;
   private float v147;
   private int v93 = -1;
   private boolean v157;
   private String v166 = "";
   private String v121 = "";
   private String v137 = "";
   private List<String> v187 = List.of();
   private float v138 = -1.0F;
   private uiRecord7 v106 = uiRecord7.ZERO;
   private uiRecord7 v100 = uiRecord7.ZERO;
   private uiRecord7 v191 = uiRecord7.ZERO;
   private uiRecord7 v112 = uiRecord7.ZERO;
   private float v216 = -1.0F;
   private float v41 = -1.0F;

   public SignOutSupport(OnlyMeSupport2 var1, float var2, uiSupport120 var3, Runnable var4) {
      this.v42 = var1;
      this.v43 = var1.v2();
      this.v37 = var1.v17();
      this.v48 = var3;
      this.v40 = var2;
      this.v44 = new uiSupport123(var2, uiSupport123.Part1.ACTION);
      this.v47 = new uiSupport123(var2, uiSupport123.Part1.ACTION);
      this.v49 = new uiSupport123(var2, uiSupport123.Part1.ACTION);
      this.v51 = v1(6, var2);
      this.v60 = v1(v32.length, var2);
      this.v59 = v1(v23.length, var2);
      this.v53 = v1(OnlyMeSupport2.Part1.values().length + 1, var2);
      ArrayList var5 = new ArrayList<>(List.of(this.v53));
      var5.remove(this.v53[OnlyMeSupport2.Part1.COSMETICS.ordinal()]);
      this.v63 = var5.toArray(new uiSupport118[0]);
      this.v64 = v1(2, var2);
      this.v61 = v1(2, var2);
      this.v66 = new uiSupport118(var2);
      this.v68 = new uiSupport118[]{this.v66};
      ArrayList var6 = new ArrayList();

      for (uiSupport118[] var10 : new uiSupport118[][]{this.v51, this.v60, this.v59, this.v53, this.v64, this.v61}) {
         var6.addAll(List.of(var10));
      }

      var6.add(this.v66);
      this.v52 = var6.toArray(new uiSupport118[0]);

      for (int var11 = 0; var11 < this.v46.length; var11++) {
         this.v46[var11] = new hudSupport57(var11 == v38.ordinal() ? 1.0F : 0.0F, 150.0F);
      }

      for (int var12 = 0; var12 < v32.length; var12++) {
         cloudSupport49 var15 = v32[var12];
         uiSupport118 var18 = this.v60[var12];
         this.v82[var15.ordinal()] = () -> this.v1(var15, var18);
      }

      for (int var13 = 0; var13 < v23.length; var13++) {
         cloudSupport49 var16 = v23[var13];
         uiSupport118 var19 = this.v59[var13];
         this.v82[var16.ordinal()] = () -> this.v1(var16, var19);
      }

      for (OnlyMeSupport2.Part1 var21 : OnlyMeSupport2.Part1.values()) {
         this.v99[var21.ordinal()] = () -> this.v1(var21);
      }

      this.v120 = this::v10;
      this.v75 = var4;
      this.v73 = () -> this.v37.v1("/account/settings");
      this.v74 = var1::v24;
      this.v72 = var1::v26;
      this.v80 = var1::v25;
      this.v84 = var1::v26;
      this.v94 = var1::v27;
      this.v64[0].v1("Online features", this.v37::v6, () -> this.v37.v1(!this.v37.v6()));
      this.v64[1].v1("Allow friend requests", var1::v12, () -> var1.v1(!var1.v12()));
      this.v61[0].v2("Your account on the website", "Open", () -> this.v37.v1("/account"));
      this.v61[1].v2("Sign out of this install", "Sign out", this.v37::v19);
      this.v66.v1("No cosmetics yet", "The ones you get appear here", false);
      this.v1(var2);
   }

   private static uiSupport118[] v1(int var0, float var1) {
      uiSupport118[] var2 = new uiSupport118[var0];

      for (int var3 = 0; var3 < var0; var3++) {
         var2[var3] = new uiSupport118(var1);
      }

      return var2;
   }

   public void v1(float var1) {
      this.v40 = var1;
      this.v44.v1(var1);
      this.v47.v1(var1);
      this.v49.v1(var1);

      for (uiSupport118 var5 : this.v52) {
         var5.v1(var1);
      }
   }

   public int v1() {
      int var1 = this.v42.v3();
      var1 = 31 * var1 + this.v43.v1();
      var1 = 31 * var1 + v38.ordinal();
      var1 = 31 * var1 + (this.v37.v6() ? 1 : 0);
      return 31 * var1 + (uiSupport223.v2 ? 1 : 0);
   }

   public float v2() {
      return this.v141;
   }

   private float v2(float var1) {
      return SignInSupport.v4(var1, this.v40);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5) {
      this.v8();
      this.v88 = var1;
      this.v103 = var2 + var5;
      this.v1(var1, this.v103, var3, var4);
      float var6 = 16.0F;
      float var7 = var3 / this.v40 - 16.0F;
      this.v101 = var1 + this.v2(var6);
      this.v105 = var1 + this.v2(var7) - this.v101;
      this.v96 = this.v103 + this.v2(82.0F);
      this.v87 = this.v103 + this.v2(260.0F) - this.v96;
      this.v85 = var1 + this.v2(44.0F);
      this.v119 = this.v103 + this.v2(220.0F);
      this.v98 = var1 + this.v2(152.0F) - this.v85;
      float var8 = var6 + 12.0F;
      float var9 = 94.0F;
      this.v44.v1("Back", false, this.v75);
      this.v44.v1(var1 + this.v2(var8), this.v103 + this.v2(var9), this.v2(var8 + this.v44.v1()) - this.v2(var8), this.v2(var9 + 32.0F) - this.v2(var9));
      this.v3(var1, var7);
      this.v3(var1);
      this.v4(var6, var7);
   }

   private void v3(float var1, float var2) {
      float var3 = 272.0F;
      float var4 = var3 + 39.0F;
      float var5 = var2;
      if (this.v125) {
         float var6 = var2 - this.v49.v1();
         this.v49.v1(var1 + this.v2(var6), this.v103 + this.v2(var3), this.v2(var2) - this.v2(var6), this.v2(var4) - this.v2(var3));
         var5 = var6 - 12.0F;
      }

      if (this.v104) {
         float var7 = var5 - this.v47.v1();
         this.v47.v1(var1 + this.v2(var7), this.v103 + this.v2(var3), this.v2(var5) - this.v2(var7), this.v2(var4) - this.v2(var3));
      }
   }

   private void v3(float var1) {
      float var2 = 44.0F;

      for (SignOutSupport.Part1 var6 : this.v3()) {
         float var7 = uiSupport169.v2("syky_sans_strong", var6.label, 18.0F);
         this.v124[var6.ordinal()] = var1 + this.v2(var2);
         this.v117[var6.ordinal()] = this.v2(var2 + var7) - this.v2(var2);
         var2 += var7 + 28.0F;
      }

      this.v45 = this.v103 + this.v2(352.0F);
   }

   private static float v4(float var0) {
      return var0 + 19.1F + 8.0F;
   }

   private void v4(float var1, float var2) {
      this.v118 = 0;
      float var3 = 406.0F;
      float var4 = (var2 - var1 - 16.0F) / 2.0F;
      float var5 = var1 + var4;
      float var6 = var5 + 16.0F;
      if (this.v42.v4() == OnlyMeSupport2.Part5.READY && this.v42.v6() != null) {
         switch (this.v1(v38)) {
            case OVERVIEW:
               this.v5((var4 - 32.0F) * this.v40);
               float var12 = Math.max(1, this.v187.size());
               float var13 = v4(var3) + var12 * 22.0F + 32.0F;
               this.v1("About", var1, var3);
               this.v159 = this.v88 + this.v2(var1);
               this.v176 = this.v103 + this.v2(v4(var3));
               this.v116 = this.v88 + this.v2(var5) - this.v159;
               this.v147 = this.v103 + this.v2(var13) - this.v176;
               this.v1("Details", var6, var3);
               float var9 = this.v1(this.v51, this.v50, var6, var2, v4(var3));
               this.v141 = Math.max(var13, var9);
               break;
            case INVENTORY:
               if (this.v42.v18() == 0) {
                  this.v1("Cosmetics", var1, var3);
                  this.v141 = this.v1(this.v68, 1, var1, var2, v4(var3));
                  return;
               }

               this.v1("Body", var1, var3);
               this.v1("Head", var6, var3);
               float var11 = this.v1(this.v60, this.v60.length, var1, var5, v4(var3));
               float var8 = this.v1(this.v59, this.v59.length, var6, var2, v4(var3));
               this.v141 = Math.max(var11, var8);
               break;
            case SETTINGS:
               this.v1("Profile visibility", var1, var3);
               float var7 = this.v1(this.v63, this.v63.length, var1, var2, v4(var3)) + 16.0F;
               this.v1("Privacy", var1, var7);
               var7 = this.v1(this.v64, this.v14(), var1, var2, v4(var7)) + 16.0F;
               this.v1("Account", var1, var7);
               this.v141 = this.v1(this.v61, this.v61.length, var1, var2, v4(var7));
         }
      } else {
         this.v141 = var3 + 54.0F;
      }
   }

   private float v1(uiSupport118[] var1, int var2, float var3, float var4, float var5) {
      float var6 = this.v88 + this.v2(var3);
      float var7 = this.v88 + this.v2(var4) - var6;

      for (int var8 = 0; var8 < var2; var8++) {
         float var9 = var5 + var8 * 54.0F;
         float var10 = this.v103 + this.v2(var9);
         var1[var8].v1(var6, var10, var7, this.v103 + this.v2(var9 + 54.0F) - var10, var8 == 0, var8 == var2 - 1);
      }

      return var5 + var2 * 54.0F;
   }

   private void v1(String var1, float var2, float var3) {
      if (this.v118 < this.v145.length) {
         this.v145[this.v118] = var1;
         this.v162[this.v118] = this.v88 + this.v2(var2 + 16.0F);
         this.v107[this.v118] = this.v103 + this.v2(var3);
         this.v118++;
      }
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v7();
      OnlyMeSupport2.Part7 var2 = this.v42.v6();
      this.v1(var2);
      this.v2(var2);
      this.v4();
      if (!this.v42.v8()) {
         this.v44.v1(var1);
      }

      if (this.v104) {
         this.v47.v1(var1);
      }

      if (this.v125) {
         this.v49.v1(var1);
      }

      if (this.v42.v4() == OnlyMeSupport2.Part5.READY && var2 != null) {
         this.v5();

         for (int var3 = 0; var3 < this.v118; var3++) {
            uiSupport169.v1("syky_sans", this.v145[var3], this.v162[var3], this.v107[var3], 16.0F * this.v40, SignInSupport.v34());
         }

         switch (this.v1(v38)) {
            case OVERVIEW:
               this.v6();
               this.v1(this.v51, this.v50, var1);
               break;
            case INVENTORY:
               if (this.v42.v18() == 0) {
                  this.v1(this.v68, 1, var1);
               } else {
                  this.v1(this.v60, this.v60.length, var1);
                  this.v1(this.v59, this.v59.length, var1);
               }
               break;
            case SETTINGS:
               this.v1(this.v63, this.v63.length, var1);
               this.v1(this.v64, this.v14(), var1);
               this.v1(this.v61, this.v61.length, var1);
         }
      } else {
         this.v1(this.v42.v4() == OnlyMeSupport2.Part5.FAILED ? this.v42.v5() : "Loading…");
      }
   }

   private SignOutSupport.Part1 v1(SignOutSupport.Part1 var1) {
      for (SignOutSupport.Part1 var5 : this.v3()) {
         if (var5 == var1) {
            return var1;
         }
      }

      return SignOutSupport.Part1.OVERVIEW;
   }

   private SignOutSupport.Part1[] v3() {
      return this.v42.v8() ? v31 : v34;
   }

   private void v1(@Nullable OnlyMeSupport2.Part7 var1) {
      float var2 = this.v85 + this.v98 / 2.0F;
      float var3 = this.v119 + this.v98 / 2.0F;
      float var4 = this.v98 / 2.0F + 6.0F * this.v40;
      boolean var5 = uiSupport169.v5();

      try {
         uiSupport119.Part2 var6 = var1 != null && var1.v6() != 0L ? this.v43.v3(var1.v1(), var1.v6()) : null;
         if (var6 != null && var6.v2() != null) {
            this.v1(var6.v2(), var6.v3(), var6.v4());
         } else if (var1 != null && (var1.v5() != 0L || var1.v6() != 0L)) {
            int var7 = var1.v5() == 0L ? 0 : this.v43.v2(var1.v1(), var1.v5());
            uiSupport169.v1(this.v101, this.v96, this.v105, this.v87, var7 == 0 ? SignInSupport.v36() : var7, this.v106);
         } else {
            uiSupport169.v1(this.v43.v2(), this.v101, this.v96, this.v105, this.v87, -1, this.v106);
         }
      } finally {
         if (var5) {
            uiSupport169.v1(1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, uiRecord7.ZERO, 0.0F, var2, var3, var4);
         }
      }
   }

   private void v1(class_2960 var1, int var2, int var3) {
      float var4 = 0.0F;
      float var5 = 0.0F;
      float var6 = 1.0F;
      float var7 = 1.0F;
      if (var2 > 0 && var3 > 0 && this.v105 > 0.0F && this.v87 > 0.0F) {
         float var8 = (float)var2 / var3;
         float var9 = this.v105 / this.v87;
         if (var9 > var8) {
            float var10 = var8 / var9;
            var5 = (1.0F - var10) / 2.0F;
            var7 = var5 + var10;
         } else {
            float var11 = var9 / var8;
            var4 = (1.0F - var11) / 2.0F;
            var6 = var4 + var11;
         }
      }

      uiSupport169.v1(var1, this.v101, this.v96, this.v105, this.v87, var4, var5, var6, var7, -1, this.v106);
   }

   private void v2(@Nullable OnlyMeSupport2.Part7 var1) {
      uiSupport122.v1(
         var1 == null ? null : this.v43.v1(var1.v1(), var1.v5()),
         this.v137,
         this.v85,
         this.v119,
         this.v98,
         this.v100,
         var1 == null ? SignInSupport.v36() : SignInSupport.v19(),
         45.0F * this.v40,
         1.0F
      );
   }

   private void v4() {
      float var1 = 36.0F * this.v40;
      float var2 = this.v88 + this.v2(164.0F);
      float var3 = this.v103 + this.v2(263.0F);
      uiSupport169.v1("syky_sans_strong", this.v166, var2, uiSupport169.v1(var3 + 43.0F * this.v40 / 2.0F, var1), var1, SignInSupport.v19());
      float var4 = 18.0F * this.v40;
      float var5 = this.v103 + this.v2(307.0F);
      uiSupport169.v1("syky_sans_strong", this.v121, var2, uiSupport169.v1(var5 + 21.0F * this.v40 / 2.0F, var4), var4, SignInSupport.v17());
   }

   private void v5() {
      float var1 = 18.0F * this.v40;
      float var2 = uiSupport169.v1(this.v45 + 21.0F * this.v40 / 2.0F, var1);
      float var3 = this.v103 + this.v2(378.0F);
      float var4 = this.v103 + this.v2(380.0F) - var3;
      SignOutSupport.Part1 var5 = this.v1(v38);

      for (SignOutSupport.Part1 var9 : this.v3()) {
         int var10 = var9.ordinal();
         this.v46[var10].v2(var9 == var5 ? 1.0F : 0.0F);
         float var11 = hudSupport60.v1(this.v46[var10].v2());
         uiSupport169.v1("syky_sans_strong", var9.label, this.v124[var10], var2, var1, uiSupport155.v1(SignInSupport.v21(), SignInSupport.v19(), var11));
         if (var11 > 0.0F) {
            uiSupport169.v1(this.v124[var10], var3, this.v117[var10], var4, uiSupport155.v1(SignInSupport.v19(), var11), this.v112);
         }
      }
   }

   @Nullable
   private SignOutSupport.Part1 v5(float var1, float var2) {
      float var3 = 28.0F * this.v40;
      if (!(var2 < this.v45 - var3 / 2.0F) && !(var2 > this.v45 + var3 * 1.5F)) {
         float var4 = 14.0F * this.v40;

         for (SignOutSupport.Part1 var8 : this.v3()) {
            int var9 = var8.ordinal();
            if (var1 >= this.v124[var9] - var4 && var1 < this.v124[var9] + this.v117[var9] + var4) {
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private void v1(uiSupport118[] var1, int var2, uiSupport35 var3) {
      uiSupport118 var4 = var1[0];
      uiSupport118 var5 = var1[var2 - 1];
      this.v2(var4.v9, var4.v10, var4.v11, var5.v10 + var5.v12 - var4.v10);

      for (int var6 = 0; var6 < var2; var6++) {
         var1[var6].v1(var3);
      }
   }

   private void v6() {
      this.v2(this.v159, this.v176, this.v116, this.v147);
      OnlyMeSupport2.Part7 var1 = this.v42.v6();
      String var2 = var1 == null ? null : var1.v4();
      boolean var3 = var2 == null || var2.isEmpty();
      float var4 = 16.0F * this.v40;
      float var5 = 22.0F * this.v40;
      float var6 = this.v176 + 16.0F * this.v40;

      for (int var7 = 0; var7 < this.v187.size(); var7++) {
         uiSupport169.v1(
            "syky_sans",
            this.v187.get(var7),
            this.v159 + 16.0F * this.v40,
            uiSupport169.v1(var6 + var7 * var5 + var5 / 2.0F, var4),
            var4,
            var3 ? SignInSupport.v49() : SignInSupport.v47()
         );
      }
   }

   private void v2(float var1, float var2, float var3, float var4) {
      uiSupport169.v1(var1, var2, var3, var4, SignInSupport.v36(), SignInSupport.v1(SignInSupport.v38(), this.v40), SignInSupport.v2(this.v40), 1.0F, this.v191);
   }

   private void v1(String var1) {
      float var2 = 18.0F * this.v40;
      float var3 = this.v103 + this.v2(406.0F);
      uiSupport169.v1("syky_sans_strong", var1, this.v88 + this.v2(44.0F), uiSupport169.v1(var3 + 21.0F * this.v40 / 2.0F, var2), var2, SignInSupport.v21());
   }

   private void v5(float var1) {
      if (this.v138 != var1) {
         this.v138 = var1;
         OnlyMeSupport2.Part7 var2 = this.v42.v6();
         String var3 = var2 == null ? "" : var2.v4();
         String var4 = var3 == null
            ? "Kept private."
            : (var3.isEmpty() ? (this.v42.v8() ? "Nothing about you yet — add a few words with Edit profile." : "Nothing here yet.") : var3);
         float var5 = 16.0F * this.v40;
         ArrayList var6 = new ArrayList();
         StringBuilder var7 = new StringBuilder();

         for (String var11 : var4.split(" ")) {
            String var12 = var7.isEmpty() ? var11 : var7 + " " + var11;
            if (!var7.isEmpty() && uiSupport169.v2("syky_sans", var12, var5) > var1) {
               var6.add(var7.toString());
               var7.setLength(0);
            }

            var7.append(var7.isEmpty() ? var11 : " " + var11);
         }

         if (!var7.isEmpty()) {
            var6.add(var7.toString());
         }

         this.v187 = List.copyOf(var6);
      }
   }

   private void v7() {
      if (this.v216 != this.v40 || this.v41 != this.v98) {
         this.v216 = this.v40;
         this.v41 = this.v98;
         this.v106 = uiRecord7.v1(12.0F * this.v40);
         this.v100 = uiRecord7.v1(this.v98 / 2.0F);
         this.v191 = uiRecord7.v1(18.0F * this.v40);
         this.v112 = SignInSupport.v3(2.0F * this.v40);
      }
   }

   private void v8() {
      this.v42.v21();
      boolean var1 = uiSupport223.v2;
      if (this.v93 != this.v42.v3() || this.v157 != var1) {
         this.v93 = this.v42.v3();
         this.v157 = var1;
         this.v138 = -1.0F;
         OnlyMeSupport2.Part7 var2 = this.v42.v6();
         this.v166 = var2 == null ? "" : (this.v42.v8() && var1 ? "Protected" : var2.v2());
         this.v137 = uiSupport122.v1(this.v166);
         this.v121 = var2 == null ? "" : "UID " + var2.v1() + this.v11();
         if (var2 != null) {
            this.v3(var2);
         }

         for (OnlyMeSupport2.Part1 var6 : OnlyMeSupport2.Part1.values()) {
            this.v53[var6.ordinal()].v1(var6.label, this.v42.v1(var6).label, this.v99[var6.ordinal()]);
         }

         this.v53[OnlyMeSupport2.Part1.values().length].v1("Server you play on", this.v9().label, this.v120);
         this.v1(this.v60, v32);
         this.v1(this.v59, v23);
         this.v13();
      }
   }

   private void v3(OnlyMeSupport2.Part7 var1) {
      Instant var2 = var1.v3();
      this.v50 = 0;
      if (this.v42.v8()) {
         this.v1("Member since", var2 == null ? "—" : v33.format(var2), true);
         this.v1("Played with syky", v1(var1.v7()), true);
         this.v1("Friends", v1(this.v42.v16()), this.v42.v16() > 0);
      } else {
         if (var2 != null) {
            this.v1("Member since", v33.format(var2), true);
         }

         this.v1("UID", Long.toString(var1.v1()), true);
         this.v1("Friendship", this.v12(), this.v42.v7() == OnlyMeSupport2.Part6.FRIENDS);
         if (var1.v7() >= 0L) {
            this.v1("Played with syky", v1(var1.v7()), true);
         }

         if (var1.v8() >= 0) {
            this.v1("Friends", v1(var1.v8()), var1.v8() > 0);
         }
      }
   }

   private void v1(String var1, String var2, boolean var3) {
      this.v51[this.v50++].v1(var1, var2, var3);
   }

   private void v1(uiSupport118[] var1, cloudSupport49[] var2) {
      for (int var3 = 0; var3 < var2.length; var3++) {
         OnlyMeSupport2.Part3 var4 = this.v1(var2[var3]);
         String var5 = OnlyMeSupport2.v3(var2[var3].v1());
         if (var4 != null && !var4.v3().isEmpty()) {
            OnlyMeSupport2.Part2 var6 = var4.v1();
            var1[var3].v1(var5, var6 == null ? "None" : var6.v2(), this.v82[var2[var3].ordinal()]);
         } else {
            var1[var3].v1(var5, var4 == null ? "—" : "Nothing owned", false);
         }
      }
   }

   @Nullable
   private OnlyMeSupport2.Part3 v1(cloudSupport49 var1) {
      for (OnlyMeSupport2.Part3 var3 : this.v42.v19()) {
         if (var3.v2() == var1) {
            return var3;
         }
      }

      return null;
   }

   private OnlyMeSupport2.Part4 v9() {
      return this.v42.v11() ? OnlyMeSupport2.Part4.FRIENDS : OnlyMeSupport2.Part4.NOBODY;
   }

   private void v1(OnlyMeSupport2.Part1 var1) {
      uiSupport118 var2 = this.v53[var1.ordinal()];
      this.v1(new uiSupport78<>(OnlyMeSupport2.Part4.values(), () -> this.v42.v1(var1), var2x -> this.v42.v1(var1, var2x), this.v48, this.v40), var2);
   }

   private void v10() {
      uiSupport118 var1 = this.v53[OnlyMeSupport2.Part1.values().length];
      this.v1(new uiSupport78<>(v36, this::v9, var1x -> this.v42.v2(var1x == OnlyMeSupport2.Part4.FRIENDS), this.v48, this.v40), var1);
   }

   private void v1(cloudSupport49 var1, uiSupport118 var2) {
      OnlyMeSupport2.Part3 var3 = this.v1(var1);
      if (var3 != null && !var3.v3().isEmpty()) {
         List var4 = var3.v3();
         String[] var5 = new String[var4.size() + 1];
         var5[0] = "None";

         for (int var6 = 0; var6 < var4.size(); var6++) {
            var5[var6 + 1] = ((OnlyMeSupport2.Part2)var4.get(var6)).v2();
         }

         this.v1(new uiSupport82(var5, () -> {
            OnlyMeSupport2.Part3 var3x = this.v1(var1);
            OnlyMeSupport2.Part2 var4x = var3x == null ? null : var3x.v1();
            return var4x == null ? 0 : var4.indexOf(var4x) + 1;
         }, var3x -> this.v42.v1(var1, var3x == 0 ? null : (OnlyMeSupport2.Part2)var4.get(var3x - 1)), this.v48, this.v40), var2);
      }
   }

   private void v1(uiSupport80 var1, uiSupport118 var2) {
      this.v48.v1(var1, var2.v9, var2.v11, var2.v10 + var2.v12 / 2.0F);
   }

   private String v11() {
      return switch (this.v42.v7()) {
         case FRIENDS -> "  ·  Your friend";
         case REQUEST_RECEIVED -> "  ·  Sent you a friend request";
         case REQUEST_SENT -> "  ·  Friend request sent";
         default -> "";
      };
   }

   private String v12() {
      return switch (this.v42.v7()) {
         case FRIENDS -> "Friends";
         case REQUEST_RECEIVED -> "Wants to be friends";
         case REQUEST_SENT -> "Request sent";
         default -> "Not friends";
      };
   }

   private void v13() {
      this.v104 = false;
      this.v125 = false;
      if (this.v42.v6() != null) {
         switch (this.v42.v7()) {
            case FRIENDS:
               this.v49.v1("Friends", "Remove friend", false, this.v94);
               this.v125 = true;
               break;
            case REQUEST_RECEIVED:
               this.v47.v1("Decline", false, this.v84);
               this.v49.v1("Accept", true, this.v80);
               this.v104 = true;
               this.v125 = true;
               break;
            case REQUEST_SENT:
               this.v49.v1("Request sent", "Cancel request", false, this.v72);
               this.v125 = true;
               break;
            case SELF:
               this.v49.v1("Edit profile", false, this.v73);
               this.v125 = true;
               break;
            case NONE:
               this.v49.v1("Add as a friend", true, this.v74);
               this.v125 = true;
            case SIGNED_OUT:
         }
      }
   }

   private static String v1(int var0) {
      return var0 < 0 ? "—" : Integer.toString(var0);
   }

   private static String v1(long var0) {
      if (var0 < 0L) {
         return "—";
      } else if (var0 < 3600L) {
         return var0 / 60L + " min";
      } else {
         return var0 < 36000L ? String.format(Locale.ENGLISH, "%.1f h", (float)var0 / 3600.0F) : var0 / 3600L + " h";
      }
   }

   private boolean v1(uiSupport118 var1) {
      return switch (this.v1(v38)) {
         case OVERVIEW -> false;
         case INVENTORY -> this.v42.v18() != 0 && (v1(this.v60, var1) || v1(this.v59, var1));
         case SETTINGS -> v1(this.v63, var1) || v1(this.v64, var1) && (var1 != this.v64[1] || this.v14() > 1) || v1(this.v61, var1);
      };
   }

   private int v14() {
      return this.v42.v13() ? this.v64.length : 1;
   }

   private static boolean v1(uiSupport118[] var0, uiSupport118 var1) {
      for (uiSupport118 var5 : var0) {
         if (var5 == var1) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v42.v8() && this.v44.v1(var1, var2, var3)) {
         return true;
      } else if ((!this.v104 || !this.v47.v1(var1, var2, var3)) && (!this.v125 || !this.v49.v1(var1, var2, var3))) {
         if (this.v42.v4() == OnlyMeSupport2.Part5.READY && var3 == 0) {
            SignOutSupport.Part1 var4 = this.v5(var1, var2);
            if (var4 != null) {
               v38 = var4;
               return true;
            } else {
               for (uiSupport118 var8 : this.v52) {
                  if (this.v1(var8) && var8.v1(var1, var2, var3)) {
                     return true;
                  }
               }

               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if ((this.v42.v8() || !this.v44.v1(var1, var2))
         && (!this.v104 || !this.v47.v1(var1, var2))
         && (!this.v125 || !this.v49.v1(var1, var2))
         && (this.v42.v4() != OnlyMeSupport2.Part5.READY || this.v5(var1, var2) == null)) {
         if (this.v42.v4() == OnlyMeSupport2.Part5.READY) {
            for (uiSupport118 var6 : this.v52) {
               if (this.v1(var6) && var6.v1(var1, var2)) {
                  return var6.v2(var1, var2);
               }
            }
         }

         return hudSupport54.ARROW;
      } else {
         return hudSupport54.POINTER;
      }
   }

   public static enum Part1 {
      OVERVIEW("Overview"),
      INVENTORY("Inventory"),
      SETTINGS("Settings");

      public final String label;

      private Part1(String var3) {
         this.label = var3;
      }
   }
}
