package cc.syky.hud;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1058;
import net.minecraft.class_1059;
import net.minecraft.class_10725;
import net.minecraft.class_10799;
import net.minecraft.class_12247;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import org.joml.Matrix4f;

public final class hudSupport68 {
   private static final Map<class_2960, class_1921> v1 = new HashMap<>();

   private hudSupport68() {
   }

   public static class_4588 v1(class_310 var0, class_4597 var1) {
      return var1.method_73477(v1(v1(var0).method_24106()));
   }

   public static void v1(
      class_310 var0,
      class_4588 var1,
      Matrix4f var2,
      class_2960 var3,
      int var4,
      int var5,
      int var6,
      int var7,
      float var8,
      float var9,
      int var10,
      int var11,
      int var12
   ) {
      if (var0 != null && var10 > 0 && var11 > 0 && var4 > 0 && var5 > 0) {
         class_1058 var13 = v1(var0).method_4608(var3);
         float var14 = var13.method_4580((float)var6 / var4);
         float var15 = var13.method_4580((float)(var6 + var10) / var4);
         float var16 = var13.method_4570((float)var7 / var5);
         float var17 = var13.method_4570((float)(var7 + var11) / var5);
         float var18 = var8 + var10;
         float var19 = var9 + var11;
         var1.method_22918(var2, var8, var9, 0.0F).method_22913(var14, var16).method_39415(var12);
         var1.method_22918(var2, var8, var19, 0.0F).method_22913(var14, var17).method_39415(var12);
         var1.method_22918(var2, var18, var19, 0.0F).method_22913(var15, var17).method_39415(var12);
         var1.method_22918(var2, var18, var9, 0.0F).method_22913(var15, var16).method_39415(var12);
      }
   }

   private static class_1059 v1(class_310 var0) {
      return var0.method_72703().method_73025(class_10725.field_56385);
   }

   private static class_1921 v1(class_2960 var0) {
      return v1.computeIfAbsent(
         var0,
         var0x -> class_1921.method_75940("syky_gui_sprite", class_12247.method_75927(class_10799.field_56883).method_75934("Sampler0", var0x).method_75938())
      );
   }
}
