package cc.syky.cloud;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport68 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.compat");
   private static final String v2 = "syky";
   private static final String v3 = "Lorg/spongepowered/asm/mixin/Mixin;";
   private static final String v4 = "Lorg/spongepowered/asm/mixin/Overwrite;";
   private static final String v5 = "named:intermediary";
   private static final int v6 = 1000;

   private cloudSupport68() {
   }

   public static void v1() {
      Thread var0 = new Thread(() -> {
         try {
            v2();
         } catch (Throwable var1) {
            v1.warn("compatibility check failed — every feature still runs, only this summary is missing", var1);
         }
      }, "syky-compat");
      var0.setDaemon(true);
      var0.start();
   }

   private static void v2() {
      ArrayList var0 = new ArrayList();
      cloudSupport68.Part2 var1 = null;

      for (ModContainer var3 : FabricLoader.getInstance().getAllMods()) {
         cloudSupport68.Part2 var4 = v1(var3);
         if (var4 != null) {
            if ("syky".equals(var4.v1())) {
               var1 = var4;
            } else {
               var0.add(var4);
            }
         }
      }

      if (var1 != null && !var1.v3().isEmpty()) {
         TreeMap var17 = new TreeMap();
         TreeSet var18 = new TreeSet();
         int var19 = 0;
         int var5 = 0;

         for (cloudSupport68.Part2 var7 : var0) {
            boolean var8 = false;

            for (Entry var10 : var7.v3().entrySet()) {
               cloudSupport68.Part1 var11 = var1.v3().get(var10.getKey());
               if (var11 != null) {
                  cloudSupport68.Part1 var12 = (cloudSupport68.Part1)var10.getValue();
                  var8 = true;
                  var18.add((String)var10.getKey());
                  TreeSet var13 = new TreeSet<>(var12.v3());
                  var13.retainAll(var11.v3());
                  String var14 = v2((String)var10.getKey());
                  String var15 = "syky " + String.join(",", var11.v2()) + " + " + var7.v1() + " " + String.join(",", var12.v2());
                  if (var13.isEmpty()) {
                     var17.computeIfAbsent(var14, var0x -> new ArrayList<>()).add("  [i] " + var14 + " — " + var15 + ", no shared method");
                  } else {
                     var19 += var13.size();
                     String var16 = var7.v2() > var1.v2() ? ", and theirs applies last" : "";
                     var17.computeIfAbsent(var14, var0x -> new ArrayList<>())
                        .add(
                           "  [!] " + var14 + "#" + String.join("/", var13) + " — " + var15 + " (priority " + var7.v2() + " vs syky " + var1.v2() + ")" + var16
                        );
                  }
               }
            }

            if (var8) {
               var5++;
            }
         }

         if (var17.isEmpty()) {
            v1.info(
               "compatibility: {} other mod(s) with mixins, none touching any of the {} vanilla classes syky transforms — every feature should behave as it does on plain Fabric",
               var0.size(),
               var1.v3().size()
            );
         } else {
            v1.info(
               "compatibility: {} mod(s) share {} of the {} vanilla classes syky transforms, {} shared method(s). [!] lines are where a syky feature can misbehave.",
               new Object[]{var5, var18.size(), var1.v3().size(), var19}
            );

            for (List var21 : var17.values()) {
               for (String var23 : var21) {
                  v1.info("{}", var23);
               }
            }
         }
      } else {
         v1.warn("compatibility check: could not read syky's own mixins — nothing to compare against");
      }
   }

   @Nullable
   private static cloudSupport68.Part2 v1(ModContainer var0) {
      String var1 = var0.getMetadata().getId();
      JsonObject var2 = v1(var0, "fabric.mod.json");
      if (var2 == null) {
         return null;
      } else {
         JsonElement var3 = var2.get("mixins");
         if (var3 != null && var3.isJsonArray()) {
            HashMap var4 = new HashMap();
            int var5 = 1000;

            for (JsonElement var7 : var3.getAsJsonArray()) {
               String var8 = v1(var7);
               if (var8 != null) {
                  JsonObject var9 = v1(var0, var8);
                  if (var9 != null) {
                     JsonElement var10 = var9.get("priority");
                     if (var10 != null && var10.isJsonPrimitive()) {
                        var5 = var10.getAsInt();
                     }

                     String var11 = var9.has("package") ? var9.get("package").getAsString() : "";
                     JsonObject var12 = v1(var0, var9);

                     for (String var14 : v1(var9)) {
                        ClassNode var15 = v2(var0, var11.isEmpty() ? var14 : var11 + "." + var14);
                        if (var15 != null) {
                           Set var16 = v1(var15, v1(var12, var15.name));
                           if (!var16.isEmpty()) {
                              String var17 = v2(var15.name.replace('/', '.'));

                              for (String var19 : v1(var15)) {
                                 cloudSupport68.Part1 var20 = var4.computeIfAbsent(var19, var0x -> cloudSupport68.Part1.v1());
                                 var20.v2().add(var17);
                                 var20.v3().addAll(var16);
                              }
                           }
                        }
                     }
                  }
               }
            }

            return var4.isEmpty() ? null : new cloudSupport68.Part2(var1, var5, var4);
         } else {
            return null;
         }
      }
   }

   @Nullable
   private static String v1(JsonElement var0) {
      if (var0.isJsonPrimitive()) {
         return var0.getAsString();
      } else {
         if (var0.isJsonObject()) {
            JsonElement var1 = var0.getAsJsonObject().get("config");
            if (var1 != null && var1.isJsonPrimitive()) {
               return var1.getAsString();
            }
         }

         return null;
      }
   }

   private static List<String> v1(JsonObject var0) {
      ArrayList var1 = new ArrayList();

      for (String var5 : new String[]{"mixins", "client", "server"}) {
         JsonElement var6 = var0.get(var5);
         if (var6 != null && var6.isJsonArray()) {
            for (JsonElement var9 : var6.getAsJsonArray()) {
               if (var9.isJsonPrimitive()) {
                  var1.add(var9.getAsString());
               }
            }
         }
      }

      return var1;
   }

   @Nullable
   private static JsonObject v1(ModContainer var0, String var1) {
      Optional var2 = var0.findPath(var1);
      if (var2.isEmpty()) {
         return null;
      } else {
         try {
            JsonObject var5;
            try (BufferedReader var3 = Files.newBufferedReader((Path)var2.get())) {
               JsonElement var4 = JsonParser.parseReader(var3);
               var5 = var4.isJsonObject() ? var4.getAsJsonObject() : null;
            }

            return var5;
         } catch (RuntimeException | IOException var8) {
            v1.debug("could not read {} from {}", new Object[]{var1, var0.getMetadata().getId(), var8});
            return null;
         }
      }
   }

   @Nullable
   private static ClassNode v2(ModContainer var0, String var1) {
      Optional var2 = var0.findPath(var1.replace('.', '/') + ".class");
      if (var2.isEmpty()) {
         return null;
      } else {
         try {
            ClassNode var3 = new ClassNode();
            new ClassReader(Files.readAllBytes((Path)var2.get())).accept(var3, 3);
            return var3;
         } catch (RuntimeException | IOException var4) {
            v1.debug("could not parse {} from {}", new Object[]{var1, var0.getMetadata().getId(), var4});
            return null;
         }
      }
   }

   private static List<String> v1(ClassNode var0) {
      ArrayList var1 = new ArrayList();

      for (AnnotationNode var3 : v1(var0.visibleAnnotations, var0.invisibleAnnotations)) {
         if ("Lorg/spongepowered/asm/mixin/Mixin;".equals(var3.desc) && var3.values != null) {
            for (byte var4 = 0; var4 + 1 < var3.values.size(); var4 += 2) {
               Object var5 = var3.values.get(var4);
               Object var7 = var3.values.get(var4 + 1);
               if (var7 instanceof List) {
                  for (Object var8 : (List)var7) {
                     if ("value".equals(var5) && var8 instanceof Type var9) {
                        var1.add(var9.getClassName());
                     } else if ("targets".equals(var5) && var8 instanceof String var10) {
                        var1.add(var10.replace('/', '.'));
                     }
                  }
               }
            }
         }
      }

      return var1;
   }

   private static Set<String> v1(ClassNode var0, Map<String, String> var1) {
      TreeSet var2 = new TreeSet();
      if (var0.methods == null) {
         return var2;
      } else {
         for (MethodNode var4 : var0.methods) {
            for (AnnotationNode var6 : v1(var4.visibleAnnotations, var4.invisibleAnnotations)) {
               if ("Lorg/spongepowered/asm/mixin/Overwrite;".equals(var6.desc)) {
                  var2.add(v1(var1, var4.name));
               } else {
                  v1(var6, var2, var1);
               }
            }
         }

         return var2;
      }
   }

   private static List<AnnotationNode> v1(@Nullable List<AnnotationNode> var0, @Nullable List<AnnotationNode> var1) {
      if (var0 == null) {
         return var1 == null ? List.of() : var1;
      } else if (var1 == null) {
         return var0;
      } else {
         ArrayList var2 = new ArrayList(var0.size() + var1.size());
         var2.addAll(var0);
         var2.addAll(var1);
         return var2;
      }
   }

   private static void v1(AnnotationNode var0, Set<String> var1, Map<String, String> var2) {
      if (var0.values != null) {
         for (byte var3 = 0; var3 + 1 < var0.values.size(); var3 += 2) {
            if ("method".equals(var0.values.get(var3))) {
               Object var5 = var0.values.get(var3 + 1);
               if (var5 instanceof List) {
                  for (Object var6 : (List)var5) {
                     if (var6 instanceof String var7) {
                        String var8 = v1(var2, var7);
                        if (!var8.isEmpty()) {
                           var1.add(var8);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Nullable
   private static JsonObject v1(ModContainer var0, JsonObject var1) {
      JsonElement var2 = var1.get("refmap");
      if (var2 != null && var2.isJsonPrimitive()) {
         JsonObject var3 = v1(var0, var2.getAsString());
         if (var3 == null) {
            return null;
         } else {
            JsonElement var4 = var3.get("data");
            if (var4 != null && var4.isJsonObject()) {
               JsonElement var5 = var4.getAsJsonObject().get("named:intermediary");
               if (var5 != null && var5.isJsonObject()) {
                  return var5.getAsJsonObject();
               }
            }

            JsonElement var6 = var3.get("mappings");
            return var6 != null && var6.isJsonObject() ? var6.getAsJsonObject() : null;
         }
      } else {
         return null;
      }
   }

   private static Map<String, String> v1(@Nullable JsonObject var0, String var1) {
      if (var0 == null) {
         return Map.of();
      } else {
         JsonElement var2 = var0.get(var1);
         if (var2 != null && var2.isJsonObject()) {
            HashMap var3 = new HashMap();

            for (Entry var5 : var2.getAsJsonObject().entrySet()) {
               if (((JsonElement)var5.getValue()).isJsonPrimitive()) {
                  var3.put((String)var5.getKey(), ((JsonElement)var5.getValue()).getAsString());
               }
            }

            return var3;
         } else {
            return Map.of();
         }
      }
   }

   public static String v1(Map<String, String> var0, String var1) {
      String var2 = (String)var0.get(var1.trim());
      return v1(var2 != null ? var2 : var1);
   }

   public static String v1(String var0) {
      String var1 = var0.trim();
      int var2 = var1.indexOf(40);
      if (var2 >= 0) {
         var1 = var1.substring(0, var2);
      }

      int var3 = Math.max(var1.lastIndexOf(59), Math.max(var1.lastIndexOf(46), var1.lastIndexOf(47)));
      if (var3 >= 0) {
         var1 = var1.substring(var3 + 1);
      }

      return var1.trim();
   }

   private static String v2(String var0) {
      int var1 = var0.lastIndexOf(46);
      return var1 < 0 ? var0 : var0.substring(var1 + 1);
   }

   public record Part1(Set<String> mixins, Set<String> methods) {
      public static cloudSupport68.Part1 v1() {
         return new cloudSupport68.Part1(new TreeSet<>(), new TreeSet<>());
      }

      public Set<String> v2() {
         return this.mixins;
      }

      public Set<String> v3() {
         return this.methods;
      }
   }

   public record Part2(String modId, int priority, Map<String, cloudSupport68.Part1> byTarget) {
      public String v1() {
         return this.modId;
      }

      public int v2() {
         return this.priority;
      }

      public Map<String, cloudSupport68.Part1> v3() {
         return this.byTarget;
      }
   }
}
