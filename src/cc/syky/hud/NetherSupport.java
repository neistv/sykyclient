package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import cc.syky.config.BooleanSetting;
import cc.syky.ui.uiSupport223;
import java.util.Optional;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_5321;
import net.minecraft.class_638;
import org.jetbrains.annotations.Nullable;

public final class NetherSupport extends CopiedSupport {
   public static final String v2 = "coords";
   private static final hudRecord2 v3 = new hudRecord2(24.0F, 24.0F, 6.0F, 6.0F, 40.0F, 8.0F);
   private static final int v4 = 1;
   private static final int v5 = 2;
   private static final int v6 = 8;
   private final cloudSupport101 v7;
   private final BooleanSetting v8;
   private int v9 = Integer.MIN_VALUE;
   private int v10 = Integer.MIN_VALUE;
   private int v11 = Integer.MIN_VALUE;
   private boolean v12;
   @Nullable
   private String v13;
   private final StringBuilder v14 = new StringBuilder(24);
   private int v15 = Integer.MIN_VALUE;
   private int v16;
   private int v18;
   @Nullable
   private String v19;
   @Nullable
   private String v17;
   private final BooleanSetting v20;
   private int v21 = Integer.MIN_VALUE;
   private int v22 = Integer.MIN_VALUE;
   private int v24 = Integer.MIN_VALUE;
   private boolean v25;
   @Nullable
   private String v26;
   @Nullable
   private String v27;

   public NetherSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("coords", hudSupport49.v9, v3, 32, var2, var3, var4);
      this.v7 = var1;
      this.v8 = this.v2().v1(new BooleanSetting("biome", false));
      this.v20 = this.v2().v1(new BooleanSetting("otherDimension", false));
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      class_310 var2 = this.v7.v1();
      if (var2 != null && var2.field_1724 != null) {
         int var3 = class_3532.method_15357(var1.v3());
         int var4 = class_3532.method_15357(var1.v4());
         int var5 = class_3532.method_15357(var1.v5());
         if (var3 != this.v9 || var4 != this.v10 || var5 != this.v11) {
            this.v9 = var3;
            this.v10 = var4;
            this.v11 = var5;
            this.v13 = null;
            this.v12 = true;
         }

         if (uiSupport223.v4) {
            return "Protected";
         } else {
            if (this.v13 == null) {
               this.v14.setLength(0);
               v1(this.v14, var3, var4, var5);
               this.v13 = this.v14.toString();
            }

            return this.v13;
         }
      } else {
         return null;
      }
   }

   @Nullable
   @Override
   public String v44() {
      return this.v12 ? this.v9 + " " + this.v10 + " " + this.v11 : null;
   }

   @Override
   public Object v40() {
      return this.v49();
   }

   private int v49() {
      return (this.v8.getValue() ? 1 : 0) | (this.v20.getValue() ? 2 : 0);
   }

   private boolean v3(int var1) {
      int var2 = this.v47() instanceof Integer var3 ? var3 : this.v49();
      return (var2 & var1) != 0;
   }

   @Override
   public void v1(cloudSupport2 var1, CopiedSupport.Part1 var2) {
      if (!uiSupport223.v4) {
         if (this.v3(1)) {
            String var3 = this.v4(var1);
            if (var3 != null) {
               var2.v1(var3, var3);
            }
         }

         if (this.v3(2)) {
            String var4 = this.v3(var1);
            if (var4 != null) {
               var2.v1(var4, this.v27);
            }
         }
      }
   }

   @Nullable
   private String v3(cloudSupport2 var1) {
      class_310 var2 = this.v7.v1();
      class_638 var3 = var2 == null ? null : var2.field_1687;
      if (var3 == null) {
         return null;
      } else {
         class_5321 var4 = var3.method_27983();
         boolean var5 = var4 == class_1937.field_25180;
         if (!var5 && var4 != class_1937.field_25179) {
            return null;
         } else {
            int var6 = v1(var1.v3(), var5);
            int var7 = class_3532.method_15357(var1.v4());
            int var8 = v1(var1.v5(), var5);
            if (this.v26 == null || var6 != this.v21 || var7 != this.v22 || var8 != this.v24 || var5 != this.v25) {
               this.v21 = var6;
               this.v22 = var7;
               this.v24 = var8;
               this.v25 = var5;
               this.v14.setLength(0);
               v1(this.v14, var5, var6, var7, var8);
               this.v26 = this.v14.toString();
               this.v27 = var6 + " " + var7 + " " + var8;
            }

            return this.v26;
         }
      }
   }

   public static int v1(double var0, boolean var2) {
      return class_3532.method_15357(var2 ? var0 * 8.0 : var0 / 8.0);
   }

   public static void v1(StringBuilder var0, boolean var1, int var2, int var3, int var4) {
      var0.append(var1 ? "Overworld " : "Nether ");
      v1(var0, var2, var3, var4);
   }

   @Nullable
   private String v4(cloudSupport2 var1) {
      int var2 = class_3532.method_15357(var1.v3());
      int var3 = class_3532.method_15357(var1.v4());
      int var4 = class_3532.method_15357(var1.v5());
      if (this.v17 == null || var2 != this.v15 || var3 != this.v16 || var4 != this.v18) {
         this.v15 = var2;
         this.v16 = var3;
         this.v18 = var4;
         this.v1(var2, var3, var4);
      }

      return this.v17;
   }

   private void v1(int var1, int var2, int var3) {
      class_310 var4 = this.v7.v1();
      class_638 var5 = var4 == null ? null : var4.field_1687;
      Optional var6 = var5 == null ? Optional.empty() : var5.method_23753(new class_2338(var1, var2, var3)).method_40230();
      if (var6.isEmpty()) {
         this.v19 = null;
         this.v17 = null;
      } else {
         String var7 = ((class_5321)var6.get()).method_29177().method_12832();
         if (!var7.equals(this.v19)) {
            this.v19 = var7;
            this.v17 = hudSupport9.v1(var7);
         }
      }
   }

   public static void v1(StringBuilder var0, int var1, int var2, int var3) {
      hudSupport19.v1(var0, var1);
      var0.append(' ');
      hudSupport19.v1(var0, var2);
      var0.append(' ');
      hudSupport19.v1(var0, var3);
   }
}
