package cc.syky.ui;

import java.util.List;
import org.jetbrains.annotations.Nullable;

public final class uiSupport77 extends uiSupport80 {
   private static final String v1 = "nothing bound yet";
   private final uiSupport150 v2;
   private final uiSupport150.Part1[] v3;

   public uiSupport77(uiSupport150 var1, float var2) {
      this(var1, var1.v1(), var2);
   }

   private uiSupport77(uiSupport150 var1, List<uiSupport150.Part1> var2, float var3) {
      super(new uiSupport71(var2.size()), var2.size(), var3);
      this.v2 = var1;
      this.v3 = var2.toArray(new uiSupport150.Part1[0]);
   }

   @Override
   public String v1(int var1) {
      return this.v3[var1].v2();
   }

   @Override
   public boolean v2(int var1) {
      return this.v2.v1(this.v3[var1].v1());
   }

   @Override
   public void v3(int var1) {
      String var2 = this.v3[var1].v1();
      this.v2.v2(var2);
      uiSupport148.v1(uiSupport146.v1(this.v2.v1(var2)));
   }

   @Nullable
   @Override
   public String v2() {
      return "nothing bound yet";
   }
}
