package cc.syky;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.util.tinyfd.TinyFileDialogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AddImageSupport {
   private static final Logger v1 = LoggerFactory.getLogger("syky.hud.image");
   private static final String v2 = "Add image";
   private static final String v3 = "Images (png, jpg, gif)";
   private static volatile boolean v4;

   private AddImageSupport() {
   }

   private static void v2() {
      if (Platform.get() == Platform.WINDOWS) {
         try {
            SharedLibrary var0 = Library.loadNative(TinyFileDialogs.class, "org.lwjgl.tinyfd", "tinyfd");
            long var1 = var0.getFunctionAddress("tinyfd_winUtf8");
            if (var1 != 0L) {
               MemoryUtil.memPutInt(var1, 1);
            }
         } catch (Throwable var3) {
            v1.debug("could not put the file picker into UTF-8 mode; non-ASCII paths may not open", var3);
         }
      }
   }

   public static boolean v1() {
      return v4;
   }

   @Nullable
   public static Path v1(@Nullable Path var0) {
      return v1(var0, "Add image");
   }

   @Nullable
   public static Path v1(@Nullable Path var0, String var1) {
      if (v4) {
         return null;
      } else {
         v4 = true;

         Path var23;
         try {
            MemoryStack var2;
            label199: {
               label200: {
                  Path var20;
                  label201: {
                     var2 = MemoryStack.stackPush();

                     try {
                        label185: {
                           PointerBuffer var17 = var2.mallocPointer(DecompilationFailedSupport.v1.length);

                           for (String var7 : DecompilationFailedSupport.v1) {
                              var17.put(var2.UTF8("*" + var7));
                           }

                           var17.flip();
                           String var18 = var0 == null ? null : var0.toAbsolutePath() + File.separator;
                           String var19 = TinyFileDialogs.tinyfd_openFileDialog(var1, var18, var17, "Images (png, jpg, gif)", false);
                           if (var19 != null && !var19.isBlank()) {
                              var20 = Path.of(var19);
                              if (!DecompilationFailedSupport.v1(var20)) {
                                 v1.warn("{} is not a picture this client reads", var20.getFileName());
                                 var23 = null;
                                 break label185;
                              }

                              if (!Files.isRegularFile(var20)) {
                                 v1.warn("the picker chose a file that is not there: {}", var19);
                                 var23 = null;
                                 break label199;
                              }

                              var23 = var20;
                              break label200;
                           }

                           var20 = null;
                           break label201;
                        }
                     } catch (Throwable var14) {
                        if (var2 != null) {
                           try {
                              var2.close();
                           } catch (Throwable var13) {
                              var14.addSuppressed(var13);
                           }
                        }

                        throw var14;
                     }

                     if (var2 != null) {
                        var2.close();
                     }

                     return var23;
                  }

                  if (var2 != null) {
                     var2.close();
                  }

                  return var20;
               }

               if (var2 != null) {
                  var2.close();
               }

               return var23;
            }

            if (var2 != null) {
               var2.close();
            }
         } catch (Throwable var15) {
            v1.warn("the system file picker could not be opened", var15);
            return null;
         } finally {
            v4 = false;
         }

         return var23;
      }
   }

   static {
      v2();
   }
}
