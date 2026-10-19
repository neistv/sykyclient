package cc.syky.internal;

import cc.syky.DecompilationFailedSupport;
import cc.syky.ui.uiSupport172;
import java.io.InputStream;
import java.util.Optional;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1723;
import net.minecraft.class_1735;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import net.minecraft.class_3300;
import net.minecraft.class_746;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport50 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.inventory-background");
   private static final class_2960 v2 = class_2960.method_60656("textures/gui/container/inventory.png");
   private static final float v3 = 256.0F;
   private static volatile int v4;
   @Nullable
   private InternalSupport50.Part1 v5;
   private int v6 = -1;
   private boolean v7;
   private boolean v8;
   private boolean v9;
   private int v10;
   @Nullable
   private class_310 v11;

   public InternalSupport50() {
   }

   public static void v1() {
      v4++;
   }

   @Nullable
   public InternalSupport50.Part1 v2() {
      return this.v5;
   }

   public void v1(class_310 var1, InternalSupport57 var2, InternalSupport56 var3, boolean var4) {
      class_746 var5 = var1.field_1724;
      if (var1.method_18506() == null && var5 != null) {
         int var6 = v4;
         if (!this.v8 && (this.v6 != var6 || this.v7 != var4)) {
            if (!this.v9 || this.v6 != var6) {
               this.v11 = var1;
               this.v8 = true;
               this.v6 = var6;
               this.v7 = var4;
               this.v9 = false;
               int[] var7 = v1(var5.field_7498);
               class_3300 var8 = var1.method_1478();
               var2.v1(() -> {
                  uiSupport172.Part1 var6x = v1(var8, var4, var7);
                  var3.v1(() -> this.v1(var6, var4, var6x));
               });
            }
         }
      }
   }

   private static int[] v1(class_1723 var0) {
      int[] var1 = new int[var0.field_7761.size() * 2];

      for (int var2 = 0; var2 < var0.field_7761.size(); var2++) {
         class_1735 var3 = (class_1735)var0.field_7761.get(var2);
         var1[var2 * 2] = var3.field_7873 + 8;
         var1[var2 * 2 + 1] = var3.field_7872 + 8;
      }

      return var1;
   }

   @Nullable
   private static uiSupport172.Part1 v1(class_3300 var0, boolean var1, int[] var2) {
      Optional var3 = var0.method_14486(v2);
      if (var3.isEmpty()) {
         v1.warn("no resource pack provides {}; the inventory is drawn unchanged", v2);
         return null;
      } else {
         String var4 = ((class_3298)var3.get()).method_14480();

         byte[] var5;
         try (InputStream var6 = ((class_3298)var3.get()).method_14482()) {
            var5 = var6.readAllBytes();
         } catch (Exception var14) {
            v1.warn("could not read the inventory panel from {}", var4, var14);
            return null;
         }

         DecompilationFailedSupport.Part1 var15 = DecompilationFailedSupport.v1(var5, Integer.MAX_VALUE);
         if (var15 == null) {
            v1.warn("could not decode the inventory panel from {}", var4);
            return null;
         } else {
            float var7 = var15.v2() / 256.0F;
            int var8 = Math.round(176.0F * var7);
            int var9 = Math.round(166.0F * var7);
            if (var8 > 0 && var9 > 0 && var8 <= var15.v2() && var9 <= var15.v3()) {
               int[] var10 = new int[var8 * var9];

               for (int var11 = 0; var11 < var9; var11++) {
                  System.arraycopy(var15.v1(), var11 * var15.v2(), var10, var11 * var8, var8);
               }

               uiSupport172.Part1 var16 = uiSupport172.v1(var10, var8, var9, var7, var1, var2);
               if (var16 == null) {
                  v1.info("the inventory from {} has no plain background to replace; it is drawn unchanged", var4);
               }

               return var16;
            } else {
               v1.warn("the inventory panel from {} is {}x{}, too small for the panel", new Object[]{var4, var15.v2(), var15.v3()});
               return null;
            }
         }
      }
   }

   private void v1(int var1, boolean var2, @Nullable uiSupport172.Part1 var3) {
      if (var1 == this.v6 && var2 == this.v7) {
         this.v8 = false;
         this.v3();
         if (var3 == null) {
            this.v9 = true;
         } else {
            class_310 var4 = this.v11;
            if (var4 != null) {
               int var5 = ++this.v10;
               class_2960 var6 = v1(var4, "frame_" + var5, var3.v1(), var3.v3(), var3.v4());
               if (var6 != null) {
                  class_2960 var7 = v1(var4, "slots_" + var5, var3.v2(), var3.v3(), var3.v4());
                  this.v5 = new InternalSupport50.Part1(var6, var7, var3.v5(), var3.v6(), var3.v7(), var3.v8());
               }
            }
         }
      } else {
         this.v8 = false;
         this.v6 = -1;
      }
   }

   @Nullable
   private static class_2960 v1(class_310 var0, String var1, int[] var2, int var3, int var4) {
      boolean var5 = false;

      for (int var9 : var2) {
         if (var9 != 0) {
            var5 = true;
            break;
         }
      }

      if (!var5) {
         return null;
      } else {
         class_2960 var11 = class_2960.method_60655("syky", "inventory_background/" + var1);
         class_1011 var12 = new class_1011(class_1012.field_4997, var3, var4, false);

         try {
            for (int var13 = 0; var13 < var4; var13++) {
               for (int var14 = 0; var14 < var3; var14++) {
                  var12.method_61941(var14, var13, var2[var13 * var3 + var14]);
               }
            }

            var0.method_1531().method_4616(var11, new class_1043(var11::toString, var12));
            return var11;
         } catch (Throwable var10) {
            var12.close();
            v1.warn("could not upload the inventory {}", var1, var10);
            return null;
         }
      }
   }

   public void v3() {
      InternalSupport50.Part1 var1 = this.v5;
      class_310 var2 = this.v11;
      if (var1 != null && var2 != null) {
         var2.method_1531().method_4615(var1.v1());
         class_2960 var3 = var1.v2();
         if (var3 != null) {
            var2.method_1531().method_4615(var3);
         }
      }

      this.v5 = null;
   }

   public void v4() {
      this.v3();
      this.v8 = false;
      this.v6 = -1;
      this.v9 = false;
   }

   public record Part1(class_2960 texture, @Nullable class_2960 slots, int pictureX0, int pictureY0, int pictureX1, int pictureY1) {
      public class_2960 v1() {
         return this.texture;
      }

      @Nullable
      public class_2960 v2() {
         return this.slots;
      }

      public int v3() {
         return this.pictureX0;
      }

      public int v4() {
         return this.pictureY0;
      }

      public int v5() {
         return this.pictureX1;
      }

      public int v6() {
         return this.pictureY1;
      }
   }
}
