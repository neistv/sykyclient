package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import cc.syky.config.BooleanSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.ui.uiSupport19;
import org.jetbrains.annotations.Nullable;

public final class FPSSupport extends CopiedSupport {
   public static final String v2 = "fps";
   private static final hudRecord2 v3 = new hudRecord2(24.0F, 24.0F, 7.0F, 6.0F, 38.0F, 8.0F);
   private static final int v4 = 1;
   private static final int v5 = 2;
   private static final int v6 = 4;
   private static final int v7 = 8;
   private final BooleanSetting v8;
   private final BooleanSetting v9;
   private final BooleanSetting v10;
   private final BooleanSetting v11;
   private final IntSetting v12;
   private final FloatSetting v13;
   private final uiSupport19 v14 = new uiSupport19();
   private int v15 = Integer.MIN_VALUE;
   private boolean v16;
   @Nullable
   private String v18;
   private int v19 = Integer.MIN_VALUE;
   private boolean v17;
   @Nullable
   private String v20;
   private int v21 = Integer.MIN_VALUE;
   @Nullable
   private String v22;
   private final hudSupport8 v24 = new hudSupport8();
   private final StringBuilder v25 = new StringBuilder(16);

   public FPSSupport(hudSupport52 var1, float var2, float var3) {
      super("fps", hudSupport49.v2, v3, 32, var1, var2, var3);
      this.v8 = this.v2().v1(new BooleanSetting("frameTime", false));
      this.v13 = this.v2().v1(new FloatSetting("updateInterval", 1.0F, 0.5F, 3.0F).setSuffix(" s"));
      this.v9 = this.v2().v1(new BooleanSetting("lowFps", false));
      this.v10 = this.v2().v1(new BooleanSetting("groupDigits", false));
      this.v11 = this.v2().v1(new BooleanSetting("fakeFps", false));
      this.v12 = this.v2().v1(new IntSetting("fakeFpsValue", 1000, 1, 1000000).v13().v1(this.v11));
   }

   @Override
   public Object v40() {
      return this.v49();
   }

   private int v49() {
      return (this.v8.getValue() ? 1 : 0) | (this.v9.getValue() ? 2 : 0) | (this.v10.getValue() ? 4 : 0) | (this.v11.getValue() ? 8 : 0);
   }

   private boolean v3(int var1) {
      int var2 = this.v47() instanceof Integer var3 ? var3 : this.v49();
      return (var2 & var1) != 0;
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      int var2 = this.v14.v1(var1.v14(), var1.v15(), (long)(this.v13.getValue().floatValue() * 1.0E9), var1.v12());
      int var3 = this.v3(8) ? this.v24.v1(var1.v36(), var2, this.v12.getValue()) : var2;
      boolean var4 = this.v3(4);
      if (var3 != this.v15 || var4 != this.v16 || this.v18 == null) {
         this.v15 = var3;
         this.v16 = var4;
         this.v18 = this.v1(var3, var4) + " FPS";
      }

      return this.v18;
   }

   @Override
   public void v1(cloudSupport2 var1, CopiedSupport.Part1 var2) {
      if (this.v3(2)) {
         String var3 = this.v3(var1);
         if (var3 != null) {
            var2.v1(var3);
         }
      }

      if (this.v3(1)) {
         var2.v1(this.v4(var1));
      }
   }

   @Nullable
   private String v3(cloudSupport2 var1) {
      int var2 = var1.v18();
      if (var2 <= 0) {
         return null;
      } else {
         boolean var3 = this.v3(4);
         if (var2 != this.v19 || var3 != this.v17 || this.v20 == null) {
            this.v19 = var2;
            this.v17 = var3;
            this.v20 = "1% " + this.v1(var2, var3);
         }

         return this.v20;
      }
   }

   private String v4(cloudSupport2 var1) {
      int var2 = (int)Math.round(var1.v16() * 10.0);
      if (var2 != this.v21 || this.v22 == null) {
         this.v21 = var2;
         this.v25.setLength(0);
         hudSupport19.v1(this.v25, var2 / 10);
         this.v25.append('.').append(var2 % 10).append(" ms");
         this.v22 = this.v25.toString();
      }

      return this.v22;
   }

   private String v1(int var1, boolean var2) {
      return var2 ? hudSupport19.v1(var1) : Integer.toString(var1);
   }
}
