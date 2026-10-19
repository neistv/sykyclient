package cc.syky.ui;

import cc.syky.cloud.InvalidMSDFSupport;
import cc.syky.cloud.cloudSupport101;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport166 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.render.font");
   private final cloudSupport101 v2;
   private final Map<String, InvalidMSDFSupport> v3 = new HashMap<>();
   private final String[] v4 = new String[4];
   private final InvalidMSDFSupport[] v5 = new InvalidMSDFSupport[4];
   private int v6;
   private final Map<String, String> v7 = new HashMap<>();
   private final Set<String> v8 = new HashSet<>();

   public uiSupport166(cloudSupport101 var1) {
      this.v2 = var1;
   }

   public void v1(String var1, String var2) {
      this.v7.put(var1, var2);
   }

   @Nullable
   public InvalidMSDFSupport v1(String var1) {
      for (int var2 = 0; var2 < this.v4.length; var2++) {
         if (this.v4[var2] == var1) {
            return this.v5[var2];
         }
      }

      InvalidMSDFSupport var10 = this.v3.get(var1);
      if (var10 != null) {
         this.v4[this.v6] = var1;
         this.v5[this.v6] = var10;
         this.v6 = (this.v6 + 1) % this.v4.length;
         return var10;
      } else if (this.v8.contains(var1)) {
         return null;
      } else {
         String var3 = this.v7.get(var1);
         if (var3 == null) {
            return null;
         } else {
            try {
               class_2960 var4 = class_2960.method_60655("syky", "fonts/msdf/" + var3 + ".json");
               class_2960 var5 = class_2960.method_60655("syky", "fonts/msdf/" + var3 + ".png");
               long var6 = System.nanoTime();
               InvalidMSDFSupport var8 = InvalidMSDFSupport.v1(var1, var4, var5, this.v2.v1().method_1478());
               this.v3.put(var1, var8);
               v1.info("loaded MSDF font {} ({}) in {} ms", new Object[]{var1, var3, (System.nanoTime() - var6) / 1000000L});
               return var8;
            } catch (Exception var9) {
               v1.error("failed to load MSDF font {}", var1, var9);
               this.v8.add(var1);
               return null;
            }
         }
      }
   }

   public void v1() {
      for (String var2 : this.v7.keySet()) {
         this.v1(var2);
      }
   }

   public void v2() {
      Arrays.fill(this.v4, null);
      Arrays.fill(this.v5, null);
      this.v3.clear();
      this.v8.clear();
   }
}
