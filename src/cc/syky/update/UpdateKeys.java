package cc.syky.update;

import java.time.Duration;
import java.util.List;

public final class UpdateKeys {
   public static final String v1 = "syky";
   public static final List<String> v2 = List.of(
      "https://updates.sykyclient.com/manifest.json",
      "https://github.com/cloh1r/syky_client_dist/releases/latest/download/manifest.json",
      "https://mirror.sykyclient.com/manifest.json"
   );
   public static final List<String> v3 = List.of(
      "MCowBQYDK2VwAyEA2RsJyWN06TAJAr39/IPsxB4C2+13uCFS2fskdzkbF38=", "MCowBQYDK2VwAyEAAHlq/LJ2MLwhb6Ckgmeynm/g8JQb8gYQthRpU5t59n0="
   );
   public static final long v4 = 67108864L;
   public static final long v5 = 524288L;
   public static final Duration v6 = Duration.ofSeconds(6L);
   public static final Duration v7 = Duration.ofSeconds(10L);
   public static final Duration v8 = Duration.ofMinutes(5L);
   public static final int v9 = 5;
   public static final Duration v10 = Duration.ofDays(14L);

   private UpdateKeys() {
   }
}
