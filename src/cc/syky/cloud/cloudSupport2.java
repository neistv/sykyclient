package cc.syky.cloud;

import cc.syky.sykyRecord4;
import cc.syky.config.configSupport5;
import cc.syky.config.configSupport6;
import cc.syky.hud.BossBarSupport2;
import cc.syky.hud.HudManager;
import cc.syky.hud.hudSupport49;
import cc.syky.hud.hudSupport51;
import cc.syky.hud.hudSupport75;
import cc.syky.internal.InternalSupport58;
import cc.syky.internal.InternalSupport7;
import cc.syky.internal.InternalSupport9;
import cc.syky.mixin.accessor.ClientInteractionBreakAccessor;
import cc.syky.module.ModuleContract;
import cc.syky.module.utilities.EndCrystalSupport;
import cc.syky.module.visual.visualSupport64;
import cc.syky.ui.WinsSupport;
import cc.syky.ui.uiRecord2;
import cc.syky.ui.uiSupport10;
import cc.syky.ui.uiSupport11;
import cc.syky.ui.uiSupport12;
import cc.syky.ui.uiSupport13;
import cc.syky.ui.uiSupport143;
import cc.syky.ui.uiSupport226;
import cc.syky.ui.uiSupport241;
import java.lang.ref.WeakReference;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import net.minecraft.class_1291;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_156;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2935;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_640;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import net.minecraft.class_8110;
import net.minecraft.class_8111;
import net.minecraft.class_8921;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport2 {
   private static final int v1 = 10;
   private static final long v2 = 1000000000L;
   private static final float v3 = -1.0F;
   private static final long v4 = 1000000000L;
   private static final long v5 = 2000000000L;
   private final cloudSupport101 v6;
   @Nullable
   private final uiSupport226 v7;
   @Nullable
   private hudSupport75 v8;
   @Nullable
   private HudManager v9;
   @Nullable
   private InternalSupport7 v10;
   private boolean v11;
   private int v12;
   private boolean v13;
   @Nullable
   private String v14;
   private double v15;
   private double v16;
   private double v18;
   private float v19;
   private float v17;
   private int v20;
   private LocalTime v21 = LocalTime.now(ZoneId.systemDefault());
   private LocalDate v22 = LocalDate.now(ZoneId.systemDefault());
   private final long v24 = System.nanoTime();
   private long v25;
   private static final long v26 = 24000L;
   private long v27 = -1L;
   @Nullable
   private List<cloudRecord2> v28 = List.of();
   private long v29;
   private List<cloudRecord> v30 = List.of();
   @Nullable
   private uiRecord2 v32;
   @Nullable
   private cloudRecord3 v23;
   private final int[] v33 = new int[EndCrystalSupport.COUNT];
   private final int[] v31 = new int[EndCrystalSupport.COUNT];
   private boolean v34;
   private final cloudSupport4 v36 = new cloudSupport4();
   private final List<cloudRecord> v38 = new ArrayList<>(8);
   private int v42;
   private final cloudSupport8 v43 = new cloudSupport8();
   private final uiSupport10 v37 = new uiSupport10();
   private final uiSupport12 v48 = new uiSupport12();
   private final cloudSupport3 v40 = new cloudSupport3();
   private long v44;
   private long v47;
   private final uiSupport11 v49 = new uiSupport11();
   private final cloudSupport6 v46 = new cloudSupport6();
   private final configSupport6 v51 = new configSupport6();
   private final configSupport5 v50 = new configSupport5(this.v51, this.v36);
   private final uiSupport13 v60 = new uiSupport13();
   private final IntPredicate v59 = this::v1;
   private float v53 = 3.0F;
   private final cloudSupport7 v63 = new cloudSupport7();
   private WeakReference<class_638> v64 = new WeakReference<>(null);
   private long v61;
   private long v66;
   private final cloudSupport5 v68 = new cloudSupport5();

   public void v1(hudSupport75 var1, HudManager var2) {
      this.v8 = var1;
      this.v9 = var2;
   }

   public void v1(InternalSupport7 var1) {
      this.v10 = var1;
   }

   public cloudSupport2(cloudSupport101 var1, cloudSupport92 var2) {
      this(var1, var2, null, null);
   }

   public cloudSupport2(cloudSupport101 var1, cloudSupport92 var2, @Nullable uiSupport226 var3, @Nullable hudSupport75 var4) {
      this.v6 = var1;
      this.v7 = var3;
      this.v8 = var4;
      var2.v1(InternalSupport58.class, var1x -> this.v49(), 200);
      var2.v1(uiSupport241.class, var1x -> this.v2(var1x.v1), 100);
      var2.v1(visualSupport64.class, var1x -> this.v1(var1x.v1()), 150);
   }

   private void v1(@Nullable class_1297 var1) {
      if (var1 != null) {
         class_310 var2 = this.v6.v1();
         if (var2 != null) {
            class_746 var3 = var2.field_1724;
            if (var3 != null && var1 != var3) {
               double var4 = var1.method_5829().method_49271(var3.method_33571());
               this.v49.v1((float)Math.sqrt(var4), System.nanoTime());
               this.v46.v1(var1.method_5628());
            }
         }
      }
   }

   public void v1(int var1, int var2, class_6880<class_8110> var3) {
      class_310 var4 = this.v6.v1();
      class_746 var5 = var4 != null ? var4.field_1724 : null;
      if (var5 != null && var2 >= 0 && !var3.method_40225(class_8111.field_42330)) {
         int var6 = var5.method_5628();
         if (var1 != var2) {
            long var7 = System.nanoTime();
            if (var2 == var6) {
               this.v46.v1(var1, var7);
            } else if (var1 == var6) {
               this.v46.v2(var2, var7);
            }
         }
      }
   }

   public void v1(int var1, class_6880<class_1291> var2, int var3, int var4) {
      class_310 var5 = this.v6.v1();
      class_746 var6 = var5 != null ? var5.field_1724 : null;
      class_638 var7 = var5 != null ? var5.field_1687 : null;
      if (var6 != null && var7 != null && var1 == var6.method_5628() && var4 > 0) {
         this.v50.v1(var6, var7, var2, var3, var4);
      }
   }

   public void v1(int var1, int var2, int var3) {
      class_310 var4 = this.v6.v1();
      class_746 var5 = var4 != null ? var4.field_1724 : null;
      class_638 var6 = var4 != null ? var4.field_1687 : null;
      if (var5 != null && var6 != null && var2 == var5.method_5628()) {
         class_1799 var7 = switch (var6.method_8469(var1)) {
            case class_1542 var10 -> var10.method_6983();
            case class_1665 var11 -> var11.method_54759();
            case null, default -> class_1799.field_8037;
         };
         this.v60.v1(var7, var3, System.nanoTime());
      }
   }

   private boolean v1(int var1) {
      class_638 var2 = this.v6.v3();
      return var2 != null && var2.method_8469(var1) != null;
   }

   private void v2(int var1) {
      class_310 var2 = this.v6.v1();
      if (var2 != null && var2.field_1755 == null) {
         this.v68.v1(var1, System.nanoTime());
      }
   }

   public int v1() {
      return this.v68.v1(System.nanoTime());
   }

   public int v2() {
      return this.v68.v2(System.nanoTime());
   }

   private void v49() {
      this.v32 = null;
      this.v23 = null;
      this.v34 = false;
      class_310 var1 = this.v6.v1();
      if (var1 == null) {
         this.v63.v1();
         this.v11 = false;
      } else {
         long var2 = System.nanoTime();
         this.v20 = var1.method_47599();
         LocalDateTime var4 = LocalDateTime.now(ZoneId.systemDefault());
         this.v21 = var4.toLocalTime();
         this.v22 = var4.toLocalDate();
         this.v25 = (var2 - this.v24) / 1000000000L;
         this.v30 = this.v51();
         class_638 var5 = var1.field_1687;
         this.v27 = var5 != null && !var1.method_1555() ? var5.method_8532() / 24000L : -1L;
         if (var5 != this.v64.get()) {
            this.v64 = new WeakReference<>(var5);
            this.v37.v1();
            this.v43.v1();
         }

         if (var1.method_1493()) {
            this.v37.v2(var2);
         } else {
            this.v37.v1(var2);
         }

         this.v48.v1(var2);
         this.v46.v1(var2);
         class_746 var6 = var1.field_1724;
         if (var6 == null) {
            this.v28 = List.of();
            this.v51.v3();
            this.v60.v3();
            this.v43.v1();
            this.v63.v1();
            this.v11 = false;
         } else {
            if (!this.v51.v2()) {
               this.v51.v1(var2, this.v59);
            }

            if (!this.v60.v2()) {
               this.v60.v2(var2);
            }

            this.v15 = var6.method_23317();
            this.v16 = var6.method_23318();
            this.v18 = var6.method_23321();
            this.v19 = var6.method_36454();
            this.v17 = var6.method_36455();
            double var7 = var6.method_55755();
            this.v53 = var7 > 0.0 ? (float)var7 : 3.0F;
            this.v43.v1(this.v15, this.v18, v2(var1));
            this.v1(var1, var6);
            this.v46();
            if (++this.v42 >= 10) {
               this.v42 = 0;
               this.v48.v1(v3(var1, var6));
            }

            this.v1(var1, var2);
            if (var6.method_6026().isEmpty()) {
               this.v28 = List.of();
            } else {
               this.v28 = null;
               this.v29 = var2;
            }
         }
      }
   }

   private void v46() {
      InternalSupport7 var1 = this.v10;
      InternalSupport9 var2 = var1 == null ? null : var1.v16();
      this.v11 = var2 != null && var2.v2();
      if (var2 != null && this.v11) {
         this.v12 = var2.v5().v1();
         this.v13 = var2.v7();
         this.v14 = var2.v1(System.currentTimeMillis());
      }
   }

   private void v1(class_310 var1, class_1657 var2) {
      float var3 = v2(var1, var2);
      if (var3 < 0.0F) {
         this.v63.v1(v1(var1));
      } else {
         this.v63.v1(var3);
      }
   }

   private static boolean v1(class_310 var0) {
      return var0.field_1755 == null && var0.field_1690.field_1886.method_1434() && var0.field_1729.method_1613();
   }

   private static float v2(class_310 var0, class_1657 var1) {
      class_636 var2 = var0.field_1761;
      class_638 var3 = var0.field_1687;
      if (var2 != null && var3 != null && var2.method_2923()) {
         ClientInteractionBreakAccessor var4 = (ClientInteractionBreakAccessor)var2;
         class_2338 var5 = var4.syky$breakingPos();
         if (var5 == null) {
            return -1.0F;
         } else {
            class_2680 var6 = var3.method_8320(var5);
            if (var6.method_26215()) {
               return -1.0F;
            } else {
               float var7 = 1.0F - var4.syky$breakingProgress();
               if (var7 <= 0.0F) {
                  return 0.0F;
               } else {
                  float var8 = var6.method_26165(var1, var3, var5);
                  float var9 = v2(var0);
                  return var8 > 0.0F && var9 > 0.0F ? var7 / var8 / var9 : Float.POSITIVE_INFINITY;
               }
            }
         }
      } else {
         return -1.0F;
      }
   }

   private List<cloudRecord> v51() {
      hudSupport75 var1 = this.v8;
      if (var1 == null) {
         return List.of();
      } else {
         this.v38.clear();
         if (this.v7 != null) {
            for (ModuleContract var3 : this.v7.v1()) {
               if (var3.isEnabled()) {
                  String var4 = v1(var1, var3.getName());
                  if (var4 != null) {
                     this.v38.add(new cloudRecord(var3.getName(), var3.getDisplayName(), var4, uiSupport143.v1(var3.getCategory())));
                  }
               }
            }
         }

         HudManager var9 = this.v9;
         if (var9 != null) {
            for (BossBarSupport2 var6 : BossBarSupport2.values()) {
               if (var9.v3(var6)) {
                  String var7 = hudSupport51.v1(var6);
                  String var8 = v1(var1, var7);
                  if (var8 != null) {
                     this.v38.add(new cloudRecord(var7, var6.v1(), var8, var9.v1(var6)));
                  }
               }
            }
         }

         InternalSupport7 var11 = this.v10;
         if (var11 != null) {
            for (InternalSupport7.Part3 var14 : var11.v14()) {
               sykyRecord4 var15 = var14.v1();
               if (var15.v1()) {
                  String var16 = var11.v2(var15);
                  String var17 = v1(var1, var16);
                  if (var17 != null) {
                     this.v38.add(new cloudRecord(var16, var15.v5(), var17, hudSupport49.v19));
                  }
               }
            }
         }

         return this.v38.isEmpty() ? List.of() : List.copyOf(this.v38);
      }
   }

   @Nullable
   private static String v1(hudSupport75 var0, String var1) {
      cloudRecord11 var2 = var0.v3(var1).orElse(null);
      return var2 != null && var2.v3() != -1 ? cloudSupport94.v2(var2.v1()) : null;
   }

   private static int v3(class_310 var0, class_1657 var1) {
      class_634 var2 = var0.method_1562();
      if (var2 == null) {
         return -1;
      } else {
         class_640 var3 = var2.method_2871(var1.method_5667());
         return var3 != null ? var3.method_2959() : -1;
      }
   }

   private void v1(class_310 var1, long var2) {
      if (var2 - this.v61 <= 2000000000L) {
         if (var2 - this.v66 >= 1000000000L) {
            class_634 var4 = var1.method_1562();
            if (var4 != null) {
               this.v66 = var2;
               var4.method_52787(new class_2935(class_156.method_658()));
            }
         }
      }
   }

   public double v3() {
      return this.v15;
   }

   public double v4() {
      return this.v16;
   }

   public double v5() {
      return this.v18;
   }

   public float v6() {
      return this.v19;
   }

   public float v7() {
      return this.v17;
   }

   public double v8() {
      return this.v43.v2();
   }

   public int v9() {
      return this.v48.v4();
   }

   public boolean v10() {
      return this.v48.v3();
   }

   public void v11() {
      this.v61 = System.nanoTime();
   }

   public int v12() {
      return this.v20;
   }

   public void v13() {
      long var1 = System.nanoTime();
      this.v40.v1(var1);
      this.v44++;
      this.v47 = var1;
   }

   public long v14() {
      return this.v44;
   }

   public long v15() {
      return this.v47;
   }

   public double v16() {
      return this.v40.v1();
   }

   public int v18() {
      return this.v40.v2();
   }

   public double v19() {
      return this.v37.v2();
   }

   public boolean v17() {
      return this.v37.v3();
   }

   public void v1(long var1) {
      class_310 var3 = this.v6.v1();
      class_8921 var4 = var3 != null && var3.field_1687 != null ? var3.field_1687.method_54719() : null;
      float var5 = var4 != null ? var4.method_54748() : 20.0F;
      boolean var6 = var4 != null && var4.method_54754();
      this.v37.v1(var1, System.nanoTime(), var5, var6);
   }

   private static float v2(class_310 var0) {
      class_638 var1 = var0.field_1687;
      return var1 != null ? var1.method_54719().method_54748() : 20.0F;
   }

   public void v2(long var1) {
      this.v48.v1(var1, System.nanoTime());
   }

   public void v20() {
      this.v48.v1();
   }

   public void v21() {
      this.v37.v1();
      this.v48.v2();
      this.v49.v1();
      this.v46.v1();
      this.v51.v3();
      this.v60.v3();
      this.v63.v1();
      this.v53 = 3.0F;
   }

   public uiSupport11 v22() {
      return this.v49;
   }

   public cloudSupport6 v24() {
      return this.v46;
   }

   public configSupport6 v25() {
      return this.v51;
   }

   public uiSupport13 v26() {
      return this.v60;
   }

   public boolean v27() {
      return this.v63.v2();
   }

   public boolean v28() {
      return this.v11;
   }

   public int v29() {
      return this.v12;
   }

   public boolean v30() {
      return this.v13;
   }

   @Nullable
   public String v32() {
      return this.v14;
   }

   public float v23() {
      return this.v63.v3();
   }

   public float v33() {
      return this.v53;
   }

   public LocalTime v31() {
      return this.v21;
   }

   public LocalDate v34() {
      return this.v22;
   }

   public long v36() {
      return this.v25;
   }

   public long v38() {
      return this.v27;
   }

   public List<cloudRecord2> v42() {
      List var1 = this.v28;
      if (var1 != null) {
         return var1;
      } else {
         class_310 var2 = this.v6.v1();
         class_746 var3 = var2 == null ? null : var2.field_1724;
         List var4 = var3 == null ? List.of() : this.v36.v1(var3.method_6026(), this.v29);
         this.v28 = var4;
         return var4;
      }
   }

   public long v43() {
      return this.v36.v1();
   }

   public List<cloudRecord> v37() {
      return this.v30;
   }

   public uiRecord2 v48() {
      uiRecord2 var1 = this.v32;
      if (var1 != null) {
         return var1;
      } else {
         uiRecord2 var2 = WinsSupport.v1(this.v6.v1());
         this.v32 = var2;
         return var2;
      }
   }

   public cloudRecord3 v40() {
      cloudRecord3 var1 = this.v23;
      if (var1 != null) {
         return var1;
      } else {
         cloudRecord3 var2 = BossBarSupport.v1(this.v6.v1());
         this.v23 = var2;
         return var2;
      }
   }

   public int[] v44() {
      this.v50();
      return this.v33;
   }

   public int[] v47() {
      this.v50();
      return this.v31;
   }

   private void v50() {
      if (!this.v34) {
         class_310 var1 = this.v6.v1();
         EndCrystalSupport.v1(var1 == null ? null : var1.field_1724, this.v33, this.v31);
         this.v34 = true;
      }
   }
}
