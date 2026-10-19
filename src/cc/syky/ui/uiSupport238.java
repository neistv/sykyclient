package cc.syky.ui;

import com.sun.jna.platform.win32.COM.WbemcliUtil.WmiQuery;
import com.sun.jna.platform.win32.COM.WbemcliUtil.WmiResult;
import oshi.util.platform.windows.WmiQueryHandler;
import oshi.util.platform.windows.WmiUtil;

public final class uiSupport238 {
   private static final WmiQuery<uiSupport238.Part1> v1 = new WmiQuery("Win32_PerfFormattedData_GPUPerformanceCounters_GPUEngine", uiSupport238.Part1.class);

   private uiSupport238() {
   }

   public static int v1(WmiQueryHandler var0) {
      WmiResult var1 = var0.queryWMI(v1);
      long var2 = 0L;

      for (int var4 = 0; var4 < var1.getResultCount(); var4++) {
         String var5 = WmiUtil.getString(var1, uiSupport238.Part1.NAME, var4);
         if (var5 != null && var5.contains("engtype_3D")) {
            var2 += WmiUtil.getUint64(var1, uiSupport238.Part1.UTILIZATIONPERCENTAGE, var4);
         }
      }

      return (int)Math.min(100L, Math.max(0L, var2));
   }

   public static enum Part1 {
      NAME,
      UTILIZATIONPERCENTAGE;

      private Part1() {
      }
   }
}
