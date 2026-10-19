package cc.syky.cloud;

import cc.syky.internal.InternalSupport62;
import cc.syky.ui.uiRecord12;
import cc.syky.ui.uiRecord13;
import cc.syky.ui.uiSupport255;
import cc.syky.ui.uiSupport256;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class PNGNotSupport {
   private static final int v3 = 1398360899;
   public static final int v1 = 1;
   public static final int v2 = 8388608;

   private PNGNotSupport() {
   }

   public static byte[] v1(cloudSupport50 var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(16384);

      try (DataOutputStream var2 = new DataOutputStream(var1)) {
         var2.writeInt(1398360899);
         var2.writeShort(1);
         var2.writeUTF(var0.v1());
         var2.writeUTF(var0.v2().v1());
         uiSupport255 var3 = var0.v3();
         var2.writeShort(var3.v1());

         for (int var4 = 0; var4 < var3.v1(); var4++) {
            var2.writeUTF(var3.v1(var4));
            var2.writeShort(var3.v2(var4));
            var2.writeUTF(var3.v3(var4).v1());

            for (int var5 = 0; var5 < 3; var5++) {
               var2.writeFloat(var3.v1(var4, var5));
            }

            for (int var18 = 0; var18 < 3; var18++) {
               var2.writeFloat(var3.v2(var4, var18));
            }
         }

         var2.writeByte(var0.v6());

         for (int var15 = 0; var15 < var0.v6(); var15++) {
            InternalSupport62 var19 = var0.v2(var15);
            var2.writeShort(var19.v1());
            var2.writeShort(var19.v2());
            var2.writeShort(var19.v4());
            var2.writeFloat(var19.v5());
            var2.writeBoolean(var19.v6());
            var2.writeInt(var19.v3().length);
            var2.write(var19.v3());
         }

         var2.writeByte(var0.v5());

         for (int var16 = 0; var16 < var0.v5(); var16++) {
            uiRecord12 var20 = var0.v1(var16);
            var2.writeByte(var20.v3());
            var2.writeByte(var20.v7());
            var2.writeUTF(var20.v4().v1());
            var2.writeInt(var20.v6());
            uiRecord13 var6 = var20.v5();
            var2.writeBoolean(var6 != null);
            if (var6 != null) {
               var2.writeByte(var6.v1().v2());
               var2.writeInt(var6.v2());
               var2.writeInt(var6.v3());
               var2.writeFloat(var6.v4());
               var2.writeFloat(var6.v5());
               var2.writeFloat(var6.v6());
            }
         }

         uiSupport256 var17 = var0.v4();
         float[] var21 = var17.v1();
         var2.writeInt(var17.v2());

         for (float var9 : var21) {
            var2.writeFloat(var9);
         }

         var2.writeShort(var17.v3());

         for (int var23 = 0; var23 < var17.v3(); var23++) {
            var2.writeShort(var17.v1(var23));
            var2.writeByte(var17.v2(var23));
            var2.writeInt(var17.v3(var23));
            var2.writeInt(var17.v4(var23));
         }

         cloudSupport50.Part1 var24 = var0.v7();
         var2.writeBoolean(var24 != null);
         if (var24 != null) {
            cloudRecord6 var25 = var24.v2();
            var2.writeByte(var25.v2());
            var2.writeByte(var25.v3());

            for (float var11 : new float[]{
               var25.v4(),
               var25.v5(),
               var25.v6(),
               var25.v7(),
               var25.v8(),
               var25.v9(),
               var25.v10(),
               var25.v11(),
               var25.v12(),
               var25.v13(),
               var25.v14(),
               var25.v15()
            }) {
               var2.writeFloat(var11);
            }

            var2.writeByte(var24.v3());

            for (float var36 : var24.v4().v1()) {
               var2.writeFloat(var36);
            }
         }

         var2.writeByte(var0.v8());

         for (int var26 = 0; var26 < var0.v8(); var26++) {
            cloudSupport45 var30 = var0.v3(var26);
            var2.writeUTF(var30.v1());
            var2.writeFloat(var30.v2());
            var2.writeByte(var30.v3().ordinal());
            var2.writeShort(var30.v4());

            for (int var33 = 0; var33 < var30.v4(); var33++) {
               cloudSupport46 var35 = var30.v2(var33);
               var2.writeShort(var35.v1());
               var2.writeByte(var35.v2().ordinal());
               var2.writeShort(var35.v3());

               for (int var37 = 0; var37 < var35.v3(); var37++) {
                  var2.writeFloat(var35.v1(var37));
                  var2.writeFloat(var35.v1(var37, 0));
                  var2.writeFloat(var35.v1(var37, 1));
                  var2.writeFloat(var35.v1(var37, 2));
                  var2.writeByte(var35.v2(var37).ordinal());
               }
            }
         }

         var2.writeByte(cloudSupport44.v3());

         for (int var27 = 0; var27 < cloudSupport44.v3(); var27++) {
            var2.writeByte(var0.v2(cloudSupport44.v1(var27)));
         }
      } catch (IOException var14) {
         throw new UncheckedIOException(var14);
      }

      return var1.toByteArray();
   }

   public static cloudSupport50 v1(byte[] var0) throws cloudSupport38 {
      if (var0.length > 8388608) {
         throw new cloudSupport38("asset is " + var0.length + " bytes, over 8388608");
      } else {
         try {
            cloudSupport50 var73;
            try (DataInputStream var1 = new DataInputStream(new ByteArrayInputStream(var0))) {
               if (var1.readInt() != 1398360899) {
                  throw new cloudSupport38("not a cosmetic");
               }

               int var2 = var1.readUnsignedShort();
               if (var2 != 1) {
                  throw new cloudSupport38("format version " + var2 + ", this client reads 1");
               }

               String var3 = var1.readUTF();
               String var4 = var1.readUTF();
               cloudSupport49 var5 = cloudSupport49.v1(var4);
               if (var5 == null) {
                  throw new PNGNotSupport.Part1(var4);
               }

               int var6 = v1(var1.readUnsignedShort(), 128, "bones");
               String[] var7 = new String[var6];
               int[] var8 = new int[var6];
               cloudSupport51[] var9 = new cloudSupport51[var6];
               float[] var10 = new float[var6 * 3];
               float[] var11 = new float[var6 * 3];

               for (int var12 = 0; var12 < var6; var12++) {
                  var7[var12] = var1.readUTF();
                  var8[var12] = var1.readShort();
                  String var13 = var1.readUTF();
                  cloudSupport51 var14 = cloudSupport51.v1(var13);
                  if (var14 == null) {
                     throw new cloudSupport38("unknown anchor " + var13);
                  }

                  var9[var12] = var14;

                  for (int var15 = 0; var15 < 3; var15++) {
                     var10[var12 * 3 + var15] = var1.readFloat();
                  }

                  for (int var44 = 0; var44 < 3; var44++) {
                     var11[var12 * 3 + var44] = var1.readFloat();
                  }
               }

               uiSupport255 var40 = new uiSupport255(var7, var8, var9, var10, var11);
               InternalSupport62[] var41 = new InternalSupport62[v1(var1.readUnsignedByte(), 16, "textures")];

               for (int var42 = 0; var42 < var41.length; var42++) {
                  int var45 = var1.readUnsignedShort();
                  int var16 = var1.readUnsignedShort();
                  int var17 = var1.readUnsignedShort();
                  float var18 = var1.readFloat();
                  boolean var19 = var1.readBoolean();
                  byte[] var20 = new byte[v1(var1.readInt(), var1.available(), "texture bytes")];
                  var1.readFully(var20);
                  int[] var21 = cloudSupport39.v1(var20);
                  if (var21[0] != var45 || var21[1] != var16) {
                     throw new cloudSupport38("texture " + var42 + " is a " + var21[0] + "x" + var21[1] + " PNG, not the declared " + var45 + "x" + var16);
                  }

                  var41[var42] = new InternalSupport62(var45, var16, var20, var17, var18, var19);
               }

               uiRecord12[] var43 = new uiRecord12[v1(var1.readUnsignedByte(), 64, "materials")];

               for (int var46 = 0; var46 < var43.length; var46++) {
                  byte var48 = var1.readByte();
                  byte var50 = var1.readByte();
                  String var53 = var1.readUTF();
                  cloudSupport36 var55 = cloudSupport36.v1(var53);
                  if (var55 == null) {
                     throw new cloudSupport38("unknown surface " + var53);
                  }

                  int var58 = var1.readInt();
                  uiRecord13 var60 = null;
                  if (var1.readBoolean()) {
                     int var22 = var1.readUnsignedByte();
                     cloudSupport37 var23 = cloudSupport37.v1(var22);
                     int var24 = var1.readInt();
                     int var25 = var1.readInt();
                     float var26 = var1.readFloat();
                     float var27 = var1.readFloat();
                     float var28 = var1.readFloat();
                     var60 = new uiRecord13(var23 == null ? cloudSupport37.GLOW : var23, var24, var25, var26, var27, var28);
                  }

                  var43[var46] = new uiRecord12(var48, var55, var60, var58, var50);
               }

               int var47 = v1(var1.readInt(), 65536, "vertices");
               float[] var49 = new float[v1(var47 * 8, var1.available() / 4, "vertex floats")];

               for (int var51 = 0; var51 < var49.length; var51++) {
                  var49[var51] = var1.readFloat();
               }

               int var52 = v1(var1.readUnsignedShort(), 4096, "parts");
               int[] var54 = new int[var52 * 4];

               for (int var56 = 0; var56 < var52; var56++) {
                  var54[var56 * 4] = var1.readUnsignedShort();
                  var54[var56 * 4 + 1] = var1.readUnsignedByte();
                  var54[var56 * 4 + 2] = var1.readInt();
                  var54[var56 * 4 + 3] = var1.readInt();
               }

               uiSupport256 var57 = new uiSupport256(var49, var54);
               cloudSupport50.Part1 var59 = null;
               if (var1.readBoolean()) {
                  int var61 = var1.readUnsignedByte();
                  int var63 = var1.readUnsignedByte();
                  float[] var66 = new float[12];

                  for (int var69 = 0; var69 < var66.length; var69++) {
                     var66[var69] = var1.readFloat();
                  }

                  cloudRecord6 var70 = new cloudRecord6(
                     var61, var63, var66[0], var66[1], var66[2], var66[3], var66[4], var66[5], var66[6], var66[7], var66[8], var66[9], var66[10], var66[11]
                  );
                  int var74 = var1.readUnsignedByte();
                  float[] var77 = new float[24];

                  for (int var79 = 0; var79 < var77.length; var79++) {
                     var77[var79] = var1.readFloat();
                  }

                  var59 = new cloudSupport50.Part1(var70, var74, cloudSupport43.v1(var77));
               }

               cloudSupport45[] var62 = new cloudSupport45[v1(var1.readUnsignedByte(), 64, "clips")];

               for (int var64 = 0; var64 < var62.length; var64++) {
                  String var67 = var1.readUTF();
                  float var71 = var1.readFloat();
                  cloudSupport45.Part1 var75 = cloudSupport45.v1(var1.readUnsignedByte());
                  cloudSupport46[] var78 = new cloudSupport46[v1(var1.readUnsignedShort(), 1024, "channels")];

                  for (int var80 = 0; var80 < var78.length; var80++) {
                     int var81 = var1.readUnsignedShort();
                     int var29 = var1.readUnsignedByte();
                     if (var29 >= cloudSupport46.Part1.values().length) {
                        throw new cloudSupport38("channel kind " + var29);
                     }

                     int var30 = v1(var1.readUnsignedShort(), 4096, "keys");
                     float[] var31 = new float[var30];
                     float[] var32 = new float[var30 * 3];
                     byte[] var33 = new byte[var30];

                     for (int var34 = 0; var34 < var30; var34++) {
                        var31[var34] = var1.readFloat();
                        var32[var34 * 3] = var1.readFloat();
                        var32[var34 * 3 + 1] = var1.readFloat();
                        var32[var34 * 3 + 2] = var1.readFloat();
                        var33[var34] = var1.readByte();
                     }

                     var78[var80] = new cloudSupport46(var81, cloudSupport46.Part1.values()[var29], var31, var32, var33);
                  }

                  var62[var64] = new cloudSupport45(var67, var71, var75, var78);
               }

               int var65 = var1.readUnsignedByte();
               int[] var68 = new int[cloudSupport44.v3()];
               Arrays.fill(var68, -1);

               for (int var72 = 0; var72 < var65; var72++) {
                  byte var76 = var1.readByte();
                  if (var72 < var68.length) {
                     var68[var72] = var76;
                  }
               }

               if (var1.available() != 0) {
                  throw new cloudSupport38(var1.available() + " trailing bytes");
               }

               var73 = new cloudSupport50(var3, var5, var40, var57, var43, var41, var59, var62, var68);
            }

            return var73;
         } catch (cloudSupport38 var37) {
            throw var37;
         } catch (EOFException var38) {
            throw new cloudSupport38("truncated", var38);
         } catch (RuntimeException | IOException var39) {
            throw new cloudSupport38(var39.getMessage() == null ? var39.toString() : var39.getMessage(), var39);
         }
      }
   }

   private static int v1(int var0, int var1, String var2) throws cloudSupport38 {
      if (var0 >= 0 && var0 <= var1) {
         return var0;
      } else {
         throw new cloudSupport38(var0 + " " + var2 + " is outside 0.." + var1);
      }
   }

   public static String v2(byte[] var0) {
      try {
         byte[] var1 = MessageDigest.getInstance("SHA-256").digest(var0);
         StringBuilder var2 = new StringBuilder(64);

         for (byte var6 : var1) {
            var2.append(Character.forDigit(var6 >> 4 & 15, 16)).append(Character.forDigit(var6 & 15, 16));
         }

         return var2.toString();
      } catch (NoSuchAlgorithmException var7) {
         throw new IllegalStateException("SHA-256 is part of every JRE", var7);
      }
   }

   public static final class Part1 extends cloudSupport38 {
      private static final long v1 = 1L;

      public Part1(String var1) {
         super("unknown slot " + var1);
      }
   }
}
