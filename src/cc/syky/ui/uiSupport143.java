package cc.syky.ui;

import cc.syky.module.ModuleCategory;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class uiSupport143 {
   public static final class_2960 v1 = v2("mark");
   public static final class_2960 v2 = v2("search");
   public static final class_2960 v3 = v2("config");
   public static final class_2960 v4 = v2("save");
   public static final class_2960 v5 = v2("chevron");
   public static final class_2960 v6 = v2("keybind");
   public static final class_2960 v7 = v2("keybind_menu");
   public static final class_2960 v8 = v1("account");
   public static final class_2960 v9 = v2("plus");
   public static final class_2960 v10 = v2("folder");
   public static final class_2960 v11 = v2("autosave");
   public static final class_2960 v12 = v2("rename");
   public static final class_2960 v13 = v2("share");
   public static final class_2960 v14 = v2("duplicate");
   public static final class_2960 v15 = v2("trash");
   public static final class_2960 v16 = v2("pin");
   public static final class_2960 v18 = v2("eye");
   public static final class_2960 v19 = v2("eye_off");
   public static final class_2960 v17 = v2("teleport");
   public static final class_2960 v20 = v2("pin_on");
   public static final class_2960 v21 = v2("pin_off");
   public static final class_2960 v22 = v2("pin_row");
   public static final class_2960 v24 = v2("pin_time");
   public static final class_2960 v25 = v2("copy");
   public static final class_2960 v26 = v2("edit");
   public static final class_2960 v27 = v2("move");
   public static final class_2960 v28 = v2("settings");
   public static final class_2960 v29 = v2("settings_pill");
   public static final class_2960 v30 = v2("sign_in");
   public static final class_2960 v32 = v2("close");
   public static final class_2960 v23 = v2("toggle_on");
   public static final class_2960 v33 = v2("toggle_off");
   public static final class_2960 v31 = v2("idea");
   public static final class_2960 v34 = v2("reset");
   public static final class_2960 v36 = v2("note");
   public static final class_2960 v38 = v2("note_off");
   public static final class_2960 v42 = v2("trash_button");
   public static final class_2960 v43 = v2("chat");
   public static final class_2960 v37 = v2("add_friend");
   public static final class_2960 v48 = v2("remove_friend");
   public static final class_2960 v40 = v2("mailbox_row");
   public static final class_2960 v44 = v2("plus_verb");
   public static final class_2960 v47 = v2("attach");
   public static final class_2960 v49 = v2("back");
   public static final class_2960 v46 = v2("send");
   public static final class_2960 v51 = v2("down");
   public static final class_2960 v50 = v2("reply");
   public static final class_2960 v60 = v2("select");
   public static final class_2960 v59 = v2("check");
   public static final class_2960 v53 = v2("tail_in");
   public static final class_2960 v63 = v2("tail_out");
   public static final class_2960 v64 = v2("tick");
   public static final class_2960 v61 = v2("ticks");
   public static final class_2960 v66 = v2("clock");
   public static final class_2960 v68 = v2("alert");
   public static final class_2960 v52 = v2("server");

   private uiSupport143() {
   }

   public static List<class_2960> v1() {
      ArrayList var0 = new ArrayList();
      var0.add(v1);
      var0.add(v2);
      var0.add(v3);
      var0.add(v4);
      var0.add(v5);
      var0.add(v6);
      var0.add(v8);
      var0.add(v9);
      var0.add(v10);
      var0.add(v11);
      var0.add(v12);
      var0.add(v13);
      var0.add(v14);
      var0.add(v15);
      var0.add(v16);
      var0.add(v18);
      var0.add(v19);
      var0.add(v17);
      var0.add(v25);
      var0.add(v20);
      var0.add(v21);
      var0.add(v22);
      var0.add(v24);
      var0.add(v26);
      var0.add(v27);
      var0.add(v28);
      var0.add(v29);
      var0.add(v23);
      var0.add(v33);
      var0.add(v7);
      var0.add(v31);
      var0.add(v34);
      var0.add(v43);
      var0.add(v37);
      var0.add(v48);
      var0.add(v40);
      var0.add(v44);
      var0.add(v49);
      var0.add(v46);
      var0.add(v47);
      var0.add(v53);
      var0.add(v63);
      var0.add(v64);
      var0.add(v61);
      var0.add(v66);
      var0.add(v68);
      var0.add(v52);
      var0.add(v51);
      var0.add(v50);
      var0.add(v60);
      var0.add(v59);

      for (AltManagerSupport var4 : AltManagerSupport.values()) {
         var0.add(v1(var4.v2()));
      }

      return var0;
   }

   public static class_2960 v1(String var0) {
      return v2("nav_" + var0);
   }

   @Nullable
   public static class_2960 v1(ModuleCategory var0) {
      for (AltManagerSupport var4 : AltManagerSupport.values()) {
         for (ModuleCategory var8 : var4.v4()) {
            if (var8 == var0) {
               return v1(var4.v2());
            }
         }
      }

      return null;
   }

   private static class_2960 v2(String var0) {
      return class_2960.method_60655("syky", "textures/ui/clickgui/" + var0 + ".png");
   }
}
