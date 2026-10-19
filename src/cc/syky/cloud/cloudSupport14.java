package cc.syky.cloud;

import cc.syky.hud.HudElement;
import cc.syky.hud.HudManager;
import cc.syky.hud.hudRecord3;
import cc.syky.hud.hudRecord4;
import cc.syky.hud.hudSupport;
import cc.syky.hud.hudSupport3;
import cc.syky.hud.hudSupport31;
import cc.syky.hud.hudSupport34;
import cc.syky.hud.hudSupport37;
import cc.syky.hud.hudSupport41;
import cc.syky.hud.hudSupport47;
import cc.syky.hud.hudSupport54;
import cc.syky.render.renderSupport47;
import cc.syky.ui.uiSupport27;
import cc.syky.ui.uiSupport28;
import cc.syky.ui.uiSupport30;
import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport14 {
   public static final float v1 = 32.0F;
   public static final float v2 = 56.0F;
   public static final float v3 = 4.0F;
   private static final float v5 = 24.0F;
   private static final float v6 = 1.0F;
   public static final float v4 = 3.0F;
   private static final long v7 = 500000000L;
   private static final hudRecord3.Part2[] v8 = new hudRecord3.Part2[]{hudRecord3.Part2.CENTER, hudRecord3.Part2.START, hudRecord3.Part2.END};
   private static final hudRecord3.Part2[] v9 = new hudRecord3.Part2[]{hudRecord3.Part2.START, hudRecord3.Part2.CENTER, hudRecord3.Part2.END};
   private static final hudRecord3.Part1[] v10 = hudRecord3.Part1.values();
   private static final hudRecord3.Part1[] v11 = new hudRecord3.Part1[]{
      hudRecord3.Part1.RIGHT, hudRecord3.Part1.LEFT, hudRecord3.Part1.BELOW, hudRecord3.Part1.ABOVE
   };
   private final HudManager v12;
   private final hudSupport37 v13;
   private final uiSupport28 v14;
   private final hudSupport34 v15;
   private cloudSupport14.Part2 v16 = cloudSupport14.Part2.NONE;
   @Nullable
   private HudElement v18;
   private float v19;
   private float v17;
   private boolean v20;
   private boolean v21;
   private boolean v22;
   private float v24;
   private float v25;
   @Nullable
   private hudSupport47 v26;
   private final List<HudElement> v27 = new ArrayList<>();
   private final List<HudElement> v28 = new ArrayList<>();
   private float[] v29 = new float[8];
   private float[] v30 = new float[8];
   private float[] v32 = new float[8];
   private float[] v23 = new float[8];
   private float v33;
   private float v31;
   private hudRecord4 v34 = hudRecord4.EMPTY;
   private cloudSupport14.Part1 v36 = cloudSupport14.Part1.HOME;
   @Nullable
   private HudElement v38;
   private hudRecord3.Part1 v42 = hudRecord3.Part1.RIGHT;
   private hudRecord3.Part2 v43 = hudRecord3.Part2.CENTER;
   private boolean v37;
   private cloudSupport14.Part1 v48 = cloudSupport14.Part1.HOME;
   @Nullable
   private HudElement v40;
   private hudRecord3.Part1 v44 = hudRecord3.Part1.RIGHT;
   private hudRecord3.Part2 v47 = hudRecord3.Part2.CENTER;
   private boolean v49;
   private boolean v46;
   @Nullable
   private hudRecord3 v51;
   private hudRecord4 v50 = hudRecord4.EMPTY;
   @Nullable
   private HudElement v60;
   private final List<HudElement> v59 = new ArrayList<>();
   private final List<HudElement> v53 = new ArrayList<>();
   private final List<hudRecord4> v63 = new ArrayList<>();
   private final List<HudElement> v64 = new ArrayList<>(4);
   private final List<hudRecord4> v61 = new ArrayList<>(4);
   private LongSupplier v66 = System::nanoTime;
   @Nullable
   private HudElement v68;
   private long v52;
   private float v75;
   private float v73;
   private final List<HudElement> v74 = new ArrayList<>(1);
   private final List<HudElement> v72 = new ArrayList<>();
   private final uiSupport27 v80 = new uiSupport27();
   private final uiSupport30 v84 = new uiSupport30();
   private final List<hudRecord4> v94 = new ArrayList<>();
   private boolean v82;
   private float v99;
   private float v120;
   private float v88;
   private float v103;
   private final List<HudElement> v101 = new ArrayList<>();
   private final List<HudElement> v96 = new ArrayList<>();

   public cloudSupport14(HudManager var1, hudSupport37 var2, uiSupport28 var3, hudSupport34 var4) {
      this.v12 = var1;
      this.v13 = var2;
      this.v14 = var3;
      this.v15 = var4;
   }

   public void v1(LongSupplier var1) {
      this.v66 = var1;
   }

   public boolean v1() {
      return this.v16 != cloudSupport14.Part2.NONE;
   }

   public boolean v2() {
      return this.v16 == cloudSupport14.Part2.PRESS;
   }

   public boolean v3() {
      return this.v16 == cloudSupport14.Part2.PIECE || this.v16 == cloudSupport14.Part2.FREE;
   }

   public hudRecord4 v4() {
      if (this.v16 == cloudSupport14.Part2.PIECE && this.v18 != null && this.v36 != cloudSupport14.Part1.FREE) {
         return this.v18.v23();
      } else {
         return this.v3() ? this.v34 : hudRecord4.EMPTY;
      }
   }

   public void v1(List<HudElement> var1) {
      var1.clear();
      if (this.v16 == cloudSupport14.Part2.FREE) {
         var1.addAll(this.v27);
      } else if (this.v16 == cloudSupport14.Part2.PIECE && this.v18 != null) {
         var1.add(this.v18);
      }
   }

   public uiSupport30 v5() {
      return this.v84;
   }

   public boolean v1(float[] var1) {
      if (this.v16 == cloudSupport14.Part2.MARQUEE && this.v82) {
         var1[0] = Math.min(this.v99, this.v88);
         var1[1] = Math.min(this.v120, this.v103);
         var1[2] = Math.max(this.v99, this.v88);
         var1[3] = Math.max(this.v120, this.v103);
         return true;
      } else {
         return false;
      }
   }

   @Nullable
   public hudSupport54 v6() {
      return switch (this.v16) {
         case NONE -> null;
         case GRAB -> hudSupport54.POINTER;
         default -> hudSupport54.ARROW;
      };
   }

   public void v1(float var1, float var2, boolean var3, boolean var4) {
      if (this.v16 == cloudSupport14.Part2.NONE) {
         HudElement var5 = hudSupport31.v1(this.v12, var1, var2, hudSupport31.v1);
         if (var5 == null) {
            if (!var3) {
               this.v14.v6();
            }

            if (!var4) {
               this.v16 = cloudSupport14.Part2.MARQUEE;
               this.v82 = false;
               this.v99 = var1;
               this.v120 = var2;
               this.v88 = var1;
               this.v103 = var2;
               this.v101.clear();
               this.v101.addAll(this.v14.v1());
            }
         } else if (var5.v7(var1, var2)) {
            this.v12.v1(var5);
         } else if (var5.v8(var1, var2)) {
            this.v18 = var5;
            this.v16 = cloudSupport14.Part2.GRAB;
            this.v12.v1(var5);
         } else {
            this.v18 = var5;
            this.v16 = cloudSupport14.Part2.PRESS;
            this.v19 = var1;
            this.v17 = var2;
            this.v20 = var3;
            this.v21 = false;
            this.v22 = false;
            long var6 = this.v66.getAsLong();
            boolean var8 = var5 == this.v68 && var6 - this.v52 <= 500000000L && !cloudSupport15.v1(var1 - this.v75, var2 - this.v73, this.v13.v3);
            this.v68 = var8 ? null : var5;
            this.v52 = var6;
            this.v75 = var1;
            this.v73 = var2;
            if (var8 && !var3 && var5.v12()) {
               this.v1(var5);
               this.v12.v1(var5);
            } else {
               if (var3) {
                  if (this.v14.v1(var5)) {
                     this.v21 = true;
                  } else {
                     this.v14.v3(var5);
                  }
               } else if (!this.v14.v1(var5)) {
                  this.v14.v2(var5);
               } else if (this.v14.v2() > 1) {
                  this.v22 = true;
               }

               this.v12.v1(var5);
            }
         }
      }
   }

   public void v1(boolean var1, float var2, float var3, boolean var4, boolean var5) {
      switch (this.v16) {
         case NONE:
         default:
            break;
         case PRESS:
            if (this.v3(var2, var3)) {
               if (var1) {
                  this.v9();
                  this.v2(var2, var3, var4, var5);
               } else {
                  this.v8();
               }
            } else if (!var1) {
               this.v4(var2, var3);
            }
            break;
         case PIECE:
         case FREE:
            if (var1) {
               this.v2(var2, var3, var4, var5);
            } else {
               this.v10();
            }
            break;
         case MARQUEE:
            if (var1) {
               this.v5(var2, var3);
            } else {
               this.v8();
            }
            break;
         case GRAB:
            HudElement var6 = renderSupport47.v1(this.v18);
            if (var1) {
               var6.v9(var2, var3);
            } else {
               this.v8();
               var6.v1(var2, var3, true);
            }
      }
   }

   public boolean v7() {
      switch (this.v16) {
         case NONE:
         case GRAB:
            return false;
         case PRESS:
         default:
            break;
         case PIECE:
            HudElement var1 = renderSupport47.v1(this.v18);
            v6(var1);
            hudSupport47 var2 = this.v26;
            if (var2 != null) {
               hudRecord4 var3 = var1.v23();
               this.v15.v2();
               var2.v2(this.v12);
               this.v15.v1(this.v74);
               hudRecord4 var4 = this.v4(var1);
               if (var4 != null && !var3.v1()) {
                  var1.v3(var3.v2() - var4.v2(), var3.v3() - var4.v3());
               }
            }
            break;
         case FREE:
            v6(this.v18);
            if (this.v26 != null) {
               this.v26.v1(this.v12);
            }
            break;
         case MARQUEE:
            this.v14.v1(this.v101, List.of());
      }

      this.v8();
      return true;
   }

   public void v1(float var1, float var2) {
      switch (this.v16) {
         case PIECE:
         case FREE:
            this.v10();
            break;
         case MARQUEE:
         default:
            this.v8();
            break;
         case GRAB:
            HudElement var3 = renderSupport47.v1(this.v18);
            this.v8();
            var3.v1(var1, var2, true);
      }
   }

   public void v2(float var1, float var2) {
      HudElement var3 = this.v18;
      cloudSupport14.Part2 var4 = this.v16;
      hudSupport3 var5 = var3 == null ? null : var3.v29();
      if (var5 != null) {
         var5.v3();
      }

      this.v8();
      if (var4 == cloudSupport14.Part2.GRAB && var3 != null) {
         var3.v1(var1, var2, false);
      }
   }

   private void v8() {
      this.v16 = cloudSupport14.Part2.NONE;
      this.v18 = null;
      this.v26 = null;
      this.v27.clear();
      this.v28.clear();
      this.v34 = hudRecord4.EMPTY;
      this.v36 = cloudSupport14.Part1.HOME;
      this.v38 = null;
      this.v40 = null;
      this.v60 = null;
      this.v51 = null;
      this.v64.clear();
      this.v61.clear();
      this.v84.v1();
      this.v82 = false;
      this.v101.clear();
      this.v21 = false;
      this.v22 = false;
   }

   private boolean v3(float var1, float var2) {
      return cloudSupport15.v1(var1 - this.v19, var2 - this.v17, this.v13.v3);
   }

   private void v4(float var1, float var2) {
      HudElement var3 = renderSupport47.v1(this.v18);
      boolean var4 = this.v21;
      boolean var5 = this.v22;
      boolean var6 = this.v20;
      this.v8();
      if (var4) {
         this.v14.v4(var3);
      } else if (var5) {
         this.v14.v2(var3);
      }

      if (!var6) {
         var3.v10(var1, var2);
      }
   }

   private void v1(HudElement var1) {
      List var2 = this.v12.v8().v6(var1);
      this.v72.clear();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         HudElement var4 = (HudElement)var2.get(var3);
         if (hudSupport31.v1.test(var4) && !var4.v27().v1()) {
            this.v72.add(var4);
         }
      }

      this.v14.v1(this.v72, List.of());
   }

   private void v9() {
      HudElement var1 = renderSupport47.v1(this.v18);
      this.v68 = null;
      this.v21 = false;
      this.v22 = false;
      this.v26 = hudSupport47.v1(this.v12, false);
      List var2 = this.v15.v1();
      this.v27.clear();
      this.v27.addAll(var2);
      if (!this.v27.contains(var1)) {
         this.v27.clear();
         this.v27.add(var1);
      }

      if (this.v27.size() == 1 && var1.v12()) {
         this.v16 = cloudSupport14.Part2.PIECE;
         hudRecord4 var8 = var1.v23();
         this.v24 = this.v19 - var8.v2();
         this.v25 = this.v17 - var8.v3();
         this.v33 = var8.v2();
         this.v31 = var8.v3();
         this.v36 = cloudSupport14.Part1.HOME;
         this.v38 = null;
         this.v74.clear();
         this.v74.add(var1);
         hudSupport41 var10 = this.v12.v8();
         hudRecord3 var11 = var1.v11();
         this.v51 = var11;
         this.v46 = var10.v6(var1).size() > 1;
         hudRecord4 var12 = this.v4(var1);
         this.v50 = var12 == null ? hudRecord4.EMPTY : var12;
         this.v46 = this.v46 & !this.v50.v1();
         this.v2(var1);
         this.v60 = var11 != null ? var11.v1() : this.v3(var1);
      } else {
         this.v16 = cloudSupport14.Part2.FREE;
         List var3 = this.v15.v1(this.v27);
         this.v28.clear();
         this.v28.addAll(var3);
         this.v1(this.v28.size());
         float var4 = Float.POSITIVE_INFINITY;
         float var5 = Float.POSITIVE_INFINITY;

         for (int var6 = 0; var6 < this.v28.size(); var6++) {
            hudRecord4 var7 = this.v15.v1(this.v28.get(var6));
            this.v29[var6] = var7.v2();
            this.v30[var6] = var7.v3();
            this.v32[var6] = var7.v4();
            this.v23[var6] = var7.v5();
            var4 = Math.min(var4, var7.v2());
            var5 = Math.min(var5, var7.v3());
         }

         this.v33 = var4;
         this.v31 = var5;
         this.v24 = this.v19 - var4;
         this.v25 = this.v17 - var5;
      }

      for (int var9 = 0; var9 < this.v27.size(); var9++) {
         if (this.v27.get(var9) != var1) {
            this.v12.v1(this.v27.get(var9));
         }
      }

      this.v12.v1(var1);
      if (this.v27.size() == 1) {
         v1(var1, this.v19, this.v17);
      }
   }

   private void v2(float var1, float var2, boolean var3, boolean var4) {
      if (var3) {
         if (Math.abs(var1 - this.v19) >= Math.abs(var2 - this.v17)) {
            var2 = this.v17;
         } else {
            var1 = this.v19;
         }
      }

      HudElement var5 = renderSupport47.v1(this.v18);
      hudSupport3 var6 = var5.v29();
      if (this.v27.size() == 1 && (var6 == null || !var6.v4())) {
         v1(var5, var1, var2);
      }

      if (this.v16 == cloudSupport14.Part2.PIECE) {
         this.v1(var5, var1, var2, var4);
      } else {
         this.v1(var1, var2, var4);
      }
   }

   private void v1(float var1, float var2, boolean var3) {
      float var4 = 0.0F;
      float var5 = 0.0F;

      for (int var6 = 0; var6 < this.v28.size(); var6++) {
         var4 = Math.max(var4, this.v29[var6] - this.v33 + this.v32[var6]);
         var5 = Math.max(var5, this.v30[var6] - this.v31 + this.v23[var6]);
      }

      this.v1(var1 - this.v24, var2 - this.v25, var4, var5, var3);
      float var9 = this.v80.v2 - this.v33;
      float var7 = this.v80.v3 - this.v31;

      for (int var8 = 0; var8 < this.v28.size(); var8++) {
         this.v15.v1(this.v28.get(var8), this.v29[var8] + var9, this.v30[var8] + var7);
      }
   }

   private void v1(float var1, float var2, float var3, float var4, boolean var5) {
      var1 = v1(var1, 0.0F, this.v13.v1 - var3);
      var2 = v1(var2, 0.0F, this.v13.v2 - var4);
      if (var5) {
         this.v80.v1(var1, var2, this.v13.v3, this.v84);
      } else {
         this.v15.v1(this.v94, this.v27);
         boolean var6 = false;

         for (int var7 = 0; var7 < this.v27.size(); var7++) {
            var6 |= this.v27.get(var7).v12();
         }

         this.v80.v1(var6 ? 10.0F * this.v13.v3 : Float.NaN);
         this.v80.v1(var1, var2, var3, var4, this.v94, this.v13.v1, this.v13.v2, this.v13.v3, 8.0F, 10.0F, this.v84);
      }

      this.v34 = new hudRecord4(this.v80.v2, this.v80.v3, var3, var4);
   }

   private void v10() {
      HudElement var1 = renderSupport47.v1(this.v18);
      v6(var1);
      if (this.v16 == cloudSupport14.Part2.PIECE) {
         if (this.v36 == cloudSupport14.Part1.FREE) {
            hudRecord4 var2 = this.v15.v1(var1);
            this.v15.v2(var1, var2.v2(), var2.v3());
         } else if (this.v36 != cloudSupport14.Part1.HOME) {
            hudSupport41 var5 = this.v12.v8();
            HudElement var3 = var5.v4(var1);
            this.v5(var3);
            HudElement var4 = this.v60;
            if (var4 != null && var5.v1(var4) && var5.v4(var4) != var3) {
               this.v5(var5.v4(var4));
            }
         }
      } else {
         for (int var6 = 0; var6 < this.v28.size(); var6++) {
            hudRecord4 var8 = this.v15.v1(this.v28.get(var6));
            this.v15.v2(this.v28.get(var6), var8.v2(), var8.v3());
         }
      }

      this.v12.v8().v1(this.v13.v1, this.v13.v2, this.v13.v3);
      this.v15.v8();
      hudSupport47 var7 = this.v26;
      this.v8();
      if (var7 != null) {
         this.v15.v2(var7);
      }
   }

   private void v1(int var1) {
      if (this.v29.length < var1) {
         this.v29 = new float[Math.max(var1, this.v29.length * 2)];
         this.v30 = new float[this.v29.length];
         this.v32 = new float[this.v29.length];
         this.v23 = new float[this.v29.length];
      }
   }

   private void v1(HudElement var1, float var2, float var3, boolean var4) {
      hudRecord4 var5 = var1.v27();
      if (!var5.v1()) {
         float var6 = var5.v4();
         float var7 = var5.v5();
         float var8 = v1(var2 - this.v24, 0.0F, this.v13.v1 - var6);
         float var9 = v1(var3 - this.v25, 0.0F, this.v13.v2 - var7);
         this.v15.v2();
         if (this.v36 != cloudSupport14.Part1.HOME) {
            renderSupport47.v1(this.v26).v2(this.v12);
         }

         if (var4) {
            this.v48 = cloudSupport14.Part1.FREE;
         } else {
            this.v1(var1, var8, var9, var6, var7);
         }

         hudSupport41 var10 = this.v12.v8();
         switch (this.v48) {
            case HOME:
            default:
               break;
            case FREE:
               if (this.v46) {
                  var10.v1(var1, null, this.v44, this.v47, false, this.v13.v1, this.v13.v2, this.v13.v3);
               }
               break;
            case SWAP:
               var10.v1(var1, renderSupport47.v1(this.v40), this.v13.v1, this.v13.v2, this.v13.v3);
               break;
            case PLACE:
               var10.v1(var1, this.v40, this.v44, this.v47, this.v49, this.v13.v1, this.v13.v2, this.v13.v3);
         }

         this.v15.v1(this.v74);
         this.v36 = this.v48;
         this.v38 = this.v40;
         this.v42 = this.v44;
         this.v43 = this.v47;
         this.v37 = this.v49;
         if (this.v36 == cloudSupport14.Part1.FREE) {
            this.v1(var8, var9, var6, var7, var4);
            this.v15.v1(var1, this.v80.v2, this.v80.v3);
            var1.v26();
         } else {
            this.v84.v1();
            hudRecord4 var11 = this.v4(var1);
            if (var11 != null) {
               var1.v3(var8 - var11.v2(), var9 - var11.v3());
            }
         }
      }
   }

   private void v2(HudElement var1) {
      this.v64.clear();
      this.v61.clear();
      hudSupport41 var2 = this.v12.v8();
      this.v11();

      for (hudRecord3.Part1 var6 : v10) {
         HudElement var7 = var2.v1(var1, var6);
         if (var7 != null && !var7.v27().v1() && !this.v64.contains(var7)) {
            hudRecord4 var8 = var2.v1(var1, var7, this.v13.v1, this.v13.v2, this.v13.v3, this.v63);
            if (var8 != null) {
               this.v64.add(var7);
               this.v61.add(var8);
            }
         }
      }
   }

   private void v11() {
      this.v63.clear();

      for (HudElement var2 : this.v12.v9()) {
         if (!var2.v12() && var2.v10() && !var2.v18().v2() && !var2.v27().v1()) {
            this.v63.add(var2.v27());
         }
      }
   }

   @Nullable
   private HudElement v3(HudElement var1) {
      hudSupport41 var2 = this.v12.v8();

      for (hudRecord3.Part1 var6 : v11) {
         HudElement var7 = var2.v2(var1, var6);
         if (var7 != null) {
            return var7;
         }
      }

      return null;
   }

   @Nullable
   private hudRecord4 v4(HudElement var1) {
      hudSupport41 var2 = this.v12.v8();
      var2.v1(this.v13.v1, this.v13.v2, this.v13.v3, null);
      return var2.v8(var1);
   }

   private void v1(HudElement var1, float var2, float var3, float var4, float var5) {
      hudSupport41 var6 = this.v12.v8();
      float var7 = this.v13.v3;
      boolean var8 = this.v36 != cloudSupport14.Part1.FREE && (this.v36 != cloudSupport14.Part1.HOME || this.v46);
      float var9 = (var8 ? 56.0F : 32.0F) * var7;
      float var10 = var9 + 34.0F * var7;
      float var11 = 4.0F * var7;
      var6.v1(this.v13.v1, this.v13.v2, var7, null);
      List var12 = var6.v1();
      this.v59.clear();
      this.v53.clear();
      this.v53.add(var6.v4(var1));

      for (int var13 = 0; var13 < var12.size(); var13++) {
         HudElement var14 = (HudElement)var12.get(var13);
         hudRecord4 var15 = var6.v8(var14);
         if (var15 != null && var14 != var1 && Math.max(v1(var2, var4, var15.v2(), var15.v4()), v1(var3, var5, var15.v3(), var15.v5())) <= var10) {
            HudElement var16 = var6.v4(var14);
            if (!this.v53.contains(var16)) {
               this.v53.add(var16);
            }
         }
      }

      for (int var33 = 0; var33 < var12.size(); var33++) {
         HudElement var35 = (HudElement)var12.get(var33);
         if (var35 != var1 && var35.v10() && var6.v8(var35) != null && this.v53.contains(var6.v4(var35))) {
            this.v59.add(var35);
         }
      }

      this.v11();
      float var34 = Float.POSITIVE_INFINITY;
      float var36 = Float.POSITIVE_INFINITY;
      this.v48 = cloudSupport14.Part1.FREE;
      if (this.v46) {
         float var37 = (float)Math.hypot(this.v50.v2() - var2, this.v50.v3() - var3);
         float var40 = var37 - var11;
         var34 = var37;
         var36 = var40;
         this.v48 = cloudSupport14.Part1.HOME;
      }

      for (int var38 = 0; var38 < this.v64.size(); var38++) {
         HudElement var41 = this.v64.get(var38);
         hudRecord4 var17 = this.v61.get(var38);
         float var18 = (float)Math.hypot(var17.v2() - var2, var17.v3() - var3);
         float var19 = var18 - 3.0F * var7 - (this.v36 == cloudSupport14.Part1.SWAP && this.v38 == var41 ? var11 : 0.0F);
         if (var19 < var36) {
            var34 = var18;
            var36 = var19;
            this.v48 = cloudSupport14.Part1.SWAP;
            this.v40 = var41;
         }
      }

      hudRecord3 var39 = this.v51;

      for (int var42 = 0; var42 < this.v59.size(); var42++) {
         HudElement var43 = this.v59.get(var42);

         for (hudRecord3.Part1 var21 : v10) {
            boolean var22 = var6.v2(var43, var21.v2()) != null;

            for (hudRecord3.Part2 var26 : var21.v1() ? v8 : v9) {
               for (int var27 = 0; var27 < (var22 ? 2 : 1); var27++) {
                  boolean var28 = var27 == 1;
                  if (var28 || var39 == null || var39.v1() != var43 || var39.v2() != var21 || var39.v3() != var26) {
                     hudRecord4 var29 = var6.v1(var1, var43, var21, var26, var28, this.v13.v1, this.v13.v2, var7, this.v63);
                     if (var29 != null) {
                        float var30 = (float)Math.hypot(var29.v2() - var2, var29.v3() - var3);
                        boolean var31 = this.v36 == cloudSupport14.Part1.PLACE
                           && this.v38 == var43
                           && this.v42 == var21
                           && this.v43 == var26
                           && this.v37 == var28;
                        float var32 = var30 + 1.0F * var7 * var6.v6() - (var31 ? var11 : 0.0F);
                        if (var32 < var36) {
                           var34 = var30;
                           var36 = var32;
                           this.v48 = cloudSupport14.Part1.PLACE;
                           this.v40 = var43;
                           this.v44 = var21;
                           this.v47 = var26;
                           this.v49 = var28;
                        }
                     }
                  }
               }
            }
         }
      }

      if (var34 > var9) {
         this.v48 = cloudSupport14.Part1.FREE;
      }
   }

   private static float v1(float var0, float var1, float var2, float var3) {
      return Math.max(0.0F, Math.max(var2 - (var0 + var1), var0 - (var2 + var3)));
   }

   private void v5(HudElement var1) {
      hudSupport41 var2 = this.v12.v8();
      var2.v1(this.v13.v1, this.v13.v2, this.v13.v3, null);
      hudRecord4 var3 = var2.v9(var1);
      if (var3 != null) {
         this.v15.v2(var1, var3.v2(), var3.v3());
      }
   }

   private void v5(float var1, float var2) {
      this.v88 = var1;
      this.v103 = var2;
      if (!this.v82) {
         if (!cloudSupport15.v1(var1 - this.v99, var2 - this.v120, this.v13.v3)) {
            return;
         }

         this.v82 = true;
      }

      float var3 = Math.min(this.v99, var1);
      float var4 = Math.min(this.v120, var2);
      float var5 = Math.max(this.v99, var1);
      float var6 = Math.max(this.v120, var2);
      this.v96.clear();

      for (HudElement var8 : this.v12.v9()) {
         if (hudSupport31.v1.test(var8)) {
            hudRecord4 var9 = var8.v27();
            if (!var9.v1() && var9.v2() < var5 && var9.v2() + var9.v4() > var3 && var9.v3() < var6 && var9.v3() + var9.v5() > var4) {
               this.v96.add(var8);
            }
         }
      }

      this.v14.v1(this.v101, this.v96);
   }

   private static void v1(HudElement var0, float var1, float var2) {
      if (hudSupport.v1() && var0.v30()) {
         hudRecord4 var3 = var0.v23();
         if (!var3.v1()) {
            var0.v28().v1(var3.v2(), var3.v3(), var3.v4(), var3.v5(), var1, var2);
         }
      }
   }

   private static void v6(@Nullable HudElement var0) {
      hudSupport3 var1 = var0 == null ? null : var0.v29();
      if (var1 != null) {
         var1.v1();
      }
   }

   private static float v1(float var0, float var1, float var2) {
      return var2 < var1 ? var1 : Math.max(var1, Math.min(var0, var2));
   }

   public static enum Part1 {
      HOME,
      FREE,
      SWAP,
      PLACE;

      private Part1() {
      }
   }

   public static enum Part2 {
      NONE,
      PRESS,
      PIECE,
      FREE,
      MARQUEE,
      GRAB;

      private Part2() {
      }
   }
}
