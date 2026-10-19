package cc.syky.internal;

import cc.syky.sykyRecord8;
import org.jetbrains.annotations.Nullable;

public interface InternalSupport18 {
   int v1 = 6;

   @Nullable
   sykyRecord8 v1();

   default void v2() {
   }

   default void v3() {
   }

   default void v4() {
   }

   default boolean v5() {
      return false;
   }

   default void v1(float var1) {
   }

   @Nullable
   default InternalSupport18.Part1 v6() {
      return null;
   }

   default boolean v1(float[] var1) {
      return false;
   }

   public record Part1(InternalSupport18.Part2 button, long sequence) {
      public InternalSupport18.Part2 v1() {
         return this.button;
      }

      public long v2() {
         return this.sequence;
      }
   }

   public static enum Part2 {
      PREVIOUS,
      PLAY_PAUSE,
      NEXT;

      private Part2() {
      }
   }
}
