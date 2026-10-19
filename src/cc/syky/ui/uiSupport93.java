package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class uiSupport93 extends UiScreen implements uiSupport86 {
   private final AddNoteSupport v1;
   private final uiSupport98 v2 = new uiSupport98();
   private float v3 = 1.0F;

   public uiSupport93(AddNoteSupport var1) {
      this.v1 = var1;
   }

   @Override
   public float v2() {
      return this.v1.v2();
   }

   @Override
   public float a_(float var1) {
      return this.v1.v3();
   }

   @Override
   public void v2(float var1) {
      this.v3 = var1;
      this.v1.v1(var1);
   }

   @Override
   public void v11() {
      this.v1.v1(this.v9, this.v10, this.v11, this.v12);
      this.v1();
   }

   private void v1() {
      class_310 var1 = class_310.method_1551();
      float var2 = (float)uiSupport142.v1(var1);
      float var3 = (float)uiSupport142.v2(var1);
      this.v2.v3(this.v9, this.v10);
      AddNoteSupport.Part2 var4 = this.v1.v3(var2, var3);
      String var5 = var4 == null ? null : var4.v8();
      if (var4 != null && var5 != null) {
         class_1041 var6 = var1.method_22683();
         this.v2
            .v1(
               var4,
               var5,
               this.v9,
               this.v1.v1(var4),
               this.v11,
               this.v1.v4(),
               uiSupport98.Part1.BESIDE,
               0.0F,
               var2,
               var3,
               0.0F,
               this.v3,
               var6.method_4486(),
               var6.method_4502()
            );
      } else {
         this.v2.v1();
      }
   }

   @Nullable
   @Override
   public UiNode v13() {
      return this.v2.v2() ? this.v2 : null;
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v1.v1(this.v9, this.v10, this.v11, this.v12);
      this.v1.v1(var1);
      if (this.v2.v2()) {
         uiSupport169.v3();

         try {
            this.v2.v3(var1, this.v2.v3());
         } finally {
            uiSupport169.v4();
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2) {
      return this.v1.v1(var1, var2);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      return this.v1.v1(var1, var2, var3);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1.v2(var1, var2);
   }
}
