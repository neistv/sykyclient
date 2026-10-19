package cc.syky.ui;

import java.util.EnumMap;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.Nullable;

public final class uiSupport139 {
   private static AltManagerSupport v2 = AltManagerSupport.VISUAL;
   private static boolean v3;
   private static float v4;
   private static float v5 = 0.5F;
   private static float v6 = 0.5F;
   private static String v7 = "";
   public static final long v1 = TimeUnit.MINUTES.toNanos(3L);
   private static long v8;
   private static boolean v9;
   private static final EnumMap<AltManagerSupport, String> v10 = new EnumMap<>(AltManagerSupport.class);
   private static uiSupport139.Part1 v11 = uiSupport139.Part1.NONE;
   @Nullable
   private static String v12;
   private static float v13;
   private static float v14;
   private static boolean v15;
   private static float v16;

   private uiSupport139() {
   }

   public static AltManagerSupport v1() {
      return v2;
   }

   public static void v1(AltManagerSupport var0) {
      v2 = var0;
      v3 = true;
   }

   public static boolean v2() {
      boolean var0 = !v3;
      v3 = true;
      return var0;
   }

   public static float v3() {
      return v4;
   }

   public static void v1(float var0) {
      v4 = var0;
   }

   public static float v4() {
      return v5;
   }

   public static float v5() {
      return v6;
   }

   public static void v1(float var0, float var1) {
      v5 = var0;
      v6 = var1;
   }

   public static void v6() {
      v8 = System.nanoTime();
      v9 = true;
   }

   public static void v7() {
      v1(System.nanoTime());
   }

   public static void v1(long var0) {
      if (v9 && var0 - v8 >= v1) {
         boolean var2 = v2.v4().length > 0;
         if (!(var2 ? v7 : v2(v2)).isEmpty()) {
            v4 = 0.0F;
         }

         v7 = "";
         v10.clear();
      }
   }

   public static String v8() {
      return v7;
   }

   public static void v1(String var0) {
      v7 = var0;
   }

   public static String v2(AltManagerSupport var0) {
      return v10.getOrDefault(var0, "");
   }

   public static void v1(AltManagerSupport var0, String var1) {
      v10.put(var0, var1);
   }

   public static void v3(AltManagerSupport var0) {
      v10.remove(var0);
   }

   public static void v1(uiSupport139.Part1 var0, @Nullable String var1, float var2, float var3) {
      v11 = var0;
      v12 = var1;
      v13 = var2;
      v14 = var3;
      v15 = false;
      v16 = 0.0F;
   }

   public static void v1(float var0, float var1, boolean var2, float var3) {
      v13 = var0;
      v14 = var1;
      v15 = var2;
      v16 = var3;
   }

   public static void v1(uiSupport139.Part1 var0, String var1) {
      v11 = var0;
      v12 = var1;
   }

   public static void v9() {
      v11 = uiSupport139.Part1.NONE;
      v12 = null;
   }

   public static boolean v10() {
      return v11 != uiSupport139.Part1.NONE;
   }

   @Nullable
   public static String v1(uiSupport139.Part1 var0) {
      return v11 == var0 ? v12 : null;
   }

   public static boolean v2(uiSupport139.Part1 var0) {
      return v11 == var0;
   }

   public static float v11() {
      return v13;
   }

   public static float v12() {
      return v14;
   }

   public static boolean v13() {
      return v15;
   }

   public static float v14() {
      return v16;
   }

   public static enum Part1 {
      NONE,
      SETTINGS,
      CONFIG,
      PAGE_WINDOW;

      private Part1() {
      }
   }
}
