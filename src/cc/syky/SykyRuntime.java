package cc.syky;

import cc.syky.account.AccountStore;
import cc.syky.account.AltCommand;
import cc.syky.account.SMTCMusicSupport;
import cc.syky.account.accountSupport16;
import cc.syky.account.accountSupport18;
import cc.syky.account.accountSupport19;
import cc.syky.account.accountSupport22;
import cc.syky.auth.MicrosoftAuth;
import cc.syky.cloud.AltManagerSupport2;
import cc.syky.cloud.CloudClient;
import cc.syky.cloud.CrashTestSupport;
import cc.syky.cloud.PresenceService;
import cc.syky.cloud.RenderThreadSupport;
import cc.syky.cloud.SignedInSupport;
import cc.syky.cloud.TryingOnSupport;
import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudRecord11;
import cc.syky.cloud.cloudSupport;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import cc.syky.cloud.cloudSupport29;
import cc.syky.cloud.cloudSupport31;
import cc.syky.cloud.cloudSupport53;
import cc.syky.cloud.cloudSupport54;
import cc.syky.cloud.cloudSupport61;
import cc.syky.cloud.cloudSupport64;
import cc.syky.cloud.cloudSupport68;
import cc.syky.cloud.cloudSupport71;
import cc.syky.cloud.cloudSupport72;
import cc.syky.cloud.cloudSupport73;
import cc.syky.cloud.cloudSupport74;
import cc.syky.cloud.cloudSupport75;
import cc.syky.cloud.cloudSupport76;
import cc.syky.cloud.cloudSupport77;
import cc.syky.cloud.cloudSupport78;
import cc.syky.cloud.cloudSupport80;
import cc.syky.cloud.cloudSupport83;
import cc.syky.cloud.cloudSupport85;
import cc.syky.cloud.cloudSupport91;
import cc.syky.cloud.cloudSupport92;
import cc.syky.cloud.cloudSupport95;
import cc.syky.cloud.cloudSupport99;
import cc.syky.config.ActionSetting;
import cc.syky.config.ConfigUi;
import cc.syky.config.NewConfigSupport;
import cc.syky.config.configSupport10;
import cc.syky.crash.CrashReporter;
import cc.syky.hud.BossBarSupport2;
import cc.syky.hud.DurabilityAlertSupport;
import cc.syky.hud.HudManager;
import cc.syky.hud.ItemPickupsSupport;
import cc.syky.hud.MicrosoftBasicSupport;
import cc.syky.hud.MySettingsSupport;
import cc.syky.hud.NoItemsSupport;
import cc.syky.hud.hudSupport23;
import cc.syky.hud.hudSupport27;
import cc.syky.hud.hudSupport48;
import cc.syky.hud.hudSupport51;
import cc.syky.hud.hudSupport7;
import cc.syky.hud.hudSupport71;
import cc.syky.hud.hudSupport75;
import cc.syky.internal.InternalSupport;
import cc.syky.internal.InternalSupport13;
import cc.syky.internal.InternalSupport16;
import cc.syky.internal.InternalSupport17;
import cc.syky.internal.InternalSupport18;
import cc.syky.internal.InternalSupport19;
import cc.syky.internal.InternalSupport20;
import cc.syky.internal.InternalSupport24;
import cc.syky.internal.InternalSupport26;
import cc.syky.internal.InternalSupport27;
import cc.syky.internal.InternalSupport28;
import cc.syky.internal.InternalSupport29;
import cc.syky.internal.InternalSupport30;
import cc.syky.internal.InternalSupport31;
import cc.syky.internal.InternalSupport32;
import cc.syky.internal.InternalSupport37;
import cc.syky.internal.InternalSupport38;
import cc.syky.internal.InternalSupport4;
import cc.syky.internal.InternalSupport43;
import cc.syky.internal.InternalSupport46;
import cc.syky.internal.InternalSupport48;
import cc.syky.internal.InternalSupport5;
import cc.syky.internal.InternalSupport51;
import cc.syky.internal.InternalSupport52;
import cc.syky.internal.InternalSupport53;
import cc.syky.internal.InternalSupport54;
import cc.syky.internal.InternalSupport55;
import cc.syky.internal.InternalSupport56;
import cc.syky.internal.InternalSupport57;
import cc.syky.internal.InternalSupport58;
import cc.syky.internal.InternalSupport59;
import cc.syky.internal.InternalSupport6;
import cc.syky.internal.InternalSupport60;
import cc.syky.internal.InternalSupport61;
import cc.syky.internal.InternalSupport7;
import cc.syky.internal.InternalSupport8;
import cc.syky.module.ModuleContract;
import cc.syky.module.advanced.StreamerMode;
import cc.syky.module.utilities.AutoRespawn;
import cc.syky.module.utilities.BorderlessFullscreen;
import cc.syky.module.utilities.CapsFix;
import cc.syky.module.utilities.ChatCamera;
import cc.syky.module.utilities.ChatHeads;
import cc.syky.module.utilities.ChatPing;
import cc.syky.module.utilities.ChatReveal;
import cc.syky.module.utilities.ChatStack;
import cc.syky.module.utilities.ChunkBorders;
import cc.syky.module.utilities.CommandFix;
import cc.syky.module.utilities.DropGuard;
import cc.syky.module.utilities.DurabilityGuard;
import cc.syky.module.utilities.FOV;
import cc.syky.module.utilities.FogBlurSupport;
import cc.syky.module.utilities.FoodSaturation;
import cc.syky.module.utilities.Freelook;
import cc.syky.module.utilities.HotbarKeys;
import cc.syky.module.utilities.InfiniteChatHistory;
import cc.syky.module.utilities.LightOverlay;
import cc.syky.module.utilities.PumpkinOverlay;
import cc.syky.module.utilities.PvPLeaveConfirm;
import cc.syky.module.utilities.ReconnectButton;
import cc.syky.module.utilities.SafeInteraction;
import cc.syky.module.utilities.ShulkerPreview;
import cc.syky.module.utilities.SlotHighlight;
import cc.syky.module.utilities.Sprint;
import cc.syky.module.utilities.TNTTimer;
import cc.syky.module.utilities.ThirdPerson;
import cc.syky.module.utilities.ToggleSneak;
import cc.syky.module.utilities.Zoom;
import cc.syky.module.visual.AspectRatio;
import cc.syky.module.visual.BlockOverlay;
import cc.syky.module.visual.BushyLeaves;
import cc.syky.module.visual.ColorCorrection;
import cc.syky.module.visual.CustomCrosshair;
import cc.syky.module.visual.CustomEnchantGlint;
import cc.syky.module.visual.CustomEndCrystal;
import cc.syky.module.visual.CustomFireOverlay;
import cc.syky.module.visual.CustomFog;
import cc.syky.module.visual.CustomHearts;
import cc.syky.module.visual.CustomHitbox;
import cc.syky.module.visual.CustomHurtColor;
import cc.syky.module.visual.CustomShield;
import cc.syky.module.visual.CustomSky;
import cc.syky.module.visual.CustomSounds;
import cc.syky.module.visual.CustomTotemPop;
import cc.syky.module.visual.CustomWater;
import cc.syky.module.visual.EffectAlerts;
import cc.syky.module.visual.FastGrass;
import cc.syky.module.visual.FocusFade;
import cc.syky.module.visual.FogBlur;
import cc.syky.module.visual.FullBright;
import cc.syky.module.visual.HealthAdvantage;
import cc.syky.module.visual.HealthIndicator;
import cc.syky.module.visual.HideArmor;
import cc.syky.module.visual.InventoryBackground;
import cc.syky.module.visual.ItemPhysic;
import cc.syky.module.visual.LootBeams;
import cc.syky.module.visual.MotionBlur;
import cc.syky.module.visual.NoShading;
import cc.syky.module.visual.Particles;
import cc.syky.module.visual.PingTags;
import cc.syky.module.visual.RainDrops;
import cc.syky.module.visual.Removals;
import cc.syky.module.visual.SelfNametag;
import cc.syky.module.visual.TargetMarker;
import cc.syky.module.visual.TierTagger;
import cc.syky.module.visual.TimeChanger;
import cc.syky.module.visual.Tracker;
import cc.syky.module.visual.ViewModel;
import cc.syky.module.visual.WeatherChanger;
import cc.syky.module.visual.WetSurfaces;
import cc.syky.module.visual.WorldTint;
import cc.syky.module.visual.visualSupport18;
import cc.syky.module.visual.visualSupport23;
import cc.syky.module.visual.visualSupport24;
import cc.syky.module.visual.visualSupport3;
import cc.syky.module.visual.visualSupport51;
import cc.syky.module.visual.visualSupport54;
import cc.syky.module.visual.visualSupport56;
import cc.syky.module.visual.visualSupport61;
import cc.syky.module.visual.visualSupport9;
import cc.syky.render.renderSupport46;
import cc.syky.serverrules.ServerRulesStore;
import cc.syky.storage.SykyPaths;
import cc.syky.ui.MicrosoftSignSupport;
import cc.syky.ui.MultiplayerSupport;
import cc.syky.ui.NothingFoundSupport;
import cc.syky.ui.PRODSupport;
import cc.syky.ui.SKINSupport;
import cc.syky.ui.UserAgentSupport;
import cc.syky.ui.uiRecord10;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiRecord9;
import cc.syky.ui.uiSupport140;
import cc.syky.ui.uiSupport146;
import cc.syky.ui.uiSupport148;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport226;
import cc.syky.ui.uiSupport227;
import cc.syky.ui.uiSupport242;
import cc.syky.ui.uiSupport246;
import cc.syky.ui.uiSupport248;
import cc.syky.ui.uiSupport258;
import cc.syky.ui.uiSupport260;
import cc.syky.ui.uiSupport261;
import cc.syky.ui.uiSupport62;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientWorldEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientWorldEvents.AfterClientWorldChange;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.Disconnect;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.Join;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.BeforeBlockOutline;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.BeforeEntities;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.BeforeTranslucent;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.DebugRender;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.EndMain;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_124;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3264;
import net.minecraft.class_3300;
import net.minecraft.class_4013;
import net.minecraft.class_4184;
import net.minecraft.class_642;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SykyRuntime {
   private static final Logger v1 = LoggerFactory.getLogger("syky.root");
   private final uiSupport260 v2 = new uiSupport260("modules (settings preview)");
   private final uiSupport260 v3 = new uiSupport260("world-render (lines)");
   private final uiSupport260 v4 = new uiSupport260("world-render (solid depth copy)");
   private final uiSupport260 v5 = new uiSupport260("world-render (wet surfaces)");
   private final uiSupport260 v6 = new uiSupport260("world-render (label submit)");
   private final uiSupport260 v7 = new uiSupport260("world-render (block outline)");
   private final uiSupport260 v8 = new uiSupport260("hud (backdrop capture)");
   private final uiSupport260 v9 = new uiSupport260("hud (tracker markers)");
   private final uiSupport260 v10 = new uiSupport260("hud (waypoint markers)");
   private final uiSupport260 v11 = new uiSupport260("world-render (block overlays)");
   private final uiSupport260 v12 = new uiSupport260("hud (under-hotbar)");
   private final uiSupport260 v13 = new uiSupport260("hud");
   private final uiSupport260 v14 = new uiSupport260("hud (perf overlay)");
   private final uiSupport260 v15 = new uiSupport260("config (auto-save)");
   private final uiSupport260 v16 = new uiSupport260("connection (world join)");
   private final uiSupport260 v18 = new uiSupport260("connection (disconnect)");
   private final uiSupport260 v19 = new uiSupport260("cloud (world join)");
   private final uiSupport260 v17 = new uiSupport260("cloud (disconnect)");
   private final uiSupport260 v20 = new uiSupport260("cloud (world change)");
   public final uiSupport260 v21 = new uiSupport260("resources (hud bake cache)");
   private static final class_2960 v22 = class_2960.method_60655("syky", "hud");
   private static final class_2960 v24 = class_2960.method_60655("syky", "hud_under_hotbar");
   private static final class_2960 v25 = class_2960.method_60655("syky", "hud_under_spectator_menu");
   private static final class_2960 v26 = class_2960.method_60655("syky", "perf");
   private static final class_2960 v27 = class_2960.method_60655("syky", "backdrop_capture");
   private static final String v28 = "module._server.refused";
   private static final long v29 = 500L;
   private static final long v30 = 250L;
   private static final int v32 = 100;
   private static final int v23 = 20;
   private static final int v33 = 10;
   private static final int v31 = 15;
   private static final int v34 = 0;
   private static final int v36 = 20;
   private static final int v38 = 0;
   private static final int v42 = 5;
   private static final int v43 = 200;
   private final cloudSupport92 v37;
   private final cloudSupport101 v48;
   private final cloudSupport53 v40;
   private final uiSupport258 v44;
   private final MySettingsSupport v47;
   private final configSupport10 v49;
   private final uiSupport226 v46;
   private final hudSupport75 v51;
   private final InternalSupport24 v50;
   private final cloudSupport99 v60;
   private final cloudSupport80 v59;
   private final InternalSupport57 v53;
   private final InternalSupport57 v63;
   private final InternalSupport56 v64;
   private final uiRecord14 v61;
   private final renderSupport46 v66;
   private final cloudSupport2 v68;
   private final HudManager v52;
   private final InternalSupport20 v75;
   private final hudSupport51 v73;
   private final cloudSupport95 v74;
   private final InternalSupport7 v72;
   private final InternalSupport4 v80;
   private final cloudSupport v84;
   private final InternalSupport5 v94;
   private final InternalSupport6 v82;
   private final InternalSupport18 v99;
   private final MicrosoftBasicSupport v120;
   private final uiSupport246 v88;
   private final MultiplayerSupport v103;
   private final CloudClient v101;
   private final ServerRulesStore v96;
   private final InternalSupport30 v105;
   private final MicrosoftSignSupport v87;
   private final SKINSupport v85;
   @Nullable
   private AltCommand v119;
   private final cloudSupport85 v98;
   private final InternalSupport61 v124;
   private final InternalSupport60 v117;
   private final cloudSupport54 v45;
   private final RenderThreadSupport v104;
   private final InternalSupport46 v125;
   private final InternalSupport27 v141;
   private final NewConfigSupport v145;
   private final InternalSupport13 v162;
   private final InternalSupport v107;
   private final SykyPaths v118;
   private final visualSupport18 v159;
   private final hudSupport71 v176;
   private boolean v116;
   private boolean v147;
   @Nullable
   private InternalSupport29 v93;

   public SykyRuntime(SykyPaths var1) {
      this.v118 = var1;
      this.v40 = new cloudSupport53();
      this.v44 = new uiSupport258(this.v40);
      this.v37 = new cloudSupport91();
      this.v48 = new cloudSupport64();
      this.v47 = new MySettingsSupport(var1.v1(), var1.v2(), this.v44);
      this.v46 = new uiSupport226(this.v47, this.v44);
      this.v60 = new cloudSupport99(this.v47);
      this.v60.v1("clickgui", "Click GUI", cloudRecord10.v1(344));
      this.v59 = new cloudSupport80(this.v44);
      this.v53 = new InternalSupport57(2);
      this.v63 = new InternalSupport57(1);
      this.v64 = new InternalSupport56(this.v44);
      this.v61 = new uiRecord14(this.v37, this.v48, this.v53, this.v64);
      this.v162 = new InternalSupport13(var1.v5(), this.v53);
      this.v107 = new InternalSupport(var1.v5());
      this.v66 = new renderSupport46(this.v48, this.v40);
      this.v68 = new cloudSupport2(this.v48, this.v37, this.v46, null);
      this.v52 = new HudManager(this.v47, this.v48, this.v68, this.v44);
      this.v99 = (InternalSupport18)(Boolean.getBoolean("syky.noMusicBridge")
         ? v34()
         : new InternalSupport16(() -> SMTCMusicSupport.v1(var1.v4().resolve("winrt")), v34(), this.v53));
      this.v73 = new hudSupport51(this.v52);
      this.v72 = new InternalSupport7(new InternalSupport8(var1.v9()), InternalSupport7.v1(), this.v64::v1);
      this.v74 = cloudSupport95.v1(new uiSupport227(this.v46, this::v1), this.v73, this.v72.v18(), new NextTrackSupport(this.v99));
      this.v51 = new hudSupport75(this.v74, this.v47);
      this.v51.v1(this.v72.v19());
      this.v72.v1(this.v51::v1);
      this.v80 = new InternalSupport4(this.v48, this.v72);
      this.v84 = new cloudSupport(this.v48, this.v72);
      this.v94 = new InternalSupport5(this.v48, this.v72, this.v63::v1);
      this.v82 = new InternalSupport6(this.v48, this.v72);
      this.v68.v1(this.v51, this.v52);
      this.v68.v1(this.v72);
      this.v50 = new InternalSupport24(this.v51, this.v74);
      this.v52.v1(this.v51, this.v73);
      this.v75 = new InternalSupport20(this.v47, this.v53);
      this.v120 = new MicrosoftBasicSupport();
      this.v88 = new uiSupport246();
      this.v103 = new MultiplayerSupport(this.v48, this.v88);
      this.v101 = new CloudClient(var1.v10().resolve("cloud.json"), new PresenceService(this.v48, this.v64));
      this.v96 = new ServerRulesStore(var1.v4().resolve("server_rules.json"), this.v64::v1);
      this.v105 = new InternalSupport30(this.v96, this.v46);
      this.v96.v1(this.v105::v2);
      this.v96.v1(cloudSupport61.v1("cc/syky/serverrules/server_rules.json", 524288L));
      this.v101.v1(this.v96);
      PRODSupport var2 = new PRODSupport(this.v48);
      this.v87 = new MicrosoftSignSupport(
         new AccountStore(var1.v8(), uiSupport261.v3()),
         new MicrosoftAuth(new UserAgentSupport("syky"), System::currentTimeMillis),
         var2,
         this.v64::v1,
         System::currentTimeMillis
      );
      this.v85 = new SKINSupport(this.v48, var2);
      ArrayList var3 = new ArrayList();

      for (BossBarSupport2 var7 : BossBarSupport2.values()) {
         var3.add(new cloudSupport85.Part1(var7.v2(), () -> this.v52.v3(var7)));
      }

      for (AltManagerSupport2 var11 : AltManagerSupport2.values()) {
         var3.add(new cloudSupport85.Part1(var11.v2(), switch (var11) {
            case WAYPOINTS -> () -> !this.v72.v11().isEmpty();
            case ALT_MANAGER -> this.v87::v8;
         }));
      }

      this.v98 = new cloudSupport85(this.v46::v1, var3, this::v31, this.v101::v7, this.v101::v1);
      this.v124 = new InternalSupport61(var1.v10().resolve("cosmetics-dev"), this.v53::v1, this.v101.v1(var1.v4().resolve("cosmetics")));
      this.v117 = new InternalSupport60(this.v124);
      this.v101.v1(this.v117);
      InternalSupport38.v1(this.v117, this.v53, this.v44);
      this.v45 = new cloudSupport54(this.v40, () -> this.v66.v6().v3());
      this.v104 = new RenderThreadSupport(Syky::lastTickAtMillis, 500L, 250L, CrashReporter.v3());
      this.v125 = new InternalSupport46(this.v48, this.v53, this.v64);
      this.v141 = new InternalSupport27(this.v48, this.v59);
      this.v49 = new configSupport10(this.v47);
      this.v145 = new NewConfigSupport(
         this.v47,
         var1.v10(),
         List.of(
            new ActionSetting("modules", this.v46::v3, this.v46::v2),
            new ActionSetting("binds", this.v51::v3, this.v51::v4),
            new ActionSetting("actions", this.v60::v4, this.v60::v5),
            new ActionSetting("hud", this::v48, this.v52::v13),
            new ActionSetting("hudimages", this.v75::v4, this.v75::v5),
            ActionSetting.v1("gui", this.v49::v1)
         )
      );
      this.v159 = new visualSupport18(this.v48, this.v37);
      this.v176 = new hudSupport71(this.v48, this.v37);
   }

   private void v23() {
      if (this.v52.v3(BossBarSupport2.CPU) || this.v52.v3(BossBarSupport2.GPU)) {
         this.v120.v1();
      }

      if (this.v52.v3(BossBarSupport2.MUSIC) && this.v99 instanceof InternalSupport16 var1) {
         var1.v8();
      }
   }

   private List<String> v33() {
      ArrayList var1 = new ArrayList();

      for (ModuleContract var3 : this.v46.v1()) {
         if (var3.isEnabled()) {
            var1.add(var3.getName());
         }
      }

      return var1;
   }

   @Nullable
   private static String v1(class_310 var0) {
      class_642 var1 = var0.method_1558();
      if (var1 != null && !var0.method_1496()) {
         String var2 = var1.method_52811() ? null : InternalSupport55.v1();
         return var2 != null ? var2 : var1.field_3761;
      } else {
         return null;
      }
   }

   private void v1(ModuleContract var1, String var2) {
      class_310 var3 = this.v48.v1();
      if (var3 != null && var3.field_1705 != null) {
         String var4 = FogBlurSupport.v1("module._server.refused", "is off on");
         var3.field_1705.method_1758(class_2561.method_43470(var1.getDisplayName() + " " + var4 + " " + var2).method_27692(class_124.field_1061), false);
      }
   }

   private List<String> v31() {
      ArrayList var1 = new ArrayList();

      for (cloudRecord11 var3 : this.v51.v6()) {
         if (var3.v3() != -1) {
            var1.add(var3.v2());
         }
      }

      return var1;
   }

   private static InternalSupport18 v34() {
      return (InternalSupport18)(Boolean.getBoolean("syky.devMusic")
         ? new InternalSupport19(new sykyRecord7("Break it off", "PinkPantheress", 96, null))
         : InternalSupport17.v2);
   }

   public NewConfigSupport v1() {
      return this.v145;
   }

   public renderSupport46 v2() {
      return this.v66;
   }

   public HudManager v3() {
      return this.v52;
   }

   public cloudSupport2 v4() {
      return this.v68;
   }

   public cloudSupport92 v5() {
      return this.v37;
   }

   public cloudSupport101 v6() {
      return this.v48;
   }

   public MySettingsSupport v7() {
      return this.v47;
   }

   public uiSupport226 v8() {
      return this.v46;
   }

   public hudSupport75 v9() {
      return this.v51;
   }

   public cloudSupport95 v10() {
      return this.v74;
   }

   public InternalSupport7 v11() {
      return this.v72;
   }

   public InternalSupport4 v12() {
      return this.v80;
   }

   public InternalSupport6 v13() {
      return this.v82;
   }

   public cloudSupport99 v14() {
      return this.v60;
   }

   public cloudSupport80 v15() {
      return this.v59;
   }

   public MicrosoftSignSupport v16() {
      return this.v87;
   }

   public SKINSupport v18() {
      return this.v85;
   }

   public InternalSupport60 v19() {
      return this.v117;
   }

   public InternalSupport61 v17() {
      return this.v124;
   }

   public InternalSupport57 v20() {
      return this.v53;
   }

   public InternalSupport56 v21() {
      return this.v64;
   }

   public cloudSupport53 v22() {
      return this.v40;
   }

   public uiSupport258 v24() {
      return this.v44;
   }

   private static void v2(boolean var0) {
      int var1 = uiSupport169.v1("gpu.world.seam");

      try {
         visualSupport9.v1(var0, visualSupport51.v46 || visualSupport51.v44, visualSupport51.v59 || visualSupport51.v53, InternalSupport48.v1());
      } finally {
         uiSupport169.v1(var1);
      }
   }

   private static void v36() {
      class_4184 var0 = class_310.method_1551().field_1773.method_19418();
      int var1 = uiSupport169.v1("gpu.world.wetsurfaces");

      try {
         cloudSupport29.v2(var0);
      } finally {
         uiSupport169.v1(var1);
      }
   }

   private static void v38() {
      class_4184 var0 = class_310.method_1551().field_1773.method_19418();
      if (accountSupport22.v1(var0)) {
         int var1 = uiSupport169.v1("gpu.world.wetsurfaces");

         try {
            cloudSupport29.v1(var0);
         } finally {
            uiSupport169.v1(var1);
         }
      }
   }

   public boolean v1(boolean var1) {
      if (var1 && !InternalSupport37.v1()) {
         return false;
      } else {
         this.v66.v1().v1(var1);
         return true;
      }
   }

   public cloudSupport54 v25() {
      return this.v45;
   }

   public InternalSupport46 v26() {
      return this.v125;
   }

   public InternalSupport27 v27() {
      return this.v141;
   }

   public InternalSupport13 v28() {
      return this.v162;
   }

   public InternalSupport v29() {
      return this.v107;
   }

   public void v30() {
      this.v93 = InternalSupport29.v1(this.v118.v10());
      cloudSupport68.v1();
      this.v145.v1();
      this.v145.v2();
      this.v47.v5();
      this.v46.v1(this.v37);
      this.v42();
      CrashReporter.v1(this::v33);
      this.v51.v3();
      this.v60.v4();
      this.v43();
      this.v37();

      try {
         this.v52.v12();
         this.v75.v4();
      } catch (RuntimeException var2) {
         v1.error("HUD layout failed to load; using defaults", var2);
      }

      this.v66.v3();
      uiSupport169.v1(this.v66);
      visualSupport9.v1(this.v66.v23());
      InternalSupport32.v1(this.v48);
      this.v44();
      this.v103.v1();
      this.v88.v1();
      this.v40();
      this.v145.v3();
      this.v47();
      this.v23();
      this.v104.v1();
      uiSupport248 var1 = CrashReporter.v1();
      if (var1 != null) {
         this.v101.v1(var1);
      }

      this.v101.v5();
      this.v87.v1();
      this.v72.v2();
      this.v162.v1();
      this.v116 = true;
      v1.info(
         "started ({} module(s), {} command(s), {} bind(s), {} hud element(s))",
         new Object[]{this.v46.v1().size(), this.v59.v1().size(), this.v51.v6().size(), this.v52.v9().size()}
      );
   }

   public synchronized void v32() {
      if (!this.v147) {
         this.v147 = true;
         v1("stuck detector", this.v104::close);
         if (this.v116) {
            v1("settings flush", this.v145::v9);
         }

         v1("config writer", this.v145::v11);
         InternalSupport29 var1 = this.v93;
         if (var1 != null) {
            v1("instance lock", var1::close);
         }

         if (this.v99 instanceof AutoCloseable var2) {
            v1("music source", var2::close);
         }

         v1("hardware monitor", this.v120::close);
         v1("discord rich presence", this.v88::close);
         if (this.v116) {
            v1("usage report", this.v98::v1);
         }

         v1("cloud", this.v101::close);
         v1("account switcher", this.v87::close);
         v1("waypoints", this.v72::close);
         v1("render teardown", () -> {
            InternalSupport53.v1();
            visualSupport54.v1();
            InternalSupport32.v1();
            visualSupport9.v6();
            uiSupport169.v7();
            this.v66.v4();
         });
         v1("custom sounds", visualSupport3::v1);
         v1("interface sounds", uiSupport148::v1);
         v1("audio engine", InternalSupport28::v2);
         v1("updater", this.v162::close);
         v1("worker pool", this.v53::close);
         v1("mesh worker", this.v63::close);
         v1.info("stopped");
      }
   }

   private static void v1(String var0, SykyRuntime.Part1 var1) {
      try {
         var1.run();
      } catch (Throwable var3) {
         v1.warn("{} teardown failed", var0, var3);
      }
   }

   private void v42() {
      this.v46.v1(new FullBright());
      this.v46.v1(new NoShading(this.v61));
      this.v46.v1(new ColorCorrection());
      this.v46.v1(new WorldTint());
      this.v46.v1(new TimeChanger());
      this.v46.v1(new CustomSky(this.v61, this.v118.v4().resolve("sky")));
      this.v46.v1(new WeatherChanger());
      this.v46.v1(new CustomFog());
      this.v46.v1(new FogBlur());
      this.v46.v1(new WetSurfaces());
      this.v46.v1(new Particles(this.v61));
      this.v46.v1(new FastGrass(this.v61));
      this.v46.v1(new BushyLeaves(this.v61));
      this.v46.v1(new Removals());
      ViewModel var1 = new ViewModel(this.v61);
      this.v46.v1(var1);
      this.v52.v3().v1(var1);
      this.v46.v1(new AspectRatio(this.v61));
      this.v46.v1(new MotionBlur());
      this.v46.v1(new CustomCrosshair());
      this.v46.v1(new TargetMarker(this.v61, this.v159));
      this.v46.v1(new BlockOverlay(this.v61));
      this.v46.v1(new Tracker(this.v61));
      this.v46.v1(new CustomWater(this.v61));
      this.v46.v1(new CustomFireOverlay());
      this.v46.v1(new RainDrops(this.v61));
      this.v46.v1(new SelfNametag());
      this.v46.v1(new CustomEnchantGlint());
      this.v46.v1(new HideArmor());
      this.v46.v1(new ItemPhysic());
      this.v46.v1(new LootBeams(this.v61));
      this.v46.v1(new InventoryBackground(this.v61));
      this.v46.v1(new CustomSounds(this.v61, this.v118.v3()));
      this.v46.v1(new FocusFade(this.v61));
      this.v46.v1(new HealthIndicator(this.v61));
      this.v46.v1(new HealthAdvantage(this.v61, this.v159));
      this.v46.v1(new CustomHearts());
      this.v46.v1(new TierTagger(this.v61));
      this.v46.v1(new PingTags(this.v61));
      this.v46.v1(new CustomHitbox(this.v61));
      this.v46.v1(new CustomHurtColor());
      this.v46.v1(new EffectAlerts(this.v61));
      this.v46.v1(new CustomShield(this.v61));
      this.v46.v1(new CustomTotemPop());
      this.v46.v1(new CustomEndCrystal());
      this.v46.v1(new Zoom());
      this.v46.v1(new FOV());
      this.v46.v1(new Freelook(this.v61));
      this.v46.v1(new ThirdPerson(this.v61));
      this.v46.v1(new ChatCamera(this.v61));
      this.v46.v1(new Sprint());
      this.v46.v1(new ToggleSneak(this.v61));
      this.v46.v1(new AutoRespawn(this.v61));
      this.v46.v1(new PumpkinOverlay());
      this.v46.v1(new SafeInteraction());
      this.v46.v1(new DurabilityGuard(this.v61));
      this.v46.v1(new DropGuard(this.v61));
      this.v46.v1(new CommandFix(this.v61));
      this.v46.v1(new CapsFix(this.v61));
      this.v46.v1(new BorderlessFullscreen(this.v61));
      this.v46.v1(new ReconnectButton());
      this.v46.v1(new PvPLeaveConfirm());
      this.v46.v1(new FoodSaturation());
      this.v46.v1(new TNTTimer(this.v61));
      this.v46.v1(new LightOverlay(this.v61));
      this.v46.v1(new ChunkBorders(this.v61));
      this.v46.v1(new ShulkerPreview());
      this.v46.v1(new SlotHighlight());
      this.v46.v1(new HotbarKeys());
      this.v46.v1(new ChatReveal(this.v61));
      this.v46.v1(new InfiniteChatHistory(this.v61));
      this.v46.v1(new ChatStack());
      this.v46.v1(new ChatPing(this.v61, this.v118.v4()));
      this.v46.v1(new ChatHeads(this.v61));
      this.v46.v1(new StreamerMode(this.v61));
   }

   private void v43() {
      this.v59.v1(new cloudSupport75(this.v59));
      this.v59.v1(new cloudSupport77(this.v51, this.v46));
      this.v59.v1(new cloudSupport72(this.v46, this.v51, this.v60, this.v52, this::v37));
      this.v59.v1(new cloudSupport76(this.v145, () -> class_156.method_668().method_672(this.v118.v1().toFile())));
      this.v59.v1(new cloudSupport73(this.v40, this.v45, this.v118.v6(), this::v1));
      this.v59.v1(new cloudSupport74(FabricLoader.getInstance().getConfigDir()));
      this.v59.v1(new cloudSupport71(this.v118.v3(), this.v53));
      SignedInSupport var1 = new SignedInSupport(this.v101, new cloudSupport78(this.v48));
      this.v101.v1(var1::v1);
      this.v59.v1(var1);
      if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
         AltCommand var2 = new AltCommand(this.v87, new cloudSupport78(this.v48));
         this.v119 = var2;
         this.v59.v1(var2);
         this.v59.v1(new TryingOnSupport(this.v101, this.v117, this.v124, () -> {
            class_746 var1x = this.v48.v2();
            return var1x == null ? null : var1x.method_5667();
         }));
         this.v59.v1(new CrashTestSupport(this.v48, this.v64));
      }
   }

   private void v37() {
      hudSupport48.v1(this.v52, this.v48, this.v159::v1, this.v99, this.v120, this.v50, this.v75, this.v176);
   }

   private void v48() {
      this.v52.v1(this::v37);
   }

   private void v40() {
      HashSet var1 = new HashSet();

      for (ModuleContract var3 : this.v46.v1()) {
         var1.add(var3.getName());
      }

      List var4 = this.v47.v1(var1);
      if (!var4.isEmpty()) {
         v1.info("self-clean: pruned {} orphaned config section(s): {}", var4.size(), var4);
      }
   }

   private void v44() {
      this.v37.v1(InternalSupport58.class, var1 -> this.v46.v6(), 100);
      this.v37.v1(InternalSupport58.class, var1 -> this.v80.v1(), 200);
      this.v37.v1(InternalSupport58.class, var1 -> this.v103.v1(var1.v1), 20);
      this.v37.v1(InternalSupport58.class, var1 -> this.v98.v1(this.v48.v3() != null), 15);
      this.v37.v1(InternalSupport58.class, var1 -> {
         if (var1.v1 % 20L == 0L) {
            this.v101.v2();
         }
      }, 0);
      this.v37.v1(InternalSupport58.class, var1 -> this.v66.v1(System.nanoTime()), 0);
      this.v37.v1(InternalSupport58.class, var1 -> {
         this.v87.v14();
         AltCommand var2 = this.v119;
         if (var2 != null) {
            var2.v3();
         }
      }, 5);
      this.v37.v1(InternalSupport58.class, var1 -> this.v15.v1(() -> this.v145.v1(System.currentTimeMillis())), 10);
      uiSupport148.v1(this.v48, this.v53);
      this.v51.v1(var0 -> uiSupport148.v1(uiSupport146.v2(var0)));
      this.v49.v1();
      uiSupport140.v1(this.v46, this.v49);
      InternalSupport26.v1(
         this.v37,
         this.v48,
         this.v46,
         this.v51,
         this.v60,
         this.v49,
         new ConfigUi(this.v145, this.v118.v1(), this.v48, this.v53, this.v64),
         this.v101,
         new sykyRecord9(this.v72, this.v87, this.v85)
      );
      this.v37.v1(InternalSupport59.class, var1 -> {
         class_310 var2 = this.v48.v1();
         if (var2 != null && var2.field_1755 == null) {
            this.v51.v1(var1.v1, var1.v3);
         }
      }, 0);
      this.v37.v1(uiSupport242.class, var1 -> this.v51.v1(var1.v1), 0);
      this.v37.v1(uiRecord9.class, var0 -> CrashReporter.v2("module", var0.v1() + " on"), 0);
      this.v37.v1(uiRecord10.class, var0 -> CrashReporter.v2("module", var0.v1() + " off"), 0);
   }

   private void v47() {
      cloudSupport83.v1(this.v48, this.v59);
      ResourceLoader.get(class_3264.field_14188).registerReloader(class_2960.method_60655("syky", "hud_bake_cache"), new class_4013() {
         public void method_14491(class_3300 var1) {
            SykyRuntime.this.v21.v1(() -> {
               CrashReporter.v2("reload", "resources");
               hudSupport7.v40();
               NoItemsSupport.v40();
               hudSupport23.v40();
               DurabilityAlertSupport.v40();
               ItemPickupsSupport.v40();
               hudSupport27.v40();
               uiSupport62.v1();
               InternalSupport53.v1();
               visualSupport54.v1();
               InternalSupport52.v1();
               visualSupport61.v1();
               InternalSupport51.v1();
            });
         }
      });
      ClientPlayConnectionEvents.JOIN.register((Join)(var1x, var2, var3) -> this.v16.v1(() -> {
         this.v105.v1(v1(var3));
         this.v46.v7();
         this.v68.v21();
      }));
      ClientPlayConnectionEvents.DISCONNECT.register((Disconnect)(var1x, var2) -> this.v18.v1(() -> var2.execute(() -> this.v18.v1(() -> {
         if (!this.v147) {
            this.v105.v1();
            this.v46.v8();
            this.v68.v21();
         }
      }))));
      ClientPlayConnectionEvents.JOIN.register((Join)(var1x, var2, var3) -> this.v19.v1(() -> {
         this.v101.v1(PresenceService.v1(var3, var1x), PresenceService.v2(var3, var1x));
         this.v101.v12();
      }));
      ClientWorldEvents.AFTER_CLIENT_WORLD_CHANGE.register((AfterClientWorldChange)(var1x, var2) -> this.v20.v1(() -> this.v101.v1(PresenceService.v1(var2))));
      ClientPlayConnectionEvents.DISCONNECT.register((Disconnect)(var1x, var2) -> this.v17.v1(() -> {
         if (!this.v147) {
            this.v101.v13();
         }
      }));
      InternalSupport38.v1();
      InternalSupport43.v1();
      InternalSupport31.v1();
      WorldRenderEvents.BEFORE_ENTITIES.register((BeforeEntities)var1x -> this.v2.v1(() -> this.v46.v1(NothingFoundSupport.v14(), NothingFoundSupport.v15())));
      WorldRenderEvents.BEFORE_DEBUG_RENDER.register((DebugRender)var1x -> {
         try {
            visualSupport9.v1(visualSupport51.v59 || visualSupport51.v53);
            visualSupport9.v1(var1x);
            InternalSupport32.v2();
            visualSupport56.v1();

            try {
               this.v46.v1(var1x);

               try {
                  long var2 = this.v44.v3();
                  this.v94.v1();
                  this.v44.v1("waypoints.areas", var2);
                  long var4 = this.v44.v3();
                  this.v82.v4();
                  this.v44.v1("waypoints.picker", var4);
                  this.v11.v1();
               } catch (Throwable var10) {
                  this.v11.v1(var10);
               }
            } finally {
               visualSupport9.v25();
            }

            this.v3.v1();
         } catch (Throwable var12) {
            this.v3.v1(var12);
         }
      });
      WorldRenderEvents.BEFORE_ENTITIES.register((BeforeEntities)var1x -> {
         try {
            InternalSupport32.v1(var1x);
            this.v6.v1();
         } catch (Throwable var3) {
            this.v6.v1(var3);
         }
      });
      WorldRenderEvents.BEFORE_ENTITIES.register((BeforeEntities)var1x -> {
         if (InternalSupport48.v1()) {
            this.v4.v1(visualSupport9::v15);
         }
      });
      WorldRenderEvents.BEFORE_TRANSLUCENT
         .register(
            (BeforeTranslucent)var1x -> {
               if (visualSupport51.v59 || visualSupport51.v53) {
                  this.v5.v1(SykyRuntime::v38);
               }

               this.v4
                  .v1(
                     () -> v2(
                        visualSupport24.v1
                           || visualSupport24.v2
                           || visualSupport23.v1()
                           || accountSupport16.v2()
                           || accountSupport19.v2()
                           || accountSupport18.v2()
                     )
                  );
            }
         );
      WorldRenderEvents.END_MAIN.register((EndMain)var1x -> {
         if (visualSupport51.v59 || visualSupport51.v53) {
            this.v5.v1(SykyRuntime::v36);
         }
      });
      WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register((BeforeBlockOutline)(var1x, var2) -> this.v7.v1(() -> !BlockOverlay.v17() && !this.v82.v1(), true));
      HudElementRegistry.attachElementBefore(VanillaHudElements.MISC_OVERLAYS, v27, (var1x, var2) -> {
         try {
            int var3 = uiSupport169.v1("gpu.world.colorgrade");

            try {
               InternalSupport54.v1();
            } finally {
               uiSupport169.v1(var3);
            }

            uiSupport169.v3(var1x);
            this.v8.v1();
         } catch (Throwable var12) {
            this.v8.v1(var12);
         }

         try {
            cloudSupport31.v1(var1x);
            this.v9.v1();
         } catch (Throwable var10) {
            this.v9.v1(var10);
         }

         try {
            long var13 = this.v44.v3();
            this.v84.v1(var1x);
            this.v44.v1("waypoints.markers", var13);
            this.v10.v1();
         } catch (Throwable var9) {
            this.v10.v1(var9);
         }
      });
      HudElement var1 = (var1x, var2) -> {
         try {
            this.v52.v1(var1x, var2);
            this.v12.v1();
         } catch (Throwable var4) {
            this.v12.v1(var4);
         }
      };
      HudElementRegistry.attachElementBefore(VanillaHudElements.HOTBAR, v24, var1);
      HudElementRegistry.attachElementBefore(VanillaHudElements.SPECTATOR_MENU, v25, var1);
      HudElementRegistry.attachElementAfter(VanillaHudElements.CHAT, v22, (var1x, var2) -> {
         try {
            this.v52.v2(var1x, var2);
            this.v13.v1();
         } catch (Throwable var4) {
            this.v13.v1(var4);
         }
      });
      HudElementRegistry.addLast(v26, (var1x, var2) -> {
         try {
            this.v45.v1(var1x, var2);
            this.v14.v1();
         } catch (Throwable var4) {
            this.v14.v1(var4);
         }
      });
   }

   @FunctionalInterface
   public interface Part1 {
      void run() throws Exception;
   }
}
