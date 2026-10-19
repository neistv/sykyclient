package cc.syky.ui;

import cc.syky.hud.hudSupport60;
import cc.syky.hud.hudSupport62;
import net.minecraft.class_1041;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_313;
import net.minecraft.class_319;

public final class SignInSupport {
   public static final float v1 = 984.0F;
   public static final float v2 = 624.0F;
   private static final float v411 = 1.7777778F;
   private static final float v208 = 0.5F;
   private static final float v452 = 0.85F;
   private static int v326 = Integer.MIN_VALUE;
   private static int v415;
   private static int v271;
   private static int v405;
   private static float v323;
   public static final int v3 = uiSupport47.SURFACE.v1();
   public static final float v4 = 28.0F;
   public static final int v5 = 18;
   public static final int v6 = 230;
   public static final float v7 = 231.0F;
   public static final float v8 = 1.0F;
   public static final float v9 = 16.0F;
   public static final float v10 = 199.0F;
   public static final float v11 = 67.0F;
   public static final float v12 = 16.0F;
   public static final float v13 = 38.0F;
   public static final float v14 = 96.5F;
   public static final float v15 = 14.5F;
   public static final float v16 = 20.0F;
   public static final float v18 = 12.0F;
   public static final float v19 = 28.0F;
   public static final float v17 = 82.0F;
   public static final float v20 = 109.0F;
   public static final float v21 = 42.0F;
   public static final float v22 = 48.0F;
   public static final float v24 = 12.0F;
   public static final float v25 = 44.0F;
   public static final float v26 = 12.0F;
   public static final float v27 = 18.0F;
   public static final float v28 = 0.7F;
   public static final float v29 = 90.0F;
   public static final float v30 = 150.0F;
   public static final float v32 = 16.0F;
   public static final float v23 = 20.0F;
   public static final float v33 = 12.0F;
   public static final float v31 = 18.0F;
   public static final float v34 = 75.0F;
   public static final String v36 = "Alpha";
   public static final String v38 = " • ";
   public static final String v42 = "Sign in";
   public static final float v43 = 169.0F;
   public static final float v37 = 224.0F;
   public static final float v48 = 29.0F;
   public static final float v40 = 24.0F;
   public static final float v44 = 285.0F;
   public static final float v47 = 352.0F;
   public static final float v49 = 53.0F;
   public static final float v46 = 16.0F;
   public static final float v51 = 18.0F;
   public static final float v50 = 18.0F;
   public static final float v60 = 82.0F;
   public static final float v59 = 178.0F;
   public static final float v53 = 12.0F;
   public static final float v63 = 108.0F;
   public static final float v64 = 44.0F;
   public static final float v61 = 220.0F;
   public static final float v66 = 6.0F;
   public static final float v68 = 164.0F;
   public static final float v52 = 263.0F;
   public static final float v75 = 43.0F;
   public static final float v73 = 36.0F;
   public static final float v74 = 307.0F;
   public static final float v72 = 21.0F;
   public static final float v80 = 18.0F;
   public static final float v84 = 272.0F;
   public static final float v94 = 39.0F;
   public static final float v82 = 20.0F;
   public static final float v99 = 12.0F;
   public static final float v120 = 16.0F;
   public static final float v88 = 352.0F;
   public static final float v103 = 21.0F;
   public static final float v101 = 18.0F;
   public static final float v96 = 28.0F;
   public static final float v105 = 378.0F;
   public static final float v87 = 2.0F;
   public static final float v85 = 406.0F;
   public static final float v119 = 32.0F;
   public static final float v98 = 12.0F;
   public static final float v124 = 16.0F;
   public static final float v117 = 22.0F;
   private static final float v396 = 0.08510638F;
   public static final float v45 = 232.0F;
   public static final float v104 = 16.0F;
   public static final float v125 = 352.0F;
   public static final float v141 = 16.0F;
   public static final float v145 = 16.0F;
   public static final float v162 = 38.0F;
   public static final float v107 = 12.0F;
   public static final float v118 = 54.0F;
   public static final int v159 = 56;
   public static final float v176 = 6.0F;
   public static final float v116 = 26.0F;
   public static final float v147 = 16.0F;
   public static final float v93 = 75.0F;
   public static final float v157 = 37.5F;
   public static final float v166 = 150.0F;
   public static final float v121 = 106.0F;
   public static final float v137 = 262.0F;
   public static final float v187 = 368.0F;
   public static final float v138 = 15.0F;
   public static final float v106 = 38.0F;
   public static final float v100 = 16.0F;
   public static final float v191 = 20.0F;
   public static final float v112 = 15.0F;
   public static final float v216 = 16.0F;
   public static final float v41 = 14.0F;
   public static final float v190 = 13.0F;
   public static final float v70 = 7.0F;
   public static final float v133 = 16.0F;
   public static final float v160 = 15.0F;
   public static final float v172 = 18.0F;
   public static final float v249 = 0.0F;
   public static final float v164 = 17.0F;
   public static final float v239 = 17.0F;
   public static final float v198 = 16.0F;
   public static final float v76 = 14.0F;
   public static final float v185 = 8.0F;
   public static final float v220 = 1.0F;
   public static final float v223 = 11.0F;
   public static final float v169 = 34.0F;
   public static final float v153 = 10.0F;
   public static final float v143 = 16.0F;
   public static final float v188 = 1.0F;
   public static final long v228 = 1060L;
   public static final float v193 = 82.0F;
   public static final float v175 = 16.0F;
   public static final float v241 = 0.45F;
   public static final float v217 = 16.0F;
   public static final float v252 = 19.1F;
   public static final float v281 = 8.0F;
   public static final float v254 = 16.0F;
   public static final float v186 = 16.0F;
   public static final float v199 = 18.0F;
   public static final float v332 = 47.0F;
   public static final float v251 = 41.0F;
   public static final float v203 = 12.0F;
   public static final float v165 = 3.0F;
   public static final float v270 = 90.0F;
   public static final float v92 = 10.0F;
   public static final float v237 = 13.0F;
   public static final float v146 = 18.0F;
   public static final float v245 = 20.0F;
   public static final float v173 = 8.0F;
   public static final float v242 = 0.5F;
   public static final int v234 = 31;
   public static final float v110 = 10.0F;
   public static final float v95 = 16.0F;
   public static final float v285 = 80.0F;
   public static final float v229 = 0.25F;
   public static final float v231 = 0.85F;
   public static final float v238 = 55.0F;
   public static final float v291 = 24.0F;
   public static final float v154 = 6.0F;
   public static final float v276 = 5.0F;
   public static final float v371 = 3.5F;
   public static final float v77 = 14.0F;
   public static final int v247 = -1711276033;
   public static final int v58 = -419430401;
   public static final int v314 = -1;
   public static final float v126 = 45.0F;
   public static final float v214 = 30.0F;
   public static final float v320 = 10.0F;
   public static final float v204 = 14.0F;
   public static final float v140 = 12.0F;
   public static final float v206 = 8.0F;
   public static final float v227 = 14.0F;
   public static final float v155 = 35.0F;
   public static final float v294 = 82.0F;
   public static final float v289 = 9.0F;
   public static final float v108 = 0.4F;
   public static final float v230 = 35.0F;
   public static final float v272 = 16.0F;
   public static final float v109 = 0.4F;
   public static final float v79 = 54.0F;
   public static final float v376 = 16.0F;
   public static final float v90 = 0.4F;
   public static final float v337 = 18.0F;
   public static final float v370 = 23.0F;
   public static final float v335 = 5.0F;
   public static final float v282 = 5.0F;
   public static final float v284 = 4.0F;
   public static final float v130 = 12.0F;
   public static final float v161 = 30.0F;
   public static final float v378 = 39.0F;
   public static final float v338 = 21.0F;
   public static final float v339 = 10.5F;
   public static final float v331 = 17.0F;
   public static final float v353 = 2.0F;
   public static final int v310 = 31;
   public static final float v312 = 0.25F;
   public static final float v345 = 5.0F;
   public static final float v313 = 3.0F;
   public static final float v406 = 2.0F;
   public static final float v315 = 39.0F;
   public static final float v290 = 21.0F;
   public static final float v197 = 10.5F;
   public static final float v306 = 17.0F;
   public static final float v360 = 17.0F;
   public static final float v394 = 8.5F;
   public static final float v368 = 2.0F;
   public static final float v383 = 21.0F;
   public static final float v402 = 2.0F;
   public static final float v180 = 11.0F;
   public static final float v152 = 90.0F;
   public static final float v183 = 240.0F;
   public static final float v35 = 420.0F;
   public static final float v142 = 16.0F;
   public static final float v171 = 134.0F;
   public static final float v342 = 14.0F;
   public static final float v283 = 40.0F;
   public static final float v340 = 350.0F;
   public static final float v86 = 1000.0F;
   public static final float v398 = 160.0F;
   public static final float v149 = 24.0F;
   public static final float v248 = 52.0F;
   public static final float v225 = 18.0F;
   public static final float v366 = 20.0F;
   public static final float v380 = 16.0F;
   public static final float v158 = 50.0F;
   public static final float v292 = 18.0F;
   public static final float v265 = 13.0F;
   public static final float v167 = 0.75F;
   public static final int v192 = v1(128);
   public static final int v258 = 318767103;
   public static final float v135 = 1.0F;
   public static final float v236 = 1.0F;
   public static final float v288 = 6.0F;
   public static final float v274 = 30.0F;
   public static final float v257 = 18.0F;
   public static final float v277 = 14.0F;
   public static final float v404 = 10.0F;
   public static final float v408 = 0.0F;
   public static final float v134 = 12.0F;
   public static final float v222 = 10.0F;
   public static final float v346 = 136.0F;
   public static final float v148 = 5.0F;
   public static final float v367 = 2.5F;
   public static final float v69 = 136.0F;
   public static final int v246 = 872415231;
   public static final float v377 = 18.0F;
   public static final float v419 = 13.0F;
   public static final float v443 = 6.5F;
   public static final float v441 = 5.0F;
   public static final float v196 = 3.0F;
   public static final float v372 = 2.0F;
   public static final float v263 = 16.0F;
   public static final float v244 = 71.0F;
   public static final float v256 = 1.2727273F;
   public static final float v156 = 0.7F;
   public static final float v381 = 0.55F;
   public static final float v385 = 72.0F;
   public static final float v364 = 82.0F;
   public static final float v316 = 0.579F;
   public static final int v233 = 419430399;
   public static final float v275 = 18.0F;
   public static final float v361 = 24.0F;
   public static final float v168 = 7.0F;
   public static final int v259 = 452984831;
   public static final float v286 = 15.0F;
   public static final float v253 = 3.0F;
   public static final float v181 = 28.0F;
   public static final float v209 = 4.0F;
   public static final float v536 = 6.0F;
   public static final int v350 = 1308622847;
   public static final float v177 = 18.0F;
   public static final float v151 = 45.0F;
   public static final float v355 = 12.0F;
   public static final float v397 = 400.0F;
   public static final float v136 = 3.0F;
   public static final float v507 = 240.0F;
   public static final float v439 = 385.0F;
   public static final float v182 = 16.0F;
   public static final float v280 = 16.0F;
   public static final float v336 = 19.0F;
   public static final float v273 = 16.0F;
   public static final float v279 = 19.0F;
   public static final float v299 = 3.9765625F;
   public static final float v307 = 8.0F;
   public static final float v262 = 16.0F;
   public static final float v321 = 15.2265625F;
   public static final float v132 = 24.0F;

   private SignInSupport() {
   }

   public static float v1(float var0, float var1) {
      class_1041 var2 = class_310.method_1551().method_22683();
      if (var2.method_4499() != v326 || var2.method_4477() != v415 || var2.method_4489() != v271 || var2.method_4506() != v405) {
         v326 = var2.method_4499();
         v415 = var2.method_4477();
         v271 = var2.method_4489();
         v405 = var2.method_4506();
         class_313 var3 = var2.method_20831();
         class_319 var4 = var3 == null ? null : var3.method_1617();
         v323 = var4 == null ? 0.0F : Math.min((float)var4.method_1668(), var4.method_1669() * 1.7777778F);
      }

      int var5 = var2.method_4495();
      return v323 > 0.0F && var5 > 0 ? v323 / var5 : Math.min(var0, var1 * 1.7777778F);
   }

   public static float v1(float var0, float var1, float var2, float var3, float var4) {
      return Math.min(var0, Math.min(var2, var3 * var1) * var4);
   }

   public static float v2(float var0, float var1) {
      float var2 = Math.min(v1(var0, var1) * 0.5F, 984.0F) * hudSupport62.v1();
      return v1(var2, 1.5769231F, var0, var1, 0.85F);
   }

   public static int v1(int var0) {
      return var0 << 24 | v3;
   }

   public static int v1() {
      return uiSupport49.v2(uiSupport47.PANEL, 230);
   }

   public static int v2() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v3() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v4() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT);
   }

   public static int v5() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT, 26);
   }

   public static int v6() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT, 38);
   }

   public static int v7() {
      return uiSupport49.v2(uiSupport47.EDGE, 26);
   }

   public static int v8() {
      return uiSupport49.v2(uiSupport47.EDGE, 21);
   }

   public static int v9() {
      return uiSupport49.v2(uiSupport47.ACCENT_TEXT);
   }

   public static int v10() {
      return uiSupport49.v2(uiSupport47.ACCENT_TEXT);
   }

   public static int v11() {
      return uiSupport49.v2(uiSupport47.NAV_INK);
   }

   public static int v12() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v13() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT);
   }

   public static int v14() {
      return uiSupport49.v2(uiSupport47.NAV_INK);
   }

   public static int v15() {
      return uiSupport49.v2(uiSupport47.NAV_INK, 128);
   }

   public static int v16() {
      return uiSupport49.v2(uiSupport47.ACCENT_TEXT);
   }

   public static int v18() {
      return uiSupport49.v2(uiSupport47.ACCENT_TEXT, 128);
   }

   public static int v19() {
      return uiSupport49.v2(uiSupport47.TEXT_BRIGHT);
   }

   public static int v17() {
      return uiSupport49.v2(uiSupport47.NAV_INK);
   }

   public static int v20() {
      return uiSupport49.v2(uiSupport47.PANEL);
   }

   public static int v21() {
      return uiSupport49.v2(uiSupport47.NAV_INK);
   }

   public static int v22() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v24() {
      return uiSupport49.v2(uiSupport47.TEXT, 218);
   }

   public static int v25() {
      return uiSupport155.v1(v26(), uiSupport49.v2(uiSupport47.EDGE, 56), 0.08510638F);
   }

   public static int v26() {
      return uiSupport49.v2(uiSupport47.CARD, 56);
   }

   public static int v27() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v28() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v29() {
      return uiSupport49.v2(uiSupport47.EDGE, 9);
   }

   public static int v30() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v32() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v23() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM);
   }

   public static int v33() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v31() {
      return uiSupport49.v2(uiSupport47.EDGE, 64);
   }

   public static int v34() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM);
   }

   public static int v36() {
      return uiSupport49.v2(uiSupport47.CARD, 56);
   }

   public static int v38() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v42() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v43() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v37() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v48() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v40() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM);
   }

   public static int v44() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM);
   }

   public static int v47() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v49() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM);
   }

   public static int v3(float var0, float var1) {
      int var2 = uiSupport155.v1(v49(), v47(), var0);
      return uiSupport155.v1(var2, Math.min(255, uiSupport155.v1(var2) + Math.round(31.0F * var1)));
   }

   public static int v46() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v51() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v50() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v60() {
      return uiSupport49.v2(uiSupport47.EDGE);
   }

   public static int v59() {
      return uiSupport49.v2(uiSupport47.ACCENT);
   }

   public static int v53() {
      return uiSupport49.v2(uiSupport47.EDGE, 31);
   }

   public static int v63() {
      return uiSupport49.v2(uiSupport47.CONTROL_INK_ON, 230);
   }

   public static int v64() {
      return uiSupport49.v2(uiSupport47.CONTROL_INK);
   }

   public static int v61() {
      return uiSupport49.v2(uiSupport47.EDGE);
   }

   public static int v66() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v68() {
      return uiSupport49.v2(uiSupport47.EDGE);
   }

   public static int v52() {
      return uiSupport49.v2(uiSupport47.SHADOW, 128);
   }

   public static int v75() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v73() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT);
   }

   public static int v74() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT);
   }

   public static int v72() {
      return uiSupport49.v2(uiSupport47.EDGE, 51);
   }

   public static float v1(float var0) {
      return hudSupport60.v1(var0);
   }

   public static int v80() {
      return uiSupport49.v2(uiSupport47.PANEL, 179);
   }

   public static int v84() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v94() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v82() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT);
   }

   public static int v99() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v120() {
      return v30();
   }

   public static int v88() {
      return uiSupport49.v2(uiSupport47.EDGE);
   }

   public static int v103() {
      return uiSupport49.v2(uiSupport47.EDGE, 10);
   }

   public static int v101() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static int v96() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT, 230);
   }

   public static int v105() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v87() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT);
   }

   public static int v85() {
      return uiSupport49.v2(uiSupport47.ACCENT_TEXT);
   }

   public static int v119() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM);
   }

   public static int v98() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT, 38);
   }

   public static int v124() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v117() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v45() {
      return uiSupport49.v2(uiSupport47.EDGE, 26);
   }

   public static int v104() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT, 38);
   }

   public static int v125() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT, 18);
   }

   public static int v141() {
      return uiSupport49.v2(uiSupport47.EDGE, 26);
   }

   public static int v145() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }

   public static class_2960 v162() {
      return uiSupport143.v6;
   }

   private static float v5(float var0) {
      return 1.0F * var0 / uiSupport169.v2();
   }

   private static float v6(float var0) {
      return Math.max(1.0F, (float)Math.round(var0));
   }

   public static float v2(float var0) {
      return v6(v5(var0)) * uiSupport169.v2();
   }

   public static int v1(int var0, float var1) {
      float var2 = v5(var1);
      float var3 = var2 / v6(var2);
      return var3 >= 1.0F ? var0 : uiSupport155.v1(var0, var3);
   }

   public static float v4(float var0, float var1) {
      return uiSupport169.v1(var0 * var1);
   }

   public static uiRecord7 v3(float var0) {
      return uiRecord7.v1(var0 / 2.0F);
   }

   public static int v107() {
      return v44();
   }

   public static int v118() {
      return uiSupport49.v2(uiSupport47.ICON);
   }

   public static int v159() {
      return uiSupport49.v2(uiSupport47.ACCENT_SOFT);
   }

   public static int v176() {
      return uiSupport49.v2(uiSupport47.EDGE, 250);
   }

   public static int v116() {
      return uiSupport49.v2(uiSupport47.SHADOW, 255);
   }

   public static int v147() {
      return uiSupport49.v2(uiSupport47.EDGE, 250);
   }

   public static int v93() {
      return uiSupport49.v2(uiSupport47.EDGE, 61);
   }

   public static int v157() {
      return uiSupport155.v2(v159(), 0.579F);
   }

   public static int v166() {
      return uiSupport155.v2(v176(), 0.579F);
   }

   public static int v121() {
      return uiSupport155.v2(v107(), 0.579F);
   }

   public static int v137() {
      return uiSupport155.v2(v118(), 0.579F);
   }

   public static int v187() {
      return uiSupport155.v2(v147(), 0.579F);
   }

   public static int v138() {
      return v80();
   }

   public static int v106() {
      return v84();
   }

   public static int v100() {
      return uiSupport49.v2(uiSupport47.TEXT);
   }

   public static int v191() {
      return uiSupport49.v2(uiSupport47.TEXT_DIM);
   }

   public static float v4(float var0) {
      float var1 = class_310.method_1551().method_22683().method_4495();
      return var1 > 0.0F ? Math.min(var0, 12.0F / var1) : var0;
   }
}
