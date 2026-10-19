package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class uiSupport39 extends UiNode {
   private final List<UiNode> v1 = new ArrayList<>();

   public uiSupport39() {
   }

   public uiSupport39 v1(UiNode var1) {
      this.v1.add(var1);
      return this;
   }

   public boolean v2(UiNode var1) {
      return this.v1.remove(var1);
   }

   public List<UiNode> v4() {
      return this.v1;
   }

   public void v5() {
      this.v1.clear();
   }

   @Override
   public void v1(int var1, int var2) {
      for (UiNode var4 : this.v1) {
         var4.v1(var1, var2);
      }
   }

   @Override
   public void v5(uiSupport35 var1) {
      for (UiNode var3 : this.v1) {
         var3.v5(var1);
      }
   }

   @Override
   public void v1(uiSupport35 var1) {
      for (UiNode var3 : this.v1) {
         var3.v1(var1);
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      for (int var4 = this.v1.size() - 1; var4 >= 0; var4--) {
         UiNode var5 = this.v1.get(var4);
         if (var5.v1(var1, var2) && var5.v1(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      for (int var4 = this.v1.size() - 1; var4 >= 0; var4--) {
         if (this.v1.get(var4).v4(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      for (int var6 = this.v1.size() - 1; var6 >= 0; var6--) {
         if (this.v1.get(var6).v1(var1, var2, var3, var4, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void v11(float var1, float var2) {
      for (UiNode var4 : this.v1) {
         var4.v11(var1, var2);
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      for (int var3 = this.v1.size() - 1; var3 >= 0; var3--) {
         UiNode var4 = this.v1.get(var3);
         if (var4.v1(var1, var2)) {
            hudSupport54 var5 = var4.v2(var1, var2);
            if (var5 != hudSupport54.ARROW) {
               return var5;
            }
         }
      }

      return hudSupport54.ARROW;
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      for (int var1 = this.v1.size() - 1; var1 >= 0; var1--) {
         hudSupport54 var2 = this.v1.get(var1).v31();
         if (var2 != null) {
            return var2;
         }
      }

      return null;
   }

   @Override
   public boolean v1(float var1, float var2, double var3, double var5) {
      for (int var7 = this.v1.size() - 1; var7 >= 0; var7--) {
         UiNode var8 = this.v1.get(var7);
         if (var8.v1(var1, var2) && var8.v1(var1, var2, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean v2(int var1, int var2) {
      for (int var3 = this.v1.size() - 1; var3 >= 0; var3--) {
         if (this.v1.get(var3).v2(var1, var2)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean v4(int var1, int var2) {
      for (int var3 = this.v1.size() - 1; var3 >= 0; var3--) {
         if (this.v1.get(var3).v4(var1, var2)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean v3(int var1, int var2) {
      for (int var3 = this.v1.size() - 1; var3 >= 0; var3--) {
         if (this.v1.get(var3).v3(var1, var2)) {
            return true;
         }
      }

      return false;
   }
}
