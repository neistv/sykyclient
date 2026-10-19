package cc.syky.mixin.chat;

import cc.syky.module.utilities.InfiniteChatHistory;
import cc.syky.module.utilities.utilitiesSupport10;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import net.minecraft.class_303;
import net.minecraft.class_310;
import net.minecraft.class_338;
import net.minecraft.class_3532;
import net.minecraft.class_303.class_7590;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_338.class})
public abstract class ChatHudHistoryMixin {
   @Unique
   private static final int VANILLA_LIMIT = 100;
   @Shadow
   @Final
   public class_310 field_2062;
   @Shadow
   @Final
   private List<class_303> field_2061;
   @Shadow
   @Final
   private List<class_7590> field_2064;
   @Shadow
   private int field_2066;
   @Unique
   @Nullable
   private ArrayDeque<class_7590> syky$refreshed;
   @Unique
   private int syky$refreshKeep;

   public ChatHudHistoryMixin() {
   }

   @Shadow
   public abstract boolean method_1819();

   @Shadow
   public abstract int method_1811();

   @Shadow
   public abstract double method_1814();

   @WrapOperation(
      method = {"method_58744"},
      at = {@At(
         value = "INVOKE",
         target = "Ljava/util/List;size()I"
      )}
   )
   private int syky$keepMessages(List<?> var1, Operation<Integer> var2) {
      int var3 = (Integer)var2.call(new Object[]{var1});
      int var4 = utilitiesSupport10.v1;
      return var4 > 0 && var1 == this.field_2061 && var3 <= var4 ? Math.min(var3, 100) : var3;
   }

   @WrapOperation(
      method = {"method_1815"},
      at = {@At(
         value = "INVOKE",
         target = "Ljava/util/List;size()I"
      )}
   )
   private int syky$keepLines(List<?> var1, Operation<Integer> var2) {
      int var3 = (Integer)var2.call(new Object[]{var1});
      int var4 = utilitiesSupport10.v1;
      return var4 > 0 && var1 == this.field_2064 && var3 <= var4 ? Math.min(var3, 100) : var3;
   }

   @WrapMethod(
      method = {"method_44813"}
   )
   private void syky$refreshAtTheBack(Operation<Void> var1) {
      int var2 = utilitiesSupport10.v1;
      if (var2 > 0 && this.syky$refreshed == null && (!this.method_1819() || this.field_2066 <= 0)) {
         ArrayDeque var3 = new ArrayDeque();
         this.syky$refreshed = var3;
         this.syky$refreshKeep = Math.max(var2, 100);
         utilitiesSupport10.v2++;

         try {
            var1.call(new Object[0]);
         } finally {
            this.syky$refreshed = null;
            this.field_2064.clear();
            Iterator var6 = var3.descendingIterator();

            while (var6.hasNext()) {
               this.field_2064.add((class_7590)var6.next());
            }
         }
      } else {
         var1.call(new Object[0]);
      }
   }

   @WrapOperation(
      method = {"method_1815"},
      at = {@At(
         value = "INVOKE",
         target = "Ljava/util/List;addFirst(Ljava/lang/Object;)V"
      )}
   )
   private void syky$lineAtTheBack(List<?> var1, Object var2, Operation<Void> var3) {
      ArrayDeque var4 = this.syky$refreshed;
      if (var4 != null && var1 == this.field_2064) {
         var4.addLast((class_7590)var2);
         if (var4.size() > this.syky$refreshKeep) {
            var4.pollFirst();
         }
      } else {
         var3.call(new Object[]{var1, var2});
      }
   }

   @WrapOperation(
      method = {"method_45587"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_338;method_44813()V"
      )}
   )
   private void syky$refreshOnlyDeleted(class_338 var1, Operation<Void> var2, @Local ListIterator<class_303> var3) {
      if (utilitiesSupport10.v1 > 0) {
         int var4 = var3.previousIndex();
         boolean var5 = uiSupport259.v1(
            "chat.history.delete",
            () -> InfiniteChatHistory.v1(
               this.field_2064, var4, this.field_2061.get(var4), this.field_2062.field_1772, class_3532.method_15357(this.method_1811() / this.method_1814())
            ),
            false
         );
         if (var5) {
            return;
         }
      }

      var2.call(new Object[]{var1});
   }
}
