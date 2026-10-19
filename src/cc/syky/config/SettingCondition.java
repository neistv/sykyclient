package cc.syky.config;

import cc.syky.module.visual.visualSupport6;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BooleanSupplier;
import org.jetbrains.annotations.Nullable;

public final class SettingCondition {
   @Nullable
   private final Setting<?> v1;
   private final BooleanSupplier v2;
   @Nullable
   private SettingCondition v3;

   private SettingCondition(@Nullable Setting<?> var1, BooleanSupplier var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public static SettingCondition v1(BooleanSetting var0) {
      return new SettingCondition(var0, var0::getValue);
   }

   public static SettingCondition v1(BooleanSupplier var0) {
      return new SettingCondition(null, var0);
   }

   public static SettingCondition v2(BooleanSetting var0) {
      return new SettingCondition(var0, () -> !var0.getValue());
   }

   public static SettingCondition v1(visualSupport6<?> var0) {
      return new SettingCondition(var0, () -> !var0.v9().isEmpty());
   }

   @SafeVarargs
   public static <E extends Enum<E>> SettingCondition v1(EnumSetting<E> var0, E... var1) {
      EnumSet var2 = EnumSet.noneOf(var0.getType());

      for (Enum var6 : var1) {
         var2.add((E)var6);
      }

      v1(var2);
      return new SettingCondition(var0, () -> var2.contains(var0.getValue()));
   }

   @SafeVarargs
   public static <E extends Enum<E>> SettingCondition v2(EnumSetting<E> var0, E... var1) {
      EnumSet var2 = EnumSet.noneOf(var0.getType());

      for (Enum var6 : var1) {
         var2.add((E)var6);
      }

      v1(var2);
      return new SettingCondition(var0, () -> !var2.contains(var0.getValue()));
   }

   private static <E extends Enum<E>> Set<E> v1(Set<E> var0) {
      if (var0.isEmpty()) {
         throw new IllegalArgumentException("enum gate needs at least one constant");
      } else {
         return var0;
      }
   }

   public SettingCondition v1(SettingCondition var1) {
      SettingCondition var2 = this;

      while (var2.v3 != null) {
         var2 = var2.v3;
      }

      var2.v3 = var1;
      return this;
   }

   @Nullable
   public Setting<?> v1() {
      return this.v1;
   }

   @Nullable
   public SettingCondition v2() {
      return this.v3;
   }

   public boolean v3() {
      return this.v2.getAsBoolean();
   }
}
