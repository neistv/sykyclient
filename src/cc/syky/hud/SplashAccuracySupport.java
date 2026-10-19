package cc.syky.hud;

import cc.syky.config.IntSetting;
import cc.syky.config.configSupport6;
import cc.syky.config.configSupport7;
import cc.syky.ui.uiRecord;
import java.util.List;
import net.minecraft.class_2960;

public final class SplashAccuracySupport extends hudSupport21<uiRecord> {
   public static final String v2 = "splash_accuracy";
   private static final long v6 = 1000000000L;
   private static final uiRecord v7 = new uiRecord(-1L, "Splash Accuracy", class_2960.method_60655("syky", "splash_accuracy_placeholder"), 0, 0L);
   private final IntSetting v8;
   private final float[] v9 = new float[3];
   private float v10 = -1.0F;

   public SplashAccuracySupport(hudSupport52 var1, float var2, float var3) {
      super("splash_accuracy", 11, var1, var2, var3, uiRecord::v1);
      this.v8 = this.v2().v1(new IntSetting("holdFor", 4, 1, 10).v1("s"));
   }

   @Override
   public List<uiRecord> v15(hudSupport40 var1) {
      configSupport6 var2 = var1.v6().v25();
      var2.v1(this.v8.getValue().intValue() * 1000000000L);
      return var2.v1();
   }

   public uiRecord v40() {
      return v7;
   }

   public boolean v1(uiRecord var1, uiRecord var2) {
      return var1.v1() > var2.v1();
   }

   public String v1(uiRecord var1) {
      return var1.v2();
   }

   public class_2960 v2(uiRecord var1) {
      return var1.v3();
   }

   public String v3(uiRecord var1) {
      return configSupport7.v1(var1.v4());
   }

   public float v1(uiRecord var1, float var2) {
      if (var2 != this.v10 || !(this.v9[0] > 0.0F)) {
         this.v10 = var2;
         this.v9[0] = v1(1, 9, configSupport7::v1, var2);
         this.v9[1] = v1(10, 99, configSupport7::v1, var2);
         this.v9[2] = v1(100, 100, configSupport7::v1, var2);
      }

      return this.v9[configSupport7.v2(var1.v4()) - 1];
   }
}
