package cc.syky.cloud;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport53 {
   public static final int v1 = 256;
   public static final String v2 = "frame.total";
   public static final String v3 = "mainthread.drain";
   public static final String v4 = "hud.draw";
   public static final String v5 = "hud.pass.early";
   public static final String v6 = "hud.pass.default";
   public static final String v7 = "hud.pass.tail";
   public static final String v8 = "clickgui.render";
   public static final String v9 = "clickgui.prepare";
   public static final String v10 = "clickgui.tree";
   public static final String v11 = "clickgui.list";
   public static final String v12 = "commands.dispatch";
   public static final String v13 = "waypoints.areas";
   public static final String v14 = "waypoints.picker";
   public static final String v15 = "waypoints.markers";
   public static final String v16 = "settings.save";
   public static final String v18 = "settings.load";
   private final int v19;
   private final Map<String, cloudSupport52> v17 = new HashMap<>();
   private volatile boolean v20;

   public cloudSupport53() {
      this(256);
   }

   public cloudSupport53(int var1) {
      if (var1 <= 0) {
         throw new IllegalArgumentException("windowSize must be > 0, got " + var1);
      } else {
         this.v19 = var1;
      }
   }

   public int v1() {
      return this.v19;
   }

   public boolean v2() {
      return this.v20;
   }

   public void v1(boolean var1) {
      this.v20 = var1;
   }

   public void v1(@Nullable String var1, long var2) {
      cloudSupport52 var4 = this.v17.get(var1);
      if (var4 == null) {
         var4 = new cloudSupport52(this.v19);
         this.v17.put(var1, var4);
      }

      var4.v1(var2);
   }

   public cloudRecord7 v1(String var1) {
      cloudSupport52 var2 = this.v17.get(var1);
      return var2 == null ? cloudRecord7.EMPTY : var2.v1();
   }

   public Map<String, cloudRecord7> v3() {
      LinkedHashMap var1 = new LinkedHashMap();
      this.v17.entrySet().stream().sorted(Entry.comparingByKey()).forEach(var1x -> var1.put(var1x.getKey(), var1x.getValue().v1()));
      return Collections.unmodifiableMap(var1);
   }

   public void v4() {
      this.v17.values().forEach(cloudSupport52::v2);
   }

   public int v5() {
      return this.v17.size();
   }
}
