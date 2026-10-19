package cc.syky.ui;

import com.sun.management.GarbageCollectionNotificationInfo;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Locale;
import java.util.function.BiConsumer;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;

public final class uiSupport250 {
   public static final long v1 = 200L;

   private uiSupport250() {
   }

   public static void v1(BiConsumer<String, String> var0) {
      NotificationListener var1 = (var1x, var2) -> {
         try {
            if (!"com.sun.management.gc.notification".equals(var1x.getType())) {
               return;
            }

            GarbageCollectionNotificationInfo var3x = GarbageCollectionNotificationInfo.from((CompositeData)var1x.getUserData());
            String var4x = var3x.getGcName();
            String var5x = var4x.toLowerCase(Locale.ROOT);
            if (var5x.contains("cycles") || var5x.contains("concurrent")) {
               return;
            }

            long var6 = var3x.getGcInfo().getDuration();
            if (var6 >= 200L) {
               var0.accept("gc", var4x + " " + var3x.getGcAction() + " " + var6 + " ms");
            }
         } catch (Throwable var8) {
         }
      };

      try {
         for (GarbageCollectorMXBean var3 : ManagementFactory.getGarbageCollectorMXBeans()) {
            if (var3 instanceof NotificationEmitter var4) {
               var4.addNotificationListener(var1, null, null);
            }
         }
      } catch (Throwable var5) {
      }
   }
}
