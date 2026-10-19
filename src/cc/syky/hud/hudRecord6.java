package cc.syky.hud;

public record hudRecord6(String cpuName, int cpuLoadPct, int cpuTempC, String gpuName, int gpuLoadPct, int gpuTempC) {
   public static final int UNKNOWN = -1;
   public static final hudRecord6 EMPTY = new hudRecord6("", -1, -1, "", -1, -1);

   public boolean v1() {
      return this.cpuName != null && !this.cpuName.isEmpty();
   }

   public boolean v2() {
      return this.gpuName != null && !this.gpuName.isEmpty();
   }

   public boolean v3() {
      return this.cpuLoadPct >= 0;
   }

   public boolean v4() {
      return this.cpuTempC >= 0;
   }

   public boolean v5() {
      return this.gpuLoadPct >= 0;
   }

   public boolean v6() {
      return this.gpuTempC >= 0;
   }

   public String v7() {
      return this.cpuName;
   }

   public int v8() {
      return this.cpuLoadPct;
   }

   public int v9() {
      return this.cpuTempC;
   }

   public String v10() {
      return this.gpuName;
   }

   public int v11() {
      return this.gpuLoadPct;
   }

   public int v12() {
      return this.gpuTempC;
   }
}
