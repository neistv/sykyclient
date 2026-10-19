package cc.syky.cloud;

import cc.syky.ui.uiSupport258;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport80 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.commands");
   private final Map<String, cloudSupport82> v2 = new LinkedHashMap<>();
   private final Map<String, String> v3 = new HashMap<>();
   private final uiSupport258 v4;

   public cloudSupport80() {
      this(uiSupport258.v1);
   }

   public cloudSupport80(uiSupport258 var1) {
      this.v4 = var1;
   }

   public <C extends cloudSupport82> C v1(C var1) {
      String var2 = var1.v1().toLowerCase(Locale.ROOT);
      if (this.v2.putIfAbsent(var2, var1) != null) {
         throw new IllegalStateException("duplicate command: " + var1.v1());
      } else {
         this.v3.put(var2, "commands.dispatch." + var2);
         return (C)var1;
      }
   }

   public Collection<cloudSupport82> v1() {
      return Collections.unmodifiableCollection(this.v2.values());
   }

   @Nullable
   public cloudSupport82 v1(String var1) {
      return var1 == null ? null : this.v2.get(var1.toLowerCase(Locale.ROOT));
   }

   public void v1(String var1, cloudSupport81 var2) {
      long var3 = this.v4.v3();

      try {
         List var5 = v2(var1);
         if (!var5.isEmpty()) {
            String var33 = ((String)var5.get(0)).toLowerCase(Locale.ROOT);
            cloudSupport82 var34 = this.v2.get(var33);
            if (var34 != null) {
               long var8 = this.v4.v3();

               try {
                  try {
                     var34.v1(var2, var5.subList(1, var5.size()));
                  } catch (Throwable var30) {
                     v1.error("command {} failed", var33, var30);
                     var2.v2("command failed: " + var33);
                  }

                  return;
               } finally {
                  this.v4.v1(this.v3.get(var33), var8);
               }
            }

            var2.v2("unknown command: " + var33);
            return;
         }

         cloudSupport82 var6 = this.v2.get("help");
         if (var6 != null) {
            long var7 = this.v4.v3();

            try {
               var6.v1(var2, List.of());
            } catch (Throwable var28) {
               v1.error("command help failed", var28);
               var2.v2("command failed: help");
            } finally {
               this.v4.v1(this.v3.get("help"), var7);
            }
         } else {
            var2.v1("syky");
         }
      } finally {
         this.v4.v1("commands.dispatch", var3);
      }
   }

   public static List<String> v2(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String[] var1 = var0.strip().split("\\s+");
         return List.of(var1);
      } else {
         return List.of();
      }
   }
}
