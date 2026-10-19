package cc.syky;

import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudSupport96;
import cc.syky.internal.InternalSupport10;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public record sykyRecord4(
   String id,
   String name,
   int x,
   int y,
   int z,
   String dimension,
   boolean visible,
   boolean linked,
   int color,
   boolean alwaysLabel,
   boolean death,
   boolean pinned,
   @Nullable String note,
   InternalSupport10 blocks,
   sykyRecord5 style,
   float size,
   int key,
   int modifiers,
   cloudSupport96 mode
) {
   public static final int MAX_COORD = 30000000;
   public static final int DEFAULT_COLOR = -2181380;
   public static final float FOLLOW_SIZE = 0.0F;
   public static final float MIN_SIZE = 0.5F;
   public static final float MAX_SIZE = 2.0F;
   public static final int DEATH_COLOR = -38037;

   public sykyRecord4(
      String id,
      String name,
      int x,
      int y,
      int z,
      String dimension,
      boolean visible,
      boolean linked,
      int color,
      boolean alwaysLabel,
      boolean death,
      boolean pinned,
      @Nullable String note,
      InternalSupport10 blocks,
      sykyRecord5 style,
      float size,
      int key,
      int modifiers,
      cloudSupport96 mode
   ) {
      if (id != null && !id.isEmpty()) {
         name = name == null ? "" : name;
         dimension = dimension == null ? "" : dimension;
         mode = mode == null ? cloudSupport96.TOGGLE : mode;
         blocks = blocks == null ? InternalSupport10.v2 : blocks;
         style = style == null ? sykyRecord5.DEFAULT : style;
         size = size > 0.0F && Float.isFinite(size) ? Math.max(0.5F, Math.min(2.0F, size)) : 0.0F;
         x = v1(x);
         y = v1(y);
         z = v1(z);
         modifiers = key == -1 ? 0 : modifiers & 15;
         this.id = id;
         this.name = name;
         this.x = x;
         this.y = y;
         this.z = z;
         this.dimension = dimension;
         this.visible = visible;
         this.linked = linked;
         this.color = color;
         this.alwaysLabel = alwaysLabel;
         this.death = death;
         this.pinned = pinned;
         this.note = note;
         this.blocks = blocks;
         this.style = style;
         this.size = size;
         this.key = key;
         this.modifiers = modifiers;
         this.mode = mode;
      } else {
         throw new IllegalArgumentException("id must not be empty");
      }
   }

   public static sykyRecord4 v1(String var0, String var1, int var2, int var3, int var4, String var5) {
      return new sykyRecord4(
         var0,
         var1,
         var2,
         var3,
         var4,
         var5,
         true,
         false,
         -2181380,
         false,
         false,
         false,
         null,
         InternalSupport10.v2,
         sykyRecord5.DEFAULT,
         0.0F,
         -1,
         0,
         cloudSupport96.TOGGLE
      );
   }

   public static sykyRecord4 v1(String var0, String var1, InternalSupport10 var2, String var3) {
      return v1(var0, var1, 0, 0, 0, var3).v1(var2);
   }

   public static int v1(int var0) {
      return Math.max(-30000000, Math.min(30000000, var0));
   }

   public boolean v1() {
      return this.key != -1;
   }

   @Nullable
   public cloudRecord10 v2() {
      return this.key == -1 ? null : new cloudRecord10(this.key, this.modifiers);
   }

   public boolean v1(String var1) {
      return this.dimension.equals(var1) || this.linked && var1.equals(EndSupport.v1(this.dimension));
   }

   public boolean v2(String var1) {
      return this.visible && this.v1(var1);
   }

   public int v3(String var1) {
      return EndSupport.v1(this.x, this.dimension, var1);
   }

   public int v4(String var1) {
      return EndSupport.v1(this.z, this.dimension, var1);
   }

   public sykyRecord4 v5(String var1) {
      return new sykyRecord4(
         this.id,
         var1,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v1(int var1, int var2, int var3) {
      return new sykyRecord4(
         this.id,
         this.name,
         var1,
         var2,
         var3,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v1(boolean var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         var1,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v2(boolean var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         var1 && !this.v3(),
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v2(int var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         var1,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v3(boolean var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         var1,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v4(boolean var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         var1,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v6(@Nullable String var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         var1,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v5(boolean var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         var1,
         this.note,
         this.blocks,
         this.style,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public boolean v3() {
      return !this.blocks.v2();
   }

   public sykyRecord4 v1(InternalSupport10 var1) {
      if (var1.v2()) {
         return new sykyRecord4(
            this.id,
            this.name,
            this.x,
            this.y,
            this.z,
            this.dimension,
            this.visible,
            this.linked,
            this.color,
            this.alwaysLabel,
            this.death,
            this.pinned,
            this.note,
            var1,
            this.style,
            this.size,
            this.key,
            this.modifiers,
            this.mode
         );
      } else {
         long var2 = var1.v3();
         return new sykyRecord4(
            this.id,
            this.name,
            InternalSupport10.v1(var2),
            InternalSupport10.v3(var2),
            InternalSupport10.v2(var2),
            this.dimension,
            this.visible,
            false,
            this.color,
            this.alwaysLabel,
            this.death,
            this.pinned,
            this.note,
            var1,
            this.style,
            this.size,
            this.key,
            this.modifiers,
            this.mode
         );
      }
   }

   public sykyRecord4 v1(sykyRecord5 var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         var1,
         this.size,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public sykyRecord4 v1(float var1) {
      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         var1,
         this.key,
         this.modifiers,
         this.mode
      );
   }

   public float v2(float var1) {
      return this.size > 0.0F ? this.size : var1;
   }

   public sykyRecord4 v1(@Nullable cloudRecord10 var1, cloudSupport96 var2) {
      int var3 = -1;
      int var4 = 0;
      if (var1 != null && var1.v1() != -1) {
         var3 = var1.v1();
         var4 = var1.v2();
      }

      return new sykyRecord4(
         this.id,
         this.name,
         this.x,
         this.y,
         this.z,
         this.dimension,
         this.visible,
         this.linked,
         this.color,
         this.alwaysLabel,
         this.death,
         this.pinned,
         this.note,
         this.blocks,
         this.style,
         this.size,
         var3,
         var4,
         var2
      );
   }

   public static String v2(int var0, int var1, int var2) {
      return String.format(Locale.ROOT, "%,d %,d %,d", var0, var1, var2);
   }

   public static String v3(int var0, int var1, int var2) {
      return var0 + " " + var1 + " " + var2;
   }

   public String v4() {
      return this.id;
   }

   public String v5() {
      return this.name;
   }

   public int v6() {
      return this.x;
   }

   public int v7() {
      return this.y;
   }

   public int v8() {
      return this.z;
   }

   public String v9() {
      return this.dimension;
   }

   public boolean v10() {
      return this.visible;
   }

   public boolean v11() {
      return this.linked;
   }

   public int v12() {
      return this.color;
   }

   public boolean v13() {
      return this.alwaysLabel;
   }

   public boolean v14() {
      return this.death;
   }

   public boolean v15() {
      return this.pinned;
   }

   @Nullable
   public String v16() {
      return this.note;
   }

   public InternalSupport10 v18() {
      return this.blocks;
   }

   public sykyRecord5 v19() {
      return this.style;
   }

   public float v17() {
      return this.size;
   }

   public int v20() {
      return this.key;
   }

   public int v21() {
      return this.modifiers;
   }

   public cloudSupport96 v22() {
      return this.mode;
   }
}
