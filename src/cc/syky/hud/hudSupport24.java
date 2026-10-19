package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport26;
import java.util.Locale;

public final class hudSupport24 extends AbstractHudWidget {
   public static final String v2 = "area_hint";
   public static final float v3 = 150.0F;
   public static final String v4 = "Left-click – outline a block   Right-click – clear it";
   public static final String v5 = "Hold to paint   Shift + click – fill from the last block";
   public static final String v6 = "Hold Left Alt – pick empty space, 4 blocks ahead";
   private static final int v7 = -1711276033;
   private String v8 = "";
   private int v9 = -1;
   private float v10;
   private float v11 = -1.0F;
   private String v12 = "";
   private float v13;
   private float v14 = -1.0F;

   public hudSupport24(hudSupport52 var1, float var2, float var3) {
      super("area_hint", 11, var1, var2, var3);
   }

   @Override
   public boolean v12(hudSupport40 var1) {
      return !var1.v6().v28();
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      float var3 = Math.max(this.v10(var2), this.v1(var1.v6(), var2));
      return this.v12(var3 + 2.0F * this.v6(16.0F, var2), this.v6(uiSupport26.v1(), var2));
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return 14.0F * var3;
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      cloudSupport2 var4 = var1.v6();
      float var5 = var2.v2() + var2.v4() / 2.0F;
      float var6 = 14.0F * var3;
      float var7 = var2.v3() + 11.0F * var3;
      this.v2("syky_sans_strong", "Left-click – outline a block   Right-click – clear it", var5, var7, var6, -1);
      var7 += 21.0F * var3;
      this.v2("syky_sans_strong", "Hold to paint   Shift + click – fill from the last block", var5, var7, var6, -1711276033);
      var7 += 21.0F * var3;
      this.v2("syky_sans_strong", "Hold Left Alt – pick empty space, 4 blocks ahead", var5, var7, var6, var4.v30() ? -1 : -1711276033);
      var7 += 26.0F * var3;
      String var8 = var4.v32();
      this.v2("syky_sans_strong", var8 != null ? var8 : this.v3(var4.v29()), var5, var7, 13.0F * var3, var8 != null ? -1 : -1711276033);
   }

   private float v10(float var1) {
      float var2 = 14.0F * var1;
      if (var2 != this.v11 || !(this.v10 > 0.0F)) {
         this.v11 = var2;
         this.v10 = Math.max(
            uiSupport169.v2("syky_sans_strong", "Left-click – outline a block   Right-click – clear it", var2),
            Math.max(
               uiSupport169.v2("syky_sans_strong", "Hold to paint   Shift + click – fill from the last block", var2),
               uiSupport169.v2("syky_sans_strong", "Hold Left Alt – pick empty space, 4 blocks ahead", var2)
            )
         );
      }

      return this.v10;
   }

   private float v1(cloudSupport2 var1, float var2) {
      String var3 = var1.v32();
      String var4 = var3 != null ? var3 : this.v3(var1.v29());
      float var5 = 13.0F * var2;
      if (!var4.equals(this.v12) || var5 != this.v14 || !(this.v13 > 0.0F)) {
         this.v12 = var4;
         this.v14 = var5;
         this.v13 = uiSupport169.v2("syky_sans_strong", var4, var5);
      }

      return this.v13;
   }

   private String v3(int var1) {
      if (var1 != this.v9) {
         this.v9 = var1;
         this.v8 = var1 == 0
            ? "No blocks yet – open the menu to stop"
            : String.format(Locale.ROOT, "%,d block%s – open the menu to save", var1, var1 == 1 ? "" : "s");
      }

      return this.v8;
   }
}
