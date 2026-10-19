package cc.syky.ui;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.Nullable;

public final class uiSupport252 {
   public static final String v1 = "boot";
   public static final String v2 = "menu";
   public static final String v3 = "world";
   public static final String v4 = "shutdown";
   public static final int v5 = 256;
   public volatile String v6 = "boot";
   @Nullable
   public volatile String v7;
   public volatile String v8 = "none";
   @Nullable
   public volatile String v9;
   public volatile int v10;
   @Nullable
   public volatile String v11;
   @Nullable
   public volatile String v12;
   @Nullable
   public volatile String v13;
   public volatile String v14 = "";
   public volatile boolean v15;
   public final Set<String> v16 = ConcurrentHashMap.newKeySet();
   public final Set<String> v18 = ConcurrentHashMap.newKeySet();
   private final AtomicInteger v19 = new AtomicInteger();

   public uiSupport252() {
   }

   public void v1(@Nullable String var1) {
      this.v1(this.v16, var1);
   }

   public void v2(@Nullable String var1) {
      this.v1(this.v18, var1);
   }

   public int v1() {
      return this.v19.get();
   }

   private void v1(Set<String> var1, @Nullable String var2) {
      if (var2 != null && !var2.isBlank() && var1.size() < 256 && var1.add(var2.strip())) {
         this.v19.incrementAndGet();
      }
   }
}
