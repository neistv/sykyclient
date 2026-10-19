package cc.syky.ui;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Property;
import org.jetbrains.annotations.Nullable;

public final class uiSupport249 {
   private static final String v2 = "syky-crash-log";
   public static final String v1 = "syky.crash";
   private final HHMmSupport2 v3;
   private final uiSupport249.Part1 v4;
   private final ThreadLocal<Boolean> v5 = ThreadLocal.withInitial(() -> Boolean.FALSE);
   @Nullable
   private LoggerContext v6;
   @Nullable
   private Configuration v7;

   public uiSupport249(HHMmSupport2 var1, uiSupport249.Part1 var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   public synchronized void v1() {
      try {
         LoggerContext var1 = this.v6;
         if (var1 == null) {
            var1 = (LoggerContext)LogManager.getContext(uiSupport249.class.getClassLoader(), false);
            this.v6 = var1;
         }

         Configuration var2 = var1.getConfiguration();
         if (var2 == this.v7) {
            return;
         }

         AbstractAppender var3 = new AbstractAppender("syky-crash-log", null, null, true, Property.EMPTY_ARRAY) {
            public void append(LogEvent var1) {
               uiSupport249.this.v1(var1);
            }
         };
         var3.start();
         var2.addAppender(var3);
         var2.getRootLogger().addAppender(var3, Level.INFO, null);
         var1.updateLoggers();
         this.v7 = var2;
      } catch (Throwable var4) {
      }
   }

   public void v1(LogEvent var1) {
      if (!this.v5.get()) {
         this.v5.set(Boolean.TRUE);

         try {
            Level var2 = var1.getLevel();
            String var3 = var1.getLoggerName() == null ? "" : var1.getLoggerName();
            boolean var4 = var2.isMoreSpecificThan(Level.WARN);
            boolean var5 = var3.startsWith("syky.settings") || var3.startsWith("syky.profiles");
            if (!var4 && !var5) {
               return;
            }

            String var6 = var1.getMessage() == null ? "" : var1.getMessage().getFormattedMessage();
            Throwable var7 = var1.getThrown();
            String var8 = var1.getThreadName() == null ? "" : var1.getThreadName();
            if (var4) {
               this.v3.v1(HHMmSupport2.v1(var1.getTimeMillis(), var8, var2.name(), var3, var6, var7));
            }

            if (!(var7 instanceof OutOfMemoryError) || !var2.isMoreSpecificThan(Level.ERROR)) {
               if (!var3.startsWith("syky")) {
                  return;
               }

               if (var5 && (var4 || var6.startsWith("switched"))) {
                  this.v4.v1("config", var6);
               }

               if (var7 != null && var2.isMoreSpecificThan(Level.ERROR) && !var3.startsWith("syky.crash")) {
                  this.v4.v1("log", var7, var8);
               }

               return;
            }

            this.v4.v1(var7, var8);
         } catch (Throwable var12) {
            return;
         } finally {
            this.v5.set(Boolean.FALSE);
         }
      }
   }

   public interface Part1 {
      void v1(String var1, Throwable var2, String var3);

      void v1(String var1, String var2);

      void v1(Throwable var1, String var2);
   }
}
