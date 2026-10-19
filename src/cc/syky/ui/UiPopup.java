package cc.syky.ui;

import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public abstract class UiPopup extends UiNode {
   public UiPopup() {
   }

   public abstract void v1(float var1);

   public abstract void v1();

   public abstract void v1(String var1);

   public abstract String v2();

   public abstract void v3();

   public abstract float v4();

   public abstract void v1(float var1, float var2, float var3, float var4, float var5);

   public abstract float v5();

   public abstract String v6();

   public abstract class_2960 v7();

   public abstract void v1(uiSupport102 var1);

   public abstract boolean v8();

   public abstract void v9();

   public abstract boolean v10();

   public abstract boolean v3(float var1, float var2);

   public abstract boolean v2(float var1, float var2, int var3);

   @Nullable
   public abstract String v11();

   @Nullable
   public class_2960 d_() {
      return null;
   }

   public boolean h_() {
      return false;
   }

   @Nullable
   public String v14() {
      return null;
   }

   public boolean v15() {
      return false;
   }

   public void v4(float var1, float var2) {
   }

   public void v1(boolean var1) {
   }

   public boolean v16() {
      return false;
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4, float var5, float var6) {
   }

   public boolean v5(float var1, float var2) {
      return false;
   }

   public float v18() {
      return 0.0F;
   }

   public UiPopup.Part1 v19() {
      return UiPopup.Part1.NONE;
   }

   public float v17() {
      return -1.0F;
   }

   public float v20() {
      return -1.0F;
   }

   public boolean v21() {
      return true;
   }

   public boolean v22() {
      return true;
   }

   public abstract void v6(float var1, float var2);

   public abstract void v7(float var1, float var2);

   public abstract boolean v24();

   @Nullable
   public abstract UiScreen v2(String var1);

   @Nullable
   public String g_() {
      return null;
   }

   public static enum Part1 {
      NONE,
      JUMP,
      GLIDE;

      private Part1() {
      }
   }

   public interface Part2 {
      void v2(UiScreen var1, float var2, float var3);

      void v4();

      boolean v13();

      boolean v3(UiScreen var1);

      void v1(UiScreen var1, float var2, float var3, String var4);

      void v2(UiScreen var1);

      void v2(String var1);

      uiSupport120 v20();

      boolean v1(int var1);

      boolean v1(UiPopup var1);

      float v29();

      float v30();
   }
}
