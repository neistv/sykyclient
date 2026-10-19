package cc.syky.cloud;

import cc.syky.internal.InternalSupport25;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class YouSupport {
   public final List<YouSupport.Part3> v1;
   public final List<YouSupport.Part2> v2;
   public final float v3;
   public static final YouSupport v4 = new YouSupport(List.of(), List.of(), 0.0F);

   private YouSupport(List<YouSupport.Part3> var1, List<YouSupport.Part2> var2, float var3) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
   }

   public static float v1(float var0) {
      return Math.max(38.0F, Math.min(440.0F, (float)Math.floor(var0 * 0.8F)));
   }

   public static YouSupport v1(
      List<GETSupport.Part14> var0,
      float var1,
      ZoneId var2,
      LocalDate var3,
      String var4,
      Set<Long> var5,
      String var6,
      String var7,
      String var8,
      String var9,
      YouSupport.Part1 var10
   ) {
      if (var0.isEmpty()) {
         return v4;
      } else {
         float var11 = v1(var1) - 12.0F - 10.0F;
         InternalSupport25.Part1 var12 = var2x -> var10.width(var6, var2x, 16.0F);
         ArrayList var13 = new ArrayList(var0.size());
         ArrayList var14 = new ArrayList();
         float var15 = 0.0F;
         boolean var16 = false;
         boolean var17 = false;
         GETSupport.Part14 var18 = null;
         LocalDate var19 = null;

         for (GETSupport.Part14 var21 : var0) {
            LocalDate var22 = MMMMDSupport.v2(var21.v6(), var2);
            if (!var22.equals(var19)) {
               if (var16) {
                  var15 += 14.0F;
               }

               String var23 = MMMMDSupport.v1(var22, var3);
               float var24 = (float)Math.ceil(var10.width(var8, var23, 13.0F) + 24.0F);
               var14.add(new YouSupport.Part2(var23, var24, var15));
               var15 += 25.0F;
               var16 = true;
               var17 = true;
            }

            boolean var39 = var18 != null && !var17 && var18.v4() == var21.v4() && Math.abs(var21.v6().toEpochMilli() - var18.v6().toEpochMilli()) <= 600000L;
            if (var16) {
               var15 += var39 ? 4.0F : 14.0F;
            }

            if (!var39 && !var13.isEmpty()) {
               ((YouSupport.Part3)var13.getLast()).v7 = true;
            }

            if (var21.v1() != GETSupport.Part9.WORDS) {
               YouSupport.Part3 var41 = v1(var21, var1, var2, var5, var4, !var39, var15);
               var13.add(var41);
               var15 += var41.v12;
               var16 = true;
               var17 = false;
               var18 = var21;
               var19 = var22;
            } else {
               ArrayList var40 = new ArrayList();
               boolean[] var25 = v1(var21.v5(), var11, var12, var40);
               float var26 = 0.0F;

               for (String var28 : var40) {
                  var26 = Math.max(var26, var12.widthOf(var28));
               }

               float var42 = var12.widthOf((String)var40.getLast());
               String var43 = (var21.v9() != null ? "edited " : "") + MMMMDSupport.v1(var21.v6(), var2);
               boolean var29 = var5.contains(var21.v3());
               float var30 = var10.width(var7, var43, 12.0F) + (var21.v4() ? 21.6F : 0.0F) + (var29 ? 14.0F : 0.0F);
               boolean var31 = var42 + 10.0F + var30 > var11;
               float var32 = var31 ? Math.max(var26, var30) : Math.max(var26, var42 + 10.0F + var30);
               float var33 = (float)Math.ceil(12.0F + var32 + 10.0F);
               GETSupport.Part18 var34 = var21.v8();
               String var35 = "";
               float var36 = 6.0F;
               if (var34 != null) {
                  var35 = var34.v2() ? "You" : var4;
                  float var37 = Math.max(var10.width(var9, var35, 14.0F), var10.width(var6, v1(v1(var34)), 14.0F));
                  float var38 = 11.0F + var37 + 10.0F;
                  var33 = Math.max(var33, (float)Math.ceil(Math.min(v1(var1), var38 + 12.0F)));
                  var36 = 55.0F;
               }

               float var44 = var36 + var40.size() * 21.0F + (var31 ? 13.0F : 0.0F) + 6.0F;
               float var45 = var21.v4() ? var1 - var33 : 0.0F;
               var13.add(new YouSupport.Part3(var21, List.copyOf(var40), var25, var43, var29, !var39, var31, var35, var36, var33, var44, var15, var45));
               var15 += var44;
               var16 = true;
               var17 = false;
               var18 = var21;
               var19 = var22;
            }
         }

         ((YouSupport.Part3)var13.getLast()).v7 = true;
         return new YouSupport(List.copyOf(var13), List.copyOf(var14), var15);
      }
   }

   private static YouSupport.Part3 v1(GETSupport.Part14 var0, float var1, ZoneId var2, Set<Long> var3, String var4, boolean var5, float var6) {
      float var7 = Math.min(300.0F, v1(var1));
      GETSupport.Part18 var8 = var0.v8();
      String var9 = "";
      float var10 = 0.0F;
      if (var8 != null) {
         var9 = var8.v2() ? "You" : var4;
         var10 = 50.0F;
      }

      String var11 = MMMMDSupport.v1(var0.v6(), var2);
      float var12 = var0.v4() ? var1 - var7 : 0.0F;
      return new YouSupport.Part3(
         var0, List.of(), new boolean[0], var11, var3.contains(var0.v3()), var5, false, var9, var10, var7, var10 + cloudSupport19.v237, var6, var12
      );
   }

   public static String v1(GETSupport.Part18 var0) {
      String var1 = var0.v4();
      return var1 != null ? var1 : var0.v3();
   }

   public static String v1(String var0) {
      int var1 = var0.indexOf(10);
      return var1 < 0 ? var0 : var0.substring(0, var1);
   }

   private static boolean[] v1(String var0, float var1, InternalSupport25.Part1 var2, List<String> var3) {
      ArrayList var4 = new ArrayList();

      for (String var8 : var0.split("\n", -1)) {
         List var9 = InternalSupport25.v1(var8.strip(), var1, var2);
         if (var9.isEmpty()) {
            var3.add("");
         } else {
            var3.addAll(var9);
         }

         var4.add(var3.size() - 1);
      }

      boolean[] var10 = new boolean[var3.size()];

      for (int var12 : var4) {
         var10[var12] = true;
      }

      return var10;
   }

   @FunctionalInterface
   public interface Part1 {
      float width(String var1, String var2, float var3);
   }

   public record Part2(String label, float width, float top) {
      public String v1() {
         return this.label;
      }

      public float v2() {
         return this.width;
      }

      public float v3() {
         return this.top;
      }
   }

   public static final class Part3 {
      public final GETSupport.Part14 v1;
      public final List<String> v2;
      public final boolean[] v3;
      public final String v4;
      public final boolean v5;
      public final boolean v6;
      public boolean v7;
      public final boolean v8;
      public final String v9;
      public final float v10;
      public final float v11;
      public final float v12;
      public final float v13;
      public final float v14;
      public final boolean v15;

      public Part3(
         GETSupport.Part14 var1,
         List<String> var2,
         boolean[] var3,
         String var4,
         boolean var5,
         boolean var6,
         boolean var7,
         String var8,
         float var9,
         float var10,
         float var11,
         float var12,
         float var13
      ) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
         this.v4 = var4;
         this.v5 = var5;
         this.v6 = var6;
         this.v8 = var7;
         this.v9 = var8;
         this.v10 = var9;
         this.v11 = var10;
         this.v12 = var11;
         this.v13 = var12;
         this.v14 = var13;
         this.v15 = var1.v1() != GETSupport.Part9.WORDS;
      }

      public boolean v1() {
         return this.v1.v4();
      }

      public String v1(int var1, int var2, int var3, int var4) {
         StringBuilder var5 = new StringBuilder();

         for (int var6 = var1; var6 <= var3; var6++) {
            String var7 = this.v2.get(var6);
            int var8 = var6 == var1 ? Math.min(var2, var7.length()) : 0;
            int var9 = var6 == var3 ? Math.min(var4, var7.length()) : var7.length();
            if (var9 > var8) {
               var5.append(var7, var8, var9);
            }

            if (var6 < var3) {
               var5.append((char)(this.v3[var6] ? '\n' : ' '));
            }
         }

         return var5.toString();
      }

      public float v2() {
         return this.v13 + this.v12;
      }
   }
}
