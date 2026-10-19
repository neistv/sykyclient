package cc.syky;

import cc.syky.cloud.cloudSupport95;
import cc.syky.internal.InternalSupport18;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public final class NextTrackSupport implements cloudSupport95 {
   public static final String v1 = "music.play_pause";
   public static final String v2 = "music.next";
   public static final String v3 = "music.previous";
   private static final List<String> v4 = List.of("music.play_pause", "music.next", "music.previous");
   private final InternalSupport18 v5;

   public NextTrackSupport(InternalSupport18 var1) {
      this.v5 = var1;
   }

   @Override
   public boolean v1(String var1) {
      return v4.contains(var1);
   }

   @Override
   public boolean v2(String var1) {
      return false;
   }

   @Override
   public void v3(String var1) {
      switch (var1) {
         case "music.play_pause":
            this.v5.v2();
            break;
         case "music.next":
            this.v5.v3();
            break;
         case "music.previous":
            this.v5.v4();
      }
   }

   @Override
   public void v4(String var1) {
      this.v3(var1);
   }

   @Override
   public void v5(String var1) {
   }

   @Nullable
   @Override
   public String v6(String var1) {
      return switch (var1) {
         case "music.play_pause" -> "Play / Pause";
         case "music.next" -> "Next track";
         case "music.previous" -> "Previous track";
         default -> null;
      };
   }

   @Override
   public Collection<String> v1() {
      return v4;
   }

   @Override
   public boolean v7(String var1) {
      return false;
   }
}
