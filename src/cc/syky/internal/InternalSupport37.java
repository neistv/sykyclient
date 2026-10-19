package cc.syky.internal;

import cc.syky.ui.uiSupport164;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.opengl.GLCapabilities;

public final class InternalSupport37 implements uiSupport164 {
   public InternalSupport37() {
   }

   public static boolean v1() {
      GLCapabilities var0 = GL.getCapabilities();
      return var0 != null && (var0.OpenGL33 || var0.GL_ARB_timer_query);
   }

   @Override
   public int v2() {
      return GL15C.glGenQueries();
   }

   @Override
   public void v1(int var1) {
      GL33C.glQueryCounter(var1, 36392);
   }

   @Override
   public boolean v2(int var1) {
      return GL15C.glGetQueryObjecti(var1, 34919) != 0;
   }

   @Override
   public long v3(int var1) {
      return GL33C.glGetQueryObjecti64(var1, 34918);
   }

   @Override
   public void v4(int var1) {
      GL15C.glDeleteQueries(var1);
   }
}
