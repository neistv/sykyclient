package cc.syky.cloud;

import cc.syky.internal.InternalSupport62;
import cc.syky.ui.uiRecord12;
import cc.syky.ui.uiRecord13;
import cc.syky.ui.uiSupport255;
import cc.syky.ui.uiSupport256;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Vector3f;

public final class cloudSupport39 {
   private static final float v1 = 0.0625F;
   private static final float v2 = (float) (Math.PI / 180.0);
   public static final String[] v3 = new String[]{"north", "south", "east", "west", "up", "down"};
   public static final float[][][] v4 = new float[][][]{
      {{1.0F, 0.0F, 0.0F}, {0.0F, 0.0F, 0.0F}, {0.0F, 1.0F, 0.0F}, {1.0F, 1.0F, 0.0F}, {0.0F, 0.0F, -1.0F}},
      {{0.0F, 0.0F, 1.0F}, {1.0F, 0.0F, 1.0F}, {1.0F, 1.0F, 1.0F}, {0.0F, 1.0F, 1.0F}, {0.0F, 0.0F, 1.0F}},
      {{1.0F, 0.0F, 1.0F}, {1.0F, 0.0F, 0.0F}, {1.0F, 1.0F, 0.0F}, {1.0F, 1.0F, 1.0F}, {1.0F, 0.0F, 0.0F}},
      {{0.0F, 0.0F, 0.0F}, {0.0F, 0.0F, 1.0F}, {0.0F, 1.0F, 1.0F}, {0.0F, 1.0F, 0.0F}, {-1.0F, 0.0F, 0.0F}},
      {{0.0F, 1.0F, 1.0F}, {1.0F, 1.0F, 1.0F}, {1.0F, 1.0F, 0.0F}, {0.0F, 1.0F, 0.0F}, {0.0F, 1.0F, 0.0F}},
      {{0.0F, 0.0F, 0.0F}, {1.0F, 0.0F, 0.0F}, {1.0F, 0.0F, 1.0F}, {0.0F, 0.0F, 1.0F}, {0.0F, -1.0F, 0.0F}}
   };
   public static final float[][] v5 = new float[][]{{0.0F, 1.0F}, {1.0F, 1.0F}, {1.0F, 0.0F}, {0.0F, 0.0F}};

   private cloudSupport39() {
   }

   public static cloudSupport50 v1(cloudSupport39.Part1 var0) throws cloudSupport38 {
      try {
         return new cloudSupport39.Part2(var0).v1();
      } catch (cloudSupport38 var2) {
         throw var2;
      } catch (RuntimeException | IOException var3) {
         throw new cloudSupport38(var3.getMessage() == null ? var3.toString() : var3.getMessage(), var3);
      }
   }

   public static JsonObject v2(byte[] var0) throws cloudSupport38 {
      try {
         return JsonParser.parseString(new String(var0, StandardCharsets.UTF_8)).getAsJsonObject();
      } catch (RuntimeException var2) {
         throw new cloudSupport38("not a JSON object", var2);
      }
   }

   public static JsonObject v1(JsonObject var0, String var1) {
      return var0.has(var1) && var0.get(var1).isJsonObject() ? var0.getAsJsonObject(var1) : new JsonObject();
   }

   public static String v1(JsonObject var0, String var1, @Nullable String var2) throws cloudSupport38 {
      if (var0.has(var1) && !var0.get(var1).isJsonNull()) {
         return var0.get(var1).getAsString();
      } else if (var2 == null) {
         throw new cloudSupport38("missing \"" + var1 + "\"");
      } else {
         return var2;
      }
   }

   public static float v1(JsonObject var0, String var1, float var2) {
      return var0.has(var1) && !var0.get(var1).isJsonNull() ? var0.get(var1).getAsFloat() : var2;
   }

   public static int v1(JsonObject var0, String var1, int var2) {
      return var0.has(var1) && !var0.get(var1).isJsonNull() ? var0.get(var1).getAsInt() : var2;
   }

   public static boolean v1(JsonObject var0, String var1, boolean var2) {
      boolean var3 = var0.has(var1) && var0.get(var1).isJsonPrimitive() && var0.get(var1).getAsJsonPrimitive().isBoolean();
      return var3 ? var0.get(var1).getAsBoolean() : var2;
   }

   public static float[] v2(JsonObject var0, String var1) {
      return var0.has(var1) ? v1(var0.getAsJsonArray(var1)) : new float[3];
   }

   public static float[] v1(JsonArray var0) {
      return new float[]{var0.get(0).getAsFloat(), var0.get(1).getAsFloat(), var0.get(2).getAsFloat()};
   }

   public static float[] v2(JsonArray var0) {
      return new float[]{var0.get(0).getAsFloat(), var0.get(1).getAsFloat()};
   }

   public static float[] v3(JsonArray var0) {
      return new float[]{var0.get(0).getAsFloat(), var0.get(1).getAsFloat(), var0.get(2).getAsFloat(), var0.get(3).getAsFloat()};
   }

   public static int[] v4(JsonArray var0) {
      int[] var1 = new int[var0.size()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = var0.get(var2).getAsInt();
      }

      return var1;
   }

   public static float[] v1(List<float[]> var0) {
      float[] var1 = new float[var0.size() * 3];

      for (int var2 = 0; var2 < var0.size(); var2++) {
         System.arraycopy(var0.get(var2), 0, var1, var2 * 3, 3);
      }

      return var1;
   }

   public static String v2(String var0) {
      return var0.toLowerCase(Locale.ROOT).endsWith(".png") ? var0.substring(0, var0.length() - 4) : var0;
   }

   public static int v1(String var0) throws cloudSupport38 {
      String var1 = var0.startsWith("#") ? var0.substring(1) : var0;

      try {
         if (var1.length() == 6) {
            return 0xFF000000 | Integer.parseUnsignedInt(var1, 16);
         }

         if (var1.length() == 8) {
            return (int)Long.parseLong(var1, 16);
         }
      } catch (NumberFormatException var3) {
      }

      throw new cloudSupport38("colour \"" + var0 + "\"");
   }

   public static int[] v1(byte[] var0) throws cloudSupport38 {
      if (var0.length >= 24
         && (var0[0] & 255) == 137
         && var0[1] == 80
         && var0[2] == 78
         && var0[3] == 71
         && var0[12] == 73
         && var0[13] == 72
         && var0[14] == 68
         && var0[15] == 82) {
         int var1 = (var0[16] & 255) << 24 | (var0[17] & 255) << 16 | (var0[18] & 255) << 8 | var0[19] & 255;
         int var2 = (var0[20] & 255) << 24 | (var0[21] & 255) << 16 | (var0[22] & 255) << 8 | var0[23] & 255;
         return new int[]{var1, var2};
      } else {
         throw new cloudSupport38("not a PNG");
      }
   }

   @FunctionalInterface
   public interface Part1 {
      byte[] read(String var1) throws IOException;
   }

   public static final class Part2 {
      private final cloudSupport39.Part1 v1;
      private final List<InternalSupport62> v2 = new ArrayList<>();
      private final Map<String, Integer> v3 = new HashMap<>();
      private final Map<String, JsonObject> v4 = new LinkedHashMap<>();
      private final List<uiRecord12> v5 = new ArrayList<>();
      private final Map<String, Integer> v6 = new HashMap<>();
      private final List<String> v7 = new ArrayList<>();
      private final List<Integer> v8 = new ArrayList<>();
      private final List<cloudSupport51> v9 = new ArrayList<>();
      private final List<float[]> v10 = new ArrayList<>();
      private final List<float[]> v11 = new ArrayList<>();
      private final Map<String, Integer> v12 = new HashMap<>();
      private final Map<Long, List<float[]>> v13 = new TreeMap<>();
      private final Map<Integer, float[]> v14 = new HashMap<>();
      private final Map<Integer, Integer> v15 = new HashMap<>();
      @Nullable
      private String v16;
      private cloudSupport49 v18 = cloudSupport49.HAT;
      private int v19 = -1;

      public Part2(cloudSupport39.Part1 var1) {
         this.v1 = var1;
      }

      public cloudSupport50 v1() throws IOException {
         JsonObject var1 = cloudSupport39.v2(this.v1.read("cosmetic.json"));
         String var2 = cloudSupport39.v1(var1, "id", null);
         String var3 = cloudSupport39.v1(var1, "slot", null);
         cloudSupport49 var4 = cloudSupport49.v1(var3);
         if (var4 == null) {
            throw new cloudSupport38("unknown slot " + var3);
         } else {
            this.v18 = var4;
            JsonObject var5 = cloudSupport39.v1(var1, "textures");

            for (Entry var7 : var5.entrySet()) {
               JsonObject var8 = ((JsonElement)var7.getValue()).getAsJsonObject();
               byte[] var9 = this.v1.read(cloudSupport39.v1(var8, "file", null));
               this.v1(
                  (String)var7.getKey(),
                  var9,
                  cloudSupport39.v1(var8, "frames", 1),
                  cloudSupport39.v1(var8, "frameSeconds", 0.1F),
                  cloudSupport39.v1(var8, "smooth", false)
               );
            }

            JsonObject var11 = cloudSupport39.v1(var1, "materials");

            for (Entry var14 : var11.entrySet()) {
               this.v4.put((String)var14.getKey(), ((JsonElement)var14.getValue()).getAsJsonObject());
               if (this.v16 == null) {
                  this.v16 = (String)var14.getKey();
               }
            }

            if (var1.has("defaultMaterial")) {
               this.v16 = cloudSupport39.v1(var1, "defaultMaterial", null);
            }

            if (this.v4.isEmpty()) {
               throw new cloudSupport38("the manifest defines no materials");
            } else {
               ArrayList var13 = new ArrayList();
               int[] var15 = new int[cloudSupport44.v3()];
               Arrays.fill(var15, -1);
               if (var1.has("model")) {
                  JsonObject var16 = cloudSupport39.v2(this.v1.read(cloudSupport39.v1(var1, "model", null)));
                  this.v1(var16, cloudSupport39.v1(var1, "groups"));
                  this.v1(var16, cloudSupport39.v1(var1, "animations"), var13, var15);
               }

               cloudSupport50.Part1 var17 = null;
               if (var1.has("cape")) {
                  var17 = this.v2(var1.getAsJsonObject("cape"));
               }

               uiSupport255 var10 = this.v7.isEmpty()
                  ? uiSupport255.v1(this.v18.v2())
                  : new uiSupport255(
                     this.v7.toArray(String[]::new),
                     this.v8.stream().mapToInt(Integer::intValue).toArray(),
                     this.v9.toArray(cloudSupport51[]::new),
                     cloudSupport39.v1(this.v10),
                     cloudSupport39.v1(this.v11)
                  );
               return new cloudSupport50(
                  var2,
                  this.v18,
                  var10,
                  this.v3(),
                  this.v5.toArray(uiRecord12[]::new),
                  this.v2.toArray(InternalSupport62[]::new),
                  var17,
                  var13.toArray(cloudSupport45[]::new),
                  var15
               );
            }
         }
      }

      private int v1(String var1, byte[] var2, int var3, float var4, boolean var5) throws cloudSupport38 {
         int[] var6 = cloudSupport39.v1(var2);
         this.v2.add(new InternalSupport62(var6[0], var6[1], var2, var3, var4, var5));
         int var7 = this.v2.size() - 1;
         this.v3.put(var1, var7);
         return var7;
      }

      private int v1(String var1, int var2) throws cloudSupport38 {
         JsonObject var3 = this.v4.get(var1);
         if (var3 == null) {
            throw new cloudSupport38("no material called " + var1);
         } else {
            int var4;
            if (var3.has("texture") && !var3.get("texture").isJsonNull()) {
               String var5 = var3.get("texture").getAsString();
               Integer var6 = this.v3.get(var5);
               if (var6 == null) {
                  throw new cloudSupport38("material " + var1 + " reads missing texture " + var5);
               }

               var4 = var6;
            } else {
               var4 = var2;
            }

            String var13 = var1 + "#" + var4;
            Integer var14 = this.v6.get(var13);
            if (var14 != null) {
               return var14;
            } else {
               cloudSupport36 var7 = cloudSupport36.v1(cloudSupport39.v1(var3, "surface", "cutout"));
               if (var7 == null) {
                  throw new cloudSupport38("material " + var1 + " has an unknown surface");
               } else {
                  uiRecord13 var8 = null;
                  if (var3.has("fx")) {
                     JsonObject var9 = var3.getAsJsonObject("fx");
                     cloudSupport37 var10 = cloudSupport37.v1(cloudSupport39.v1(var9, "type", null));
                     if (var10 == null) {
                        throw new cloudSupport38("material " + var1 + " has an unknown effect");
                     }

                     var8 = new uiRecord13(
                        var10,
                        cloudSupport39.v1(cloudSupport39.v1(var9, "color", "#ffffff")),
                        cloudSupport39.v1(cloudSupport39.v1(var9, "secondary", "#ffffff")),
                        cloudSupport39.v1(var9, "intensity", 1.0F),
                        cloudSupport39.v1(var9, "speed", 1.0F),
                        cloudSupport39.v1(var9, "scale", 1.0F)
                     );
                  }

                  int var15 = var3.has("tint") ? cloudSupport39.v1(var3.get("tint").getAsString()) : -1;
                  int var16 = -1;
                  if (var3.has("fxTexture")) {
                     String var11 = var3.get("fxTexture").getAsString();
                     Integer var12 = this.v3.get(var11);
                     if (var12 == null) {
                        throw new cloudSupport38("material " + var1 + " reads missing texture " + var11);
                     }

                     var16 = var12;
                  }

                  this.v5.add(new uiRecord12(var4, var7, var8, var15, var16));
                  this.v6.put(var13, this.v5.size() - 1);
                  return this.v5.size() - 1;
               }
            }
         }
      }

      private void v1(JsonObject var1, JsonObject var2) throws IOException {
         float var3 = 16.0F;
         float var4 = 16.0F;
         if (var1.has("resolution")) {
            JsonObject var5 = var1.getAsJsonObject("resolution");
            var3 = cloudSupport39.v1(var5, "width", 16.0F);
            var4 = cloudSupport39.v1(var5, "height", 16.0F);
         }

         JsonArray var13 = var1.has("textures") ? var1.getAsJsonArray("textures") : new JsonArray();

         for (int var6 = 0; var6 < var13.size(); var6++) {
            JsonObject var7 = var13.get(var6).getAsJsonObject();
            String var8 = cloudSupport39.v1(var7, "source", "");
            int var9 = var8.indexOf(44);
            if (!var8.startsWith("data:image/png;base64,") || var9 < 0) {
               throw new cloudSupport38("model texture " + var6 + " is not an embedded PNG");
            }

            byte[] var10 = Base64.getDecoder().decode(var8.substring(var9 + 1));
            String var11 = cloudSupport39.v2(cloudSupport39.v1(var7, "name", "texture" + var6));
            Integer var12 = this.v3.get(var11);
            this.v15.put(var6, var12 != null ? var12 : this.v1(var11, var10, 1, 0.1F, false));
            this.v14.put(var6, new float[]{cloudSupport39.v1(var7, "uv_width", var3), cloudSupport39.v1(var7, "uv_height", var4)});
         }

         HashMap var14 = new HashMap();
         if (var1.has("elements")) {
            for (JsonElement var17 : var1.getAsJsonArray("elements")) {
               JsonObject var20 = var17.getAsJsonObject();
               var14.put(cloudSupport39.v1(var20, "uuid", ""), var20);
            }
         }

         HashMap var16 = new HashMap();
         if (var1.has("groups")) {
            for (JsonElement var21 : var1.getAsJsonArray("groups")) {
               JsonObject var23 = var21.getAsJsonObject();
               var16.put(cloudSupport39.v1(var23, "uuid", ""), var23);
            }
         }

         if (var1.has("outliner")) {
            for (JsonElement var22 : var1.getAsJsonArray("outliner")) {
               this.v1(var22, -1, null, null, var14, var16, var2);
            }
         }
      }

      private void v1(
         JsonElement var1,
         int var2,
         @Nullable cloudSupport51 var3,
         @Nullable String var4,
         Map<String, JsonObject> var5,
         Map<String, JsonObject> var6,
         JsonObject var7
      ) throws IOException {
         if (var1.isJsonPrimitive()) {
            JsonObject var20 = (JsonObject)var5.get(var1.getAsString());
            if (var20 != null && cloudSupport39.v1(var20, "visibility", true)) {
               int var21 = var2;
               if (var2 < 0) {
                  if (this.v19 < 0) {
                     this.v19 = this.v1("root", -1, this.v18.v2(), new float[3], new float[3], null);
                  }

                  var21 = this.v19;
               }

               this.v1(var20, var21, var4 != null ? var4 : this.v2());
            }
         } else {
            JsonObject var8 = var1.getAsJsonObject();
            String var9 = cloudSupport39.v1(var8, "uuid", "");
            JsonObject var10 = var8.has("name") ? var8 : var6.getOrDefault(var9, var8);
            if (cloudSupport39.v1(var10, "visibility", true)) {
               String var11 = cloudSupport39.v1(var10, "name", "group");
               JsonObject var12 = var7.has(var11) ? var7.getAsJsonObject(var11) : new JsonObject();
               cloudSupport51 var13 = var3;
               if (var3 == null) {
                  String var14 = var12.has("anchor") ? var12.get("anchor").getAsString() : var11;
                  cloudSupport51 var15 = cloudSupport51.v1(var14);
                  if (var12.has("anchor") && var15 == null) {
                     throw new cloudSupport38("group " + var11 + " names unknown anchor " + var14);
                  }

                  var13 = var15 != null ? var15 : this.v18.v2();
               }

               String var22 = var12.has("material") ? var12.get("material").getAsString() : var4;
               float[] var23 = cloudSupport39.v2(var10, "origin");
               float[] var16 = cloudSupport39.v2(var10, "rotation");
               int var17 = this.v1(var11, var2, var13, v1(var23, var13), v1(var16), var9);
               if (var8.has("children")) {
                  for (JsonElement var19 : var8.getAsJsonArray("children")) {
                     this.v1(var19, var17, var13, var22, var5, var6, var7);
                  }
               }
            }
         }
      }

      private String v2() {
         return this.v16 == null ? this.v4.keySet().iterator().next() : this.v16;
      }

      private int v1(String var1, int var2, cloudSupport51 var3, float[] var4, float[] var5, @Nullable String var6) throws cloudSupport38 {
         if (this.v7.size() >= 128) {
            throw new cloudSupport38("more than 128 groups");
         } else {
            this.v7.add(var1);
            this.v8.add(var2);
            this.v9.add(var3);
            this.v10.add(var4);
            this.v11.add(var5);
            int var7 = this.v7.size() - 1;
            if (var6 != null) {
               this.v12.put(var6, var7);
            }

            return var7;
         }
      }

      private void v1(JsonObject var1, int var2, String var3) throws IOException {
         String var4 = cloudSupport39.v1(var1, "type", "cube");
         float[] var5 = cloudSupport39.v2(var1, "origin");
         float[] var6 = cloudSupport39.v2(var1, "rotation");
         Matrix3f var7 = new Matrix3f()
            .rotateZYX(var6[2] * (float) (Math.PI / 180.0), var6[1] * (float) (Math.PI / 180.0), var6[0] * (float) (Math.PI / 180.0));
         cloudSupport51 var8 = this.v9.get(var2);
         switch (var4) {
            case "cube":
               this.v1(var1, var2, var3, var5, var7, var8);
               break;
            case "mesh":
               this.v2(var1, var2, var3, var5, var7, var8);
         }
      }

      private void v1(JsonObject var1, int var2, String var3, float[] var4, Matrix3f var5, cloudSupport51 var6) throws IOException {
         float var7 = cloudSupport39.v1(var1, "inflate", 0.0F);
         float[] var8 = cloudSupport39.v2(var1, "from");
         float[] var9 = cloudSupport39.v2(var1, "to");

         for (int var10 = 0; var10 < 3; var10++) {
            var8[var10] -= var7;
            var9[var10] += var7;
         }

         JsonObject var25 = cloudSupport39.v1(var1, "faces");
         boolean var11 = cloudSupport39.v1(var1, "box_uv", false);
         float[] var12 = var1.has("uv_offset") ? cloudSupport39.v2(var1.getAsJsonArray("uv_offset")) : new float[2];

         for (int var13 = 0; var13 < cloudSupport39.v3.length; var13++) {
            if (var25.has(cloudSupport39.v3[var13])) {
               JsonObject var14 = var25.getAsJsonObject(cloudSupport39.v3[var13]);
               if (var14.has("texture")
                  && !var14.get("texture").isJsonNull()
                  && (!var14.get("texture").isJsonPrimitive() || !var14.get("texture").getAsJsonPrimitive().isBoolean())) {
                  int var15 = var14.get("texture").getAsInt();
                  float[] var16 = var11 ? v1(cloudSupport39.v3[var13], var12, var8, var9) : cloudSupport39.v3(var14.getAsJsonArray("uv"));
                  int var17 = Math.floorMod(Math.round(cloudSupport39.v1(var14, "rotation", 0.0F) / 90.0F), 4);
                  float[] var18 = new float[32];
                  float[][] var19 = cloudSupport39.v4[var13];
                  Vector3f var20 = var5.transform(new Vector3f(var19[4][0], var19[4][1], var19[4][2]));
                  float[] var21 = this.v1(var15);

                  for (int var22 = 0; var22 < 4; var22++) {
                     Vector3f var23 = new Vector3f(
                        var8[0] + (var9[0] - var8[0]) * var19[var22][0],
                        var8[1] + (var9[1] - var8[1]) * var19[var22][1],
                        var8[2] + (var9[2] - var8[2]) * var19[var22][2]
                     );
                     var23.sub(var4[0], var4[1], var4[2]);
                     var5.transform(var23);
                     var23.add(var4[0], var4[1], var4[2]);
                     float[] var24 = cloudSupport39.v5[(var22 + var17) % 4];
                     v1(
                        var18,
                        var22,
                        var23,
                        var6,
                        (var16[0] + (var16[2] - var16[0]) * var24[0]) / var21[0],
                        (var16[1] + (var16[3] - var16[1]) * var24[1]) / var21[1],
                        var20
                     );
                  }

                  this.v1(var2, this.v1(var3, this.v2(var15)), var18);
               }
            }
         }
      }

      private void v2(JsonObject var1, int var2, String var3, float[] var4, Matrix3f var5, cloudSupport51 var6) throws IOException {
         JsonObject var7 = cloudSupport39.v1(var1, "vertices");
         HashMap var8 = new HashMap();

         for (Entry var10 : var7.entrySet()) {
            float[] var11 = cloudSupport39.v1(((JsonElement)var10.getValue()).getAsJsonArray());
            Vector3f var12 = var5.transform(new Vector3f(var11[0], var11[1], var11[2]));
            var8.put((String)var10.getKey(), var12.add(var4[0], var4[1], var4[2]));
         }

         for (Entry var25 : cloudSupport39.v1(var1, "faces").entrySet()) {
            JsonObject var26 = ((JsonElement)var25.getValue()).getAsJsonObject();
            if (var26.has("texture") && !var26.get("texture").isJsonNull()) {
               int var27 = var26.get("texture").getAsInt();
               float[] var13 = this.v1(var27);
               JsonArray var14 = var26.getAsJsonArray("vertices");
               JsonObject var15 = cloudSupport39.v1(var26, "uv");
               int var16 = var14.size();
               if (var16 >= 3 && var16 <= 4) {
                  Vector3f[] var17 = new Vector3f[var16];
                  float[][] var18 = new float[var16][];

                  for (int var19 = 0; var19 < var16; var19++) {
                     String var20 = var14.get(var19).getAsString();
                     Vector3f var21 = (Vector3f)var8.get(var20);
                     if (var21 == null || !var15.has(var20)) {
                        throw new cloudSupport38("mesh face uses missing vertex " + var20);
                     }

                     var17[var19] = var21;
                     float[] var22 = cloudSupport39.v2(var15.getAsJsonArray(var20));
                     var18[var19] = new float[]{var22[0] / var13[0], var22[1] / var13[1]};
                  }

                  int var28 = this.v1(var3, this.v2(var27));
                  if (var16 != 4) {
                     this.v1(var2, var28, var6, var17, var18);
                  } else {
                     int[] var29 = v1(var17);
                     Vector3f var30 = v1(var17[var29[0]], var17[var29[1]], var17[var29[2]], var17[var29[3]]);
                     float[] var31 = new float[32];

                     for (int var23 = 0; var23 < 4; var23++) {
                        v1(var31, var23, var17[var29[var23]], var6, var18[var29[var23]][0], var18[var29[var23]][1], var30);
                     }

                     this.v1(var2, var28, var31);
                  }
               }
            }
         }
      }

      private void v1(int var1, int var2, cloudSupport51 var3, Vector3f[] var4, float[][] var5) {
         Vector3f var6 = v1(var4[0], var4[1], var4[2], var4[2]);
         Vector3f var7 = new Vector3f(var4[0]).add(var4[1]).add(var4[2]).div(3.0F);
         float[] var8 = new float[]{(var5[0][0] + var5[1][0] + var5[2][0]) / 3.0F, (var5[0][1] + var5[1][1] + var5[2][1]) / 3.0F};

         for (int var9 = 0; var9 < 3; var9++) {
            int var10 = (var9 + 1) % 3;
            int var11 = (var9 + 2) % 3;
            Vector3f var12 = new Vector3f(var4[var9]).add(var4[var10]).mul(0.5F);
            Vector3f var13 = new Vector3f(var4[var11]).add(var4[var9]).mul(0.5F);
            float[] var14 = new float[]{(var5[var9][0] + var5[var10][0]) / 2.0F, (var5[var9][1] + var5[var10][1]) / 2.0F};
            float[] var15 = new float[]{(var5[var11][0] + var5[var9][0]) / 2.0F, (var5[var11][1] + var5[var9][1]) / 2.0F};
            float[] var16 = new float[32];
            v1(var16, 0, var4[var9], var3, var5[var9][0], var5[var9][1], var6);
            v1(var16, 1, var12, var3, var14[0], var14[1], var6);
            v1(var16, 2, var7, var3, var8[0], var8[1], var6);
            v1(var16, 3, var13, var3, var15[0], var15[1], var6);
            this.v1(var1, var2, var16);
         }
      }

      private static int[] v1(Vector3f[] var0) {
         int[][] var1 = new int[][]{{0, 1, 2, 3}, {0, 1, 3, 2}, {0, 2, 1, 3}};
         int[] var2 = var1[0];
         float var3 = -1.0F;

         for (int[] var7 : var1) {
            float var8 = v2(var0[var7[0]], var0[var7[1]], var0[var7[2]], var0[var7[3]]).length();
            if (var8 > var3) {
               var3 = var8;
               var2 = var7;
            }
         }

         return var2;
      }

      private static Vector3f v1(Vector3f var0, Vector3f var1, Vector3f var2, Vector3f var3) {
         Vector3f var4 = v2(var0, var1, var2, var3);
         float var5 = var4.length();
         return var5 > 1.0E-9F ? var4.div(var5) : new Vector3f(0.0F, 1.0F, 0.0F);
      }

      private static Vector3f v2(Vector3f var0, Vector3f var1, Vector3f var2, Vector3f var3) {
         Vector3f[] var4 = new Vector3f[]{var0, var1, var2, var3};
         Vector3f var5 = new Vector3f();

         for (int var6 = 0; var6 < 4; var6++) {
            Vector3f var7 = var4[var6];
            Vector3f var8 = var4[(var6 + 1) % 4];
            var5.x = var5.x + (var7.y - var8.y) * (var7.z + var8.z);
            var5.y = var5.y + (var7.z - var8.z) * (var7.x + var8.x);
            var5.z = var5.z + (var7.x - var8.x) * (var7.y + var8.y);
         }

         return var5;
      }

      private static float[] v1(String var0, float[] var1, float[] var2, float[] var3) {
         float var4 = (float)Math.floor(var3[0] - var2[0] + 1.0E-4F);
         float var5 = (float)Math.floor(var3[1] - var2[1] + 1.0E-4F);
         float var6 = (float)Math.floor(var3[2] - var2[2] + 1.0E-4F);
         float var7 = var1[0];
         float var8 = var1[1];

         return switch (var0) {
            case "north" -> new float[]{var7 + var6, var8 + var6, var7 + var6 + var4, var8 + var6 + var5};
            case "east" -> new float[]{var7, var8 + var6, var7 + var6, var8 + var6 + var5};
            case "south" -> new float[]{var7 + 2.0F * var6 + var4, var8 + var6, var7 + 2.0F * var6 + 2.0F * var4, var8 + var6 + var5};
            case "west" -> new float[]{var7 + var6 + var4, var8 + var6, var7 + 2.0F * var6 + var4, var8 + var6 + var5};
            case "up" -> new float[]{var7 + var6 + var4, var8 + var6, var7 + var6, var8};
            default -> new float[]{var7 + var6 + 2.0F * var4, var8, var7 + var6 + var4, var8 + var6};
         };
      }

      private float[] v1(int var1) throws cloudSupport38 {
         float[] var2 = this.v14.get(var1);
         if (var2 == null) {
            throw new cloudSupport38("a face is painted with missing texture " + var1);
         } else {
            return var2;
         }
      }

      private int v2(int var1) throws cloudSupport38 {
         Integer var2 = this.v15.get(var1);
         if (var2 == null) {
            throw new cloudSupport38("a face is painted with missing texture " + var1);
         } else {
            return var2;
         }
      }

      private static void v1(float[] var0, int var1, Vector3f var2, cloudSupport51 var3, float var4, float var5, Vector3f var6) {
         int var7 = var1 * 8;
         var0[var7] = (-var2.x - var3.v2()) * 0.0625F;
         var0[var7 + 1] = (24.0F - var2.y - var3.v3()) * 0.0625F;
         var0[var7 + 2] = (var2.z - var3.v4()) * 0.0625F;
         var0[var7 + 3] = var4;
         var0[var7 + 4] = var5;
         var0[var7 + 5] = -var6.x;
         var0[var7 + 6] = -var6.y;
         var0[var7 + 7] = var6.z;
      }

      private static float[] v1(float[] var0, cloudSupport51 var1) {
         return new float[]{(-var0[0] - var1.v2()) * 0.0625F, (24.0F - var0[1] - var1.v3()) * 0.0625F, (var0[2] - var1.v4()) * 0.0625F};
      }

      private static float[] v1(float[] var0) {
         return new float[]{-var0[0] * (float) (Math.PI / 180.0), -var0[1] * (float) (Math.PI / 180.0), var0[2] * (float) (Math.PI / 180.0)};
      }

      private void v1(int var1, int var2, float[] var3) {
         this.v13.computeIfAbsent((long)var1 << 32 | var2, var0 -> new ArrayList<>()).add(var3);
      }

      private uiSupport256 v3() {
         int var1 = 0;

         for (List var3 : this.v13.values()) {
            var1 += var3.size();
         }

         float[] var11 = new float[var1 * 4 * 8];
         int[] var12 = new int[this.v13.size() * 4];
         int var4 = 0;
         int var5 = 0;

         for (Entry var7 : this.v13.entrySet()) {
            int var8 = var4 / 8;

            for (float[] var10 : (List)var7.getValue()) {
               System.arraycopy(var10, 0, var11, var4, var10.length);
               var4 += var10.length;
            }

            var12[var5++] = (int)((Long)var7.getKey() >>> 32);
            var12[var5++] = (int)((Long)var7.getKey()).longValue();
            var12[var5++] = var8;
            var12[var5++] = var4 / 8 - var8;
         }

         return new uiSupport256(var11, var12);
      }

      private void v1(JsonObject var1, JsonObject var2, List<cloudSupport45> var3, int[] var4) throws cloudSupport38 {
         if (var2.size() != 0 && var1.has("animations")) {
            HashMap var5 = new HashMap();

            for (JsonElement var7 : var1.getAsJsonArray("animations")) {
               JsonObject var8 = var7.getAsJsonObject();
               var5.put(cloudSupport39.v1(var8, "name", ""), var8);
            }

            HashMap var13 = new HashMap();

            for (Entry var15 : var2.entrySet()) {
               cloudSupport44 var9 = cloudSupport44.v1((String)var15.getKey());
               if (var9 == null) {
                  throw new cloudSupport38("no motion called " + (String)var15.getKey());
               }

               String var10 = ((JsonElement)var15.getValue()).getAsString();
               Integer var11 = (Integer)var13.get(var10);
               if (var11 == null) {
                  JsonObject var12 = (JsonObject)var5.get(var10);
                  if (var12 == null) {
                     throw new cloudSupport38("the model has no animation " + var10);
                  }

                  var3.add(this.v1(var12));
                  var11 = var3.size() - 1;
                  var13.put(var10, var11);
               }

               var4[var9.ordinal()] = var11;
            }
         }
      }

      private cloudSupport45 v1(JsonObject var1) throws cloudSupport38 {
         String var2 = cloudSupport39.v1(var1, "name", "clip");
         String var4 = cloudSupport39.v1(var1, "loop", "loop");

         cloudSupport45.Part1 var3 = switch (var4) {
            case "once" -> cloudSupport45.Part1.ONCE;
            case "hold" -> cloudSupport45.Part1.HOLD;
            default -> cloudSupport45.Part1.LOOP;
         };
         ArrayList var17 = new ArrayList();
         JsonObject var18 = cloudSupport39.v1(var1, "animators");

         for (Entry var7 : var18.entrySet()) {
            Integer var8 = this.v12.get(var7.getKey());
            JsonObject var9 = ((JsonElement)var7.getValue()).getAsJsonObject();
            if (var8 != null && "bone".equals(cloudSupport39.v1(var9, "type", "bone")) && var9.has("keyframes")) {
               LinkedHashMap var10 = new LinkedHashMap();

               for (JsonElement var12 : var9.getAsJsonArray("keyframes")) {
                  JsonObject var13 = var12.getAsJsonObject();
                  String var15 = cloudSupport39.v1(var13, "channel", "");

                  cloudSupport46.Part1 var14 = switch (var15) {
                     case "rotation" -> cloudSupport46.Part1.ROTATION;
                     case "position" -> cloudSupport46.Part1.POSITION;
                     case "scale" -> cloudSupport46.Part1.SCALE;
                     default -> null;
                  };
                  if (var14 != null) {
                     var10.computeIfAbsent(var14, var0 -> new TreeMap<>()).put(cloudSupport39.v1(var13, "time", 0.0F), var13);
                  }
               }

               for (Entry var20 : var10.entrySet()) {
                  var17.add(v1(var8, (cloudSupport46.Part1)var20.getKey(), (SortedMap<Float, JsonObject>)var20.getValue()));
               }
            }
         }

         return new cloudSupport45(var2, Math.max(0.05F, cloudSupport39.v1(var1, "length", 1.0F)), var3, var17.toArray(cloudSupport46[]::new));
      }

      private static cloudSupport46 v1(int var0, cloudSupport46.Part1 var1, SortedMap<Float, JsonObject> var2) throws cloudSupport38 {
         int var3 = var2.size();
         float[] var4 = new float[var3];
         float[] var5 = new float[var3 * 3];
         byte[] var6 = new byte[var3];
         int var7 = 0;

         for (Entry var9 : var2.entrySet()) {
            JsonObject var10 = (JsonObject)var9.getValue();
            JsonObject var11 = var10.getAsJsonArray("data_points").get(0).getAsJsonObject();
            float var12 = v1(var11, "x");
            float var13 = v1(var11, "y");
            float var14 = v1(var11, "z");
            var4[var7] = (Float)var9.getKey();
            switch (var1) {
               case ROTATION:
                  var5[var7 * 3] = -var12 * (float) (Math.PI / 180.0);
                  var5[var7 * 3 + 1] = -var13 * (float) (Math.PI / 180.0);
                  var5[var7 * 3 + 2] = var14 * (float) (Math.PI / 180.0);
                  break;
               case POSITION:
                  var5[var7 * 3] = -var12 * 0.0625F;
                  var5[var7 * 3 + 1] = -var13 * 0.0625F;
                  var5[var7 * 3 + 2] = var14 * 0.0625F;
                  break;
               case SCALE:
                  var5[var7 * 3] = var12;
                  var5[var7 * 3 + 1] = var13;
                  var5[var7 * 3 + 2] = var14;
            }

            String var15 = cloudSupport39.v1(var10, "interpolation", "linear");

            var6[var7] = (byte)(switch (var15) {
               case "step" -> cloudSupport46.Part2.STEP.ordinal();
               case "catmullrom", "bezier" -> cloudSupport46.Part2.SMOOTH.ordinal();
               default -> cloudSupport46.Part2.LINEAR.ordinal();
            });
            var7++;
         }

         return new cloudSupport46(var0, var1, var4, var5, var6);
      }

      private static float v1(JsonObject var0, String var1) throws cloudSupport38 {
         if (!var0.has(var1)) {
            return 0.0F;
         } else {
            String var2 = var0.get(var1).getAsString().trim();
            if (var2.isEmpty()) {
               return 0.0F;
            } else {
               try {
                  return Float.parseFloat(var2);
               } catch (NumberFormatException var4) {
                  throw new cloudSupport38("keyframe value \"" + var2 + "\" is an expression; bake it to numbers");
               }
            }
         }
      }

      private cloudSupport50.Part1 v2(JsonObject var1) throws cloudSupport38 {
         cloudRecord6 var2 = cloudRecord6.v1();
         int[] var3 = var1.has("grid") ? cloudSupport39.v4(var1.getAsJsonArray("grid")) : new int[]{var2.v2(), var2.v3()};
         float[] var4 = var1.has("size") ? cloudSupport39.v2(var1.getAsJsonArray("size")) : new float[]{var2.v4() * 16.0F, var2.v5() * 16.0F};
         float var5 = cloudSupport39.v1(var1, "thickness", var2.v6() * 16.0F) * 0.0625F;
         JsonObject var6 = cloudSupport39.v1(var1, "physics");
         cloudRecord6 var7 = new cloudRecord6(
            var3[0],
            var3[1],
            var4[0] * 0.0625F,
            var4[1] * 0.0625F,
            var5,
            var2.v7(),
            0.125F + var5 / 2.0F,
            cloudSupport39.v1(var6, "gravity", var2.v9()),
            cloudSupport39.v1(var6, "drag", var2.v10()),
            cloudSupport39.v1(var6, "airResistance", var2.v11()),
            cloudSupport39.v1(var6, "bendStiffness", var2.v12()),
            cloudSupport39.v1(var6, "wind", var2.v13()),
            var2.v14(),
            Math.max(var2.v15(), var4[0] * 0.0625F / 2.0F)
         );
         String var8 = cloudSupport39.v1(var1, "material", this.v2());
         JsonObject var9 = this.v4.get(var8);
         if (var9 != null && var9.has("texture")) {
            int var10 = this.v1(var8, -1);
            cloudSupport43 var11 = cloudSupport43.v1;
            if (var1.has("layout") && var1.get("layout").isJsonArray()) {
               JsonArray var12 = var1.getAsJsonArray("layout");
               float[] var13 = new float[var12.size()];

               for (int var14 = 0; var14 < var13.length; var14++) {
                  var13[var14] = var12.get(var14).getAsFloat();
               }

               var11 = cloudSupport43.v1(var13);
            }

            return new cloudSupport50.Part1(var7, var10, var11);
         } else {
            throw new cloudSupport38("the cape's material must name its texture");
         }
      }
   }
}
