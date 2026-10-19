package cc.syky.cloud;

import net.minecraft.class_1041;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

public final class cloudSupport57 {
   private static final int v1 = 1;

   private cloudSupport57() {
   }

   public static boolean v1(class_1041 var0, int var1) {
      return GLFW.glfwGetMouseButton(var0.method_4490(), var1) == 1;
   }

   @Nullable
   public static String v1(int var0) {
      return GLFW.glfwGetKeyName(var0, 0);
   }

   public static boolean v1(class_1041 var0) {
      return GLFW.glfwGetWindowMonitor(var0.method_4490()) != 0L;
   }

   public static void v1(class_1041 var0, int var1, int var2, int var3, int var4) {
      long var5 = var0.method_4490();
      GLFW.glfwSetWindowAttrib(var5, 131077, 0);
      GLFW.glfwSetWindowMonitor(var5, 0L, var1, var2, var3, var4, -1);
   }

   public static void v2(class_1041 var0) {
      GLFW.glfwSetWindowAttrib(var0.method_4490(), 131077, 1);
   }

   public static void v3(class_1041 var0) {
      GLFW.glfwRequestWindowAttention(var0.method_4490());
   }
}
