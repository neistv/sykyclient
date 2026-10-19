package cc.syky.ui;

import org.jetbrains.annotations.Nullable;

public final class uiSupport269 {
   private final MicrosoftSignSupport v1;
   private uiSupport269.Part1 v2 = uiSupport269.Part1.STARTING;
   @Nullable
   private String v3;
   @Nullable
   private String v4;
   private long v5;
   @Nullable
   private uiRecord16 v6;
   @Nullable
   private TheSignSupport v7;

   public uiSupport269(MicrosoftSignSupport var1) {
      this.v1 = var1;
   }

   public uiSupport269.Part1 v1() {
      return this.v2;
   }

   public boolean v2() {
      return this.v2 == uiSupport269.Part1.DONE || this.v2 == uiSupport269.Part1.FAILED || this.v2 == uiSupport269.Part1.CANCELLED;
   }

   @Nullable
   public String v3() {
      return this.v3;
   }

   @Nullable
   public String v4() {
      return this.v4;
   }

   public long v5() {
      return this.v5;
   }

   @Nullable
   public uiRecord16 v6() {
      return this.v6;
   }

   @Nullable
   public TheSignSupport v7() {
      return this.v7;
   }

   public void v8() {
      String var1 = this.v4;
      String var2 = this.v3;
      if (var1 != null && var2 != null && !this.v2()) {
         this.v1.v3(var1, var2);
      }
   }

   public void v9() {
      this.v1.v1(this);
   }

   public void v1(String var1, String var2, long var3) {
      this.v2 = uiSupport269.Part1.WAITING;
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = var3;
   }

   public void v10() {
      this.v2 = uiSupport269.Part1.SIGNING_IN;
   }

   public void v1(uiRecord16 var1) {
      this.v2 = uiSupport269.Part1.DONE;
      this.v6 = var1;
   }

   public void v1(TheSignSupport var1) {
      this.v2 = uiSupport269.Part1.FAILED;
      this.v7 = var1;
   }

   public void v11() {
      this.v2 = uiSupport269.Part1.CANCELLED;
   }

   public static enum Part1 {
      STARTING,
      WAITING,
      SIGNING_IN,
      DONE,
      FAILED,
      CANCELLED;

      private Part1() {
      }
   }
}
