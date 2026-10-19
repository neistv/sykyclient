package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import cc.syky.config.BooleanSetting;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport25;

public final class BreakSupport extends AbstractHudWidget {
   public static final String v2 = "break_indicator";
   private static final String v3 = "Break";
   private static final String v4 = " – ";
   private static final String v5 = "∞";
   private static final int v6 = 0;
   private final BooleanSetting v7;
   private long v8;
   private boolean v9;
   private long v10;
   private boolean v11;
   private boolean v12;
   private final StringBuilder v13 = new StringBuilder(24);
   private String v14 = "";
   private long v15 = Long.MIN_VALUE;
   private boolean v16;
   private boolean v18;
   private float v19;
   private int v17 = Integer.MIN_VALUE;
   private boolean v20;
   private float v21;
   private final hudSupport16.Part1 v22 = new hudSupport16.Part1();

   public BreakSupport(hudSupport52 var1, float var2, float var3) {
      super("break_indicator", 11, var1, var2, var3);
      this.v7 = this.v2().v1(new BooleanSetting("label", true));
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      return !var1.v6().v27();
   }

   @Override
   public void v17() {
      this.v12 = false;
   }

   @Override
   public Object v1(hudSupport40 var1) {
      return this.v7.getValue() ? Boolean.TRUE : Boolean.FALSE;
   }

   private boolean v40() {
      return this.v22() instanceof Boolean var1 ? var1 : this.v7.getValue();
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      this.v15(var1);
      float var3 = 16.0F * var2;
      return this.v12(uiSupport25.v1(this.v1(this.v40(), var3), var2), this.v6(36.0F, var2));
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return 18.0F * var3;
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v15(var1);
      this.v1("syky_sans_strong", this.v4(this.v40()), var2.v2() + 15.0F * var3, var2.v3() + 8.0F * var3, 16.0F * var3, -1);
   }

   private void v15(hudSupport40 var1) {
      cloudSupport2 var2 = var1.v6();
      if (var2.v27()) {
         float var3 = var2.v23();
         this.v9 = !Float.isFinite(var3);
         this.v8 = this.v9 ? 0L : Math.max(0L, Math.round(var3 * 10.0));
         this.v11 = this.v9;
         this.v10 = this.v8;
         this.v12 = true;
      } else if (this.v12 && this.v19()) {
         this.v9 = this.v11;
         this.v8 = this.v10;
      } else {
         this.v9 = false;
         this.v8 = 0L;
      }
   }

   private String v4(boolean var1) {
      if (this.v8 == this.v15 && this.v9 == this.v16 && var1 == this.v18) {
         return this.v14;
      } else {
         this.v15 = this.v8;
         this.v16 = this.v9;
         this.v18 = var1;
         this.v13.setLength(0);
         if (var1) {
            this.v13.append("Break").append(" – ");
         }

         if (this.v9) {
            this.v13.append("∞");
         } else {
            hudSupport16.v1(this.v13, this.v8);
         }

         this.v14 = this.v13.toString();
         return this.v14;
      }
   }

   private float v1(boolean var1, float var2) {
      int var3 = this.v9 ? 0 : hudSupport16.v1(this.v8);
      if (var3 != this.v17 || var1 != this.v20 || var2 != this.v21 || !(this.v19 > 0.0F)) {
         this.v17 = var3;
         this.v20 = var1;
         this.v21 = var2;
         this.v19 = uiSupport169.v2("syky_sans_strong", this.v1(var1, var3, var2), var2);
      }

      return this.v19;
   }

   private String v1(boolean var1, int var2, float var3) {
      if (var2 == 0) {
         return this.v4(var1);
      } else {
         String var4 = this.v22.v1(var3);
         this.v13.setLength(0);
         if (var1) {
            this.v13.append("Break").append(" – ");
         }

         hudSupport16.v1(this.v13, var4, var2);
         return this.v13.toString();
      }
   }
}
