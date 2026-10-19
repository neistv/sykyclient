package cc.syky.internal;

import cc.syky.LANRecord;
import cc.syky.cloud.cloudSupport101;
import java.lang.ref.WeakReference;
import java.nio.file.Path;
import net.minecraft.class_1132;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_5218;
import net.minecraft.class_638;
import net.minecraft.class_642;
import net.minecraft.class_746;
import net.minecraft.class_642.class_8678;

public final class InternalSupport4 {
   private final cloudSupport101 v1;
   private final InternalSupport7 v2;
   private WeakReference<class_638> v3 = new WeakReference<>(null);
   private boolean v4;
   private static final String v5 = "unknown";

   public InternalSupport4(cloudSupport101 var1, InternalSupport7 var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public void v1() {
      class_310 var1 = this.v1.v1();
      class_638 var2 = var1 == null ? null : var1.field_1687;
      if (var2 != this.v3.get() || var2 != null != this.v4) {
         this.v3 = new WeakReference<>(var2);
         this.v4 = var2 != null;
         if (var2 != null && var1 != null) {
            this.v2.v1(v1(var1), var2.method_27983().method_29177().toString());
         } else {
            this.v2.v1(null, "");
         }
      }

      class_746 var3 = var1 == null ? null : var1.field_1724;
      if (var2 != null && var3 != null && var3.method_5805()) {
         this.v2.v1(var3.method_23317(), var3.method_23318(), var3.method_23321());
      }
   }

   public void v2() {
      class_310 var1 = this.v1.v1();
      class_746 var2 = var1 == null ? null : var1.field_1724;
      class_638 var3 = var1 == null ? null : var1.field_1687;
      if (var2 != null && var3 != null) {
         this.v1();
         class_2338 var4 = var2.method_24515();
         this.v2.v1(var4.method_10263(), var4.method_10264(), var4.method_10260(), var3.method_27983().method_29177().toString());
      }
   }

   public static LANRecord v1(class_310 var0) {
      class_1132 var1 = var0.method_1576();
      if (var1 != null) {
         Path var4 = var1.method_27050(class_5218.field_24188).toAbsolutePath().normalize();
         Path var5 = var4.getFileName();
         return LANRecord.v4(var5 == null ? "" : var5.toString());
      } else {
         class_642 var2 = var0.method_1558();
         if (var2 == null) {
            return LANRecord.v1("unknown");
         } else if (var2.method_52811()) {
            return LANRecord.v3(var2.field_3752 == null ? "" : var2.field_3752);
         } else {
            String var3 = var2.field_3761 == null ? "" : var2.field_3761;
            return var2.method_55616() != class_8678.field_45609
               ? LANRecord.v1(var3)
               : LANRecord.v2(var2.field_3752 != null && !var2.field_3752.isBlank() ? var2.field_3752 : var3);
         }
      }
   }
}
