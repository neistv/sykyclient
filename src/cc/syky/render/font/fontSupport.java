package cc.syky.render.font;

import org.jetbrains.annotations.Nullable;

public final class fontSupport {
   private static final int v1 = 127;
   private final StringBuilder v2 = new StringBuilder();
   private final int v3;
   private boolean v4;
   private int v5;
   private int v6;
   private int v7;
   @Nullable
   private String v8 = "";

   public fontSupport(int var1) {
      if (var1 <= 0) {
         throw new IllegalArgumentException("maxCodepoints must be positive: " + var1);
      } else {
         this.v3 = var1;
      }
   }

   public void v1(boolean var1) {
      this.v4 = var1;
   }

   public String v1() {
      if (this.v8 == null) {
         this.v8 = this.v2.toString();
      }

      return this.v8;
   }

   public int v2() {
      return this.v2.length();
   }

   public boolean v3() {
      return this.v2.length() == 0;
   }

   public int v4() {
      return this.v5;
   }

   public int v5() {
      return this.v6;
   }

   public int v6() {
      return this.v7;
   }

   public boolean v7() {
      return this.v5 != this.v6;
   }

   public int v8() {
      return Math.min(this.v5, this.v6);
   }

   public int v9() {
      return Math.max(this.v5, this.v6);
   }

   public String v10() {
      return this.v7() ? this.v2.substring(this.v8(), this.v9()) : "";
   }

   public boolean v1(String var1) {
      String var2 = v1(this.v4(var1), this.v3);
      if (var2.contentEquals(this.v2)) {
         return false;
      } else {
         this.v2.setLength(0);
         this.v2.append(var2);
         this.v5 = this.v2.length();
         this.v6 = this.v5;
         this.v15();
         return true;
      }
   }

   public boolean v2(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         String var2 = this.v4(var1);
         boolean var3 = this.v14();
         if (!var2.isEmpty()) {
            String var4 = v1(var2, this.v3 - this.v16());
            if (!var4.isEmpty()) {
               this.v2.insert(this.v5, var4);
               this.v5 = this.v5 + var4.length();
               this.v6 = this.v5;
               var3 = true;
            }
         }

         if (var3) {
            this.v15();
         }

         return var3;
      } else {
         return false;
      }
   }

   public boolean v2(boolean var1) {
      if (this.v14()) {
         this.v15();
         return true;
      } else if (this.v5 == 0) {
         return false;
      } else {
         int var2 = var1 ? this.v3(this.v5) : this.v2.offsetByCodePoints(this.v5, -1);
         this.v2.delete(var2, this.v5);
         this.v5 = var2;
         this.v6 = var2;
         this.v15();
         return true;
      }
   }

   public boolean v3(boolean var1) {
      if (this.v14()) {
         this.v15();
         return true;
      } else if (this.v5 >= this.v2.length()) {
         return false;
      } else {
         int var2 = var1 ? this.v4(this.v5) : this.v2.offsetByCodePoints(this.v5, 1);
         this.v2.delete(this.v5, var2);
         this.v6 = this.v5;
         this.v15();
         return true;
      }
   }

   public boolean v11() {
      if (!this.v14()) {
         return false;
      } else {
         this.v15();
         return true;
      }
   }

   public void v1(boolean var1, boolean var2) {
      if (!var2 && this.v7()) {
         this.v5 = this.v8();
         this.v6 = this.v5;
      } else {
         int var3 = this.v5 == 0 ? 0 : (var1 ? this.v3(this.v5) : this.v2.offsetByCodePoints(this.v5, -1));
         this.v2(var3, var2);
      }
   }

   public void v2(boolean var1, boolean var2) {
      if (!var2 && this.v7()) {
         this.v5 = this.v9();
         this.v6 = this.v5;
      } else {
         int var3 = this.v2.length();
         int var4 = this.v5 >= var3 ? var3 : (var1 ? this.v4(this.v5) : this.v2.offsetByCodePoints(this.v5, 1));
         this.v2(var4, var2);
      }
   }

   public void v4(boolean var1) {
      this.v2(0, var1);
   }

   public void v5(boolean var1) {
      this.v2(this.v2.length(), var1);
   }

   public void v1(int var1, boolean var2) {
      this.v2(this.v6(this.v5(var1)), var2);
   }

   public void v12() {
      this.v6 = 0;
      this.v5 = this.v2.length();
   }

   public void v13() {
      this.v6 = this.v5;
   }

   public void v1(int var1) {
      int var2 = this.v2.length();
      if (var2 == 0) {
         this.v5 = 0;
         this.v6 = 0;
      } else {
         int var3 = this.v5(var1);
         if (var3 == var2 || var3 > 0 && this.v2(var3) && !this.v2(var3 - 1)) {
            var3--;
         }

         boolean var4 = this.v2(var3);
         int var5 = var3;
         int var6 = var3;

         while (var5 > 0 && this.v2(var5 - 1) == var4) {
            var5--;
         }

         while (var6 < var2 && this.v2(var6) == var4) {
            var6++;
         }

         this.v6 = var5;
         this.v5 = var6;
      }
   }

   private void v2(int var1, boolean var2) {
      this.v5 = var1;
      if (!var2) {
         this.v6 = var1;
      }
   }

   private boolean v14() {
      if (!this.v7()) {
         return false;
      } else {
         int var1 = this.v8();
         this.v2.delete(var1, this.v9());
         this.v5 = var1;
         this.v6 = var1;
         return true;
      }
   }

   private void v15() {
      this.v7++;
      this.v8 = null;
   }

   private int v16() {
      return this.v2.codePointCount(0, this.v2.length());
   }

   private boolean v2(int var1) {
      return Character.isWhitespace(this.v2.charAt(var1));
   }

   private int v3(int var1) {
      int var2 = var1;

      while (var2 > 0 && this.v2(var2 - 1)) {
         var2--;
      }

      while (var2 > 0 && !this.v2(var2 - 1)) {
         var2--;
      }

      return var2;
   }

   private int v4(int var1) {
      int var2 = this.v2.length();
      int var3 = var1;

      while (var3 < var2 && this.v2(var3)) {
         var3++;
      }

      while (var3 < var2 && !this.v2(var3)) {
         var3++;
      }

      return var3;
   }

   private int v5(int var1) {
      return Math.max(0, Math.min(var1, this.v2.length()));
   }

   private int v6(int var1) {
      return var1 > 0 && var1 < this.v2.length() && Character.isLowSurrogate(this.v2.charAt(var1)) && Character.isHighSurrogate(this.v2.charAt(var1 - 1))
         ? var1 - 1
         : var1;
   }

   private String v4(String var1) {
      if (this.v4 && var1 != null && (var1.indexOf(13) >= 0 || var1.indexOf(10) >= 0)) {
         String[] var2 = var1.replace("\r\n", "\n").replace('\r', '\n').split("\n", -1);
         StringBuilder var3 = new StringBuilder(var1.length());

         for (int var4 = 0; var4 < var2.length; var4++) {
            if (var4 > 0) {
               var3.append('\n');
            }

            var3.append(v3(var2[var4]));
         }

         return var3.toString();
      } else {
         return v3(var1);
      }
   }

   public static String v3(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = null;
         int var2 = 0;

         while (var2 < var0.length()) {
            int var3 = var0.codePointAt(var2);
            int var4 = Character.charCount(var3);
            boolean var5 = var3 >= 32 && var3 != 127 && (var3 > 65535 || !Character.isSurrogate((char)var3));
            if (!var5 && var1 == null) {
               var1 = new StringBuilder(var0.length());
               var1.append(var0, 0, var2);
            } else if (var5 && var1 != null) {
               var1.appendCodePoint(var3);
            }

            var2 += var4;
         }

         return var1 == null ? var0 : var1.toString();
      } else {
         return "";
      }
   }

   private static String v1(String var0, int var1) {
      if (var1 > 0 && !var0.isEmpty()) {
         return var0.codePointCount(0, var0.length()) <= var1 ? var0 : var0.substring(0, var0.offsetByCodePoints(0, var1));
      } else {
         return "";
      }
   }
}
