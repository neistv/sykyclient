package cc.syky.cloud;

import cc.syky.sykyRecord7;
import cc.syky.sykyRecord8;
import cc.syky.account.accountSupport3;
import cc.syky.config.EnumSetting;
import cc.syky.hud.AbstractHudWidget;
import cc.syky.hud.CopiedSupport2;
import cc.syky.hud.hudRecord4;
import cc.syky.hud.hudSupport40;
import cc.syky.hud.hudSupport49;
import cc.syky.hud.hudSupport52;
import cc.syky.hud.hudSupport54;
import cc.syky.internal.InternalSupport18;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport151;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport7;
import cc.syky.util.ClipboardUtil;
import java.util.Arrays;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class MusicPlayerSupport extends AbstractHudWidget {
   public static final String v2 = "music_player";
   private static final int v3 = 536870911;
   private static final int v4 = -637534209;
   private static final int v5 = 1509949439;
   private static final float v6 = 18.0F;
   private static final float v7 = 16.0F;
   private static final float v8 = 1600.0F;
   private static final float v9 = 6.0F;
   private static final int v10 = -1713776167;
   private static final float v11 = 2.0F;
   private static final float v12 = 1.0F;
   private static final float[] v13 = new float[]{0.0F, 4.0F, 8.0F, 12.0F, 16.0F, 20.0F};
   private static final float v14 = 2.0F;
   private static final float v15 = 2.0F;
   private static final float v16 = 14.0F;
   private static final float[] v18 = new float[]{0.3F, 0.62F, 1.0F, 1.0F, 0.62F, 0.3F};
   private static final float[] v19 = new float[]{0.0F, 1.1F, 2.4F, 3.5F, 4.7F, 5.8F};
   private static final float[] v17 = new float[]{6.1F, 7.3F, 5.4F, 8.0F, 6.6F, 7.1F};
   private static final float v20 = 7.0F;
   private static final int[] v21 = new int[]{4, 2, 0, 1, 3, 5};
   private static final float v22 = 0.6F;
   private static final float v24 = 1.2F;
   private static final float v25 = 1.5F;
   private static final float v26 = 0.02F;
   private static final float v27 = 0.08F;
   private static final float v28 = 0.15F;
   private static final float v29 = 60.0F;
   private static final float v30 = 5.0F;
   private static final float v32 = 0.12F;
   private static final float v23 = 0.15F;
   private static final float[] v33 = new float[]{0.72F, 0.88F, 1.0F, 1.0F, 0.88F, 0.72F};
   private static final float v31 = 6.0F;
   private static final float v34 = 11.0F;
   private static final int v36 = 536870911;
   private static final int v38 = 1946157055;
   private static final int v42 = 1040187391;
   private static final float v43 = 9.0F;
   private static final float v37 = 18.0F;
   private static final float v48 = 13.0F;
   private static final float v40 = 1.2727273F;
   private static final int v44 = -1;
   private static final int v47 = Integer.MIN_VALUE;
   private static final float v49 = 5.0F;
   private static final float v46 = 3.0F;
   private static final float v51 = 2.0F;
   private static final float v50 = 14.0F;
   private static final float v60 = 14.0F;
   private static final int v59 = 255;
   private static final float v53 = 0.14F;
   private static final float v63 = 40.0F;
   private static final float v64 = 16.0F;
   private static final long v61 = 90000000L;
   private static final long v66 = 220000000L;
   private static final int v68 = 0;
   private static final int v52 = 1;
   private static final int v75 = 2;
   private static final float v73 = 9.0F;
   private static final int v74 = 2113929215;
   private static final int v72 = -637534209;
   private static final float v80 = 6.0F;
   private static final sykyRecord7 v84 = new sykyRecord7("Music Player", "", 0, null);
   private static final String v94 = "—:—";
   private static final long v82 = 1000000000L;
   private final InternalSupport18 v99;
   private final cloudSupport12<sykyRecord8> v120 = new cloudSupport12<>(var0 -> var0.v2() != null);
   private long v88;
   private float v103;
   private final float[] v101 = new float[6];
   private final float[] v96 = new float[6];
   private final float[] v105 = new float[6];
   private final float[] v87 = new float[6];
   private boolean v85;
   private float v119;
   private long v98;
   @Nullable
   private CopiedSupport2 v124;
   @Nullable
   private CopiedSupport2 v117;
   private final cloudSupport11 v45 = new cloudSupport11();
   @Nullable
   private String v104;
   private long v125;
   private boolean v141;
   private float v145 = -1.0F;
   private float v162;
   private float v107;
   private final float[] v118 = new float[3];
   private final boolean[] v159 = new boolean[3];
   private final float[] v176 = new float[3];
   private int v116 = -1;
   private boolean v147;
   private long v93;
   private boolean v157;
   private long v166 = Long.MIN_VALUE;
   private float v121 = -1.0F;
   private final EnumSetting<WideRecord.Part1> v137;
   private sykyRecord7 v187 = v84;
   private boolean v138 = true;
   private float v106;
   private float v100;
   private long v191;

   public MusicPlayerSupport(InternalSupport18 var1, hudSupport52 var2, float var3, float var4) {
      super("music_player", 47, var2, var3, var4);
      this.v99 = var1;
      this.v137 = this.v2().v1(new EnumSetting<>("design", WideRecord.Part1.DEFAULT));
      this.v2().v1(new uiSupport151("playPause", "music.play_pause"));
      this.v2().v1(new uiSupport151("nextTrack", "music.next"));
      this.v2().v1(new uiSupport151("previousTrack", "music.previous"));
      this.v21().v1(uiSupport7.Part1.GLIDE);
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      sykyRecord8 var2 = this.v47();
      return var2 == null || var2.v2() == null;
   }

   @Override
   public class_2960 v38() {
      return hudSupport49.v26;
   }

   @Override
   public Object v1(hudSupport40 var1) {
      return this.v137.getValue();
   }

   private WideRecord v40() {
      return WideRecord.v1(this.v22() instanceof WideRecord.Part1 var1 ? var1 : this.v137.getValue());
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      WideRecord var3 = this.v40();
      return this.v12(this.v6(var3.v1(), var2), this.v6(var3.v2(), var2));
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return 25.0F * var3;
   }

   @Override
   public void v4(hudSupport40 var1, float var2) {
      sykyRecord8 var3 = this.v49();
      sykyRecord7 var4 = var3 != null ? var3.v2() : v84;
      boolean var5 = var3 == null || var3.v4();
      int var6 = var4.v3();
      float var7 = this.v121;
      boolean var8 = var7 >= 0.0F;
      this.v187 = var4;
      this.v138 = var5;
      this.v106 = var8 ? var7 : (var3 != null ? var3.v1() : 0.0F);
      this.v100 = var8 ? var7 * var6 : (var3 != null ? var3.v3() : 0.0F);
      long var9 = System.nanoTime();
      this.v191 = var9;
      float var11 = this.v1(var9);
      this.v103 = v1(this.v103, !var5, 7.0F, var11);
      this.v1(this.v99 != null && this.v99.v1(this.v101), var11);
      this.v162 = v1(this.v162, var8 || this.v141 && this.v3(var6), 14.0F, var11);
      this.v107 = v1(this.v107, var8, 14.0F, var11);
      this.v2(var9);

      for (int var12 = 0; var12 < this.v118.length; var12++) {
         boolean var13 = this.v157 && var12 == this.v116 && var9 - this.v93 < 220000000L;
         this.v118[var12] = v1(this.v118[var12], this.v159[var12] || var13, 14.0F, var11);
         this.v159[var12] = false;
         boolean var14 = var12 == this.v116 && (this.v147 || var9 - this.v93 < 90000000L);
         this.v176[var12] = v1(this.v176[var12], var14, var14 ? 40.0F : 16.0F, var11);
      }

      this.v141 = false;
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      WideRecord var4 = this.v40();
      sykyRecord7 var5 = this.v187;
      int var6 = var5.v3();
      float var7 = var2.v2();
      float var8 = var2.v3();
      if (!this.v51()) {
         this.v1(var7, var8, var3, var4.v3(), var5);
      }

      this.v1(var7, var8, var3, var4.v4(), var5, this.v191);
      this.v1(var7, var8, var3, var4, this.v191);
      WideRecord.Part2 var9 = var4.v6();
      if (var9 != null) {
         this.v1(var7, var8, var3, var9, this.v106, var6);
         this.v2(var7, var8, var3, var9, this.v100, var6);
      }

      if (!this.v51()) {
         this.v1(var7, var8, var3, var4.v7(), this.v138);
      }
   }

   @Override
   public void v4(hudSupport40 var1, hudRecord4 var2, float var3) {
      if (this.v21().v2() instanceof WideRecord.Part1 var4 && this.v21().v1() instanceof WideRecord.Part1 var5) {
         WideRecord var16 = WideRecord.v1(var4);
         WideRecord var7 = WideRecord.v1(var5);
         float var8 = this.a_(var1);
         WideRecord.Part4 var9 = var16.v3();
         WideRecord.Part4 var10 = var7.v3();
         float var11 = this.v6(var9.v1() + var9.v3(), var8) - this.v6(var9.v1(), var8);
         float var12 = this.v6(var10.v1() + var10.v3(), var8) - this.v6(var10.v1(), var8);
         this.v1(
            this.v187,
            this.v1(var2, var9.v1(), var10.v1(), var8, var3),
            this.v2(var2, var9.v2(), var10.v2(), var8, var3),
            v3(var11, var12, var3),
            v3(var9.v4(), var10.v4(), var3) * var8
         );
         WideRecord.Part5 var13 = var16.v7();
         WideRecord.Part5 var14 = var7.v7();
         this.v1(
            this.v138,
            this.v1(var2, var13.v1(), var14.v1(), var8, var3),
            this.v1(var2, var13.v2(), var14.v2(), var8, var3),
            this.v2(var2, var13.v3(), var14.v3(), var8, var3),
            v3(this.v6(var13.v4(), var8), this.v6(var14.v4(), var8), var3),
            v3(this.v6(var13.v5(), var8), this.v6(var14.v5(), var8), var3),
            this.v1(var2, var13.v6(), var14.v6(), var8, var3),
            this.v2(var2, var13.v7(), var14.v7(), var8, var3),
            v3(this.v6(var13.v8(), var8), this.v6(var14.v8(), var8), var3),
            v3(this.v6(var13.v9(), var8), this.v6(var14.v9(), var8), var3)
         );
      }
   }

   private float v1(hudRecord4 var1, float var2, float var3, float var4, float var5) {
      return v3(this.v1(var1, this.v6(var2, var4), true), this.v1(var1, this.v6(var3, var4), false), var5);
   }

   private float v2(hudRecord4 var1, float var2, float var3, float var4, float var5) {
      return v3(this.v2(var1, this.v6(var2, var4), true), this.v2(var1, this.v6(var3, var4), false), var5);
   }

   private static float v3(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   private float v1(long var1) {
      float var3 = this.v88 == 0L ? 0.0F : (float)(var1 - this.v88) * 1.0E-9F;
      this.v88 = var1;
      return var3 > 0.1F ? 0.1F : var3;
   }

   private static float v1(float var0, boolean var1, float var2, float var3) {
      float var4 = var1 ? 1.0F : 0.0F;
      float var5 = var0 + (var4 - var0) * (1.0F - (float)Math.exp(-var2 * var3));
      if (var5 < 5.0E-4F) {
         return 0.0F;
      } else {
         return var5 > 0.9995F ? 1.0F : var5;
      }
   }

   private boolean v3(int var1) {
      return var1 > 0 && this.v99 != null && this.v99.v5();
   }

   private boolean v44() {
      return this.v121 >= 0.0F;
   }

   private int v13(float var1, float var2) {
      hudRecord4 var3 = this.v27();
      if (var3.v1()) {
         return -1;
      } else {
         float var4 = this.v60();
         WideRecord.Part5 var5 = this.v40().v7();

         for (int var6 = 0; var6 < this.v176.length; var6++) {
            if (v1(var3, var4, var5, var6, var1, var2)) {
               return var6;
            }
         }

         return -1;
      }
   }

   private void v2(long var1) {
      InternalSupport18.Part1 var3 = this.v99 == null ? null : this.v99.v6();
      if (var3 != null && var3.v2() != this.v166) {
         boolean var4 = this.v166 == Long.MIN_VALUE;
         this.v166 = var3.v2();

         byte var5 = switch (var3.v1()) {
            case PREVIOUS -> 0;
            case NEXT -> 2;
            case PLAY_PAUSE -> 1;
         };
         if (!var4 && (!this.v147 || this.v116 != var5)) {
            this.v116 = var5;
            this.v147 = false;
            this.v157 = true;
            this.v93 = var1;
         }
      }
   }

   private void v4(int var1) {
      if (this.v99 != null) {
         switch (var1) {
            case 0:
               this.v99.v4();
               break;
            case 2:
               this.v99.v3();
               break;
            default:
               this.v99.v2();
         }
      }
   }

   private static boolean v1(hudRecord4 var0, float var1, WideRecord.Part5 var2, int var3, float var4, float var5) {
      return switch (var3) {
         case 0 -> v1(var0, var1, var2.v1(), var2.v3(), var2.v4(), var2.v5(), var4, var5);
         case 2 -> v1(var0, var1, var2.v2(), var2.v3(), var2.v4(), var2.v5(), var4, var5);
         default -> v1(var0, var1, var2.v6(), var2.v7(), var2.v8(), var2.v9(), var4, var5);
      };
   }

   private static boolean v1(hudRecord4 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = var0.v2() + (var2 - 6.0F) * var1;
      float var9 = var0.v3() + (var3 - 6.0F) * var1;
      float var10 = (var4 + 12.0F) * var1;
      float var11 = (var5 + 12.0F) * var1;
      return var6 >= var8 && var6 <= var8 + var10 && var7 >= var9 && var7 <= var9 + var11;
   }

   @Override
   public void v10(float var1, float var2) {
      sykyRecord8 var3 = this.v47();
      sykyRecord7 var4 = var3 == null ? null : var3.v2();
      if (var4 != null) {
         WideRecord.Part6 var5 = this.v40().v4();
         if (this.v1(var1, var2, var5, var5.v3(), var5.v7())) {
            if (ClipboardUtil.v1(var4.v1())) {
               this.v124 = v1(this.v124);
            }
         } else {
            if (this.v1(var1, var2, var5, var5.v5(), var5.v8()) && ClipboardUtil.v1(var4.v2())) {
               this.v117 = v1(this.v117);
            }
         }
      }
   }

   private static CopiedSupport2 v1(@Nullable CopiedSupport2 var0) {
      CopiedSupport2 var1 = var0 == null ? new CopiedSupport2() : var0;
      var1.v1(System.nanoTime());
      return var1;
   }

   private boolean v1(float var1, float var2, WideRecord.Part6 var3, float var4, float var5) {
      hudRecord4 var6 = this.v27();
      if (var6.v1()) {
         return false;
      } else {
         float var7 = this.v60();
         float var8 = var6.v2() + var3.v1() * var7;
         float var9 = var6.v3() + var4 * var7;
         float var10 = (var3.v2() - var3.v1()) * var7;
         float var11 = (var5 - var4) * var7;
         return var1 >= var8 && var1 <= var8 + var10 && var2 >= var9 && var2 <= var9 + var11;
      }
   }

   @Override
   public boolean v8(float var1, float var2) {
      int var3 = this.v13(var1, var2);
      if (var3 >= 0) {
         this.v116 = var3;
         this.v147 = true;
         this.v157 = false;
         this.v93 = System.nanoTime();
         this.v4(var3);
         return true;
      } else {
         sykyRecord8 var4 = this.v47();
         int var5 = var4 != null && var4.v2() != null ? var4.v2().v3() : 0;
         if (this.v3(var5) && this.v14(var1, var2)) {
            this.v121 = this.v10(var1);
            return true;
         } else {
            return false;
         }
      }
   }

   @Override
   public void v9(float var1, float var2) {
      if (this.v44()) {
         this.v121 = this.v10(var1);
      }
   }

   @Override
   public void v1(float var1, float var2, boolean var3) {
      this.v147 = false;
      float var4 = this.v121;
      this.v121 = -1.0F;
      if (var3 && !(var4 < 0.0F) && this.v99 != null) {
         sykyRecord8 var5 = this.v47();
         int var6 = var5 != null && var5.v2() != null ? var5.v2().v3() : 0;
         if (var6 > 0) {
            this.v99.v1(var4 * var6);
         }
      }
   }

   @Override
   public hudSupport54 v11(float var1, float var2) {
      sykyRecord8 var3 = this.v47();
      int var4 = var3 != null && var3.v2() != null ? var3.v2().v3() : 0;
      this.v141 = this.v3(var4) && this.v14(var1, var2);
      if (this.v141) {
         this.v145 = this.v10(var1);
      }

      hudRecord4 var5 = this.v27();
      if (!var5.v1()) {
         float var6 = this.v60();
         WideRecord.Part5 var7 = this.v40().v7();

         for (int var8 = 0; var8 < this.v159.length; var8++) {
            this.v159[var8] = v1(var5, var6, var7, var8, var1, var2);
         }
      }

      boolean var9 = this.v141 || this.v159[0] || this.v159[2] || this.v159[1];
      return var9 ? hudSupport54.POINTER : hudSupport54.ARROW;
   }

   private boolean v14(float var1, float var2) {
      hudRecord4 var3 = this.v27();
      WideRecord.Part2 var4 = this.v40().v6();
      if (!var3.v1() && var4 != null) {
         float var5 = this.v60();
         float var6 = var3.v2() + this.v1(var4, var5);
         float var7 = var3.v3() + this.v6(var4.v2() - 9.0F, var5);
         float var8 = this.v2(var4, var5);
         float var9 = this.v6(var4.v2() + 7.0F + 9.0F, var5) - this.v6(var4.v2() - 9.0F, var5);
         return var1 >= var6 && var1 <= var6 + var8 && var2 >= var7 && var2 <= var7 + var9;
      } else {
         return false;
      }
   }

   private float v10(float var1) {
      hudRecord4 var2 = this.v27();
      WideRecord.Part2 var3 = this.v40().v6();
      float var4 = this.v60();
      return !var2.v1() && var3 != null ? v2(var1, var2.v2() + this.v1(var3, var4), this.v2(var3, var4)) : 0.0F;
   }

   private float v1(WideRecord.Part2 var1, float var2) {
      return this.v6(var1.v1(), var2);
   }

   private float v2(WideRecord.Part2 var1, float var2) {
      return this.v6(var1.v1() + var1.v3(), var2) - this.v6(var1.v1(), var2);
   }

   public static float v2(float var0, float var1, float var2) {
      if (!(var2 > 0.0F)) {
         return 0.0F;
      } else {
         float var3 = (var0 - var1) / var2;
         if (var3 < 0.0F) {
            return 0.0F;
         } else {
            return var3 > 1.0F ? 1.0F : var3;
         }
      }
   }

   public static float v5(float var0, float var1, float var2, float var3) {
      float var4 = var0 + var1 * var2;
      float var5 = var0 + var3;
      float var6 = var0 + var1 - var3;
      if (var4 < var5) {
         return var5;
      } else {
         return var4 > var6 ? var6 : var4;
      }
   }

   @Nullable
   private sykyRecord8 v47() {
      return this.v99 == null ? null : this.v99.v1();
   }

   @Nullable
   private sykyRecord8 v49() {
      sykyRecord8 var1 = this.v47();
      long var2 = System.nanoTime();
      if (var1 != null && var1.v2() != null) {
         this.v98 = 0L;
      } else if (this.v98 == 0L) {
         this.v98 = var2;
      }

      boolean var4 = this.v98 != 0L && var2 - this.v98 < 1000000000L;
      return this.v120.v1(var1, this.v19() || var4);
   }

   @Override
   public void v17() {
      this.v120.v1();
      this.v98 = 0L;
      this.v103 = 0.0F;
      this.v162 = 0.0F;
      this.v107 = 0.0F;
      this.v88 = 0L;
      Arrays.fill(this.v87, 0.0F);
      this.v85 = false;
      this.v119 = 0.0F;
      this.v121 = -1.0F;
      this.v141 = false;
      this.v145 = -1.0F;
      this.v104 = null;
      Arrays.fill(this.v118, 0.0F);
      Arrays.fill(this.v159, false);
      Arrays.fill(this.v176, 0.0F);
      this.v116 = -1;
      this.v147 = false;
      this.v157 = false;
      this.v166 = Long.MIN_VALUE;
   }

   private void v1(float var1, float var2, float var3, WideRecord.Part4 var4, sykyRecord7 var5) {
      float var6 = this.v6(var4.v1() + var4.v3(), var3) - this.v6(var4.v1(), var3);
      this.v1(var5, var1 + this.v6(var4.v1(), var3), var2 + this.v6(var4.v2(), var3), var6, var4.v4() * var3);
   }

   private void v1(sykyRecord7 var1, float var2, float var3, float var4, float var5) {
      uiRecord7 var6 = uiRecord7.v1(var5);
      class_2960 var7 = var1.v4();
      if (var7 != null) {
         uiSupport169.v1(accountSupport3.v1(var7, var4), var2, var3, var4, var4, -1, var6);
      } else {
         this.v1(var2, var3, var4, var4, this.v2(536870911), var6);
      }
   }

   private void v1(float var1, float var2, float var3, WideRecord.Part6 var4, sykyRecord7 var5, long var6) {
      float var8 = var1 + var4.v1() * var3;
      float var9 = var1 + var4.v2() * var3;
      float var10 = 18.0F * var3;
      cloudRecord5 var11 = cloudRecord5.NONE.v1(var9, var10);
      float var12 = var2 + var4.v3() * var3;
      String var13 = var5.v1();
      float var14 = var9 - var8;
      float var15 = var4.v4() * var3;
      float var16 = var4.v6() * var3;
      float var17 = this.v1(var13, var15, var14, var3, var6);
      cloudRecord5 var18 = this.v1(var13, var15, var8, var9, var10, var17);
      float var19 = var8 + var17;
      CopiedSupport2 var20 = this.v124;
      if (var20 != null && var20.v2(var6)) {
         this.v1(var20, var13, var19, var12, var15, var3, var6, var18, var8, var11);
      } else if (var13 != null && !var13.isEmpty()) {
         this.v1("syky_sans_strong", var13, var19, var12, var15, -637534209, var18);
      }

      String var21 = var5.v2();
      float var22 = var2 + var4.v5() * var3;
      CopiedSupport2 var23 = this.v117;
      if (var23 != null && var23.v2(var6)) {
         this.v1(var23, var21, var8, var22, var16, 1509949439, var3, var6, var11);
      } else if (var21 != null && !var21.isEmpty()) {
         this.v1("syky_sans_strong", var21, var8, var22, var16, 1509949439, var11);
      }
   }

   private void v1(CopiedSupport2 var1, @Nullable String var2, float var3, float var4, float var5, int var6, float var7, long var8, cloudRecord5 var10) {
      var1.v3(var8);
      CopiedSupport2.Part1 var11 = var1.v1();
      if (var2 != null && !var2.isEmpty() && var11.v1() > 0.003921569F) {
         this.v1(var11, "syky_sans_strong", var2, var3, var4 + var11.v2() * var7, uiSupport169.v2("syky_sans_strong", var2, var5), var5, var6, var10);
      }

      CopiedSupport2.Part1 var12 = var1.v2();
      if (var12.v1() > 0.003921569F) {
         this.v1(var12, "syky_sans_strong", "Copied!", var3, var4 + var12.v2() * var7, uiSupport169.v2("syky_sans_strong", "Copied!", var5), var5, var6, var10);
      }
   }

   private cloudRecord5 v1(@Nullable String var1, float var2, float var3, float var4, float var5, float var6) {
      if (var1 != null && !var1.isEmpty()) {
         float var7 = -var6;
         float var8 = this.v45.v1(var1, var2) + var6 - (var4 - var3);
         return cloudRecord5.NONE.v1(var3, var4, v15(var7, var5), v15(var8, var5));
      } else {
         return cloudRecord5.NONE.v1(var4, var5);
      }
   }

   private static float v15(float var0, float var1) {
      if (var0 <= 0.0F) {
         return 0.0F;
      } else {
         return var0 < var1 ? var0 : var1;
      }
   }

   private float v1(@Nullable String var1, float var2, float var3, float var4, long var5) {
      if (var1 != null && !var1.isEmpty() && !(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         if (!var1.equals(this.v104)) {
            this.v104 = var1;
            this.v125 = var5;
         }

         float var7 = this.v45.v1(var1, var2) - var3;
         if (var7 <= 6.0F * var4) {
            return 0.0F;
         } else {
            float var8 = var7 / (16.0F * var4) * 1000.0F;
            float var9 = 2.0F * (1600.0F + var8);
            float var10 = (float)(var5 - this.v125) * 1.0E-6F % var9;
            if (var10 < 1600.0F) {
               return 0.0F;
            } else {
               var10 -= 1600.0F;
               if (var10 < var8) {
                  return -var7 * (var10 / var8);
               } else {
                  var10 -= var8;
                  return var10 < 1600.0F ? -var7 : -var7 * (1.0F - (var10 - 1600.0F) / var8);
               }
            }
         }
      } else {
         this.v104 = null;
         return 0.0F;
      }
   }

   private void v1(
      CopiedSupport2 var1, @Nullable String var2, float var3, float var4, float var5, float var6, long var7, cloudRecord5 var9, float var10, cloudRecord5 var11
   ) {
      var1.v3(var7);
      CopiedSupport2.Part1 var12 = var1.v1();
      if (var2 != null && !var2.isEmpty() && var12.v1() > 0.003921569F) {
         this.v1(var12, "syky_sans_strong", var2, var3, var4 + var12.v2() * var6, uiSupport169.v2("syky_sans_strong", var2, var5), var5, -637534209, var9);
      }

      CopiedSupport2.Part1 var13 = var1.v2();
      if (var13.v1() > 0.003921569F) {
         this.v1(
            var13,
            "syky_sans_strong",
            "Copied!",
            var10,
            var4 + var13.v2() * var6,
            uiSupport169.v2("syky_sans_strong", "Copied!", var5),
            var5,
            -637534209,
            var11
         );
      }
   }

   private void v1(boolean var1, float var2) {
      this.v119 = v1(this.v119, var1, 6.0F, var2);
      if (!var1) {
         this.v85 = false;
      } else {
         float var3 = 1.0F - (float)Math.exp(-var2 / 0.6F);
         float var4 = 1.0F - (float)Math.exp(-var2 / 1.2F);
         float var5 = 1.0F - (float)Math.exp(-60.0F * var2);
         float var6 = 1.0F - (float)Math.exp(-5.0F * var2);

         for (int var7 = 0; var7 < 6; var7++) {
            float var8 = this.v101[var7];
            if (!this.v85) {
               this.v96[var7] = var8;
               this.v105[var7] = 0.02F;
            }

            this.v96[var7] = this.v96[var7] + (var8 - this.v96[var7]) * var3;
            this.v105[var7] = this.v105[var7] + (Math.abs(var8 - this.v96[var7]) - this.v105[var7]) * var4;
            float var9 = (var8 - this.v96[var7]) / Math.max(0.02F, this.v105[var7]);
            float var10 = v11(0.5F + 0.5F * var9 / 1.5F) * v11((this.v96[var7] - 0.08F) / 0.15F);
            if (var10 < this.v87[var7]) {
               this.v87[var7] = this.v87[var7] + (var10 - this.v87[var7]) * var6;
            } else if (var10 - this.v87[var7] > 0.12F) {
               this.v87[var7] = this.v87[var7] + (var10 - this.v87[var7]) * var5;
            }
         }

         this.v85 = true;
      }
   }

   private static float v11(float var0) {
      return var0 < 0.0F ? 0.0F : Math.min(1.0F, var0);
   }

   private void v1(float var1, float var2, float var3, WideRecord var4, long var5) {
      WideRecord.Part3 var7 = var4.v5();
      float var8 = this.v103;
      double var9 = var5 * 1.0E-9;
      float var11 = 12.0F;
      uiRecord7 var12 = uiRecord7.v1(1.0F * var3);

      for (int var13 = 0; var13 < v13.length; var13++) {
         float var14 = 2.0F;
         if (var8 > 0.0F) {
            float var15 = 0.5F + 0.3F * (float)Math.sin(var9 * v17[var13] + v19[var13]) + 0.2F * (float)Math.sin(var9 * v17[var13] * 1.7 + v19[var13] * 1.7);
            if (var15 < 0.0F) {
               var15 = 0.0F;
            } else if (var15 > 1.0F) {
               var15 = 1.0F;
            }

            float var16 = this.v87[v21[var13]] * (0.85F + 0.15F * var15) * v33[var13];
            float var17 = var15 * v18[var13];
            float var18 = 2.0F + var11 * (var17 + (var16 - var17) * this.v119);
            var14 += (var18 - var14) * var8;
         }

         float var19 = var7.v2() - var14 * 0.5F;
         this.v2(hudSupport49.v21, var1 + (var7.v1() + v13[var13]) * var3, var2 + var19 * var3, 2.0F * var3, var14 * var3, this.v2(-1713776167), var12);
      }
   }

   private void v1(float var1, float var2, float var3, WideRecord.Part2 var4, float var5, int var6) {
      float var7 = this.v162;
      float var8 = var1 + this.v1(var4, var3);
      float var9 = this.v2(var4, var3);
      float var10 = this.v6(1.0F, var3) * var7;
      float var11 = var2 + this.v6(var4.v2(), var3) - var10;
      float var12 = var2 + this.v6(var4.v2() + 7.0F, var3) + var10 - var11;
      uiRecord7 var13 = uiRecord7.v1(Math.min(11.0F * var3, var12 * 0.5F));
      uiSupport169.v1(var8, var11, var9, var12, 536870911, var13);
      if (var6 > 0) {
         if (var7 > 0.0F && this.v145 >= 0.0F && !this.v44()) {
            this.v1(var8, var11, var9, var12, var13, this.v145, uiSupport155.v1(1040187391, var7));
         }

         if (var5 > 0.0F) {
            this.v1(var8, var11, var9, var12, var13, var5, 1946157055);
         }

         if (var7 > 0.0F) {
            this.v1(var8, var11, var9, var12, var3, var5, var7);
         }
      }
   }

   private void v1(float var1, float var2, float var3, float var4, uiRecord7 var5, float var6, int var7) {
      float var8 = var3 * var6;
      if (var8 < var4) {
         var8 = var4;
      }

      if (var8 > var3) {
         var8 = var3;
      }

      this.v2(hudSupport49.v21, var1, var2, var8, var4, this.v2(var7), var5);
   }

   private void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = var5 * var7 * (1.0F + 0.27272725F * this.v107);
      float var9 = 18.0F * var8;
      float var10 = 13.0F * var8;
      if (!(var9 <= 0.0F)) {
         float var11 = v5(var1, var3, var6, var9 * 0.5F);
         float var12 = var2 + var4 * 0.5F;
         float var13 = var11 - var9 * 0.5F;
         float var14 = var12 - var10 * 0.5F;
         float var15 = var10 * 0.5F;
         float var16 = 2.0F * var8;
         uiSupport169.v1(
            var13 + var16,
            var14 + var16,
            var9 - 2.0F * var16,
            var10 - 2.0F * var16,
            Math.max(0.0F, var15 - var16),
            uiSupport155.v1(Integer.MIN_VALUE, var7),
            5.0F * var5,
            0.0F,
            3.0F * var5
         );
         this.v2(hudSupport49.v21, var13, var14, var9, var10, this.v2(uiSupport155.v1(-1, var7)), uiRecord7.v1(var15));
      }
   }

   private void v2(float var1, float var2, float var3, WideRecord.Part2 var4, float var5, int var6) {
      String var7 = var6 <= 0 ? "—:—" : v7((int)var5);
      String var8 = var6 <= 0 ? "—:—" : v7(var6);
      float var9 = var2 + var4.v4() * var3;
      float var10 = var4.v5() * var3;
      this.v1("syky_sans_strong", var7, var1 + var4.v6() * var3, var9, var10, 2113929215);
      float var11 = uiSupport169.v2("syky_sans_strong", var8, var10);
      this.v1("syky_sans_strong", var8, var1 + var4.v7() * var3 - var11, var9, var10, 2113929215);
   }

   private void v1(float var1, float var2, float var3, WideRecord.Part5 var4, boolean var5) {
      this.v1(
         var5,
         var1 + this.v6(var4.v1(), var3),
         var1 + this.v6(var4.v2(), var3),
         var2 + this.v6(var4.v3(), var3),
         this.v6(var4.v4(), var3),
         this.v6(var4.v5(), var3),
         var1 + this.v6(var4.v6(), var3),
         var2 + this.v6(var4.v7(), var3),
         this.v6(var4.v8(), var3),
         this.v6(var4.v9(), var3)
      );
   }

   private void v1(boolean var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      class_2960 var11 = var1 ? hudSupport49.v24 : hudSupport49.v25;
      float var12 = this.v5(1);
      this.v1(var11, var7 + var9 * var12, var8 + var10 * var12, var9 * (1.0F - 2.0F * var12), var10 * (1.0F - 2.0F * var12), this.v6(1), uiRecord7.ZERO);
      float var13 = this.v5(0);
      this.v1(
         hudSupport49.v22,
         var2 + var5 * var13,
         var4 + var6 * var13,
         var5 * (1.0F - 2.0F * var13),
         var6 * (1.0F - 2.0F * var13),
         1.0F,
         0.0F,
         0.0F,
         1.0F,
         this.v6(0),
         uiRecord7.ZERO
      );
      float var14 = this.v5(2);
      this.v1(
         hudSupport49.v22, var3 + var5 * var14, var4 + var6 * var14, var5 * (1.0F - 2.0F * var14), var6 * (1.0F - 2.0F * var14), this.v6(2), uiRecord7.ZERO
      );
   }

   private float v5(int var1) {
      return 0.07F * this.v176[var1];
   }

   private int v6(int var1) {
      float var2 = this.v118[var1];
      if (var2 <= 0.0F) {
         return -637534209;
      } else {
         int var3 = uiSupport155.v1(-637534209);
         int var4 = Math.round(var3 + (255 - var3) * var2);
         return uiSupport155.v1(-637534209, var4);
      }
   }

   private static String v7(int var0) {
      if (var0 < 0) {
         var0 = 0;
      }

      int var1 = var0 / 60;
      int var2 = var0 % 60;
      StringBuilder var3 = new StringBuilder(5);
      var3.append(var1).append(':');
      if (var2 < 10) {
         var3.append('0');
      }

      var3.append(var2);
      return var3.toString();
   }
}
