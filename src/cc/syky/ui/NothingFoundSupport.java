package cc.syky.ui;

import cc.syky.Syky;
import cc.syky.sykyRecord9;
import cc.syky.cloud.CloudClient;
import cc.syky.cloud.FromYouSupport;
import cc.syky.cloud.SykySession;
import cc.syky.config.SettingRegistry;
import cc.syky.config.configRecord;
import cc.syky.config.configSupport10;
import cc.syky.config.configSupport9;
import cc.syky.hud.hudSupport2;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport58;
import cc.syky.hud.hudSupport75;
import cc.syky.internal.InternalSupport2;
import cc.syky.module.ModuleCategory;
import cc.syky.module.ModuleContract;
import cc.syky.render.renderSupport33;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.class_1041;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NothingFoundSupport extends UiNode implements uiSupport124, UiPopup.Part2, uiSupport136, uiSupport120, uiSupport130, OffOnSupport.Part1 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.clickgui");
   private static final float v2 = 54.0F;
   private static final String v3 = "Client";
   private static final String v4 = "Other";
   private static final String v5 = "Nothing found";
   private static final float v6 = 16.0F;
   private static final float v7 = 16.0F;
   private static final float v8 = 8.0F;
   private final uiSupport226 v13;
   @Nullable
   private final hudSupport75 v14;
   private final configSupport10 v15;
   private final CreateNewSupport v16;
   @Nullable
   private AltManagerSupport v18;
   private final EnumMap<AltManagerSupport, UiPopup> v19 = new EnumMap<>(AltManagerSupport.class);
   private final uiSupport117<NEWSupport> v17;
   private final hudSupport58 v20 = new hudSupport58();
   private final uiSupport125 v21 = new uiSupport125();
   private final uiSupport100 v22 = new uiSupport100();
   private final uiSupport158 v24 = new uiSupport158();
   private final uiSupport102 v25 = new uiSupport102();
   private final uiSupport102 v26 = new uiSupport102();
   private boolean v27;
   private long v28;
   private boolean v29;
   private final uiSupport128 v30 = new uiSupport128();
   private final hudSupport57 v32 = new hudSupport57(0.0F, 90.0F);
   private float v23;
   private AltManagerSupport v33;
   @Nullable
   private uiSupport117<NEWSupport> v31;
   private float v34;
   private boolean v36;
   private uiRecord7 v38 = uiRecord7.ZERO;
   private float v42 = -1.0F;
   private float v43;
   private AltManagerSupport v37;
   private String v48 = "";
   private String v40 = "";
   private final Map<String, uiSupport101.Part1[]> v44 = new HashMap<>();
   private long v47;
   private float v49;
   private float v46;
   private final uiSupport88<UiScreen> v51 = new uiSupport88<>();
   private boolean v50 = true;
   private boolean v60;
   private float v59;
   private boolean v53;

   private static int v34() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM, 140);
   }

   public NothingFoundSupport(
      uiSupport226 var1,
      @Nullable hudSupport75 var2,
      configSupport10 var3,
      float var4,
      AltManagerSupport var5,
      @Nullable CloudClient var6,
      @Nullable sykyRecord9 var7
   ) {
      this.v13 = var1;
      this.v14 = var2;
      this.v15 = var3;
      this.v43 = var4;
      this.v17 = new uiSupport117<>(var4);
      this.v16 = new CreateNewSupport(var6, var4, this, this::v52);
      if (var7 != null) {
         this.v19.put(AltManagerSupport.WAYPOINTS, new CopyCoordsSupport(var7.v1(), var2, var4, this));
         this.v19.put(AltManagerSupport.ALTS, new CopyNameSupport(var7.v2(), var7.v3(), var4, this));
         if (var6 != null) {
            this.v19.put(AltManagerSupport.SOCIALS, new FromYouSupport(var6, var7.v1(), var4, this));
         }
      }

      this.v37 = var5;
      this.v33 = var5;
      UiPopup var8 = this.v19.get(var5);
      this.v48 = var8 != null ? "" : uiSupport139.v8();
      this.v40 = uiSupport101.v1(this.v48);
      if (var8 != null) {
         var8.v1(uiSupport139.v2(var5));
         var8.v1();
      }

      this.v48();
      this.v38();
      this.v36();
   }

   private void v36() {
      UiPopup var1 = this.v73();
      if (!uiSupport139.v10() && this.v51.v1() == null && var1 != null) {
         String var2 = var1.g_();
         if (var2 != null) {
            uiSupport139.v1(uiSupport139.Part1.PAGE_WINDOW, var2);
         }
      }

      String var5 = uiSupport139.v1(uiSupport139.Part1.PAGE_WINDOW);
      if (var5 != null && this.v51.v1() == null) {
         UiScreen var3 = var1 == null ? null : var1.v2(var5);
         if (var3 == null) {
            uiSupport139.v9();
         } else {
            this.v51.v1(var3, uiSupport139.v11(), uiSupport139.v12(), uiSupport139.v13());
            if (var3 instanceof uiSupport69 var4) {
               var4.v1(uiSupport139.v14());
               var4.v18();
            }
         }
      }
   }

   private void v38() {
      String var1 = uiSupport139.v1(uiSupport139.Part1.SETTINGS);
      if (var1 != null) {
         SettingRegistry var2 = this.v3(var1);
         if (var2 != null && !var2.all().isEmpty()) {
            uiSupport69 var3 = new uiSupport69(var1, var2, this.v4(var1), this.v43);
            this.v51.v1(var3, uiSupport139.v11(), uiSupport139.v12(), uiSupport139.v13());
            var3.v1(uiSupport139.v14());
            var3.v18();
         } else {
            uiSupport139.v9();
         }
      }
   }

   @Nullable
   private SettingRegistry v3(String var1) {
      if ("_gui".equals(var1)) {
         return this.v15.v1();
      } else {
         ModuleContract var2 = this.v13.v6(var1);
         return var2 == null ? null : var2.getSettings();
      }
   }

   public AltManagerSupport v1() {
      return this.v37;
   }

   public void v1(AltManagerSupport var1) {
      boolean var2 = this.v12();
      if (var1 != this.v37 || var2) {
         int var3 = var1.compareTo(this.v37);
         this.v36 = false;
         this.v33 = this.v37;
         if (!this.v30.v2()) {
            this.v42();
         }

         if (var2) {
            this.v48 = "";
            this.v40 = "";
            uiSupport139.v1("");
         }

         UiPopup var4 = this.v19.get(this.v37);
         if (var4 != null) {
            var4.v9();
            var4.v1("");
            uiSupport139.v3(this.v37);
         }

         UiPopup var5 = this.v19.get(var1);
         if (var5 != null) {
            var5.v1();
         }

         this.v37 = var1;
         this.v4();
         this.v48();
         this.v20.v5(0.0F);
         this.v21.v2();
         this.v53 = false;
         this.v30.v1(var3);
         if (!this.v30.v1()) {
            this.v43();
         }
      }
   }

   private void v42() {
      this.v31 = this.v17.v4();
      this.v34 = this.v43 > 0.0F ? this.v20.v1() / this.v43 : 0.0F;
   }

   private void v43() {
      this.v31 = null;
   }

   public boolean v2() {
      UiScreen var1 = this.v37();
      if (var1 != null) {
         return var1.v3();
      } else {
         UiPopup var2 = this.v73();
         return var2 != null && var2.v8();
      }
   }

   public void v2(float var1, float var2, int var3) {
      UiScreen var4 = this.v51.v1();
      if (var4 != null && !var4.v1(var1, var2) && uiSupport90.v2(var3)) {
         var4.e_();
      }

      UiPopup var5 = this.v73();
      if (var5 != null && var5.v8() && (!this.v3(var2) || !var5.v3(var1, var2))) {
         var5.v9();
      }
   }

   public void v1(float var1) {
      this.v59 = var1;
      this.v53 = var1 > 0.0F;
   }

   public float v3() {
      return this.v43 > 0.0F ? this.v20.v2() / this.v43 : 0.0F;
   }

   public void v2(float var1) {
      this.v43 = var1;
      this.v16.v1(var1);

      for (UiPopup var3 : this.v19.values()) {
         var3.v1(var1);
      }

      this.v20.v8(var1);
      this.v17.v2(var1);
      uiSupport117 var4 = this.v31;
      if (var4 != null) {
         var4.v2(var1);
      }

      UiScreen var5 = this.v51.v1();
      if (var5 != null) {
         var5.v2(var1);
      }
   }

   @Override
   public void v4() {
      if (this.v51.v1() != null) {
         this.v51.v8();
         uiSupport139.v9();
         uiSupport69.v8();
      }
   }

   @Nullable
   private UiScreen v37() {
      return this.v51.v2();
   }

   public void v5() {
      UiScreen var1 = this.v37();
      if (var1 != null) {
         if (!var1.v12()) {
            this.v4();
         }
      }
   }

   public boolean v3(float var1, float var2, int var3) {
      UiScreen var4 = this.v37();
      if (var4 == null) {
         return false;
      } else if (var4.v2(var1, var2, var3)) {
         return true;
      } else if (this.v5(var1, var2, var3)) {
         return true;
      } else {
         if (uiSupport90.v2(var3)) {
            this.v5();
         }

         return true;
      }
   }

   @Nullable
   private NEWSupport v12(float var1, float var2) {
      return this.v3(var2) ? this.v17.v2(var1, var2) : null;
   }

   private boolean v5(float var1, float var2, int var3) {
      UiPopup var4 = this.v73();
      if (var4 != null && this.v3(var2) && var4.v2(var1, var2, var3)) {
         this.v4();
         var4.v1(var1, var2, var3);
         return true;
      } else {
         NEWSupport var5 = this.v12(var1, var2);
         if (var5 != null && var5.v2(var1, var2, var3)) {
            boolean var6 = var3 == 0 && this.v1(var5.v3());
            this.v4();
            if (!var6) {
               var5.v1(var1, var2, var3);
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public void v6() {
      UiPopup var1 = this.v73();
      if (var1 != null) {
         var1.v10();
      }

      UiScreen var2 = this.v37();
      if (var2 != null) {
         var2.v15();
      }
   }

   public void v1(String var1) {
      UiPopup var2 = this.v73();
      if (var2 != null) {
         var2.v1(var1);
         uiSupport139.v1(this.v37, var1);
         this.v20.v3(0.0F);
         this.v21.v2();
         this.v53 = false;
         this.v4();
      } else {
         this.v48 = var1;
         this.v40 = uiSupport101.v1(var1);
         uiSupport139.v1(var1);
         this.v40();
         this.v20.v3(0.0F);
         this.v21.v2();
         this.v53 = false;
         this.v4();
      }
   }

   public String v7() {
      UiPopup var1 = this.v73();
      return var1 != null ? var1.v2() : this.v48;
   }

   public void v3(float var1, float var2) {
      this.v1("_gui", this.v15.v1(), var1, var2);
   }

   public boolean v4(float var1, float var2) {
      UiScreen var3 = this.v37();
      if (var3 != null && var3.v3(var1, var2)) {
         var3.v4(var1, var2);
         this.v60 = true;
         if (var3.v5(0.0F, 0.0F)) {
            return true;
         } else {
            this.v51.v1(var3, var1, var2);
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean v8() {
      return this.v60;
   }

   public void v5(float var1, float var2) {
      UiScreen var3 = this.v51.v1();
      if (this.v60 && !(this.v43 <= 0.0F) && var3 != null) {
         if (!var3.v5(var1, var2)) {
            this.v51.v1(var1, var2, this.v9, this.v10, this.v43);
         }
      }
   }

   public void v9() {
      if (this.v60) {
         this.v60 = false;
         UiScreen var1 = this.v51.v1();
         if (var1 != null) {
            var1.v16();
         }

         this.v51.v4(this.v43);
      }
   }

   public boolean v10() {
      UiScreen var1 = this.v37();
      if (var1 == null) {
         return false;
      } else if (var1.v14()) {
         return true;
      } else {
         this.v4();
         return false;
      }
   }

   public boolean v11() {
      return this.v37() != null;
   }

   public boolean v6(float var1, float var2) {
      UiScreen var3 = this.v51.v1();
      return var3 != null && var3.v1(var1, var2);
   }

   public boolean v1(float[] var1) {
      UiScreen var2 = this.v51.v1();
      if (var2 != null && this.v51.v5()) {
         var1[0] = var2.v9 + var2.v11 * 0.5F;
         var1[1] = var2.v10 + var2.v12 * 0.5F;
         return true;
      } else {
         return false;
      }
   }

   private void v48() {
      ArrayList var1 = new ArrayList();

      for (Entry var3 : this.v44().entrySet()) {
         uiSupport115 var4 = this.v17.v1(var3.getKey(), (String)var3.getKey(), false);
         this.v1(var4, (List<ModuleContract>)var3.getValue(), false);
         var1.add(var4);
      }

      this.v17.v2(var1);
      float var5 = this.v17.v2() ? 1.0F : 0.0F;
      this.v32.v3(var5);
      this.v23 = var5;
   }

   private void v40() {
      if (!this.v30.v1() && uiSupport103.v1()) {
         ArrayList var1 = new ArrayList();

         for (Entry var3 : this.v44().entrySet()) {
            uiSupport115 var4 = this.v17.v1(var3.getKey(), (String)var3.getKey());
            if (var4 != null) {
               this.v1(var4, (List<ModuleContract>)var3.getValue(), true);
            } else {
               var4 = this.v17.v1(var3.getKey(), (String)var3.getKey(), true);
               this.v1(var4, (List<ModuleContract>)var3.getValue(), true);
            }

            var1.add(var4);
         }

         this.v17.v1(var1);
      } else {
         this.v48();
      }
   }

   private void v1(uiSupport115<NEWSupport> var1, List<ModuleContract> var2, boolean var3) {
      boolean var4 = var3 && uiSupport103.v1();
      var1.v1(
         var2, ModuleContract::getName, var2x -> new NEWSupport(var2x, this.v13, this.v14, this.v43, this, this, this, var4), (var0, var1x) -> {}, var0 -> true
      );
   }

   private Map<String, List<ModuleContract>> v44() {
      LinkedHashMap var1 = new LinkedHashMap();

      for (ModuleContract var3 : this.v47()) {
         String var4 = var3.getGroup().isEmpty() ? "Other" : var3.getGroup();
         var1.computeIfAbsent(var4, var0 -> new ArrayList<>()).add(var3);
      }

      return var1;
   }

   public boolean v12() {
      return !this.v40.isEmpty();
   }

   private List<ModuleContract> v47() {
      ArrayList var1 = new ArrayList();
      if (this.v12()) {
         return uiSupport101.v1(this.v13.v1(), var1x -> {
            uiSupport101.Part1[] var2 = this.v2(var1x);
            return uiSupport101.v1(this.v40, var2[0], var2[1], var2[2]);
         });
      } else {
         for (ModuleCategory var5 : this.v37.v4()) {
            var1.addAll(this.v13.v1(var5));
         }

         return var1;
      }
   }

   private uiSupport101.Part1[] v2(ModuleContract var1) {
      return this.v44
         .computeIfAbsent(
            var1.getName(),
            var1x -> new uiSupport101.Part1[]{
               uiSupport101.Part1.v1(var1.getDisplayName()), uiSupport101.Part1.v1(var1.getName()), uiSupport101.Part1.v1(var1.getGroup())
            }
         );
   }

   private void v49() {
      boolean var1 = this.v17.v5();
      if (uiSupport103.v1()) {
         this.v32.v2(var1 ? 0.0F : 1.0F);
      } else {
         this.v32.v3(var1 ? 0.0F : 1.0F);
      }

      this.v23 = uiSupport103.v2(this.v32.v2());
   }

   @Override
   public void v1(int var1, int var2) {
      this.v50();
   }

   private float v46() {
      return this.v10 + SignInSupport.v4(82.0F, this.v43);
   }

   private float v51() {
      return Math.max(0.0F, this.v12 - 98.0F * this.v43);
   }

   private void v50() {
      this.v63();
      this.v51.v1(this.v9, this.v10, this.v43);
      this.v61();
      this.v51.v1(this.v43, this.v50);
   }

   public void v1(boolean var1) {
      this.v50 = var1;
   }

   private float v60() {
      return this.v12 + 40.0F * this.v43;
   }

   private float v59() {
      return this.v30.v3().v5() * this.v60();
   }

   private float v53() {
      return this.v30.v4().v5() * this.v60();
   }

   private void v63() {
      boolean var1 = this.v64();
      this.v46 = this.v17.v2(var1);
      if (this.v75()) {
         this.v46 = Math.max(this.v46, this.v16.v1());
      }

      UiPopup var2 = this.v73();
      if (var2 != null) {
         this.v46 = Math.max(this.v46, var2.v4());
      }

      this.v20.v7(Math.max(0.0F, this.v46 - this.v51()));
      if (this.v53) {
         this.v20.v5(this.v59 * this.v43);
      }

      if (var2 != null) {
         float var3 = var2.v18();
         if (var3 != 0.0F) {
            this.v20.v4(var3);
         }

         switch (var2.v19()) {
            case JUMP:
               this.v20.v5(this.v20.v3());
               this.v53 = false;
               break;
            case GLIDE:
               this.v20.v3(this.v20.v3());
            case NONE:
         }

         float var4 = var2.v17();
         if (var4 >= 0.0F) {
            this.v20.v5(this.v20.v3() - var4 * this.v43);
            this.v53 = false;
         }

         float var5 = var2.v20();
         if (var5 >= 0.0F) {
            this.v20.v3(var5);
            this.v21.v1();
            this.v53 = false;
         }
      }

      this.v20.v3(uiSupport169.v1(this.v20.v2()));
      this.v17.v1(this.v9, this.v46() - this.v20.v1() + this.v59(), var1, this.v10, this.v10 + this.v12);
      uiSupport117 var6 = this.v31;
      if (var6 != null) {
         var6.v1(this.v9, this.v46() - this.v34 * this.v43 + this.v53(), var1, this.v10, this.v10 + this.v12);
      }
   }

   private boolean v64() {
      return uiSupport117.v1(this.v11, this.v43);
   }

   private void v61() {
      UiScreen var1 = this.v51.v1();
      if (var1 != null) {
         float var2 = var1.a_(624.0F);
         float var3 = var1.v3(624.0F);
         this.v51.v1(var1.v2() * this.v43, var2 * this.v43, false, 0.0F, this.v9, this.v10, this.v43);
         float var4 = this.v51.v5(this.v43);
         float var5 = this.v51.v6(this.v43);
         float var6 = SignInSupport.v4(this.v51.v3() + var1.v2(), this.v43) - var4;
         float var7 = SignInSupport.v4(this.v51.v4() + var3, this.v43) - var5 + (var2 - var3) * this.v43;
         float var8 = this.v51.v5() ? this.v51.v2(this.v9) + var4 : Math.max(this.v9, this.v9 + var4);
         float var9 = this.v51.v3(this.v10) + var5;
         var1.v1(var8, var9, var6, var7);
         var1.v4(this.v51.v5() ? 0.0F : this.v9);
         var1.v1(this.v50 && !this.v51.v7() && !this.v51.v6());
         if (uiSupport139.v10()) {
            uiSupport139.v1(this.v51.v3(), this.v51.v4(), this.v51.v5(), var1 instanceof uiSupport127 var10 ? var10.v1() : 0.0F);
         }
      }
   }

   @Override
   public void v2(ModuleContract var1, float var2, float var3) {
      InternalSupport2.v2(var1.getName());
      this.v1(var1.getName(), var1.getSettings(), var2, var3);
   }

   @Override
   public boolean v1(ModuleContract var1) {
      return var1.getName().equals(uiSupport139.v1(uiSupport139.Part1.SETTINGS));
   }

   @Override
   public boolean v13() {
      return this.v37() != null;
   }

   @Nullable
   public static String v14() {
      if (!configSupport9.v1()) {
         return null;
      } else {
         return uiSupport142.v1 != null ? uiSupport139.v1(uiSupport139.Part1.SETTINGS) : null;
      }
   }

   @Nullable
   public static String v15() {
      String var0 = v14();
      return var0 == null ? null : uiSupport69.v1(var0);
   }

   public void v1(UiScreen var1, float var2, float var3) {
      uiSupport69.v8();
      this.v3(var1, var2, var3);
      uiSupport139.v1(uiSupport139.Part1.CONFIG, null, this.v51.v3(), this.v51.v4());
   }

   public boolean v16() {
      return "_gui".equals(uiSupport139.v1(uiSupport139.Part1.SETTINGS)) && this.v37() != null;
   }

   public boolean v18() {
      return uiSupport139.v2(uiSupport139.Part1.CONFIG) && this.v37() != null;
   }

   public static boolean v19() {
      return uiSupport139.v2(uiSupport139.Part1.CONFIG);
   }

   public void v1(UiScreen var1) {
      this.v51.v1(var1, uiSupport139.v11(), uiSupport139.v12(), uiSupport139.v13());
      if (var1 instanceof uiSupport127 var2) {
         var2.v1(uiSupport139.v14());
      }
   }

   private void v1(String var1, SettingRegistry var2, float var3, float var4) {
      uiSupport69.v8();
      this.v3(new uiSupport69(var1, var2, this.v4(var1), this.v43), var3, var4);
      uiSupport139.v1(uiSupport139.Part1.SETTINGS, var1, this.v51.v3(), this.v51.v4());
   }

   private configRecord v4(String var1) {
      if ("_gui".equals(var1)) {
         return configRecord.v1("Client", null);
      } else {
         ModuleContract var2 = this.v13.v6(var1);
         return var2 == null ? configRecord.v1(var1, null) : configRecord.v1(var2, this.v13, this.v14);
      }
   }

   @Override
   public void v3(ModuleContract var1, float var2, float var3) {
      this.v2(new uiSupport93(OffOnSupport.v1(var1, this.v13, this, var2, var3, this.v43)), var2, var3);
   }

   @Override
   public void v1(ModuleContract var1, float var2, float var3) {
      hudSupport75 var4 = this.v14;
      if (var4 != null) {
         this.v4();
         this.v3(new KeySupport(var1.getName(), var4, this.v43, this::v4), var2, var3);
      }
   }

   private void v3(UiScreen var1, float var2, float var3) {
      this.v20.v5(this.v20.v1());
      uiSupport89.v1(var1, var2, var3, var1.v2(), var1.a_(624.0F), this.v43, this.v9);
      this.v4(var1, var2, var3);
   }

   @Override
   public void v1(uiSupport80 var1, float var2, float var3, float var4) {
      this.v4();
      uiSupport75 var5 = new uiSupport75(var1);
      this.v20.v5(this.v20.v1());
      uiSupport89.v1(var5, var2, var3, var4, var5.v1(), uiSupport75.v5(), var5.v2(), var5.a_(624.0F), this.v43, this.v9);
      this.v4(var5, var2 + var3, var4);
   }

   private void v4(UiScreen var1, float var2, float var3) {
      this.v60 = false;
      this.v51.v1(var1, this.v9, this.v10, this.v43, var2, var3);
   }

   public void v2(uiSupport35 var1) {
      long var2 = System.nanoTime();
      this.v49 = this.v47 == 0L ? 0.0F : (float)(var2 - this.v47) / 1000000.0F;
      this.v47 = var2;
      if (this.v49 > 100.0F) {
         this.v49 = 100.0F;
      }

      this.v20.v9(this.v49);
      if (!this.v20.v7()) {
         this.v21.v1();
      }

      this.v30.v1(this.v49);
      if (!this.v30.v1()) {
         this.v43();
      }

      this.v49();
      UiPopup var4 = this.v19.get(this.v37);
      if (var4 != null) {
         var4.v3();
      }

      UiPopup var5 = this.v33 == this.v37 ? null : this.v19.get(this.v33);
      if (var5 != null) {
         var5.v3();
      }

      UiScreen var6 = this.v51.v1();
      if (var6 != null) {
         var6.v10();
      }

      this.v50();
      if (var6 != null) {
         var6.v11();
      }

      this.v51.v11();
      this.v22.v1(this.v10(this.v6(var1)), var1.v1, var1.v2, this.v49, this.v9, this.v10, this.v43);
   }

   private uiSupport35 v6(uiSupport35 var1) {
      UiScreen var2 = this.v51.v1();
      return var2 != null && var2.v1(var1.v1, var1.v2) ? var1.v1() : var1;
   }

   private uiRecord7 v66() {
      float var1 = 28.0F * this.v43;
      if (this.v42 != var1) {
         this.v42 = var1;
         this.v38 = uiRecord7.v5(var1);
      }

      return this.v38;
   }

   @Override
   public void v1(uiSupport35 var1) {
      uiSupport35 var2 = this.v6(var1);
      boolean var3 = uiSupport131.v1 && !this.v30.v1();
      boolean var4 = false;
      boolean var5 = false;
      if (var3) {
         this.v8(var2);
         var5 = this.v26.v1(this.v25);
         var4 = this.v27 && var5;
         if (var4 && !uiSupport131.v2 && this.v68()) {
            uiSupport131.v5++;
            this.v7(var2);
            this.v9(var2);
            return;
         }
      } else {
         this.v27 = false;
      }

      boolean var6 = var3 ? uiSupport169.v1(this.v24, var5 && uiSupport131.v3) : uiSupport169.v5();
      float var7 = var6 ? this.v10 : this.v46();
      float var8 = var6 ? this.v12 : this.v51();
      uiSupport169.v6(this.v9, var7, this.v11, var8);
      uiSupport258 var9 = Syky.profilerOrNull();
      long var10 = var9 == null ? 0L : var9.v3();
      int var12 = uiSupport33.v2();
      long var13 = uiSupport131.v2 ? uiSupport169.v14() : 0L;
      boolean var15 = false;
      if (var3) {
         uiSupport34.v2();
      }

      try {
         if (this.v30.v1()) {
            this.v1(var2, var7, var8);
         } else {
            var15 = this.v2(var2, var7, var8);
         }
      } finally {
         if (var3) {
            uiSupport34.v3();
         }

         if (var9 != null) {
            var9.v1("clickgui.list", var10);
         }

         uiSupport131.v4++;
         if (var6) {
            if (var3) {
               this.v1(var4, !var15 && uiSupport33.v2() == var12, var13);
            }

            long var20 = this.v24.v3();
            int var22 = uiSupport169.v1("gpu.clickgui.veil");
            uiSupport169.v1(
               this.v9,
               this.v10,
               this.v11,
               this.v12,
               this.v66(),
               this.v10 + 35.0F * this.v43,
               this.v10 + 82.0F * this.v43,
               9.0F * this.v43,
               0.4F,
               this.v10 + 35.0F * this.v43,
               this.v10 + this.v12 - 16.0F * this.v43,
               this.v10 + this.v12,
               0.4F
            );
            uiSupport169.v1(var22);
            uiSupport131.v6 = uiSupport131.v6 + (this.v24.v3() - var20);
         } else {
            this.v27 = false;
         }

         uiSupport169.v17();
      }

      this.v7(var2);
      this.v9(var2);
   }

   private void v7(uiSupport35 var1) {
      UiPopup var2 = this.v73();
      boolean var3 = this.v30.v1();
      UiPopup var4 = var3 ? this.v19.get(this.v33) : null;
      if (var2 != null || var4 != null) {
         uiSupport169.v6(this.v9, this.v10, this.v11, this.v12);

         try {
            if (var4 != null && !this.v30.v4().v7()) {
               boolean var5 = this.v36;
               if (var5) {
                  var4.v1(true);
               }

               try {
                  var4.v1(var1.v1(), this.v9, this.v10, this.v11, this.v12, this.v30.v4().v1());
               } finally {
                  if (var5) {
                     var4.v1(false);
                  }
               }
            }

            if (var2 != null && (!var3 || !this.v30.v3().v7())) {
               var2.v1(var1, this.v9, this.v10, this.v11, this.v12, var3 ? this.v30.v3().v1() : 1.0F);
            }
         } finally {
            uiSupport169.v17();
         }
      }
   }

   private boolean v68() {
      uiSupport169.v12();
      uiSupport169.v6(this.v9, this.v10, this.v11, this.v12);

      boolean var3;
      try {
         int var1 = uiSupport169.v1("gpu.clickgui.veil");
         boolean var2 = uiSupport169.v1(
            this.v24,
            this.v9,
            this.v10,
            this.v11,
            this.v12,
            this.v66(),
            this.v10 + 35.0F * this.v43,
            this.v10 + 82.0F * this.v43,
            9.0F * this.v43,
            0.4F,
            this.v10 + 35.0F * this.v43,
            this.v10 + this.v12 - 16.0F * this.v43,
            this.v10 + this.v12,
            0.4F
         );
         uiSupport169.v1(var1);
         var3 = var2;
      } finally {
         uiSupport169.v17();
      }

      return var3;
   }

   private void v1(boolean var1, boolean var2, long var3) {
      if (uiSupport131.v2) {
         boolean var5 = uiSupport169.v14() == var3;
         long var6 = var5 ? uiSupport169.v13() : 0L;
         if (var1 && var5 && this.v29) {
            uiSupport131.v8++;
            if (var6 != this.v28) {
               uiSupport131.v7++;
               v1.warn(
                  "the kept module list would have gone stale: a frame with an unchanged key recorded something else — an input the key does not cover, or an animator that does not report to UiMotion"
               );
            }
         }

         this.v28 = var6;
         this.v29 = var5;
      }

      this.v25.v2(this.v26);
      this.v27 = var2;
   }

   private void v8(uiSupport35 var1) {
      uiSupport102 var2 = this.v26;
      var2.v1();
      class_1041 var3 = class_310.method_1551().method_22683();
      var2.v1(var3.method_4489());
      var2.v1(var3.method_4506());
      var2.v1(var3.method_4495());
      var2.v1(renderSupport33.v2());
      var2.v1(renderSupport33.v3());
      var2.v1(this.v9);
      var2.v1(this.v10);
      var2.v1(this.v11);
      var2.v1(this.v12);
      var2.v1(this.v43);
      var2.v1(uiSupport49.v1());
      var2.v1(this.v14 == null ? -1 : this.v14.v2());
      var2.v1(this.v23);
      var2.v1(this.v59());
      var2.v1(this.v37);
      var2.v1(this.v12());
      if (this.v37 == AltManagerSupport.ACCOUNT) {
         var2.v1(this.v16.v3());
         var2.v1(SykySession.v1());
         var2.v1(this.v20.v1());
      }

      UiPopup var4 = this.v73();
      if (var4 != null) {
         var4.v1(var2);
         var2.v1(this.v20.v1());
      }

      boolean var5 = var1.v2();
      float var6 = var1.v1;
      float var7 = var1.v2;
      boolean var8 = var5 && var6 >= this.v9 && var6 < this.v9 + this.v11 && var7 >= this.v10 && var7 < this.v10 + this.v12;
      this.v17.v1(var2, this.v10, this.v10 + this.v12);
      var8 |= var5 && this.v17.v3(var6, var7);
      var2.v1(var8);
      if (var8) {
         var2.v1(var6);
         var2.v1(var7);
      }
   }

   public void v17() {
      this.v27 = false;
      this.v24.close();
   }

   private void v9(uiSupport35 var1) {
      this.v21.v1(this.v20, this.v9, this.v46(), this.v11, this.v51(), this.v46, this.v43, var1.v1, var1.v2);
   }

   private void v1(uiSupport35 var1, float var2, float var3) {
      if (!this.v30.v4().v7()) {
         this.v1(var1, this.v30.v4(), this.v53(), var2, var3, true);
      }

      if (!this.v30.v3().v7()) {
         this.v1(var1, this.v30.v3(), this.v59(), var2, var3, false);
      }
   }

   private void v1(uiSupport35 var1, uiSupport129 var2, float var3, float var4, float var5, boolean var6) {
      float var7 = var4 + var3;
      if (!uiSupport169.v2(this.v9, var7, this.v11, var5)) {
         if (!var6) {
            this.v2(var1, var7, var5);
         }
      } else {
         try {
            if (var6) {
               this.v3(var1, var7, var5);
            } else {
               this.v2(var1, var7, var5);
            }
         } finally {
            uiSupport169.v1(var2.v1(), this.v9 + this.v11 / 2.0F, var4 + var5 / 2.0F, var2.v2(), var2.v3(), this.v1(var2), this.v9, var4, this.v11, var5);
         }
      }
   }

   private float v1(uiSupport129 var1) {
      return SignInSupport.v4(var1.v4() * this.v43);
   }

   private boolean v2(uiSupport35 var1, float var2, float var3) {
      if (this.v23 > 0.0F) {
         this.v1(var1, this.v59(), this.v23, this.v37, false);
      }

      return this.v17.v1(var1, var2, var2 + var3);
   }

   private void v3(uiSupport35 var1, float var2, float var3) {
      uiSupport117 var4 = this.v31;
      if (var4 != null && !var4.v2()) {
         var4.v2(var1, var2, var2 + var3);
      } else {
         this.v1(var1.v1(), this.v53(), 1.0F, this.v33, true);
      }
   }

   private class_2960 v2(AltManagerSupport var1) {
      return this.v12() ? uiSupport143.v2 : uiSupport143.v1(var1.v2());
   }

   private void v1(uiSupport35 var1, float var2, float var3, AltManagerSupport var4, boolean var5) {
      if (var4 != AltManagerSupport.ACCOUNT || this.v12() && this.v17.v2()) {
         UiPopup var13 = this.v19.get(var4);
         if (var13 != null) {
            float var7 = var5 ? this.v34 * this.v43 : this.v20.v1();
            boolean var8 = var5 && this.v36;
            if (var8) {
               var13.v1(true);
            }

            try {
               var13.v1(this.v9, this.v10, this.v11, this.v12, var2 - var7);
               var13.v3(var1, var3);
               float var9 = var13.v5() * var3;
               if (var9 > 0.0F) {
                  this.v1(var13.v7(), var13.v6(), var2, var9);
               }
            } finally {
               if (var8) {
                  var13.v1(false);
               }
            }
         } else {
            this.v1(this.v2(var4), "Nothing found", var2, var3);
         }
      } else {
         float var6 = var5 ? this.v34 * this.v43 : this.v20.v1();
         this.v16.v1(this.v9, this.v10, this.v11, this.v12, var2 - var6);
         this.v16.v3(var1, var3);
      }
   }

   private void v1(class_2960 var1, String var2, float var3, float var4) {
      float var5 = 16.0F * this.v43;
      float var6 = 16.0F * this.v43;
      float var7 = 8.0F * this.v43;
      float var8 = uiSupport169.v2("syky_sans_strong", var2, var5);
      float var9 = this.v9 + (this.v11 - (var6 + var7 + var8)) / 2.0F;
      float var10 = this.v10 + 54.0F * this.v43;
      float var11 = this.v10 + this.v12 - 16.0F * this.v43;
      float var12 = var10 + (var11 - var10) * 0.45F + var3;
      int var13 = uiSupport155.v1(v34(), var4);
      uiSupport169.v1(var1, var9, var12 - var6 / 2.0F, var6, var6, var13, uiRecord7.ZERO);
      uiSupport169.v1("syky_sans_strong", var2, var9 + var6 + var7, uiSupport169.v1(var12, var5), var5, var13);
   }

   public void v3(uiSupport35 var1) {
      if (!this.v51.v1(var1, this.v43)) {
         this.v51.v10();
      }

      if (this.v22.v1()) {
         uiSupport169.v1(this.v22.v9, this.v22.v10, this.v22.v11, this.v22.v12);

         try {
            this.v22.v3(var1, this.v22.v2());
         } finally {
            uiSupport169.v4();
         }
      }
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4, float var5) {
      UiScreen var6 = this.v51.v1();
      if (var6 != null) {
         try {
            if (!this.v51.v1(var1, this.v43, var2, var3, var4, var5)) {
               this.v51.v10();
            }
         } finally {
            if (var6 instanceof uiSupport69 var9) {
               var9.v1(var1, var2, var3, var4, var5);
            }
         }
      }
   }

   public void v2(float[] var1) {
      var1[0] = 0.0F;
      var1[1] = 0.0F;
      var1[2] = 0.0F;
      var1[3] = 0.0F;
      boolean var2 = false;
      UiScreen var3 = this.v51.v1();
      if (var3 != null && !this.v51.v5()) {
         var2 = this.v1(var1, var3, false);
         UiNode var4 = var3.v13();

         while (var4 != null) {
            var2 = this.v1(var1, var4, var2);
            var4 = var4 instanceof uiSupport69 var5 ? var5.v13() : null;
         }
      }

      if (this.v22.v1()) {
         var2 = this.v1(var1, this.v22, var2);
      }

      if (!var2) {
         var1[2] = 0.0F;
         var1[3] = 0.0F;
      }
   }

   private boolean v1(float[] var1, UiNode var2, boolean var3) {
      float var4 = hudSupport2.v1(this.v43);
      float var5 = var2.v9 - var4;
      float var6 = var2.v10 - var4;
      float var7 = var2.v9 + var2.v11 + var4;
      float var8 = var2.v10 + var2.v12 + var4;
      if (!var3) {
         var1[0] = var5;
         var1[1] = var6;
         var1[2] = var7 - var5;
         var1[3] = var8 - var6;
         return true;
      } else {
         float var9 = Math.min(var1[0], var5);
         float var10 = Math.min(var1[1], var6);
         float var11 = Math.max(var1[0] + var1[2], var7);
         float var12 = Math.max(var1[1] + var1[3], var8);
         var1[0] = var9;
         var1[1] = var10;
         var1[2] = var11 - var9;
         var1[3] = var12 - var10;
         return true;
      }
   }

   @Nullable
   private NEWSupport v10(uiSupport35 var1) {
      if (this.v51.v1() == null && var1.v2() && this.v15.v2() && this.v3(var1.v2)) {
         NEWSupport var2 = this.v17.v2(var1.v1, var1.v2);
         return var2 != null && !var2.v3(var1.v1, var1.v2) ? var2 : null;
      } else {
         return null;
      }
   }

   @Override
   public boolean v1(float var1, float var2) {
      UiScreen var3 = this.v51.v1();
      return super.v1(var1, var2) || var3 != null && var3.v1(var1, var2);
   }

   private boolean v3(float var1) {
      float var2 = this.v46();
      return var1 >= var2 && var1 <= var2 + this.v51();
   }

   public boolean v7(float var1, float var2) {
      UiScreen var3 = this.v51.v1();
      if (var3 != null && var3.v1(var1, var2)) {
         return false;
      } else {
         UiPopup var4 = this.v73();
         return var4 == null || !var4.v5(var1, var2);
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      UiScreen var4 = this.v37();
      if (var4 != null) {
         if (var4.v1(var1, var2)) {
            return var4.v1(var1, var2, var3);
         } else {
            this.v3(var1, var2, var3);
            return true;
         }
      } else {
         UiScreen var5 = this.v51.v1();
         if (var5 != null && var5.v1(var1, var2)) {
            return true;
         } else if (!super.v1(var1, var2)) {
            return false;
         } else if (var3 == 0 && this.v21.v1(this.v20, var1, var2)) {
            this.v53 = false;
            return true;
         } else if (this.v3(var2)) {
            if (this.v75() && this.v16.v1(var1, var2, var3)) {
               return true;
            } else {
               UiPopup var7 = this.v73();
               return var7 != null ? var7.v1(var1, var2, var3) : this.v17.v2(var1, var2, var3);
            }
         } else {
            UiPopup var6 = this.v73();
            return var6 != null && var6.v5(var1, var2) && var6.v1(var1, var2, var3);
         }
      }
   }

   @Override
   public void v2(String var1) {
      AltManagerSupport var2 = this.v37;
      if (this.v16.v1(var1)) {
         this.v18 = var2 == AltManagerSupport.ACCOUNT ? null : var2;
         uiSupport139.v1(AltManagerSupport.ACCOUNT);
         uiSupport139.v1(0.0F);
         this.v1(AltManagerSupport.ACCOUNT);
      }
   }

   @Override
   public boolean v1(int var1) {
      UiPopup var2 = this.v73();
      if (var2 == null) {
         return false;
      } else {
         boolean var3 = !this.v30.v2();
         if (var3) {
            this.v31 = null;
            this.v34 = this.v43 > 0.0F ? this.v20.v1() / this.v43 : 0.0F;
            this.v36 = true;
            this.v33 = this.v37;
         }

         this.v4();
         this.v20.v5(0.0F);
         this.v21.v2();
         this.v53 = false;
         this.v30.v1(var1);
         return var3 && this.v30.v1();
      }
   }

   @Override
   public uiSupport120 v20() {
      return this;
   }

   public void v21() {
      this.v18 = null;
      this.v16.v2();
   }

   private void v52() {
      AltManagerSupport var1 = this.v18;
      this.v18 = null;
      if (var1 == null) {
         this.v16.v2();
      } else {
         uiSupport139.v1(var1);
         uiSupport139.v1(0.0F);
         this.v1(var1);
      }
   }

   private boolean v75() {
      return this.v37 == AltManagerSupport.ACCOUNT && !this.v12();
   }

   @Nullable
   private UiPopup v73() {
      return this.v19.get(this.v37);
   }

   @Override
   public void v2(UiScreen var1) {
      this.v4();
      this.v20.v5(this.v20.v1());
      float var2 = var1.a_(624.0F);
      float var3 = this.v9 + this.v11 / 2.0F;
      float var4 = this.v10 + this.v12 / 2.0F;
      uiSupport89.v1(var1, var3 - var1.v2() * this.v43 / 2.0F, var4 - var2 * this.v43 / 2.0F, var1.v2(), var2, this.v43, this.v9);
      this.v4(var1, var3, var4);
   }

   @Override
   public void v2(UiScreen var1, float var2, float var3) {
      this.v4();
      this.v3(var1, var2, var3);
   }

   @Override
   public void v1(UiScreen var1, float var2, float var3, String var4) {
      this.v2(var1, var2, var3);
      uiSupport139.v1(uiSupport139.Part1.PAGE_WINDOW, var4, this.v51.v3(), this.v51.v4());
   }

   @Override
   public boolean v3(UiScreen var1) {
      return this.v37() == var1;
   }

   @Nullable
   public String v22() {
      UiPopup var1 = this.v73();
      return var1 == null ? null : var1.v11();
   }

   @Nullable
   public class_2960 v24() {
      UiPopup var1 = this.v73();
      return var1 == null ? null : var1.d_();
   }

   public boolean v25() {
      UiPopup var1 = this.v73();
      return var1 != null && var1.h_();
   }

   @Nullable
   public String v26() {
      UiPopup var1 = this.v73();
      return var1 == null ? null : var1.v14();
   }

   public boolean v27() {
      UiPopup var1 = this.v73();
      return var1 != null && var1.v15();
   }

   public void v8(float var1, float var2) {
      UiPopup var3 = this.v73();
      if (var3 != null) {
         var3.v4(var1, var2);
      }
   }

   public void v9(float var1, float var2) {
      UiPopup var3 = this.v73();
      if (var3 != null) {
         var3.v6(var1, var2);
      }
   }

   public boolean v28() {
      UiPopup var1 = this.v73();
      return var1 != null && var1.v16();
   }

   @Override
   public boolean v1(UiPopup var1) {
      return this.v73() == var1;
   }

   @Override
   public float v29() {
      return this.v20.v1();
   }

   @Override
   public float v30() {
      return this.v20.v3();
   }

   public boolean v32() {
      UiPopup var1 = this.v73();
      return var1 == null || var1.v21();
   }

   public boolean v23() {
      UiPopup var1 = this.v73();
      return var1 != null && var1.v22();
   }

   public boolean v33() {
      UiPopup var1 = this.v73();
      return var1 != null && var1.v24();
   }

   public void v10(float var1, float var2) {
      UiPopup var3 = this.v73();
      if (var3 != null) {
         var3.v7(var1, var2);
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      UiScreen var3 = this.v37();
      if (var3 != null) {
         if (var3.v1(var1, var2)) {
            return var3.v2(var1, var2);
         } else {
            NEWSupport var6 = this.v12(var1, var2);
            return var6 != null && var6.v2(var1, var2, 0) ? hudSupport54.POINTER : hudSupport54.ARROW;
         }
      } else {
         UiScreen var4 = this.v51.v1();
         if (var4 != null && var4.v1(var1, var2)) {
            return hudSupport54.ARROW;
         } else if (!super.v1(var1, var2)) {
            return hudSupport54.ARROW;
         } else if (this.v21.v1(var1, var2)) {
            return hudSupport54.POINTER;
         } else if (this.v3(var2)) {
            if (this.v75()) {
               return this.v16.v2(var1, var2);
            } else {
               UiPopup var7 = this.v73();
               return var7 != null ? var7.v2(var1, var2) : this.v17.v4(var1, var2);
            }
         } else {
            UiPopup var5 = this.v73();
            return var5 != null && var5.v5(var1, var2) ? var5.v2(var1, var2) : hudSupport54.ARROW;
         }
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      if (this.v21.v4()) {
         return hudSupport54.POINTER;
      } else {
         UiScreen var1 = this.v37();
         if (var1 != null) {
            return var1.v31();
         } else {
            UiPopup var2 = this.v73();
            return var2 == null ? null : var2.v31();
         }
      }
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      if (this.v21.v3()) {
         return true;
      } else {
         UiScreen var4 = this.v37();
         if (var4 != null) {
            return var4.v4(var1, var2, var3);
         } else {
            UiPopup var5 = this.v73();
            return var5 != null && var5.v4(var1, var2, var3);
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      if (this.v21.v1(this.v20, var2)) {
         this.v53 = false;
         return true;
      } else {
         UiScreen var6 = this.v37();
         if (var6 != null) {
            return var6.v1(var1, var2, var3, var4, var5);
         } else {
            UiPopup var7 = this.v73();
            return var7 != null && var7.v1(var1, var2, var3, var4, var5);
         }
      }
   }

   @Override
   public void v11(float var1, float var2) {
      UiScreen var3 = this.v37();
      if (var3 != null) {
         var3.v11(var1, var2);
      }
   }

   @Override
   public boolean v1(float var1, float var2, double var3, double var5) {
      UiScreen var7 = this.v51.v1();
      if (var7 != null && var7.v1(var1, var2)) {
         UiScreen var8 = this.v37();
         if (var8 != null) {
            var8.v1(var1, var2, var3, var5);
         }

         return true;
      } else if (super.v1(var1, var2) && this.v3(var2) && !(this.v20.v3() <= 0.0F)) {
         this.v20.v2((float)(-var5) * 54.0F * this.v43);
         this.v21.v1();
         this.v53 = false;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean v2(int var1, int var2) {
      UiScreen var3 = this.v37();
      if (var3 != null) {
         return var3.v2(var1, var2);
      } else {
         UiPopup var4 = this.v73();
         return var4 != null && var4.v2(var1, var2);
      }
   }

   @Override
   public boolean v3(int var1, int var2) {
      UiScreen var3 = this.v37();
      if (var3 != null) {
         return var3.v3(var1, var2);
      } else {
         UiPopup var4 = this.v73();
         return var4 != null && var4.v3(var1, var2);
      }
   }
}
