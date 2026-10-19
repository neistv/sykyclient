package cc.syky.internal;

import cc.syky.cloud.cloudSupport63;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_2960;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Support642 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.render");
   private static final Set<class_2960> v2 = ConcurrentHashMap.newKeySet();

   private Support642() {
   }

   public static boolean v1(class_2960 var0) {
      if (!"syky".equals(var0.method_12836())) {
         return false;
      } else {
         if (v2.add(var0)) {
            v1.warn("the graphics driver did not compile {}; the effect drawn with it is off", var0);
            cloudSupport63.v1("shader compile", new IllegalStateException("pipeline " + var0 + " did not compile"));
         }

         return true;
      }
   }

   public static Set<class_2960> v1() {
      return Set.copyOf(v2);
   }
}
