package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.config.EnumSetting;
import cc.syky.config.IntSetting;
import cc.syky.module.visual.visualSupport6;
import cc.syky.ui.uiRecord4;
import cc.syky.ui.uiSupport169;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_746;
import net.minecraft.class_9334;

public final class DurabilityAlertSupport extends hudSupport21<uiRecord4> {
   public static final String v2 = "durability_alert";
   private static final OffHandSupport.Part1[] v6 = OffHandSupport.Part1.values();
   private static final class_1304[] v7 = new class_1304[]{
      class_1304.field_6173,
      class_1304.field_6171,
      class_1304.field_6169,
      class_1304.field_6174,
      class_1304.field_6174,
      class_1304.field_6172,
      class_1304.field_6166
   };
   private static final int v8 = 5;
   private static final Object v9 = new Object();
   private static final uiRecord4 v10 = new uiRecord4(null, class_1799.field_8037, "Durability Alert", 0, 0, "");
   private static final AtomicInteger v11 = new AtomicInteger();
   private final cloudSupport101 v12;
   private final visualSupport6<OffHandSupport.Part1> v13;
   private final IntSetting v14;
   private final EnumSetting<PercentSupport> v15;
   private final uiRecord4[] v16 = new uiRecord4[v6.length];
   private List<uiRecord4> v18 = List.of();
   private final List<uiRecord4> v19 = new ArrayList<>(v6.length);
   private static final int v17 = 2 * v6.length;
   private final hudSupport13 v20 = new hudSupport13("durability_alert", v17);
   private final class_1799[] v21 = new class_1799[v17];
   private final uiRecord4[] v22 = new uiRecord4[v17];
   private boolean v24;
   private final float[][] v25 = new float[PercentSupport.values().length][5];
   private float v26 = -1.0F;
   private final hudSupport16.Part1 v27 = new hudSupport16.Part1();
   private final StringBuilder v28 = new StringBuilder(6);

   public static void v40() {
      v11.incrementAndGet();
   }

   public DurabilityAlertSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("durability_alert", 11, var2, var3, var4, DurabilityAlertSupport::v3);
      this.v12 = var1;
      AutoSupport var5 = this.v2();
      this.v13 = var5.v1(new visualSupport6<>("pieces", OffHandSupport.Part1.class, EnumSet.allOf(OffHandSupport.Part1.class)));
      this.v14 = var5.v1(new IntSetting("warnAt", 25, 1, 100).v1("%"));
      this.v15 = var5.v1(new EnumSetting<>("readout", PercentSupport.PERCENT));
      Arrays.fill(this.v21, class_1799.field_8037);
   }

   private static Object v3(uiRecord4 var0) {
      OffHandSupport.Part1 var1 = var0.v2();
      return var1 == null ? v9 : var1;
   }

   @Override
   public List<uiRecord4> v15(hudSupport40 var1) {
      class_746 var2 = this.v12.v2();
      EnumSet var3 = this.v13.v9();
      int var4 = this.v14.getValue();
      boolean var5 = false;

      for (OffHandSupport.Part1 var9 : v6) {
         int var10 = var9.ordinal();
         class_1799 var11 = var2 != null && var3.contains(var9) ? var2.method_6118(v7[var10]) : class_1799.field_8037;
         if (!v1(var9, var11)) {
            var11 = class_1799.field_8037;
         }

         uiRecord4 var12 = this.v16[var10];
         if (!v1(var11, var4)) {
            if (var12 != null) {
               this.v16[var10] = null;
               var5 = true;
            }
         } else if (var12 == null || !class_1799.method_7973(var12.v3(), var11)) {
            this.v16[var10] = uiRecord4.v1(var9, var11);
            var5 = true;
         }
      }

      if (var5) {
         this.v19.clear();

         for (uiRecord4 var16 : this.v16) {
            if (var16 != null) {
               this.v19.add(var16);
            }
         }

         this.v18 = this.v19.isEmpty() ? List.of() : List.copyOf(this.v19);
      }

      return this.v18;
   }

   private static boolean v1(OffHandSupport.Part1 var0, class_1799 var1) {
      return switch (var0) {
         case CHESTPLATE -> !var1.method_57826(class_9334.field_54197);
         case ELYTRA -> var1.method_57826(class_9334.field_54197);
         default -> true;
      };
   }

   private static boolean v1(class_1799 var0, int var1) {
      if (!var0.method_7960() && var0.method_7963()) {
         int var2 = var0.method_7936();
         return OffHandSupport.v1(PercentSupport.v1(var0.method_7919(), var2), var2, var1);
      } else {
         return false;
      }
   }

   public uiRecord4 v59() {
      return v10;
   }

   public boolean v1(uiRecord4 var1, uiRecord4 var2) {
      return v4(var1) < v4(var2);
   }

   private static int v4(uiRecord4 var0) {
      OffHandSupport.Part1 var1 = var0.v2();
      return var1 == null ? Integer.MAX_VALUE : var1.ordinal();
   }

   public String v1(uiRecord4 var1) {
      return var1.v4();
   }

   public String v2(uiRecord4 var1) {
      return this.v15.getValue() == PercentSupport.PERCENT ? OffHandSupport.v1(var1.v1()) : var1.v7();
   }

   public float v1(uiRecord4 var1, float var2) {
      if (var2 != this.v26) {
         this.v26 = var2;

         for (float[] var6 : this.v25) {
            Arrays.fill(var6, 0.0F);
         }
      }

      PercentSupport var10 = this.v15.getValue();
      boolean var11 = var10 == PercentSupport.PERCENT;
      int var12 = Math.min(OffHandSupport.v2(var11 ? var1.v1() : var1.v5()), 5);
      float[] var13 = this.v25[var10.ordinal()];
      float var7 = var13[var12 - 1];
      if (var7 > 0.0F) {
         return var7;
      } else {
         String var8 = this.v27.v1(var2);
         this.v28.setLength(0);

         for (int var9 = 0; var9 < var12; var9++) {
            this.v28.append(var8);
         }

         if (var11) {
            this.v28.append('%');
         }

         var7 = uiSupport169.v2("syky_sans_strong", this.v28.toString(), var2);
         var13[var12 - 1] = var7;
         return var7;
      }
   }

   @Override
   public void v4(hudSupport40 var1, float var2) {
      super.v4(var1, var2);
      Arrays.fill(this.v21, class_1799.field_8037);
      Arrays.fill(this.v22, null);
      boolean var3 = false;

      for (int var4 = 0; var4 < this.v46(); var4++) {
         var3 |= this.v1(this.v3(var4), 0);
         uiRecord4 var5 = this.v4(var4);
         if (var5 != null) {
            this.v1(var5, v6.length);
         }
      }

      if (!var3) {
         this.v24 = false;
      } else {
         this.v20.v1(v17, 18.0F, this.v9(hudSupport13.v1(var1, var2)), v11.get());

         for (int var6 = 0; var6 < v17; var6++) {
            this.v20.v1(var6, this.v21[var6]);
         }

         this.v24 = this.v20.v1() != null;
      }
   }

   private boolean v1(uiRecord4 var1, int var2) {
      OffHandSupport.Part1 var3 = var1.v2();
      if (var3 == null) {
         return false;
      } else {
         int var4 = var2 + var3.ordinal();
         this.v21[var4] = var1.v3();
         this.v22[var4] = var1;
         return true;
      }
   }

   public void v1(uiRecord4 var1, float var2, float var3, float var4, float var5, float var6) {
      OffHandSupport.Part1 var7 = var1.v2();
      if (var7 != null && this.v24) {
         int var8 = this.v22[var7.ordinal() + v6.length] == var1 ? var7.ordinal() + v6.length : var7.ordinal();
         this.v1(this.v20, var8, var2, var3, var4, var5, var6);
      }
   }

   @Override
   public void v49() {
      Arrays.fill(this.v16, null);
      Arrays.fill(this.v21, class_1799.field_8037);
      Arrays.fill(this.v22, null);
      this.v18 = List.of();
      this.v19.clear();
      this.v24 = false;
   }
}
