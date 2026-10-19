package cc.syky.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public final class NativeMethodSupport {
   public static final int v1 = 128;
   private static final int v2 = 8;
   private static final int v3 = 4;
   private static final int v4 = 4096;

   private NativeMethodSupport() {
   }

   public static JsonObject v1(Throwable var0) {
      return v1(var0, 0, Collections.newSetFromMap(new IdentityHashMap<>()));
   }

   private static JsonObject v1(Throwable var0, int var1, Set<Throwable> var2) {
      var2.add(var0);
      JsonObject var3 = new JsonObject();
      var3.addProperty("class", var0.getClass().getName());
      String var4 = v2(var0);
      if (var4 != null) {
         var3.addProperty("message", v1(var4, 4096));
      }

      var3.add("frames", v1(var0.getStackTrace()));
      if (var1 >= 8) {
         return var3;
      } else {
         Throwable var5 = var0.getCause();
         if (var5 != null && !var2.contains(var5)) {
            var3.add("cause", v1(var5, var1 + 1, var2));
         }

         Throwable[] var6 = var0.getSuppressed();
         if (var6.length > 0) {
            JsonArray var7 = new JsonArray();

            for (int var8 = 0; var8 < var6.length && var8 < 4; var8++) {
               if (!var2.contains(var6[var8])) {
                  var7.add(v1(var6[var8], var1 + 1, var2));
               }
            }

            if (!var7.isEmpty()) {
               var3.add("suppressed", var7);
            }
         }

         return var3;
      }
   }

   public static JsonObject v1(String var0, String var1, StackTraceElement[] var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty("class", var0);
      var3.addProperty("message", var1);
      var3.add("frames", v1(var2));
      return var3;
   }

   public static JsonArray v1(StackTraceElement[] var0) {
      JsonArray var1 = new JsonArray();

      for (int var2 = 0; var2 < var0.length && var2 < 128; var2++) {
         var1.add(v1(var0[var2]));
      }

      return var1;
   }

   public static String v1(StackTraceElement var0) {
      String var1;
      if (var0.isNativeMethod()) {
         var1 = "Native Method";
      } else if (var0.getFileName() == null) {
         var1 = "Unknown Source";
      } else if (var0.getLineNumber() >= 0) {
         var1 = var0.getFileName() + ":" + var0.getLineNumber();
      } else {
         var1 = var0.getFileName();
      }

      return var0.getClassName() + "." + var0.getMethodName() + "(" + var1 + ")";
   }

   public static String v1(Throwable var0, int var1) {
      StringBuilder var2 = new StringBuilder(var0.getClass().getName());
      StackTraceElement[] var3 = var0.getStackTrace();

      for (int var4 = 0; var4 < var3.length && var4 < var1; var4++) {
         var2.append('|').append(v1(var3[var4]));
      }

      return var2.toString();
   }

   @Nullable
   private static String v2(Throwable var0) {
      try {
         return var0.getMessage();
      } catch (Throwable var2) {
         return null;
      }
   }

   public static String v1(String var0, int var1) {
      return var0.length() <= var1 ? var0 : var0.substring(0, var1) + "…";
   }
}
