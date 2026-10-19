package cc.syky.hud;

import cc.syky.cloud.cloudSupport11;
import cc.syky.cloud.cloudSupport6;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.IntSetting;
import cc.syky.ui.uiSupport24;

public final class MyComboSupport extends AbstractHudWidget {
   public static final String v2 = "combo";
   private static final String v3 = "Combo";
   private static final String v4 = "Enemy";
   private static final String v5 = " – ";
   private static final long v6 = 1000000000L;
   private final EnumSetting<MyComboSupport.Part2> v7;
   private final BooleanSetting v8;
   private final BooleanSetting v9;
   private final IntSetting v10;
   private final MyComboSupport.Part3 v11 = new MyComboSupport.Part3("Combo");
   private final MyComboSupport.Part3 v12 = new MyComboSupport.Part3("Enemy");
   private final cloudSupport11 v13 = new cloudSupport11();
   private final cloudSupport11 v14 = new cloudSupport11();
   private int v15;
   private int v16;
   private int v18;
   private int v19;
   private boolean v17;
   private boolean v20;
   private boolean v21;
   private MyComboSupport.Part1 v22 = new MyComboSupport.Part1(MyComboSupport.Part2.MINE, true);

   public MyComboSupport(hudSupport52 var1, float var2, float var3) {
      super("combo", 43, var1, var2, var3);
      AutoSupport var4 = this.v2();
      this.v7 = var4.v1(new EnumSetting<>("show", MyComboSupport.Part2.MINE));
      this.v8 = var4.v1(new BooleanSetting("label", true));
      this.v9 = var4.v1(new BooleanSetting("forgiveOneHit", false));
      this.v10 = var4.v1(new IntSetting("resetAfter", 8, 1, 60).v1("s"));
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      cloudSupport6 var2 = var1.v6().v24();
      var2.v2(this.v10.getValue().intValue() * 1000000000L);
      boolean var3 = this.v9.getValue();
      MyComboSupport.Part2 var4 = this.v7.getValue();
      boolean var5 = var1.v7();
      return !v1(var4, MyComboSupport.Part2.THEIRS, var2.v1(var3), var5) && !v1(var4, MyComboSupport.Part2.MINE, var2.v2(var3), var5);
   }

   private static boolean v1(MyComboSupport.Part2 var0, MyComboSupport.Part2 var1, int var2, boolean var3) {
      return var0 != var1 && (var2 > 0 || var3);
   }

   @Override
   public void v17() {
      this.v17 = false;
   }

   @Override
   public Object v1(hudSupport40 var1) {
      MyComboSupport.Part1 var2 = this.v22;
      if (var2.v1() == this.v7.getValue() && var2.v2() == this.v8.getValue()) {
         return var2;
      } else {
         this.v22 = new MyComboSupport.Part1(this.v7.getValue(), this.v8.getValue());
         return this.v22;
      }
   }

   private MyComboSupport.Part1 v40() {
      return this.v22() instanceof MyComboSupport.Part1 var1 ? var1 : this.v22;
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      this.v15(var1);
      MyComboSupport.Part1 var3 = this.v40();
      boolean var4 = this.v1(var3);
      boolean var5 = this.v2(var3);
      float var6 = 16.0F * var2;
      float var7 = 0.0F;
      if (var4) {
         var7 += this.v13.v1(this.v11.v1(this.v15, var3.v2()), var6);
      }

      var7 += uiSupport24.v1(var4 && var5, var2);
      if (var5) {
         var7 += this.v14.v1(this.v12.v1(this.v16, var3.v2()), var6);
      }

      return this.v12(uiSupport24.v1(var7, var2), this.v6(36.0F, var2));
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return 18.0F * var3;
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v15(var1);
      MyComboSupport.Part1 var4 = this.v40();
      boolean var5 = this.v1(var4);
      boolean var6 = this.v2(var4);
      float var7 = 16.0F * var3;
      float var8 = var2.v2() + 15.0F * var3;
      float var9 = var2.v3() + 8.0F * var3;
      if (var5) {
         String var10 = this.v11.v1(this.v15, var4.v2());
         this.v1("syky_sans_strong", var10, var8, var9, var7, -1);
         var8 += this.v13.v1(var10, var7);
      }

      if (var5 && var6) {
         this.v1(this.v8(uiSupport24.v2(var8, var3)), var2.v3(), var3);
         var8 += uiSupport24.v1(true, var3);
      }

      if (var6) {
         this.v1("syky_sans_strong", this.v12.v1(this.v16, var4.v2()), var8, var9, var7, -1);
      }
   }

   private boolean v1(MyComboSupport.Part1 var1) {
      return v1(var1.v1(), MyComboSupport.Part2.THEIRS, this.v15, this.v20);
   }

   private boolean v2(MyComboSupport.Part1 var1) {
      return v1(var1.v1(), MyComboSupport.Part2.MINE, this.v16, this.v20);
   }

   private void v15(hudSupport40 var1) {
      cloudSupport6 var2 = var1.v6().v24();
      boolean var3 = this.v9.getValue();
      MyComboSupport.Part2 var4 = this.v7.getValue();
      boolean var5 = var1.v7();
      int var6 = var2.v1(var3);
      int var7 = var2.v2(var3);
      if (v1(var4, MyComboSupport.Part2.THEIRS, var6, var5) || v1(var4, MyComboSupport.Part2.MINE, var7, var5)) {
         this.v18 = var6;
         this.v19 = var7;
         this.v21 = var5;
         this.v17 = true;
         this.v15 = var6;
         this.v16 = var7;
         this.v20 = var5;
      } else if (this.v17 && this.v19()) {
         this.v15 = this.v18;
         this.v16 = this.v19;
         this.v20 = this.v21;
      } else {
         this.v15 = 0;
         this.v16 = 0;
         this.v20 = var5;
      }
   }

   public record Part1(MyComboSupport.Part2 show, boolean label) {
      public MyComboSupport.Part2 v1() {
         return this.show;
      }

      public boolean v2() {
         return this.label;
      }
   }

   public static enum Part2 implements hudSupport64 {
      MINE("My combo"),
      THEIRS("Enemy combo"),
      BOTH("Both");

      private final String label;

      private Part2(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }

   public static final class Part3 {
      private final String v1;
      private String v2 = "";
      private int v3 = -1;
      private boolean v4;

      public Part3(String var1) {
         this.v1 = var1;
      }

      public String v1(int var1, boolean var2) {
         if (var1 == this.v3 && var2 == this.v4) {
            return this.v2;
         } else {
            this.v3 = var1;
            this.v4 = var2;
            StringBuilder var3 = new StringBuilder(16);
            if (var2) {
               var3.append(this.v1).append(" – ");
            }

            var3.append(var1);
            this.v2 = var3.toString();
            return this.v2;
         }
      }
   }
}
