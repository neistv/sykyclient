package cc.syky.cloud;

public record cloudRecord11(String targetId, int key, int modifiers, cloudSupport96 mode) {
   public cloudRecord11(String targetId, int key, int modifiers, cloudSupport96 mode) {
      if (targetId != null && !targetId.isBlank()) {
         if (mode == null) {
            mode = cloudSupport96.TOGGLE;
         }

         modifiers &= 15;
         this.targetId = targetId;
         this.key = key;
         this.modifiers = modifiers;
         this.mode = mode;
      } else {
         throw new IllegalArgumentException("targetId must not be blank");
      }
   }

   public cloudRecord10 v1() {
      return new cloudRecord10(this.key, this.modifiers);
   }

   public String v2() {
      return this.targetId;
   }

   public int v3() {
      return this.key;
   }

   public int v4() {
      return this.modifiers;
   }

   public cloudSupport96 v5() {
      return this.mode;
   }
}
