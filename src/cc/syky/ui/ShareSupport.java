package cc.syky.ui;

import java.util.List;

public final class ShareSupport {
   private ShareSupport() {
   }

   public static AddNoteSupport v1(ShareSupport.Part1 var0, boolean var1, float var2) {
      return new AddNoteSupport(
         List.of(
            new AddNoteSupport.Part2(uiSupport143.v12, 20.0F, 20.0F, -1.0F, "Rename", false, true, false, var0::v5),
            new AddNoteSupport.Part2(uiSupport143.v13, 21.0F, 19.0F, 0.0F, "Share", false, true, false, var0::v6),
            new AddNoteSupport.Part2(uiSupport143.v14, 20.0F, 20.0F, 0.0F, "Duplicate", false, true, false, var0::v7),
            new AddNoteSupport.Part2(uiSupport143.v15, 18.0F, 20.0F, 0.0F, "Delete", true, var1, true, var0::v8)
         ),
         var2
      );
   }

   public interface Part1 {
      void v5();

      void v6();

      void v7();

      void v8();
   }
}
