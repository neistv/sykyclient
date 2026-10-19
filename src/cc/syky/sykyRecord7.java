package cc.syky;

import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public record sykyRecord7(String title, @Nullable String artist, int durationSeconds, @Nullable class_2960 artwork) {
   public sykyRecord7(String title, @Nullable String artist, int durationSeconds, @Nullable class_2960 artwork) {
      if (title == null) {
         title = "";
      }

      if (artist == null) {
         artist = "";
      }

      if (durationSeconds < 0) {
         durationSeconds = 0;
      }

      this.title = title;
      this.artist = artist;
      this.durationSeconds = durationSeconds;
      this.artwork = artwork;
   }

   public String v1() {
      return this.title;
   }

   @Nullable
   public String v2() {
      return this.artist;
   }

   public int v3() {
      return this.durationSeconds;
   }

   @Nullable
   public class_2960 v4() {
      return this.artwork;
   }
}
