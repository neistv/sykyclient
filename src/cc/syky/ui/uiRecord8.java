package cc.syky.ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.jetbrains.annotations.Nullable;

public record uiRecord8(
   int originX, int originY, int originZ, int sx, int sy, int sz, byte[] opacity, @Nullable byte[] faces, int[] dark, int[] mounts, int[][] stops
) {
   private static final int MAGIC = 1397509937;

   public void v1(OutputStream var1) throws IOException {
      try (DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(var1))) {
         var2.writeInt(1397509937);
         var2.writeInt(this.originX);
         var2.writeInt(this.originY);
         var2.writeInt(this.originZ);
         var2.writeInt(this.sx);
         var2.writeInt(this.sy);
         var2.writeInt(this.sz);
         var2.write(this.opacity);
         var2.writeBoolean(this.faces != null);
         if (this.faces != null) {
            var2.write(this.faces);
         }

         v1(var2, this.dark);
         v1(var2, this.mounts);
         var2.writeInt(this.stops.length);

         for (int[] var6 : this.stops) {
            var2.writeInt(var6[0]);
            var2.writeInt(var6[1]);
            var2.writeInt(var6[2]);
         }
      }
   }

   public static uiRecord8 v1(InputStream var0) throws IOException {
      uiRecord8 var16;
      try (DataInputStream var1 = new DataInputStream(new GZIPInputStream(var0))) {
         if (var1.readInt() != 1397509937) {
            throw new IOException("not a light overlay region");
         }

         int var2 = var1.readInt();
         int var3 = var1.readInt();
         int var4 = var1.readInt();
         int var5 = var1.readInt();
         int var6 = var1.readInt();
         int var7 = var1.readInt();
         byte[] var8 = new byte[var5 * var6 * var7];
         var1.readFully(var8);
         byte[] var9 = null;
         if (var1.readBoolean()) {
            var9 = new byte[var8.length];
            var1.readFully(var9);
         }

         int[] var10 = v1(var1);
         int[] var11 = v1(var1);
         int[][] var12 = new int[var1.readInt()][];

         for (int var13 = 0; var13 < var12.length; var13++) {
            var12[var13] = new int[]{var1.readInt(), var1.readInt(), var1.readInt()};
         }

         var16 = new uiRecord8(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
      }

      return var16;
   }

   private static void v1(DataOutputStream var0, int[] var1) throws IOException {
      var0.writeInt(var1.length);

      for (int var5 : var1) {
         var0.writeInt(var5);
      }
   }

   private static int[] v1(DataInputStream var0) throws IOException {
      int[] var1 = new int[var0.readInt()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = var0.readInt();
      }

      return var1;
   }

   public int v1() {
      return this.originX;
   }

   public int v2() {
      return this.originY;
   }

   public int v3() {
      return this.originZ;
   }

   public int v4() {
      return this.sx;
   }

   public int v5() {
      return this.sy;
   }

   public int v6() {
      return this.sz;
   }

   public byte[] v7() {
      return this.opacity;
   }

   @Nullable
   public byte[] v8() {
      return this.faces;
   }

   public int[] v9() {
      return this.dark;
   }

   public int[] v10() {
      return this.mounts;
   }

   public int[][] v11() {
      return this.stops;
   }
}
