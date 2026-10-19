package cc.syky.internal;

import cc.syky.cloud.cloudSupport69;
import cc.syky.module.visual.visualSupport9;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.class_1921;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_9799;
import net.minecraft.class_9801;
import org.joml.Matrix4fStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport33 implements visualSupport9.Part1 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.render");
   private static final int v2 = 16384;
   private final Map<class_1921, class_9799> v3 = new HashMap<>();
   private final Map<class_1921, class_287> v4 = new LinkedHashMap<>();

   public InternalSupport33() {
   }

   public class_287 v1(class_1921 var1) {
      class_287 var2 = this.v4.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         class_9799 var3 = this.v3.computeIfAbsent(var1, var0 -> new class_9799(16384));
         class_287 var4 = cloudSupport69.v1(() -> new class_287(var3, class_5596.field_27382, class_290.field_1580));
         this.v4.put(var1, var4);
         return var4;
      }
   }

   public void v1() {
      for (class_287 var2 : this.v4.values()) {
         try {
            class_9801 var3 = var2.method_60794();
            if (var3 != null) {
               var3.close();
            }
         } catch (Throwable var4) {
            v1.debug("discarding a late layer batch failed", var4);
         }
      }

      this.v4.clear();
   }

   public void v2(class_1921 var1) {
      class_9799 var2 = this.v3.remove(var1);
      if (var2 != null) {
         var2.close();
      }
   }

   @Override
   public boolean v2() {
      return this.v4.isEmpty();
   }

   @Override
   public void v3() {
      Matrix4fStack var1 = RenderSystem.getModelViewStack();
      var1.pushMatrix();

      try {
         var1.set(visualSupport9.v12());

         for (Entry var3 : this.v4.entrySet()) {
            class_9801 var4 = ((class_287)var3.getValue()).method_60794();
            if (var4 != null) {
               ((class_1921)var3.getKey()).method_60895(var4);
            }
         }
      } finally {
         this.v4.clear();
         var1.popMatrix();
      }
   }

   public void v4() {
      this.v1();

      for (class_9799 var2 : this.v3.values()) {
         var2.close();
      }

      this.v3.clear();
   }
}
