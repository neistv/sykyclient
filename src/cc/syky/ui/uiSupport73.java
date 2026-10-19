package cc.syky.ui;

import java.util.List;
import org.jetbrains.annotations.Nullable;

public final class uiSupport73 extends uiSupport80 {
   private static final float v1 = 180.0F;
   private static final String v2 = "no files — .syky sounds open";
   private final uiSupport149 v3;
   private final String[] v4;
   private final String[] v5;

   public uiSupport73(uiSupport149 var1, float var2) {
      this(var1, var1.v1(), var2);
   }

   private uiSupport73(uiSupport149 var1, List<String> var2, float var3) {
      super(new uiSupport71(var2.size()), var2.size(), var3);
      this.v3 = var1;
      this.v4 = var2.toArray(new String[0]);
      this.v5 = new String[this.v4.length];

      for (int var4 = 0; var4 < this.v4.length; var4++) {
         this.v5[var4] = v1(this.v4[var4]);
      }
   }

   @Override
   public String v1(int var1) {
      return this.v5[var1];
   }

   @Override
   public boolean v2(int var1) {
      return this.v3.v1(this.v4[var1]);
   }

   @Override
   public void v3(int var1) {
      this.v3.v2(this.v4[var1]);
      uiSupport148.v1(uiSupport146.v1(this.v3.v1(this.v4[var1])));
   }

   @Nullable
   @Override
   public String v2() {
      return "no files — .syky sounds open";
   }

   private static String v1(String var0) {
      if (uiSupport169.v2("syky_sans_strong", var0, 18.0F) <= 180.0F) {
         return var0;
      } else {
         String var1 = var0;

         while (var1.length() > 1 && uiSupport169.v2("syky_sans_strong", var1 + "…", 18.0F) > 180.0F) {
            var1 = var1.substring(0, var1.length() - 1);
         }

         return var1 + "…";
      }
   }
}
