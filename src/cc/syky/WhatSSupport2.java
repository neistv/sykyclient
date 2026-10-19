package cc.syky;

import cc.syky.internal.InternalSupport25;
import cc.syky.module.utilities.FogBlurSupport;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class WhatSSupport2 {
   private static final String v1 = "syky_sans_strong";
   private static final class_2960 v2 = class_2960.method_60655("syky", "textures/ui/icons/arrow_right.png");
   private final List<WhatSSupport2.Part1> v3 = new ArrayList<>();
   private float v4;
   private float v5;
   private float v6;
   private static final float v7 = 0.24462998F;
   private static final float v8 = 1.15088F;

   public WhatSSupport2() {
   }

   public void v1(sykyRecord var1, float var2) {
      if (!(var2 <= 0.0F) && var2 != this.v4) {
         if (!(v1("M") <= 0.0F)) {
            this.v4 = var2;
            this.v3.clear();
            float var3 = v2(65.0F, 44.0F, 36.0F);
            this.v3.add(WhatSSupport2.Part1.v1(FogBlurSupport.v1("whatsnew.heading", "What's new"), 0.0F, var3, 36.0F, -1, true));
            float var4 = v2(115.0F, 19.0F, 16.0F);
            this.v1(var1, var2, var4);
            float var5 = 16.0F;
            float var6 = var2 - var5;
            float var7 = var4;
            float var8 = 16.0F;
            float var9 = 40.0F;

            for (sykyRecord2.Part1 var11 : var1.v5()) {
               if (var11.v1()) {
                  var7 += v1(var8, var9, 22.0F);
                  this.v3.add(WhatSSupport2.Part1.v1(var11.v2(), 0.0F, var7, 22.0F, -1, false));
                  var8 = 22.0F;
                  var9 = 18.0F;
               }

               for (String var13 : var11.v3()) {
                  List var14 = InternalSupport25.v1(var13, var6, WhatSSupport2::v1);

                  for (int var15 = 0; var15 < var14.size(); var15++) {
                     if (var15 == 0) {
                        var7 += v1(var8, var9, 15.0F);
                        this.v3.add(WhatSSupport2.Part1.v1("•", 0.0F, var7, 15.0F, -637534209, false));
                     } else {
                        var7 += 22.0F;
                     }

                     this.v3.add(WhatSSupport2.Part1.v1((String)var14.get(var15), var5, var7, 15.0F, -637534209, false));
                  }

                  var8 = 15.0F;
                  var9 = 16.0F;
               }

               var9 = 44.0F;
            }

            this.v6 = var7 + v1(var8) + 52.0F - 10.0F;
            this.v5 = this.v6 + v2();
         }
      }
   }

   public float v1() {
      return this.v6;
   }

   public static float v2() {
      return 40.0F;
   }

   private static float v1(float var0) {
      return 1.15088F * var0;
   }

   private static float v1(float var0, float var1, float var2) {
      return v1(var0) + var1 - 0.24462998F * var2;
   }

   private void v1(sykyRecord var1, float var2, float var3) {
      if (!var1.v1()) {
         this.v3.add(WhatSSupport2.Part1.v1(var1.v4(), 0.0F, var3, 16.0F, -1275068417, true));
      } else {
         float var4 = v1(var1.v3(), 16.0F);
         float var5 = v1(var1.v4(), 16.0F);
         float var6 = 8.0F;
         float var7 = var6 * 1.4814814F;
         float var8 = 9.0F;
         float var9 = (var2 - (var4 + var8 + var7 + var8 + var5)) * 0.5F;
         this.v3.add(WhatSSupport2.Part1.v1(var1.v3(), var9, var3, 16.0F, -1275068417, false));
         var9 += var4 + var8;
         float var10 = var3 + 9.61F;
         this.v3.add(WhatSSupport2.Part1.v1(v2, var9, var10 - var6 * 0.5F, var7, var6, -1275068417));
         var9 += var7 + var8;
         this.v3.add(WhatSSupport2.Part1.v1(var1.v4(), var9, var3, 16.0F, -1275068417, false));
      }
   }

   private static float v2(float var0, float var1, float var2) {
      return var0 + var1 * 0.5F - 56.0F - 0.600625F * var2;
   }

   public float v3() {
      return this.v5;
   }

   public void v1(float var1, float var2, float var3, float var4) {
      for (int var5 = 0; var5 < this.v3.size(); var5++) {
         WhatSSupport2.Part1 var6 = this.v3.get(var5);
         float var7 = var2 + var6.v4() * var4;
         if (var6.v2() != null) {
            uiSupport169.v2(var6.v2(), var1 + var6.v3() * var4, var7, var6.v5() * var4, var6.v6() * var4, var6.v7(), uiRecord7.ZERO);
         } else if (var6.v8()) {
            uiSupport169.v6("syky_sans_strong", var6.v1(), var1 + var3 * 0.5F, var7, var6.v6() * var4, var6.v7());
         } else {
            uiSupport169.v4("syky_sans_strong", var6.v1(), var1 + var6.v3() * var4, var7, var6.v6() * var4, var6.v7());
         }
      }
   }

   private static float v1(String var0) {
      return v1(var0, 15.0F);
   }

   private static float v1(String var0, float var1) {
      return uiSupport169.v2("syky_sans_strong", var0, var1);
   }

   public record Part1(String text, @Nullable class_2960 icon, float x, float y, float w, float h, int color, boolean centered) {
      public static WhatSSupport2.Part1 v1(String var0, float var1, float var2, float var3, int var4, boolean var5) {
         return new WhatSSupport2.Part1(var0, null, var1, var2, 0.0F, var3, var4, var5);
      }

      public static WhatSSupport2.Part1 v1(class_2960 var0, float var1, float var2, float var3, float var4, int var5) {
         return new WhatSSupport2.Part1("", var0, var1, var2, var3, var4, var5, false);
      }

      public String v1() {
         return this.text;
      }

      @Nullable
      public class_2960 v2() {
         return this.icon;
      }

      public float v3() {
         return this.x;
      }

      public float v4() {
         return this.y;
      }

      public float v5() {
         return this.w;
      }

      public float v6() {
         return this.h;
      }

      public int v7() {
         return this.color;
      }

      public boolean v8() {
         return this.centered;
      }
   }
}
