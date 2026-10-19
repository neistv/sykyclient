package cc.syky.cloud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public interface cloudSupport95 {
   boolean v1(String var1);

   boolean v2(String var1);

   void v3(String var1);

   void v4(String var1);

   void v5(String var1);

   @Nullable
   String v6(String var1);

   Collection<String> v1();

   default boolean v7(String var1) {
      return true;
   }

   default boolean v8(String var1) {
      return false;
   }

   static cloudSupport95 v1(cloudSupport95... var0) {
      final cloudSupport95[] var1 = (cloudSupport95[])var0.clone();
      return new cloudSupport95() {
         @Nullable
         private cloudSupport95 v9(String var1x) {
            for (cloudSupport95 var5 : var1) {
               if (var5.v1(var1x)) {
                  return var5;
               }
            }

            return null;
         }

         @Override
         public boolean v1(String var1x) {
            return this.v9(var1x) != null;
         }

         @Override
         public boolean v2(String var1x) {
            cloudSupport95 var2 = this.v9(var1x);
            return var2 != null && var2.v2(var1x);
         }

         @Override
         public boolean v8(String var1x) {
            cloudSupport95 var2 = this.v9(var1x);
            return var2 != null && var2.v8(var1x);
         }

         @Override
         public void v3(String var1x) {
            cloudSupport95 var2 = this.v9(var1x);
            if (var2 != null) {
               var2.v3(var1x);
            }
         }

         @Override
         public void v4(String var1x) {
            cloudSupport95 var2 = this.v9(var1x);
            if (var2 != null) {
               var2.v4(var1x);
            }
         }

         @Override
         public void v5(String var1x) {
            cloudSupport95 var2 = this.v9(var1x);
            if (var2 != null) {
               var2.v5(var1x);
            }
         }

         @Nullable
         @Override
         public String v6(String var1x) {
            cloudSupport95 var2 = this.v9(var1x);
            return var2 == null ? null : var2.v6(var1x);
         }

         @Override
         public boolean v7(String var1x) {
            cloudSupport95 var2 = this.v9(var1x);
            return var2 == null || var2.v7(var1x);
         }

         @Override
         public Collection<String> v1() {
            ArrayList var1x = new ArrayList();

            for (cloudSupport95 var5 : var1) {
               var1x.addAll(var5.v1());
            }

            return List.copyOf(var1x);
         }
      };
   }
}
