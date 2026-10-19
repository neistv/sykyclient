package cc.syky.hud;

import cc.syky.config.EnumSetting;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport223;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class ShieldTimerSupport extends hudSupport21<hudRecord5> {
   public static final String v2 = "shield_timer";
   private static final String v6 = "You";
   private static final hudRecord5 v7 = new hudRecord5(new UUID(0L, 0L), false, "Shield Timer", 0.0F);
   private final hudSupport71 v8;
   private final EnumSetting<MyShieldSupport.Part1> v9;
   @Nullable
   private List<hudRecord5> v10;
   @Nullable
   private MyShieldSupport.Part1 v11;
   private List<hudRecord5> v12 = List.of();
   private final List<hudRecord5> v13 = new ArrayList<>(4);
   private final StringBuilder v14 = new StringBuilder(8);
   private final float[] v15 = new float[3];
   private float v16 = -1.0F;
   private final hudSupport16.Part1 v18 = new hudSupport16.Part1();

   public ShieldTimerSupport(hudSupport71 var1, hudSupport52 var2, float var3, float var4) {
      super("shield_timer", 15, var2, var3, var4, hudRecord5::v1);
      this.v8 = var1;
      this.v9 = this.v2().v1(new EnumSetting<>("show", MyShieldSupport.Part1.BOTH));
   }

   @Override
   public List<hudRecord5> v15(hudSupport40 var1) {
      List var2 = this.v8.v1();
      MyShieldSupport.Part1 var3 = this.v9.getValue();
      if (var2 != this.v10 || var3 != this.v11) {
         this.v10 = var2;
         this.v11 = var3;
         this.v12 = MyShieldSupport.v1(var2, var3, this.v13);
      }

      return this.v12;
   }

   public hudRecord5 v40() {
      return v7;
   }

   public boolean v1(hudRecord5 var1, hudRecord5 var2) {
      return MyShieldSupport.v1(var1, var2);
   }

   public String v1(hudRecord5 var1) {
      if (var1.v2()) {
         return "You";
      } else {
         return uiSupport223.v1(var1.v1()) ? "Protected" : var1.v3();
      }
   }

   public class_2960 v2(hudRecord5 var1) {
      return hudSupport49.v18;
   }

   @Override
   public boolean v47() {
      return true;
   }

   @Override
   public class_2960 v38() {
      return hudSupport49.v18;
   }

   public String v3(hudRecord5 var1) {
      return MyShieldSupport.v2(var1.v4());
   }

   public float v1(hudRecord5 var1, float var2) {
      if (var2 != this.v16) {
         this.v16 = var2;
         Arrays.fill(this.v15, 0.0F);
      }

      int var3 = Math.min(hudSupport16.v1(MyShieldSupport.v1(var1.v4())), this.v15.length);
      float var4 = this.v15[var3 - 1];
      if (var4 > 0.0F) {
         return var4;
      } else {
         this.v14.setLength(0);
         hudSupport16.v1(this.v14, this.v18.v1(var2), var3);
         var4 = uiSupport169.v2("syky_sans_strong", this.v14.toString(), var2);
         this.v15[var3 - 1] = var4;
         return var4;
      }
   }

   @Override
   public void v49() {
      this.v10 = null;
      this.v11 = null;
      this.v12 = List.of();
      this.v13.clear();
   }
}
