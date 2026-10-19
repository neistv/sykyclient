package cc.syky.account;

import cc.syky.cloud.cloudSupport81;
import cc.syky.cloud.cloudSupport82;
import cc.syky.ui.MicrosoftSignSupport;
import cc.syky.ui.TheSignSupport;
import cc.syky.ui.uiRecord16;
import cc.syky.ui.uiSupport269;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class AltCommand implements cloudSupport82 {
   private static final List<String> v1 = List.of("list", "add", "microsoft", "use", "back", "remove", "cancel");
   private static final String v2 = "alt: list | add <name> | microsoft | use <#|name> | back | remove <#|name> | cancel";
   private final MicrosoftSignSupport v3;
   private final cloudSupport81 v4;
   private int v5 = -1;
   @Nullable
   private uiSupport269 v6;
   @Nullable
   private uiSupport269.Part1 v7;
   @Nullable
   private String v8;
   private boolean v9;

   public AltCommand(MicrosoftSignSupport var1, cloudSupport81 var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   @Override
   public String v1() {
      return "alt";
   }

   @Override
   public String v2() {
      return "alt [list|add|microsoft|use|back|remove|cancel] — switch Minecraft accounts";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      String var3 = var2.isEmpty() ? "list" : ((String)var2.get(0)).toLowerCase(Locale.ROOT);
      String var4 = var2.size() > 1 ? String.join(" ", var2.subList(1, var2.size())) : "";
      switch (var3) {
         case "list":
            this.v1(var1);
            break;
         case "add":
            this.v1(var1, var4);
            break;
         case "microsoft":
         case "ms":
            this.v2(var1);
            break;
         case "use":
            this.v2(var1, var4);
            break;
         case "back":
            this.v3(var1);
            break;
         case "remove":
            this.v3(var1, var4);
            break;
         case "cancel":
            this.v4(var1);
            break;
         default:
            var1.v1("alt: list | add <name> | microsoft | use <#|name> | back | remove <#|name> | cancel");
      }
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      String var4 = var3.toLowerCase(Locale.ROOT);
      ArrayList var5 = new ArrayList();
      if (var2 == 0) {
         for (String var7 : v1) {
            if (var7.startsWith(var4)) {
               var5.add(var7);
            }
         }
      } else if (var2 == 1 && (((String)var1.get(0)).equalsIgnoreCase("use") || ((String)var1.get(0)).equalsIgnoreCase("remove"))) {
         for (uiRecord16 var9 : this.v3.v4()) {
            if (var9.v5().toLowerCase(Locale.ROOT).startsWith(var4)) {
               var5.add(var9.v5());
            }
         }

         var5.sort(String.CASE_INSENSITIVE_ORDER);
      }

      return var5;
   }

   public void v3() {
      int var1 = this.v3.v3();
      if (var1 != this.v5) {
         this.v5 = var1;
         this.v4();
         this.v5();
      }
   }

   private void v1(cloudSupport81 var1) {
      List var2 = this.v3.v4();
      if (var2.isEmpty()) {
         var1.v1("No accounts yet. .syky alt add <name> or .syky alt microsoft");
      } else {
         MicrosoftSignSupport.Part1 var3 = this.v3.v6();

         for (int var4 = 0; var4 < var2.size(); var4++) {
            uiRecord16 var5 = (uiRecord16)var2.get(var4);
            StringBuilder var6 = new StringBuilder().append(var4 + 1).append(". ").append(var5.v5()).append(" (").append(v2(var5)).append(')');
            if (var5.v8()) {
               var6.append(" - playing");
            }

            if (var3 != null && var3.v1().equals(var5.v3())) {
               var6.append(var3.v2() ? " - next, after you leave" : " - switching");
            }

            if (var5.v10()) {
               var6.append(" - sign in again");
            }

            var1.v1(var6.toString());
         }
      }
   }

   private void v1(cloudSupport81 var1, String var2) {
      MicrosoftSignSupport.Part3 var3 = this.v3.v2(var2);
      uiRecord16 var4 = var3.v2();
      if (var4 == null) {
         TheSignSupport var5 = var3.v3();
         var1.v2(var5 == null ? "Couldn't add the account." : var5.v1());
      } else {
         var1.v1("Added " + var4.v5() + ". Switch with .syky alt use " + var4.v5());
      }
   }

   private void v2(cloudSupport81 var1) {
      uiSupport269 var2 = this.v3.v12();
      this.v6 = var2;
      this.v7 = null;
      var1.v1("Starting a Microsoft sign-in...");
   }

   private void v2(cloudSupport81 var1, String var2) {
      uiRecord16 var3 = this.v1(var2);
      if (var3 == null) {
         var1.v2("No such account. .syky alt list");
      } else if (var3.v8()) {
         this.v3.v1(var3.v3());
         var1.v1("Already playing as " + var3.v5() + ".");
      } else {
         this.v1(var3);
         this.v3.v1(var3.v3());
         var1.v1("Switching to " + var3.v5() + "...");
      }
   }

   private void v3(cloudSupport81 var1) {
      this.v3.v11();
      MicrosoftSignSupport.Part1 var2 = this.v3.v6();
      uiRecord16 var3 = var2 == null ? null : this.v2(var2.v1());
      if (var3 == null) {
         var1.v1("Already playing as the launcher's account.");
      } else {
         this.v1(var3);
         var1.v1("Switching back to " + var3.v5() + "...");
      }
   }

   private void v3(cloudSupport81 var1, String var2) {
      uiRecord16 var3 = this.v1(var2);
      if (var3 != null && var3.v1()) {
         this.v3.v3(var3.v3());
         var1.v1("Removed " + var3.v5() + ".");
      } else {
         var1.v2(var3 == null ? "No such account. .syky alt list" : "The launcher's account can't be removed.");
      }
   }

   private void v4(cloudSupport81 var1) {
      uiSupport269 var2 = this.v3.v7();
      if (var2 != null && !var2.v2()) {
         var2.v9();
         var1.v1("Sign-in cancelled.");
      } else {
         var1.v1("No sign-in to cancel.");
      }
   }

   private void v1(uiRecord16 var1) {
      this.v8 = var1.v3();
      this.v9 = false;
      this.v3.v10();
   }

   private void v4() {
      uiSupport269 var1 = this.v6;
      if (var1 != null && var1.v1() != this.v7) {
         this.v7 = var1.v1();
         switch (var1.v1()) {
            case WAITING:
               var1.v8();
               this.v4.v1("Confirm the code " + var1.v3() + " at microsoft.com/link - the page is open and the code is on your clipboard.");
               break;
            case SIGNING_IN:
               this.v4.v1("Confirmed. Signing in to Minecraft...");
               break;
            case DONE:
               uiRecord16 var3 = var1.v6();
               this.v4.v1(var3 == null ? "Signed in." : "Signed in as " + var3.v5() + ". Switch with .syky alt use " + var3.v5());
               break;
            case FAILED:
               TheSignSupport var2 = var1.v7();
               this.v4.v2(var2 == null ? "The sign-in failed." : var2.v1());
         }

         if (var1.v2()) {
            this.v6 = null;
         }
      }
   }

   private void v5() {
      String var1 = this.v8;
      if (var1 != null) {
         uiRecord16 var2 = this.v3.v5();
         if (var2 != null && var2.v3().equals(var1)) {
            this.v4.v1("Now playing as " + var2.v5() + ".");
            this.v8 = null;
         } else {
            MicrosoftSignSupport.Part1 var3 = this.v3.v6();
            if (var3 != null && var3.v1().equals(var1)) {
               if (var3.v2() && !this.v9) {
                  uiRecord16 var5 = this.v2(var1);
                  this.v4.v1((var5 == null ? "The account" : var5.v5()) + " is ready. Leave this world, then join again to play as them.");
                  this.v9 = true;
               }
            } else {
               TheSignSupport var4 = this.v3.v9();
               if (var4 != null) {
                  this.v4.v2(var4.v1());
               }

               this.v8 = null;
            }
         }
      }
   }

   @Nullable
   private uiRecord16 v1(String var1) {
      String var2 = var1.strip();
      if (var2.isEmpty()) {
         return null;
      } else {
         List var3 = this.v3.v4();

         try {
            int var4 = Integer.parseInt(var2);
            return var4 >= 1 && var4 <= var3.size() ? (uiRecord16)var3.get(var4 - 1) : null;
         } catch (NumberFormatException var7) {
            for (uiRecord16 var6 : var3) {
               if (var6.v5().equalsIgnoreCase(var2)) {
                  return var6;
               }
            }

            return null;
         }
      }
   }

   @Nullable
   private uiRecord16 v2(String var1) {
      for (uiRecord16 var3 : this.v3.v4()) {
         if (var3.v3().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   private static String v2(uiRecord16 var0) {
      String var1 = switch (var0.v4()) {
         case MICROSOFT -> "Microsoft";
         case OFFLINE -> "offline";
         case EXTERNAL -> "other auth server";
      };
      return var0.v7() ? var1 : var1 + ", launcher";
   }
}
