package cc.syky.internal;

import java.util.concurrent.Executor;
import java.util.function.Function;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport34<K> {
   private final Executor v1;
   private final Function<K, InternalSupport35> v2;
   @Nullable
   private K v3;
   @Nullable
   private InternalSupport36 v4;
   @Nullable
   private K v5;
   @Nullable
   private volatile InternalSupport34.Part1<K> v6;

   public InternalSupport34(Executor var1, Function<K, InternalSupport35> var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   @Nullable
   public InternalSupport36 v1(K var1) {
      this.v4();
      if (this.v5 == null && !this.v2((K)var1)) {
         this.v5 = (K)var1;
         this.v1.execute(() -> this.v6 = new InternalSupport34.Part1<>((K)var1, this.v2.apply((K)var1)));
      }

      return this.v4;
   }

   @Nullable
   public InternalSupport36 v1() {
      this.v4();
      return this.v4;
   }

   public boolean v2() {
      return this.v5 != null;
   }

   public boolean v2(K var1) {
      return this.v3 != null && this.v3.equals(var1);
   }

   public boolean v1(InternalSupport34<K> var1, K var2) {
      if (var1.v4 != null && !this.v2((K)var2) && var1.v2(var2)) {
         this.v3();
         this.v4 = var1.v4;
         this.v3 = var1.v3;
         var1.v4 = null;
         var1.v3 = null;
         return true;
      } else {
         return false;
      }
   }

   private void v4() {
      InternalSupport34.Part1 var1 = this.v6;
      if (var1 != null) {
         this.v6 = null;
         this.v5 = null;
         InternalSupport36 var2 = this.v4;
         this.v4 = var1.v2().v5() ? null : InternalSupport36.v1(var1.v2());
         this.v3 = (K)var1.v1();
         if (var2 != null) {
            var2.close();
         }
      }
   }

   public void v3() {
      if (this.v4 != null) {
         this.v4.close();
         this.v4 = null;
      }

      this.v3 = null;
   }

   public record Part1<K>(K input, InternalSupport35 pack) {
      public K v1() {
         return this.input;
      }

      public InternalSupport35 v2() {
         return this.pack;
      }
   }
}
