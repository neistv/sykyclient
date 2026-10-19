package cc.syky.cloud;

import cc.syky.internal.InternalSupport26;
import com.google.gson.JsonObject;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public final class SignedInSupport implements cloudSupport82 {
   private static final String v2 = "[syky] ";
   private static final Pattern v3 = Pattern.compile("[A-Za-z0-9_]{3,16}");
   private static final int v4 = 1024;
   public static final int v1 = 8;
   private static final long v5 = 2000000000L;
   private static final List<String> v6 = List.of("login", "logout", "online", "profile");
   private static final String v7 = "account: login | logout | online on|off | profile <name>";
   private final CloudClient v8;
   private final cloudSupport81 v9;
   private final Map<Long, String> v10 = new HashMap<>();
   private final Map<Long, String> v11 = new HashMap<>();
   private double v12 = 8.0;
   private long v13 = System.nanoTime();
   private boolean v14;

   public SignedInSupport(CloudClient var1, cloudSupport81 var2) {
      this.v8 = var1;
      this.v9 = var2;
   }

   @Override
   public String v1() {
      return "account";
   }

   @Override
   public String v2() {
      return "account [login|logout|profile|online] — your syky account";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      String var3 = var2.isEmpty() ? "" : ((String)var2.get(0)).toLowerCase(Locale.ROOT);
      String var4 = var2.size() > 1 ? (String)var2.get(1) : "";
      switch (var3) {
         case "":
            this.v1(var1);
            break;
         case "help":
            var1.v1("account: login | logout | online on|off | profile <name>");
            break;
         case "login":
            this.v8.v15();
            break;
         case "logout":
            this.v8.v19();
            break;
         case "online":
            v1(var1, var4, "Online features", this.v8::v1);
            break;
         case "stats":
            v1(var1, var4, "Anonymous usage statistics", this.v8::v2);
            break;
         case "crashes":
            v1(var1, var4, "Crash reports", this.v8::v3);
            break;
         case "profile":
            this.v1(var1, var4);
            break;
         default:
            var1.v2("account: login | logout | online on|off | profile <name>");
      }
   }

   private void v1(cloudSupport81 var1) {
      SykySession.Part1 var2 = SykySession.v1();
      var1.v1(var2 == null ? "Not signed in. Sign in with .syky account login" : "Signed in as " + var2.v2() + " (UID " + var2.v1() + ").");
      String var3 = !this.v8.v6() ? "off" : (this.v8.v8() ? "connected" : "connecting");
      var1.v1("Server: " + this.v8.v9() + " (" + var3 + "). Commands: .syky account help");
   }

   private static void v1(cloudSupport81 var0, String var1, String var2, SignedInSupport.Part1 var3) {
      String var4 = var1.toLowerCase(Locale.ROOT);
      switch (var4) {
         case "on":
            var3.set(true);
            var0.v1(var2 + ": on.");
            break;
         case "off":
            var3.set(false);
            var0.v1(var2 + ": off.");
            break;
         default:
            var0.v2("Say on or off.");
      }
   }

   private void v1(cloudSupport81 var1, String var2) {
      if (!v3.matcher(var2).matches()) {
         var1.v2(var2.isEmpty() ? "Give a syky username." : "\"" + var2 + "\" is not a syky username.");
      } else {
         this.v8.v1("GET", "/v1/users/" + URLEncoder.encode(var2, StandardCharsets.UTF_8), null, var1x -> {
            this.v1(var1x);
            InternalSupport26.v1(cloudSupport60.v2(var1x, "username"));
         }, var1::v2);
      }
   }

   public void v1(String var1, JsonObject var2) {
      long var3 = cloudSupport60.v3(var2, "uid");
      switch (var1) {
         case "friend_request":
            this.v1(var2);
            String var9 = cloudSupport60.v2(var2, "username");
            this.v2("[syky] Friend request from " + var9 + ". Answer it on their profile: .syky account profile " + var9);
            break;
         case "friend_added":
            this.v1(var2);
            this.v2("[syky] " + cloudSupport60.v2(var2, "username") + " is now your friend.");
            break;
         case "friend_removed":
            this.v1(var3, var1x -> this.v2("[syky] " + var1x + " is no longer your friend."));
            break;
         case "friend_request_removed":
            this.v1(var3, var1x -> this.v2("[syky] The friend request with " + var1x + " was withdrawn."));
            break;
         case "friend_presence":
            String var7 = v1(cloudSupport60.v2(var2, "server"));
            String var8 = !cloudSupport60.v1(var2, "online", false) ? " went offline." : (var7.isEmpty() ? " is online." : " is playing on " + var7 + ".");
            if (var8.equals(this.v11.put(var3, var8))) {
               return;
            }

            if (this.v11.size() > 1024) {
               this.v11.clear();
            }

            this.v1(var3, var2x -> this.v2("[syky] " + var2x + var8));
      }
   }

   private void v2(String var1) {
      long var2 = System.nanoTime();
      this.v12 = Math.min(8.0, this.v12 + (var2 - this.v13) / 2.0E9);
      this.v13 = var2;
      if (this.v12 >= 1.0) {
         this.v12--;
         this.v14 = false;
         this.v9.v1(var1);
      } else if (!this.v14) {
         this.v14 = true;
         this.v9.v1("[syky] Too many notifications at once; hiding the rest for a moment.");
      }
   }

   private void v1(long var1, Consumer<String> var3) {
      String var4 = this.v10.get(var1);
      if (var4 != null) {
         var3.accept(var4);
      } else {
         this.v8.v1("GET", "/v1/users/uid/" + var1, null, var2 -> {
            this.v1(var2);
            var3.accept(cloudSupport60.v2(var2, "username"));
         }, var3x -> var3.accept("UID " + var1));
      }
   }

   private void v1(JsonObject var1) {
      long var2 = cloudSupport60.v3(var1, "uid");
      String var4 = cloudSupport60.v2(var1, "username");
      if (var2 > 0L && !var4.isEmpty()) {
         if (this.v10.size() >= 1024) {
            this.v10.clear();
         }

         this.v10.put(var2, var4);
      }
   }

   public static String v1(String var0) {
      StringBuilder var1 = null;

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         boolean var4 = Character.isISOControl(var3) || var3 == 8232 || var3 == 8233 || var3 == 167;
         boolean var5 = var3 >= 8234 && var3 <= 8238 || var3 >= 8294 && var3 <= 8297;
         if (!var4 && !var5) {
            if (var1 != null) {
               var1.append(var3);
            }
         } else {
            if (var1 == null) {
               var1 = new StringBuilder(var0.length()).append(var0, 0, var2);
            }

            if (var4) {
               var1.append(' ');
            }
         }
      }

      return var1 == null ? var0 : var1.toString();
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      String var4 = var3 == null ? "" : var3.toLowerCase(Locale.ROOT);
      List var5;
      if (var2 == 0) {
         var5 = v6;
      } else {
         if (var2 != 1 || var1.isEmpty()) {
            return List.of();
         }

         String var6 = ((String)var1.get(0)).toLowerCase(Locale.ROOT);

         var5 = switch (var6) {
            case "online", "stats" -> List.of("off", "on");
            case "profile" -> List.copyOf(this.v10.values());
            default -> List.of();
         };
      }

      ArrayList var9 = new ArrayList();

      for (String var8 : var5) {
         if (var8.toLowerCase(Locale.ROOT).startsWith(var4)) {
            var9.add(var8);
         }
      }

      var9.sort(String.CASE_INSENSITIVE_ORDER);
      return var9;
   }

   public interface Part1 {
      void set(boolean var1);
   }
}
