package cc.syky.internal;

import cc.syky.sykyRecord4;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport9 {
   private final InternalSupport7 v1;
   private boolean v2;
   private boolean v3;
   @Nullable
   private String v4;
   private String v5 = "";
   private InternalSupport10 v6 = InternalSupport10.v2;
   private String v7 = "";
   private long v8;
   private boolean v9;
   private boolean v10;
   private String v11 = "";
   private long v12;

   public InternalSupport9(InternalSupport7 var1) {
      this.v1 = var1;
   }

   public boolean v1() {
      return this.v2;
   }

   public boolean v2() {
      return this.v2 && this.v3;
   }

   @Nullable
   public String v3() {
      return this.v4;
   }

   public String v4() {
      return this.v5;
   }

   public InternalSupport10 v5() {
      return this.v6;
   }

   public String v6() {
      return this.v7;
   }

   public boolean v7() {
      return this.v10;
   }

   public void v1(boolean var1) {
      this.v10 = var1;
   }

   public void v1(String var1, long var2) {
      this.v11 = var1;
      this.v12 = var2;
   }

   @Nullable
   public String v1(long var1) {
      return this.v2 && var1 < this.v12 ? this.v11 : null;
   }

   public boolean v8() {
      return this.v9;
   }

   public long v9() {
      return this.v8;
   }

   public void v1(String var1) {
      if (this.v1.v8()) {
         this.v13();
         this.v2 = true;
         this.v3 = true;
         this.v5 = var1;
         this.v7 = this.v1.v10();
      }
   }

   public boolean v2(String var1) {
      sykyRecord4 var2 = this.v1.v1(var1);
      if (var2 != null && var2.v3() && var2.v9().equals(this.v1.v10())) {
         this.v13();
         this.v2 = true;
         this.v3 = true;
         this.v4 = var1;
         this.v5 = var2.v5();
         this.v6 = var2.v18();
         this.v7 = var2.v9();
         return true;
      } else {
         return false;
      }
   }

   public void v3(String var1) {
      this.v5 = var1;
   }

   public void v2(boolean var1) {
      if (this.v2 && this.v3 != var1) {
         this.v3 = var1;
      }
   }

   public boolean v2(long var1) {
      return this.v1(this.v6.v5(var1), var1);
   }

   public boolean v3(long var1) {
      return this.v1(this.v6.v6(var1), var1);
   }

   public boolean v1(long[] var1, long var2) {
      return this.v1(this.v6.v2(var1), var2);
   }

   public boolean v2(long[] var1, long var2) {
      InternalSupport10 var4 = this.v6;

      for (long var8 : var1) {
         var4 = var4.v6(var8);
      }

      return this.v1(var4, var2);
   }

   private boolean v1(InternalSupport10 var1, long var2) {
      if (!this.v2()) {
         return false;
      } else {
         this.v8 = var2;
         this.v9 = true;
         if (var1.equals(this.v6)) {
            return false;
         } else {
            this.v6 = var1;
            return true;
         }
      }
   }

   @Nullable
   public sykyRecord4 v10() {
      if (this.v2 && !this.v6.v2()) {
         String var1 = this.v4;
         sykyRecord4 var2;
         if (var1 != null && this.v1.v1(var1) != null) {
            this.v1.v1(var1, this.v6);
            this.v1.v1(var1, this.v5);
            var2 = this.v1.v1(var1);
         } else {
            var2 = this.v1.v1(this.v5, this.v6, this.v7);
         }

         this.v11();
         return var2;
      } else {
         return null;
      }
   }

   public void v11() {
      if (this.v2) {
         this.v13();
      }
   }

   public void v12() {
      this.v11();
   }

   private void v13() {
      this.v2 = false;
      this.v3 = false;
      this.v4 = null;
      this.v5 = "";
      this.v6 = InternalSupport10.v2;
      this.v7 = "";
      this.v9 = false;
      this.v10 = false;
      this.v11 = "";
      this.v12 = 0L;
   }
}
