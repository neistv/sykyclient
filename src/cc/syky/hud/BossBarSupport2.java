package cc.syky.hud;

import java.util.Locale;

public enum BossBarSupport2 implements hudSupport64 {
   WATERMARK("Watermark", "watermark"),
   SERVER_IP("Server IP", "serverIp"),
   FPS("FPS", "fps"),
   PING("Ping", "ping"),
   CLOCK("Clock", "time"),
   USERNAME("Username", "user"),
   UID("UID", "uid"),
   PLAYTIME("Playtime", "playtime"),
   COORDS("Coords", "coords"),
   TPS("TPS", "tps"),
   BPS("BPS", "bps"),
   DATE("Date", "date"),
   DAY_COUNTER("Day Counter", "day_counter"),
   GAME_CLOCK("In-game Clock", "game_clock"),
   CPU("CPU", "cpu"),
   GPU("GPU", "gpu"),
   KEYSTROKES("Keystrokes", "keystrokes"),
   ARMOR("Armor", "armor"),
   ITEM_COUNTER("Item Counter", "item_counter"),
   ITEM_PICKUPS("Item Pickups", "item_pickups"),
   REACH("Reach Display", "reach"),
   COMBO("Combo Counter", "combo"),
   SHIELD_TIMER("Shield Timer", "shield_timer"),
   DURABILITY_ALERT("Durability Alert", "durability_alert"),
   BREAK_INDICATOR("Break Indicator", "break_indicator"),
   TARGET("Target HUD", "target_hud"),
   INVENTORY("Inventory", "inventory_hud"),
   POTIONS("Active Potions", "active_potion"),
   EXPIRING_POTIONS("Expiring Potions", "expiring_potion"),
   SPLASH_ACCURACY("Splash Accuracy", "splash_accuracy"),
   HOTKEYS("Hotkeys", "hotkeys"),
   MUSIC("Music Player", "music_player"),
   IMAGES("Images", LoadingSupport.v2),
   SCOREBOARD("Scoreboard", "scoreboard"),
   BOSS_BAR("Boss Bar", "bossbar");

   private final String label;
   private final String[] elementIds;
   private final String usageKey;

   private BossBarSupport2(String var3, String... var4) {
      if (var4.length == 0) {
         throw new IllegalArgumentException("a hud switch must own at least one element: " + var3);
      } else {
         this.label = var3;
         this.elementIds = var4;
         this.usageKey = "hud:" + this.name().toLowerCase(Locale.ROOT);
      }
   }

   public String v2() {
      return this.usageKey;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public String[] v3() {
      return (String[])this.elementIds.clone();
   }
}
