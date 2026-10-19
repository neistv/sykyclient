package cc.syky.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class uiSupport253<S> {
   private final int v1;
   private final int v2;
   private final Map<String, uiSupport253.Part2<S>> v3 = new LinkedHashMap<>();
   private int v4;

   public uiSupport253(int var1, int var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public synchronized boolean v1(String var1, S var2) {
      uiSupport253.Part2 var3 = this.v3.get(var1);
      if (var3 != null) {
         var3.v2++;
         return false;
      } else if (this.v3.size() < this.v1 && this.v4 < this.v2) {
         this.v3.put(var1, new uiSupport253.Part2<>((S)var2));
         this.v4++;
         return true;
      } else {
         return false;
      }
   }

   public synchronized List<uiSupport253.Part1<S>> v1() {
      ArrayList var1 = new ArrayList();

      for (Entry var3 : this.v3.entrySet()) {
         uiSupport253.Part2 var4 = (uiSupport253.Part2)var3.getValue();
         if (var4.v2 != 0) {
            if (this.v4 >= this.v2) {
               break;
            }

            var1.add(new uiSupport253.Part1((String)var3.getKey(), var4.v2, var4.v1));
            var4.v2 = 0;
            this.v4++;
         }
      }

      return var1;
   }

   public record Part1<S>(String key, int count, S sample) {
      public String v1() {
         return this.key;
      }

      public int v2() {
         return this.count;
      }

      public S v3() {
         return this.sample;
      }
   }

   public static final class Part2<S> {
      public final S v1;
      public int v2;

      public Part2(S var1) {
         this.v1 = (S)var1;
      }
   }
}
