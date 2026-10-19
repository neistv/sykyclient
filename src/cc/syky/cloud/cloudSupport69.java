package cc.syky.cloud;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport69 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.compat.iris");
   private static final String v2 = "net.irisshaders.iris.api.v0.IrisApi";
   private static final String v3 = "net.irisshaders.iris.vertices.ImmediateState";
   private static cloudSupport69.Part1 v4 = cloudSupport69.Part1.UNRESOLVED;
   private static cloudSupport69.Part1 v5 = cloudSupport69.Part1.UNRESOLVED;
   @Nullable
   private static ThreadLocal<Boolean> v6;
   @Nullable
   private static MethodHandle v7;
   @Nullable
   private static MethodHandle v8;

   private cloudSupport69() {
   }

   public static boolean v1() {
      if (v4 == cloudSupport69.Part1.UNRESOLVED) {
         v6();
      }

      MethodHandle var0 = v7;
      if (var0 == null) {
         return false;
      } else {
         try {
            return (boolean)var0.invokeExact();
         } catch (Throwable var2) {
            v1("IrisApi.isShaderPackInUse() failed", var2);
            return false;
         }
      }
   }

   public static boolean v2() {
      if (v4 == cloudSupport69.Part1.UNRESOLVED) {
         v6();
      }

      MethodHandle var0 = v8;
      if (var0 == null) {
         return false;
      } else {
         try {
            return (boolean)var0.invokeExact();
         } catch (Throwable var2) {
            v8 = null;
            v1.warn("IrisApi.isRenderingShadowPass() failed — syky treats every pass as the main one", var2);
            return false;
         }
      }
   }

   public static <T> T v1(Supplier<T> var0) {
      ThreadLocal var1 = v4();
      if (var1 == null) {
         return (T)var0.get();
      } else {
         Boolean var2 = (Boolean)var1.get();
         var1.set(Boolean.TRUE);

         Object var3;
         try {
            var3 = var0.get();
         } finally {
            var1.set(var2 != null ? var2 : Boolean.FALSE);
         }

         return (T)var3;
      }
   }

   @Nullable
   private static ThreadLocal<Boolean> v4() {
      if (v5 == cloudSupport69.Part1.UNRESOLVED) {
         v5();
      }

      return v6;
   }

   private static void v5() {
      try {
         Class var0 = Class.forName("net.irisshaders.iris.vertices.ImmediateState", false, cloudSupport69.class.getClassLoader());
         if (var0.getField("skipExtension").get(null) instanceof ThreadLocal var2) {
            v6 = var2;
            v5 = cloudSupport69.Part1.READY;
            return;
         }

         v5 = cloudSupport69.Part1.UNAVAILABLE;
      } catch (ClassNotFoundException var3) {
         v5 = cloudSupport69.Part1.UNAVAILABLE;
      } catch (Throwable var4) {
         v5 = cloudSupport69.Part1.UNAVAILABLE;
         v1.warn("Iris is present but its vertex-format opt-out could not be bound — world billboards may be malformed while a shaderpack is loaded", var4);
      }
   }

   public static boolean v3() {
      if (v4 == cloudSupport69.Part1.UNRESOLVED) {
         v6();
      }

      return v4 == cloudSupport69.Part1.READY;
   }

   private static void v6() {
      try {
         Class var0 = Class.forName("net.irisshaders.iris.api.v0.IrisApi", false, cloudSupport69.class.getClassLoader());
         Lookup var1 = MethodHandles.lookup();
         Object var2 = (Object)var1.findStatic(var0, "getInstance", MethodType.methodType(var0)).invoke();
         if (var2 == null) {
            v1("IrisApi.getInstance() returned null", null);
            return;
         }

         v7 = var1.findVirtual(var0, "isShaderPackInUse", MethodType.methodType(boolean.class)).bindTo(var2);

         try {
            v8 = var1.findVirtual(var0, "isRenderingShadowPass", MethodType.methodType(boolean.class)).bindTo(var2);
         } catch (IllegalAccessException | NoSuchMethodException var4) {
            v8 = null;
         }

         v4 = cloudSupport69.Part1.READY;
         v1.info("Iris detected — world geometry will drain after the shaderpack composite while a pack is on");
      } catch (ClassNotFoundException var5) {
         v4 = cloudSupport69.Part1.UNAVAILABLE;
         v7 = null;
      } catch (Throwable var6) {
         v1("could not bind net.irisshaders.iris.api.v0.IrisApi", var6);
      }
   }

   private static void v1(String var0, @Nullable Throwable var1) {
      v4 = cloudSupport69.Part1.UNAVAILABLE;
      v7 = null;
      v8 = null;
      if (var1 == null) {
         v1.warn("Iris present but unusable ({}) — syky renders as if no shaderpack were loaded", var0);
      } else {
         v1.warn("Iris present but unusable ({}) — syky renders as if no shaderpack were loaded", var0, var1);
      }
   }

   public static enum Part1 {
      UNRESOLVED,
      READY,
      UNAVAILABLE;

      private Part1() {
      }
   }
}
