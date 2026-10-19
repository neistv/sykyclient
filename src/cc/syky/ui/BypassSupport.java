package cc.syky.ui;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BypassSupport {
   private static final Logger v5 = LoggerFactory.getLogger("syky.chatping");
   public static final String v1 = "syky client";
   public static final String v2 = "cc.syky.client";
   public static final String v3 = "syky.client";
   private static final long v6 = 10L;
   public static final int v4 = 220;
   private static final int v7 = 80;
   public static final String v8 = String.join(
      "\n",
      "$ErrorActionPreference = 'Stop'",
      "if ($env:SYKY_NOTIFY_REGISTER) {",
      "  $key = 'HKCU:\\Software\\Classes\\AppUserModelId\\cc.syky.client'",
      "  if (-not (Test-Path $key)) { New-Item -Path $key -Force | Out-Null }",
      "  Set-ItemProperty -Path $key -Name DisplayName -Value 'syky client'",
      "  if ($env:SYKY_NOTIFY_ICON) { Set-ItemProperty -Path $key -Name IconUri -Value $env:SYKY_NOTIFY_ICON }",
      "  Remove-Item -Path 'HKCU:\\Software\\Classes\\AppUserModelId\\syky.client' -Recurse -ErrorAction SilentlyContinue",
      "  Remove-Item -Path 'HKCU:\\Software\\Microsoft\\Windows\\CurrentVersion\\Notifications\\Settings\\syky.client' -Recurse -ErrorAction SilentlyContinue",
      "}",
      "$null = [Windows.UI.Notifications.ToastNotificationManager, Windows.UI.Notifications, ContentType = WindowsRuntime]",
      "$null = [Windows.Data.Xml.Dom.XmlDocument, Windows.Data.Xml.Dom.XmlDocument, ContentType = WindowsRuntime]",
      "$xml = New-Object Windows.Data.Xml.Dom.XmlDocument",
      "$xml.LoadXml('<toast><visual><binding template=\"ToastGeneric\"><text></text><text></text></binding></visual></toast>')",
      "$texts = $xml.GetElementsByTagName('text')",
      "$null = $texts.Item(0).AppendChild($xml.CreateTextNode($env:SYKY_NOTIFY_TITLE))",
      "$null = $texts.Item(1).AppendChild($xml.CreateTextNode($env:SYKY_NOTIFY_BODY))",
      "[Windows.UI.Notifications.ToastNotificationManager]::CreateToastNotifier('cc.syky.client').Show([Windows.UI.Notifications.ToastNotification]::new($xml))"
   );
   public static final String v9 = String.join(
      "\n",
      "$ErrorActionPreference = 'Stop'",
      "Add-Type -AssemblyName System.Windows.Forms",
      "Add-Type -AssemblyName System.Drawing",
      "$tray = New-Object System.Windows.Forms.NotifyIcon",
      "$tray.Icon = [System.Drawing.SystemIcons]::Information",
      "try { if ($env:SYKY_NOTIFY_ICON) { $tray.Icon = [System.Drawing.Icon]::FromHandle(([System.Drawing.Bitmap]::FromFile($env:SYKY_NOTIFY_ICON)).GetHicon()) } } catch { }",
      "$tray.Text = 'syky client'",
      "$tray.Visible = $true",
      "$tray.ShowBalloonTip(5000, $env:SYKY_NOTIFY_TITLE, $env:SYKY_NOTIFY_BODY, 'Info')",
      "Start-Sleep -Seconds 6",
      "$tray.Dispose()"
   );
   private final BypassSupport.Part2 v10;
   private final Path v11;
   private final AtomicBoolean v12 = new AtomicBoolean();
   private int v13;
   private boolean[] v14 = new boolean[0];
   private boolean v15;
   private boolean v16;
   @Nullable
   private Path v18;
   private boolean v19;
   @Nullable
   private ExecutorService v17;

   public BypassSupport(BypassSupport.Part2 var1, Path var2) {
      this.v10 = var1;
      this.v11 = var2;
   }

   public void v1(String var1, String var2) {
      if (this.v12.compareAndSet(false, true)) {
         try {
            this.v1().execute(() -> {
               try {
                  this.v2(var1, var2);
               } finally {
                  this.v12.set(false);
               }
            });
         } catch (RuntimeException var4) {
            this.v12.set(false);
            v5.warn("Chat Ping desktop notification: could not queue it", var4);
         }
      }
   }

   public void v2(String var1, String var2) {
      String var3 = v1(var1, 80);
      String var4 = v1(var2, 220);
      Path var5 = this.v2();
      List var6 = v1(this.v10, var3, var4, var5);
      if (this.v14.length != var6.size()) {
         this.v14 = new boolean[var6.size()];
      }

      try {
         for (int var7 = 0; var7 < var6.size(); var7++) {
            int var8 = (this.v13 + var7) % var6.size();
            if (!this.v14[var8] && this.v1(var8, (List<String>)var6.get(var8), var3, var4, var5)) {
               this.v13 = var8;
               return;
            }
         }
      } catch (InterruptedException var9) {
         Thread.currentThread().interrupt();
         return;
      }

      if (!this.v19) {
         this.v19 = true;
         v5.warn("Chat Ping desktop notification: no notification helper worked on {}", this.v10);
      }
   }

   public static List<List<String>> v1(BypassSupport.Part2 var0, String var1, String var2, @Nullable Path var3) {
      return switch (var0) {
         case WINDOWS -> BypassSupport.Part1.v1;
         case MAC -> List.of(
            List.of("osascript", "-e", "on run argv", "-e", "display notification (item 2 of argv) with title (item 1 of argv)", "-e", "end run", var1, var2)
         );
         case LINUX, OTHER -> {
            String var4 = v1(var2);
            ArrayList var5 = new ArrayList<>(List.of("notify-send", "--app-name=syky client"));
            if (var3 != null) {
               var5.add("--icon=" + var3);
            }

            var5.addAll(List.of("--", var1, var4));
            yield List.of(
               var5,
               List.<String>of(
                  "gdbus",
                  "call",
                  "--session",
                  "--dest",
                  "org.freedesktop.Notifications",
                  "--object-path",
                  "/org/freedesktop/Notifications",
                  "--method",
                  "org.freedesktop.Notifications.Notify",
                  v2("syky client"),
                  "0",
                  v2(var3 == null ? "" : var3.toString()),
                  v2(var1),
                  v2(var4),
                  "[]",
                  "{}",
                  "5000"
               ),
               List.<String>of("kdialog", "--title", var1, "--passivepopup", var4, "5"),
               List.<String>of("zenity", "--notification", "--text=" + v1(var1) + "\n" + var4)
            );
         }
      };
   }

   public static String v1(String var0, int var1) {
      StringBuilder var2 = new StringBuilder(Math.min(var0.length(), var1 + 1));

      for (int var3 = 0; var3 < var0.length() && var2.length() <= var1; var3++) {
         char var4 = var0.charAt(var3);
         var2.append(Character.isISOControl(var4) ? ' ' : var4);
      }

      String var5 = var2.toString().strip();
      return var5.length() > var1 ? var5.substring(0, var1 - 1).stripTrailing() + "…" : var5;
   }

   public static String v1(String var0) {
      return var0.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
   }

   public static String v2(String var0) {
      return "'" + var0.replace("\\", "\\\\").replace("'", "\\'") + "'";
   }

   public static String v3(String var0) {
      return Base64.getEncoder().encodeToString(var0.getBytes(StandardCharsets.UTF_16LE));
   }

   private synchronized ExecutorService v1() {
      ExecutorService var1 = this.v17;
      if (var1 == null) {
         var1 = Executors.newSingleThreadExecutor(var0 -> {
            Thread var1x = new Thread(var0, "syky-notify");
            var1x.setDaemon(true);
            return var1x;
         });
         this.v17 = var1;
      }

      return var1;
   }

   private boolean v1(int var1, List<String> var2, String var3, String var4, @Nullable Path var5) throws InterruptedException {
      ProcessBuilder var6 = new ProcessBuilder(var2).redirectErrorStream(true).redirectOutput(Redirect.DISCARD);
      if (this.v10 == BypassSupport.Part2.WINDOWS) {
         var6.environment().put("SYKY_NOTIFY_TITLE", var3);
         var6.environment().put("SYKY_NOTIFY_BODY", var4);
         var6.environment().put("SYKY_NOTIFY_ICON", var5 == null ? "" : var5.toString());
         var6.environment().put("SYKY_NOTIFY_REGISTER", this.v15 ? "" : "1");
      }

      Process var7;
      try {
         var7 = var6.start();
      } catch (SecurityException | IOException var9) {
         this.v14[var1] = true;
         return false;
      }

      if (!var7.waitFor(10L, TimeUnit.SECONDS)) {
         var7.destroyForcibly();
         return false;
      } else {
         boolean var8 = var7.exitValue() == 0;
         if (var8 && this.v10 == BypassSupport.Part2.WINDOWS && var1 == 0) {
            this.v15 = true;
         }

         return var8;
      }
   }

   @Nullable
   private Path v2() {
      if (this.v16) {
         return this.v18;
      } else {
         this.v16 = true;
         Path var1 = this.v11.resolve("notify-icon.png").toAbsolutePath();
         if (Files.isRegularFile(var1)) {
            this.v18 = var1;
            return var1;
         } else {
            try (InputStream var2 = BypassSupport.class.getResourceAsStream("/assets/syky/icon.png")) {
               if (var2 != null) {
                  Files.createDirectories(this.v11);
                  Files.copy(var2, var1, StandardCopyOption.REPLACE_EXISTING);
                  this.v18 = var1;
               }
            } catch (IOException var7) {
               this.v18 = null;
            }

            return this.v18;
         }
      }
   }

   public static final class Part1 {
      public static final List<List<String>> v1 = List.of(v1(BypassSupport.v8), v1(BypassSupport.v9));

      private Part1() {
      }

      private static List<String> v1(String var0) {
         String var1 = System.getenv("SystemRoot");
         String var2 = (var1 != null && !var1.isEmpty() ? var1 : "C:\\Windows") + "\\System32\\WindowsPowerShell\\v1.0\\powershell.exe";
         return List.of(
            var2, "-NoLogo", "-NoProfile", "-NonInteractive", "-ExecutionPolicy", "Bypass", "-WindowStyle", "Hidden", "-EncodedCommand", BypassSupport.v3(var0)
         );
      }
   }

   public static enum Part2 {
      WINDOWS,
      MAC,
      LINUX,
      OTHER;

      private Part2() {
      }

      public static BypassSupport.Part2 v1() {
         String var0 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
         if (var0.startsWith("windows")) {
            return WINDOWS;
         } else if (!var0.startsWith("mac") && !var0.startsWith("darwin")) {
            return !var0.contains("linux") && !var0.contains("bsd") ? OTHER : LINUX;
         } else {
            return MAC;
         }
      }
   }
}
