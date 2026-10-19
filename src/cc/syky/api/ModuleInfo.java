package cc.syky.api;

import cc.syky.module.ModuleCategory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ModuleInfo {
   String name();

   ModuleCategory category();

   String description() default "";

   String displayName() default "";

   String group() default "";

   boolean defaultEnabled() default false;
}
