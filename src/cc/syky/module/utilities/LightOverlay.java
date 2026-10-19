package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.internal.InternalSupport10;
import cc.syky.internal.InternalSupport11;
import cc.syky.internal.InternalSupport34;
import cc.syky.internal.InternalSupport35;
import cc.syky.internal.InternalSupport36;
import cc.syky.mixin.accessor.BlockItemInvoker;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiRecord8;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport178;
import cc.syky.ui.uiSupport179;
import cc.syky.ui.uiSupport180;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1268;
import net.minecraft.class_1747;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_4076;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_239.class_240;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ModuleInfo(
   name = "lightoverlay",
   displayName = "Light Overlay",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.lightoverlay.description"
)
public final class LightOverlay extends Module {
   private static final Logger v2 = LoggerFactory.getLogger("syky.lightoverlay");
   private static final long name = 600000L;
   private static final long displayName = 400000000L;
   private static final int category = 20;
   private static final int group = 14;
   private static final double description = 0.125;
   private static final double defaultEnabled = 0.625;
   private static final float subscriptions = 0.45F;
   private static final float enableAction = 0.6F;
   private static final float disableAction = 0.6F;
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -50384));
   private final IntSetting fillOpacity = this.settings.add(new IntSetting("fillOpacity", 35, 0, 100));
   private final BooleanSetting outline = this.settings.add(new BooleanSetting("outline", true));
   private final FloatSetting thickness = this.settings.add(new FloatSetting("thickness", 1.0F, 0.5F, 4.0F).setCondition(this.outline));
   private final BooleanSetting fromBelow = this.settings.add(new BooleanSetting("fromBelow", true));
   private final IntSetting range = this.settings.add(new IntSetting("range", 24, 8, 48));
   private final BooleanSetting torchHints = this.settings.add(new BooleanSetting("torchHints", true));
   private final ColorSetting hintColor = this.settings.add(new ColorSetting("hintColor", -15821).setCondition(this.torchHints));
   private final BooleanSetting placePreview = this.settings.add(new BooleanSetting("placePreview", true));
   private final ColorSetting previewColor = this.settings.add(new ColorSetting("previewColor", -13318311).setCondition(this.placePreview));
   private final uiRecord14 v22;
   private final Long2ObjectOpenHashMap<uiSupport178.Part1> v24 = new Long2ObjectOpenHashMap();
   private final LongArrayList v25 = new LongArrayList();
   private final LongOpenHashSet v26 = new LongOpenHashSet();
   private final LongOpenHashSet v27 = new LongOpenHashSet();
   private final class_2339 v28 = new class_2339();
   @Nullable
   private class_638 v29;
   private uiSupport178.Part2 v30 = new uiSupport178.Part2(0, 7);
   private int v32;
   private int v23;
   private int v33;
   private int v31 = -1;
   private int v34 = -1;
   private int v36 = -1;
   private int v38;
   private int v42;
   private int v43;
   private int v37 = -1;
   private int v48 = -1;
   private int v40 = -1;
   private int v44;
   private int v47;
   private long v49;
   private int v46 = -1;
   private long[] v51;
   @Nullable
   private LightOverlay.Part3 v50;
   @Nullable
   private InternalSupport36 v60;
   @Nullable
   private LightOverlay.Part3 v59;
   private long[] v53;
   private boolean v63;
   private long v64;
   private int v61;
   private int v66;
   @Nullable
   private volatile LightOverlay.Part6 v68;
   private int v52;
   private int v75;
   private InternalSupport34<LightOverlay.Part3> v73;
   private boolean v74;
   private int v72;
   private int v80;
   @Nullable
   private volatile LightOverlay.Part5 v84;
   @Nullable
   private volatile LightOverlay.Part5 v94;
   private static final long[] v82 = new long[0];

   @Nullable
   public LightOverlay.Part1 v17() {
      LightOverlay.Part5 var1 = this.v94;
      LightOverlay.Part8 var2 = var1 == null ? null : var1.v7();
      if (var2 == null) {
         return null;
      } else {
         uiSupport179.Part3 var3 = uiSupport179.v1(var2.v1(), var2.v2(), var2.v3(), var2.v4(), var2.v5(), var2.v6(), var2.v7(), var2.v8());
         long var4 = var3.v6() / 1000000L;
         return new LightOverlay.Part1(var3.v1(), var3.v2(), var3.v3(), var3.v4(), var3.v5(), var4);
      }
   }

   public LightOverlay.Part9 v20() {
      LightOverlay.Part5 var1 = this.v94;
      boolean var2 = this.v28();
      boolean var3 = var1 != null && !this.v74 && this.v72 == this.v47;
      return new LightOverlay.Part9(var2, var3, this.v27(), var1 != null ? (long[])var1.v3().clone() : new long[0], var1 != null ? var1.v6() : 0L, this.v47);
   }

   public LightOverlay(uiRecord14 var1) {
      this.v51 = v82;
      this.v53 = v82;
      this.v61 = -1;
      this.v66 = -1;
      this.v72 = -1;
      this.v80 = -1;
      this.v22 = var1;
      this.v73 = this.v21();
      this.setToggleActions(() -> uiSupport180.v1 = true, () -> {
         uiSupport180.v1 = false;
         uiSupport180.v2();
      });
   }

   private InternalSupport34<LightOverlay.Part3> v21() {
      return new InternalSupport34<>(this.v22.v3()::v1, LightOverlay::v1);
   }

   @Override
   public void onDisableHook() {
      this.v29();
      this.v29 = null;
   }

   @Override
   public void onRenderHook() {
      this.v29();
      this.v29 = null;
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      class_310 var2 = this.v22.v2().v1();
      class_638 var3 = var2.field_1687;
      class_746 var4 = var2.field_1724;
      if (var3 != null && var4 != null) {
         if (var3 != this.v29) {
            this.v29();
            this.v29 = var3;
            this.v30 = uiSupport178.Part2.v1(var3.method_8597());
         }

         this.v1(var3, var4);
         this.v22();
         if (++this.v75 % 20 == 0) {
            this.v24();
         }

         this.v2(var3, var4);
         this.v1(var2, var4);
         this.v25();
         this.v1(var4);
      }
   }

   private void v1(boolean var1) {
      if (var1) {
         this.v44++;
      }

      this.v47++;
      this.v49 = System.nanoTime();
   }

   private void v1(class_638 var1, class_746 var2) {
      int var3 = this.range.getValue();
      int var4 = var1.method_32891();
      int var5 = var1.method_31597() - 1;
      int var6 = var2.method_31477();
      int var7 = var2.method_31478();
      int var8 = var2.method_31479();
      int var9 = var6 - var3 >> 4;
      int var10 = var6 + var3 >> 4;
      int var11 = var8 - var3 >> 4;
      int var12 = var8 + var3 >> 4;
      int var13 = Math.max(var7 - var3 >> 4, var4);
      int var14 = Math.min(var7 + var3 >> 4, var5);
      if (var9 != this.v32 || var10 != this.v31 || var13 != this.v23 || var14 != this.v34 || var11 != this.v33 || var12 != this.v36) {
         this.v32 = var9;
         this.v31 = var10;
         this.v23 = var13;
         this.v34 = var14;
         this.v33 = var11;
         this.v36 = var12;
         this.v1(true);
      }

      int var15 = var3 + 14;
      int var16 = var6 - var15 >> 4;
      int var17 = var6 + var15 >> 4;
      int var18 = var8 - var15 >> 4;
      int var19 = var8 + var15 >> 4;
      int var20 = Math.max(var7 - var15 >> 4, var4);
      int var21 = Math.min(var7 + var15 >> 4, var5);
      if (var16 != this.v38 || var17 != this.v37 || var20 != this.v42 || var21 != this.v48 || var18 != this.v43 || var19 != this.v40) {
         this.v38 = var16;
         this.v37 = var17;
         this.v42 = var20;
         this.v48 = var21;
         this.v43 = var18;
         this.v40 = var19;
         boolean var22 = false;
         ObjectIterator var23 = this.v24.long2ObjectEntrySet().fastIterator();

         while (var23.hasNext()) {
            Entry var24 = (Entry)var23.next();
            if (!this.v2(var24.getLongKey())) {
               var22 = true;
               var23.remove();
            }
         }

         for (int var28 = this.v25.size() - 1; var28 >= 0; var28--) {
            long var30 = this.v25.getLong(var28);
            if (!this.v2(var30)) {
               this.v1(var28);
            }
         }

         this.v27.removeIf(var1x -> !this.v2(var1x));

         for (int var29 = this.v42; var29 <= this.v48; var29++) {
            for (int var31 = this.v43; var31 <= this.v40; var31++) {
               for (int var25 = this.v38; var25 <= this.v37; var25++) {
                  long var26 = class_4076.method_18685(var25, var29, var31);
                  if (!this.v24.containsKey(var26) && !this.v27.contains(var26)) {
                     this.v3(var26);
                  }
               }
            }
         }

         if (var22) {
            this.v1(true);
         }
      }
   }

   private boolean v1(long var1) {
      int var3 = class_4076.method_18686(var1);
      int var4 = class_4076.method_18689(var1);
      int var5 = class_4076.method_18690(var1);
      return var3 >= this.v32 && var3 <= this.v31 && var4 >= this.v23 && var4 <= this.v34 && var5 >= this.v33 && var5 <= this.v36;
   }

   private boolean v2(long var1) {
      int var3 = class_4076.method_18686(var1);
      int var4 = class_4076.method_18689(var1);
      int var5 = class_4076.method_18690(var1);
      return var3 >= this.v38 && var3 <= this.v37 && var4 >= this.v42 && var4 <= this.v48 && var5 >= this.v43 && var5 <= this.v40;
   }

   private void v22() {
      LongSet var1 = uiSupport180.v1();
      if (!var1.isEmpty()) {
         LongIterator var2 = var1.iterator();

         while (var2.hasNext()) {
            long var3 = var2.nextLong();
            if (this.v2(var3)) {
               this.v27.remove(var3);
               this.v3(var3);
            }
         }

         uiSupport180.v2();
      }
   }

   private void v24() {
      if (!this.v27.isEmpty()) {
         LongIterator var1 = this.v27.iterator();

         while (var1.hasNext()) {
            this.v3(var1.nextLong());
         }

         this.v27.clear();
      }
   }

   private void v3(long var1) {
      if (this.v26.add(var1)) {
         this.v25.add(var1);
      }
   }

   private long v1(int var1) {
      long var2 = this.v25.getLong(var1);
      int var4 = this.v25.size() - 1;
      this.v25.set(var1, this.v25.getLong(var4));
      this.v25.removeLong(var4);
      this.v26.remove(var2);
      return var2;
   }

   private void v2(class_638 var1, class_746 var2) {
      if (!this.v25.isEmpty()) {
         int var3 = var2.method_31477() >> 4;
         int var4 = var2.method_31478() >> 4;
         int var5 = var2.method_31479() >> 4;
         long var6 = System.nanoTime() + 600000L;

         do {
            long var8 = this.v1(this.v1(var3, var4, var5));
            uiSupport178.Part1 var10 = uiSupport178.v1(
               var1, this.v30, class_4076.method_18686(var8), class_4076.method_18689(var8), class_4076.method_18690(var8), this.v28
            );
            if (var10 == null) {
               this.v27.add(var8);
            } else {
               uiSupport178.Part1 var11 = (uiSupport178.Part1)this.v24.put(var8, var10);
               if (var11 != null) {
                  if (!Arrays.equals(var11.v1(), var10.v1())) {
                     this.v1(this.v1(var8));
                  } else if (!Arrays.equals(var11.v2(), var10.v2()) || !Arrays.equals(var11.v3(), var10.v3()) || !Arrays.equals(var11.v4(), var10.v4())) {
                     this.v1(false);
                  }
               } else {
                  this.v1(var10.v1().length > 0 && this.v1(var8));
               }
            }
         } while (!this.v25.isEmpty() && System.nanoTime() < var6);
      }
   }

   private int v1(int var1, int var2, int var3) {
      int var4 = 0;
      int var5 = Integer.MAX_VALUE;
      int var6 = 0;

      for (int var7 = this.v25.size(); var6 < var7; var6++) {
         long var8 = this.v25.getLong(var6);
         int var10 = class_4076.method_18686(var8) - var1;
         int var11 = class_4076.method_18689(var8) - var2;
         int var12 = class_4076.method_18690(var8) - var3;
         int var13 = var10 * var10 + var11 * var11 + var12 * var12;
         if (var13 < var5) {
            var5 = var13;
            var4 = var6;
         }
      }

      return var4;
   }

   private void v25() {
      InternalSupport36 var1;
      if (this.v73.v2() || this.v46 == this.v44 && this.v51 == this.v53) {
         var1 = this.v73.v1();
      } else {
         this.v46 = this.v44;
         this.v51 = this.v53;
         this.v50 = new LightOverlay.Part3(this.v27(), this.v53, new AtomicReference<>());
         var1 = this.v73.v1(this.v50);
      }

      LightOverlay.Part3 var2 = this.v50;
      if (var2 != null && !var2.equals(this.v59) && this.v73.v2(var2)) {
         this.v26();
         InternalSupport35 var3 = var2.v3().getAndSet(null);
         this.v60 = var3 != null && !var3.v5() ? InternalSupport36.v1(var3) : null;
         this.v59 = var2;
      }

      if (var1 != null) {
         this.v1(var1, this.color.getValue(), this.fromBelow.getValue());
      }

      if (this.v60 != null) {
         this.v1(this.v60, this.previewColor.getValue(), false);
      }
   }

   private void v1(InternalSupport36 var1, int var2, boolean var3) {
      visualSupport9.v1(
         var1,
         uiSupport155.v1(var2, this.fillOpacity.getValue().intValue() / 100.0F),
         this.outline.getValue() ? var2 : 0,
         this.thickness.getValue(),
         0.001,
         this.range.getValue().intValue() + 32.0,
         var3 ? uiSupport155.v1(var2, 0.6F) : 0,
         0.6F
      );
   }

   private void v26() {
      if (this.v60 != null) {
         this.v60.close();
         this.v60 = null;
      }

      this.v59 = null;
   }

   private long[] v27() {
      int var1 = 0;
      ObjectIterator var2 = this.v24.long2ObjectEntrySet().iterator();

      while (var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1 += this.v1(var3.getLongKey()) ? ((uiSupport178.Part1)var3.getValue()).v1().length : 0;
      }

      long[] var7 = new long[var1];
      int var8 = 0;
      ObjectIterator var4 = this.v24.long2ObjectEntrySet().iterator();

      while (var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         if (this.v1(var5.getLongKey())) {
            long[] var6 = ((uiSupport178.Part1)var5.getValue()).v1();
            System.arraycopy(var6, 0, var7, var8, var6.length);
            var8 += var6.length;
         }
      }

      return var7;
   }

   private static InternalSupport35 v1(LightOverlay.Part3 var0) {
      try {
         long[] var1 = var0.v1();
         if (var0.v2().length == 0) {
            return v1(var1);
         } else {
            LongOpenHashSet var2 = new LongOpenHashSet(var0.v2());
            LongArrayList var3 = new LongArrayList(var1.length);
            LongArrayList var4 = new LongArrayList();

            for (long var8 : var1) {
               (var2.contains(var8) ? var4 : var3).add(var8);
            }

            var0.v3().set(v1(var4.toLongArray()));
            return v1(var3.toLongArray());
         }
      } catch (Throwable var10) {
         v2.warn("could not build the light overlay of {} blocks", var0.v1().length, var10);
         return InternalSupport35.v5;
      }
   }

   private static InternalSupport35 v1(long[] var0) {
      if (var0.length == 0) {
         return InternalSupport35.v5;
      } else {
         InternalSupport11 var1 = InternalSupport11.v1(var0);
         return InternalSupport35.v1(var1.v1(), var1.v2());
      }
   }

   private void v1(class_310 var1, class_746 var2) {
      LightOverlay.Part4 var3 = this.placePreview.getValue() ? this.v2(var1, var2) : null;
      LightOverlay.Part6 var4 = this.v68;
      if (var4 != null) {
         this.v68 = null;
         this.v63 = false;
         if (var3 != null && var4.v1() == this.v52 && var4.v2() == var3.v1() && var4.v3() == var3.v2() && !Arrays.equals(var4.v4(), this.v53)) {
            this.v53 = var4.v4();
         }
      }

      if (var3 == null) {
         this.v53 = v82;
         this.v61 = -1;
      } else if (!this.v63 && (var3.v1() != this.v64 || var3.v2() != this.v61 || this.v66 != this.v47)) {
         this.v63 = true;
         this.v64 = var3.v1();
         this.v61 = var3.v2();
         this.v66 = this.v47;
         int var5 = this.v30.v1();
         int var6 = var3.v2() - var5;
         int var7 = InternalSupport10.v1(var3.v1());
         int var8 = InternalSupport10.v3(var3.v1());
         int var9 = InternalSupport10.v2(var3.v1());
         LightOverlay.Part7 var10 = new LightOverlay.Part7(
            var7 - var6 >> 4,
            var8 - var6 >> 4,
            var9 - var6 >> 4,
            var7 + var6 >> 4,
            var8 + var6 >> 4,
            var9 + var6 >> 4,
            this.v32,
            this.v23,
            this.v33,
            this.v31,
            this.v34,
            this.v36
         );
         Long2ObjectOpenHashMap var11 = new Long2ObjectOpenHashMap();

         for (int var12 = var10.v2(); var12 <= var10.v5(); var12++) {
            for (int var13 = var10.v3(); var13 <= var10.v6(); var13++) {
               for (int var14 = var10.v1(); var14 <= var10.v4(); var14++) {
                  long var15 = class_4076.method_18685(var14, var12, var13);
                  uiSupport178.Part1 var17 = (uiSupport178.Part1)this.v24.get(var15);
                  if (var17 != null) {
                     var11.put(var15, var17);
                  }
               }
            }
         }

         int var18 = this.v52;
         this.v22.v3().v1(() -> {
            long[] var9x;
            try {
               var9x = var10.v1(var11, var3.v1(), var3.v2(), var5);
            } catch (Throwable var11x) {
               v2.warn("could not preview the light at {} {} {}", new Object[]{var7, var8, var9, var11x});
               var9x = v82;
            }

            this.v68 = new LightOverlay.Part6(var18, var3.v1(), var3.v2(), var9x);
         });
      }
   }

   @Nullable
   private LightOverlay.Part4 v2(class_310 var1, class_746 var2) {
      if (var1.field_1765 instanceof class_3965 var3 && var3.method_17783() == class_240.field_1332 && var2.method_31549().field_7476) {
         for (class_1268 var7 : class_1268.values()) {
            class_1799 var8 = var2.method_5998(var7);
            if (var8.method_7909() instanceof class_1747 var9) {
               try {
                  class_1750 var16 = var9.method_16356(new class_1750(var2, var7, var8, var3));
                  if (var16 != null && var16.method_7716()) {
                     class_2680 var11 = ((BlockItemInvoker)var9).syky$getPlacementState(var16);
                     if (var11 != null) {
                        class_2338 var12 = var16.method_8037();
                        int var13 = var11.method_26213();
                        return var13 < this.v30.v1()
                           ? null
                           : new LightOverlay.Part4(InternalSupport10.v1(var12.method_10263(), var12.method_10264(), var12.method_10260()), var13);
                     }
                  }
               } catch (RuntimeException var14) {
                  return null;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private void v1(class_746 var1) {
      LightOverlay.Part5 var2 = this.v84;
      if (var2 != null) {
         this.v84 = null;
         this.v74 = false;
         if (var2.v1() == this.v52) {
            this.v94 = var2;
         }
      }

      int var3 = Math.max(v1(var1.method_6047()), v1(var1.method_6079()));
      int var4 = this.v30.v1();
      if (this.torchHints.getValue() && var3 >= var4) {
         boolean var5 = this.v72 != this.v47 || this.v80 != var3;
         boolean var6 = this.v28();
         if (!this.v74 && var5 && var6) {
            this.v1(var3, var4);
         }

         LightOverlay.Part5 var7 = this.v94;
         if (var7 != null && var7.v2() == var3) {
            int var8 = this.hintColor.getValue();
            int var9 = uiSupport155.v1(var8, 0.45F);

            for (class_238 var13 : var7.v5()) {
               visualSupport9.v1(var13, var9);
               visualSupport9.v1(var13, var8, 1.0F);
            }
         }
      }
   }

   private boolean v28() {
      if (this.v25.isEmpty() && System.nanoTime() - this.v49 >= 400000000L) {
         LongIterator var1 = this.v27.iterator();

         while (var1.hasNext()) {
            if (this.v1(var1.nextLong())) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private static int v1(class_1799 var0) {
      return var0.method_7909() instanceof class_1747 var1 ? var1.method_7711().method_9564().method_26213() : 0;
   }

   private void v1(int var1, int var2) {
      this.v74 = true;
      this.v72 = this.v47;
      this.v80 = var1;
      LightOverlay.Part7 var3 = new LightOverlay.Part7(
         this.v38, this.v42, this.v43, this.v37, this.v48, this.v40, this.v32, this.v23, this.v33, this.v31, this.v34, this.v36
      );
      Long2ObjectOpenHashMap var4 = new Long2ObjectOpenHashMap(this.v24);
      LightOverlay.Part5 var5 = this.v94;
      LightOverlay.Part5 var6 = var5 != null && var5.v2() == var1 ? var5 : null;
      long[] var7 = var6 != null ? var6.v3() : new long[0];
      int var8 = var6 != null ? var6.v4() : -1;
      int var9 = this.v52;
      this.v22.v3().v1(() -> {
         long var8x = System.nanoTime();

         LightOverlay.Part5 var10;
         try {
            var10 = var3.v1(var4, var7, var8, var1, var2, var9, var8x);
         } catch (Throwable var12) {
            v2.warn("could not plan where to light the area", var12);
            var10 = new LightOverlay.Part5(var9, var1, new long[0], var8, new class_238[0], 0L, null);
         }

         this.v84 = var10;
      });
   }

   public void v1(int var1, int var2, int var3, int var4, int var5, int var6, int[][] var7, Path var8) throws IOException {
      class_638 var9 = this.v22.v2().v1().field_1687;
      if (var9 == null) {
         throw new IOException("no world to export");
      } else {
         uiSupport178.Part2 var10 = uiSupport178.Part2.v1(var9.method_8597());
         Long2ObjectOpenHashMap var11 = new Long2ObjectOpenHashMap();

         for (int var12 = var2; var12 <= var5; var12++) {
            for (int var13 = var3; var13 <= var6; var13++) {
               for (int var14 = var1; var14 <= var4; var14++) {
                  uiSupport178.Part1 var15 = uiSupport178.v1(var9, var10, var14, var12, var13, this.v28);
                  if (var15 == null) {
                     throw new IOException("section " + var14 + ", " + var12 + ", " + var13 + " is not loaded");
                  }

                  var11.put(class_4076.method_18685(var14, var12, var13), var15);
               }
            }
         }

         LightOverlay.Part7 var21 = new LightOverlay.Part7(var1, var2, var3, var4, var5, var6, var1, var2, var3, var4, var5, var6);
         LightOverlay.Part2 var22 = var21.v1(var11);
         uiSupport179.Part1 var23 = var22.v1();
         uiRecord8 var24 = new uiRecord8(
            var23.v6(), var2 * 16, var23.v7(), var23.v1(), var23.v2(), var23.v3(), var23.v4(), var23.v5(), var22.v2(), var22.v4(), var7
         );
         Files.createDirectories(var8.getParent());

         try (OutputStream var16 = Files.newOutputStream(var8)) {
            var24.v1(var16);
         }
      }
   }

   private void v29() {
      this.v24.clear();
      this.v25.clear();
      this.v26.clear();
      this.v27.clear();
      this.v37 = this.v48 = this.v40 = -1;
      this.v38 = this.v42 = this.v43 = 0;
      this.v31 = this.v34 = this.v36 = -1;
      this.v32 = this.v23 = this.v33 = 0;
      this.v1(true);
      this.v46 = -1;
      this.v52++;
      this.v94 = null;
      this.v53 = v82;
      this.v51 = v82;
      this.v50 = null;
      this.v61 = -1;
      this.v26();
      this.v73.v3();
      this.v73 = this.v21();
      uiSupport180.v2();
   }

   public record Part1(int planned, int searched, int lowerBound, int lonely, double overlap, long searchMillis) {
      public int v1() {
         return this.planned;
      }

      public int v2() {
         return this.searched;
      }

      public int v3() {
         return this.lowerBound;
      }

      public int v4() {
         return this.lonely;
      }

      public double v5() {
         return this.overlap;
      }

      public long v6() {
         return this.searchMillis;
      }
   }

   public record Part2(uiSupport179.Part1 grid, int[] dark, boolean[] painted, int[] mounts, boolean[] mount) {
      public uiSupport179.Part1 v1() {
         return this.grid;
      }

      public int[] v2() {
         return this.dark;
      }

      public boolean[] v3() {
         return this.painted;
      }

      public int[] v4() {
         return this.mounts;
      }

      public boolean[] v5() {
         return this.mount;
      }
   }

   public record Part3(long[] floors, long[] lit, AtomicReference<InternalSupport35> litPack) {
      public long[] v1() {
         return this.floors;
      }

      public long[] v2() {
         return this.lit;
      }

      public AtomicReference<InternalSupport35> v3() {
         return this.litPack;
      }
   }

   public record Part4(long pos, int luminance) {
      public long v1() {
         return this.pos;
      }

      public int v2() {
         return this.luminance;
      }
   }

   public record Part5(int generation, int luminance, long[] spots, int lattice, class_238[] markers, long nanos, @Nullable LightOverlay.Part8 problem) {
      public int v1() {
         return this.generation;
      }

      public int v2() {
         return this.luminance;
      }

      public long[] v3() {
         return this.spots;
      }

      public int v4() {
         return this.lattice;
      }

      public class_238[] v5() {
         return this.markers;
      }

      public long v6() {
         return this.nanos;
      }

      @Nullable
      public LightOverlay.Part8 v7() {
         return this.problem;
      }
   }

   public record Part6(int generation, long pos, int luminance, long[] floors) {
      public int v1() {
         return this.generation;
      }

      public long v2() {
         return this.pos;
      }

      public int v3() {
         return this.luminance;
      }

      public long[] v4() {
         return this.floors;
      }
   }

   public record Part7(
      int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int paintMinX, int paintMinY, int paintMinZ, int paintMaxX, int paintMaxY, int paintMaxZ
   ) {
      public LightOverlay.Part5 v1(Long2ObjectMap<uiSupport178.Part1> var1, long[] var2, int var3, int var4, int var5, int var6, long var7) {
         LightOverlay.Part2 var9 = this.v1(var1);
         uiSupport179.Part1 var10 = var9.v1();
         int var11 = var10.v1();
         int var12 = var10.v3();
         int var13 = var10.v6();
         int var14 = this.minY * 16;
         int var15 = var10.v7();
         IntArrayList var16 = new IntArrayList();

         for (long var20 : var2) {
            int var22 = InternalSupport10.v1(var20) - var13;
            int var23 = InternalSupport10.v3(var20) - var14;
            int var24 = InternalSupport10.v2(var20) - var15;
            if (var22 >= 0 && var23 >= 0 && var24 >= 0 && var22 < var11 && var23 < var10.v2() && var24 < var12) {
               int var25 = (var23 * var12 + var24) * var11 + var22;
               if (var9.v5()[var25]) {
                  var16.add(var25);
               }
            }
         }

         int[] var36 = var16.toIntArray();
         boolean[] var37 = var9.v3();
         int[] var38 = Arrays.stream(var9.v2()).filter(var1x -> var37[var1x]).toArray();
         uiSupport179.Part4 var39 = uiSupport179.v1(var10, var38, var9.v4(), var36, var4, var5, var3, uiSupport179.Part2.PLAY);
         int[] var21 = var39.v1();
         long[] var40 = new long[var21.length];
         class_238[] var41 = new class_238[var21.length];

         for (int var42 = 0; var42 < var21.length; var42++) {
            int var44 = var21[var42];
            int var26 = var44 / (var11 * var12);
            int var27 = var44 - var26 * var11 * var12;
            int var28 = var27 / var11;
            int var29 = var27 - var28 * var11;
            var40[var42] = InternalSupport10.v1(var13 + var29, var14 + var26, var15 + var28);
            double var30 = var13 + var29 + 0.5;
            double var32 = var15 + var28 + 0.5;
            double var34 = var14 + var26;
            var41[var42] = new class_238(var30 - 0.125, var34, var32 - 0.125, var30 + 0.125, var34 + 0.625, var32 + 0.125);
         }

         LightOverlay.Part8 var43 = new LightOverlay.Part8(var10, var38, var9.v4(), var36, var4, var5, var3, var39.v1());
         return new LightOverlay.Part5(var6, var4, var40, var39.v2(), var41, System.nanoTime() - var7, var43);
      }

      public long[] v1(Long2ObjectMap<uiSupport178.Part1> var1, long var2, int var4, int var5) {
         LightOverlay.Part2 var6 = this.v1(var1);
         uiSupport179.Part1 var7 = var6.v1();
         int var8 = var7.v1();
         int var9 = var7.v3();
         int var10 = var7.v6();
         int var11 = this.minY * 16;
         int var12 = var7.v7();
         boolean[] var13 = var6.v3();
         LongArrayList var14 = new LongArrayList();

         for (int var18 : uiSupport179.v1(var7, v1(var2, 0, var10, var11, var12, var8, var9), var4, var5)) {
            if (var13[var18]) {
               int var19 = var18 / (var8 * var9);
               int var20 = var18 - var19 * var8 * var9;
               int var21 = var20 / var8;
               int var22 = var20 - var21 * var8;
               var14.add(InternalSupport10.v1(var10 + var22, var11 + var19 - 1, var12 + var21));
            }
         }

         return var14.toLongArray();
      }

      public LightOverlay.Part2 v1(Long2ObjectMap<uiSupport178.Part1> var1) {
         int var2 = (this.maxX - this.minX + 1) * 16;
         int var3 = (this.maxY - this.minY + 1) * 16;
         int var4 = (this.maxZ - this.minZ + 1) * 16;
         int var5 = this.minX * 16;
         int var6 = this.minY * 16;
         int var7 = this.minZ * 16;
         byte[] var8 = new byte[var2 * var3 * var4];
         Arrays.fill(var8, (byte)15);
         byte[] var9 = null;
         boolean[] var10 = new boolean[var8.length];
         boolean[] var11 = new boolean[var8.length];
         IntArrayList var12 = new IntArrayList();
         IntArrayList var13 = new IntArrayList();
         ObjectIterator var14 = var1.long2ObjectEntrySet().iterator();

         while (var14.hasNext()) {
            Entry var15 = (Entry)var14.next();
            long var16 = var15.getLongKey();
            int var18 = class_4076.method_18686(var16);
            int var19 = class_4076.method_18689(var16);
            int var20 = class_4076.method_18690(var16);
            int var21 = var18 * 16 - var5;
            int var22 = var19 * 16 - var6;
            int var23 = var20 * 16 - var7;
            if (var21 >= 0 && var22 >= 0 && var23 >= 0 && var21 < var2 && var22 < var3 && var23 < var4) {
               uiSupport178.Part1 var24 = (uiSupport178.Part1)var15.getValue();
               byte[] var25 = var24.v3();
               byte[] var26 = var24.v4();
               if (var26 != null && var9 == null) {
                  var9 = new byte[var8.length];
               }

               for (int var27 = 0; var27 < 16; var27++) {
                  for (int var28 = 0; var28 < 16; var28++) {
                     int var29 = ((var22 + var27) * var4 + var23 + var28) * var2 + var21;
                     int var30 = (var27 * 16 + var28) * 16;
                     if (var25 == null) {
                        Arrays.fill(var8, var29, var29 + 16, (byte)0);
                     } else {
                        System.arraycopy(var25, var30, var8, var29, 16);
                     }

                     if (var26 != null) {
                        System.arraycopy(var26, var30, var9, var29, 16);
                     }
                  }
               }

               boolean var35 = var18 >= this.paintMinX
                  && var18 <= this.paintMaxX
                  && var19 >= this.paintMinY
                  && var19 <= this.paintMaxY
                  && var20 >= this.paintMinZ
                  && var20 <= this.paintMaxZ;

               for (long var31 : var24.v1()) {
                  int var33 = v1(var31, 1, var5, var6, var7, var2, var4);
                  var12.add(var33);
                  var11[var33] = var35;
               }

               for (long var42 : var24.v2()) {
                  int var43 = v1(var42, 0, var5, var6, var7, var2, var4);
                  var10[var43] = true;
                  var13.add(var43);
               }
            }
         }

         uiSupport179.Part1 var34 = new uiSupport179.Part1(var2, var3, var4, var8, var9, var5, var7);
         return new LightOverlay.Part2(var34, var12.toIntArray(), var11, var13.toIntArray(), var10);
      }

      private static int v1(long var0, int var2, int var3, int var4, int var5, int var6, int var7) {
         int var8 = InternalSupport10.v1(var0) - var3;
         int var9 = InternalSupport10.v3(var0) + var2 - var4;
         int var10 = InternalSupport10.v2(var0) - var5;
         return (var9 * var7 + var10) * var6 + var8;
      }

      public int v1() {
         return this.minX;
      }

      public int v2() {
         return this.minY;
      }

      public int v3() {
         return this.minZ;
      }

      public int v4() {
         return this.maxX;
      }

      public int v5() {
         return this.maxY;
      }

      public int v6() {
         return this.maxZ;
      }

      public int v7() {
         return this.paintMinX;
      }

      public int v8() {
         return this.paintMinY;
      }

      public int v9() {
         return this.paintMinZ;
      }

      public int v10() {
         return this.paintMaxX;
      }

      public int v11() {
         return this.paintMaxY;
      }

      public int v12() {
         return this.paintMaxZ;
      }
   }

   public record Part8(uiSupport179.Part1 grid, int[] dark, int[] mounts, int[] keep, int luminance, int safe, int lattice, int[] all) {
      public uiSupport179.Part1 v1() {
         return this.grid;
      }

      public int[] v2() {
         return this.dark;
      }

      public int[] v3() {
         return this.mounts;
      }

      public int[] v4() {
         return this.keep;
      }

      public int v5() {
         return this.luminance;
      }

      public int v6() {
         return this.safe;
      }

      public int v7() {
         return this.lattice;
      }

      public int[] v8() {
         return this.all;
      }
   }

   public record Part9(boolean settled, boolean current, long[] painted, long[] spots, long planNanos, int revision) {
      public boolean v1() {
         return this.settled;
      }

      public boolean v2() {
         return this.current;
      }

      public long[] v3() {
         return this.painted;
      }

      public long[] v4() {
         return this.spots;
      }

      public long v5() {
         return this.planNanos;
      }

      public int v6() {
         return this.revision;
      }
   }
}
