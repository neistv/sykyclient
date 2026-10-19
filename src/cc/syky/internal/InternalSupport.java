package cc.syky.internal;

import cc.syky.sykyRecord;
import cc.syky.sykyRecord3;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport {
   private static final Logger v1 = LoggerFactory.getLogger("syky.whatsnew");
   private static final String v2 = "syky.whatsnew.force";
   private final Path v3;
   private boolean v4;
   @Nullable
   private sykyRecord v5;
   @Nullable
   private String v6;
   private boolean v7;

   public InternalSupport(Path var1) {
      this.v3 = var1;
   }

   @Nullable
   public sykyRecord v1() {
      if (!this.v4) {
         this.v4 = true;
         this.v5 = this.v3();
      }

      return this.v5;
   }

   public void v2() {
      this.v5 = null;
      String var1 = this.v6;
      if (var1 != null && this.v7) {
         this.v1(var1);
      }
   }

   public static InternalSupport.Part1 v1(sykyRecord3 var0, @Nullable String var1, String var2) {
      if (!var0.v2(var2)) {
         return InternalSupport.Part1.SILENT;
      } else if (var1 == null) {
         return InternalSupport.Part1.v1(var2);
      } else if (var1.equals(var2)) {
         return InternalSupport.Part1.SILENT;
      } else {
         List var3 = var0.v1(var1, var2);
         return var3.isEmpty() ? InternalSupport.Part1.v1(var2) : new InternalSupport.Part1(sykyRecord.v1(var3, var0.v3(var1), var0.v4()), null);
      }
   }

   @Nullable
   private sykyRecord v3() {
      String var1 = v5();
      if (var1 == null) {
         return null;
      } else {
         this.v6 = var1;
         sykyRecord3 var2 = InternalSupport3.v1();
         if (var2 == null) {
            return null;
         } else if (v4()) {
            v1.info("what's-new is forced; showing every entry and writing nothing");
            InternalSupport2.v1(var2.v1(), null);
            return sykyRecord.v1(var2.v2(), null, var2.v4());
         } else {
            this.v7 = true;
            String var3 = InternalSupport12.v1(this.v3).v7();
            this.v2(var2, var3, var1);
            InternalSupport.Part1 var4 = v1(var2, var3, var1);
            if (var4.v2() != null) {
               this.v1(var4.v2());
            }

            return var4.v1();
         }
      }
   }

   private void v2(sykyRecord3 var1, @Nullable String var2, String var3) {
      InternalSupport12 var4 = InternalSupport12.v1(this.v3);
      Set var5 = var4.v9();
      if (var1.v2(var3) && !var3.equals(var4.v10())) {
         var5.addAll(var1.v2(var2, var3));
         var4.v1(var5);
         var4.v3(var3);
         var4.v1();
      }

      InternalSupport2.v1(var5, this.v3);
   }

   private void v1(String var1) {
      InternalSupport12 var2 = InternalSupport12.v1(this.v3);
      var2.v1(var1);
      var2.v1();
   }

   private static boolean v4() {
      String var0 = System.getProperty("syky.whatsnew.force");
      return var0 != null ? Boolean.parseBoolean(var0) : FabricLoader.getInstance().isDevelopmentEnvironment();
   }

   @Nullable
   private static String v5() {
      return FabricLoader.getInstance().getModContainer("syky").map(var0 -> var0.getMetadata().getVersion().getFriendlyString()).orElse(null);
   }

   public record Part1(@Nullable sykyRecord content, @Nullable String stamp) {
      public static final InternalSupport.Part1 SILENT = new InternalSupport.Part1(null, null);

      public static InternalSupport.Part1 v1(String var0) {
         return new InternalSupport.Part1(null, var0);
      }

      @Nullable
      public sykyRecord v1() {
         return this.content;
      }

      @Nullable
      public String v2() {
         return this.stamp;
      }
   }
}
