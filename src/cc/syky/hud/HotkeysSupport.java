package cc.syky.hud;

import cc.syky.cloud.cloudRecord;
import cc.syky.config.SettingCondition;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport150;
import cc.syky.ui.uiSupport169;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class HotkeysSupport extends hudSupport11<cloudRecord> {
   public static final String v2 = "hotkeys";
   private static final float v8 = 200.0F;
   private static final float v9 = 10.0F;
   private static final float v10 = 13.0F;
   private static final float v11 = 12.0F;
   private static final float v12 = 24.0F;
   private static final float v13 = 18.0F;
   private static final float v14 = 2.0F;
   private static final float v15 = 12.0F;
   private static final float v16 = 9.0F;
   private static final float v18 = 18.0F;
   private static final float v19 = 13.0F;
   private static final float v17 = 1.0F;
   private static final float v20 = 44.0F;
   private static final float v21 = 16.0F;
   private static final hudSupport11.Part1 v22 = new hudSupport11.Part1("Hotkeys", 10.0F, 2.0F, 24.0F, 9.0F, 13.0F, 200.0F);
   private final uiSupport150 v24;
   private List<cloudRecord> v25 = List.of();
   @Nullable
   private List<cloudRecord> v26;
   private int v27 = -1;
   private static final float v28 = 13.0F;

   public HotkeysSupport(Supplier<List<uiSupport150.Part1>> var1, hudSupport52 var2, float var3, float var4) {
      super("hotkeys", 31, var2, var3, var4, v22, cloudRecord::v1);
      this.v24 = this.v2().v1(new uiSupport150("modules").v1(var1), SettingCondition.v1(() -> !((List)var1.get()).isEmpty()));
   }

   @Override
   public float v40() {
      return this.v2().v14() ? 48.0F : 13.0F;
   }

   private float v44() {
      return this.v2().v14() ? 44.0F : 13.0F;
   }

   @Override
   public class_2960 v38() {
      return hudSupport49.v16;
   }

   @Override
   public List<cloudRecord> v14(hudSupport40 var1) {
      List var2 = var1.v6().v37();
      int var3 = this.v24.v10();
      if (var2 == this.v26 && var3 == this.v27) {
         return this.v25;
      } else {
         this.v26 = var2;
         this.v27 = var3;
         if (this.v24.v8().isEmpty()) {
            this.v25 = var2;
            return this.v25;
         } else {
            ArrayList var4 = new ArrayList(var2.size());

            for (cloudRecord var6 : var2) {
               if (this.v24.v1(var6.v1())) {
                  var4.add(var6);
               }
            }

            this.v25 = List.copyOf(var4);
            return this.v25;
         }
      }
   }

   @Override
   public void v2(float var1, float var2, float var3) {
      float var4 = 18.0F * var3;
      float var5 = 3.0F * var3;
      this.v1(hudSupport49.v16, var1 + 12.0F * var3 + var5, var2 + var5, var4, var4);
   }

   public float v1(cloudRecord var1, float var2) {
      float var3 = uiSupport169.v2("syky_sans_strong", var1.v2(), 16.0F * var2);
      float var4 = uiSupport169.v2("syky_sans_strong", var1.v3(), 16.0F * var2);
      return this.v44() * var2 + var3 + 16.0F * var2 + var4 + 13.0F * var2;
   }

   public void v1(cloudRecord var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var3 + -0.10999966F * var5;
      int var8 = CopiedSupport2.v1(-855638017, var6);
      if (this.v2().v14() && var1.v4() != null) {
         float var9 = 18.0F * var5;
         this.v1(var1.v4(), var2 + 13.0F * var5, var3 + 1.0F * var5, var9, var9, CopiedSupport2.v1(-1, var6), uiRecord7.ZERO);
      }

      this.v1("syky_sans_strong", var1.v2(), var2 + this.v44() * var5, var7, 16.0F * var5, var8);
      float var11 = uiSupport169.v2("syky_sans_strong", var1.v3(), 16.0F * var5);
      float var10 = var2 + var4 - 13.0F * var5 - var11;
      this.v1("syky_sans_strong", var1.v3(), var10, var7, 16.0F * var5, var8);
   }
}
