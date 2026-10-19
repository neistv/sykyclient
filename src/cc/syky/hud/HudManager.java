package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import cc.syky.cloud.cloudSupport26;
import cc.syky.cloud.cloudSupport53;
import cc.syky.module.visual.visualSupport6;
import cc.syky.ui.uiSupport141;
import cc.syky.ui.uiSupport163;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport258;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1041;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_9779;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HudManager {
   public static final String v1 = "_hud";
   public static final int v2 = 6;
   public static final String v3 = "elements";
   private static final float v4 = 0.08F;
   private static final Logger v5 = LoggerFactory.getLogger("syky.hud");
   private final cloudSupport101 v6;
   private final cloudSupport2 v7;
   private final uiSupport258 v8;
   private final hudSupport32 v9;
   private final HUDEditorSupport v10;
   private final hudSupport45 v11;
   @Nullable
   private hudSupport75 v12;
   @Nullable
   private hudSupport51 v13;
   private final Set<BossBarSupport2> v14 = EnumSet.noneOf(BossBarSupport2.class);
   private final hudSupport39 v15;
   private final visualSupport6<BossBarSupport2> v16 = new visualSupport6<>("elements", BossBarSupport2.class, EnumSet.noneOf(BossBarSupport2.class));
   private final AutoSupport v18 = AutoSupport.v1(this.v16);
   private final Map<String, HudElement> v19 = new LinkedHashMap<>();
   private final hudSupport41 v17 = new hudSupport41(HudManager::v8);
   private final ArrayList<HudElement> v20 = new ArrayList<>();
   private int v21;
   private int v22 = -1;
   private final Map<String, String> v24 = new HashMap<>();
   private long v25;
   private long v26;
   private boolean v27;
   private boolean v28;
   private int v29 = -1;
   private int v30 = -1;
   private boolean v32;
   private final List<HudElement> v23 = new ArrayList<>();
   private final List<HudElement> v33 = Collections.unmodifiableList(this.v23);
   private final Collection<HudElement> v31 = Collections.unmodifiableCollection(this.v19.values());
   private final hudSupport38 v34 = new hudSupport38();
   private final List<HudElement> v36 = new ArrayList<>();
   private final hudSupport38 v38 = new hudSupport38();
   private final hudSupport40 v42;
   private boolean v43;
   private final hudSupport42 v37 = new hudSupport42();
   private final List<HudElement> v48 = new ArrayList<>();
   private boolean v40;
   private final cloudSupport26.Part1 v44 = this::v1;
   @Nullable
   private hudSupport40 v47;
   private hudSupport44 v49 = hudSupport44.DEFAULT;
   private boolean v46;
   private long v51;
   private boolean v50;
   private final Map<String, BossBarSupport2> v60 = new HashMap<>();
   private final Map<String, Boolean> v59 = new HashMap<>();
   private final List<HudElement> v53 = new ArrayList<>();
   private final List<hudRecord4> v63 = new ArrayList<>();
   private boolean v64;

   public HudManager(MySettingsSupport var1, cloudSupport101 var2, cloudSupport2 var3) {
      this(var1, var2, var3, uiSupport258.v1);
   }

   public HudManager(MySettingsSupport var1, cloudSupport101 var2, cloudSupport2 var3, uiSupport258 var4) {
      this.v6 = var2;
      this.v7 = var3;
      this.v42 = new hudSupport40(null, 0, 0, 1.0F, var3, false);
      this.v8 = var4;
      this.v11 = new hudSupport45(var1);
      this.v15 = new hudSupport39(var1);
      this.v9 = new hudSupport32(this, var2);
      this.v10 = new HUDEditorSupport(this);

      for (BossBarSupport2 var8 : BossBarSupport2.values()) {
         for (String var12 : var8.v3()) {
            this.v60.put(var12, var8);
         }
      }

      this.v18.v4().setOnChange(() -> this.v27 = true);
   }

   public HUDEditorSupport v1() {
      return this.v10;
   }

   public AutoSupport v2() {
      return this.v18;
   }

   public hudSupport32 v3() {
      return this.v9;
   }

   public void v1(HudElement var1) {
      if (var1 != null) {
         this.v23.remove(var1);
         this.v23.add(var1);
      }
   }

   public List<HudElement> v4() {
      return this.v33;
   }

   public void v2(HudElement var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("element must not be null");
      } else if (this.v19.putIfAbsent(var1.v1(), var1) != null) {
         throw new IllegalStateException("hud element already registered: " + var1.v1());
      } else {
         this.v21++;
         this.v24.put(var1.v1(), "hud.draw." + var1.v1());
         var1.v2().v1(this.v18);
         AutoSupport var2 = var1.v2();
         if (var1.v37()) {
            this.v17.v2(var1);
         }

         var2.v4().setOnChange(() -> {
            var2.v3();
            this.v27 = true;
         });
      }
   }

   public void v1(hudSupport75 var1, hudSupport51 var2) {
      this.v12 = var1;
      this.v13 = var2;
   }

   @Nullable
   public hudSupport75 v5() {
      return this.v12;
   }

   @Nullable
   public hudSupport51 v6() {
      return this.v13;
   }

   @Nullable
   public class_2960 v1(BossBarSupport2 var1) {
      if (var1 == null) {
         return null;
      } else {
         for (String var5 : var1.v3()) {
            HudElement var6 = this.v19.get(var5);
            if (var6 != null && var6.v38() != null) {
               return var6.v38();
            }
         }

         return null;
      }
   }

   @Nullable
   public BossBarSupport2 v3(HudElement var1) {
      return var1 == null ? null : this.v60.get(var1.v1());
   }

   public void v2(BossBarSupport2 var1) {
      if (var1 != null) {
         this.v16.v2(var1);
      }
   }

   public boolean v3(BossBarSupport2 var1) {
      return var1 != null && (this.v16.v1(var1) || this.v14.contains(var1));
   }

   public void v1(BossBarSupport2 var1, boolean var2) {
      if (var1 != null) {
         if (var2 ? this.v14.add(var1) : this.v14.remove(var1)) {
            this.v27 = true;
         }
      }
   }

   public boolean v4(HudElement var1) {
      return var1 != null && this.v60.containsKey(var1.v1());
   }

   public boolean v5(HudElement var1) {
      BossBarSupport2 var2 = var1 == null ? null : this.v60.get(var1.v1());
      if (var2 != null && this.v16.v1(var2)) {
         this.v16.v2(var2);
         return true;
      } else {
         return false;
      }
   }

   public EnumSet<BossBarSupport2> v7() {
      return EnumSet.copyOf(this.v16.v9());
   }

   public void v1(EnumSet<BossBarSupport2> var1) {
      this.v16.v1(EnumSet.copyOf(var1));
   }

   public hudSupport41 v8() {
      return this.v17;
   }

   private void v1(float var1) {
      this.v22();

      for (int var2 = 0; var2 < this.v20.size(); var2++) {
         HudElement var3 = this.v20.get(var2);
         boolean var4 = var3.v37();
         if (var4 != var3.v12()) {
            if (var4) {
               this.v17.v2(var3);
            } else {
               hudRecord4 var5 = var3.v27();
               this.v17.v3(var3);
               var3.v26();
               if (var1 > 0.0F && !var5.v1()) {
                  var3.v1(hudSupport52.TOP_LEFT);
                  var3.v1(var5.v2() / var1, var5.v3() / var1);
               }
            }
         }
      }
   }

   private void v22() {
      if (this.v22 != this.v21 || this.v20.size() != this.v19.size()) {
         this.v20.clear();

         for (HudElement var2 : this.v19.values()) {
            this.v20.add(var2);
         }

         this.v22 = this.v21;
      }
   }

   public Collection<HudElement> v9() {
      return this.v31;
   }

   public void v10() {
      this.v10.v7();
      this.v9.v3();
      this.v18.v19();
      this.v17.v3();
      this.v19.clear();
      this.v21++;
      this.v24.clear();
      this.v23.clear();
      this.v48.clear();
      this.v59.clear();
      this.v53.clear();
   }

   @Nullable
   public HudElement v1(String var1) {
      return this.v19.get(var1);
   }

   public cloudSupport2 v11() {
      return this.v7;
   }

   public void v12() {
      class_310 var1 = this.v6.v1();
      if (var1 != null && var1.method_22683() != null) {
         this.v18.v1(var1.method_22683().method_4506());
      }

      this.v15.v1(this.v19, this.v18);
      this.v21++;
      int var2 = this.v11.v1(this.v19, this.v17);
      this.v19();
      this.v50 = true;
      this.v1(0.0F);
      this.v32 = true;
      if (var2 > 0) {
         v5.info("loaded {} hud element(s) from persistence", var2);
      }
   }

   public void v1(Runnable var1) {
      this.v10();
      var1.run();
      this.v12();
   }

   public void v13() {
      this.v11.v2(this.v19, this.v17);
      this.v15.v2(this.v19, this.v18);
   }

   private void v1(int var1, int var2, float var3) {
      this.v63.clear();
      this.v22();

      for (int var4 = 0; var4 < this.v20.size(); var4++) {
         HudElement var5 = this.v20.get(var4);
         if (!var5.v12() && !var5.v18().v2() && !var5.v27().v1()) {
            this.v63.add(var5.v27());
         }
      }

      boolean var7 = false;

      for (int var8 = this.v53.size() - 1; var8 >= 0; var8--) {
         HudElement var6 = this.v53.get(var8);
         if (!var6.v10() || !var6.v12()) {
            this.v53.remove(var8);
         } else if (!var6.v27().v1()) {
            this.v53.remove(var8);
            var7 |= this.v17.v1(var6, var1, var2, var3, this.v63);
         }
      }

      if (var7) {
         this.v13();
      }
   }

   public void v14() {
      this.v32 = true;
   }

   private void v2(int var1, int var2, float var3) {
      if (!(var3 <= 0.0F)) {
         this.v22();

         for (int var4 = 0; var4 < this.v20.size(); var4++) {
            HudElement var5 = this.v20.get(var4);
            if (!var5.v12()) {
               v1(var5, var5.v27(), var1, var2, var3);
            }
         }

         List var10 = this.v17.v5();

         for (int var11 = 0; var11 < var10.size(); var11++) {
            List var6 = (List)var10.get(var11);
            hudRecord4 var7 = null;

            for (int var8 = 0; var8 < var6.size(); var8++) {
               hudRecord4 var9 = ((HudElement)var6.get(var8)).v27();
               if (!var9.v1()) {
                  var7 = var7 == null ? var9 : v1(var7, var9);
               }
            }

            if (var7 != null) {
               v1((HudElement)var6.get(0), var7, var1, var2, var3);
            }
         }
      }
   }

   private static void v1(HudElement var0, hudRecord4 var1, int var2, int var3, float var4) {
      if (!var1.v1()) {
         hudSupport52 var5 = var0.v3();
         float var6 = var0.v7();
         float var7 = var0.v8();
         float var8 = var5.v1(var2, var1.v4(), var6 * var4);
         float var9 = var5.v2(var3, var1.v5(), var7 * var4);
         float var10 = v1(var8, 0.0F, var2 - var1.v4());
         float var11 = v1(var9, 0.0F, var3 - var1.v5());
         var0.v2(
            Math.abs(var10 - var8) >= 0.5F ? var5.v3(var2, var1.v4(), var10) / var4 : var6,
            Math.abs(var11 - var9) >= 0.5F ? var5.v4(var3, var1.v5(), var11) / var4 : var7
         );
      }
   }

   private static hudRecord4 v1(hudRecord4 var0, hudRecord4 var1) {
      float var2 = Math.min(var0.v2(), var1.v2());
      float var3 = Math.min(var0.v3(), var1.v3());
      float var4 = Math.max(var0.v2() + var0.v4(), var1.v2() + var1.v4());
      float var5 = Math.max(var0.v3() + var0.v5(), var1.v3() + var1.v5());
      return new hudRecord4(var2, var3, var4 - var2, var5 - var3);
   }

   private static float v1(float var0, float var1, float var2) {
      if (var2 < var1) {
         return var1;
      } else if (var0 < var1) {
         return var1;
      } else {
         return var0 > var2 ? var2 : var0;
      }
   }

   public void v1(class_332 var1, class_9779 var2) {
      this.v1(var1, hudSupport44.BEFORE_HOTBAR, true);
   }

   public void v2(class_332 var1, class_9779 var2) {
      this.v1(var1, hudSupport44.DEFAULT, false);
   }

   private void v1(class_332 var1, hudSupport44 var2, boolean var3) {
      if (!this.v19.isEmpty()) {
         this.v19();
         class_310 var4 = this.v6.v1();
         if (var4 != null) {
            class_1041 var5 = var4.method_22683();
            int var6 = var5.method_4486();
            int var7 = var5.method_4502();
            double var8 = var5.method_4495();
            float var10 = var8 > 0.0 ? (float)(1.0 / var8) : 1.0F;
            if (var3 && this.v18.v1(var5.method_4506())) {
               this.v27 = true;
            }

            boolean var11 = var4.field_1755 instanceof class_408;
            boolean var12 = this.v18.v1();
            if (var3) {
               this.v24();
            }

            long var13 = this.v8.v3();
            boolean var15 = false;
            uiSupport169.v1(var1);

            try {
               hudSupport40 var16 = this.v42.v1(var1, var6, var7, var10, this.v7, var11);
               if (var3) {
                  this.v7.v13();
                  this.v25();
                  if (this.v27) {
                     this.v27 = false;
                     this.v1(var10);
                     this.v32 = true;
                  }

                  this.v1(var16, var11, var4.field_1687 != null && var4.field_1724 != null);
                  this.v10.v1(var11);
                  this.v9.v1(var11, var6, var7, var10);
                  this.v1(var16);
                  this.v3(var16);
               }

               boolean var17 = v1(var4.field_1755);
               boolean var18 = !var3 && var12 && var17;
               var15 = !var3 && var12 && !var17 && this.v64 && uiSupport169.v16();
               if (!var18) {
                  boolean var19 = var2 != hudSupport44.BEFORE_HOTBAR || this.v28;
                  if (var19 && this.v1(var11)) {
                     this.v1(var16, var2, var11, false);
                  }

                  if (var19) {
                     if (!var3) {
                        this.v9.v5();
                     }

                     this.v1(var16, var2);
                     this.v4(var16, var2);
                     this.v5(var16, var2);
                  }

                  if (!var3) {
                     if (var6 != this.v29 || var7 != this.v30) {
                        this.v29 = var6;
                        this.v30 = var7;
                        this.v32 = true;
                     }

                     if (this.v32) {
                        this.v32 = false;
                        this.v2(var6, var7, var10);
                     }

                     if (!this.v53.isEmpty()) {
                        this.v1(var6, var7, var10);
                     }
                  }
               }
            } finally {
               uiSupport169.v11();
               this.v47 = null;
               if (var15) {
                  uiSupport169.v1(var1, var6, var7);
               }

               uiSupport169.v15();
               this.v1(var3 ? "hud.pass.early" : "hud.pass.default", var13);
            }
         }
      }
   }

   public boolean v15() {
      if (this.v64 && this.v18.v1()) {
         class_310 var1 = this.v6.v1();
         if (var1 == null || var1.field_1690.field_1842) {
            return false;
         } else {
            return var1.field_1687 != null && var1.field_1724 != null ? v1(var1.field_1755) : false;
         }
      } else {
         return false;
      }
   }

   private static boolean v1(class_437 var0) {
      return var0 == null || var0 instanceof class_408 || var0 instanceof uiSupport141;
   }

   public boolean v16() {
      if (this.v64 && this.v18.v1()) {
         class_310 var1 = this.v6.v1();
         if (var1 != null && !var1.field_1690.field_1842 && var1.field_1687 != null && var1.field_1724 != null) {
            class_437 var2 = var1.field_1755;
            return var2 != null && !(var2 instanceof class_408) && !(var2 instanceof uiSupport141)
               ? !var2.method_73150() && var1.field_1690.method_57703() >= 1.0F
               : false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void v18() {
      if (this.v15()) {
         class_310 var1 = this.v6.v1();
         boolean var2 = var1.field_1755 instanceof class_408;
         class_1041 var3 = var1.method_22683();
         int var4 = var3.method_4486();
         int var5 = var3.method_4502();
         double var6 = var3.method_4495();
         float var8 = var6 > 0.0 ? (float)(1.0 / var6) : 1.0F;
         long var9 = this.v8.v3();
         int var11 = uiSupport169.v1("gpu.hud.tail");
         uiSupport163.v1();

         try {
            hudSupport40 var12 = this.v42.v1(null, var4, var5, var8, this.v7, var2);
            if (this.v1(var2)) {
               this.v1(var12, hudSupport44.DEFAULT, var2, true);
            }

            uiSupport169.v1(null);

            try {
               this.v9.v5();
               this.v1(var12, hudSupport44.DEFAULT);
               this.v4(var12, hudSupport44.DEFAULT);
               this.v5(var12, hudSupport44.DEFAULT);
               if (var4 != this.v29 || var5 != this.v30) {
                  this.v29 = var4;
                  this.v30 = var5;
                  this.v32 = true;
               }

               if (this.v32) {
                  this.v32 = false;
                  this.v2(var4, var5, var8);
               }

               if (!this.v53.isEmpty()) {
                  this.v1(var4, var5, var8);
               }
            } finally {
               uiSupport169.v15();
            }
         } finally {
            uiSupport169.v11();
            this.v47 = null;
            uiSupport163.v2();
            uiSupport169.v1(var11);
            this.v1("hud.pass.tail", var9);
         }
      }
   }

   public boolean v1(boolean var1) {
      if (var1) {
         return true;
      } else {
         this.v22();

         for (int var2 = 0; var2 < this.v20.size(); var2++) {
            HudElement var3 = this.v20.get(var2);
            if (v8(var3) && var3.v31()) {
               return true;
            }
         }

         return false;
      }
   }

   private void v1(hudSupport40 var1, hudSupport44 var2, boolean var3, boolean var4) {
      this.v47 = var1;
      this.v49 = var2;
      this.v46 = false;
      uiSupport169.v1(this.v44, var4, this.v1(var2, var3));
   }

   public boolean v1(hudSupport44 var1, boolean var2) {
      if (!var2 && !this.v40 && !this.v26()) {
         this.v22();

         for (int var3 = 0; var3 < this.v20.size(); var3++) {
            HudElement var4 = this.v20.get(var3);
            if (var4.v48() == var1 && v8(var4) && var4.v31() && !var4.v33()) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void v1(cloudSupport26 var1) {
      hudSupport40 var2 = this.v47;
      if (var2 != null) {
         if (!this.v46) {
            this.v2(var2);
         }

         this.v22();

         for (int var3 = 0; var3 < this.v20.size(); var3++) {
            HudElement var4 = this.v20.get(var3);
            if (var4.v48() == this.v49 && v8(var4) && var4.v31()) {
               hudRecord4 var5;
               try {
                  var5 = var4.v12() ? var4.v23() : var4.v3(var2);
               } catch (Throwable var7) {
                  this.v1(var4, "animatedFrame", var7);
                  continue;
               }

               if (!var5.v1()) {
                  var1.v1(var5.v2(), var5.v3(), var5.v4(), var5.v5());
               }
            }
         }
      }
   }

   private void v1(String var1, long var2) {
      if (var2 != 0L) {
         long var4 = System.nanoTime() - var2;
         cloudSupport53 var6 = this.v8.v2();
         if (var6 != null) {
            var6.v1(var1, var4);
         }

         this.v26 += var4;
      }
   }

   private void v24() {
      cloudSupport53 var1 = this.v8.v2();
      if (var1 != null && this.v26 > 0L) {
         var1.v1("hud.draw", this.v26);
      }

      this.v26 = 0L;
   }

   public void v19() {
      boolean var1 = false;
      boolean var2 = false;
      this.v22();

      for (int var3 = 0; var3 < this.v20.size(); var3++) {
         HudElement var4 = this.v20.get(var3);
         BossBarSupport2 var5 = this.v60.get(var4.v1());
         boolean var6 = var5 == null || this.v16.v1(var5) || this.v14.contains(var5);
         Boolean var7 = this.v59.get(var4.v1());
         if (var7 == null || var7 != var6) {
            this.v59.put(var4.v1(), var6);
            var4.v1(var6);
            if (var7 != null && var6 && var4.v12()) {
               if (!this.v53.contains(var4)) {
                  this.v53.add(var4);
               }
            } else if (!var6) {
               this.v53.remove(var4);
            }
         }

         var1 |= this.v6(var4);
         var2 |= var4.v48() == hudSupport44.BEFORE_HOTBAR;
      }

      this.v64 = var1;
      this.v28 = var2;
   }

   private boolean v6(HudElement var1) {
      return var1.v10() && this.v60.containsKey(var1.v1()) || !var1.v18().v2();
   }

   public boolean v17() {
      return this.v28;
   }

   public boolean v20() {
      return this.v64;
   }

   private void v1(hudSupport40 var1, boolean var2, boolean var3) {
      long var4 = System.nanoTime();
      long var6 = this.v51;
      this.v51 = var4;
      float var8 = var6 == 0L ? 0.0F : (float)(var4 - var6) / 1000000.0F;
      this.v1(var1, var2, var3, var8, var4);
   }

   public void v1(hudSupport40 var1, boolean var2, boolean var3, float var4) {
      this.v1(var1, var2, var3, var4, System.nanoTime());
   }

   private void v1(hudSupport40 var1, boolean var2, boolean var3, float var4, long var5) {
      this.v22();

      for (int var7 = 0; var7 < this.v20.size(); var7++) {
         HudElement var8 = this.v20.get(var7);
         hudSupport5 var9 = var8.v18();
         boolean var10 = var9.v2();

         boolean var11;
         try {
            var11 = var8.v10() && !var8.v12(var1) && (var2 || !var8.v11(var1));
         } catch (Throwable var15) {
            this.v1(var8, "hidden", var15);
            continue;
         }

         boolean var12 = !var3 || this.v50;
         if (var12) {
            var9.v1(var11);
         } else {
            var9.v1(var11, var4);
         }

         try {
            var8.v1(var1, var5, var12 || var9.v5() || var10);
         } catch (Throwable var14) {
            this.v1(var8, "morphKey", var14);
            continue;
         }

         var8.v4(var1.v5());
         hudSupport3 var13 = var8.v29();
         if (var13 != null && var9.v3()) {
            var13.v3();
         }

         if (var9.v2() && !var10) {
            var8.v2(hudRecord4.EMPTY);
            if (var13 != null) {
               var13.v3();
            }

            var8.v20();
         }
      }

      this.v50 = false;
      boolean var16 = false;

      for (int var17 = 0; var17 < this.v20.size(); var17++) {
         var16 |= this.v6(this.v20.get(var17));
      }

      this.v64 = var16;
   }

   private void v1(hudSupport40 var1) {
      this.v48.clear();
      this.v40 = false;
      this.v22();

      for (int var2 = 0; var2 < this.v20.size(); var2++) {
         HudElement var3 = this.v20.get(var2);
         if (!var3.v18().v2() && var3.v18().v3() && !this.v23.contains(var3)) {
            this.v48.add(var3);
         }
      }

      for (int var9 = 0; var9 < this.v23.size(); var9++) {
         HudElement var12 = this.v23.get(var9);
         if (!var12.v18().v2()) {
            this.v48.add(var12);
         }
      }

      for (int var10 = 0; var10 < this.v48.size(); var10++) {
         this.v40 = this.v40 | this.v48.get(var10).v18().v3();
      }

      if (!this.v48.isEmpty() && (this.v40 || this.v26())) {
         this.v2(var1);
         boolean var11 = hudSupport.v1();

         for (int var13 = 0; var13 < this.v48.size(); var13++) {
            HudElement var4 = this.v48.get(var13);

            hudRecord4 var5;
            try {
               var5 = var4.v2(var1);
            } catch (Throwable var8) {
               hudSupport3 var7 = var4.v29();
               if (var7 != null) {
                  var7.v3();
               }

               this.v1(var4, "wobbleFrame", var8);
               continue;
            }

            if (!var11) {
               hudSupport3 var6 = var4.v29();
               if (var6 != null && var6.v4()) {
                  var6.v3();
               }
            } else if (var5.v1()) {
               hudSupport3 var14 = var4.v29();
               if (var14 != null) {
                  var14.v3();
               }
            } else {
               hudSupport3 var15 = var4.v29();
               if (var15 != null && var15.v4()) {
                  var15.v1(var5.v2(), var5.v3(), var5.v4(), var5.v5(), hudSupport.v3());
               }
            }
         }
      }
   }

   private void v1(HudElement var1, String var2, Throwable var3) {
      v5.warn("hud element '{}' threw in {} — auto-disabling", new Object[]{var1.v1(), var2, var3});
      var1.v1(false);
      var1.v18().v1(false);
      var1.v2(hudRecord4.EMPTY);
   }

   private void v25() {
      long var1 = System.nanoTime();
      if (this.v25 == 0L) {
         this.v25 = var1;
      } else {
         float var3 = (float)(var1 - this.v25) * 1.0E-9F;
         this.v25 = var1;
         if (!(var3 <= 0.0F) && !(var3 > 0.5F)) {
            float var4 = (float)Math.pow(0.5, var3 / 0.08F);
            this.v22();

            for (int var5 = 0; var5 < this.v20.size(); var5++) {
               HudElement var6 = this.v20.get(var5);
               if (var6.v25()) {
                  var6.v5(var4);
               }
            }
         }
      }
   }

   private void v1(hudSupport40 var1, hudSupport44 var2) {
      this.v36.clear();
      this.v3(var1, var2);
      boolean var3 = !this.v1(var2);
      if (var3) {
         List var4 = this.v17.v5();

         for (int var5 = 0; var5 < var4.size(); var5++) {
            List var6 = (List)var4.get(var5);

            for (int var7 = 0; var7 < var6.size(); var7++) {
               HudElement var8 = (HudElement)var6.get(var7);
               if (var8.v48() == var2) {
                  if (this.v7(var8)) {
                     this.v1(var1, var8);
                  } else {
                     this.v2(var1, var8);
                  }
               }
            }
         }

         if (!this.v43) {
            this.v2(var1, var2);
         }

         for (int var12 = 0; var12 < this.v36.size(); var12++) {
            this.v2(var1, this.v36.get(var12));
         }

         this.v46 = true;
         uiSupport169.v8();
         uiSupport169.v19();
         if (!this.v2(var2)) {
            List var14 = this.v17.v5();

            for (int var18 = 0; var18 < var14.size(); var18++) {
               List var22 = (List)var14.get(var18);

               for (int var27 = 0; var27 < var22.size(); var27++) {
                  HudElement var31 = (HudElement)var22.get(var27);
                  if (var31.v48() == var2 && !this.v7(var31)) {
                     this.v1(var1, var31, HudElement.Part2.ICONS);
                  }
               }
            }

            List var19 = this.v17.v5();

            for (int var23 = 0; var23 < var19.size(); var23++) {
               List var28 = (List)var19.get(var23);

               for (int var32 = 0; var32 < var28.size(); var32++) {
                  HudElement var10 = (HudElement)var28.get(var32);
                  if (var10.v48() == var2 && !this.v7(var10)) {
                     this.v1(var1, var10, HudElement.Part2.TEXT);
                  }
               }
            }
         } else {
            List var13 = this.v17.v5();

            for (int var17 = 0; var17 < var13.size(); var17++) {
               List var21 = (List)var13.get(var17);

               for (int var26 = 0; var26 < var21.size(); var26++) {
                  HudElement var9 = (HudElement)var21.get(var26);
                  if (var9.v48() == var2 && !this.v7(var9)) {
                     this.v3(var1, var9);
                  }
               }
            }
         }

         for (int var15 = 0; var15 < this.v36.size(); var15++) {
            this.v3(var1, this.v36.get(var15));
         }
      } else {
         uiSupport169.v8();
         List var11 = this.v17.v5();

         for (int var16 = 0; var16 < var11.size(); var16++) {
            List var20 = (List)var11.get(var16);

            for (int var24 = 0; var24 < var20.size(); var24++) {
               HudElement var29 = (HudElement)var20.get(var24);
               if (var29.v48() == var2) {
                  if (this.v7(var29)) {
                     this.v1(var1, var29);
                  } else {
                     this.v2(var1, var29);
                  }
               }
            }

            uiSupport169.v19();
            List var25 = var20;

            for (int var30 = 0; var30 < var25.size(); var30++) {
               HudElement var33 = (HudElement)var25.get(var30);
               if (var33.v48() == var2 && !this.v7(var33)) {
                  this.v3(var1, var33);
               }
            }
         }
      }
   }

   private void v2(hudSupport40 var1, hudSupport44 var2) {
      hudSupport38 var3 = this.v38;
      var3.v1();

      try {
         float var4 = 2.0F;
         List var5 = this.v17.v5();

         for (int var6 = 0; var6 < var5.size(); var6++) {
            List var7 = (List)var5.get(var6);

            for (int var8 = 0; var8 < var7.size(); var8++) {
               HudElement var9 = (HudElement)var7.get(var8);
               if (var9.v48() == var2 && v8(var9) && !this.v7(var9)) {
                  hudRecord4 var10 = var9.v23();
                  if (!var10.v1()) {
                     v1(var3, var10, var4);
                  }
               }
            }
         }

         this.v22();

         for (int var18 = 0; var18 < this.v20.size(); var18++) {
            HudElement var19 = this.v20.get(var18);
            if (!var19.v12() && var19.v48() == var2 && v8(var19) && !this.v7(var19)) {
               hudRecord4 var20;
               try {
                  var20 = var19.v3(var1);
               } catch (Throwable var16) {
                  this.v1(var19, "animatedFrame", var16);
                  continue;
               }

               if (!var20.v1()) {
                  float var21 = var20.v2() - var4;
                  float var22 = var20.v3() - var4;
                  float var11 = var20.v4() + 2.0F * var4;
                  float var12 = var20.v5() + 2.0F * var4;
                  if (!var19.v2().v8() && !var3.v2(var21, var22, var11, var12)) {
                     this.v36.add(var19);
                  }

                  var3.v1(var21, var22, var11, var12);
               }
            }
         }
      } finally {
         var3.v1();
      }
   }

   public void v2(boolean var1) {
      this.v43 = var1;
   }

   public List<hudRecord4> v21() {
      ArrayList var1 = new ArrayList(this.v36.size());

      for (int var2 = 0; var2 < this.v36.size(); var2++) {
         var1.add(this.v36.get(var2).v23());
      }

      return var1;
   }

   private static void v1(hudSupport38 var0, hudRecord4 var1, float var2) {
      var0.v1(var1.v2() - var2, var1.v3() - var2, var1.v4() + 2.0F * var2, var1.v5() + 2.0F * var2);
   }

   private void v3(hudSupport40 var1, hudSupport44 var2) {
      boolean var3 = false;
      List var4 = this.v17.v5();

      for (int var5 = 0; var5 < var4.size(); var5++) {
         List var6 = (List)var4.get(var5);

         for (int var7 = 0; var7 < var6.size(); var7++) {
            HudElement var8 = (HudElement)var6.get(var7);
            var8.v3(false);
            var3 |= var8.v48() == var2 && v8(var8) && !this.v7(var8) && var8.v2().v8();
         }
      }

      if (var3) {
         this.v2(var1);
         this.v37.v1();
         List var13 = this.v17.v5();

         for (int var14 = 0; var14 < var13.size(); var14++) {
            List var15 = (List)var13.get(var14);

            for (int var16 = 0; var16 < var15.size(); var16++) {
               HudElement var9 = (HudElement)var15.get(var16);
               if (var9.v48() == var2 && v8(var9)) {
                  hudRecord4 var10 = var9.v23();
                  if (!var10.v1()) {
                     boolean var11 = !this.v7(var9) && var9.v2().v8();
                     float var12 = var11 ? hudSupport66.v4() * var9.v6(var1) : 0.0F;
                     if (!this.v37.v1(var10, var9.v7(var1), var12)) {
                        break;
                     }

                     var9.v3(var11);
                  }
               }
            }
         }

         this.v37.v1(hudSupport66.v5());
      }
   }

   private void v1(hudSupport38 var1, List<HudElement> var2, hudSupport44 var3) {
      float var4 = Float.POSITIVE_INFINITY;
      float var5 = Float.POSITIVE_INFINITY;
      float var6 = Float.NEGATIVE_INFINITY;
      float var7 = Float.NEGATIVE_INFINITY;
      boolean var8 = false;
      List var9 = var2;

      for (int var10 = 0; var10 < var9.size(); var10++) {
         HudElement var11 = (HudElement)var9.get(var10);
         if (var11.v48() == var3 && v8(var11)) {
            hudRecord4 var12 = var11.v27();
            if (!var12.v1()) {
               float var13 = var12.v2() + var12.v4();
               float var14 = var12.v3() + var12.v5();
               if (var12.v2() < var4) {
                  var4 = var12.v2();
               }

               if (var12.v3() < var5) {
                  var5 = var12.v3();
               }

               if (var13 > var6) {
                  var6 = var13;
               }

               if (var14 > var7) {
                  var7 = var14;
               }

               var8 = true;
            }
         }
      }

      if (var8 && var6 - var4 > 0.0F && var7 - var5 > 0.0F) {
         var1.v1(var4, var5, var6 - var4, var7 - var5);
      }
   }

   private boolean v1(hudSupport44 var1) {
      hudSupport38 var2 = this.v34;
      var2.v1();
      List var3 = this.v17.v5();

      for (int var4 = 0; var4 < var3.size(); var4++) {
         this.v1(var2, (List<HudElement>)var3.get(var4), var1);
      }

      boolean var8;
      try {
         var8 = var2.v3();
      } finally {
         var2.v1();
      }

      return var8;
   }

   private boolean v2(hudSupport44 var1) {
      hudSupport38 var2 = this.v34;
      var2.v1();
      List var3 = this.v17.v5();

      for (int var4 = 0; var4 < var3.size(); var4++) {
         List var5 = (List)var3.get(var4);

         for (int var6 = 0; var6 < var5.size(); var6++) {
            HudElement var7 = (HudElement)var5.get(var6);
            if (var7.v48() == var1 && !this.v7(var7) && v8(var7)) {
               hudRecord4 var8 = var7.v23();
               if (!var8.v1()) {
                  var2.v1(var8.v2(), var8.v3(), var8.v4(), var8.v5());
               }
            }
         }
      }

      boolean var12;
      try {
         var12 = var2.v3();
      } finally {
         var2.v1();
      }

      return var12;
   }

   private void v4(hudSupport40 var1, hudSupport44 var2) {
      this.v22();

      for (int var3 = 0; var3 < this.v20.size(); var3++) {
         HudElement var4 = this.v20.get(var3);
         if (!var4.v12() && var4.v48() == var2 && !this.v7(var4) && !this.v36.contains(var4)) {
            this.v2(var1, var4);
            uiSupport169.v19();
            this.v3(var1, var4);
         }
      }
   }

   private void v5(hudSupport40 var1, hudSupport44 var2) {
      if (!this.v48.isEmpty()) {
         for (int var3 = 0; var3 < this.v48.size(); var3++) {
            HudElement var4 = this.v48.get(var3);
            if (var4.v48() == var2 && v8(var4)) {
               hudRecord4 var5 = var4.v32();
               float var6 = var4.v2().v8() ? var4.v6(var1) : 0.0F;
               boolean var7 = hudSupport2.v1(var4.v29(), var5.v2(), var5.v3(), var5.v4(), var5.v5(), var6);

               try {
                  hudSupport5 var8 = var4.v18();
                  boolean var9 = var8.v3() && this.v1(var5, var6, var7);

                  try {
                     this.v2(var1, var4);
                     uiSupport169.v19();
                     this.v3(var1, var4);
                  } finally {
                     if (var9) {
                        this.v1(var1, var8, var5, var6, !var7);
                     }
                  }
               } finally {
                  if (var7) {
                     hudSupport2.v1();
                  }
               }
            }
         }
      }
   }

   private boolean v1(hudRecord4 var1, float var2, boolean var3) {
      boolean var4 = !var3 && !var1.v1();
      if (var4) {
         float var5 = hudSupport2.v1(var2);
         uiSupport169.v6(var1.v2() - var5, var1.v3() - var5, var1.v4() + 2.0F * var5, var1.v5() + 2.0F * var5);
      }

      if (uiSupport169.v5()) {
         return true;
      } else {
         if (var4) {
            uiSupport169.v17();
         }

         return false;
      }
   }

   private void v1(hudSupport40 var1, hudSupport5 var2, hudRecord4 var3, float var4, boolean var5) {
      float var6 = var3.v2() + var3.v4() * 0.5F;
      float var7 = var3.v3() + var3.v5() * 0.5F;
      if (var5) {
         uiSupport169.v17();
         float var8 = 2.0F * v1(var1, var2) + 1.0F;
         float var9 = (var3.v4() * 0.5F + hudSupport2.v1(var4)) * var2.v8() + var8;
         float var10 = (var3.v5() * 0.5F + hudSupport2.v1(var4)) * var2.v9() + var8;
         uiSupport169.v6(var6 - var9, var7 - var10, var9 * 2.0F, var10 * 2.0F);
      }

      uiSupport169.v1(var2.v7(), var6, var7, var2.v8(), var2.v9(), v1(var1, var2));
      if (var5) {
         uiSupport169.v17();
      }
   }

   private static float v1(hudSupport40 var0, hudSupport5 var1) {
      return hudSupport70.v1() ? var1.v10() * var0.v5() : 0.0F;
   }

   private boolean v26() {
      for (int var1 = 0; var1 < this.v48.size(); var1++) {
         hudSupport3 var2 = this.v48.get(var1).v29();
         if (var2 != null && var2.v4()) {
            return true;
         }
      }

      return false;
   }

   private void v2(hudSupport40 var1) {
      List var2 = this.v17.v5();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         List var4 = (List)var2.get(var3);

         for (int var5 = 0; var5 < var4.size(); var5++) {
            this.v1(var1, (HudElement)var4.get(var5));
         }
      }

      this.v46 = true;
   }

   private boolean v7(HudElement var1) {
      return !this.v48.isEmpty() && this.v48.contains(var1);
   }

   private static boolean v8(HudElement var0) {
      return !var0.v18().v2();
   }

   private void v1(hudSupport40 var1, HudElement var2) {
      if (v8(var2)) {
         try {
            var2.v10(var1);
         } catch (Throwable var4) {
            this.v1(var2, "measure", var4);
         }
      }
   }

   private void v2(hudSupport40 var1, HudElement var2) {
      if (v8(var2)) {
         try {
            var2.v8(var1);
         } catch (Throwable var4) {
            this.v1(var2, "drawBackdrop", var4);
         }
      }
   }

   private void v3(hudSupport40 var1) {
      this.v22();

      for (int var2 = 0; var2 < this.v20.size(); var2++) {
         HudElement var3 = this.v20.get(var2);
         if (v8(var3)) {
            try {
               var3.v13(var1);
            } catch (Throwable var5) {
               this.v1(var3, "renderEarlyItems", var5);
            }
         }
      }
   }

   private void v1(HudElement var1, long var2) {
      if (var2 != 0L) {
         this.v8.v1(this.v24.get(var1.v1()), var2);
      }
   }

   private void v3(hudSupport40 var1, HudElement var2) {
      if (v8(var2)) {
         long var3 = this.v8.v3();

         try {
            var2.v9(var1);
            this.v1(var2, var3);
         } catch (Throwable var6) {
            this.v1(var2, var3);
            this.v1(var2, "render", var6);
         }
      }
   }

   private void v1(hudSupport40 var1, HudElement var2, HudElement.Part2 var3) {
      if (v8(var2)) {
         if (var3 == HudElement.Part2.ICONS) {
            long var4 = this.v8.v3();

            try {
               var2.v1(var1, var3);
               this.v1(var2, var4);
            } catch (Throwable var8) {
               this.v1(var2, var4);
               this.v1(var2, "render", var8);
            }
         } else {
            try {
               var2.v1(var1, var3);
            } catch (Throwable var7) {
               this.v1(var2, "render", var7);
            }
         }
      }
   }
}
