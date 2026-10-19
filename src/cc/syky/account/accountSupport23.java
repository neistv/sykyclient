package cc.syky.account;

import cc.syky.cloud.cloudSupport29;
import cc.syky.internal.InternalSupport48;
import cc.syky.module.visual.visualSupport23;
import cc.syky.module.visual.visualSupport24;
import cc.syky.module.visual.visualSupport51;
import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_4184;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class accountSupport23 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.worldpost");
   private static final int v2 = 600;
   private static int v3;
   private static boolean v4;

   private accountSupport23() {
   }

   public static void v1() {
      if (!v4 && ++v3 > 600) {
         v4 = true;
         v1.error(
            "the pre-hand depth clear hook never fired in {} frames — another mod has claimed that instruction. Particles, MotionBlur, FogBlur and both syky geometry drains are inactive for this session.",
            600
         );
      }

      accountSupport22.v1();
   }

   public static void v1(class_4184 var0) {
      v3 = 0;
      int var1 = uiSupport169.v1("gpu.world.post");

      try {
         v2(var0);
      } finally {
         uiSupport169.v1(var1);
      }
   }

   private static void v2(class_4184 var0) {
      int var1 = uiSupport169.v1("gpu.world.cover");

      try {
         uiSupport259.v1("render.world.cover", visualSupport9::v19);
      } finally {
         uiSupport169.v1(var1);
      }

      boolean var2 = (visualSupport51.v46 || visualSupport51.v44) && accountSupport22.v1(var0);
      if (var2 && visualSupport51.v46) {
         int var3 = uiSupport169.v1("gpu.world.fogblur");

         try {
            uiSupport259.v1("render.fogblur", accountSupport20::v1);
         } finally {
            uiSupport169.v1(var3);
         }
      }

      int var146 = uiSupport169.v1("gpu.world.shapes");

      try {
         uiSupport259.v1("render.world", () -> visualSupport9.v3(accountSupport22.v3()));
      } finally {
         uiSupport169.v1(var146);
      }

      if (visualSupport24.v1 || visualSupport24.v2) {
         int var4 = uiSupport169.v1("gpu.world.particles");

         try {
            uiSupport259.v1("render.particles.dust", visualSupport24::v1);
         } finally {
            uiSupport169.v1(var4);
         }
      }

      if (visualSupport23.v1 || visualSupport23.v2) {
         int var147 = uiSupport169.v1("gpu.world.particles");

         try {
            uiSupport259.v1("render.particles.hit", visualSupport23::v2);
         } finally {
            uiSupport169.v1(var147);
         }
      }

      if (accountSupport16.v1 || accountSupport16.v2) {
         int var148 = uiSupport169.v1("gpu.world.particles");

         try {
            uiSupport259.v1("render.particles.trail", accountSupport16::v3);
         } finally {
            uiSupport169.v1(var148);
         }
      }

      if (accountSupport19.v1()) {
         int var149 = uiSupport169.v1("gpu.world.particles");

         try {
            uiSupport259.v1("render.healthring", accountSupport19::v5);
         } finally {
            uiSupport169.v1(var149);
         }
      }

      if (accountSupport18.v1()) {
         int var150 = uiSupport169.v1("gpu.world.particles");

         try {
            uiSupport259.v1("render.lootbeams", accountSupport18::v5);
         } finally {
            uiSupport169.v1(var150);
         }
      }

      if (visualSupport51.v59 || visualSupport51.v53) {
         int var151 = uiSupport169.v1("gpu.world.wetsurfaces");

         try {
            uiSupport259.v1("render.wetsurfaces.mirror", () -> cloudSupport29.v3(var0));
         } finally {
            uiSupport169.v1(var151);
         }
      }

      if (var2 && visualSupport51.v44) {
         int var152 = uiSupport169.v1("gpu.world.motionblur");

         try {
            uiSupport259.v1("render.motionblur", () -> InternalSupport48.v1(var0));
         } finally {
            uiSupport169.v1(var152);
         }
      }

      int var153 = uiSupport169.v1("gpu.world.overlay");

      try {
         uiSupport259.v1("render.world.overlay", () -> visualSupport9.v4(accountSupport22.v3()));
      } finally {
         uiSupport169.v1(var153);
      }

      uiSupport259.v1("render.world.cover", visualSupport9::v21);
   }
}
