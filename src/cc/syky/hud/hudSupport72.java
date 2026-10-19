package cc.syky.hud;

import cc.syky.module.visual.visualSupport40;
import it.unimi.dsi.fastutil.ints.Int2LongOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.Int2LongMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.function.IntUnaryOperator;

public final class hudSupport72 {
   public static final int v1 = 0;
   public static final int v2 = 1;
   public static final int v3 = 2;
   private static final IntOpenHashSet v4 = new IntOpenHashSet();

   private hudSupport72() {
   }

   public static void v1(int var0, long var1) {
      visualSupport40.v11.put(var0, var1);
      v4.remove(var0);
   }

   public static void v1(long var0, IntUnaryOperator var2) {
      Int2LongOpenHashMap var3 = visualSupport40.v11;
      if (!var3.isEmpty()) {
         ObjectIterator var4 = var3.int2LongEntrySet().fastIterator();

         while (var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            int var6 = var5.getIntKey();
            if (!v1(var6, var5.getLongValue(), var0, var2.applyAsInt(var6))) {
               var4.remove();
               v4.remove(var6);
            }
         }
      }
   }

   private static boolean v1(int var0, long var1, long var3, int var5) {
      if (var5 == 0 || var1 <= var3) {
         return false;
      } else if (var5 == 1) {
         v4.add(var0);
         return true;
      } else {
         return !v4.contains(var0);
      }
   }

   public static void v1() {
      visualSupport40.v11.clear();
      v4.clear();
   }
}
