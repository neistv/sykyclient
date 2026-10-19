package cc.syky.config;

import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudSupport94;
import cc.syky.cloud.cloudSupport98;
import cc.syky.mixin.accessor.EntryListWidgetInvoker;
import cc.syky.ui.uiSupport259;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_3675;
import net.minecraft.class_4185;
import net.minecraft.class_459;
import net.minecraft.class_5250;
import net.minecraft.class_6379;
import net.minecraft.class_6599;
import net.minecraft.class_7919;
import net.minecraft.class_3675.class_306;
import net.minecraft.class_3675.class_307;
import net.minecraft.class_459.class_461;
import org.jetbrains.annotations.Nullable;

public final class AltSupport extends class_461 {
   private static final int v1 = 75;
   private static final int v2 = 50;
   private static final int v3 = 20;
   private static final int v4 = 9;
   private static final int v5 = 10;
   private static final int v6 = 5;
   private static final int v7 = 3;
   private static final int v8 = 6;
   private final configSupport4 v9;
   private final List<configSupport4> v10;
   private final class_6599 v11;
   private final class_459 v12;
   private final class_310 v13;
   private final class_2561 v14;
   private final class_4185 v15;
   private final class_4185 v16;
   private final List<class_4185> v18;
   private boolean v19;
   @Nullable
   private class_2561 v17;

   public AltSupport(configSupport4 var1, List<configSupport4> var2, class_6599 var3, class_459 var4, class_310 var5) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = var3;
      this.v12 = var4;
      this.v13 = var5;
      this.v14 = class_2561.method_43470(var1.v1());
      this.v15 = class_4185.method_46430(this.v14, var1x -> uiSupport259.v1("keybinds.arm", this::v2)).method_46434(0, 0, 75, 20).method_46431();
      this.v16 = class_4185.method_46430(class_2561.method_43471("controls.reset"), var1x -> uiSupport259.v1("keybinds.reset", this::v3))
         .method_46434(0, 0, 50, 20)
         .method_46431();
      this.v18 = List.of(this.v15, this.v16);
      this.v4();
   }

   public boolean v1() {
      return this.v19;
   }

   public void v1(int var1, int var2) {
      this.v19 = false;
      if (var1 == 256) {
         this.v9.v1(cloudRecord10.v1(-1));
      } else {
         this.v9.v1(cloudSupport98.v1(var1, var2));
      }
   }

   private void v2() {
      this.v11.field_34799 = null;

      for (class_461 var2 : this.v12.method_25396()) {
         if (var2 instanceof AltSupport var3) {
            var3.v19 = var3 == this;
         }
      }

      this.v12.method_49006();
   }

   private void v3() {
      this.v9.v5();
      this.v12.method_49006();
   }

   public void method_25343(class_332 var1, int var2, int var3, boolean var4, float var5) {
      uiSupport259.v1("keybinds.row-render", () -> this.v1(var1, var2, var3, var5));
   }

   private void v1(class_332 var1, int var2, int var3, float var4) {
      int var5 = ((EntryListWidgetInvoker)this.v12).syky$scrollbarX() - 50 - 10;
      int var6 = this.method_73382() - 2;
      this.v16.method_48229(var5, var6);
      this.v16.method_25394(var1, var2, var3, var4);
      int var7 = var5 - 5 - 75;
      this.v15.method_48229(var7, var6);
      this.v15.method_25394(var1, var2, var3, var4);
      var1.method_27535(this.v13.field_1772, this.v14, this.method_73380(), this.method_73385() - 4, -1);
      if (this.v17 != null) {
         int var8 = var7 - 6;
         var1.method_25294(var8, this.method_73382() - 1, var8 + 3, this.method_73386(), -256);
      }
   }

   public void method_48269() {
      uiSupport259.v1("keybinds.row-update", this::v4);
   }

   private void v4() {
      if (this.v11.field_34799 != null) {
         this.v19 = false;
      }

      this.v16.field_22763 = !this.v9.v4();
      this.v17 = this.v1(this.v9.v3());
      this.v15.method_25355(this.v5());
      if (this.v17 != null) {
         this.v15
            .method_25355(
               class_2561.method_43470("[ ")
                  .method_10852(this.v15.method_25369().method_27661().method_27692(class_124.field_1068))
                  .method_27693(" ]")
                  .method_27692(class_124.field_1054)
            );
         this.v15.method_47400(class_7919.method_47407(class_2561.method_43469("controls.keybinds.duplicateKeybinds", new Object[]{this.v17})));
      } else {
         this.v15.method_47400(null);
      }

      if (this.v19) {
         this.v15
            .method_25355(
               class_2561.method_43470("> ")
                  .method_10852(this.v15.method_25369().method_27661().method_27695(new class_124[]{class_124.field_1068, class_124.field_1073}))
                  .method_27693(" <")
                  .method_27692(class_124.field_1054)
            );
      }
   }

   @Nullable
   private class_2561 v1(cloudRecord10 var1) {
      if (var1.v1() == -1) {
         return null;
      } else {
         String var2 = v1(var1.v1()).method_1441();
         class_5250 var3 = class_2561.method_43473();
         boolean var4 = false;

         for (class_304 var8 : this.v13.field_1690.field_1839) {
            if (var8.method_1428().equals(var2)) {
               if (var4) {
                  var3.method_27693(", ");
               }

               var3.method_10852(class_2561.method_43471(var8.method_1431()));
               var4 = true;
            }
         }

         for (configSupport4 var10 : this.v10) {
            if (configSupport3.v1(this.v9, var10)) {
               if (var4) {
                  var3.method_27693(", ");
               }

               var3.method_27693(var10.v1());
               var4 = true;
            }
         }

         return var4 ? var3 : null;
      }
   }

   private static class_306 v1(int var0) {
      return cloudSupport94.v2(var0) ? class_307.field_1672.method_1447(cloudSupport94.v3(var0)) : class_307.field_1668.method_1447(var0);
   }

   private class_2561 v5() {
      cloudRecord10 var1 = this.v9.v3();
      if (var1.v1() == -1) {
         return class_3675.field_16237.method_27445();
      } else {
         class_5250 var2 = class_2561.method_43473();
         if ((var1.v2() & 1) != 0) {
            var2.method_27693("Shift + ");
         }

         if ((var1.v2() & 2) != 0) {
            var2.method_27693("Ctrl + ");
         }

         if ((var1.v2() & 4) != 0) {
            var2.method_27693("Alt + ");
         }

         if ((var1.v2() & 8) != 0) {
            var2.method_27693("Super + ");
         }

         return var2.method_10852(v1(var1.v1()).method_27445());
      }
   }

   public List<? extends class_364> method_25396() {
      return this.v18;
   }

   public List<? extends class_6379> method_37025() {
      return this.v18;
   }
}
