package cc.syky.ui;

import cc.syky.cloud.cloudSupport58;
import cc.syky.config.SettingRegistry;
import cc.syky.config.configRecord;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import net.minecraft.class_1068;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class CopyNameSupport extends UiPopup implements SignInSupport3.Part2, SignInSupport2.Part1 {
   public static final String v1 = "+ Create new account";
   public static final String v2 = "_accounts";
   private static final String v3 = "Alt manager";
   private static final String v4 = "No accounts yet";
   private static final String v5 = "Nothing found";
   private static final String v6 = "Signing in...";
   private static final String v7 = "Rejoin to apply";
   private static final String v8 = "The account the game started with keeps its name";
   private static final String v13 = "A Microsoft name is changed on minecraft.net";
   private static final String v14 = "The account the game started with stays in the list";
   private static final String v15 = "The account the game started with is never saved to pin";
   private static final String v16 = "The account the game started with is never saved to keep a note";
   private static final String v18 = "_options";
   private static final String v19 = "_create";
   @Nullable
   private static SignInSupport3 v17;
   private final MicrosoftSignSupport v20;
   private final SKINSupport v21;
   private final UiPopup.Part2 v22;
   private final uiSupport117<SignInSupport2> v24;
   private int v25 = -1;
   @Nullable
   private DateAddedSupport v26;
   private boolean v27;
   private final List<String> v28 = new ArrayList<>();
   private boolean v29 = true;
   @Nullable
   private String v30;
   private String v32 = "";
   private String v23 = "";
   private float v33;
   private final hudSupport57 v31 = new hudSupport57(0.0F, 90.0F);
   private float v34;
   @Nullable
   private UiScreen v36;

   public CopyNameSupport(MicrosoftSignSupport var1, SKINSupport var2, float var3, UiPopup.Part2 var4) {
      this.v20 = var1;
      this.v21 = var2;
      this.v33 = var3;
      this.v22 = var4;
      this.v24 = new uiSupport117<>(var3);
      this.v24.v1(true);
   }

   @Override
   public void v1(float var1) {
      this.v33 = var1;
      this.v24.v2(var1);
   }

   @Override
   public void v1() {
      this.v20.v13();
      this.v20.v10();
      this.v30 = null;
      this.v29 = true;
      this.v25 = -1;
   }

   @Nullable
   @Override
   public String v11() {
      return "+ Create new account";
   }

   @Override
   public void v6(float var1, float var2) {
      this.v23();
      this.v1(this.v28(), var1, var2);
   }

   @Override
   public void v7(float var1, float var2) {
      if (this.v24()) {
         this.v22.v4();
      } else {
         this.v23();
         uiSupport69 var3 = this.v27();
         this.v36 = var3;
         this.v22.v1(var3, var1, var2, "_options");
      }
   }

   @Override
   public boolean v24() {
      UiScreen var1 = this.v36;
      return var1 != null && this.v22.v3(var1);
   }

   private uiSupport69 v27() {
      SettingRegistry var1 = this.v20.v2().v1();
      configRecord var2 = configRecord.v1("Alt manager", uiSupport143.v1(AltManagerSupport.ALTS.v2()));
      return new uiSupport69("_accounts", var1, var2, this.v33);
   }

   @Nullable
   @Override
   public UiScreen v2(String var1) {
      if ("_options".equals(var1)) {
         uiSupport69 var2 = this.v27();
         this.v36 = var2;
         return var2;
      } else {
         return "_create".equals(var1) ? this.v28() : null;
      }
   }

   private SignInSupport3 v28() {
      SignInSupport3 var1 = v17;
      if (var1 != null) {
         var1.v1(this);
         return var1;
      } else {
         SignInSupport3 var2 = new SignInSupport3(this.v20, this, this.v33);
         v17 = var2;
         return var2;
      }
   }

   private void v1(SignInSupport3 var1, float var2, float var3) {
      var1.v2(this.v33);
      this.v22.v1(var1, var2, var3, "_create");
   }

   @Override
   public void v1(String var1) {
      this.v32 = var1;
      this.v23 = uiSupport101.v1(var1);
      this.v25 = -1;
   }

   @Override
   public String v2() {
      return this.v32;
   }

   private boolean v2(SignInSupport2 var1) {
      return uiSupport101.v1(this.v23, var1.v3()) || !var1.v4().isEmpty() && uiSupport101.v1(this.v23, var1.v4());
   }

   @Override
   public void v3() {
      this.v29();
      boolean var1 = this.v24.v5();
      this.v32();
      boolean var2 = !var1;
      if (uiSupport103.v1()) {
         this.v31.v2(var2 ? 1.0F : 0.0F);
      } else {
         this.v31.v3(var2 ? 1.0F : 0.0F);
      }

      this.v34 = uiSupport103.v2(this.v31.v2());
   }

   private void v29() {
      uiSupport271 var1 = this.v20.v2();
      DateAddedSupport var2 = var1.v2();
      boolean var3 = var1.v4();
      int var4 = this.v20.v3();
      if (var4 != this.v25 || var2 != this.v26 || var3 != this.v27) {
         if (var2 != this.v26) {
            this.v29 = true;
         }

         this.v25 = var4;
         this.v26 = var2;
         this.v27 = var3;
         boolean var5 = this.v24.v3();
         List var6 = this.v1(this.v20.v4(), var2);
         HashMap var7 = new HashMap();

         for (uiRecord16 var9 : var6) {
            var7.computeIfAbsent(v1(var9, var3), var0 -> new ArrayList<>()).add(var9);
         }

         ArrayList var16 = new ArrayList();

         for (CopyNameSupport.Part1 var12 : CopyNameSupport.Part1.values()) {
            List var13 = (List)var7.get(var12);
            if (var13 != null) {
               String var14 = var12 == CopyNameSupport.Part1.OTHER ? v30() : var12.title;
               uiSupport115 var15 = this.v24.v1(var12, var14);
               if (var15 == null) {
                  var15 = this.v24.v1(var12, var14, var5);
                  this.v1(var15, var12, var13, var5);
                  if (!var15.v5()) {
                     continue;
                  }

                  if (var12.column >= 0) {
                     var15.v1(var12.column);
                  }
               } else {
                  this.v1(var15, var12, var13, var5);
               }

               var16.add(var15);
            }
         }

         this.v24.v1(var16);
      }
   }

   private void v1(uiSupport115<SignInSupport2> var1, CopyNameSupport.Part1 var2, List<uiRecord16> var3, boolean var4) {
      var1.v1(
         var3,
         uiRecord16::v3,
         var3x -> new SignInSupport2(this, var3x, var2.heads && var3x.v4() != uiSupport272.OFFLINE, this.v33, var4),
         SignInSupport2::v1,
         this::v2
      );
   }

   private static CopyNameSupport.Part1 v1(uiRecord16 var0, boolean var1) {
      if (!var1) {
         return CopyNameSupport.Part1.ALL;
      } else {
         return switch (var0.v4()) {
            case OFFLINE -> CopyNameSupport.Part1.OFFLINE;
            case MICROSOFT -> CopyNameSupport.Part1.MICROSOFT;
            case EXTERNAL -> CopyNameSupport.Part1.OTHER;
         };
      }
   }

   private static String v30() {
      return "elyby".equals(uiSupport266.v2()) ? "Ely.by account" : CopyNameSupport.Part1.OTHER.title;
   }

   private List<uiRecord16> v1(List<uiRecord16> var1, DateAddedSupport var2) {
      Comparator var3 = NowSupport.v1(var2);
      Object var4;
      if (this.v29) {
         this.v29 = false;
         var4 = NowSupport.v1(var1, var2);
      } else {
         HashMap var5 = new HashMap();

         for (uiRecord16 var7 : var1) {
            var5.put(var7.v3(), var7);
         }

         var4 = new ArrayList(var1.size());

         for (String var14 : this.v28) {
            uiRecord16 var8 = (uiRecord16)var5.remove(var14);
            if (var8 != null) {
               var4.add(var8);
            }
         }

         ArrayList var12 = new ArrayList(var5.values());
         var12.sort(var3);

         for (uiRecord16 var16 : var12) {
            int var9 = 0;

            while (var9 < var4.size() && var3.compare((uiRecord16)var4.get(var9), var16) <= 0) {
               var9++;
            }

            var4.add(var9, var16);
         }
      }

      this.v28.clear();

      for (uiRecord16 var13 : var4) {
         this.v28.add(var13.v3());
      }

      return (List<uiRecord16>)var4;
   }

   private static boolean v3(SignInSupport2 var0) {
      uiRecord16 var1 = var0.v1();
      return var1.v7() && var1.v4() == uiSupport272.MICROSOFT;
   }

   private void v32() {
      LastSeenDisplay var1 = this.v20.v2().v3();
      long var2 = System.currentTimeMillis();
      String var4 = uiSupport223.v5 ? "Protected" : null;
      MicrosoftSignSupport.Part1 var5 = this.v20.v6();
      TheSignSupport var6 = this.v20.v9();
      String var7 = this.v30;

      for (uiSupport115 var9 : this.v24.v1()) {
         for (SignInSupport2 var11 : var9.v3()) {
            String var12 = var11.v2();
            String var13 = null;
            boolean var14 = false;
            boolean var15 = false;
            if (var5 != null && var5.v1().equals(var12)) {
               var15 = var5.v2();
               var13 = var15 ? "Rejoin to apply" : (v3(var11) ? "Signing in..." : null);
            } else if (var6 != null && var12.equals(var7)) {
               var13 = var6.v1();
               var14 = true;
            }

            var11.v1(var1, var2, var13, var14, var15, var4);
         }
      }
   }

   @Override
   public float v4() {
      return this.v24.v6();
   }

   @Override
   public void v1(float var1, float var2, float var3, float var4, float var5) {
      this.v24.v1(this, var1, var2, var3, var4, var5);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v24.v1(var1);
   }

   @Override
   public float v5() {
      return this.v34;
   }

   @Override
   public String v6() {
      return this.v23.isEmpty() ? "No accounts yet" : "Nothing found";
   }

   @Override
   public class_2960 v7() {
      return this.v23.isEmpty() ? uiSupport143.v1(AltManagerSupport.ALTS.v2()) : uiSupport143.v2;
   }

   @Override
   public void v1(uiSupport102 var1) {
      var1.v1(this);
      var1.v1(this.v9);
      var1.v1(this.v10);
      var1.v1(this.v11);
      var1.v1(this.v12);
      var1.v1(this.v34);
      var1.v1(this.v23.isEmpty());
      var1.v1(this.v22.v13());
      this.v24.v1(var1);
   }

   @Override
   public void v1(SignInSupport2 var1) {
      this.v23();
      uiRecord16 var2 = var1.v1();
      this.v30 = var2.v3();
      if (var2.v10()) {
         this.v8(var1.v9 + var1.v11 / 2.0F, var1.v10 + var1.v12 / 2.0F);
      } else {
         this.v20.v1(var2.v3());
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   @Override
   public void v1(SignInSupport2 var1, float var2, float var3) {
      this.v23();
      uiRecord16 var4 = var1.v1();
      String var5 = var1.v5() ? null : (var4.v7() ? "A Microsoft name is changed on minecraft.net" : "The account the game started with keeps its name");
      ArrayList var6 = new ArrayList(6);
      var6.add(new AddNoteSupport.Part2(uiSupport143.v25, 21.0F, 21.0F, 0.0F, "Copy name", false, true, false, () -> this.v3(var4.v5())));
      var6.add(new AddNoteSupport.Part2(uiSupport143.v25, 21.0F, 21.0F, 0.0F, "Copy UUID", false, true, false, () -> this.v3(var4.v6().toString())));
      var6.add(new AddNoteSupport.Part2(uiSupport143.v26, 22.0F, 22.0F, 0.0F, "Rename", false, var5 == null, var5, false, () -> this.v4(var1)));
      var6.add(
         AddNoteSupport.Part2.v1(var4.v16(), var4.v7() ? null : "The account the game started with is never saved to pin", () -> this.v1(var1, !var4.v16()))
      );
      var6.add(
         AddNoteSupport.Part2.v2(var4.v18() != null, var4.v7() ? null : "The account the game started with is never saved to keep a note", () -> this.v5(var1))
      );
      if (var4.v18() != null) {
         var6.add(AddNoteSupport.Part2.v1(() -> this.v6(var1)));
      }

      if (var4.v4() == uiSupport272.MICROSOFT && var4.v7()) {
         var6.add(new AddNoteSupport.Part2(uiSupport143.v30, 22.0F, 22.0F, 0.0F, "Sign in again", false, true, false, () -> this.v8(var2, var3)));
      }

      var6.add(
         new AddNoteSupport.Part2(
            uiSupport143.v15,
            18.0F,
            20.0F,
            0.0F,
            "Delete",
            true,
            var4.v1(),
            var4.v1() ? null : "The account the game started with stays in the list",
            true,
            () -> this.v7(var1)
         )
      );
      this.v22.v2(new uiSupport93(new AddNoteSupport(var6, this.v33)), var2, var3);
   }

   @Override
   public void v1(SignInSupport2 var1, String var2) {
      String var3 = var1.v1().v5();
      TheSignSupport var4 = this.v20.v1(var1.v2(), var2);
      if (var4 != null && var4 != TheSignSupport.INVALID_NAME) {
         this.v30 = var1.v2();
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      } else {
         if (var4 == null && !var3.equals(var2.strip())) {
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
         }
      }
   }

   @Override
   public void v2(SignInSupport2 var1, String var2) {
      String var3 = var1.v1().v18();
      this.v20.v2(var1.v2(), var2);
      if (!Objects.equals(var3, cloudSupport58.v1(var2))) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   @Override
   public boolean v26() {
      return this.v22.v13();
   }

   @Override
   public class_2960 v1(uiRecord16 var1) {
      return uiSupport223.v3 ? class_1068.method_4648(var1.v6()).comp_1626().comp_3627() : this.v21.v1(var1);
   }

   @Override
   public void v12() {
      this.v22.v4();
   }

   private void v3(String var1) {
      this.v22.v4();
      class_310 var2 = class_310.method_1551();
      if (var2 != null && var2.field_1774 != null) {
         var2.field_1774.method_1455(var1);
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v4(SignInSupport2 var1) {
      this.v22.v4();
      if (var1.v17() && var1.v5()) {
         this.v23();
         var1.v27();
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v8(float var1, float var2) {
      SignInSupport3 var3 = this.v28();
      var3.v1();
      this.v1(var3, var1, var2);
   }

   private void v5(SignInSupport2 var1) {
      this.v22.v4();
      if (var1.v17()) {
         this.v23();
         String var2 = var1.v1().v18();
         var1.v3(var2 == null ? "" : var2);
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v6(SignInSupport2 var1) {
      this.v22.v4();
      this.v20.v2(var1.v2(), null);
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   private void v1(SignInSupport2 var1, boolean var2) {
      this.v22.v4();
      this.v20.v1(var1.v2(), var2);
      this.v29 = true;
      uiSupport148.v1(uiSupport146.v1(var2));
   }

   private void v7(SignInSupport2 var1) {
      this.v22.v4();
      this.v20.v3(var1.v2());
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   private void v23() {
      SignInSupport2 var1 = this.v24.v7();
      if (var1 != null) {
         var1.v16();
      }
   }

   @Override
   public boolean v8() {
      return this.v24.v7() != null;
   }

   @Override
   public void v9() {
      this.v23();
   }

   @Override
   public boolean v10() {
      SignInSupport2 var1 = this.v24.v7();
      if (var1 == null) {
         return false;
      } else {
         var1.v18();
         return true;
      }
   }

   @Override
   public boolean v3(float var1, float var2) {
      return this.v24.v3(var1, var2);
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      return this.v24.v1(var1, var2, var3);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      SignInSupport2 var4 = this.v24.v7();
      if (var4 != null && !var4.v1(var1, var2)) {
         this.v23();
         return true;
      } else {
         SignInSupport2 var5 = this.v24.v2(var1, var2);
         return var5 != null && var5.v1(var1, var2, var3);
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      SignInSupport2 var6 = this.v24.v7();
      return var6 != null && var6.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      SignInSupport2 var4 = this.v24.v7();
      return var4 != null && var4.v4(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      SignInSupport2 var3 = this.v24.v7();
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
      SignInSupport2 var3 = this.v24.v7();
      if (var3 == null) {
         return false;
      } else {
         return var3.v28() || var1 > 32 && var1 < 127 ? var3.v3(var1, var2) : true;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      SignInSupport2 var3 = this.v24.v2(var1, var2);
      return var3 == null ? hudSupport54.ARROW : var3.v2(var1, var2);
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      SignInSupport2 var1 = this.v24.v7();
      return var1 == null ? null : var1.v31();
   }

   public static enum Part1 {
      OFFLINE("Offline accounts", 0, false),
      MICROSOFT("Microsoft accounts", 1, true),
      OTHER("Launcher account", -1, true),
      ALL("Accounts", 0, true);

      public final String title;
      public final int column;
      public final boolean heads;

      private Part1(String var3, int var4, boolean var5) {
         this.title = var3;
         this.column = var4;
         this.heads = var5;
      }
   }
}
