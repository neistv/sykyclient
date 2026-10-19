package cc.syky.ui;

import cc.syky.EndSupport;
import cc.syky.LANRecord;
import cc.syky.WaypointsSupport;
import cc.syky.sykyRecord4;
import cc.syky.cloud.cloudSupport58;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport75;
import cc.syky.internal.InternalSupport7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;
import net.minecraft.class_2338;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public final class CopyCoordsSupport extends UiPopup implements TheEndSupport.Part3, uiSupport46.Part1 {
   private static final String v2 = "_options";
   private static final String v3 = "_create";
   private static final String v4 = "_move:";
   @Nullable
   private static TheEndSupport v5;
   @Nullable
   private static String v6;
   public static final String v1 = "+ Create new waypoint";
   private static final String v7 = "Join a world to place waypoints";
   private static final String v8 = "No waypoints yet";
   private static final String v13 = "Nothing found";
   private static final String v14 = "Join this waypoint's world first";
   private static final String v15 = "Go to this overlay's dimension first";
   private static final String v16 = "Save or discard the overlay being picked first";
   private static final List<String> v18 = List.of("minecraft:overworld", "minecraft:the_nether", "minecraft:the_end");
   private final InternalSupport7 v19;
   @Nullable
   private final hudSupport75 v17;
   private final UiPopup.Part2 v20;
   private final uiSupport117<uiSupport46> v21;
   private int v22 = -1;
   private boolean v24;
   private String v25 = "";
   private String v26 = "";
   private float v27;
   private final hudSupport57 v28 = new hudSupport57(0.0F, 90.0F);
   private float v29;
   @Nullable
   private UiScreen v30;

   public CopyCoordsSupport(InternalSupport7 var1, @Nullable hudSupport75 var2, float var3, UiPopup.Part2 var4) {
      this.v19 = var1;
      this.v17 = var2;
      this.v27 = var3;
      this.v20 = var4;
      this.v21 = new uiSupport117<>(var3);
      this.v21.v1(true);
   }

   @Override
   public void v1(float var1) {
      this.v27 = var1;
      this.v21.v2(var1);
   }

   @Override
   public void v1() {
      this.v19.v6();
      this.v24 = this.v19.v3().v2();
      if (this.v24) {
         this.v19.v4();
      }
   }

   @Nullable
   @Override
   public String v11() {
      return this.v19.v8() ? "+ Create new waypoint" : null;
   }

   @Override
   public void v6(float var1, float var2) {
      this.v8(var1, var2);
   }

   @Override
   public void v1(String var1) {
      this.v25 = var1;
      this.v26 = uiSupport101.v1(var1);
      this.v22 = -1;
   }

   @Override
   public String v2() {
      return this.v25;
   }

   private boolean v2(uiSupport46 var1) {
      return uiSupport101.v1(this.v26, var1.v5()) || !var1.v32().isEmpty() && uiSupport101.v1(this.v26, var1.v32());
   }

   @Override
   public void v3() {
      this.v27();
      boolean var1 = this.v21.v5();
      boolean var2 = !var1 && (!this.v19.v8() || this.v19.v9());
      if (uiSupport103.v1()) {
         this.v28.v2(var2 ? 1.0F : 0.0F);
      } else {
         this.v28.v3(var2 ? 1.0F : 0.0F);
      }

      this.v29 = uiSupport103.v2(this.v28.v2());
   }

   private void v27() {
      boolean var1 = this.v19.v3().v2();
      if (var1 != this.v24) {
         this.v24 = var1;
         this.v22 = -1;
         if (var1) {
            this.v19.v4();
         }
      }

      int var2 = this.v19.v15();
      if (var2 != this.v22) {
         this.v22 = var2;
         boolean var3 = this.v21.v3();
         ArrayList var4 = new ArrayList();
         LANRecord var5 = this.v19.v7();
         this.v1(var4, null, var1 && var5 != null ? var5.v3() : null, this.v19.v11(), var3);
         if (var1) {
            for (Entry var7 : this.v19.v5().entrySet()) {
               this.v1(var4, (LANRecord)var7.getKey(), ((LANRecord)var7.getKey()).v3(), (List<sykyRecord4>)var7.getValue(), var3);
            }
         }

         this.v21.v1(var4);
      }
   }

   private void v1(List<uiSupport115<uiSupport46>> var1, @Nullable LANRecord var2, @Nullable String var3, List<sykyRecord4> var4, boolean var5) {
      LinkedHashMap var6 = new LinkedHashMap();

      for (String var8 : v18) {
         var6.put(var8, new ArrayList());
      }

      for (sykyRecord4 var15 : var4) {
         if (var15.v15()) {
            var6.computeIfAbsent(var15.v9(), var0 -> new ArrayList<>()).add(var15);
         }
      }

      for (sykyRecord4 var16 : var4) {
         if (!var16.v15()) {
            var6.computeIfAbsent(var16.v9(), var0 -> new ArrayList<>()).add(var16);
         }
      }

      for (Entry var17 : var6.entrySet()) {
         if (!((List)var17.getValue()).isEmpty()) {
            String var9 = var3 == null ? EndSupport.v2((String)var17.getKey()) : EndSupport.v2((String)var17.getKey()) + " (" + var3 + ")";
            CopyCoordsSupport.Part1 var10 = new CopyCoordsSupport.Part1(var2, (String)var17.getKey());
            uiSupport115 var11 = this.v21.v1(var10, var9);
            if (var11 == null) {
               var11 = this.v21.v1(var10, var9, var5);
               this.v1(var11, var2, (List<sykyRecord4>)var17.getValue(), var5);
               if (!var11.v5()) {
                  continue;
               }
            } else {
               this.v1(var11, var2, (List<sykyRecord4>)var17.getValue(), var5);
            }

            var1.add(var11);
         }
      }
   }

   private void v1(uiSupport115<uiSupport46> var1, @Nullable LANRecord var2, List<sykyRecord4> var3, boolean var4) {
      var1.v1(var3, sykyRecord4::v4, var3x -> new uiSupport46(this, var2, var3x, this.v19.v2(var3x), this.v27, var4), uiSupport46::v1, this::v2);
   }

   @Override
   public float v4() {
      return this.v21.v6();
   }

   @Override
   public void v1(float var1, float var2, float var3, float var4, float var5) {
      this.v21.v1(this, var1, var2, var3, var4, var5);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v21.v1(var1);
   }

   @Override
   public float v5() {
      return this.v29;
   }

   @Override
   public String v6() {
      if (!this.v19.v8()) {
         return "Join a world to place waypoints";
      } else {
         return this.v26.isEmpty() ? "No waypoints yet" : "Nothing found";
      }
   }

   @Override
   public class_2960 v7() {
      return this.v19.v8() && !this.v26.isEmpty() ? uiSupport143.v2 : uiSupport143.v16;
   }

   @Override
   public void v1(uiSupport102 var1) {
      var1.v1(this);
      var1.v1(this.v9);
      var1.v1(this.v10);
      var1.v1(this.v11);
      var1.v1(this.v12);
      var1.v1(this.v29);
      var1.v1(this.v19.v8());
      var1.v1(this.v26.isEmpty());
      var1.v1(this.v20.v13());
      this.v21.v1(var1);
   }

   @Override
   public void v1(uiSupport46 var1) {
      sykyRecord4 var2 = this.v3(var1);
      if (var2 != null) {
         LANRecord var3 = var1.v3();
         if (var3 == null) {
            this.v19.v1(var2.v4(), !var2.v10());
         } else {
            this.v19.v1(var3, var2.v4(), !var2.v10());
         }

         sykyRecord4 var4 = this.v3(var1);
         uiSupport148.v1(uiSupport146.v1(var4 != null && var4.v10()));
      }
   }

   @Override
   public void v1(uiSupport46 var1, float var2, float var3) {
      this.v30();
      String var4 = var1.v2();
      boolean var5 = var1.v3() == null;
      String var6 = var5 ? null : "Join this waypoint's world first";
      String var7 = var5 ? NotInSupport.v2(var1.v1(), this.v19.v10()) : "Join this waypoint's world first";
      AddNoteSupport.Part2 var8 = AddNoteSupport.Part2.v2(var1.v1().v16() != null, null, () -> this.v5(var1));
      ArrayList var9 = new ArrayList<>(
         List.of(
            new AddNoteSupport.Part2(uiSupport143.v17, 22.0F, 22.0F, 0.0F, "Teleport", false, var7 == null, var7, false, () -> this.v3(var4)),
            new AddNoteSupport.Part2(uiSupport143.v25, 21.0F, 21.0F, 0.0F, "Copy coords", false, true, false, () -> this.v4(var1)),
            AddNoteSupport.Part2.v1(var1.v1().v15(), null, () -> this.v1(var1, !var1.v1().v15())),
            new AddNoteSupport.Part2(uiSupport143.v26, 22.0F, 22.0F, 0.0F, "Rename", false, true, false, () -> this.v7(var1)),
            var8,
            var1.v1().v3()
               ? this.v3(var1, var2, var3)
               : new AddNoteSupport.Part2(uiSupport143.v27, 22.0F, 22.0F, 0.0F, "Change coords", false, var5, var6, false, () -> this.v2(var4, var2, var3)),
            new AddNoteSupport.Part2(uiSupport143.v28, 22.0F, 22.0F, 0.0F, "Settings", false, var5, var6, true, () -> this.v3(var4, var2, var3)),
            new AddNoteSupport.Part2(uiSupport143.v15, 18.0F, 20.0F, 0.0F, "Delete", true, true, true, () -> this.v8(var1))
         )
      );
      if (var1.v1().v16() != null) {
         var9.add(var9.indexOf(var8) + 1, AddNoteSupport.Part2.v1(() -> this.v6(var1)));
      }

      this.v20.v2(new uiSupport93(new AddNoteSupport(var9, this.v27)), var2, var3);
   }

   @Override
   public void v2(uiSupport46 var1, float var2, float var3) {
      hudSupport75 var4 = this.v17;
      if (var4 != null && var1.v3() == null) {
         this.v30();
         this.v20.v2(new KeySupport(var1.v4(), var4, this.v27, this.v20::v4), var2, var3);
      }
   }

   @Override
   public void v1(uiSupport46 var1, String var2) {
      sykyRecord4 var3 = this.v3(var1);
      LANRecord var4 = var1.v3();
      if (var4 == null) {
         this.v19.v1(var1.v2(), var2);
      } else {
         this.v19.v1(var4, var1.v2(), var2);
      }

      sykyRecord4 var5 = this.v3(var1);
      if (var3 != null && var5 != null && !var3.v5().equals(var5.v5())) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   @Override
   public void v2(uiSupport46 var1, String var2) {
      LANRecord var3 = var1.v3();
      LANRecord var4 = var3 != null ? var3 : this.v19.v7();
      sykyRecord4 var5 = this.v3(var1);
      if (var4 != null && var5 != null) {
         this.v19.v2(var4, var1.v2(), var2);
         if (!Objects.equals(var5.v16(), cloudSupport58.v1(var2))) {
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
         }
      }
   }

   @Override
   public boolean v26() {
      return this.v20.v13();
   }

   @Override
   public void v12() {
      this.v20.v4();
   }

   private void v3(String var1) {
      this.v20.v4();
      sykyRecord4 var2 = this.v19.v1(var1);
      if (var2 != null) {
         NotInSupport.v3(var2, this.v19.v10());
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   @Nullable
   private sykyRecord4 v3(uiSupport46 var1) {
      LANRecord var2 = var1.v3();
      return var2 == null ? this.v19.v1(var1.v2()) : this.v19.v2(var2, var1.v2());
   }

   private void v1(uiSupport46 var1, boolean var2) {
      this.v20.v4();
      LANRecord var3 = var1.v3();
      LANRecord var4 = var3 != null ? var3 : this.v19.v7();
      if (var4 != null) {
         this.v19.v2(var4, var1.v2(), var2);
         uiSupport148.v1(uiSupport146.v1(var2));
      }
   }

   private void v4(uiSupport46 var1) {
      this.v20.v4();
      sykyRecord4 var2 = this.v3(var1);
      class_310 var3 = class_310.method_1551();
      if (var2 != null && var3 != null && var3.field_1774 != null) {
         var3.field_1774.method_1455(sykyRecord4.v3(var2.v6(), var2.v7(), var2.v8()));
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v5(uiSupport46 var1) {
      this.v20.v4();
      if (var1.v17()) {
         this.v30();
         String var2 = var1.v1().v16();
         var1.v3(var2 == null ? "" : var2);
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v6(uiSupport46 var1) {
      this.v2(var1, "");
      this.v20.v4();
   }

   private void v7(uiSupport46 var1) {
      this.v20.v4();
      if (var1.v17()) {
         this.v30();
         var1.v27();
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private AddNoteSupport.Part2 v3(uiSupport46 var1, float var2, float var3) {
      String var4;
      if (var1.v3() != null) {
         var4 = "Join this waypoint's world first";
      } else if (!var1.v1().v9().equals(this.v19.v10())) {
         var4 = "Go to this overlay's dimension first";
      } else if (this.v19.v16().v1()) {
         var4 = "Save or discard the overlay being picked first";
      } else {
         var4 = null;
      }

      String var5 = var1.v2();
      return new AddNoteSupport.Part2(uiSupport143.v27, 22.0F, 22.0F, 0.0F, "Edit blocks", false, var4 == null, var4, false, () -> this.v1(var5, var2, var3));
   }

   private void v1(String var1, float var2, float var3) {
      if (!this.v19.v16().v2(var1)) {
         this.v20.v4();
      } else {
         TheEndSupport var4 = this.v28();
         if (var4 == null) {
            this.v19.v16().v11();
            this.v20.v4();
         } else {
            this.v1(var4, var2, var3, "_create");
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
            this.v13();
         }
      }
   }

   private void v2(String var1, float var2, float var3) {
      sykyRecord4 var4 = this.v19.v1(var1);
      if (var4 == null) {
         this.v20.v4();
      } else {
         this.v1(TheEndSupport.v1(this.v19, this, var4, this.v27), var2, var3, "_move:" + var1);
      }
   }

   private void v1(TheEndSupport var1, float var2, float var3, String var4) {
      v5 = var1;
      v6 = var4;
      this.v20.v1(var1, var2, var3, var4);
   }

   @Nullable
   private TheEndSupport v4(String var1) {
      TheEndSupport var2 = v5;
      if (var2 != null && var1.equals(v6) && !var2.v1()) {
         var2.v1(this);
         return var2;
      } else {
         return null;
      }
   }

   private void v3(String var1, float var2, float var3) {
      sykyRecord4 var4 = this.v19.v1(var1);
      if (var4 == null) {
         this.v20.v4();
      } else {
         this.v20.v1(WaypointsSupport.v1(this.v19, var4, this.v17, this.v19.v2(var4), this.v27), var2, var3, var1);
      }
   }

   private void v8(uiSupport46 var1) {
      this.v20.v4();
      LANRecord var2 = var1.v3();
      if (var2 == null) {
         this.v19.v3(var1.v2());
      } else {
         this.v19.v3(var2, var1.v2());
      }

      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   @Override
   public void v7(float var1, float var2) {
      if (this.v24()) {
         this.v20.v4();
      } else {
         this.v30();
         uiSupport69 var3 = WaypointsSupport.v1(this.v19, this.v27);
         this.v30 = var3;
         this.v20.v1(var3, var1, var2, "_options");
      }
   }

   @Nullable
   @Override
   public UiScreen v2(String var1) {
      if ("_create".equals(var1)) {
         TheEndSupport var6 = this.v4(var1);
         if (var6 != null) {
            return var6;
         } else if (!this.v19.v16().v1()) {
            return null;
         } else {
            TheEndSupport var3 = this.v28();
            if (var3 != null) {
               v5 = var3;
               v6 = var1;
            }

            return var3;
         }
      } else if (var1.startsWith("_move:")) {
         sykyRecord4 var5 = this.v19.v1(var1.substring("_move:".length()));
         return var5 == null ? null : this.v4(var1);
      } else if ("_options".equals(var1)) {
         uiSupport69 var4 = WaypointsSupport.v1(this.v19, this.v27);
         this.v30 = var4;
         return var4;
      } else {
         sykyRecord4 var2 = this.v19.v1(var1);
         return var2 == null ? null : WaypointsSupport.v1(this.v19, var2, this.v17, this.v19.v2(var2), this.v27);
      }
   }

   @Override
   public boolean v24() {
      UiScreen var1 = this.v30;
      return var1 != null && this.v20.v3(var1);
   }

   @Nullable
   @Override
   public String g_() {
      return this.v19.v16().v1() ? "_create" : null;
   }

   private void v8(float var1, float var2) {
      this.v30();
      TheEndSupport var3 = this.v28();
      if (var3 != null) {
         this.v1(var3, var1, var2, "_create");
      }
   }

   @Nullable
   private TheEndSupport v28() {
      class_310 var1 = class_310.method_1551();
      class_746 var2 = var1 == null ? null : var1.field_1724;
      if (this.v19.v8() && var2 != null) {
         class_2338 var3 = var2.method_24515();
         return TheEndSupport.v1(this.v19, this, var3.method_10263(), var3.method_10264(), var3.method_10260(), this.v27);
      } else {
         return null;
      }
   }

   @Override
   public void v13() {
      uiSupport141 var1 = uiSupport142.v1;
      if (var1 != null) {
         var1.method_25419();
      }
   }

   @Nullable
   private uiSupport46 v29() {
      return this.v21.v7();
   }

   private void v30() {
      uiSupport46 var1 = this.v29();
      if (var1 != null) {
         var1.v16();
      }
   }

   @Override
   public boolean v8() {
      return this.v29() != null;
   }

   @Override
   public void v9() {
      this.v30();
   }

   @Override
   public boolean v10() {
      uiSupport46 var1 = this.v29();
      if (var1 == null) {
         return false;
      } else {
         var1.v18();
         return true;
      }
   }

   @Override
   public boolean v3(float var1, float var2) {
      return this.v21.v3(var1, var2);
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      return this.v21.v1(var1, var2, var3);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      uiSupport46 var4 = this.v29();
      if (var4 != null && !var4.v1(var1, var2)) {
         this.v30();
         return true;
      } else {
         uiSupport46 var5 = this.v9(var1, var2);
         return var5 != null && var5.v1(var1, var2, var3);
      }
   }

   @Nullable
   private uiSupport46 v9(float var1, float var2) {
      return this.v21.v2(var1, var2);
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      uiSupport46 var6 = this.v29();
      return var6 != null && var6.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      uiSupport46 var4 = this.v29();
      return var4 != null && var4.v4(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      uiSupport46 var3 = this.v29();
      if (var3 == null) {
         return false;
      } else if (var1 != 257 && var1 != 335) {
         return var3.v2(var1, var2);
      } else {
         var3.v16();
         return true;
      }
   }

   @Override
   public boolean v3(int var1, int var2) {
      uiSupport46 var3 = this.v29();
      return var3 != null && var3.v3(var1, var2);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      uiSupport46 var3 = this.v9(var1, var2);
      return var3 == null ? hudSupport54.ARROW : var3.v2(var1, var2);
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      uiSupport46 var1 = this.v29();
      return var1 == null ? null : var1.v31();
   }

   public record Part1(@Nullable LANRecord world, String dimension) {
      @Nullable
      public LANRecord v1() {
         return this.world;
      }

      public String v2() {
         return this.dimension;
      }
   }
}
