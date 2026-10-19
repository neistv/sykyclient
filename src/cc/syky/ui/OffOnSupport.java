package cc.syky.ui;

import cc.syky.module.ModuleContract;
import java.util.List;

public final class OffOnSupport {
   private OffOnSupport() {
   }

   public static AddNoteSupport v1(ModuleContract var0, uiSupport226 var1, OffOnSupport.Part1 var2, float var3, float var4, float var5) {
      String var6 = var1.v8(var0.getName());
      String var7 = var6 == null ? null : "Off on " + var6;
      boolean var8 = var6 != null ? var1.v9(var0.getName()) : var0.isEnabled();
      String var9 = var0.getSettings().all().isEmpty() ? "This module has no settings" : null;
      String var10 = var9 != null ? var9 : (var0.getSettings().v6() ? null : "Already at defaults");
      return new AddNoteSupport(
         List.of(
            AddNoteSupport.Part2.v3(var8, var7, () -> {
               var2.v4();
               NEWSupport.v1(var1, var0);
            }),
            AddNoteSupport.Part2.v1(var9, () -> {
               var2.v4();
               var2.v2(var0, var3, var4);
            }),
            new AddNoteSupport.Part2(uiSupport143.v7, 22.0F, 22.0F, 0.0F, "Bind settings", false, true, false, () -> var2.v1(var0, var3, var4)),
            AddNoteSupport.Part2.v2(var2::v4),
            AddNoteSupport.Part2.v1(var10, var2::v4, () -> var1.v7(var0.getName()))
         ),
         var5
      );
   }

   public interface Part1 extends uiSupport136 {
      void v2(ModuleContract var1, float var2, float var3);

      void v4();
   }
}
