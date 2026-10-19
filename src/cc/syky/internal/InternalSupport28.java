package cc.syky.internal;

import cc.syky.sound.soundSupport;
import java.util.EnumSet;
import java.util.Set;

public final class InternalSupport28 {
   private static final soundSupport v1 = new soundSupport();
   private static final Set<InternalSupport28.Part1> v2 = EnumSet.noneOf(InternalSupport28.Part1.class);

   private InternalSupport28() {
   }

   public static soundSupport v1() {
      return v1;
   }

   public static synchronized void v1(InternalSupport28.Part1 var0, boolean var1) {
      boolean var2 = var1 ? v2.add(var0) : v2.remove(var0);
      if (var2) {
         if (v2.isEmpty()) {
            v1.v2();
         } else {
            v1.v1();
         }
      }
   }

   public static synchronized void v2() {
      v2.clear();
      v1.v2();
   }

   public static enum Part1 {
      CUSTOM_SOUNDS,
      UI;

      private Part1() {
      }
   }
}
