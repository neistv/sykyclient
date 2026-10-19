package cc.syky;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;

public record sykyRecord(String rangeFrom, String rangeTo, List<sykyRecord2.Part1> groups) {
   public sykyRecord(String rangeFrom, String rangeTo, List<sykyRecord2.Part1> groups) {
      groups = List.copyOf(groups);
      this.rangeFrom = rangeFrom;
      this.rangeTo = rangeTo;
      this.groups = groups;
   }

   public boolean v1() {
      return !this.rangeFrom.equals(this.rangeTo);
   }

   public String v2() {
      return this.v1() ? this.rangeFrom + " — " + this.rangeTo : this.rangeTo;
   }

   @Nullable
   public static sykyRecord v1(List<sykyRecord2> var0, @Nullable String var1, List<String> var2) {
      if (var0.isEmpty()) {
         return null;
      } else {
         String var3 = ((sykyRecord2)var0.get(0)).v2();
         String var4 = var1 != null ? var1 : ((sykyRecord2)var0.get(var0.size() - 1)).v2();
         return new sykyRecord(var4, var3, v1(var0, var2));
      }
   }

   private static List<sykyRecord2.Part1> v1(List<sykyRecord2> var0, List<String> var1) {
      LinkedHashMap var2 = new LinkedHashMap();

      for (String var4 : var1) {
         var2.put(var4, new ArrayList());
      }

      for (sykyRecord2 var9 : var0) {
         for (sykyRecord2.Part1 var6 : var9.v3()) {
            var2.computeIfAbsent(var6.v2(), var0x -> new ArrayList<>()).addAll(var6.v3());
         }
      }

      ArrayList var8 = new ArrayList(var2.size());

      for (Entry var11 : var2.entrySet()) {
         if (!((List)var11.getValue()).isEmpty()) {
            var8.add(new sykyRecord2.Part1((String)var11.getKey(), (List<String>)var11.getValue()));
         }
      }

      return var8;
   }

   public String v3() {
      return this.rangeFrom;
   }

   public String v4() {
      return this.rangeTo;
   }

   public List<sykyRecord2.Part1> v5() {
      return this.groups;
   }
}
