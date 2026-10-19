package cc.syky;

import java.util.List;

public record sykyRecord2(String version, String label, List<sykyRecord2.Part1> groups, List<String> modules) {
   public sykyRecord2(String version, String label, List<sykyRecord2.Part1> groups, List<String> modules) {
      groups = List.copyOf(groups);
      modules = List.copyOf(modules);
      this.version = version;
      this.label = label;
      this.groups = groups;
      this.modules = modules;
   }

   public sykyRecord2(String var1, String var2, List<sykyRecord2.Part1> var3) {
      this(var1, var2, var3, List.of());
   }

   public String v1() {
      return this.version;
   }

   public String v2() {
      return this.label;
   }

   public List<sykyRecord2.Part1> v3() {
      return this.groups;
   }

   public List<String> v4() {
      return this.modules;
   }

   public record Part1(String title, List<String> lines) {
      public Part1(String title, List<String> lines) {
         lines = List.copyOf(lines);
         this.title = title;
         this.lines = lines;
      }

      public boolean v1() {
         return !this.title.isBlank();
      }

      public String v2() {
         return this.title;
      }

      public List<String> v3() {
         return this.lines;
      }
   }
}
