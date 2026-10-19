package cc.syky.ui;

import java.lang.management.ManagementFactory;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport266 {
   private static final Logger v3 = LoggerFactory.getLogger("syky.account");
   public static final String v1 = "mojang";
   public static final String v2 = "elyby";
   @Nullable
   private static volatile String v4;
   @Nullable
   private static String v5;
   private static boolean v6;
   private static boolean v7;

   private uiSupport266() {
   }

   @Nullable
   public static String v1() {
      String var0 = v4;
      return var0 != null ? var0 : v2();
   }

   @Nullable
   public static synchronized String v2() {
      v4();
      return v5;
   }

   public static synchronized boolean v3() {
      v4();
      return v6;
   }

   public static void v1(@Nullable String var0) {
      v4 = var0;
   }

   private static void v4() {
      if (!v7) {
         String var0 = "mojang";
         boolean var1 = false;

         try {
            for (String var3 : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
               String var4 = var3.toLowerCase(Locale.ROOT);
               if (var4.startsWith("-javaagent:") && var4.contains("authlib-injector")) {
                  var1 = true;
                  var0 = var4.contains("ely.by") ? "elyby" : null;
                  break;
               }
            }
         } catch (LinkageError | RuntimeException var5) {
            v3.debug("could not read the JVM arguments; assuming the Mojang session server", var5);
         }

         v5 = var0;
         v6 = var1;
         v7 = true;
      }
   }
}
