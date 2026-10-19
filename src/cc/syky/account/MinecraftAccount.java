package cc.syky.account;

import cc.syky.ui.uiSupport272;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public record MinecraftAccount(
   String id,
   uiSupport272 kind,
   String name,
   UUID uuid,
   long addedAt,
   long lastUsedAt,
   @Nullable String lastPlace,
   boolean pinned,
   @Nullable String note,
   @Nullable String skinUrl,
   boolean slimSkin,
   @Nullable String msRefreshToken,
   @Nullable String mcAccessToken,
   long mcExpiresAt,
   boolean needsSignIn
) {
   public static MinecraftAccount v1(String var0, String var1, UUID var2, long var3) {
      return new MinecraftAccount(var0, uiSupport272.OFFLINE, var1, var2, var3, 0L, null, false, null, null, false, null, null, 0L, false);
   }

   public static MinecraftAccount v1(String var0, String var1, UUID var2, @Nullable String var3, boolean var4, String var5, String var6, long var7, long var9) {
      return new MinecraftAccount(var0, uiSupport272.MICROSOFT, var1, var2, var9, 0L, null, false, null, var3, var4, var5, var6, var7, false);
   }

   public MinecraftAccount v1(String var1) {
      return new MinecraftAccount(
         this.id,
         this.kind,
         var1,
         this.uuid,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         this.pinned,
         this.note,
         this.skinUrl,
         this.slimSkin,
         this.msRefreshToken,
         this.mcAccessToken,
         this.mcExpiresAt,
         this.needsSignIn
      );
   }

   public MinecraftAccount v1(UUID var1) {
      return new MinecraftAccount(
         this.id,
         this.kind,
         this.name,
         var1,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         this.pinned,
         this.note,
         this.skinUrl,
         this.slimSkin,
         this.msRefreshToken,
         this.mcAccessToken,
         this.mcExpiresAt,
         this.needsSignIn
      );
   }

   public MinecraftAccount v1(long var1, @Nullable String var3) {
      return new MinecraftAccount(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.addedAt,
         var1,
         var3 == null ? this.lastPlace : var3,
         this.pinned,
         this.note,
         this.skinUrl,
         this.slimSkin,
         this.msRefreshToken,
         this.mcAccessToken,
         this.mcExpiresAt,
         this.needsSignIn
      );
   }

   public MinecraftAccount v1(boolean var1) {
      return new MinecraftAccount(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         var1,
         this.note,
         this.skinUrl,
         this.slimSkin,
         this.msRefreshToken,
         this.mcAccessToken,
         this.mcExpiresAt,
         this.needsSignIn
      );
   }

   public MinecraftAccount v2(@Nullable String var1) {
      return new MinecraftAccount(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         this.pinned,
         var1,
         this.skinUrl,
         this.slimSkin,
         this.msRefreshToken,
         this.mcAccessToken,
         this.mcExpiresAt,
         this.needsSignIn
      );
   }

   public MinecraftAccount v1(String var1, @Nullable String var2, boolean var3) {
      return new MinecraftAccount(
         this.id,
         this.kind,
         var1,
         this.uuid,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         this.pinned,
         this.note,
         var2,
         var3,
         this.msRefreshToken,
         this.mcAccessToken,
         this.mcExpiresAt,
         this.needsSignIn
      );
   }

   public MinecraftAccount v1(String var1, String var2, long var3) {
      return new MinecraftAccount(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         this.pinned,
         this.note,
         this.skinUrl,
         this.slimSkin,
         var1,
         var2,
         var3,
         false
      );
   }

   public MinecraftAccount v1() {
      return new MinecraftAccount(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         this.pinned,
         this.note,
         this.skinUrl,
         this.slimSkin,
         null,
         null,
         0L,
         true
      );
   }

   @Override
   public String toString() {
      return "StoredAccount[" + this.id + " " + this.kind + " " + this.name + " " + this.uuid + (this.needsSignIn ? " needs sign-in" : "") + "]";
   }

   public String v2() {
      return this.id;
   }

   public uiSupport272 v3() {
      return this.kind;
   }

   public String v4() {
      return this.name;
   }

   public UUID v5() {
      return this.uuid;
   }

   public long v6() {
      return this.addedAt;
   }

   public long v7() {
      return this.lastUsedAt;
   }

   @Nullable
   public String v8() {
      return this.lastPlace;
   }

   public boolean v9() {
      return this.pinned;
   }

   @Nullable
   public String v10() {
      return this.note;
   }

   @Nullable
   public String v11() {
      return this.skinUrl;
   }

   public boolean v12() {
      return this.slimSkin;
   }

   @Nullable
   public String v13() {
      return this.msRefreshToken;
   }

   @Nullable
   public String v14() {
      return this.mcAccessToken;
   }

   public long v15() {
      return this.mcExpiresAt;
   }

   public boolean v16() {
      return this.needsSignIn;
   }
}
