package cc.syky.cloud;

import cc.syky.EndSupport;
import cc.syky.LANRecord;
import cc.syky.sykyRecord4;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import cc.syky.internal.InternalSupport25;
import cc.syky.internal.InternalSupport7;
import cc.syky.render.font.MsdfFont;
import cc.syky.ui.AddFriendSupport;
import cc.syky.ui.AddNoteSupport;
import cc.syky.ui.SignInSupport;
import cc.syky.ui.UiPopup;
import cc.syky.ui.UiScreen;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport102;
import cc.syky.ui.uiSupport116;
import cc.syky.ui.uiSupport119;
import cc.syky.ui.uiSupport122;
import cc.syky.ui.uiSupport143;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport35;
import cc.syky.ui.uiSupport49;
import cc.syky.ui.uiSupport51;
import cc.syky.ui.uiSupport52;
import cc.syky.ui.uiSupport53;
import cc.syky.ui.uiSupport55;
import cc.syky.ui.uiSupport93;
import cc.syky.ui.uiSupport97;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.class_2338;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public final class ReplyToSupport {
   private static final Set<String> v1 = new HashSet<>();
   private static final Map<Long, Float> v2 = new HashMap<>();
   private static final String v3 = "The start of your chat. Messages stay for 180 days, and only the two of you can read them.";
   private final ReplyToSupport.Part1 v4;
   private final GETSupport v5;
   private final long v6;
   private String v7;
   private String v8;
   private long v9;
   @Nullable
   private GETSupport2.Part2 v10;
   private boolean v11;
   @Nullable
   private GETSupport2.Part1 v12;
   private boolean v13;
   private final uiSupport53 v14;
   @Nullable
   private GETSupport2.Part1 v15;
   private final uiSupport53 v16;
   private final uiSupport53 v18;
   private String v19 = "";
   @Nullable
   private GETSupport2.Part1 v17;
   private boolean v20;
   private String v21 = "";
   private float v22 = -1.0F;
   private String v24 = "";
   @Nullable
   private GETSupport2.Part2 v25;
   private long v26 = -1L;
   private float v27;
   private final uiSupport53 v28;
   private final uiSupport53 v29;
   private final uiSupport53 v30;
   private final uiSupport53 v32;
   private final uiSupport53 v23;
   private final uiSupport53 v33;
   private final uiSupport53 v31;
   private final uiSupport53 v34;
   private final uiSupport53 v36;
   private final uiSupport53 v38;
   private final uiSupport53 v42;
   private final MsdfFont v43;
   private final hudSupport57 v37 = new hudSupport57(0.0F, 110.0F);
   private int v48;
   @Nullable
   private GETSupport.Part14 v40;
   @Nullable
   private String v44;
   @Nullable
   private String v47;
   @Nullable
   private String v49;
   private int v46;
   private int v51;
   private int v50;
   private int v60;
   private boolean v59;
   private long v53;
   private float v63;
   private float v64;
   private int v61;
   @Nullable
   private GETSupport.Part14 v66;
   private String v68 = "";
   private boolean v52;
   private final Set<String> v75 = new LinkedHashSet<>();
   private final hudSupport57 v73 = new hudSupport57(0.0F, 150.0F);
   @Nullable
   private String v74;
   @Nullable
   private UiScreen v72;
   private final Map<String, hudSupport57> v80 = new HashMap<>();
   @Nullable
   private String v84;
   private long v94;
   private long v82;
   @Nullable
   private GETSupport2.Part1 v99;
   private long v120;
   private long v88;
   private float v103 = -1.0F;
   private float v101;
   private boolean v96;
   private boolean v105;
   @Nullable
   private String v87;
   private Set<String> v85 = Set.of();
   private float v119;
   private float v98;
   private long v124;
   private YouSupport v117 = YouSupport.v4;
   @Nullable
   private List<GETSupport.Part14> v45;
   private float v104 = -1.0F;
   @Nullable
   private LocalDate v125;
   private String v141 = "";
   private Set<Long> v145 = Set.of();
   private List<String> v162 = List.of();
   private float v107 = -1.0F;
   private ZoneId v118 = ZoneId.systemDefault();
   private int v159 = 1;
   private boolean v176;
   private float v116;
   private UiPopup.Part1 v147 = UiPopup.Part1.JUMP;
   private float v93 = -1.0F;
   private float v157 = -1.0F;
   private boolean v166;
   private float v121;
   private boolean v137;
   private float v187;
   private float v138;
   private float v106;
   private float v100;
   private float v191;
   @Nullable
   private List<GETSupport.Part14> v112;
   @Nullable
   private List<GETSupport.Part14> v216;
   private static final String v41 = "Coordinates";
   private static final String v190 = "Server invite";

   public ReplyToSupport(ReplyToSupport.Part1 var1, GETSupport var2, long var3, String var5, String var6, float var7) {
      this.v4 = var1;
      this.v5 = var2;
      this.v6 = var3;
      this.v7 = var5;
      this.v8 = uiSupport122.v1(var5);
      this.v27 = var7;
      this.v28 = uiSupport53.v1(uiSupport53.Part2.QUIET, uiSupport53.v1(uiSupport143.v49, 9.0F, 14.0F, -1.5F), var7, var1::v3);
      this.v29 = uiSupport53.v1(uiSupport53.Part2.QUIET, uiSupport53.v4(), var7, () -> {});
      this.v30 = new uiSupport53(uiSupport53.Part2.QUIET, "Cancel request", null, var7, () -> var1.v1(var3, false));
      uiSupport53.Part1 var8 = (var1x, var2x, var3x, var4, var5x, var6x) -> uiSupport53.v1(this.v66 != null ? uiSupport143.v59 : uiSupport143.v46, 15.0F, 15.0F)
         .draw(var1x, var2x, var3x, var4, var5x, var6x);
      this.v32 = uiSupport53.v2(uiSupport53.Part2.SEND_INSIDE, var8, var7, this::v64);
      this.v23 = uiSupport53.v2(uiSupport53.Part2.SEND_INSIDE, uiSupport53.v1(uiSupport143.v47, 15.0F, 15.0F), var7, () -> {});
      this.v23.v4(false);
      this.v33 = uiSupport53.v2(uiSupport53.Part2.QUIET, uiSupport53.v1(uiSupport143.v51, 16.0F, 16.0F), var7, this::v20);
      this.v31 = uiSupport53.v2(uiSupport53.Part2.SEND_INSIDE, uiSupport53.v1(uiSupport143.v32, 14.0F, 14.0F), var7, this::v66);
      this.v31.v4(false);
      this.v34 = uiSupport53.v2(uiSupport53.Part2.SEND_INSIDE, uiSupport53.v1(uiSupport143.v21, 18.0F, 18.0F), var7, this::v84);
      this.v34.v4(false);
      this.v36 = uiSupport53.v1(uiSupport53.Part2.QUIET, uiSupport53.v1(uiSupport143.v32, 14.0F, 14.0F), var7, this::v52);
      this.v38 = new uiSupport53(uiSupport53.Part2.QUIET, "Copy", uiSupport143.v25, var7, this::v74);

      for (uiSupport53 var12 : new uiSupport53[]{this.v28, this.v29, this.v30, this.v33, this.v36, this.v38}) {
         var12.v5(true);
      }

      this.v42 = new uiSupport53(uiSupport53.Part2.DANGER, "Delete", null, var7, this::v72);
      this.v14 = new uiSupport53(uiSupport53.Part2.QUIET, "Decline", null, var7, () -> var1.v1(var3, false)).v1();
      this.v16 = new uiSupport53(uiSupport53.Part2.ACCEPT, "Send friend request", uiSupport143.v37, var7, () -> var1.v2(var3)).v1();
      this.v18 = new uiSupport53(uiSupport53.Part2.ACCEPT, "Accept friend request", null, var7, () -> var1.v1(var3, true)).v1();
      this.v43 = new MsdfFont("syky_sans_strong", 2000, var0 -> {});
      this.v43.v1("Message " + var5);
      this.v43.v1(true);
      this.v43.v1(1060L);
      this.v43.v2(var6);
      boolean var13 = !var6.isBlank();
      this.v32.v4(var13);
      this.v32.v2(var13);
   }

   public long v1() {
      return this.v6;
   }

   public String v2() {
      return this.v66 != null ? this.v68 : this.v43.v2();
   }

   public void v1(float var1) {
      this.v27 = var1;
      this.v28.v1(var1);
      this.v29.v1(var1);
      this.v30.v1(var1);
      this.v32.v1(var1);
      this.v23.v1(var1);
      this.v33.v1(var1);
      this.v31.v1(var1);
      this.v34.v1(var1);
      this.v36.v1(var1);
      this.v38.v1(var1);
      this.v42.v1(var1);
      this.v14.v1(var1);
      this.v16.v1(var1);
      this.v18.v1(var1);
   }

   private List<uiSupport53> v13() {
      if (!this.v14() || this.v4.v1(this.v6)) {
         return List.of();
      } else if (this.v12 != null) {
         return List.of(this.v14, this.v18);
      } else {
         return this.v4.v3(this.v6) ? List.of(this.v16) : List.of();
      }
   }

   private boolean v14() {
      return this.v11 && this.v10 == null && (this.v12 == null || this.v13);
   }

   private boolean v15() {
      return this.v10 == null && this.v12 != null && !this.v13;
   }

   private String v16() {
      return this.v12 != null ? this.v7 + " wants to be friends. Accept to keep talking." : "To keep talking, add each other as friends.";
   }

   public void v1(@Nullable GETSupport2.Part2 var1) {
      this.v11 = true;
      this.v10 = var1;
      if (var1 != null) {
         if (!var1.v2().equals(this.v7)) {
            this.v7 = var1.v2();
            this.v8 = uiSupport122.v1(this.v7);
            this.v43.v1("Message " + this.v7);
         }

         this.v9 = var1.v3();
      }
   }

   public void v1(long var1) {
      this.v9 = var1;
   }

   public void v1(@Nullable GETSupport2.Part1 var1, boolean var2) {
      if (var1 != null && this.v10 == null && (this.v12 == null || !var1.equals(this.v12))) {
         this.v9 = var1.v3();
         this.v43.v3(false);
      }

      this.v12 = this.v10 == null ? var1 : null;
      this.v13 = var2;
   }

   public void v3() {
      this.v5.v9(this.v6);
      this.v4.v5().v4();
      if (this.v93 < 0.0F) {
         this.v147 = UiPopup.Part1.JUMP;
      }

      this.v48 = 0;
   }

   public void v4() {
      Float var1 = v2.get(this.v6);
      if (var1 != null && var1 > 0.0F) {
         this.v93 = var1;
         this.v147 = UiPopup.Part1.NONE;
      }
   }

   public void v1(boolean var1) {
      this.v137 = var1;
   }

   public void v1(long var1, ZoneId var3, boolean var4) {
      long var5 = this.v124 == 0L ? 0L : Math.min(50L, Math.max(0L, var1 - this.v124));
      this.v124 = var1;
      this.v82 = var1;
      this.v118 = var3;
      if (this.v14()) {
         this.v43.v3(false);
         this.v40 = null;
         this.v44 = null;
         this.v61();
      }

      this.v2(var1);
      float var7 = this.v4.v7();
      boolean var8 = var7 >= this.v4.v8() - this.v27;
      if (var8) {
         this.v48 = 0;
      }

      this.v18();
      this.v50();
      int var9 = Math.max(1, Math.min(6, this.v43.v1()));
      boolean var10 = !this.v5.v2(this.v6).isEmpty();
      if (var9 != this.v159 || var10 != this.v176) {
         this.v159 = var9;
         this.v176 = var10;
         if (var8 && this.v93 < 0.0F) {
            this.v147 = UiPopup.Part1.JUMP;
         }
      }

      this.v1(var8, var3, LocalDate.ofInstant(Instant.ofEpochMilli(var1), var3));
      if (var4 && this.v166 && !this.v117.v1.isEmpty() && this.v93 < 0.0F && this.v27 > 0.0F) {
         v2.put(this.v6, Math.max(0.0F, (this.v4.v8() - var7) / this.v27));
      }

      this.v8(var7);
      if (var4) {
         this.v5(var5);
         this.v121 = var7;
         this.v5.v11(this.v6);
         if (var7 <= 600.0F * this.v27 && this.v5.v5(this.v6)) {
            this.v5.v10(this.v6);
         }
      }

      boolean var11 = this.v4.v8() - var7 > 240.0F * this.v27;
      this.v37.v2(var11 && !this.v137 ? 1.0F : 0.0F);
      this.v73.v2(this.v52 ? 1.0F : 0.0F);
      if (this.v84 != null && var1 - this.v94 > 1400L) {
         this.v84 = null;
      }

      boolean var12 = !this.v43.v2().isBlank();
      boolean var13 = this.v4.v1(this.v6);
      this.v14.v2(!var13);
      this.v30.v2(!var13);
      this.v32.v3(var12);
      this.v32.v2(var12);
   }

   private List<GETSupport.Part14> v1(List<GETSupport.Part14> var1) {
      GETSupport2.Part1 var2 = this.v12;
      if (var2 != null && !var2.v5().isBlank()) {
         if (var2 == this.v15 && this.v45 != null && this.v45.size() == var1.size() + 1 && this.v112 == var1) {
            return this.v45;
         } else {
            ArrayList var3 = new ArrayList(var1.size() + 1);
            var3.addAll(var1);
            var3.add(new GETSupport.Part14("request:" + this.v6, 0L, !this.v13, var2.v5(), var2.v4(), GETSupport.Part16.SENT, null, null, null, null, null));
            this.v112 = var1;
            return var3;
         }
      } else {
         return var1;
      }
   }

   private void v18() {
      List var1 = this.v1(this.v5.v1(this.v6));
      if (var1 != this.v216) {
         this.v216 = var1;
         HashSet var2 = new HashSet();

         for (GETSupport.Part14 var4 : var1) {
            var2.add(var4.v2());
         }

         GETSupport.Part14 var7 = this.v40;
         if (var7 != null && !var2.contains(var7.v2())) {
            this.v40 = null;
            this.v44 = null;
         }

         String var8 = this.v49;
         String var5 = this.v47;
         if (var8 != null && !var2.contains(var8) || var5 != null && !var2.contains(var5)) {
            this.v40();
         }

         GETSupport.Part14 var6 = this.v66;
         if (var6 != null && !var2.contains(var6.v2())) {
            this.v61();
         }

         this.v75.retainAll(var2);
      }
   }

   private void v2(long var1) {
      long var3 = var1 / 60000L;
      GETSupport2.Part2 var5 = this.v10;
      GETSupport2.Part1 var6 = this.v12;
      if (var5 != this.v25 || var6 != this.v99 || var3 != this.v26 || this.v24.isEmpty()) {
         this.v25 = var5;
         this.v99 = var6;
         this.v26 = var3;
         if (var5 == null) {
            this.v24 = var6 == null ? "Not friends" : (this.v13 ? "Wants to be friends" : "Friend request sent");
         } else {
            String var7 = AddFriendSupport.v1(var5, Instant.ofEpochMilli(var1));
            String var8 = var5.v6();
            this.v24 = var5.v5() && var8 != null && !var8.isEmpty() ? var7 + " · " + var8 : var7;
         }
      }
   }

   private float v19() {
      float var1 = this.v106 > 0.0F && this.v27 > 0.0F ? this.v106 / this.v27 : 752.0F;
      return Math.max(0.0F, var1 - 56.0F);
   }

   private void v1(boolean var1, ZoneId var2, LocalDate var3) {
      List var4 = this.v1(this.v5.v1(this.v6));
      float var5 = this.v19();
      HashSet var6 = new HashSet();

      for (GETSupport.Part6 var8 : this.v5.v2(this.v6)) {
         var6.add(var8.v1().v3());
      }

      if (var4 != this.v45 || this.v12 != this.v15 || var5 != this.v104 || !var3.equals(this.v125) || !this.v7.equals(this.v141) || !var6.equals(this.v145)) {
         YouSupport var15 = this.v117;
         this.v117 = YouSupport.v1(var4, var5, var2, var3, this.v7, var6, "syky_sans", "syky_sans", "syky_sans", "syky_sans_strong", uiSupport169::v2);
         this.v45 = var4;
         this.v104 = var5;
         this.v125 = var3;
         this.v141 = this.v7;
         this.v145 = var6;
         this.v15 = this.v12;
         if (this.v147 != UiPopup.Part1.JUMP && !var15.v1.isEmpty() && !this.v117.v1.isEmpty()) {
            YouSupport.Part3 var16 = var15.v1.getFirst();
            YouSupport.Part3 var9 = v1(this.v117, var16.v1.v2());
            if (var9 != null && var9 != this.v117.v1.getFirst()) {
               this.v116 = this.v116 + (this.v1(this.v117) + var9.v13 - this.v1(var15) - var16.v13) * this.v27;
            }

            String var10 = var15.v1.getLast().v1.v2();
            int var11 = 0;
            boolean var12 = false;

            for (int var13 = this.v117.v1.size() - 1; var13 >= 0; var13--) {
               GETSupport.Part14 var14 = this.v117.v1.get(var13).v1;
               if (var14.v2().equals(var10)) {
                  break;
               }

               if (var14.v4()) {
                  var12 |= var14.v7() == GETSupport.Part16.SENDING;
               } else {
                  var11++;
               }
            }

            if (!var1 && !var12) {
               this.v48 += var11;
            } else if (var11 > 0 || var12) {
               this.v147 = UiPopup.Part1.GLIDE;
            }
         }
      }
   }

   @Nullable
   private static YouSupport.Part3 v1(YouSupport var0, String var1) {
      for (YouSupport.Part3 var3 : var0.v1) {
         if (var3.v1.v2().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   @Nullable
   private YouSupport.Part3 v3(long var1) {
      for (YouSupport.Part3 var4 : this.v117.v1) {
         if (var4.v1.v3() == var1) {
            return var4;
         }
      }

      return null;
   }

   private boolean v17() {
      return this.v166 && this.v104 == this.v19() && (!this.v117.v1.isEmpty() || this.v5.v3(this.v6) == GETSupport.Part15.READY);
   }

   public float v5() {
      float var1 = this.v116;
      this.v116 = 0.0F;
      return var1;
   }

   public UiPopup.Part1 v6() {
      if (!this.v17()) {
         return UiPopup.Part1.NONE;
      } else {
         UiPopup.Part1 var1 = this.v147;
         this.v147 = UiPopup.Part1.NONE;
         return var1;
      }
   }

   public float v7() {
      if (!this.v17()) {
         return -1.0F;
      } else {
         float var1 = this.v93;
         this.v93 = -1.0F;
         return var1;
      }
   }

   public float v8() {
      if (!this.v17()) {
         return -1.0F;
      } else {
         float var1 = this.v157;
         this.v157 = -1.0F;
         return var1;
      }
   }

   private void v20() {
      this.v147 = UiPopup.Part1.GLIDE;
      this.v48 = 0;
   }

   private void v4(long var1) {
      YouSupport.Part3 var3 = this.v3(var1);
      if (var3 != null) {
         float var4 = this.v2(this.v1(this.v117)) + this.v2(var3.v13) + this.v2(var3.v12) / 2.0F;
         this.v157 = Math.max(0.0F, var4 - this.v100 * 0.45F);
         this.v84 = var3.v1.v2();
         this.v94 = this.v82;
      }
   }

   private float v21() {
      return (this.v22() ? 46.0F : 0.0F) + 20.0F + (this.v14() ? 1 : this.v159) * 22.0F;
   }

   private boolean v22() {
      return this.v40 != null || this.v66 != null;
   }

   private float v24() {
      return this.v176 ? 134.0F : 88.0F;
   }

   public float v9() {
      return this.v117.v1.isEmpty() ? 0.0F : (this.v117.v3 + this.v24() + 12.0F + this.v21() + 14.0F - 16.0F - 82.0F) * this.v27;
   }

   private float v1(YouSupport var1) {
      float var2 = (this.v100 > 0.0F && this.v27 > 0.0F ? this.v100 / this.v27 : 624.0F) - 14.0F - this.v21() - 12.0F;
      return Math.max(this.v24(), var2 - var1.v3);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5) {
      this.v166 = true;
      this.v187 = var1;
      this.v138 = var2;
      this.v106 = var3;
      this.v100 = var4;
      this.v191 = var5;
   }

   private float v25() {
      return this.v191 + (this.v137 ? this.v121 : this.v4.v7());
   }

   private float v2(float var1) {
      return SignInSupport.v4(var1, this.v27);
   }

   private float v26() {
      return this.v138 + this.v100 - this.v2(14.0F);
   }

   private float v27() {
      return this.v26() - this.v2(this.v21());
   }

   private float v28() {
      return this.v187 + this.v2(16.0F);
   }

   private float v29() {
      return this.v187 + this.v106 - this.v2(16.0F);
   }

   private uiRecord7 v30() {
      return uiRecord7.v1(21.0F * this.v27);
   }

   private float v32() {
      return this.v187 + this.v2(28.0F);
   }

   private float v23() {
      return hudSupport60.v1(this.v73.v2()) * 24.0F * this.v27;
   }

   public void v1(uiSupport102 var1) {
      var1.v1(this.v117);
      var1.v1(this.v106);
      var1.v1(this.v100);
      var1.v1(this.v21());
      var1.v1(this.v176);
      var1.v1(this.v51());
      var1.v1(this.v12);
      var1.v1(this.v14());
      var1.v1(this.v13().hashCode());
      var1.v1(this.v5.v3(this.v6));
      var1.v1((float)this.v9);
      var1.v1(this.v4.v1().v1(this.v6, this.v9) != null);
      var1.v1(uiSupport49.v1());
      var1.v1(this.v73.v2());
      var1.v1(this.v75.hashCode());
      var1.v1(this.v33());
      GETSupport.Part14 var2 = this.v66;
      var1.v1(var2 == null ? null : var2.v2());
      var1.v1(this.v31());
      var1.v1(this.v34());
      var1.v1(this.v47);
      var1.v1(this.v49);
      var1.v1(this.v46);
      var1.v1(this.v51);
      var1.v1(this.v50);
      var1.v1(this.v60);
      InternalSupport7 var3 = this.v4.v5();
      var1.v1(var3.v15());
      var1.v1(var3.v8());
      var1.v1(uiSupport223.v4);
      var1.v1(uiSupport223.v5);
      var1.v1(v1.size());
      var1.v1(this.v4.v6().hashCode());
   }

   @Nullable
   private String v33() {
      UiScreen var1 = this.v72;
      return var1 != null && this.v4.v1(var1) ? this.v74 : null;
   }

   private float v31() {
      if (this.v84 == null) {
         return 0.0F;
      } else {
         float var1 = (float)(this.v82 - this.v94) / 1400.0F;
         return var1 >= 1.0F ? 0.0F : 1.0F - hudSupport60.v1(var1);
      }
   }

   public void v1(uiSupport35 var1) {
      float var2 = this.v25();
      if (this.v117.v1.isEmpty()) {
         float var7 = this.v27() + var2;
         uiSupport169.v6(this.v187, this.v138, this.v106, Math.max(0.0F, var7 - this.v138));

         try {
            this.v5(var2);
         } finally {
            uiSupport169.v17();
         }
      } else {
         float var3 = this.v46();
         this.v3(var3);
         this.v1(var3, this.v32(), this.v138, this.v138 + this.v100);
         float var4 = hudSupport60.v1(this.v73.v2());
         if (var4 > 0.0F) {
            this.v4(var3, var4);
         }
      }
   }

   private float v1(YouSupport.Part3 var1) {
      String var2 = var1.v1.v2();
      GETSupport.Part14 var3 = this.v66;
      boolean var4 = this.v75.contains(var2) || var2.equals(this.v33()) || var3 != null && var3.v2().equals(var2);
      hudSupport57 var5 = this.v80.get(var2);
      if (var5 == null) {
         if (!var4) {
            return var2.equals(this.v84) ? this.v31() : 0.0F;
         }

         var5 = new hudSupport57(0.0F, 90.0F);
         this.v80.put(var2, var5);
      }

      var5.v2(var4 ? 1.0F : 0.0F);
      float var6 = SignInSupport.v1(var5.v2());
      if (!var4 && var6 <= 0.001F) {
         this.v80.remove(var2);
      }

      return Math.max(var6, var2.equals(this.v84) ? this.v31() : 0.0F);
   }

   private float v34() {
      float var1 = 0.0F;

      for (hudSupport57 var3 : this.v80.values()) {
         var1 += var3.v2();
      }

      return var1;
   }

   private float[] v1(int var1, float var2) {
      YouSupport.Part3 var3 = this.v117.v1.get(var1);
      float var4 = var1 > 0 ? (var3.v13 - this.v117.v1.get(var1 - 1).v2()) / 2.0F : 7.0F;
      float var5 = var1 + 1 < this.v117.v1.size() ? (this.v117.v1.get(var1 + 1).v13 - var3.v2()) / 2.0F : 7.0F;
      float var6 = var2 + this.v2(var3.v13 - Math.min(var4, 7.0F));
      float var7 = var2 + this.v2(var3.v2() + Math.min(var5, 7.0F));
      return new float[]{var6, var7};
   }

   private void v3(float var1) {
      for (int var2 = 0; var2 < this.v117.v1.size(); var2++) {
         float var3 = this.v1(this.v117.v1.get(var2));
         if (!(var3 <= 0.0F)) {
            float[] var4 = this.v1(var2, var1);
            float var5 = SignInSupport.v2(this.v27);
            uiSupport169.v1(this.v187, var4[0], this.v106 - var5, var4[1] - var4[0], cloudSupport19.v1(var3), uiRecord7.ZERO);
         }
      }
   }

   private void v4(float var1, float var2) {
      float var3 = this.v2(22.0F);
      float var4 = this.v187 + this.v2(16.0F);
      uiRecord7 var5 = uiRecord7.v1(var3 / 2.0F);
      float var6 = this.v2(12.0F);

      for (YouSupport.Part3 var8 : this.v117.v1) {
         float var9 = var1 + this.v2(var8.v13);
         float var10 = var9 + this.v2(var8.v12) / 2.0F;
         if (!(var10 + var3 < this.v138) && !(var10 - var3 > this.v138 + this.v100)) {
            float var11 = var9 + uiSupport169.v1((this.v2(var8.v12) - var3) / 2.0F);
            if (this.v75.contains(var8.v1.v2())) {
               uiSupport169.v1(var4, var11, var3, var3, uiSupport155.v1(cloudSupport19.v5(), var2), var5);
               uiSupport169.v1(
                  uiSupport143.v59,
                  var4 + uiSupport169.v1((var3 - var6) / 2.0F),
                  var11 + uiSupport169.v1((var3 - var6) / 2.0F),
                  var6,
                  var6,
                  uiSupport155.v1(cloudSupport19.v6(), var2),
                  uiRecord7.ZERO
               );
            } else {
               uiSupport169.v1(var4, var11, var3, var3, uiSupport155.v1(cloudSupport19.v7(), var2), 2.0F * this.v27, var5, 1.0F);
            }
         }
      }
   }

   private void v1(float var1, float var2, float var3, float var4) {
      float var5 = this.v23();

      for (YouSupport.Part3 var7 : this.v117.v1) {
         float var8 = var1 + this.v2(var7.v13);
         float var9 = var1 + this.v2(var7.v2());
         if (!(var9 < var3) && !(var8 > var4)) {
            float var10 = var2 + this.v2(var7.v14) + (var7.v1() ? 0.0F : var5);
            this.v1(var7, var10, var8, this.v2(var7.v14 + var7.v11) - this.v2(var7.v14), var9 - var8);
         }
      }
   }

   private void v1(YouSupport.Part3 var1, float var2, float var3, float var4, float var5) {
      boolean var6 = var1.v1();
      int var7 = cloudSupport19.v1(var6);
      float var8 = 16.5F * this.v27;
      float var9 = 5.0F * this.v27;
      float var10 = var1.v6 ? var8 : var9;
      float var11 = var1.v7 ? 0.0F : var9;
      uiRecord7 var12 = var6 ? uiRecord7.v1(var8, var10, var11, var8) : uiRecord7.v1(var10, var8, var8, var11);
      uiSupport169.v1(var2, var3, var4, var5, var7, var12);
      if (var1.v7) {
         float var13 = this.v2(10.0F);
         float var14 = this.v2(16.0F);
         float var15 = 1.0F * this.v27;
         float var16 = var6 ? var2 + var4 - var15 : var2 - var13 + var15;
         uiSupport169.v1(var6 ? uiSupport143.v63 : uiSupport143.v53, var16, var3 + var5 - var14, var13, var14, var7, uiRecord7.ZERO);
      }

      GETSupport.Part18 var25 = var1.v1.v8();
      if (var25 != null) {
         this.v1(var1, var25, var2, var3, var4);
      }

      if (var1.v15) {
         this.v1(var1, this.v2(var1), var2, var3, var4, var5);
      } else {
         float var26 = 16.0F * this.v27;
         float var27 = var2 + this.v2(12.0F);
         int var28 = cloudSupport19.v2(var6);
         int[] var17 = this.v1(this.v1(var1.v1.v2()));
         if (var17 != null) {
            this.v1(var1, var17, var27, var3, var26);
         }

         for (int var18 = 0; var18 < var1.v2.size(); var18++) {
            String var19 = var1.v2.get(var18);
            if (!var19.isEmpty()) {
               float var20 = var3 + (var1.v10 + var18 * 21.0F + 10.5F - 0.75F) * this.v27;
               uiSupport169.v1("syky_sans", var19, var27, uiSupport169.v1(var20, var26), var26, var28);
            }
         }

         float var29 = 12.0F * this.v27;
         float var30 = uiSupport169.v2(var3 + var5 - 7.0F * this.v27, var29);
         float var31 = var2 + var4 - this.v2(10.0F);
         if (var6) {
            float var21 = this.v2(17.6F);
            float var22 = this.v2(11.0F);
            float var23 = var30 + 0.600625F * var29;
            GETSupport.Part16 var24 = var1.v1.v7();
            uiSupport169.v1(
               v1(var24),
               var31 - var21,
               var23 - var22 / 2.0F,
               var21,
               var22,
               var24 == GETSupport.Part16.FAILED ? cloudSupport19.v2() : cloudSupport19.v1(),
               uiRecord7.ZERO
            );
            var31 -= var21 + this.v2(4.0F);
         }

         float var32 = uiSupport169.v2("syky_sans", var1.v4, var29);
         uiSupport169.v1("syky_sans", var1.v4, var31 - var32, var30, var29, cloudSupport19.v3(var6));
         if (var1.v5) {
            float var33 = this.v2(11.0F);
            uiSupport169.v1(
               uiSupport143.v24,
               var31 - var32 - this.v2(3.0F) - var33,
               var30 + 0.600625F * var29 - var33 / 2.0F,
               var33,
               var33,
               cloudSupport19.v3(var6),
               uiRecord7.ZERO
            );
         }
      }
   }

   private void v1(YouSupport.Part3 var1, ReplyToSupport.Part2 var2, float var3, float var4, float var5, float var6) {
      boolean var7 = var1.v1();
      float var8 = var4 + this.v2(var1.v10);
      float var9 = this.v2(cloudSupport19.v165);
      float var10 = this.v2(14.0F);
      float var11 = this.v2(34.0F);
      float var12 = var3 + var10;
      float var13 = var8 + uiSupport169.v1((var9 - var11) / 2.0F);
      int var14 = cloudSupport19.v9(var7);
      uiRecord7 var15 = uiRecord7.v1(10.0F * this.v27);
      class_2960 var16 = var2.v2();
      if (var16 != null) {
         uiSupport169.v1(var16, var12, var13, var11, var11, var15);
      } else {
         uiSupport169.v1(var12, var13, var11, var11, var14, var15);
         float var17 = this.v2(22.0F);
         uiSupport169.v1(
            var2.v1(),
            var12 + uiSupport169.v1((var11 - var17) / 2.0F),
            var13 + uiSupport169.v1((var11 - var17) / 2.0F),
            var17,
            var17,
            cloudSupport19.v12(var7),
            uiRecord7.ZERO
         );
      }

      float var50 = var12 + var11 + this.v2(12.0F);
      float var18 = var3 + var5 - var10 - var50;
      float var19 = 38.0F * this.v27;
      float var20 = var8 + (var9 - var19) / 2.0F;
      float var21 = 16.0F * this.v27;
      String var22 = var2.v3();
      if (uiSupport169.v2("syky_sans_strong", var22, var21) > var18) {
         var22 = uiSupport116.v1("syky_sans_strong", var22, var18, var21);
      }

      uiSupport169.v1("syky_sans_strong", var22, var50, uiSupport169.v1(var20 + 19.0F * this.v27 / 2.0F, var21), var21, cloudSupport19.v10(var7));
      float var23 = 14.0F * this.v27;
      String var24 = var2.v4();
      if (uiSupport169.v2("syky_sans", var24, var23) > var18) {
         var24 = uiSupport116.v1("syky_sans", var24, var18, var23);
      }

      float var25 = var20 + 29.5F * this.v27;
      uiSupport169.v1("syky_sans", var24, var50, uiSupport169.v1(var25, var23), var23, cloudSupport19.v11(var7));
      float var26 = SignInSupport.v2(this.v27);
      float var27 = var4 + uiSupport169.v1(this.v2(var1.v10) + var9);
      uiSupport169.v1(var3 + var10, var27, var5 - 2.0F * var10, var26, var14, uiRecord7.ZERO);
      float var28 = var27 + var26;
      float var29 = var4 + var6 - var28;
      String var30 = var2.v5();
      boolean var31 = var2.v6();
      float var32 = 15.0F * this.v27;
      float var33 = uiSupport169.v2("syky_sans", var30, var32);
      uiSupport169.v1(
         "syky_sans",
         var30,
         var3 + (var5 - var33) / 2.0F,
         uiSupport169.v1(var28 + var29 / 2.0F, var32),
         var32,
         var31 ? cloudSupport19.v13(var7) : cloudSupport19.v1(var7, 0.0F)
      );
      float var34 = 12.0F * this.v27;
      float var35 = uiSupport169.v2("syky_sans", var1.v4, var34);
      float var36 = var1.v5 ? this.v2(11.0F) + this.v2(3.0F) : 0.0F;
      float var37 = var7 ? this.v2(4.0F) + this.v2(17.6F) : 0.0F;
      float var38 = this.v2(8.0F);
      float var39 = this.v2(20.0F);
      float var40 = var38 + var36 + var35 + var37 + var38;
      float var41 = this.v2(10.0F);
      float var42 = var3 + uiSupport169.v1(var5 - var41 - var40);
      float var43 = var4 + uiSupport169.v1(var6 - var41 - var39);
      uiSupport169.v1(var42, var43, var40, var39, var14, uiRecord7.v1(var39 / 2.0F));
      float var44 = uiSupport169.v1(var43 + var39 / 2.0F, var34);
      float var45 = var44 + 0.600625F * var34;
      float var46 = var42 + var38;
      if (var1.v5) {
         float var47 = this.v2(11.0F);
         uiSupport169.v1(uiSupport143.v24, var46, var45 - var47 / 2.0F, var47, var47, cloudSupport19.v3(var7), uiRecord7.ZERO);
         var46 += var36;
      }

      uiSupport169.v1("syky_sans", var1.v4, var46, var44, var34, cloudSupport19.v3(var7));
      if (var7) {
         float var51 = this.v2(17.6F);
         float var48 = this.v2(11.0F);
         GETSupport.Part16 var49 = var1.v1.v7();
         uiSupport169.v1(
            v1(var49),
            var46 + var35 + this.v2(4.0F),
            var45 - var48 / 2.0F,
            var51,
            var48,
            var49 == GETSupport.Part16.FAILED ? cloudSupport19.v2() : cloudSupport19.v1(),
            uiRecord7.ZERO
         );
      }
   }

   private ReplyToSupport.Part2 v2(YouSupport.Part3 var1) {
      GETSupport.Part14 var2 = var1.v1;
      GETSupport.Part1 var3 = var2.v11();
      if (var3 != null) {
         LANRecord var8 = this.v3(var3);
         boolean var9 = var8 != null && this.v1(var8, var3);
         String var10 = "Save waypoint";
         if (var8 != null && var9) {
            boolean var11 = var8.equals(this.v4.v5().v7());
            var10 = !var11 && var3.v7() != null && !uiSupport223.v5 ? "Saved for " + var3.v7() : "Saved";
         }

         return new ReplyToSupport.Part2(uiSupport143.v16, null, v1(var3), v2(var3), var10, var9);
      } else {
         GETSupport.Part7 var4 = Objects.requireNonNull(var2.v12());
         boolean var5 = this.v1(var4.v1(), var4.v2());
         String var6 = var4.v3();
         class_2960 var7 = var6 != null && !uiSupport223.v5 ? uiSupport52.v1(var6) : null;
         return new ReplyToSupport.Part2(
            uiSupport143.v52, var7, v1(var4), uiSupport223.v5 ? "Protected" : var4.v1(), var5 ? "You're here" : "Join server", var5
         );
      }
   }

   private static String v1(GETSupport.Part7 var0) {
      String var1 = var0.v2();
      return var1 != null && !uiSupport223.v5 ? var1 : "Server invite";
   }

   private static String v1(GETSupport.Part1 var0) {
      String var1 = var0.v7();
      return var1 != null && !uiSupport223.v5 ? var1 : "Coordinates";
   }

   private static String v2(GETSupport.Part1 var0) {
      String var1 = uiSupport223.v4 ? "Protected" : String.format(Locale.ROOT, "%,d  %,d  %,d", var0.v2(), var0.v3(), var0.v4());
      return var1 + " · " + EndSupport.v2(var0.v5());
   }

   private static String v1(GETSupport.Part14 var0) {
      return switch (var0.v1()) {
         case WORDS -> var0.v5();
         case PLACE -> "Coordinates";
         case INVITE -> "Server invite";
      };
   }

   private static class_2960 v1(GETSupport.Part16 var0) {
      return switch (var0) {
         case SENDING -> uiSupport143.v66;
         case SENT -> uiSupport143.v64;
         case READ -> uiSupport143.v61;
         case FAILED -> uiSupport143.v68;
      };
   }

   @Nullable
   private LANRecord v3(GETSupport.Part1 var1) {
      InternalSupport7 var2 = this.v4.v5();
      LANRecord var3 = var2.v8() ? var2.v7() : null;
      String var4 = var1.v6();
      if (var4 == null) {
         return var3;
      } else {
         return var3 != null && this.v1(var4, var1.v7()) ? var3 : LANRecord.v1(var4);
      }
   }

   private boolean v1(String var1, @Nullable String var2) {
      InternalSupport7 var3 = this.v4.v5();
      LANRecord var4 = var3.v8() ? var3.v7() : null;
      if (var4 == null) {
         return false;
      } else {
         String var5 = this.v4.v6();
         return var4.equals(LANRecord.v1(var1)) || !var5.isEmpty() && var5.equals(var2);
      }
   }

   private boolean v1(LANRecord var1, GETSupport.Part1 var2) {
      InternalSupport7 var3 = this.v4.v5();
      if (v1.contains(v2(var1, var2))) {
         return true;
      } else {
         List var4 = var1.equals(var3.v7()) ? var3.v11() : var3.v5().get(var1);
         if (var4 == null) {
            return false;
         } else {
            for (sykyRecord4 var6 : var4) {
               if (var6.v6() == var2.v2() && var6.v7() == var2.v3() && var6.v8() == var2.v4() && var6.v9().equals(var2.v5())) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   private static String v2(LANRecord var0, GETSupport.Part1 var1) {
      return var0.v1() + "|" + var1.v2() + "|" + var1.v3() + "|" + var1.v4() + "|" + var1.v5();
   }

   private boolean v1(YouSupport.Part3 var1, float var2, float var3) {
      if (!var1.v15) {
         return false;
      } else {
         float var4 = this.v6(var1);
         float var5 = this.v7(var1) + this.v2(var1.v12);
         return var2 >= var4 && var2 <= var4 + this.v2(var1.v11) && var3 >= var5 - this.v2(40.0F) && var3 <= var5;
      }
   }

   private void v3(YouSupport.Part3 var1) {
      GETSupport.Part1 var2 = var1.v1.v11();
      if (var2 != null) {
         LANRecord var3 = this.v3(var2);
         if (var3 == null) {
            this.v4.v3("Join a world to save this waypoint.");
         } else if (!this.v1(var3, var2)) {
            InternalSupport7 var4 = this.v4.v5();
            if (var4.v1(var3, var1.v1() ? "" : this.v7, var2.v2(), var2.v3(), var2.v4(), var2.v5()) == null) {
               this.v4.v3("This waypoint could not be saved.");
            } else if (!var3.equals(var4.v7())) {
               v1.add(v2(var3, var2));
            }
         }
      }
   }

   private void v4(YouSupport.Part3 var1) {
      if (var1.v1.v11() != null) {
         this.v3(var1);
      } else {
         GETSupport.Part7 var2 = var1.v1.v12();
         if (var2 != null && !this.v1(var2.v1(), var2.v2())) {
            String var3 = v1(var2);
            if (!cloudSupport17.v2()) {
               this.v1(var2, var3);
            } else {
               String var4 = uiSupport223.v5 ? "this server" : var2.v1();
               this.v1(
                  new uiSupport55.Part1(
                     uiSupport223.v5 ? "Join server" : "Join " + var3,
                     "You will leave the world you are in and connect to " + var4 + ".",
                     null,
                     false,
                     "Join",
                     uiSupport143.v52,
                     uiSupport53.Part2.ACCEPT
                  ),
                  var1.v1,
                  var3x -> this.v1(var2, var3)
               );
            }
         }
      }
   }

   private void v1(GETSupport.Part7 var1, String var2) {
      if (!cloudSupport17.v1(var1.v1(), var2)) {
         this.v4.v3("This server address can't be joined.");
      }
   }

   @Nullable
   private GETSupport.Part1 v36() {
      InternalSupport7 var1 = this.v4.v5();
      class_310 var2 = class_310.method_1551();
      class_746 var3 = var2 == null ? null : var2.field_1724;
      if (var1.v8() && var1.v7() != null && var3 != null && !var1.v10().isEmpty()) {
         class_2338 var4 = var3.method_24515();
         return new GETSupport.Part1(var4.method_10263(), var4.method_10264(), var4.method_10260(), var1.v10(), this.v38(), null);
      } else {
         return null;
      }
   }

   @Nullable
   private String v38() {
      InternalSupport7 var1 = this.v4.v5();
      LANRecord var2 = var1.v7();
      return var1.v8() && var2 != null && "server".equals(var2.v4()) ? var2.v5() : null;
   }

   private void v42() {
      String var1 = this.v66 != null ? "Finish the edit first" : null;
      String var2 = var1 != null ? var1 : (this.v36() == null ? "Join a world first" : null);
      String var3 = this.v38();
      String var4 = var1 != null ? var1 : (var3 == null ? "Join a server first" : (!cloudSupport17.v1(var3) ? "Only a public server can be shared" : null));
      List var5 = List.of(new AddNoteSupport.Part2(uiSupport143.v16, 22.0F, 22.0F, 0.0F, "Share coordinates", false, var2 == null, var2, false, () -> {
         this.v4.v4();
         this.v43();
      }), new AddNoteSupport.Part2(uiSupport143.v52, 22.0F, 22.0F, 0.0F, "Invite to server", false, var4 == null, var4, false, () -> {
         this.v4.v4();
         this.v37();
      }));
      uiSupport93 var6 = new uiSupport93(new AddNoteSupport(var5, this.v27));
      float var7 = var6.a_(624.0F) * this.v27;
      this.v4.v1(var6, this.v23.v9, this.v23.v10 - this.v2(10.0F) - var7);
   }

   private void v43() {
      GETSupport.Part1 var1 = this.v36();
      if (var1 != null && !this.v14() && this.v66 == null) {
         GETSupport.Part14 var2 = this.v40;
         this.v5.v1(this.v6, var1, var2 == null ? 0L : var2.v3());
         this.v40 = null;
         this.v44 = null;
         this.v147 = UiPopup.Part1.GLIDE;
      }
   }

   private void v37() {
      String var1 = this.v38();
      if (var1 != null && cloudSupport17.v1(var1) && !this.v14() && this.v66 == null) {
         GETSupport.Part14 var2 = this.v40;
         this.v5.v1(this.v6, var1, cloudSupport17.v1(), var2 == null ? 0L : var2.v3());
         this.v40 = null;
         this.v44 = null;
         this.v147 = UiPopup.Part1.GLIDE;
      }
   }

   private void v1(YouSupport.Part3 var1, GETSupport.Part18 var2, float var3, float var4, float var5) {
      boolean var6 = var1.v1();
      float var7 = this.v2(6.0F);
      float var8 = var3 + var7;
      float var9 = var4 + var7;
      float var10 = var5 - 2.0F * var7;
      float var11 = this.v2(44.0F);
      uiRecord7 var12 = uiRecord7.v1(10.5F * this.v27);
      uiSupport169.v1(var8, var9, var10, var11, cloudSupport19.v4(var6), var12);
      uiSupport169.v6(var8, var9, this.v2(3.0F), var11);

      try {
         uiSupport169.v1(var8, var9, var10, var11, cloudSupport19.v5(var6), var12);
      } finally {
         uiSupport169.v17();
      }

      float var13 = 14.0F * this.v27;
      float var14 = var8 + this.v2(11.0F);
      float var15 = var10 - this.v2(21.0F);
      float var16 = var9 + 12.5F * this.v27;
      uiSupport169.v1("syky_sans_strong", var1.v9, var14, uiSupport169.v1(var16, var13), var13, cloudSupport19.v6(var6));
      String var17 = YouSupport.v1(YouSupport.v1(var2));
      if (uiSupport169.v2("syky_sans", var17, var13) > var15) {
         var17 = uiSupport116.v1("syky_sans", var17, var15, var13);
      }

      float var18 = var9 + 30.0F * this.v27;
      uiSupport169.v1("syky_sans", var17, var14, uiSupport169.v1(var18, var13), var13, cloudSupport19.v7(var6));
   }

   private boolean v48() {
      return this.v49 != null && this.v47 != null && (!this.v49.equals(this.v47) || this.v46 != this.v50 || this.v51 != this.v60);
   }

   private void v40() {
      this.v49 = null;
      this.v47 = null;
      this.v59 = false;
   }

   private int v1(@Nullable String var1) {
      if (var1 == null) {
         return -1;
      } else {
         for (int var2 = 0; var2 < this.v117.v1.size(); var2++) {
            if (this.v117.v1.get(var2).v1.v2().equals(var1)) {
               return var2;
            }
         }

         return -1;
      }
   }

   @Nullable
   private int[] v44() {
      int var1 = this.v1(this.v47);
      int var2 = this.v1(this.v49);
      if (var1 >= 0 && var2 >= 0 && this.v48()) {
         boolean var3 = var1 < var2 || var1 == var2 && (this.v46 < this.v50 || this.v46 == this.v50 && this.v51 <= this.v60);
         return var3 ? new int[]{var1, this.v46, this.v51, var2, this.v50, this.v60} : new int[]{var2, this.v50, this.v60, var1, this.v46, this.v51};
      } else {
         return null;
      }
   }

   @Nullable
   private int[] v1(int var1) {
      int[] var2 = this.v44();
      if (var2 != null && var1 >= var2[0] && var1 <= var2[3]) {
         YouSupport.Part3 var3 = this.v117.v1.get(var1);
         if (var3.v15) {
            return null;
         } else {
            int var4 = var3.v2.size() - 1;
            int var5 = var1 == var2[0] ? var2[1] : 0;
            int var6 = var1 == var2[0] ? var2[2] : 0;
            int var7 = var1 == var2[3] ? var2[4] : var4;
            int var8 = var1 == var2[3] ? var2[5] : var3.v2.get(var4).length();
            return new int[]{var5, var6, var7, var8};
         }
      } else {
         return null;
      }
   }

   private boolean v47() {
      int[] var1 = this.v44();
      return var1 != null && var1[0] == var1[3];
   }

   private String v49() {
      int[] var1 = this.v44();
      if (var1 == null) {
         return "";
      } else {
         ArrayList var2 = new ArrayList();
         ArrayList var3 = new ArrayList();

         for (int var4 = var1[0]; var4 <= var1[3]; var4++) {
            int[] var5 = this.v1(var4);
            if (var5 != null) {
               YouSupport.Part3 var6 = this.v117.v1.get(var4);
               var2.add(var6.v1);
               var3.add(var6.v1(var5[0], var5[1], var5[2], var5[3]));
            }
         }

         return this.v1(var2, var3);
      }
   }

   private String v1(List<GETSupport.Part14> var1, List<String> var2) {
      if (var2.size() == 1) {
         return (String)var2.getFirst();
      } else {
         SykySession.Part1 var3 = SykySession.v1();
         String var4 = var3 == null ? "You" : var3.v2();
         StringBuilder var5 = new StringBuilder();

         for (int var6 = 0; var6 < var2.size(); var6++) {
            if (var6 > 0) {
               var5.append("\n\n");
            }

            var5.append(((GETSupport.Part14)var1.get(var6)).v4() ? var4 : this.v7).append(":\n").append((String)var2.get(var6));
         }

         return var5.toString();
      }
   }

   private boolean v5(YouSupport.Part3 var1) {
      return this.v1(this.v1(var1.v1.v2())) != null;
   }

   private float[] v1(YouSupport.Part3 var1, int var2, float var3) {
      String var4 = var1.v2.get(var2);
      float[] var5 = new float[var4.length() + 1];
      uiSupport169.v1("syky_sans", var4, var3, var5);
      return var5;
   }

   private void v1(YouSupport.Part3 var1, int[] var2, float var3, float var4, float var5) {
      int var6 = cloudSupport19.v8(var1.v1());

      for (int var7 = var2[0]; var7 <= var2[2] && var7 < var1.v2.size(); var7++) {
         float[] var8 = this.v1(var1, var7, var5);
         int var9 = var1.v2.get(var7).length();
         int var10 = var7 == var2[0] ? Math.min(var2[1], var9) : 0;
         int var11 = var7 == var2[2] ? Math.min(var2[3], var9) : var9;
         float var12 = var3 + var8[var10];
         float var13 = var3 + var8[var11] + (var7 < var2[2] ? var5 * 0.25F : 0.0F);
         if (!(var13 <= var12)) {
            float var14 = var4 + (var1.v10 + var7 * 21.0F) * this.v27;
            uiSupport169.v1(var12, var14, var13 - var12, 21.0F * this.v27, var6, uiRecord7.ZERO);
         }
      }
   }

   private float v6(YouSupport.Part3 var1) {
      return this.v32() + this.v2(var1.v14) + (var1.v1() ? 0.0F : this.v23());
   }

   private float v46() {
      return this.v138 + this.v191 + this.v2(this.v1(this.v117)) + this.v51();
   }

   private float v51() {
      if (this.v137) {
         return 0.0F;
      } else {
         float var1 = this.v4.v8();
         float var2;
         if (this.v93 >= 0.0F) {
            var2 = Math.max(0.0F, var1 - this.v93 * this.v27);
         } else {
            if (this.v147 != UiPopup.Part1.JUMP) {
               return 0.0F;
            }

            var2 = var1;
         }

         return this.v4.v7() - var2;
      }
   }

   private float v7(YouSupport.Part3 var1) {
      return this.v46() + this.v2(var1.v13);
   }

   private boolean v2(YouSupport.Part3 var1, float var2, float var3) {
      if (var1.v15) {
         return false;
      } else {
         float var4 = this.v6(var1);
         float var5 = this.v7(var1) + var1.v10 * this.v27;
         return var2 >= var4 && var2 <= var4 + this.v2(var1.v11) && var3 >= var5 && var3 <= var5 + var1.v2.size() * 21.0F * this.v27;
      }
   }

   @Nullable
   private YouSupport.Part3 v4(float var1) {
      YouSupport.Part3 var2 = null;
      float var3 = Float.MAX_VALUE;

      for (YouSupport.Part3 var5 : this.v117.v1) {
         if (!var5.v15) {
            float var6 = this.v7(var5);
            float var7 = var6 + this.v2(var5.v12);
            float var8 = var1 < var6 ? var6 - var1 : (var1 > var7 ? var1 - var7 : 0.0F);
            if (var8 < var3) {
               var3 = var8;
               var2 = var5;
            }
         }
      }

      return var2;
   }

   private int[] v3(YouSupport.Part3 var1, float var2, float var3) {
      float var4 = 16.0F * this.v27;
      float var5 = this.v7(var1) + var1.v10 * this.v27;
      int var6 = (int)Math.floor((var3 - var5) / (21.0F * this.v27));
      if (var6 < 0) {
         return new int[]{0, 0};
      } else if (var6 >= var1.v2.size()) {
         int var12 = var1.v2.size() - 1;
         return new int[]{var12, var1.v2.get(var12).length()};
      } else {
         float[] var7 = this.v1(var1, var6, var4);
         float var8 = var2 - (this.v6(var1) + this.v2(12.0F));
         String var9 = var1.v2.get(var6);
         int var10 = 0;

         while (var10 < var9.length()) {
            int var11 = var10 + Character.charCount(var9.codePointAt(var10));
            if (var8 < (var7[var10] + var7[var11]) / 2.0F) {
               return new int[]{var6, var10};
            }

            var10 = var11;
         }

         return new int[]{var6, var9.length()};
      }
   }

   private void v4(YouSupport.Part3 var1, float var2, float var3) {
      boolean var4 = this.v82 - this.v53 <= 400L && Math.abs(var2 - this.v63) <= 3.0F && Math.abs(var3 - this.v64) <= 3.0F && var1.v1.v2().equals(this.v49);
      this.v61 = var4 ? this.v61 % 3 + 1 : 1;
      this.v53 = this.v82;
      this.v63 = var2;
      this.v64 = var3;
      int[] var5 = this.v3(var1, var2, var3);
      this.v49 = var1.v1.v2();
      this.v47 = this.v49;
      this.v43.v3(false);
      switch (this.v61) {
         case 2:
            String var9 = var1.v2.get(var5[0]);
            int var7 = Math.min(var5[1], var9.length());
            int var8 = var7;

            while (var7 > 0 && !Character.isWhitespace(var9.charAt(var7 - 1))) {
               var7--;
            }

            while (var8 < var9.length() && !Character.isWhitespace(var9.charAt(var8))) {
               var8++;
            }

            this.v46 = var5[0];
            this.v51 = var7;
            this.v50 = var5[0];
            this.v60 = var8;
            this.v59 = false;
            break;
         case 3:
            int var6 = var1.v2.size() - 1;
            this.v46 = 0;
            this.v51 = 0;
            this.v50 = var6;
            this.v60 = var1.v2.get(var6).length();
            this.v59 = false;
            break;
         default:
            this.v46 = var5[0];
            this.v51 = var5[1];
            this.v50 = var5[0];
            this.v60 = var5[1];
            this.v59 = true;
      }
   }

   private boolean v5(YouSupport.Part3 var1, float var2, float var3) {
      if (var1.v1.v8() == null) {
         return false;
      } else {
         float var4 = this.v46();
         float var5 = this.v32() + this.v2(var1.v14) + (var1.v1() ? 0.0F : this.v23()) + this.v2(6.0F);
         float var6 = var4 + this.v2(var1.v13) + this.v2(6.0F);
         float var7 = this.v2(var1.v11) - 2.0F * this.v2(6.0F);
         return var2 >= var5 && var2 <= var5 + var7 && var3 >= var6 && var3 <= var6 + this.v2(44.0F);
      }
   }

   private void v5(float var1) {
      GETSupport.Part15 var2 = this.v5.v3(this.v6);
      float var3 = this.v138 + this.v2(70.0F);
      float var4 = (var3 + this.v27()) / 2.0F + var1;
      if (var2 != GETSupport.Part15.READY) {
         String var16 = var2 == GETSupport.Part15.FAILED ? this.v5.v4(this.v6) : "Loading...";
         float var17 = 15.0F * this.v27;
         float var18 = uiSupport169.v2("syky_sans", var16, var17);
         uiSupport169.v1("syky_sans", var16, this.v187 + (this.v106 - var18) / 2.0F, uiSupport169.v1(var4, var17), var17, cloudSupport19.v9());
      } else {
         float var5 = Math.max(0.0F, this.v106 / this.v27 - 240.0F);
         if (var5 != this.v107) {
            this.v107 = var5;
            this.v162 = InternalSupport25.v1(
               "The start of your chat. Messages stay for 180 days, and only the two of you can read them.",
               var5,
               var0 -> uiSupport169.v2("syky_sans", var0, 15.0F)
            );
         }

         float var6 = 113.0F + this.v162.size() * 21.0F;
         float var7 = var4 - var6 * this.v27 / 2.0F;
         float var8 = this.v2(64.0F);
         uiSupport122.v1(
            this.v4.v1().v1(this.v6, this.v9),
            this.v8,
            this.v187 + uiSupport169.v1((this.v106 - var8) / 2.0F),
            var7,
            var8,
            uiRecord7.v1(var8 / 2.0F),
            SignInSupport.v19(),
            28.0F * this.v27,
            1.0F
         );
         float var9 = var7 + 78.0F * this.v27;
         float var10 = 20.0F * this.v27;
         float var11 = uiSupport169.v2("syky_sans_strong", this.v7, var10);
         uiSupport169.v1(
            "syky_sans_strong",
            this.v7,
            this.v187 + (this.v106 - var11) / 2.0F,
            uiSupport169.v1(var9 + 21.0F * this.v27 / 2.0F, var10),
            var10,
            cloudSupport19.v8()
         );
         var9 += 35.0F * this.v27;
         float var12 = 15.0F * this.v27;

         for (String var14 : this.v162) {
            float var15 = uiSupport169.v2("syky_sans", var14, var12);
            uiSupport169.v1(
               "syky_sans", var14, this.v187 + (this.v106 - var15) / 2.0F, uiSupport169.v1(var9 + 21.0F * this.v27 / 2.0F, var12), var12, cloudSupport19.v9()
            );
            var9 += 21.0F * this.v27;
         }
      }
   }

   private void v50() {
      float var1 = this.v2(38.0F);
      float var2 = this.v138 + this.v2(16.0F);
      float var3 = this.v187 + this.v2(16.0F);
      float var4 = this.v187 + this.v106 - this.v2(16.0F);
      this.v28.v1(var3, var2, var1, var1);
      this.v29.v1(var4 - var1, var2, var1, var1);
      float var5 = this.v2(this.v30.v6());
      this.v30.v1(this.v29.v9 - this.v2(10.0F) - var5, var2, var5, var1);
      this.v36.v1(var3, var2, var1, var1);
      float var6 = this.v2(this.v42.v6());
      this.v42.v1(var4 - var6, var2, var6, var1);
      float var7 = this.v2(this.v38.v6());
      this.v38.v1(var4 - var6 - this.v2(10.0F) - var7, var2, var7, var1);
      float var8 = this.v2(30.0F);
      float var9 = this.v138 + this.v2(74.0F);
      this.v34.v1(var4 - this.v2(8.0F) - var8, var9 + uiSupport169.v1((this.v2(46.0F) - var8) / 2.0F), var8, var8);
      float var10 = this.v26();
      float var11 = this.v2(32.0F);
      float var12 = this.v29() - this.v2(5.0F) - var11;
      this.v32.v1(var12, var10 - this.v2(5.0F) - var11, var11, var11);
      float var13 = this.v27();
      float var14 = this.v2(28.0F);
      float var15 = var13 + 26.5F * this.v27;
      this.v31.v1(this.v29() - this.v2(8.0F) - var14, uiSupport169.v1(var15 - var14 / 2.0F), var14, var14);
      this.v23.v1(this.v28() + this.v2(5.0F), this.v32.v10, var11, var11);
      float var16 = this.v23.v9 + var11 + this.v2(8.0F);
      float var17 = Math.max(0.0F, var12 - this.v2(8.0F) - var16);
      float var18 = 22.0F * this.v27;
      float var19 = 17.0F * this.v27;
      this.v43.v1(var18, 6);
      this.v43.v1(var19, uiSupport169.v1(var18 / 2.0F, var19), 1.0F * this.v27);
      float var20 = var13 + this.v2((this.v22() ? 46.0F : 0.0F) + 10.0F);
      this.v43.v1(var16, var20, var17, this.v159 * var18);
      int var21 = cloudSupport16.v2();
      this.v43.v1(var21, cloudSupport16.v1(), SignInSupport.v31(), var21);
      float var22 = this.v2(38.0F);
      this.v33.v1(this.v29() - var22, this.v27() - this.v2(10.0F) - var22, var22, var22);
      float var23 = this.v29() - this.v2(5.0F);
      List var24 = this.v13();

      for (int var25 = var24.size() - 1; var25 >= 0; var25--) {
         uiSupport53 var26 = (uiSupport53)var24.get(var25);
         float var27 = this.v2(var26.v6());
         var26.v1(var23 - var27, this.v32.v10, var27, var11);
         var23 = var26.v9 - this.v2(8.0F);
      }
   }

   @Nullable
   private uiSupport53 v5(float var1, float var2) {
      for (uiSupport53 var4 : this.v13()) {
         if (var4.v1(var1, var2)) {
            return var4;
         }
      }

      return null;
   }

   private boolean v6(float var1, float var2) {
      float var3 = this.v187 + this.v2(66.0F);
      float var4 = this.v187 + this.v2(116.0F);
      float var5 = var4 + Math.max(uiSupport169.v2("syky_sans_strong", this.v7, 18.0F * this.v27), uiSupport169.v2("syky_sans", this.v24, 15.0F * this.v27));
      float var6 = this.v138 + this.v2(16.0F);
      float var7 = (this.v15() ? this.v30.v9 : this.v29.v9) - this.v2(8.0F);
      return var1 >= var3 && var1 <= Math.min(var5, var7) && var2 >= var6 && var2 <= var6 + this.v2(38.0F);
   }

   private boolean v7(float var1, float var2) {
      return var1 >= this.v28() && var1 <= this.v29() && var2 >= this.v27() && var2 <= this.v26();
   }

   private float v60() {
      return this.v187 + this.v2(16.0F);
   }

   private float v59() {
      return this.v187 + this.v106 - this.v2(16.0F);
   }

   private boolean v8(float var1, float var2) {
      float var3 = this.v138 + this.v2(74.0F);
      return this.v176 && var1 >= this.v60() && var1 <= this.v59() && var2 >= var3 && var2 <= var3 + this.v2(46.0F);
   }

   private boolean v53() {
      return this.v37.v2() > 0.5F;
   }

   public void v1(uiSupport35 var1, float var2) {
      if (!(var2 <= 0.0F)) {
         if (var2 < 1.0F && uiSupport169.v5()) {
            try {
               this.v2(var1.v1());
            } finally {
               uiSupport169.v2(var2);
            }
         } else {
            this.v2(var1);
         }
      }
   }

   private void v2(uiSupport35 var1) {
      this.v50();
      uiSupport35 var2 = this.v4.v2() ? var1.v1() : var1;
      this.v63();
      if (this.v176) {
         this.v6(var2);
      }

      if (this.v52) {
         this.v5(var2);
      } else {
         this.v4(var2);
      }

      float var3 = this.v28();
      float var4 = this.v27();
      v1(var3, var4, this.v29() - var3, this.v26() - var4, this.v30(), this.v27);
      if (this.v14()) {
         this.v3(var2);
      } else {
         if (this.v22()) {
            this.v7(var2);
         }

         this.v43.v1(var2);
         this.v23.v1(var2);
         this.v32.v1(var2);
      }

      float var5 = hudSupport60.v1(this.v37.v2());
      if (var5 > 0.0F) {
         this.v2(var2, var5);
      }
   }

   private void v3(uiSupport35 var1) {
      List var2 = this.v13();
      float var3 = this.v28() + this.v2(18.0F);
      float var4 = (var2.isEmpty() ? this.v29() - this.v2(5.0F) : ((uiSupport53)var2.getFirst()).v9) - this.v2(8.0F);
      float var5 = 17.0F * this.v27;
      float var6 = Math.max(0.0F, var4 - var3);
      if (this.v12 != this.v17 || this.v13 != this.v20 || !this.v7.equals(this.v21) || var6 != this.v22) {
         this.v17 = this.v12;
         this.v20 = this.v13;
         this.v21 = this.v7;
         this.v22 = var6;
         String var7 = this.v16();
         this.v19 = uiSupport169.v2("syky_sans_strong", var7, var5) <= var6 ? var7 : uiSupport116.v1("syky_sans_strong", var7, var6, var5);
      }

      float var10 = this.v27() + this.v2(10.0F) + 22.0F * this.v27 / 2.0F;
      uiSupport169.v1("syky_sans_strong", this.v19, var3, uiSupport169.v1(var10, var5), var5, cloudSupport16.v1());

      for (uiSupport53 var9 : var2) {
         var9.v1(var1);
      }
   }

   private void v4(uiSupport35 var1) {
      this.v28.v1(var1);
      this.v29.v1(var1);
      if (this.v15()) {
         this.v30.v1(var1);
      }

      float var2 = this.v2(38.0F);
      float var3 = this.v138 + this.v2(16.0F);
      uiSupport122.v1(
         this.v4.v1().v1(this.v6, this.v9),
         this.v8,
         this.v187 + this.v2(66.0F),
         var3,
         var2,
         uiRecord7.v1(var2 / 2.0F),
         SignInSupport.v19(),
         17.0F * this.v27,
         1.0F
      );
      GETSupport2.Part2 var4 = this.v10;
      if (var4 != null && var4.v5()) {
         float var5 = this.v2(14.0F);
         uiSupport169.v1(this.v187 + this.v2(66.0F) + var2 - var5, var3 + var2 - var5, var5, var5, -8126666, uiRecord7.v1(var5 / 2.0F));
      }

      float var10 = 40.0F;
      float var6 = this.v138 + (70.0F - var10) / 2.0F * this.v27;
      float var7 = this.v187 + this.v2(116.0F);
      float var8 = 18.0F * this.v27;
      float var9 = 15.0F * this.v27;
      uiSupport169.v1("syky_sans_strong", this.v7, var7, uiSupport169.v1(var6 + 21.0F * this.v27 / 2.0F, var8), var8, cloudSupport19.v8());
      uiSupport169.v1("syky_sans", this.v24, var7, uiSupport169.v1(var6 + 31.0F * this.v27, var9), var9, cloudSupport19.v9());
   }

   private void v5(uiSupport35 var1) {
      this.v36.v1(var1);
      this.v38.v1(var1);
      this.v42.v1(var1);
      float var2 = 18.0F * this.v27;
      uiSupport169.v1(
         "syky_sans_strong",
         this.v75.size() + " selected",
         this.v187 + this.v2(66.0F),
         uiSupport169.v1(this.v138 + 70.0F * this.v27 / 2.0F, var2),
         var2,
         cloudSupport19.v8()
      );
   }

   private void v6(uiSupport35 var1) {
      List var2 = this.v80();
      if (!var2.isEmpty()) {
         int var3 = this.v2(var2);
         GETSupport.Part6 var4 = (GETSupport.Part6)var2.get(var3);
         float var5 = this.v60();
         float var6 = this.v138 + this.v2(74.0F);
         float var7 = this.v59() - var5;
         float var8 = this.v2(46.0F);
         v1(var5, var6, var7, var8, uiRecord7.v1(14.0F * this.v27), this.v27);
         int var9 = Math.min(var2.size(), 4);
         int var10 = Math.max(0, Math.min(var3 - (var9 - 2), var2.size() - var9));
         float var11 = this.v2(30.0F);
         float var12 = 2.0F * this.v27;
         float var13 = (var11 - var12 * (var9 - 1)) / var9;
         float var14 = var5 + this.v2(12.0F);
         float var15 = var6 + (var8 - var11) / 2.0F;
         float var16 = this.v2(3.0F);

         for (int var17 = 0; var17 < var9; var17++) {
            boolean var18 = var10 + var17 == var3;
            uiSupport169.v1(
               var14,
               var15 + var17 * (var13 + var12),
               var16,
               var13,
               var18 ? cloudSupport19.v4() : uiSupport155.v1(cloudSupport19.v4(), 0.35F),
               uiRecord7.v1(var16 / 2.0F)
            );
         }

         float var23 = 14.0F * this.v27;
         float var24 = var5 + this.v2(25.0F);
         float var19 = this.v34.v9 - this.v2(8.0F) - var24;
         float var20 = var6 + (var8 - 35.0F * this.v27) / 2.0F;
         String var21 = var2.size() > 1 ? "Pinned message #" + (var3 + 1) : "Pinned message";
         uiSupport169.v1("syky_sans_strong", var21, var24, uiSupport169.v1(var20 + 17.0F * this.v27 / 2.0F, var23), var23, cloudSupport19.v4());
         String var22 = YouSupport.v1(v1(var4.v1()));
         if (uiSupport169.v2("syky_sans", var22, var23) > var19) {
            var22 = uiSupport116.v1("syky_sans", var22, var19, var23);
         }

         uiSupport169.v1("syky_sans", var22, var24, uiSupport169.v1(var20 + 26.0F * this.v27, var23), var23, cloudSupport19.v8());
         this.v34.v1(var1);
      }
   }

   private void v7(uiSupport35 var1) {
      GETSupport.Part14 var2 = this.v66;
      GETSupport.Part14 var3 = var2 != null ? var2 : this.v40;
      if (var3 != null) {
         float var4 = this.v28();
         float var5 = this.v27();
         float var6 = var5 + this.v2(9.0F);
         float var7 = 35.0F * this.v27;
         float var8 = this.v2(20.0F);
         uiSupport169.v1(
            var2 != null ? uiSupport143.v26 : uiSupport143.v50,
            uiSupport169.v1(var4 + this.v2(16.0F) + (this.v2(22.0F) - var8) / 2.0F),
            uiSupport169.v1(var6 + (var7 - var8) / 2.0F),
            var8,
            var8,
            cloudSupport19.v4(),
            uiRecord7.ZERO
         );
         float var9 = this.v2(3.0F);
         uiSupport169.v1(var4 + this.v2(50.0F), var6, var9, var7, cloudSupport19.v4(), uiRecord7.v1(var9 / 2.0F));
         float var10 = 14.0F * this.v27;
         float var11 = var4 + this.v2(65.0F);
         float var12 = this.v31.v9 - this.v2(8.0F) - var11;
         String var13 = var2 != null ? "Edit message" : "Reply to " + (var3.v4() ? "You" : this.v7);
         uiSupport169.v1("syky_sans_strong", var13, var11, uiSupport169.v1(var6 + 17.0F * this.v27 / 2.0F, var10), var10, cloudSupport19.v4());
         String var14 = var2 == null ? this.v44 : null;
         String var15 = YouSupport.v1(var14 != null ? var14 : v1(var3));
         if (uiSupport169.v2("syky_sans", var15, var10) > var12) {
            var15 = uiSupport116.v1("syky_sans", var15, var12, var10);
         }

         uiSupport169.v1("syky_sans", var15, var11, uiSupport169.v1(var6 + 26.0F * this.v27, var10), var10, cloudSupport19.v7(false));
         this.v31.v1(var1);
      }
   }

   private void v63() {
      List var1 = this.v117.v2;
      if (!var1.isEmpty() && !this.v117.v1.isEmpty()) {
         float var2 = this.v46();
         float var3 = this.v176 ? 128.0F : 82.0F;
         float var4 = this.v138 + this.v25() + this.v2(var3);
         float var5 = this.v2(25.0F);
         float var6 = 13.0F * this.v27;
         float var7 = this.v27();
         uiRecord7 var8 = uiRecord7.v1(12.5F * this.v27);
         uiSupport169.v6(this.v187, this.v138, this.v106, Math.max(0.0F, var7 - this.v138));

         try {
            for (int var9 = 0; var9 < var1.size(); var9++) {
               YouSupport.Part2 var10 = (YouSupport.Part2)var1.get(var9);
               float var11 = Math.max(var2 + this.v2(var10.v3()), var4);
               if (var9 + 1 < var1.size()) {
                  var11 = Math.min(var11, var2 + this.v2(((YouSupport.Part2)var1.get(var9 + 1)).v3()) - var5 - this.v2(14.0F));
               }

               float var12 = var11 >= var4 ? 1.0F : Math.max(0.0F, (var11 - (var4 - var5)) / var5);
               if (!(var12 <= 0.0F) && !(var11 > var7)) {
                  float var13 = this.v2(var10.v2());
                  float var14 = this.v187 + uiSupport169.v1((this.v106 - var13) / 2.0F);
                  boolean var15 = var12 < 1.0F && uiSupport169.v5();

                  try {
                     uiSupport97.v1(var14, var11, var13, var5, var8, uiSupport97.v1());
                     uiSupport169.v1(var14, var11, var13, var5, SignInSupport.v26(), var8);
                     float var16 = uiSupport169.v2("syky_sans", var10.v1(), var6);
                     uiSupport169.v1(
                        "syky_sans", var10.v1(), var14 + (var13 - var16) / 2.0F, uiSupport169.v1(var11 + var5 / 2.0F, var6), var6, cloudSupport19.v3()
                     );
                  } finally {
                     if (var15) {
                        uiSupport169.v2(var12);
                     }
                  }
               }
            }
         } finally {
            uiSupport169.v17();
         }
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, float var5) {
      uiSupport97.v1(var0, var1, var2, var3, var4, uiSupport97.v1());
      uiSupport169.v1(var0, var1, var2, var3, SignInSupport.v26(), var4);
      uiSupport169.v1(var0, var1, var2, var3, SignInSupport.v1(SignInSupport.v27(), var5), SignInSupport.v2(var5), var4, 1.0F);
   }

   private void v2(uiSupport35 var1, float var2) {
      boolean var3 = var2 < 1.0F && uiSupport169.v5();

      try {
         this.v33.v1(var1);
         if (this.v48 > 0) {
            uiSupport51.v1(this.v33.v9 + this.v33.v11 + this.v2(9.0F) / 2.0F, this.v33.v10 - this.v2(7.0F), Math.min(this.v48, 99), this.v27, 1.0F);
         }
      } finally {
         if (var3) {
            float var6 = 0.6F + 0.39999998F * var2;
            uiSupport169.v1(var2, this.v33.v9 + this.v33.v11 / 2.0F, this.v33.v10 + this.v33.v12 / 2.0F, var6, var6, 0.0F);
         }
      }
   }

   public boolean v1(float var1, float var2) {
      this.v50();
      boolean var3 = this.v52
         ? this.v36.v1(var1, var2) || this.v38.v1(var1, var2) || this.v42.v1(var1, var2)
         : this.v28.v1(var1, var2) || this.v29.v1(var1, var2) || this.v15() && this.v30.v1(var1, var2) || this.v6(var1, var2);
      return var3 || this.v8(var1, var2) || this.v7(var1, var2) || this.v53() && this.v33.v1(var1, var2);
   }

   private void v64() {
      String var1 = this.v43.v2().strip();
      if (!var1.isEmpty() && !this.v14()) {
         GETSupport.Part14 var2 = this.v66;
         if (var2 != null) {
            this.v5.v1(this.v6, var2.v3(), var1, this.v4::v3);
            this.v61();
         } else {
            GETSupport.Part14 var3 = this.v40;
            this.v5.v1(this.v6, var1, var3 == null ? 0L : var3.v3(), var3 == null ? null : this.v44);
            this.v40 = null;
            this.v44 = null;
            this.v43.v2("");
            this.v147 = UiPopup.Part1.GLIDE;
            this.v48 = 0;
         }
      }
   }

   private void v2(GETSupport.Part14 var1) {
      this.v1(var1, null);
   }

   private void v1(GETSupport.Part14 var1, @Nullable String var2) {
      if (this.v66 != null) {
         this.v61();
      }

      this.v40 = var1;
      this.v44 = var2;
      this.v40();
      this.v43.v3(true);
   }

   private void v3(GETSupport.Part14 var1) {
      if (this.v66 == null) {
         this.v68 = this.v43.v2();
      }

      this.v40 = null;
      this.v66 = var1;
      this.v43.v2(var1.v5());
      this.v43.v3(true);
   }

   private void v61() {
      if (this.v66 != null) {
         this.v66 = null;
         this.v43.v2(this.v68);
         this.v68 = "";
      }
   }

   private void v66() {
      if (this.v66 != null) {
         this.v61();
      } else {
         this.v40 = null;
         this.v44 = null;
      }
   }

   @Nullable
   private GETSupport.Part14 v68() {
      for (int var1 = this.v117.v1.size() - 1; var1 >= 0; var1--) {
         GETSupport.Part14 var2 = this.v117.v1.get(var1).v1;
         if (var2.v4() && this.v5.v1(var2)) {
            return var2;
         }
      }

      return null;
   }

   private void v4(GETSupport.Part14 var1) {
      this.v52 = true;
      this.v75.add(var1.v2());
      this.v43.v3(false);
   }

   private void v52() {
      this.v52 = false;
      this.v96 = false;
      this.v75.clear();
   }

   private void v8(YouSupport.Part3 var1) {
      this.v85 = new LinkedHashSet<>(this.v75);
      this.v105 = !this.v75.contains(var1.v1.v2());
      this.v87 = var1.v1.v2();
      this.v96 = true;
      this.v6(this.v98);
   }

   private void v6(float var1) {
      int var2 = this.v1(this.v87);
      YouSupport.Part3 var3 = this.v7(var1);
      if (var2 >= 0 && var3 != null) {
         int var4 = this.v117.v1.indexOf(var3);
         this.v75.clear();
         this.v75.addAll(this.v85);

         for (int var5 = Math.min(var2, var4); var5 <= Math.max(var2, var4); var5++) {
            String var6 = this.v117.v1.get(var5).v1.v2();
            if (this.v105) {
               this.v75.add(var6);
            } else {
               this.v75.remove(var6);
            }
         }
      }
   }

   private void v75() {
      this.v96 = false;
      this.v85 = Set.of();
      if (this.v75.isEmpty()) {
         this.v52 = false;
      }
   }

   @Nullable
   private YouSupport.Part3 v7(float var1) {
      float var2 = Math.max(this.v138 + this.v2(this.v24()), Math.min(this.v27() - 1.0F, var1));
      float var3 = this.v46();
      YouSupport.Part3 var4 = null;
      float var5 = Float.MAX_VALUE;

      for (int var6 = 0; var6 < this.v117.v1.size(); var6++) {
         float[] var7 = this.v1(var6, var3);
         float var8 = var2 < var7[0] ? var7[0] - var2 : (var2 >= var7[1] ? var2 - var7[1] : 0.0F);
         if (var8 < var5) {
            var5 = var8;
            var4 = this.v117.v1.get(var6);
         }
      }

      return var4;
   }

   private void v5(long var1) {
      if ((this.v96 || this.v59) && var1 > 0L && !this.v117.v1.isEmpty()) {
         float var3 = this.v2(36.0F);
         float var4 = this.v138 + this.v2(this.v24());
         float var5 = this.v27();
         float var6 = 0.0F;
         if (this.v98 < var4 + var3) {
            var6 = -Math.min(1.0F, (var4 + var3 - this.v98) / var3);
         } else if (this.v98 > var5 - var3) {
            var6 = Math.min(1.0F, (this.v98 - (var5 - var3)) / var3);
         }

         if (var6 != 0.0F) {
            this.v116 = this.v116 + var6 * 900.0F * this.v27 * (float)var1 / 1000.0F;
            if (this.v96) {
               this.v6(this.v98);
            } else {
               this.v11(this.v119, this.v98);
            }
         }
      }
   }

   private void v5(GETSupport.Part14 var1) {
      if (!this.v75.remove(var1.v2())) {
         this.v75.add(var1.v2());
      }

      if (this.v75.isEmpty()) {
         this.v52 = false;
      }
   }

   private List<GETSupport.Part14> v73() {
      ArrayList var1 = new ArrayList(this.v75.size());

      for (YouSupport.Part3 var3 : this.v117.v1) {
         if (this.v75.contains(var3.v1.v2())) {
            var1.add(var3.v1);
         }
      }

      return var1;
   }

   private void v74() {
      List var1 = this.v73();
      ArrayList var2 = new ArrayList(var1.size());

      for (GETSupport.Part14 var4 : var1) {
         var2.add(var4.v5());
      }

      this.v4.v2(this.v1(var1, var2));
      this.v52();
   }

   private void v72() {
      List var1 = this.v73();
      if (!var1.isEmpty()) {
         String var2 = var1.size() == 1 ? "this message" : "these " + var1.size() + " messages";
         this.v1(
            new uiSupport55.Part1(
               var1.size() == 1 ? "Delete message" : "Delete " + var1.size() + " messages",
               "Are you sure you want to delete " + var2 + "? This cannot be undone.",
               "Also delete for " + this.v7,
               true,
               "Delete",
               null,
               uiSupport53.Part2.DANGER
            ),
            null,
            var2x -> {
               for (GETSupport.Part14 var4 : var1) {
                  this.v1(var4, var2x.booleanValue());
               }

               this.v52();
            }
         );
      }
   }

   private void v6(GETSupport.Part14 var1) {
      if (var1.v3() <= 0L) {
         this.v1(var1, false);
      } else {
         this.v1(
            new uiSupport55.Part1(
               "Delete message",
               "Are you sure you want to delete this message? This cannot be undone.",
               "Also delete for " + this.v7,
               true,
               "Delete",
               null,
               uiSupport53.Part2.DANGER
            ),
            var1,
            var2 -> this.v1(var1, var2.booleanValue())
         );
      }
   }

   private void v7(GETSupport.Part14 var1) {
      this.v1(
         new uiSupport55.Part1(
            "Pin message", "This message will stay at the top of the chat.", "Also pin for " + this.v7, true, "Pin", uiSupport143.v20, uiSupport53.Part2.ACCEPT
         ),
         var1,
         var2 -> {
            this.v5.v2(this.v6, var1.v3(), var2, this.v4::v3);
            this.v120 = 0L;
         }
      );
   }

   private void v1(uiSupport55.Part1 var1, @Nullable GETSupport.Part14 var2, Consumer<Boolean> var3) {
      uiSupport55 var4 = new uiSupport55(var1, this.v27, var2x -> {
         this.v4.v4();
         var3.accept(var2x);
      }, this.v4::v4);
      this.v74 = var2 == null ? null : var2.v2();
      this.v72 = var4;
      this.v43.v3(false);
      this.v4.v2(var4);
   }

   private void v1(GETSupport.Part14 var1, boolean var2) {
      if (var1.v7() == GETSupport.Part16.FAILED) {
         this.v5.v3(this.v6, var1.v2());
      } else if (var1.v3() > 0L) {
         this.v5.v1(this.v6, var1.v3(), var2, this.v4::v3);
      }
   }

   private List<GETSupport.Part6> v80() {
      ArrayList var1 = new ArrayList<>(this.v5.v2(this.v6));
      var1.sort(Comparator.comparingLong(var0 -> var0.v1().v3()));
      return var1;
   }

   private int v2(List<GETSupport.Part6> var1) {
      if (this.v120 != 0L) {
         for (int var2 = 0; var2 < var1.size(); var2++) {
            if (((GETSupport.Part6)var1.get(var2)).v1().v3() == this.v120) {
               return var2;
            }
         }
      }

      float var6 = this.v46();
      float var3 = this.v27();

      for (int var4 = var1.size() - 1; var4 >= 0; var4--) {
         YouSupport.Part3 var5 = this.v3(((GETSupport.Part6)var1.get(var4)).v1().v3());
         if (var5 == null || var6 + this.v2(var5.v13) < var3) {
            return var4;
         }
      }

      return 0;
   }

   private void v8(float var1) {
      if (this.v120 != 0L) {
         if (this.v103 < 0.0F) {
            if (this.v82 - this.v88 > 120L && Math.abs(var1 - this.v101) < 0.5F) {
               this.v103 = var1;
            }
         } else if (Math.abs(var1 - this.v103) > 2.0F * this.v27) {
            this.v120 = 0L;
         }

         this.v101 = var1;
      }
   }

   private void v84() {
      List var1 = this.v80();
      if (!var1.isEmpty()) {
         this.v5.v1(this.v6, ((GETSupport.Part6)var1.get(this.v2(var1))).v1().v3(), this.v4::v3);
         this.v120 = 0L;
      }
   }

   private void v94() {
      List var1 = this.v80();
      if (!var1.isEmpty()) {
         int var2 = this.v2(var1);
         this.v4(((GETSupport.Part6)var1.get(var2)).v1().v3());
         this.v120 = ((GETSupport.Part6)var1.get(var2 == 0 ? var1.size() - 1 : var2 - 1)).v1().v3();
         this.v88 = this.v82;
         this.v103 = -1.0F;
         this.v101 = this.v4.v7();
      }
   }

   public boolean v10() {
      return this.v43.v3();
   }

   public void v11() {
      this.v43.v3(false);
   }

   public boolean v1(int var1, int var2) {
      if (!this.v43.v3()) {
         if (var1 == 67 && MsdfFont.v1(var2) && (var2 & 1) == 0 && this.v48()) {
            this.v4.v2(this.v49());
            return true;
         } else {
            return false;
         }
      } else {
         boolean var3 = var1 == 257 || var1 == 335;
         if (var3 && (var2 & 1) == 0) {
            this.v64();
            return true;
         } else {
            if (var1 == 265 && this.v43.v2().isEmpty() && this.v66 == null) {
               GETSupport.Part14 var4 = this.v68();
               if (var4 != null) {
                  this.v3(var4);
                  return true;
               }
            }

            this.v43.v2(var1, var2);
            return true;
         }
      }
   }

   public boolean v2(int var1, int var2) {
      if (!this.v43.v3()) {
         return false;
      } else {
         this.v43.v3(var1, var2);
         return true;
      }
   }

   public boolean v2(float var1, float var2) {
      return this.v9(var1, var2) != null || this.v1(var1, var2) || this.v52 && this.v10(var1, var2) != null;
   }

   @Nullable
   private YouSupport.Part3 v9(float var1, float var2) {
      if (!(var2 >= this.v27()) && !(var2 < this.v138 + this.v2(70.0F)) && !this.v8(var1, var2)) {
         float var3 = this.v46();
         float var4 = this.v32();
         float var5 = this.v23();

         for (YouSupport.Part3 var7 : this.v117.v1) {
            float var8 = var3 + this.v2(var7.v13);
            float var9 = var4 + this.v2(var7.v14) + (var7.v1() ? 0.0F : var5);
            if (var1 >= var9 && var1 <= var9 + this.v2(var7.v11) && var2 >= var8 && var2 <= var8 + this.v2(var7.v12)) {
               return var7;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   @Nullable
   private YouSupport.Part3 v10(float var1, float var2) {
      if (!(var2 >= this.v27()) && !(var2 < this.v138 + this.v2(70.0F)) && !this.v8(var1, var2)) {
         float var3 = this.v46();

         for (int var4 = 0; var4 < this.v117.v1.size(); var4++) {
            float[] var5 = this.v1(var4, var3);
            if (var2 >= var5[0] && var2 < var5[1]) {
               return this.v117.v1.get(var4);
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public boolean v1(float var1, float var2, int var3) {
      this.v50();
      if (this.v52) {
         return false;
      } else if (var3 != 0 || !this.v29.v1(var1, var2) && (this.v14() || !this.v23.v1(var1, var2))) {
         if (var3 == 1) {
            return this.v10(var1, var2) != null;
         } else {
            YouSupport.Part3 var4 = this.v9(var1, var2);
            return var4 != null && var3 == 0 && var4.v1.v7() == GETSupport.Part16.FAILED;
         }
      } else {
         return true;
      }
   }

   public boolean v2(float var1, float var2, int var3) {
      this.v50();
      this.v119 = var1;
      this.v98 = var2;
      if (this.v52) {
         if (this.v36.v1(var1, var2)) {
            return this.v36.v1(var1, var2, var3);
         }

         if (this.v38.v1(var1, var2)) {
            return this.v38.v1(var1, var2, var3);
         }

         if (this.v42.v1(var1, var2)) {
            return this.v42.v1(var1, var2, var3);
         }
      } else {
         if (this.v28.v1(var1, var2)) {
            return this.v28.v1(var1, var2, var3);
         }

         if (this.v15() && this.v30.v1(var1, var2)) {
            return this.v30.v1(var1, var2, var3);
         }

         if (this.v29.v1(var1, var2)) {
            if (var3 == 0 || var3 == 1) {
               this.v43.v3(false);
               this.v4.v1(this.v6, this.v7, var1, var2);
            }

            return true;
         }

         if (this.v6(var1, var2)) {
            if (var3 == 0) {
               this.v4.v1(this.v7);
            }

            return true;
         }
      }

      if (this.v8(var1, var2)) {
         if (this.v34.v1(var1, var2)) {
            return this.v34.v1(var1, var2, var3);
         } else {
            if (var3 == 0) {
               this.v94();
            }

            return true;
         }
      } else if (this.v53() && this.v33.v1(var1, var2)) {
         return this.v33.v1(var1, var2, var3);
      } else if (this.v22() && this.v31.v1(var1, var2)) {
         return this.v31.v1(var1, var2, var3);
      } else if (this.v14() && this.v7(var1, var2)) {
         uiSupport53 var8 = this.v5(var1, var2);
         return var8 == null || var8.v1(var1, var2, var3);
      } else if (this.v23.v1(var1, var2)) {
         if (var3 == 0) {
            this.v43.v3(false);
            this.v42();
         }

         return true;
      } else if (this.v32.v1(var1, var2)) {
         return this.v32.v1(var1, var2, var3);
      } else if (this.v7(var1, var2)) {
         this.v43.v2(var1, var2, var3);
         return true;
      } else if (this.v52) {
         YouSupport.Part3 var7 = this.v10(var1, var2);
         if (var7 != null && var3 == 0) {
            this.v8(var7);
            return true;
         } else if (var7 != null && var3 == 1) {
            this.v5(var7.v1);
            return true;
         } else {
            return var7 != null;
         }
      } else {
         YouSupport.Part3 var4 = var3 == 1 ? this.v10(var1, var2) : null;
         if (var4 != null) {
            this.v43.v3(false);
            this.v6(var4, var1, var2);
            return true;
         } else {
            YouSupport.Part3 var5 = this.v9(var1, var2);
            if (var5 != null && this.v1(var1, var2, var3)) {
               this.v43.v3(false);
               this.v6(var5, var1, var2);
               return true;
            } else if (var5 != null && var3 == 0 && this.v5(var5, var1, var2)) {
               GETSupport.Part18 var6 = var5.v1.v8();
               if (var6 != null) {
                  this.v4(var6.v1());
               }

               return true;
            } else if (var5 != null && var3 == 0 && this.v1(var5, var1, var2)) {
               this.v40();
               this.v43.v3(false);
               this.v4(var5);
               return true;
            } else if (var5 != null && var3 == 0 && this.v2(var5, var1, var2)) {
               this.v4(var5, var1, var2);
               return true;
            } else {
               this.v40();
               this.v43.v3(false);
               return var5 != null;
            }
         }
      }
   }

   private void v6(YouSupport.Part3 var1, float var2, float var3) {
      GETSupport.Part14 var4 = var1.v1;
      ArrayList var5 = new ArrayList(9);
      boolean var6 = !this.v14();
      if (this.v5(var1)) {
         String var7 = this.v49();
         if (var6 && this.v47() && var4.v3() > 0L) {
            var5.add(new AddNoteSupport.Part2(uiSupport143.v50, 22.0F, 22.0F, 0.0F, "Quote & Reply", false, true, false, () -> {
               this.v4.v4();
               this.v1(var4, var7);
            }));
         }

         var5.add(new AddNoteSupport.Part2(uiSupport143.v25, 21.0F, 21.0F, 0.0F, "Copy selection", false, true, false, () -> this.v4.v2(var7)));
      }

      if (var6 && var4.v7() == GETSupport.Part16.FAILED) {
         var5.add(new AddNoteSupport.Part2(uiSupport143.v34, 22.0F, 22.0F, 0.0F, "Send again", false, true, false, () -> {
            this.v4.v4();
            this.v5.v2(this.v6, var4.v2());
            this.v147 = UiPopup.Part1.GLIDE;
         }));
      }

      boolean var13 = var4.v3() > 0L;
      if (var6 && var13) {
         var5.add(new AddNoteSupport.Part2(uiSupport143.v50, 22.0F, 22.0F, 0.0F, "Reply", false, true, false, () -> {
            this.v4.v4();
            this.v2(var4);
         }));
         if (var4.v4() && var4.v1() == GETSupport.Part9.WORDS) {
            boolean var8 = this.v5.v1(var4);
            var5.add(new AddNoteSupport.Part2(uiSupport143.v26, 22.0F, 22.0F, 0.0F, "Edit", false, var8, var8 ? null : "Only for 48 hours", false, () -> {
               this.v4.v4();
               this.v3(var4);
            }));
         }
      }
      var5.add(new AddNoteSupport.Part2(uiSupport143.v25, 21.0F, 21.0F, 0.0F, switch (var4.v1()) {
         case WORDS -> "Copy text";
         case PLACE -> "Copy coords";
         case INVITE -> "Copy address";
      }, false, true, false, () -> this.v4.v2(var4.v5())));
      if (var13) {
         var5.add(AddNoteSupport.Part2.v1(this.v5.v1(this.v6, var4.v3()), null, () -> {
            this.v4.v4();
            if (this.v5.v1(this.v6, var4.v3())) {
               this.v5.v1(this.v6, var4.v3(), this.v4::v3);
            } else {
               this.v7(var4);
            }
         }));
         var5.add(new AddNoteSupport.Part2(uiSupport143.v60, 22.0F, 22.0F, 0.0F, "Select", false, true, false, () -> {
            this.v4.v4();
            this.v4(var4);
         }));
      }

      if (var13 || var4.v7() == GETSupport.Part16.FAILED) {
         var5.add(new AddNoteSupport.Part2(uiSupport143.v15, 18.0F, 20.0F, 0.0F, "Delete", true, true, true, () -> {
            this.v4.v4();
            this.v6(var4);
         }));
      }

      LocalDate var14 = LocalDate.ofInstant(Instant.ofEpochMilli(this.v82), this.v118);
      ArrayList var9 = new ArrayList(2);
      Instant var10 = var4.v10();
      if (var4.v4() && var10 != null) {
         var9.add(new AddNoteSupport.Part1(uiSupport143.v61, 16.0F, 10.0F, "Read " + MMMMDSupport.v1(var10, this.v118, var14)));
      }

      Instant var11 = var4.v9();
      if (var11 != null) {
         var9.add(new AddNoteSupport.Part1(uiSupport143.v26, 15.0F, 15.0F, "Edited " + MMMMDSupport.v1(var11, this.v118, var14)));
      }

      uiSupport93 var12 = new uiSupport93(new AddNoteSupport(var5, var9, this.v27));
      this.v74 = var4.v2();
      this.v72 = var12;
      this.v4.v1(var12, var2, var3);
   }

   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      this.v119 = var1;
      this.v98 = var2;
      if (this.v96) {
         this.v6(var2);
         return true;
      } else if (this.v59) {
         this.v11(var1, var2);
         return true;
      } else {
         return this.v43.v3() && this.v43.v1(var1, var2, var3, var4, var5);
      }
   }

   private void v11(float var1, float var2) {
      YouSupport.Part3 var3 = this.v4(var2);
      if (var3 != null) {
         int[] var4 = this.v3(var3, var1, var2);
         this.v49 = var3.v1.v2();
         this.v50 = var4[0];
         this.v60 = var4[1];
      }
   }

   public boolean v3(float var1, float var2, int var3) {
      if (this.v96) {
         this.v75();
         return true;
      } else if (this.v59) {
         this.v59 = false;
         if (!this.v48()) {
            this.v40();
         }

         return true;
      } else {
         return this.v43.v3() && this.v43.v4(var1, var2, var3);
      }
   }

   public hudSupport54 v3(float var1, float var2) {
      this.v50();
      if (this.v52) {
         if (this.v36.v1(var1, var2) || this.v38.v1(var1, var2) || this.v42.v1(var1, var2)) {
            return hudSupport54.POINTER;
         }
      } else {
         if (this.v28.v1(var1, var2)) {
            return this.v28.v2(var1, var2);
         }

         if (this.v15() && this.v30.v1(var1, var2)) {
            return this.v30.v2(var1, var2);
         }

         if (this.v29.v1(var1, var2) || this.v6(var1, var2)) {
            return hudSupport54.POINTER;
         }
      }

      if (this.v8(var1, var2) || this.v53() && this.v33.v1(var1, var2)) {
         return hudSupport54.POINTER;
      } else if (this.v14() && this.v7(var1, var2)) {
         uiSupport53 var4 = this.v5(var1, var2);
         return var4 != null ? var4.v2(var1, var2) : hudSupport54.ARROW;
      } else if (this.v22() && this.v31.v1(var1, var2)) {
         return hudSupport54.POINTER;
      } else if (this.v23.v1(var1, var2)) {
         return this.v23.v2(var1, var2);
      } else if (this.v32.v1(var1, var2)) {
         return this.v32.v2(var1, var2);
      } else if (this.v7(var1, var2)) {
         return hudSupport54.IBEAM;
      } else if (this.v52) {
         return this.v10(var1, var2) != null ? hudSupport54.POINTER : hudSupport54.ARROW;
      } else {
         YouSupport.Part3 var3 = this.v9(var1, var2);
         if (var3 == null) {
            return hudSupport54.ARROW;
         } else if (var3.v1.v7() == GETSupport.Part16.FAILED || this.v5(var3, var1, var2)) {
            return hudSupport54.POINTER;
         } else if (this.v1(var3, var1, var2) && !this.v2(var3).v6()) {
            return hudSupport54.POINTER;
         } else {
            return this.v2(var3, var1, var2) ? hudSupport54.IBEAM : hudSupport54.ARROW;
         }
      }
   }

   @Nullable
   public hudSupport54 v12() {
      if (this.v59) {
         return hudSupport54.IBEAM;
      } else {
         return this.v43.v3() ? this.v43.v31() : null;
      }
   }

   public interface Part1 {
      uiSupport119 v1();

      boolean v2();

      boolean v1(UiScreen var1);

      void v3();

      void v1(long var1, boolean var3);

      boolean v1(long var1);

      void v2(long var1);

      boolean v3(long var1);

      void v1(String var1);

      void v1(long var1, String var3, float var4, float var5);

      void v1(UiScreen var1, float var2, float var3);

      void v4();

      void v2(String var1);

      void v3(String var1);

      void v2(UiScreen var1);

      InternalSupport7 v5();

      String v6();

      float v7();

      float v8();
   }

   public record Part2(class_2960 glyph, @Nullable class_2960 picture, String title, String line, String button, boolean done) {
      public class_2960 v1() {
         return this.glyph;
      }

      @Nullable
      public class_2960 v2() {
         return this.picture;
      }

      public String v3() {
         return this.title;
      }

      public String v4() {
         return this.line;
      }

      public String v5() {
         return this.button;
      }

      public boolean v6() {
         return this.done;
      }
   }
}
