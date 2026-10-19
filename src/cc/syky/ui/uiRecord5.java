package cc.syky.ui;

public record uiRecord5(String name, boolean active) {
   public String v1() {
      return this.name;
   }

   public boolean v2() {
      return this.active;
   }
}
