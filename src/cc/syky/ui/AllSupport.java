package cc.syky.ui;

import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.Setting;
import cc.syky.hud.hudSupport64;
import cc.syky.hud.hudSupport75;
import cc.syky.module.visual.visualSupport6;
import cc.syky.module.visual.visualSupport7;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class AllSupport {
   private final String v1;
   private final AllSupport.Part1 v2;
   @Nullable
   private final hudSupport75 v3;
   private static final Map<Enum<?>, String> v4 = new IdentityHashMap<>();

   public AllSupport(String var1, @Nullable hudSupport75 var2, AllSupport.Part1 var3) {
      this.v1 = var1;
      this.v3 = var2;
      this.v2 = var3;
   }

   public uiSupport61 v1(Setting<?> var1, Map<Setting<?>, ColorSetting> var2, Map<BooleanSetting, Setting<?>> var3) {
      String var4 = uiSupport135.v3(this.v1, var1.getName());
      if (var1 instanceof BooleanSetting var9) {
         return this.v1(var9, (ColorSetting)var2.get(var9), (Setting<?>)var3.get(var9), var4);
      } else {
         uiSupport60 var5 = this.v1(var1, 136.0F);
         if (var5 != null) {
            return new uiSupport58(var4, var5);
         } else {
            uiSupport64 var6 = this.v2(var1, 136.0F);
            if (var6 != null) {
               return new uiSupport63(var4, var6);
            } else if (var1 instanceof EnumSetting var15) {
               return this.v1(var15, (ColorSetting)var2.get(var15), var4);
            } else if (var1 instanceof visualSupport6 var14) {
               return this.v1(var14, var4);
            } else if (var1 instanceof uiSupport149 var13) {
               uiSupport65 var17 = (var2x, var3x, var4x, var5x, var6x, var7x) -> this.v2.open(var13, var3x, var4x, var5x, var6x, var7x);
               return new uiSupport67(var4, () -> v1(var13), var17, 136.0F);
            } else if (var1 instanceof uiSupport150 var12) {
               uiSupport65 var16 = (var2x, var3x, var4x, var5x, var6x, var7x) -> this.v2.open(var12, var3x, var4x, var5x, var6x, var7x);
               return new uiSupport67(var4, () -> v1(var12), var16, 136.0F);
            } else if (var1 instanceof ColorSetting var11) {
               uiSupport65 var8 = (var2x, var3x, var4x, var5x, var6x, var7x) -> this.v2.open(var11, var3x, var4x, var5x, var6x, var7x);
               return new uiSupport66(var4, () -> var11.getValue(), var8, null, null, 0.0F, 0.0F);
            } else if (var1 instanceof visualSupport7 var10) {
               return v1(var10, var4);
            } else {
               return (uiSupport61)(var1 instanceof uiSupport151 var7 && this.v3 != null
                  ? new uiSupport70(var4, new PressASupport(var7.v1(), this.v3))
                  : new uiSupport57(var4 + " (?)", () -> false, () -> {}));
            }
         }
      }
   }

   private static uiSupport60.Part1 v1(float var0, String var1, String var2) {
      return var3 -> var3 <= var0 ? var1 : uiSupport60.v1(var3) + var2;
   }

   @Nullable
   private uiSupport60 v1(Setting<?> var1, float var2) {
      if (v1(var1)) {
         return null;
      } else if (var1 instanceof FloatSetting var7) {
         String var4 = var7.getSnapStop();
         String var5 = var7.getSuffix();
         uiSupport60.Part1 var6 = var4 == null ? var1x -> uiSupport60.v1(var1x) + var5 : v1(var7.getMin(), var4, var5);
         return new uiSupport60(() -> var7.getValue().doubleValue(), var1x -> var7.setValue((float)var1x), var7.getMin(), var7.getMax(), 0.0, var6, var2);
      } else {
         return var1 instanceof IntSetting var3
            ? new uiSupport60(
               () -> var3.getValue().doubleValue(),
               var1x -> var3.setValue((int)Math.round(var1x)),
               var3.getMin(),
               var3.getMax(),
               1.0,
               var1x -> Math.round(var1x) + var3.v12(),
               var2
            )
            : null;
      }
   }

   private static boolean v1(Setting<?> var0) {
      return var0 instanceof IntSetting var2 && var2.v14() || var0 instanceof FloatSetting var1 && var1.isDraggable();
   }

   @Nullable
   private uiSupport64 v2(Setting<?> var1, float var2) {
      if (var1 instanceof IntSetting var3 && var3.v14()) {
         return new uiSupport64(
            () -> var3.getValue().doubleValue(),
            var1x -> var3.setValue((int)Math.round(var1x)),
            var3.getMin(),
            var3.getMax(),
            true,
            var0 -> Long.toString(Math.round(var0)),
            var2
         );
      } else {
         return var1 instanceof FloatSetting var4 && var4.isDraggable()
            ? new uiSupport64(
               () -> var4.getValue().doubleValue(), var1x -> var4.setValue((float)var1x), var4.getMin(), var4.getMax(), false, uiSupport60::v1, var2
            )
            : null;
      }
   }

   @Nullable
   private Supplier<String> v2(Setting<?> var1) {
      if (var1 instanceof EnumSetting var3) {
         return () -> v1(var3.getValue());
      } else {
         return var1 instanceof visualSupport6 var2 ? () -> v1(var2) : null;
      }
   }

   public static void v1(BooleanSetting var0) {
      var0.setValue(!var0.getValue());
      uiSupport148.v1(uiSupport146.v1(var0.getValue()));
   }

   private uiSupport61 v1(BooleanSetting var1, @Nullable ColorSetting var2, @Nullable Setting<?> var3, String var4) {
      BooleanSupplier var5 = () -> var1.getValue();
      Runnable var6 = () -> v1(var1);
      IntSupplier var7 = var2 == null ? null : () -> var2.getValue();
      uiSupport65 var8 = var2 == null ? null : (var2x, var3x, var4x, var5x, var6x, var7x) -> this.v2.open(var2, var3x, var4x, var5x, var6x, var7x);
      uiSupport60 var9 = var3 == null ? null : this.v1(var3, 72.0F);
      uiSupport64 var10 = var3 != null && var9 == null ? this.v2(var3, 82.0F) : null;
      Supplier var11 = null;
      uiSupport65 var12 = null;
      if (var3 != null && var9 == null && var10 == null) {
         var11 = this.v2(var3);
         if (var11 != null) {
            var12 = (var2x, var3x, var4x, var5x, var6x, var7x) -> this.v2.open(var3, var3x, var4x, var5x, var6x, var7x);
         }
      }

      return new uiSupport57(var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   private <E extends Enum<E>> uiSupport61 v1(EnumSetting<?> var1, @Nullable ColorSetting var2, String var3) {
      uiSupport65 var5 = (var2x, var3x, var4, var5x, var6x, var7x) -> this.v2.open(var1, var3x, var4, var5x, var6x, var7x);
      if (var2 == null) {
         return new uiSupport67(var3, () -> v1(var1.getValue()), var5, 136.0F);
      } else {
         uiSupport65 var6 = (var2x, var3x, var4, var5x, var6x, var7x) -> this.v2.open(var2, var3x, var4, var5x, var6x, var7x);
         float var7 = 0.0F;

         for (Enum var11 : var1.getValues()) {
            var7 = Math.max(var7, uiSupport169.v2("syky_sans_strong", v1(var11), 18.0F));
         }

         return new uiSupport66(var3, () -> var2.getValue(), var6, () -> v1(var1.getValue()), var5, 136.0F, var7);
      }
   }

   private static uiSupport61 v1(visualSupport7 var0, String var1) {
      uiSupport65 var2 = (var1x, var2x, var3x, var4x, var5, var6) -> var0.v1();
      float var3 = uiSupport169.v2("syky_sans_strong", var0.v8(), 18.0F);
      float var4 = Math.max(136.0F, uiSupport68.v1(var3));
      return new uiSupport67(var1, new AllSupport.Part2(var0, var4 - uiSupport68.v1(0.0F)), var2, var4);
   }

   public static String v1(String var0, float var1) {
      if (v1(var0) <= var1) {
         return var0;
      } else {
         int var2 = var0.lastIndexOf(46);
         String var3 = var2 > 0 && var0.length() - var2 <= 6 ? var0.substring(var2) : "";
         String var4 = var0.substring(0, var0.length() - var3.length());

         for (int var5 = var4.length() - 1; var5 > 0; var5--) {
            String var6 = var4.substring(0, var5) + "..." + var3;
            if (v1(var6) <= var1) {
               return var6;
            }
         }

         return "..." + var3;
      }
   }

   private static float v1(String var0) {
      return uiSupport169.v2("syky_sans_strong", var0, 18.0F);
   }

   private <E extends Enum<E>> uiSupport61 v1(visualSupport6<?> var1, String var2) {
      uiSupport65 var4 = (var2x, var3, var4x, var5, var6, var7) -> this.v2.open(var1, var3, var4x, var5, var6, var7);
      return new uiSupport67(var2, () -> v1(var1), var4, 136.0F);
   }

   private static String v1(Enum<?> var0) {
      if (var0 instanceof hudSupport64 var4) {
         return var4.v1();
      } else {
         String var1 = v4.get(var0);
         if (var1 != null) {
            return var1;
         } else {
            String var2 = var0.name().toLowerCase(Locale.ROOT).replace('_', ' ');
            String var3 = var2.isEmpty() ? var2 : Character.toUpperCase(var2.charAt(0)) + var2.substring(1);
            v4.put(var0, var3);
            return var3;
         }
      }
   }

   private static <E extends Enum<E>> String v1(visualSupport6<E> var0) {
      Enum[] var1 = var0.v11();
      int var2 = 0;

      for (Enum var6 : var1) {
         if (var0.v1((E)var6)) {
            var2++;
         }
      }

      if (var2 == 0) {
         return "None";
      } else if (var2 == var1.length) {
         return "All";
      } else {
         StringBuilder var8 = new StringBuilder();

         for (Enum var7 : var1) {
            if (var0.v1((E)var7)) {
               if (var8.length() > 0) {
                  var8.append(", ");
               }

               var8.append(v1(var7));
               if (var8.length() > 18) {
                  return var2 + " of " + var1.length;
               }
            }
         }

         return var8.toString();
      }
   }

   private static String v1(uiSupport150 var0) {
      int var1 = var0.v1().size();
      int var2 = var0.v9();
      if (var2 == 0) {
         return "None";
      } else {
         return var2 == var1 ? "All" : var2 + " of " + var1;
      }
   }

   private static String v1(uiSupport149 var0) {
      int var1 = var0.v8().size();
      if (var1 == 0) {
         return "None";
      } else {
         return var1 == 1 ? "1 sound" : var1 + " sounds";
      }
   }

   public interface Part1 {
      void open(Setting<?> var1, float var2, float var3, float var4, float var5, float var6);
   }

   public static final class Part2 implements Supplier<String> {
      private final visualSupport7 v1;
      private final float v2;
      @Nullable
      private String v3;
      private String v4 = "";

      public Part2(visualSupport7 var1, float var2) {
         this.v1 = var1;
         this.v2 = var2;
      }

      public String v1() {
         String var1 = this.v1.v9();
         if (var1 != null) {
            return var1;
         } else if (!this.v1.v10()) {
            return this.v1.v8();
         } else {
            String var2 = this.v1.v12();
            if (!var2.equals(this.v3)) {
               this.v3 = var2;
               this.v4 = AllSupport.v1(this.v1.v11(), this.v2);
            }

            return this.v4;
         }
      }
   }
}
