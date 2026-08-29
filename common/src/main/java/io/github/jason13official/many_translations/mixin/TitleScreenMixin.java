package io.github.jason13official.many_translations.mixin;

import io.github.jason13official.many_translations.Constants;
import io.github.jason13official.many_translations.platform.Services;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.resources.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

  @Inject(at = @At("HEAD"), method = "init()V")
  private void init(CallbackInfo info) {

    if (Services.PLATFORM.isDevelopmentEnvironment()) {
      // Constants.LOG.info("Translation Test:");
      Constants.LOG.info("\n  base={}\n  split={}\n  override={}",
          I18n.get("many_translations.developer_translation_in_normal"),
          I18n.get("many_translations.developer_translation_in_1"),
          I18n.get("many_translations.developer_override_test"));
    }
  }
}
