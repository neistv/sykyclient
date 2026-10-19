package cc.syky.ui;

import cc.syky.cloud.cloudRecord8;
import cc.syky.cloud.cloudSupport55;
import net.minecraft.class_1011;
import org.jetbrains.annotations.Nullable;

public final class uiSupport156 implements AutoCloseable {
   private final Object v1 = new Object();
   private final int[] v2 = new int[35937];
   private final int[] v3 = new int[35937];
   @Nullable
   private cloudRecord8 v4;
   @Nullable
   private cloudRecord8 v5;
   @Nullable
   private cloudRecord8 v6;
   private boolean v7;
   private final Thread v8 = new Thread(this::v2, "syky-grade-bake");

   public uiSupport156() {
      this.v8.setDaemon(true);
      this.v8.start();
   }

   public void v1(cloudRecord8 var1) {
      synchronized (this.v1) {
         if (!var1.equals(this.v4)) {
            this.v4 = var1;
            this.v5 = var1;
            this.v1.notifyAll();
         }
      }
   }

   public void v1() {
      synchronized (this.v1) {
         this.v4 = null;
         this.v6 = null;
      }
   }

   @Nullable
   public cloudRecord8 v1(class_1011 var1) {
      synchronized (this.v1) {
         cloudRecord8 var3 = this.v6;
         if (var3 == null) {
            return null;
         } else {
            this.v6 = null;
            int var4 = 0;

            for (int var5 = 0; var4 < 33; var4++) {
               for (int var6 = 0; var6 < 1089; var5++) {
                  var1.method_61941(var6, var4, this.v3[var5]);
                  var6++;
               }
            }

            return var3;
         }
      }
   }

   private void v2() {
      while (true) {
         cloudRecord8 var1;
         synchronized (this.v1) {
            while (this.v5 == null && !this.v7) {
               try {
                  this.v1.wait();
               } catch (InterruptedException var7) {
                  Thread.currentThread().interrupt();
                  return;
               }
            }

            cloudRecord8 var3 = this.v5;
            if (this.v7 || var3 == null) {
               return;
            }

            var1 = var3;
            this.v5 = null;
         }

         cloudSupport55.v1(var1, this.v2);
         synchronized (this.v1) {
            if (this.v7) {
               return;
            }

            System.arraycopy(this.v2, 0, this.v3, 0, 35937);
            this.v6 = var1;
         }
      }
   }

   @Override
   public void close() {
      synchronized (this.v1) {
         this.v7 = true;
         this.v5 = null;
         this.v1.notifyAll();
      }
   }
}
