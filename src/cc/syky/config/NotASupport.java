package cc.syky.config;

import cc.syky.ui.AddNoteSupport;
import cc.syky.ui.AllSupport;
import java.util.List;
import java.util.Set;

public final class NotASupport {
   private NotASupport() {
   }

   public static AddNoteSupport v1(Setting<?> var0, SettingRegistry var1, NotASupport.Part1 var2, float var3, float var4, float var5) {
      Set var6 = var1.v6(var0);
      boolean var7 = var0 instanceof BooleanSetting var8 && var8.getValue();
      String var11 = var0 instanceof BooleanSetting ? null : "Not a switch";
      String var9 = var1.isHidden(var0) ? null : "No more settings here";
      String var10 = SettingRegistry.v1(var6) ? null : "Already at defaults";
      return new AddNoteSupport(List.of(AddNoteSupport.Part2.v3(var7, var11, () -> {
         var2.v1();
         if (var0 instanceof BooleanSetting var2x) {
            AllSupport.v1(var2x);
         }
      }), AddNoteSupport.Part2.v1(var9, () -> {
         var2.v1();
         var2.v1(var0, var3, var4);
      }), AddNoteSupport.Part2.v2(var2::v1), AddNoteSupport.Part2.v1(var10, var2::v1, () -> var1.v2(var6))), var5);
   }

   public interface Part1 {
      void v1(Setting<?> var1, float var2, float var3);

      void v1();
   }
}
