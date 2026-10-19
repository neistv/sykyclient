package cc.syky.hud;

import cc.syky.config.EnumSetting;
import cc.syky.config.IntSetting;
import cc.syky.ui.uiRecord3;
import cc.syky.ui.uiSupport13;
import cc.syky.ui.uiSupport169;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_1799;

public final class ItemPickupsSupport extends hudSupport21<uiRecord3> {
   public static final String v2 = "item_pickups";
   private static final long v6 = 1000000000L;
   private static final int v7 = 24;
   private static final int v8 = 10;
   private static final uiRecord3 v9 = new uiRecord3(-1L, class_1799.field_8037, "Item Pickups", "Item Pickups", 0, "", 0L);
   private static final AtomicInteger v10 = new AtomicInteger();
   private final IntSetting v11;
   private final EnumSetting<RealItemSupport> v12;
   private final hudSupport13 v13 = new hudSupport13("item_pickups", 24);
   private final long[] v14 = new long[24];
   private final class_1799[] v15 = new class_1799[24];
   private final boolean[] v16 = new boolean[24];
   private boolean v18;
   private final float[] v19 = new float[10];
   private float v17 = -1.0F;
   private final hudSupport16.Part1 v20 = new hudSupport16.Part1();
   private final StringBuilder v21 = new StringBuilder(11);

   public static void v40() {
      v10.incrementAndGet();
   }

   public ItemPickupsSupport(hudSupport52 var1, float var2, float var3) {
      super("item_pickups", 11, var1, var2, var3, uiRecord3::v1);
      AutoSupport var4 = this.v2();
      this.v11 = var4.v1(new IntSetting("holdFor", 4, 1, 15).v1("s"));
      this.v12 = var4.v1(new EnumSetting<>("name", RealItemSupport.CUSTOM));
      Arrays.fill(this.v14, -1L);
      Arrays.fill(this.v15, class_1799.field_8037);
   }

   @Override
   public List<uiRecord3> v15(hudSupport40 var1) {
      uiSupport13 var2 = var1.v6().v26();
      var2.v1(this.v11.getValue().intValue() * 1000000000L);
      return var2.v1();
   }

   public uiRecord3 v59() {
      return v9;
   }

   public boolean v1(uiRecord3 var1, uiRecord3 var2) {
      return var1.v1() > var2.v1();
   }

   public String v1(uiRecord3 var1) {
      return this.v12.getValue() == RealItemSupport.REAL ? var1.v4() : var1.v3();
   }

   public String v2(uiRecord3 var1) {
      return var1.v6();
   }

   public float v1(uiRecord3 var1, float var2) {
      if (var2 != this.v17) {
         this.v17 = var2;
         Arrays.fill(this.v19, 0.0F);
      }

      int var3 = Math.min(Math.max(1, v5(var1.v5())), 10);
      float var4 = this.v19[var3 - 1];
      if (var4 > 0.0F) {
         return var4;
      } else {
         String var5 = this.v20.v1(var2);
         this.v21.setLength(0);
         this.v21.append("x");

         for (int var6 = 0; var6 < var3; var6++) {
            this.v21.append(var5);
         }

         var4 = uiSupport169.v2("syky_sans_strong", this.v21.toString(), var2);
         this.v19[var3 - 1] = var4;
         return var4;
      }
   }

   private static int v5(int var0) {
      int var1 = 1;

      for (int var2 = var0; var2 >= 10; var2 /= 10) {
         var1++;
      }

      return var1;
   }

   @Override
   public void v4(hudSupport40 var1, float var2) {
      super.v4(var1, var2);
      Arrays.fill(this.v16, false);
      int var3 = this.v46();

      for (int var4 = 0; var4 < var3; var4++) {
         long var5 = this.v3(var4).v1();
         int var7 = var5 < 0L ? -1 : this.v1(var5);
         if (var7 >= 0) {
            this.v16[var7] = true;
         }
      }

      for (int var8 = 0; var8 < 24; var8++) {
         if (!this.v16[var8]) {
            this.v14[var8] = -1L;
            this.v15[var8] = class_1799.field_8037;
         }
      }

      boolean var9 = false;

      for (int var10 = 0; var10 < var3; var10++) {
         uiRecord3 var6 = this.v3(var10);
         if (var6.v1() >= 0L) {
            int var12 = this.v1(var6.v1());
            if (var12 < 0) {
               var12 = this.v1(-1L);
               if (var12 < 0) {
                  continue;
               }

               this.v14[var12] = var6.v1();
               this.v15[var12] = var6.v2();
            }

            var9 = true;
         }
      }

      if (!var9) {
         this.v18 = false;
      } else {
         this.v13.v1(24, 18.0F, this.v9(hudSupport13.v1(var1, var2)), v10.get());

         for (int var11 = 0; var11 < 24; var11++) {
            this.v13.v1(var11, this.v15[var11]);
         }

         this.v18 = this.v13.v1() != null;
      }
   }

   private int v1(long var1) {
      for (int var3 = 0; var3 < 24; var3++) {
         if (this.v14[var3] == var1) {
            return var3;
         }
      }

      return -1;
   }

   public void v1(uiRecord3 var1, float var2, float var3, float var4, float var5, float var6) {
      if (this.v18 && var1.v1() >= 0L) {
         int var7 = this.v1(var1.v1());
         if (var7 >= 0) {
            this.v1(this.v13, var7, var2, var3, var4, var5, var6);
         }
      }
   }

   @Override
   public void v49() {
      Arrays.fill(this.v14, -1L);
      Arrays.fill(this.v15, class_1799.field_8037);
      this.v18 = false;
   }
}
