package io.github.jason13official.many_translations;

import net.minecraft.resources.ResourceLocation;

public class ManyTranslations {

  public static void init() {
  }

  public static ResourceLocation identifier(final String path) {
    return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
  }
}