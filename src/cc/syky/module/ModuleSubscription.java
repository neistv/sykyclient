package cc.syky.module;

@FunctionalInterface
public interface ModuleSubscription extends AutoCloseable {
   @Override
   void close();
}
