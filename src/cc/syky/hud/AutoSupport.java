package cc.syky.hud;

import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.Setting;
import cc.syky.config.SettingCondition;
import cc.syky.config.SettingRegistry;
import cc.syky.module.visual.visualSupport6;
import cc.syky.render.renderSupport47;
import com.google.gson.JsonObject;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.function.BooleanSupplier;
import org.jetbrains.annotations.Nullable;

public final class AutoSupport {
   public static final int v1 = 1;
   public static final int v2 = 2;
   public static final int v3 = 4;
   public static final int v4 = 8;
   public static final int v5 = 16;
   public static final int v6 = 32;
   private static final int v12 = 63;
   public static final float v7 = 0.5F;
   public static final float v8 = 4.0F;
   public static final float v9 = 0.25F;
   public static final float v10 = 1.0F;
   public static final String v11 = "scale";
   private static final float v13 = 1080.0F;
   private static final int v14 = 0;
   private final SettingRegistry v15 = new SettingRegistry();
   private final Set<Setting<?>> v16 = Collections.newSetFromMap(new IdentityHashMap<>());
   @Nullable
   private final EnumSetting<AutoSupport.Part1> v18;
   @Nullable
   private final visualSupport6<?> v19;
   @Nullable
   private AutoSupport v17;
   private boolean v20;
   @Nullable
   private AutoSupport.Part1 v21;
   private boolean v22;
   @Nullable
   private final BooleanSetting v24;
   private final FloatSetting v25;
   private float v26 = 1.0F;
   @Nullable
   private final BooleanSetting v27;
   @Nullable
   private final BooleanSetting v28;
   @Nullable
   private final BooleanSetting v29;
   @Nullable
   private final BooleanSetting v30;
   @Nullable
   private final ColorSetting v32;
   @Nullable
   private final EnumSetting<AutoSupport.Part2> v23;
   @Nullable
   private final ColorSetting v33;
   @Nullable
   private final BooleanSetting v31;
   @Nullable
   private final ColorSetting v34;

   public static AutoSupport v1(visualSupport6<?> var0) {
      return new AutoSupport(63, null, var0);
   }

   public AutoSupport(int var1) {
      this(var1, new EnumSetting<>("settings", AutoSupport.Part1.USE_GLOBAL), null);
   }

   private AutoSupport(int var1, @Nullable EnumSetting<AutoSupport.Part1> var2, @Nullable visualSupport6<?> var3) {
      this.v18 = var2 != null ? this.v15.add(var2) : null;
      this.v21 = this.v18 == null ? null : this.v18.getValue();
      if (var3 != null) {
         this.v15.add(var3);
      }

      this.v19 = var3;
      this.v24 = var3 != null ? this.v15.add(new BooleanSetting("overVanilla", true), SettingCondition.v1(var3)) : null;
      this.v25 = this.v3(new FloatSetting("scale", 0.25F, 0.25F, 4.0F).setSnapStop("Auto", 0.5F));
      boolean var4 = v1(var1, 1);
      this.v27 = var4 ? this.v3(new BooleanSetting("blur", true)) : null;
      this.v28 = v1(var1, 8) ? this.v3(new BooleanSetting("vibrancy", true)) : null;
      this.v29 = var4 ? this.v3(new BooleanSetting("shadow", false)) : null;
      BooleanSupplier var5 = v1(var1, 8) ? this::v7 : null;
      this.v33 = v1(var1, 2) ? this.v3(new ColorSetting("mainColor", -1).setCondition(var5)) : null;
      boolean var6 = v1(var1, 16);
      boolean var7 = v1(var1, 32);
      this.v31 = var6 ? this.v3(new BooleanSetting("icon", true)) : null;
      if (!v1(var1, 4) && !var6 && !var7) {
         this.v34 = null;
      } else {
         ColorSetting var8 = new ColorSetting("secondColor", -1).setCondition(var5);
         this.v34 = this.v3(var6 && !var7 ? var8.setCondition(this.v31) : var8);
      }

      this.v30 = var4 ? this.v3(new BooleanSetting("background", true)) : null;
      EnumSetting var9 = var4 ? new EnumSetting<>("backgroundMode", AutoSupport.Part2.FLAT) : null;
      this.v32 = var9 != null ? this.v3(new ColorSetting("backgroundColor", 855638016).setCondition(this.v30).setConditionEnum(var9, this::v20)) : null;
      this.v23 = var9 != null ? this.v3(var9) : null;
   }

   private <T, S extends Setting<T>> S v3(S var1) {
      if (this.v18 != null) {
         return this.v15.add((S)var1, SettingCondition.v1(this.v18, AutoSupport.Part1.CUSTOM));
      } else {
         return this.v19 != null ? this.v15.add((S)var1, SettingCondition.v1(this.v19)) : this.v15.add((S)var1);
      }
   }

   public <T, S extends Setting<T>> S v1(S var1) {
      this.v16.add(var1);
      return this.v15.add((S)var1);
   }

   public <T, S extends Setting<T>> S v1(S var1, SettingCondition var2) {
      this.v16.add(var1);
      return this.v15.add((S)var1, var2);
   }

   public <T, S extends Setting<T>> S v2(S var1) {
      this.v16.add(var1);
      return this.v15.addHidden((S)var1);
   }

   private static boolean v1(int var0, int var1) {
      return (var0 & var1) != 0;
   }

   public void v1(AutoSupport var1) {
      this.v17 = var1;
   }

   public boolean v1() {
      return this.v24 != null && this.v24.getValue();
   }

   private AutoSupport v17() {
      return this.v17 != null && this.v18 != null && this.v18.getValue() == AutoSupport.Part1.USE_GLOBAL ? this.v17 : this;
   }

   public boolean v2() {
      return this.v17() != this;
   }

   public void v3() {
      if (!this.v20 && !this.v22 && this.v17 != null && this.v18 != null) {
         AutoSupport.Part1 var1 = this.v21;
         AutoSupport.Part1 var2 = this.v18.getValue();
         this.v21 = var2;
         if (var2 == AutoSupport.Part1.CUSTOM && var1 != AutoSupport.Part1.CUSTOM) {
            for (Setting var4 : this.v15.all()) {
               if (var4 != this.v18 && !this.v16.contains(var4) && var4.isModified()) {
                  return;
               }
            }

            this.v20 = true;

            try {
               this.v2(this.v17);
            } finally {
               this.v20 = false;
            }
         }
      }
   }

   private void v2(AutoSupport var1) {
      this.v25.setValue(var1.v25.getValue());
      if (this.v27 != null) {
         this.v27.setValue(renderSupport47.v1(var1.v27).getValue());
      }

      if (this.v28 != null) {
         this.v28.setValue(renderSupport47.v1(var1.v28).getValue());
      }

      if (this.v29 != null) {
         this.v29.setValue(renderSupport47.v1(var1.v29).getValue());
      }

      if (this.v33 != null) {
         this.v33.setValue(renderSupport47.v1(var1.v33).getValue());
      }

      if (this.v31 != null) {
         this.v31.setValue(renderSupport47.v1(var1.v31).getValue());
      }

      if (this.v34 != null) {
         this.v34.setValue(renderSupport47.v1(var1.v34).getValue());
      }

      if (this.v30 != null) {
         this.v30.setValue(renderSupport47.v1(var1.v30).getValue());
      }

      if (this.v32 != null) {
         this.v32.setValue(renderSupport47.v1(var1.v32).getValue());
      }

      if (this.v23 != null) {
         this.v23.setValue(renderSupport47.v1(var1.v23).getValue());
      }
   }

   public SettingRegistry v4() {
      return this.v15;
   }

   public float v5() {
      float var1 = this.v17().v25.getValue();
      if (var1 != 0.25F) {
         return var1;
      } else {
         return this.v17 != null ? this.v17.v26 : this.v26;
      }
   }

   public void v1(float var1) {
      this.v25.setValue(var1);
   }

   public boolean v1(int var1) {
      float var2 = v2(var1);
      if (var2 == this.v26) {
         return false;
      } else {
         this.v26 = var2;
         return true;
      }
   }

   public static float v2(int var0) {
      float var1 = Math.round(var0 / 1080.0F * 2.0F) / 2.0F;
      return Math.max(1.0F, Math.min(4.0F, var1));
   }

   public boolean v6() {
      return this.v27 == null || renderSupport47.v1(this.v17().v27).getValue();
   }

   public boolean v7() {
      return this.v28 == null || renderSupport47.v1(this.v17().v28).getValue();
   }

   public boolean v8() {
      return this.v29 != null && renderSupport47.v1(this.v17().v29).getValue();
   }

   public boolean v9() {
      return this.v30 == null || renderSupport47.v1(this.v17().v30).getValue();
   }

   public int v10() {
      if (this.v32 == null) {
         return 855638016;
      } else {
         return this.v9() ? renderSupport47.v1(this.v17().v32).getValue() : 0;
      }
   }

   public boolean v11() {
      return this.v23 != null && renderSupport47.v1(this.v17().v23).getValue() == AutoSupport.Part2.TINT;
   }

   private boolean v20() {
      return this.v6() && hudSupport70.v1();
   }

   public int v12() {
      return this.v33 == null ? -1 : renderSupport47.v1(this.v17().v33).getValue();
   }

   public int v13() {
      return this.v34 == null ? -1 : renderSupport47.v1(this.v17().v34).getValue();
   }

   public boolean v14() {
      return this.v31 == null || renderSupport47.v1(this.v17().v31).getValue();
   }

   public boolean v15() {
      for (Setting var2 : this.v15.all()) {
         if (var2.isModified()) {
            return true;
         }
      }

      return false;
   }

   public JsonObject v16() {
      return this.v15.save();
   }

   public void v1(JsonObject var1) {
      this.v22 = true;

      try {
         this.v15.load(var1);
         if (this.v18 != null && !var1.entrySet().isEmpty() && !var1.has(this.v18.getName())) {
            this.v18.setValue(AutoSupport.Part1.CUSTOM);
         }
      } finally {
         this.v22 = false;
         this.v21();
      }
   }

   public void v18() {
      this.v22 = true;

      try {
         this.v25.setValue(1.0F);
      } finally {
         this.v22 = false;
      }
   }

   public void v19() {
      this.v22 = true;

      try {
         this.v15.v8();
      } finally {
         this.v22 = false;
         this.v21();
      }
   }

   private void v21() {
      this.v21 = this.v18 == null ? null : this.v18.getValue();
   }

   public static enum Part1 {
      USE_GLOBAL,
      CUSTOM;

      private Part1() {
      }
   }

   public static enum Part2 {
      FLAT,
      TINT;

      private Part2() {
      }
   }
}
