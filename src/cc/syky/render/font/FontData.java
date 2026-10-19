package cc.syky.render.font;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public final class FontData {
   @Nullable
   public FontData.AtlasData atlas;
   @Nullable
   public FontData.MetricsData metrics;
   @Nullable
   public List<FontData.GlyphData> glyphs;
   @SerializedName("kerning")
   @Nullable
   public List<FontData.KerningData> kernings;

   public FontData() {
   }

   public static final class AtlasData {
      @Nullable
      public String type;
      @SerializedName("distanceRange")
      public float range;
      public float size;
      public float width;
      public float height;
      @Nullable
      public String yOrigin;

      public AtlasData() {
      }
   }

   public static final class BoundsData {
      public float left;
      public float bottom;
      public float right;
      public float top;

      public BoundsData() {
      }
   }

   public static final class GlyphData {
      public int unicode;
      public float advance;
      @Nullable
      public FontData.BoundsData planeBounds;
      @Nullable
      public FontData.BoundsData atlasBounds;

      public GlyphData() {
      }
   }

   public static final class KerningData {
      @SerializedName("unicode1")
      public int leftChar;
      @SerializedName("unicode2")
      public int rightChar;
      public float advance;

      public KerningData() {
      }
   }

   public static final class MetricsData {
      public float emSize;
      public float lineHeight;
      public float ascender;
      public float descender;

      public MetricsData() {
      }
   }
}
