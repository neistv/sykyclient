package cc.syky.config;

import java.util.Objects;

public record ActionSetting(String name, Runnable reload, Runnable persist) {
   public ActionSetting(String name, Runnable reload, Runnable persist) {
      Objects.requireNonNull(name, "name");
      Objects.requireNonNull(reload, "reload");
      Objects.requireNonNull(persist, "persist");
      this.name = name;
      this.reload = reload;
      this.persist = persist;
   }

   public static ActionSetting v1(String var0, Runnable var1) {
      return new ActionSetting(var0, var1, () -> {});
   }

   public String v1() {
      return this.name;
   }

   public Runnable v2() {
      return this.reload;
   }

   public Runnable v3() {
      return this.persist;
   }
}
