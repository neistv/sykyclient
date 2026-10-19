package cc.syky.cloud;

import cc.syky.internal.InternalSupport62;
import cc.syky.ui.uiRecord12;
import cc.syky.ui.uiSupport255;
import cc.syky.ui.uiSupport256;
import cc.syky.ui.uiSupport257;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport50 {
   private static final Pattern v1 = Pattern.compile("[a-z0-9][a-z0-9_.-]{0,63}");
   private final String v2;
   private final cloudSupport49 v3;
   private final uiSupport255 v4;
   private final uiSupport256 v5;
   private final uiRecord12[] v6;
   private final InternalSupport62[] v7;
   @Nullable
   private final cloudSupport50.Part1 v8;
   private final cloudSupport45[] v9;
   private final int[] v10;
   private final uiSupport257 v11;
   private final float v12;

   public cloudSupport50(
      String var1,
      cloudSupport49 var2,
      uiSupport255 var3,
      uiSupport256 var4,
      uiRecord12[] var5,
      InternalSupport62[] var6,
      @Nullable cloudSupport50.Part1 var7,
      cloudSupport45[] var8,
      int[] var9
   ) {
      if (!v1.matcher(var1).matches()) {
         throw new IllegalArgumentException("cosmetic id \"" + var1 + "\"");
      } else if (var5.length <= 64 && var6.length <= 16 && var8.length <= 64) {
         for (uiRecord12 var13 : var5) {
            if (var13.v3() >= var6.length || var13.v7() >= var6.length) {
               throw new IllegalArgumentException(var1 + ": material reads texture " + var13.v3() + "/" + var13.v7());
            }
         }

         for (int var16 = 0; var16 < var4.v3(); var16++) {
            if (var4.v1(var16) >= var3.v1() || var4.v2(var16) >= var5.length) {
               throw new IllegalArgumentException(var1 + ": part " + var16 + " names a missing bone or material");
            }
         }

         if (var7 == null || var7.v3() >= 0 && var7.v3() < var5.length) {
            for (cloudSupport45 var25 : var8) {
               for (int var14 = 0; var14 < var25.v4(); var14++) {
                  cloudSupport46 var15 = var25.v2(var14);
                  if (var15.v1() < 0 || var15.v1() >= var3.v1()) {
                     throw new IllegalArgumentException(var1 + ": clip " + var25.v1() + " animates bone " + var15.v1());
                  }
               }
            }

            if (var9.length != cloudSupport44.v3()) {
               throw new IllegalArgumentException(var1 + ": one clip slot per motion");
            } else {
               for (int var26 : var9) {
                  if (var26 < -1 || var26 >= var8.length) {
                     throw new IllegalArgumentException(var1 + ": motion plays clip " + var26);
                  }
               }

               if (var4.v3() == 0 && var7 == null) {
                  throw new IllegalArgumentException(var1 + ": nothing to draw");
               } else {
                  this.v2 = var1;
                  this.v3 = var2;
                  this.v4 = var3;
                  this.v5 = var4;
                  this.v6 = var5;
                  this.v7 = var6;
                  this.v8 = var7;
                  this.v9 = var8;
                  this.v10 = var9;
                  this.v11 = uiSupport257.v1(var3, var4, var8);
                  float var19 = this.v11.v1();
                  if (var7 != null) {
                     cloudRecord6 var22 = var7.v2();
                     var19 = Math.max(var19, (float)Math.hypot(var22.v7(), var22.v8()) + var7.v1());
                  }

                  this.v12 = var19;
               }
            }
         } else {
            throw new IllegalArgumentException(var1 + ": the cape's material " + var7.v3() + " is missing");
         }
      } else {
         throw new IllegalArgumentException(var1 + ": too many materials, textures or clips");
      }
   }

   public String v1() {
      return this.v2;
   }

   public cloudSupport49 v2() {
      return this.v3;
   }

   public uiSupport255 v3() {
      return this.v4;
   }

   public uiSupport256 v4() {
      return this.v5;
   }

   public int v5() {
      return this.v6.length;
   }

   public uiRecord12 v1(int var1) {
      return this.v6[var1];
   }

   public int v6() {
      return this.v7.length;
   }

   public InternalSupport62 v2(int var1) {
      return this.v7[var1];
   }

   @Nullable
   public cloudSupport50.Part1 v7() {
      return this.v8;
   }

   public int v8() {
      return this.v9.length;
   }

   public cloudSupport45 v3(int var1) {
      return this.v9[var1];
   }

   public boolean v9() {
      for (int var4 : this.v10) {
         if (var4 >= 0) {
            return true;
         }
      }

      return false;
   }

   public int v1(cloudSupport44 var1) {
      cloudSupport44 var2 = var1;

      while (true) {
         int var3 = this.v10[var2.ordinal()];
         if (var3 >= 0 || var2 == cloudSupport44.IDLE) {
            return var3;
         }

         var2 = var2.v2();
      }
   }

   public int v2(cloudSupport44 var1) {
      return this.v10[var1.ordinal()];
   }

   public uiSupport257 v10() {
      return this.v11;
   }

   public float v11() {
      return this.v12;
   }

   public record Part1(cloudRecord6 cloth, int material, cloudSupport43 layout) {
      public float v1() {
         return this.cloth.v4() * 0.5F + this.cloth.v5() + this.cloth.v6();
      }

      public cloudRecord6 v2() {
         return this.cloth;
      }

      public int v3() {
         return this.material;
      }

      public cloudSupport43 v4() {
         return this.layout;
      }
   }
}
