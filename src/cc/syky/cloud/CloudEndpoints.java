package cc.syky.cloud;

import java.net.URI;
import java.time.Duration;

public final class CloudEndpoints {
   public static final String v1 = v3(System.getProperty("syky.cloud.url", "https://api.sykyclient.com"));
   public static final Duration v2 = Duration.ofSeconds(10L);
   public static final Duration v3 = Duration.ofSeconds(15L);
   public static final Duration v4 = Duration.ofSeconds(30L);
   public static final int v5 = 65536;
   public static final int v6 = 262144;
   public static final long v7 = 1000L;
   public static final long v8 = 60000L;
   public static final long v9 = 1000L;
   public static final long v10 = 14000L;
   public static final long v11 = 60000L;
   public static final long v12 = 1800000L;
   public static final long v13 = 500L;
   public static final int v14 = 256;
   public static final long v15 = 60000L;
   public static final long v16 = 15000L;
   public static final long v18 = 600000L;
   public static final int v19 = 128;
   public static final int v17 = 384;
   public static final long v20 = 1800000L;
   public static final long v21 = 600000L;
   public static final long v22 = 20000L;
   public static final long v24 = 300000L;
   public static final Duration v25 = Duration.ofMinutes(10L);

   private CloudEndpoints() {
   }

   public static URI v1(String var0, String var1) {
      return URI.create(var0 + var1);
   }

   public static String v1(String var0) {
      URI var1 = URI.create(var0);
      String var2 = var1.getHost();
      return var2 != null && var2.startsWith("api.")
         ? var1.getScheme() + "://" + var2.substring("api.".length()) + (var1.getPort() < 0 ? "" : ":" + var1.getPort())
         : var0;
   }

   public static URI v2(String var0) {
      String var1 = var0.substring(var0.indexOf("://") + 3);
      return URI.create((var0.startsWith("https://") ? "wss://" : "ws://") + var1 + "/v1/gateway");
   }

   private static String v3(String var0) {
      return var0.endsWith("/") ? var0.substring(0, var0.length() - 1) : var0;
   }
}
