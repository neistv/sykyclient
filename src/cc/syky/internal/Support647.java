package cc.syky.internal;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Collection;
import java.util.function.Consumer;

public final class Support647 extends ObjectOpenHashSet<String> {
   private static final long v1 = 1L;
   private final transient Consumer<String> v2 = this::add;

   public Support647() {
   }

   public boolean addAll(Collection<? extends String> var1) {
      int var2 = this.size();
      var1.forEach(this.v2);
      return this.size() != var2;
   }
}
