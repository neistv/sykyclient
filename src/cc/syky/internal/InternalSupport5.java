package cc.syky.internal;

import cc.syky.sykyRecord4;
import cc.syky.sykyRecord5;
import cc.syky.cloud.cloudSupport101;
import cc.syky.module.visual.visualSupport9;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import net.minecraft.class_310;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport5 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.waypoints");
   private static final String v2 = "\u0000draft";
   private final cloudSupport101 v3;
   private final InternalSupport7 v4;
   private final Executor v5;
   private final Map<String, InternalSupport5.Part1> v6 = new HashMap<>();
   private int v7 = -1;

   public InternalSupport5(cloudSupport101 var1, InternalSupport7 var2, Executor var3) {
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = var3;
   }

   public void v1() {
      class_310 var1 = this.v3.v1();
      if (var1 != null && var1.field_1687 != null && this.v4.v8()) {
         double var2 = (var1.field_1690.method_38521() + 1) * 16.0;
         String var4 = this.v4.v10();
         InternalSupport9 var5 = this.v4.v16();
         String var6 = var5.v1() ? var5.v3() : null;
         boolean var7 = this.v7 != this.v4.v15();
         if (var7) {
            for (InternalSupport5.Part1 var9 : this.v6.values()) {
               var9.v2 = false;
            }
         }

         InternalSupport5.Part1 var15 = this.v6.get("\u0000draft");

         for (InternalSupport7.Part3 var10 : this.v4.v14()) {
            sykyRecord4 var11 = var10.v1();
            if (var11.v3() && var11.v9().equals(var4)) {
               InternalSupport5.Part1 var12 = this.v6.computeIfAbsent(var11.v4(), var1x -> new InternalSupport5.Part1(this.v5));
               var12.v2 = true;
               if (!var11.v4().equals(var6)) {
                  if (var15 != null && !var5.v1() && var12.v1.v1(var15.v1, var11.v18())) {
                     var15 = null;
                  }

                  InternalSupport36 var13 = var12.v1.v1(var11.v18());
                  if (var13 != null) {
                     sykyRecord5 var14 = var11.v19();
                     visualSupport9.v1(var13, v1(var11.v12(), var14), var11.v12(), var14.v2(), 0.001, var2);
                  }
               }
            }
         }

         if (var7) {
            Iterator var17 = this.v6.entrySet().iterator();

            while (var17.hasNext()) {
               Entry var20 = (Entry)var17.next();
               if (!((InternalSupport5.Part1)var20.getValue()).v2 && !((String)var20.getKey()).equals("\u0000draft")) {
                  ((InternalSupport5.Part1)var20.getValue()).v1();
                  var17.remove();
               }
            }

            this.v7 = this.v4.v15();
         }

         if (var5.v1()) {
            InternalSupport5.Part1 var18 = this.v6.computeIfAbsent("\u0000draft", var1x -> new InternalSupport5.Part1(this.v5));
            sykyRecord4 var21 = var6 == null ? null : this.v4.v1(var6);
            int var22 = var21 == null ? -2181380 : var21.v12();
            sykyRecord5 var23 = var21 == null ? sykyRecord5.DEFAULT : var21.v19();
            InternalSupport36 var24 = var18.v1.v1(var5.v5());
            if (var24 != null) {
               visualSupport9.v1(var24, v1(var22, var23), var22, var23.v2(), 0.001, var2);
            }
         } else {
            InternalSupport5.Part1 var19 = this.v6.remove("\u0000draft");
            if (var19 != null) {
               var19.v1();
            }
         }
      } else {
         if (!this.v6.isEmpty()) {
            this.v6.values().forEach(InternalSupport5.Part1::v1);
            this.v6.clear();
         }
      }
   }

   private static InternalSupport35 v1(InternalSupport10 var0) {
      try {
         InternalSupport11 var1 = InternalSupport11.v1(var0);
         return InternalSupport35.v1(var1.v1(), var1.v2());
      } catch (Throwable var2) {
         v1.warn("could not build the mesh of a {}-block overlay", var0.v1(), var2);
         return InternalSupport35.v5;
      }
   }

   private static int v1(int var0, sykyRecord5 var1) {
      int var2 = Math.round((var0 >>> 24 & 0xFF) * var1.v1() / 100.0F);
      return var0 & 16777215 | var2 << 24;
   }

   public static double v1(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }

   public static final class Part1 {
      public final InternalSupport34<InternalSupport10> v1;
      public boolean v2;

      public Part1(Executor var1) {
         this.v1 = new InternalSupport34<>(var1, InternalSupport5::v1);
      }

      public void v1() {
         this.v1.v3();
      }
   }
}
