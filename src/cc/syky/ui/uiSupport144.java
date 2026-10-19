package cc.syky.ui;

import cc.syky.cloud.cloudRecord9;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport79;
import cc.syky.cloud.cloudSupport80;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_342;

public final class uiSupport144 {
   private static final int v1 = 10;
   private static final int v2 = -805306368;
   private static final int v3 = -5592406;
   private static final int v4 = -171;
   private static final int v5 = 2;
   private static final int v6 = 2;
   private final class_342 v7;
   private final cloudSupport80 v8;
   private final class_327 v9;
   private cloudRecord9 v10 = cloudRecord9.EMPTY;
   private int v11;
   private int v12;
   private String v13 = "";

   public uiSupport144(class_342 var1, cloudSupport80 var2, cloudSupport101 var3) {
      this.v7 = var1;
      this.v8 = var2;
      this.v9 = var3.v1().field_1772;
   }

   public void v1() {
      String var1 = this.v7.method_1882();
      if (!var1.equals(this.v13)) {
         this.v13 = var1;
         cloudRecord9 var2 = cloudSupport79.v1(this.v8, var1);
         if (!v1(this.v10, var2)) {
            this.v11 = 0;
            this.v12 = 0;
         }

         this.v10 = var2;
         this.v4();
      }
   }

   public boolean v1(int var1) {
      if (this.v10.v1()) {
         return false;
      } else {
         switch (var1) {
            case 258:
               this.v2();
               return true;
            case 264:
               this.v2(1);
               return true;
            case 265:
               this.v2(-1);
               return true;
            default:
               return false;
         }
      }
   }

   public boolean v1(double var1, double var3, double var5) {
      if (this.v10.v1()) {
         return false;
      } else if (!this.v2(var1, var3)) {
         return false;
      } else {
         this.v2(var5 > 0.0 ? -1 : 1);
         return true;
      }
   }

   public boolean v1(double var1, double var3) {
      if (this.v10.v1()) {
         return false;
      } else {
         int var5 = this.v7();
         int var6 = this.v8();
         int var7 = this.v9();
         int var8 = this.v6();
         int var9 = this.v5();
         if (!(var1 < var5) && !(var1 >= var5 + var7)) {
            for (int var10 = 0; var10 < var9; var10++) {
               int var11 = var6 + var10 * var8;
               if (var3 >= var11 && var3 < var11 + var8) {
                  this.v11 = this.v12 + var10;
                  this.v2();
                  return true;
               }
            }

            return false;
         } else {
            return false;
         }
      }
   }

   public void v1(class_332 var1) {
      if (!this.v10.v1()) {
         int var2 = this.v7();
         int var3 = this.v8();
         int var4 = this.v9();
         int var5 = this.v6();
         int var6 = this.v5();
         var1.method_25294(var2, var3, var2 + var4, var3 + var6 * var5, -805306368);

         for (int var7 = 0; var7 < var6; var7++) {
            int var8 = this.v12 + var7;
            String var9 = this.v10.v3().get(var8);
            int var10 = var8 == this.v11 ? -171 : -5592406;
            var1.method_25303(this.v9, var9, var2 + 2, var3 + var7 * var5 + 1, var10);
         }
      }
   }

   private void v2() {
      if (!this.v10.v1() && this.v11 >= 0 && this.v11 < this.v10.v3().size()) {
         String var1 = this.v10.v3().get(this.v11);
         String var2 = this.v7.method_1882();
         int var3 = this.v10.v2();
         if (var3 <= var2.length()) {
            String var4 = var2.substring(0, var3);
            boolean var5 = !var4.isEmpty() && var4.charAt(var4.length() - 1) != ' ';
            String var6 = (var5 ? " " : "") + var1 + " ";
            this.v7.method_1852(var4 + var6);
            this.v7.method_1883(var4.length() + var6.length(), false);
            this.v1();
         }
      }
   }

   private void v2(int var1) {
      int var2 = this.v10.v3().size();
      if (var2 > 0) {
         this.v11 = ((this.v11 + var1) % var2 + var2) % var2;
         this.v3();
      }
   }

   private void v3() {
      if (this.v11 < this.v12) {
         this.v12 = this.v11;
      } else if (this.v11 >= this.v12 + 10) {
         this.v12 = this.v11 - 10 + 1;
      }

      this.v12 = Math.max(0, Math.min(this.v12, Math.max(0, this.v10.v3().size() - 10)));
   }

   private void v4() {
      if (this.v10.v3().isEmpty()) {
         this.v11 = 0;
         this.v12 = 0;
      } else {
         if (this.v11 >= this.v10.v3().size()) {
            this.v11 = this.v10.v3().size() - 1;
         }

         this.v3();
      }
   }

   private int v5() {
      return Math.min(10, this.v10.v3().size());
   }

   private int v6() {
      return 9 + 2;
   }

   private int v7() {
      String var1 = this.v7.method_1882();
      int var2 = Math.min(this.v10.v2(), var1.length());
      String var3 = var1.substring(0, var2);
      boolean var4 = !var3.isEmpty() && var3.charAt(var3.length() - 1) != ' ';
      int var5 = this.v9.method_1727(var3) + (var4 ? this.v9.method_1727(" ") : 0);
      return this.v7.method_46426() + 4 + var5;
   }

   private int v8() {
      int var1 = this.v6();
      return this.v7.method_46427() - this.v5() * var1 - 1;
   }

   private int v9() {
      int var1 = 0;
      int var2 = Math.min(this.v10.v3().size(), this.v12 + 10);

      for (int var3 = this.v12; var3 < var2; var3++) {
         int var4 = this.v9.method_1727(this.v10.v3().get(var3));
         if (var4 > var1) {
            var1 = var4;
         }
      }

      return var1 + 4;
   }

   private boolean v2(double var1, double var3) {
      int var5 = this.v7();
      int var6 = this.v8();
      int var7 = this.v9();
      int var8 = this.v5() * this.v6();
      return var1 >= var5 && var1 < var5 + var7 && var3 >= var6 && var3 < var6 + var8;
   }

   private static boolean v1(cloudRecord9 var0, cloudRecord9 var1) {
      if (var0.v2() != var1.v2()) {
         return false;
      } else if (var0.v3().size() != var1.v3().size()) {
         return false;
      } else {
         for (int var2 = 0; var2 < var0.v3().size(); var2++) {
            if (!var0.v3().get(var2).equals(var1.v3().get(var2))) {
               return false;
            }
         }

         return true;
      }
   }
}
