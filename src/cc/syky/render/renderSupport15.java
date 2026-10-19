package cc.syky.render;

import cc.syky.cloud.cloudSupport69;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.class_1921;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_9799;
import net.minecraft.class_9801;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class renderSupport15 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.render3d.billboard");
   private static final int v2 = 4096;
   private static final VertexFormat v3 = class_290.field_1580;
   private static final class_2960 v4 = class_2960.method_60655("syky", "glow");
   private final Map<renderSupport15.Part1, class_9799> v5 = new HashMap<>();
   private final Map<renderSupport15.Part1, class_287> v6 = new LinkedHashMap<>();
   private int v7;
   @Nullable
   private class_2960 v8;
   @Nullable
   private renderSupport9 v9;
   @Nullable
   private class_287 v10;
   private boolean v11;

   public renderSupport15() {
   }

   public class_287 v1(class_2960 var1, renderSupport9 var2) {
      if (!this.v11) {
         this.v11 = true;
         v1.info("first billboard recorded this session: texture={}, layer={}", var1, var2);
      }

      if (this.v10 != null && var2 == this.v9 && var1.equals(this.v8)) {
         return this.v10;
      } else {
         renderSupport15.Part1 var3 = new renderSupport15.Part1(var1, var2);
         class_287 var4 = this.v6.get(var3);
         if (var4 != null) {
            return this.v1(var1, var2, var4);
         } else {
            class_9799 var5 = this.v5.computeIfAbsent(var3, var0 -> new class_9799(4096));
            class_287 var6 = cloudSupport69.v1(() -> new class_287(var5, class_5596.field_27382, v3));
            this.v6.put(var3, var6);
            if (var2.v1()) {
               this.v7++;
            }

            return this.v1(var1, var2, var6);
         }
      }
   }

   public class_287 v1() {
      return this.v1(v4, renderSupport9.TRANSLUCENT);
   }

   private class_287 v1(class_2960 var1, renderSupport9 var2, class_287 var3) {
      this.v8 = var1;
      this.v9 = var2;
      this.v10 = var3;
      return var3;
   }

   private void v9() {
      this.v8 = null;
      this.v9 = null;
      this.v10 = null;
   }

   public int v2() {
      return this.v6.size();
   }

   public void v3() {
      if (!this.v6.isEmpty()) {
         this.v1(false);
      }
   }

   public void v4() {
      if (this.v7 != 0) {
         this.v1(true);
      }
   }

   private void v1(boolean var1) {
      try {
         Iterator var2 = this.v6.entrySet().iterator();

         while (var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            renderSupport15.Part1 var4 = (renderSupport15.Part1)var3.getKey();
            if (!var1 || var4.v2().v1()) {
               class_287 var5 = (class_287)var3.getValue();
               var2.remove();
               if (var1) {
                  this.v7--;
               }

               class_9801 var6 = null;

               try {
                  var6 = var5.method_60794();
                  if (var6 != null) {
                     class_1921 var7 = var4.layer == renderSupport9.SPRITE ? EMISSIVESupport.v1(var4.texture) : renderSupport5.v2();
                     var7.method_60895(var6);
                  }
               } catch (Throwable var14) {
                  if (var6 != null) {
                     try {
                        var6.close();
                     } catch (Throwable var13) {
                     }
                  }

                  v1.warn("billboard batch flush failed for {}", var4.texture, var14);
               }
            }
         }
      } finally {
         if (!var1) {
            this.v7 = 0;
         }

         this.v9();
      }
   }

   public void v5() {
      this.v9();
      this.v7 = 0;
      if (!this.v6.isEmpty()) {
         int var1 = 0;

         for (class_287 var3 : this.v6.values()) {
            try {
               class_9801 var4 = var3.method_60794();
               if (var4 != null) {
                  var4.close();
                  var1++;
               }
            } catch (Throwable var5) {
               v1.warn("stale billboard builder cleanup failed", var5);
            }
         }

         this.v6.clear();
         if (var1 > 0) {
            v1.warn("dropped {} stale billboard batch(es) from previous frame (drain missed?)", var1);
         }
      }
   }

   public void v6() {
      this.v5();

      for (class_9799 var2 : this.v5.values()) {
         try {
            var2.close();
         } catch (Throwable var4) {
            v1.warn("allocator close failed", var4);
         }
      }

      this.v5.clear();
   }

   public boolean v7() {
      return this.v6.isEmpty();
   }

   public boolean v8() {
      return this.v7 == 0;
   }

   public record Part1(class_2960 texture, renderSupport9 layer) {

      public class_2960 v1() {
         return this.texture;
      }

      public renderSupport9 v2() {
         return this.layer;
      }
   }
}
