package cc.syky.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayDeque;

public final class uiSupport254 {
   public static final int v1 = 100;
   private static final int v2 = 200;
   private final ArrayDeque<uiSupport254.Part1> v3 = new ArrayDeque<>(100);

   public uiSupport254() {
   }

   public void v1(long var1, String var3, String var4) {
      uiSupport254.Part1 var5 = new uiSupport254.Part1(var1, var3, NativeMethodSupport.v1(var4, 200));
      synchronized (this.v3) {
         if (this.v3.size() == 100) {
            this.v3.removeFirst();
         }

         this.v3.addLast(var5);
      }
   }

   public JsonArray v1() {
      uiSupport254.Part1[] var1;
      synchronized (this.v3) {
         var1 = this.v3.toArray(new uiSupport254.Part1[0]);
      }

      JsonArray var9 = new JsonArray(var1.length);

      for (uiSupport254.Part1 var6 : var1) {
         JsonObject var7 = new JsonObject();
         var7.addProperty("t", var6.v1());
         var7.addProperty("c", var6.v2());
         var7.addProperty("m", var6.v3());
         var9.add(var7);
      }

      return var9;
   }

   public record Part1(long t, String c, String m) {
      public long v1() {
         return this.t;
      }

      public String v2() {
         return this.c;
      }

      public String v3() {
         return this.m;
      }
   }
}
