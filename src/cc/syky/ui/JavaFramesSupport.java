package cc.syky.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public final class JavaFramesSupport {
   public static final int v1 = 16384;
   private static final int v2 = 64;
   private static final Pattern v3 = Pattern.compile("^Current thread \\([^)]*\\):\\s+(\\w+)\\s+(\"[^\"]*\")");
   private static final Pattern v4 = Pattern.compile(",\\s*pid=\\d+,\\s*tid=\\d+\\s*$");

   private JavaFramesSupport() {
   }

   public static boolean v1(String var0) {
      for (String var2 : var0.lines().toList()) {
         if (var2.startsWith("java_command:") || var2.startsWith("Command Line:")) {
            String var3 = var2.toLowerCase(Locale.ROOT);
            if (var3.contains("knotclient") || var3.contains("net.minecraft.client.main.main") || var3.contains("minecraft")) {
               return true;
            }
         }
      }

      return false;
   }

   @Nullable
   public static JsonObject v2(String var0) {
      List var1 = var0.lines().toList();
      if (!var1.isEmpty() && ((String)var1.get(0)).startsWith("#")) {
         StringBuilder var2 = new StringBuilder();
         String var3 = null;
         String var4 = null;
         boolean var5 = false;

         int var6;
         for (var6 = 0; var6 < var1.size() && ((String)var1.get(var6)).startsWith("#"); var6++) {
            String var7 = ((String)var1.get(var6)).substring(1).strip();
            v1(var2, (String)var1.get(var6));
            if (!var7.isEmpty()) {
               if (var5) {
                  var4 = var7;
                  var5 = false;
               } else if (var7.startsWith("Problematic frame:")) {
                  var5 = true;
               } else if (var3 == null && !var7.startsWith("A fatal error has been detected")) {
                  var3 = v4.matcher(var7).replaceFirst("");
               }
            }
         }

         String var14 = null;
         JsonArray var8 = new JsonArray();
         JsonArray var9 = new JsonArray();
         String var10 = "";

         for (JsonArray var11 = null; var6 < var1.size(); var6++) {
            String var12 = (String)var1.get(var6);
            if (var12.startsWith("---------------")) {
               var10 = var12;
               var11 = null;
               if (var12.contains("P R O C E S S")) {
                  break;
               }

               if (var12.contains("S U M M A R Y")) {
                  v1(var2, "");
                  v1(var2, var12);
               }
            } else if (var10.contains("S U M M A R Y")) {
               if (!var12.startsWith("Command Line:")) {
                  v1(var2, var12);
               }
            } else if (var10.contains("T H R E A D")) {
               if (var11 != null) {
                  if (var12.isBlank()) {
                     var11 = null;
                  } else if (var11.size() < 64) {
                     var11.add(var12.strip());
                  }
               } else {
                  Matcher var13 = v3.matcher(var12);
                  if (var14 == null && var13.find()) {
                     var14 = var13.group(2) + " " + var13.group(1);
                  } else if (var12.startsWith("Native frames:")) {
                     var11 = var8;
                  } else if (var12.startsWith("Java frames:")) {
                     var11 = var9;
                  }
               }
            }
         }

         JsonObject var15 = new JsonObject();
         if (var3 != null) {
            var15.addProperty("error", var3);
         }

         if (var4 != null) {
            var15.addProperty("problematic_frame", var4);
         }

         if (var14 != null) {
            var15.addProperty("thread", var14);
         }

         var15.add("native_frames", var8);
         var15.add("java_frames", var9);
         var15.addProperty("summary", NativeMethodSupport.v1(var2.toString().strip(), 16384));
         return var15;
      } else {
         return null;
      }
   }

   private static void v1(StringBuilder var0, String var1) {
      if (var0.length() <= 16384) {
         var0.append(var1).append('\n');
      }
   }
}
