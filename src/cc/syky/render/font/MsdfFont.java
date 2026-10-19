package cc.syky.render.font;

import cc.syky.cloud.cloudRecord5;
import cc.syky.hud.hudSupport54;
import cc.syky.ui.UiNode;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport35;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.LongSupplier;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import org.jetbrains.annotations.Nullable;

public final class MsdfFont extends UiNode {
   private static final long v1 = 400L;
   private static final float v2 = 3.0F;
   private static final long v3 = 1060L;
   private static final char v4 = '•';
   private static final float v5 = 0.8F;
   private static final boolean v6 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("mac");
   private final fontSupport v7;
   private final String v8;
   private final Consumer<String> v13;
   private MsdfFont.Part1 v14;
   private MsdfFont.Part3 v15 = MsdfFont.Part2.INSTANCE;
   private LongSupplier v16 = MsdfFont::v21;
   private BooleanSupplier v18 = MsdfFont::v22;
   private String v19 = "";
   private float v17 = -1.0F;
   private boolean v20;
   private float v21 = 14.0F;
   private float v22;
   private float v24 = 1.0F;
   private long v25 = 1060L;
   private int v26 = -1;
   private int v27 = 1090519039;
   private int v28 = 1090519039;
   private int v29 = -1;
   private boolean v30;
   private boolean v32;
   private float[] v23 = new float[16];
   private int v33 = -1;
   private boolean v31;
   private boolean v34;
   private String v36 = "";
   private float v38;
   private long v42;
   private long v43;
   private float v37;
   private float v48;
   private int v40;
   private boolean v44;
   private float v47;
   private int v49 = 1;
   private int[] v46 = new int[8];
   private int[] v51 = new int[8];
   private int v50 = 1;
   private int v60 = -1;
   private float v59 = -1.0F;
   private float v53 = -1.0F;
   private float v63;
   private float v64 = -1.0F;

   public MsdfFont(String var1, int var2, Consumer<String> var3) {
      this.v8 = var1;
      this.v7 = new fontSupport(var2);
      this.v13 = var3;
      this.v14 = (var1x, var2x) -> uiSupport169.v1(var1, var1x, 1.0F, var2x);
   }

   public void v1(float var1, float var2, float var3) {
      this.v21 = var1;
      this.v22 = var2;
      this.v24 = Math.max(var3, uiSupport169.v2());
   }

   public void v1(int var1, int var2, int var3, int var4) {
      this.v26 = var1;
      this.v27 = var2;
      this.v28 = var3;
      this.v29 = var4;
   }

   public void v1(String var1) {
      this.v19 = var1 == null ? "" : var1;
      this.v17 = -1.0F;
   }

   public void v1(boolean var1) {
      this.v20 = var1;
   }

   public void v1(long var1) {
      this.v25 = Math.max(1L, var1);
   }

   public void v1(float var1, int var2) {
      if (!this.v44) {
         this.v44 = true;
         this.v7.v1(true);
      }

      this.v47 = var1;
      this.v49 = Math.max(1, var2);
   }

   public int v1() {
      this.v12();
      return this.v50;
   }

   public String v2() {
      return this.v7.v1();
   }

   public void v2(boolean var1) {
      this.v31 = var1;
   }

   public void v2(String var1) {
      this.v7.v1(var1);
   }

   public boolean v3() {
      return this.v30;
   }

   public void v3(boolean var1) {
      if (this.v30 != var1) {
         this.v30 = var1;
         this.v32 = false;
         this.v40 = 0;
         if (!var1) {
            this.v7.v13();
         } else {
            this.v20();
         }
      }
   }

   public void v4() {
      this.v32 = false;
      this.v7.v12();
      this.v20();
   }

   public static boolean v1(int var0) {
      return (var0 & 4) == 0 && ((var0 & 2) != 0 || v6 && (var0 & 8) != 0);
   }

   @Override
   public void v1(uiSupport35 var1) {
      if (!(this.v11 <= 0.0F) && !(this.v12 <= 0.0F)) {
         this.v5();
         if (this.v44) {
            this.v2(var1);
         } else {
            if (this.v32 && var1.v2()) {
               this.v7.v1(this.v1(var1.v1), true);
            }

            this.v6();
            if (this.v9()) {
               this.v10();
            } else {
               uiSupport169.v6(this.v9, this.v10, this.v11, this.v12);

               try {
                  this.v10();
               } finally {
                  uiSupport169.v17();
               }
            }
         }
      }
   }

   private boolean v9() {
      if (!(this.v38 > 0.0F) && !(this.v22 < 0.0F)) {
         if (this.v22 + this.v21 * uiSupport169.v2(this.v8) > this.v12) {
            return false;
         } else {
            return this.v14()
               ? this.v15() * this.v21 + (this.v30 ? this.v24 : 0.0F) <= this.v11
               : this.v4(this.v7.v2()) + (this.v30 ? this.v24 : 0.0F) <= this.v11;
         }
      } else {
         return false;
      }
   }

   private void v10() {
      float var1 = this.v10 + this.v22;
      if (this.v14()) {
         uiSupport169.v1(this.v8, this.v19, this.v9, var1, this.v21, this.v27);
      }

      if (!this.v7.v3() || this.v30) {
         float var2 = this.v9 - this.v38;
         float var3 = this.v21 * uiSupport169.v2(this.v8);
         if (this.v30 && this.v7.v7()) {
            float var4 = this.v4(this.v7.v8());
            float var5 = this.v4(this.v7.v9());
            uiSupport169.v1(var2 + var4, var1, var5 - var4, var3, this.v28, uiRecord7.ZERO);
         }

         if (!this.v36.isEmpty()) {
            uiSupport169.v1(this.v8, this.v36, var2, var1, this.v21, this.v26, this.v18());
         }

         if (this.v30 && this.v16()) {
            uiSupport169.v1(var2 + this.v4(this.v7.v4()), var1, this.v24, var3, this.v29, uiRecord7.ZERO);
         }
      }
   }

   private void v2(uiSupport35 var1) {
      this.v12();
      if (this.v32 && var1.v2()) {
         this.v7.v1(this.v3(var1.v1, var1.v2), true);
      }

      this.v13();
      boolean var2 = this.v50 > this.v49 || this.v63 > 0.0F;
      if (var2) {
         uiSupport169.v6(this.v9, this.v10, this.v11, this.v12);
      }

      try {
         this.v11();
      } finally {
         if (var2) {
            uiSupport169.v17();
         }
      }
   }

   private void v11() {
      if (this.v14()) {
         uiSupport169.v1(this.v8, this.v19, this.v9, this.v10 + this.v22, this.v21, this.v27);
      }

      if (!this.v7.v3() || this.v30) {
         float var1 = this.v21 * uiSupport169.v2(this.v8);
         boolean var2 = this.v30 && this.v7.v7();
         int var3 = this.v7.v8();
         int var4 = this.v7.v9();

         for (int var5 = 0; var5 < this.v50; var5++) {
            float var6 = this.v2(var5);
            if (!(var6 + var1 < this.v10) && !(var6 > this.v10 + this.v12)) {
               int var7 = this.v46[var5];
               int var8 = this.v51[var5];
               if (var2 && var3 <= var8 && var4 >= var7 && (var3 < var8 || var4 > var8)) {
                  float var9 = this.v5(Math.max(var3, var7), var5);
                  float var10 = var4 > var8 ? this.v5(var8, var5) + this.v21 * 0.3F : this.v5(Math.min(var4, var8), var5);
                  uiSupport169.v1(this.v9 + var9, var6, var10 - var9, var1, this.v28, uiRecord7.ZERO);
               }

               if (var8 > var7) {
                  uiSupport169.v1(this.v8, this.v36.substring(var7, var8), this.v9, var6, this.v21, this.v26);
               }
            }
         }

         if (this.v30 && this.v16()) {
            int var11 = this.v3(this.v7.v4());
            uiSupport169.v1(this.v9 + this.v5(this.v7.v4(), var11), this.v2(var11), this.v24, var1, this.v29, uiRecord7.ZERO);
         }
      }
   }

   private float v2(int var1) {
      return this.v10 + this.v22 + var1 * this.v47 - this.v63;
   }

   private float v5(int var1, int var2) {
      return (this.v23[var1] - this.v23[this.v46[var2]]) * this.v21;
   }

   private int v3(int var1) {
      this.v12();
      int var2 = 0;

      while (var2 + 1 < this.v50 && this.v46[var2 + 1] <= var1) {
         var2++;
      }

      return var2;
   }

   private void v12() {
      if (!this.v44) {
         this.v50 = 1;
      } else {
         this.v5();
         if (this.v60 != this.v7.v6() || this.v59 != this.v11 || this.v53 != this.v21) {
            this.v60 = this.v7.v6();
            this.v59 = this.v11;
            this.v53 = this.v21;
            String var1 = this.v7.v1();
            float var2 = this.v21 > 0.0F ? Math.max(0.0F, this.v11 - this.v24) / this.v21 : Float.MAX_VALUE;
            int var3 = 0;
            int var4 = 0;
            int var5 = -1;
            int var6 = 0;

            while (var6 < var1.length()) {
               char var7 = var1.charAt(var6);
               if (var7 == '\n') {
                  var3 = this.v1(var3, var4, var6);
                  var4 = var6 + 1;
                  var5 = -1;
                  var6 = var4;
               } else {
                  int var8 = var6 + Character.charCount(var1.codePointAt(var6));
                  if (this.v23[var8] - this.v23[var4] > var2 && var6 > var4) {
                     int var9 = var5 > var4 ? var5 : var6;
                     var3 = this.v1(var3, var4, var9);
                     var4 = var9;
                     var5 = -1;
                     var6 = var9;
                  } else {
                     if (var7 == ' ') {
                        var5 = var8;
                     }

                     var6 = var8;
                  }
               }
            }

            this.v50 = this.v1(var3, var4, var1.length());
         }
      }
   }

   private int v1(int var1, int var2, int var3) {
      if (var1 == this.v46.length) {
         this.v46 = Arrays.copyOf(this.v46, var1 * 2);
         this.v51 = Arrays.copyOf(this.v51, var1 * 2);
      }

      this.v46[var1] = var2;
      this.v51[var1] = var3;
      return var1 + 1;
   }

   private void v13() {
      int var1 = this.v3(this.v7.v4());
      float var2 = Math.max(0.0F, (this.v50 - this.v49) * this.v47);
      float var3 = var1 * this.v47;
      if (var3 < this.v63) {
         this.v63 = var3;
      } else if (var3 + this.v47 > this.v63 + this.v49 * this.v47) {
         this.v63 = var3 + this.v47 - this.v49 * this.v47;
      }

      this.v63 = Math.max(0.0F, Math.min(this.v63, var2));
   }

   private int v3(float var1, float var2) {
      this.v12();
      int var3 = this.v47 > 0.0F ? (int)Math.floor((var2 - (this.v10 + this.v22) + this.v63) / this.v47) : 0;
      var3 = Math.max(0, Math.min(var3, this.v50 - 1));
      return this.v1(var3, var1 - this.v9);
   }

   private int v1(int var1, float var2) {
      String var3 = this.v7.v1();
      int var4 = this.v46[var1];
      int var5 = this.v51[var1];

      while (var4 < var5) {
         int var6 = var4 + Character.charCount(var3.codePointAt(var4));
         if (var2 < (this.v5(var4, var1) + this.v5(var6, var1)) / 2.0F) {
            return var4;
         }

         var4 = var6;
      }

      return var5 > this.v46[var1] && var5 < var3.length() && var3.charAt(var5 - 1) == 32 && var3.charAt(var5) != 10 ? var5 - 1 : var5;
   }

   private void v1(int var1, boolean var2) {
      int var3 = this.v3(this.v7.v4());
      if (this.v64 < 0.0F) {
         this.v64 = this.v5(this.v7.v4(), var3);
      }

      int var4 = var3 + var1;
      float var5 = this.v64;
      if (var4 < 0) {
         this.v7.v1(0, var2);
      } else if (var4 >= this.v50) {
         this.v7.v1(this.v7.v2(), var2);
      } else {
         this.v7.v1(this.v1(var4, var5), var2);
      }

      this.v20();
      this.v64 = var5;
   }

   private boolean v14() {
      return this.v7.v3() && !this.v19.isEmpty() && (!this.v30 || this.v20);
   }

   private float v15() {
      if (this.v17 < 0.0F) {
         this.v17 = uiSupport169.v2(this.v8, this.v19, 1.0F);
      }

      return this.v17;
   }

   private boolean v16() {
      long var1 = this.v16.getAsLong();
      return var1 - this.v42 < this.v25 / 2L ? true : Math.floorMod(var1, this.v25) < this.v25 / 2L;
   }

   public void v5() {
      if (this.v33 != this.v7.v6() || this.v34 != this.v31) {
         String var1 = this.v7.v1();
         this.v36 = this.v31 ? String.valueOf('•').repeat(var1.length()) : var1;
         if (this.v23.length < var1.length() + 1) {
            this.v23 = new float[Math.max(this.v23.length * 2, var1.length() + 1)];
         }

         this.v14.prefixWidths(this.v36.indexOf(10) < 0 ? this.v36 : this.v36.replace('\n', ' '), this.v23);
         this.v33 = this.v7.v6();
         this.v34 = this.v31;
      }
   }

   private float v4(int var1) {
      return this.v23[var1] * this.v21;
   }

   private cloudRecord5 v18() {
      boolean var1 = this.v38 > 0.0F;
      boolean var2 = this.v4(this.v7.v2()) - this.v38 > this.v11;
      return !var1 && !var2 ? cloudRecord5.NONE : cloudRecord5.NONE.v1(var1 ? this.v9 : -1.0E9F, var2 ? this.v9 + this.v11 : 1.0E9F, this.v21 * 0.8F);
   }

   public void v6() {
      this.v5();
      float var1 = this.v4(this.v7.v4());
      float var2 = Math.max(0.0F, this.v4(this.v7.v2()) + this.v24 - this.v11);
      this.v38 = Math.min(this.v38, var2);
      if (var1 - this.v38 < 0.0F) {
         this.v38 = var1;
      } else if (var1 - this.v38 > this.v11 - this.v24) {
         this.v38 = var1 - (this.v11 - this.v24);
      }

      this.v38 = Math.max(0.0F, this.v38);
   }

   private int v1(float var1) {
      this.v5();
      String var2 = this.v7.v1();
      float var3 = var1 - (this.v9 - this.v38);
      if (var3 <= 0.0F) {
         return 0;
      } else {
         int var4 = 0;

         while (var4 < var2.length()) {
            int var5 = var4 + Character.charCount(var2.codePointAt(var4));
            if (var3 < (this.v4(var4) + this.v4(var5)) / 2.0F) {
               return var4;
            }

            var4 = var5;
         }

         return var2.length();
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      return this.v1(var1, var2) && this.v2(var1, var2, var3);
   }

   public boolean v2(float var1, float var2, int var3) {
      if (var3 != 0) {
         return false;
      } else {
         this.v30 = true;
         this.v5();
         long var4 = this.v16.getAsLong();
         boolean var6 = Math.abs(var1 - this.v37) <= 3.0F && Math.abs(var2 - this.v48) <= 3.0F;
         this.v40 = var4 - this.v43 <= 400L && var6 ? this.v40 % 3 + 1 : 1;
         this.v43 = var4;
         this.v37 = var1;
         this.v48 = var2;
         int var7 = this.v44 ? this.v3(var1, var2) : this.v1(var1);
         switch (this.v40) {
            case 2:
               this.v7.v1(var7);
               this.v32 = false;
               break;
            case 3:
               this.v7.v12();
               this.v32 = false;
               break;
            default:
               this.v7.v1(var7, this.v18.getAsBoolean());
               this.v32 = true;
         }

         this.v20();
         return true;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      if (this.v32 && var3 == 0) {
         this.v7.v1(this.v44 ? this.v3(var1, var2) : this.v1(var1), true);
         this.v20();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      if (this.v32 && var3 == 0) {
         this.v32 = false;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return hudSupport54.IBEAM;
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      return this.v32 ? hudSupport54.IBEAM : null;
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v30 && Character.isValidCodePoint(var1) ? this.v4(this.v7.v2(new String(Character.toChars(var1)))) : false;
   }

   @Override
   public boolean v2(int var1, int var2) {
      if (!this.v30) {
         return false;
      } else {
         boolean var3 = v1(var2);
         boolean var4 = (var2 & 1) != 0;
         if (var3 && !var4) {
            switch (var1) {
               case 65:
                  this.v7.v12();
                  return this.v17();
               case 67:
                  this.v19();
                  return true;
               case 86:
                  return this.v4(this.v7.v2(this.v15.v1()));
               case 88:
                  if (this.v31) {
                     return true;
                  }

                  this.v19();
                  return this.v4(this.v7.v11());
            }
         }

         if (this.v44) {
            switch (var1) {
               case 257:
               case 335:
                  if (var4) {
                     return this.v4(this.v7.v2("\n"));
                  }
                  break;
               case 264:
                  this.v1(1, var4);
                  return true;
               case 265:
                  this.v1(-1, var4);
                  return true;
               case 268:
                  if (var3) {
                     this.v7.v4(var4);
                  } else {
                     this.v7.v1(this.v46[this.v3(this.v7.v4())], var4);
                  }

                  return this.v17();
               case 269:
                  if (var3) {
                     this.v7.v5(var4);
                  } else {
                     int var5 = this.v3(this.v7.v4());
                     int var6 = this.v51[var5];
                     this.v7.v1(var5 + 1 < this.v50 && this.v46[var5 + 1] == var6 && var6 > this.v46[var5] ? var6 - 1 : var6, var4);
                  }

                  return this.v17();
            }
         }

         switch (var1) {
            case 257:
            case 335:
               this.v3(false);
               return true;
            case 259:
               return this.v4(this.v7.v2(var3));
            case 261:
               return this.v4(this.v7.v3(var3));
            case 262:
               this.v7.v2(var3, var4);
               return this.v17();
            case 263:
               this.v7.v1(var3, var4);
               return this.v17();
            case 268:
               this.v7.v4(var4);
               return this.v17();
            case 269:
               this.v7.v5(var4);
               return this.v17();
            default:
               return false;
         }
      }
   }

   private void v19() {
      if (this.v7.v7() && !this.v31) {
         this.v15.v1(this.v7.v10());
      }
   }

   private boolean v17() {
      this.v20();
      return true;
   }

   private boolean v4(boolean var1) {
      this.v20();
      if (var1 && this.v13 != null) {
         this.v13.accept(this.v7.v1());
      }

      return true;
   }

   private void v20() {
      this.v42 = this.v16.getAsLong();
      this.v64 = -1.0F;
   }

   private static long v21() {
      return System.nanoTime() / 1000000L;
   }

   private static boolean v22() {
      class_310 var0 = class_310.method_1551();
      return var0 != null && var0.method_22683() != null
         ? class_3675.method_15987(var0.method_22683(), 340) || class_3675.method_15987(var0.method_22683(), 344)
         : false;
   }

   public void v1(MsdfFont.Part1 var1) {
      this.v14 = var1;
      this.v33 = -1;
   }

   public void v1(MsdfFont.Part3 var1) {
      this.v15 = var1;
   }

   public void v1(LongSupplier var1) {
      this.v16 = var1;
   }

   public void v1(BooleanSupplier var1) {
      this.v18 = var1;
   }

   public fontSupport v7() {
      return this.v7;
   }

   public float v8() {
      return this.v38;
   }

   public interface Part1 {
      void prefixWidths(String var1, float[] var2);
   }

   public static enum Part2 implements MsdfFont.Part3 {
      INSTANCE;

      private Part2() {
      }

      @Override
      public String v1() {
         class_310 var1 = class_310.method_1551();
         if (var1 != null && var1.field_1774 != null) {
            String var2 = var1.field_1774.method_1460();
            return var2 == null ? "" : var2;
         } else {
            return "";
         }
      }

      @Override
      public void v1(String var1) {
         class_310 var2 = class_310.method_1551();
         if (var2 != null && var2.field_1774 != null) {
            var2.field_1774.method_1455(var1);
         }
      }
   }

   public interface Part3 {
      String v1();

      void v1(String var1);
   }
}
