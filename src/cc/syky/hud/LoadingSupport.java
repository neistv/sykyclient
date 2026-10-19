package cc.syky.hud;

import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.internal.InternalSupport20;
import cc.syky.internal.InternalSupport23;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import java.nio.file.Path;
import org.jetbrains.annotations.Nullable;

public final class LoadingSupport extends AbstractHudWidget {
   public static final String[] v2 = v49();
   private final InternalSupport20 v3;
   private final int v4;
   private final FloatSetting v5;
   private final IntSetting v6;
   private uiRecord7 v7 = uiRecord7.ZERO;
   private float v8 = -1.0F;
   private uiRecord7 v9 = uiRecord7.ZERO;
   private float v10 = -1.0F;
   private long v11;
   @Nullable
   private InternalSupport23 v12;
   @Nullable
   private Object v13;
   private boolean v14;

   public LoadingSupport(InternalSupport20 var1, int var2, hudSupport52 var3, float var4, float var5) {
      super(v2[var2], 0, var3, var4, var5);
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = this.v2().v1(new FloatSetting("cornerRadius", 12.0F, 0.0F, 40.0F));
      this.v6 = this.v2().v1(new IntSetting("opacity", 100, 5, 100));
   }

   public static hudSupport52 v40() {
      return hudSupport52.TOP_LEFT;
   }

   public static float v3(int var0) {
      return LoadingSupport2.v1(var0);
   }

   public static float v4(int var0) {
      return LoadingSupport2.v2(var0);
   }

   public int v44() {
      return this.v4;
   }

   public InternalSupport20 v47() {
      return this.v3;
   }

   private static String[] v49() {
      String[] var0 = new String[12];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = "image_" + (var1 + 1);
      }

      return var0;
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      return this.v3.v2(this.v4) == null;
   }

   @Override
   public boolean v12(hudSupport40 var1) {
      return !this.v3.v1(this.v4);
   }

   @Override
   public void v17() {
      this.v3.v7(this.v4);
      this.v13 = null;
      this.v12 = null;
   }

   @Override
   public void v2(boolean var1) {
      if (var1) {
         this.v3.v7(this.v4);
      } else {
         this.v3.v6(this.v4);
      }
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      if (!this.v46()) {
         return this.v12(0.0F, 0.0F);
      } else {
         InternalSupport23 var3 = this.v3.v2(this.v4);
         return var3 == null
            ? this.v12(244.0F * var2, 117.0F * var2)
            : this.v12(LoadingSupport2.v1(var3.v4(), var3.v5()) * var2, LoadingSupport2.v2(var3.v4(), var3.v5()) * var2);
      }
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return this.v3.v2(this.v4) == null ? 20.0F * var3 : this.v5.getValue() * var3;
   }

   @Override
   public boolean v31() {
      return super.v31() || this.v46() && this.v3.v2(this.v4) == null;
   }

   @Override
   public void v1(hudSupport40 var1, hudRecord4 var2, float var3) {
      if (this.v46() && this.v3.v2(this.v4) == null) {
         uiSupport169.v2(var2.v2(), var2.v3(), var2.v4(), var2.v5(), this.v10(this.v50()), 855638016);
      }
   }

   @Nullable
   @Override
   public Object v1(hudSupport40 var1) {
      if (!this.v3.v1(this.v4) && this.v13 != null) {
         return this.v13;
      } else {
         Path var2 = this.v3.v9(this.v4);
         Object var3 = var2 == null ? Boolean.FALSE : var2;
         this.v13 = var3;
         return var3;
      }
   }

   @Override
   public void v10(float var1, float var2) {
      if (this.v3.v1(this.v4)) {
         this.v3.v1(this.v4, this.v59());
      }
   }

   private boolean v46() {
      if (this.v3.v1(this.v4)) {
         this.v14 = true;
         return true;
      } else if (this.v14 && !this.v18().v2()) {
         return true;
      } else {
         this.v14 = false;
         return false;
      }
   }

   private int v59() {
      return Math.max(1, Math.round(244.0F * this.v9()));
   }

   @Override
   public void v4(hudSupport40 var1, float var2) {
      if (this.v36()) {
         this.v3.v2(this.v4, this.v59());
      }
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      if (this.v46()) {
         InternalSupport23 var4 = this.v3.v2(this.v4);
         if (var4 == null) {
            this.v1(var2, var3);
         } else {
            this.v1(var4, var2, var3);
         }

         this.v1(var2.v2(), var2.v3(), var2.v4(), var2.v5(), this.v50());
      }
   }

   private uiRecord7 v10(float var1) {
      if (var1 != this.v8) {
         this.v8 = var1;
         this.v7 = uiRecord7.v1(var1);
      }

      return this.v7;
   }

   private void v1(InternalSupport23 var1, hudRecord4 var2, float var3) {
      if (this.v12 != var1) {
         this.v12 = var1;
         this.v11 = System.nanoTime();
      }

      int var4 = var1.v6() ? var1.v1((System.nanoTime() - this.v11) / 1000000L) : 0;
      int var5 = Math.round(this.v6.getValue().intValue() / 100.0F * 255.0F) << 24 | 16777215;
      uiSupport169.v1(
         var1.v1(), var2.v2(), var2.v3(), var2.v4(), var2.v5(), var1.v1(var4), var1.v2(var4), var1.v3(var4), var1.v4(var4), var5, this.v10(this.v50())
      );
   }

   private void v1(hudRecord4 var1, float var2) {
      float var3 = 13.0F * var2;
      float var4 = 7.0F * var2;
      if (var4 != this.v10) {
         this.v10 = var4;
         this.v9 = uiRecord7.v1(var4);
      }

      uiSupport169.v1(var1.v2() + var3, var1.v3() + var3, var1.v4() - 2.0F * var3, var1.v5() - 2.0F * var3, 450484697, this.v9);
      float var5 = 16.0F * var2;
      String var6 = this.v3.v3(this.v4) ? "Loading..." : "Click here to add image";
      uiSupport169.v3("syky_sans_strong", var6, var1.v2() + var1.v4() / 2.0F, var1.v3() + var1.v5() / 2.0F - 0.600625F * var5, var5, -2130706433);
   }
}
