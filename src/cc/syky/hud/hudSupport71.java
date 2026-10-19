package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport92;
import cc.syky.internal.InternalSupport58;
import cc.syky.mixin.accessor.EntityTrackedPositionAccessor;
import cc.syky.module.visual.visualSupport40;
import cc.syky.module.visual.visualSupport64;
import cc.syky.ui.uiSupport239;
import it.unimi.dsi.fastutil.ints.Int2LongMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.IntUnaryOperator;
import net.minecraft.class_10707;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1796;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1819;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import net.minecraft.class_742;
import net.minecraft.class_746;
import net.minecraft.class_9334;
import org.jetbrains.annotations.Nullable;

public final class hudSupport71 {
   private static final double v1 = 2.25;
   private static final long v2 = 1000000000L;
   private static final double v3 = 36.0;
   private final cloudSupport101 v4;
   private int v5 = -1;
   private long v6;
   private float v7;
   private BooleanSupplier v8 = () -> false;
   private boolean v9;
   @Nullable
   private class_638 v10;
   private final IntUnaryOperator v11 = this::v1;
   private List<hudRecord5> v12 = List.of();
   private final List<hudRecord5> v13 = new ArrayList<>(4);
   @Nullable
   private class_1799 v14;

   public hudSupport71(cloudSupport101 var1, cloudSupport92 var2) {
      this.v4 = var1;
      var2.v1(InternalSupport58.class, var1x -> this.v2(), 0);
      var2.v1(visualSupport64.class, this::v1, 40);
      var2.v1(uiSupport239.class, this::v1, 40);
   }

   public void v1(BooleanSupplier var1) {
      this.v8 = var1;
   }

   public List<hudRecord5> v1() {
      return this.v12;
   }

   private void v2() {
      boolean var1 = this.v8.getAsBoolean();
      this.v9 = var1 || visualSupport40.v1 && visualSupport40.v8;
      class_310 var2 = this.v4.v1();
      class_638 var3 = var2 == null ? null : var2.field_1687;
      class_746 var4 = var2 == null ? null : var2.field_1724;
      if (this.v9 && var3 != null && var4 != null) {
         if (var3 != this.v10) {
            hudSupport72.v1();
            this.v10 = var3;
         }

         hudSupport72.v1(var3.method_75260(), this.v11);
         this.v12 = var1 ? this.v1(var3, var4) : List.of();
      } else {
         hudSupport72.v1();
         this.v10 = null;
         this.v12 = List.of();
      }
   }

   private List<hudRecord5> v1(class_638 var1, class_746 var2) {
      this.v13.clear();
      float var3 = var1.method_54719().method_54748();
      int var4 = this.v1(var2);
      if (var4 > 0) {
         this.v13.add(new hudRecord5(var2.method_5667(), true, var2.method_5477().getString(), var4 / var3));
      }

      if (!visualSupport40.v11.isEmpty()) {
         long var5 = var1.method_75260();
         ObjectIterator var7 = visualSupport40.v11.int2LongEntrySet().fastIterator();

         while (var7.hasNext()) {
            Entry var8 = (Entry)var7.next();
            long var9 = var8.getLongValue() - var5;
            if (var9 > 0L && var1.method_8469(var8.getIntKey()) instanceof class_1657 var11) {
               this.v13.add(new hudRecord5(var11.method_5667(), false, var11.method_5477().getString(), (float)var9 / var3));
            }
         }
      }

      return this.v13.isEmpty() ? List.of() : List.copyOf(this.v13);
   }

   private int v1(class_746 var1) {
      class_1799 var2 = v1((class_1657)var1);
      if (var2 == null) {
         if (this.v14 == null) {
            this.v14 = class_1802.field_8255.method_7854();
         }

         var2 = this.v14;
      }

      return v1(var1.method_7357(), var2);
   }

   public static int v1(class_1796 var0, class_1799 var1) {
      if (!(var0.method_7905(var1, 0.0F) > 0.0F)) {
         return 0;
      } else {
         int var2 = 0;

         int var3;
         for (var3 = 1; var3 < 1073741824 && var0.method_7905(var1, var3) > 0.0F; var3 <<= 1) {
            var2 = var3;
         }

         while (var3 - var2 > 1) {
            int var4 = var2 + var3 >>> 1;
            if (var0.method_7905(var1, var4) > 0.0F) {
               var2 = var4;
            } else {
               var3 = var4;
            }
         }

         return var3;
      }
   }

   @Nullable
   private static class_1799 v1(class_1657 var0) {
      class_1799 var1 = var0.method_6079();
      if (var1.method_7909() instanceof class_1819) {
         return var1;
      } else {
         class_1799 var2 = var0.method_6047();
         return var2.method_7909() instanceof class_1819 ? var2 : null;
      }
   }

   private void v1(visualSupport64 var1) {
      class_310 var2 = this.v4.v1();
      if (var2 != null && var2.field_1724 != null && var1.v1() instanceof class_1309 var3) {
         this.v5 = var3.method_5628();
         this.v6 = System.nanoTime();
         this.v7 = var2.field_1724.method_67125();
      }
   }

   private void v1(uiSupport239 var1) {
      if (this.v9 && var1.v2() == class_3419.field_15248) {
         class_310 var2 = this.v4.v1();
         class_638 var3 = var2 == null ? null : var2.field_1687;
         if (var2 != null && var3 != null && var2.field_1724 != null) {
            class_742 var4 = null;
            class_10707 var5 = null;
            double var6 = 2.25;

            for (class_742 var9 : var3.method_18456()) {
               if (var9.method_5628() != var2.field_1724.method_5628()) {
                  class_10707 var10 = v1(var9, var1.v1());
                  if (var10 != null) {
                     class_243 var11 = ((EntityTrackedPositionAccessor)var9).syky$trackedPosition().method_60933();
                     double var12 = var11.method_1028(var1.v3(), var1.v4(), var1.v5());
                     if (var12 <= var6) {
                        var6 = var12;
                        var4 = var9;
                        var5 = var10;
                     }
                  }
               }
            }

            if (var4 != null && var5 != null) {
               float var14 = this.v1(var3, var4) * var5.comp_3587();
               int var15 = var14 > 0.0F ? Math.round(var14 * 20.0F) : 0;
               if (var15 > 0) {
                  hudSupport72.v1(var4.method_5628(), var3.method_75260() + var15);
               }
            }
         }
      }
   }

   @Nullable
   private static class_10707 v1(class_1657 var0, class_6880<class_3414> var1) {
      class_10707 var2 = v1(var0.method_6030(), var1);
      if (var2 == null) {
         var2 = v1(var0.method_6079(), var1);
      }

      if (var2 == null) {
         var2 = v1(var0.method_6047(), var1);
      }

      return var2;
   }

   @Nullable
   private static class_10707 v1(class_1799 var0, class_6880<class_3414> var1) {
      class_10707 var2 = (class_10707)var0.method_58694(class_9334.field_56396);
      if (var2 == null) {
         return null;
      } else {
         Optional var3 = var2.comp_3591();
         return var3.isPresent() && ((class_3414)((class_6880)var3.get()).comp_349()).comp_3319().equals(((class_3414)var1.comp_349()).comp_3319())
            ? var2
            : null;
      }
   }

   private float v1(class_638 var1, class_1657 var2) {
      if (var2.method_5628() == this.v5 && System.nanoTime() - this.v6 <= 1000000000L && this.v7 > 0.0F) {
         return this.v7;
      } else {
         float var3 = 0.0F;

         for (class_742 var5 : var1.method_18456()) {
            if (var5.method_5628() != var2.method_5628() && var5.method_5858(var2) <= 36.0) {
               var3 = Math.max(var3, var5.method_67125());
            }
         }

         return var3 > 0.0F ? var3 : 5.0F;
      }
   }

   private int v1(int var1) {
      class_310 var2 = this.v4.v1();
      class_638 var3 = var2 == null ? null : var2.field_1687;
      if ((var3 == null ? null : var3.method_8469(var1)) instanceof class_1309 var5 && var5.method_5805()) {
         boolean var6 = var5.method_6115() && var5.method_6030().method_58694(class_9334.field_56396) != null;
         return var6 ? 2 : 1;
      } else {
         return 0;
      }
   }
}
