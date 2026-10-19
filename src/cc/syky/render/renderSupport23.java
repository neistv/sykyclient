package cc.syky.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class renderSupport23 implements AutoCloseable {
   private final Map<GpuTexture, GpuTextureView> v1 = new HashMap<>();

   public renderSupport23() {
   }

   public GpuTextureView v1(GpuTexture var1) {
      GpuTextureView var2 = this.v1.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         Iterator var3 = this.v1.entrySet().iterator();

         while (var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            if (((GpuTexture)var4.getKey()).isClosed()) {
               ((GpuTextureView)var4.getValue()).close();
               var3.remove();
            }
         }

         GpuTextureView var5 = RenderSystem.getDevice().createTextureView(var1);
         this.v1.put(var1, var5);
         return var5;
      }
   }

   @Override
   public void close() {
      for (GpuTextureView var2 : this.v1.values()) {
         var2.close();
      }

      this.v1.clear();
   }
}
