package cc.syky.cloud;

import cc.syky.config.OnlyMeSupport;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import cc.syky.internal.InternalSupport7;
import cc.syky.ui.AddFriendSupport;
import cc.syky.ui.AddNoteSupport;
import cc.syky.ui.AltManagerSupport;
import cc.syky.ui.CreateNewSupport;
import cc.syky.ui.RequestSentSupport;
import cc.syky.ui.SentJustSupport;
import cc.syky.ui.SignInSupport;
import cc.syky.ui.UiPopup;
import cc.syky.ui.UiScreen;
import cc.syky.ui.UndoSupport;
import cc.syky.ui.YouAndSupport;
import cc.syky.ui.uiSupport101;
import cc.syky.ui.uiSupport102;
import cc.syky.ui.uiSupport103;
import cc.syky.ui.uiSupport115;
import cc.syky.ui.uiSupport117;
import cc.syky.ui.uiSupport119;
import cc.syky.ui.uiSupport143;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport35;
import cc.syky.ui.uiSupport53;
import cc.syky.ui.uiSupport54;
import cc.syky.ui.uiSupport55;
import cc.syky.ui.uiSupport93;
import com.mojang.authlib.GameProfile;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_640;
import org.jetbrains.annotations.Nullable;

public final class FromYouSupport extends UiPopup implements RequestSentSupport.Part1, AddFriendSupport.Part1, SentJustSupport.Part1 {
   private static long v1;
   private static String v2 = "";
   private static final Map<Long, String> v3 = new HashMap<>();
   private static final String v4 = "Add new friend";
   private static final String v5 = "Recently met";
   private static final String v6 = "Seen in the tab";
   private static final String v7 = "_options";
   private static FromYouSupport.Part1 v8 = FromYouSupport.Part1.FRIENDS;
   private static FromYouSupport.Part3 v13 = FromYouSupport.Part3.FRIENDS;
   private static boolean v14 = true;
   private static FromYouSupport.Part1 v15 = FromYouSupport.Part1.FRIENDS;
   private static String v16 = "";
   private static FromYouSupport.Part1 v18 = FromYouSupport.Part1.FRIENDS;
   private final CreateNewSupport v19;
   private FromYouSupport.Part1 v17 = v18;
   public final CloudClient v20;
   public final InternalSupport7 v21;
   public final GETSupport2 v22;
   public final GETSupport v24;
   public final UiPopup.Part2 v25;
   @Nullable
   public ReplyToSupport v26;
   private final ReplyToSupport.Part1 v27 = new FromYouSupport.Part2();
   @Nullable
   private OnlyMeSupport v28;
   private final UndoSupport v29 = new UndoSupport();
   public FromYouSupport.Part1 v30 = v8;
   private FromYouSupport.Part1 v32 = v8;
   private boolean v23;
   private FromYouSupport.Part3 v33 = v13;
   private boolean v31 = v14;
   private boolean v34 = v14;
   private long v36;
   private final uiSupport117<AddFriendSupport> v38;
   private final uiSupport117<uiSupport54> v42;
   private final uiSupport117<RequestSentSupport> v43;
   private final cloudSupport88 v37;
   private final cloudSupport18 v48 = new cloudSupport18();
   private int v40 = -1;
   private String v44 = "";
   private final YouAndSupport v47;
   private final uiSupport53 v49;
   private final uiSupport53 v46;
   private final uiSupport53 v51;
   private final uiSupport53 v50;
   private final uiSupport53 v60;
   public FromYouSupport.Part1 v59 = v15;
   public final Set<Long> v53 = new HashSet<>();
   private int v63 = -1;
   private int v64 = -1;
   @Nullable
   private FromYouSupport.Part1 v61;
   @Nullable
   private FromYouSupport.Part3 v66;
   private boolean v68;
   private String v52 = "";
   private String v75 = "";
   private float v73;
   private final hudSupport57 v74 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v72 = new hudSupport57(0.0F, 90.0F);
   private float v80;
   private float v84;
   private float v94;
   private float v82;
   private boolean v99;
   private boolean v120;
   private static final Comparator<AddFriendSupport.Part2> v88 = Comparator.comparingLong(var0 -> {
      GETSupport2.Part2 var1 = var0.v7();
      Instant var2 = var1 == null ? null : var1.v8();
      return var2 == null ? 0L : -var2.toEpochMilli();
   });
   private static int v103;
   private static int v101 = -1;
   private static int v96 = -1;
   @Nullable
   private static CloudClient v105;

   public FromYouSupport(CloudClient var1, InternalSupport7 var2, float var3, UiPopup.Part2 var4) {
      this.v20 = var1;
      this.v21 = var2;
      this.v22 = var1.v3();
      this.v24 = var1.v4();
      this.v25 = var4;
      this.v73 = var3;
      this.v38 = new uiSupport117<>(var3);
      this.v38.v1(true);
      this.v38.v1(136.0F);
      this.v42 = new uiSupport117<>(var3);
      this.v42.v1(true);
      this.v42.v1(136.0F);
      this.v37 = var1.v1();
      this.v43 = new uiSupport117<>(var3);
      this.v43.v1(true);
      this.v43.v1(252.0F);
      this.v47 = new YouAndSupport(this.v22, this.v37, this::v1, this::v1, this::v1, FromYouSupport::v5, var3);
      this.v49 = new uiSupport53(uiSupport53.Part2.QUIET, "Friend Requests", null, var3, () -> this.v1(FromYouSupport.Part3.FRIENDS));
      this.v46 = new uiSupport53(uiSupport53.Part2.QUIET, "From You", null, var3, () -> this.v1(FromYouSupport.Part3.SENT));
      this.v49.v1(() -> Math.min(this.v22.v2().size(), 99));
      this.v51 = new uiSupport53(uiSupport53.Part2.QUIET, "Messages", null, var3, () -> this.v2(true));
      this.v50 = new uiSupport53(uiSupport53.Part2.QUIET, "Friends", null, var3, () -> this.v2(false));
      this.v51.v1(() -> v1(var1));
      this.v60 = uiSupport53.v1(
         uiSupport53.Part2.QUIET, uiSupport53.v1(uiSupport143.v49, 9.0F, 14.0F, -1.5F), var3, () -> this.v1(FromYouSupport.Part1.FRIENDS)
      );
      this.v19 = new CreateNewSupport(var1, var3, var4.v20(), this::v29);
      if (this.v30 == FromYouSupport.Part1.PROFILE && v16.isEmpty()) {
         this.v30 = FromYouSupport.Part1.FRIENDS;
         this.v32 = FromYouSupport.Part1.FRIENDS;
      }

      if (this.v30 == FromYouSupport.Part1.CHAT) {
         if (v1 != 0L) {
            this.v26 = new ReplyToSupport(this.v27, this.v24, v1, v2, v8(v1), var3);
         } else {
            this.v30 = FromYouSupport.Part1.FRIENDS;
            this.v32 = FromYouSupport.Part1.FRIENDS;
         }
      }
   }

   @Override
   public void v1(float var1) {
      this.v73 = var1;
      this.v38.v2(var1);
      this.v42.v2(var1);
      this.v47.v1(var1);
      this.v43.v2(var1);
      this.v49.v1(var1);
      this.v46.v1(var1);
      this.v51.v1(var1);
      this.v50.v1(var1);
      this.v60.v1(var1);
      this.v19.v1(var1);
      ReplyToSupport var2 = this.v26;
      if (var2 != null) {
         var2.v1(var1);
      }
   }

   @Override
   public void v1() {
      this.v22.v8();
      this.v24.v6();
      OnlyMeSupport2 var1 = OnlyMeSupport2.v1(this.v20);
      var1.v15();
      if (this.v30 == FromYouSupport.Part1.PROFILE && !v16.equalsIgnoreCase(String.valueOf(var1.v9()))) {
         var1.v1(v16);
      }

      this.v63 = -1;
      ReplyToSupport var2 = this.v26;
      if (this.v30 == FromYouSupport.Part1.CHAT && var2 != null) {
         var2.v4();
         var2.v3();
      }
   }

   private void v1(long var1, String var3) {
      if (this.v34()) {
         this.v25.v4();
         ReplyToSupport var4 = this.v26;
         if (var4 == null || var4.v1() != var1) {
            var4 = new ReplyToSupport(this.v27, this.v24, var1, var3, v8(var1), this.v73);
            this.v26 = var4;
         }

         v1 = var1;
         v2 = var3;
         this.v59 = this.v30 == FromYouSupport.Part1.CHAT ? this.v59 : this.v30;
         v15 = this.v59;
         if (this.v94 > 0.0F) {
            var4.v1(this.v80, this.v84, this.v94, this.v82, 0.0F);
         }

         var4.v3();
         this.v1(FromYouSupport.Part1.CHAT);
      }
   }

   public void v3(String var1) {
      SykySession.Part1 var2 = SykySession.v1();
      if (var2 != null && var2.v2().equalsIgnoreCase(var1)) {
         this.v25.v2(var1);
      } else {
         this.v25.v4();
         if (this.v30 != FromYouSupport.Part1.PROFILE) {
            this.v17 = this.v30;
            v18 = this.v30;
         }

         v16 = var1;
         OnlyMeSupport2.v1(this.v20).v1(var1);
         this.v1(FromYouSupport.Part1.PROFILE);
      }
   }

   private void v29() {
      FromYouSupport.Part1 var1 = this.v17;
      if (var1 == FromYouSupport.Part1.CHAT && this.v26 == null || var1 == FromYouSupport.Part1.REQUESTS && !this.v44()) {
         var1 = FromYouSupport.Part1.FRIENDS;
      }

      this.v1(var1);
   }

   public void v1(FromYouSupport.Part1 var1) {
      if (var1 != this.v30) {
         this.v9();
         if (this.v25.v1(var1.ordinal() - this.v30.ordinal())) {
            this.v32 = this.v30;
         }

         this.v30 = var1;
         v8 = var1;
      }
   }

   private void v1(FromYouSupport.Part3 var1) {
      if (this.v33 != var1) {
         this.v33 = var1;
         v13 = var1;
      }
   }

   private void v2(boolean var1) {
      if (this.v31 != var1) {
         this.v31 = var1;
         v14 = var1;
         if (uiSupport103.v1()) {
            long var2 = System.currentTimeMillis();
            float var4 = this.v5(var2);
            this.v36 = var4 > 0.0F && var4 < 1.0F ? var2 - (long)((1.0F - var4) * 260.0F) : var2;
         } else {
            this.v34 = var1;
         }
      }
   }

   private float v5(long var1) {
      return this.v36 == 0L ? 1.0F : Math.min(1.0F, (float)(var1 - this.v36) / 260.0F);
   }

   private float v30() {
      float var1 = this.v5(System.currentTimeMillis());
      if (var1 >= 1.0F) {
         return 1.0F;
      } else {
         return var1 < 0.5F ? 1.0F - hudSupport60.v1(var1 * 2.0F) : hudSupport60.v1(var1 * 2.0F - 1.0F);
      }
   }

   private void v32() {
      float var1 = this.v5(System.currentTimeMillis());
      if (var1 >= 0.5F && this.v34 != this.v31) {
         this.v34 = this.v31;
      }

      if (var1 >= 1.0F) {
         this.v36 = 0L;
         this.v34 = this.v31;
      }
   }

   private FromYouSupport.Part1 v23() {
      return this.v23 ? this.v32 : this.v30;
   }

   @Override
   public void v1(boolean var1) {
      this.v23 = var1;
   }

   @Override
   public boolean v21() {
      return this.v30 == FromYouSupport.Part1.FRIENDS || this.v30 == FromYouSupport.Part1.REQUESTS || this.v30 == FromYouSupport.Part1.ADD;
   }

   @Override
   public boolean v16() {
      return this.v30 == FromYouSupport.Part1.CHAT;
   }

   @Override
   public void v1(uiSupport35 var1, float var2, float var3, float var4, float var5, float var6) {
      ReplyToSupport var7 = this.v26;
      if (this.v23() == FromYouSupport.Part1.CHAT && var7 != null) {
         var7.v1(this.v23);
         var7.v1(var1, var6);
      }

      if (!this.v23 && var6 > 0.0F) {
         this.v2(var2, var3, var4, var5);
      }
   }

   private void v2(float var1, float var2, float var3, float var4) {
      List var5 = this.v24.v4();
      this.v29.v1(!var5.isEmpty());
      if (this.v29.v1() && !var5.isEmpty()) {
         GETSupport.Part2 var6 = (GETSupport.Part2)var5.getFirst();
         long var7 = Math.max(0L, var6.v3() - System.currentTimeMillis());
         String var9 = var5.size() == 1 ? "Chat with " + this.v6(var6.v1()) + " deleted" : var5.size() + " chats deleted";
         float var10 = this.v30 == FromYouSupport.Part1.CHAT ? 66.0F : 16.0F;
         this.v29.v1(var9, var7, 10000L, var1, var3, var2 + var4 - SignInSupport.v4(var10, this.v73), this.v73);
      }
   }

   private String v6(long var1) {
      AddFriendSupport.Part2 var3 = this.v7(var1);
      return var3 == null ? "a friend" : var3.v5();
   }

   @Nullable
   private AddFriendSupport.Part2 v7(long var1) {
      for (GETSupport2.Part2 var4 : this.v22.v1()) {
         if (var4.v1() == var1) {
            return AddFriendSupport.Part2.v1(var4);
         }
      }

      GETSupport.Part4 var5 = this.v24.v7(var1);
      return var5 == null ? null : new AddFriendSupport.Part2(var1, var5.v2(), var5.v3(), null);
   }

   private boolean v8(float var1, float var2) {
      return this.v29.v1(var1, var2);
   }

   private void v33() {
      if (!this.v24.v4().isEmpty()) {
         this.v24.v3();
      }
   }

   @Override
   public boolean v5(float var1, float var2) {
      ReplyToSupport var3 = this.v26;
      return this.v8(var1, var2) || this.v30 == FromYouSupport.Part1.CHAT && var3 != null && var3.v1(var1, var2);
   }

   @Override
   public float v18() {
      ReplyToSupport var1 = this.v26;
      return this.v30 == FromYouSupport.Part1.CHAT && var1 != null ? var1.v5() : 0.0F;
   }

   @Override
   public UiPopup.Part1 v19() {
      ReplyToSupport var1 = this.v26;
      return this.v30 == FromYouSupport.Part1.CHAT && var1 != null ? var1.v6() : UiPopup.Part1.NONE;
   }

   @Override
   public float v20() {
      ReplyToSupport var1 = this.v26;
      return this.v30 == FromYouSupport.Part1.CHAT && var1 != null ? var1.v8() : -1.0F;
   }

   @Override
   public float v17() {
      ReplyToSupport var1 = this.v26;
      return this.v30 == FromYouSupport.Part1.CHAT && var1 != null ? var1.v7() : -1.0F;
   }

   private boolean v34() {
      return SykySession.v1() != null;
   }

   @Nullable
   @Override
   public String v11() {
      return this.v34() && this.v30 != FromYouSupport.Part1.CHAT && this.v30 != FromYouSupport.Part1.PROFILE ? "Add new friend" : null;
   }

   @Nullable
   @Override
   public class_2960 d_() {
      return uiSupport143.v44;
   }

   @Override
   public boolean h_() {
      return this.v30 == FromYouSupport.Part1.ADD;
   }

   @Override
   public void v6(float var1, float var2) {
      this.v1(this.v30 == FromYouSupport.Part1.ADD ? FromYouSupport.Part1.FRIENDS : FromYouSupport.Part1.ADD);
   }

   @Nullable
   @Override
   public String v14() {
      return null;
   }

   @Override
   public boolean v15() {
      return false;
   }

   @Override
   public void v4(float var1, float var2) {
   }

   @Override
   public boolean v22() {
      return this.v34();
   }

   @Override
   public void v7(float var1, float var2) {
      if (this.v24()) {
         this.v25.v4();
      } else {
         this.v9();
         this.v25.v1(this.v36().v1(), var1, var2, "_options");
      }
   }

   @Override
   public boolean v24() {
      OnlyMeSupport var1 = this.v28;
      return var1 != null && this.v25.v3(var1.v1());
   }

   @Nullable
   @Override
   public UiScreen v2(String var1) {
      return "_options".equals(var1) && this.v34() ? this.v36().v1() : null;
   }

   private OnlyMeSupport v36() {
      OnlyMeSupport var1 = new OnlyMeSupport(OnlyMeSupport2.v1(this.v20), this.v73);
      this.v28 = var1;
      return var1;
   }

   @Override
   public void v1(String var1) {
      this.v52 = var1;
      this.v75 = uiSupport101.v1(var1);
      this.v63 = -1;
   }

   @Override
   public String v2() {
      return this.v52;
   }

   private boolean v1(uiSupport54 var1) {
      return uiSupport101.v1(this.v75, var1.f_());
   }

   @Override
   public void v3() {
      this.v22.v7();
      this.v24.v5();
      OnlyMeSupport var1 = this.v28;
      if (var1 != null && this.v25.v3(var1.v1())) {
         var1.v2();
      }

      this.v32();
      this.v38();
      this.v42();
      boolean var2 = this.v38.v5();
      boolean var3 = this.v42.v5();
      this.v43.v5();
      long var4 = System.currentTimeMillis();

      for (uiSupport115 var7 : this.v43.v1()) {
         for (RequestSentSupport var9 : var7.v3()) {
            var9.v1(var4);
         }
      }

      for (uiSupport115 var14 : this.v38.v1()) {
         for (AddFriendSupport var18 : var14.v3()) {
            var18.v1(var4);
         }
      }

      for (uiSupport115 var15 : this.v42.v1()) {
         for (uiSupport54 var19 : var15.v3()) {
            if (var19 instanceof SentJustSupport var10) {
               var10.v1(var4);
            } else if (var19 instanceof AddFriendSupport var11) {
               var11.v1(var4);
            }
         }
      }

      v1(this.v74, !var2);
      v1(this.v72, !var3);
   }

   private static String v8(long var0) {
      String var2 = v3.get(var0);
      return var2 == null ? "" : var2;
   }

   private void v38() {
      ReplyToSupport var1 = this.v26;
      if (var1 != null) {
         String var2 = var1.v2();
         if (var2.isBlank()) {
            v3.remove(var1.v1());
         } else {
            v3.put(var1.v1(), var2);
         }
      }

      if (var1 != null && this.v30 == FromYouSupport.Part1.CHAT) {
         GETSupport2.Part2 var5 = null;

         for (GETSupport2.Part2 var4 : this.v22.v1()) {
            if (var4.v1() == var1.v1()) {
               var5 = var4;
               break;
            }
         }

         if (var5 != null || this.v22.v4() == GETSupport2.Part3.READY) {
            var1.v1(var5);
         }

         if (var5 == null) {
            GETSupport.Part4 var6 = this.v24.v7(var1.v1());
            if (var6 != null) {
               var1.v1(var6.v3());
            }
         }

         GETSupport2.Part1 var7 = v1(this.v22.v2(), var1.v1());
         GETSupport2.Part1 var8 = var7 == null ? v1(this.v22.v3(), var1.v1()) : null;
         var1.v1(var7 != null ? var7 : var8, var7 != null);
         if (!this.v34()) {
            v1 = 0L;
            this.v1(FromYouSupport.Part1.FRIENDS);
         } else {
            var1.v1(System.currentTimeMillis(), ZoneId.systemDefault(), this.v25.v1(this));
         }
      }
   }

   @Nullable
   public static GETSupport2.Part1 v1(List<GETSupport2.Part1> var0, long var1) {
      for (GETSupport2.Part1 var4 : var0) {
         if (var4.v1() == var1) {
            return var4;
         }
      }

      return null;
   }

   private static void v1(hudSupport57 var0, boolean var1) {
      if (uiSupport103.v1()) {
         var0.v2(var1 ? 1.0F : 0.0F);
      } else {
         var0.v3(var1 ? 1.0F : 0.0F);
      }
   }

   private void v42() {
      int var1 = this.v22.v6();
      int var2 = this.v24.v1();
      if (this.v30 == FromYouSupport.Part1.ADD && (this.v37.v1() != this.v40 || !this.v47.v1().equals(this.v44))) {
         this.v40 = this.v37.v1();
         this.v44 = this.v47.v1();
         this.v3(this.v43.v3());
      }

      if (var1 != this.v63 || var2 != this.v64 || this.v30 != this.v61 || this.v33 != this.v66 || this.v34 != this.v68 || this.v37() != this.v99) {
         boolean var3 = this.v30 != this.v61 || this.v37() != this.v99 || this.v34 != this.v68;
         this.v63 = var1;
         this.v64 = var2;
         this.v61 = this.v30;
         this.v66 = this.v33;
         this.v68 = this.v34;
         this.v99 = this.v37();
         if (this.v30 == FromYouSupport.Part1.FRIENDS) {
            this.v5(!var3 && this.v38.v3());
         } else if (this.v30 == FromYouSupport.Part1.REQUESTS) {
            this.v4(!var3 && this.v42.v3());
         } else if (this.v30 == FromYouSupport.Part1.ADD) {
            this.v3(!var3 && this.v43.v3());
         }
      }
   }

   private void v3(boolean var1) {
      long var2 = System.currentTimeMillis();
      String var4 = this.v47.v1().strip();
      String var5 = uiSupport101.v1(var4.startsWith("@") ? var4.substring(1) : var4);
      String var6 = this.v43();
      Predicate var7 = var2x -> uiSupport101.v1(var5, var2x.f_()) && uiSupport101.v1(var6, var2x.f_());
      ArrayList var8 = new ArrayList(2);
      this.v1(var8, "met", "Recently met", this.v1(this.v37.v1(var2)), var7, var1);
      this.v1(var8, "tab", "Seen in the tab", this.v1(this.v37.v2(var2)), var7, var1);
      if (var1) {
         this.v43.v1(var8);
      } else {
         this.v43.v2(var8);
      }
   }

   private List<cloudSupport88.Part1> v1(List<cloudSupport88.Part1> var1) {
      SykySession.Part1 var2 = SykySession.v1();
      ArrayList var3 = new ArrayList(var1.size());

      for (cloudSupport88.Part1 var5 : var1) {
         if ((var2 == null || var5.v1() != var2.v1()) && this.v22.v1(var5.v1()) != GETSupport2.Part5.FRIENDS) {
            var3.add(var5);
         }
      }

      return var3;
   }

   private void v1(
      List<uiSupport115<RequestSentSupport>> var1, String var2, String var3, List<cloudSupport88.Part1> var4, Predicate<RequestSentSupport> var5, boolean var6
   ) {
      uiSupport115 var7 = var6 ? this.v43.v1(var2, var3) : null;
      if (var7 == null) {
         if (var4.isEmpty()) {
            return;
         }

         var7 = this.v43.v1(var2, var3, var6).v1(71.0F);
         var7.v1(0);
      }

      var7.v1(var4, var0 -> uiSupport54.v1("met:", var0.v1()), var2x -> new RequestSentSupport(this, var2x, this.v73, var6), RequestSentSupport::v1, var5);
      if (var7.v5()) {
         var1.add(var7);
      }
   }

   private String v43() {
      String var1 = this.v52.strip();
      return var1.startsWith("@") ? uiSupport101.v1(var1.substring(1)) : this.v75;
   }

   private void v4(boolean var1) {
      boolean var2 = this.v33 == FromYouSupport.Part3.FRIENDS;
      List var3 = var2 ? this.v22.v2() : this.v22.v3();
      uiSupport115 var4 = var1 ? this.v42.v1("requests", "") : null;
      if (var4 == null) {
         var4 = this.v42.v1("requests", "", var1).v1(71.0F);
      }

      String var5 = var2 ? "in:" : "out:";
      var4.v1(
         var3,
         var1x -> uiSupport54.v1(var5, var1x.v1()),
         var3x -> new SentJustSupport(this, var3x, var2, this.v73, var1),
         (var0, var1x) -> ((SentJustSupport)var0).v1(var1x),
         this::v1
      );
      ArrayList var6 = var4.v5() ? new ArrayList<>(List.of(var4)) : new ArrayList();
      if (var1) {
         this.v42.v1(var6);
      } else {
         this.v42.v2(var6);
      }
   }

   private void v5(boolean var1) {
      boolean var2 = var1;
      ArrayList var3 = new ArrayList();
      if (this.v34) {
         if (this.v44()) {
            var3.add(AddFriendSupport.Part2.v1());
         }

         for (long var5 : this.v24.v2()) {
            AddFriendSupport.Part2 var7 = this.v7(var5);
            if (var7 != null) {
               var3.add(var7);
            }
         }
      } else {
         for (GETSupport2.Part2 var12 : this.v22.v1()) {
            var3.add(AddFriendSupport.Part2.v1(var12));
         }
      }

      var3.sort(this.v48());
      boolean var11 = !this.v34 && this.v37() && var3.size() > 8;
      if (var11 != this.v120) {
         this.v120 = var11;
         var2 = false;
      }

      ArrayList var13 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var14 = new ArrayList();

      for (AddFriendSupport.Part2 var9 : var3) {
         (var9.v2() ? var13 : (var9.v3() ? var6 : var14)).add(var9);
      }

      int var15 = var11 ? Math.max(0, (var6.size() + var14.size() + 1) / 2 - var6.size()) : var14.size();
      ArrayList var16 = new ArrayList(4);
      this.v1(var16, "mailbox", 0, var13, var2);
      this.v1(var16, "pinned", 0, var6, var2);
      this.v1(var16, "list", 0, var14.subList(0, Math.min(var15, var14.size())), var2);
      if (var11) {
         this.v1(var16, "right", 1, var14.subList(Math.min(var15, var14.size()), var14.size()), var2);
      }

      if (var2) {
         this.v38.v1(var16);
      } else {
         this.v38.v2(var16);
      }
   }

   private void v1(List<uiSupport115<AddFriendSupport>> var1, String var2, int var3, List<AddFriendSupport.Part2> var4, boolean var5) {
      uiSupport115 var6 = var5 ? this.v38.v1(var2, "") : null;
      if (var6 == null) {
         if (var4.isEmpty()) {
            return;
         }

         var6 = this.v38.v1(var2, "", var5).v1(71.0F);
         var6.v1(var3);
      }

      boolean var7 = this.v34;
      var6.v1(
         var4,
         var0 -> uiSupport54.v1("home:", var0.v4()),
         var3x -> new AddFriendSupport(this, var3x, var7, this.v73, var5),
         (var1x, var2x) -> var1x.v1(var2x, var7),
         this::v1
      );
      if (var6.v5()) {
         var1.add(var6);
      }
   }

   private boolean v37() {
      return this.v94 > 0.0F && uiSupport117.v1(this.v94, this.v73);
   }

   private Comparator<AddFriendSupport.Part2> v48() {
      return Comparator.<AddFriendSupport.Part2, Boolean>comparing(var0 -> !var0.v2())
         .thenComparing(var0 -> !var0.v3())
         .thenComparing(v88)
         .thenComparing(this::v1, Comparator.reverseOrder())
         .thenComparing(var0 -> !v2(var0))
         .thenComparing(FromYouSupport::v3, Comparator.reverseOrder())
         .thenComparing(var0 -> var0.v5().toLowerCase(Locale.ROOT));
   }

   private long v1(AddFriendSupport.Part2 var1) {
      GETSupport.Part10 var2 = this.v24.v8(var1.v4());
      return var2 == null ? 0L : var2.v1();
   }

   private static boolean v2(AddFriendSupport.Part2 var0) {
      GETSupport2.Part2 var1 = var0.v7();
      return var1 != null && var1.v5();
   }

   private static long v3(AddFriendSupport.Part2 var0) {
      GETSupport2.Part2 var1 = var0.v7();
      Instant var2 = var1 == null ? null : var1.v7();
      return var2 == null ? 0L : var2.toEpochMilli();
   }

   @Override
   public float v4() {
      ReplyToSupport var1 = this.v26;
      if (this.v30 == FromYouSupport.Part1.CHAT) {
         return var1 == null ? 0.0F : var1.v9();
      } else if (this.v30 == FromYouSupport.Part1.PROFILE) {
         return this.v19.v1();
      } else {
         float var2 = switch (this.v30) {
            case FRIENDS, REQUESTS -> 136.0F;
            case ADD, CHAT, PROFILE -> 75.0F;
         };

         float var3 = switch (this.v30) {
            case FRIENDS -> this.v38.v6();
            case REQUESTS -> this.v42.v6();
            case ADD -> this.v43.v2() ? SignInSupport.v4(YouAndSupport.v2(), this.v73) : 177.0F * this.v73 + this.v43.v6();
            case CHAT, PROFILE -> 0.0F;
         };
         return Math.max(0.0F, var3 + (var2 - 82.0F) * this.v73);
      }
   }

   private float v40() {
      boolean var1 = uiSupport117.v1(this.v94, this.v73);
      return SignInSupport.v4(16.0F + (var1 ? 720.0F : 352.0F), this.v73) - SignInSupport.v4(16.0F, this.v73);
   }

   @Override
   public void v1(float var1, float var2, float var3, float var4, float var5) {
      this.v80 = var1;
      this.v84 = var2;
      this.v94 = var3;
      this.v82 = var4;
      float var6 = var1 + SignInSupport.v4(16.0F, this.v73);
      switch (this.v23()) {
         case FRIENDS:
            this.v38.v1(this, var1, var2, var3, var4, var5);
            this.v1(List.of(this.v51, this.v50), this.v31 ? 0 : 1, var6, var2 + var5);
            break;
         case REQUESTS:
            this.v42.v1(this, var1, var2, var3, var4, var5);
            float var9 = SignInSupport.v4(38.0F, this.v73);
            this.v60.v1(var6, var2 + var5 + SignInSupport.v4(82.0F, this.v73), var9, var9);
            this.v1(List.of(this.v49, this.v46), this.v33.ordinal(), var6 + var9 + SignInSupport.v4(16.0F, this.v73), var2 + var5);
            break;
         case ADD:
            float var8 = var2 + SignInSupport.v4(75.0F, this.v73) + var5;
            this.v47.v1(var6, var8, this.v40(), SignInSupport.v4(YouAndSupport.v2(), this.v73));
            this.v43.v1(this, var1, var2, var3, var4, var5);
            this.v1(var6, var8, this.v40(), this.v47.v12);
            break;
         case CHAT:
            ReplyToSupport var7 = this.v26;
            if (var7 != null) {
               var7.v1(this.v23);
               var7.v1(var1, var2, var3, var4, var5);
            }

            this.v1(var1, var2, var3, var4);
            break;
         case PROFILE:
            this.v19.v1(var1, var2, var3, var4, var5);
            this.v1(var1, var2, var3, var4);
      }
   }

   private void v1(List<uiSupport53> var1, int var2, float var3, float var4) {
      float var5 = var4 + SignInSupport.v4(82.0F, this.v73);
      float var6 = SignInSupport.v4(38.0F, this.v73);
      float var7 = var3;

      for (int var8 = 0; var8 < var1.size(); var8++) {
         uiSupport53 var9 = (uiSupport53)var1.get(var8);
         float var10 = SignInSupport.v4(var9.v6(), this.v73);
         var9.v1(var7, var5, var10, var6);
         var9.v1(var8 == var2);
         var7 += var10 + SignInSupport.v4(16.0F, this.v73);
      }
   }

   @Override
   public void v1(uiSupport35 var1) {
      switch (this.v23()) {
         case FRIENDS:
            this.v51.v1(var1);
            this.v50.v1(var1);
            this.v2(var1);
            break;
         case REQUESTS:
            this.v60.v1(var1);
            this.v49.v1(var1);
            this.v46.v1(var1);
            this.v42.v1(var1);
            break;
         case ADD:
            this.v47.v1(var1);
            this.v43.v1(var1);
            break;
         case CHAT:
            ReplyToSupport var2 = this.v26;
            if (var2 != null) {
               var2.v1(this.v23);
               var2.v1(var1);
            }
            break;
         case PROFILE:
            this.v19.v1(var1);
      }
   }

   private void v2(uiSupport35 var1) {
      float var2 = this.v30();
      if (var2 >= 1.0F) {
         this.v38.v1(var1);
      } else if (!(var2 <= 0.0F)) {
         boolean var3 = uiSupport169.v5();

         try {
            this.v38.v1(var3 ? var1.v1() : var1);
         } finally {
            if (var3) {
               uiSupport169.v1(var2, this.v9 + this.v11 / 2.0F, this.v10 + this.v12 / 2.0F, 1.0F, 1.0F, 6.5F * this.v73 * (1.0F - var2));
            }
         }
      }
   }

   @Override
   public float v5() {
      return switch (this.v23()) {
         case FRIENDS -> uiSupport103.v2(this.v74.v2()) * this.v30();
         case REQUESTS -> uiSupport103.v2(this.v72.v2());
         case ADD, CHAT, PROFILE -> 0.0F;
      };
   }

   @Override
   public String v6() {
      if (!this.v75.isEmpty()) {
         return "Nothing found";
      } else if (!this.v34()) {
         return "Sign in to add friends";
      } else {
         GETSupport2.Part3 var1 = this.v22.v4();
         if (var1 == GETSupport2.Part3.LOADING) {
            return "Loading...";
         } else if (var1 == GETSupport2.Part3.FAILED) {
            return this.v22.v5();
         } else if (this.v23() == FromYouSupport.Part1.REQUESTS) {
            return switch (this.v33) {
               case FRIENDS -> "No friend requests";
               case SENT -> "No requests sent";
            };
         } else {
            return this.v34 ? "No messages yet" : "No friends yet";
         }
      }
   }

   @Override
   public class_2960 v7() {
      return this.v75.isEmpty() ? uiSupport143.v1(AltManagerSupport.SOCIALS.v2()) : uiSupport143.v2;
   }

   @Override
   public void v1(uiSupport102 var1) {
      var1.v1(this);
      var1.v1(this.v9);
      var1.v1(this.v10);
      var1.v1(this.v11);
      var1.v1(this.v12);
      var1.v1(this.v23());
      var1.v1(this.v33);
      var1.v1(this.v31);
      var1.v1(this.v34);
      var1.v1(this.v30());
      var1.v1(this.v5());
      var1.v1(this.v75.isEmpty());
      var1.v1(this.v25.v13());
      var1.v1(this.v22.v6());
      switch (this.v23()) {
         case FRIENDS:
            this.v38.v1(var1);
            var1.v1(v1(this.v20));
            var1.v1(this.v51.v7());
            var1.v1(this.v50.v7());
            var1.v1(this.v51.v8());
            var1.v1(this.v50.v8());
            break;
         case REQUESTS:
            this.v42.v1(var1);
            var1.v1(this.v60.v8());
            var1.v1(this.v22.v2().size());

            for (uiSupport53 var3 : List.of(this.v49, this.v46)) {
               var1.v1(var3.v7());
               var1.v1(var3.v8());
            }
            break;
         case ADD:
            this.v47.v1(var1);
            this.v43.v1(var1);
            break;
         case CHAT:
            ReplyToSupport var2 = this.v26;
            if (var2 != null) {
               var2.v1(var1);
            }
            break;
         case PROFILE:
            var1.v1(this.v19.v3());
            var1.v1(SykySession.v1());
            var1.v1(this.v25.v29());
      }
   }

   @Override
   public uiSupport119 v27() {
      return OnlyMeSupport2.v1(this.v20).v2();
   }

   @Override
   public boolean v28() {
      return this.v25.v13();
   }

   @Override
   public void v1(AddFriendSupport var1, float var2, float var3) {
      this.v1(var1.v11(), var1.v12(), var2, var3);
   }

   @Override
   public void v1(AddFriendSupport var1) {
      if (var1.v1()) {
         this.v1(this.v22.v2().isEmpty() ? FromYouSupport.Part3.SENT : FromYouSupport.Part3.FRIENDS);
         this.v1(FromYouSupport.Part1.REQUESTS);
      } else {
         this.v1(var1.v11(), var1.v12());
      }
   }

   @Override
   public String v25() {
      List var1 = this.v22.v2();
      if (!var1.isEmpty()) {
         return var1.size() == 1 ? ((GETSupport2.Part1)var1.getFirst()).v2() + " wants to be friends" : v2(var1) + " want to be friends";
      } else {
         List var2 = this.v22.v3();
         return var2.isEmpty() ? "" : "Sent to " + v2(var2);
      }
   }

   private static String v2(List<GETSupport2.Part1> var0) {
      StringBuilder var1 = new StringBuilder();
      int var2 = Math.min(2, var0.size());

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 > 0) {
            var1.append(var3 == var0.size() - 1 ? " and " : ", ");
         }

         var1.append(((GETSupport2.Part1)var0.get(var3)).v2());
      }

      if (var0.size() > var2) {
         var1.append(" and ").append(var0.size() - var2).append(" more");
      }

      return var1.toString();
   }

   @Override
   public boolean v2(long var1) {
      return !this.v53.contains(var1) && this.v22.v1(var1) == GETSupport2.Part5.NONE;
   }

   @Override
   public void v2(AddFriendSupport var1) {
      this.v9(var1.v11());
   }

   public void v9(long var1) {
      if (this.v53.add(var1)) {
         this.v22.v1(var1, var3 -> this.v53.remove(var1), var3 -> {
            this.v53.remove(var1);
            this.v1(this.v6(var1), var3);
         });
      }
   }

   @Override
   public int v26() {
      return Math.min(this.v22.v2().size(), 99);
   }

   @Override
   public void v4(SentJustSupport var1) {
      this.v1(var1.v11(), var1.v12());
   }

   @Nullable
   @Override
   public GETSupport.Part10 v1(long var1) {
      return this.v24.v8(var1);
   }

   public void v1(long var1, String var3, float var4, float var5) {
      ArrayList var6 = new ArrayList(6);
      GETSupport2.Part2 var7 = null;

      for (GETSupport2.Part2 var9 : this.v22.v1()) {
         if (var9.v1() == var1) {
            var7 = var9;
         }
      }

      var6.add(new AddNoteSupport.Part2(uiSupport143.v8, 20.0F, 20.0F, 0.0F, "View profile", false, true, false, () -> {
         this.v25.v4();
         this.v3(var3);
      }));
      if (var7 != null) {
         boolean var10 = var7.v8() != null;
         var6.add(AddNoteSupport.Part2.v1(var10, null, () -> {
            this.v25.v4();
            this.v22.v1(var1, !var10, OnlyMeSupport2::v2);
         }));
      } else if (this.v22.v1(var1) == GETSupport2.Part5.REQUEST_SENT) {
         var6.add(new AddNoteSupport.Part2(uiSupport143.v32, 22.0F, 22.0F, 0.0F, "Cancel request", false, true, false, () -> {
            this.v25.v4();
            this.v22.v2(var1, () -> {}, OnlyMeSupport2::v2);
         }));
      } else {
         var6.add(new AddNoteSupport.Part2(uiSupport143.v37, 18.0F, 18.0F, 0.0F, "Add friend", false, true, false, () -> {
            this.v25.v4();
            this.v22.v1(var1, var0 -> {}, var2 -> this.v1(var3, var2));
         }));
      }

      var6.add(new AddNoteSupport.Part2(uiSupport143.v25, 21.0F, 21.0F, 0.0F, "Copy name", false, true, false, () -> this.v4(var3)));
      boolean var11 = this.v24.v8(var1) != null || !this.v24.v1(var1).isEmpty();
      var6.add(new AddNoteSupport.Part2(uiSupport143.v15, 18.0F, 20.0F, 0.0F, "Delete chat", true, var11, var11 ? null : "No messages", true, () -> {
         this.v25.v4();
         this.v2(var1, var3);
      }));
      if (var7 != null) {
         var6.add(new AddNoteSupport.Part2(uiSupport143.v48, 18.0F, 18.0F, 0.0F, "Remove friend", true, true, false, () -> {
            this.v25.v4();
            this.v22.v3(var1, () -> {}, OnlyMeSupport2::v2);
         }));
      }

      var6.add(new AddNoteSupport.Part2(uiSupport143.v32, 22.0F, 22.0F, 0.0F, "Block", true, true, false, () -> {
         this.v25.v4();
         this.v22.v4(var1, () -> {}, OnlyMeSupport2::v2);
      }));
      this.v25.v2(new uiSupport93(new AddNoteSupport(var6, this.v73)), var4, var5);
   }

   private void v2(long var1, String var3) {
      uiSupport55 var4 = new uiSupport55(
         new uiSupport55.Part1(
            "Delete chat",
            "Are you sure you want to delete all messages with " + var3 + "? You can undo it for 10 seconds.",
            "Also delete for " + var3,
            true,
            "Delete",
            null,
            uiSupport53.Part2.DANGER
         ),
         this.v73,
         var3x -> {
            this.v25.v4();
            this.v24.v1(var1, var3x, OnlyMeSupport2::v2);
            ReplyToSupport var4x = this.v26;
            if (this.v30 == FromYouSupport.Part1.CHAT && var4x != null && var4x.v1() == var1) {
               this.v1(FromYouSupport.Part1.FRIENDS);
            }
         },
         this.v25::v4
      );
      this.v25.v2(var4);
   }

   public void v4(String var1) {
      this.v25.v4();
      class_310 var2 = class_310.method_1551();
      if (var2 != null && var2.field_1774 != null) {
         var2.field_1774.method_1455(var1);
      }
   }

   @Override
   public void v1(SentJustSupport var1) {
      long var2 = var1.v11();
      if (this.v53.add(var2)) {
         this.v22.v1(var2, () -> this.v53.remove(var2), var3 -> {
            this.v53.remove(var2);
            OnlyMeSupport2.v2(var3);
         });
      }
   }

   @Override
   public void v2(SentJustSupport var1) {
      long var2 = var1.v11();
      if (this.v53.add(var2)) {
         this.v22.v2(var2, () -> this.v53.remove(var2), var3 -> {
            this.v53.remove(var2);
            OnlyMeSupport2.v2(var3);
         });
      }
   }

   public static int v1(CloudClient var0) {
      GETSupport2 var1 = var0.v3();
      GETSupport var2 = var0.v4();
      var1.v7();
      var2.v5();
      if (var1.v6() == v101 && var2.v1() == v96 && v105 == var0) {
         return v103;
      } else {
         v101 = var1.v6();
         v96 = var2.v1();
         v105 = var0;
         int var3 = var1.v2().size();

         for (long var5 : var2.v2()) {
            GETSupport.Part10 var7 = var2.v8(var5);
            var3 += var7 == null ? 0 : var7.v5();
         }

         v103 = Math.min(var3, 99);
         return v103;
      }
   }

   public boolean v44() {
      return !this.v22.v2().isEmpty() || !this.v22.v3().isEmpty();
   }

   @Override
   public GETSupport2.Part5 v3(long var1) {
      return this.v22.v1(var1);
   }

   @Override
   public boolean v4(long var1) {
      return this.v53.contains(var1);
   }

   private void v1(List<YouAndSupport.Part3> var1, float var2, float var3, Consumer<YouAndSupport.Part3> var4) {
      boolean var5 = uiSupport223.v5;
      long var6 = System.currentTimeMillis();
      ArrayList var8 = new ArrayList(var1.size());

      for (YouAndSupport.Part3 var10 : var1) {
         cloudSupport88.Part1 var11 = var10.v3();
         String var12 = var11 == null ? "" : var11.v3() + " · " + RequestSentSupport.v1(var11, var5, var6);
         var8.add(AddNoteSupport.Part2.v1(var11 == null ? null : this.v48.v1(var11), "@" + var10.v2(), var12, () -> {
            this.v25.v4();
            var4.accept(var10);
         }));
      }

      this.v25.v2(new uiSupport93(new AddNoteSupport(var8, this.v73)), var2, var3);
   }

   private void v1(String var1, Runnable var2) {
      uiSupport55 var3 = new uiSupport55(
         new uiSupport55.Part1(
            "Send a friend request to @" + var1 + "?",
            "You haven't met anyone called " + var1 + " in a game. @" + var1 + " is a syky account — check it's the person you mean.",
            null,
            false,
            "Send request",
            uiSupport143.v37,
            uiSupport53.Part2.ACCEPT
         ),
         this.v73,
         var2x -> {
            this.v25.v4();
            var2.run();
         },
         this.v25::v4
      );
      this.v25.v2(var3);
   }

   private static boolean v5(String var0) {
      class_310 var1 = class_310.method_1551();
      class_634 var2 = var1 == null ? null : var1.method_1562();
      if (var2 == null) {
         return false;
      } else {
         for (class_640 var4 : var2.method_2880()) {
            GameProfile var5 = var4.method_2966();
            if (var5.name().equalsIgnoreCase(var0) && cloudSupport90.v2(var5.id())) {
               return true;
            }
         }

         return false;
      }
   }

   private void v1(String var1, String var2) {
      uiSupport55 var3 = new uiSupport55(
         uiSupport55.Part1.v1("Couldn't send a friend request to " + var1, var2), this.v73, var1x -> this.v25.v4(), this.v25::v4
      );
      this.v25.v2(var3);
   }

   @Override
   public void v1(RequestSentSupport var1) {
      long var2 = var1.v11();
      if (this.v53.add(var2)) {
         this.v22.v1(var2, var3 -> {
            this.v53.remove(var2);
            this.v1(var2, var3.v2());
         }, var4 -> {
            this.v53.remove(var2);
            this.v1(var1.v1().v2(), var4);
         });
      }
   }

   @Override
   public void v2(RequestSentSupport var1) {
      this.v1(var1.v11(), var1.v1().v2());
   }

   @Override
   public class_2960 v1(cloudSupport88.Part1 var1) {
      return this.v48.v1(var1);
   }

   @Override
   public boolean v3(SentJustSupport var1) {
      return this.v53.contains(var1.v11());
   }

   @Override
   public boolean v8() {
      ReplyToSupport var1 = this.v26;

      return switch (this.v30) {
         case ADD -> this.v47.v3();
         case CHAT -> var1 != null && var1.v10();
         default -> false;
      };
   }

   @Override
   public void v9() {
      this.v47.v4();
      ReplyToSupport var1 = this.v26;
      if (var1 != null) {
         var1.v11();
      }
   }

   @Override
   public boolean v10() {
      return false;
   }

   @Override
   public boolean v2(int var1, int var2) {
      ReplyToSupport var3 = this.v26;

      return switch (this.v30) {
         case ADD -> this.v47.v2(var1, var2);
         case CHAT -> var3 != null && var3.v1(var1, var2);
         default -> false;
      };
   }

   @Override
   public boolean v3(int var1, int var2) {
      ReplyToSupport var3 = this.v26;

      return switch (this.v30) {
         case ADD -> this.v47.v3(var1, var2);
         case CHAT -> var3 != null && var3.v2(var1, var2);
         default -> false;
      };
   }

   @Override
   public boolean v3(float var1, float var2) {
      if (this.v8(var1, var2)) {
         return true;
      } else {
         return switch (this.v30) {
            case FRIENDS -> this.v38.v3(var1, var2) || this.v51.v1(var1, var2) || this.v50.v1(var1, var2);
            case REQUESTS -> this.v42.v3(var1, var2) || this.v60.v1(var1, var2) || this.v49.v1(var1, var2) || this.v46.v1(var1, var2);
            case ADD -> this.v47.v1(var1, var2) || this.v43.v3(var1, var2);
            case CHAT -> {
               ReplyToSupport var3 = this.v26;
               yield var3 != null && var3.v2(var1, var2);
            }
            case PROFILE -> this.v19.v1(var1, var2);
         };
      }
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      ReplyToSupport var4 = this.v26;

      return switch (this.v30) {
         case FRIENDS -> this.v38.v1(var1, var2, var3);
         case CHAT -> var4 != null && var4.v1(var1, var2, var3);
         default -> false;
      };
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (this.v8(var1, var2)) {
         if (var3 == 0) {
            this.v33();
         }

         return true;
      } else {
         return switch (this.v30) {
            case FRIENDS -> {
               if (this.v51.v1(var1, var2)) {
                  yield this.v51.v1(var1, var2, var3);
               } else if (this.v50.v1(var1, var2)) {
                  yield this.v50.v1(var1, var2, var3);
               } else {
                  AddFriendSupport var7 = this.v38.v2(var1, var2);
                  yield var7 != null && var7.v1(var1, var2, var3);
               }
            }
            case REQUESTS -> {
               if (this.v60.v1(var1, var2)) {
                  yield this.v60.v1(var1, var2, var3);
               } else if (this.v49.v1(var1, var2)) {
                  yield this.v49.v1(var1, var2, var3);
               } else if (this.v46.v1(var1, var2)) {
                  yield this.v46.v1(var1, var2, var3);
               } else {
                  uiSupport54 var6 = this.v42.v2(var1, var2);
                  yield var6 != null && var6.v1(var1, var2, var3);
               }
            }
            case ADD -> {
               if (this.v47.v1(var1, var2)) {
                  yield this.v47.v1(var1, var2, var3);
               } else {
                  this.v47.v4();
                  RequestSentSupport var5 = this.v43.v2(var1, var2);
                  yield var5 != null && var5.v1(var1, var2, var3);
               }
            }
            case CHAT -> {
               ReplyToSupport var4 = this.v26;
               yield var4 != null && var4.v2(var1, var2, var3);
            }
            case PROFILE -> this.v19.v1(var1, var2, var3);
         };
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      ReplyToSupport var6 = this.v26;

      return switch (this.v30) {
         case ADD -> this.v47.v1(var1, var2, var3, var4, var5);
         case CHAT -> var6 != null && var6.v1(var1, var2, var3, var4, var5);
         default -> false;
      };
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      ReplyToSupport var4 = this.v26;

      return switch (this.v30) {
         case ADD -> this.v47.v4(var1, var2, var3);
         case CHAT -> var4 != null && var4.v3(var1, var2, var3);
         default -> false;
      };
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (this.v8(var1, var2)) {
         return hudSupport54.POINTER;
      } else {
         return switch (this.v30) {
            case FRIENDS -> {
               if (this.v51.v1(var1, var2)) {
                  yield this.v51.v2(var1, var2);
               } else if (this.v50.v1(var1, var2)) {
                  yield this.v50.v2(var1, var2);
               } else {
                  AddFriendSupport var6 = this.v38.v2(var1, var2);
                  yield var6 == null ? hudSupport54.ARROW : var6.v2(var1, var2);
               }
            }
            case REQUESTS -> {
               if (this.v60.v1(var1, var2)) {
                  yield this.v60.v2(var1, var2);
               } else if (this.v49.v1(var1, var2)) {
                  yield this.v49.v2(var1, var2);
               } else if (this.v46.v1(var1, var2)) {
                  yield this.v46.v2(var1, var2);
               } else {
                  uiSupport54 var5 = this.v42.v2(var1, var2);
                  yield var5 == null ? hudSupport54.ARROW : var5.v2(var1, var2);
               }
            }
            case ADD -> {
               if (this.v47.v1(var1, var2)) {
                  yield this.v47.v2(var1, var2);
               } else {
                  RequestSentSupport var4 = this.v43.v2(var1, var2);
                  yield var4 == null ? hudSupport54.ARROW : var4.v2(var1, var2);
               }
            }
            case CHAT -> {
               ReplyToSupport var3 = this.v26;
               yield var3 == null ? hudSupport54.ARROW : var3.v3(var1, var2);
            }
            case PROFILE -> this.v19.v2(var1, var2);
         };
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      ReplyToSupport var1 = this.v26;

      return switch (this.v30) {
         case ADD -> this.v47.v31();
         case CHAT -> var1 == null ? null : var1.v12();
         default -> null;
      };
   }

   public static enum Part1 {
      FRIENDS,
      REQUESTS,
      ADD,
      CHAT,
      PROFILE;

      private Part1() {
      }
   }

   public final class Part2 implements ReplyToSupport.Part1 {
      public Part2() {
      }

      @Override
      public uiSupport119 v1() {
         return FromYouSupport.this.v27();
      }

      @Override
      public boolean v2() {
         return FromYouSupport.this.v25.v13();
      }

      @Override
      public boolean v1(UiScreen var1) {
         return FromYouSupport.this.v25.v3(var1);
      }

      @Override
      public void v3(String var1) {
         OnlyMeSupport2.v2(var1);
      }

      @Override
      public void v2(UiScreen var1) {
         FromYouSupport.this.v25.v2(var1);
      }

      @Override
      public InternalSupport7 v5() {
         return FromYouSupport.this.v21;
      }

      @Override
      public String v6() {
         return FromYouSupport.this.v20.v11();
      }

      @Override
      public void v3() {
         FromYouSupport.this.v1(
            FromYouSupport.this.v59 == FromYouSupport.Part1.REQUESTS && FromYouSupport.this.v44()
               ? FromYouSupport.Part1.REQUESTS
               : FromYouSupport.Part1.FRIENDS
         );
      }

      @Override
      public void v1(long var1, boolean var3) {
         boolean var4 = FromYouSupport.v1(FromYouSupport.this.v22.v2(), var1) != null;
         if (FromYouSupport.this.v53.add(var1)) {
            Runnable var5 = () -> FromYouSupport.this.v53.remove(var1);
            Consumer var6 = var3x -> {
               FromYouSupport.this.v53.remove(var1);
               OnlyMeSupport2.v2(var3x);
            };
            if (var3 && var4) {
               FromYouSupport.this.v22.v1(var1, var5, var6);
            } else {
               FromYouSupport.this.v22.v2(var1, () -> {
                  var5.run();
                  ReplyToSupport var4x = FromYouSupport.this.v26;
                  boolean var5x = FromYouSupport.this.v24.v8(var1) == null && FromYouSupport.this.v24.v1(var1).isEmpty();
                  if (FromYouSupport.this.v30 == FromYouSupport.Part1.CHAT && var4x != null && var4x.v1() == var1 && var5x) {
                     this.v3();
                  }
               }, var6);
            }
         }
      }

      @Override
      public boolean v1(long var1) {
         return FromYouSupport.this.v53.contains(var1);
      }

      @Override
      public void v2(long var1) {
         FromYouSupport.this.v9(var1);
      }

      @Override
      public boolean v3(long var1) {
         return FromYouSupport.this.v2(var1);
      }

      @Override
      public void v1(String var1) {
         FromYouSupport.this.v3(var1);
      }

      @Override
      public void v1(long var1, String var3, float var4, float var5) {
         FromYouSupport.this.v1(var1, var3, var4, var5);
      }

      @Override
      public void v1(UiScreen var1, float var2, float var3) {
         FromYouSupport.this.v25.v2(var1, var2, var3);
      }

      @Override
      public void v4() {
         FromYouSupport.this.v25.v4();
      }

      @Override
      public void v2(String var1) {
         FromYouSupport.this.v4(var1);
      }

      @Override
      public float v7() {
         return FromYouSupport.this.v25.v29();
      }

      @Override
      public float v8() {
         return FromYouSupport.this.v25.v30();
      }
   }

   public static enum Part3 {
      FRIENDS,
      SENT;

      private Part3() {
      }
   }
}
