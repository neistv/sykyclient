package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.ui.uiSupport18;
import net.minecraft.class_12206;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.jetbrains.annotations.Nullable;

public final class SleepNowSupport extends CopiedSupport {
   public static final String v2 = "game_clock";
   private static final String v3 = "Sleep now";
   private static final int v4 = 1;
   private static final int v5 = 2;
   private static final int v6 = 4;
   private static final int v7 = 8;
   private static final int v8 = 0;
   private static final int v9 = 2;
   private static final int v10 = 4;
   private static final long v11 = Long.MIN_VALUE;
   private static final int v12 = 20;
   private final cloudSupport101 v13;
   private final EnumSetting<HHMmSupport.Part1> v14;
   private final BooleanSetting v15;
   private final BooleanSetting v16;
   private final IntSetting v18;
   private final uiSupport18 v19 = new uiSupport18();
   private long v17 = Long.MIN_VALUE;
   private int v20 = -1;
   private int v21 = 0;
   private long v22 = Long.MIN_VALUE;
   private long v24 = Long.MIN_VALUE;
   private long v25;
   private int v26 = -1;
   private long v27 = Long.MIN_VALUE;
   private long v28 = Long.MIN_VALUE;
   private boolean v29;
   private int v30 = -1;
   @Nullable
   private String v32;
   private int v23 = -1;
   @Nullable
   private String v33;
   private long v31;

   public SleepNowSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("game_clock", hudSupport49.v4, HHMmSupport.v3, var2, var3, var4);
      this.v13 = var1;
      this.v14 = this.v2().v1(new EnumSetting<>("format", HHMmSupport.Part1.TWENTY_FOUR_HOUR));
      this.v15 = this.v2().v1(new BooleanSetting("phase", false));
      this.v16 = this.v2().v1(new BooleanSetting("sleepTimer", true));
      this.v18 = this.v2().v1(new IntSetting("showBefore", 3, 1, 10).v1("min"), SettingCondition.v1(this.v16));
   }

   @Override
   public Object v40() {
      return this.v46();
   }

   private int v46() {
      return (this.v14.getValue() == HHMmSupport.Part1.TWELVE_HOUR ? 1 : 0) | (this.v15.getValue() ? 8 : 0) | this.v3(this.v50());
   }

   private int v51() {
      return this.v47() instanceof Integer var1 ? var1 : this.v46();
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      class_638 var2 = this.v50();
      if (var2 == null) {
         return null;
      } else {
         return (this.v51() & 8) != 0 ? SleepInSupport.v2(v2(var2)) : this.v1(var2);
      }
   }

   @Override
   public void v1(cloudSupport2 var1, CopiedSupport.Part1 var2) {
      int var3 = this.v51();
      if ((var3 & 8) != 0) {
         class_638 var4 = this.v50();
         if (var4 != null) {
            var2.v1(this.v1(var4));
         }
      }

      if ((var3 & 4) != 0) {
         var2.v1("Sleep now");
      } else if ((var3 & 2) != 0 && this.v32 != null) {
         var2.v1(this.v32);
      }
   }

   private String v1(class_638 var1) {
      boolean var2 = (this.v51() & 1) != 0;
      int var3 = SleepInSupport.v1(v2(var1)) * 2 + (var2 ? 1 : 0);
      String var4 = this.v33;
      if (var3 != this.v23 || var4 == null) {
         this.v23 = var3;
         var4 = SleepInSupport.v1(var3 / 2, var2);
         this.v33 = var4;
      }

      return var4;
   }

   @Nullable
   private class_638 v50() {
      class_310 var1 = this.v13.v1();
      return var1 == null ? null : var1.field_1687;
   }

   private static long v2(class_638 var0) {
      return var0.method_28104().method_217();
   }

   private int v3(@Nullable class_638 var1) {
      if (var1 == null) {
         this.v19.v1();
         this.v21 = 0;
         return 0;
      } else {
         long var2 = var1.method_75260();
         boolean var4 = this.v10() || !this.v18().v2();
         int var5 = (this.v16.getValue() ? 1 : 0) | this.v18.getValue() << 1 | (var4 ? 65536 : 0);
         if (var2 == this.v17 && var5 == this.v20) {
            return this.v21;
         } else {
            this.v17 = var2;
            this.v20 = var5;
            this.v21 = this.v1(var1, var2, var4);
            if (this.v21 == 2) {
               this.v4(var1);
            }

            return this.v21;
         }
      }
   }

   private int v1(class_638 var1, long var2, boolean var4) {
      long var5 = v2(var1);
      if (var2 != this.v28) {
         this.v29 = this.v28 != Long.MIN_VALUE && var5 == this.v27;
         this.v28 = var2;
         this.v27 = var5;
      }

      if (this.v16.getValue() && !var1.method_8597().comp_5219() && var4) {
         this.v31++;
         float var7 = (Float)var1.method_75728().method_75694(class_12206.field_64348);
         if (!this.v19.v1(var1)) {
            return SleepInSupport.v1(var7) ? 4 : 0;
         } else {
            float var8 = SleepInSupport.v1(this.v19.v1(var1.method_8532()), var7);
            if (SleepInSupport.v1(SleepInSupport.v2(this.v19.v1(var5), var8))) {
               return 4;
            } else {
               float var9 = var1.method_54719().method_54748();
               if (!this.v29 && !var1.method_54719().method_54754()) {
                  boolean var10 = var5 < this.v25;
                  if (this.v24 == Long.MIN_VALUE || var2 - this.v24 >= 20L || var2 < this.v24 || var10 || this.v20 != this.v26) {
                     this.v24 = var2;
                     this.v25 = var5;
                     this.v26 = this.v20;
                     long var11 = (long)((float)(this.v18.getValue().intValue() * 60L) * var9);
                     long var13 = SleepInSupport.v1(this.v19, var5, var8, var11);
                     this.v22 = var13 < 0L ? Long.MIN_VALUE : var5 + var13;
                  }

                  return this.v22 != Long.MIN_VALUE && this.v22 > var5 ? 2 : 0;
               } else {
                  return 0;
               }
            }
         }
      } else {
         return 0;
      }
   }

   private void v4(class_638 var1) {
      int var2 = SleepInSupport.v1(this.v22 - v2(var1), var1.method_54719().method_54748());
      if (var2 != this.v30 || this.v32 == null) {
         this.v30 = var2;
         this.v32 = SleepInSupport.v1(var2);
      }
   }

   public long v49() {
      return this.v31;
   }
}
