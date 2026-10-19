package cc.syky.cloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SykyLinkLogin implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.cloud");
   private static final SecureRandom v2 = new SecureRandom();
   private static final Pattern v3 = Pattern.compile("sc_[A-Za-z0-9_-]{20,100}");
   private static final int v4 = 8192;
   private static final int v5 = 1000;
   private static final int v6 = 5000;
   private final String v7 = v5();
   private final ServerSocket v8 = new ServerSocket(0, 8, InetAddress.getLoopbackAddress());
   private final long v9;
   private final Consumer<String> v10;
   private final Consumer<String> v11;
   private volatile boolean v12;

   public SykyLinkLogin(Consumer<String> var1, Consumer<String> var2) throws IOException {
      this.v8.setSoTimeout(1000);
      this.v9 = System.currentTimeMillis() + CloudEndpoints.v25.toMillis();
      this.v10 = var1;
      this.v11 = var2;
   }

   public int v1() {
      return this.v8.getLocalPort();
   }

   public String v2() {
      return this.v7;
   }

   public String v3() {
      return v2(this.v7);
   }

   public void v4() {
      Thread var1 = new Thread(this::v6, "syky-sign-in");
      var1.setDaemon(true);
      var1.start();
   }

   private void v6() {
      try {
         while (!this.v12) {
            if (System.currentTimeMillis() > this.v9) {
               this.v2(null, "Sign-in timed out. Run .syky account login again.");
               return;
            } else {
               try (Socket var1 = this.v8.accept()) {
                  this.v1(var1);
               } catch (SocketTimeoutException var12) {
               }
            }
         }
      } catch (IOException var13) {
         if (!this.v12) {
            this.v2(null, "Sign-in was interrupted. Run .syky account login again.");
         }
      } finally {
         this.v7();
      }
   }

   private void v1(Socket var1) throws IOException {
      var1.setSoTimeout(5000);

      String var2;
      try {
         BufferedReader var3 = new BufferedReader(new InputStreamReader(var1.getInputStream(), StandardCharsets.US_ASCII));
         var2 = v1(var3);
      } catch (SocketTimeoutException var5) {
         return;
      }

      String var6 = v1(var2);
      if (var6 != null && (var6.equals("/callback") || var6.startsWith("/callback?"))) {
         String var4 = v1(var6, "code");
         if (var4 != null && v3.matcher(var4).matches()) {
            v1(var1.getOutputStream(), 200, "You are signed in to syky. You can close this tab and go back to the game.");
            this.v2(var4, null);
         } else {
            v1(var1.getOutputStream(), 400, "This sign-in link is not valid. Start again from the game.");
            this.v2(null, "Sign-in was cancelled in the browser.");
         }
      } else {
         v1(var1.getOutputStream(), 404, "Not found.");
      }
   }

   private void v2(@Nullable String var1, @Nullable String var2) {
      if (!this.v12) {
         this.v12 = true;
         this.v7();
         if (var1 != null) {
            this.v10.accept(var1);
         } else if (var2 != null) {
            this.v11.accept(var2);
         }
      }
   }

   @Override
   public void close() {
      this.v12 = true;
      this.v7();
   }

   private void v7() {
      try {
         this.v8.close();
      } catch (IOException var2) {
         v1.debug("closing the sign-in listener failed", var2);
      }
   }

   private static String v1(BufferedReader var0) throws IOException {
      StringBuilder var1 = new StringBuilder();

      int var2;
      while ((var2 = var0.read()) != -1 && var2 != 10 && var1.length() < 8192) {
         if (var2 != 13) {
            var1.append((char)var2);
         }
      }

      return var1.toString();
   }

   @Nullable
   public static String v1(String var0) {
      String[] var1 = var0.split(" ", -1);
      return var1.length == 3 && var1[0].equals("GET") && var1[2].startsWith("HTTP/") ? var1[1] : null;
   }

   @Nullable
   public static String v1(String var0, String var1) {
      int var2 = var0.indexOf(63);
      if (var2 < 0) {
         return null;
      } else {
         for (String var6 : var0.substring(var2 + 1).split("&", -1)) {
            int var7 = var6.indexOf(61);
            if (var7 > 0 && var6.substring(0, var7).equals(var1)) {
               try {
                  return URLDecoder.decode(var6.substring(var7 + 1), StandardCharsets.UTF_8);
               } catch (IllegalArgumentException var9) {
                  return null;
               }
            }
         }

         return null;
      }
   }

   private static void v1(OutputStream var0, int var1, String var2) throws IOException {
      String var3 = var1 == 200 ? "OK" : (var1 == 404 ? "Not Found" : "Bad Request");
      String var4 = "<!doctype html><meta charset=\"utf-8\"><title>syky</title><p>" + var2 + "</p>";
      byte[] var5 = var4.getBytes(StandardCharsets.UTF_8);
      String var6 = "HTTP/1.1 "
         + var1
         + " "
         + var3
         + "\r\nContent-Type: text/html; charset=utf-8\r\nContent-Length: "
         + var5.length
         + "\r\nCache-Control: no-store\r\nReferrer-Policy: no-referrer\r\nConnection: close\r\n\r\n";
      var0.write(var6.getBytes(StandardCharsets.US_ASCII));
      var0.write(var5);
      var0.flush();
   }

   public static String v5() {
      byte[] var0 = new byte[32];
      v2.nextBytes(var0);
      return Base64.getUrlEncoder().withoutPadding().encodeToString(var0);
   }

   public static String v2(String var0) {
      try {
         byte[] var1 = MessageDigest.getInstance("SHA-256").digest(var0.getBytes(StandardCharsets.US_ASCII));
         return Base64.getUrlEncoder().withoutPadding().encodeToString(var1);
      } catch (NoSuchAlgorithmException var2) {
         throw new IllegalStateException("SHA-256 is missing from this Java runtime", var2);
      }
   }
}
