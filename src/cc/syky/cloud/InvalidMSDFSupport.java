package cc.syky.cloud;

import cc.syky.render.font.FontData;
import com.google.gson.Gson;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap.Entry;
import it.unimi.dsi.fastutil.longs.Long2FloatMap;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import net.minecraft.class_2960;
import net.minecraft.class_3300;

public final class InvalidMSDFSupport {
   public static final int v1 = 63;
   private final String v2;
   private final class_2960 v3;
   private final FontData.AtlasData v4;
   private final FontData.MetricsData v5;
   private final Int2ObjectMap<cloudSupport28> v6;
   private final Long2FloatMap v7;
   private static final int v8 = 1280;
   private final cloudSupport28[] v9 = new cloudSupport28[1280];
   private static final int v10 = 128;
   private final float[] v11 = new float[16384];

   private InvalidMSDFSupport(
      String var1, class_2960 var2, FontData.AtlasData var3, FontData.MetricsData var4, Int2ObjectMap<cloudSupport28> var5, Long2FloatMap var6
   ) {
      this.v2 = var1;
      this.v3 = var2;
      this.v4 = var3;
      this.v5 = var4;
      this.v6 = var5;
      this.v7 = var6;
      ObjectIterator var7 = var5.int2ObjectEntrySet().iterator();

      while (var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         int var9 = var8.getIntKey();
         if (var9 >= 0 && var9 < 1280) {
            this.v9[var9] = (cloudSupport28)var8.getValue();
         }
      }

      Arrays.fill(this.v11, var6.defaultReturnValue());
      var7 = var6.long2FloatEntrySet().iterator();

      while (var7.hasNext()) {
         it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry var16 = (it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry)var7.next();
         long var17 = var16.getLongKey();
         long var11 = var17 >>> 32;
         long var13 = var17 & 4294967295L;
         if (var11 < 128L && var13 < 128L) {
            this.v11[(int)var11 * 128 + (int)var13] = var16.getFloatValue();
         }
      }
   }

   public String v1() {
      return this.v2;
   }

   public class_2960 v2() {
      return this.v3;
   }

   public float v3() {
      return this.v4.width;
   }

   public float v4() {
      return this.v4.height;
   }

   public float v5() {
      return this.v4.range;
   }

   public float v6() {
      return this.v4.size > 0.0F ? this.v4.range / (2.0F * this.v4.size) : 0.0F;
   }

   public boolean v7() {
      return "mtsdf".equals(this.v4.type);
   }

   public float v8() {
      return this.v5.lineHeight;
   }

   public float v9() {
      return this.v5.ascender;
   }

   public cloudSupport28 v1(int var1) {
      return var1 >= 0 && var1 < 1280 ? this.v9[var1] : (cloudSupport28)this.v6.get(var1);
   }

   public int v2(int var1) {
      if (var1 >= 0 && var1 < 1280) {
         return this.v9[var1] != null ? var1 : 63;
      } else {
         return this.v6.containsKey(var1) ? var1 : 63;
      }
   }

   public float v1(int var1, int var2) {
      return var1 >= 0 && var2 >= 0 && var1 < 128 && var2 < 128 ? this.v11[var1 * 128 + var2] : this.v7.get(v2(var1, var2));
   }

   private static long v2(int var0, int var1) {
      return (long)var0 << 32 | var1 & 4294967295L;
   }

   public float v1(String var1, float var2) {
      float var3 = 0.0F;
      float var4 = 0.0F;
      int var5 = -1;
      int var6 = 0;

      while (var6 < var1.length()) {
         int var7 = var1.codePointAt(var6);
         var6 += Character.charCount(var7);
         if (var7 == 10) {
            if (var4 > var3) {
               var3 = var4;
            }

            var4 = 0.0F;
            var5 = -1;
         } else {
            var7 = this.v2(var7);
            cloudSupport28 var8 = this.v1(var7);
            if (var8 != null) {
               if (var5 != -1) {
                  var4 += this.v1(var5, var7) * var2;
               }

               var4 += var8.v2 * var2;
               var5 = var7;
            }
         }
      }

      return var4 > var3 ? var4 : var3;
   }

   public float v2(String var1, float var2) {
      float var3 = 0.0F;
      float var4 = Float.POSITIVE_INFINITY;
      float var5 = Float.NEGATIVE_INFINITY;
      int var6 = -1;
      int var7 = 0;

      while (var7 < var1.length()) {
         int var8 = var1.codePointAt(var7);
         var7 += Character.charCount(var8);
         if (var8 == 10) {
            break;
         }

         var8 = this.v2(var8);
         cloudSupport28 var9 = this.v1(var8);
         if (var9 != null) {
            if (var6 != -1) {
               var3 += this.v1(var6, var8) * var2;
            }

            if (var9.v11) {
               var4 = Math.min(var4, var3 + var9.v7 * var2);
               var5 = Math.max(var5, var3 + var9.v9 * var2);
            }

            var3 += var9.v2 * var2;
            var6 = var8;
         }
      }

      return var4 > var5 ? 0.0F : (var4 + var5) / 2.0F - var3 / 2.0F;
   }

   public void v1(String var1, float var2, float[] var3) {
      if (var3.length < var1.length() + 1) {
         throw new IllegalArgumentException("out is " + var3.length + ", need " + (var1.length() + 1));
      } else {
         float var4 = 0.0F;
         int var5 = -1;
         int var6 = 0;

         while (var6 < var1.length()) {
            int var7 = var1.codePointAt(var6);
            int var8 = Character.charCount(var7);
            int var9 = var7 == 10 ? -1 : this.v2(var7);
            cloudSupport28 var10 = var9 < 0 ? null : this.v1(var9);
            if (var10 != null && var5 != -1) {
               var4 += this.v1(var5, var9) * var2;
            }

            for (int var11 = 0; var11 < var8; var11++) {
               var3[var6 + var11] = var4;
            }

            if (var10 != null) {
               var4 += var10.v2 * var2;
               var5 = var9;
            }

            var6 += var8;
         }

         var3[var1.length()] = var4;
      }
   }

   public float v3(String var1, float var2) {
      if (var1.isEmpty()) {
         return 0.0F;
      } else {
         int var3 = 1;

         for (int var4 = 0; var4 < var1.length(); var4++) {
            if (var1.charAt(var4) == '\n') {
               var3++;
            }
         }

         return var3 * this.v5.lineHeight * var2;
      }
   }

   public static InvalidMSDFSupport v1(String var0, class_2960 var1, class_2960 var2, class_3300 var3) {
      FontData var4;
      try (
         InputStream var5 = var3.getResourceOrThrow(var1).method_14482();
         InputStreamReader var6 = new InputStreamReader(var5, StandardCharsets.UTF_8);
      ) {
         var4 = (FontData)new Gson().fromJson(var6, FontData.class);
      } catch (Exception var13) {
         throw new RuntimeException("Failed to load MSDF font JSON: " + var1, var13);
      }

      if (var4 != null && var4.atlas != null && var4.metrics != null && var4.glyphs != null) {
         Int2ObjectOpenHashMap var14 = new Int2ObjectOpenHashMap(var4.glyphs.size());

         for (FontData.GlyphData var7 : var4.glyphs) {
            var14.put(var7.unicode, new cloudSupport28(var7, var4.atlas.width, var4.atlas.height));
         }

         Long2FloatOpenHashMap var16 = new Long2FloatOpenHashMap();
         var16.defaultReturnValue(0.0F);
         if (var4.kernings != null) {
            for (FontData.KerningData var8 : var4.kernings) {
               var16.put(v2(var8.leftChar, var8.rightChar), var8.advance);
            }
         }

         return new InvalidMSDFSupport(var0, var2, var4.atlas, var4.metrics, var14, var16);
      } else {
         throw new RuntimeException("Invalid MSDF font JSON: " + var1);
      }
   }

   public static InvalidMSDFSupport v1(String var0, FontData.AtlasData var1, FontData.MetricsData var2, Int2ObjectMap<cloudSupport28> var3, Long2FloatMap var4) {
      return new InvalidMSDFSupport(var0, class_2960.method_60655("syky", "test"), var1, var2, var3, var4);
   }
}
