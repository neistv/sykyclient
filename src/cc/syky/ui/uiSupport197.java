package cc.syky.ui;

import java.util.Map;

public final class uiSupport197 {
   public static final uiSupport197 v1 = new uiSupport197(Map.of());
   private final Map<Character, Character> v2;

   private uiSupport197(Map<Character, Character> var1) {
      this.v2 = var1;
   }

   public static uiSupport197 v1(Map<Character, Character> var0) {
      return var0.isEmpty() ? v1 : new uiSupport197(Map.copyOf(var0));
   }

   public boolean v1() {
      return this.v2.isEmpty();
   }

   public String v1(String var1) {
      if (this.v2.isEmpty()) {
         return var1;
      } else {
         StringBuilder var2 = null;

         for (int var3 = 0; var3 < var1.length(); var3++) {
            char var4 = var1.charAt(var3);
            char var5 = this.v1(var4);
            if (var5 == var4) {
               if (var2 != null) {
                  var2.append(var4);
               }
            } else {
               if (var2 == null) {
                  var2 = new StringBuilder(var1.length()).append(var1, 0, var3);
               }

               var2.append(var5);
            }
         }

         return var2 == null ? var1 : var2.toString();
      }
   }

   private char v1(char var1) {
      Character var2 = this.v2.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         char var3 = Character.toLowerCase(var1);
         if (var3 == var1) {
            return var1;
         } else {
            Character var4 = this.v2.get(var3);
            return var4 == null ? var1 : Character.toUpperCase(var4);
         }
      }
   }
}
