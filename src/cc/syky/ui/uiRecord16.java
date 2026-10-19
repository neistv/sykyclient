package cc.syky.ui;

import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public record uiRecord16(
   String id,
   uiSupport272 kind,
   String name,
   UUID uuid,
   boolean saved,
   boolean active,
   boolean playing,
   boolean needsSignIn,
   @Nullable String skinUrl,
   boolean slimSkin,
   long addedAt,
   long lastUsedAt,
   @Nullable String lastPlace,
   boolean pinned,
   @Nullable String note
) {
   public static final String LAUNCH_ID = "launch";

   public boolean v1() {
      return this.saved;
   }

   public boolean v2() {
      return this.saved && this.kind == uiSupport272.OFFLINE;
   }

   public uiRecord16 v1(boolean var1, boolean var2) {
      return var1 == this.active && var2 == this.playing
         ? this
         : new uiRecord16(
            this.id,
            this.kind,
            this.name,
            this.uuid,
            this.saved,
            var1,
            var2,
            this.needsSignIn,
            this.skinUrl,
            this.slimSkin,
            this.addedAt,
            this.lastUsedAt,
            this.lastPlace,
            this.pinned,
            this.note
         );
   }

   public uiRecord16 v1(long var1, @Nullable String var3) {
      return new uiRecord16(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.saved,
         this.active,
         this.playing,
         this.needsSignIn,
         this.skinUrl,
         this.slimSkin,
         this.addedAt,
         var1,
         var3 == null ? this.lastPlace : var3,
         this.pinned,
         this.note
      );
   }

   public uiRecord16 v1(String var1, UUID var2) {
      return new uiRecord16(
         this.id, this.kind, var1, var2, this.saved, false, false, false, null, false, this.addedAt, this.lastUsedAt, this.lastPlace, this.pinned, this.note
      );
   }

   public uiRecord16 v1(boolean var1) {
      return new uiRecord16(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.saved,
         this.active,
         this.playing,
         this.needsSignIn,
         this.skinUrl,
         this.slimSkin,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         var1,
         this.note
      );
   }

   public uiRecord16 v1(@Nullable String var1) {
      return new uiRecord16(
         this.id,
         this.kind,
         this.name,
         this.uuid,
         this.saved,
         this.active,
         this.playing,
         this.needsSignIn,
         this.skinUrl,
         this.slimSkin,
         this.addedAt,
         this.lastUsedAt,
         this.lastPlace,
         this.pinned,
         var1
      );
   }

   public String v3() {
      return this.id;
   }

   public uiSupport272 v4() {
      return this.kind;
   }

   public String v5() {
      return this.name;
   }

   public UUID v6() {
      return this.uuid;
   }

   public boolean v7() {
      return this.saved;
   }

   public boolean v8() {
      return this.active;
   }

   public boolean v9() {
      return this.playing;
   }

   public boolean v10() {
      return this.needsSignIn;
   }

   @Nullable
   public String v11() {
      return this.skinUrl;
   }

   public boolean v12() {
      return this.slimSkin;
   }

   public long v13() {
      return this.addedAt;
   }

   public long v14() {
      return this.lastUsedAt;
   }

   @Nullable
   public String v15() {
      return this.lastPlace;
   }

   public boolean v16() {
      return this.pinned;
   }

   @Nullable
   public String v18() {
      return this.note;
   }
}
