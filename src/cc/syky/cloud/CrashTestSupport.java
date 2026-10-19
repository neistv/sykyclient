package cc.syky.cloud;

import cc.syky.internal.InternalSupport56;
import cc.syky.ui.uiSupport260;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_128;
import net.minecraft.class_310;

public final class CrashTestSupport implements cloudSupport82 {
   private static final String v1 = "crash test error|crash|hang";
   private static final List<String> v2 = List.of("error", "crash", "hang");
   private final cloudSupport101 v3;
   private final InternalSupport56 v4;

   public CrashTestSupport(cloudSupport101 var1, InternalSupport56 var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   @Override
   public String v1() {
      return "crash";
   }

   @Override
   public String v2() {
      return "crash test error|crash|hang — try crash reporting (development only)";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      String var3 = var2.size() == 2 && "test".equals(var2.get(0)) ? ((String)var2.get(1)).toLowerCase(Locale.ROOT) : "";
      switch (var3) {
         case "error":
            new uiSupport260("crash test").v1(() -> {
               throw new IllegalStateException("crash test");
            });
            var1.v1("An isolated error was reported.");
            break;
         case "crash":
            var1.v1("Crashing on the next tick.");
            this.v4.v1(() -> {
               class_310 var1x = this.v3.v1();
               if (var1x != null) {
                  var1x.method_1494(class_128.method_560(new IllegalStateException("crash test"), "Crash test"));
               }
            });
            break;
         case "hang":
            var1.v1("Freezing the main thread for 7 s.");
            this.v4.v1(() -> {
               try {
                  Thread.sleep(7000L);
               } catch (InterruptedException var1x) {
                  Thread.currentThread().interrupt();
               }
            });
            break;
         default:
            var1.v2("crash test error|crash|hang");
      }
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      if (var2 == 0) {
         return List.of("test");
      } else {
         return var2 == 1 ? v2 : List.of();
      }
   }
}
